package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.NotDirectoryException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgFunction;

/**
 * Exports PgDatabase model as a directory tree with
 * sql files with objects' code as leaves.
 * 
 * @author Alexander Levsha
 */
public class ModelExporter {
	
	/**
	 * Objects of the export directory;
	 */
	private final File outDir;
	
	/**
	 * Database to export.
	 */
	private final PgDatabase db;
	
	/**
	 * SQL files encoding.
	 */
	private final String sqlEncoding;
	
	/**
	 * List for written files' names.
	 */
	private List<String> writtenFiles = new ArrayList<>(2000);
	
	/**
	 * Creates a new ModelExporter object with set {@link #outDir} and {@link #db}
	 * and default output encoding (UTF-8).
	 * 
	 * @param outDir outDir, directory should be empty or not exist
	 * @param db database
	 */
	public ModelExporter(final String outDir, final PgDatabase db) {
		this(outDir, db, "UTF-8");
	}
	
	/**
	 * Creates a new ModelExporter object with set {@link #outDir} and {@link #db}
	 * and {@link #sqlEncoding}.
	 * 
	 * @param outDir outDir, directory should be empty or not exist
	 * @param db database
	 */
	public ModelExporter(final String outDir, final PgDatabase db,
			final String sqlEncoding) {
		this.outDir = new File(outDir);
		this.db = db;
		this.sqlEncoding = sqlEncoding;
	}
	
	/**
	 * Starts the {@link #db} export process.
	 * 
	 * @throws NotDirectoryException
	 * @throws DirectoryNotEmptyException
	 * @throws FileAlreadyExistsException
	 * @throws DirectoryException
	 * @throws FileException
	 * @throws IOException
	 */
	public void export() throws IOException {
		if(outDir.exists()) {
			if(!outDir.isDirectory()) {
				throw new NotDirectoryException(outDir.getAbsolutePath());
			}
			
			if(outDir.list().length != 0) {
				throw new DirectoryNotEmptyException(outDir.getAbsolutePath());
			}
		} else {
			if(!outDir.mkdirs()) {
				throw new DirectoryException("Could not create output directory:"
						+ outDir.getAbsolutePath());
			}
		}
		
		// exporting schemas and all they contain
		File schemasSharedDir = new File(outDir, "SCHEMA/");
		if(!schemasSharedDir.mkdir()) {
			throw new DirectoryException("Could not create schemas directory:"
					+ schemasSharedDir.getAbsolutePath());
		}
		
		for(PgSchema schema : db.getSchemas()) {
			File schemaSQL = new File(schemasSharedDir, schema.getName() + ".sql");
			dumpSQL(schema.getCreationSQL(), schemaSQL);
			
			File schemaDir = new File(schemasSharedDir, schema.getName() + '/');
			if(!schemaDir.mkdir()) {
				throw new DirectoryException("Could not create schema directory:"
						+ schemaDir.getAbsolutePath());
			}
			
			// stub for toArray type conversion
			PgStatementWithSearchPath[] sampleArray = new PgStatementWithSearchPath[0];
			// TODO List.toArray(new T[List.size()]) is significantly more efficient
			
			processObjects(schema.getFunctions().toArray(sampleArray), schemaDir, "FUNCTION/");
			processObjects(schema.getSequences().toArray(sampleArray), schemaDir, "SEQUENCE/");
			processObjects(schema.getTables().toArray(sampleArray), schemaDir, "TABLE/");
			processObjects(schema.getViews().toArray(sampleArray), schemaDir, "VIEW/");
			
			// indexes are stored both in schemas and tables
			// this is sufficient
			processObjects(schema.getIndexes().toArray(sampleArray), schemaDir, "INDEX/");
			
			// constraints are saved when tables are processed
			// primary keys in schema are redundant, they are a subset of constraints
			
			// triggers are saved when tables are processed
		}
		
		// exporting extensions
		File extensionsDir = new File(outDir, "EXTENSION/");
		if(!extensionsDir.mkdir()) {
			throw new DirectoryException("Could not create extensions directory:"
					+ extensionsDir.getAbsolutePath());
		}
		
		for(PgExtension ext : db.getExtensions()) {
			File extSQL = new File(extensionsDir, ext.getName() + ".sql");
			dumpSQL(ext.getCreationSQL(), extSQL);
		}
		
		
		// dump the list of written files
		File listing = new File(outDir, "listing.lst");
		if(!listing.createNewFile()) {
			throw new FileException("Cannot create listing file:"
					+ listing.getAbsolutePath());
		}
		
		try(PrintWriter listingOut = new PrintWriter(listing, sqlEncoding)) {
			for(String s : writtenFiles) {
				listingOut.println(s);
			}
		}
	}
	
	/**
	 * Processes dumping of objects.
	 * 
	 * @param objects array of {@link #PgStatementWithSearchPath} to dump
	 * @param parentOutDir schema directory
	 * @param outDirName object type directory
	 * 
	 * @throws NotDirectoryException
	 * @throws FileAlreadyExistsException
	 * @throws DirectoryException
	 * @throws FileException
	 * @throws IOException
	 */
	private void processObjects(final PgStatementWithSearchPath[] objects,
			final File parentOutDir, final String outDirName) throws IOException {
		File objectDir = new File(parentOutDir, outDirName);
		
		if(objectDir.exists()) {
			if(!objectDir.isDirectory()) {
				throw new NotDirectoryException(objectDir.getAbsolutePath());
			}
		} else {
			if(!objectDir.mkdir()) {
				throw new DirectoryException("Could not create objects directory:"
						+ objectDir.getAbsolutePath());
			}
		}
		
		for(PgStatementWithSearchPath obj : objects) {
			String filename;
			
			if(obj instanceof PgFunction) {
				filename = ((PgFunction) obj).getSignature();
			} else {
				filename = obj.getName();
			}
			filename += ".sql";
			
			if(obj instanceof PgTable) {
				PgTable table = (PgTable) obj;
				
				if(table.getIgnored()) {
					continue;
				}
				
				// TODO same optimization here
				PgStatementWithSearchPath[] sampleArray = new PgStatementWithSearchPath[0];
				
				// out them to schema's subdirectory, not table's subdirectory
				processObjects(table.getConstraints().toArray(sampleArray), parentOutDir, "CONSTRAINT/");
				processObjects(table.getTriggers().toArray(sampleArray), parentOutDir, "TRIGGER/");
			}

			File objectSQL = new File(objectDir, filename);
			dumpSQL(obj.getSearchPath() + "\n\n" +
					obj.getCreationSQL(),
					objectSQL);
		}
	}
	
	/**
	 * Writes out SQL code to file.
	 * 	
	 * @param sql SQL code
	 * @param file file
	 * 
	 * @throws FileAlreadyExistsException
	 * @throws FileException
	 */
	private void dumpSQL(final String sql, final File file
			) throws IOException{
		if(file.exists()) {
			throw new FileAlreadyExistsException(file.getAbsolutePath());
		}
		
		if(!file.createNewFile()) {
			throw new FileException("Cannot create sql output file:"
					+ file.getAbsolutePath());
		}
		
		try(PrintWriter outFile = new PrintWriter(file, sqlEncoding)) {
			outFile.println(sql);
		}
		
		writtenFiles.add(file.getAbsolutePath());
	}
}
