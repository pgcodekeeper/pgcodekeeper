package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Scanner;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public class JdbcConnector {
    private String host;
    private int port;
    private String user;
    private String pass;
    private String dbName;
    private String encoding;
    private String timezone;
    
    public JdbcConnector(String host, int port, String user, String pass, String dbName, String encoding, String timezone){
        this.host = host;
        this.port = port == 0 ? ApgdiffConsts.JDBC_CONSTS.JDBC_DEFAULT_PORT : port;
        this.user = user.isEmpty() ? System.getProperty("user.name") : user;
        this.dbName = dbName;
        this.encoding = encoding;
        this.timezone = timezone;
        this.pass = pass.isEmpty() ? getPgPassPassword() : pass;
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
            throw new IOException(Messages.Connection_JdbcDriverClassNotFound, e);
        } catch (SQLException e) {
            throw new IOException(MessageFormat.format(
                    Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage()), e);
        }
    }
    
    private Connection establishConnection() throws SQLException, ClassNotFoundException{
        Class.forName(ApgdiffConsts.JDBC_CONSTS.JDBC_DRIVER);
        Log.log(Log.LOG_INFO, "Establishing JDBC connection with host:port " + 
                host + ":" + port + ", db name " + dbName + ", username " + user);
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://" + host + ":" + port + "/" + dbName, user, pass);
        return connection;
    }
    
    String getEncoding(){
        return encoding;
    }
    
    String getTimezone(){
        return timezone;
    }
    
    private String getPgPassPassword(){
        Log.log(Log.LOG_INFO, "User provided an empty password. Reading password from pgpass file.");
        File pgPassFile;
        if (System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH).contains("win")){
            pgPassFile = new File(System.getenv("APPDATA"),"\\postgresql\\pgpass.conf");
        }else{
            pgPassFile = new File(System.getProperty("user.home"), "/.pgpass");
        }
        Log.log(Log.LOG_INFO, "pgpass file will be read at " + pgPassFile.getAbsolutePath());

        if (!pgPassFile.isFile() || !pgPassFile.exists()){
            Log.log(Log.LOG_INFO, "Using empty password, because pgpass file either "
                    + "does not exist or is not a file: " + pgPassFile.getAbsolutePath());
            return "";
        }
        
        String [] expectedTokens = {host, String.valueOf(port), dbName, user};
        try (Scanner sc = new Scanner(pgPassFile)){
            sc.useDelimiter(":|\n");
            while (sc.hasNextLine()) {
                int tokenCounter = 0;

                while (sc.hasNext()) {
                    if (tokenCounter > 3) {
                        return sc.skip(":").nextLine();
                    }

                    String token = sc.next();
                    if (!token.equals(expectedTokens[tokenCounter++]) && !token.equals("*")) {
                        break;
                    }
                }
                sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Error reading pgpass file: "
                    + e.getLocalizedMessage(), e);
        }
        Log.log(Log.LOG_INFO, "Using empty password, because no password has been found "
                + "in pgpass file for " + host + ":" + port + ":" + dbName + ":" + user);
        return "";
    }
}
