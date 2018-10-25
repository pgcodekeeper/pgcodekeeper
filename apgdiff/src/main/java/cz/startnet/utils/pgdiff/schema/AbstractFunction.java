package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractFunction extends PgStatementWithSearchPath implements IFunction {

    public static final String FROM_CURRENT = "FROM CURRENT";

    protected static final float DEFAULT_PROCOST = 100.0f;
    protected static final float DEFAULT_PROROWS = 1000.0f;

    protected final List<String> options = new ArrayList<>();
    protected final List<String> transforms = new ArrayList<>();
    protected final List<Argument> arguments = new ArrayList<>();
    protected final Map<String, String> configurations = new LinkedHashMap<>();
    protected final Map<String, String> returnsColumns = new LinkedHashMap<>();

    private float cost = DEFAULT_PROCOST;
    private float rows = DEFAULT_PROROWS;
    private boolean isForReplication;
    private boolean ansiNulls;
    private boolean quotedIdentified;
    private boolean isCLR;
    private boolean isWindow;
    private boolean isStrict;
    private boolean isLeakproof;
    private boolean isSecurityDefiner;
    private String body;
    private String returns;
    private String language;
    private String parallel;
    private String volatileType;

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

    public boolean isWindow() {
        return isWindow;
    }

    public void setWindow(boolean isWindow) {
        this.isWindow = isWindow;
        resetHash();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
        resetHash();
    }

    public String getVolatileType() {
        return volatileType;
    }

    public void setVolatileType(String volatileType) {
        this.volatileType = volatileType;
        resetHash();
    }

    public boolean isStrict() {
        return isStrict;
    }

    public void setStrict(boolean isStrict) {
        this.isStrict = isStrict;
        resetHash();
    }

    public boolean isSecurityDefiner() {
        return isSecurityDefiner;
    }

    public void setSecurityDefiner(boolean isSecurityDefiner) {
        this.isSecurityDefiner = isSecurityDefiner;
        resetHash();
    }

    public boolean isLeakproof() {
        return isLeakproof;
    }

    public void setLeakproof(boolean isLeakproof) {
        this.isLeakproof = isLeakproof;
        resetHash();
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
        resetHash();
    }

    public float getRows() {
        return rows;
    }

    public void setRows(float rows) {
        this.rows = rows;
        resetHash();
    }

    public String getParallel() {
        return parallel;
    }

    public void setParallel(String parallel) {
        this.parallel = parallel;
        resetHash();
    }

    public List<String> getTransform() {
        return Collections.unmodifiableList(transforms);
    }

    public void addTransform(String datatype) {
        transforms.add(datatype);
        resetHash();
    }

    public Map<String, String> getConfigurations() {
        return Collections.unmodifiableMap(configurations);
    }

    public void addConfiguration(String par, String val) {
        configurations.put(par, val);
        resetHash();
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
    }

    public boolean isCLR() {
        return isCLR;
    }

    public void setCLR(boolean isCLR) {
        this.isCLR = isCLR;
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
                    && transforms.equals(func.transforms)
                    && configurations.equals(func.configurations)
                    && Objects.equals(body, func.getBody())
                    && isWindow == func.isWindow()
                    && Objects.equals(language, func.getLanguage())
                    && Objects.equals(parallel, func.getParallel())
                    && Objects.equals(volatileType, func.getVolatileType())
                    && isStrict == func.isStrict()
                    && isSecurityDefiner == func.isSecurityDefiner()
                    && isLeakproof == func.isLeakproof()
                    && rows == func.getRows()
                    && cost == func.getCost()
                    && isForReplication == func.isForReplication()
                    && Objects.equals(returns, func.getReturns())
                    && isCLR == func.isCLR();
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
                    && Objects.equals(grants, func.grants)
                    && Objects.equals(revokes, func.revokes)
                    && Objects.equals(comment, func.getComment())
                    && quotedIdentified == func.isQuotedIdentified()
                    && ansiNulls == func.isAnsiNulls();
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
        hasher.put(isWindow);
        hasher.put(language);
        hasher.put(volatileType);
        hasher.put(isStrict);
        hasher.put(isSecurityDefiner);
        hasher.put(isLeakproof);
        hasher.put(rows);
        hasher.put(cost);
        hasher.put(parallel);
        hasher.put(name);
        hasher.put(owner);
        hasher.put(comment);
        hasher.put(quotedIdentified);
        hasher.put(ansiNulls);
        hasher.put(options);
        hasher.put(transforms);
        hasher.put(configurations);
        hasher.put(isForReplication);
        hasher.put(isCLR);
    }

    @Override
    public AbstractFunction shallowCopy() {
        AbstractFunction functionDst = getFunctionCopy();
        functionDst.setReturns(getReturns());
        functionDst.setAnsiNulls(isAnsiNulls());
        functionDst.setQuotedIdentified(isQuotedIdentified());
        functionDst.setForReplication(isForReplication());
        functionDst.setCLR(isCLR());
        functionDst.setBody(getBody());
        functionDst.setWindow(isWindow());
        functionDst.setLanguage(getLanguage());
        functionDst.setVolatileType(getVolatileType());
        functionDst.setStrict(isStrict());
        functionDst.setSecurityDefiner(isSecurityDefiner());
        functionDst.setLeakproof(isLeakproof());
        functionDst.setRows(getRows());
        functionDst.setCost(getCost());
        functionDst.setComment(getComment());
        functionDst.setParallel(getParallel());
        functionDst.setOwner(getOwner());
        functionDst.setLocation(getLocation());
        for (Argument argSrc : arguments) {
            Argument argDst = new Argument(argSrc.getMode(), argSrc.getName(), argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            argDst.setReadOnly(argSrc.isReadOnly());
            argDst.setVarying(argSrc.isVarying());
            functionDst.addArgument(argDst);
        }
        functionDst.revokes.addAll(revokes);
        functionDst.grants.addAll(grants);
        functionDst.deps.addAll(deps);
        functionDst.options.addAll(options);
        functionDst.transforms.addAll(transforms);
        functionDst.returnsColumns.putAll(returnsColumns);
        functionDst.configurations.putAll(configurations);

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
}
