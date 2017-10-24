package cz.startnet.utils.pgdiff.schema;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Base implementation of foreign table
 *
 * @since 4.1.1
 * @author galiev_mr
 *
 */
public abstract class ForeignPgTable extends PgTable {
    protected final String serverName;

    protected static final String ALTER_FOREIGN_OPTION = "{0} OPTIONS ({1} {2} {3});";

    public ForeignPgTable(String name, String rawStatement, String serverName) {
        super(name, rawStatement);
        this.serverName = serverName;
        resetHash();
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
        sb.append(PgDiffUtils.getQuotedName(getName()));
        return sb.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP FOREIGN TABLE " + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    protected boolean isNeedRecreate(PgTable oldTable, PgTable newTable) {
        return super.isNeedRecreate(newTable, oldTable) || !(newTable instanceof ForeignPgTable)
                || !Objects.equals(((ForeignPgTable)oldTable).getServerName(),
                        ((ForeignPgTable)newTable).getServerName());
    }


    @Override
    protected StringBuilder appendOwnerSQL(StringBuilder sb) {
        return owner == null ? super.appendOwnerSQL(sb)
                : sb.append("\n\nALTER FOREIGN TABLE ").append(PgDiffUtils.getQuotedName(getName()))
                .append(" OWNER TO ").append(PgDiffUtils.getQuotedName(owner)).append(';');
    }

    @Override
    public void compareOptions(PgOptionContainer oldContainer,
            PgOptionContainer newContainer, StringBuilder sb) {
        Map <String, String> oldForeignOptions = oldContainer.getOptions();
        Map <String, String> newForeignOptions = newContainer.getOptions();
        if (!oldForeignOptions.isEmpty() || !newForeignOptions.isEmpty()) {
            oldForeignOptions.forEach((key, value) -> {
                if (newForeignOptions.containsKey(key)) {
                    String newValue =  newForeignOptions.get(key);
                    if (!Objects.equals(value, newValue)) {
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
        sbSQL.append(PgDiffUtils.getQuotedName(name));
    }

    @Override
    protected void compareTableOptions(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        if (oldTable.getHasOids() && !newTable.getHasOids()) {
            sb.append(getAlterTable(true, false))
            .append(" SET WITHOUT OIDS;");
        } else if (newTable.getHasOids() && !oldTable.getHasOids()) {
            sb.append(getAlterTable(true, false))
            .append(" SET WITH OIDS;");
        }
    }

    @Override
    protected void appendAlterOptions(StringBuilder sbSQL) {
        if (hasOids) {
            sbSQL.append(getAlterTable(true, false));
            sbSQL.append(" SET WITH ").append(OIDS).append(";");
        }
    }

    public String getServerName() {
        return serverName;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (this == obj) {
            eq = true;
        } else if (obj instanceof ForeignPgTable) {
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
        if (obj instanceof ForeignPgTable && super.compare(obj)) {
            ForeignPgTable table = (ForeignPgTable) obj;
            return getServerName().equals(table.getServerName());
        }

        return false;
    }

    @Override
    public PgTable shallowCopy() {
        return super.shallowCopy();
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = super.computeHash();
        result = prime * result + ((serverName == null) ? 0 : serverName.hashCode());
        return result;
    }

}
