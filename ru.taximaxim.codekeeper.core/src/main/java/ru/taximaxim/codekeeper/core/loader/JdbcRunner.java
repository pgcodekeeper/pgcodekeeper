/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.DaemonThreadFactory;
import ru.taximaxim.codekeeper.core.IProgressReporter;
import ru.taximaxim.codekeeper.core.loader.callables.QueriesBatchCallable;
import ru.taximaxim.codekeeper.core.loader.callables.QueryCallable;
import ru.taximaxim.codekeeper.core.loader.callables.ResultSetCallable;
import ru.taximaxim.codekeeper.core.loader.callables.StatementCallable;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class JdbcRunner {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcRunner.class);

    private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(1,
            Integer.MAX_VALUE, 2, TimeUnit.SECONDS, new SynchronousQueue<>(),
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

    public void run(AbstractJdbcConnector connector, String script)
            throws SQLException, IOException, InterruptedException {
        try (Connection connection = connector.getConnection();
                Statement st = connection.createStatement()) {
            run(st, script);
        }
    }

    /**
     * execute statement by given batches with no return value
     *
     * @param connector contains database connection information
     * @param batches contains splited queries of Statements
     * @param reporter reports result
     * @throws SQLException
     * @throws IOException
     * @throws InterruptedException
     */
    public void runBatches(AbstractJdbcConnector connector, List<PgObjLocation> batches,
            IProgressReporter reporter) throws SQLException, IOException, InterruptedException {
        try (Connection connection = connector.getConnection();
                Statement st = connection.createStatement()) {
            runScript(new QueriesBatchCallable(st, batches, monitor, reporter, connection, connector.getType()));
        }
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

        while (true) {
            if (monitor.isCanceled()) {
                LOG.info(MESSAGE);
                callable.cancel();
                throw new InterruptedException(MESSAGE);
            }
            try {
                return queryFuture.get(SLEEP_TIME, TimeUnit.MILLISECONDS);
            } catch (ExecutionException e) {
                Throwable t = e.getCause();
                throw new SQLException(t.getLocalizedMessage(), e);
            } catch (TimeoutException e) {
                // no action: check cancellation and try again
            }
        }
    }
}
