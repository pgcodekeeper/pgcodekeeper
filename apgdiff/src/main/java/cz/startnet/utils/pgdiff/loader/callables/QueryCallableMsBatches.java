package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.PreparedStatement;
import java.sql.Statement;

import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;

public class QueryCallableMsBatches extends StatementCallable<String> {

    public QueryCallableMsBatches(PreparedStatement st) {
        super(st, null);
    }

    public QueryCallableMsBatches(Statement st, String script) {
        super(st, script);
    }

    @Override
    public String call() throws Exception {
        if (st instanceof PreparedStatement) {
            ((PreparedStatement)st).executeBatch();
        } else {
            for (String query : script.split(PgStatement.GO)) {
                st.addBatch(query);
            }
            st.executeBatch();
        }
        return JDBC_CONSTS.JDBC_SUCCESS;
    }
}
