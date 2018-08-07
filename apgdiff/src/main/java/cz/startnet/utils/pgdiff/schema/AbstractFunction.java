package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractFunction extends PgStatementWithSearchPath implements IFunction {

    protected final List<Argument> arguments = new ArrayList<>();
    private String body;
    private String returns;
    protected final Map<String, String> returnsColumns = new LinkedHashMap<>();
    protected final List<String> options = new ArrayList<>();

    private boolean isForReplication;
    private boolean ansiNulls;
    private boolean quotedIdentified;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FUNCTION;
    }

    public AbstractFunction(String name, String rawStatement) {
        super(name, rawStatement);
    }

    protected abstract String getDeclaration(Argument arg, boolean includeDefaultValue, boolean includeArgName);

    public void setBody(final String body) {
        this.body = body;
        resetHash();
    }

    /**
     * Sets {@link #body} with newlines as requested in arguments.
     */
    public void setBody(PgDiffArguments args, String body) {
        setBody(args.isKeepNewlines() ? body : body.replace("\r", ""));
    }

    public String getBody() {
        return body;
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public boolean isQuotedIdentified() {
        return quotedIdentified;
    }


    /**
     * @return the returns
     */
    @Override
    public String getReturns() {
        return returns;
    }

    /**
     * @param returns the returns to set
     */
    public void setReturns(String returns) {
        this.returns = returns;
        resetHash();
    }

    /**
     * @return unmodifiable RETURNS TABLE map
     */
    @Override
    public Map<String, String> getReturnsColumns() {
        return Collections.unmodifiableMap(returnsColumns);
    }

    public void addReturnsColumn(String name, String type) {
        returnsColumns.put(name, type);
    }

    public List<String> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public void addOption(final String option) {
        options.add(option);
        resetHash();
    }

    public boolean isForReplication() {
        return isForReplication;
    }

    public void setForReplication(boolean isForReplication) {
        this.isForReplication = isForReplication;
        resetHash();
    }

    /**
     * Getter for {@link #arguments}. List cannot be modified.
     *
     * @return {@link #arguments}
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
    public boolean checkForChanges(AbstractFunction func) {
        boolean equals = false;

        if (this == func) {
            equals = true;
        } else {
            equals = Objects.equals(name, func.getBareName())
                    && arguments.equals(func.arguments)
                    && options.equals(func.options)
                    && Objects.equals(body, func.getBody())
                    && Objects.equals(isForReplication, func.isForReplication())
                    && Objects.equals(returns, func.getReturns());
        }
        return equals;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractFunction) {
            AbstractFunction func  = (AbstractFunction) obj;
            if (!checkForChanges(func)) {
                return false;
            }
            return  Objects.equals(owner, func.getOwner())
                    && options.equals(func.options)
                    && Objects.equals(grants, func.grants)
                    && Objects.equals(revokes, func.revokes)
                    && Objects.equals(comment, func.getComment())
                    && Objects.equals(isForReplication, func.isForReplication)
                    && Objects.equals(quotedIdentified, func.isQuotedIdentified())
                    && Objects.equals(ansiNulls, func.isAnsiNulls());
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(grants);
        hasher.putOrdered(revokes);
        hasher.putOrdered(arguments);
        hasher.put(returns);
        hasher.put(body);
        hasher.put(name);
        hasher.put(owner);
        hasher.put(comment);
        hasher.put(quotedIdentified);
        hasher.put(ansiNulls);
        hasher.put(options);
        hasher.put(isForReplication);
    }

    @Override
    public AbstractFunction shallowCopy() {
        AbstractFunction functionDst = getFunctionCopy();
        functionDst.setReturns(getReturns());
        functionDst.setAnsiNulls(isAnsiNulls());
        functionDst.setQuotedIdentified(isQuotedIdentified());
        functionDst.returnsColumns.putAll(returnsColumns);
        functionDst.setBody(getBody());
        functionDst.setComment(getComment());
        for (Argument argSrc : arguments) {
            Argument argDst = new Argument(argSrc.getMode(), argSrc.getName(), argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            argDst.setReadOnly(argSrc.isReadOnly());
            argDst.setVarying(argSrc.isVarying());
            functionDst.addArgument(argDst);
        }
        for (PgPrivilege priv : revokes) {
            functionDst.addPrivilege(priv);
        }
        for (PgPrivilege priv : grants) {
            functionDst.addPrivilege(priv);
        }
        functionDst.setOwner(getOwner());
        functionDst.deps.addAll(deps);

        return functionDst;
    }

    protected abstract AbstractFunction getFunctionCopy();

    @Override
    public AbstractFunction deepCopy() {
        return shallowCopy();
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }

    protected static boolean needDrop(AbstractFunction oldFunction, AbstractFunction newFunction) {
        if (newFunction == null ||
                !Objects.equals(oldFunction.getReturns(), newFunction.getReturns())) {
            return true;
        }

        Iterator<Argument> iOld = oldFunction.getArguments().iterator();
        Iterator<Argument> iNew = newFunction.getArguments().iterator();
        while (iOld.hasNext() && iNew.hasNext()) {
            Argument argOld = iOld.next();
            Argument argNew = iNew.next();

            String oldDef = argOld.getDefaultExpression();
            String newDef = argNew.getDefaultExpression();
            // allow creation of defaults (old==null && new!=null)
            if (oldDef != null && !oldDef.equals(newDef)) {
                return true;
            }

            // [IN]OUT args that change their names implicitly change the function's
            // return type due to it being "SETOF record" in case of
            // multiple [IN]OUT args present

            // actually any argument name change requires drop
            if (!Objects.equals(argOld.getName(), argNew.getName())) {
                return true;
            }
            // нельзя менять тип out параметров
            if ("OUT".equalsIgnoreCase(argOld.getMode()) &&
                    !Objects.equals(argOld.getDataType(), argNew.getDataType())) {
                return true;
            }
        }
        // Если добавляется или удаляется out параметр нужно удалить функцию,
        // т.к. меняется её возвращаемое значение
        while (iOld.hasNext()) {
            if ("OUT".equalsIgnoreCase(iOld.next().getMode())) {
                return true;
            }
        }
        while (iNew.hasNext()) {
            if ("OUT".equalsIgnoreCase(iNew.next().getMode())) {
                return true;
            }
        }

        return false;
    }
}
