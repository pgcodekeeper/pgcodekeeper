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
package ru.taximaxim.codekeeper.core.schema.ms;

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

/**
 * Stores database information.
 *
 * @author fordfrog
 */
public class MsDatabase extends AbstractDatabase {

    private final Map<String, MsAssembly> assemblies = new LinkedHashMap<>();
    private final Map<String, MsRole> roles = new LinkedHashMap<>();
    private final Map<String, MsUser> users = new LinkedHashMap<>();

    public MsDatabase(PgDiffArguments arguments) {
        super(arguments);
    }
    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(assemblies.values());
        l.add(roles.values());
        l.add(users.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case SCHEMA:
            return getSchema(name);
        case ASSEMBLY:
            return getAssembly(name);
        case ROLE:
            return getRole(name);
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
        case ASSEMBLY:
            addAssembly((MsAssembly) st);
            break;
        case ROLE:
            addRole((MsRole) st);
            break;
        case USER:
            addUser((MsUser) st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    /**
     * Returns assembly of given name or null if the assembly has not been found.
     *
     * @param name
     *            assembly name
     *
     * @return found assembly or null
     */
    public MsAssembly getAssembly(final String name) {
        return assemblies.get(name);
    }

    /**
     * Returns role of given name or null if the role has not been found.
     *
     * @param name
     *            role name
     *
     * @return found role or null
     */
    public MsRole getRole(final String name) {
        return roles.get(name);
    }

    /**
     * Returns user of given name or null if the user has not been found.
     *
     * @param name
     *            user name
     *
     * @return found user or null
     */
    public MsUser getUser(final String name) {
        return users.get(name);
    }

    /**
     * Getter for {@link #assemblies}. The list cannot be modified.
     *
     * @return {@link #assemblies}
     */
    public Collection<MsAssembly> getAssemblies() {
        return Collections.unmodifiableCollection(assemblies.values());
    }

    /**
     * Getter for {@link #roles}. The list cannot be modified.
     *
     * @return {@link #roles}
     */
    public Collection<MsRole> getRoles() {
        return Collections.unmodifiableCollection(roles.values());
    }

    /**
     * Getter for {@link #users}. The list cannot be modified.
     *
     * @return {@link #users}
     */
    public Collection<MsUser> getUsers() {
        return Collections.unmodifiableCollection(users.values());
    }

    public void addAssembly(final MsAssembly assembly) {
        addUnique(assemblies, assembly);
    }

    public void addRole(final MsRole role) {
        addUnique(roles, role);
    }

    public void addUser(final MsUser user) {
        addUnique(users, user);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof MsDatabase && super.compareChildren(obj)) {
            MsDatabase db = (MsDatabase) obj;
            return assemblies.equals(db.assemblies)
                    && roles.equals(db.roles)
                    && users.equals(db.users);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(assemblies);
        hasher.putUnordered(roles);
        hasher.putUnordered(users);
    }

    @Override
    protected boolean isFirstLevelType(DbObjType type) {
        return type.in(DbObjType.SCHEMA, DbObjType.USER, DbObjType.ROLE, DbObjType.ASSEMBLY);
    }

    @Override
    protected AbstractDatabase getDatabaseCopy() {
        return new MsDatabase(getArguments());
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}