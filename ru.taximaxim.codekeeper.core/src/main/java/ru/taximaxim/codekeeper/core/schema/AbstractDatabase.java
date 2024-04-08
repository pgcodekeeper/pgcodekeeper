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
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.AbstractAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgTable;

/**
 * Stores database information.
 */
public abstract class AbstractDatabase extends PgStatement implements IDatabase {

    private PgDiffArguments arguments;

    private SupportedVersion version;

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

    protected AbstractDatabase(PgDiffArguments arguments) {
        super("DB_name_placeholder");
        this.arguments = arguments;
    }

    public List<PgOverride> getOverrides() {
        return overrides;
    }

    protected AbstractDatabase() {
        this(new PgDiffArguments());
    }

    @Override
    public final DbObjType getStatementType() {
        return DbObjType.DATABASE;
    }

    public void setArguments(PgDiffArguments arguments) {
        this.arguments = arguments;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return this;
    }

    public final PgDiffArguments getArguments() {
        return arguments;
    }

    public SupportedVersion getVersion() {
        return version != null ? version : SupportedVersion.VERSION_10;
    }

    public void setVersion(SupportedVersion version) {
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

        return schemas.get(name);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        l.add(schemas.values());
    }

    public void sortColumns() {
        if (getDbType() == DatabaseType.PG) {
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
    public String getFullSQL() {
        return null;
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        return false;
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        return null;
    }

    @Override
    public void computeHash(Hasher hasher) {
        // has only child objects
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(schemas);
    }

    public void addLib(AbstractDatabase lib, String libName, String owner) {
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

    protected void addOverride(PgOverride override) {
        overrides.add(override);
    }

    protected abstract void concat(PgStatement st);

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
        if (obj instanceof AbstractDatabase) {
            AbstractDatabase db = (AbstractDatabase) obj;
            return schemas.equals(db.schemas);
        }
        return false;
    }

    @Override
    public final AbstractDatabase shallowCopy() {
        AbstractDatabase dbDst = getDatabaseCopy();
        dbDst.setVersion(version);
        copyBaseFields(dbDst);
        return dbDst;
    }

    protected abstract AbstractDatabase getDatabaseCopy();
}