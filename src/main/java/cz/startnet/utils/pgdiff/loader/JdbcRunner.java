package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JdbcRunner {
    private JdbcConnector connector;

    public JdbcRunner(JdbcConnector connector) {
        this.connector = connector;
    }
    
    public String runScript(final String script) throws IOException{
        try(Connection connection = connector.getConnection(); Statement stmnt = connection.createStatement();){
            
            Future<String> queryFuture = Executors.newCachedThreadPool().submit(
                    new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            stmnt.execute(script);
                            return "success";
                        }
                    });
            
            try {
                return queryFuture.get();
            } catch (InterruptedException e) {
                // user hit stop script button
                try {
                    stmnt.cancel();
                } catch (SQLException e1) {
                    return "Script execution was not interrupted, it is likely still alive in background";
                }
                return "Script execution interrupted by user.";
            } catch (ExecutionException e) {
                // exception thrown in callable's call() method
                return e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
            }
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }
}
