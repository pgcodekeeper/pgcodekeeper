package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NotDirectoryException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;

/**
 * Exports PgDatabase model as a directory tree with
 * sql files with objects' code as leaves.
 * 
 * @author Alexander Levsha
 */
public class ModelExporter {
    
    private static final Pattern INVALID_FILENAME = Pattern.compile("[\\/:*?\"<>|]");
    private static final String GROUP_DELIMITER = 
            "\n\n--------------------------------------------------------------------------------\n\n";
    
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
     * Creates a new ModelExporter object with set {@link #outDir} and {@link #db}
     * and {@link #sqlEncoding}.
     * 
     * @param outDir outDir, directory should be empty or not exist
     * @param db database
     */
    public ModelExporter(File outDir, PgDatabase db, String sqlEncoding) {
        this.outDir = outDir;
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
            File schemaSQL = new File(schemasSharedDir, getExportedFilenameSql(schema));
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
            File extSQL = new File(extensionsDir, getExportedFilenameSql(ext));
            dumpSQL(ext.getCreationSQL(), extSQL);
        }
        
        // exporting schemas contents
        for(PgSchema schema : db.getSchemas()) {
            File schemaDir = new File(schemasSharedDir, getExportedFilename(schema));
            if(!schemaDir.mkdir()) {
                throw new DirectoryException("Could not create schema directory:"
                        + schemaDir.getAbsolutePath());
            }
            dumpFunctions(schema.getFunctions(), schemaDir);
            dumpObjects(schema.getSequences(), schemaDir, "SEQUENCE");
            dumpTables(schema.getTables(), schemaDir);
            dumpObjects(schema.getViews(), schemaDir, "VIEW");

            // indexes, triggers, constraints are dumped when tables are processed
        }
        writeProjVersion(new File(outDir.getPath(), 
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }
    
    private void dumpFunctions(List<PgFunction> funcs, File parentDir) throws IOException {
        if (funcs.isEmpty()) {
            return;
        }
        File funcDir = mkdirObjects(parentDir, "FUNCTION");
        
        Map<String, StringBuilder> dumps = new HashMap<>(funcs.size());
        for(PgFunction f : funcs) {
            String fileName = getExportedFilenameSql(f);
            StringBuilder groupedDump = dumps.get(fileName);
            if (groupedDump == null) {
                groupedDump = new StringBuilder(getDumpSql(f));
                dumps.put(fileName, groupedDump);
            } else {
                groupedDump.append(GROUP_DELIMITER).append(getDumpSql(f));
            }
        }
        for (Entry<String, StringBuilder> dump : dumps.entrySet()) {
            dumpSQL(dump.getValue(), new File(funcDir, dump.getKey()));
        }
    }
    
    private void dumpTables(List<PgTable> tables, File parentDir) throws IOException {
        if (tables.isEmpty()) {
            return;
        }
        File tablesDir = mkdirObjects(parentDir, "TABLE");
        
        for (PgTable table : tables) {
            StringBuilder groupSql = new StringBuilder(getDumpSql(table));
            
            for (PgConstraint constr : table.getConstraints()) {
                groupSql.append(GROUP_DELIMITER).append(getDumpSql(constr));
            }
            
            for (PgIndex idx : table.getIndexes()) {
                groupSql.append(GROUP_DELIMITER).append(getDumpSql(idx));
            }
            
            for (PgTrigger trig : table.getTriggers()) {
                groupSql.append(GROUP_DELIMITER).append(getDumpSql(trig));
            }
            
            dumpSQL(groupSql, new File(tablesDir, getExportedFilenameSql(table)));
        }
    }

    private void dumpObjects(List<? extends PgStatementWithSearchPath> objects,
            File parentOutDir, String objectDirName) throws IOException {
        if (objects.isEmpty()) {
            return;
        }
        File objectDir = mkdirObjects(parentOutDir, objectDirName);
        
        for(PgStatementWithSearchPath obj : objects) {
            dumpSQL(getDumpSql(obj), new File(objectDir, getExportedFilenameSql(obj)));
        }
    }

    private File mkdirObjects(File parentOutDir, String outDirName)
            throws NotDirectoryException, DirectoryException {
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
        return objectDir;
    }
    
    private void dumpSQL(CharSequence sql, File file) throws IOException {
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
        String name = statement.getBareName();
        Matcher m = INVALID_FILENAME.matcher(name);
        if (m.find()) {
            boolean bareNameGrouped = statement instanceof PgFunction;
            String hash = PgDiffUtils.md5(
                    bareNameGrouped? statement.getBareName() : statement.getName())
                            // 2^40 variants, should be enough for this purpose
                            .substring(0, 10);
            
            return m.replaceAll("") + '_' + hash;
        } else {
            return name;
        }
    }
    
    private static String getExportedFilenameSql(PgStatement statement) {
        return getExportedFilename(statement) + ".sql";
    }
    
    private String getDumpSql(PgStatementWithSearchPath statement) {
        return statement.getSearchPath() + "\n\n" + statement.getFullSQL();
    }
    
    private void writeProjVersion(File f) throws IOException {
        try (PrintWriter pw = new UnixPrintWriter(f, "UTF-8")) {
            pw.println(ApgdiffConsts.VERSION_PROP_NAME + " = "
                    + ApgdiffConsts.EXPORT_CURRENT_VERSION);
        }
    }
}
