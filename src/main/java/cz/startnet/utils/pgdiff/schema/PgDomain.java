package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
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
    
    public void addConstraint(PgConstraint constraint) {
        constraints.add(constraint);
        constraint.setParent(this);
        resetHash();
    }
    

    public List<PgConstraint> getConstrsNotValid() {
        return Collections.unmodifiableList(constrsNotValid);
    }
    
    public void addConstrNotValid(PgConstraint constraint) {
        constrsNotValid.add(constraint);
        constraint.setParent(this);
        resetHash();
    }

    public PgDomain(String name, String rawStatement, String searchPath) {
        super(name, rawStatement, searchPath);
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
		
        return sb.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP DOMAIN " + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public PgDomain shallowCopy() {
        PgDomain copy = new PgDomain(getName(), getRawStatement(), getSearchPath());
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
        for (PgPrivilege priv : privileges) {
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
        return Objects.equals(dataType, dom.getDataType())
                && Objects.equals(collation, dom.getCollation())
                && Objects.equals(defaultValue, dom.getDefaultValue())
                && notNull == dom.isNotNull()
                && constraints.equals(dom.constraints)
                && constrsNotValid.equals(dom.constrsNotValid)
                && Objects.equals(owner, dom.getOwner())
                && privileges.equals(dom.privileges)
                && Objects.equals(comment, dom.getComment());
    }

    @Override
    protected int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
        result = prime * result + ((collation == null) ? 0 : collation.hashCode());
        result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
        result = prime * result + (notNull ? itrue : ifalse);
        result = prime * result + ((constraints == null) ? 0 : constraints.hashCode());
        result = prime * result + ((constrsNotValid == null) ? 0 : constrsNotValid.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((privileges == null) ? 0 : privileges.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }
}
