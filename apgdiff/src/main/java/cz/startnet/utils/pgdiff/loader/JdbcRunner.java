package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class JdbcRunner {
    private final JdbcConnector connector;

    public JdbcRunner(JdbcConnector connector) {
        this.connector = connector;
    }

    public String runScript(final String script) throws IOException{
        try (Connection connection = connector.getConnection();
                Statement stmnt = connection.createStatement();) {
            stmnt.setEscapeProcessing(false);

            try {
                Future<String> queryFuture = Executors.newCachedThreadPool().submit(
                        new Callable<String>() {

                            @Override
                            public String call() throws Exception {
                                stmnt.execute(script);
                                return JDBC_CONSTS.JDBC_SUCCESS;
                            }
                        });

                return queryFuture.get();
            } catch (InterruptedException e) {
                // user hit stop script button
                try {
                    stmnt.cancel();
                } catch (SQLException e1) {
                    return "Script execution was not interrupted, it is likely still alive in background";
                }
                return "Script execution interrupted.";
            } catch (ExecutionException e) {
                // exception thrown in callable's call() method
                Throwable t = e.getCause();
                if (t instanceof SQLException) {
                    // log just in case it's not an SQL execution error
                    Log.log(e);
                    return t.getMessage();
                } else {
                    throw new IOException(t.getLocalizedMessage(), e);
                }
            }
        } catch (SQLException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }
}
