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

    /**
     * Function name and arguments that should be fired on the trigger.
     */
    private String function;
    /**
     * Name of the trigger.
     */
    private String name;
    /**
     * Name of the table the trigger is defined on.
     */
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
    /**
     * Whether the trigger should be fired on DELETE.
     */
    private boolean onDelete;
    /**
     * Whether the trigger should be fired on INSERT.
     */
    private boolean onInsert;
    /**
     * Whether the trigger should be fired on UPDATE.
     */
    private boolean onUpdate;
    /**
     * Whether the trigger should be fired on TRUNCATE.
     */
    private boolean onTruncate;
    /**
     * Optional list of columns for UPDATE event.
     */
    private final List<String> updateColumns = new ArrayList<String>();
    /**
     * WHEN condition.
     */
    private String when;
    /**
     * Comment.
     */
    private String comment;
    
    /**
     * Create a new PgTrigger object
     */
    public PgTrigger(final String rawStatement, final String searchPath) {
    	super(rawStatement, searchPath);    	
    }

    /**
     * Setter for {@link #before}.
     *
     * @param before {@link #before}
     */
    public void setBefore(final boolean before) {
        this.before = before;
    }

    /**
     * Getter for {@link #before}.
     *
     * @return {@link #before}
     */
    public boolean isBefore() {
        return before;
    }

    /**
     * Getter for {@link #comment}.
     *
     * @return {@link #comment}
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for {@link #comment}.
     *
     * @param comment {@link #comment}
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * Creates and returns SQL for creation of trigger.
     *
     * @return created SQL
     */
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

    /**
     * Creates and returns SQL for dropping the trigger.
     *
     * @return created SQL
     */
    public String getDropSQL() {
        return "DROP TRIGGER " + PgDiffUtils.getQuotedName(getName()) + " ON "
                + PgDiffUtils.getQuotedName(getTableName()) + ";";
    }

    /**
     * Setter for {@link #forEachRow}.
     *
     * @param forEachRow {@link #forEachRow}
     */
    public void setForEachRow(final boolean forEachRow) {
        this.forEachRow = forEachRow;
    }

    /**
     * Getter for {@link #forEachRow}.
     *
     * @return {@link #forEachRow}
     */
    public boolean isForEachRow() {
        return forEachRow;
    }

    /**
     * Setter for {@link #function}.
     *
     * @param function {@link #function}
     */
    public void setFunction(final String function) {
        this.function = function;
    }

    /**
     * Getter for {@link #function}.
     *
     * @return {@link #function}
     */
    public String getFunction() {
        return function;
    }

    /**
     * Setter for {@link #name}.
     *
     * @param name {@link #name}
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter for {@link #name}.
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for {@link #onDelete}.
     *
     * @param onDelete {@link #onDelete}
     */
    public void setOnDelete(final boolean onDelete) {
        this.onDelete = onDelete;
    }

    /**
     * Getter for {@link #onDelete}.
     *
     * @return {@link #onDelete}
     */
    public boolean isOnDelete() {
        return onDelete;
    }

    /**
     * Setter for {@link #onInsert}.
     *
     * @param onInsert {@link #onInsert}
     */
    public void setOnInsert(final boolean onInsert) {
        this.onInsert = onInsert;
    }

    /**
     * Getter for {@link #onInsert}.
     *
     * @return {@link #onInsert}
     */
    public boolean isOnInsert() {
        return onInsert;
    }

    /**
     * Setter for {@link #onUpdate}.
     *
     * @param onUpdate {@link #onUpdate}
     */
    public void setOnUpdate(final boolean onUpdate) {
        this.onUpdate = onUpdate;
    }

    /**
     * Getter for {@link #onUpdate}.
     *
     * @return {@link #onUpdate}
     */
    public boolean isOnUpdate() {
        return onUpdate;
    }

    /**
     * Getter for {@link #onTruncate}.
     *
     * @return {@link #onTruncate}
     */
    public boolean isOnTruncate() {
        return onTruncate;
    }

    /**
     * Setter for {@link #onTruncate}.
     *
     * @param onTruncate {@link #onTruncate}
     */
    public void setOnTruncate(final boolean onTruncate) {
        this.onTruncate = onTruncate;
    }

    /**
     * Setter for {@link #tableName}.
     *
     * @param tableName {@link #tableName}
     */
    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    /**
     * Getter for {@link #tableName}.
     *
     * @return {@link #tableName}
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Getter for {@link #updateColumns}.
     *
     * @return {@link #updateColumns}
     */
    public List<String> getUpdateColumns() {
        return Collections.unmodifiableList(updateColumns);
    }

    /**
     * Adds column name to the list of update columns.
     *
     * @param columnName column name
     */
    public void addUpdateColumn(final String columnName) {
        updateColumns.add(columnName);
    }

    /**
     * Getter for {@link #when}.
     *
     * @return {@link #when}
     */
    public String getWhen() {
        return when;
    }

    /**
     * Setter for {@link #when}.
     *
     * @param when {@link #when}
     */
    public void setWhen(final String when) {
        this.when = when;
    }

    @Override
    public boolean equals(final Object object) {
        boolean equals = false;

        if (this == object) {
            equals = true;
        } else if (object instanceof PgTrigger) {
            final PgTrigger trigger = (PgTrigger) object;
            equals = (before == trigger.isBefore())
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

        return equals;
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
        PgTrigger triggerDst = new PgTrigger(getRawStatement(), getSearchPath());
        triggerDst.setName(getName());
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
