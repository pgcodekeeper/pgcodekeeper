package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.Statement;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;

public class QueryCallableBatches extends Cancelable<String> {

    private final QueryBatches queryBatches;

    public QueryCallableBatches(Statement st, List<List<String>> batchesList) {
        super(st);
        queryBatches = new QueryBatches(st, batchesList);
    }

    @Override
    public String call() throws Exception {
        queryBatches.executeBatches();
        return JDBC_CONSTS.JDBC_SUCCESS;
    }
}
