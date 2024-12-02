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
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Stores table information.
 */
public abstract class AbstractTable extends PgStatementContainer implements IOptionContainer {

    protected static final String ALTER_COLUMN = " ALTER COLUMN ";

    protected final List<AbstractColumn> columns = new ArrayList<>();
    protected final Map<String, String> options = new LinkedHashMap<>();

    private final Map<String, AbstractConstraint> constraints = new LinkedHashMap<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TABLE;
    }

    protected AbstractTable(String name) {
        super(name);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(constraints.values());
    }

    public static Stream<PgStatement> columnAdder(PgStatement st) {
        Stream<PgStatement> newStream = Stream.of(st);
        if (st.getStatementType() == DbObjType.TABLE) {
            newStream = Stream.concat(newStream, ((AbstractTable)st).getColumns().stream());
        }

        return newStream;
    }

    /**
     * Generates beginning of alter table statement.
     * @param only - if true, append 'only' to statement
     *
     * @return alter table statement beginning in String format
     */
    public abstract String getAlterTable(boolean only);

    /**
     * Finds column according to specified column {@code name}.
     *
     * @param name name of the column to be searched
     *
     * @return found column or null if no such column has been found
     */
    public AbstractColumn getColumn(final String name) {
        for (AbstractColumn column : columns) {
            if (column.getName().equals(name)) {
                return column;
            }
        }
        return null;
    }

    /**
     * Getter for {@link #columns}. The list cannot be modified.
     *
     * @return {@link #columns}
     */
    public List<AbstractColumn> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return columns.stream().filter(c -> c.getType() != null)
                .map(c -> new Pair<>(c.getName(), c.getType()));
    }

    @Override
    public AbstractConstraint getConstraint(final String name) {
        return constraints.get(name);
    }

    /**
     * Getter for {@link #constraints}. The list cannot be modified.
     *
     * @return {@link #constraints}
     */
    @Override
    public Collection<AbstractConstraint> getConstraints() {
        return Collections.unmodifiableCollection(constraints.values());
    }

    protected boolean isColumnsOrderChanged(AbstractTable newTable) {
        if (getDatabaseArguments().isIgnoreColumnOrder()) {
            return false;
        }

        return StatementUtils.isColumnsOrderChanged(newTable.getColumns(), columns);
    }

    protected void appendColumnsPriliges(Collection<SQLAction> createActions) {
        for (AbstractColumn col : columns) {
            col.appendPrivileges(createActions);
        }
    }

    public final boolean isRecreated(AbstractTable newTable) {
        return isNeedRecreate(newTable) || isColumnsOrderChanged(newTable);
    }

    protected abstract boolean isNeedRecreate(AbstractTable newTable);

    @Override
    public Map <String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    public String getOption(String option) {
        return options.get(option);
    }

    @Override
    public void addOption(String option, String value) {
        options.put(option, value);
        resetHash();
    }

    public void addColumn(final AbstractColumn column) {
        assertUnique(getColumn(column.getName()), column);
        columns.add(column);
        column.setParent(this);
        resetHash();
    }

    @Override
    public void addConstraint(final AbstractConstraint constraint) {
        addUnique(constraints, constraint);
    }

    public boolean containsColumn(final String name) {
        return getColumn(name) != null;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractTable table && super.compare(obj)) {
            boolean isColumnsEqual;
            if (getDatabaseArguments().isIgnoreColumnOrder()) {
                isColumnsEqual = PgDiffUtils.setlikeEquals(columns, table.columns);
            } else {
                isColumnsEqual = columns.equals(table.columns);
            }

            return isColumnsEqual
                    && getClass().equals(table.getClass())
                    && options.equals(table.options);
        }

        return false;
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof AbstractTable table && super.compareChildren(obj)) {
            return constraints.equals(table.constraints);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(constraints);
    }

    @Override
    public void computeHash(Hasher hasher) {
        if (getDatabaseArguments().isIgnoreColumnOrder()) {
            hasher.putUnordered(columns);
        } else {
            hasher.putOrdered(columns);
        }
        hasher.put(options);
    }

    @Override
    public AbstractTable shallowCopy() {
        AbstractTable tableDst =  (AbstractTable) super.shallowCopy();
        copyBaseFields(tableDst);
        for (AbstractColumn colSrc : columns) {
            tableDst.addColumn((AbstractColumn) colSrc.deepCopy());
        }
        tableDst.options.putAll(options);
        return tableDst;
    }

    @Override
    protected PgStatementContainer getCopy() {
        return getTableCopy();
    }

    protected abstract AbstractTable getTableCopy();
}
