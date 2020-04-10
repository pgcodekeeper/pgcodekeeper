package cz.startnet.utils.pgdiff.schema.meta;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IConstraint;

public class MetaConstraint extends MetaStatement implements IConstraint {

    private static final long serialVersionUID = -8009680478870666859L;

    private boolean isUnique;
    private boolean isPrimaryKey;
    private final transient Set<String> columns = new HashSet<>();

    public MetaConstraint(GenericColumn object) {
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
    public MetaSchema getContainingSchema() {
        MetaStatement parent = getParent();
        if (parent != null) {
            return (MetaSchema) parent.getParent();
        }

        return null;
    }

}
