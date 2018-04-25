package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetCallable extends StatementCallable<ResultSet> {

    public ResultSetCallable(PreparedStatement st) {
        super(st, null);
    }

    public ResultSetCallable(Statement st, String script) {
        super(st, script);
    }

    @Override
    public ResultSet call() throws Exception {
        if (st instanceof PreparedStatement) {
            return ((PreparedStatement)st).executeQuery();
        } else {
            return st.executeQuery(script);
        }
    }
}
