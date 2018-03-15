package ru.taximaxim.codekeeper.ui.dbstore;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbInfo {

    private static final int DBINFO_LINE_PARTS_COUNT = 7;
    /**
     * Delimiter for spacing parts of the coordinates.
     */
    private static final String DELIM = "\t"; //$NON-NLS-1$
    /**
     * Delimiter between coords entries in the preference string.
     */
    static final String DELIM_ENTRY = "\n"; //$NON-NLS-1$

    private final String name;
    private final String dbname;
    private final String dbuser;
    private final String dbpass;
    private final String dbhost;
    private final int dbport;
    private final boolean readOnly;

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

    public DbInfo(String name, String dbname, String dbuser, String dbpass,
            String dbhost, int dbport) {
        this(name, dbname, dbuser, dbpass, dbhost, dbport, false);
    }

    public DbInfo(String name, String dbname, String dbuser, String dbpass,
            String dbhost, int dbport, boolean readOnly) {
        this.name = name;
        this.dbname = dbname;
        this.dbuser = dbuser;
        this.dbpass = dbpass;
        this.dbhost = dbhost;
        this.dbport = dbport;
        this.readOnly = readOnly;
    }

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
            this.readOnly = (parts.length == DBINFO_LINE_PARTS_COUNT - 1) ? false : Boolean.parseBoolean(parts[6]);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                name.length()
                + dbname.length()
                + dbuser.length()
                + dbpass.length()
                + dbhost.length()
                + DBINFO_LINE_PARTS_COUNT * 3);
        sb.append(name)
        .append(DELIM)
        .append(dbname)
        .append(DELIM)
        .append(dbuser)
        .append(DELIM)
        .append(dbpass)
        .append(DELIM)
        .append(dbhost)
        .append(DELIM)
        .append(dbport)
        .append(DELIM)
        .append(readOnly);

        return sb.toString();
    }


    public static List<DbInfo> readStoreFromXml(String preference) {
        List<DbInfo> store = DbStoreXml.INSTANCE.readStoreFromXml();
        if (store.isEmpty()) {
            // legacy
            return preferenceToStore(preference);
        }

        return store;
    }

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
    public static LinkedList<DbInfo> preferenceToStore(String preference) {
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
}