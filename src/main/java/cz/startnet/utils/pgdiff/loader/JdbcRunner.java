package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcRunner {
    private JdbcConnector connector;

    public JdbcRunner(JdbcConnector connector) {
        this.connector = connector;
    }
    
    public String runScript(String script) throws IOException{
        try(Connection connection = connector.getConnection(); Statement stmnt = connection.createStatement();){
            stmnt.execute(script);
            return "success";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
