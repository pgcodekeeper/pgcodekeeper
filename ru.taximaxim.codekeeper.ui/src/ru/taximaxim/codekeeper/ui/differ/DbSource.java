package ru.taximaxim.codekeeper.ui.differ;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import cz.startnet.utils.pgdiff.IProgressReporter;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.DatabaseLoader;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.JdbcMsConnector;
import cz.startnet.utils.pgdiff.loader.JdbcMsLoader;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.loader.ProjectLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.fileutils.InputStreamProvider;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.consoles.UiProgressReporter;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.externalcalls.PgDumper;
import ru.taximaxim.codekeeper.ui.formatter.Formatter;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.prefs.PrePostScriptPrefPage;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;
import ru.taximaxim.codekeeper.ui.properties.OverridablePrefs;

public abstract class DbSource {

    private final String origin;
    private PgDatabase dbObject;
    private List<Object> errors = Collections.emptyList();

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
            throws IOException, InterruptedException, CoreException {
        Log.log(Log.LOG_INFO, "Loading DB from " + origin); //$NON-NLS-1$

        dbObject = this.loadInternal(monitor);
        return dbObject;
    }

    protected PgDatabase load(DatabaseLoader loader) throws IOException, InterruptedException {
        try {
            return loader.loadAndAnalyze();
        } finally {
            errors = loader.getErrors();
        }
    }

    public boolean isLoaded(){
        return dbObject != null;
    }

    public List<Object> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    protected DbSource(String origin) {
        this.origin = origin;
    }

    protected abstract PgDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException, CoreException;

    static PgDiffArguments getPgDiffArgs(String charset, boolean forceUnixNewlines,
            boolean msSql, IProject proj, Map<String, Boolean> oneTimePrefs) {
        return getPgDiffArgs(charset, ApgdiffConsts.UTC, forceUnixNewlines, msSql,
                proj, oneTimePrefs);
    }

