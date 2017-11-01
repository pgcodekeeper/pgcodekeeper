package cz.startnet.utils.pgdiff.schema;

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
            }

            if (column.getStorage() != null){
                sbOption.append(getAlterTable(true, false))
                .append(" ALTER COLUMN ")
                .append(PgDiffUtils.getQuotedName(column.name))
                .append(" SET STORAGE ")
                .append(column.getStorage())
                .append(';');
            }

            writeOptions(column, options, false);
            writeOptions(column, options, true);

            writeSequences(column, options);
            sbSQL.append(",\n");
        }

        if (!columns.isEmpty()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
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
    protected void compareTableTypes(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        // untransformable
    }

}