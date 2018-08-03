package cz.startnet.utils.pgdiff.schema;

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
    protected PgTable getTableCopy() {
        return new SimpleForeignPgTable(name, getRawStatement(), serverName);
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append(" (\n");

        int start = sbSQL.length();
        for (AbstractColumn column : columns) {
            writeColumn(column, sbSQL, sbOption);
        }

        if (start != sbSQL.length()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
        }

        sbSQL.append(')');
    }
}