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
    private boolean isIdentity;
    private String seed;
    private String increment;
    private String defaultName;
    private String expession;

    public MsColumn(String name) {
        super(name);
    }

    @Override
    public String getFullDefinition() {
        final StringBuilder sbDefinition = new StringBuilder();
        sbDefinition.append(MsDiffUtils.quoteName(name));
        sbDefinition.append(' ');
        if (expession != null) {
            sbDefinition.append("AS ").append(expession);
        } else {
            sbDefinition.append(getType());
        }

        if (getCollation() != null) {
            sbDefinition.append(" COLLATE ").append(getCollation());
        }

        if (isSparse()) {
            sbDefinition.append(" SPARSE");
        }

        sbDefinition.append(getNullValue() ? " NULL" : " NOT NULL");

        if (isIdentity) {
            sbDefinition.append(" IDENTITY (").append(seed).append(',').append(increment).append(")");
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
            sb.append(getAlterColumn(true, false, newColumn.getName()))
            .append(MsDiffUtils.quoteName(newColumn.getType()));

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

    public String getExpression() {
        return expession;
    }

    public void setExpression(final String expession) {
        this.expession = expession;
        resetHash();
    }

    public String getSeed() {
        return seed;
    }

    public String getIncrement() {
        return increment;
    }

    public void setIdentity(String seed, String increment) {
        this.seed = seed;
        this.increment = increment;
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
        colDst.seed = getSeed();
        colDst.increment = getIncrement();
        colDst.setDefaultName(defaultName);
        colDst.setExpression(expession);
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
        hasher.put(seed);
        hasher.put(increment);
        hasher.put(defaultName);
        hasher.put(expession);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsColumn && super.compare(obj)) {
            MsColumn col = (MsColumn) obj;
            return Objects.equals(isSparse, col.isSparse())
                    && Objects.equals(isNotForRep, col.isNotForRep())
                    && Objects.equals(seed, col.seed)
                    && Objects.equals(increment, col.increment)
                    && Objects.equals(defaultName, col.getDefaultName())
                    && Objects.equals(expession, col.getExpression());
        }

        return false;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
