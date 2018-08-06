package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.regex.Matcher;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;


public abstract class AbstractModelExporter {

    protected static final int HASH_LENGTH = 10;
    protected static final String GROUP_DELIMITER =
            "\n\n--------------------------------------------------------------------------------\n\n";

    /**
     * Objects of the export directory;
     */
    protected final File outDir;

    /**
     * Database to export.
     */
    protected final PgDatabase newDb;

    /**
     * Old state db to fetch filenames from
     */
    protected final PgDatabase oldDb;

    /**
     * SQL files encoding.
     */
    protected final String sqlEncoding;

    /**
     * Objects that we need to operate on.<br>
     * Remove the entry from this list after it has been processed.
     */
    protected final LinkedList<TreeElement> changeList;

    /**
     * Creates a new ModelExporter object with set {@link #outDir} and {@link #newDb}
     * and {@link #sqlEncoding}.
     *
     * @param outDir outDir, directory should be empty or not exist
     * @param newDb database
     */
    public AbstractModelExporter(File outDir, PgDatabase db, String sqlEncoding) {
        this.outDir = outDir;
        this.newDb = db;
        this.oldDb = null;
        this.sqlEncoding = sqlEncoding;
        this.changeList = null;
    }

    public AbstractModelExporter(File outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding){
        this.outDir = outDir;
        this.newDb = newDb;
        this.oldDb = oldDb;
        this.sqlEncoding = sqlEncoding;
        this.changeList = new LinkedList<>(changedObjects);
    }

    /**
     * Starts the {@link #newDb} export process.
     */
    public abstract void exportFull() throws IOException;

    protected void dumpSQL(CharSequence sql, File file) throws IOException {
        Files.createDirectories(file.toPath().getParent());
        try (PrintWriter outFile = new UnixPrintWriter(Files.newOutputStream(file.toPath(),
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE), sqlEncoding)) {
            outFile.println(sql);
        }
    }

    protected String getDumpSql(PgStatement statement) {
        return statement.getFullSQL();
    }

    public static String getExportedFilename(String name) {
        Matcher m = FileUtils.INVALID_FILENAME.matcher(name);
        if (m.find()) {
            String hash = PgDiffUtils.md5(name)
                    // 2^40 variants, should be enough for this purpose
                    .substring(0, HASH_LENGTH);
            return m.replaceAll("") + '_' + hash; //$NON-NLS-1$
        } else {
            return name;
        }
    }


    /**
     * @return a statement's exported file name
     */
    public static String getExportedFilename(PgStatement statement) {
        return getExportedFilename(statement.getBareName());
    }

    public static String getExportedFilenameSql(PgStatement statement) {
        return getExportedFilenameSql(getExportedFilename(statement));
    }

    public static String getExportedFilenameSql(String name) {
        return getExportedFilename(name) + ".sql"; //$NON-NLS-1$
    }

    public static void writeProjVersion(File f) throws FileNotFoundException {
        try (PrintWriter pw = new UnixPrintWriter(f, StandardCharsets.UTF_8)) {
            pw.println(ApgdiffConsts.VERSION_PROP_NAME + " = " //$NON-NLS-1$
                    + ApgdiffConsts.EXPORT_CURRENT_VERSION);
        }
    }
}

/**
 * Sets fixed order for table subelements export as historically defined by DiffTree.create().
 */
class ExportTableOrder implements Comparator<PgStatementWithSearchPath> {

    public static final ExportTableOrder INSTANCE = new ExportTableOrder();

    @Override
    public int compare(PgStatementWithSearchPath o1, PgStatementWithSearchPath o2) {
        return getTableSubelementRank(o1) - getTableSubelementRank(o2);
    }

    private int getTableSubelementRank(PgStatementWithSearchPath el) {
        switch (el.getStatementType()) {
        case INDEX:     return 0;
        case TRIGGER:   return 1;
        case RULE:      return 2;
        case CONSTRAINT:return 3;
        default: throw new IllegalArgumentException("Illegal table subelement: " + el.getName());
        }
    }
}
