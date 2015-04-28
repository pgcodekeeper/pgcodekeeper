package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import cz.startnet.utils.pgdiff.PgDiffDomains;
import cz.startnet.utils.pgdiff.PgDiffUtils;

public class PgDomain extends PgStatementWithSearchPath {

    private String dataType;
    private String collation;
    private String defaultValue;
    private boolean notNull;
    private final List<PgConstraint> constraints = new ArrayList<>();
    private final List<PgConstraint> constrsNotValid = new ArrayList<>();

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
    
    public List<PgConstraint> getConstraints() {
        return Collections.unmodifiableList(constraints);
    }
    
    public PgConstraint getConstraint(String name) {
        for (PgConstraint c : constraints) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
    
    public void addConstraint(PgConstraint constraint) {
        constraints.add(constraint);
        constraint.setParent(this);
        resetHash();
    }
    
    public List<PgConstraint> getConstrsNotValid() {
        return Collections.unmodifiableList(constrsNotValid);
    }

    public PgConstraint getConstraintNotValid(String name) {
        for (PgConstraint c : constrsNotValid) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
    
    public void addConstrNotValid(PgConstraint constraint) {
        constrsNotValid.add(constraint);
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
        sb.append("CREATE DOMAIN ").append(PgDiffUtils.getQuotedName(getName()))
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
        for (PgConstraint constr : constraints) {
            sb.append("\n\tCONSTRAINT ").append(PgDiffUtils.getQuotedName(constr.getName()))
                    .append(' ').append(constr.getDefinition());
        }
        sb.append(';');
        
        for (PgConstraint constr : constrsNotValid) {
            sb.append("\n\nALTER DOMAIN ").append(PgDiffUtils.getQuotedName(getName()))
                    .append("\n\tADD CONSTRAINT ").append(PgDiffUtils.getQuotedName(constr.getName()))
                    .append(' ').append(constr.getDefinition()).append(';');
        }
        
        appendOwnerSQL(sb);
        appendPrivileges(sb);
        
        if (comment != null && !comment.isEmpty()) {
            sb.append("\n\n");
            appendCommentSql(sb);
        }
        for (PgConstraint c : constraints) {
            if (c.getComment() != null && !c.getComment().isEmpty()) {
                sb.append("\n\n");
                c.appendCommentSql(sb);
            }
        }
        for (PgConstraint c : constrsNotValid) {
            if (c.getComment() != null && !c.getComment().isEmpty()) {
                sb.append("\n\n");
                c.appendCommentSql(sb);
            }
        }
        
        return sb.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP DOMAIN " + PgDiffUtils.getQuotedName(getName()) + ';';
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
            if (sb.length() != 0) {
                sb.append("\n\n");
            }
            sb.append("ALTER DOMAIN ").append(PgDiffUtils.getQuotedName(newDomain.getName()));
            if (newDomain.getDefaultValue() == null) {
                sb.append("\n\tDROP DEFAULT");
            } else {
                sb.append("\n\tSET DEFAULT ").append(newDomain.getDefaultValue());
            }
            sb.append(';');
        }
        
        if (newDomain.isNotNull() != oldDomain.isNotNull()) {
            if (sb.length() != 0) {
                sb.append("\n\n");
            }
            sb.append("ALTER DOMAIN ").append(PgDiffUtils.getQuotedName(newDomain.getName()));
            if (newDomain.isNotNull()) {
                sb.append("\n\tSET NOT NULL");
            } else {
                sb.append("\n\tDROP NOT NULL");
            }
            sb.append(';');
        }
        
        PgDiffDomains.compareConstraints(newDomain.getName(), oldDomain.getConstraints(),
                newDomain.getConstraints(), sb);
        PgDiffDomains.compareConstraints(newDomain.getName(), oldDomain.getConstrsNotValid(),
                newDomain.getConstrsNotValid(), sb);
        
        if (!Objects.equals(oldDomain.getOwner(), newDomain.getOwner())) {
            newDomain.appendOwnerSQL(sb);
        }
        if (!oldDomain.getGrants().equals(newDomain.getGrants()) || 
                !oldDomain.getRevokes().equals(newDomain.getRevokes())) {
            newDomain.appendPrivileges(sb);
        }
        if (!Objects.equals(oldDomain.getComment(), newDomain.getComment())) {
            //sb.append("\n\n");
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
        for (PgConstraint constr : constraints) {
            copy.addConstraint(constr.shallowCopy());
        }
        for (PgConstraint constr : constrsNotValid) {
            copy.addConstrNotValid(constr.shallowCopy());
        }
        for (PgPrivilege priv : grants) {
            copy.addPrivilege(priv.shallowCopy());
        }
        for (PgPrivilege priv : revokes) {
            copy.addPrivilege(priv.shallowCopy());
        }
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
                && constraints.equals(dom.constraints)
                && constrsNotValid.equals(dom.constrsNotValid)
                && Objects.equals(owner, dom.getOwner())
                && grants.equals(dom.grants)
                && revokes.equals(dom.revokes)
                && Objects.equals(comment, dom.getComment());
    }

    @Override
    protected int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
        result = prime * result + ((collation == null) ? 0 : collation.hashCode());
        result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
        result = prime * result + (notNull ? itrue : ifalse);
        result = prime * result + ((constraints == null) ? 0 : constraints.hashCode());
        result = prime * result + ((constrsNotValid == null) ? 0 : constrsNotValid.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema) this.getParent();
    }
}
