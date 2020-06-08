package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgPolicy extends PgStatementWithSearchPath {

    private PgEventType event;
    private final Set<String> roles = new LinkedHashSet<>();
    private String using;
    private String check;
    private boolean isPermissive = true;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.POLICY;
    }

    public PgEventType getEvent() {
        return event;
    }

    public void setEvent(PgEventType event) {
        this.event = event;
        resetHash();
    }

    public Set<String> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public void addRole(String role) {
        roles.add(role);
        resetHash();
    }

    public String getUsing() {
        return using;
    }

    public void setUsing(String using) {
        this.using = using;
        resetHash();
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
        resetHash();
    }

    public boolean isPermissive() {
        return isPermissive;
    }

    public void setPermissive(boolean isPermissive) {
        this.isPermissive = isPermissive;
    }

    public PgPolicy(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE POLICY ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(" ON ").append(getParent().getQualifiedName());

        if (!isPermissive()) {
            sbSQL.append("\n  AS RESTRICTIVE");
        }

        if (event != null) {
            sbSQL.append("\n  FOR ").append(event);
        }

        if (!roles.isEmpty()) {
            sbSQL.append("\n  TO ").append(String.join(", ", roles));
        }

        if (using != null && !using.isEmpty()) {
            sbSQL.append("\n  USING ").append(using);
        }

        if (check != null && !check.isEmpty()) {
            sbSQL.append("\n  WITH CHECK ").append(check);
        }
        sbSQL.append(';');

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        StringBuilder sbSQL = new StringBuilder("DROP POLICY ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(" ON ").append(getParent().getQualifiedName()).append(';');
        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgPolicy newPolice = (PgPolicy) newCondition;

        if (!compareUnalterable(newPolice)) {
            isNeedDepcies.set(true);
            return true;
        }

        Set<String> newRoles = newPolice.roles;
        String newUsing = newPolice.getUsing();
        String newCheck = newPolice.getCheck();

        if (!Objects.equals(roles, newRoles) || !Objects.equals(using, newUsing)
                || !Objects.equals(check, newCheck)) {

            sb.append("\n\nALTER POLICY ").append(PgDiffUtils.getQuotedName(getName()));
            sb.append(" ON ").append(getParent().getQualifiedName());

            if (!Objects.equals(roles, newRoles)) {
                sb.append("\n  TO ");
                if (newRoles.isEmpty()) {
                    sb.append("PUBLIC");
                } else {
                    sb.append(String.join(", ", newRoles));
                }
            }

            if (!Objects.equals(using, newUsing)) {
                sb.append("\n  USING ").append(newUsing);
            }

            if (!Objects.equals(check, newCheck)) {
                sb.append("\n  WITH CHECK ").append(newCheck);
            }
            sb.append(';');
        }

        if (!Objects.equals(getComment(), newPolice.getComment())) {
            sb.append("\n\n");
            newPolice.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    @Override
    public PgPolicy shallowCopy() {
        PgPolicy copy = new PgPolicy(getName());
        copyBaseFields(copy);
        copy.setPermissive(isPermissive());
        copy.setEvent(getEvent());
        copy.roles.addAll(roles);
        copy.setUsing(getUsing());
        copy.setCheck(getCheck());
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgPolicy && super.compare(obj)) {
            PgPolicy police = (PgPolicy) obj;
            return compareUnalterable(police)
                    && roles.equals(police.roles)
                    && Objects.equals(getUsing(), police.getUsing())
                    && Objects.equals(getCheck(), police.getCheck());
        }

        return false;
    }

    private boolean compareUnalterable(PgPolicy police) {
        // we can alter but cannot remove
        if (using != null && police.getUsing() == null) {
            return false;
        }

        if (check != null && police.getCheck() == null) {
            return false;
        }

        return event == police.event && isPermissive == police.isPermissive();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(isPermissive);
        hasher.put(event);
        hasher.put(roles);
        hasher.put(using);
        hasher.put(check);
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent().getParent();
    }
}
