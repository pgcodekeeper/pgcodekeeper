package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_args_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.DbObjNature;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public abstract class AbstractExpr {

    // TODO get current postgresql version.
    // Need to get version. I already got it from JdbcLoader(READER)
    // and put it to the 'PgDatabase' as currentPostgreSqlVersion,
    // but I couldn't get it from PgDumpLoader(WRITER), that's why for
    // cases with 'PgDumpLoader(WRITER)' the version was hard-coded in 'PgDatabase'.
    protected final PgSystemStorage systemStorage;
    private final AbstractExpr parent;
    private final Set<GenericColumn> depcies;

    protected final PgDatabase db;

    public Set<GenericColumn> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    public AbstractExpr(PgDatabase db) {
        parent = null;
        depcies = new LinkedHashSet<>();
        this.db = db;
        systemStorage = PgSystemStorage.getObjectsFromResources(db.getPostgresVersion());
    }

    protected AbstractExpr(AbstractExpr parent) {
        this.parent = parent;
        this.depcies = parent.depcies;
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

    protected Pair<IRelation, Pair<String, String>> findColumn(String name) {
        return parent == null ? null : parent.findColumn(name);
    }

    protected Pair<String, String> findColumnInComplex(String name) {
        return parent == null ? null : parent.findColumnInComplex(name);
    }

    protected GenericColumn addRelationDepcy(List<IdentifierContext> ids) {
        String schemaName = null;
        IdentifierContext schemaNameCtx = QNameParser.getSchemaNameCtx(ids);
        String relationName = QNameParser.getFirstName(ids);
        if (schemaNameCtx != null) {
            schemaName = schemaNameCtx.getText();
        }

        if (schemaName == null) {
            return new GenericColumn(ApgdiffConsts.PG_CATALOG, relationName, DbObjType.TABLE);
        }

        GenericColumn depcy = new GenericColumn(schemaName, relationName, DbObjType.TABLE);
        if (!ApgdiffUtils.isPgSystemSchema(schemaName)) {
            depcies.add(depcy);
        }
        return depcy;
    }

    protected void addTypeDepcy(Data_typeContext type) {
        Schema_qualified_name_nontypeContext typeName = type.predefined_type().schema_qualified_name_nontype();

        if (typeName != null) {
            IdentifierContext qual = typeName.identifier();
            String schemaName = qual == null ? null : qual.getText();

            if (schemaName != null && !ApgdiffUtils.isPgSystemSchema(schemaName)) {
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

        return columns.findAny().map(Pair::getSecond).orElseGet(() -> {
            Log.log(Log.LOG_WARNING,
                    "Column " + colName + " not found in relation " + relationName);
            return TypesSetManually.COLUMN;
        });
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
     *          empty stream if no relation found
     */
    protected Stream<Pair<String, String>> addFilteredRelationColumnsDepcies(String schemaName,
            String relationName, Predicate<String> colNamePredicate) {
        IRelation relation = findRelations(schemaName, relationName)
                .findAny()
                .orElse(null);
        if (relation == null) {
            Log.log(Log.LOG_WARNING, "Relation not found: " + schemaName + '.' + relationName);
            return Stream.empty();
        }

        Stream<Pair<String, String>> cols = relation.getRelationColumns()
                .filter(col -> colNamePredicate.test(col.getFirst()));
        if (DbObjNature.USER == relation.getStatementNature()) {
            // hack
            cols = cols.peek(col -> depcies.add(
                    new GenericColumn(relation.getSchemaName(),
                            relation.getName(), col.getFirst(), DbObjType.COLUMN)));
        }
        return cols;
    }

    private String processTablelessColumn(String name) {
        Pair<String, String> col = findColumnInComplex(name);
        if (col == null) {
            Pair<IRelation, Pair<String, String>> relCol = findColumn(name);
            if (relCol == null) {
                Log.log(Log.LOG_WARNING, "Tableless column not resolved: " + name);
                return TypesSetManually.COLUMN;
            }
            IRelation rel = relCol.getFirst();
            col = relCol.getSecond();
            if (rel.getStatementNature() == DbObjNature.USER) {
                depcies.add(new GenericColumn(rel.getSchemaName(), rel.getName(),
                        col.getFirst(), DbObjType.COLUMN));
            }
        }
        return col.getSecond();
    }

    protected void addColumnsDepcies(Schema_qualified_nameContext table, List<IdentifierContext> cols) {
        List<IdentifierContext> ids = table.identifier();
        String schemaName = QNameParser.getSchemaName(ids);
        String tableName = QNameParser.getFirstName(ids);
        for (IdentifierContext col : cols) {
            addFilteredColumnDepcy(schemaName, tableName, col.getText());
        }
    }

    protected void addFunctionDepcy(IFunction function) {
        if (DbObjNature.USER == function.getStatementNature()) {
            depcies.add(new GenericColumn(function.getSchemaName(),
                    function.getName(), DbObjType.FUNCTION));
        }
    }

    /**
     * Use only in contexts where function can be pinpointed only by its name.
     * Such as ::regproc casts.
     */
    protected void addFunctionDepcyNotOverloaded(List<IdentifierContext> ids) {
        IdentifierContext schemaNameCtx = QNameParser.getSchemaNameCtx(ids);
        String schemaName = null;
        if (schemaNameCtx != null) {
            schemaName = schemaNameCtx.getText();
        }

        if (schemaName == null || ApgdiffUtils.isPgSystemSchema(schemaName)) {
            return;
        }

        String functionName = QNameParser.getFirstName(ids);
        AbstractFunction function = findSchema(schemaName, ids.get(0)).getFunctions().stream()
                .filter(f -> functionName.equals(f.getBareName()))
                .findAny().orElse(null);
        if (function != null) {
            depcies.add(new GenericColumn(schemaName, function.getName(), function.getStatementType()));
        }
    }

    protected void addFunctionSigDepcy(String signature) {
        SQLParser p = AntlrParser.makeBasicParser(SQLParser.class, signature, "function signature");
        Function_args_parserContext sig = p.function_args_parser();
        List<IdentifierContext> ids = sig.schema_qualified_name().identifier();

        String schemaName = null;
        IdentifierContext schemaNameCtx = QNameParser.getSchemaNameCtx(ids);
        if (schemaNameCtx != null) {
            schemaName = schemaNameCtx.getText();
        }

        if (schemaName != null && !ApgdiffUtils.isPgSystemSchema(schemaName)) {
            depcies.add(new GenericColumn(schemaName,
                    PgDiffUtils.getQuotedName(QNameParser.getFirstName(ids)) +
                    ParserAbstract.getFullCtxText(sig.function_args()), DbObjType.FUNCTION));
        }
    }

    protected void addSchemaDepcy(List<IdentifierContext> ids) {
        String schemaName = QNameParser.getFirstName(ids);
        if (!ApgdiffUtils.isPgSystemSchema(schemaName)) {
            depcies.add(new GenericColumn(schemaName, DbObjType.SCHEMA));
        }
    }

    protected Stream<IRelation> findRelations(String schemaName, String relationName) {
        Stream<IRelation> foundRelations;
        if (schemaName != null) {
            if (ApgdiffUtils.isPgSystemSchema(schemaName)) {
                foundRelations = systemStorage.getSchema(schemaName).getRelations()
                        .map(r -> (IRelation) r);
            } else {
                foundRelations = findSchema(schemaName, null).getRelations();
            }
        } else {
            foundRelations = systemStorage.getPgCatalog().getRelations()
                    .map(r -> (IRelation) r);
        }

        return foundRelations.filter(r -> r.getName().equals(relationName));
    }

    protected AbstractSchema findSchema(String schemaName, ParserRuleContext errorCtx) {
        AbstractSchema foundSchema = db.getSchema(schemaName);
        if (foundSchema == null) {
            throw new UnresolvedReferenceException("Schema '" + schemaName + "' not found!",
                    errorCtx != null ? errorCtx.getStart() : null);
        }
        return foundSchema;
    }
}