package cz.startnet.utils.pgdiff.loader;

import java.net.URISyntaxException;
import java.util.Map;

public class JdbcMsConnector extends JdbcConnector {

    public JdbcMsConnector(String host, int port, String user, String pass, String dbName,
            Map<String, String> properties, boolean readOnly, String timezone) {
        super(host, port, user, pass, dbName, properties, readOnly, timezone);
        // TODO Auto-generated constructor stub
    }

    public JdbcMsConnector(String host, int port, String user, String pass, String dbName,
            String timezone) {
        super(host, port, user, pass, dbName, timezone);
        // TODO Auto-generated constructor stub
    }

    public JdbcMsConnector(String url, Map<String, String> properties, boolean readOnly)
            throws URISyntaxException {
        super(url, properties, readOnly);
        // TODO Auto-generated constructor stub
    }

    public JdbcMsConnector(String url) throws URISyntaxException {
        super(url);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected String generateBasicConnectionString() {
        return "jdbc:sqlserver://" + host + ':' + port + ";databaseName=" + dbName;
    }
}
