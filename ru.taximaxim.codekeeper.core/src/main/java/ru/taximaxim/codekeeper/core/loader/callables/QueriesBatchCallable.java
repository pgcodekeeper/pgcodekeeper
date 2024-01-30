/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.loader.callables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;

import com.microsoft.sqlserver.jdbc.SQLServerError;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.IProgressReporter;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcType;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class QueriesBatchCallable extends StatementCallable<String> {

    private final List<PgObjLocation> batches;
    private final IProgressMonitor monitor;
    private final Connection connection;
    private final IProgressReporter reporter;
    private final DatabaseType dbType;

    private boolean isAutoCommitEnabled = true;

    public QueriesBatchCallable(Statement st, List<PgObjLocation> batches,
            IProgressMonitor monitor, IProgressReporter reporter,
            Connection connection, DatabaseType dbType) {
        super(st, null);
        this.batches = batches;
        this.monitor = monitor;
        this.connection = connection;
        this.reporter = reporter;
        this.dbType = dbType;
    }

    @Override
    public String call() throws Exception {
        SubMonitor subMonitor = SubMonitor.convert(monitor);
        PgObjLocation currQuery = null;
        String[] finalModifiedQuery = new String[1];

        try {
            if (reporter != null) {
                reporter.writeDbName();
            }
            switch (dbType) {
            case PG:
            case CH:
                subMonitor.setWorkRemaining(batches.size());
                for (PgObjLocation query : batches) {
                    PgDiffUtils.checkCancelled(monitor);
                    currQuery = query;
                    executeSingleStatement(query, finalModifiedQuery);
                    subMonitor.worked(1);
                }
                break;
            case MS:
                List<List<PgObjLocation>> batchesList = getListBatchesFromSetBatches();
                subMonitor.setWorkRemaining(batchesList.size());
                for (List<PgObjLocation> queriesList : batchesList) {
                    PgDiffUtils.checkCancelled(monitor);
                    // in case we're executing a real batch after a single-statement one
                    currQuery = null;
                    if (queriesList.size() == 1) {
                        currQuery = queriesList.get(0);
                        executeSingleStatement(currQuery, finalModifiedQuery);
                    } else {
                        runBatch(queriesList);
                    }
                    subMonitor.worked(1);
                }
                connection.commit();
                break;
            default:
                throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
            }

            if (reporter != null) {
                reporter.writeMessage("Script finished"); //$NON-NLS-1$
            }
        } catch (PSQLException ex) {
            ServerErrorMessage sem = ex.getServerErrorMessage();
            if (reporter == null || sem == null) {
                throw ex;
            }
            StringBuilder sb = new StringBuilder(sem.toString());
            if (currQuery != null) {
                int offset = sem.getPosition();
                if (offset > 0) {
                    appendPosition(sb, finalModifiedQuery[0], offset);
                } else {
                    if (currQuery.getLineNumber() > 1) {
                        sb.append("\n  Line: ").append(currQuery.getLineNumber()); //$NON-NLS-1$
                    }
                    sb.append('\n').append(currQuery.getSql());
                }
                reporter.reportErrorLocation(currQuery.getOffset(),
                        currQuery.getSql().length());
            }

            reporter.writeError(sb.toString());
        } catch (SQLServerException e) {
            SQLServerError err = e.getSQLServerError();
            if (reporter == null || err == null) {
                throw e;
            }
            StringBuilder sb = new StringBuilder(err.getErrorMessage());
            if (currQuery != null) {
                if (err.getLineNumber() > 1) {
                    sb.append("\n  Line: ").append(err.getLineNumber()); //$NON-NLS-1$
                } else if (currQuery.getLineNumber() > 1) {
                    sb.append("\n  Line: ").append(currQuery.getLineNumber()); //$NON-NLS-1$
                }
                sb.append('\n').append(currQuery.getSql());
                reporter.reportErrorLocation(currQuery.getOffset(),
                        currQuery.getSql().length());
            }

            reporter.writeError(sb.toString());
        }
        // BatchUpdateException
        // MS SQL driver returns a useless batch update status array
        // where even successful statements are marked as Statement.EXECUTE_FAILED
        // so we cannot deduce which one failed to show more accurate error context

        return Consts.JDBC_SUCCESS;
    }

    private List<List<PgObjLocation>> getListBatchesFromSetBatches() {
        List<List<PgObjLocation>> batchesList = new ArrayList<>();
        batchesList.add(new ArrayList<>());

        for (PgObjLocation loc : batches) {
            if (Consts.GO.equalsIgnoreCase(loc.getAction())) {
                batchesList.add(new ArrayList<>());
            } else {
                batchesList.get(batchesList.size() - 1).add(loc);
            }
        }

        int lastBatchIdx = batchesList.size() - 1;
        List<PgObjLocation> lastBatch = batchesList.get(lastBatchIdx);
        if (lastBatch.isEmpty()) {
            batchesList.remove(lastBatchIdx);
        }

        return batchesList;
    }

    private void executeSingleStatement(PgObjLocation query, String[] finalModifiedQuery)
            throws SQLException, InterruptedException {
        String sql = query.getSql();

        finalModifiedQuery[0] = sql;
        if (st.execute(sql)) {
            writeResult(query.getSql());
        }
        writeWarnings();
        writeStatus(query.getAction());
    }

    private void runBatch(List<PgObjLocation> queriesList)
            throws SQLException {
        if (isAutoCommitEnabled) {
            connection.setAutoCommit(false);
            isAutoCommitEnabled = false;
        }

        if (reporter != null) {
            reporter.writeMessage("Starting batch"); //$NON-NLS-1$
        }

        for (PgObjLocation query : queriesList) {
            st.addBatch(query.getSql());
            writeStatus(query.getAction());
        }

        if (reporter != null) {
            reporter.writeMessage("Executing batch"); //$NON-NLS-1$
        }

        st.executeBatch();
        writeWarnings();
    }

    private void writeResult(String query) throws SQLException, InterruptedException {
        if (reporter == null) {
            return;
        }
        List<List<Object>> results = new ArrayList<>();
        try (ResultSet res = st.getResultSet()) {

            ResultSetMetaData meta = res.getMetaData();
            int count = meta.getColumnCount();

            // add column names as first list
            List<Object> names = new ArrayList<>(count);
            for (int i = 1; i <= count; i++) {
                String type = meta.getColumnTypeName(i);
                String dealias = JdbcType.DATA_TYPE_ALIASES.get(type);
                names.add(meta.getColumnLabel(i) + ' ' +
                        (dealias == null ? type : dealias));
            }
            results.add(names);

            // add other rows
            while (res.next()) {
                PgDiffUtils.checkCancelled(monitor);
                List<Object> row = new ArrayList<>(count);
                results.add(row);
                for (int i = 1; i <= count; i++) {
                    row.add(res.getObject(i));
                }
            }
        }
        reporter.showData(query, results);
    }

    private void writeWarnings() throws SQLException {
        if (reporter == null) {
            return;
        }

        SQLWarning war = st.getWarnings();
        while (war != null) {
            reporter.writeWarning(war.getLocalizedMessage());
            war = war.getNextWarning();
        }
    }

    private void writeStatus(String msgAction) {
        if (reporter == null || msgAction == null) {
            return;
        }
        reporter.writeMessage(msgAction);
    }

    private void appendPosition(StringBuilder sb, String query, int offset) {
        sb.append('\n');
        int begin = query.lastIndexOf('\n', offset) + 1;
        int end = query.indexOf('\n', offset);

        if (end == offset) {
            // error in last character in previous line
            begin = query.lastIndexOf('\n', offset - 1) + 1;
        }

        String line;
        if (end == -1) {
            line = query.substring(begin);
        } else {
            line = query.substring(begin, end);
        }

        sb.append(line.replace("\t", "    ")).append('\n'); //$NON-NLS-1$ //$NON-NLS-2$

        for (int i = 0; i < offset - begin - 1; i++) {
            if ('\t' == line.charAt(i)) {
                sb.append("    "); //$NON-NLS-1$
            } else {
                sb.append(' ');
            }
        }
        sb.append('^');
    }
}
