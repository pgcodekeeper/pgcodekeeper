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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.EventType;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

/**
 * Stores table rule information.
 *
 * @author akifiev_an
 *
 */
public final class PgRule extends PgStatement implements ISearchPath {

    private EventType event;
    private String condition;
    private boolean instead;
    private final List<String> commands = new ArrayList<>();
    /**
     * null is default (ENABLED), otherwise contains "{ENABLE|DISABLE} [ALWAYS|REPLICA]" string
     */
    private String enabledState;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.RULE;
    }

    public void setEvent(EventType event) {
        this.event = event;
        resetHash();
    }

    public void setCondition(String condition) {
        this.condition = condition;
        resetHash();
    }

    public void setInstead(boolean instead) {
        this.instead = instead;
        resetHash();
    }

    public void addCommand(String command) {
        commands.add(command);
        resetHash();
    }

    public void setEnabledState(String enabledState) {
        this.enabledState = enabledState;
        resetHash();
    }

    public PgRule(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE RULE ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));
        sbSQL.append(" AS\n    ON ").append(event);
        sbSQL.append(" TO ").append(parent.getQualifiedName());
        if (condition != null && !condition.isEmpty()){
            sbSQL.append("\n  WHERE ").append(condition);
        }
        sbSQL.append(" DO ");
        if (instead){
            sbSQL.append("INSTEAD ");
        }
        switch (commands.size()) {
        case 0:
            sbSQL.append("NOTHING");
            break;
        case 1:
            // space before is defined by get_query_def
            sbSQL.append(' ').append(commands.get(0));
            break;
        default:
            sbSQL.append('(');
            for (String command : commands) {
                sbSQL.append(' ').append(command).append(";\n");
            }
            sbSQL.append(')');
        }
        script.addStatement(sbSQL);

        if (enabledState != null) {
            addAlterTable(enabledState, this, script);
        }
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgRule newRule = (PgRule) newCondition;

        if (!compareUnalterable(newRule)) {
            return ObjectState.RECREATE;
        }
        String newEnabledState = newRule.enabledState;
        if (!Objects.equals(enabledState, newEnabledState)) {
            if (newEnabledState == null) {
                newEnabledState = "ENABLE";
            }
            addAlterTable(newEnabledState, newRule, script);
        }
        appendAlterComments(newRule, script);

        return getObjectState(script, startSize);
    }

    private void addAlterTable(String enabledState, PgRule rule, SQLScript script) {
        StringBuilder sql = new StringBuilder();
        sql.append(ALTER_TABLE)
        .append(parent.getQualifiedName())
        .append(' ')
        .append(enabledState)
        .append(" RULE ")
        .append(PgDiffUtils.getQuotedName(rule.name));
        script.addStatement(sql);
    }

    @Override
    protected StringBuilder appendFullName(StringBuilder sb) {
        sb.append(PgDiffUtils.getQuotedName(name)).append(" ON ");
        sb.append(parent.getQualifiedName());
        return sb;
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    @Override
    public PgRule shallowCopy() {
        PgRule ruleDst = new PgRule(name);
        copyBaseFields(ruleDst);
        ruleDst.setEvent(event);
        ruleDst.setCondition(condition);
        ruleDst.setInstead(instead);
        ruleDst.commands.addAll(commands);
        ruleDst.setEnabledState(enabledState);
        return ruleDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgRule rule && super.compare(obj)) {
            return compareUnalterable(rule)
                    && Objects.equals(enabledState, rule.enabledState);
        }

        return false;
    }

    private boolean compareUnalterable(PgRule rule) {
        return event == rule.event
                && Objects.equals(condition, rule.condition)
                && instead == rule.instead
                && commands.equals(rule.commands);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(event);
        hasher.put(condition);
        hasher.put(instead);
        hasher.put(commands);
        hasher.put(enabledState);
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) parent.getParent();
    }

    @Override
    public boolean isSubElement() {
        return true;
    }
}
