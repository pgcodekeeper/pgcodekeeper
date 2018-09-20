package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsUser extends PgStatement {

    // TODO PASSWORD, DEFAULT_LANGUAGE, ALLOW_ENCRYPTED_VALUE_MODIFICATIONS
    private String schema;

    public MsUser(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.USER;
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase) getParent();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE USER ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        if (owner != null) {
            sbSQL.append(" FOR LOGIN ").append(MsDiffUtils.quoteName(owner));
        }
        if (schema != null) {
            sbSQL.append(" WITH DEFAULT_SCHEMA=").append(MsDiffUtils.quoteName(schema));
        }

        sbSQL.append(GO);

        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP USER " + MsDiffUtils.quoteName(name) + GO;
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsUser newUser;
        if (newCondition instanceof MsUser) {
            newUser = (MsUser) newCondition;
        } else {
            return false;
        }

        StringBuilder sbSql = new StringBuilder();

        if (!Objects.equals(getOwner(), newUser.getOwner())) {
            sbSql.append("LOGIN = ").append(MsDiffUtils.quoteName(newUser.getOwner())).append(", ");
        }

        String newSchema = newUser.getSchema();
        if (!Objects.equals(getSchema(), newSchema)) {
            sbSql.append("DEFAULT_SCHEMA = ").append(MsDiffUtils.quoteName(newSchema)).append(", ");
        }

        if (sbSql.length() > 0) {
            sbSql.setLength(sbSql.length() - 2);
            sb.append("ALTER USER ").append(MsDiffUtils.quoteName(name))
            .append(" WITH ").append(sbSql).append(GO);
        }

        alterPrivileges(newUser, sb);

        return sb.length() > startLength;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
        resetHash();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(owner);
        hasher.put(schema);
        hasher.putOrdered(grants);
        hasher.putOrdered(revokes);
    }

    @Override
    public MsUser shallowCopy() {
        MsUser userDst = new MsUser(getName(), getRawStatement());
        userDst.setOwner(getOwner());
        userDst.setSchema(getSchema());
        for (PgPrivilege priv : revokes) {
            userDst.addPrivilege(priv);
        }
        for (PgPrivilege priv : grants) {
            userDst.addPrivilege(priv);
        }
        userDst.setLocation(getLocation());
        return userDst;
    }

    @Override
    public MsUser deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsUser) {
            MsUser user = (MsUser) obj;
            return Objects.equals(schema, user.getSchema())
                    && Objects.equals(name, user.getName())
                    && Objects.equals(owner, user.getOwner())
                    && grants.equals(user.grants)
                    && revokes.equals(user.revokes);
        }
        return false;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