    static PgDiffArguments getPgDiffArgs(String charset, String timeZone,
            boolean forceUnixNewlines, boolean msSql, IProject proj,
            Map<String, Boolean> oneTimePrefs) {
        PgDiffArguments args = new PgDiffArguments();
        OverridablePrefs prefs = new OverridablePrefs(proj, oneTimePrefs);
        args.setInCharsetName(charset);
        args.setAddTransaction(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION));
        args.setDisableCheckFunctionBodies(!prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES));
        args.setEnableFunctionBodiesDependencies(prefs.getBooleanOfRootPref(PREF.ENABLE_BODY_DEPENDENCIES));
        args.setIgnoreConcurrentModification(Activator.getDefault().getPreferenceStore()
                .getBoolean(PREF.IGNORE_CONCURRENT_MODIFICATION));
        args.setUsingTypeCastOff(!prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.USING_ON_OFF));
        args.setSelectedOnly(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS));
        args.setDataMovementMode(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.DATA_MOVEMENT_MODE));
        args.setIgnorePrivileges(prefs.getBooleanOfRootPref(PREF.NO_PRIVILEGES));
        args.setIgnoreColumnOrder(prefs.getBooleanOfRootPref(PREF.IGNORE_COLUMN_ORDER));
        args.setSimplifyView(prefs.getBooleanOfRootPref(PREF.SIMPLIFY_VIEW));
        args.setAutoFormatObjectCode(prefs.getBooleanOfRootPref(PREF.FORMAT_OBJECT_CODE_AUTOMATICALLY));
        args.setFormatConfiguration(Formatter.getFormatterConfig());
        args.setTimeZone(timeZone);
        args.setKeepNewlines(!forceUnixNewlines);
        args.setMsSql(msSql);
        if (prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT)) {
            List<String> prePaths = new ArrayList<>();
            addPathIfExists(prePaths, PrePostScriptPrefPage.getScriptPath(FILE.PRE_SCRIPT));
            addPathIfExists(prePaths, Paths.get(proj.getLocationURI()).resolve(FILE.PRE_DIR));
            args.setPreFilePath(prePaths);

            List<String> postPaths = new ArrayList<>();
            addPathIfExists(postPaths, Paths.get(proj.getLocationURI()).resolve(FILE.POST_DIR));
            addPathIfExists(postPaths, PrePostScriptPrefPage.getScriptPath(FILE.POST_SCRIPT));
            args.setPostFilePath(postPaths);
        }
        return args;
    }

    private static void addPathIfExists(List<String> paths, Path path) {
        if (Files.exists(path)) {
            paths.add(path.toString());
        }
    }

    public static DbSource fromDirTree(boolean forceUnixNewlines,String dirTreePath,
            String encoding, boolean isMsSql, Map<String, Boolean> oneTimePrefs) {
        return new DbSourceDirTree(forceUnixNewlines, dirTreePath, encoding,
                isMsSql, oneTimePrefs);
    }

    public static DbSource fromProject(PgDbProject proj, Map<String, Boolean> oneTimePrefs) {
        return new DbSourceProject(proj, oneTimePrefs);
    }

    public static DbSource fromProject(PgDbProject proj) {
        return fromProject(proj, null);
    }

    public static DbSource fromFile(boolean forceUnixNewlines, File filename,
            String encoding, boolean isMsSql, IProject proj, Map<String, Boolean> oneTimePrefs) {
        return fromFile(forceUnixNewlines, filename.toPath(), encoding, isMsSql, proj, oneTimePrefs);
    }

    public static DbSource fromFile(boolean forceUnixNewlines, Path filename,
            String encoding, boolean isMsSql, IProject proj, Map<String, Boolean> oneTimePrefs) {
        return new DbSourceFile(forceUnixNewlines, filename, encoding, isMsSql,
                proj, oneTimePrefs);
    }

    public static DbSource fromFile(boolean forceUnixNewlines, File filename,
            String encoding, boolean isMsSql, IProject proj) {
        return fromFile(forceUnixNewlines, filename.toPath(), encoding, isMsSql, proj);
    }

    public static DbSource fromFile(boolean forceUnixNewlines, Path filename,
            String encoding, boolean isMsSql, IProject proj) {
        return fromFile(forceUnixNewlines, filename, encoding, isMsSql, proj, null);
    }

    public static DbSource fromDbInfo(DbInfo dbinfo, boolean forceUnixNewlines,
            String charset, String timezone, IProject proj, Map<String, Boolean> oneTimePrefs) {
        if (dbinfo.isPgDumpSwitch()) {
            return new DbSourceDb(forceUnixNewlines, dbinfo, charset, timezone,
                    proj, oneTimePrefs);
        }
        return new DbSourceJdbc(dbinfo, timezone, forceUnixNewlines, proj, oneTimePrefs);
    }

    public static DbSource fromDbInfo(DbInfo dbinfo, boolean forceUnixNewlines,
            String charset, String timezone, IProject proj) {
        return fromDbInfo(dbinfo, forceUnixNewlines, charset, timezone, proj, null);
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
    private final boolean isMsSql;
    private final Map<String, Boolean> oneTimePrefs;

    DbSourceDirTree(boolean forceUnixNewlines, String dirTreePath, String encoding,
            boolean isMsSql, Map<String, Boolean> oneTimePrefs) {
        super(dirTreePath);

        this.forceUnixNewlines = forceUnixNewlines;
        this.dirTreePath = dirTreePath;
        this.encoding = encoding;
        this.isMsSql = isMsSql;
        this.oneTimePrefs = oneTimePrefs;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor)
            throws InterruptedException, IOException {
        monitor.subTask(Messages.dbSource_loading_tree);

        return load(new ProjectLoader(dirTreePath,
                getPgDiffArgs(encoding, forceUnixNewlines, isMsSql, null, oneTimePrefs),
                new ArrayList<>()));
    }
}

class DbSourceProject extends DbSource {

    private final PgDbProject proj;
    private final Map<String, Boolean> oneTimePrefs;

    DbSourceProject(PgDbProject proj, Map<String, Boolean> oneTimePrefs) {
        super(proj.getProjectName());
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor)
            throws InterruptedException, CoreException, IOException {
        String charset = proj.getProjectCharset();
        monitor.subTask(Messages.dbSource_loading_tree);
        IProject project = proj.getProject();

        monitor.setWorkRemaining(UIProjectLoader.countFiles(project));

        IEclipsePreferences pref = proj.getPrefs();

        PgDiffArguments arguments = getPgDiffArgs(charset,
                pref.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true),
                OpenProjectUtils.checkMsSql(project), project, oneTimePrefs);

        Path listFile = Paths.get(project.getLocationURI()).resolve(FILE.IGNORED_SCHEMA);
        return load(new UIProjectLoader(project, arguments, monitor, InternalIgnoreList.getIgnoreSchemaList(listFile)));
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
    private final Path filename;
    private final String encoding;
    private final boolean isMsSql;
    private final IProject proj;
    private final Map<String, Boolean> oneTimePrefs;

