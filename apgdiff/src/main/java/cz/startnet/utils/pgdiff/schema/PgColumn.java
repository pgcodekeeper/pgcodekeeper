/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

/**
 * Stores column information.
 */
public class PgColumn extends AbstractColumn {

    private static final String ALTER_FOREIGN_OPTION =  "{0} OPTIONS ({1} {2} {3});";

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
            if (getCollation() != null) {
                sbDefinition.append(" COLLATE ").append(getCollation());
            }
        }

        if (getDefaultValue() != null) {
            sbDefinition.append(" DEFAULT ");
            sbDefinition.append(getDefaultValue());
        }

        if (!getNullValue()) {
            sbDefinition.append(" NOT NULL");
        }

        return sbDefinition.toString();
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();

        if (getType() != null) {
            sb.append(getAlterTable());
            sb.append("\n\tADD COLUMN ")
            .append(PgDiffUtils.getQuotedName(name))
            .append(' ')
            .append(getType());
            if (getCollation() != null) {
                sb.append(" COLLATE ").append(getCollation());
            }
            sb.append(';');
        }

        compareDefaults(null, getDefaultValue(), new AtomicBoolean(), sb);
        compareNullValues(true, getNullValue(), getDefaultValue() != null, sb);
        compareStorages(null, getStorage(), sb);

        appendPrivileges(sb);

        compareForeignOptions(Collections.<String, String>emptyMap(), fOptions, sb);
        writeOptions(true, sb);
        compareStats(null, getStatistics(), sb);
        compareIdentity(null, getIdentityType(), null, getSequence(), sb);

        if (comment != null && !comment.isEmpty()) {
            sb.append("\n\n");
            appendCommentSql(sb);
        }

        return sb.toString();
    }

    private String getAlterColumn(boolean newLine, boolean only, String column) {
        return ((AbstractTable) getParent()).getAlterTable(newLine, only) + ALTER_COLUMN +
                PgDiffUtils.getQuotedName(column);
    }

    @Override
    public String getDropSQL() {
        if (getType() != null) {
            return getAlterTable() + "\n\tDROP COLUMN "
                    + PgDiffUtils.getQuotedName(getName()) + ';';
        }

        StringBuilder sb = new StringBuilder();

        compareDefaults(getDefaultValue(), null, null, sb);
        compareNullValues(getNullValue(), true, false, sb);
        compareStorages(getStorage(), null, sb);

        alterPrivileges(new PgColumn(name), sb);

        compareForeignOptions(fOptions, Collections.<String, String>emptyMap(), sb);
        writeOptions(false, sb);
        compareStats(getStatistics(), null, sb);
        compareIdentity(getIdentityType(), null, getSequence(), null, sb);

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

        boolean isNeedDropDefault = !Objects.equals(getType(), newColumn.getType())
                && !Objects.equals(getDefaultValue(), newColumn.getDefaultValue());

        if (isNeedDropDefault) {
            compareDefaults(getDefaultValue(), null, null, sb);
        }

        compareTypes(this, newColumn, isNeedDepcies, sb);

        String oldDefault = isNeedDropDefault ? null : getDefaultValue();
        compareDefaults(oldDefault, newColumn.getDefaultValue(), isNeedDepcies, sb);
        compareNullValues(getNullValue(), newColumn.getNullValue(), newColumn.getDefaultValue() != null, sb);
        compareStorages(getStorage(), newColumn.getStorage(), sb);

        alterPrivileges(newColumn, sb);

        compareOptions(newColumn, sb);
        compareForeignOptions(getForeignOptions(), newColumn.getForeignOptions(), sb);
        compareStats(getStatistics(), newColumn.getStatistics(), sb);
        compareIdentity(getIdentityType(), newColumn.getIdentityType(),
                getSequence(), newColumn.getSequence(), sb);

        if (!Objects.equals(getComment(), newColumn.getComment())) {
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
            AbstractSequence oldSequence, AbstractSequence newSequence, StringBuilder sb) {

        if (!Objects.equals(oldIdentityType, newIdentityType)) {
            sb.append(getAlterColumn(true, false, PgDiffUtils.getQuotedName(name)));

            if (newIdentityType == null) {
                sb.append(" DROP IDENTITY;");
            } else if (oldIdentityType == null) {
                sb.append(" ADD GENERATED ")
                .append(newIdentityType)
                .append(" AS IDENTITY (")
                .append("\n\tSEQUENCE NAME ")
                .append(PgDiffUtils.getQuotedName(newSequence.getContainingSchema().getName()))
                .append('.')
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
                .append(PgDiffUtils.getQuotedName(oldSequence.getContainingSchema().getName()))
                .append('.')
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
     * @param hasDefault - true if new column has default value
     * @param sb - StringBuilder for difference
     */
    private void compareNullValues(boolean oldNull, boolean newNull, boolean hasDefault, StringBuilder sb) {
        if (oldNull != newNull) {
            if (newNull) {
                sb.append(getAlterColumn(true, true, PgDiffUtils.getQuotedName(name)));
                sb.append(" DROP NOT NULL;");
            } else {
                if (hasDefault) {
                    sb.append("\n\nUPDATE ONLY ").append(getParent().getQualifiedName())
                    .append("\n\tSET ").append(PgDiffUtils.getQuotedName(name))
                    .append(" = DEFAULT WHERE ")
                    .append(PgDiffUtils.getQuotedName(name)).append(" IS NULL;");
                }
                sb.append(getAlterColumn(true, true, PgDiffUtils.getQuotedName(name)));
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
    protected AbstractColumn getColumnCopy() {
        return new PgColumn(getName());
    }
}
