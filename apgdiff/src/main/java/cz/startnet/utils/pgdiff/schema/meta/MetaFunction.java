package cz.startnet.utils.pgdiff.schema.meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.ArgMode;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MetaFunction extends MetaStatement implements IFunction {

    private static final long serialVersionUID = -585518205768372673L;

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

    public MetaFunction(PgObjLocation object) {
        super(object);
    }

    public MetaFunction(String schemaName, String name) {
        super(new GenericColumn(schemaName, name, DbObjType.FUNCTION));
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
        return super.getName();
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
            signatureCache = getFunctionSignature();
        }
        return signatureCache;
    }

    private String getFunctionSignature() {
        StringBuilder sb = new StringBuilder();

        sb.append(PgDiffUtils.getQuotedName(getBareName())).append('(');
        boolean addComma = false;
        for (final Argument argument : getArguments()) {
            ArgMode mode = argument.getMode();
            if (ArgMode.OUT == mode) {
                continue;
            }
            if (addComma) {
                sb.append(", ");
            }

            if (ArgMode.IN != mode) {
                sb.append(mode);
                sb.append(' ');
            }

            sb.append(argument.getDataType());
            addComma = true;
        }
        sb.append(')');

        return sb.toString();
    }

    @Override
    public MetaSchema getContainingSchema() {
        return (MetaSchema) getParent();
    }

    @Override
    public MetaStatement getCopy() {
        MetaFunction copy = new MetaFunction(getObject());
        getArguments().forEach(copy::addArgument);
        getOrderBy().forEach(copy::addArgument);
        getReturnsColumns().forEach(copy::addReturnsColumn);
        copy.setReturns(getReturns());
        copy.setSetof(isSetof());
        return copy;
    }
}
