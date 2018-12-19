package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public abstract class AbstractPgFunction extends AbstractFunction {

    public static final String FROM_CURRENT = "FROM CURRENT";

    protected static final float DEFAULT_PROCOST = 100.0f;
    protected static final float DEFAULT_PROROWS = 1000.0f;

    private float cost = DEFAULT_PROCOST;
    private float rows = DEFAULT_PROROWS;
    private boolean isWindow;
    private boolean isStrict;
    private boolean isLeakproof;
    private boolean isSecurityDefiner;
    private String language;
    private String parallel;
    private String volatileType;
    private String body;
    private String returns;

    protected final List<String> options = new ArrayList<>();
    protected final List<Argument> arguments = new ArrayList<>();
    protected final List<String> transforms = new ArrayList<>();
    protected final Map<String, String> configurations = new LinkedHashMap<>();
    protected final Map<String, String> returnsColumns = new LinkedHashMap<>();

    private String signatureCache;

    public AbstractPgFunction(String name) {
        super(name);
    }

    public StringBuilder appendFunctionSignature(StringBuilder sb,
            boolean includeDefaultValues, boolean includeArgNames) {
        boolean cache = !includeDefaultValues && !includeArgNames;
        if (cache && signatureCache != null) {
            return sb.append(signatureCache);
        }
        final int sigStart = sb.length();

        sb.append(isPostgres() ? PgDiffUtils.getQuotedName(name) : MsDiffUtils.quoteName(name)).append('(');
        boolean addComma = false;
        for (final Argument argument : arguments) {
            if (!includeArgNames && "OUT".equalsIgnoreCase(argument.getMode())) {
                continue;
            }
            if (addComma) {
                sb.append(", ");
            }
            sb.append(getDeclaration(argument, includeDefaultValues, includeArgNames));
            addComma = true;
        }
        sb.append(')');

        if (cache) {
            signatureCache = sb.substring(sigStart, sb.length());
        }
        return sb;
    }

    protected abstract String getDeclaration(Argument arg,
            boolean includeDefaultValue, boolean includeArgName);

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

    /**
     * Returns function signature. It consists of unquoted name and argument
     * data types.
     *
     * @return function signature
     */
    public String getSignature() {
        if (signatureCache == null) {
            signatureCache = appendFunctionSignature(new StringBuilder(), false, false).toString();
        }
        return signatureCache;
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
    public boolean compareUnalterable(AbstractPgFunction func) {
        boolean equals = false;

        if (this == func) {
            equals = true;
        } else {
            equals = Objects.equals(body, func.getBody())
                    && isWindow == func.isWindow()
                    && Objects.equals(language, func.getLanguage())
                    && Objects.equals(parallel, func.getParallel())
                    && Objects.equals(volatileType, func.getVolatileType())
                    && isStrict == func.isStrict()
                    && isSecurityDefiner == func.isSecurityDefiner()
                    && isLeakproof == func.isLeakproof()
                    && rows == func.getRows()
                    && cost == func.getCost()
                    && Objects.equals(returns, func.getReturns())
                    && arguments.equals(func.arguments)
                    && options.equals(func.options)
                    && transforms.equals(func.transforms)
                    && configurations.equals(func.configurations);
        }
        return equals;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof AbstractPgFunction && super.compare(obj)
                && compareUnalterable((AbstractPgFunction) obj);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(arguments);
        hasher.put(returns);
        hasher.put(body);
        hasher.put(options);
        hasher.put(transforms);
        hasher.put(configurations);
        hasher.put(isWindow);
        hasher.put(language);
        hasher.put(volatileType);
        hasher.put(isStrict);
        hasher.put(isSecurityDefiner);
        hasher.put(isLeakproof);
        hasher.put(rows);
        hasher.put(cost);
        hasher.put(parallel);
    }

    @Override
    public AbstractFunction shallowCopy() {
        AbstractPgFunction functionDst = getFunctionCopy();
        copyBaseFields(functionDst);
        functionDst.setReturns(getReturns());
        functionDst.setBody(getBody());
        functionDst.setWindow(isWindow());
        functionDst.setLanguage(getLanguage());
        functionDst.setVolatileType(getVolatileType());
        functionDst.setStrict(isStrict());
        functionDst.setSecurityDefiner(isSecurityDefiner());
        functionDst.setLeakproof(isLeakproof());
        functionDst.setRows(getRows());
        functionDst.setCost(getCost());
        functionDst.setParallel(getParallel());
        for (Argument argSrc : arguments) {
            Argument argDst = new Argument(argSrc.getMode(), argSrc.getName(), argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            argDst.setReadOnly(argSrc.isReadOnly());
            functionDst.addArgument(argDst);
        }
        functionDst.options.addAll(options);
        functionDst.transforms.addAll(transforms);
        functionDst.returnsColumns.putAll(returnsColumns);
        functionDst.configurations.putAll(configurations);

        return functionDst;
    }

    protected abstract AbstractPgFunction getFunctionCopy();

    public class PgArgument extends Argument {

        private static final long serialVersionUID = -6351018532827424260L;

        public PgArgument(String mode, String name, String dataType) {
            super(mode, name, dataType);
        }

        @Override
        public void setDefaultExpression(String defaultExpression) {
            super.setDefaultExpression(defaultExpression);
            resetHash();
        }
    }
}
