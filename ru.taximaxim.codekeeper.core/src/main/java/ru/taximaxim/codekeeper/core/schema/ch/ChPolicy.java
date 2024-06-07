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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractPolicy;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class ChPolicy extends AbstractPolicy {

    private final Set<String> excepts = new LinkedHashSet<>();

    public ChPolicy(String name) {
        super(name);
    }

    public void addExcept(String except) {
        this.excepts.add(except);
        resetHash();
    }

    public Set<String> getExcepts() {
        return Collections.unmodifiableSet(excepts);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        appendFullSQL(sbSQL, true);
        return sbSQL.toString();
    }

    private void appendFullSQL(StringBuilder sbSQL, boolean isCreate) {
        sbSQL.append(isCreate ? "CREATE" : "ALTER").append(" POLICY ");

        if (isCreate) {
            appendIfNotExists(sbSQL);
        }

        sbSQL.append(name);

        if (event != null) {
            sbSQL.append("\n  FOR ").append(event);
        }

        if (using != null && !using.isEmpty()) {
            sbSQL.append("\n  USING ").append(using);
        }

        if (!isPermissive()) {
            sbSQL.append("\n  AS RESTRICTIVE");
        }

        if (!roles.isEmpty()) {
            sbSQL.append("\n  TO ");
            sbSQL.append(String.join(", ", roles));
        } else if (!excepts.isEmpty() || !isCreate) {
            sbSQL.append("\n  TO ALL");
        }

        if (!excepts.isEmpty()) {
            sbSQL.append(" EXCEPT ").append(String.join(", ", excepts));
        }

        sbSQL.append(getSeparator());
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        if (!compare(newCondition)) {
            ((ChPolicy) newCondition).appendFullSQL(sb, false);
            return true;
        }

        return false;
    }

    @Override
    public String getQualifiedName() {
        return name;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(excepts);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof ChPolicy && super.compare(obj)) {
            ChPolicy police = (ChPolicy) obj;
            return Objects.equals(excepts, police.excepts);
        }

        return false;
    }

    @Override
    protected AbstractPolicy getPolicyCopy() {
        ChPolicy policy = new ChPolicy(getName());
        policy.excepts.addAll(excepts);
        return policy;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) getParent();
    }
}
