package cz.startnet.utils.pgdiff.schema;

import java.util.Map.Entry;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Base implementation of regular table
 *
 * @since 4.1.1
 * @author galiev_mr
 *
 */

public abstract class RegularPgTable extends PgTable {

    protected boolean isLogged = true;
    protected String tablespace;
    protected boolean isRowSecurity;
    protected boolean isForceSecurity;

    public RegularPgTable(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    protected void appendName(StringBuilder sbSQL) {
        sbSQL.append("CREATE ");
        if (!isLogged()) {
            sbSQL.append("UNLOGGED ");
        }
        sbSQL.append("TABLE ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));
    }

    @Override
    protected String getAlterTable(boolean nextLine, boolean only) {
        StringBuilder sb = new StringBuilder();
        if (nextLine) {
            sb.append("\n\n");
        }
        sb.append("ALTER TABLE ");
        if (only) {
            sb.append("ONLY ");
        }
        sb.append(PgDiffUtils.getQuotedName(getName()));
        return sb.toString();
    }

    @Override
    protected void appendOptions(StringBuilder sbSQL) {
        StringBuilder sb = new StringBuilder();

        for (Entry <String, String> entry : options.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            sb.append(key);
            if (!value.isEmpty()) {
                sb.append('=').append(value);
            }
            sb.append(", ");
        }

        if (hasOids) {
            sb.append(OIDS).append('=').append(hasOids).append(", ");
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(")");
        }

        fillTablespace(sbSQL);
        sbSQL.append(';');
    }

    @Override
    protected void appendAlterOptions(StringBuilder sbSQL) {
        // since 9.5 PostgreSQL
        if (isRowSecurity) {
            sbSQL.append(getAlterTable(true, false));
            sbSQL.append(" ENABLE ROW LEVEL SECURITY;");
        }

        // since 9.5 PostgreSQL
        if (isForceSecurity) {
            sbSQL.append(getAlterTable(true, true));
            sbSQL.append(" FORCE ROW LEVEL SECURITY;");
        }
    }

    @Override
    protected void compareTableOptions(PgTable oldTable, PgTable newTable, StringBuilder sb) {
        RegularPgTable oldRegTable = (RegularPgTable) oldTable;
        RegularPgTable newRegTable = (RegularPgTable) newTable;

        if (oldRegTable.getHasOids() && !newRegTable.getHasOids()) {
            sb.append(getAlterTable(true, false))
            .append(" SET WITHOUT OIDS;");
        } else if (newRegTable.getHasOids() && !oldRegTable.getHasOids()) {
            sb.append(getAlterTable(true, false))
            .append(" SET WITH OIDS;");
        }

        if (!Objects.equals(oldRegTable.getTablespace(), newRegTable.getTablespace())) {
            sb.append(getAlterTable(true, false))
            .append("\n\tSET TABLESPACE ")
            .append(newRegTable.getTablespace())
            .append(';');
        }

        // since 9.5 PostgreSQL
        if (oldRegTable.isLogged != newRegTable.isLogged) {
            sb.append(getAlterTable(true, false))
            .append("\n\tSET ")
            .append(newRegTable.isLogged ? "LOGGED" : "UNLOGGED")
            .append(';');
        }

        // since 9.5 PostgreSQL
        if (oldRegTable.isRowSecurity != newRegTable.isRowSecurity) {
            sb.append(getAlterTable(true, false))
            .append(newRegTable.isRowSecurity ? " ENABLE" : " DISABLE")
            .append(" ROW LEVEL SECURITY;");
        }

        // since 9.5 PostgreSQL
        if (oldRegTable.isForceSecurity != newRegTable.isForceSecurity) {
            sb.append(getAlterTable(true, true))
            .append(newRegTable.isForceSecurity ? "" : " NO")
            .append(" FORCE ROW LEVEL SECURITY;");
        }
    }

    @Override
    protected boolean isNeedRecreate(PgTable oldTable, PgTable newTable) {
        return super.isNeedRecreate(newTable, oldTable) || !(newTable instanceof RegularPgTable);
    }

    protected void fillTablespace(StringBuilder sbSQL) {
        if (tablespace != null && !tablespace.isEmpty()) {
            sbSQL.append("\nTABLESPACE ");
            sbSQL.append(tablespace);
        }
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
        resetHash();
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(final String tablespace) {
        this.tablespace = tablespace;
        resetHash();
    }

    public boolean isRowSecurity() {
        return isRowSecurity;
    }

    public void setRowSecurity(final boolean isRowSecurity) {
        this.isRowSecurity = isRowSecurity;
        resetHash();
    }

    public boolean isForceSecurity() {
        return isForceSecurity;
    }

    public void setForceSecurity(final boolean isForceSecurity) {
        this.isForceSecurity = isForceSecurity;
        resetHash();
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (this == obj) {
            eq = true;
        } else if (obj instanceof RegularPgTable) {
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
        if (obj instanceof RegularPgTable && super.compare(obj)) {
            RegularPgTable table = (RegularPgTable) obj;
            return Objects.equals(tablespace, table.getTablespace())
                    && isLogged == table.isLogged()
                    && isRowSecurity == table.isRowSecurity()
                    && isForceSecurity == table.isForceSecurity();
        }

        return false;
    }

    @Override
    public PgTable shallowCopy() {
        RegularPgTable copy = (RegularPgTable) super.shallowCopy();
        copy.setLogged(isLogged());
        copy.setTablespace(getTablespace());
        copy.setRowSecurity(isRowSecurity());
        copy.setForceSecurity(isForceSecurity());
        return copy;
    }

    @Override
    public int computeHash() {
        final int itrue = 1231;
        final int ifalse = 1237;
        final int prime = 31;
        int result = super.computeHash();
        result = prime * result + (isLogged ? itrue : ifalse);
        result = prime * result + ((tablespace == null) ? 0 : tablespace.hashCode());
        result = prime * result + (isRowSecurity ? itrue : ifalse);
        result = prime * result + (isForceSecurity ? itrue : ifalse);
        return result;
    }
}
