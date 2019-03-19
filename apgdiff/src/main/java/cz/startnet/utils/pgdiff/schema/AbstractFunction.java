package cz.startnet.utils.pgdiff.schema;

import java.util.List;
import java.util.Map;

public abstract class AbstractFunction extends PgStatementWithSearchPath implements IFunction {

    public AbstractFunction(String name) {
        super(name);
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }

    @Override
    public String getReturns() {
        // subclasses may override if needed
        throw new IllegalStateException("Unsupported operation");
    }

    @Override
    public Map<String, String> getReturnsColumns() {
        // subclasses may override if needed
        throw new IllegalStateException("Unsupported operation");
    }

    @Override
    public List<Argument> getArguments() {
        // subclasses may override if needed
        throw new IllegalStateException("Unsupported operation");
    }
}
