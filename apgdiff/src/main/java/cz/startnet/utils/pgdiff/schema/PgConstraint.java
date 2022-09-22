/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgConstraint extends AbstractConstraint {

    public PgConstraint(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        appendAlterTable(sbSQL);
        sbSQL.append("\n\tADD CONSTRAINT ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(' ');
        sbSQL.append(getDefinition());

        PgDiffArguments args = getDatabase().getArguments();
        boolean isPartitionTable = getParent() instanceof PartitionPgTable
                || (getParent() instanceof AbstractRegularTable
                        && ((AbstractRegularTable)getParent()).getPartitionBy() != null) ;
        boolean generateNotValid = args != null && args.isConstraintNotValid() && !isPartitionTable && !isUnique() && !isPrimaryKey();

        if (isNotValid() || generateNotValid) {
            sbSQL.append(" NOT VALID");
        }
        sbSQL.append(';');

        if (generateNotValid && !isNotValid() ) {
            sbSQL.append("\n\n");
            appendAlterTable(sbSQL)
            .append(" VALIDATE CONSTRAINT ")
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
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(getParent().getQualifiedName());
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
            sb.append("\n\nALTER ").append(getParent().getStatementType().name()).append(' ')
            .append(getParent().getQualifiedName())
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

    private StringBuilder appendAlterTable(StringBuilder sbSQL) {
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(getParent().getQualifiedName());
        return sbSQL;
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        return new PgConstraint(getName());
    }
}
