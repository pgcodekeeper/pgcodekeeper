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
    private PgSchema defaultSchema;

    private final List<PgSchema> schemas = new ArrayList<>();
    private final List<PgExtension> extensions = new ArrayList<>();

    // Contains object definitions
    private final Map<String, List<PgObjLocation>> objDefinitions = new HashMap<>();
    // Содержит ссылки на объекты
    private final Map<String, List<PgObjLocation>> objReferences = new HashMap<>();
    // Contains PgStatement's contexts for analysis (for getting dependencies).
    private final List<Entry<PgStatement, ParserRuleContext>> contextsForAnalyze = new ArrayList<>();

    private PgDiffArguments arguments;

    private DBTimestamp dbTimestamp;

    private final List<PgOverride> overrides = new ArrayList<>();
    private SupportedVersion postgresVersion;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.DATABASE;
    }

    public PgDatabase() {
        this(true);
    }

    /**
     * @param createDefaultObjects
     *          add default public schema and default plpgsql extension automatically
     */
    public PgDatabase(boolean createDefaultObjects) {
        super("DB_name_placeholder", null);

        if (createDefaultObjects) {
            addSchema(new PgSchema(ApgdiffConsts.PUBLIC, null));
            defaultSchema = schemas.get(0);
            // DO NOT ADD plpgsql extension here
            // it is already present in dumps and this branch is executed only for dumps
        }
    }

    public void setDefaultSchema(final String name) {
        defaultSchema = getSchema(name);
    }

    public PgSchema getDefaultSchema() {
        return defaultSchema;
    }

    public String getDefSearchPath(){
        return "SET search_path = " + defaultSchema.getName() + ", pg_catalog;";
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

    public List<Entry<PgStatement, ParserRuleContext>> getContextsForAnalyze() {
        return contextsForAnalyze;
    }

    /**
     * Add context to the map for analyze.
     *
     * @param stmt statement to which the context belongs
     * @param ctx context for analyze
     */
    public void addContextForAnalyze(PgStatement stmt, ParserRuleContext ctx) {
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
    public PgSchema getSchema(final String name) {
        if (name == null) {
            return getDefaultSchema();
        }

        for (final PgSchema schema : schemas) {
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
    public List<PgSchema> getSchemas() {
        return Collections.unmodifiableList(schemas);
    }

    public void addSchema(final PgSchema schema) {
        assertUnique(this::getSchema, schema);
        schemas.add(schema);
        schema.setParent(this);
        resetHash();
    }


    public boolean containsExtension(final String name) {
        return getExtension(name) != null;
    }

    @Override
    public Stream<PgStatement> getDescendants() {
        Stream<PgStatement> stream = getChildren();

        for (PgSchema schema : getSchemas()) {
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

    public void sortColumns() {
        for (PgSchema schema : schemas) {
            schema.getTables().forEach(PgTable::sortColumns);
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
                    && PgDiffUtils.setlikeEquals(schemas, db.schemas);
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
    }

    @Override
    public PgDatabase shallowCopy() {
        PgDatabase dbDst = new PgDatabase(false);
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
        for (PgSchema schema : schemas) {
            copy.addSchema(schema.deepCopy());
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

        for (PgSchema s : database.getSchemas()) {
            PgSchema schema = getSchema(s.getName());
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

                for (PgSequence seq : s.getSequences()) {
                    PgSequence sequence = schema.getSequence(seq.getName());
                    if (sequence == null) {
                        seq.dropParent();
                        schema.addSequence(seq);
                    } else {
                        overrides.add(new PgOverride(sequence, seq));
                    }
                }

                for (PgFunction func : s.getFunctions()) {
                    PgFunction function = schema.getFunction(func.getName());
                    if (!schema.containsFunction(func.getName())) {
                        func.dropParent();
                        schema.addFunction(func);
                    } else {
                        overrides.add(new PgOverride(function, func));
                    }
                }

                for (PgTable t : s.getTables()) {
                    PgTable table = schema.getTable(t.getName());
                    if (table == null) {
                        t.dropParent();
                        schema.addTable(t);
                    } else {
                        overrides.add(new PgOverride(table, t));

                        for (PgConstraint con : t.getConstraints()) {
                            PgConstraint constraint = table.getConstraint(con.getName());
                            if (constraint == null) {
                                con.dropParent();
                                table.addConstraint(con);
                            } else {
                                overrides.add(new PgOverride(constraint, con));
                            }
                        }

                        for (PgIndex ind : t.getIndexes()) {
                            PgIndex index = table.getIndex(ind.getName());
                            if (index == null) {
                                ind.dropParent();
                                table.addIndex(ind);
                            } else {
                                overrides.add(new PgOverride(index, ind));
                            }
                        }

                        for (PgTrigger tr : t.getTriggers()) {
                            PgTrigger trigger = table.getTrigger(tr.getName());
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

                for (PgView v : s.getViews()) {
                    PgView view = schema.getView(v.getName());
                    if (view == null) {
                        v.dropParent();
                        schema.addView(v);
                    } else {
                        overrides.add(new PgOverride(view, v));

                        for (PgTrigger tr : v.getTriggers()) {
                            PgTrigger trigger = view.getTrigger(tr.getName());
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
        db.getDescendants().flatMap(PgTable::columnAdder).forEach(st -> statements.put(st.getQualifiedName(), st));
        return statements;
    }
}