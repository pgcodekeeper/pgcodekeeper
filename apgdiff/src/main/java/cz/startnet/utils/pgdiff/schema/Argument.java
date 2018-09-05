package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.hashers.IHashable;
import cz.startnet.utils.pgdiff.hashers.JavaHasher;

/**
 * Subclass when need to reset hashes
 * (like when setting hashed fields after adding the arg to its container).
 */
public class Argument implements Serializable, IHashable {

    private static final long serialVersionUID = 7466228261754446064L;

    private final String mode;
    private final String name;
    private final String dataType;
    private String defaultExpression;
    private boolean isVarying;
    private boolean isReadOnly;

    public Argument(String name, String dataType) {
        this(null, name, dataType);
    }

    public Argument(String mode, String name, String dataType) {
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

    public boolean isVarying() {
        return isVarying;
    }

    public void setVarying(final boolean isVarying) {
        this.isVarying = isVarying;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(final boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
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

    // ms function
    /*
    @Override
    public String getDeclaration(boolean includeDefaultValue,
            boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();
        sbString.append(getName()).append(' ').append(getDataType());

        if (includeDefaultValue && getDefaultExpression() != null
                && !getDefaultExpression().isEmpty()) {
            sbString.append(" = ");
            sbString.append(getDefaultExpression());
        }

        if (getMode() != null && !"IN".equalsIgnoreCase(getMode())) {
            sbString.append(' ').append(getMode());
        }


        return sbString.toString();
    }

     */


    // ms proc
    /*
    @Override
    public String getDeclaration(boolean includeDefaultValue,
            boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        if (getName() != null && !getName().isEmpty() && includeArgName) {
            sbString.append(getName());
            sbString.append(' ');
        }

        sbString.append(getDataType());

        if (isVarying()) {
            sbString.append(" VARYING");
        }

        if (includeDefaultValue && getDefaultExpression() != null
                && !getDefaultExpression().isEmpty()) {
            sbString.append(" = ");
            sbString.append(getDefaultExpression());
        }

        if (getMode() != null && !"IN".equalsIgnoreCase(getMode())) {
            sbString.append(' ');
            sbString.append(getMode());
        }

        if (isReadOnly()) {
            sbString.append(" READONLY");
        }

        return sbString.toString();
    }


        public boolean isVarying() {
            return isVarying;
        }

        public void setVarying(final boolean isVarying) {
            this.isVarying = isVarying;
            resetHash();
        }

        public boolean isReadOnly() {
            return isReadOnly;
        }

        public void setReadOnly(final boolean isReadOnly) {
            this.isReadOnly = isReadOnly;
            resetHash();
        }
     */

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
                    && isReadOnly == arg.isReadOnly()
                    && isVarying == arg.isVarying()
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
        hasher.put(isReadOnly);
        hasher.put(isVarying);
    }
}
