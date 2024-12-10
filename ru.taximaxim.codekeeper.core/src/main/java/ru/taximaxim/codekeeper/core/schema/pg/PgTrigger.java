/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractTrigger;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class PgTrigger extends AbstractTrigger {

    public enum TgTypes {
        BEFORE, AFTER, INSTEAD_OF
    }

    private String function;
    private String refTableName;
    private String enabledState;
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
    private Boolean isChild;


    public PgTrigger(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
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

        if (enabledState != null) {
            sbSQL.append("\n\nALTER TABLE ")
            .append(getParent().getQualifiedName())
            .append(' ')
            .append(enabledState)
            .append(" TRIGGER ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');
        }

        return sbSQL.toString();
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgTrigger newTrg = (PgTrigger) newCondition;
        if (!compareUnalterable(newTrg)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }
        String newEnabledState = newTrg.getEnabledState();
        if (!Objects.equals(getEnabledState(), newEnabledState)) {
            if (newEnabledState == null) {
                newEnabledState = "ENABLE";
            }
            sb.append("\n\nALTER TABLE ")
            .append(getParent().getQualifiedName())
            .append(' ')
            .append(newEnabledState)
            .append(" TRIGGER ")
            .append(PgDiffUtils.getQuotedName(newTrg.getName()))
            .append(';');
        }
        compareComments(sb, newTrg);

        return getObjectState(sb, startLength);
    }

    @Override
    public boolean canDrop() {
        return !isChild;
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
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

    public String getEnabledState() {
        return enabledState;
    }

    public void setEnabledState(String enabledState) {
        this.enabledState = enabledState;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PgTrigger trigger && super.compare(obj)) {
            return compareUnalterable(trigger)
                    && Objects.equals(enabledState, trigger.getEnabledState());
        }
        return false;
    }

    private boolean compareUnalterable(PgTrigger trigger) {
        return tgType == trigger.getType()
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
        hasher.put(enabledState);
        hasher.put(isChild);
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
        trigger.setEnabledState(getEnabledState());
        trigger.setIsChild(isChild);
        return trigger;
    }

    public Boolean getIsChild() {
        return isChild;
    }

    public void setIsChild(Boolean isChild) {
        this.isChild = isChild;
        resetHash();
    }
}
