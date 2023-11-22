/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import java.util.Collection;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.hashers.IHashable;
import ru.taximaxim.codekeeper.core.hashers.JavaHasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class PgPrivilege implements IHashable {

    public static final String WITH_GRANT_OPTION = " WITH GRANT OPTION";

    private final String state;
    private final String permission;
    private final String role;
    private final String name;
    private final boolean isGrantOption;

    public boolean isRevoke() {
        return "REVOKE".equalsIgnoreCase(getState());
    }

    public PgPrivilege(String state, String permission, String name, String role, boolean isGrantOption) {
        this.state = state;
        this.permission = permission;
        this.name = name;
        this.role = role;
        this.isGrantOption = isGrantOption;
    }

    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append(state).append(' ').append(permission);
        if (name != null) {
            sb.append(" ON ").append(getName());
        }

        sb.append(isRevoke() ? " FROM ": " TO ").append(getRole());

        if (isGrantOption) {
            sb.append(isRevoke() ? " CASCADE" : WITH_GRANT_OPTION);
        }

        return sb.toString();
    }

    public String getDropSQL() {
        if (isRevoke()) {
            return null;
        }

        return new PgPrivilege("REVOKE", permission, name, role, isGrantOption).getCreationSQL();
    }

    public static StringBuilder appendPrivileges(Collection<PgPrivilege> privileges,
            DatabaseType dbType, StringBuilder sb) {
        if (privileges.isEmpty()) {
            return sb;
        }

        if (sb.length() != 0) {
            sb.append("\n\n");
        }

        for (PgPrivilege priv : privileges) {
            sb.append(priv.getCreationSQL()).append(dbType == DatabaseType.PG ? ';' : PgStatement.GO).append('\n');
        }

        sb.setLength(sb.length() - 1);

        return sb;
    }

    public static StringBuilder appendDefaultPostgresPrivileges(PgStatement newObj, StringBuilder sb) {
        DbObjType type = newObj.getStatementType();
        boolean isFunctionOrTypeOrDomain = false;
        String typeName;
        switch (type) {
        case FUNCTION:
        case PROCEDURE:
        case TYPE:
        case DOMAIN:
            isFunctionOrTypeOrDomain = true;
            typeName = type.name();
            break;
        case AGGREGATE:
            isFunctionOrTypeOrDomain = true;
            typeName = DbObjType.FUNCTION.name();
            break;
        case FOREIGN_DATA_WRAPPER:
            typeName = "FOREIGN DATA WRAPPER";
            break;
        case SERVER:
            typeName = "FOREIGN SERVER";
            break;
        case VIEW:
            typeName = DbObjType.TABLE.name();
            break;
        case SCHEMA:
        case SEQUENCE:
        case TABLE:
            typeName = type.name();
            break;
        default:
            return sb;
        }

        StringBuilder sbName = new StringBuilder()
                .append(typeName)
                .append(' ');
        if (newObj instanceof AbstractPgFunction) {
            AbstractPgFunction func = (AbstractPgFunction) newObj;
            sbName.append(PgDiffUtils.getQuotedName(func.getParent().getName()))
            .append('.');
            func.appendFunctionSignature(sbName, false, true);
        } else {
            sbName.append(newObj.getQualifiedName());
        }
        String name = sbName.toString();

        // FUNCTION/PROCEDURE/AGGREGATE/TYPE/DOMAIN by default has "GRANT ALL to PUBLIC".
        // That's why for them set "GRANT ALL to PUBLIC".
        PgPrivilege priv = new PgPrivilege(isFunctionOrTypeOrDomain ? "GRANT" : "REVOKE",
                "ALL", name, "PUBLIC", false);
        sb.append('\n').append(priv.getCreationSQL()).append(';');

        String owner = newObj.getOwner();
        if (owner == null) {
            return sb;
        }
        owner = PgDiffUtils.getQuotedName(owner);

        priv = new PgPrivilege("REVOKE", "ALL", name, owner, false);
        sb.append('\n').append(priv.getCreationSQL()).append(';');

        priv = new PgPrivilege("GRANT", "ALL", name, owner, false);
        sb.append('\n').append(priv.getCreationSQL()).append(';');

        return sb;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgPrivilege) {
            PgPrivilege priv = (PgPrivilege) obj;
            eq = isGrantOption == priv.isGrantOption()
                    && Objects.equals(state, priv.getState())
                    && Objects.equals(permission, priv.getPermission())
                    && Objects.equals(role, priv.getRole())
                    && Objects.equals(name, priv.getName());
        }

        return eq;
    }

    @Override
    public int hashCode() {
        JavaHasher hasher = new JavaHasher();
        computeHash(hasher);
        return hasher.getResult();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(state);
        hasher.put(permission);
        hasher.put(role);
        hasher.put(name);
        hasher.put(isGrantOption);
    }

    @Override
    public String toString() {
        return getCreationSQL();
    }

    public String getState() {
        return state;
    }

    public String getPermission() {
        return permission;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public boolean isGrantOption() {
        return isGrantOption;
    }
}
