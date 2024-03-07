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
import ru.taximaxim.codekeeper.core.schema.PgStatement;

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
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ROLE ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        if (owner != null) {
            sbSQL.append("\nAUTHORIZATION ").append(MsDiffUtils.quoteName(owner));
        }
        sbSQL.append(GO);

        for (String member : members) {
            sbSQL.append("\nALTER ROLE ").append(MsDiffUtils.quoteName(getName()));
            sbSQL.append(" ADD MEMBER ").append(MsDiffUtils.quoteName(member));
            sbSQL.append(GO);
        }

        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        StringBuilder sb = new StringBuilder();

        for (String member : members) {
            sb.append("ALTER ROLE ").append(MsDiffUtils.quoteName(name));
            sb.append(" DROP MEMBER ").append(MsDiffUtils.quoteName(member));
            sb.append(GO).append('\n');
        }
        sb.append(super.getDropSQL(optionExists));
        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsRole newRole = (MsRole) newCondition;

        if (!Objects.equals(getOwner(), newRole.getOwner())) {
            newRole.alterOwnerSQL(sb);
        }

        if (!Objects.equals(members, newRole.members)) {
            for (String newMember : newRole.members) {
                if (!members.contains(newMember)) {
                    sb.append("\nALTER ROLE ").append(MsDiffUtils.quoteName(getName()));
                    sb.append(" ADD MEMBER ").append(MsDiffUtils.quoteName(newMember));
                    sb.append(GO);
                }
            }

            for (String oldMember : members) {
                if (!newRole.members.contains(oldMember)) {
                    sb.append("\nALTER ROLE ").append(MsDiffUtils.quoteName(getName()));
                    sb.append(" DROP MEMBER ").append(MsDiffUtils.quoteName(oldMember));
                    sb.append(GO);
                }
            }
        }

        alterPrivileges(newRole, sb);

        return sb.length() > startLength;
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

        return obj instanceof MsRole && super.compare(obj)
                && Objects.equals(members, ((MsRole) obj).members);
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
