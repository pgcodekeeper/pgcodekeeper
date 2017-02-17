/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
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
    private boolean unique;
    private boolean isPrimaryKey;
    private final List<String> columns = new ArrayList<>();
    private GenericColumn refTable;
    private final List<String> refs = new ArrayList<>();
    private boolean notValid;

    /**
     * Список колонок на которых установлен PrimaryKey или Unique
     */
    public List<String> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    /**
     * Добавить колонку к списку колонок PrimaryKey или Unique
     */
    public void addColumn(String genericColumn) {
        columns.add(genericColumn);
    }

    public List<String> getForeignColumns(){
        return Collections.unmodifiableList(refs);
    }

    public void addForeignColumn(String referencedColumn) {
        refs.add(referencedColumn);
    }

    public GenericColumn getForeignTable() {
        return refTable;
    }

    public void setForeignTable(GenericColumn foreignTable) {
        if (foreignTable != null && (foreignTable.type != DbObjType.TABLE || foreignTable.column != null)) {
            throw new IllegalArgumentException("Incorrect foreign table ref!");
        }
        this.refTable = foreignTable;
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

    public boolean isNotValid() {
        return notValid;
    }

    public void setNotValid(boolean notValid) {
        resetHash();
        this.notValid = notValid;
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
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(PgDiffUtils.getQuotedName(getParent().getName()));
        sbSQL.append("\n\tADD CONSTRAINT ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(' ');
        sbSQL.append(getDefinition());
        if (isNotValid()) {
            sbSQL.append(" NOT VALID");
        }
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
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(PgDiffUtils.getQuotedName(getParent().getName()));
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

        PgConstraint oldConstr = this;
        if (!oldConstr.compareWithoutComments(newConstr)) {
            isNeedDepcies.set(true);
            return true;
        }
        if (oldConstr.isNotValid() && !newConstr.isNotValid()) {
            sb.append("\n\nALTER ").append(getParent().getStatementType().name()).append(' ')
            .append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append("\n\tVALIDATE CONSTRAINT ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');
        }
        if (!Objects.equals(oldConstr.getComment(), newConstr.getComment())) {
            sb.append("\n\n");
            newConstr.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgConstraint) {
            PgConstraint constraint = (PgConstraint) obj;
            eq = compareWithoutComments(constraint)
                    && notValid == constraint.isNotValid()
                    && Objects.equals(comment, constraint.getComment());
        }

        return eq;
    }

    private boolean compareWithoutComments(PgConstraint constraint) {
        boolean eq;
        eq = Objects.equals(definition, constraint.getDefinition())
                && Objects.equals(name, constraint.getName());
        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((definition == null) ? 0 : definition.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (notValid ? 1231 : 1237);
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    @Override
    public PgConstraint shallowCopy() {
        PgConstraint constraintDst = new PgConstraint(getName(), getRawStatement());
        constraintDst.setDefinition(getDefinition());
        constraintDst.setComment(getComment());
        constraintDst.setPrimaryKey(isPrimaryKey());
        constraintDst.setUnique(isUnique());
        constraintDst.columns.addAll(columns);
        constraintDst.setForeignTable(getForeignTable());
        constraintDst.refs.addAll(refs);
        constraintDst.deps.addAll(deps);
        constraintDst.setNotValid(isNotValid());
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
