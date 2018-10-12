package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsColumn extends AbstractColumn {

    public MsColumn(String name) {
        super(name);
    }

    @Override
    public String getFullDefinition() {
        final StringBuilder sbDefinition = new StringBuilder();
        sbDefinition.append(MsDiffUtils.quoteName(name));
        sbDefinition.append(' ');
        if (getExpression() != null) {
            sbDefinition.append("AS ").append(getExpression());
        } else {
            sbDefinition.append(getType());
        }

        if (getCollation() != null) {
            sbDefinition.append(" COLLATE ").append(getCollation());
        }

        if (isSparse()) {
            sbDefinition.append(" SPARSE");
        }

        if (isRowGuidCol()) {
            sbDefinition.append(" ROWGUIDCOL");
        }

        if (isPersisted()) {
            sbDefinition.append(" PERSISTED");
        }

        if (getExpression() == null) {
            sbDefinition.append(getNullValue() ? " NULL" : " NOT NULL");
        }

        if (isIdentity()) {
            sbDefinition.append(" IDENTITY (").append(getSeed()).append(',').append(getIncrement()).append(")");
            if (isNotForRep()) {
                sbDefinition.append(" NOT FOR REPLICATION");
            }
        }

        if (getDefaultValue() != null) {
            if (getDefaultName() != null) {
                sbDefinition.append(" CONSTRAINT ");
                sbDefinition.append(MsDiffUtils.quoteName(getDefaultName()));
            }
            sbDefinition.append(" DEFAULT ");
            sbDefinition.append(getDefaultValue());
        }

        return sbDefinition.toString();
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();

        sb.append(getAlterTable());
        sb.append("\n\tADD ").append(MsDiffUtils.quoteName(name)).append(' ');
        if (getExpression() != null) {
            sb.append("AS ").append(getExpression());
        } else {
            sb.append(getType());
        }

        if (getCollation() != null) {
            sb.append(" COLLATE ").append(getCollation());
        }

        if (isIdentity()) {
            sb.append(" IDENTITY (").append(getSeed()).append(',').append(getIncrement()).append(")");
            if (isNotForRep()) {
                sb.append(" NOT FOR REPLICATION");
            }
        }

        boolean isJoinNotNull = getExpression() == null && getDefaultValue() == null
                && !getNullValue();

        if (isJoinNotNull) {
            sb.append(" NOT NULL");
        }

        sb.append(GO);

        compareDefaults(null, null, getDefaultName(), getDefaultValue(), sb);

        if (!isJoinNotNull && getExpression() == null && !getNullValue()) {
            if (getDefaultValue() != null) {
                appendUpdate(sb);
            }

            sb.append(getAlterColumn(true, false, getName()))
            .append(' ').append(getType());

            if (getCollation() != null) {
                sb.append(" COLLATE ").append(getCollation());
            }

            sb.append(" NOT NULL");
            sb.append(GO);
        }

        compareOption(false, isSparse(), "SPARSE", sb);
        compareOption(false, isRowGuidCol(), "ROWGUIDCOL", sb);
        compareOption(false, isPersisted(), "PERSISTED", sb);

        appendPrivileges(sb);
        return sb.toString();
    }

    private void compareOption(boolean oldOption, boolean newOption,
            String optionName, StringBuilder sb) {
        if (oldOption != newOption) {
            sb.append(getAlterColumn(true, false, name));
            sb.append(newOption ? " ADD " : " DROP ");
            sb.append(optionName);
            sb.append(GO);
        }
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsColumn newColumn;
        if (newCondition instanceof MsColumn) {
            newColumn = (MsColumn) newCondition;
        } else {
            return false;
        }

        // recreate column to change identity or computed value
        if (!Objects.equals(newColumn.getSeed(), getSeed())
                || !Objects.equals(newColumn.getIncrement(), getIncrement())
                || !Objects.equals(newColumn.getExpression(), getExpression())) {
            isNeedDepcies.set(true);
            return true;
        }


        boolean isNeedDropDefault = !Objects.equals(getType(), newColumn.getType())
                && (!Objects.equals(getDefaultValue(), newColumn.getDefaultValue())
                        || !Objects.equals(getDefaultName(), newColumn.getDefaultName()));

        if (isNeedDropDefault) {
            compareDefaults(getDefaultName(), getDefaultValue(), null, null, sb);
        }

        compareTypes(newColumn, sb);

        String oldDefaultName = isNeedDropDefault ? null : getDefaultName();
        String oldDefault = isNeedDropDefault ? null : getDefaultValue();
        compareDefaults(oldDefaultName, oldDefault, newColumn.getDefaultName(),
                newColumn.getDefaultValue(), sb);

        compareNullValues(newColumn, sb);

        compareOption(isNotForRep(), newColumn.isNotForRep(), "NOT FOR REPLICATION", sb);
        compareOption(isSparse(), newColumn.isSparse(), "SPARSE", sb);
        compareOption(isRowGuidCol(), newColumn.isRowGuidCol(), "ROWGUIDCOL", sb);
        compareOption(isPersisted(), newColumn.isPersisted(), "PERSISTED", sb);

        alterPrivileges(newColumn, sb);

        return sb.length() > startLength;
    }

    private void compareDefaults(String oldDefaultName, String oldDefault,
            String newDefaultName, String newDefault, StringBuilder sb) {
        if (!Objects.equals(oldDefault, newDefault)
                || !Objects.equals(oldDefaultName, newDefaultName)) {
            if (oldDefault != null) {
                sb.append(((AbstractTable)this.getParent()).getAlterTable(true, false));
                sb.append(" DROP CONSTRAINT ").append(MsDiffUtils.quoteName(oldDefaultName));
                sb.append(GO);
            }

            if (newDefault != null) {
                sb.append(((AbstractTable)this.getParent()).getAlterTable(true, false));
                sb.append(" ADD CONSTRAINT ").append(MsDiffUtils.quoteName(newDefaultName));
                sb.append(" DEFAULT ").append(newDefault);
                sb.append(" FOR ").append(MsDiffUtils.quoteName(name));
                sb.append(GO);
            }
        }
    }

    private void compareTypes(MsColumn newColumn, StringBuilder sb) {
        String newCollation = newColumn.getCollation();
        if (!Objects.equals(getType(), newColumn.getType())
                || !Objects.equals(newCollation, getCollation())) {

            sb.append(getAlterColumn(true, false, newColumn.getName()))
            .append(' ').append(newColumn.getType());

            if (newCollation != null) {
                sb.append(" COLLATE ").append(newCollation);
            }

            if (getNullValue() == newColumn.getNullValue()) {
                sb.append(newColumn.getNullValue() ? " NULL" : " NOT NULL");
            }
            sb.append(GO);
        }
    }

    private void compareNullValues(MsColumn newColumn, StringBuilder sb) {
        if (newColumn.getNullValue() != getNullValue()) {
            if (newColumn.getDefaultValue() != null && getNullValue() && !newColumn.getNullValue()) {
                appendUpdate(sb);
            }

            sb.append(getAlterColumn(true, false, newColumn.getName()))
            .append(' ').append(newColumn.getType());

            if (newColumn.getCollation() != null) {
                sb.append(" COLLATE ").append(newColumn.getCollation());
            }

            sb.append(newColumn.getNullValue() ? " NULL" : " NOT NULL");
            sb.append(GO);
        }
    }

    private void appendUpdate(StringBuilder sb) {
        sb.append("\n\nUPDATE ").append(getParent().getQualifiedName())
        .append("\n\tSET ").append(MsDiffUtils.quoteName(name))
        .append(" = DEFAULT WHERE ")
        .append(MsDiffUtils.quoteName(name)).append(" IS NULL");
        sb.append(GO);
    }

    private String getAlterColumn(boolean newLine, boolean only, String column) {
        return ((AbstractTable)this.getParent()).getAlterTable(newLine, only) + ALTER_COLUMN +
                MsDiffUtils.quoteName(column);
    }

    @Override
    public String getDropSQL() {
        return getAlterTable() + "\n\tDROP COLUMN " + MsDiffUtils.getQuotedName(getName()) + GO;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    protected AbstractColumn getColumnCopy() {
        return new MsColumn(getName());
    }
}
