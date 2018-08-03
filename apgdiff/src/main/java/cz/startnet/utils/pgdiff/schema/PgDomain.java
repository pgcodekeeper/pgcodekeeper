package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgDomain extends PgStatementWithSearchPath {

    private String dataType;
    private String collation;
    private String defaultValue;
    private boolean notNull;
    private final List<AbstractConstraint> constraints = new ArrayList<>();

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
        resetHash();
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
        resetHash();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
        resetHash();
    }

    public List<AbstractConstraint> getConstraints() {
        return Collections.unmodifiableList(constraints);
    }

    public AbstractConstraint getConstraint(String name) {
        for (AbstractConstraint c : constraints) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public void addConstraint(AbstractConstraint constraint) {
        assertUnique(this::getConstraint, constraint);
        constraints.add(constraint);
        constraint.setParent(this);
        resetHash();
    }

    public PgDomain(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.DOMAIN;
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE DOMAIN ").append(PgDiffUtils.getQuotedName(getContainingSchema().getName()))
        .append('.').append(PgDiffUtils.getQuotedName(getName()))
        .append(" AS ").append(dataType);
        if (collation != null && !collation.isEmpty()) {
            sb.append(" COLLATE ").append(collation);
        }
        if (notNull) {
            sb.append(" NOT NULL");
        }
        if (defaultValue != null && !defaultValue.isEmpty()) {
            sb.append(" DEFAULT ").append(defaultValue);
        }

        List<AbstractConstraint> notValids = new ArrayList<>();
        for (AbstractConstraint constr : constraints) {
            if (constr.isNotValid()) {
                notValids.add(constr);
            } else {
                sb.append("\n\tCONSTRAINT ").append(PgDiffUtils.getQuotedName(constr.getName()))
                .append(' ').append(constr.getDefinition());
            }
        }
        sb.append(';');

        for (AbstractConstraint notValid : notValids) {
            sb.append("\n\n").append(notValid.getCreationSQL());
        }

        appendOwnerSQL(sb);
        appendPrivileges(sb);

        if (comment != null && !comment.isEmpty()) {
            sb.append("\n\n");
            appendCommentSql(sb);
        }
        for (AbstractConstraint c : constraints) {
            if (c.getComment() != null && !c.getComment().isEmpty()) {
                sb.append("\n\n");
                c.appendCommentSql(sb);
            }
        }

        return sb.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP DOMAIN " + PgDiffUtils.getQuotedName(getContainingSchema().getName()) + '.'
                + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgDomain newDomain, oldDomain = this;
        if (newCondition instanceof PgDomain) {
            newDomain = (PgDomain) newCondition;
        } else {
            return false;
        }

        if (!Objects.equals(newDomain.getDataType(), oldDomain.getDataType()) ||
                !Objects.equals(newDomain.getCollation(), oldDomain.getCollation())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(newDomain.getDefaultValue(), oldDomain.getDefaultValue())) {
            sb.append("\n\nALTER DOMAIN ").append(PgDiffUtils.getQuotedName(getContainingSchema().getName()))
            .append('.').append(PgDiffUtils.getQuotedName(newDomain.getName()));
            if (newDomain.getDefaultValue() == null) {
                sb.append("\n\tDROP DEFAULT");
            } else {
                sb.append("\n\tSET DEFAULT ").append(newDomain.getDefaultValue());
            }
            sb.append(';');
        }

        if (newDomain.isNotNull() != oldDomain.isNotNull()) {
            sb.append("\n\nALTER DOMAIN ").append(PgDiffUtils.getQuotedName(getContainingSchema().getName()))
            .append('.').append(PgDiffUtils.getQuotedName(newDomain.getName()));
            if (newDomain.isNotNull()) {
                sb.append("\n\tSET NOT NULL");
            } else {
                sb.append("\n\tDROP NOT NULL");
            }
            sb.append(';');
        }

        AtomicBoolean needDepcyConstr = new AtomicBoolean();
        for (AbstractConstraint oldConstr : oldDomain.getConstraints()) {
            AbstractConstraint newConstr = newDomain.getConstraint(oldConstr.getName());
            if (newConstr == null) {
                sb.append("\n\n").append(oldConstr.getDropSQL());
            } else {
                oldConstr.appendAlterSQL(newConstr, sb, needDepcyConstr);
            }
        }
        for (AbstractConstraint newConstr : newDomain.getConstraints()) {
            if (oldDomain.getConstraint(newConstr.getName()) == null) {
                sb.append("\n\n").append(newConstr.getCreationSQL());
            }
        }

        if (!Objects.equals(oldDomain.getOwner(), newDomain.getOwner())) {
            newDomain.appendOwnerSQL(sb);
        }
        alterPrivileges(newDomain, sb);
        if (!Objects.equals(oldDomain.getComment(), newDomain.getComment())) {
            sb.append("\n\n");
            newDomain.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    @Override
    public PgDomain shallowCopy() {
        PgDomain copy = new PgDomain(getName(), getRawStatement());
        copy.setDataType(getDataType());
        copy.setCollation(getCollation());
        copy.setDefaultValue(getDefaultValue());
        copy.setNotNull(isNotNull());
        copy.setOwner(getOwner());
        copy.setComment(getComment());
        for (AbstractConstraint constr : constraints) {
            copy.addConstraint(constr.deepCopy());
        }
        for (PgPrivilege priv : grants) {
            copy.addPrivilege(priv);
        }
        for (PgPrivilege priv : revokes) {
            copy.addPrivilege(priv);
        }
        copy.deps.addAll(deps);
        return copy;
    }

    @Override
    public PgDomain deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PgDomain)) {
            return false;
        }
        PgDomain dom = (PgDomain) obj;
        return Objects.equals(name, dom.getName())
                && Objects.equals(dataType, dom.getDataType())
                && Objects.equals(collation, dom.getCollation())
                && Objects.equals(defaultValue, dom.getDefaultValue())
                && notNull == dom.isNotNull()
                && PgDiffUtils.setlikeEquals(constraints, dom.constraints)
                && Objects.equals(owner, dom.getOwner())
                && grants.equals(dom.grants)
                && revokes.equals(dom.revokes)
                && Objects.equals(comment, dom.getComment());
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(dataType);
        hasher.put(collation);
        hasher.put(defaultValue);
        hasher.put(notNull);
        hasher.putUnordered(constraints);
        hasher.put(owner);
        hasher.putOrdered(grants);
        hasher.putOrdered(revokes);
        hasher.put(comment);
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent();
    }
}
