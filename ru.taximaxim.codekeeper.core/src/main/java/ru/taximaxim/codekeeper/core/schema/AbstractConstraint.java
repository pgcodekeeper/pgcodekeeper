/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

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
    private boolean isClustered;
    private boolean notValid;

    protected AbstractConstraint(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.CONSTRAINT;
    }

    /**
     * Список колонок на которых установлен PrimaryKey или Unique
     */
    @Override
    public Set<String> getColumns() {
        return Collections.unmodifiableSet(columns);
    }

    /**
     * Adds column to columns list for PK or Unique
     *
     * @param column
     *            - column name
     */
    public void addColumn(String column) {
        columns.add(column);
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

    public boolean isClustered() {
        return isClustered;
    }

    public void setClustered(boolean isClustered) {
        this.isClustered = isClustered;
        resetHash();
    }

    public boolean isNotValid() {
        return notValid;
    }

    public void setNotValid(boolean notValid) {
        this.notValid = notValid;
        resetHash();
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
                && notValid == ((AbstractConstraint) obj).isNotValid()
                && isClustered == ((AbstractConstraint) obj).isClustered;
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
        constraintDst.setClustered(isClustered());
        return constraintDst;
    }

    protected abstract AbstractConstraint getConstraintCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }

    @Override
    public String getTableName() {
        return getParent().getName();
    }
}