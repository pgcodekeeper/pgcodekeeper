package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;

public class QueriesBatchCallable extends StatementCallable<String> {

    private final List<List<String>> batches;
    private final IProgressMonitor monitor;
    private final Connection connection;

    public QueriesBatchCallable(Statement st, List<List<String>> batches,
            IProgressMonitor monitor, Connection connection) {
        super(st, null);
        this.batches = batches;
        this.monitor = monitor;
        this.connection = connection;
    }

    @Override
    public String call() throws Exception {
        SubMonitor subMonitor = SubMonitor.convert(monitor);
        if (batches.size() == 1) {
            List<String> queries = batches.get(0);
            subMonitor.setWorkRemaining(queries.size());
            for (String query : queries) {
                PgDiffUtils.checkCancelled(monitor);
                if (st instanceof PreparedStatement) {
                    ((PreparedStatement)st).execute();
                } else {
                    st.execute(query);
                }
                subMonitor.worked(1);
            }
        } else {
            subMonitor.setWorkRemaining(batches.size());
            connection.setAutoCommit(false);
            for (List<String> queriesList : batches) {
                PgDiffUtils.checkCancelled(monitor);
                for (String queries : queriesList) {
                    st.addBatch(queries);
                }
                st.executeBatch();
                subMonitor.worked(1);
            }
            connection.commit();
        }
        return JDBC_CONSTS.JDBC_SUCCESS;
    }
}
