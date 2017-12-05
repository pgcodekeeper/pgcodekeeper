package cz.startnet.utils.pgdiff.schema.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemFunction extends PgSystemStatement {

    private static final long serialVersionUID = -7905948011960006249L;

    private final List<PgSystemArgument> signature = new ArrayList<>();

    /**
     * Order by for aggregate functions
     */
    private final List<PgSystemArgument> orderBy = new ArrayList<>();

    /**
     * Function return type name, if null
     * {@link PgSystemStatement#columns columns} contains columns
     */
    private String returnType;
    private boolean setof;

    public PgSystemFunction(final String schema, final String name) {
        super(schema, name, DbObjType.FUNCTION);
    }

    public List<PgSystemArgument> getSignature() {
        return signature;
    }

    public void addSignaturePart(final PgSystemArgument arg) {
        signature.add(arg);
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

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public static class PgSystemArgument {

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

        public String getDataType() {
            return dataType;
        }

        public String getDefaultExpression() {
            return defaultExpression;
        }

        public void setDefaultExpression(final String defaultExpression) {
            this.defaultExpression = defaultExpression;
        }

        public String getMode() {
            return mode;
        }

        public String getName() {
            return name;
        }

        public String getDeclaration(boolean includeDefaultValue, boolean includeArgName) {
            final StringBuilder sbString = new StringBuilder();

            if (mode != null && !"IN".equalsIgnoreCase(mode)) {
                sbString.append(mode);
                sbString.append(' ');
            }

            if (name != null && !name.isEmpty() && includeArgName) {
                sbString.append(PgDiffUtils.getQuotedName(name));
                sbString.append(' ');
            }

            sbString.append(dataType);

            if (includeDefaultValue && defaultExpression != null
                    && !defaultExpression.isEmpty()) {
                sbString.append(" = ");
                sbString.append(defaultExpression);
            }

            return sbString.toString();
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
