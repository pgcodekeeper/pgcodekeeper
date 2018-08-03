package cz.startnet.utils.pgdiff.schema;

import java.text.MessageFormat;
import java.util.Map;
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
public abstract class ForeignPgTable extends PgTable {

    protected final String serverName;

    protected static final String ALTER_FOREIGN_OPTION = "{0} OPTIONS ({1} {2} {3});";

    public ForeignPgTable(String name, String rawStatement, String serverName) {
        super(name, rawStatement);
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
        sb.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        sb.append(PgDiffUtils.getQuotedName(getName()));
        return sb.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP FOREIGN TABLE " + PgDiffUtils.getQuotedName(getContainingSchema().getName()) + '.'
                + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    protected boolean isNeedRecreate(PgTable newTable) {
        return !this.getClass().equals(newTable.getClass())
                || !Objects.equals(serverName, ((ForeignPgTable)newTable).getServerName());
    }

    @Override
    protected StringBuilder appendOwnerSQL(StringBuilder sb) {
        return owner == null ? super.appendOwnerSQL(sb)
                : sb.append("\n\nALTER FOREIGN TABLE ").append(PgDiffUtils.getQuotedName(getContainingSchema().getName()))
                .append('.').append(PgDiffUtils.getQuotedName(getName()))
                .append(" OWNER TO ").append(PgDiffUtils.getQuotedName(owner)).append(';');
    }

    @Override
    protected void appendOptions(StringBuilder sbSQL) {
        sbSQL.append("\nSERVER ").append(serverName);

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
    public void compareOptions(PgOptionContainer newContainer, StringBuilder sb) {
        Map <String, String> oldForeignOptions = getOptions();
        Map <String, String> newForeignOptions = newContainer.getOptions();
        if (!oldForeignOptions.isEmpty() || !newForeignOptions.isEmpty()) {
            oldForeignOptions.forEach((key, value) -> {
                String newValue = newForeignOptions.get(key);
                if (newValue != null) {
                    if (!value.equals(newValue)) {
                        sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                                getAlterTable(true, false), "SET", key, newValue));
                    }
                } else {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterTable(true, false), "DROP", key, ""));
                }
            });

            newForeignOptions.forEach((key, value) -> {
                if (!oldForeignOptions.containsKey(key)) {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterTable(true, false), "ADD", key, value));
                }
            });
        }
    }

    @Override
    protected void appendName(StringBuilder sbSQL) {
        sbSQL.append("CREATE FOREIGN TABLE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        sbSQL.append(PgDiffUtils.getQuotedName(name));
    }

    @Override
    protected void appendAlterOptions(StringBuilder sbSQL) {
        if (hasOids) {
            sbSQL.append(getAlterTable(true, true));
            sbSQL.append(" SET WITH OIDS;");
        }
    }

    @Override
    protected void compareTableTypes(PgTable newTable,  StringBuilder sb) {
        // untransformable
    }

    public String getServerName() {
        return serverName;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof ForeignPgTable && super.compare(obj)) {
            ForeignPgTable table = (ForeignPgTable) obj;
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
