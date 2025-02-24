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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
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
import ru.taximaxim.codekeeper.core.script.SQLActionType;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Base PostgreSQL table class
 *
 * @since 5.3.1.
 * @author galiev_mr
 */
public abstract class AbstractPgTable extends AbstractTable {

    private static final String RESTART_SEQUENCE_QUERY = """
            DO LANGUAGE plpgsql $_$
            DECLARE restart_var bigint = (SELECT COALESCE(
                (SELECT nextval(pg_get_serial_sequence('%1$s', '%2$s'))),
                (SELECT MAX(%2$s) + 1 FROM %3$s),
                1));
            BEGIN
                EXECUTE $$ ALTER TABLE %3$s ALTER COLUMN %2$s RESTART WITH $$ || restart_var || ';' ;
            END
            $_$""";

    private static final String CHANGE_TRIGGER_STATE =
            "ALTER TABLE %1$s %2$s TRIGGER %3$s";

    private static final Logger LOG = LoggerFactory.getLogger(AbstractPgTable.class);

    protected boolean hasOids;
    protected final List<Inherits> inherits = new ArrayList<>();
    private Map<String, String> triggerStates = new HashMap<>();

    protected AbstractPgTable(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();

        SQLScript temp = new SQLScript(getDbType());

        appendName(sbSQL);
        appendColumns(sbSQL, temp);
        appendInherit(sbSQL);
        appendOptions(sbSQL);
        script.addStatement(sbSQL);

        script.addAllStatements(temp);
        appendAlterOptions(script);

        appendOwnerSQL(script);
        appendPrivileges(script);
        appendColumnsPriliges(script);
        appendColumnsStatistics(script);
        appendTriggerStates(script);
        appendComments(script);
    }

    private void appendTriggerStates(AbstractPgTable newTable, SQLScript script) {
        if (!triggerStates.equals(newTable.triggerStates)) {
            newTable.appendTriggerStates(script);
        }
    }

    private void appendTriggerStates(SQLScript script) {
        for (var state : triggerStates.entrySet()) {
            String changeTgState = CHANGE_TRIGGER_STATE.formatted(getQualifiedName(), state.getValue(), state.getKey());
            script.addStatement(changeTgState, SQLActionType.END);
        }
    }

    @Override
    public void appendComments(SQLScript script) {
        super.appendComments(script);
        appendChildrenComments(script);
    }

