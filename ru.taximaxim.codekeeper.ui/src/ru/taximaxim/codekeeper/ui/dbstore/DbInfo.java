package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;

public class DbInfo {

    public static final String DEFAULT_EXECUTE_PATH = "pg_dump"; //$NON-NLS-1$
    public static final String DEFAULT_CUSTOM_PARAMS = "--schema-only --no-password"; //$NON-NLS-1$

    private final String name;
    private final String dbname;
    private final String dbuser;
    private final String dbpass;
    private final String dbhost;
    private final int dbport;
    private final String pgdumpExePath;
    private final String pgdumpCustomParams;
    private final boolean pgDumpSwitch;
    private final boolean readOnly;
    private final boolean winAuth;
    private final boolean msSql;
    private final String domain;
    private final boolean generateName;
    private final List<String> ignoreFiles;
    private final Map<String, String> properties;

    public String getName() {
        return name;
    }

    public String getDbName() {
        return dbname;
    }

    public String getDbUser() {
        return dbuser;
    }

    public String getDbPass() {
        return dbpass;
    }

    public String getDbHost() {
        return dbhost;
    }

    public int getDbPort() {
        return dbport;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public boolean isWinAuth() {
        return winAuth;
    }

    public boolean isMsSql() {
        return msSql;
    }

    public String getDomain() {
        return domain;
    }

    public boolean isGeneratedName() {
        return generateName;
    }

    public List<String> getIgnoreFiles() {
        return ignoreFiles;
    }

    public Map<String, String> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    public String getPgdumpExePath() {
        return pgdumpExePath;
    }

    public String getPgdumpCustomParams() {
        return pgdumpCustomParams;
    }

    public boolean isPgDumpSwitch() {
        return pgDumpSwitch;
    }

    public DbInfo(String name, String dbname, String dbuser, String dbpass,
            String dbhost, int dbport, boolean readOnly, boolean generateName,
            List<String> ignoreFiles, Map<String, String> properties, boolean msSql, boolean winAuth,
            String domain, String pgdumpExePath, String pgdumpCustomParams, boolean pgDumpSwitch) {
        this.name = name;
        this.dbname = dbname;
        this.dbuser = dbuser;
        this.dbpass = dbpass;
        this.dbhost = dbhost;
        this.dbport = dbport;
        this.readOnly = readOnly;
        this.generateName = generateName;
        this.ignoreFiles = ignoreFiles;
        this.properties = properties;
        this.msSql = msSql;
        this.winAuth = winAuth;
        this.domain = domain;
        this.pgdumpExePath = pgdumpExePath == null ? DEFAULT_EXECUTE_PATH : pgdumpExePath;
        this.pgdumpCustomParams = pgdumpCustomParams == null ? DEFAULT_CUSTOM_PARAMS : pgdumpCustomParams;
        this.pgDumpSwitch = pgDumpSwitch;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DbInfo)) {
            return false;
        }
        DbInfo other = (DbInfo) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public static List<DbInfo> readStoreFromXml() {
        try {
            return DbXmlStore.INSTANCE.readObjects();
        } catch (IOException e) {
            Log.log(e);
        }

        return new ArrayList<>();
    }

    public static DbInfo getLastDb(String preference) {
        try {
            return DbXmlStore.INSTANCE.readObjects().stream()
                    .filter(e -> preference.equals(e.getName())).findAny().orElse(null);
        } catch (IOException ex) {
            Log.log(ex);
        }

        return null;
    }

    public void appendIgnoreFiles(IgnoreList ignoreList) {
        for (String file : getIgnoreFiles()) {
            InternalIgnoreList.readAppendList(Paths.get(file), ignoreList);
        }
    }
}