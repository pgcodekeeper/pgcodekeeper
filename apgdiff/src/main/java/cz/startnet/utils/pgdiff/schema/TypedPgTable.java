package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

/**
 * Typed table object
 *
 * @since 4.1.1
 * @author galiev_mr
 *
 */
public class TypedPgTable extends RegularPgTable {

    private final String ofType;

    public TypedPgTable(String name, String rawStatement, String ofType) {
        super(name, rawStatement);
        this.ofType = ofType;
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append(" OF ").append(ofType);

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
    }

    public String getOfType() {
        return ofType;
    }

    @Override
    protected void compareTableTypes(PgTable newTable, StringBuilder sb) {
        if (newTable instanceof TypedPgTable) {
            String newType  = ((TypedPgTable)newTable).getOfType();
            if (!Objects.equals(ofType, newType)) {
                sb.append(getAlterTable(true, false))
                .append(" OF ")
                .append(newType)
                .append(';');
            }
        } else {
            sb.append(getAlterTable(true, false))
            .append(" NOT OF")
            .append(';');

            if (newTable instanceof RegularPgTable) {
                ((RegularPgTable)newTable).convertTable(sb);
            }
        }
    }

    @Override
    protected PgTable getTableCopy() {
        return new TypedPgTable(name, getRawStatement(), getOfType());
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof TypedPgTable && super.compare(obj)) {
            TypedPgTable table = (TypedPgTable) obj;
            return Objects.equals(ofType, table.getOfType());
        }

        return false;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = super.computeHash();
        result = prime * result + ((ofType == null) ? 0 : ofType.hashCode());
        return result;
    }

    @Override
    protected void convertTable(StringBuilder sb) {
        sb.append(getAlterTable(true, false))
        .append(" OF ").append(getOfType()).append(';');
    }
}
