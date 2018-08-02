/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Postgres schema code generation.
 */
public class PgSchema extends AbstractSchema {

    public PgSchema(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SCHEMA ");
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
    public String getDropSQL() {
        return "DROP SCHEMA " + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgSchema newSchema;
        if (newCondition instanceof PgSchema) {
            newSchema = (PgSchema) newCondition;
        } else {
            return false;
        }

        if (!Objects.equals(getOwner(), newSchema.getOwner())) {
            sb.append(newSchema.getOwnerSQL());
        }

        alterPrivileges(newSchema, sb);

        if (!Objects.equals(getComment(), newSchema.getComment())) {
            sb.append("\n\n");
            newSchema.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    @Override
    public AbstractSchema getSchemaCopy() {
        return new PgSchema(getName(), getRawStatement());
    }
}
