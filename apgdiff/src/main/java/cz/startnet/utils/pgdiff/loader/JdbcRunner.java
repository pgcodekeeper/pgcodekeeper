package cz.startnet.utils.pgdiff.loader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.loader.callables.QueryCallable;
import cz.startnet.utils.pgdiff.loader.callables.ResultSetCallable;
import cz.startnet.utils.pgdiff.loader.callables.StatementCallable;
import ru.taximaxim.codekeeper.apgdiff.DaemonThreadFactory;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class JdbcRunner {

    private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(2,
            Integer.MAX_VALUE, 0, TimeUnit.SECONDS, new SynchronousQueue<>(),
            new DaemonThreadFactory());

    private static final int SLEEP_TIME = 20;

    private static final String MESSAGE = "Script execution interrupted by user";

    private final IProgressMonitor monitor;


    public JdbcRunner() {
        this.monitor = new NullProgressMonitor();
    }

    public JdbcRunner(IProgressMonitor monitor) {
        this.monitor = monitor;
    }

    /**
     * execute prepared statement with no return value
     */
    public void run(PreparedStatement st) throws SQLException, InterruptedException {
        runScript(new QueryCallable(st));
    }

    /**
     * execute statement by given script with no return value
     */
    public void run(Statement st, String script) throws SQLException, InterruptedException {
        runScript(new QueryCallable(st, script));
    }

    /**
     * execute prepared statement and return result set
     */
    public ResultSet runScript(PreparedStatement st) throws InterruptedException, SQLException {
        return runScript(new ResultSetCallable(st));
    }

    /**
     * execute statement by given script and return result set
     */
    public ResultSet runScript(Statement st, String script) throws InterruptedException, SQLException {
        return runScript(new ResultSetCallable(st, script));
    }


    private <T> T runScript(StatementCallable<T> callable) throws InterruptedException, SQLException {
        Future<T> queryFuture = THREAD_POOL.submit(callable);

        while (!queryFuture.isDone()) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                //callable finished or unanticipated awakening
            }
            if (monitor.isCanceled()) {
                Log.log(Log.LOG_INFO, MESSAGE);
                callable.cancel();
                throw new InterruptedException(MESSAGE);
            }
        }
        try {
            return queryFuture.get();
        } catch (ExecutionException e) {
            Throwable t = e.getCause();
            if (t instanceof SQLException) {
                throw (SQLException)t;
            } else {
                throw new IllegalStateException(t.getLocalizedMessage(), e);
            }
        }
    }
}
