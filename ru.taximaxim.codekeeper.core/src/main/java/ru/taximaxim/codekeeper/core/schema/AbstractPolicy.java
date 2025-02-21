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
package ru.taximaxim.codekeeper.core.schema;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public abstract class AbstractPolicy extends PgStatement {

    protected EventType event;
    protected final Set<String> roles = new LinkedHashSet<>();
    protected String using;
    protected boolean isPermissive = true;

    protected AbstractPolicy(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.POLICY;
    }

    public void setEvent(EventType event) {
        this.event = event;
        resetHash();
    }

    public void addRole(String role) {
        roles.add(role);
        resetHash();
    }

    public void setUsing(String using) {
        this.using = using;
        resetHash();
    }

    public void setPermissive(boolean isPermissive) {
        this.isPermissive = isPermissive;
        resetHash();
    }

    @Override
    public AbstractPolicy shallowCopy() {
        AbstractPolicy copy = getPolicyCopy();
        copyBaseFields(copy);
        copy.setPermissive(isPermissive);
        copy.setEvent(event);
        copy.roles.addAll(roles);
        copy.setUsing(using);
        return copy;
    }

    protected abstract AbstractPolicy getPolicyCopy();

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(isPermissive);
        hasher.put(event);
        hasher.put(roles);
        hasher.put(using);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractPolicy police && super.compare(obj)) {
            return isPermissive == police.isPermissive
                    && event == police.event
                    && roles.equals(police.roles)
                    && Objects.equals(using, police.using);
        }

        return false;
    }
}
