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
        StringBuilder inherits = new StringBuilder();
        StringBuilder options = new StringBuilder();

        int start = sbSQL.length();
        for (PgColumn column : columns) {
            if (column.isInherit()) {
                searchColumn(column, inherits);
            } else {
                sbSQL.append("\t");
                sbSQL.append(column.getFullDefinition(false, null));
                sbSQL.append(",\n");
            }

            if (column.getStorage() != null) {
                sbOption.append(getAlterTable(true, false))
                .append(" ALTER COLUMN ")
                .append(PgDiffUtils.getQuotedName(column.name))
                .append(" SET STORAGE ")
                .append(column.getStorage())
                .append(';');
            }

            writeOptions(column, options, false);
            writeSequences(column, options);
        }

        if (start != sbSQL.length()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
        }

        // saving order
        sbOption.append(inherits);
        sbOption.append(options);

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
