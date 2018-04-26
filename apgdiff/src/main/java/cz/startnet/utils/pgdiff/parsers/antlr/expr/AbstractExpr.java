package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
import cz.startnet.utils.pgdiff.schema.DbObjNature;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.ISchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

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

    protected List<Pair<String, String>> findCte(String cteName) {
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
    protected List<Pair<String, String>> findReferenceComplex(String name) {
        return parent == null ? null : parent.findReferenceComplex(name);
    }

    /**
     * @return {@link cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc#unaliasedNamespace
     * unaliased namespaces}
     */
    protected Set<GenericColumn> getAllUnaliasedNmsp() {
        return parent == null ? Collections.emptySet() : parent.getAllUnaliasedNmsp();
    }

    /**
     * @return {@link cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc#namespace
     * The local namespace of this Select.}
     */
    protected Map<String, GenericColumn> getAllReferences() {
        return parent == null ? Collections.emptyMap() : parent.getAllReferences();
    }

    /**
     * @return {@link cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc#complexNamespace
     * Map contains alias and list of pairs. Pairs returned by aliased subquery.}
     */
    protected Map<String, List<Pair<String, String>>> getAllReferencesComplex() {
        return parent == null ? Collections.emptyMap() : parent.getAllReferencesComplex();
    }

    protected GenericColumn addRelationDepcy(List<IdentifierContext> ids) {
        String schemaName = null;
        IdentifierContext schemaNameCtx = QNameParser.getSchemaNameCtx(ids);
        String relationName = QNameParser.getFirstName(ids);
        if (schemaNameCtx != null) {
            schemaName = schemaNameCtx.getText();
        } else if (db.getSchema(schema).containsRelation(relationName)) {
            schemaName = schema;
        } else {
            for (ISchema s : systemStorage.getSchemas()) {
                if (s.containsRelation(relationName)) {
                    schemaName = s.getName();
                    break;
                }
            }
            if (schemaName == null) {
                Log.log(Log.LOG_WARNING, "Could not find schema for relation: " + relationName);
                schemaName = schema;
            }
        }

        GenericColumn depcy = new GenericColumn(schemaName, relationName, DbObjType.TABLE);
        if (!isSystemSchema(schemaName)) {
            depcies.add(depcy);
        }
        return depcy;
    }

    protected void addTypeDepcy(Data_typeContext type) {
        Schema_qualified_name_nontypeContext typeName = type.predefined_type().schema_qualified_name_nontype();

        if (typeName != null) {
            IdentifierContext qual = typeName.identifier();
            String schemaName = qual == null ? this.schema : qual.getText();

            if (!isSystemSchema(schemaName)) {
                depcies.add(new GenericColumn(schemaName,
                        typeName.identifier_nontype().getText(), DbObjType.TYPE));
            }
        }
    }

    /**
     * @return column with its type
     */
    protected Pair<String, String> processColumn(Schema_qualified_nameContext qname) {
        List<IdentifierContext> ids = qname.identifier();
        String columnName = QNameParser.getFirstName(ids);
        String columnType = TypesSetManually.COLUMN;
        Pair<String, String> pair = new Pair<>(columnName, null);

        if (ids.size() > 1) {
            String schemaName = QNameParser.getThirdName(ids);
            String columnParent = QNameParser.getSecondName(ids);

            Entry<String, GenericColumn> ref = findReference(schemaName, columnParent, columnName);
            List<Pair<String, String>> refComplex;
            if (ref != null) {
                GenericColumn referencedTable = ref.getValue();
                if (referencedTable != null) {
                    columnType = addFilteredColumnDepcy(
                            referencedTable.schema, referencedTable.table, columnName);
                } else if ((refComplex = findReferenceComplex(columnParent)) != null) {
                    columnType = refComplex.stream()
                            .filter(entry -> columnName.equals(entry.getKey()))
                            .map(Entry::getValue)
                            .findAny()
                            .orElseGet(() -> {
                                Log.log(Log.LOG_WARNING, "Column " + columnName +
                                        " not found in complex " + columnParent);
                                return TypesSetManually.COLUMN;
                            });
                } else {
                    Log.log(Log.LOG_WARNING, "Complex not found: " + columnParent);
                }
            } else {
                Log.log(Log.LOG_WARNING, "Unknown column reference: "
                        + schemaName + ' ' + columnParent + ' ' + columnName);
            }
        } else {
            // table-less columns analysis
            columnType = processTablelessColumn(columnName);
        }

        pair.setValue(columnType);

        return pair;
    }

    /**
     * Add a dependency only from the column of the user object. Always return its type.
     *
     * @param relation user or system object which contains column 'colName'
     * @param colName dependency from this column will be added
     * @return column type
     */
    private String addFilteredColumnDepcy(String schemaName, String relationName, String colName) {
        Stream<Pair<String, String>> columns = addFilteredRelationColumnsDepcies(
                schemaName, relationName, col -> col.equals(colName));
        // handle system columns; look for relation anyway for a potential 'not found' warning
        // do not use the stream nor add the depcy though
        switch (colName) {
        case "oid":
        case "tableoid":
            return "oid";
        case "xmin":
        case "xmax":
            return "xid";
        case "cmin":
        case "cmax":
            return "cid";
        case "ctid":
            return "tid";
        default:
            break;
        }
        if (columns != null) {
            Optional<String> type = columns.findAny()
                    .map(Pair::getSecond);
            if (type.isPresent()) {
                return type.get();
            } else {
                Log.log(Log.LOG_WARNING, "Column " + colName + " not found in relation "
                        + relationName);
            }
        }
        return TypesSetManually.COLUMN;
    }

    /**
     * Terminal operation must be called on the returned stream
     * for depcy addition to take effect!
     * <br><br>
     * Returns a stream of relation columns filtered with the given predicate.
     * When this stream is terminated, and if the relation is a user relation,
     * side-effect depcy-addition is performed for all columns satisfying the predicate. <br>
     * If a short-circuiting operation is used to terminate the stream
     * then only some column depcies will be added.
     *<br><br>
     * This ugly solution was chosen because all others lead to any of the following:<ul>
     * <li>code duplicaton </li>
     * <li>depcy addition/relation search logic leaking into other classes </li>
     * <li>inefficient filtering on the hot path (predicate matching a single column) </li>
     * <li>and/or other performance/allocation inefficiencies </li>
     * @param schemaName
     * @param relationName
     * @param colNamePredicate
     * @return column stream with  attached depcy-addition peek-step;
     *          null if no relation found
     */
    protected Stream<Pair<String, String>> addFilteredRelationColumnsDepcies(String schemaName,
            String relationName, Predicate<String> colNamePredicate) {
        IRelation relation = findRelations(schemaName, relationName)
                .findAny()
                .orElse(null);
        if (relation == null) {
            Log.log(Log.LOG_WARNING, "Relation not found: " + schemaName + '.' + relationName);
            return null;
        }

        Stream<Pair<String, String>> cols = relation.getRelationColumns()
                .filter(col -> colNamePredicate.test(col.getFirst()));
        if (DbObjNature.USER == relation.getStatementNature()) {
            // hack
            cols = cols.peek(col -> depcies.add(
                    new GenericColumn(relation.getContainingSchema().getName(),
                            relation.getName(), col.getFirst(), DbObjType.COLUMN)));
        }
        return cols;
    }

    private String processTablelessColumn(String columnName) {
        // Contains column type with nature mark of column.
        List<Entry<DbObjNature, String>> resultColTypeWithNatureMark = new ArrayList<>();

        // Comparing 'tableless column' with columns from 'unaliased namespace' and
        // getting corresponding type for 'tableless column'.
        for (GenericColumn gTableOrView : getAllUnaliasedNmsp()) {
            Entry<DbObjNature, String> colType = getTypeOfCorrespondingColWithNatureMark(columnName,
                    getRelationColumnsWithNatureMark(gTableOrView.schema, gTableOrView.table));
            if (colType != null) {
                if (DbObjNature.USER.equals(colType.getKey())) {
                    addColumnDepcy(gTableOrView.schema, gTableOrView.table, columnName);
                }
                resultColTypeWithNatureMark.add(colType);
            }
        }

        // Comparing 'tableless column' with columns from aliased table or view and
        // getting corresponding type for 'tableless column'.
        for (Entry<String, GenericColumn> nmsp : getAllReferences().entrySet()) {
            GenericColumn gTableOrView = nmsp.getValue();
            if (gTableOrView == null) {
                continue;
            }
            Entry<DbObjNature, String> colType = getTypeOfCorrespondingColWithNatureMark(columnName,
                    getRelationColumnsWithNatureMark(gTableOrView.schema, gTableOrView.table));
            if (colType != null) {
                if (DbObjNature.USER.equals(colType.getKey())) {
                    addColumnDepcy(gTableOrView.schema, gTableOrView.table, columnName);
                }
                resultColTypeWithNatureMark.add(colType);
            }
        }

        // Comparing 'tableless column' with columns from subquery and
        // getting corresponding type for 'tableless column'.
        resultColTypeWithNatureMark.addAll(getTypeOfCorrespondingColComplex(columnName,
                getAllReferencesComplex()).stream()
                .map(type -> new SimpleEntry<>(DbObjNature.USER, type))
                .collect(Collectors.toList()));

        if (resultColTypeWithNatureMark.size() == 1) {
            return resultColTypeWithNatureMark.get(0).getValue();
        } else if (resultColTypeWithNatureMark.size() > 1) {
            // TODO Warn the user about an error of ambiguity in the dialog.
            Log.log(Log.LOG_ERROR, "Ambiguous column reference: " + columnName);
        }
        return TypesSetManually.COLUMN;
    }

    private List<String> getTypeOfCorrespondingColComplex(String columnName,
            Map<String, List<Pair<String, String>>> colsOfAlias) {
        List<String> columnTypes = new ArrayList<>();
        for (Entry<String, List<Pair<String, String>>> nmsp : colsOfAlias.entrySet()) {
            String colType = getTypeOfCorrespondingCol(columnName, nmsp.getValue());
            if (colType != null) {
                columnTypes.add(colType);
            }
        }
        return columnTypes;
    }

    private String getTypeOfCorrespondingCol(String columnName,
            List<Pair<String, String>> tableOrViewColumns) {
        for (Pair<String, String> colPair : tableOrViewColumns) {
            if (columnName.equals(colPair.getKey())) {
                return colPair.getValue();
            }
        }
        return null;
    }

    private Entry<DbObjNature, String> getTypeOfCorrespondingColWithNatureMark(String columnName,
            List<Entry<DbObjNature, List<Pair<String, String>>>> tblOrViewColsWithNatureMark) {
        for (Entry<DbObjNature, List<Pair<String, String>>> entryColPairs : tblOrViewColsWithNatureMark) {
            for (Pair<String, String> colPair : entryColPairs.getValue()) {
                if (columnName.equals(colPair.getKey())) {
                    return new SimpleEntry<>(entryColPairs.getKey(), colPair.getValue());
                }
            }
        }
        return null;
    }

    /**
     * Gives lists of relation columns (name-type) with nature marks
     * for given schemaName and relationName.
     *
     * @param qualSchemaName
     * @param relationName
     * @return lists of relation columns (name-type) with nature marks
     * for given schemaName and relationName
     */
    protected List<Entry<DbObjNature, List<Pair<String, String>>>> getRelationColumnsWithNatureMark(String qualSchemaName,
            String relationName) {
        return findRelations(qualSchemaName, relationName)
                .map(r -> new SimpleEntry<>(r.getStatementNature(), r.getRelationColumns().collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    protected void addColumnsDepcies(Schema_qualified_nameContext table, List<IdentifierContext> cols) {
        List<IdentifierContext> ids = table.identifier();
        String schemaName = QNameParser.getSchemaName(ids, schema);
        String tableName = QNameParser.getFirstName(ids);
        for (IdentifierContext col : cols) {
            String columnName = col.getText();
            addFilteredColumnDepcy(schemaName, tableName, columnName);
        }
    }

    protected void addFunctionDepcy(IFunction function) {
        if (DbObjNature.USER == function.getStatementNature()) {
            depcies.add(new GenericColumn(function.getContainingSchema().getName(),
                    function.getName(), DbObjType.FUNCTION));
        }
    }

    /**
     * Use only in contexts where function can be pinpointed only by its name.
     * Such as ::regproc casts.
     */
    protected void addFunctionDepcyNotOverloaded(List<IdentifierContext> ids) {
        IdentifierContext schemaNameCtx = QNameParser.getSchemaNameCtx(ids);
        String schemaName;
        if (schemaNameCtx != null) {
            schemaName = schemaNameCtx.getText();
            if (isSystemSchema(schemaName)) {
                return;
            }
        } else {
            schemaName = schema;
        }

        String functionName = QNameParser.getFirstName(ids);
        PgFunction function = db.getSchema(schemaName).getFunctions().stream()
                .filter(f -> functionName.equals(f.getBareName()))
                .findAny().orElse(null);
        if (function != null) {
            depcies.add(new GenericColumn(schemaName, function.getName(), DbObjType.FUNCTION));
        }
    }

    protected GenericColumn addColumnDepcy(String schemaName, String tableOrView, String columnName) {
        String sName = schemaName != null ? schemaName : this.schema;
        GenericColumn genericColumn = new GenericColumn(sName, tableOrView, columnName, DbObjType.COLUMN);
        depcies.add(genericColumn);
        return genericColumn;
    }

    protected void addFunctionSigDepcy(String signature) {
        SQLParser p = AntlrParser.makeBasicParser(SQLParser.class, signature, "function signature");
        Function_args_parserContext sig = p.function_args_parser();
        List<IdentifierContext> ids = sig.schema_qualified_name().identifier();

        String schemaName = null;
        IdentifierContext schemaNameCtx = QNameParser.getSchemaNameCtx(ids);
        if (schemaNameCtx != null) {
            schemaName = schemaNameCtx.getText();
        } else {
            if (db.getSchema(schema).containsFunction(signature)) {
                schemaName = schema;
            }
            for (ISchema s : systemStorage.getSchemas()) {
                if (s.containsFunction(signature)) {
                    schemaName = s.getName();
                    break;
                }
            }

            if (schemaName == null) {
                Log.log(Log.LOG_WARNING, "Could not find schema for function: " + signature);
                schemaName = schema;
            }
        }

        if (!isSystemSchema(schemaName)) {
            depcies.add(new GenericColumn(schemaName,
                    PgDiffUtils.getQuotedName(QNameParser.getFirstName(ids)) +
                    ParserAbstract.getFullCtxText(sig.function_args()), DbObjType.FUNCTION));
        }
    }

    protected void addSchemaDepcy(List<IdentifierContext> ids) {
        String schemaName = QNameParser.getFirstName(ids);
        if (!isSystemSchema(schemaName)) {
            depcies.add(new GenericColumn(schemaName, DbObjType.SCHEMA));
        }
    }

    protected Stream<IRelation> findRelations(String schemaName, String relationName) {
        Stream<IRelation> foundRelations;
        if (schemaName != null) {
            if (isSystemSchema(schemaName)) {
                foundRelations = systemStorage.getSchema(schemaName).getRelations()
                        .map(r -> (IRelation) r);
            } else {
                foundRelations = db.getSchema(schemaName).getRelations();
            }
        } else {
            foundRelations = Stream.concat(db.getSchema(schema).getRelations(),
                    systemStorage.getSchema(PgSystemStorage.SCHEMA_PG_CATALOG).getRelations());
        }

        return foundRelations.filter(r -> r.getName().equals(relationName));
    }

    protected boolean isSystemSchema(String schemaName) {
        return PgSystemStorage.SCHEMA_PG_CATALOG.equals(schemaName)
                || PgSystemStorage.SCHEMA_INFORMATION_SCHEMA.equals(schemaName);
    }
}