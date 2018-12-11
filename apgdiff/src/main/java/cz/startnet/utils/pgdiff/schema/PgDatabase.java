/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
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

    private final List<AbstractSchema> schemas = new ArrayList<>();
    private final List<PgExtension> extensions = new ArrayList<>();
    private final List<MsAssembly> assemblies = new ArrayList<>();
    private final List<MsRole> roles = new ArrayList<>();
    private final List<MsUser> users = new ArrayList<>();

    // Contains object definitions
    private final Map<String, List<PgObjLocation>> objDefinitions = new HashMap<>();
    // Содержит ссылки на объекты
    private final Map<String, List<PgObjLocation>> objReferences = new HashMap<>();
    // Contains PgStatement's contexts for analysis (for getting dependencies).
    private final List<Entry<PgStatementWithSearchPath, ParserRuleContext>> contextsForAnalyze = new ArrayList<>();

    private PgDiffArguments arguments;

    private DBTimestamp dbTimestamp;

    private final List<PgOverride> overrides = new ArrayList<>();
    private SupportedVersion postgresVersion;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.DATABASE;
    }

    public PgDatabase() {
        super("DB_name_placeholder");
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

    public Map<String, List<PgObjLocation>> getObjDefinitions() {
        return objDefinitions;
    }

    public Map<String, List<PgObjLocation>> getObjReferences() {
        return objReferences;
    }

    public List<Entry<PgStatementWithSearchPath, ParserRuleContext>> getContextsForAnalyze() {
        return contextsForAnalyze;
    }

    /**
     * Add context to the map for analyze.
     *
     * @param stmt statement to which the context belongs
     * @param ctx context for analyze
     */
    public void addContextForAnalyze(PgStatementWithSearchPath stmt, ParserRuleContext ctx) {
        contextsForAnalyze.add(new SimpleEntry<>(stmt, ctx));
    }

    public void setDbTimestamp(DBTimestamp dbTimestamp) {
        this.dbTimestamp = dbTimestamp;
    }

    public DBTimestamp getDbTimestamp() {
        return dbTimestamp;
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

        for (final AbstractSchema schema : schemas) {
            if (schema.getName().equals(name)) {
                return schema;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #schemas}. The list cannot be modified.
     *
     * @return {@link #schemas}
     */
    public List<AbstractSchema> getSchemas() {
        return Collections.unmodifiableList(schemas);
    }

    public void addSchema(final AbstractSchema schema) {
        assertUnique(this::getSchema, schema);
        schemas.add(schema);
        schema.setParent(this);
        resetHash();
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
    protected void fillDescendantsList(List<List<? extends PgStatement>> l) {
        fillChildrenList(l);
        for (AbstractSchema schema : schemas) {
            schema.fillDescendantsList(l);
        }
    }

    @Override
    protected void fillChildrenList(List<List<? extends PgStatement>> l) {
        l.add(schemas);
        l.add(extensions);
        l.add(assemblies);
        l.add(roles);
        l.add(users);
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
        for(final PgExtension ext : extensions) {
            if(ext.getName().equals(name)) {
                return ext;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #extensions}. The list cannot be modified.
     *
     * @return {@link #extensions}
     */
    public List<PgExtension> getExtensions() {
        return Collections.unmodifiableList(extensions);
    }

    public void addExtension(final PgExtension extension) {
        assertUnique(this::getExtension, extension);
        extensions.add(extension);
        extension.setParent(this);
        resetHash();
    }

    /**
     * Returns assembly of given name or null if the assembly has not been found.
     *
     * @param name assembly name
     *
     * @return found assembly or null
     */
    public MsAssembly getAssembly(final String name) {
        for (final MsAssembly ass : assemblies) {
            if (ass.getName().equals(name)) {
                return ass;
            }
        }

        return null;
    }

    /**
     * Returns role of given name or null if the role has not been found.
     *
     * @param name role name
     *
     * @return found role or null
     */
    public MsRole getRole(final String name) {
        for (final MsRole role : roles) {
            if (role.getName().equals(name)) {
                return role;
            }
        }

        return null;
    }

    /**
     * Returns user of given name or null if the user has not been found.
     *
     * @param name user name
     *
     * @return found user or null
     */
    public MsUser getUser(final String name) {
        for (final MsUser user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #assemblies}. The list cannot be modified.
     *
     * @return {@link #assemblies}
     */
    public List<MsAssembly> getAssemblies() {
        return Collections.unmodifiableList(assemblies);
    }

    /**
     * Getter for {@link #roles}. The list cannot be modified.
     *
     * @return {@link #roles}
     */
    public List<MsRole> getRoles() {
        return Collections.unmodifiableList(roles);
    }

    /**
     * Getter for {@link #users}. The list cannot be modified.
     *
     * @return {@link #users}
     */
    public List<MsUser> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public void addAssembly(final MsAssembly assembly) {
        assertUnique(this::getAssembly, assembly);
        assemblies.add(assembly);
        assembly.setParent(this);
        resetHash();
    }

    public void addRole(final MsRole role) {
        assertUnique(this::getRole, role);
        roles.add(role);
        role.setParent(this);
        resetHash();
    }

    public void addUser(final MsUser user) {
        assertUnique(this::getRole, user);
        users.add(user);
        user.setParent(this);
        resetHash();
    }

    public void sortColumns() {
        if (isPostgres()) {
            for (AbstractSchema schema : schemas) {
                schema.getTables().forEach(t -> ((PgTable) t).sortColumns());
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
        PgDatabase newDb;
        final int startLength = sb.length();
        if (newCondition instanceof PgDatabase) {
            newDb = (PgDatabase) newCondition;
        } else {
            return false;
        }
        PgDatabase oldDb = this;
        if (!Objects.equals(oldDb.getComment(), newDb.getComment())) {
            sb.append("\n\n");
            newDb.appendCommentSql(sb);
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
            return PgDiffUtils.setlikeEquals(extensions, db.extensions)
                    && PgDiffUtils.setlikeEquals(schemas, db.schemas)
                    && PgDiffUtils.setlikeEquals(assemblies, db.assemblies)
                    && PgDiffUtils.setlikeEquals(roles, db.roles)
                    && PgDiffUtils.setlikeEquals(users, db.users);
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
        PgDatabase dbDst = new PgDatabase();
        copyBaseFields(dbDst);
        dbDst.setArguments(getArguments());
        dbDst.setPostgresVersion(getPostgresVersion());
        return dbDst;
    }

    @Override
    public PgDatabase deepCopy() {
        PgDatabase copy = shallowCopy();
        for (PgExtension ext : extensions) {
            copy.addExtension(ext.deepCopy());
        }
        for (AbstractSchema schema : schemas) {
            copy.addSchema(schema.deepCopy());
        }
        for (MsAssembly ass : assemblies) {
            copy.addAssembly(ass.deepCopy());
        }
        for (MsRole role : roles) {
            copy.addRole(role.deepCopy());
        }
        for (MsUser user : users) {
            copy.addUser(user.deepCopy());
        }
        return copy;
    }

    public void addLib(PgDatabase database) {
        database.getDescendants().forEach(st -> {
            st.markAsLib();
            concat(st);
        });
        contextsForAnalyze.addAll(database.contextsForAnalyze);
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
            AbstractTable tab = getSchema(parent.getParent().getName()).getTable(parentName);
            orig = tab.getChild(name, type);
            if (orig == null) {
                tab.addChild(st.shallowCopy());
            }
            break;
        case TRIGGER:
            PgTriggerContainer tCont = getSchema(parent.getParent().getName())
            .getTriggerContainer(parentName);
            orig = tCont.getTrigger(name);
            if (orig == null) {
                tCont.addTrigger((AbstractTrigger) st.shallowCopy());
            }
            break;
        case RULE:
            PgRuleContainer rCont = getSchema(parent.getParent().getName())
            .getRuleContainer(parentName);
            orig = rCont.getRule(name);
            if (orig == null) {
                rCont.addRule((PgRule) st.shallowCopy());
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

        if (orig != null) {
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