package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;

public class QueryBatches {

    // One item of List<List<String>> contains splited queries of one Statement.
    private final List<List<String>> batches;
    private final Statement st;

    public QueryBatches(Statement st, List<List<String>> batches) {
        this.st = st;
        this.batches = batches;
    }

    public void executeBatches() throws SQLException {
        for (String query : PgDiffUtils.sIter(batches.stream().flatMap(Collection::stream))) {
            st.addBatch(query);
        }
        st.executeBatch();
    }
}
