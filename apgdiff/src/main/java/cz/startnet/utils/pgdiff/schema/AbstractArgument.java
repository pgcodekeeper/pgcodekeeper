package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.hashers.IHashable;
import cz.startnet.utils.pgdiff.hashers.JavaHasher;

public abstract class AbstractArgument implements IArgument, Serializable, IHashable {

    private static final long serialVersionUID = 7466228261754446064L;

    protected final String mode;
    protected final String name;
    protected final String dataType;
    protected String defaultExpression;

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
        } else if(obj instanceof AbstractArgument) {
            final AbstractArgument arg = (AbstractArgument) obj;
            eq = Objects.equals(dataType, arg.getDataType())
                    && Objects.equals(defaultExpression, arg.getDefaultExpression())
                    && Objects.equals(mode, arg.getMode())
                    && Objects.equals(name, arg.getName());
        }

        return eq;
    }

    @Override
    public int hashCode() {
        JavaHasher hasher = new JavaHasher();
        computeHash(hasher);
        return hasher.getResult();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(dataType);
        hasher.put(defaultExpression);
        hasher.put(mode);
        hasher.put(name);
    }
}
