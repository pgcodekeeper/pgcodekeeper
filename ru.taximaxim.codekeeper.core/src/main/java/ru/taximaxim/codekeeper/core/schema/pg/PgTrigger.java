/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractTrigger;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;
public final class PgTrigger extends AbstractTrigger {

    public enum TgTypes {
        BEFORE, AFTER, INSTEAD_OF
    }

    private String function;
    private String refTableName;
    private EnabledState triggerState;
    /**
     * Whether the trigger should be fired BEFORE, AFTER or INSTEAD_OF action. Default is
     * before.
     */
    private TgTypes tgType = TgTypes.BEFORE;
    /**
     * Whether the trigger should be fired FOR EACH ROW or FOR EACH STATEMENT.
     * Default is FOR EACH STATEMENT.
     */
    private boolean isForEachRow;
    private boolean isOnDelete;
    private boolean isOnInsert;
    private boolean isOnUpdate;
    private boolean isOnTruncate;
    private boolean isConstraint;
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
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE");
        if (isConstraint) {
            sbSQL.append(" CONSTRAINT");
        }
        sbSQL.append(" TRIGGER ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));
        sbSQL.append("\n\t");
        sbSQL.append(tgType == TgTypes.INSTEAD_OF ? "INSTEAD OF" : tgType);

        boolean firstEvent = true;

        if (isOnInsert) {
            sbSQL.append(" INSERT");
            firstEvent = false;
        }

        if (isOnUpdate) {
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

        if (isOnDelete) {
            if (!firstEvent) {
                sbSQL.append(" OR");
            }

            sbSQL.append(" DELETE");
        }

        if (isOnTruncate) {
            if (!firstEvent) {
                sbSQL.append(" OR");
            }

            sbSQL.append(" TRUNCATE");
        }

        sbSQL.append(" ON ");
        sbSQL.append(parent.getQualifiedName());

        if (isConstraint) {
            if (refTableName != null){
                sbSQL.append("\n\tFROM ").append(refTableName);
            }
            if (isImmediate != null) {
                sbSQL.append("\n\tDEFERRABLE INITIALLY ")
                    .append(isImmediate.booleanValue() ? "IMMEDIATE" : "DEFERRED");
            } else {
                sbSQL.append("\n\tNOT DEFERRABLE INITIALLY IMMEDIATE");
            }
        }

        if (oldTable != null || newTable != null) {
            sbSQL.append("\n\tREFERENCING ");
            if (newTable != null) {
                sbSQL.append("NEW TABLE AS ");
                sbSQL.append(newTable);
                sbSQL.append(' ');
            }
            if (oldTable != null) {
                sbSQL.append("OLD TABLE AS ");
                sbSQL.append(oldTable);
                sbSQL.append(' ');
            }
        }

        sbSQL.append("\n\tFOR EACH ");
        sbSQL.append(isForEachRow ? "ROW" : "STATEMENT");

        if (when != null) {
            sbSQL.append("\n\tWHEN (");
            sbSQL.append(when);
            sbSQL.append(')');
        }

        sbSQL.append("\n\tEXECUTE PROCEDURE ");
        sbSQL.append(function);
        script.addStatement(sbSQL);

        if (triggerState != null) {
            addAlterTable(triggerState, this, script);
        }
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgTrigger newTrg = (PgTrigger) newCondition;
        if (!compareUnalterable(newTrg)) {
            return ObjectState.RECREATE;
        }
        EnabledState newTriggerState = newTrg.triggerState;
        if (!Objects.equals(triggerState, newTriggerState)) {
            if (newTriggerState == null) {
                newTriggerState = EnabledState.ENABLE;
            }
            addAlterTable(newTriggerState, newTrg, script);
        }
        appendAlterComments(newTrg, script);

        return getObjectState(script, startSize);
    }

    private void addAlterTable(EnabledState enabledState, PgTrigger trigger, SQLScript script) {
        StringBuilder sql = new StringBuilder();
        sql.append(ALTER_TABLE)
        .append(parent.getQualifiedName())
        .append(' ')
        .append(enabledState.getValue())
        .append(" TRIGGER ")
        .append(PgDiffUtils.getQuotedName(trigger.name));
        script.addStatement(sql);
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    @Override
    protected StringBuilder appendFullName(StringBuilder sb) {
        sb.append(PgDiffUtils.getQuotedName(name)).append(" ON ");
        sb.append(parent.getQualifiedName());
        return sb;
    }

    public void setType(final TgTypes tgType) {
        this.tgType = tgType;
        resetHash();
    }

    public void setForEachRow(final boolean isForEachRow) {
        this.isForEachRow = isForEachRow;
        resetHash();
    }

    public void setFunction(final String function) {
        this.function = function;
        resetHash();
    }

    public void setOnDelete(final boolean isOnDelete) {
        this.isOnDelete = isOnDelete;
        resetHash();
    }

    public void setOnInsert(final boolean isOnInsert) {
        this.isOnInsert = isOnInsert;
        resetHash();
    }

    public void setOnUpdate(final boolean isOnUpdate) {
        this.isOnUpdate = isOnUpdate;
        resetHash();
    }

    public void setOnTruncate(final boolean isOnTruncate) {
        this.isOnTruncate = isOnTruncate;
        resetHash();
    }

    public void setConstraint(final boolean isConstraint) {
        this.isConstraint = isConstraint;
        resetHash();
    }

    public void addUpdateColumn(final String columnName) {
        updateColumns.add(columnName);
        resetHash();
    }

    public void setWhen(final String when) {
        this.when = when;
        resetHash();
    }

    public void setImmediate(final Boolean isImmediate) {
        this.isImmediate = isImmediate;
        resetHash();
    }

    public void setRefTableName(final String refTableName) {
        this.refTableName = refTableName;
        resetHash();
    }

    public void setOldTable(String oldTable) {
        this.oldTable = oldTable;
        resetHash();
    }

    public void setNewTable(String newTable) {
        this.newTable = newTable;
        resetHash();
    }

    public void setTriggerState(EnabledState triggerState) {
        this.triggerState = triggerState;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PgTrigger trigger && super.compare(obj)) {
            return compareUnalterable(trigger)
                    && triggerState == trigger.triggerState;
        }
        return false;
    }

    private boolean compareUnalterable(PgTrigger trigger) {
        return tgType == trigger.tgType
                && (isForEachRow == trigger.isForEachRow)
                && Objects.equals(function, trigger.function)
                && (isOnDelete == trigger.isOnDelete)
                && (isOnInsert == trigger.isOnInsert)
                && (isOnUpdate == trigger.isOnUpdate)
                && (isOnTruncate == trigger.isOnTruncate)
                && Objects.equals(isImmediate, trigger.isImmediate)
                && Objects.equals(refTableName, trigger.refTableName)
                && (isConstraint == trigger.isConstraint)
                && Objects.equals(when, trigger.when)
                && Objects.equals(newTable, trigger.newTable)
                && Objects.equals(oldTable, trigger.oldTable)
                && Objects.equals(updateColumns, trigger.updateColumns);

    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(tgType);
        hasher.put(isForEachRow);
        hasher.put(function);
        hasher.put(isOnDelete);
        hasher.put(isOnInsert);
        hasher.put(isOnTruncate);
        hasher.put(isOnUpdate);
        hasher.put(when);
        hasher.put(updateColumns);
        hasher.put(isConstraint);
        hasher.put(isImmediate);
        hasher.put(refTableName);
        hasher.put(newTable);
        hasher.put(oldTable);
        hasher.put(triggerState);
    }

    @Override
    protected AbstractTrigger getTriggerCopy() {
        PgTrigger trigger = new PgTrigger(name);
        trigger.setType(tgType);
        trigger.setForEachRow(isForEachRow);
        trigger.setFunction(function);
        trigger.setOnDelete(isOnDelete);
        trigger.setOnInsert(isOnInsert);
        trigger.setOnTruncate(isOnTruncate);
        trigger.setOnUpdate(isOnUpdate);
        trigger.setConstraint(isConstraint);
        trigger.setWhen(when);
        trigger.setImmediate(isImmediate);
        trigger.setRefTableName(refTableName);
        trigger.setNewTable(newTable);
        trigger.setOldTable(oldTable);
        trigger.updateColumns.addAll(updateColumns);
        trigger.setTriggerState(triggerState);
        return trigger;
    }
}
