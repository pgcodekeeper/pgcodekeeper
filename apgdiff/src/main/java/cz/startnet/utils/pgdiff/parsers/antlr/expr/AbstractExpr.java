package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_args_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.ISchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractExpr {

    // TODO get postgresql version.
    // Need to get version. I can get it from JdbcLoader(READER),
    // but I can't get it from PgDumpLoader(WRITER).
    protected final PgSystemStorage systemStorage;
    protected final String schema;
    private final AbstractExpr parent;
    private final Set<GenericColumn> depcies;

    protected final PgDatabase db;

    public Set<GenericColumn> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    public AbstractExpr(String schema, PgDatabase db) {
        this.schema = schema;
        parent = null;
        depcies = new LinkedHashSet<>();
        this.db = db;
        systemStorage = PgSystemStorage.getObjectsFromResources(SupportedVersion.VERSION_9_5);
    }

    protected AbstractExpr(AbstractExpr parent) {
        this.schema = parent.schema;
        this.parent = parent;
        depcies = parent.depcies;
        this.db = parent.db;
        this.systemStorage = parent.systemStorage;
    }

    protected List<SimpleEntry<String, String>> findCte(String cteName) {
        return parent == null ? null : parent.findCte(cteName);
    }

    protected boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    /**
     * @param schema optional schema qualification of name, may be null
     * @param name alias of the referenced object
     * @param column optional referenced column alias, may be null
     * @return a pair of (Alias, Dealiased name) where Alias is the given name.
     *          Dealiased name can be null if the name is internal to the query
     *          and is not a reference to external table.<br>
     *          null if the name is not found
     */
    protected Entry<String, GenericColumn> findReference(String schema, String name, String column) {
        return parent == null ? null : parent.findReference(schema, name, column);
    }

    /**
     * @param schema optional schema qualification of name, may be null
     * @param name alias of the referenced object
     * @return a pair of (Alias, ColumnsList) where Alias is the given name.
     *          ColumnsList list of columns as pair 'columnName-columnType' of the internal query.<br>
     */
    protected Entry<String, List<SimpleEntry<String, String>>> findReferenceComplex(String name) {
        return parent == null ? null : parent.findReferenceComplex(name);
    }

    protected GenericColumn addObjectDepcy(List<IdentifierContext> ids, DbObjType type) {
        GenericColumn depcy = new GenericColumn(
                getSchemaNameForRelation(ids), QNameParser.getFirstName(ids), type);
        depcies.add(depcy);
        return depcy;
    }

    private String getSchemaNameForRelation(List<IdentifierContext> ids) {
        IdentifierContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        if (schemaCtx != null) {
            return schemaCtx.getText();
        }
        String relationName = QNameParser.getFirstName(ids);

        if (db.getSchema(schema).containsRelation(relationName)) {
            return schema;
        }
        for (ISchema s : systemStorage.getSchemas()) {
            if (s.containsRelation(relationName)) {
                return s.getName();
            }
        }
        Log.log(Log.LOG_WARNING, "Could not find schema for relation: " + relationName);
        return schema;
    }

    private String getSchemaNameForFunction(IdentifierContext sch, String signature) {
        if (sch != null) {
            return sch.getText();
        }
        if (db.getSchema(schema).containsFunction(signature)) {
            return schema;
        }
        for (ISchema s : systemStorage.getSchemas()) {
            if (s.containsFunction(signature)) {
                return s.getName();
            }
        }
        Log.log(Log.LOG_WARNING, "Could not find schema for function: " + signature);
        return schema;
    }

    protected void addFunctionDepcy(IFunction function){
        depcies.add(new GenericColumn(function.getContainingSchema().getName(),
                function.getName(), DbObjType.FUNCTION));
    }

    protected void addTypeDepcy(Data_typeContext type) {
        Schema_qualified_name_nontypeContext typeName = type.predefined_type().schema_qualified_name_nontype();

        if (typeName != null) {
            IdentifierContext qual = typeName.identifier();
            String schema = qual == null ? this.schema : qual.getText();

            depcies.add(new GenericColumn(schema,
                    typeName.identifier_nontype().getText(), DbObjType.TYPE));
        }
    }

    /**
     * @return column with its type
     */
    protected SimpleEntry<String, String> addColumnDepcy(Schema_qualified_nameContext qname) {
        List<IdentifierContext> ids = qname.identifier();
        String column = QNameParser.getFirstName(ids);
        String columnType = TypesSetManually.COLUMN;
        String columnParent = null;
        SimpleEntry<String, String> pair = new SimpleEntry<>(column, null);

        // TODO table-less columns are pending full analysis
        if (ids.size() > 1) {
            String schema = QNameParser.getThirdName(ids);
            columnParent = QNameParser.getSecondName(ids);

            Entry<String, GenericColumn> ref = findReference(schema, columnParent, column);
            if (ref != null) {
                GenericColumn referencedTable = ref.getValue();
                if (referencedTable != null) {
                    columnParent = referencedTable.table;
                    GenericColumn genericColumn = new GenericColumn(referencedTable.schema, columnParent, column, DbObjType.COLUMN);
                    depcies.add(genericColumn);

                    columnType = getColumnType(genericColumn);
                } else {
                    Entry<String, List<SimpleEntry<String, String>>> refComplex = findReferenceComplex(columnParent);
                    if (refComplex != null) {
                        columnType = refComplex.getValue().stream()
                                .filter(entry -> column.equals(entry.getKey()))
                                .map(Entry::getValue)
                                .findAny().orElse(TypesSetManually.COLUMN);
                    }
                }
            } else {
                Log.log(Log.LOG_WARNING, "Unknown column reference: "
                        + schema + ' ' + columnParent + ' ' + column);
            }
        }

        pair.setValue(columnType);

        return pair;
    }

    private String getColumnType(GenericColumn genericColumn) {
        for (IRelation relation : (Iterable<IRelation>)findRelations(genericColumn.schema, genericColumn.table)::iterator) {
            for (Entry<String, String> colPair : (Iterable<SimpleEntry<String, String>>)relation.getRelationColumns()::iterator ) {
                if (genericColumn.column.equals(colPair.getKey())) {
                    return colPair.getValue();
                }
            }
        }
        return TypesSetManually.COLUMN;
    }

    protected void addColumnsDepcies(Schema_qualified_nameContext table, List<IdentifierContext> cols) {
        List<IdentifierContext> ids = table.identifier();
        String schemaName = QNameParser.getSchemaName(ids, schema);
        String tableName = QNameParser.getFirstName(ids);
        for (IdentifierContext col : cols) {
            depcies.add(new GenericColumn(schemaName, tableName, col.getText(), DbObjType.COLUMN));
        }
    }

    protected void addColumnsDepcies(String schemaName, String tableOrView, List<SimpleEntry<String, String>> cols) {
        String sName = schemaName != null ? schemaName : this.schema;
        for (Entry<String, String> col : cols) {
            depcies.add(new GenericColumn(sName, tableOrView, col.getKey(), DbObjType.COLUMN));
        }
    }

    protected void addFunctionSigDepcy(String signature) {
        SQLParser p = AntlrParser.makeBasicParser(SQLParser.class, signature, "function signature");
        Function_args_parserContext sig = p.function_args_parser();
        List<IdentifierContext> ids = sig.schema_qualified_name().identifier();
        depcies.add(new GenericColumn(getSchemaNameForFunction(QNameParser.getSchemaNameCtx(ids), signature),
                PgDiffUtils.getQuotedName(QNameParser.getFirstName(ids)) +
                ParserAbstract.getFullCtxText(sig.function_args()),
                DbObjType.FUNCTION));
    }

    protected void addSchemaDepcy(List<IdentifierContext> ids) {
        depcies.add(new GenericColumn(QNameParser.getFirstName(ids), DbObjType.SCHEMA));
    }

    protected Stream<IRelation> findRelations(String schemaName, String relationName) {
        Stream<IRelation> foundRelations;
        if (PgSystemStorage.SCHEMA_PG_CATALOG.equals(schemaName)
                || PgSystemStorage.SCHEMA_INFORMATION_SCHEMA.equals(schemaName)) {
            foundRelations = systemStorage.getSchema(schemaName).getRelations()
                    .map(r -> (IRelation) r);
        } else if (schemaName != null) {
            foundRelations = db.getSchema(schemaName).getRelations();
        } else {
            foundRelations = Stream.concat(db.getSchema(schema).getRelations(),
                    systemStorage.getSchema(PgSystemStorage.SCHEMA_PG_CATALOG).getRelations());
        }

        return foundRelations.filter(r -> r.getName().equals(relationName));
    }
}