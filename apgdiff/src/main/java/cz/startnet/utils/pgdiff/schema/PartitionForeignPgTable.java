package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

/**
 * Partition foreign table object
 *
 * @since 4.1.1
 * @author galiev_mr
 */
public class PartitionForeignPgTable extends ForeignPgTable {
    private final String partitionBounds;

    public PartitionForeignPgTable(String name, String rawStatement,
            String serverName, String partitionBounds) {
        super(name, rawStatement, serverName);
        this.partitionBounds = partitionBounds;
    }

    @Override
    protected boolean isNeedRecreate(PgTable newTable) {
        return super.isNeedRecreate(newTable)
                || !(Objects.equals(partitionBounds, ((PartitionForeignPgTable)newTable).partitionBounds))
                || !inherits.equals(newTable.inherits);
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
    protected PgTable getTableCopy() {
        return new PartitionForeignPgTable(name, getRawStatement(), serverName,
                partitionBounds);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionForeignPgTable && super.compare(obj)) {
            PartitionForeignPgTable table = (PartitionForeignPgTable) obj;
            return Objects.equals(partitionBounds, table.partitionBounds);
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