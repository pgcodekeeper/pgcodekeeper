package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;

public abstract class AbstractFunction extends PgStatementWithSearchPath implements IFunction {

    protected final List<Argument> arguments = new ArrayList<>();

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
        return null;
    }

    @Override
    public Map<String, String> getReturnsColumns() {
        // subclasses may override if needed
        return Collections.emptyMap();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        AbstractFunction newFunction = (AbstractFunction) newCondition;

        if (!compareUnalterable(newFunction)) {
            if (needDrop(newFunction)) {
                isNeedDepcies.set(true);
                return true;
            }

            if (!isPostgres()) {
                isNeedDepcies.set(true);
            }

            sb.append(newFunction.getFunctionFullSQL(false));
        }

        if (!Objects.equals(getOwner(), newFunction.getOwner())) {
            newFunction.alterOwnerSQL(sb);
        }

        alterPrivileges(newFunction, sb);

        if (!Objects.equals(getComment(), newFunction.getComment())) {
            sb.append("\n\n");
            newFunction.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    protected abstract String getFunctionFullSQL(boolean isCreate);

    /**
     * Getter for {@link #arguments}. List cannot be modified.
     */
    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public void addArgument(final Argument argument) {
        arguments.add(argument);
        resetHash();
    }

    /**
     * Compares two objects whether they are equal. If both objects are of the
     * same class but they equal just in whitespace in {@link #body}, they are
     * considered being equal.
     *
     * @param func                     object to be compared
     * @return true if {@code object} is PgFunction and the function code is
     *         the same when compared ignoring whitespace, otherwise returns
     *         false
     */
    protected boolean compareUnalterable(AbstractFunction func) {
        return arguments.equals(func.arguments);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof AbstractFunction && super.compare(obj)
                && compareUnalterable((AbstractFunction) obj);
    }

    public abstract boolean needDrop(AbstractFunction newFunction);

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(arguments);
    }

    @Override
    public AbstractFunction shallowCopy() {
        AbstractFunction functionDst = getFunctionCopy();
        copyBaseFields(functionDst);
        for (Argument argSrc : arguments) {
            Argument argDst = new Argument(argSrc.getMode(), argSrc.getName(), argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            argDst.setReadOnly(argSrc.isReadOnly());
            functionDst.addArgument(argDst);
        }
        return functionDst;
    }

    protected abstract AbstractFunction getFunctionCopy();
}
