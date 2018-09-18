package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Callable;

public abstract class StatementCallable<T> implements Callable<T> {

    protected final Statement st;
    protected final String script;

    public StatementCallable(Statement st, String script) {
        this.st = st;
        this.script = script;
    }

    public void cancel() throws SQLException {
        st.cancel();
    }
}
