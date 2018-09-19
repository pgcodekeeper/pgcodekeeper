package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.Statement;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;

public class QueriesBatchCallable extends StatementCallable<String> {

    private final List<String> queriesList;

    public QueriesBatchCallable(Statement st, List<String> queriesList) {
        super(st, null);
        this.queriesList = queriesList;
    }

    @Override
    public String call() throws Exception {
        for (String queries : queriesList) {
            st.addBatch(queries);
        }
        st.executeBatch();
        return JDBC_CONSTS.JDBC_SUCCESS;
    }
}
