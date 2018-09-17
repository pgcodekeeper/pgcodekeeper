package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;

public class DbInfo {

    /**
     * @deprecated legacy
     */
    @Deprecated
    private static final int DBINFO_LINE_PARTS_COUNT = 6;
    /**
     * @deprecated legacy
     * Delimiter for spacing parts of the coordinates.
     */
    @Deprecated
    private static final String DELIM = "\t"; //$NON-NLS-1$
    /**
     * @deprecated legacy <br>
     * Delimiter between coords entries in the preference string.
     */
    @Deprecated
    private static final String DELIM_ENTRY = "\n"; //$NON-NLS-1$

    private final String name;
    private final String dbname;
    private final String dbuser;
    private final String dbpass;
    private final String dbhost;
    private final int dbport;
    private final boolean readOnly;
    private final boolean msSql;
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

    public boolean isMsSql() {
        return msSql;
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

    public DbInfo(String name, String dbname, String dbuser, String dbpass,
            String dbhost, int dbport, boolean readOnly, boolean generateName,
            List<String> ignoreFiles, Map<String, String> properties, boolean msSql) {
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
    }

    /**
     * @deprecated changed to xml history, remove in future
     * @since 4.3.3
     */
    @Deprecated
    private DbInfo(String coords) {
        String[] parts = coords.split(DELIM, -1);

        try {
            if(parts.length > DBINFO_LINE_PARTS_COUNT) {
                throw new ArrayIndexOutOfBoundsException(
                        Messages.dbInfo_too_many_parts_in_dbinfo_string);
            }
            // SONAR-OFF
            this.name = parts[0];
            this.dbname = parts[1];
            this.dbuser = parts[2];
            this.dbpass = parts[3];
            this.dbhost = parts[4];
            this.dbport = Integer.parseInt(parts[5]);
            this.readOnly = false;
            this.msSql = false;
            this.generateName = false;
            this.ignoreFiles = new ArrayList<>();
            this.properties = new HashMap<>();
            // SONAR-ON
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            throw new IllegalArgumentException(
                    MessageFormat.format(Messages.dbInfo_bad_dbinfo_string, coords), ex);
        }
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

    public static List<DbInfo> readStoreFromXml(String preference) {
        try {
            return DbXmlStore.INSTANCE.readObjects();
        } catch (IOException e) {
            // check old prefs, legacy
            return preferenceToStore(preference);
        }
    }

    public static DbInfo getLastDb(String preference) {
        try {
            return preference.contains(DELIM) ? getLastStore(preference) :
                DbXmlStore.INSTANCE.readObjects().stream()
                .filter(e -> preference.equals(e.getName())).findAny().orElse(null);
        } catch (IOException ex) {
            // check old prefs, legacy
            return preferenceToStore(Activator.getDefault().getPreferenceStore().getString(PREF.DB_STORE)).stream()
                    .filter(info -> preference.equals(info.getName())).findAny().orElse(null);
        }
    }

    /**
     * @deprecated use {@link #getLastDb} instead, remove in future
     * @since 4.3.3
     */
    @Deprecated
    public static DbInfo getLastStore(String preference) {
        try {
            return new DbInfo(preference);
        } catch (IllegalArgumentException ex) {
            Log.log(ex);
        }
        return null;
    }

    /**
     * @deprecated changed to xml history, remove in future
     * @since 4.3.3
     */
    @Deprecated
    public static List<DbInfo> preferenceToStore(String preference) {
        LinkedList<DbInfo> store = new LinkedList<>();
        String[] coordStrings = preference.split(DELIM_ENTRY);
        for(String coords : coordStrings) {
            try {
                if (!coords.isEmpty()) {
                    store.add(new DbInfo(coords));
                }
            } catch(IllegalArgumentException ex) {
                // just ignore broken entries
                // the store won't have them in and they will be consequently deleted from preferences
                Log.log(ex);
            }
        }
        return store;
    }

    public void appendIgnoreFiles(IgnoreList ignoreList) {
        for (String file : getIgnoreFiles()) {
            InternalIgnoreList.readAppendList(Paths.get(file), ignoreList);
        }
    }
}