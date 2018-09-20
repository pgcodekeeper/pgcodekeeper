/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;

public class PgTrigger extends AbstractTrigger {

    public PgTrigger(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE");
        if (isConstraint()) {
            sbSQL.append(" CONSTRAINT");
        }
        sbSQL.append(" TRIGGER ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append("\n\t");
        sbSQL.append(getType() == TgTypes.INSTEAD_OF ? "INSTEAD OF" : getType());

        boolean firstEvent = true;

        if (isOnInsert()) {
            sbSQL.append(" INSERT");
            firstEvent = false;
        }

        if (isOnUpdate()) {
            if (firstEvent) {
                firstEvent = false;
            } else {
                sbSQL.append(" OR");
            }

            sbSQL.append(" UPDATE");

            if (!updateColumns.isEmpty()) {
                sbSQL.append(" OF ");
                sbSQL.append(String.join(", ", updateColumns));
            }
        }

        if (isOnDelete()) {
            if (!firstEvent) {
                sbSQL.append(" OR");
            }

            sbSQL.append(" DELETE");
        }

        if (isOnTruncate()) {
            if (!firstEvent) {
                sbSQL.append(" OR");
            }

            sbSQL.append(" TRUNCATE");
        }

        sbSQL.append(" ON ");
        sbSQL.append(getTableName());

        if (isConstraint()) {
            if (getRefTableName() != null){
                sbSQL.append("\n\tFROM ").append(getRefTableName());
            }
            if (isImmediate() != null){
                sbSQL.append("\n\tDEFERRABLE INITIALLY ")
                .append(isImmediate() ? "IMMEDIATE" : "DEFERRED");
            } else {
                sbSQL.append("\n\tNOT DEFERRABLE INITIALLY IMMEDIATE");
            }
        }

        if (getOldTable() != null || getNewTable() != null) {
            sbSQL.append("\n\tREFERENCING ");
            if (getNewTable() != null) {
                sbSQL.append("NEW TABLE AS ");
                sbSQL.append(getNewTable());
                sbSQL.append(' ');
            }
            if (getOldTable() != null) {
                sbSQL.append("OLD TABLE AS ");
                sbSQL.append(getOldTable());
                sbSQL.append(' ');
            }
        }

        sbSQL.append("\n\tFOR EACH ");
        sbSQL.append(isForEachRow() ? "ROW" : "STATEMENT");

        if (getWhen() != null) {
            sbSQL.append("\n\tWHEN (");
            sbSQL.append(getWhen());
            sbSQL.append(')');
        }

        sbSQL.append("\n\tEXECUTE PROCEDURE ");
        sbSQL.append(getFunction());
        sbSQL.append(';');

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP TRIGGER " + PgDiffUtils.getQuotedName(getName()) + " ON "
                + getTableName() + ";";
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgTrigger newTrg;
        if (newCondition instanceof PgTrigger) {
            newTrg = (PgTrigger)newCondition;
        } else {
            return false;
        }
        if (!compareWithoutComments(newTrg)) {
            isNeedDepcies.set(true);
            return true;
        }
        if (!Objects.equals(getComment(), newTrg.getComment())) {
            sb.append("\n\n");
            newTrg.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    @Override
    protected AbstractTrigger getTriggerCopy() {
        return new PgTrigger(getName(), getRawStatement());
    }
}
