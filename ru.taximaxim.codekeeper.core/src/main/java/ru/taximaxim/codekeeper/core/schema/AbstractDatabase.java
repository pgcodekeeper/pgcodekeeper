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
import java.util.Set;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.loader.pg.SupportedPgVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.AbstractAnalysisLauncher;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.ISettings;

/**
 * Stores database information.
 */
public abstract class AbstractDatabase extends PgStatement implements IDatabase {

    private SupportedPgVersion version;

    /**
     * Current default schema.
     */
    private AbstractSchema defaultSchema;
    private final Map<String, AbstractSchema> schemas = new LinkedHashMap<>();

    private final List<PgOverride> overrides = new ArrayList<>();

    // Contains object references
    private final Map<String, Set<PgObjLocation>> objReferences = new HashMap<>();
    // Contains analysis launchers for all statements
    // (used for launch analyze and getting dependencies).
    private final ArrayList<AbstractAnalysisLauncher> analysisLaunchers = new ArrayList<>();

    protected AbstractDatabase() {
        super("DB_name_placeholder");
    }

    public List<PgOverride> getOverrides() {
        return overrides;
    }

    @Override
    public final DbObjType getStatementType() {
        return DbObjType.DATABASE;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return this;
    }

    public SupportedPgVersion getVersion() {
        return version != null ? version : SupportedPgVersion.VERSION_10;
    }

    public void setVersion(SupportedPgVersion version) {
        this.version = version;
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
     * @param launcher
     *            launcher that contains almost everything needed to analyze an statement contained in it
     */
    public void addAnalysisLauncher(AbstractAnalysisLauncher launcher) {
        analysisLaunchers.add(launcher);
    }

    @Override
    protected void fillDescendantsList(List<Collection<? extends PgStatement>> l) {
        fillChildrenList(l);
        for (AbstractSchema schema : schemas.values()) {
            schema.fillDescendantsList(l);
        }
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

    public void setDefaultSchema(final String name) {
        defaultSchema = getSchema(name);
    }

    public AbstractSchema getDefaultSchema() {
        return defaultSchema;
    }

    public boolean containsSchema(final String name) {
        return getSchema(name) != null;
    }

    /**
     * Returns schema of given name or null if the schema has not been found. If schema name is null then default schema
     * is returned.
     *
     * @param name
     *            schema name or null which means default schema
     *
     * @return found schema or null
     */
    @Override
    public AbstractSchema getSchema(final String name) {
        if (name == null) {
            return getDefaultSchema();
        }

        return getChildByName(schemas, name);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        l.add(schemas.values());
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        // no action
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        return ObjectState.NOTHING;
    }

    @Override
    public void getDropSQL(SQLScript script, boolean optionExists) {
    }

    @Override
    public void computeHash(Hasher hasher) {
        // has only child objects
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(schemas);
    }

    public void addLib(AbstractDatabase lib, String libName, String owner, ISettings settings) {
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

        overrides.addAll(lib.overrides);
        lib.objReferences.entrySet().forEach(e -> objReferences.putIfAbsent(e.getKey(), e.getValue()));
    }

    protected void addOverride(PgOverride override) {
        overrides.add(override);
    }

    protected void concat(PgStatement st) {
        DbObjType type = st.getStatementType();
        PgStatement parent = st.parent;
        String parentName = parent.getName();
        IStatementContainer cont;

        if (isFirstLevelType(type)) {
            cont = this;
        } else if (st.isSubElement()) {
            cont = getSchema(parent.parent.getName()).getStatementContainer(parentName);
        } else {
            cont = getSchema(parentName);
        }

        String name = st.getName();
        PgStatement orig = cont.getChild(name, type);
        if (orig == null) {
            cont.addChild(st.shallowCopy());
        }

        if (orig != null && !orig.compare(st)) {
            addOverride(new PgOverride(orig, st));
        }
    }

    protected abstract boolean isFirstLevelType(DbObjType type);

    public static Map<String, PgStatement> listPgObjects(AbstractDatabase db) {
        Map<String, PgStatement> statements = new HashMap<>();
        db.getDescendants().flatMap(AbstractTable::columnAdder)
        .forEach(st -> statements.put(st.getQualifiedName(), st));
        return statements;
    }

    public void copyLaunchers(AbstractDatabase db) {
        analysisLaunchers.addAll(db.analysisLaunchers);
    }

    @Override
    public boolean compare(PgStatement obj) {
        return obj instanceof AbstractDatabase && super.compare(obj);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        return obj instanceof AbstractDatabase db && schemas.equals(db.schemas);
    }

    @Override
    public final AbstractDatabase shallowCopy() {
        AbstractDatabase dbDst = getDatabaseCopy();
        dbDst.setVersion(version);
        copyBaseFields(dbDst);
        return dbDst;
    }

    protected abstract AbstractDatabase getDatabaseCopy();

    public final PgStatement getStatement(GenericColumn gc) {
        DbObjType type = gc.type;
        if (type == DbObjType.DATABASE) {
            return this;
        }

        if (isFirstLevelType(type)) {
            return getChild(gc.schema, type);
        }

        AbstractSchema s = getSchema(gc.schema);
        if (s == null) {
            return null;
        }

        switch (type) {
        case DOMAIN:
        case SEQUENCE:
        case VIEW:
        case COLLATION:
        case FTS_PARSER:
        case FTS_TEMPLATE:
        case FTS_DICTIONARY:
        case FTS_CONFIGURATION:
            return s.getChild(gc.table, type);
        case STATISTICS:
            return resolveStatistics(s, gc, type);
        case TYPE:
            return (PgStatement) resolveTypeCall(s, gc.table);
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
            return (PgStatement) resolveFunctionCall(s, gc.table);
        case OPERATOR:
            return (PgStatement) resolveOperatorCall(s, gc.table);
        case TABLE:
            return (PgStatement) s.getRelation(gc.table);
        case INDEX:
            return s.getIndexByName(gc.table);
            // handled in getStatement, left here for consistency
        case COLUMN:
            AbstractTable t = s.getTable(gc.table);
            return t == null ? null : t.getColumn(gc.column);
        case CONSTRAINT:
        case TRIGGER:
        case RULE:
        case POLICY:
            PgStatementContainer sc = s.getStatementContainer(gc.table);
            return sc == null ? null : sc.getChild(gc.column, type);
        default:
            throw new IllegalStateException("Unhandled DbObjType: " + type);
        }
    }

    protected PgStatement resolveStatistics(AbstractSchema s, GenericColumn gc, DbObjType type) {
        return s.getChild(gc.table, type);
    }

    private IStatement resolveTypeCall(AbstractSchema s, String table) {
        PgStatement st = s.getChild(table, DbObjType.TYPE);
        if (st != null) {
            return st;
        }
        st = s.getChild(table, DbObjType.DOMAIN);
        if (st != null) {
            return st;
        }
        // every "selectable" relation can be used as a type
        // getRelation should only look for "selectable" relations
        return s.getRelation(table);
    }

    private IFunction resolveFunctionCall(AbstractSchema schema, String table) {
        if (schema.getDbType() == DatabaseType.PG) {
            return schema.getFunction(table);
        }

        for (IFunction f : schema.getFunctions()) {
            if (f.getBareName().equals(table)) {
                return f;
            }
        }
        return null;
    }

    protected IOperator resolveOperatorCall(AbstractSchema schema, String table) {
        return null;
    }
}