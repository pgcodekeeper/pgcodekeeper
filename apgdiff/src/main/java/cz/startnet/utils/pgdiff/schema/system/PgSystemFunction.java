package cz.startnet.utils.pgdiff.schema.system;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.AbstractArgument;
import cz.startnet.utils.pgdiff.schema.IArgument;
import cz.startnet.utils.pgdiff.schema.IFunction;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemFunction extends PgSystemStatement implements IFunction {

    private static final long serialVersionUID = -7905948011960006249L;

    private final List<PgSystemArgument> arguments = new ArrayList<>();
    private transient String signatureCache;

    /**
     * Order by for aggregate functions
     */
    private final List<PgSystemArgument> orderBy = new ArrayList<>();

    /**
     *  Contains table's columns, if function returns table.
     */
    private final Map<String, String> returnsColumns = new LinkedHashMap<>();

    /**
     * Function return type name, if null columns contains columns
     */
    private String returns;
    private boolean setof;

    public PgSystemFunction(final String name) {
        super(name, DbObjType.FUNCTION);
    }

    public Map<String, String> getReturnsColumns() {
        return returnsColumns;
    }

    public void addReturnsColumns(String name, String type) {
        returnsColumns.put(name, type);
    }

    @Override
    public String getBareName() {
        return name;
    }

    @Override
    public List<PgSystemArgument> getArguments() {
        return arguments;
    }

    public void addArgument(final PgSystemArgument arg) {
        arguments.add(arg);
    }

    public boolean isSetof() {
        return setof;
    }

    public void setSetof(final boolean setof) {
        this.setof = setof;
    }

    public List<PgSystemArgument> getOrderBy() {
        return orderBy;
    }

    public void addOrderBy(final PgSystemArgument type) {
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
        for (final IArgument argument : arguments) {
            if ("OUT".equalsIgnoreCase(argument.getMode())) {
                continue;
            }
            if (addComma) {
                sb.append(", ");
            }
            sb.append(argument.getDeclaration(false, false));
            addComma = true;
        }
        sb.append(')');

        signatureCache = sb.substring(sigStart, sb.length());

        return sb;
    }

    public static class PgSystemArgument extends AbstractArgument {

        private static final long serialVersionUID = -4230871703844831688L;

        public PgSystemArgument(String name, String dataType) {
            super(name, dataType);
        }

        public PgSystemArgument(String mode, String name, String dataType) {
            super(mode, name, dataType);
        }
    }
}
