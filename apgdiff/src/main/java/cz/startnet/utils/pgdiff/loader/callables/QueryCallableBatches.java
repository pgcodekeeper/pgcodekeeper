package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;

public class QueryCallableBatches extends Cancelable<String> {

    private final QueryBatches queryBatches;

    public QueryCallableBatches(Statement st, List<List<String>> batches) {
        super(st);
        queryBatches = QueryBatchesFactory.getQueryBatches(st, batches);
    }

    @Override
    public String call() throws Exception {
        queryBatches.executeBatches();
        return JDBC_CONSTS.JDBC_SUCCESS;
    }

    @Override
    public void cancel() throws SQLException {
        st.cancel();
    }
}
