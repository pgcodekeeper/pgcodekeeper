package cz.startnet.utils.pgdiff.schema;

import java.util.Map.Entry;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

/**
 * Base implementation of foreign table
 *
 * @since 4.1.1
 * @author galiev_mr
 */
public abstract class AbstractForeignTable extends AbstractPgTable implements PgForeignOptionContainer {

    protected final String serverName;

    public AbstractForeignTable(String name, String serverName) {
        super(name);
        this.serverName = serverName;
    }

    @Override
    protected String getAlterTable(boolean nextLine, boolean only) {
        StringBuilder sb = new StringBuilder();
        if (nextLine) {
            sb.append("\n\n");
        }
        sb.append("ALTER FOREIGN TABLE ");
        if (only) {
            sb.append("ONLY ");
        }
        sb.append(getQualifiedName());
        return sb.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP FOREIGN TABLE " + getQualifiedName() + ';';
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        return super.isNeedRecreate(newTable)
                || !this.getClass().equals(newTable.getClass())
                || !Objects.equals(serverName, ((AbstractForeignTable)newTable).getServerName());
    }

    @Override
    protected void appendOptions(StringBuilder sbSQL) {
        sbSQL.append("\nSERVER ").append(PgDiffUtils.getQuotedName(serverName));

        StringBuilder sb = new StringBuilder();
        for (Entry <String, String> entry : options.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            sb.append(key);
            if (!value.isEmpty()) {
                sb.append(' ').append(value);
            }
            sb.append(", ");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nOPTIONS (").append(sb).append(")");
        }

        sbSQL.append(';');
    }

    @Override
    protected String getTypeName() {
        return "FOREIGN TABLE";
    }
    @Override
    public String getAlterHeader() {
        return getAlterTable(true, false);
    }

    @Override
    protected void appendName(StringBuilder sbSQL) {
        sbSQL.append("CREATE FOREIGN TABLE ").append(getQualifiedName());
    }

    @Override
    protected void appendAlterOptions(StringBuilder sbSQL) {
        if (hasOids) {
            sbSQL.append(getAlterTable(true, true));
            sbSQL.append(" SET WITH OIDS;");
        }
    }

    @Override
    protected void compareTableTypes(AbstractPgTable newTable,  StringBuilder sb) {
        // untransformable
    }

    public String getServerName() {
        return serverName;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof AbstractForeignTable && super.compare(obj)) {
            AbstractForeignTable table = (AbstractForeignTable) obj;
            return Objects.equals(serverName, table.getServerName());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(serverName);
    }
}