    private void appendChildrenComments(SQLScript script) {
        for (final AbstractColumn column : getColumns()) {
            column.appendComments(script);
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
     * Fills columns and their options to create table statement. Options will be
     * appends after CREATE TABLE statement. <br>
     * Must be overridden by subclasses
     *
     * @param sbSQL  - StringBuilder for columns
     * @param script - collection for options
     */
    protected abstract void appendColumns(StringBuilder sbSQL, SQLScript script);

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
    protected abstract void appendAlterOptions(SQLScript script);

    protected void appendColumnsStatistics(SQLScript script) {
        columns.stream().map(PgColumn.class::cast).filter(c -> c.getStatistics() != null)
        .forEach(column -> {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterTable(true));
            sql.append(ALTER_COLUMN);
            sql.append(PgDiffUtils.getQuotedName(column.getName()));
            sql.append(" SET STATISTICS ");
            sql.append(column.getStatistics());
            script.addStatement(sql);
        });
    }

    protected PgSequence writeSequences(PgColumn column, StringBuilder sbOption) {
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
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        AbstractPgTable newTable = (AbstractPgTable) newCondition;

        if (isRecreated(newTable)) {
            return ObjectState.RECREATE;
        }

        compareTableTypes(newTable, script);
        compareInherits(newTable, script);
        compareOptions(newTable, script);
        appendAlterOwner(newTable, script);
        compareTableOptions(newTable, script);
        alterPrivileges(newTable, script);
        appendTriggerStates(newTable, script);
        appendAlterComments(newTable, script);

        return getObjectState(script, startSize);
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        if (options.equals(newTable.getOptions())) {
            return false;
        }

        // check greenplum options
        for (String gpOption : GP_OPTION_LIST) {
            if (!Objects.equals(options.get(gpOption), newTable.getOption(gpOption))) {
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
    protected void compareTableOptions(AbstractPgTable newTable, SQLScript script) {
        if (hasOids != newTable.hasOids) {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterTable(true))
            .append(" SET ")
            .append(newTable.hasOids ? "WITH" : "WITHOUT")
            .append(" OIDS");
            script.addStatement(sql);
        }
    }

    protected void compareInherits(AbstractPgTable newTable, SQLScript script) {
        List<Inherits> newInherits = newTable.inherits;

        if (newTable instanceof PartitionPgTable) {
            return;
        }

        inherits.stream()
        .filter(e -> !newInherits.contains(e))
        .forEach(e -> script.addStatement(getInheritsActions(e, "\n\tNO INHERIT ")));

        newInherits.stream()
        .filter(e -> !inherits.contains(e))
        .forEach(e -> script.addStatement(getInheritsActions(e, "\n\tINHERIT ")));
    }

    private String getInheritsActions(Inherits inh, String state) {
        return getAlterTable(false) + state + inh.getQualifiedName();
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

    public boolean hasInherits() {
        return !inherits.isEmpty();
    }

    public void putTriggerState(String triggerName, String state) {
        triggerStates.put(triggerName, state);
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
        if (inherits.isEmpty()) {
            return;
        }

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

    protected void writeColumn(PgColumn column, StringBuilder sbSQL, SQLScript script) {
        boolean isInherit = column.isInherit();
        if (isInherit) {
            fillInheritOptions(column, script);
        } else {
            sbSQL.append("\t");
            sbSQL.append(column.getFullDefinition());
            sbSQL.append(",\n");
        }
        if (column.getStorage() != null) {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterTable(isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" SET STORAGE ")
            .append(column.getStorage());
            script.addStatement(sql);
        }

        writeOptions(column, script, isInherit);
        AbstractSequence sequence = column.getSequence();
        if (sequence != null) {
            StringBuilder sbSeq = new StringBuilder();
            if (getDatabaseArguments().isGenerateExistDoBlock()) {
                StringBuilder tmpSb = new StringBuilder();
                writeSequences(column, tmpSb);
                PgDiffUtils.appendSqlWrappedInDo(sbSeq, tmpSb, Consts.DUPLICATE_RELATION);
            } else {
                writeSequences(column, sbSeq);
                sbSeq.setLength(sbSeq.length() - 1);
            }
            script.addStatement(sbSeq);
        }
    }

    private void fillInheritOptions(AbstractColumn column, SQLScript script) {
        if (!column.getNullValue()) {
            script.addStatement(getAlterColumn(column) + " SET NOT NULL");
        }
        if (column.getDefaultValue() != null) {
            script.addStatement(getAlterColumn(column) + " SET DEFAULT " + column.getDefaultValue());
        }
    }

    private String getAlterColumn(AbstractColumn column) {
        return getAlterTable(true) + ALTER_COLUMN + PgDiffUtils.getQuotedName(column.getName());
    }

    private void writeOptions(PgColumn column, SQLScript script, boolean isInherit) {
        Map<String, String> opts = column.getOptions();
        Map<String, String> fOpts = column.getForeignOptions();

        if (!opts.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(getAlterTable(isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" SET (");

            for (Entry<String, String> option : opts.entrySet()) {
                sb.append(option.getKey());
                if (!option.getValue().isEmpty()) {
                    sb.append('=').append(option.getValue());
                }
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(")");
            script.addStatement(sb);
        }

        if (!fOpts.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(getAlterTable(isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" OPTIONS (");

            for (Entry<String, String> option : fOpts.entrySet()) {
                sb.append(option.getKey());
                if (!option.getValue().isEmpty()) {
                    sb.append(' ').append(option.getValue());
                }
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(")");
            script.addStatement(sb);
        }
    }

    /**
     * Compare tables types and generate transform scripts for change tables type
     *
     * @param newTable - new table
     * @param sb - StringBuilder for statements
     */
    protected abstract void compareTableTypes(AbstractPgTable newTable, SQLScript script);

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof AbstractPgTable table && super.compare(obj)) {
            return hasOids == table.hasOids
                    && inherits.equals(table.inherits)
                    && triggerStates.equals(table.triggerStates);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.putOrdered(inherits);
        hasher.put(hasOids);
        hasher.put(triggerStates);
    }

    @Override
    public AbstractTable shallowCopy() {
        AbstractPgTable copy = (AbstractPgTable) super.shallowCopy();
        copy.inherits.addAll(inherits);
        copy.setHasOids(hasOids);
        copy.triggerStates.putAll(triggerStates);
        return copy;
    }

    @Override
    protected void writeInsert(SQLScript script, AbstractTable newTable, String tblTmpQName,
            List<String> identityColsForMovingData, String cols) {
        String tblQName = newTable.getQualifiedName();
        StringBuilder sbInsert = new StringBuilder();
        sbInsert.append("INSERT INTO ").append(tblQName).append('(').append(cols).append(")");
        if (!identityColsForMovingData.isEmpty()) {
            sbInsert.append("\nOVERRIDING SYSTEM VALUE");
        }
        sbInsert.append("\nSELECT ").append(cols).append(" FROM ").append(tblTmpQName);
        script.addStatement(sbInsert);

        for (String colName : identityColsForMovingData) {
            String quotedCol = PgDiffUtils.getQuotedName(colName);
            script.addStatement(RESTART_SEQUENCE_QUERY.formatted(tblTmpQName, quotedCol, tblQName));
        }
    }

    @Override
    public List<String> getColsForMovingData(AbstractTable newTable) {
        return newTable.getColumns().stream()
                .filter(c -> containsColumn(c.getName()))
                .map(PgColumn.class::cast)
                .filter(pgCol -> !pgCol.isGenerated())
                .map(AbstractColumn::getName)
                .toList();
    }
}
