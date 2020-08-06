package cz.startnet.utils.pgdiff.schema;

/**
 * Simple foreign table object
 *
 * @since 4.1.1
 * @author galiev_mr
 *
 */
public class SimpleForeignPgTable extends AbstractForeignTable {

    public SimpleForeignPgTable(String name, String serverName) {
        super(name, serverName);
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new SimpleForeignPgTable(name, serverName);
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append(" (\n");

        int start = sbSQL.length();
        for (AbstractColumn column : columns) {
            writeColumn((PgColumn) column, sbSQL, sbOption);
        }

        if (start != sbSQL.length()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
        }

        sbSQL.append(')');
    }

}