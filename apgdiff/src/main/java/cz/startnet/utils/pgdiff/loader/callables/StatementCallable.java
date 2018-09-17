package cz.startnet.utils.pgdiff.loader.callables;

import java.sql.Statement;

public abstract class StatementCallable<T> extends Cancelable<T> {

    protected final String script;

    public StatementCallable(Statement st, String script) {
        super(st);
        this.script = script;
    }
}
