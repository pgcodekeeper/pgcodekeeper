/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores trigger information.
 *
 * @author fordfrog
 */
public class PgTrigger extends PgStatementWithSearchPath {

    private String function;
    private String tableName;
    /**
     * Whether the trigger should be fired BEFORE or AFTER action. Default is
     * before.
     */
    private boolean before = true;
    /**
     * Whether the trigger should be fired FOR EACH ROW or FOR EACH STATEMENT.
     * Default is FOR EACH STATEMENT.
     */
    private boolean forEachRow;
    private boolean onDelete;
    private boolean onInsert;
    private boolean onUpdate;
    private boolean onTruncate;
    /**
     * Optional list of columns for UPDATE event.
     */
    private final List<String> updateColumns = new ArrayList<>();
    private String when;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TRIGGER;
    }

    public PgTrigger(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public void setBefore(final boolean before) {
        this.before = before;
        resetHash();
    }

    public boolean isBefore() {
        return before;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE TRIGGER ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append("\n\t");
        sbSQL.append(isBefore() ? "BEFORE" : "AFTER");

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
                sbSQL.append(" OF");

                boolean first = true;

                for (final String columnName : updateColumns) {
                    if (first) {
                        first = false;
                    } else {
                        sbSQL.append(',');
                    }

                    sbSQL.append(' ');
                    sbSQL.append(columnName);
                }
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
        sbSQL.append(PgDiffUtils.getQuotedName(getTableName()));
        sbSQL.append("\n\tFOR EACH ");
        sbSQL.append(isForEachRow() ? "ROW" : "STATEMENT");

        if (when != null && !when.isEmpty()) {
            sbSQL.append("\n\tWHEN (");
            sbSQL.append(when);
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
                + PgDiffUtils.getQuotedName(getTableName()) + ";";
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
        PgTrigger oldTrg = this;
        if (!oldTrg.compareWithoutComments(newTrg)) {
            isNeedDepcies.set(true);
            return true;
        }
        if (!Objects.equals(oldTrg.getComment(), newTrg.getComment())) {
            sb.append("\n\n");
            newTrg.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    public void setForEachRow(final boolean forEachRow) {
        this.forEachRow = forEachRow;
        resetHash();
    }

    public boolean isForEachRow() {
        return forEachRow;
    }

    public void setFunction(final String function) {
        this.function = function;
        resetHash();
    }

    private String getFunction() {
        return function;
    }

    public void setOnDelete(final boolean onDelete) {
        this.onDelete = onDelete;
        resetHash();
    }

    public boolean isOnDelete() {
        return onDelete;
    }

    public void setOnInsert(final boolean onInsert) {
        this.onInsert = onInsert;
        resetHash();
    }

    public boolean isOnInsert() {
        return onInsert;
    }

    public void setOnUpdate(final boolean onUpdate) {
        this.onUpdate = onUpdate;
        resetHash();
    }

    public boolean isOnUpdate() {
        return onUpdate;
    }

    public boolean isOnTruncate() {
        return onTruncate;
    }

    public void setOnTruncate(final boolean onTruncate) {
        this.onTruncate = onTruncate;
        resetHash();
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
        resetHash();
    }

    public String getTableName() {
        return tableName;
    }

    public List<String> getUpdateColumns() {
        return Collections.unmodifiableList(updateColumns);
    }

    public void addUpdateColumn(final String columnName) {
        updateColumns.add(columnName);
        resetHash();
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(final String when) {
        this.when = when;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgTrigger) {
            PgTrigger trigger = (PgTrigger) obj;
            eq = compareWithoutComments(trigger)
                    && Objects.equals(comment, trigger.getComment());
        }

        return eq;
    }

    public boolean compareWithoutComments(PgTrigger trigger) {
        return (before == trigger.isBefore())
                && (forEachRow == trigger.isForEachRow())
                && Objects.equals(function, trigger.getFunction())
                && Objects.equals(name, trigger.getName())
                && (onDelete == trigger.isOnDelete())
                && (onInsert == trigger.isOnInsert())
                && (onUpdate == trigger.isOnUpdate())
                && (onTruncate == trigger.isOnTruncate())
                && Objects.equals(tableName, trigger.getTableName())
                && Objects.equals(when, trigger.getWhen())
                && new HashSet<>(updateColumns).equals(new HashSet<>(trigger.updateColumns));
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + (before ? itrue : ifalse);
        result = prime * result + (forEachRow ? itrue : ifalse);
        result = prime * result + (function == null ? 0 : function.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (onDelete ? itrue : ifalse);
        result = prime * result + (onInsert ? itrue : ifalse);
        result = prime * result + (onTruncate ? itrue : ifalse);
        result = prime * result + (onUpdate ? itrue : ifalse);
        result = prime * result + ((tableName == null) ? 0 : tableName.hashCode());
        result = prime * result + (when == null ? 0 : when.hashCode());
        result = prime * result + new HashSet<>(updateColumns).hashCode();
        result = prime * result + (comment == null ? 0 : comment.hashCode());
        return result;
    }

    @Override
    public PgTrigger shallowCopy() {
        PgTrigger triggerDst =
                new PgTrigger(getName(), getRawStatement());
        triggerDst.setBefore(isBefore());
        triggerDst.setForEachRow(isForEachRow());
        triggerDst.setFunction(getFunction());
        triggerDst.setOnDelete(isOnDelete());
        triggerDst.setOnInsert(isOnInsert());
        triggerDst.setOnTruncate(isOnTruncate());
        triggerDst.setOnUpdate(isOnUpdate());
        triggerDst.setTableName(getTableName());
        triggerDst.setWhen(getWhen());
        triggerDst.setComment(getComment());
        triggerDst.updateColumns.addAll(updateColumns);
        triggerDst.deps.addAll(deps);
        return triggerDst;
    }

    @Override
    public PgTrigger deepCopy() {
        return shallowCopy();
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent().getParent();
    }
}
