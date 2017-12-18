package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Partition regular table object
 *
 * @since 4.1.1
 * @author galiev_mr
 */
public class PartitionPgTable extends RegularPgTable {

    private String partitionBounds;

    public PartitionPgTable(String name, String rawStatement, String partitionBound) {
        super(name, rawStatement);
        setPartitionBounds(partitionBound);
    }

    public String getPartitionBounds() {
        return partitionBounds;
    }

    public void setPartitionBounds(final String partitionBounds) {
        this.partitionBounds = partitionBounds;
        resetHash();
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        final Inherits tableName = inherits.get(0);
        String parentName = (tableName.getKey() == null ? "" : (tableName.getKey() + ".")) +
                tableName.getValue();

        sbSQL.append(" PARTITION OF ").append(parentName);

        if (!columns.isEmpty()) {
            sbSQL.append(" (\n");

            int start = sbSQL.length();
            for (PgColumn column : columns) {
                writeColumn(column, sbSQL, sbOption);
            }

            if (start != sbSQL.length()) {
                sbSQL.setLength(sbSQL.length() - 2);
                sbSQL.append("\n)");
            }
        }

        sbSQL.append('\n');
        sbSQL.append(partitionBounds);
    }


    @Override
    protected void appendInherit(StringBuilder sbSQL) {
        // partition table not support default INHERITS syntax
    }

    @Override
    protected void compareTableTypes(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        if (!(newTable instanceof PartitionPgTable)) {
            final Inherits tableName = oldTable.getInherits().get(0);
            sb.append("\n\nALTER TABLE ");
            sb.append(tableName.getKey() == null ?
                    "" : PgDiffUtils.getQuotedName(tableName.getKey()) + '.')
            .append(PgDiffUtils.getQuotedName(tableName.getValue()))
            .append("\n\tDETACH PARTITION ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');

            if (newTable instanceof TypedPgTable) {
                sb.append(newTable.getAlterTable(true, false))
                .append(" OF ")
                .append(((TypedPgTable) newTable).getOfType())
                .append(';');
            }
        }
    }

    @Override
    protected void compareTableOptions(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        super.compareTableOptions(oldTable, newTable, sb);

        if (newTable instanceof PartitionPgTable) {
            PartitionPgTable oldPart = (PartitionPgTable) oldTable;
            PartitionPgTable newPart = (PartitionPgTable) newTable;

            Inherits oldInherits = oldTable.getInherits().get(0);
            Inherits newInherits = newTable.getInherits().get(0);

            if (!oldPart.getPartitionBounds().equals(newPart.getPartitionBounds())
                    || !Objects.equals(oldInherits, newInherits)) {
                sb.append("\n\nALTER TABLE ");
                sb.append(oldInherits.getKey() == null ?
                        "" : PgDiffUtils.getQuotedName(oldInherits.getKey()) + '.')
                .append(PgDiffUtils.getQuotedName(oldInherits.getValue()))
                .append("\n\tDETACH PARTITION ")
                .append(PgDiffUtils.getQuotedName(getName()))
                .append(';');

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

    @Override
    protected void compareInherits(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        //not support default syntax
    }


    @Override
    protected PgTable getTableCopy(String name, String rawStatement) {
        return new PartitionPgTable(name, rawStatement, getPartitionBounds());
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionPgTable && super.compare(obj)) {
            PartitionPgTable table = (PartitionPgTable) obj;
            return partitionBounds.equals(table.getPartitionBounds());
        }

        return false;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = super.computeHash();
        result = prime * result + ((partitionBounds == null) ? 0 : partitionBounds.hashCode());
        return result;
    }
}