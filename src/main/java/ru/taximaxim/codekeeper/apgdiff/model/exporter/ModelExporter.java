package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

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
    private final PgDatabase newDb;
    
    /**
     * Old state db to fetch filenames from 
     */
    private final PgDatabase oldDb;
    
    /**
     * SQL files encoding.
     */
    private final String sqlEncoding;
    
    private List<TreeElement> changedObjects;
    
    /**
     * Creates a new ModelExporter object with set {@link #outDir} and {@link #newDb}
     * and {@link #sqlEncoding}.
     * 
     * @param outDir outDir, directory should be empty or not exist
     * @param newDb database
     */
    public ModelExporter(File outDir, PgDatabase db, String sqlEncoding) {
        this.outDir = outDir;
        this.newDb = db;
        this.sqlEncoding = sqlEncoding;
        this.oldDb = null;
    }
    
    public ModelExporter(File outDir, PgDatabase newDb, PgDatabase oldDb, List<TreeElement> changedObjects, String sqlEncoding){
        this.outDir = outDir;
        this.newDb = newDb;
        this.oldDb = oldDb;
        this.sqlEncoding = sqlEncoding;
        this.changedObjects = changedObjects;
    }
    
    /**
     * Deletes folder and its contents recursively. FOLLOWS SYMLINKS!
     */
    public void deleteRecursive(File f) throws IOException {
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                deleteRecursive(sub);
            }
        }
        Files.getFileAttributeView(f.toPath(), DosFileAttributeView.class).setReadOnly(false);
        Files.deleteIfExists(f.toPath());
    }
    
    public void exportPartial() throws IOException {
        if (oldDb == null){
            throw new IOException("Old database should not be null for partial export.");
        }
        if(!outDir.exists() || !outDir.isDirectory()) {
            throw new DirectoryException("Output directory does not exist: " + 
                    outDir.getAbsolutePath());
        }
        for (TreeElement el : changedObjects){
            switch(el.getSide()){
                case LEFT:
                    deleteObject(el);
                    break;
                case BOTH:
                    editObject(el);
                    break;
                case RIGHT:
                    createObject(el);
                    break;
            }
        }
    }
    
    private void deleteObject(TreeElement el) throws IOException{
        PgStatement st = el.getPgStatement(oldDb);
        if (st == null){
            st = el.getPgStatement(newDb);
        }
        TreeElement elParent = el.getParent().getParent();
        if (st instanceof PgSchema){
            // delete schema sql file
            Path toDelete = Paths.get(outDir.getCanonicalPath(), getRelativeFilePath(st, true).toString());
            Log.log(Log.LOG_INFO, "Deleting file " + toDelete.toString() + " for object " + el.getType() + " " + el.getName());
            Files.deleteIfExists(toDelete);
            
            // delete schema's folder content
            deleteRecursive(new File(outDir, getRelativeFilePath(st, false).toString()));
        }else if (st instanceof PgFunction){
            if (!(elParent.getSide() == DiffSide.LEFT && changedObjects.contains(elParent))){
                // delete function sql file
                Path toDelete = Paths.get(outDir.getCanonicalPath(), getRelativeFilePath(st, true).toString());
                Log.log(Log.LOG_INFO, "Deleting file " + toDelete.toString() + " for object " + el.getType() + " " + el.getName());
                Files.deleteIfExists(toDelete);
                
                PgSchema newParentSchema = newDb.getSchema(st.getParent().getName());
                List<PgFunction> funcsToExport = new ArrayList<PgFunction>();
                
                String targetFuncFileName = getExportedFilename(st);
                
                for (PgFunction func : newParentSchema.getFunctions()){
                    if (targetFuncFileName.equals(getExportedFilename(func))){
                        funcsToExport.add(func);
                    }
                }
                
                // dump rest of same-named functions back
                dumpFunctions(funcsToExport, new File (outDir, getRelativeFilePath(newParentSchema, false).toString()));
            }
        }else if ((st instanceof PgConstraint || st instanceof PgIndex || st instanceof PgTrigger)){
            if (!changedObjects.contains(elParent)){
                editObject(elParent);
            }
        }else{
            Path toDelete = Paths.get(outDir.getCanonicalPath(), getRelativeFilePath(st, true).toString());
            Log.log(Log.LOG_INFO, "Deleting file " + toDelete.toString() + " for object " + el.getType() + " " + el.getName());
            Files.deleteIfExists(toDelete);
        }
    }
    
    private void editObject(TreeElement el) throws IOException{
        PgStatement stInNew = el.getPgStatement(newDb);
        TreeElement elParent = el.getParent().getParent();

        if (stInNew instanceof PgSchema || stInNew instanceof PgExtension){
            // delete sql file
            Path toDelete = Paths.get(outDir.getCanonicalPath(), getRelativeFilePath(stInNew, true).toString());
            Log.log(Log.LOG_INFO, "Deleting file " + toDelete.toString() + " for object " + el.getType() + " " + el.getName());
            Files.deleteIfExists(toDelete);
            
            // dump new version
            dumpSQL(stInNew.getFullSQL(), new File(outDir, getRelativeFilePath(stInNew, true).toString()));
        }else if (stInNew instanceof PgFunction && (elParent.getSide() != DiffSide.LEFT || !changedObjects.contains(elParent))){
            deleteObject(el);
        }else if (stInNew instanceof PgConstraint || stInNew instanceof PgIndex || stInNew instanceof PgTrigger){
            if (!changedObjects.contains(elParent)){
                editObject(elParent);
            }
        }else if (stInNew instanceof PgTable){
            // remove old version
            deleteObject(el);

            PgTable newTable = (PgTable)el.getPgStatement(newDb);
            if (newTable == null){
                throw new IOException("New table should not be null since it is not in edit/delete lists");
            }
            
            File parentSchemaDir = new File (outDir, getRelativeFilePath(stInNew.getParent(), false).toString());
            dumpTables(Arrays.asList(newTable), parentSchemaDir);
        }else{
            // remove old version
            deleteObject(el);
            
            // dump new version
            dumpSQL(getDumpSql((PgStatementWithSearchPath)stInNew), new File(outDir, getRelativeFilePath(stInNew, true).toString()));
        }
    }
    
    private void createObject(TreeElement el) throws IOException{
        PgStatement stInNew = el.getPgStatement(newDb);
        TreeElement elParent = el.getParent().getParent();
        
        if (stInNew instanceof PgSchema || stInNew instanceof PgExtension){
            // export schema/extension sql file
            dumpSQL(stInNew.getFullSQL(), new File (outDir, getRelativeFilePath(stInNew, true).toString()));
            
            // do not create schema folder, as it will be created by dumpObject
        }else if (stInNew instanceof PgFunction){
            testParentSchema(elParent);
            
            editObject(el);
        }else if (stInNew instanceof PgConstraint || stInNew instanceof PgIndex || stInNew instanceof PgTrigger){
            if(!changedObjects.contains(elParent)){
                editObject(elParent);
            }
        }else if (stInNew instanceof PgSequence){
            testParentSchema(elParent);

            dumpObjects(new ArrayList<PgStatementWithSearchPath>(Arrays.asList((PgStatementWithSearchPath)stInNew)), 
                    new File(new File(outDir, "SCHEMA"), getExportedFilename(stInNew.getParent())), "SEQUENCE");
        }else if (stInNew instanceof PgView){
            testParentSchema(elParent);

            dumpObjects(new ArrayList<PgStatementWithSearchPath>(Arrays.asList((PgStatementWithSearchPath)stInNew)), 
                    new File(new File(outDir, "SCHEMA"), getExportedFilename(stInNew.getParent())), "VIEW");
        }else if (stInNew instanceof PgTable){
            testParentSchema(elParent);

            editObject(el);
        }else{
            throw new IOException("Wrong TreeItem type: " + el.getType());
        }
    }
    
    private boolean testParentSchema(TreeElement el) throws IOException{
        if (el.getSide() == DiffSide.RIGHT && !changedObjects.contains(el) 
                || el.getSide() == DiffSide.LEFT && changedObjects.contains(el)){
            throw new IOException("Parent schema either will not be created (NEW) "
                    + "or is deleted already along with its schema folder");
        }
        return true;
    }
    
    /**
     * Starts the {@link #newDb} export process.
     * 
     * @throws NotDirectoryException
     * @throws DirectoryNotEmptyException
     * @throws FileAlreadyExistsException
     * @throws DirectoryException
     * @throws FileException
     * @throws IOException
     */
    public void exportFull() throws IOException {
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
        
        for(PgSchema schema : newDb.getSchemas()) {
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
        
        for(PgExtension ext : newDb.getExtensions()) {
            File extSQL = new File(extensionsDir, getExportedFilenameSql(ext));
            dumpSQL(ext.getCreationSQL(), extSQL);
        }
        
        // exporting schemas contents
        for(PgSchema schema : newDb.getSchemas()) {
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
        mkdirObjects(null, parentDir.getAbsolutePath());
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
        mkdirObjects(null, parentDir.toString());
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
        mkdirObjects(null, parentOutDir.toString());
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
    
    public File getRelativeFilePath(PgStatement st, boolean addExtension){
        File file = new File("SCHEMA");
        
        PgStatement parentSt = st.getParent();
        String parentExportedFileName = parentSt == null ? 
                null : ModelExporter.getExportedFilename(parentSt);
                
        if (st instanceof PgExtension){
            file = new File("EXTENSION");
        }
        else if (st instanceof PgSequence){
            file = new File(new File(file, parentExportedFileName), "SEQUENCE");
        }
        else if (st instanceof PgView){
            file = new File(new File(file, parentExportedFileName), "VIEW");
        }
        else if (st instanceof PgTable){
            file = new File(new File(file, parentExportedFileName), "TABLE");
        }
        else if (st instanceof PgFunction){
            file = new File(new File(file, parentExportedFileName), "FUNCTION");
        }
        else if (st instanceof PgConstraint || st instanceof PgIndex || st instanceof PgTrigger){
            st = parentSt;
            String schemaName = ModelExporter.getExportedFilename(parentSt.getParent());
            file = new File(new File(file, schemaName), "TABLE");
        }
        
        return new File(file, ModelExporter.getExportedFilename(st) + (addExtension ? ".sql" : ""));
    }
}
