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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.Inherits;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Base PostgreSQL table class
 *
 * @since 5.3.1.
 * @author galiev_mr
 */
public abstract class AbstractPgTable extends AbstractTable {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractPgTable.class);

    protected boolean hasOids;
    protected final List<Inherits> inherits = new ArrayList<>();

    protected AbstractPgTable(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        List<SQLAction> alterTableActions = new ArrayList<>();

        final StringBuilder sbSQL = new StringBuilder();

        appendName(sbSQL);
        appendColumns(sbSQL, alterTableActions);
        appendInherit(sbSQL);
        appendOptions(sbSQL);
        createActions.add(new SQLAction(sbSQL));

        createActions.addAll(alterTableActions);
        appendAlterOptions(createActions);

        appendOwnerSQL(createActions);
        appendPrivileges(createActions);
        appendColumnsPriliges(createActions);
        appendColumnsStatistics(createActions);
    }

    @Override
    public void appendComments(Collection<SQLAction> sqlActions) {
        super.appendComments(sqlActions);
        appendChildrenComments(sqlActions);
    }

    @Override
    protected void appendChildrenComments(Collection<SQLAction> sqlActions) {
        for (final AbstractColumn column : getColumns()) {
            column.appendComments(sqlActions);
        }
    }

    /**
     * Appends CREATE TABLE statement beginning
     * <br><br>
     * Expected:
     * <br><br>
     * CREATE [ [ GLOBAL | LOCAL ] { TEMPORARY | TEMP } | UNLOGGED | FOREIGN ] TABLE [ IF NOT EXISTS ] table_name
     *
     * @param sbSQL - StringBuilder for statement
     */
    protected abstract void appendName(StringBuilder sbSQl);

    /**
     * Fills columns and their options to create table statement. Options will
     * be appends after CREATE TABLE statement. <br>
     * Must be overridden by subclasses
     *
     * @param sbSQL - StringBuilder for columns
     * @param alterTableActions - collection for options
     */
    protected abstract void appendColumns(StringBuilder sbSQL, Collection<SQLAction> alterTableActions);

    /**
     * Fills tables parents, parents are stored in 'inherits' list.<br>
     * May be overridden by subclasses.
     * <br><br>
     * For example:
     * <br><br>
     * INHERITS (first_parent, schema_name.second_parent)
     *
     * @param sbSQL - StringBuilder for inherits
     */
    protected void appendInherit(StringBuilder sbSQL) {
        if (!inherits.isEmpty()) {
            sbSQL.append("\nINHERITS (");
            for (final Inherits tableName : inherits) {
                sbSQL.append(tableName.getQualifiedName());
                sbSQL.append(", ");
            }
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append(")");
        }
    }

    /**
     * Appends table storage parameters or server options, part of create statement;
     *
     * @param sbSQL - StringBuilder for options
     */
    protected abstract void appendOptions(StringBuilder sbSQL);

    /**
     * Appends <b>TABLE</b> options by alter table statement
     * <br><br>
     * For example:
     * <br><br>
     * ALTER TABLE table_name SET WITH OID;
     * <br>
     * @param sbSQL - StringBuilder for options
     */
    protected abstract void appendAlterOptions(Collection<SQLAction> sqlActions);

    protected void appendColumnsStatistics(Collection<SQLAction> createActions) {
        columns.stream().map(PgColumn.class::cast).filter(c -> c.getStatistics() != null)
        .forEach(column -> {
            SQLAction sql = new SQLAction();
            sql.append(getAlterTable(true));
            sql.append(ALTER_COLUMN);
            sql.append(PgDiffUtils.getQuotedName(column.getName()));
            sql.append(" SET STATISTICS ");
            sql.append(column.getStatistics());
            createActions.add(sql);
        });
    }

    protected PgSequence writeSequences(PgColumn column, StringBuilder sbOption, boolean newLine) {
        PgSequence sequence = column.getSequence();
        sbOption.append(getAlterTable(false))
        .append(ALTER_COLUMN)
        .append(PgDiffUtils.getQuotedName(column.getName()))
        .append(" ADD GENERATED ")
        .append(column.getIdentityType())
        .append(" AS IDENTITY (");
        sbOption.append("\n\tSEQUENCE NAME ").append(sequence.getQualifiedName());
        sequence.fillSequenceBody(sbOption);
        sbOption.append("\n);");
        return sequence;
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        AbstractPgTable newTable = (AbstractPgTable) newCondition;

        if (isRecreated(newTable)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        compareTableTypes(newTable, alterActions);
        compareInherits(newTable, alterActions);
        compareOptions(newTable, alterActions);
        compareOwners(newTable, alterActions);
        compareTableOptions(newTable, alterActions);
        alterPrivileges(newTable, alterActions);
        appendAlterComments(newTable, alterActions);

        return getObjectState(alterActions);
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        if (options.equals(newTable.getOptions())) {
            return false;
        }

        // check greenplum options
        for (String gpOption : GP_OPTION_LIST) {
            if (!Objects.equals(getOption(gpOption), newTable.getOption(gpOption))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        Stream<Pair<String, String>> localColumns = super.getRelationColumns();
        if (inherits.isEmpty()) {
            return localColumns;
        }

        Stream<Pair<String, String>> inhColumns = Stream.empty();
        for (Inherits inht : inherits) {
            String schemaName = inht.getKey();
            AbstractSchema inhtSchema = schemaName == null ? getContainingSchema()
                    : getDatabase().getSchema(schemaName);
            if (inhtSchema != null) {
                String tableName = inht.getValue();
                AbstractTable inhtTable = inhtSchema.getTable(tableName);
                if (inhtTable != null) {
                    inhColumns = Stream.concat(inhColumns, inhtTable.getRelationColumns());
                } else {
                    LOG.warn("Inherit table not found: {}.{} ", schemaName, tableName);
                }
            } else {
                LOG.warn("Inherit schema not found: {}", schemaName);
            }
        }
        return Stream.concat(inhColumns, localColumns);
    }

    @Override
    protected boolean isColumnsOrderChanged(AbstractTable newTable) {
        // broken inherit algorithm
        if (newTable instanceof AbstractPgTable table && !(newTable instanceof TypedPgTable)
                && inherits.isEmpty() && table.inherits.isEmpty()) {
            return super.isColumnsOrderChanged(newTable);
        }

        return false;
    }

    /**
     * Compare <b>TABLE</b> options by alter table statement
     *
     * @param newTable - new table
     * @param sb - StringBuilder for statements
     */
    protected void compareTableOptions(AbstractPgTable newTable, Collection<SQLAction> createActions) {
        if (hasOids != newTable.getHasOids()) {
            SQLAction sql = new SQLAction();
            sql.append(getAlterTable(true))
            .append(" SET ")
            .append(newTable.getHasOids() ? "WITH" : "WITHOUT")
            .append(" OIDS");
            createActions.add(sql);
        }
    }

    protected void compareInherits(AbstractPgTable newTable, Collection<SQLAction> sqlActions) {
        List<Inherits> newInherits = newTable.getInherits();

        if (newTable instanceof PartitionPgTable) {
            return;
        }

        sqlActions.addAll(inherits.stream()
                .filter(e -> !newInherits.contains(e))
                .map(e -> getInheritsActions(e, "\n\tNO INHERIT "))
                .collect(Collectors.toSet()));

        sqlActions.addAll(newInherits.stream()
                .filter(e -> !inherits.contains(e))
                .map(e -> getInheritsActions(e, "\n\tINHERIT "))
                .collect(Collectors.toSet()));
    }

    private SQLAction getInheritsActions(Inherits inh, String state) {
        return new SQLAction().append(getAlterTable(false)).append(state).append(inh.getQualifiedName());
    }

    public void addInherits(final String schemaName, final String tableName) {
        inherits.add(new Inherits(schemaName, tableName));
        resetHash();
    }

    /**
     * Getter for {@link #inherits}.
     *
     * @return {@link #inherits}
     */
    public List<Inherits> getInherits() {
        return Collections.unmodifiableList(inherits);
    }

    public boolean getHasOids() {
        return hasOids;
    }

    public void setHasOids(final boolean hasOids) {
        this.hasOids = hasOids;
        resetHash();
    }

    /**
     * Sorts columns on table.
     * <br><br>
     * First the usual columns in the order of adding,
     * then sorted alphabetically the inheritance columns
     */
    public void sortColumns() {
        Collections.sort(columns, (e1, e2) ->  {
            boolean first = ((PgColumn) e1).isInherit();
            boolean second = ((PgColumn) e2).isInherit();
            if (first && second) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Boolean.compare(first, second);
            }
        });

        resetHash();
    }

    protected void writeColumn(PgColumn column, StringBuilder sbSQL, Collection<SQLAction> alterTableActions) {
        boolean isInherit = column.isInherit();
        if (isInherit) {
            fillInheritOptions(column, alterTableActions);
        } else {
            sbSQL.append("\t");
            sbSQL.append(column.getFullDefinition());
            sbSQL.append(",\n");
        }
        if (column.getStorage() != null) {
            SQLAction action = new SQLAction();
            action.append(getAlterTable(isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" SET STORAGE ")
            .append(column.getStorage());
            alterTableActions.add(action);
        }

        writeOptions(column, alterTableActions, isInherit);
        AbstractSequence sequence = column.getSequence();
        if (sequence != null) {
            StringBuilder sbSeq = new StringBuilder();
            if (getDatabaseArguments().isGenerateExistDoBlock()) {
                StringBuilder tmpSb = new StringBuilder();
                writeSequences(column, tmpSb, false);
                PgDiffUtils.appendSqlWrappedInDo(sbSeq, tmpSb, Consts.DUPLICATE_RELATION);
            } else {
                writeSequences(column, sbSeq, true);
                sbSeq.setLength(sbSeq.length() - 1);
            }
            alterTableActions.add(new SQLAction(sbSeq));
        }
    }

    private void fillInheritOptions(AbstractColumn column, Collection<SQLAction> alterTableActions) {
        if (!column.getNullValue()) {
            alterTableActions.add(getAlterColumn(column).append(" SET NOT NULL"));
        }
        if (column.getDefaultValue() != null) {
            SQLAction action = getAlterColumn(column)
                    .append(" SET DEFAULT ")
                    .append(column.getDefaultValue());
            alterTableActions.add(action);
        }
    }

    private SQLAction getAlterColumn(AbstractColumn column) {
        SQLAction action = new SQLAction();
        return action.append(getAlterTable(true)).append(ALTER_COLUMN)
                .append(PgDiffUtils.getQuotedName(column.getName()));
    }

    private void writeOptions(PgColumn column, Collection<SQLAction> alterTableActions, boolean isInherit) {
        Map<String, String> opts = column.getOptions();
        Map<String, String> fOpts = column.getForeignOptions();

        if (!opts.isEmpty()) {
            SQLAction action = new SQLAction();
            action.append(getAlterTable(isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" SET (");

            for (Entry<String, String> option : opts.entrySet()) {
                action.append(option.getKey());
                if (!option.getValue().isEmpty()) {
                    action.append('=').append(option.getValue());
                }
                action.append(", ");
            }
            action.reduce(2);
            action.append(")");
            alterTableActions.add(action);
        }

        if (!fOpts.isEmpty()) {
            SQLAction action = new SQLAction();
            action.append(getAlterTable(isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" OPTIONS (");

            for (Entry<String, String> option : fOpts.entrySet()) {
                action.append(option.getKey());
                if (!option.getValue().isEmpty()) {
                    action.append(' ').append(option.getValue());
                }
                action.append(", ");
            }
            action.reduce(2);
            action.append(")");
            alterTableActions.add(action);
        }
    }

    /**
     * Compare tables types and generate transform scripts for change tables type
     *
     * @param newTable - new table
     * @param sb - StringBuilder for statements
     */
    protected abstract void compareTableTypes(AbstractPgTable newTable, Collection<SQLAction> alterActions);

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof AbstractPgTable table && super.compare(obj)) {
            return hasOids == table.getHasOids()
                    && inherits.equals(table.inherits);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.putOrdered(inherits);
        hasher.put(hasOids);
    }

    @Override
    public AbstractTable shallowCopy() {
        AbstractPgTable copy = (AbstractPgTable) super.shallowCopy();
        copy.inherits.addAll(inherits);
        copy.setHasOids(getHasOids());
        return copy;
    }
}
