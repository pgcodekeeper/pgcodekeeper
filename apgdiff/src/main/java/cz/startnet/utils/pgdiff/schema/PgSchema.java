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

/**
 * Postgres schema code generation.
 */
public class PgSchema extends AbstractSchema {

    public PgSchema(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        PgDiffArguments args = getDatabase().getArguments();
        if (args.isOptionDropObject()) {
            sbSQL.append(getDropSQL(true));
            sbSQL.append("\n\n");
        }
        sbSQL.append("CREATE SCHEMA ");
        if  (args != null && args.isOptionExisting()) {
            sbSQL.append("IF NOT EXISTS ");
        }
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));

        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        StringBuilder dropSb = new StringBuilder();
        dropSb.append("DROP SCHEMA ");
        if (optionExists) {
            dropSb.append("IF EXISTS ");
        }
        dropSb.append(PgDiffUtils.getQuotedName(getName())).append(";");
        return dropSb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        if (!Objects.equals(getOwner(), newCondition.getOwner())) {
            newCondition.alterOwnerSQL(sb);
        }

        alterPrivileges(newCondition, sb);

        if (!Objects.equals(getComment(), newCondition.getComment())) {
            sb.append("\n\n");
            newCondition.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    @Override
    protected AbstractSchema getSchemaCopy() {
        return new PgSchema(getName());
    }
}
