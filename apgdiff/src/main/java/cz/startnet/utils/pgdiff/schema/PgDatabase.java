/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.AbstractAnalysisLauncher;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores database information.
 *
 * @author fordfrog
 */
public class PgDatabase extends PgStatement {
    /**
     * Current default schema.
     */
    private AbstractSchema defaultSchema;

    private final Map<String, AbstractSchema> schemas = new LinkedHashMap<>();
    private final Map<String, PgExtension> extensions = new LinkedHashMap<>();
    private final Map<String, MsAssembly> assemblies = new LinkedHashMap<>();
    private final Map<String, MsRole> roles = new LinkedHashMap<>();
    private final Map<String, MsUser> users = new LinkedHashMap<>();

    // Contains object definitions
    private final Map<String, Set<PgObjLocation>> objDefinitions = new HashMap<>();
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

    public Map<String, Set<PgObjLocation>> getObjDefinitions() {
        return objDefinitions;
    }

    public Map<String, Set<PgObjLocation>> getObjReferences() {
        return objReferences;
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
    public Collection<AbstractSchema> getSchemas() {
        return Collections.unmodifiableCollection(schemas.values());
    }

    public void addSchema(final AbstractSchema schema) {
        addUnique(schemas, schema, this);
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
        addUnique(extensions, extension, this);
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
        addUnique(assemblies, assembly, this);
    }

    public void addRole(final MsRole role) {
        addUnique(roles, role, this);
    }

    public void addUser(final MsUser user) {
        addUnique(users, user, this);
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
    public String getDropSQL() {
        return null;
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();

        if (!Objects.equals(getComment(), newCondition.getComment())) {
            sb.append("\n\n");
            newCondition.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    @Override
    public boolean compare(PgStatement obj) {
        // for now all instances of PgDatabase considered to be shallow equal
        return obj instanceof PgDatabase;
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof PgDatabase) {
            PgDatabase db = (PgDatabase) obj;
            return extensions.equals(db.extensions)
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

    public void addLib(PgDatabase lib) {
        lib.getDescendants().forEach(st -> {
            st.markAsLib();
            concat(st);
        });

        lib.analysisLaunchers.stream()
        .filter(st -> st.getStmt().getParent() != null)
        .forEach(l -> {
            l.updateStmt(this);
            analysisLaunchers.add(l);
        });
    }

    public void concat(PgStatement st) {
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
            orig = getChild(name, type);
            if (orig == null) {
                addChild(st.shallowCopy());
            } else if (type == DbObjType.SCHEMA
                    && ApgdiffConsts.PUBLIC.equals(name) && !st.hasChildren()) {
                // skip empty public schema
                orig = null;
            }
            break;
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case RULE:
            IStatementContainer cont = getSchema(parent.getParent().getName())
            .getStatementContainer(parentName);

            orig = ((PgStatement) cont).getChild(name, type);
            if (orig == null) {
                ((PgStatement) cont).addChild(st.shallowCopy());
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
}