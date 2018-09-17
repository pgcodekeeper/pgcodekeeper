package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Callable;

public abstract class Cancelable<T> implements Callable<T> {

    protected final Statement st;

    public Cancelable(Statement st) {
        this.st = st;
    }

    public void cancel() throws SQLException {
        st.cancel();
    }
}
