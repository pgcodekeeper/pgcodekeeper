package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;

import com.microsoft.sqlserver.jdbc.SQLServerError;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import cz.startnet.utils.pgdiff.IProgressReporter;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcType;
import cz.startnet.utils.pgdiff.parsers.antlr.ScriptParser;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;

public class QueriesBatchCallable extends StatementCallable<String> {

    private final Map<String, Set<PgObjLocation>> batches;
    private final IProgressMonitor monitor;
    private final Connection connection;
    private final IProgressReporter reporter;

    public QueriesBatchCallable(Statement st, Map<String, Set<PgObjLocation>> batches,
            IProgressMonitor monitor, IProgressReporter reporter, Connection connection) {
        super(st, null);
        this.batches = batches;
        this.monitor = monitor;
        this.connection = connection;
        this.reporter = reporter;
    }

    @Override
    public String call() throws Exception {
        SubMonitor subMonitor = SubMonitor.convert(monitor);
        String currQuery = null;
        int currQueryLine = 1;
        int currQueryOffset = 0;

        List<List<PgObjLocation>> batchesList = getListBatchesFromSetBatches();

        try {
            if (batchesList.size() == 1) {
                List<PgObjLocation> queries = batchesList.get(0);
                subMonitor.setWorkRemaining(queries.size());
                for (PgObjLocation query : queries) {
                    PgDiffUtils.checkCancelled(monitor);
                    currQuery = query.getSql();
                    currQueryLine = query.getLineNumber();
                    currQueryOffset = query.getOffset();
                    executeSingleStatement(query);

                    subMonitor.worked(1);
                }
            } else {
                subMonitor.setWorkRemaining(batchesList.size());
                connection.setAutoCommit(false);
                for (List<PgObjLocation> queriesList : batchesList) {
                    PgDiffUtils.checkCancelled(monitor);
                    // in case we're executing a real batch after a single-statement one
                    currQuery = null;
                    if (queriesList.size() == 1) {
                        PgObjLocation query = queriesList.get(0);
                        currQuery = query.getSql();
                        currQueryLine = query.getLineNumber();
                        currQueryOffset = query.getOffset();
                        executeSingleStatement(query);
                    } else {
                        for (PgObjLocation query : queriesList) {
                            currQuery = query.getSql();
                            currQueryLine = query.getLineNumber();
                            currQueryOffset = query.getOffset();
                            st.addBatch(currQuery);
                            writeStatus(query.getAction());
                        }

                        if (reporter != null) {
                            reporter.writeMessage("Executing batch");
                        }

                        st.executeBatch();
                        writeWarnings();
                    }
                    subMonitor.worked(1);
                }
                connection.commit();
            }

            if (reporter != null) {
                reporter.writeMessage("Script finished");
            }
        } catch (PSQLException ex) {
            ServerErrorMessage sem = ex.getServerErrorMessage();
            if (reporter == null || sem == null) {
                throw ex;
            }
            StringBuilder sb = new StringBuilder(sem.toString());
            int offset = sem.getPosition();
            if (currQuery != null) {
                if (offset > 0) {
                    appendPosition(sb, currQuery, offset);
                } else {
                    if (currQueryLine > 1) {
                        sb.append("\n  Line: ").append(currQueryLine);
                    }
                    sb.append('\n').append(currQuery);
                }
                reporter.setErrorPosition(currQueryOffset, currQuery.length());
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
                    sb.append("\n  Line: ").append(err.getLineNumber());
                } else if (currQueryLine > 1) {
                    sb.append("\n  Line: ").append(currQueryLine);
                }
                sb.append('\n').append(currQuery);
            }

            reporter.writeError(sb.toString());
        } finally {
            batchesList.clear();
        }
        // BatchUpdateException
        // MS SQL driver returns a useless batch update status array
        // where even successful statements are marked as Statement.EXECUTE_FAILED
        // so we cannot deduce which one failed to show more accurate error context

        return JDBC_CONSTS.JDBC_SUCCESS;
    }

    private List<List<PgObjLocation>> getListBatchesFromSetBatches() {
        List<List<PgObjLocation>> batchesList = new ArrayList<>();
        batchesList.add(new ArrayList<>());

        batches.get(ScriptParser.SCRIPT_KEY).stream().forEach(loc -> {
            if (PgStatement.strGO.equalsIgnoreCase(loc.getAction())) {
                batchesList.add(new ArrayList<>());
            } else {
                batchesList.get(batchesList.size() - 1).add(loc);
            }
        });

        List<PgObjLocation> lastBatch = batchesList.get(batchesList.size() - 1);
        if (lastBatch.isEmpty()) {
            batchesList.remove(lastBatch);
        }

        return batchesList;
    }

    private void executeSingleStatement(PgObjLocation query) throws SQLException {
        if (st.execute(query.getSql())) {
            writeResult(query.getSql());
        }
        writeWarnings();
        writeStatus(query.getAction());
    }

    private void writeResult(String query) throws SQLException {
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
                names.add(meta.getColumnLabel(i) + '\n' +
                        (dealias == null ? type : dealias));
            }
            results.add(names);

            // add other rows
            while (res.next()) {
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

        String line;
        if (end == -1) {
            line = query.substring(begin);
        } else {
            line = query.substring(begin, end);
        }

        sb.append(line.replace("\t", "    ")).append('\n');

        for (int i = 0; i < offset - begin - 1; i++) {
            if ('\t' == line.charAt(i)) {
                sb.append("    ");
            } else {
                sb.append(' ');
            }
        }
        sb.append('^');
    }
}
