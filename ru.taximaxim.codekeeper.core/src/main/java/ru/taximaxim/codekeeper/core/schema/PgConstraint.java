/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package ru.taximaxim.codekeeper.core.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class PgConstraint extends AbstractConstraint {

    private boolean nullsDistinction = true;

    public PgConstraint(String name) {
        super(name);
    }

    public boolean isNullsDistinction() {
        return nullsDistinction;
    }

    public void setNullsDistinction(boolean nullsDistinction) {
        this.nullsDistinction = nullsDistinction;
        resetHash();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        appendAlterTable(sbSQL);
        sbSQL.append("\n\tADD CONSTRAINT ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(' ');
        sbSQL.append(getDefinition());

        boolean generateNotValid = false;
        PgDiffArguments args = getDatabase().getArguments();
        if (args != null && args.isConstraintNotValid() && !isUnique() && !isPrimaryKey()) {
            boolean isPartitionTable = getParent() instanceof PartitionPgTable
                    || (getParent() instanceof AbstractRegularTable
                            && ((AbstractRegularTable) getParent()).getPartitionBy() != null);
            generateNotValid = !isPartitionTable;
        }

        if (isNotValid() || generateNotValid) {
            sbSQL.append(" NOT VALID");
        }
        sbSQL.append(';');

        if (generateNotValid && !isNotValid()) {
            sbSQL.append("\n\n");
            appendAlterTable(sbSQL);
            sbSQL.append(" VALIDATE CONSTRAINT ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');
        }

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        final StringBuilder sbSQL = new StringBuilder();
        appendAlterTable(sbSQL);
        sbSQL.append("\n\tDROP CONSTRAINT ");
        if (optionExists) {
            sbSQL.append("IF EXISTS ");
        }
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(';');

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgConstraint newConstr = (PgConstraint) newCondition;

        if (!Objects.equals(getDefinition(), newConstr.getDefinition())) {
            isNeedDepcies.set(true);
            return true;
        }
        if (isNotValid() && !newConstr.isNotValid()) {
            sb.append("\n\n");
            appendAlterTable(sb);
            sb.append("\n\tVALIDATE CONSTRAINT ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');
        }

        if (!Objects.equals(getComment(), newConstr.getComment())) {
            sb.append("\n\n");
            newConstr.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    @Override
    protected StringBuilder appendCommentSql(StringBuilder sb) {
        sb.append("COMMENT ON CONSTRAINT ");
        sb.append(PgDiffUtils.getQuotedName(getName())).append(" ON ");
        if (getParent().getStatementType() == DbObjType.DOMAIN) {
            sb.append("DOMAIN ");
        }
        sb.append(getParent().getQualifiedName());
        return sb.append(" IS ")
                .append(comment == null || comment.isEmpty() ? "NULL" : comment)
                .append(';');
    }

    private void appendAlterTable(StringBuilder sbSQL) {
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(getParent().getQualifiedName());
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        return new PgConstraint(getName());
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(nullsDistinction);
    }

    @Override
    public boolean compare(PgStatement constr) {
        return constr instanceof PgConstraint
                && super.compare(constr)
                && nullsDistinction == ((PgConstraint) constr).nullsDistinction;
    }
}
