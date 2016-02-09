package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private final String encoding;
    private final String timezone;

    public JdbcConnector(String host, int port, String user, String pass, String dbName, String encoding, String timezone){
        this.host = host;
        this.port = port == 0 ? ApgdiffConsts.JDBC_CONSTS.JDBC_DEFAULT_PORT : port;
        this.user = user.isEmpty() ? System.getProperty("user.name") : user; //$NON-NLS-1$
        this.dbName = dbName;
        this.encoding = encoding;
        this.timezone = timezone;
        this.pass = (pass == null || pass.isEmpty()) ? getPgPassPassword() : pass;
    }

    /**
     * Creates new connection instance with params specified in constructor.<br>
     * It is the caller responsibility to close connection.
     *
     * @return new connection
     * @throws IOException  If driver not found or a database access error occurs
     */
    Connection getConnection() throws IOException{
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
        props.setProperty("user", user); //$NON-NLS-1$
        props.setProperty("password", pass); //$NON-NLS-1$
        String apgdiffVer = "unknown"; //$NON-NLS-1$
        BundleContext bctx = Activator.getContext();
        if (bctx != null) {
            apgdiffVer = bctx.getBundle().getVersion().toString();
        }
        props.setProperty("ApplicationName", "pgCodeKeeper apgdiff module, Bundle-Version: " + apgdiffVer); //$NON-NLS-1$ //$NON-NLS-2$

        Class.forName(ApgdiffConsts.JDBC_CONSTS.JDBC_DRIVER);
        Log.log(Log.LOG_INFO, "Establishing JDBC connection with host:port " +  //$NON-NLS-1$
                host + ":" + port + ", db name " + dbName + ", username " + user); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://" + host + ":" + port + "/" + dbName, props); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return connection;
    }

    String getEncoding(){
        return encoding;
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
            throw new IllegalStateException(MessageFormat.format(
                    Messages.jdbcConnector_error_reading_pgpass_file,
                    e.getLocalizedMessage()), e);
        }
        Log.log(Log.LOG_INFO, "Using empty password, because no password has been found " //$NON-NLS-1$
                + "in pgpass file for " + host + ":" + port + ":" + dbName + ":" + user); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        return ""; //$NON-NLS-1$
    }
}
