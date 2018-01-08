package cz.startnet.utils.pgdiff.schema;

/**
 * Partition foreign table object
 *
 * @since 4.1.1
 * @author galiev_mr
 */
public class PartitionForeignPgTable extends ForeignPgTable {
    private String partitionBounds;

    public PartitionForeignPgTable(String name, String rawStatement,
            String serverName, String partitionBound) {
        super(name, rawStatement, serverName);
        setPartitionBounds(partitionBound);
    }

    @Override
    protected boolean isNeedRecreate(PgTable oldTable, PgTable newTable) {
        return super.isNeedRecreate(oldTable, newTable)
                || !((PartitionForeignPgTable)oldTable).getPartitionBounds().equals(((PartitionForeignPgTable)newTable).getPartitionBounds())
                || !oldTable.getInherits().equals(newTable.getInherits());
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
        // PgTable.inherits stores PARTITION OF table in this implementation
    }

    @Override
    protected void compareTableTypes(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        // untransformable
    }

    @Override
    protected PgTable getTableCopy(String name, String rawStatement) {
        return new PartitionForeignPgTable(name, rawStatement,
                getServerName(), getPartitionBounds());
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionForeignPgTable && super.compare(obj)) {
            PartitionForeignPgTable table = (PartitionForeignPgTable) obj;
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