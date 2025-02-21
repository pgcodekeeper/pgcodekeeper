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

import java.util.Collection;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.hashers.IHashable;
import ru.taximaxim.codekeeper.core.hashers.JavaHasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgFunction;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class PgPrivilege implements IHashable {

    private static final String WITH_GRANT_OPTION = " WITH GRANT OPTION";

    private final String state;
    private final String permission;
    private final String role;
    private final String name;
    private final boolean isGrantOption;
    private final DatabaseType dbType;

    public boolean isRevoke() {
        return "REVOKE".equalsIgnoreCase(state);
    }

    public PgPrivilege(String state, String permission, String name, String role, boolean isGrantOption, DatabaseType dbType) {
        this.state = state;
        this.permission = permission;
        this.name = name;
        this.role = role;
        this.isGrantOption = isGrantOption;
        this.dbType = dbType;
    }

    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append(state).append(' ').append(permission);
        if (name != null) {
            sb.append(" ON ").append(name);
        }

        sb.append(isRevoke() ? " FROM ": " TO ").append(role);

        if (isGrantOption) {
            String cascade = dbType == DatabaseType.CH ? "" : " CASCADE";
            sb.append(isRevoke() ? cascade : WITH_GRANT_OPTION);
        }

        return sb.toString();
    }

    public String getDropSQL() {
        if (isRevoke()) {
            return null;
        }

        return new PgPrivilege("REVOKE", permission, name, role, isGrantOption, dbType).getCreationSQL();
    }

    public static void appendPrivileges(Collection<PgPrivilege> privileges, SQLScript script) {
        for (PgPrivilege priv : privileges) {
            script.addStatement(priv.getCreationSQL());
        }
    }

    public static void appendDefaultPostgresPrivileges(PgStatement newObj, SQLScript script) {
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
            return;
        }

        StringBuilder sbName = new StringBuilder()
                .append(typeName)
                .append(' ');
        if (newObj instanceof AbstractPgFunction func) {
            sbName.append(PgDiffUtils.getQuotedName(func.parent.getName()))
            .append('.');
            func.appendFunctionSignature(sbName, false, true);
        } else {
            sbName.append(newObj.getQualifiedName());
        }
        String name = sbName.toString();

        // FUNCTION/PROCEDURE/AGGREGATE/TYPE/DOMAIN by default has "GRANT ALL to PUBLIC".
        // That's why for them set "GRANT ALL to PUBLIC".
        PgPrivilege priv = new PgPrivilege(isFunctionOrTypeOrDomain ? "GRANT" : "REVOKE",
                "ALL", name, "PUBLIC", false, DatabaseType.PG);
        script.addStatement(priv.getCreationSQL());

        String owner = newObj.owner;
        if (owner == null) {
            return;
        }
        owner = PgDiffUtils.getQuotedName(owner);

        addDefPostgresPrivileges(script, "REVOKE", name, owner);
        addDefPostgresPrivileges(script, "GRANT", name, owner);
    }

    private static void addDefPostgresPrivileges(SQLScript script, String state, String name, String owner) {
        PgPrivilege priv = new PgPrivilege(state, "ALL", name, owner, false, DatabaseType.PG);
        script.addStatement(priv.getCreationSQL());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgPrivilege priv) {
            return isGrantOption == priv.isGrantOption
                    && Objects.equals(state, priv.state)
                    && Objects.equals(permission, priv.permission)
                    && Objects.equals(role, priv.role)
                    && Objects.equals(name, priv.name);
        }

        return false;
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

    public String getPermission() {
        return permission;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}
