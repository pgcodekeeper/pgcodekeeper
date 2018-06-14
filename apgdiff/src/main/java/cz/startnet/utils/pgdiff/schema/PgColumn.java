/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores column information.
 *
 * @author fordfrog
 */
public class PgColumn extends PgStatementWithSearchPath implements PgOptionContainer {

    private static final String ALTER_COLUMN = "\n\tALTER COLUMN ";
    private static final String ALTER_FOREIGN_OPTION =  "{0} OPTIONS ({1} {2} {3});";

    private String type;
    private String collation;
    private boolean nullValue = true;
    private String defaultValue;
    private Integer statistics;
    private String storage;
    private final Map<String, String> options = new LinkedHashMap<>(0);
    private final Map<String, String> fOptions = new LinkedHashMap<>(0);
    private PgSequence sequence;
    private String identityType;
    private boolean isInherit;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.COLUMN;
    }

    public PgColumn(String name) {
        super(name, null);
    }

    public void setDefaultValue(final String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public String getDefaultValue() {
        return defaultValue;
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

    public boolean isInherit() {
        return isInherit;
    }

    public void setInherit(boolean isInherit) {
        this.isInherit = isInherit;
        resetHash();
    }

    /**
     * Returns full definition of the column.
     *
     * @return full definition of the column
     */
    public String getFullDefinition() {
        final StringBuilder sbDefinition = new StringBuilder();
        String cName = PgDiffUtils.getQuotedName(name);
        sbDefinition.append(cName);

        if (type == null) {
            sbDefinition.append(" WITH OPTIONS");
        } else {
            sbDefinition.append(' ');
            sbDefinition.append(type);
            if (collation != null) {
                sbDefinition.append(" COLLATE ").append(collation);
            }
        }

        if (defaultValue != null) {
            sbDefinition.append(" DEFAULT ");
            sbDefinition.append(defaultValue);
        }

        if (!nullValue) {
            sbDefinition.append(" NOT NULL");
        }

        return sbDefinition.toString();
    }


    public void setNullValue(final boolean nullValue) {
        this.nullValue = nullValue;
        resetHash();
    }

    public boolean getNullValue() {
        return nullValue;
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

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();

        if (type != null) {
            sb.append(getAlterTable());
            sb.append("\n\tADD COLUMN ")
            .append(PgDiffUtils.getQuotedName(name))
            .append(' ')
            .append(type);
            if (collation != null) {
                sb.append(" COLLATE ").append(collation);
            }
            sb.append(';');
        }

        compareDefaults(null, defaultValue, new AtomicBoolean(), sb);
        compareNullValues(true, nullValue, sb);
        compareStorages(null, storage, sb);

        appendPrivileges(sb);

        compareForeignOptions(Collections.<String, String>emptyMap(), fOptions, sb);
        writeOptions(true, sb);
        compareStats(null, statistics, sb);
        compareIdentity(null, identityType, null, sequence, sb);

        if (comment != null && !comment.isEmpty()) {
            sb.append("\n\n");
            appendCommentSql(sb);
        }

        return sb.toString();
    }

    private String getAlterTable() {
        return ((PgTable)this.getParent()).getAlterTable(false, false);
    }

    private String getAlterColumn(boolean newLine, boolean only, String column) {
        return ((PgTable)this.getParent()).getAlterTable(newLine, only) + ALTER_COLUMN +
                PgDiffUtils.getQuotedName(column);
    }

    @Override
    public String getDropSQL() {
        if (type != null) {
            return getAlterTable() + "\n\tDROP COLUMN "
                    + PgDiffUtils.getQuotedName(getName()) + ';';
        }

        StringBuilder sb = new StringBuilder();

        compareDefaults(defaultValue, null, new AtomicBoolean(), sb);
        compareNullValues(nullValue, true, sb);
        compareStorages(storage, null, sb);

        alterPrivileges(new PgColumn(name), sb);

        compareForeignOptions(fOptions, Collections.<String, String>emptyMap(), sb);
        writeOptions(false, sb);
        compareStats(statistics, null, sb);
        compareIdentity(identityType, null, sequence, null, sb);

        if (comment != null && !comment.isEmpty()) {
            sb.append("\n\n");
            appendCommentSql(sb);
        }

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgColumn newColumn;
        if (newCondition instanceof PgColumn) {
            newColumn = (PgColumn) newCondition;
        } else {
            return false;
        }
        PgColumn oldColumn = this;

        compareTypes(oldColumn, newColumn, isNeedDepcies, sb);

        compareDefaults(oldColumn.getDefaultValue(), newColumn.getDefaultValue(), isNeedDepcies, sb);
        compareNullValues(oldColumn.getNullValue(), newColumn.getNullValue(), sb);
        compareStorages(oldColumn.getStorage(), newColumn.getStorage(), sb);

        alterPrivileges(newColumn, sb);

        compareOptions(newColumn, sb);
        compareForeignOptions(oldColumn.getForeignOptions(), newColumn.getForeignOptions(), sb);
        compareStats(oldColumn.getStatistics(), newColumn.getStatistics(), sb);
        compareIdentity(oldColumn.getIdentityType(), newColumn.getIdentityType(),
                oldColumn.getSequence(), newColumn.getSequence(), sb);

        if (!Objects.equals(oldColumn.getComment(), newColumn.getComment())) {
            sb.append("\n\n");
            newColumn.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    /**
     * Writes SET/RESET options for column to StringBuilder
     *
     * @param isCreate - if true SET options, else RESET
     * @param sb - StringBuilder for options
     */
    private void writeOptions(boolean isCreate, StringBuilder sb) {
        if (!options.isEmpty()) {
            sb.append(getAlterColumn(true, true, PgDiffUtils.getQuotedName(name)));
            sb.append(isCreate ? " SET (" : " RESET (");
            for (Entry<String, String> option : options.entrySet()) {
                sb.append(option.getKey());
                if (isCreate && !option.getValue().isEmpty()) {
                    sb.append('=').append(option.getValue());
                }
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(");");
        }
    }

    /**
     * Compare columns identity and write difference to StringBuilder.
     *
     * @param oldIdentityType - old column identity type
     * @param newIdentityType - new column identity type
     * @param oldSequence - old column identity sequence
     * @param newSequence - new column identity sequence
     * @param sb - StringBuilder for difference
     */
    private void compareIdentity(String oldIdentityType, String newIdentityType,
            PgSequence oldSequence, PgSequence newSequence, StringBuilder sb) {

        if (!Objects.equals(oldIdentityType, newIdentityType)) {
            sb.append(getAlterColumn(true, false, PgDiffUtils.getQuotedName(name)));

            if (newIdentityType == null) {
                sb.append(" DROP IDENTITY;");
            } else if (oldIdentityType == null) {
                sb.append(" ADD GENERATED ")
                .append(newIdentityType)
                .append(" AS IDENTITY (")
                .append("\n\tSEQUENCE NAME ")
                .append(PgDiffUtils.getQuotedName(newSequence.getName()));
                newSequence.fillSequenceBody(sb);
                sb.append("\n);");
            } else {
                sb.append(" SET GENERATED ").append(newIdentityType).append(';');
            }
        }

        if (oldSequence != null && newSequence != null &&
                !Objects.equals(oldSequence, newSequence)) {
            if (!oldSequence.getName().equals(newSequence.getName())) {
                sb.append("\n\n").append("ALTER SEQUENCE ")
                .append(PgDiffUtils.getQuotedName(oldSequence.getName()))
                .append(" RENAME TO ")
                .append(PgDiffUtils.getQuotedName(newSequence.getName())).append(';');
            }

            oldSequence.appendAlterSQL(newSequence, sb, new AtomicBoolean());
        }
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
     */
    private void compareTypes(PgColumn oldColumn, PgColumn newColumn,
            AtomicBoolean isNeedDepcies, StringBuilder sb) {

        String oldCollation = oldColumn.getCollation();
        String newCollation = newColumn.getCollation();

        if (!Objects.equals(oldColumn.getType(), newColumn.getType()) ||
                (newCollation != null && !newCollation.equals(oldCollation))) {
            isNeedDepcies.set(true);

            sb.append(getAlterColumn(true, false, newColumn.getName()))
            .append(" TYPE ")
            .append(newColumn.getType());

            if (newCollation != null) {
                sb.append(" COLLATE ")
                .append(newCollation);
            }

            PgDiffArguments arg = getDatabase().getArguments();

            if (arg == null || !arg.isUsingTypeCastOff()) {
                sb.append(" USING ").append(PgDiffUtils.getQuotedName(newColumn.getName()))
                .append("::").append(newColumn.getType());
            }
            sb.append("; /* " + MessageFormat.format(Messages.Table_TypeParameterChange,
                    newColumn.getParent().getParent().getName() + '.' + newColumn.getParent().getName(),
                    oldColumn.getType(), newColumn.getType()) + " */");
        }
    }

    /**
     * Compares two columns foreign options and write difference to StringBuilder.
     *
     * @param oldForeignOptions - old column foreign options
     * @param newForeignOptions - new column foreign options
     * @param sb - StringBuilder for difference
     */
    private void compareForeignOptions(Map<String, String> oldForeignOptions,
            Map<String, String> newForeignOptions, StringBuilder sb) {
        if (!oldForeignOptions.isEmpty() || !newForeignOptions.isEmpty()) {
            oldForeignOptions.forEach((key, value) -> {
                if (newForeignOptions.containsKey(key)) {
                    String newValue =  newForeignOptions.get(key);
                    if (!Objects.equals(value, newValue)) {
                        sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                                getAlterColumn(true, false, PgDiffUtils.getQuotedName(name)),
                                "SET", key, newValue));
                    }
                } else {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterColumn(true, false, PgDiffUtils.getQuotedName(name)),
                            "DROP", key, ""));
                }
            });

            newForeignOptions.forEach((key, value) -> {
                if (!oldForeignOptions.containsKey(key)) {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterColumn(true, false, PgDiffUtils.getQuotedName(name)),
                            "ADD", key, value));
                }
            });
        }

    }

    /**
     * Compares two columns null values and write difference to StringBuilder.
     *
     * @param oldNull - old column null value
     * @param newNull - new column null value
     * @param sb - StringBuilder for difference
     */
    private void compareNullValues(boolean oldNull, boolean newNull, StringBuilder sb) {
        if (oldNull != newNull) {
            sb.append(getAlterColumn(true, true, PgDiffUtils.getQuotedName(name)));
            if (newNull) {
                sb.append(" DROP NOT NULL;");
            } else {
                sb.append(" SET NOT NULL;");
            }
        }
    }

    /**
     * Compares two columns default values and write difference to StringBuilder.
     * If the default values ​​are not equal, and the new value is not null,
     * then the column will be changed with dependencies.
     *
     * @param oldDefault - old column default value
     * @param newDefault - new column default value
     * @param isNeedDepcies - if set true, column will be changed with dependencies
     * @param sb - StringBuilder for difference
     */
    private void compareDefaults(String oldDefault, String newDefault,
            AtomicBoolean isNeedDepcies, StringBuilder sb) {
        if (!Objects.equals(oldDefault, newDefault)) {
            sb.append(getAlterColumn(true, true, PgDiffUtils.getQuotedName(name)));
            if (newDefault == null) {
                sb.append(" DROP DEFAULT;");
            } else {
                sb.append(" SET DEFAULT ").append(newDefault).append(';');
                isNeedDepcies.set(true);
            }
        }
    }

    /**
     * Compares two columns statistics and write difference to StringBuilder.
     *
     * @param oldStat - old column statistics
     * @param newStat - new column statistics
     * @param sb - StringBuilder for difference
     */
    private void compareStats(Integer oldStat, Integer newStat, StringBuilder sb) {
        Integer newStatValue = null;

        if (newStat != null && (oldStat == null || !newStat.equals(oldStat))) {
            newStatValue = newStat;
        } else if (oldStat != null && newStat == null) {
            newStatValue = Integer.valueOf(-1);
        }

        if (newStatValue != null) {
            sb.append(getAlterColumn(true, true, PgDiffUtils.getQuotedName(name)))
            .append(" SET STATISTICS ")
            .append(newStatValue)
            .append(';');
        }
    }

    /**
     * Compares two columns storages and writes difference to StringBuilder.
     * If new column doesn't have storage, adds warning as SQL comment.
     *
     * @param oldStorage - old column storage
     * @param newStorage - new column storage
     * @param sb - StringBuilder for difference
     */
    private void compareStorages(String oldStorage, String newStorage,
            StringBuilder sb) {
        if (newStorage == null && oldStorage != null) {
            sb.append("\n\n" + MessageFormat.format(
                    Messages.Storage_WarningUnableToDetermineStorageType,
                    getParent().getName(), getName()));
        } else if (newStorage != null && !newStorage.equalsIgnoreCase(oldStorage)) {
            sb.append(getAlterColumn(true, true, PgDiffUtils.getQuotedName(name)))
            .append(" SET STORAGE ")
            .append(newStorage)
            .append(';');
        }
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if(obj instanceof PgColumn) {
            PgColumn col = (PgColumn) obj;

            eq = Objects.equals(name, col.getName())
                    && Objects.equals(type, col.getType())
                    && Objects.equals(collation, col.getCollation())
                    && nullValue == col.getNullValue()
                    && Objects.equals(defaultValue, col.getDefaultValue())
                    && Objects.equals(statistics, col.getStatistics())
                    && Objects.equals(storage, col.getStorage())
                    && options.equals(col.options)
                    && fOptions.equals(col.fOptions)
                    && Objects.equals(sequence, col.sequence)
                    && Objects.equals(identityType, col.identityType)
                    && isInherit == col.isInherit()
                    && grants.equals(col.grants)
                    && revokes.equals(col.revokes)
                    && Objects.equals(comment, col.getComment());
        }
        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((collation == null) ? 0 : collation.hashCode());
        result = prime * result + (nullValue ? itrue : ifalse);
        result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
        result = prime * result + ((statistics == null) ? 0 : statistics.hashCode());
        result = prime * result + ((storage == null) ? 0 : storage.hashCode());
        result = prime * result + ((options == null) ? 0 : options.hashCode());
        result = prime * result + ((fOptions == null) ? 0 : fOptions.hashCode());
        result = prime * result + ((sequence == null) ? 0 : sequence.hashCode());
        result = prime * result + ((identityType == null) ? 0 : identityType.hashCode());
        result = prime * result + (isInherit ? itrue : ifalse);
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    @Override
    public PgColumn shallowCopy() {
        PgColumn colDst = new PgColumn(getName());
        colDst.setType(getType());
        colDst.setCollation(getCollation());
        colDst.setNullValue(getNullValue());
        colDst.setDefaultValue(getDefaultValue());
        colDst.setStatistics(getStatistics());
        colDst.setStorage(getStorage());
        colDst.options.putAll(options);
        colDst.fOptions.putAll(fOptions);
        colDst.setIdentityType(getIdentityType());
        colDst.setSequence(getSequence());
        colDst.setInherit(isInherit());
        for (PgPrivilege priv : grants) {
            colDst.addPrivilege(priv.deepCopy());
        }
        for (PgPrivilege priv : revokes) {
            colDst.addPrivilege(priv.deepCopy());
        }
        colDst.setComment(getComment());
        colDst.deps.addAll(deps);
        return colDst;
    }

    @Override
    public PgColumn deepCopy() {
        return shallowCopy();
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent().getParent();
    }
}
