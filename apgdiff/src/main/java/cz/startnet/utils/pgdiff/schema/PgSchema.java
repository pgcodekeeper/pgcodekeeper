/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

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
        appendDropBeforeCreate(sbSQL);
        sbSQL.append("CREATE SCHEMA ");
        appendIfNotExists(sbSQL);
        sbSQL.append(getQualifiedName());

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
