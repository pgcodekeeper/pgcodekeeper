package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;

import cz.startnet.utils.pgdiff.IProgressReporter;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;

public class QueriesBatchCallable extends StatementCallable<String> {

    private final List<List<String>> batches;
    private final IProgressMonitor monitor;
    private final Connection connection;
    private final IProgressReporter reporter;

    public QueriesBatchCallable(Statement st, List<List<String>> batches,
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
        String curr = null;
        try {
            if (batches.size() == 1) {
                List<String> queries = batches.get(0);
                subMonitor.setWorkRemaining(queries.size());
                for (String query : queries) {
                    curr = query;
                    PgDiffUtils.checkCancelled(monitor);
                    st.execute(query);

                    writeWarnings();
                    writeStatus(query);
                    subMonitor.worked(1);
                }
            } else {
                subMonitor.setWorkRemaining(batches.size());
                connection.setAutoCommit(false);
                for (List<String> queriesList : batches) {
                    PgDiffUtils.checkCancelled(monitor);
                    for (String query : queriesList) {
                        st.addBatch(query);
                        writeStatus(query);
                    }

                    if (reporter != null) {
                        reporter.writeMessage("Executing batch");
                    }

                    st.executeBatch();
                    writeWarnings();

                    subMonitor.worked(1);
                }
                connection.commit();
            }

            if (reporter != null) {
                reporter.writeMessage("Script finished");
            }
        } catch (PSQLException ex) {
            if (reporter == null) {
                throw ex;
            }
            ServerErrorMessage sem = ex.getServerErrorMessage();
            StringBuilder sb = new StringBuilder(sem.toString());
            int offset = sem.getPosition();
            if (offset > 0 && curr != null) {
                appendPosition(sb, curr, offset);
            }

            reporter.writeError(sb.toString());
        }

        return JDBC_CONSTS.JDBC_SUCCESS;
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

    private void writeStatus(String query) {
        if (reporter == null) {
            return;
        }

        String[] arr = query.split("\\s+", -1);
        String first = arr[0];
        String second = arr[1];

        String message = first;
        if (second != null
                && ("CREATE".equalsIgnoreCase(first)
                        || "ALTER".equalsIgnoreCase(first)
                        || "DROP".equalsIgnoreCase(first)
                        || "START".equalsIgnoreCase(first)
                        || "BEGIN".equalsIgnoreCase(first))) {
            message = first + ' ' + second;
        }

        reporter.writeMessage(message.toUpperCase(Locale.ENGLISH));
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
