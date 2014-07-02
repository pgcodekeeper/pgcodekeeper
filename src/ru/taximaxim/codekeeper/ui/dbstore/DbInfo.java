package ru.taximaxim.codekeeper.ui.dbstore;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbInfo {
    
    /**
     * Delimiter for spacing parts of the coordinates.
     */
    private final static char d = '\t';
    
    /**
     * Delimiter between coords entries in the preference string.
     */
    private final static char d_entries = '\n';
    
    public final String name;
    
    public String dbname;
    public String dbuser;
    public String dbpass;
    public String dbhost;
    public int dbport;
    
    public DbInfo(String name, String dbname, String dbuser, String dbpass,
            String dbhost, int dbport) {
        this.name = name;
        this.dbname = dbname;
        this.dbuser = dbuser;
        this.dbpass = dbpass;
        this.dbhost = dbhost;
        this.dbport = dbport;
    }
    
    public DbInfo(String coords) {
        String[] parts = coords.split(Pattern.quote(String.valueOf(d)), -1);
        
        try {
            if(parts.length > 6) {
                throw new ArrayIndexOutOfBoundsException(
                        Messages.DbInfo_too_many_parts_in_dbinfo_string);
            }
            
            this.name = parts[0];
            this.dbname = parts[1];
            this.dbuser = parts[2];
            this.dbpass = parts[3];
            this.dbhost = parts[4];
            this.dbport = Integer.parseInt(parts[5]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            throw new IllegalArgumentException(Messages.DbInfo_bad_dbinfo_string + coords, ex);
        }
    }
    
    public static DbInfo getEmpty(String name) {
        return new DbInfo(name, "", "", "", "", 0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                name.length()
                + dbname.length()
                + dbuser.length()
                + dbpass.length()
                + dbhost.length()
                + 6 + 6);
        sb.append(name)
            .append(d)
            .append(dbname)
            .append(d)
            .append(dbuser)
            .append(d)
            .append(dbpass)
            .append(d)
            .append(dbhost)
            .append(d)
            .append(dbport);
        
        return sb.toString();
    }
    
    public static Map<String, DbInfo> preferenceToStore(String preference) {
        String[] coordStrings = preference.split(
                Pattern.quote(String.valueOf(d_entries)));
        
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
    
    public static String storeToPreference(Map<String, DbInfo> store) {
        StringBuilder sb = new StringBuilder();
        
        Iterator<Entry<String, DbInfo>> it = store.entrySet().iterator();
        while(it.hasNext()) {
            sb.append(it.next().getValue());
            if(it.hasNext()) {
                sb.append(d_entries);
            }
        }
        
        return sb.toString();
    }
}