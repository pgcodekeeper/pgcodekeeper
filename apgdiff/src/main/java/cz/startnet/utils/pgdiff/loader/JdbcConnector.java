package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Map;
import java.util.Properties;

import org.osgi.framework.BundleContext;

import ru.taximaxim.codekeeper.apgdiff.Activator;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.pgpass.PgPass;
import ru.taximaxim.pgpass.PgPassException;

public class JdbcConnector {

    protected String host;
    protected int port;
    protected String user;
    protected String pass;
    protected String dbName;
    protected String url;

    protected Map<String, String> properties;
    protected String timezone;
    protected boolean readOnly;

    /**
     * @throws IllegalArgumentException url isn't valid
     */
    public static String dbNameFromUrl(String url) {
        return fromUrl(url).dbName;
    }

    /**
     * @throws IllegalArgumentException url isn't valid
     */
    public static JdbcConnector fromUrl(String url) {
        try {
            if (url.startsWith("jdbc:postgresql:")) {
                return new JdbcConnector(url);
            } else if (url.startsWith("jdbc:sqlserver:")) {
                return new JdbcMsConnector(url);
            }
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException(ex.getLocalizedMessage(), ex);
        }
        throw new IllegalArgumentException(
                "Unknown url schema, supported schemas are 'postgresql' and 'sqlserver'");
    }

    private static String urlDecode(String encoded) {
        try {
            return URLDecoder.decode(encoded, ApgdiffConsts.UTF_8);
        } catch (UnsupportedEncodingException ex) {
            Log.log(ex);
            return encoded;
        }
    }

    public JdbcConnector(String host, int port, String user, String pass, String dbName, String timezone) {
        this(host, port, user, pass, dbName, null, false, timezone);
    }

    public JdbcConnector(String host, int port, String user, String pass, String dbName,
            Map<String, String> properties, boolean readOnly, String timezone) {
        this.host = host;
        this.port = port < 1 ? ApgdiffConsts.JDBC_CONSTS.JDBC_DEFAULT_PORT : port;
        this.dbName = dbName;
        this.user = user.isEmpty() ? System.getProperty("user.name") : user;
        this.pass = pass == null || pass.isEmpty() ? getPgPassPassword() : pass;
        this.url = generateBasicConnectionString();

        this.timezone = timezone;
        this.properties = properties;
        this.readOnly = readOnly;
    }

    protected JdbcConnector() {
        // no impl, unintialized instance
    }

    private JdbcConnector(String url) throws URISyntaxException {
        this.url = url;
        this.timezone = ApgdiffConsts.UTC;

        String host = null, user = null, pass = null, dbName = null;
        int port = -1;
        // strip jdbc:, URI doesn't understand schemas with colons
        URI uri = new URI(url.substring(5));

        if (uri.isOpaque()) {
            // special case for jdbc:postgres:database_name
            dbName = uri.getSchemeSpecificPart();
        } else {
            host = uri.getHost();
            port = uri.getPort();
            dbName = uri.getPath();
            if (dbName != null && !dbName.isEmpty()) {
                // strip leading /
                dbName = dbName.substring(1);
            }

            String query = uri.getRawQuery();
            if (query != null) {
                for (String param : query.split("&")) {
                    int eq = param.indexOf('=');
                    if (eq != -1) {
                        String key = urlDecode(param.substring(0, eq));
                        String val = urlDecode(param.substring(eq + 1));
                        switch (key) {
                        case "user":
                            user = val;
                            break;
                        case "password":
                            pass = val;
                            break;
                        default:
                            break;
                        }
                    }
                }
            }
        }
        this.host = host == null ? "" : host;
        this.port = port < 1 ? ApgdiffConsts.JDBC_CONSTS.JDBC_DEFAULT_PORT : port;
        this.dbName = dbName == null ? "" : dbName;
        this.user = user == null || user.isEmpty() ? System.getProperty("user.name") : user;
        this.pass = pass == null || pass.isEmpty() ? getPgPassPassword() : pass;
    }

    /**
     * @return connection string derived from {@link #host}, {@link #port}
     *          and {@link #dbName}
     */
    protected String generateBasicConnectionString() {
        String db;
        try {
            db = URLEncoder.encode(dbName, ApgdiffConsts.UTF_8);
        } catch (UnsupportedEncodingException ex) {
            Log.log(ex);
            db = dbName;
        }
        return "jdbc:postgresql://" + host + ':' + port + '/' + db;
    }

    /**
     * Creates new connection instance with params specified in constructor.<br>
     * It is the caller responsibility to close connection.
     *
     * @return new connection
     * @throws IOException  If driver not found or a database access error occurs
     */
    public Connection getConnection() throws IOException{
        try{
            Connection connection = establishConnection();
            connection.setReadOnly(readOnly);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new IOException(MessageFormat.format(
                    Messages.Connection_JdbcDriverClassNotFound, e.getLocalizedMessage()), e);
        } catch (SQLException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    private Connection establishConnection() throws SQLException, ClassNotFoundException {
        Log.log(Log.LOG_INFO, "Establishing JDBC connection with host:port " +
                host + ":" + port + ", db name " + dbName + ", username " + user);
        return DriverManager.getConnection(url, makeProperties());
    }

    protected Properties makeProperties() {
        Properties props = new Properties();

        if (properties != null) {
            properties.entrySet().forEach(entry -> props.setProperty(entry.getKey(), entry.getValue()));
        }

        props.setProperty("user", user);
        props.setProperty("password", pass);

        String apgdiffVer = "unknown";
        BundleContext bctx = Activator.getContext();
        if (bctx != null) {
            apgdiffVer = bctx.getBundle().getVersion().toString();
        }
        props.setProperty("ApplicationName", "pgCodeKeeper apgdiff module, Bundle-Version: " + apgdiffVer);

        return props;
    }

    String getTimezone(){
        return timezone;
    }

    private String getPgPassPassword(){
        Log.log(Log.LOG_INFO, "User provided an empty password. Reading password from pgpass file."); //$NON-NLS-1$

        try {
            String pass = PgPass.get(host, String.valueOf(port), dbName, user);
            if (pass != null) {
                return pass;
            }
        } catch (PgPassException e) {
            Log.log(e);
        }

        Log.log(Log.LOG_INFO, "Using empty password, because no password has been found " //$NON-NLS-1$
                + "in pgpass file for " + host + ":" + port + ":" + dbName + ":" + user); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        return "";
    }
}
