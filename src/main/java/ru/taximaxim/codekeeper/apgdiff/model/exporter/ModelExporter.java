package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.UnixPrintWriter;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTable;

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
	private StringBuilder writtenFiles = new StringBuilder(3000 * 260);
	
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
		} else if(!outDir.mkdirs()) {
				throw new DirectoryException("Could not create output directory:"
						+ outDir.getAbsolutePath());
		}
		
		// exporting schemas
		File schemasSharedDir = new File(outDir, "SCHEMA");
		if(!schemasSharedDir.mkdir()) {
			throw new DirectoryException("Could not create schemas directory:"
					+ schemasSharedDir.getAbsolutePath());
		}
		
		for(PgSchema schema : db.getSchemas()) {
			if(schema.getName().equals("public")) {
            	continue;
            }
			File schemaSQL = new File(schemasSharedDir, getExportedFilename(schema)+ ".sql");
			dumpSQL(schema.getCreationSQL(), schemaSQL);
		}
		
		// exporting extensions
		File extensionsDir = new File(outDir, "EXTENSION");
		if(!extensionsDir.mkdir()) {
			throw new DirectoryException("Could not create extensions directory:"
					+ extensionsDir.getAbsolutePath());
		}
		
		for(PgExtension ext : db.getExtensions()) {
			File extSQL = new File(extensionsDir, getExportedFilename(ext) + ".sql");
			dumpSQL(ext.getCreationSQL(), extSQL);
		}
		
		// exporting schemas contents
		for(PgSchema schema : db.getSchemas()) {
			File schemaDir = new File(schemasSharedDir, getExportedFilename(schema));
			if(!schemaDir.mkdir()) {
				throw new DirectoryException("Could not create schema directory:"
						+ schemaDir.getAbsolutePath());
			}
			
			processObjects(schema.getFunctions(), schemaDir, "FUNCTION");
			processObjects(schema.getSequences(), schemaDir, "SEQUENCE");
			processObjects(schema.getTables(), schemaDir, "TABLE");
			processObjects(schema.getViews(), schemaDir, "VIEW");
			
			// indexes, triggers, constraints are saved when tables are processed
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
			String filename = null;
            filename = getExportedFilename(obj) + ".sql";
			String sqlToDump = obj.getSearchPath() + "\n\n" + obj.getCreationSQL();
			
			// OWNED BY is exported as a separate statement for SEQUENCE
			if(obj instanceof PgSequence) {
				sqlToDump += "\n\n" + ((PgSequence)obj).getOwnedBySQL();
			}
			
			File objectSQL = new File(objectDir, filename);
			dumpSQL(sqlToDump, objectSQL);

            if(obj instanceof PgTable) {
                PgTable table = (PgTable) obj;
				// out them to their own directory in schema, not table directory
				processObjects(table.getConstraints(), parentOutDir, "CONSTRAINT");
				processObjects(table.getTriggers(), parentOutDir, "TRIGGER");
				processObjects(table.getIndexes(), parentOutDir, "INDEX");
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
		
		try(PrintWriter outFile = new UnixPrintWriter(file, sqlEncoding)) {
			outFile.println(sql);
		}
		
		writtenFiles.append(outPath.relativize(file.toPath())).append('\n');
	}
	
	/**
	 * @return a statement's exported file name
	 */
	public static String getExportedFilename(PgStatement statement) {
	    return statement.getBareName()
	            + "_" + PgDiffUtils.md5(statement.getName());
	}
}
