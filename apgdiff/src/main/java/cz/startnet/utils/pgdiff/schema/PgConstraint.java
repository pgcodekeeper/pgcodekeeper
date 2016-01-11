/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table constraint information.
 *
 * @author fordfrog
 */
public class PgConstraint extends PgStatementWithSearchPath {

    private String definition;
    private String tableName;
    private boolean unique;
    private boolean isPrimaryKey;
    private final List<GenericColumn> columns = new ArrayList<>();
    private final List<GenericColumn> refs = new ArrayList<>();

    /**
     * Список колонок на которых установлен PrimaryKey или Unique
     */
    public List<GenericColumn> getColumns() {
        return Collections.unmodifiableList(columns);
    }
    
    /**
     * Добавить колонку к списку колонок PrimaryKey или Unique 
     */
    public boolean addColumn(GenericColumn genericColumn) {
        return columns.add(genericColumn);    
    }
    
    public void addAllColumns(Collection<GenericColumn> cols) {
        for (GenericColumn col : cols) {
            columns.add(col);
        }
    }
    
    public void addForeignColumn(GenericColumn referencedColumn) {
        refs.add(referencedColumn);
    }
    
    public List<GenericColumn> getRefs(){
        return Collections.unmodifiableList(refs);
    }
    
    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.CONSTRAINT;
    }
    
    
    public PgConstraint(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER TABLE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getTableName()));
        sbSQL.append("\n\tADD CONSTRAINT ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(' ');
        sbSQL.append(getDefinition());
        sbSQL.append(';');

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    public void setDefinition(final String definition) {
        this.definition = definition;
        resetHash();
    }

    public String getDefinition() {
        return definition;
    }

    @Override
    public String getDropSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER TABLE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getTableName()));
        sbSQL.append("\n\tDROP CONSTRAINT ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(';');

        return sbSQL.toString();
    }
    
    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgConstraint newConstr;
        if (newCondition instanceof PgConstraint) {
            newConstr = (PgConstraint)newCondition; 
        } else {
            return false;
        }
        // TODO alterable state resulting in VALIDATE CONSTRAINT
        PgConstraint oldConstr = this;
        if (!oldConstr.compareWithoutComments(newConstr)) {
            isNeedDepcies.set(true);
            return true;
        }
        if (!Objects.equals(oldConstr.getComment(), newConstr.getComment())) {
            sb.append("\n\n");
            newConstr.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
        resetHash();
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgConstraint) {
            PgConstraint constraint = (PgConstraint) obj;
            eq = compareWithoutComments(constraint)
                    && Objects.equals(comment, constraint.getComment());
        }

        return eq;
    }

    public boolean compareWithoutComments(PgConstraint constraint) {
        boolean eq;
        eq = Objects.equals(definition, constraint.getDefinition())
                && Objects.equals(name, constraint.getName())
                && Objects.equals(tableName, constraint.getTableName());
        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((definition == null) ? 0 : definition.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tableName == null) ? 0 : tableName.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }
    
    @Override
    public PgConstraint shallowCopy() {
        PgConstraint constraintDst = new PgConstraint(getName(), getRawStatement());
        constraintDst.setDefinition(getDefinition());
        constraintDst.setTableName(getTableName());
        constraintDst.setComment(getComment());
        constraintDst.setPrimaryKey(isPrimaryKey());
        constraintDst.setUnique(isUnique());
        constraintDst.addAllColumns(columns);
        constraintDst.refs.addAll(refs);
        return constraintDst;
    }
    
    @Override
    public PgConstraint deepCopy() {
        return shallowCopy();
    }
    
    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent().getParent();
    }
}
