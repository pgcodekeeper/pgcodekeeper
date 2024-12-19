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

public class MsTrigger extends AbstractTrigger implements SourceStatement {

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

        if (isDisable()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nDISABLE TRIGGER ");
            appendName(sb);
            script.addStatement(sb);
        }
    }

    private void addTriggerFullSQL(SQLScript script, boolean isCreate) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(isQuotedIdentified() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(isAnsiNulls() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        appendSourceStatement(isCreate, sbSQL);
        script.addStatement(sbSQL);
    }

    @Override
    public StringBuilder appendName(StringBuilder sb) {
        sb.append(MsDiffUtils.quoteName(getSchemaName()))
        .append('.')
        .append(MsDiffUtils.quoteName(getName()))
        .append(" ON ")
        .append(getParent().getQualifiedName());
        return sb;
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        MsTrigger newTrigger = (MsTrigger) newCondition;
        boolean isNeedDepcies = false;
        if (isAnsiNulls() != newTrigger.isAnsiNulls()
                || isQuotedIdentified() != newTrigger.isQuotedIdentified()
                || !Objects.equals(getFirstPart(), newTrigger.getFirstPart())
                || !Objects.equals(getSecondPart(), newTrigger.getSecondPart())) {
            newTrigger.addTriggerFullSQL(script, false);
            isNeedDepcies = true;
        }

        if (isDisable() != newTrigger.isDisable()) {
            StringBuilder sbSQL = new StringBuilder();
            sbSQL.append('\n');
            sbSQL.append(newTrigger.isDisable() ? "DISABLE" : "ENABLE");
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
        .append(MsDiffUtils.quoteName(getName()));
        return sb;
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsTrigger trigger && super.compare(obj)) {
            return Objects.equals(getFirstPart(), trigger.getFirstPart())
                    && Objects.equals(getSecondPart(), trigger.getSecondPart())
                    && isQuotedIdentified() == trigger.isQuotedIdentified()
                    && isAnsiNulls() == trigger.isAnsiNulls()
                    && isDisable() == trigger.isDisable();
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(getFirstPart());
        hasher.put(getSecondPart());
        hasher.put(isQuotedIdentified());
        hasher.put(isAnsiNulls());
        hasher.put(isDisable());
    }

    @Override
    protected AbstractTrigger getTriggerCopy() {
        MsTrigger trigger = new MsTrigger(getName());
        trigger.setFirstPart(getFirstPart());
        trigger.setSecondPart(getSecondPart());
        trigger.setAnsiNulls(isAnsiNulls());
        trigger.setQuotedIdentified(isQuotedIdentified());
        trigger.setDisable(isDisable());
        return trigger;
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public boolean isQuotedIdentified() {
        return quotedIdentified;
    }

    public boolean isDisable() {
        return isDisable;
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
