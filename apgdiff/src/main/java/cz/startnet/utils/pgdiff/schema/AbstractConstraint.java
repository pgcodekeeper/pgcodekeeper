/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table constraint information.
 */
public abstract class AbstractConstraint extends PgStatementWithSearchPath implements IConstraint {

    private String definition;
    private boolean unique;
    private boolean isPrimaryKey;
    private final Set<String> columns = new HashSet<>();
    private GenericColumn refTable;
    private final Set<String> refs = new HashSet<>();
    private boolean notValid;

    /**
     * Список колонок на которых установлен PrimaryKey или Unique
     */
    @Override
    public Set<String> getColumns() {
        return Collections.unmodifiableSet(columns);
    }

    /**
     * Добавить колонку к списку колонок PrimaryKey или Unique
     */
    public void addColumn(String genericColumn) {
        columns.add(genericColumn);
    }

    public Set<String> getForeignColumns() {
        return Collections.unmodifiableSet(refs);
    }

    public void addForeignColumn(String referencedColumn) {
        refs.add(referencedColumn);
    }

    public GenericColumn getForeignTable() {
        return refTable;
    }

    public void setForeignTable(GenericColumn foreignTable) {
        if (foreignTable != null && (foreignTable.type != DbObjType.TABLE || foreignTable.column != null)) {
            throw new IllegalArgumentException("Incorrect foreign table ref!");
        }
        this.refTable = foreignTable;
    }

    @Override
    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    @Override
    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public boolean isNotValid() {
        return notValid;
    }

    public void setNotValid(boolean notValid) {
        this.notValid = notValid;
        resetHash();
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.CONSTRAINT;
    }

    public AbstractConstraint(String name) {
        super(name);
    }

    public void setDefinition(final String definition) {
        this.definition = definition;
        resetHash();
    }

    public String getDefinition() {
        return definition;
    }

    @Override
    public PgObjLocation getLocation() {
        PgObjLocation location = getMeta().getLocation();
        if (location == null) {
            location = getParent().getLocation();
        }
        return location;
    }

    @Override
    public void setLocation(PgObjLocation location) {
        getMeta().setLocation(location);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof AbstractConstraint && super.compare(obj)
                && Objects.equals(definition, ((AbstractConstraint) obj).getDefinition())
                && notValid == ((AbstractConstraint) obj).isNotValid();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(definition);
        hasher.put(notValid);
    }

    @Override
    public AbstractConstraint shallowCopy() {
        AbstractConstraint constraintDst = getConstraintCopy();
        copyBaseFields(constraintDst);
        constraintDst.setDefinition(getDefinition());
        constraintDst.setPrimaryKey(isPrimaryKey());
        constraintDst.setUnique(isUnique());
        constraintDst.columns.addAll(columns);
        constraintDst.setForeignTable(getForeignTable());
        constraintDst.refs.addAll(refs);
        constraintDst.setNotValid(isNotValid());
        return constraintDst;
    }

    protected abstract AbstractConstraint getConstraintCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }
}