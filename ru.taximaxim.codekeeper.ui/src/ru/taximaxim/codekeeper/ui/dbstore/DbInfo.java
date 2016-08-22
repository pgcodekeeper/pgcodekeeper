package ru.taximaxim.codekeeper.ui.dbstore;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbInfo {

    private static final int DBINFO_LINE_PARTS_COUNT = 6;
    /**
     * Delimiter for spacing parts of the coordinates.
     */
    private static final String DELIM = "\t";
    /**
     * Delimiter between coords entries in the preference string.
     */
    private static final String DELIM_ENTRY = "\n";

    final String name;
    final String dbname;
    final String dbuser;
    final String dbpass;
    final String dbhost;
    final int dbport;

    public String getName() {
        return name;
    }

    public DbInfo(String name, String dbname, String dbuser, String dbpass,
            String dbhost, int dbport) {
        this.name = name;
        this.dbname = dbname;
        this.dbuser = dbuser;
        this.dbpass = dbpass;
        this.dbhost = dbhost;
        this.dbport = dbport;
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
                + DBINFO_LINE_PARTS_COUNT * 2);
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
        .append(dbport);

        return sb.toString();
    }

    public static LinkedList<DbInfo> preferenceToStore(String preference) {
        LinkedList<DbInfo> store = new LinkedList<>();
        String[] coordStrings = preference.split(DELIM_ENTRY);
        for(String coords : coordStrings) {
            try {
                store.add(new DbInfo(coords));
            } catch(IllegalArgumentException ex) {
                // just ignore broken entries
                // the store won't have them in and they will be consequently deleted from preferences
                Log.log(ex);
            }
        }
        return store;
    }

    public static String storeToPreference(List<DbInfo> store) {
        StringBuilder sb = new StringBuilder();
        for (DbInfo entry : store) {
            sb.append(entry).append(DELIM_ENTRY);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}