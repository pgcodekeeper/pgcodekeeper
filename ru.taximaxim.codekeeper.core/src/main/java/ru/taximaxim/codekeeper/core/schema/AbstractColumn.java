/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

/**
 * Stores column information.
 */
public abstract class AbstractColumn extends PgStatement implements ISearchPath {

    protected static final String ALTER_COLUMN = "\n\tALTER COLUMN ";
    protected static final String COLLATE = " COLLATE ";
    protected static final String NULL = " NULL";
    protected static final String NOT_NULL = " NOT NULL";

    protected String type;
    protected String collation;
    protected boolean nullValue = true;
    protected String defaultValue;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.COLUMN;
    }

    protected AbstractColumn(String name) {
        super(name);
    }

    public void setDefaultValue(final String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Returns full definition of the column.
     *
     * @return full definition of the column
     */
    public abstract String getFullDefinition();

    public void setNullValue(final boolean nullValue) {
        this.nullValue = nullValue;
        resetHash();
    }

    public boolean getNullValue() {
        return nullValue;
    }

    public void setType(final String type) {
        this.type = type;
        resetHash();
    }

    public String getType() {
        return type;
    }

    public void setCollation(final String collation) {
        this.collation = collation;
        resetHash();
    }

    public String getCollation() {
        return collation;
    }

    @Override
    public PgObjLocation getLocation() {
        PgObjLocation location = meta.getLocation();
        if (location == null) {
            location = parent.getLocation();
        }
        return location;
    }

    @Override
    public void setLocation(PgObjLocation location) {
        meta.setLocation(location);
    }

    protected String getAlterTable(boolean only) {
        return ((AbstractTable) parent).getAlterTable(only);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractColumn col && super.compare(obj)) {
            return  Objects.equals(type, col.type)
                    && Objects.equals(collation, col.collation)
                    && nullValue == col.nullValue
                    && Objects.equals(defaultValue, col.defaultValue);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(type);
        hasher.put(collation);
        hasher.put(nullValue);
        hasher.put(defaultValue);
    }

    @Override
    public AbstractColumn shallowCopy() {
        AbstractColumn colDst = getColumnCopy();
        copyBaseFields(colDst);
        colDst.setType(type);
        colDst.setCollation(collation);
        colDst.setNullValue(nullValue);
        colDst.setDefaultValue(defaultValue);
        return colDst;
    }

    protected abstract AbstractColumn getColumnCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) parent.parent;
    }

    @Override
    public boolean isSubElement() {
        return true;
    }
}