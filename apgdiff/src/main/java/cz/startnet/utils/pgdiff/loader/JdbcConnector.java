package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

import org.osgi.framework.BundleContext;

import ru.taximaxim.codekeeper.apgdiff.Activator;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public class JdbcConnector {

    private final String host;
    private final int port;
    private final String user;
    private final String pass;
    private final String dbName;
    private final String url;

    private final String encoding;
    private final String timezone;
    private Charset charset;

    public JdbcConnector(String host, int port, String user, String pass, String dbName,
            String encoding, String timezone) {
        this.host = host;
        this.port = port == 0 ? ApgdiffConsts.JDBC_CONSTS.JDBC_DEFAULT_PORT : port;
        this.dbName = dbName;
        this.user = user.isEmpty() ? System.getProperty("user.name") : user;
        this.pass = (pass == null || pass.isEmpty()) ? getPgPassPassword() : pass;
        this.url = "jdbc:postgresql://" + host + ":" + this.port + "/" + dbName;

        this.encoding = encoding;
        this.timezone = timezone;
    }

    public JdbcConnector(String url) throws URISyntaxException {
        this.url = url;
        this.encoding = ApgdiffConsts.UTF_8;
        this.timezone = ApgdiffConsts.UTC;

        String host = null, user = null, pass = null, dbName = null;
        int port = -1;
        if (url.startsWith("jdbc:postgresql:")) {
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

                String query = uri.getQuery();
                if (query != null) {
                    for (String param : query.split("&")) {
                        int eq = param.indexOf('=');
                        if (eq != -1) {
                            String key = param.substring(0, eq);
                            String val = param.substring(eq + 1);
                            switch (key) {
                            case "user":
                                user = val;
                                break;
                            case "password":
                                pass = val;
                                break;
                            }
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
     * Creates new connection instance with params specified in constructor.<br>
     * It is the caller responsibility to close connection.
     *
     * @return new connection
     * @throws IOException  If driver not found or a database access error occurs
     */
    Connection getConnection() throws IOException{
        this.charset = Charset.forName(encoding);
        try{
            return establishConnection();
        } catch (ClassNotFoundException e) {
            throw new IOException(MessageFormat.format(
                    Messages.Connection_JdbcDriverClassNotFound, e.getLocalizedMessage()), e);
        } catch (SQLException e) {
            throw new IOException(MessageFormat.format(
                    Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), Messages.JdbcConnector_in_jdbc_connection), e);
        }
    }

    private Connection establishConnection() throws SQLException, ClassNotFoundException {
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pass);
        String apgdiffVer = "unknown";
        BundleContext bctx = Activator.getContext();
        if (bctx != null) {
            apgdiffVer = bctx.getBundle().getVersion().toString();
        }
        props.setProperty("ApplicationName", "pgCodeKeeper apgdiff module, Bundle-Version: " + apgdiffVer);

        Class.forName(ApgdiffConsts.JDBC_CONSTS.JDBC_DRIVER);
        Log.log(Log.LOG_INFO, "Establishing JDBC connection with host:port " +
                host + ":" + port + ", db name " + dbName + ", username " + user);
        return DriverManager.getConnection(url, props);
    }

    public String getEncoding() {
        return encoding;
    }

    /**
     * @return {@link Charset} for {@link #encoding}, or null, if {@link #getConnection()}
     *          wasn't called yet.
     */
    public Charset getCharset() {
        return charset;
    }

    String getTimezone(){
        return timezone;
    }

    private String getPgPassPassword(){
        Log.log(Log.LOG_INFO, "User provided an empty password. Reading password from pgpass file."); //$NON-NLS-1$
        File pgPassFile;
        if (System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH).contains("win")){ //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            pgPassFile = new File(System.getenv("APPDATA"),"\\postgresql\\pgpass.conf"); //$NON-NLS-1$ //$NON-NLS-2$
        }else{
            pgPassFile = new File(System.getProperty("user.home"), "/.pgpass"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        Log.log(Log.LOG_INFO, "pgpass file will be read at " + pgPassFile.getAbsolutePath()); //$NON-NLS-1$

        if (!pgPassFile.isFile() || !pgPassFile.exists()){
            Log.log(Log.LOG_INFO, "Using empty password, because pgpass file either " //$NON-NLS-1$
                    + "does not exist or is not a file: " + pgPassFile.getAbsolutePath()); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }

        String [] expectedTokens = {host, String.valueOf(port), dbName, user};
        try (Scanner sc = new Scanner(pgPassFile)){
            sc.useDelimiter(":|\n"); //$NON-NLS-1$
            while (sc.hasNextLine()) {
                int tokenCounter = 0;

                while (sc.hasNext()) {
                    if (tokenCounter > 3) {
                        return sc.skip(":").nextLine(); //$NON-NLS-1$
                    }

                    String token = sc.next();
                    if (!token.equals(expectedTokens[tokenCounter++]) && !token.equals("*")) { //$NON-NLS-1$
                        break;
                    }
                }
                sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            Log.log(e);
            return "";
        }
        Log.log(Log.LOG_INFO, "Using empty password, because no password has been found " //$NON-NLS-1$
                + "in pgpass file for " + host + ":" + port + ":" + dbName + ":" + user); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        return ""; //$NON-NLS-1$
    }
}
