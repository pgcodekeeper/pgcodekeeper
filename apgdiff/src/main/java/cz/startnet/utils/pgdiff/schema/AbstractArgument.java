package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgFunction.Argument;

public abstract class AbstractArgument implements IArgument {
    private final String mode;
    private final String name;
    private final String dataType;
    private String defaultExpression;

    public AbstractArgument(String name, String dataType) {
        this(null, name, dataType);
    }

    public AbstractArgument(String mode, String name, String dataType) {
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
        } else if(obj instanceof Argument) {
            final Argument arg = (Argument) obj;
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
