package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

/**
 * Partition regular table object
 *
 * @since 4.1.1
 * @author galiev_mr
 */
public class PartitionPgTable extends RegularPgTable {

    private final String partitionBounds;

    public PartitionPgTable(String name, String rawStatement, String partitionBounds) {
        super(name, rawStatement);
        this.partitionBounds = partitionBounds;
    }

    public String getPartitionBounds() {
        return partitionBounds;
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append(" PARTITION OF ").append(inherits.get(0).getQualifiedName());

        if (!columns.isEmpty()) {
            sbSQL.append(" (\n");

            int start = sbSQL.length();
            for (AbstractColumn column : columns) {
                writeColumn(column, sbSQL, sbOption);
            }

            if (start != sbSQL.length()) {
                sbSQL.setLength(sbSQL.length() - 2);
                sbSQL.append("\n)");
            } else {
                sbSQL.setLength(sbSQL.length() - 3);
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
    protected void compareTableTypes(PgTable newTable, StringBuilder sb) {
        if (!(newTable instanceof PartitionPgTable)) {
            final Inherits tableName = inherits.get(0);
            sb.append("\n\nALTER TABLE ");
            sb.append(tableName.getQualifiedName())
            .append("\n\tDETACH PARTITION ")
            .append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append('.')
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');

            if (newTable instanceof RegularPgTable) {
                ((RegularPgTable)newTable).convertTable(sb);
            }
        }
    }

    @Override
    protected void convertTable(StringBuilder sb) {
        Inherits newInherits = getInherits().get(0);
        sb.append("\n\nALTER TABLE ");
        sb.append(newInherits.getQualifiedName())
        .append("\n\tATTACH PARTITION ")
        .append(PgDiffUtils.getQuotedName(getParent().getName()))
        .append('.')
        .append(PgDiffUtils.getQuotedName(getName()))
        .append(' ').append(getPartitionBounds()).append(';');
    }

    @Override
    protected void compareTableOptions(PgTable newTable, StringBuilder sb) {
        super.compareTableOptions(newTable, sb);

        if (newTable instanceof PartitionPgTable) {
            String newBounds = ((PartitionPgTable) newTable).getPartitionBounds();

            Inherits oldInherits = inherits.get(0);
            Inherits newInherits = newTable.getInherits().get(0);

            if (!Objects.equals(partitionBounds, newBounds)
                    || !Objects.equals(oldInherits, newInherits)) {
                sb.append("\n\nALTER TABLE ");
                sb.append(oldInherits.getQualifiedName())
                .append("\n\tDETACH PARTITION ")
                .append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append('.')
                .append(PgDiffUtils.getQuotedName(getName()))
                .append(';');

                sb.append("\n\nALTER TABLE ");
                sb.append(newInherits.getQualifiedName())
                .append("\n\tATTACH PARTITION ")
                .append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append('.')
                .append(PgDiffUtils.getQuotedName(getName()))
                .append(' ')
                .append(((PartitionPgTable)newTable).getPartitionBounds())
                .append(';');
            }
        }
    }

    @Override
    protected void compareInherits(PgTable newTable, StringBuilder sb) {
        //not support default syntax
    }

    @Override
    protected PgTable getTableCopy() {
        return new PartitionPgTable(name, getRawStatement(), partitionBounds);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionPgTable && super.compare(obj)) {
            PartitionPgTable table = (PartitionPgTable) obj;
            return Objects.equals(partitionBounds, table.partitionBounds);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(partitionBounds);
    }
}