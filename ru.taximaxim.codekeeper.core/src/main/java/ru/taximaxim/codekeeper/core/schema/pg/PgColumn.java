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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import java.text.MessageFormat;
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
import ru.taximaxim.codekeeper.core.schema.IForeignTable;
import ru.taximaxim.codekeeper.core.schema.ISimpleOptionContainer;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.Inherits;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

/**
 * Stores column information.
 */
public final class PgColumn extends AbstractColumn implements ISimpleOptionContainer, ICompressOptionContainer {

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

        if (type == null) {
            sbDefinition.append(" WITH OPTIONS");
        } else {
            sbDefinition.append(' ');
            sbDefinition.append(type);
            if (compression != null) {
                sbDefinition.append(COMPRESSION).append(PgDiffUtils.getQuotedName(compression));
            }

            if (collation != null) {
                sbDefinition.append(COLLATE).append(collation);
            }
        }

        definitionDefaultNotNull(sbDefinition);

        generatedAlwaysAsStored(sbDefinition);

        appendCompressOptions(sbDefinition);
        return sbDefinition.toString();
    }

    private StringBuilder definitionDefaultNotNull(StringBuilder sbDefinition) {
        if (defaultValue != null && !isGenerated) {
            sbDefinition.append(" DEFAULT ");
            sbDefinition.append(defaultValue);
        }

        if (!nullValue) {
            sbDefinition.append(NOT_NULL);
        }

        return sbDefinition;
    }

    private StringBuilder generatedAlwaysAsStored(StringBuilder sbDefinition) {
        if (isGenerated) {
            sbDefinition.append(" GENERATED ALWAYS AS (")
            .append(defaultValue)
            .append(") STORED");
        }
        return sbDefinition;
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        StringBuilder sb = new StringBuilder();

        boolean mergeDefaultNotNull = false;
        if (type != null && getParentCol((AbstractPgTable) parent) == null) {
            sb.append(getAlterTable(false));
            sb.append("\n\tADD COLUMN ");
            appendIfNotExists(sb);
            sb.append(PgDiffUtils.getQuotedName(name))
            .append(' ')
            .append(type);
            if (compression != null) {
                sb.append(COMPRESSION).append(PgDiffUtils.getQuotedName(compression));
            }
            if (collation != null) {
                sb.append(COLLATE).append(collation);
            }

            mergeDefaultNotNull = !nullValue;
            if (mergeDefaultNotNull) {
                // for NOT NULL columns we'd emit a time consuming UPDATE column=DEFAULT anyway
                // so we can merge DEFAULT with column definition with no performance loss
                // this operation also becomes fast on PostgreSQL 11+ (metadata only operation)
                definitionDefaultNotNull(sb);
            }

            generatedAlwaysAsStored(sb);
            appendCompressOptions(sb);

            script.addStatement(sb);
        }

        // column may have a default expression or a generation expression
        // (https://www.postgresql.org/docs/12/catalog-pg-attribute.html) (param - 'atthasdef')
        if (!mergeDefaultNotNull && !isGenerated) {
            compareDefaults(null, defaultValue, new AtomicBoolean(), script);
            compareNullValues(true, nullValue, defaultValue != null, script);
        }
        compareStorages(null, storage, script);

        appendPrivileges(script);

        compareForeignOptions(Collections.<String, String>emptyMap(), fOptions, script);
        writeOptions(true, script);

        compareStats(null, statistics, script);
        compareIdentity(null, identityType, null, sequence, script);

        appendComments(script);
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

    private String getAlterTableColumn(boolean only, String column) {
        return getAlterTableColumn(only, column, true);
    }

    private String getAlterTableColumn(boolean only, String column, boolean needAlterTable) {
        StringBuilder sb = new StringBuilder();
        if (needAlterTable) {
            sb.append(((AbstractTable) parent).getAlterTable(only));
        }
        sb.append(ALTER_COLUMN + PgDiffUtils.getQuotedName(column));
        return sb.toString();
    }

    @Override
    public void getDropSQL(SQLScript script, boolean optionExists) {
        if (type != null && getParentCol((AbstractPgTable) parent) == null) {
            boolean addOnly = true;

            //// Condition for partitioned tables.
            // If there are sections, then it is impossible to delete a column
            // only from a partitioned table.
            // Because of impossible inherit from partitioned tables, this
            // condition will also be true for cases when a partitioned table
            // does not have sections.
            if (parent instanceof AbstractRegularTable regTable) {
                addOnly = regTable.getPartitionBy() == null;
            }
            StringBuilder dropSb = new StringBuilder();
            dropSb.append(getAlterTable(addOnly))
            .append("\n\tDROP COLUMN ");
            if (optionExists) {
                dropSb.append(IF_EXISTS);
            }
            dropSb.append(PgDiffUtils.getQuotedName(name));
            script.addStatement(dropSb);
            return;
        }

        compareDefaults(defaultValue, null, null, script);
        compareNullValues(nullValue, true, false, script);
        compareStorages(storage, null, script);

        alterPrivileges(new PgColumn(name), script);

        compareForeignOptions(fOptions, Collections.<String, String>emptyMap(), script);
        writeOptions(false, script);
        compareStats(statistics, null, script);
        compareIdentity(identityType, null, sequence, null, script);

        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgColumn newColumn = (PgColumn) newCondition;

        if (isGenerated != newColumn.isGenerated
                || (isGenerated && !Objects.equals(defaultValue, newColumn.defaultValue))
                || !compareCompressOptions(newColumn)) {
            return ObjectState.RECREATE;
        }

        boolean isNeedDropDefault = !Objects.equals(type, newColumn.type)
                && !Objects.equals(defaultValue, newColumn.defaultValue);

        if (isNeedDropDefault) {
            compareDefaults(defaultValue, null, null, script);
        }
        AtomicBoolean isNeedDepcies = new AtomicBoolean();
        StringBuilder typeBuilder = new StringBuilder();
        compareTypes(this, newColumn, isNeedDepcies, typeBuilder, true, true);
        if (!typeBuilder.isEmpty()) {
            script.addStatement(typeBuilder);
        }

        String oldDefault = isNeedDropDefault ? null : defaultValue;
        compareDefaults(oldDefault, newColumn.defaultValue, isNeedDepcies, script);
        compareNullValues(nullValue, newColumn.nullValue, newColumn.defaultValue != null, script);
        compareStorages(storage, newColumn.storage, script);
        compareCompression(compression, newColumn.compression, script);

        alterPrivileges(newColumn, script);

        compareOptions(newColumn, script);
        compareForeignOptions(fOptions, newColumn.fOptions, script);
        compareStats(statistics, newColumn.statistics, script);

        compareIdentity(identityType, newColumn.identityType, sequence, newColumn.sequence, script);
        appendAlterComments(newColumn, script);
        return getObjectState(isNeedDepcies.get(), script, startSize);
    }

    private boolean compareCompressOptions(PgColumn newColumn) {
        return Objects.equals(compressType, newColumn.compressType)
                && compressLevel == newColumn.compressLevel
                && blockSize == newColumn.blockSize;
    }

    /**
     * Writes SET/RESET options for column to StringBuilder
     *
     * @param isCreate
     *            - if true SET options, else RESET
     * @param sqlActions for collect sql statements
     */
    private void writeOptions(boolean isCreate, SQLScript script) {
        if (!options.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(getAlterTableColumn(true, name));
            sb.append(isCreate ? " SET (" : " RESET (");
            for (Entry<String, String> option : options.entrySet()) {
                sb.append(option.getKey());
                if (isCreate && !option.getValue().isEmpty()) {
                    sb.append('=').append(option.getValue());
                }
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(")");
            script.addStatement(sb);
        }
    }

    /**
     * Compare columns identity and write difference to StringBuilder.
     *
     * @param oldIdentityType - old column identity type
     * @param newIdentityType - new column identity type
     * @param oldSequence     - old column identity sequence
     * @param newSequence     - new column identity sequence
     * @param script          for collect sql statements
     */
    private void compareIdentity(String oldIdentityType, String newIdentityType,
            AbstractSequence oldSequence, AbstractSequence newSequence, SQLScript script) {
        if (!Objects.equals(oldIdentityType, newIdentityType)) {
            StringBuilder sb = new StringBuilder();
            sb.append(getAlterTableColumn(false, name));

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
            script.addStatement(sb);
        }

        if (oldSequence != null && newSequence != null &&
                !Objects.equals(oldSequence, newSequence)) {
            if (!oldSequence.getName().equals(newSequence.getName())) {
                StringBuilder sbSeq = new StringBuilder();
                sbSeq.append("ALTER SEQUENCE ")
                .append(oldSequence.getQualifiedName())
                .append(" RENAME TO ")
                .append(PgDiffUtils.getQuotedName(newSequence.getName()));
                script.addStatement(sbSeq.toString());
            }

            oldSequence.appendAlterSQL(newSequence, script);
        }
    }

    public boolean isJoinable(PgColumn newColumn) {
        return newColumn.type != null
                && (!Objects.equals(type, newColumn.type)
                        || !Objects.equals(collation, newColumn.collation))
                && Objects.equals(defaultValue, newColumn.defaultValue)
                && nullValue == newColumn.nullValue
                && compareColOptions(newColumn)
                && Objects.equals(comment, newColumn.comment);
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
        String oldType = oldColumn.type;
        String newType = newColumn.type;
        if (newType == null) {
            return;
        }

        String oldCollation = oldColumn.collation;
        String newCollation = newColumn.collation;

        if (!Objects.equals(oldType, newType) || (newCollation != null && !newCollation.equals(oldCollation))) {
            isNeedDepcies.set(true);
            sb.append(getAlterTableColumn(false, newColumn.name, isNeedAlterTable));
            sb.append(" TYPE ").append(newType);

            if (newCollation != null) {
                sb.append(COLLATE).append(newCollation);
            }

            if (!getDatabaseArguments().isUsingTypeCastOff() && !(parent instanceof IForeignTable)) {
                sb.append(" USING ").append(PgDiffUtils.getQuotedName(newColumn.name))
                .append("::").append(newType);
            }
            sb.append(isLastColumn ? ";" : ",");
            sb.append(" /* " + MessageFormat.format(Messages.Table_TypeParameterChange,
                    newColumn.parent.getParent().getName() + '.' + newColumn.parent.getName(),
                    oldType, newType) + " */");
        }
    }

    /**
     * Compares two columns foreign options and write difference to StringBuilder.
     *
     * @param oldForeignOptions - old column foreign options
     * @param newForeignOptions - new column foreign options
     * @param script            - collection for actions
     */
    private void compareForeignOptions(Map<String, String> oldForeignOptions, Map<String, String> newForeignOptions,
            SQLScript script) {
        if (!oldForeignOptions.isEmpty() || !newForeignOptions.isEmpty()) {
            oldForeignOptions.forEach((key, value) -> {
                if (newForeignOptions.containsKey(key)) {
                    String newValue =  newForeignOptions.get(key);
                    if (!Objects.equals(value, newValue)) {
                        script.addStatement(getAlterOption("SET", key, newValue));
                    }
                } else {
                    script.addStatement(getAlterOption("DROP", key, ""));
                }
            });

            newForeignOptions.forEach((key, value) -> {
                if (!oldForeignOptions.containsKey(key)) {
                    script.addStatement(getAlterOption("ADD", key, value));
                }
            });
        }
    }

    private String getAlterOption(String action, String key, String value) {
        return MessageFormat.format(ALTER_FOREIGN_OPTION, getAlterTableColumn(false, name), action, key, value);
    }

    /**
     * Compares two columns null values and write difference to StringBuilder.
     *
     * @param oldNull - old column null value
     * @param newNull - new column null value
     * @param hasDefault - true if new column has default value
     * @param sqlActions- actions for collect sql statements
     */
    private void compareNullValues(boolean oldNull, boolean newNull, boolean hasDefault, SQLScript script) {
        if (oldNull == newNull) {
            return;
        }

        if (newNull) {
            script.addStatement(getAlterTableColumn(true, name) + " DROP" + NOT_NULL);
            return;
        }

        if (hasDefault) {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE ").append(parent.getQualifiedName())
            .append("\n\tSET ").append(PgDiffUtils.getQuotedName(name))
            .append(" = DEFAULT WHERE ").append(PgDiffUtils.getQuotedName(name))
            .append(" IS").append(NULL);
            script.addStatement(sql.toString());
        }
        script.addStatement(getAlterTableColumn(false, name) + " SET" + NOT_NULL);
    }

    /**
     * Compares two columns default values and write difference to StringBuilder. If
     * the default values ​​are not equal, and the new value is not null, then the
     * column will be changed with dependencies.
     *
     * @param oldDefault    - old column default value
     * @param newDefault    - new column default value
     * @param isNeedDepcies - if set true, column will be changed with dependencies
     * @param script        for collect sql statements
     */
    private void compareDefaults(String oldDefault, String newDefault, AtomicBoolean isNeedDepcies, SQLScript script) {
        if (!Objects.equals(oldDefault, newDefault)) {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterTableColumn(true, name));
            if (newDefault == null) {
                sql.append(" DROP DEFAULT");
            } else {
                sql.append(" SET DEFAULT ").append(newDefault);
                isNeedDepcies.set(true);
            }
            script.addStatement(sql);
        }
    }

    /**
     * Compares two columns statistics and write difference to StringBuilder.
     *
     * @param oldStat - old column statistics
     * @param newStat - new column statistics
     * @param script  for collect sql statements
     */
    private void compareStats(Integer oldStat, Integer newStat, SQLScript script) {
        Integer newStatValue = null;

        if (newStat != null && (oldStat == null || !newStat.equals(oldStat))) {
            newStatValue = newStat;
        } else if (oldStat != null && newStat == null) {
            newStatValue = Integer.valueOf(-1);
        }
        if (newStatValue != null) {
            script.addStatement(getAlterTableColumn(true, name) + " SET STATISTICS " + newStatValue);
        }
    }

    /**
     * Compares two columns storages and writes difference to StringBuilder. If new
     * column doesn't have storage, adds warning as SQL comment.
     *
     * @param oldStorage - old column storage
     * @param newStorage - new column storage
     * @param script     for collect sql statements
     */
    private void compareStorages(String oldStorage, String newStorage, SQLScript script) {
        StringBuilder sql;
        if (newStorage == null && oldStorage != null) {
            sql = new StringBuilder();
            sql.append(MessageFormat.format(
                    Messages.Storage_WarningUnableToDetermineStorageType,
                    parent.getName(), name));
            script.addStatement(sql);
        } else if (newStorage != null && !newStorage.equalsIgnoreCase(oldStorage)) {
            script.addStatement(getAlterTableColumn(true, name) + " SET STORAGE " + newStorage);
        }
    }

    private void compareCompression(String oldCompression, String newCompression, SQLScript script) {
        if (newCompression == null && oldCompression != null) {
            script.addStatement(getAlterTableColumn(true, name) + " SET COMPRESSION DEFAULT");
            return;
        }
        if (newCompression == null || newCompression.equalsIgnoreCase(oldCompression)) {
            return;
        }
        script.addStatement(getAlterTableColumn(true, name) + " SET COMPRESSION " + PgDiffUtils.getQuotedName(newCompression));
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
            AbstractColumn parentCol = parentTbl.getColumn(name);
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

    @Override
    public void setCompressLevel(int compressLevel) {
        this.compressLevel = compressLevel;
        resetHash();
    }

    @Override
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
        resetHash();
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

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgColumn col && super.compare(obj)) {
            return compareColOptions(col);
        }

        return false;
    }

    private boolean compareColOptions(PgColumn col) {
        return Objects.equals(statistics, col.statistics)
                && Objects.equals(storage, col.storage)
                && Objects.equals(identityType, col.identityType)
                && isInherit == col.isInherit
                && isGenerated == col.isGenerated
                && options.equals(col.options)
                && fOptions.equals(col.fOptions)
                && compareCompressOptions(col)
                && Objects.equals(sequence, col.sequence)
                && Objects.equals(compression, col.compression);
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
        PgColumn copy = new PgColumn(name);
        copy.setStatistics(statistics);
        copy.setStorage(storage);
        copy.options.putAll(options);
        copy.fOptions.putAll(fOptions);
        copy.setCompressType(compressType);
        copy.setCompressLevel(compressLevel);
        copy.setBlockSize(blockSize);
        copy.setIdentityType(identityType);
        copy.setSequence(sequence);
        copy.setCompression(compression);
        copy.setInherit(isInherit);
        copy.setGenerated(isGenerated);
        return copy;
    }
}
