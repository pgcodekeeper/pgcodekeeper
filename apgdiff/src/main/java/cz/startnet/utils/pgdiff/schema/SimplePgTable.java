package cz.startnet.utils.pgdiff.schema;

/**
 * Simple table object
 *
 * @since 4.1.1
 * @author galiev_mr
 *
 */
public class SimplePgTable extends RegularPgTable {

    public SimplePgTable(String name, String rawStatement) {
        super(name, rawStatement);
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

    @Override
    protected PgTable getTableCopy() {
        return new SimplePgTable(name, getRawStatement());
    }

    @Override
    protected void compareTableTypes(PgTable newTable, StringBuilder sb) {
        if (newTable instanceof RegularPgTable) {
            ((RegularPgTable)newTable).convertTable(sb);
        }
    }

    @Override
    protected void convertTable(StringBuilder sb) {
        // no implements
    }
}