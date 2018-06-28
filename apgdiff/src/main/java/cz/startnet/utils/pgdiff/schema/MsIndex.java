package cz.startnet.utils.pgdiff.schema;

import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsIndex extends PgIndex {

    public MsIndex(String name, String rawStatement) {
        super(name, rawStatement);
        setPostgres(false);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");

        if (isUnique()) {
            sbSQL.append("UNIQUE ");
        }

        if (isClusterIndex()) {
            sbSQL.append("CLUSTERED ");
        }

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

    // TODO append alter for each part of definition
    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (newCondition instanceof MsIndex && !compare(newCondition)) {
            isNeedDepcies.set(true);
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
}
