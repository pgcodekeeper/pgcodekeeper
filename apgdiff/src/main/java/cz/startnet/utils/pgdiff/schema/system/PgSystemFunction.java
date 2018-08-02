package cz.startnet.utils.pgdiff.schema.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.IFunction;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemFunction extends PgSystemStatement implements IFunction {

    private static final long serialVersionUID = -7905948011960006249L;

    private List<Argument> arguments;
    private transient String signatureCache;

    /**
     * Order by for aggregate functions
     */
    private List<Argument> orderBy;

    /**
     *  Contains table's columns, if function returns table.
     */
    private Map<String, String> returnsColumns;

    /**
     * Function return type name, if null columns contains columns
     */
    private String returns;
    private boolean setof;

    public PgSystemFunction(final String name) {
        super(name, DbObjType.FUNCTION);
    }

    @Override
    public Map<String, String> getReturnsColumns() {
        return returnsColumns == null ? Collections.emptyMap() : Collections.unmodifiableMap(returnsColumns);
    }

    public void addReturnsColumn(String name, String type) {
        if (returnsColumns == null) {
            returnsColumns = new LinkedHashMap<>();
        }
        returnsColumns.put(name, type);
    }

    @Override
    public String getBareName() {
        return name;
    }

    @Override
    public List<Argument> getArguments() {
        return arguments == null ? Collections.emptyList() : Collections.unmodifiableList(arguments);
    }

    public void addArgument(final Argument arg) {
        if (arguments == null) {
            arguments = new ArrayList<>();
        }
        arguments.add(arg);
    }

    public boolean isSetof() {
        return setof;
    }

    public void setSetof(final boolean setof) {
        this.setof = setof;
    }

    public List<Argument> getOrderBy() {
        return orderBy == null ? Collections.emptyList() : Collections.unmodifiableList(orderBy);
    }

    public void addOrderBy(final Argument type) {
        if (orderBy == null) {
            orderBy = new ArrayList<>();
        }
        orderBy.add(type);
    }

    @Override
    public String getReturns() {
        return returns;
    }

    public void setReturns(String returns) {
        this.returns = returns;
    }

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
     * Returns function signature. It consists of unquoted name and argument
     * data types.
     *
     * @return function signature
     */
    public String getSignature() {
        if (signatureCache == null) {
            signatureCache = appendFunctionSignature().toString();
        }
        return signatureCache;
    }

    public StringBuilder appendFunctionSignature() {
        StringBuilder sb = new StringBuilder();

        if (signatureCache != null) {
            return sb.append(signatureCache);
        }
        final int sigStart = sb.length();

        sb.append(PgDiffUtils.getQuotedName(name)).append('(');
        boolean addComma = false;
        for (final Argument argument : getArguments()) {
            if ("OUT".equalsIgnoreCase(argument.getMode())) {
                continue;
            }
            if (addComma) {
                sb.append(", ");
            }
            sb.append(getDeclaration(argument, false, false));
            addComma = true;
        }
        sb.append(')');

        signatureCache = sb.substring(sigStart, sb.length());

        return sb;
    }

    @Override
    public PgSystemSchema getContainingSchema() {
        return (PgSystemSchema) getParent();
    }

    public String getDeclaration(Argument arg, boolean includeDefaultValue, boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        String mode = arg.getMode();
        if (mode != null && !"IN".equalsIgnoreCase(mode)) {
            sbString.append(mode);
            sbString.append(' ');
        }

        String name = arg.getName();

        if (name != null && !name.isEmpty() && includeArgName) {
            sbString.append(PgDiffUtils.getQuotedName(name));
            sbString.append(' ');
        }

        sbString.append(arg.getDataType());

        String def = arg.getDefaultExpression();

        if (includeDefaultValue && def != null && !def.isEmpty()) {
            sbString.append(" = ");
            sbString.append(def);
        }

        return sbString.toString();
    }
}
