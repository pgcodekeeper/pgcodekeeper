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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.AbstractAnalysisLauncher;

/**
 * Stores database information.
 *
 * @author fordfrog
 */
public class PgDatabase extends PgStatement implements IDatabase {
    /**
     * Current default schema.
     */
    private AbstractSchema defaultSchema;

    private final Map<String, AbstractSchema> schemas = new LinkedHashMap<>();
    private final Map<String, PgExtension> extensions = new LinkedHashMap<>();
    private final Map<String, PgForeignDataWrapper> fdws = new LinkedHashMap<>();
    private final Map<String, PgServer> servers = new LinkedHashMap<>();
    private final Map<String, PgUserMapping> userMappings = new LinkedHashMap<>();
    private final Map<String, PgCast> casts = new LinkedHashMap<>();
    private final Map<String, MsAssembly> assemblies = new LinkedHashMap<>();
    private final Map<String, MsRole> roles = new LinkedHashMap<>();
    private final Map<String, MsUser> users = new LinkedHashMap<>();

    // Содержит ссылки на объекты
    private final Map<String, Set<PgObjLocation>> objReferences = new HashMap<>();
    // Contains analysis launchers for all statements
    // (used for launch analyze and getting dependencies).
    private final ArrayList<AbstractAnalysisLauncher> analysisLaunchers = new ArrayList<>();

    private PgDiffArguments arguments;

    private final List<PgOverride> overrides = new ArrayList<>();

