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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class ChDatabase extends AbstractDatabase {

    private final Map<String, ChFunction> functions = new LinkedHashMap<>();
    private final Map<String, ChPolicy> policies = new LinkedHashMap<>();
    private final Map<String, ChUser> users = new LinkedHashMap<>();
    private final Map<String, ChRole> roles = new LinkedHashMap<>();

    public ChDatabase(PgDiffArguments arguments) {
        super(arguments);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(functions.values());
        l.add(policies.values());
        l.add(users.values());
        l.add(roles.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        return switch (type) {
            case SCHEMA -> getSchema(name);
            case FUNCTION -> getChildByName(functions, name);
            case POLICY -> getChildByName(policies, name);
            case USER -> getChildByName(users, name);
            case ROLE -> getChildByName(roles, name);
            default -> null;
        };
    }

    @Override
    public void addChild(IStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case SCHEMA:
            addSchema((AbstractSchema) st);
            break;
        case FUNCTION:
            addFunction((ChFunction) st);
            break;
        case POLICY:
            addPolicy((ChPolicy) st);
            break;
        case USER:
            addUser((ChUser) st);
            break;
        case ROLE:
            addRole((ChRole) st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    private void addFunction(final ChFunction function) {
        addUnique(functions, function);
    }

    private void addPolicy(final ChPolicy policy) {
        addUnique(policies, policy);
    }

    private void addUser(final ChUser user) {
        addUnique(users, user);
    }

    private void addRole(final ChRole role) {
        addUnique(roles, role);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof ChDatabase db && super.compareChildren(obj)) {
            return functions.equals(db.functions)
                    && users.equals(db.users)
                    && roles.equals(db.roles)
                    && policies.equals(db.policies);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(functions);
        hasher.putUnordered(users);
        hasher.putUnordered(roles);
        hasher.putUnordered(policies);
    }

    @Override
    protected boolean isFirstLevelType(DbObjType type) {
        return type.in(DbObjType.SCHEMA, DbObjType.POLICY, DbObjType.FUNCTION, DbObjType.USER, DbObjType.ROLE);
    }

    @Override
    protected AbstractDatabase getDatabaseCopy() {
        return new ChDatabase(arguments);
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }
}
