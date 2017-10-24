package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;

/**
 * Typed table object
 *
 * @since 4.1.1
 * @author galiev_mr
 *
 */
public class TypedPgTable extends RegularPgTable {

    protected String ofType;

    public TypedPgTable(String name, String rawStatement, String ofType) {
        super(name, rawStatement);
        setOfType(ofType);
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append(" OF ").append(ofType);

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
    }


    public String getOfType() {
        return ofType;
    }

    public void setOfType(String ofType) {
        this.ofType = ofType;
        resetHash();
    }

    @Override
    protected boolean isNeedRecreate(PgTable newTable, PgTable oldTable) {
        if (super.isNeedRecreate(newTable, oldTable)) {
            return true;
        }

        return !Objects.equals(newTable.getClass(), oldTable.getClass())
                || !Objects.equals(((TypedPgTable)newTable).getType(),
                        ((TypedPgTable) oldTable).getType());
    }

    @Override
    protected void compareTableTypes(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        if (newTable instanceof TypedPgTable) {
            String oldType  = ((TypedPgTable)oldTable).getOfType();
            String newType  = ((TypedPgTable)newTable).getOfType();
            if (!Objects.equals(oldType, newType)) {
                sb.append(getAlterTable(true, false))
                .append(" OF ")
                .append(newType)
                .append(';');
            }
        } else {
            sb.append(getAlterTable(true, false))
            .append(" NOT OF")
            .append(';');

            if (newTable instanceof PartitionPgTable) {
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

    @Override
    protected PgTable getTableCopy(String name, String rawStatement) {
        return new TypedPgTable(name, rawStatement, getOfType());
    }

    public PgType getType() {
        QNameParser parser = new QNameParser(ofType);
        PgSchema schema = getContainingSchema();
        String schemaName = parser.getSchemaName(schema.getName());
        String typeName = parser.getFirstName();

        PgSchema schemaType = ((PgDatabase) schema.getParent()).getSchema(schemaName);
        if (schemaType != null) {
            return schemaType.getType(typeName);
        }

        return null;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (this == obj) {
            eq = true;
        } else if (obj instanceof TypedPgTable) {
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
        if (obj instanceof TypedPgTable && super.compare(obj)) {
            TypedPgTable table = (TypedPgTable) obj;
            return Objects.equals(ofType, table.getOfType());
        }

        return false;
    }

    @Override
    public PgTable shallowCopy() {
        TypedPgTable copy = (TypedPgTable) super.shallowCopy();
        copy.setOfType(getOfType());
        return copy;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = super.computeHash();
        result = prime * result + ((ofType == null) ? 0 : ofType.hashCode());
        return result;
    }
}
