package cz.startnet.utils.pgdiff.schema;

import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsIndex extends AbstractIndex {

    public MsIndex(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");

        if (isUnique()) {
            sbSQL.append("UNIQUE ");
        }

        if (!isClusterIndex()) {
            sbSQL.append("NON");
        }
        sbSQL.append("CLUSTERED ");

        sbSQL.append("INDEX ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        sbSQL.append(" ON ");
        sbSQL.append(MsDiffUtils.quoteName(getContainingSchema().getName()));
        sbSQL.append('.').append(MsDiffUtils.quoteName(getTableName()));
        sbSQL.append(' ');
        sbSQL.append(getDefinition());
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (newCondition instanceof MsIndex && !compare(newCondition)) {
            sb.append(newCondition.getCreationSQL());
            return true;
        }

        return false;
    }

    @Override
    public String getDropSQL() {
        return "DROP INDEX " + MsDiffUtils.quoteName(getName()) + " ON "
                + MsDiffUtils.quoteName(getContainingSchema().getName()) + '.'
                + MsDiffUtils.quoteName(getTableName()) + GO;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    protected AbstractIndex getIndexCopy() {
        return new MsIndex(getName(), getRawStatement());
    }
}