    private SupportedVersion postgresVersion;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.DATABASE;
    }

    public PgDatabase() {
        super("DB_name_placeholder");
    }

    public PgDatabase(PgDiffArguments arguments) {
        this();
        this.arguments = arguments;
    }

    public void setDefaultSchema(final String name) {
        defaultSchema = getSchema(name);
    }

    public AbstractSchema getDefaultSchema() {
        return defaultSchema;
    }

    public void setArguments(PgDiffArguments arguments) {
        this.arguments = arguments;
    }

    public PgDiffArguments getArguments() {
        return arguments;
    }

    public Map<String, Set<PgObjLocation>> getObjReferences() {
        return objReferences;
    }

    public Set<PgObjLocation> getObjReferences(String name) {
        return objReferences.getOrDefault(name, Collections.emptySet());
    }

    public void addReference(String fileName, PgObjLocation loc) {
        objReferences.computeIfAbsent(fileName, k -> new LinkedHashSet<>()).add(loc);
    }

    public List<AbstractAnalysisLauncher> getAnalysisLaunchers() {
        return analysisLaunchers;
    }

    public void clearAnalysisLaunchers() {
        analysisLaunchers.clear();
        analysisLaunchers.trimToSize();
    }

    /**
     * Add 'analysis launcher' for deferred analyze.
     *
     * @param launcher launcher that contains almost everything needed to
     * analyze an statement contained in it
     */
    public void addAnalysisLauncher(AbstractAnalysisLauncher launcher) {
        analysisLaunchers.add(launcher);
    }

    public SupportedVersion getPostgresVersion() {
        return postgresVersion != null ? postgresVersion : SupportedVersion.VERSION_10;
    }

    public void setPostgresVersion(SupportedVersion postgresVersion) {
        this.postgresVersion = postgresVersion;
    }

    public List<PgOverride> getOverrides() {
        return overrides;
    }

    @Override
    public PgDatabase getDatabase() {
        return this;
    }

    /**
     * Returns schema of given name or null if the schema has not been found. If
     * schema name is null then default schema is returned.
     *
     * @param name schema name or null which means default schema
     *
     * @return found schema or null
     */
    @Override
    public AbstractSchema getSchema(final String name) {
        if (name == null) {
            return getDefaultSchema();
        }

        return schemas.get(name);
    }

    /**
     * Getter for {@link #schemas}. The list cannot be modified.
     *
     * @return {@link #schemas}
     */
    @Override
    public Collection<AbstractSchema> getSchemas() {
        return Collections.unmodifiableCollection(schemas.values());
    }

    public void addSchema(final AbstractSchema schema) {
        addUnique(schemas, schema);
    }

    public boolean containsExtension(final String name) {
        return getExtension(name) != null;
    }

    public boolean containsAssembly(final String name) {
        return getAssembly(name) != null;
    }

    public boolean containsSchema(final String name) {
        return getSchema(name) != null;
    }

    @Override
    protected void fillDescendantsList(List<Collection<? extends PgStatement>> l) {
        fillChildrenList(l);
        for (AbstractSchema schema : schemas.values()) {
            schema.fillDescendantsList(l);
        }
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        l.add(schemas.values());
        l.add(extensions.values());
        l.add(fdws.values());
        l.add(servers.values());
        l.add(userMappings.values());
        l.add(casts.values());
        l.add(assemblies.values());
        l.add(roles.values());
        l.add(users.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case SCHEMA:
            return getSchema(name);
        case EXTENSION:
            return getExtension(name);
        case FOREIGN_DATA_WRAPPER:
            return getForeignDW(name);
        case SERVER:
            return getServer(name);
        case USER_MAPPING:
            return getUserMapping(name);
        case CAST:
            return getCast(name);
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
    public void addChild(PgStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case SCHEMA:
            addSchema((AbstractSchema) st);
            break;
        case EXTENSION:
            addExtension((PgExtension) st);
            break;
        case FOREIGN_DATA_WRAPPER:
            addForeignDW((PgForeignDataWrapper) st);
            break;
        case SERVER:
            addServer((PgServer) st);
            break;
        case CAST:
            addCast((PgCast) st);
            break;
        case USER_MAPPING:
            addUserMapping((PgUserMapping) st);
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
     * Returns extension of given name or null if the extension has not been found.
     *
     * @param name extension name
     *
     * @return found extension or null
     */
    public PgExtension getExtension(final String name) {
        return extensions.get(name);
    }

    /**
     * Getter for {@link #extensions}. The list cannot be modified.
     *
     * @return {@link #extensions}
     */
    public Collection<PgExtension> getExtensions() {
        return Collections.unmodifiableCollection(extensions.values());
    }

    public void addExtension(final PgExtension extension) {
        addUnique(extensions, extension);
    }

    /**
     * Returns foreign data wrapper of given name or null if the foreign data wrapper has not been found.
     *
     * @param name foreign data wrapper name
     *
     * @return found foreign data wrapper or null
     */
    public PgForeignDataWrapper getForeignDW(final String name) {
        return fdws.get(name);
    }

    /**
     * Getter for {@link #fdws}. The list cannot be modified.
     *
     * @return {@link #fdws}
     */
    public Collection<PgForeignDataWrapper> getForeignDWs() {
        return Collections.unmodifiableCollection(fdws.values());
    }

    public void addForeignDW(final PgForeignDataWrapper fDW) {
        addUnique(fdws, fDW);
    }

    public PgServer getServer(final String name) {
        return servers.get(name);
    }

    public Collection<PgServer> getServers() {
        return Collections.unmodifiableCollection(servers.values());
    }

    public void addServer(final PgServer server) {
        addUnique(servers, server);
    }

    public PgUserMapping getUserMapping(final String name) {
        return userMappings.get(name);
    }

    public Collection<PgUserMapping> getUserMappings() {
        return Collections.unmodifiableCollection(userMappings.values());
    }

    public void addUserMapping(final PgUserMapping userMapping) {
        addUnique(userMappings, userMapping);
    }

    /**
     * Returns cast of given name or null if the cast has not been found.
     *
     * @param name cast name
     *
     * @return found cast or null
     */
    @Override
    public PgCast getCast(final String name) {
        return casts.get(name);
    }

    /**
     * Getter for {@link #casts}. The list cannot be modified.
     *
     * @return {@link #casts}
     */
    @Override
    public Collection<PgCast> getCasts() {
        return Collections.unmodifiableCollection(casts.values());
    }

    public void addCast(final PgCast cast) {
        addUnique(casts, cast);
    }

    /**
     * Returns assembly of given name or null if the assembly has not been found.
     *
     * @param name assembly name
     *
     * @return found assembly or null
     */
    public MsAssembly getAssembly(final String name) {
        return assemblies.get(name);
    }

    /**
     * Returns role of given name or null if the role has not been found.
     *
     * @param name role name
     *
     * @return found role or null
     */
    public MsRole getRole(final String name) {
        return roles.get(name);
    }

    /**
     * Returns user of given name or null if the user has not been found.
     *
     * @param name user name
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

    public void sortColumns() {
        if (isPostgres()) {
            for (AbstractSchema schema : schemas.values()) {
                schema.getTables().forEach(t -> ((AbstractPgTable) t).sortColumns());
            }
        }
    }

    @Override
    public String getCreationSQL() {
        return null;
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        return null;
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();

        if (!Objects.equals(getComment(), newCondition.getComment())) {
            newCondition.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    @Override
    protected StringBuilder appendFullName(StringBuilder sb) {
        return sb.append("current_database()");
    }

    @Override
    public boolean compare(PgStatement obj) {
        return obj instanceof PgDatabase && super.compare(obj);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof PgDatabase) {
            PgDatabase db = (PgDatabase) obj;
            return extensions.equals(db.extensions)
                    && fdws.equals(db.fdws)
                    && servers.equals(db.servers)
                    && casts.equals(db.casts)
                    && schemas.equals(db.schemas)
                    && assemblies.equals(db.assemblies)
                    && roles.equals(db.roles)
                    && users.equals(db.users);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        // has only child objects
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(extensions);
        hasher.putUnordered(fdws);
        hasher.putUnordered(servers);
        hasher.putUnordered(casts);
        hasher.putUnordered(schemas);
        hasher.putUnordered(assemblies);
        hasher.putUnordered(roles);
        hasher.putUnordered(users);
    }

    @Override
    public PgDatabase shallowCopy() {
        PgDatabase dbDst = new PgDatabase(getArguments());
        copyBaseFields(dbDst);
        dbDst.setPostgresVersion(getPostgresVersion());
        return dbDst;
    }

    public void addLib(PgDatabase lib, String libName, String owner) {
        lib.getDescendants().forEach(st -> {
            // do not override dependent library name
            if (libName != null && st.getLibName() == null) {
                st.setLibName(libName);
            }
            if (st.isOwned() && owner != null && !owner.isEmpty()) {
                st.setOwner(owner);
            }
            concat(st);
        });

        lib.analysisLaunchers.stream()
        .filter(st -> st.getStmt().getParent() != null)
        .forEach(l -> {
            l.updateStmt(this);
            analysisLaunchers.add(l);
        });

        overrides.addAll(lib.getOverrides());
    }

    private void concat(PgStatement st) {
        DbObjType type = st.getStatementType();
        String name = st.getName();
        PgStatement parent = st.getParent();
        String parentName = parent.getName();
        PgStatement orig = null;
        switch (type) {
        case USER:
        case ROLE:
        case ASSEMBLY:
        case SCHEMA:
        case EXTENSION:
        case FOREIGN_DATA_WRAPPER:
        case SERVER:
        case CAST:
            orig = getChild(name, type);
            if (orig == null) {
                addChild(st.shallowCopy());
            } else if (type == DbObjType.SCHEMA
                    && Consts.PUBLIC.equals(name) && !st.hasChildren()) {
                // skip empty public schema
                orig = null;
            }
            break;
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case RULE:
        case POLICY:
            PgStatementContainer cont = getSchema(parent.getParent().getName())
            .getStatementContainer(parentName);

            orig = cont.getChild(name, type);
            if (orig == null) {
                cont.addChild(st.shallowCopy());
            }
            break;
        default :
            AbstractSchema schema = getSchema(parentName);
            orig = schema.getChild(name, type);
            if (orig == null) {
                schema.addChild(st.shallowCopy());
            }
            break;
        }

        if (orig != null && !orig.compare(st)) {
            overrides.add(new PgOverride(orig, st));
        }
    }

    public static Map<String, PgStatement> listPgObjects(PgDatabase db) {
        Map<String, PgStatement> statements = new HashMap<>();
        db.getDescendants().flatMap(AbstractTable::columnAdder)
        .forEach(st -> statements.put(st.getQualifiedName(), st));
        return statements;
    }

    public void copyLaunchers(PgDatabase db) {
        analysisLaunchers.addAll(db.analysisLaunchers);
    }
}