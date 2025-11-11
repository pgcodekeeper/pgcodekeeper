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
import org.pgcodekeeper.core.Consts;
import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.ignorelist.IgnoreSchemaList;
import org.pgcodekeeper.core.loader.DatabaseLoader;
import org.pgcodekeeper.core.loader.LoaderFactory;
import org.pgcodekeeper.core.loader.PgDumpLoader;
import org.pgcodekeeper.core.loader.ProjectLoader;
import org.pgcodekeeper.core.reporter.IProgressReporter;
import org.pgcodekeeper.core.schema.AbstractDatabase;
import org.pgcodekeeper.core.utils.InputStreamProvider;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.consoles.UiProgressReporter;
import ru.taximaxim.codekeeper.ui.database.jdbc.base.IDbInfoConnector;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.externalcalls.PgDumper;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;
import ru.taximaxim.codekeeper.ui.properties.UISettings;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;
import ru.taximaxim.codekeeper.ui.utils.UIMonitor;

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

    public static DbSource fromDirTree(String dirTreePath, Map<String, Boolean> oneTimePrefs) {
        return new DbSourceDirTree(dirTreePath, oneTimePrefs);
    }

    public static DbSource fromProject(PgDbProject proj, Map<String, Boolean> oneTimePrefs) {
        return new DbSourceProject(proj, oneTimePrefs);
    }

    public static DbSource fromProject(PgDbProject proj) {
        return fromProject(proj, null);
    }

    public static DbSource fromFile(File filename, IProject proj) {
        return fromFile(filename, proj, null);
    }

    public static DbSource fromFile(File filename, IProject proj, Map<String, Boolean> oneTimePrefs) {
        return fromFile(filename, proj, oneTimePrefs, null);
    }

    public static DbSource fromFile(File filename, IProject proj, Map<String, Boolean> oneTimePrefs, DatabaseType dbType) {
        return new DbSourceFile(filename.toPath(), proj, oneTimePrefs, dbType);
    }

    public static DbSource fromDbInfo(DbInfo dbinfo, String charset, String timezone, IProject proj,
            Map<String, Boolean> oneTimePrefs) {
        if (dbinfo.isPgDumpSwitch()) {
            return new DbSourceDb(dbinfo, charset, timezone, proj, oneTimePrefs);
        }
        return new DbSourceJdbc(dbinfo, timezone, proj, oneTimePrefs);
    }

    public static DbSource fromDbInfo(DbInfo dbinfo, String charset, String timezone, IProject proj) {
        return fromDbInfo(dbinfo, charset, timezone, proj, null);
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

    private final String dirTreePath;
    private final Map<String, Boolean> oneTimePrefs;

    DbSourceDirTree(String dirTreePath, Map<String, Boolean> oneTimePrefs) {
        super(dirTreePath);

        this.dirTreePath = dirTreePath;
        this.oneTimePrefs = oneTimePrefs;
    }

    @Override
    protected AbstractDatabase loadInternal(SubMonitor monitor)
            throws InterruptedException, IOException {
        monitor.subTask(Messages.dbSource_loading_tree);

        return load(new ProjectLoader(dirTreePath, new UISettings(null, oneTimePrefs), new ArrayList<>()));
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
        monitor.subTask(Messages.dbSource_loading_tree);
        IProject project = proj.getProject();

        monitor.setWorkRemaining(ProjectUtils.countFiles(project));

        Path listFile = Paths.get(project.getLocationURI()).resolve(FILE.IGNORED_SCHEMA);
        boolean projectOnly = oneTimePrefs != null && Boolean.TRUE == oneTimePrefs.get(Consts.PROJECT_ONLY);

        return load(new UIProjectLoader(project, new UISettings(project, oneTimePrefs), monitor,
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

    private final Path filename;
    private final IProject proj;
    private final Map<String, Boolean> oneTimePrefs;
    private final DatabaseType dbType;

    DbSourceFile(Path filename, IProject proj, Map<String, Boolean> oneTimePrefs, DatabaseType dbType) {
        super(filename.toAbsolutePath().toString());

        this.filename = filename;
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
        this.dbType = dbType;
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
        return load(new PgDumpLoader(filename, new UISettings(proj, oneTimePrefs, dbType), new UIMonitor(monitor), 2));
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

    DbSourceDb(DbInfo dbinfo, String encoding, String timezone, IProject proj, Map<String, Boolean> oneTimePrefs) {
        super(dbinfo.getDbName());

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

        return load(new PgDumpLoader(streamProvider, "pg_dump", new UISettings(proj, oneTimePrefs), //$NON-NLS-1$
                new UIMonitor(monitor)));
    }
}

class DbSourceJdbc extends DbSource {

    private final IDbInfoConnector jdbcConnector;
    private final String dbName;
    private final IProject proj;
    private final Map<String, Boolean> oneTimePrefs;
    private final String timezone;
    private final DatabaseType dbType;

    @Override
    public String getDbName() {
        return dbName;
    }

    DbSourceJdbc(DbInfo dbinfo, String timezone, IProject proj, Map<String, Boolean> oneTimePrefs) {
        super(dbinfo.getDbName());

        this.jdbcConnector = IDbInfoConnector.createConnector(dbinfo);
        this.dbName = dbinfo.getDbName();
        this.dbType = dbinfo.getDbType();
        this.proj = proj;
        this.oneTimePrefs = oneTimePrefs;
        this.timezone = timezone;
    }

    @Override
    protected AbstractDatabase loadInternal(SubMonitor monitor)
            throws IOException, InterruptedException {
        monitor.subTask(Messages.reading_db_from_jdbc);

        IgnoreSchemaList ignoreShemaList = null;
        if (proj != null) {
            Path listFile = Paths.get(proj.getLocationURI()).resolve(FILE.IGNORED_SCHEMA);
            ignoreShemaList = InternalIgnoreList.getIgnoreSchemaList(listFile);
        }

        return load(LoaderFactory.createJdbcLoader(new UISettings(proj, oneTimePrefs, dbType),
                timezone, jdbcConnector, new UIMonitor(monitor), ignoreShemaList));
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

