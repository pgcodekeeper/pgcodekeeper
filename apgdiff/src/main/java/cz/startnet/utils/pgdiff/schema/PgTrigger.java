/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public class PgTrigger extends AbstractTrigger {

    public enum TgTypes {
        BEFORE, AFTER, INSTEAD_OF
    }

    private String function;
    private String refTableName;
    /**
     * Whether the trigger should be fired BEFORE, AFTER or INSTEAD_OF action. Default is
     * before.
     */
    private TgTypes tgType = TgTypes.BEFORE;
    /**
     * Whether the trigger should be fired FOR EACH ROW or FOR EACH STATEMENT.
     * Default is FOR EACH STATEMENT.
     */
    private boolean forEachRow;
    private boolean onDelete;
    private boolean onInsert;
    private boolean onUpdate;
    private boolean onTruncate;
    private boolean constraint;
    private Boolean isImmediate;
    /**
     * Optional list of columns for UPDATE event.
     */
    private final Set<String> updateColumns = new HashSet<>();
    private String when;

    /**
     * REFERENCING old table name
     */
    private String oldTable;
    /**
     * REFERENCING new table name
     */
    private String newTable;


    public PgTrigger(String name) {
        super(name);
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
                for (String updateColumn : updateColumns) {
                    sbSQL.append(PgDiffUtils.getQuotedName(updateColumn));
                    sbSQL.append(", ");
                }
                sbSQL.setLength(sbSQL.length() - 2);
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
        sbSQL.append(getParent().getQualifiedName());

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
    public final String getDropSQL() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DROP ").append(getTypeName()).append(' ');
        appendFullName(sb);
        sb.append(';');
        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgTrigger newTrg = (PgTrigger) newCondition;
        if (!compareUnalterable(newTrg)) {
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
    protected StringBuilder appendFullName(StringBuilder sb) {
        sb.append(PgDiffUtils.getQuotedName(getName())).append(" ON ");
        sb.append(getParent().getQualifiedName());
        return sb;
    }

    public void setType(final TgTypes tgType) {
        this.tgType = tgType;
        resetHash();
    }

    public TgTypes getType() {
        return tgType;
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

    protected String getFunction() {
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

    public Set<String> getUpdateColumns() {
        return Collections.unmodifiableSet(updateColumns);
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

    public Boolean isImmediate() {
        return isImmediate;
    }

    public void setImmediate(final Boolean isImmediate) {
        this.isImmediate = isImmediate;
        resetHash();
    }

    public boolean isConstraint() {
        return constraint;
    }

    public void setConstraint(final boolean constraint) {
        this.constraint = constraint;
        resetHash();
    }

    public String getRefTableName() {
        return refTableName;
    }

    public void setRefTableName(final String refTableName) {
        this.refTableName = refTableName;
        resetHash();
    }

    public void setOldTable(String oldTable) {
        this.oldTable = oldTable;
        resetHash();
    }

    public String getOldTable() {
        return oldTable;
    }

    public void setNewTable(String newTable) {
        this.newTable = newTable;
        resetHash();
    }

    public String getNewTable() {
        return newTable;
    }

    @Override
    public boolean compare(PgStatement obj) {
        return super.compare(obj) && compareUnalterable(obj);
    }

    private boolean compareUnalterable(PgStatement obj) {
        if (obj instanceof PgTrigger) {
            PgTrigger trigger = (PgTrigger) obj;
            return  tgType == trigger.getType()
                    && (forEachRow == trigger.isForEachRow())
                    && Objects.equals(function, trigger.getFunction())
                    && (onDelete == trigger.isOnDelete())
                    && (onInsert == trigger.isOnInsert())
                    && (onUpdate == trigger.isOnUpdate())
                    && (onTruncate == trigger.isOnTruncate())
                    && Objects.equals(isImmediate, trigger.isImmediate())
                    && Objects.equals(refTableName, trigger.getRefTableName())
                    && (constraint == trigger.isConstraint())
                    && Objects.equals(when, trigger.getWhen())
                    && Objects.equals(newTable, trigger.getNewTable())
                    && Objects.equals(oldTable, trigger.getOldTable())
                    && Objects.equals(updateColumns, trigger.updateColumns);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(tgType);
        hasher.put(forEachRow);
        hasher.put(function);
        hasher.put(onDelete);
        hasher.put(onInsert);
        hasher.put(onTruncate);
        hasher.put(onUpdate);
        hasher.put(when);
        hasher.put(updateColumns);
        hasher.put(constraint);
        hasher.put(isImmediate);
        hasher.put(refTableName);
        hasher.put(newTable);
        hasher.put(oldTable);
    }

    @Override
    protected AbstractTrigger getTriggerCopy() {
        PgTrigger trigger = new PgTrigger(getName());
        trigger.setType(getType());
        trigger.setForEachRow(isForEachRow());
        trigger.setFunction(getFunction());
        trigger.setOnDelete(isOnDelete());
        trigger.setOnInsert(isOnInsert());
        trigger.setOnTruncate(isOnTruncate());
        trigger.setOnUpdate(isOnUpdate());
        trigger.setConstraint(isConstraint());
        trigger.setWhen(getWhen());
        trigger.setImmediate(isImmediate());
        trigger.setRefTableName(getRefTableName());
        trigger.setNewTable(getNewTable());
        trigger.setOldTable(getOldTable());
        trigger.updateColumns.addAll(updateColumns);
        return trigger;
    }
}
