package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.util.List;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.NotDirectoryException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;

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
	 * Path for the outDir;
	 */
	private final Path outPath;
	
	/**
	 * Database to export.
	 */
	private final PgDatabase db;
	
	/**
	 * SQL files encoding.
	 */
	private final String sqlEncoding;
	
	/**
	 * List of written files' names.
	 */
	private StringBuilder writtenFiles = new StringBuilder(2000 * 260);
	
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
		this.outPath = this.outDir.toPath(); 
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
		
		// exporting schemas
		File schemasSharedDir = new File(outDir, "SCHEMA/");
		if(!schemasSharedDir.mkdir()) {
			throw new DirectoryException("Could not create schemas directory:"
					+ schemasSharedDir.getAbsolutePath());
		}
		
		for(PgSchema schema : db.getSchemas()) {
			if(schema.getName().equals("public")) {
            	continue;
            }
			File schemaSQL = new File(schemasSharedDir, schema.getName() + ".sql");
			dumpSQL(schema.getCreationSQL(), schemaSQL);
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
		
		// exporting schemas contents
		for(PgSchema schema : db.getSchemas()) {
			File schemaDir = new File(schemasSharedDir, schema.getName() + '/');
			if(!schemaDir.mkdir()) {
				throw new DirectoryException("Could not create schema directory:"
						+ schemaDir.getAbsolutePath());
			}
			
			processObjects(schema.getFunctions(), schemaDir, "FUNCTION/");
			processObjects(schema.getSequences(), schemaDir, "SEQUENCE/");
			processObjects(schema.getTables(), schemaDir, "TABLE/");
			processObjects(schema.getViews(), schemaDir, "VIEW/");
			
			// indexes are stored both in schemas and tables
			// this is sufficient
			processObjects(schema.getIndexes(), schemaDir, "INDEX/");
			
			// constraints are saved when tables are processed
			// primary keys in schema are redundant, they are a subset of constraints
			
			// triggers are saved when tables are processed
		}
		
		
		// dump the list of written files
		File listing = new File(outDir, "listing.lst");
		if(!listing.createNewFile()) {
			throw new FileException("Cannot create listing file:"
					+ listing.getAbsolutePath());
		}
		
		try(PrintWriter listingOut = new PrintWriter(listing, sqlEncoding)) {
			listingOut.println(writtenFiles.toString());
		}
	}
	
	/**
	 * Processes dumping of objects.
	 * 
	 * @param objects List of {@link #PgStatementWithSearchPath} to dump
	 * @param parentOutDir schema directory
	 * @param outDirName object type directory
	 * 
	 * @throws NotDirectoryException
	 * @throws FileAlreadyExistsException
	 * @throws DirectoryException
	 * @throws FileException
	 * @throws IOException
	 */
	private void processObjects(final List<? extends PgStatementWithSearchPath> objects,
			final File parentOutDir, final String outDirName) throws IOException {
		if(objects.isEmpty()) {
			return;
		}
		
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
			
			PgTable table = null;
			if(obj instanceof PgTable) {
				table = (PgTable) obj;
				
				if(table.getIgnored()) {
					continue;
				}
			}
			
			// this has to be after the ignore check but before
			// dependencies export for the listing to be in the right order
			// hence the (table != null) trick
			File objectSQL = new File(objectDir, filename);
			dumpSQL(obj.getSearchPath() + "\n\n" +
					obj.getCreationSQL(),
					objectSQL);
			
			if(table != null) {
				// out them to their own directory in schema, not table directory
				processObjects(table.getConstraints(), parentOutDir, "CONSTRAINT/");
				processObjects(table.getTriggers(), parentOutDir, "TRIGGER/");
			}
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
	private void dumpSQL(final String sql,
			final File file) throws IOException{
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
		
		writtenFiles.append(outPath.relativize(file.toPath())).append('\n');
	}
}