    DbSourceFile(boolean forceUnixNewlines, Path filename, String encoding,
            boolean isMsSql, IProject proj, Map<String, Boolean> oneTimePrefs) {
        super(filename.toAbsolutePath().toString());

        this.forceUnixNewlines = forceUnixNewlines;
        this.filename = filename;
        this.encoding = encoding;
        this.isMsSql = isMsSql;
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor)
            throws InterruptedException, IOException {
        monitor.subTask(Messages.dbSource_loading_dump);

        try {
            int linesCount = countLines(filename);
            monitor.setWorkRemaining(linesCount > AVERAGE_STATEMENT_LENGTH ?
                    linesCount/AVERAGE_STATEMENT_LENGTH : 1);
        } catch (IOException e) {
            Log.log(Log.LOG_INFO, "Error counting file lines. Setting 1000"); //$NON-NLS-1$
            monitor.setWorkRemaining(1000);
        }
        PgDiffArguments args = getPgDiffArgs(encoding, forceUnixNewlines, isMsSql, proj, oneTimePrefs);
        return load(new PgDumpLoader(filename, args, monitor, 2));
    }

    private int countLines(Path filename) throws IOException {
        try (InputStream fis = Files.newInputStream(filename);
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
    private final IProject proj;
    private final Map<String, Boolean> oneTimePrefs;

    @Override
    public String getDbName() {
        return dbname;
    }

    DbSourceDb(boolean forceUnixNewlines,
            DbInfo dbinfo, String encoding, String timezone, IProject proj,
            Map<String, Boolean> oneTimePrefs) {
        super(dbinfo.getDbName());

        this.forceUnixNewlines = forceUnixNewlines;
        this.exePgdump = dbinfo.getPgdumpExePath();
        this.customParams = dbinfo.getPgdumpCustomParams();
        this.host = dbinfo.getDbHost();
        this.port = dbinfo.getDbPort();
        this.user = dbinfo.getDbUser();
        this.pass = dbinfo.getDbPass();
        this.dbname = dbinfo.getDbName();
        this.encoding = encoding;
        this.timezone = timezone;
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor, 2);

        pm.newChild(1).subTask(Messages.dbSource_executing_pg_dump);

        byte[] dump;
        try (IProgressReporter progress = new UiProgressReporter(monitor, null)) {
            dump = new PgDumper(exePgdump, customParams,
                    host, port, user, pass, dbname, encoding, timezone, progress)
                    .pgDump();
        }
        InputStreamProvider streamProvider = () -> new ByteArrayInputStream(dump, 0, dump.length);

        pm.newChild(1).subTask(Messages.dbSource_loading_dump);

        PgDiffArguments args = getPgDiffArgs(encoding, forceUnixNewlines, false, proj, oneTimePrefs);
        return load(new PgDumpLoader(streamProvider, "pg_dump", args, monitor)); //$NON-NLS-1$
    }
}

class DbSourceJdbc extends DbSource {

    private final JdbcConnector jdbcConnector;
    private final String dbName;
    private final boolean forceUnixNewlines;
    private final boolean isMsSql;
    private final IProject proj;
    private final Map<String, Boolean> oneTimePrefs;

    @Override
    public String getDbName() {
        return dbName;
    }

    DbSourceJdbc(DbInfo dbinfo, String timezone, boolean forceUnixNewlines,
            IProject proj, Map<String, Boolean> oneTimePrefs) {
        super(dbinfo.getDbName());

        String host = dbinfo.getDbHost();
        int port = dbinfo.getDbPort();
        String user = dbinfo.getDbUser();
        String pass = dbinfo.getDbPass();
        Map<String, String> properties = dbinfo.getProperties();
        boolean readOnly = dbinfo.isReadOnly();
        boolean winAuth = dbinfo.isWinAuth();

        this.dbName = dbinfo.getDbName();
        this.forceUnixNewlines = forceUnixNewlines;
        this.isMsSql =  dbinfo.isMsSql();
        if (isMsSql) {
            jdbcConnector = new JdbcMsConnector(host, port, user, pass, dbName, properties,
                    readOnly, winAuth, dbinfo.getDomain());
        } else {
            jdbcConnector = new JdbcConnector(host, port, user, pass, dbName, properties,
                    readOnly, timezone);
        }
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException {
        monitor.subTask(Messages.reading_db_from_jdbc);
        PgDiffArguments args = getPgDiffArgs(ApgdiffConsts.UTF_8, forceUnixNewlines,
                isMsSql, proj, oneTimePrefs);

        IgnoreSchemaList ignoreShemaList = null;
        if (proj != null) {
            Path listFile = Paths.get(proj.getLocationURI()).resolve(FILE.IGNORED_SCHEMA);
            ignoreShemaList = InternalIgnoreList.getIgnoreSchemaList(listFile);
        }
        if (isMsSql) {
            return load(new JdbcMsLoader(jdbcConnector, args, monitor, ignoreShemaList));
        }
        return load(new JdbcLoader(jdbcConnector, args, monitor, ignoreShemaList));
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
