package ru.taximaxim.codekeeper.ui.differ;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.IPreferenceStore;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempFile;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.externalcalls.PgDumper;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;
import ru.taximaxim.codekeeper.ui.prefs.LicensePrefs;

public abstract class DbSource {

    private final String origin;
    private PgDatabase dbObject;

    public String getOrigin() {
        return origin;
    }

    /**
     * @return DB name this source uses or null if not applicable
     */
    public String getDbName() {
        return null;
    }

    public PgDatabase getDbObject() {
        if (dbObject == null) {
            throw new IllegalStateException(
                    Messages.dbSource_db_is_not_loaded_yet_object_is_null);
        }
        return dbObject;
    }

    public PgDatabase get(SubMonitor monitor)
            throws IOException, InterruptedException, LicenseException, CoreException {
        Log.log(Log.LOG_INFO, "Loading DB from " + origin); //$NON-NLS-1$

        dbObject = this.loadInternal(monitor);
        return dbObject;
    }

    public boolean isLoaded(){
        return dbObject != null;
    }

    protected DbSource(String origin) {
        this.origin = origin;
    }

    protected abstract PgDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException, LicenseException, CoreException;

    static PgDiffArguments getPgDiffArgs(String charset, boolean forceUnixNewlines)
            throws LicenseException, IOException {
        return getPgDiffArgs(charset, ApgdiffConsts.UTC, forceUnixNewlines);
    }
    static PgDiffArguments getPgDiffArgs(String charset, String timeZone,
            boolean forceUnixNewlines) throws LicenseException, IOException {
        PgDiffArguments args = new PgDiffArguments();
        IPreferenceStore mainPS = Activator.getDefault().getPreferenceStore();
        args.setInCharsetName(charset);
        args.setAddTransaction(mainPS.getBoolean(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION));
        args.setDisableCheckFunctionBodies(!mainPS.getBoolean(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES));
        args.setUsingTypeCastOff(mainPS.getBoolean(DB_UPDATE_PREF.USING_ON_OFF));
        args.setIgnorePrivileges(mainPS.getBoolean(PREF.NO_PRIVILEGES));
        args.setTimeZone(timeZone);
        args.setKeepNewlines(!forceUnixNewlines);
        LicensePrefs.setLicense(args);
        return args;
    }

    public static DbSource fromDirTree(boolean forceUnixNewlines,String dirTreePath, String encoding) {
        return new DbSourceDirTree(forceUnixNewlines, dirTreePath, encoding);
    }

    public static DbSource fromProject(PgDbProject proj) {
        return new DbSourceProject(proj);
    }

    public static DbSource fromFile(boolean forceUnixNewlines, File filename, String encoding) {
        return new DbSourceFile(forceUnixNewlines, filename, encoding);
    }

    public static DbSource fromDbInfo(DbInfo dbinfo, IPreferenceStore prefs,
            boolean forceUnixNewlines, String charset, String timezone) {
        if (prefs.getBoolean(PREF.PGDUMP_SWITCH)) {
            return DbSource.fromDb(forceUnixNewlines,
                    prefs.getString(PREF.PGDUMP_EXE_PATH),
                    prefs.getString(PREF.PGDUMP_CUSTOM_PARAMS),
                    dbinfo.getDbHost(), dbinfo.getDbPort(),
                    dbinfo.getDbUser(), dbinfo.getDbPass(), dbinfo.getDbName(),
                    charset, timezone);
        } else {
            return DbSource.fromJdbc(dbinfo.getDbHost(), dbinfo.getDbPort(),
                    dbinfo.getDbUser(), dbinfo.getDbPass(), dbinfo.getDbName(),
                    timezone, forceUnixNewlines);
        }
    }

    public static DbSource fromDb(boolean forceUnixNewlines,
            String exePgdump, String customParams,
            String host, int port, String user, String pass, String dbname,
            String encoding, String timezone) {
        return new DbSourceDb(forceUnixNewlines, exePgdump, customParams,
                host, port, user, pass, dbname, encoding, timezone);
    }

    public static DbSource fromJdbc(String host, int port, String user, String pass, String dbname,
            String timezone, boolean forceUnixNewlines) {
        return new DbSourceJdbc(host, port, user, pass, dbname, timezone, forceUnixNewlines);
    }

    public static DbSource fromDbObject(PgDatabase db, String origin) {
        return new DbSourceFromDbObject(db, origin);
    }

    /**
     * Calls {@link #getDbObject()} on the argument.
     */
    public static DbSource fromDbObject(DbSource dbSource) {
        return fromDbObject(dbSource.getDbObject(), dbSource.getOrigin());
    }
}

class DbSourceDirTree extends DbSource {

    private final boolean forceUnixNewlines;
    private final String dirTreePath;
    private final String encoding;

    DbSourceDirTree(boolean forceUnixNewlines, String dirTreePath, String encoding) {
        super(dirTreePath);

        this.forceUnixNewlines = forceUnixNewlines;
        this.dirTreePath = dirTreePath;
        this.encoding = encoding;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor)
            throws InterruptedException, IOException, LicenseException {
        monitor.subTask(Messages.dbSource_loading_tree);

        return PgDumpLoader.loadDatabaseSchemaFromDirTree(dirTreePath,
                getPgDiffArgs(encoding, forceUnixNewlines), monitor);
    }
}

