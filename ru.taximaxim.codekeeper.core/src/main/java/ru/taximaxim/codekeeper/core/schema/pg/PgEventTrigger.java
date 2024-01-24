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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class PgEventTrigger extends PgStatement {

    private String executable;
    private final List<String> tags = new ArrayList<>();
    private String event;
    private String mode;

    public PgEventTrigger(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
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
        sb.append("\n\tEXECUTE PROCEDURE ").append(executable).append(";");
        if (mode != null) {
            sb.append("\n\nALTER EVENT TRIGGER ").append(getQualifiedName()).append(" ").append(mode).append(";");
        }
        appendOwnerSQL(sb);

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        PgEventTrigger newEventTrigger = (PgEventTrigger) newCondition;
        if (!Objects.equals(getExecutable(), newEventTrigger.getExecutable())
                || !Objects.equals(getTags(), newEventTrigger.getTags())
                || !Objects.equals(getEvent(), newEventTrigger.getEvent())) {
            isNeedDepcies.set(true);
            return true;
        }

        final int startLength = sb.length();
        if (!Objects.equals(getMode(), newEventTrigger.getMode())) {
            sb.append("\nALTER EVENT TRIGGER ").append(getQualifiedName())
            .append(" ").append(newEventTrigger.getMode());
        }
        if (!Objects.equals(getOwner(), newEventTrigger.getOwner())) {
            newEventTrigger.appendOwnerSQL(sb);
        }
        compareComments(sb, newEventTrigger);

        return sb.length() > startLength;
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
        if (obj instanceof PgEventTrigger && super.compare(obj)) {
            PgEventTrigger newEventTrigger = (PgEventTrigger) obj;
            return Objects.equals(executable, newEventTrigger.executable)
                    && Objects.equals(tags, newEventTrigger.tags)
                    && Objects.equals(event, newEventTrigger.event)
                    && Objects.equals(mode, newEventTrigger.mode);
        }

        return false;
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase) getParent();
    }

    @Override
    public PgStatement shallowCopy() {
        PgEventTrigger evt = new PgEventTrigger(getName());
        copyBaseFields(evt);
        evt.setEvent(getEvent());
        evt.setExecutable(getExecutable());
        evt.tags.addAll(tags);
        evt.setMode(getMode());

        return evt;
    }

    public String getExecutable() {
        return executable;
    }

    public void setExecutable(String executable) {
        this.executable = executable;
        resetHash();
    }

    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    }

    public void addTag(String tag) {
        this.tags.add(tag);
        resetHash();
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
        resetHash();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
        resetHash();
    }
}
