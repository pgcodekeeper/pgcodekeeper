/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;

public class PgConstraint extends AbstractConstraint {

    public PgConstraint(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(PgDiffUtils.getQuotedName(getParent().getParent().getName()));
        sbSQL.append('.');
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

    @Override
    public String getDropSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(PgDiffUtils.getQuotedName(getParent().getParent().getName()));
        sbSQL.append('.');
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
        PgConstraint newConstr = (PgConstraint) newCondition;

        if (!Objects.equals(getDefinition(), newConstr.getDefinition())) {
            isNeedDepcies.set(true);
            return true;
        }
        if (isNotValid() && !newConstr.isNotValid()) {
            sb.append("\n\nALTER ").append(getParent().getStatementType().name()).append(' ')
            .append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
            .append('.')
            .append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append("\n\tVALIDATE CONSTRAINT ")
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
    protected AbstractConstraint getConstraintCopy() {
        return new PgConstraint(getName());
    }
}
