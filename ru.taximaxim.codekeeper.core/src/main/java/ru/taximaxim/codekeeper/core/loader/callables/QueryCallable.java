package ru.taximaxim.codekeeper.core.loader.callables;

import java.sql.PreparedStatement;
import java.sql.Statement;

import ru.taximaxim.codekeeper.core.Consts.JDBC_CONSTS;

public class QueryCallable extends StatementCallable<String> {

    public QueryCallable(PreparedStatement st) {
        super(st, null);
    }

    public QueryCallable(Statement st, String script) {
        super(st, script);
    }

    @Override
    public String call() throws Exception {
        if (st instanceof PreparedStatement) {
            ((PreparedStatement)st).execute();
        } else {
            st.execute(script);
        }
        return JDBC_CONSTS.JDBC_SUCCESS;
    }
}
