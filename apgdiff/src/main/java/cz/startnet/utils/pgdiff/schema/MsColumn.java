package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public class MsColumn extends PgColumn {

    // TODO ROWGUIDCOL | PERSISTED | HIDDEN | MASKED
    private boolean isSparse;
    private boolean isNotForRep;
    private String identity;
    private String defaultName;

    public MsColumn(String name) {
        super(name);
    }

    @Override
    public String getFullDefinition() {
        final StringBuilder sbDefinition = new StringBuilder();
        sbDefinition.append(MsDiffUtils.quoteName(name));
        sbDefinition.append(' ');
        sbDefinition.append(MsDiffUtils.quoteName(getType()));

        if (getCollation() != null) {
            sbDefinition.append(" COLLATE ").append(getCollation());
        }

        if (isSparse()) {
            sbDefinition.append(" SPARSE");
        }

        sbDefinition.append(getNullValue() ? " NULL" : " NOT NULL");

        if (identity != null) {
            sbDefinition.append(" IDENTITY (").append(identity).append(")");;
        }

        if (isNotForRep()) {
            sbDefinition.append(" NOT FOR REPLICATION");
        }

        if (getDefaultName() != null && getDefaultValue() != null) {
            sbDefinition.append(" CONSTRAINT ");
            sbDefinition.append(MsDiffUtils.quoteName(getDefaultName()));
            sbDefinition.append(" DEFAULT ");
            sbDefinition.append(getDefaultValue());
        }

        return sbDefinition.toString();
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();

        sb.append(getAlterTable());
        sb.append("\n\tADD COLUMN ");
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

        // recreate column to change identity
        if (!Objects.equals(newColumn.getIdentity(), getIdentity())) {
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

        if (newColumn.isSparse() != isSparse()) {
            sb.append(getAlterColumn(true, false, name));
            sb.append(newColumn.isSparse() ? " ADD" : " DROP" );
            sb.append(" SPARSE");
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
            sb.append(getAlterColumn(true, false, newColumn.getName())).append(newColumn.getType());

            if (newCollation != null) {
                sb.append(" COLLATE ").append(newCollation);
            }

            sb.append(newColumn.getNullValue() ? " NULL" : " NOT NULL");
            sb.append(GO);
        }
    }

    @Override
    protected String getAlterColumn(boolean newLine, boolean only, String column) {
        return ((PgTable)this.getParent()).getAlterTable(newLine, only) + ALTER_COLUMN +
                MsDiffUtils.quoteName(column);
    }

    @Override
    public String getDropSQL() {
        return getAlterTable() + "\n\tDROP COLUMN "
                + PgDiffUtils.getQuotedName(getName()) + GO;
    }

    public boolean isSparse() {
        return isSparse;
    }

    public void setSparse(final boolean isSparse) {
        this.isSparse = isSparse;
        resetHash();
    }

    public boolean isNotForRep() {
        return isNotForRep;
    }

    public void setNotForRep(final boolean isNotForRep) {
        this.isNotForRep = isNotForRep;
        resetHash();
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(final String defaultName) {
        this.defaultName = defaultName;
        resetHash();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(final String identity) {
        this.identity = identity;
        resetHash();
    }

    @Override
    public MsColumn shallowCopy() {
        MsColumn colDst = new MsColumn(getName());
        colDst.setType(getType());
        colDst.setCollation(getCollation());
        colDst.setNullValue(getNullValue());
        colDst.setDefaultValue(getDefaultValue());
        colDst.setSparse(isSparse);
        colDst.setNotForRep(isNotForRep);
        colDst.setIdentity(identity);
        colDst.setDefaultName(defaultName);
        for (PgPrivilege priv : grants) {
            colDst.addPrivilege(priv);
        }
        for (PgPrivilege priv : revokes) {
            colDst.addPrivilege(priv);
        }
        colDst.deps.addAll(deps);
        return colDst;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isSparse);
        hasher.put(isNotForRep);
        hasher.put(identity);
        hasher.put(defaultName);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsColumn && super.compare(obj)) {
            MsColumn col = (MsColumn) obj;
            return Objects.equals(isSparse, col.isSparse())
                    && Objects.equals(isNotForRep, col.isNotForRep())
                    && Objects.equals(identity, col.getIdentity())
                    && Objects.equals(defaultName, col.getDefaultName());
        }

        return false;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
