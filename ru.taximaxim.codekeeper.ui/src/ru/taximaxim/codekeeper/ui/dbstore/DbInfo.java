package ru.taximaxim.codekeeper.ui.dbstore;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbInfo {

    private static final int DBINFO_LINE_PARTS_COUNT = 6;
    /**
     * Delimiter for spacing parts of the coordinates.
     */
    private static final char DELIM = '\t';
    /**
     * Delimiter between coords entries in the preference string.
     */
    private static final char DELIM_ENTRY = '\n';

    String name;
    String dbname;
    String dbuser;
    String dbpass;
    String dbhost;
    int dbport;

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
        String[] parts = coords.split(Pattern.quote(String.valueOf(DELIM)), -1);

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

    public static DbInfo getEmpty(String name) {
        return new DbInfo(name, "", "", "", "", 0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    }

    public static DbInfo getEmptyNamed(String name) {
        return new DbInfo(name, name, "", "", "", 0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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

    public static Map<String, DbInfo> preferenceToStore(String preference) {
        String[] coordStrings = preference.split(
                Pattern.quote(String.valueOf(DELIM_ENTRY)));

        // use LinkedHashmap for insertion-order iteration
        Map<String, DbInfo> store = new LinkedHashMap<>(coordStrings.length);
        for(String coords : coordStrings) {
            try {
                DbInfo c = new DbInfo(coords);
                store.put(c.name, c);
            } catch(IllegalArgumentException ex) {
                // just ignore broken entries
                // the store won't have them in and they will be consequently deleted from preferences
                Log.log(ex);
            }
        }

        return store;
    }

    public static String storeToPreference(Map<String, DbInfo> store, List<String> list) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String entry : list) {
            sb.append(store.get(entry));
            if (count++ < list.size() - 1) {
                sb.append(DELIM_ENTRY);
            }
        }
        return sb.toString();
    }

    public static String storeToPreference(Map<String, DbInfo> store) {
        StringBuilder sb = new StringBuilder();

        for (DbInfo info : store.values()){
            sb.append(info);
            sb.append(DELIM_ENTRY);
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }

    public String getName(){
        return name;
    }
}