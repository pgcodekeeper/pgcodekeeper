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

    private static final String ALTER_TABLE = "ALTER TABLE ";
    private static final String ALTER_COLUMN = "\n\tALTER COLUMN ";
    private static final String ALTER_FOREIGN_OPTION =  "\n\n{0} ALTER COLUMN {1} OPTIONS ({2} {3} {4});";

    private Integer statistics;
    private String defaultValue;
    private String type;
    private String collation;
    private boolean nullValue = true;
    private String storage;
    private final Map<String, String> options = new LinkedHashMap<>(0);
    private final Map<String, String> fOptions = new LinkedHashMap<>(0);
    private PgSequence sequence;
    private String identityType;

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

    /**
     * Returns full definition of the column.
     *
     * @param addDefaults whether default value should be added in case NOT NULL
     *                    constraint is specified but no default value is set
     *
     * @return full definition of the column
     */
    public String getFullDefinition(final boolean addDefaults,
            StringBuilder separateDefault) {
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

        if (defaultValue != null && !defaultValue.isEmpty()) {
            StringBuilder sbDefault = sbDefinition;
            if (separateDefault != null && nullValue) {
                sbDefault = separateDefault;
                sbDefault.append(cName);
                sbDefault.append(" SET");
            }
            sbDefault.append(" DEFAULT ");
            sbDefault.append(defaultValue);
        } else if (!nullValue && addDefaults) {
            final String defaultColValue = PgColumnUtils.getDefaultValue(type);

            if (defaultColValue != null) {
                sbDefinition.append(" DEFAULT ");
                sbDefinition.append(defaultColValue);
            }
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
        StringBuilder defaultStatement = new StringBuilder();
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(getAlterTable());
        if (type == null) {
            sbSQL.append(getTypelessColDef(true));
        } else {
            sbSQL.append("\n\tADD COLUMN ")
            .append(getFullDefinition(false, defaultStatement));
        }
        sbSQL.append(';');
        if (defaultStatement.length() > 0) {
            sbSQL.append("\n\n")
            .append(getAlterTable())
            .append(ALTER_COLUMN)
            .append(defaultStatement)
            .append(';');
        }
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }
        return sbSQL.toString();
    }

    private String getTypelessColDef(boolean isCreate) {
        StringBuilder sb = new StringBuilder();
        String cName = PgDiffUtils.getQuotedName(name);
        if (defaultValue != null && !defaultValue.isEmpty()) {
            sb.append(ALTER_COLUMN).append(cName);
            if (isCreate) {
                sb.append(" SET DEFAULT ").append(defaultValue);
            } else {
                sb.append(" DROP DEFAULT");
            }
            sb.append(",");
        }
        if (!nullValue) {
            sb.append(ALTER_COLUMN).append(cName);
            sb.append( isCreate ? " SET" : " DROP").append(" NOT NULL,");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();

    }

    private String getAlterTable() {
        return ALTER_TABLE + PgDiffUtils.getQuotedName(this.getParent().getName());
    }

    @Override
    public String getDropSQL() {
        String drop;
        if (type == null) {
            drop = getTypelessColDef(false);
        } else {
            drop = "\n\tDROP COLUMN " + PgDiffUtils.getQuotedName(getName());
        }
        return getAlterTable() + drop + ';';
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
        final Integer oldStat = oldColumn.getStatistics();
        final Integer newStat = newColumn.getStatistics();
        Integer newStatValue = null;

        if (newStat != null && (oldStat == null || !newStat.equals(oldStat))) {
            newStatValue = newStat;
        } else if (oldStat != null && newStat == null) {
            newStatValue = Integer.valueOf(-1);
        }

        if (newStatValue != null) {
            sb.append("\n\n" + ALTER_TABLE + "ONLY "
                    + PgDiffUtils.getQuotedName(this.getParent().getName())
                    + ALTER_COLUMN + PgDiffUtils.getQuotedName(getName())
                    + " SET STATISTICS " + newStatValue + ';');
        }
        final String oldStorage =
                (oldColumn.getStorage() == null ||oldColumn.getStorage().isEmpty()) ?
                        null : oldColumn.getStorage();
        final String newStorage =
                (newColumn.getStorage() == null || newColumn.getStorage().isEmpty()) ?
                        null : newColumn.getStorage();

        if (newStorage == null && oldStorage != null) {
            sb.append("\n\n" + MessageFormat.format(
                    Messages.Storage_WarningUnableToDetermineStorageType,
                    newColumn.getParent().getName(), newColumn.getName()));
        }

        if (newStorage != null && !newStorage.equalsIgnoreCase(oldStorage)) {
            sb.append("\n\n")
            .append(ALTER_TABLE)
            .append("ONLY ")
            .append(PgDiffUtils.getQuotedName(newColumn.getParent().getName()))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(newColumn.getName()))
            .append(" SET STORAGE ")
            .append(newStorage)
            .append(';');
        }

        if (!Objects.equals(oldColumn.getType(), newColumn.getType()) ||
                (newColumn.getCollation() != null &&
                !newColumn.getCollation().equals(oldColumn.getCollation()))) {
            isNeedDepcies.set(true);

            sb.append(
                    "\n\n" + getAlterTable()
                    + ALTER_COLUMN
                    + PgDiffUtils.getQuotedName(newColumn.getName())
                    + " TYPE "
                    + newColumn.getType());
            if (newColumn.getCollation() != null) {
                sb.append(" COLLATE ")
                .append(newColumn.getCollation());
            }

            PgDiffArguments arg = ((PgDatabase) newCondition.getParent().getParent().getParent()).getArguments();

            if (arg == null || !arg.isUsingTypeCastOff()) {
                sb.append(" USING ").append(PgDiffUtils.getQuotedName(newColumn.getName()))
                .append("::").append(newColumn.getType());
            }
            sb.append("; /* " + MessageFormat.format(Messages.Table_TypeParameterChange,
                    newColumn.getParent().getName(),
                    oldColumn.getType(), newColumn.getType()) + " */");
        }

        final String oldDefault = (oldColumn.getDefaultValue() == null) ? ""
                : oldColumn.getDefaultValue();
        final String newDefault = (newColumn.getDefaultValue() == null) ? ""
                : newColumn.getDefaultValue();

        if (!oldDefault.equals(newDefault)) {
            if (newDefault.isEmpty()) {
                sb.append("\n\n" + getAlterTable() + ALTER_COLUMN
                        + newColumn.getName() + " DROP DEFAULT;");
            } else {
                sb.append("\n\n" + getAlterTable() + ALTER_COLUMN
                        + newColumn.getName() + " SET DEFAULT " + newDefault + ';');
                isNeedDepcies.set(true);
            }
        }

        if (oldColumn.getNullValue() != newColumn.getNullValue()) {
            if (newColumn.getNullValue()) {
                sb.append("\n\n" + getAlterTable() + ALTER_COLUMN
                        + newColumn.getName() + " DROP NOT NULL;");
            } else {
                sb.append("\n\n" + getAlterTable() + ALTER_COLUMN
                        + newColumn.getName() + " SET NOT NULL;");
            }
        }

        alterPrivileges(newColumn, sb);
        compareOptions(oldColumn, newColumn, sb);

        Map<String, String> oldForeignOptions = oldColumn.getForeignOptions();
        Map<String, String> newForeignOptions = newColumn.getForeignOptions();

        if (!oldForeignOptions.isEmpty() || !newForeignOptions.isEmpty()) {
            oldForeignOptions.forEach((key, value) -> {
                if (newForeignOptions.containsKey(key)) {
                    String newValue =  newForeignOptions.get(key);
                    if (!Objects.equals(value, newValue)) {
                        sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION, getAlterTable(),
                                newColumn.getName(), "SET", key, newValue));
                    }
                } else {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION, getAlterTable(),
                            newColumn.getName(), "DROP", key, ""));
                }
            });

            newForeignOptions.forEach((key, value) -> {
                if (!oldForeignOptions.containsKey(key)) {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION, getAlterTable(),
                            newColumn.getName(), "ADD", key, value));
                }
            });
        }

        if (!Objects.equals(oldColumn.getComment(), newColumn.getComment())) {
            sb.append("\n\n");
            newColumn.appendCommentSql(sb);
        }

        String oldIdentityType = oldColumn.getIdentityType();
        String newIdentityType = newColumn.getIdentityType();

        if (!Objects.equals(oldIdentityType, newIdentityType)) {
            sb.append("\n\n").append(getAlterTable())
            .append(ALTER_COLUMN).append(newColumn.getName());

            if (newIdentityType == null) {
                sb.append(" DROP IDENTITY;");
            } else if (oldIdentityType == null) {
                PgSequence seq = newColumn.getSequence();
                sb.append(" ADD GENERATED ")
                .append(newIdentityType)
                .append(" AS IDENTITY (")
                .append("\n\tSEQUENCE NAME ")
                .append(seq.getName());
                seq.fillSequenceBody(sb);
                sb.append("\n);");
            } else {
                sb.append(" SET GENERATED ").append(newIdentityType).append(';');
            }
        }

        PgSequence oldSequence = oldColumn.getSequence();
        PgSequence newSequence = newColumn.getSequence();

        if (oldSequence != null && newSequence != null &&
                !Objects.equals(oldSequence, newSequence)) {
            if (!oldSequence.getName().equals(newSequence.getName())) {
                sb.append("\n\n").append("ALTER SEQUENCE ").append(oldSequence.getName())
                .append(" RENAME TO ").append(newSequence.getName()).append(';');
            }

            oldSequence.appendAlterSQL(newSequence, sb, new AtomicBoolean());
        }
        return sb.length() > startLength;
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
                    && Objects.equals(comment, col.getComment())
                    && grants.equals(col.grants)
                    && revokes.equals(col.revokes)
                    && Objects.equals(fOptions, col.fOptions)
                    && Objects.equals(sequence, col.sequence)
                    && Objects.equals(identityType, col.identityType)
                    && Objects.equals(options, col.options);
        }
        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (nullValue ? itrue : ifalse);
        result = prime * result + ((statistics == null) ? 0 : statistics.hashCode());
        result = prime * result + ((storage == null) ? 0 : storage.hashCode());
        result = prime * result + ((collation == null) ? 0 : collation.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((options == null) ? 0 : options.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((fOptions == null) ? 0 : fOptions.hashCode());
        result = prime * result + ((identityType == null) ? 0 : identityType.hashCode());
        result = prime * result + ((sequence == null) ? 0 : sequence.hashCode());
        return result;
    }

    @Override
    public PgColumn shallowCopy() {
        PgColumn colDst = new PgColumn(getName());
        colDst.setDefaultValue(getDefaultValue());
        colDst.setIdentityType(getIdentityType());
        colDst.setSequence(getSequence());
        colDst.setNullValue(getNullValue());
        colDst.setStatistics(getStatistics());
        colDst.setStorage(getStorage());
        colDst.setCollation(getCollation());
        colDst.setType(getType());
        colDst.setComment(getComment());
        colDst.options.putAll(options);
        colDst.fOptions.putAll(fOptions);
        for (PgPrivilege priv : grants) {
            colDst.addPrivilege(priv.deepCopy());
        }
        for (PgPrivilege priv : revokes) {
            colDst.addPrivilege(priv.deepCopy());
        }
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
