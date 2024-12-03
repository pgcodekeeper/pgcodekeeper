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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ICompressOptionContainer;
import ru.taximaxim.codekeeper.core.schema.ISimpleOptionContainer;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.Inherits;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLAction;

/**
 * Stores column information.
 */
public class PgColumn extends AbstractColumn implements ISimpleOptionContainer, ICompressOptionContainer  {

    private static final Logger LOG = LoggerFactory.getLogger(PgColumn.class);

    private static final String ALTER_FOREIGN_OPTION = "{0} OPTIONS ({1} {2} {3})";
    private static final String COMPRESSION = " COMPRESSION ";

    private Integer statistics;
    private String storage;
    private final Map<String, String> options = new LinkedHashMap<>(0);
    private final Map<String, String> fOptions = new LinkedHashMap<>(0);
    private PgSequence sequence;
    private String identityType;
    private String compression;
    private boolean isInherit;
    private boolean isGenerated;

    // greenplum type fields
    private String compressType;
    private int compressLevel = -1;
    private int blockSize;

    public PgColumn(String name) {
        super(name);
    }

    @Override
    public String getFullDefinition() {
        final StringBuilder sbDefinition = new StringBuilder();
        String cName = PgDiffUtils.getQuotedName(name);
        sbDefinition.append(cName);

        if (getType() == null) {
            sbDefinition.append(" WITH OPTIONS");
        } else {
            sbDefinition.append(' ');
            sbDefinition.append(getType());
            if (getCompression() != null) {
                sbDefinition.append(COMPRESSION).append(PgDiffUtils.getQuotedName(getCompression()));
            }

            if (getCollation() != null) {
                sbDefinition.append(COLLATE).append(getCollation());
            }
        }

        definitionDefaultNotNull(sbDefinition);

        generatedAlwaysAsStored(sbDefinition);

        appendCompressOptions(sbDefinition);
        return sbDefinition.toString();
    }

    private StringBuilder definitionDefaultNotNull(StringBuilder sbDefinition) {
        if (getDefaultValue() != null && !isGenerated()) {
            sbDefinition.append(" DEFAULT ");
            sbDefinition.append(getDefaultValue());
        }

        if (!getNullValue()) {
            sbDefinition.append(NOT_NULL);
        }

        return sbDefinition;
    }

    private StringBuilder generatedAlwaysAsStored(StringBuilder sbDefinition) {
        if (isGenerated()) {
            sbDefinition.append(" GENERATED ALWAYS AS (")
            .append(getDefaultValue())
            .append(") STORED");
        }
        return sbDefinition;
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        StringBuilder sb = new StringBuilder();

        boolean mergeDefaultNotNull = false;
        if (getType() != null && getParentCol((AbstractPgTable) getParent()) == null) {
            sb.append(getAlterTable(false));
            sb.append("\n\tADD COLUMN ");
            appendIfNotExists(sb);
            sb.append(PgDiffUtils.getQuotedName(name))
            .append(' ')
            .append(getType());
            if (getCompression() != null) {
                sb.append(COMPRESSION).append(PgDiffUtils.getQuotedName(getCompression()));
            }
            if (getCollation() != null) {
                sb.append(COLLATE).append(getCollation());
            }

            mergeDefaultNotNull = !getNullValue();
            if (mergeDefaultNotNull) {
                // for NOT NULL columns we'd emit a time consuming UPDATE column=DEFAULT anyway
                // so we can merge DEFAULT with column definition with no performance loss
                // this operation also becomes fast on PostgreSQL 11+ (metadata only operation)
                definitionDefaultNotNull(sb);
            }

            generatedAlwaysAsStored(sb);
            appendCompressOptions(sb);

            createActions.add(new SQLAction(sb));
        }

        // column may have a default expression or a generation expression
        // (https://www.postgresql.org/docs/12/catalog-pg-attribute.html) (param - 'atthasdef')
        if (!mergeDefaultNotNull && !isGenerated()) {
            compareDefaults(null, getDefaultValue(), new AtomicBoolean(), createActions);
            compareNullValues(true, getNullValue(), getDefaultValue() != null, createActions);
        }
        compareStorages(null, getStorage(), createActions);

        appendPrivileges(createActions);

        compareForeignOptions(Collections.<String, String>emptyMap(), fOptions, createActions);
        writeOptions(true, createActions);

        compareStats(null, getStatistics(), createActions);
        compareIdentity(null, getIdentityType(), null, getSequence(), createActions);

        appendComments(createActions);
    }

