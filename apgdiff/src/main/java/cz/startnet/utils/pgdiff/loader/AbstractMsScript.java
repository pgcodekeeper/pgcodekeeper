package cz.startnet.utils.pgdiff.loader;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMsScript {

    protected final Statement st;
    protected final String script;
    protected List<String> batches = new ArrayList<>();


    public AbstractMsScript(Statement st, String script) {
        this.st = st;
        this.script = script;
    }

    public void addQuery(String query) {
        batches.add(query);
    }

    public void executeBatch() throws SQLException {
        if (st instanceof PreparedStatement) {
            executePreparedStatementBatch();
        } else {
            executeStatementBatch();
        }
    }

    protected abstract void fillBatchesFromScript();

    protected abstract void executeStatementBatch() throws SQLException;

    protected abstract void executePreparedStatementBatch() throws SQLException;
}
