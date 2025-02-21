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

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class PgEventTrigger extends PgStatement {

    private String executable;
    private final List<String> tags = new ArrayList<>();
    private String event;
    private String mode;

    public PgEventTrigger(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE EVENT TRIGGER ")
        .append(getQualifiedName())
        .append("\n\tON ").append(event);
        if (!tags.isEmpty()) {
            sb.append("\n\tWHEN TAG IN (");
            for (String tag : tags) {
                sb.append(tag).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(")");
        }
        sb.append("\n\tEXECUTE PROCEDURE ").append(executable);
        script.addStatement(sb);

        if (mode != null) {
            StringBuilder sql = new StringBuilder();
            sql.append("ALTER EVENT TRIGGER ").append(getQualifiedName()).append(" ").append(mode);
            script.addStatement(sql);
        }
        appendOwnerSQL(script);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgEventTrigger newEventTrigger = (PgEventTrigger) newCondition;
        if (!Objects.equals(executable, newEventTrigger.executable)
                || !Objects.equals(tags, newEventTrigger.tags)
                || !Objects.equals(event, newEventTrigger.event)) {
            return ObjectState.RECREATE;
        }

        if (!Objects.equals(mode, newEventTrigger.mode)) {
            StringBuilder sql = new StringBuilder();
            sql.append("ALTER EVENT TRIGGER ").append(getQualifiedName())
            .append(" ").append(newEventTrigger.mode);
            script.addStatement(sql);
        }

        appendAlterOwner(newEventTrigger, script);
        appendAlterComments(newEventTrigger, script);
        return getObjectState(script, startSize);
    }

    @Override
    public String getTypeName() {
        return "EVENT TRIGGER";
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.EVENT_TRIGGER;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(executable);
        hasher.put(tags);
        hasher.put(event);
        hasher.put(mode);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PgEventTrigger newEventTrigger && super.compare(obj)) {
            return Objects.equals(executable, newEventTrigger.executable)
                    && Objects.equals(tags, newEventTrigger.tags)
                    && Objects.equals(event, newEventTrigger.event)
                    && Objects.equals(mode, newEventTrigger.mode);
        }

        return false;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) parent;
    }

    @Override
    public PgStatement shallowCopy() {
        PgEventTrigger evt = new PgEventTrigger(name);
        copyBaseFields(evt);
        evt.setEvent(event);
        evt.setExecutable(executable);
        evt.tags.addAll(tags);
        evt.setMode(mode);

        return evt;
    }

    public void setExecutable(String executable) {
        this.executable = executable;
        resetHash();
    }

    public void addTag(String tag) {
        this.tags.add(tag);
        resetHash();
    }

    public void setEvent(String event) {
        this.event = event;
        resetHash();
    }

    public void setMode(String mode) {
        this.mode = mode;
        resetHash();
    }
}
