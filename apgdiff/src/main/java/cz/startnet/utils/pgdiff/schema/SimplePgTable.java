package cz.startnet.utils.pgdiff.schema;

import cz.startnet.utils.pgdiff.PgDiffUtils;

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
        for (PgColumn column : columns) {
            writeColumn(column, sbSQL, sbOption);
        }

        if (start != sbSQL.length()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
        }

        sbSQL.append(')');
    }

    @Override
    protected PgTable getTableCopy(String name, String rawStatement) {
        return new SimplePgTable(name, rawStatement);
    }

    @Override
    protected void compareTableTypes(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        if (newTable instanceof TypedPgTable) {
            String newType  = ((TypedPgTable)newTable).getOfType();
            sb.append(getAlterTable(true, false))
            .append(" OF ")
            .append(newType)
            .append(';');
        } else if (newTable instanceof PartitionPgTable) {
            Inherits newInherits = newTable.getInherits().get(0);
            sb.append("\n\nALTER TABLE ");
            sb.append(newInherits.getKey() == null ?
                    "" : PgDiffUtils.getQuotedName(newInherits.getKey()) + '.')
            .append(PgDiffUtils.getQuotedName(newInherits.getValue()))
            .append("\n\tATTACH PARTITION ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(' ')
            .append(((PartitionPgTable)newTable).getPartitionBounds())
            .append(';');
        }
    }
}
