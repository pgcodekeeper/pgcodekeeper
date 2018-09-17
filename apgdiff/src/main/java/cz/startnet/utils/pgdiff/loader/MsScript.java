package cz.startnet.utils.pgdiff.loader;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import cz.startnet.utils.pgdiff.schema.PgStatement;

public class MsScript extends AbstractMsScript {

    public MsScript(Statement st, String script) {
        super(st, script);
    }

    @Override
    protected void fillBatchesFromScript() {
        batches = new ArrayList<>(Arrays.asList(script.split(PgStatement.GO)));
    }

    @Override
    protected void executeStatementBatch() throws SQLException {
        // TODO fix 'CREATE FUNCTION'/'CREATE VIEW' must be the first statement in a query batch.
        fillBatchesFromScript();
        for (String query : batches) {
            st.addBatch(query);
        }
        st.executeBatch();
        batches.clear();
    }

    @Override
    protected void executePreparedStatementBatch() throws SQLException {
        ((PreparedStatement)st).executeBatch();
    }
}
