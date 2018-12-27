package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;

import cz.startnet.utils.pgdiff.IProgressReporter;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;

public class QueriesBatchCallable extends StatementCallable<String> {

    private static final Pattern PATTERN_WS = Pattern.compile("\\s+");

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
        String currQuery = null;
        try {
            if (batches.size() == 1) {
                List<String> queries = batches.get(0);
                subMonitor.setWorkRemaining(queries.size());
                for (String query : queries) {
                    currQuery = query;
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
            if (offset > 0 && currQuery != null) {
                appendPosition(sb, currQuery, offset);
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

        // trim to avoid empty strings at the edges of the array
        String[] arr = PATTERN_WS.split(query.trim(), 3);
        if (arr[0].isEmpty()) {
            // empty or whitespace query, wtf was that
            return;
        }

        String message = arr[0].toUpperCase(Locale.ENGLISH);
        if (arr.length > 1) {
            switch (message) {
            case "CREATE":
            case "ALTER":
            case "DROP":
            case "START":
            case "BEGIN":
                message += ' ' + arr[1].toUpperCase(Locale.ENGLISH);
            }
        }

        reporter.writeMessage(message);
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
