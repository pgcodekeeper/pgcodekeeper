/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.IProgressReporter;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.fileutils.InputStreamProvider;
import ru.taximaxim.codekeeper.core.loader.AbstractJdbcConnector;
import ru.taximaxim.codekeeper.core.loader.DatabaseLoader;
import ru.taximaxim.codekeeper.core.loader.LoaderFactory;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.loader.ProjectLoader;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.consoles.UiProgressReporter;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfoJdbcConnector;
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
    private AbstractDatabase dbObject;
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

    public AbstractDatabase getDbObject() {
        if (dbObject == null) {
            throw new IllegalStateException(
                    Messages.dbSource_db_is_not_loaded_yet_object_is_null);
        }
        return dbObject;
    }

    public AbstractDatabase get(SubMonitor monitor)
            throws IOException, InterruptedException, CoreException {
        Log.log(Log.LOG_INFO, "Loading DB from " + origin); //$NON-NLS-1$

        dbObject = this.loadInternal(monitor);
        return dbObject;
    }

    protected AbstractDatabase load(DatabaseLoader loader) throws IOException, InterruptedException {
        try {
            return loader.loadAndAnalyze();
        } finally {
            errors = loader.getErrors();
        }
    }

    public boolean isLoaded() {
        return dbObject != null;
    }

    public List<Object> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    protected DbSource(String origin) {
        this.origin = origin;
    }

    protected abstract AbstractDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException, CoreException;

    static PgDiffArguments getPgDiffArgs(String charset, boolean forceUnixNewlines,
            DatabaseType dbType, IProject proj, Map<String, Boolean> oneTimePrefs) {
        return getPgDiffArgs(charset, Consts.UTC, forceUnixNewlines, dbType,
                proj, oneTimePrefs);
    }

    static PgDiffArguments getPgDiffArgs(String charset, String timeZone,
            boolean forceUnixNewlines, DatabaseType dbType, IProject proj,
            Map<String, Boolean> oneTimePrefs) {
        PgDiffArguments args = new PgDiffArguments();
        OverridablePrefs prefs = new OverridablePrefs(proj, oneTimePrefs);
        args.setInCharsetName(charset);
        args.setAddTransaction(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION));
        args.setDisableCheckFunctionBodies(!prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.CHECK_FUNCTION_BODIES));
        args.setEnableFunctionBodiesDependencies(prefs.getBooleanOfRootPref(PREF.ENABLE_BODY_DEPENDENCIES));
        args.setIgnoreConcurrentModification(Activator.getDefault().getPreferenceStore()
                .getBoolean(PREF.IGNORE_CONCURRENT_MODIFICATION));
        args.setSelectedOnly(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS));
        args.setDataMovementMode(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.DATA_MOVEMENT_MODE));
        args.setIgnorePrivileges(prefs.getBooleanOfRootPref(PREF.NO_PRIVILEGES));
        args.setIgnoreColumnOrder(prefs.getBooleanOfRootPref(PREF.IGNORE_COLUMN_ORDER));
        args.setSimplifyView(prefs.getBooleanOfRootPref(PREF.SIMPLIFY_VIEW));
        args.setAutoFormatObjectCode(prefs.getBooleanOfRootPref(PREF.FORMAT_OBJECT_CODE_AUTOMATICALLY));
        args.setFormatConfiguration(Formatter.getFormatterConfig());
        args.setCommentsToEnd(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.COMMENTS_TO_END));
        args.setDropBeforeCreate(prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.DROP_BEFORE_CREATE));
        args.setTimeZone(timeZone);
        args.setKeepNewlines(!forceUnixNewlines);
        args.setDbType(dbType);
        if (prefs.getBooleanOfDbUpdatePref(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT)) {
            List<String> prePaths = new ArrayList<>();
            if (proj != null) {
                addPathIfExists(prePaths, Paths.get(proj.getLocationURI()).resolve(FILE.PRE_DIR));
            }
            addPathIfExists(prePaths, PrePostScriptPrefPage.getScriptPath(FILE.PRE_SCRIPT));
            args.setPreFilePath(prePaths);

            List<String> postPaths = new ArrayList<>();
            if (proj != null) {
                addPathIfExists(postPaths, Paths.get(proj.getLocationURI()).resolve(FILE.POST_DIR));
            }
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

    public static DbSource fromDirTree(boolean forceUnixNewlines, String dirTreePath,
            String encoding, DatabaseType dbType, Map<String, Boolean> oneTimePrefs) {
        return new DbSourceDirTree(forceUnixNewlines, dirTreePath, encoding,
                dbType, oneTimePrefs);
    }

    public static DbSource fromProject(PgDbProject proj, Map<String, Boolean> oneTimePrefs) {
        return new DbSourceProject(proj, oneTimePrefs);
    }

    public static DbSource fromProject(PgDbProject proj) {
        return fromProject(proj, null);
    }

    public static DbSource fromFile(boolean forceUnixNewlines, File filename,
            String encoding, DatabaseType dbType, IProject proj, Map<String, Boolean> oneTimePrefs) {
        return fromFile(forceUnixNewlines, filename.toPath(), encoding, dbType, proj, oneTimePrefs);
    }

    public static DbSource fromFile(boolean forceUnixNewlines, Path filename,
            String encoding, DatabaseType dbType, IProject proj, Map<String, Boolean> oneTimePrefs) {
        return new DbSourceFile(forceUnixNewlines, filename, encoding, dbType,
                proj, oneTimePrefs);
    }

    public static DbSource fromFile(boolean forceUnixNewlines, File filename,
            String encoding, DatabaseType dbType, IProject proj) {
        return fromFile(forceUnixNewlines, filename.toPath(), encoding, dbType, proj);
    }

    public static DbSource fromFile(boolean forceUnixNewlines, Path filename,
            String encoding, DatabaseType dbType, IProject proj) {
        return fromFile(forceUnixNewlines, filename, encoding, dbType, proj, null);
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

    public static DbSource fromDbObject(AbstractDatabase db, String origin) {
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
    private final DatabaseType dbType;
    private final Map<String, Boolean> oneTimePrefs;

    DbSourceDirTree(boolean forceUnixNewlines, String dirTreePath, String encoding,
            DatabaseType dbType, Map<String, Boolean> oneTimePrefs) {
        super(dirTreePath);

        this.forceUnixNewlines = forceUnixNewlines;
        this.dirTreePath = dirTreePath;
        this.encoding = encoding;
        this.dbType = dbType;
        this.oneTimePrefs = oneTimePrefs;
    }

    @Override
    protected AbstractDatabase loadInternal(SubMonitor monitor)
            throws InterruptedException, IOException {
        monitor.subTask(Messages.dbSource_loading_tree);

        return load(new ProjectLoader(dirTreePath,
                getPgDiffArgs(encoding, forceUnixNewlines, dbType, null, oneTimePrefs),
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
    protected AbstractDatabase loadInternal(SubMonitor monitor)
            throws InterruptedException, CoreException, IOException {
        String charset = proj.getProjectCharset();
        monitor.subTask(Messages.dbSource_loading_tree);
        IProject project = proj.getProject();

        monitor.setWorkRemaining(UIProjectLoader.countFiles(project));

        IEclipsePreferences pref = proj.getPrefs();

        PgDiffArguments arguments = getPgDiffArgs(charset,
                pref.getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true),
                OpenProjectUtils.getDatabaseType(project), project, oneTimePrefs);

        Path listFile = Paths.get(project.getLocationURI()).resolve(FILE.IGNORED_SCHEMA);
        boolean projectOnly = oneTimePrefs != null && Boolean.TRUE == oneTimePrefs.get(Consts.PROJECT_ONLY);

        return load(new UIProjectLoader(project, arguments, monitor,
                InternalIgnoreList.getIgnoreSchemaList(listFile), projectOnly));
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
    private final DatabaseType dbType;
    private final IProject proj;
    private final Map<String, Boolean> oneTimePrefs;

    DbSourceFile(boolean forceUnixNewlines, Path filename, String encoding,
            DatabaseType dbType, IProject proj, Map<String, Boolean> oneTimePrefs) {
        super(filename.toAbsolutePath().toString());

        this.forceUnixNewlines = forceUnixNewlines;
        this.filename = filename;
        this.encoding = encoding;
        this.dbType = dbType;
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
    }

    @Override
    protected AbstractDatabase loadInternal(SubMonitor monitor)
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
        PgDiffArguments args = getPgDiffArgs(encoding, forceUnixNewlines, dbType, proj, oneTimePrefs);
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
    protected AbstractDatabase loadInternal(SubMonitor monitor)
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

        PgDiffArguments args = getPgDiffArgs(encoding, forceUnixNewlines, DatabaseType.PG, proj, oneTimePrefs);
        return load(new PgDumpLoader(streamProvider, "pg_dump", args, monitor)); //$NON-NLS-1$
    }
}

class DbSourceJdbc extends DbSource {

    private final AbstractJdbcConnector jdbcConnector;
    private final String dbName;
    private final boolean forceUnixNewlines;
    private final DatabaseType dbType;
    private final IProject proj;
    private final Map<String, Boolean> oneTimePrefs;
    private final String timezone;

    @Override
    public String getDbName() {
        return dbName;
    }

    DbSourceJdbc(DbInfo dbinfo, String timezone, boolean forceUnixNewlines,
            IProject proj, Map<String, Boolean> oneTimePrefs) {
        super(dbinfo.getDbName());

        this.jdbcConnector = new DbInfoJdbcConnector(dbinfo);
        this.dbName = dbinfo.getDbName();
        this.forceUnixNewlines = forceUnixNewlines;
        this.dbType = dbinfo.getDbType();
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
        this.timezone = timezone;
    }

    @Override
    protected AbstractDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException {
        monitor.subTask(Messages.reading_db_from_jdbc);
        PgDiffArguments args = getPgDiffArgs(Consts.UTF_8, forceUnixNewlines,
                dbType, proj, oneTimePrefs);

        IgnoreSchemaList ignoreShemaList = null;
        if (proj != null) {
            Path listFile = Paths.get(proj.getLocationURI()).resolve(FILE.IGNORED_SCHEMA);
            ignoreShemaList = InternalIgnoreList.getIgnoreSchemaList(listFile);
        }

        return load(LoaderFactory.createJdbcLoader(args, timezone, jdbcConnector, monitor, ignoreShemaList));
    }
}
class DbSourceFromDbObject extends DbSource {

    AbstractDatabase db;

    protected DbSourceFromDbObject(AbstractDatabase db, String origin) {
        super(origin);
        this.db = db;
    }

    @Override
    protected AbstractDatabase loadInternal(SubMonitor monitor) throws IOException {
        return db;
    }
}

