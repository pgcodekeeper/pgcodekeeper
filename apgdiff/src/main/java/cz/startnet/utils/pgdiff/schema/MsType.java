package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public class MsType extends AbstractType {

    // base type
    private String baseType;
    private boolean isNotNull;

    // assembly type
    private String assemblyName;
    private String assemblyClass;

    // table type
    private boolean isMemoryOptimized;
    private final List<String> columns = new ArrayList<>();
    private final List<String> constraints = new ArrayList<>();
    private final List<String> indices = new ArrayList<>();


    public MsType(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder("CREATE TYPE ").append(getQualifiedName());

        if (getBaseType() != null) {
            sb.append(" FROM ").append(getBaseType());
            if (isNotNull()) {
                sb.append(" NOT NULL");
            }
        } else if (getAssemblyName() != null) {
            sb.append("\nEXTERNAL NAME ").append(MsDiffUtils.quoteName(getAssemblyName()))
            .append('.').append(MsDiffUtils.quoteName(getAssemblyClass()));
        } else {
            sb.append(" AS TABLE(");
            for (String col : columns) {
                sb.append("\n\t");
                sb.append(col);
                sb.append(",");
            }

            if (!columns.isEmpty()) {
                sb.setLength(sb.length() - 1);
            }

            for (String ind : indices) {
                sb.append(",\n\t").append(ind);
            }

            for (String con : constraints) {
                sb.append(",\n\t").append(con);
            }

            sb.append("\n)");

            if (isMemoryOptimized()) {
                sb.append("\nWITH ( MEMORY_OPTIMIZED = ON )");
            }
        }

        sb.append(GO);

        appendOwnerSQL(sb);
        appendPrivileges(sb);

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsType newType = (MsType) newCondition;

        if (!compareUnalterable(newType)) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(getOwner(), newType.getOwner())) {
            newType.alterOwnerSQL(sb);
        }
        alterPrivileges(newType, sb);

        return sb.length() > startLength;
    }

    private boolean compareUnalterable(MsType newType) {
        boolean equals = false;

        if (this == newType) {
            equals = true;
        } else {
            equals = isNotNull() == newType.isNotNull()
                    && isMemoryOptimized() == newType.isMemoryOptimized()
                    && Objects.equals(getBaseType(), newType.getBaseType())
                    && Objects.equals(getAssemblyName(), newType.getAssemblyName())
                    && Objects.equals(getAssemblyClass(), newType.getAssemblyClass())
                    && columns.equals(newType.columns)
                    && PgDiffUtils.setlikeEquals(indices, newType.indices)
                    && PgDiffUtils.setlikeEquals(constraints, newType.constraints);
        }

        return equals;
    }

    @Override
    public String getDropSQL() {
        return "DROP TYPE " + getQualifiedName() + GO;
    }

    @Override
    protected AbstractType getTypeCopy() {
        MsType copy = new MsType(getName());
        copy.setNotNull(isNotNull());
        copy.setMemoryOptimized(isMemoryOptimized());
        copy.setBaseType(getBaseType());
        copy.setAssemblyName(getAssemblyName());
        copy.setAssemblyClass(getAssemblyClass());
        copy.columns.addAll(columns);
        copy.indices.addAll(indices);
        copy.constraints.addAll(constraints);
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MsType) {
            MsType type = (MsType) obj;
            return super.compare(type) && compareUnalterable(type);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(isNotNull);
        hasher.put(isMemoryOptimized);
        hasher.put(baseType);
        hasher.put(assemblyName);
        hasher.put(assemblyClass);
        hasher.put(columns);
        hasher.put(indices);
        hasher.put(constraints);
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
        resetHash();
    }

    public boolean isNotNull() {
        return isNotNull;
    }

    public void setNotNull(boolean isNotNull) {
        this.isNotNull = isNotNull;
        resetHash();
    }

    public String getAssemblyName() {
        return assemblyName;
    }

    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
        resetHash();
    }

    public String getAssemblyClass() {
        return assemblyClass;
    }

    public void setAssemblyClass(String assemblyClass) {
        this.assemblyClass = assemblyClass;
        resetHash();
    }

    public boolean isMemoryOptimized() {
        return isMemoryOptimized;
    }

    public void setMemoryOptimized(boolean isMemoryOptimized) {
        this.isMemoryOptimized = isMemoryOptimized;
        resetHash();
    }

    public List<String> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    public void addColumn(String column) {
        columns.add(column);
        resetHash();
    }

    public List<String> getConstraints() {
        return Collections.unmodifiableList(constraints);
    }

    public void addConstraint(String constraint) {
        constraints.add(constraint);
        resetHash();
    }

    public List<String> getIndices() {
        return Collections.unmodifiableList(indices);
    }

    public void addIndex(String index) {
        indices.add(index);
        resetHash();
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
