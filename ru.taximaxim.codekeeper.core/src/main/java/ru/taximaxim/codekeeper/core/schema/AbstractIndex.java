/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

/**
 * Stores table index information.
 */
public abstract class AbstractIndex extends PgStatement
implements ISimpleOptionContainer, ISimpleColumnContainer, ISearchPath {

    private String where;
    private String tablespace;
    private boolean unique;
    private boolean isClustered;

    protected final List<SimpleColumn> columns = new ArrayList<>();
    protected final List<String> includes = new ArrayList<>();
    protected final Map<String, String> options = new LinkedHashMap<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.INDEX;
    }

    protected AbstractIndex(String name) {
        super(name);
    }

    public boolean isClustered() {
        return isClustered;
    }

    public void setClustered(boolean isClustered) {
        this.isClustered = isClustered;
        resetHash();
    }

    @Override
    public void addColumn(SimpleColumn column) {
        columns.add(column);
        resetHash();
    }

    public boolean compareColumns(Set<String> refs) {
        if (refs.size() != columns.size()) {
            return false;
        }
        int i = 0;
        for (String ref : refs) {
            if (!ref.equals(columns.get(i++).getName())) {
                return false;
            }
        }
        return true;
    }

    public void addInclude(String column) {
        includes.add(column);
        resetHash();
    }

    public List<String> getIncludes() {
        return Collections.unmodifiableList(includes);
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(final boolean unique) {
        this.unique = unique;
        resetHash();
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(final String where) {
        this.where = where;
        resetHash();
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(String tableSpace) {
        this.tablespace = tableSpace;
        resetHash();
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String key, String value) {
        options.put(key, value);
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractIndex && super.compare(obj)) {
            AbstractIndex index = (AbstractIndex) obj;
            return compareUnalterable(index)
                    && isClustered == index.isClustered()
                    && Objects.equals(tablespace, index.getTablespace())
                    && Objects.equals(options, index.options);
        }

        return false;
    }

    protected boolean compareUnalterable(AbstractIndex index) {
        return Objects.equals(columns, index.columns)
                && Objects.equals(where, index.where)
                && Objects.equals(includes, index.includes)
                && unique == index.isUnique();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(columns);
        hasher.put(unique);
        hasher.put(isClustered);
        hasher.put(where);
        hasher.put(tablespace);
        hasher.put(options);
        hasher.put(includes);
    }

    @Override
    public AbstractIndex shallowCopy() {
        AbstractIndex indexDst = getIndexCopy();
        copyBaseFields(indexDst);
        indexDst.setUnique(isUnique());
        indexDst.setClustered(isClustered());
        indexDst.setWhere(getWhere());
        indexDst.setTablespace(getTablespace());
        indexDst.columns.addAll(columns);
        indexDst.options.putAll(options);
        indexDst.includes.addAll(includes);
        return indexDst;
    }

    protected void appendWhere(StringBuilder sbSQL) {
        if (where != null) {
            sbSQL.append("\nWHERE ").append(getWhere());
        }
    }

    protected abstract AbstractIndex getIndexCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }

    @Override
    public boolean isSubElement() {
        return true;
    }
}
