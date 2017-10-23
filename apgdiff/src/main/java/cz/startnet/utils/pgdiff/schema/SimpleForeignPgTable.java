package cz.startnet.utils.pgdiff.schema;

import java.util.Map.Entry;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Simple foreign table object
 *
 * @since 4.1.1
 * @author galiev_mr
 *
 */
public class SimpleForeignPgTable extends ForeignPgTable {

    public SimpleForeignPgTable(String name, String rawStatement, String serverName) {
        super(name, rawStatement, serverName);
    }

    @Override
    protected PgTable getTableCopy(String name, String rawStatement) {
        return new SimpleForeignPgTable(name, rawStatement, serverName);
    }

    @Override
    public boolean compare(PgStatement obj) {
        return super.compare(obj)
                && Objects.equals(serverName, ((SimpleForeignPgTable) obj).getServerName());
    }

    @Override
    protected void appendOptions(StringBuilder sbSQL) {
        fillServer(sbSQL);

        StringBuilder sb = new StringBuilder();
        for (Entry <String, String> entry : options.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            sb.append(key);
            if (!value.isEmpty()) {
                sb.append(' ').append(value);
            }
            sb.append(", ");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nOPTIONS (").append(sb).append(")");
        }

        sbSQL.append(';');
    }

    private void fillServer(StringBuilder sbSQL) {
        sbSQL.append("\nSERVER ").append(serverName);
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append(" (\n");
        for (PgColumn column : columns) {
            sbSQL.append("\t");
            sbSQL.append(column.getFullDefinition(false, null));

            if (column.getStorage() != null){
                sbOption.append(getAlterTable(true, false))
                .append(" ALTER COLUMN ")
                .append(PgDiffUtils.getQuotedName(column.name))
                .append(" SET STORAGE ")
                .append(column.getStorage())
                .append(';');
            }

            writeOptions(column, sbOption, false);
            writeOptions(column, sbOption, true);

            writeSequences(column, sbOption);
            sbSQL.append(",\n");
        }

        if (!columns.isEmpty()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
        }

        sbSQL.append(')');
    }

    @Override
    protected void compareTableTypes(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        //no impl
    }

}