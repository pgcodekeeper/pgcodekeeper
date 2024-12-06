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

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class MsRole extends PgStatement {

    private final Set<String> members = new LinkedHashSet<>();

    public MsRole(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.ROLE;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) getParent();
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ROLE ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        if (owner != null) {
            sbSQL.append("\nAUTHORIZATION ").append(MsDiffUtils.quoteName(owner));
        }
        script.addStatement(sbSQL);

        for (String member : members) {
            appendAlterRole(member, script, true);
        }

        appendPrivileges(script);
    }

    @Override
    public void getDropSQL(SQLScript script, boolean optionExists) {
        for (String member : members) {
            appendAlterRole(member, script, false);
        }
        super.getDropSQL(script, optionExists);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, AtomicBoolean isNeedDepcies, SQLScript script) {
        int startSize = script.getSize();
        MsRole newRole = (MsRole) newCondition;

        appendAlterOwner(newRole, script);

        if (!Objects.equals(members, newRole.members)) {
            for (String newMember : newRole.members) {
                if (!members.contains(newMember)) {
                    appendAlterRole(newMember, script, true);
                }
            }

            for (String oldMember : members) {
                if (!newRole.members.contains(oldMember)) {
                    appendAlterRole(oldMember, script, false);
                }
            }
        }

        alterPrivileges(newRole, script);

        return getObjectState(script, startSize);
    }

    public void appendAlterRole(String member, SQLScript script, boolean needAddMember) {
        StringBuilder sql = new StringBuilder();
        sql.append("ALTER ROLE ").append(MsDiffUtils.quoteName(getName()));
        sql.append(needAddMember ? " ADD " : " DROP ").append("MEMBER ").append(MsDiffUtils.quoteName(member));
        script.addStatement(sql);
    }

    public void addMember(String member) {
        members.add(member);
        resetHash();
    }

    public Set<String> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(members);
    }

    @Override
    public MsRole shallowCopy() {
        MsRole roleDst = new MsRole(getName());
        copyBaseFields(roleDst);
        roleDst.members.addAll(members);
        return roleDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj == this) {
            return true;
        }

        return obj instanceof MsRole role && super.compare(obj)
                && Objects.equals(members, role.members);
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
