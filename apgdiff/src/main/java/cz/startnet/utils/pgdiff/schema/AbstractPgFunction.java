package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractPgFunction extends AbstractFunction {

    public static final String FROM_CURRENT = "FROM CURRENT";

    protected static final float DEFAULT_INTERNAL_PROCOST = 1.0f;
    protected static final float DEFAULT_PROCOST = 100.0f;
    protected static final float DEFAULT_PROROWS = 1000.0f;

    private float rows = DEFAULT_PROROWS;
    private boolean isWindow;
    private boolean isStrict;
    private boolean isLeakproof;
    private boolean isSecurityDefiner;
    private String cost;
    private String language;
    private String parallel;
    private String volatileType;
    private String body;
    private String returns;

    protected final List<Argument> arguments = new ArrayList<>();
    protected final List<String> transforms = new ArrayList<>();
    protected final Map<String, String> configurations = new LinkedHashMap<>();
    protected final Map<String, String> returnsColumns = new LinkedHashMap<>();

    private String signatureCache;

    public AbstractPgFunction(String name) {
        super(name);
    }

    @Override
    public String getDropSQL() {
        final StringBuilder sbString = new StringBuilder();
        sbString.append("DROP ");
        sbString.append(getStatementType().name());
        sbString.append(' ');
        sbString.append(PgDiffUtils.getQuotedName(getSchemaName())).append('.');
        if (getStatementType() == DbObjType.AGGREGATE) {
            ((PgAggregate) this).appendAggSignature(sbString);
        } else {
            appendFunctionSignature(sbString, false, true);
        }
        sbString.append(';');
        return sbString.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        AbstractPgFunction newAbstractPgFunction;
        if (newCondition instanceof AbstractPgFunction) {
            newAbstractPgFunction = (AbstractPgFunction) newCondition;
        } else {
            return false;
        }

        if (!compareUnalterable(newAbstractPgFunction)) {
            if (needDrop(newAbstractPgFunction)) {
                isNeedDepcies.set(true);
                return true;
            } else {
                sb.append(newAbstractPgFunction.getCreationSQL());
            }
        }

        if (!Objects.equals(getOwner(), newAbstractPgFunction.getOwner())) {
            newAbstractPgFunction.alterOwnerSQL(sb);
        }
        alterPrivileges(newAbstractPgFunction, sb);
        if (!Objects.equals(getComment(), newAbstractPgFunction.getComment())) {
            sb.append("\n\n");
            newAbstractPgFunction.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    protected abstract boolean needDrop(AbstractPgFunction newFunction);

    /**
     * Alias for {@link #getSignature()} which provides a unique function ID.
     *
     * Use {@link #getBareName()} to get just the function name.
     */
    @Override
    public String getName() {
        return getSignature();
    }

    /**
     * Appends signature of statement to sb.<br />
     *
     * Used for PRIVILEGES in Functions, Procedures, Aggregates.<br />
     *
     * Used for CREATE, ALTER, DROP, COMMENT operations in Functions and Procedures.<br /><br />
     *
     * (For CREATE, ALTER, DROP, COMMENT operations in Aggregates used own method
     * {@link PgAggregate#appendAggSignature(StringBuilder)}.)
     *
     */
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

    public static String getDeclaration(Argument arg, boolean includeDefaultValue, boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        if (includeArgName) {
            String mode = arg.getMode();
            if (mode != null && !"IN".equalsIgnoreCase(mode)) {
                sbString.append(mode);
                sbString.append(' ');
            }

            String name = arg.getName();

            if (name != null && !name.isEmpty()) {
                sbString.append(PgDiffUtils.getQuotedName(name));
                sbString.append(' ');
            }
        }

        sbString.append(arg.getDataType());

        String def = arg.getDefaultExpression();

        if (includeDefaultValue && def != null && !def.isEmpty()) {
            sbString.append(" = ");
            sbString.append(def);
        }

        return sbString.toString();
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

    public void setLanguageCost(String language, Float cost) {
        this.language = language;

        if (cost != null) {
            String val = "" + (cost % 1 == 0 ? cost.intValue() : cost);

            if ("internal".equals(getLanguage()) || "c".equals(getLanguage())) {
                if (DEFAULT_INTERNAL_PROCOST != cost) {
                    this.cost = val;
                }
            } else if (DEFAULT_PROCOST != cost) {
                this.cost = val;
            }
        }

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

    public String getCost() {
        return cost;
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
                    && Objects.equals(cost, func.getCost())
                    && Objects.equals(returns, func.getReturns())
                    && arguments.equals(func.arguments)
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
        functionDst.language = getLanguage();
        functionDst.setVolatileType(getVolatileType());
        functionDst.setStrict(isStrict());
        functionDst.setSecurityDefiner(isSecurityDefiner());
        functionDst.setLeakproof(isLeakproof());
        functionDst.setRows(getRows());
        functionDst.cost = getCost();
        functionDst.setParallel(getParallel());
        for (Argument argSrc : arguments) {
            Argument argDst = new Argument(argSrc.getMode(), argSrc.getName(), argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            argDst.setReadOnly(argSrc.isReadOnly());
            functionDst.addArgument(argDst);
        }
        functionDst.transforms.addAll(transforms);
        functionDst.returnsColumns.putAll(returnsColumns);
        functionDst.configurations.putAll(configurations);

        return functionDst;
    }

    protected abstract AbstractPgFunction getFunctionCopy();

    @Override
    public String getQualifiedName() {
        return getParent().getQualifiedName() + '.' + getName();
    }

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
