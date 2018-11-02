package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsRole extends PgStatement {

    private final Set<String> members = new LinkedHashSet<>();

    public MsRole(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.ROLE;
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase) getParent();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ROLE ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        if (owner != null) {
            sbSQL.append("\nAUTHORIZATION ").append(MsDiffUtils.quoteName(owner));
        }
        sbSQL.append(GO);

        for (String member : members) {
            sbSQL.append("\nALTER ROLE ").append(MsDiffUtils.quoteName(getName()));
            sbSQL.append(" ADD MEMBER ").append(MsDiffUtils.quoteName(member));
            sbSQL.append(GO);
        }

        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        StringBuilder sb = new StringBuilder();

        for (String member : members) {
            sb.append("ALTER ROLE ").append(MsDiffUtils.quoteName(name));
            sb.append(" DROP MEMBER ").append(MsDiffUtils.quoteName(member));
            sb.append(GO).append('\n');
        }

        sb.append("DROP ROLE ").append(MsDiffUtils.quoteName(name)).append(GO);

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsRole newRole;
        if (newCondition instanceof MsRole) {
            newRole = (MsRole) newCondition;
        } else {
            return false;
        }

        if (!Objects.equals(getOwner(), newRole.getOwner())) {
            sb.append(newRole.getOwnerSQL());
        }

        if (!Objects.equals(members, newRole.members)) {
            for (String newMember : newRole.members) {
                if (!members.contains(newMember)) {
                    sb.append("\nALTER ROLE ").append(MsDiffUtils.quoteName(getName()));
                    sb.append(" ADD MEMBER ").append(MsDiffUtils.quoteName(newMember));
                    sb.append(GO);
                }
            }

            for (String oldMember : members) {
                if (!newRole.members.contains(oldMember)) {
                    sb.append("\nALTER ROLE ").append(MsDiffUtils.quoteName(getName()));
                    sb.append(" DROP MEMBER ").append(MsDiffUtils.quoteName(oldMember));
                    sb.append(GO);
                }
            }
        }

        alterPrivileges(newRole, sb);

        return sb.length() > startLength;
    }

    public void addMember(String member) {
        members.add(member);
        resetHash();
    }

    public Set<String> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(owner);
        hasher.put(members);
        hasher.putUnordered(grants);
        hasher.putUnordered(revokes);
    }

    @Override
    public MsRole shallowCopy() {
        MsRole roleDst = new MsRole(getName(), getRawStatement());
        roleDst.setOwner(getOwner());
        roleDst.members.addAll(members);
        roleDst.grants.addAll(grants);
        roleDst.revokes.addAll(revokes);
        roleDst.setLocation(getLocation());
        return roleDst;
    }

    @Override
    public MsRole deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsRole) {
            MsRole role = (MsRole) obj;
            return Objects.equals(members, role.members)
                    && Objects.equals(name, role.getName())
                    && Objects.equals(owner, role.getOwner())
                    && grants.equals(role.grants)
                    && revokes.equals(role.revokes);
        }
        return false;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }
}
