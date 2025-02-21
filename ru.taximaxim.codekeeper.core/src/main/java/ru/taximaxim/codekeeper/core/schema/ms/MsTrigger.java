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
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractTrigger;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SourceStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class MsTrigger extends AbstractTrigger implements SourceStatement {

    private boolean ansiNulls;
    private boolean quotedIdentified;
    private boolean isDisable;

    private String firstPart;
    private String secondPart;

    public MsTrigger(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        addTriggerFullSQL(script, true);

        if (isDisable) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nDISABLE TRIGGER ");
            appendName(sb);
            script.addStatement(sb);
        }
    }

    private void addTriggerFullSQL(SQLScript script, boolean isCreate) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(quotedIdentified ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(ansiNulls ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        appendSourceStatement(isCreate, sbSQL);
        script.addStatement(sbSQL);
    }

    @Override
    public StringBuilder appendName(StringBuilder sb) {
        sb.append(MsDiffUtils.quoteName(getSchemaName()))
        .append('.')
        .append(MsDiffUtils.quoteName(name))
        .append(" ON ")
        .append(parent.getQualifiedName());
        return sb;
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        MsTrigger newTrigger = (MsTrigger) newCondition;
        boolean isNeedDepcies = false;
        if (ansiNulls != newTrigger.ansiNulls
                || quotedIdentified != newTrigger.quotedIdentified
                || !Objects.equals(firstPart, newTrigger.firstPart)
                || !Objects.equals(secondPart, newTrigger.secondPart)) {
            newTrigger.addTriggerFullSQL(script, false);
            isNeedDepcies = true;
        }

        if (isDisable != newTrigger.isDisable) {
            StringBuilder sbSQL = new StringBuilder();
            sbSQL.append('\n');
            sbSQL.append(newTrigger.isDisable ? "DISABLE" : "ENABLE");
            sbSQL.append(" TRIGGER ");
            appendName(sbSQL);
            script.addStatement(sbSQL);
        }
        return getObjectState(isNeedDepcies, script, startSize);
    }

    @Override
    protected StringBuilder appendFullName(StringBuilder sb) {
        sb.append(MsDiffUtils.quoteName(getSchemaName()))
        .append('.')
        .append(MsDiffUtils.quoteName(name));
        return sb;
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsTrigger trigger && super.compare(obj)) {
            return Objects.equals(firstPart, trigger.firstPart)
                    && Objects.equals(secondPart, trigger.secondPart)
                    && quotedIdentified == trigger.quotedIdentified
                    && ansiNulls == trigger.ansiNulls
                    && isDisable == trigger.isDisable;
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(firstPart);
        hasher.put(secondPart);
        hasher.put(quotedIdentified);
        hasher.put(ansiNulls);
        hasher.put(isDisable);
    }

    @Override
    protected AbstractTrigger getTriggerCopy() {
        MsTrigger trigger = new MsTrigger(name);
        trigger.setFirstPart(firstPart);
        trigger.setSecondPart(secondPart);
        trigger.setAnsiNulls(ansiNulls);
        trigger.setQuotedIdentified(quotedIdentified);
        trigger.setDisable(isDisable);
        return trigger;
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public void setDisable(boolean isDisable) {
        this.isDisable = isDisable;
        resetHash();
    }

    @Override
    public String getFirstPart() {
        return firstPart;
    }

    @Override
    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
        resetHash();
    }

    @Override
    public String getSecondPart() {
        return secondPart;
    }

    @Override
    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
        resetHash();
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
