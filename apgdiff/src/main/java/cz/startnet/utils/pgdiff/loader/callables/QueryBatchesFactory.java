package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class QueryBatchesFactory {

    public static QueryBatches getQueryBatches(Statement st, List<List<String>> batches) {
        if (st instanceof PreparedStatement) {
            return new QueryBatchesPreparedStatement(st, batches);
        } else {
            return new QueryBatchesStatement(st, batches);
        }
    }
}

abstract class QueryBatches {

    // One item of List<List<String>> contains queries of one Statement splited by 'GO'.
    private final List<List<String>> batches;
    private final Statement st;

    public QueryBatches(Statement st, List<List<String>> batches) {
        this.st = st;
        this.batches = batches;
    }

    public abstract void executeBatches() throws SQLException;
}

class QueryBatchesPreparedStatement extends QueryBatches {

    public QueryBatchesPreparedStatement(Statement st, List<List<String>> batches) {
        super(st, batches);
    }

    @Override
    public void executeBatches() throws SQLException {
        // TODO add code for execute PreparedStatment
    }
}

class QueryBatchesStatement extends QueryBatches {

    public QueryBatchesStatement(Statement st, List<List<String>> batches) {
        super(st, batches);
    }

    @Override
    public void executeBatches() throws SQLException {
        // TODO add code for execute Statment
    }
}
