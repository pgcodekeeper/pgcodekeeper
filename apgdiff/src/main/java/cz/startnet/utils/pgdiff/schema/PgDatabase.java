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
import java.util.stream.Stream;

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
        super("DB_name_placeholder", null);
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

    @Override
    public Stream<PgStatement> getDescendants() {
        Stream<PgStatement> stream = getChildren();

        for (AbstractSchema schema : getSchemas()) {
            stream = Stream.concat(stream, schema.getDescendants());
        }

        return stream;
    }

    @Override
    public Stream<PgStatement> getChildren() {
        return Stream.concat(getSchemas().stream(), getExtensions().stream());
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
        for (AbstractSchema schema : schemas) {
            schema.getTables().forEach(AbstractTable::sortColumns);
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
        dbDst.setArguments(getArguments());
        dbDst.setComment(getComment());
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
            copy.addAssembly(ass);
        }
        for (MsRole role : roles) {
            copy.addRole(role);
        }
        for (MsUser user : users) {
            copy.addUser(user);
        }
        return copy;
    }

    public void addLib(PgDatabase database) {
        database.getDescendants().forEach(PgStatement::markAsLib);
        concat(database);
    }

    private void concat(PgDatabase database) {
        for (PgExtension e : database.getExtensions()) {
            PgExtension ext = getExtension(e.getName());
            if (ext == null) {
                e.dropParent();
                addExtension(e);
            } else if (!"plpgsql".equals(e.getName())) {
                overrides.add(new PgOverride(ext, e));
            }
        }

        for (MsAssembly a : database.getAssemblies()) {
            MsAssembly ass = getAssembly(a.getName());
            if (ass == null) {
                a.dropParent();
                addAssembly(a);
            } else {
                overrides.add(new PgOverride(ass, a));
            }
        }

        for (MsRole r : database.getRoles()) {
            MsRole role = getRole(r.getName());
            if (role == null) {
                r.dropParent();
                addRole(r);
            } else {
                overrides.add(new PgOverride(role, r));
            }
        }

        for (MsUser u : database.getUsers()) {
            MsUser user = getUser(u.getName());
            if (user == null) {
                u.dropParent();
                addUser(user);
            } else {
                overrides.add(new PgOverride(user, u));
            }
        }

        for (AbstractSchema s : database.getSchemas()) {
            AbstractSchema schema = getSchema(s.getName());
            if (schema == null) {
                s.dropParent();
                addSchema(s);
                // skip empty public schema
            } else if (!ApgdiffConsts.PUBLIC.equals(s.getName())
                    || !s.compareChildren(new PgSchema(ApgdiffConsts.PUBLIC, ""))) {
                overrides.add(new PgOverride(schema, s));

                for (PgType ty : s.getTypes()) {
                    PgType type = schema.getType(ty.getName());
                    if (type == null) {
                        ty.dropParent();
                        schema.addType(ty);
                    } else {
                        overrides.add(new PgOverride(type, ty));
                    }
                }

                for (PgDomain dom : s.getDomains()) {
                    PgDomain domain = schema.getDomain(dom.getName());
                    if (domain == null) {
                        dom.dropParent();
                        schema.addDomain(dom);
                    } else {
                        overrides.add(new PgOverride(domain, dom));
                    }
                }

                for (AbstractSequence seq : s.getSequences()) {
                    AbstractSequence sequence = schema.getSequence(seq.getName());
                    if (sequence == null) {
                        seq.dropParent();
                        schema.addSequence(seq);
                    } else {
                        overrides.add(new PgOverride(sequence, seq));
                    }
                }

                for (AbstractFunction func : s.getFunctions()) {
                    AbstractFunction function = schema.getFunction(func.getName());
                    if (!schema.containsFunction(func.getName())) {
                        func.dropParent();
                        schema.addFunction(func);
                    } else {
                        overrides.add(new PgOverride(function, func));
                    }
                }

                for (AbstractTable t : s.getTables()) {
                    AbstractTable table = schema.getTable(t.getName());
                    if (table == null) {
                        t.dropParent();
                        schema.addTable(t);
                    } else {
                        overrides.add(new PgOverride(table, t));

                        for (AbstractConstraint con : t.getConstraints()) {
                            AbstractConstraint constraint = table.getConstraint(con.getName());
                            if (constraint == null) {
                                con.dropParent();
                                table.addConstraint(con);
                            } else {
                                overrides.add(new PgOverride(constraint, con));
                            }
                        }

                        for (AbstractIndex ind : t.getIndexes()) {
                            AbstractIndex index = table.getIndex(ind.getName());
                            if (index == null) {
                                ind.dropParent();
                                table.addIndex(ind);
                            } else {
                                overrides.add(new PgOverride(index, ind));
                            }
                        }

                        for (AbstractTrigger tr : t.getTriggers()) {
                            AbstractTrigger trigger = table.getTrigger(tr.getName());
                            if (trigger == null) {
                                tr.dropParent();
                                table.addTrigger(tr);
                            } else {
                                overrides.add(new PgOverride(trigger, tr));
                            }
                        }

                        for (PgRule r : t.getRules()) {
                            PgRule rule = table.getRule(r.getName());
                            if (rule == null) {
                                r.dropParent();
                                table.addRule(r);
                            } else {
                                overrides.add(new PgOverride(rule, r));
                            }
                        }
                    }
                }

                for (AbstractView v : s.getViews()) {
                    AbstractView view = schema.getView(v.getName());
                    if (view == null) {
                        v.dropParent();
                        schema.addView(v);
                    } else {
                        overrides.add(new PgOverride(view, v));

                        for (AbstractTrigger tr : v.getTriggers()) {
                            AbstractTrigger trigger = view.getTrigger(tr.getName());
                            if (trigger == null) {
                                tr.dropParent();
                                view.addTrigger(tr);
                            } else {
                                overrides.add(new PgOverride(trigger, tr));
                            }
                        }

                        for (PgRule r : v.getRules()) {
                            PgRule rule = view.getRule(r.getName());
                            if (rule == null) {
                                r.dropParent();
                                view.addRule(r);
                            } else {
                                overrides.add(new PgOverride(rule, r));
                            }
                        }
                    }
                }
            }
        }
    }

    public static Map<String, PgStatement> listPgObjects(PgDatabase db) {
        Map<String, PgStatement> statements = new HashMap<>();
        db.getDescendants().flatMap(AbstractTable::columnAdder).forEach(st -> statements.put(st.getQualifiedName(), st));
        return statements;
    }
}