class DbSourceProject extends DbSource {

    private final PgDbProject proj;

    DbSourceProject(PgDbProject proj) {
        super(proj.getProjectName());

        this.proj = proj;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException, LicenseException, CoreException {
        String charset = proj.getProjectCharset();
        monitor.subTask(Messages.dbSource_loading_tree);
        IProject project = proj.getProject();

        int filesCount = PgUIDumpLoader.countFiles(project);
        monitor.setWorkRemaining(filesCount);

        IEclipsePreferences pref = proj.getPrefs();
        PgDatabase db = PgUIDumpLoader.loadDatabaseSchemaFromIProject(
                project.getProject(),
                getPgDiffArgs(charset, pref.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true)),
                monitor, null);

        DBTimestamp.updateObjects(db, proj.getProjectName());
        return db;
    }
}

class DbSourceFile extends DbSource {
    /*
     * Магическая константа AVERAGE_STATEMENT_LENGTH получена эмпирическим путем.
     * Она равна количеству строк в файле sql, поделенному на количество выражений.
     *
     * По подсчетам, это число в районе 6. Для верности берем 5.
     */
    private static final int AVERAGE_STATEMENT_LENGTH = 5;

    private final boolean forceUnixNewlines;
    private final File filename;
    private final String encoding;

    DbSourceFile(boolean forceUnixNewlines, File filename, String encoding) {
        super(filename.getAbsolutePath());

        this.forceUnixNewlines = forceUnixNewlines;
        this.filename = filename;
        this.encoding = encoding;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor)
            throws InterruptedException, IOException, LicenseException {
        monitor.subTask(Messages.dbSource_loading_dump);

        try {
            int linesCount = countLines(filename);
            monitor.setWorkRemaining(linesCount > AVERAGE_STATEMENT_LENGTH ?
                    linesCount/AVERAGE_STATEMENT_LENGTH : 1);
        } catch (IOException e) {
            Log.log(Log.LOG_INFO, "Error counting file lines. Setting 1000"); //$NON-NLS-1$
            monitor.setWorkRemaining(1000);
        }

        try (PgDumpLoader loader = new PgDumpLoader(filename,
                getPgDiffArgs(encoding, forceUnixNewlines),
                monitor, 2)) {
            return loader.load();
        }
    }

    private int countLines(File filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename);
                InputStream is = new BufferedInputStream(fis)){
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        }
    }
}

class DbSourceDb extends DbSource {

    private final boolean forceUnixNewlines;
    private final String exePgdump;
    private final String customParams;

    private final String host;
    private final String user;
    private final String pass;
    private final String dbname;
    private final String encoding;
    private final String timezone;
    private final int port;

    @Override
    public String getDbName() {
        return dbname;
    }

    DbSourceDb(boolean forceUnixNewlines,
            String exePgdump, String customParams,
            String host, int port, String user, String pass,
            String dbname, String encoding, String timezone) {
        super(dbname);

        this.forceUnixNewlines = forceUnixNewlines;
        this.exePgdump = exePgdump;
        this.customParams = customParams;
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.dbname = dbname;
        this.encoding = encoding;
        this.timezone = timezone;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException, LicenseException {
        SubMonitor pm = SubMonitor.convert(monitor, 2);

        try (TempFile tf = new TempFile("tmp_dump_", ".sql")) { //$NON-NLS-1$ //$NON-NLS-2$
            File dump = tf.get().toFile();

            pm.newChild(1).subTask(Messages.dbSource_executing_pg_dump);

            new PgDumper(exePgdump, customParams,
                    host, port, user, pass, dbname, encoding, timezone,
                    dump.getAbsolutePath()).pgDump();

            pm.newChild(1).subTask(Messages.dbSource_loading_dump);

            try (PgDumpLoader loader = new PgDumpLoader(dump,
                    getPgDiffArgs(encoding, forceUnixNewlines),
                    monitor)) {
                return loader.load();
            }
        }
    }
}

class DbSourceJdbc extends DbSource {

    private final JdbcConnector jdbcConnector;
    private final String dbName;
    private final boolean forceUnixNewlines;
    private PgDatabase db;
    private String projectName;

    @Override
    public String getDbName() {
        return dbName;
    }

    public void setProjectDb(PgDatabase db) {
        this.db = db;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    DbSourceJdbc(String host, int port, String user, String pass, String dbName,
            String timezone, boolean forceUnixNewlines) {
        super(dbName);
        this.dbName = dbName;
        this.forceUnixNewlines = forceUnixNewlines;
        jdbcConnector = new JdbcConnector(host, port, user, pass, dbName, timezone);
    }

    @Override
    public PgDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException, LicenseException {
        monitor.subTask(Messages.reading_db_from_jdbc);
        PgDiffArguments args = getPgDiffArgs(ApgdiffConsts.UTF_8, forceUnixNewlines);
        return new JdbcLoader(jdbcConnector, args, monitor).getDbFromJdbc(db, projectName);
    }
}

class DbSourceFromDbObject extends DbSource {

    PgDatabase db;

    protected DbSourceFromDbObject(PgDatabase db, String origin) {
        super(origin);
        this.db = db;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor) throws IOException {
        return db;
    }
}
