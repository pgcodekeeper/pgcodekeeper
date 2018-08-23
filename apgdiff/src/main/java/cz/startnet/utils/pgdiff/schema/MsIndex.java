package cz.startnet.utils.pgdiff.schema;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffArguments;

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
        if (getWhere() != null) {
            sbSQL.append("\nWHERE ").append(getWhere());
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : options.entrySet()) {
            sb.append(entry.getKey());
            if (!entry.getValue().isEmpty()){
                sb.append(" = ").append(entry.getValue());
            }
            sb.append(", ");
        }

        // TODO global preference: transaction cannot be used with concurrently mode for PG
        PgDiffArguments args = getDatabase().getArguments();
        if (args != null && args.isConcurrentlyMode() && !options.containsKey("ONLINE")) {
            sb.append("ONLINE = ON, ");
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(')');
        }

        if (getTableSpace() != null) {
            sbSQL.append("\nON ").append(MsDiffUtils.quoteName(getTableSpace()));
        }

        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (newCondition instanceof MsIndex && !compare(newCondition)) {
            isNeedDepcies.set(true);
            return true;
        }

        // options can be changed by syntax :
        // ALTER SEQUENCE index_name ON schema_name.table REBUILD WITH (options (, option)*)
        // but how to reset option? all indices has all option with default value
        // and we don't know what is it and how to change current value to default value.

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
