package ru.taximaxim.codekeeper.ui.differ;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.PgDbFilter2;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.UIConsts;
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
        if(dbObject == null) {
            throw new NullPointerException("DB is not loaded yet, object is null!");
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
    
    protected abstract PgDatabase loadInternal(SubMonitor monitor) throws IOException;

    public static DbSource fromDirTree(String dirTreePath, String encoding) {
        return new DbSourceDirTree(dirTreePath, encoding);
    }
    
    public static DbSource fromSvn(String svnExec, PgDbProject proj) {
        return new DbSourceSvn(svnExec, proj);
    }
    
    public static DbSource fromSvn(String svnExec, PgDbProject proj, String rev) {
        return new DbSourceSvn(svnExec, proj, rev);
    }
    
    public static DbSource fromSvn(String svnExec, String url, String user,
            String pass, String rev, String encoding) {
        return new DbSourceSvn(svnExec, url, user, pass, rev, encoding);
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
        return new DbSourceDb(exePgdump, host, port, user, pass, dbname, encoding);
    }
    
    public static DbSource fromFilter(DbSource src, TreeElement filter, DiffSide side) {
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
        SubMonitor.convert(monitor, 1).newChild(1).subTask("Loading tree");
        
        return PgDumpLoader.loadDatabaseSchemaFromDirTree(
                dirTreePath, encoding, false, false);
    }
}

class DbSourceSvn extends DbSource {
    
    final private SvnExec svn;
    
    final private String encoding;
    
    final private String rev;
    
    DbSourceSvn(String svnExec, PgDbProject proj) {
        this(svnExec, proj, null);
    }
    
    public DbSourceSvn(String svnExec, PgDbProject proj, String rev) {
        this(svnExec,
                proj.getString(UIConsts.PROJ_PREF_SVN_URL),
                proj.getString(UIConsts.PROJ_PREF_SVN_USER),
                proj.getString(UIConsts.PROJ_PREF_SVN_PASS),
                proj.getString(UIConsts.PROJ_PREF_ENCODING),
                rev);
    }
    
    DbSourceSvn(String svnExec, String url, String user, String pass,
            String rev, String encoding) {
        super(url + (rev.isEmpty()? "" : "@" + rev));
        
        svn = new SvnExec(svnExec, url, user, pass);
        
        this.encoding = encoding;
        this.rev = rev;
    }
    
    @Override
    protected PgDatabase loadInternal(SubMonitor monitor) throws IOException {
        SubMonitor pm = SubMonitor.convert(monitor, 2);
        
        try(TempDir tmpDir = new TempDir("tmp_svn_")) {
            File dir = tmpDir.get();
            
            pm.newChild(1).subTask("SVN rev checkout");
            svn.svnCo(dir, rev);
            
            pm.newChild(1).subTask("Loading tree");
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
        SubMonitor.convert(monitor, 1).newChild(1).subTask("Loading tree");
        
        return PgDumpLoader.loadDatabaseSchemaFromDirTree(
                proj.getProjectSchemaDir().getAbsolutePath(),
                proj.getString(UIConsts.PROJ_PREF_ENCODING), false, false);
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
        SubMonitor.convert(monitor, 1).newChild(1).subTask("Loading dump");
        
        return PgDumpLoader.loadDatabaseSchemaFromDump(
                filename, encoding, false, false);
    }
}

class DbSourceDb extends DbSource {
    
    final private String exePgdump;
    
    final private String host, user, pass, dbname, encoding;
    final private int port;

    DbSourceDb(String exePgdump, PgDbProject props) {
        this(exePgdump,
                props.getString(UIConsts.PROJ_PREF_DB_HOST),
                props.getInt(UIConsts.PROJ_PREF_DB_PORT),
                props.getString(UIConsts.PROJ_PREF_DB_USER),
                props.getString(UIConsts.PROJ_PREF_DB_PASS),
                props.getString(UIConsts.PROJ_PREF_DB_NAME),
                props.getString(UIConsts.PROJ_PREF_ENCODING));
    }
    
    DbSourceDb(String exePgdump, String host, int port,
            String user, String pass, String dbname, String encoding) {
        super((host.isEmpty() && dbname.isEmpty())? "Undisclosed DB"
                : (host.isEmpty()? dbname + "@unknown_host"
                        : (dbname.isEmpty() ? "unknown_db@" + host
                                : dbname + "@" + host)));
        
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
        
        try(TempFile tf = new TempFile("tmp_dump_", ".sql")) {
            File dump = tf.get();
            
            pm.newChild(1).subTask("Executing pg_dump");
            
            new PgDumper(exePgdump,
                    host, port, user, pass, dbname, encoding,
                    dump.getAbsolutePath())
                .pgDump();
            
            pm.newChild(1).subTask("Loading dump");

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