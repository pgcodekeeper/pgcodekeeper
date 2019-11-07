package cz.startnet.utils.pgdiff.schema;

import java.util.Collection;
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

    public static StringBuilder appendPrivileges(Collection<PgPrivilege> privileges,
            boolean isPostgres, StringBuilder sb) {
        if (privileges.isEmpty()) {
            return sb;
        }

        sb.append('\n');
        for (PgPrivilege priv : privileges) {
            sb.append('\n').append(priv.getCreationSQL()).append(isPostgres ? ';' : "\nGO");
        }

        return sb;
    }

    public static StringBuilder appendDefaultPrivileges(PgStatement newObj, StringBuilder sb) {
        DbObjType type = newObj.getStatementType();
        String owner = newObj.getOwner();
        if (type == DbObjType.COLUMN) {
            return sb;
        }

        boolean isFunctionOrTypeOrDomain = false;
        isFunctionOrTypeOrDomain = (DbObjType.FUNCTION == type) || (DbObjType.PROCEDURE == type)
                || (DbObjType.AGGREGATE == type) || (DbObjType.TYPE == type)
                || (DbObjType.DOMAIN == type);
        if (type == DbObjType.VIEW) {
            type = DbObjType.TABLE;
        } else if (type == DbObjType.AGGREGATE) {
            // for AGGREGATEs in GRANT/REVOKE the type will be the same as in FUNCTIONs
            type = DbObjType.FUNCTION;
        }

        StringBuilder sbName = new StringBuilder()
                .append(type.name())
                .append(' ');
        if (type == DbObjType.FUNCTION || type == DbObjType.PROCEDURE) {
            AbstractPgFunction func = (AbstractPgFunction) newObj;
            sbName.append(PgDiffUtils.getQuotedName(func.getParent().getName()))
            .append('.');
            func.appendFunctionSignature(sbName, false, true);
        } else {
            sbName.append(newObj.getQualifiedName());
        }
        String name = sbName.toString();

        // FUNCTION/PROCEDURE/AGGREGATE/TYPE/DOMAIN by default has "GRANT ALL to PUBLIC".
        // That's why for them set "GRANT ALL to PUBLIC".
        PgPrivilege priv = new PgPrivilege(isFunctionOrTypeOrDomain ? "GRANT" : "REVOKE",
                "ALL", name, "PUBLIC", false);
        sb.append('\n').append(priv.getCreationSQL()).append(';');

        if (owner == null) {
            return sb;
        }
        owner = PgDiffUtils.getQuotedName(owner);

        priv = new PgPrivilege("REVOKE", "ALL", name, owner, false);
        sb.append('\n').append(priv.getCreationSQL()).append(';');

        priv = new PgPrivilege("GRANT", "ALL", name, owner, false);
        sb.append('\n').append(priv.getCreationSQL()).append(';');

        return sb;
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
