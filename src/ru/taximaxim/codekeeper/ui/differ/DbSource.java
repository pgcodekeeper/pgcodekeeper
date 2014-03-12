package ru.taximaxim.codekeeper.ui.differ;

import java.io.File;
import java.io.IOException;
import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.PgDbFilter2;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.GitExec;
import ru.taximaxim.codekeeper.ui.externalcalls.IRepoWorker;
import ru.taximaxim.codekeeper.ui.externalcalls.PgDumper;
import ru.taximaxim.codekeeper.ui.externalcalls.SvnExec;
import ru.taximaxim.codekeeper.ui.fileutils.TempDir;
import ru.taximaxim.codekeeper.ui.fileutils.TempFile;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public abstract class DbSource {

    final private String origin;

    private PgDatabase dbObject;

    public String getOrigin() {
        return origin;
    }

    public PgDatabase getDbObject() {
        if (dbObject == null) {
            throw new NullPointerException(
                    "DB is not loaded yet, object is null!");
        }
        return dbObject;
    }

    public PgDatabase get(SubMonitor monitor) throws IOException {
        dbObject = this.loadInternal(monitor);
        return dbObject;
    }

    protected DbSource(String origin) {
        this.origin = origin;
    }

    protected abstract PgDatabase loadInternal(SubMonitor monitor)
            throws IOException;

    public static DbSource fromDirTree(String dirTreePath, String encoding) {
        return new DbSourceDirTree(dirTreePath, encoding);
    }

    public static DbSource fromSvn(String svnExec, PgDbProject proj) {
        return new DbSourceRepo(svnExec, proj);
    }

    public static DbSource fromSvn(String svnExec, PgDbProject proj, String rev) {
        return new DbSourceRepo(svnExec, proj, rev);
    }

    public static DbSource fromSvn(String svnExec, String url, String user,
            String pass, String rev, String encoding) {
        return new DbSourceRepo(UIConsts.PROJ_REPO_TYPE_SVN_NAME, svnExec, url, user, pass, rev, encoding);
    }

    public static DbSource fromGit(String gitExec, PgDbProject proj) {
        return new DbSourceRepo(gitExec, proj);
    }

    public static DbSource fromGit(String gitExec, PgDbProject proj,
            String commitHash) {
        return new DbSourceRepo(gitExec, proj, commitHash);
    }

    public static DbSource fromGit(String gitExec, String url, String user,
            String pass, String commitHash, String encoding) {
        return new DbSourceRepo(UIConsts.PROJ_REPO_TYPE_GIT_NAME, gitExec, url, user, pass, commitHash,
                encoding);
    }

    public static DbSource fromProject(PgDbProject proj) {
        return new DbSourceProject(proj);
    }

    public static DbSource fromFile(String filename, String encoding) {
        return new DbSourceFile(filename, encoding);
    }

    public static DbSource fromDb(String exePgdump, PgDbProject proj) {
        return new DbSourceDb(exePgdump, proj);
    }

    public static DbSource fromDb(String exePgdump, String host, int port,
            String user, String pass, String dbname, String encoding) {
        return new DbSourceDb(exePgdump, host, port, user, pass, dbname,
                encoding);
    }

    public static DbSource fromFilter(DbSource src, TreeElement filter,
            DiffSide side) {
        return new DbSourceFilter(src, filter, side);
    }
}

class DbSourceDirTree extends DbSource {

    final private String dirTreePath;

    final private String encoding;

    DbSourceDirTree(String dirTreePath, String encoding) {
        super(dirTreePath);

        this.dirTreePath = dirTreePath;
        this.encoding = encoding;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor) {
        SubMonitor.convert(monitor, 1).newChild(1).subTask("Loading tree...");

        return PgDumpLoader.loadDatabaseSchemaFromDirTree(dirTreePath,
                encoding, false, false);
    }
}

class DbSourceRepo extends DbSource {

    final private IRepoWorker repo;

    final private String encoding;

    final private String rev;

    DbSourceRepo(String repoExec, PgDbProject proj) {
        this(repoExec, proj, null);
    }

    public DbSourceRepo(String repoExec, PgDbProject proj, String rev) {
        this(proj.getString(UIConsts.PROJ_PREF_REPO_TYPE), repoExec, proj
                .getString(UIConsts.PROJ_PREF_REPO_URL), proj
                .getString(UIConsts.PROJ_PREF_REPO_USER), proj
                .getString(UIConsts.PROJ_PREF_REPO_PASS), proj
                .getString(UIConsts.PROJ_PREF_ENCODING), rev);
    }

