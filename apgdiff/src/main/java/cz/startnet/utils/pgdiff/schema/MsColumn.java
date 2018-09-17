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
        sb.append("\n\tADD ");
        sb.append(getFullDefinition());
        sb.append(GO);

        appendPrivileges(sb);
        return sb.toString();
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

        compareTypes(newColumn, sb);

        if (newColumn.isNotForRep() != isNotForRep()) {
            sb.append(getAlterColumn(true, false, name));
            sb.append(newColumn.isNotForRep() ? " ADD" : " DROP" );
            sb.append(" NOT FOR REPLICATION");
            sb.append(GO);
        }

        if (newColumn.isSparse() != isSparse()) {
            sb.append(getAlterColumn(true, false, name));
            sb.append(newColumn.isSparse() ? " ADD" : " DROP" );
            sb.append(" SPARSE");
            sb.append(GO);
        }

        if (newColumn.isRowGuidCol() != isRowGuidCol()) {
            sb.append(getAlterColumn(true, false, name));
            sb.append(newColumn.isRowGuidCol() ? " ADD" : " DROP" );
            sb.append(" ROWGUIDCOL");
            sb.append(GO);
        }

        if (newColumn.isPersisted() != isPersisted()) {
            sb.append(getAlterColumn(true, false, name));
            sb.append(newColumn.isPersisted() ? " ADD" : " DROP" );
            sb.append(" PERSISTED");
            sb.append(GO);
        }

        String newDefault = newColumn.getDefaultValue();
        if (!Objects.equals(newDefault, getDefaultValue())
                || !Objects.equals(getDefaultName(), newColumn.getDefaultName())) {
            if (getDefaultValue() != null) {
                sb.append(getAlterColumn(true, false, name));
                sb.append(" DROP CONSTRAINT ").append(getDefaultName());
                sb.append(GO);
            }

            if (newDefault != null) {
                sb.append(getAlterColumn(true, false, name));
                sb.append(" ADD CONSTRAINT ");
                sb.append(MsDiffUtils.quoteName(newColumn.getDefaultName()));
                sb.append(" DEFAULT ");
                sb.append(newDefault);
                sb.append(GO);
            }
        }

        alterPrivileges(newColumn, sb);

        return sb.length() > startLength;
    }

    private void compareTypes(MsColumn newColumn, StringBuilder sb) {
        String newCollation = newColumn.getCollation();
        if (!Objects.equals(getType(), newColumn.getType())
                || !Objects.equals(newCollation, getCollation())
                || newColumn.getNullValue() != getNullValue()) {

            sb.append(getAlterColumn(true, false, newColumn.getName()))
            .append(' ').append(newColumn.getType());

            if (newCollation != null) {
                sb.append(" COLLATE ").append(newCollation);
            }

            sb.append(newColumn.getNullValue() ? " NULL" : " NOT NULL");
            sb.append(GO);
        }
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
