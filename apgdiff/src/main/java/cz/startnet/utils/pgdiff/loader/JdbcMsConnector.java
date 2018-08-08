package cz.startnet.utils.pgdiff.loader;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JdbcMsConnector extends JdbcConnector {

    private static final int DEFAULT_PORT = 1433;
    private static final Pattern PATTERN_PROPERTIES =
            Pattern.compile(";(?:(\\w+)=(\\w+|\\{[^}]*\\})?)?");

    private static String unescapeValue(String val) {
        if (val.length() > 1 && val.charAt(0) == '{') {
            // strip escape braces
            return val.substring(1, val.length() - 1);
        }
        return val;
    }

    public JdbcMsConnector(String host, int port, String user, String pass, String dbName,
            String timezone) {
        this(host, port, user, pass, dbName, null, false, timezone);
    }

    public JdbcMsConnector(String host, int port, String user, String pass, String dbName,
            Map<String, String> properties, boolean readOnly, String timezone) {
        this.host = host;
        this.port = port < 1 ? DEFAULT_PORT : port;
        this.dbName = dbName;
        this.user = user;
        this.pass = pass == null ? "" : pass;
        this.url = generateBasicConnectionString();

        this.timezone = timezone;
        this.properties = properties;
        this.readOnly = readOnly;
    }

    protected JdbcMsConnector(String url, String timezone) throws URISyntaxException {
        this.url = url;
        this.timezone = timezone;

        // strip jdbc:, URI doesn't understand schemas with colons
        String uriPart = url.substring(5);
        int semic = uriPart.indexOf(';');
        if (semic > -1) {
            Matcher m = PATTERN_PROPERTIES.matcher(uriPart.substring(semic));

            // strip properties string from URI text
            uriPart = uriPart.substring(0, semic);

            while (m.find()) {
                if (m.groupCount() < 2) {
                    // 0 = no groups, only lone semicolon matched
                    // 1 = no value, not interested
                    continue;
                }
                String s = m.group(1).toLowerCase();
                switch (s) {
                case "user":
                case "username":
                    this.user = unescapeValue(m.group(2));
                    break;
                case "password":
                    this.pass = unescapeValue(m.group(2));
                    break;
                case "database":
                case "databasename":
                    this.dbName = unescapeValue(m.group(2));
                    break;
                default:
                    break;
                }
            }
        }
        URI uri = new URI(uriPart);
        int port = uri.getPort();

        this.host = uri.getHost();
        this.port = port < 1 ? DEFAULT_PORT : port;

        if (dbName == null) {
            dbName = "";
        }
        if (user == null) {
            user = "";
        }
        if (pass == null) {
            pass = "";
        }
    }

    @Override
    protected String generateBasicConnectionString() {
        return "jdbc:sqlserver://" + host + ':' + port
                + (isDbNameEscapable() ? ";databaseName={" + dbName + '}' : "") ;
    }

    @Override
    protected Properties makeProperties() {
        Properties props = super.makeProperties();
        if (!isDbNameEscapable()) {
            props.setProperty("databaseName", dbName);
        }
        return props;
    }

    private boolean isDbNameEscapable() {
        return dbName.indexOf('}') < 0;
    }
}
