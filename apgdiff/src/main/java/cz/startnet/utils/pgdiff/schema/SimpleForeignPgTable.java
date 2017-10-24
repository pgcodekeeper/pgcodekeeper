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
        // untransformable
    }

}