package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.hashers.IHashable;
import cz.startnet.utils.pgdiff.hashers.JavaHasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgPrivilege implements IHashable {

    public static final String WITH_GRANT_OPTION = " WITH GRANT OPTION";

    private final String state;
    private final String permission;
    private final String role;
    private final String name;
    private final boolean isGrantOption;

    public boolean isRevoke() {
        return "REVOKE".equalsIgnoreCase(getState());
    }

    public PgPrivilege(String state, String permission, String name, String role, boolean isGrantOption) {
        this.state = state;
        this.permission = permission;
        this.name = name;
        this.role = role;
        this.isGrantOption = isGrantOption;
    }

    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append(state).append(' ').append(permission);
        if (name != null) {
            sb.append(" ON ").append(getName());
        }

        sb.append(isRevoke() ? " FROM ": " TO ").append(getRole());

        if (isGrantOption) {
            sb.append(isRevoke() ? " CASCADE" : WITH_GRANT_OPTION);
        }

        return sb.toString();
    }

    public String getDropSQL() {
        if (isRevoke()) {
            return null;
        }

        return new PgPrivilege("REVOKE", permission, name, role, isGrantOption).getCreationSQL();
    }

    public static void appendDefaultPrivileges(PgStatement newObj, StringBuilder sb) {
        DbObjType type = newObj.getStatementType();
        String owner = type != DbObjType.COLUMN ? newObj.getOwner() : newObj.getParent().getOwner();
        if (owner == null) {
            return;
        }

        String name = newObj.getName();
        String column = "";

        if (type == DbObjType.COLUMN) {
            column = '(' + PgDiffUtils.getQuotedName(name) + ')';
            name = PgDiffUtils.getQuotedName(newObj.getParent().getParent().getName())
                    + '.' + PgDiffUtils.getQuotedName(newObj.getParent().getName());
            type = DbObjType.TABLE;
        } else if (type == DbObjType.SCHEMA) {
            name = PgDiffUtils.getQuotedName(name);
        } else {
            name = PgDiffUtils.getQuotedName(newObj.getParent().getName()) + '.' + name;
        }

        owner =  PgDiffUtils.getQuotedName(owner);

        PgPrivilege priv = new PgPrivilege("REVOKE", "ALL" + column, type + " " + name, "PUBLIC", false);
        sb.append('\n').append(priv.getCreationSQL()).append(';');
        priv = new PgPrivilege("REVOKE", "ALL" + column, type + " " + name, owner, false);
        sb.append('\n').append(priv.getCreationSQL()).append(';');
        priv = new PgPrivilege("GRANT", "ALL" + column, type + " " + name, owner, false);
        sb.append('\n').append(priv.getCreationSQL()).append(';');
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgPrivilege) {
            PgPrivilege priv = (PgPrivilege) obj;
            eq = isGrantOption == priv.isGrantOption()
                    && Objects.equals(state, priv.getState())
                    && Objects.equals(permission, priv.getPermission())
                    && Objects.equals(role, priv.getRole())
                    && Objects.equals(name, priv.getName());
        }

        return eq;
    }

    @Override
    public int hashCode() {
        JavaHasher hasher = new JavaHasher();
        computeHash(hasher);
        return hasher.getResult();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(state);
        hasher.put(permission);
        hasher.put(role);
        hasher.put(name);
        hasher.put(isGrantOption);
    }

    @Override
    public String toString() {
        return getCreationSQL();
    }

    public String getState() {
        return state;
    }

    public String getPermission() {
        return permission;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public boolean isGrantOption() {
        return isGrantOption;
    }
}
