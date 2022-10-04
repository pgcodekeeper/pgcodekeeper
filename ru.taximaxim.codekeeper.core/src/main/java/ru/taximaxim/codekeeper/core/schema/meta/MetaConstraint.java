package ru.taximaxim.codekeeper.core.schema.meta;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ru.taximaxim.codekeeper.core.schema.IConstraint;
import ru.taximaxim.codekeeper.core.schema.ISchema;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class MetaConstraint extends MetaStatement implements IConstraint {

    private static final long serialVersionUID = 7375924980206798486L;

    private boolean isUnique;
    private boolean isPrimaryKey;
    private final Set<String> columns = new HashSet<>();

    public MetaConstraint(PgObjLocation object) {
        super(object);
    }

    @Override
    public boolean isUnique() {
        return isUnique;
    }

    @Override
    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    @Override
    public Set<String> getColumns() {
        return Collections.unmodifiableSet(columns);
    }

    public void setUnique(boolean isUnique) {
        this.isUnique = isUnique;
    }

    public void setPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public void addColumn(String column) {
        columns.add(column);
    }

    @Override
    public ISchema getContainingSchema() {
        throw new IllegalStateException("Unsupported operation");
    }

    @Override
    public String getSchemaName() {
        return getObject().getSchema();
    }

    @Override
    public String getTableName() {
        return getObject().getTable();
    }
}