    DbSourceRepo(String repoType, String repoExec, String url, String user,
            String pass, String rev, String encoding) {
        super(url + (rev.isEmpty() ? "" : "@" + rev));
        switch (repoType) {
        case UIConsts.PROJ_REPO_TYPE_SVN_NAME:
            repo = new SvnExec(repoExec, url, user, pass);
            break;
        case UIConsts.PROJ_REPO_TYPE_GIT_NAME:
            repo = new GitExec(repoExec, url, user, pass);
            break;
        default:
            repo = new SvnExec(repoExec, url, user, pass);
            break;
        }

        this.encoding = encoding;
        this.rev = rev;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor) throws IOException {
        SubMonitor pm = SubMonitor.convert(monitor, 2);

        try (TempDir tmpDir = new TempDir("tmp_repo_")) {
            File dir = tmpDir.get();

            pm.newChild(1).subTask("Repository rev checkout...");
            repo.repoCheckOut(dir, rev);

            pm.newChild(1).subTask("Loading tree...");
            return PgDumpLoader.loadDatabaseSchemaFromDirTree(
                    dir.getAbsolutePath(), encoding, false, false);
        } 

    }
}

class DbSourceProject extends DbSource {

    final private PgDbProject proj;

    DbSourceProject(PgDbProject proj) {
        super(proj.getProjectPropsFile().getAbsolutePath());

        this.proj = proj;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor) {
        SubMonitor.convert(monitor, 1).newChild(1).subTask("Loading tree...");

        return PgDumpLoader.loadDatabaseSchemaFromDirTree(proj
                .getProjectSchemaDir().getAbsolutePath(), proj
                .getString(UIConsts.PROJ_PREF_ENCODING), false, false);
    }
}

class DbSourceFile extends DbSource {

    final private String filename;

    final private String encoding;

    DbSourceFile(String filename, String encoding) {
        super(filename);

        this.filename = filename;
        this.encoding = encoding;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor) {
        SubMonitor.convert(monitor, 1).newChild(1).subTask("Loading dump...");

        return PgDumpLoader.loadDatabaseSchemaFromDump(filename, encoding,
                false, false);
    }
}

class DbSourceDb extends DbSource {

    final private String exePgdump;

    final private String host, user, pass, dbname, encoding;
    final private int port;

    DbSourceDb(String exePgdump, PgDbProject props) {
        this(exePgdump, props.getString(UIConsts.PROJ_PREF_DB_HOST), props
                .getInt(UIConsts.PROJ_PREF_DB_PORT), props
                .getString(UIConsts.PROJ_PREF_DB_USER), props
                .getString(UIConsts.PROJ_PREF_DB_PASS), props
                .getString(UIConsts.PROJ_PREF_DB_NAME), props
                .getString(UIConsts.PROJ_PREF_ENCODING));
    }

    DbSourceDb(String exePgdump, String host, int port, String user,
            String pass, String dbname, String encoding) {
        super((dbname.isEmpty() ? "unknown_db" : dbname) + "@"
                + (host.isEmpty() ? "unknown_host" : host));

        this.exePgdump = exePgdump;
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.dbname = dbname;
        this.encoding = encoding;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor) throws IOException {
        SubMonitor pm = SubMonitor.convert(monitor, 2);

        try (TempFile tf = new TempFile("tmp_dump_", ".sql")) {
            File dump = tf.get();

            pm.newChild(1).subTask("Executing pg_dump...");

            new PgDumper(exePgdump, host, port, user, pass, dbname, encoding,
                    dump.getAbsolutePath()).pgDump();

            pm.newChild(1).subTask("Loading dump...");

            return PgDumpLoader.loadDatabaseSchemaFromDump(
                    dump.getAbsolutePath(), encoding, false, false);
        }
    }
}

class DbSourceFilter extends DbSource {

    final DbSource src;

    final TreeElement filter;

    final DiffSide side;

    DbSourceFilter(DbSource src, TreeElement filter, DiffSide side) {
        super("Filter on " + src.getOrigin());
        this.src = src;
        this.filter = filter;
        this.side = side;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor) throws IOException {
        PgDatabase db;
        try {
            db = src.getDbObject();
        } catch (NullPointerException ex) {
            db = src.get(monitor);
        }

        return new PgDbFilter2(db, filter, side).apply();
    }
}