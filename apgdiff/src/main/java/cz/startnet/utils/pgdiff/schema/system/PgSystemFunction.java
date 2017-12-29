package cz.startnet.utils.pgdiff.schema.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cz.startnet.utils.pgdiff.schema.IArgument;
import cz.startnet.utils.pgdiff.schema.IFunction;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemFunction extends PgSystemStatement implements IFunction, Serializable {

    private static final long serialVersionUID = -7905948011960006249L;

    private final List<IArgument> arguments = new ArrayList<>();

    /**
     * Order by for aggregate functions
     */
    private final List<PgSystemArgument> orderBy = new ArrayList<>();
    private final Map<String, String> columns = new LinkedHashMap<>();

    /**
     * Function return type name, if null columns contains columns
     */
    private String returns;
    private boolean setof;

    public PgSystemFunction(final String name) {
        super(name, DbObjType.FUNCTION);
    }

    public Map<String, String> getColumns() {
        return columns;
    }

    public void addColumn(String name, String type) {
        columns.put(name, type);
    }

    @Override
    public String getBareName() {
        return name;
    }

    @Override
    public List<IArgument> getArguments() {
        return arguments;
    }

    public void addArgumentPart(final PgSystemArgument arg) {
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

    public void addOrderByPart(final PgSystemArgument type) {
        orderBy.add(type);
    }

    @Override
    public String getReturns() {
        return returns;
    }

    public void setReturns(String returns) {
        this.returns = returns;
    }

    public static class PgSystemArgument implements IArgument {

        private static final long serialVersionUID = -2474167798261721854L;

        private final String mode;
        private final String name;
        private final String dataType;
        private String defaultExpression;

        public PgSystemArgument(String name, String dataType) {
            this(null, name, dataType);
        }

        public PgSystemArgument(String mode, String name, String dataType) {
            this.mode = mode == null || mode.isEmpty() ? "IN" : mode;
            this.name = (name != null && name.isEmpty()) ? null : name;
            this.dataType = dataType;
        }

        @Override
        public String getDataType() {
            return dataType;
        }

        @Override
        public String getDefaultExpression() {
            return defaultExpression;
        }

        @Override
        public void setDefaultExpression(final String defaultExpression) {
            this.defaultExpression = defaultExpression;
        }

        @Override
        public String getMode() {
            return mode;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            boolean eq = false;

            if(this == obj) {
                eq = true;
            } else if(obj instanceof PgSystemArgument) {
                final PgSystemArgument arg = (PgSystemArgument) obj;
                eq = Objects.equals(dataType, arg.getDataType())
                        && Objects.equals(defaultExpression, arg.getDefaultExpression())
                        && Objects.equals(mode, arg.getMode())
                        && Objects.equals(name, arg.getName());
            }

            return eq;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
            result = prime * result
                    + ((defaultExpression == null) ? 0 : defaultExpression.hashCode());
            result = prime * result + ((mode == null) ? 0 : mode.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }
    }
}
