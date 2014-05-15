/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import cz.startnet.utils.pgdiff.PgDiffUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

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
    private final List<String> updateColumns = new ArrayList<String>();
    private String when;
    private String comment;
    
    public PgTrigger(String name, String rawStatement, String searchPath) {
        super(name, rawStatement, searchPath);        
    }

    public void setBefore(final boolean before) {
        this.before = before;
    }

    public boolean isBefore() {
        return before;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(100);
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
            sbSQL.append("\n\nCOMMENT ON TRIGGER ");
            sbSQL.append(PgDiffUtils.getQuotedName(name));
            sbSQL.append(" ON ");
            sbSQL.append(PgDiffUtils.getQuotedName(tableName));
            sbSQL.append(" IS ");
            sbSQL.append(comment);
            sbSQL.append(';');
        }

        return sbSQL.toString();
    }

    public String getDropSQL() {
        return "DROP TRIGGER " + PgDiffUtils.getQuotedName(getName()) + " ON "
                + PgDiffUtils.getQuotedName(getTableName()) + ";";
    }

    public void setForEachRow(final boolean forEachRow) {
        this.forEachRow = forEachRow;
    }

    public boolean isForEachRow() {
        return forEachRow;
    }

    public void setFunction(final String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public void setOnDelete(final boolean onDelete) {
        this.onDelete = onDelete;
    }

    public boolean isOnDelete() {
        return onDelete;
    }

    public void setOnInsert(final boolean onInsert) {
        this.onInsert = onInsert;
    }

    public boolean isOnInsert() {
        return onInsert;
    }

    public void setOnUpdate(final boolean onUpdate) {
        this.onUpdate = onUpdate;
    }

    public boolean isOnUpdate() {
        return onUpdate;
    }

    public boolean isOnTruncate() {
        return onTruncate;
    }

    public void setOnTruncate(final boolean onTruncate) {
        this.onTruncate = onTruncate;
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public List<String> getUpdateColumns() {
        return Collections.unmodifiableList(updateColumns);
    }

    public void addUpdateColumn(final String columnName) {
        updateColumns.add(columnName);
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(final String when) {
        this.when = when;
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgTrigger) {
            PgTrigger trigger = (PgTrigger) obj;
            eq = (before == trigger.isBefore())
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

        return eq;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (before ? 1231 : 1237);
        result = prime * result + (forEachRow ? 1231 : 1237);
        result = prime * result + ((function == null) ? 0 : function.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (onDelete ? 1231 : 1237);
        result = prime * result + (onInsert ? 1231 : 1237);
        result = prime * result + (onTruncate ? 1231 : 1237);
        result = prime * result + (onUpdate ? 1231 : 1237);
        result = prime * result + ((tableName == null) ? 0 : tableName.hashCode());
        result = prime * result + ((when == null) ? 0 : when.hashCode());
        result = prime * result + new HashSet<>(updateColumns).hashCode();
        return result;
    }
    
    @Override
    public PgTrigger shallowCopy() {
        PgTrigger triggerDst =
                new PgTrigger(getName(), getRawStatement(), getSearchPath());
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
        for(String updCol : updateColumns) {
            triggerDst.addUpdateColumn(updCol);
        }
        return triggerDst;
    }
    
    @Override
    public PgTrigger deepCopy() {
        return shallowCopy();
    }
}
