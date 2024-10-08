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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
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
    public String getCreationSQL() {
        final StringBuilder sbOption = new StringBuilder();
        final StringBuilder sbSQL = new StringBuilder();
        appendName(sbSQL);
        appendColumns(sbSQL, sbOption);
        appendInherit(sbSQL);
        appendOptions(sbSQL);
        sbSQL.append(sbOption);
        appendAlterOptions(sbSQL);
        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);
        appendColumnsPriliges(sbSQL);
        appendColumnsStatistics(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public void appendComments(StringBuilder sb) {
        super.appendComments(sb);

        for (final AbstractColumn column : getColumns()) {
            column.appendComments(sb);
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
    protected abstract void appendName(StringBuilder sbSQL);

    /**
     * Fills columns and their options to create table statement. Options will
     * be appends after CREATE TABLE statement. <br>
     * Must be overridden by subclasses
     *
     * @param sbSQL - StringBuilder for columns
     * @param sbOption - StringBuilder for options
     */
    protected abstract void appendColumns(StringBuilder sbSQL, StringBuilder sbOption);

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
     * Appends table storage parameters or server options, part of create statement,
     * must be finished with ';' character;
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
    protected abstract void appendAlterOptions(StringBuilder sbSQL);

    protected void appendColumnsStatistics(StringBuilder sbSQL) {
        columns.stream().map(PgColumn.class::cast).filter(c -> c.getStatistics() != null)
        .forEach(column -> {
            sbSQL.append(getAlterTable(true, true));
            sbSQL.append(ALTER_COLUMN);
            sbSQL.append(PgDiffUtils.getQuotedName(column.getName()));
            sbSQL.append(" SET STATISTICS ");
            sbSQL.append(column.getStatistics());
            sbSQL.append(';');
        });
    }

    protected PgSequence writeSequences(PgColumn column, StringBuilder sbOption, boolean newLine) {
        PgSequence sequence = column.getSequence();
        sbOption.append(getAlterTable(newLine, false))
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
    public ObjectState appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        AbstractPgTable newTable = (AbstractPgTable) newCondition;

        if (isRecreated(newTable)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        compareTableTypes(newTable, sb);
        compareInherits(newTable, sb);
        compareOptions(newTable, sb);
        compareOwners(newTable, sb);
        compareTableOptions(newTable, sb);
        alterPrivileges(newTable, sb);
        compareComments(sb, newTable);
        return getObjectState(sb, startLength);
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
    protected void compareTableOptions(AbstractPgTable newTable, StringBuilder sb) {
        if (hasOids != newTable.getHasOids()) {
            sb.append(getAlterTable(true, true))
            .append(" SET ")
            .append(newTable.getHasOids() ? "WITH" : "WITHOUT")
            .append(" OIDS;");
        }
    }

    protected void compareInherits(AbstractPgTable newTable, StringBuilder sb) {
        List<Inherits> newInherits = newTable.getInherits();

        if (newTable instanceof PartitionPgTable) {
            return;
        }

        for (final Inherits tableName : inherits) {
            if (!newInherits.contains(tableName)) {
                sb.append(getAlterTable(true, false))
                .append("\n\tNO INHERIT ")
                .append(tableName.getQualifiedName())
                .append(';');
            }
        }

        for (final Inherits tableName : newInherits) {
            if (!inherits.contains(tableName)) {
                sb.append(getAlterTable(true, false))
                .append("\n\tINHERIT ")
                .append(tableName.getQualifiedName())
                .append(';');
            }
        }
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

    protected void writeColumn(PgColumn column, StringBuilder sbSQL,
            StringBuilder sbOption) {

        boolean isInherit = column.isInherit();
        if (isInherit) {
            fillInheritOptions(column, sbOption);
        } else {
            sbSQL.append("\t");
            sbSQL.append(column.getFullDefinition());
            sbSQL.append(",\n");
        }

        if (column.getStorage() != null) {
            sbOption.append(getAlterTable(true, isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" SET STORAGE ")
            .append(column.getStorage())
            .append(';');
        }

        writeOptions(column, sbOption, isInherit);
        AbstractSequence sequence = column.getSequence();
        if (sequence != null) {
            if (getDatabaseArguments().isGenerateExistDoBlock()) {
                StringBuilder sbSeq = new StringBuilder();
                writeSequences(column, sbSeq, false);
                PgDiffUtils.appendSqlWrappedInDo(sbOption, sbSeq, Consts.DUPLICATE_RELATION);
            } else {
                writeSequences(column, sbOption, true);
            }
        }
    }

    private void fillInheritOptions(AbstractColumn column, StringBuilder sb) {
        if (!column.getNullValue()) {
            sb.append(getAlterTable(true, true))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" SET NOT NULL;");
        }
        if (column.getDefaultValue() != null) {
            sb.append(getAlterTable(true, true))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" SET DEFAULT ")
            .append(column.getDefaultValue())
            .append(';');
        }
    }

    private void writeOptions(PgColumn column, StringBuilder sbOption, boolean isInherit) {
        Map<String, String> opts = column.getOptions();
        Map<String, String> fOpts = column.getForeignOptions();

        if (!opts.isEmpty()) {
            sbOption.append(getAlterTable(true, isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" SET (");

            for (Entry<String, String> option : opts.entrySet()) {
                sbOption.append(option.getKey());
                if (!option.getValue().isEmpty()) {
                    sbOption.append('=').append(option.getValue());
                }
                sbOption.append(", ");
            }
            sbOption.setLength(sbOption.length() - 2);
            sbOption.append(");");
        }

        if (!fOpts.isEmpty()) {
            sbOption.append(getAlterTable(true, isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.getName()))
            .append(" OPTIONS (");

            for (Entry<String, String> option : fOpts.entrySet()) {
                sbOption.append(option.getKey());
                if (!option.getValue().isEmpty()) {
                    sbOption.append(' ').append(option.getValue());
                }
                sbOption.append(", ");
            }
            sbOption.setLength(sbOption.length() - 2);
            sbOption.append(");");
        }
    }

    /**
     * Compare tables types and generate transform scripts for change tables type
     *
     * @param newTable - new table
     * @param sb - StringBuilder for statements
     */
    protected abstract void compareTableTypes(AbstractPgTable newTable, StringBuilder sb);

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
