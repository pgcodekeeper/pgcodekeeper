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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.Collection;
import java.util.Collections;
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

public class ChDatabase extends AbstractDatabase {

    private final Map<String, ChFunction> functions = new LinkedHashMap<>();
    private final Map<String, ChPolicy> policies = new LinkedHashMap<>();
    private final Map<String, ChUser> users = new LinkedHashMap<>();

    public ChDatabase(PgDiffArguments arguments) {
        super(arguments);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(functions.values());
        l.add(policies.values());
        l.add(users.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case SCHEMA:
            return getSchema(name);
        case FUNCTION:
            return getFunction(name);
        case POLICY:
            return getPolicy(name);
        case USER:
            return getUser(name);
        default:
            return null;
        }
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
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    /**
     * Returns function of given name or null if the extension has not been found.
     *
     * @param name
     *            function name
     *
     * @return found function or null
     */
    public ChFunction getFunction(final String name) {
        return functions.get(name);
    }

    /**
     * Getter for {@link #functions}. The list cannot be modified.
     *
     * @return {@link #functions}
     */
    public Collection<ChFunction> getFunctions() {
        return Collections.unmodifiableCollection(functions.values());
    }

    public void addFunction(final ChFunction function) {
        addUnique(functions, function);
    }

    /**
     * Finds policy according to specified policy {@code name}.
     *
     * @param name
     *            name of the policy to be searched
     *
     * @return found policy or null if no such policy has been found
     */
    public ChPolicy getPolicy(final String name) {
        return policies.get(name);
    }

    /**
     * Getter for {@link #policies}. The list cannot be modified.
     *
     * @return {@link #policies}
     */
    public Collection<ChPolicy> getPolicies() {
        return Collections.unmodifiableCollection(policies.values());
    }

    public void addPolicy(final ChPolicy policy) {
        addUnique(policies, policy);
    }

    /**
     * Returns user of given name or null if the user has not been found.
     *
     * @param name
     *            user name
     *
     * @return found user or null
     */
    public ChUser getUser(final String name) {
        return users.get(name);
    }

    /**
     * Getter for {@link #users}. The list cannot be modified.
     *
     * @return {@link #users}
     */
    public Collection<ChUser> getUsers() {
        return Collections.unmodifiableCollection(users.values());
    }

    public void addUser(final ChUser user) {
        addUnique(users, user);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof ChDatabase && super.compareChildren(obj)) {
            ChDatabase db = (ChDatabase) obj;
            return functions.equals(db.functions)
                    && users.equals(db.users)
                    && policies.equals(db.policies);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(functions);
        hasher.putUnordered(users);
        hasher.putUnordered(policies);
    }

    @Override
    protected boolean isFirstLevelType(DbObjType type) {
        return type.in(DbObjType.SCHEMA, DbObjType.POLICY, DbObjType.FUNCTION, DbObjType.USER);
    }

    @Override
    protected AbstractDatabase getDatabaseCopy() {
        return new ChDatabase(getArguments());
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }
}