    private void appendCompressOptions(StringBuilder sb) {
        if (compressType != null || compressLevel != -1 || blockSize != 0) {
            sb.append(" ENCODING (");
            if (compressType != null) {
                sb.append("COMPRESSTYPE = ").append(compressType);
            }

            if (compressLevel != -1) {
                sb.append(", COMPRESSLEVEL = ").append(compressLevel);
            }

            if (blockSize != 0) {
                sb.append(", BLOCKSIZE = ").append(blockSize);
            }
            sb.append(")");
        }
    }

    private String getAlterTableColumn(boolean newLine, boolean only, String column) {
        return getAlterTableColumn(newLine, only, column, true);
    }

    private String getAlterTableColumn(boolean newLine, boolean only, String column,
            boolean needAlterTable) {
        StringBuilder sb = new StringBuilder();
        if (needAlterTable) {
            sb.append(((AbstractTable) getParent()).getAlterTable(only));
        }
        sb.append(ALTER_COLUMN + PgDiffUtils.getQuotedName(column));
        return sb.toString();
    }

    @Override
    public void getDropSQL(Collection<SQLAction> dropActions, boolean optionExists) {
        if (getType() != null && getParentCol((AbstractPgTable) getParent()) == null) {
            boolean addOnly = true;

            //// Condition for partitioned tables.
            // If there are sections, then it is impossible to delete a column
            // only from a partitioned table.
            // Because of impossible inherit from partitioned tables, this
            // condition will also be true for cases when a partitioned table
            // does not have sections.
            PgStatement parent = getParent();
            if (parent instanceof AbstractRegularTable regTable) {
                addOnly = regTable.getPartitionBy() == null;
            }
            StringBuilder dropSb = new StringBuilder();
            dropSb.append(getAlterTable(addOnly))
            .append("\n\tDROP COLUMN ");
            if (optionExists) {
                dropSb.append(IF_EXISTS);
            }
            dropSb.append(PgDiffUtils.getQuotedName(getName()));
            dropActions.add(new SQLAction(dropSb));
            return;
        }

        compareDefaults(getDefaultValue(), null, null, dropActions);
        compareNullValues(getNullValue(), true, false, dropActions);
        compareStorages(getStorage(), null, dropActions);

        alterPrivileges(new PgColumn(name), dropActions);

        compareForeignOptions(fOptions, Collections.<String, String>emptyMap(), dropActions);
        writeOptions(false, dropActions);
        compareStats(getStatistics(), null, dropActions);
        compareIdentity(getIdentityType(), null, getSequence(), null, dropActions);

        appendComments(dropActions);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        PgColumn newColumn = (PgColumn) newCondition;

        if (isGenerated() != newColumn.isGenerated()
                || (isGenerated() && !Objects.equals(getDefaultValue(), newColumn.getDefaultValue()))
                || !compareCompressOptions(newColumn)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        boolean isNeedDropDefault = !Objects.equals(getType(), newColumn.getType())
                && !Objects.equals(getDefaultValue(), newColumn.getDefaultValue());

        if (isNeedDropDefault) {
            compareDefaults(getDefaultValue(), null, null, alterActions);
        }

        StringBuilder typeBuilder = new StringBuilder();
        compareTypes(this, newColumn, isNeedDepcies, typeBuilder, true, true);
        if (!typeBuilder.isEmpty()) {
            alterActions.add(new SQLAction(typeBuilder));
        }

        String oldDefault = isNeedDropDefault ? null : getDefaultValue();
        compareDefaults(oldDefault, newColumn.getDefaultValue(), isNeedDepcies, alterActions);
        compareNullValues(getNullValue(), newColumn.getNullValue(), newColumn.getDefaultValue() != null, alterActions);
        compareStorages(getStorage(), newColumn.getStorage(), alterActions);
        compareCompression(getCompression(), newColumn.getCompression(), alterActions);

        alterPrivileges(newColumn, alterActions);

        compareOptions(newColumn, alterActions);
        compareForeignOptions(getForeignOptions(), newColumn.getForeignOptions(), alterActions);
        compareStats(getStatistics(), newColumn.getStatistics(), alterActions);

        compareIdentity(getIdentityType(), newColumn.getIdentityType(), getSequence(), newColumn.getSequence(), alterActions);
        appendAlterComments(newColumn, alterActions);
        return getObjectState(alterActions);
    }

    private boolean compareCompressOptions(PgColumn newColumn) {
        return Objects.equals(getCompressType(), newColumn.getCompressType())
                && getCompressLevel() == newColumn.getCompressLevel()
                && getBlockSize() == newColumn.getBlockSize();
    }

    /**
     * Writes SET/RESET options for column to StringBuilder
     *
     * @param isCreate
     *            - if true SET options, else RESET
     * @param sqlActions for collect sql statements
     */
    private void writeOptions(boolean isCreate, Collection<SQLAction> actions) {
        if (!options.isEmpty()) {
            SQLAction action = new SQLAction();
            action.append(getAlterTableColumn(true, true, name));
            action.append(isCreate ? " SET (" : " RESET (");
            for (Entry<String, String> option : options.entrySet()) {
                action.append(option.getKey());
                if (isCreate && !option.getValue().isEmpty()) {
                    action.append('=').append(option.getValue());
                }
                action.append(", ");
            }
            action.reduce(2);
            action.append(")");
            actions.add(action);
        }
    }

    /**
     * Compare columns identity and write difference to StringBuilder.
     *
     * @param oldIdentityType - old column identity type
     * @param newIdentityType - new column identity type
     * @param oldSequence - old column identity sequence
     * @param newSequence - new column identity sequence
     * @param sqlActions for collect sql statements
     */
    private void compareIdentity(String oldIdentityType, String newIdentityType,
            AbstractSequence oldSequence, AbstractSequence newSequence, Collection<SQLAction> sqlActions) {
        if (!Objects.equals(oldIdentityType, newIdentityType)) {
            StringBuilder sb = new StringBuilder();
            sb.append(getAlterTableColumn(true, false, name));

            if (newIdentityType == null) {
                sb.append(" DROP IDENTITY");
                if (getDatabaseArguments().isGenerateExists()) {
                    sb.append(" IF EXISTS");
                }
            } else if (oldIdentityType == null) {
                sb.append(" ADD GENERATED ")
                .append(newIdentityType)
                .append(" AS IDENTITY (")
                .append("\n\tSEQUENCE NAME ")
                .append(newSequence.getQualifiedName());
                newSequence.fillSequenceBody(sb);
                sb.append("\n)");
            } else {
                sb.append(" SET GENERATED ").append(newIdentityType);
            }
            sqlActions.add(new SQLAction(sb));
        }

        if (oldSequence != null && newSequence != null &&
                !Objects.equals(oldSequence, newSequence)) {
            if (!oldSequence.getName().equals(newSequence.getName())) {
                StringBuilder sbSeq = new StringBuilder();
                sbSeq.append("ALTER SEQUENCE ")
                .append(oldSequence.getQualifiedName())
                .append(" RENAME TO ")
                .append(PgDiffUtils.getQuotedName(newSequence.getName()));
                sqlActions.add(new SQLAction(sbSeq));
            }

            oldSequence.appendAlterSQL(newSequence, new AtomicBoolean(), sqlActions);
        }
    }

    public boolean isJoinable(PgColumn newColumn) {
        return newColumn.getType() != null
                && (!Objects.equals(getType(), newColumn.getType())
                        || !Objects.equals(getCollation(), newColumn.getCollation()))
                && Objects.equals(getDefaultValue(), newColumn.getDefaultValue())
                && getNullValue() == newColumn.getNullValue()
                && compareColOptions(newColumn)
                && Objects.equals(getComment(), newColumn.getComment());
    }

    public void joinAction(StringBuilder sb, PgColumn newColumn, boolean isNeedAlterTable,
            boolean isLastColumn) {
        compareTypes(this, newColumn, new AtomicBoolean(), sb, isNeedAlterTable, isLastColumn);
    }

    /**
     * Compares two columns types and collations and write difference to StringBuilder.
     * If the values ​​are not equal, then the column will be changed with dependencies.
     * Adds warning as SQL comment.
     *
     * @param oldColumn - old column
     * @param newColumn - new column
     * @param isNeedDepcies - if set true, column will be changed with dependencies
     * @param sb - StringBuilder for difference
     * @param isNeedAlterTable - if true ALTER TABLE sentence added before ALTER COLUMN
     * @param  isLastColumn -  if true will be added ";" in the end of ALTER COLUMN. If false then - ",".
     */
    private void compareTypes(PgColumn oldColumn, PgColumn newColumn, AtomicBoolean isNeedDepcies,
            StringBuilder sb, boolean isNeedAlterTable, boolean isLastColumn) {
        String oldType = oldColumn.getType();
        String newType = newColumn.getType();
        if (newType == null) {
            return;
        }

        String oldCollation = oldColumn.getCollation();
        String newCollation = newColumn.getCollation();

        if (!Objects.equals(oldType, newType) || (newCollation != null && !newCollation.equals(oldCollation))) {
            isNeedDepcies.set(true);
            sb.append(getAlterTableColumn(true, false, newColumn.getName(), isNeedAlterTable));
            sb.append(" TYPE ").append(newType);

            if (newCollation != null) {
                sb.append(COLLATE).append(newCollation);
            }

            if (!getDatabaseArguments().isUsingTypeCastOff()
                    && !(getParent() instanceof AbstractForeignTable)
                    && !(getParent() instanceof GpExternalTable)) {
                sb.append(" USING ").append(PgDiffUtils.getQuotedName(newColumn.getName()))
                .append("::").append(newType);
            }
            sb.append(isLastColumn ? ";" : ",");
            sb.append(" /* " + MessageFormat.format(Messages.Table_TypeParameterChange,
                    newColumn.getParent().getParent().getName() + '.' + newColumn.getParent().getName(),
                    oldType, newType) + " */");
        }
    }

    /**
     * Compares two columns foreign options and write difference to StringBuilder.
     *
     * @param oldForeignOptions - old column foreign options
     * @param newForeignOptions - new column foreign options
     * @param actions - collection for actions
     */
    private void compareForeignOptions(Map<String, String> oldForeignOptions,
            Map<String, String> newForeignOptions, Collection<SQLAction> actions) {
        if (!oldForeignOptions.isEmpty() || !newForeignOptions.isEmpty()) {
            oldForeignOptions.forEach((key, value) -> {
                if (newForeignOptions.containsKey(key)) {
                    String newValue =  newForeignOptions.get(key);
                    if (!Objects.equals(value, newValue)) {
                        SQLAction action = new SQLAction();
                        action.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                                getAlterTableColumn(true, false, name),
                                "SET", key, newValue));
                        actions.add(action);
                    }
                } else {
                    SQLAction action = new SQLAction();
                    action.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterTableColumn(true, false, name),
                            "DROP", key, ""));
                    actions.add(action);
                }
            });

            newForeignOptions.forEach((key, value) -> {
                if (!oldForeignOptions.containsKey(key)) {
                    SQLAction action = new SQLAction();
                    action.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterTableColumn(true, false, name),
                            "ADD", key, value));
                    actions.add(action);
                }
            });
        }

    }

    /**
     * Compares two columns null values and write difference to StringBuilder.
     *
     * @param oldNull - old column null value
     * @param newNull - new column null value
     * @param hasDefault - true if new column has default value
     * @param sqlActions- actions for collect sql statements
     */
    private void compareNullValues(boolean oldNull, boolean newNull, boolean hasDefault, Collection<SQLAction> sqlActions) {
        if (oldNull == newNull) {
            return;
        }

        if (newNull) {
            SQLAction sql = new SQLAction();
            sql.append(getAlterTableColumn(true, true, name));
            sql.append(" DROP").append(NOT_NULL);
            sqlActions.add(sql);
            return;
        }

        if (hasDefault) {
            SQLAction sql = new SQLAction();
            sql.append("UPDATE ").append(getParent().getQualifiedName())
            .append("\n\tSET ").append(PgDiffUtils.getQuotedName(name))
            .append(" = DEFAULT WHERE ").append(PgDiffUtils.getQuotedName(name))
            .append(" IS").append(NULL);
            sqlActions.add(sql);
        }
        SQLAction sql = new SQLAction();
        sql.append(getAlterTableColumn(true, false, name));
        sql.append(" SET").append(NOT_NULL);
        sqlActions.add(sql);
    }

    /**
     * Compares two columns default values and write difference to StringBuilder.
     * If the default values ​​are not equal, and the new value is not null,
     * then the column will be changed with dependencies.
     *
     * @param oldDefault - old column default value
     * @param newDefault - new column default value
     * @param isNeedDepcies - if set true, column will be changed with dependencies
     * @param sqlActions for collect sql statements
     */
    private void compareDefaults(String oldDefault, String newDefault,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> sqlActions) {
        if (!Objects.equals(oldDefault, newDefault)) {
            SQLAction sql = new SQLAction();
            sql.append(getAlterTableColumn(true, true, name));
            if (newDefault == null) {
                sql.append(" DROP DEFAULT");
            } else {
                sql.append(" SET DEFAULT ").append(newDefault);
                isNeedDepcies.set(true);
            }
            sqlActions.add(sql);
        }
    }

    /**
     * Compares two columns statistics and write difference to StringBuilder.
     *
     * @param oldStat - old column statistics
     * @param newStat - new column statistics
     * @param sqlActions for collect sql statements
     */
    private void compareStats(Integer oldStat, Integer newStat, Collection<SQLAction> sqlActions) {
        Integer newStatValue = null;

        if (newStat != null && (oldStat == null || !newStat.equals(oldStat))) {
            newStatValue = newStat;
        } else if (oldStat != null && newStat == null) {
            newStatValue = Integer.valueOf(-1);
        }
        if (newStatValue != null) {
            SQLAction action = new SQLAction();
            action.append(getAlterTableColumn(true, true, name))
            .append(" SET STATISTICS ")
            .append(newStatValue);
            sqlActions.add(action);
        }
    }

    /**
     * Compares two columns storages and writes difference to StringBuilder.
     * If new column doesn't have storage, adds warning as SQL comment.
     *
     * @param oldStorage - old column storage
     * @param newStorage - new column storage
     * @param sqlActions for collect sql statements
     */
    private void compareStorages(String oldStorage, String newStorage,
            Collection<SQLAction> sqlActions) {
        SQLAction sql;
        if (newStorage == null && oldStorage != null) {
            // FIXME fix test
            sql = new SQLAction();
            sql.append(MessageFormat.format(
                    Messages.Storage_WarningUnableToDetermineStorageType,
                    getParent().getName(), getName()));
            sqlActions.add(sql);
        } else if (newStorage != null && !newStorage.equalsIgnoreCase(oldStorage)) {
            sql = new SQLAction();
            sql.append(getAlterTableColumn(true, true, name))
            .append(" SET STORAGE ")
            .append(newStorage);
            sqlActions.add(sql);
        }
    }

    private void compareCompression(String oldCompression, String newCompression,
            Collection<SQLAction> alterActions) {
        SQLAction sql;
        if (newCompression == null && oldCompression != null) {
            sql = new SQLAction();
            sql.append(getAlterTableColumn(true, true, name)).append(" SET COMPRESSION DEFAULT");
            alterActions.add(sql);
        } else if (newCompression != null && !newCompression.equalsIgnoreCase(oldCompression)) {
            sql = new SQLAction();
            sql.append(getAlterTableColumn(true, true, name))
            .append(" SET COMPRESSION ").append(PgDiffUtils.getQuotedName(newCompression));
            alterActions.add(sql);
        }
    }

    /**
     * Returns the parent column for given column or null if given column hasn't
     * parent column.
     */
    public AbstractColumn getParentCol(AbstractPgTable tbl) {
        for (Inherits in : tbl.getInherits()) {
            IStatement parent = getDatabase().getStatement(new GenericColumn(in.getKey(), in.getValue(),
                    DbObjType.TABLE));
            if (parent == null) {
                LOG.error("There is no such object of inheritance as table: {}", in.getQualifiedName());
                continue;
            }

            AbstractPgTable parentTbl = (AbstractPgTable) parent;
            AbstractColumn parentCol = parentTbl.getColumn(getName());
            if (parentCol == null) {
                parentCol = getParentCol(parentTbl);
            }
            if (parentCol != null) {
                // if not found continue searching through other inherit entries
                return parentCol;
            }
        }

        return null;
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String attribute, String value){
        this.options.put(attribute, value);
        resetHash();
    }

    public Map<String, String> getForeignOptions() {
        return Collections.unmodifiableMap(fOptions);
    }

    public void addForeignOption(String attribute, String value){
        this.fOptions.put(attribute, value);
        resetHash();
    }

    @Override
    public void setCompressType(String compressType) {
        this.compressType = compressType;
        resetHash();
    }

    public String getCompressType() {
        return compressType;
    }

    @Override
    public void setCompressLevel(int compressLevel) {
        this.compressLevel = compressLevel;
        resetHash();
    }

    public int getCompressLevel() {
        return compressLevel;
    }

    @Override
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
        resetHash();
    }

    public int getBlockSize() {
        return blockSize;
    }

    public boolean isInherit() {
        return isInherit;
    }

    public void setInherit(boolean isInherit) {
        this.isInherit = isInherit;
        resetHash();
    }

    public boolean isGenerated() {
        return isGenerated;
    }

    public void setGenerated(boolean isGenerated) {
        this.isGenerated = isGenerated;
        resetHash();
    }

    public void setStatistics(final Integer statistics) {
        this.statistics = statistics;
        resetHash();
    }

    public Integer getStatistics() {
        return statistics;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(final String storage) {
        this.storage = storage;
        resetHash();
    }

    public PgSequence getSequence() {
        return sequence;
    }

    public void setSequence(final PgSequence sequence) {
        this.sequence = sequence;
        resetHash();
    }

    public void setIdentityType(final String identityType) {
        this.identityType = identityType;
        resetHash();
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setCompression(String compression) {
        this.compression = compression;
        resetHash();
    }

    public String getCompression() {
        return compression;
    }


    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgColumn col && super.compare(obj)) {
            return compareColOptions(col);
        }

        return false;
    }

    private boolean compareColOptions(PgColumn col) {
        return Objects.equals(statistics, col.getStatistics())
                && Objects.equals(storage, col.getStorage())
                && Objects.equals(identityType, col.getIdentityType())
                && isInherit == col.isInherit()
                && isGenerated == col.isGenerated()
                && options.equals(col.options)
                && fOptions.equals(col.fOptions)
                && compareCompressOptions(col)
                && Objects.equals(sequence, col.getSequence())
                && Objects.equals(compression, col.getCompression());
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(statistics);
        hasher.put(storage);
        hasher.put(options);
        hasher.put(fOptions);
        hasher.put(compressType);
        hasher.put(compressLevel);
        hasher.put(blockSize);
        hasher.put(sequence);
        hasher.put(compression);
        hasher.put(identityType);
        hasher.put(isInherit);
        hasher.put(isGenerated);
    }

    @Override
    protected AbstractColumn getColumnCopy() {
        PgColumn copy = new PgColumn(getName());
        copy.setStatistics(getStatistics());
        copy.setStorage(getStorage());
        copy.options.putAll(options);
        copy.fOptions.putAll(fOptions);
        copy.setCompressType(getCompressType());
        copy.setCompressLevel(getCompressLevel());
        copy.setBlockSize(getBlockSize());
        copy.setIdentityType(getIdentityType());
        copy.setSequence(getSequence());
        copy.setCompression(getCompression());
        copy.setInherit(isInherit());
        copy.setGenerated(isGenerated());
        return copy;
    }
}
