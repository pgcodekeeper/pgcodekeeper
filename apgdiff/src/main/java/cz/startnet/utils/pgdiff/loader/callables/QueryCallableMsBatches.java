package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.Statement;

import cz.startnet.utils.pgdiff.loader.AbstractMsScript;
import cz.startnet.utils.pgdiff.loader.MsScript;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.JDBC_CONSTS;

public class QueryCallableMsBatches extends StatementCallable<String> {

    private final AbstractMsScript msScript;

    public QueryCallableMsBatches(Statement st, String script) {
        super(st, script);
        msScript = new MsScript(st, script);
    }

    @Override
    public String call() throws Exception {
        msScript.executeBatch();
        return JDBC_CONSTS.JDBC_SUCCESS;
    }
}
