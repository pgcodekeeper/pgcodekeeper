package cz.startnet.utils.pgdiff.schema;

/**
 * Partition foreign table object
 *
 * @since 4.1.1
 * @author galiev_mr
 */
public class PartitionForeignTable extends ForeignPgTable {
    private String partitionBounds;

    public PartitionForeignTable(String name, String rawStatement,
            String serverName, String partitionBound) {
        super(name, rawStatement, serverName);
        setPartitionBounds(partitionBound);
    }

    @Override
    protected boolean isNeedRecreate(PgTable oldTable, PgTable newTable) {
        return super.isNeedRecreate(oldTable, newTable)
                || !((PartitionForeignTable)oldTable).getPartitionBounds().equals(((PartitionForeignTable)newTable).getPartitionBounds())
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
            for (PgColumn column : columns) {
                sbSQL.append("\t");
                sbSQL.append(column.getFullDefinition(false, null));
                sbSQL.append(",\n");
                writeSequences(column, sbOption);
            }
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append("\n)");
        }
        sbSQL.append('\n');
        sbSQL.append(partitionBounds);
    }

    @Override
    protected void appendInherit(StringBuilder sbSQL) {
        // partition foreign table not support INHERITS syntax, but this field fills
        // from jdbc reader
    }

    @Override
    protected void compareTableTypes(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        // untransformable
    }

    @Override
    protected PgTable getTableCopy(String name, String rawStatement) {
        return new PartitionForeignTable(name, rawStatement,
                getServerName(), getPartitionBounds());
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (this == obj) {
            eq = true;
        } else if (obj instanceof PartitionForeignTable) {
            eq = super.equals(obj);
        }
        return eq;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionForeignTable && super.compare(obj)) {
            PartitionForeignTable table = (PartitionForeignTable) obj;
            return getPartitionBounds().equals(table.getPartitionBounds());
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