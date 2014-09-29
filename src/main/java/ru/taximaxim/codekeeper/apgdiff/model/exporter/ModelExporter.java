package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

import org.osgi.framework.Version;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgSchema;
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
     * Creates a new ModelExporter object with set {@link #outDir} and {@link #db}
     * and {@link #sqlEncoding}.
     * 
     * @param outDir outDir, directory should be empty or not exist
     * @param db database
     */
    public ModelExporter(final File outDir, final PgDatabase db,
            final String sqlEncoding) {
        this.outDir = outDir;
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
            
            for (ApgdiffConsts.WORK_DIR_NAMES subdirName : ApgdiffConsts.WORK_DIR_NAMES.values()) {
                if (new File(outDir, subdirName.toString()).exists()) {
                    throw new DirectoryException("Output directory already contains "
                            + subdirName + " directory.");
                }
            }
        } else if(!outDir.mkdirs()) {
                throw new DirectoryException("Could not create output directory:"
                        + outDir.getAbsolutePath());
        }
        
        // exporting schemas
        File schemasSharedDir = new File(outDir, 
                ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.toString());
        if(!schemasSharedDir.mkdir()) {
            throw new DirectoryException("Could not create schemas directory:"
                    + schemasSharedDir.getAbsolutePath());
        }
        
        for(PgSchema schema : db.getSchemas()) {
            File schemaSQL = new File(schemasSharedDir, getExportedFilename(schema)+ ".sql");
            dumpSQL(schema.getCreationSQL(), schemaSQL);
        }
        
        // exporting extensions
        File extensionsDir = new File(outDir, 
                ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.toString());
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
        writeProjVersion(new File(outDir.getPath(), 
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
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
            String sqlToDump = obj.getSearchPath() + "\n\n" + obj.getFullSQL();
            
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
            Log.log(Log.LOG_DEBUG, "Dumped SQL:\n" + file.getAbsolutePath());
            
            outFile.println(sql);
        }
    }
    
    /**
     * @return a statement's exported file name
     */
    public static String getExportedFilename(PgStatement statement) {
        return statement.getBareName().replaceAll("[\\s\\/:,.;*?\"<>|]", "")
                + "_" + PgDiffUtils.md5(statement.getName());
    }
    
    private void writeProjVersion(File f) throws IOException {
        Properties prop = new Properties();
        Version progVersion = Version.parseVersion(ApgdiffConsts.EXPORT_CURRENT_VERSION);
        if (f.exists()) {
            try(FileInputStream fStream = new FileInputStream(f)){
                prop.load(fStream);
            }
            String oldVersion = prop.getProperty(ApgdiffConsts.VERSION_PROP_NAME);
            if (oldVersion != null) {
                try {
                    if (progVersion.compareTo(Version.parseVersion(oldVersion)) == 0) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    Log.log(e);
                }
            }
        }
        prop = new Properties();
        prop.setProperty(ApgdiffConsts.VERSION_PROP_NAME, progVersion.toString());
        try(FileOutputStream fOutputStream = new FileOutputStream(f)){
            prop.store(fOutputStream , null);
        }
    }
}
