/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
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

    private PgDiffArguments arguments;

    private DBTimestamp dbTimestamp;

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

            PgExtension ext = new PgExtension("plpgsql", null);
            ext.setSchema("pg_catalog");
            ext.setComment("'PL/pgSQL procedural language'");
            addExtension(ext);
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

    public void setDbTimestamp(DBTimestamp dbTimestamp) {
        this.dbTimestamp = dbTimestamp;
    }

    public DBTimestamp getDbTimestamp() {
        return dbTimestamp;
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
            schema.getTables().forEach(t -> t.sortColumns());
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
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + PgDiffUtils.setlikeHashcode(extensions);
        result = prime * result + PgDiffUtils.setlikeHashcode(schemas);
        return result;
    }

    @Override
    public PgDatabase shallowCopy() {
        PgDatabase dbDst = new PgDatabase(false);
        dbDst.setArguments(getArguments());
        dbDst.setComment(getComment());
        return dbDst;
    }

    @Override
    public PgDatabase deepCopy() {
        PgDatabase copy = shallowCopy();
        for(PgExtension ext : extensions) {
            copy.addExtension(ext.deepCopy());
        }
        for(PgSchema schema : schemas) {
            copy.addSchema(schema.deepCopy());
        }
        return copy;
    }

    public static Map<String, PgStatement> listPgObjects(PgDatabase db) {
        Map<String, PgStatement> statements = new HashMap<>();

        for (PgSchema schema : db.getSchemas()) {
            mapQname(statements, schema);
            for (PgType ty : schema.getTypes()) {
                mapQname(statements, ty);
            }
            for (PgDomain domain : schema.getDomains()) {
                mapQname(statements, domain);
            }
            for (PgSequence sequence : schema.getSequences()) {
                mapQname(statements, sequence);
            }
            for (PgFunction function : schema.getFunctions()) {
                mapQname(statements, function);
            }
            for (PgTable table : schema.getTables()) {
                mapQname(statements, table);
                for (PgColumn column : table.getColumns()) {
                    mapQname(statements, column);
                }
                for (PgConstraint constraint : table.getConstraints()) {
                    mapQname(statements, constraint);
                }
                for (PgIndex index : table.getIndexes() ){
                    mapQname(statements, index);
                }
                for (PgTrigger trigger : table.getTriggers()) {
                    mapQname(statements, trigger);
                }
                for (PgRule rule : table.getRules()) {
                    mapQname(statements, rule);
                }
            }
            for (PgView view : schema.getViews()) {
                mapQname(statements, view);
                for (PgTrigger trigger : view.getTriggers()) {
                    mapQname(statements, trigger);
                }
                for (PgRule rule : view.getRules()) {
                    mapQname(statements, rule);
                }
            }
        }
        for (PgExtension ext : db.getExtensions()) {
            mapQname(statements, ext);
        }
        return statements;
    }

    private static void mapQname(Map<String, PgStatement> map, PgStatement st) {
        map.put(st.getQualifiedName(), st);
    }
}