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

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public abstract class MsConstraint extends AbstractConstraint {

    private boolean isDisabled;

    protected MsConstraint(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        appendAlterTable(sbSQL);
        if (isNotValid()) {
            sbSQL.append(" WITH NOCHECK");
        }
        sbSQL.append("\n\tADD ");
        if (!name.isEmpty()) {
            sbSQL.append("CONSTRAINT ").append(MsDiffUtils.quoteName(getName())).append(' ');
        }
        sbSQL.append(getDefinition());
        script.addStatement(sbSQL);

        // 1) if is not valid, after adding it is disabled by default
        // 2) can't be valid if disabled
        if (isNotValid()) {
            StringBuilder sb = new StringBuilder();
            appendAlterTable(sb);
            sb.append(' ');
            if (isDisabled()) {
                sb.append("NO");
            }
            sb.append("CHECK CONSTRAINT ").append(MsDiffUtils.quoteName(getName()));
            script.addStatement(sb);
        }
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        MsConstraint newConstr = (MsConstraint) newCondition;

        if (!compareUnalterable(newConstr)) {
            return ObjectState.RECREATE;
        }
        compareOptions(newConstr, script);

        if (isNotValid() != newConstr.isNotValid() || isDisabled() != newConstr.isDisabled()) {
            StringBuilder sb = new StringBuilder();
            appendAlterTable(sb);
            sb.append(" WITH ");
            if (newConstr.isNotValid()) {
                sb.append("NO");
            }
            sb.append("CHECK ");
            if (newConstr.isDisabled()) {
                sb.append("NO");
            }
            sb.append("CHECK CONSTRAINT ").append(MsDiffUtils.quoteName(newConstr.getName()));
            script.addStatement(sb);
        }

        return getObjectState(script, startSize);
    }

    protected abstract boolean compareUnalterable(MsConstraint newConstr);

    @Override
    public void getDropSQL(SQLScript script, boolean optionExists) {
        appendSpecialDropSQL(script);
        final StringBuilder sbSQL = new StringBuilder();
        appendAlterTable(sbSQL);
        sbSQL.append("\n\tDROP CONSTRAINT ");
        if (optionExists) {
            sbSQL.append(IF_EXISTS);
        }
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        script.addStatement(sbSQL);
    }

    protected void compareOptions(MsConstraint newConstr, SQLScript script) {
        // subclasses will override if needed
    }

    protected void appendSpecialDropSQL(SQLScript script) {
        // subclasses will override if needed
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsConstraint con && super.compare(obj)) {
            return isDisabled == con.isDisabled();
        }
        return false;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
        resetHash();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isDisabled);
    }

    @Override
    public AbstractConstraint shallowCopy() {
        MsConstraint con = (MsConstraint) super.shallowCopy();
        con.setDisabled(isDisabled());
        return con;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
