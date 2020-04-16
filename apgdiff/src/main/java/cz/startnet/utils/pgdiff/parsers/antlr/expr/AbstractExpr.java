package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_args_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Indirection_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.ISchema;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.ModPair;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public abstract class AbstractExpr {

    protected static final String NONAME = "?column?";

    // TODO get current postgresql version.
    // Need to get version. I already got it from JdbcLoader(READER)
    // and put it to the 'PgDatabase' as currentPostgreSqlVersion,
    // but I couldn't get it from PgDumpLoader(WRITER), that's why for
    // cases with 'PgDumpLoader(WRITER)' the version was hard-coded in 'PgDatabase'.
    protected final IDatabase db;
    private final AbstractExpr parent;
    private final Set<GenericColumn> depcies;
    private final Set<DbObjType> disabledDepcies;

    private FullAnalyze fullAnalyze;

    public Set<GenericColumn> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    public AbstractExpr(IDatabase db, DbObjType... disabledDepcies) {
        parent = null;
        depcies = new LinkedHashSet<>();
        this.db = db;
        this.disabledDepcies = Arrays.stream(disabledDepcies)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(DbObjType.class)));
    }

    protected AbstractExpr(AbstractExpr parent) {
        this(parent, parent.depcies);
    }

    protected AbstractExpr(AbstractExpr parent, Set<GenericColumn> depcies) {
        this.parent = parent;
        this.depcies = depcies;
        this.db = parent.db;
        this.fullAnalyze = parent.fullAnalyze;
        this.disabledDepcies = parent.disabledDepcies;
    }

    public void setFullAnaLyze(FullAnalyze fullAnalyze) {
        this.fullAnalyze = fullAnalyze;
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
        String schemaName = QNameParser.getSchemaName(ids);
        String relationName = QNameParser.getFirstName(ids);

        if (schemaName == null) {
            return new GenericColumn(ApgdiffConsts.PG_CATALOG, relationName, DbObjType.TABLE);
        }

        GenericColumn depcy = new GenericColumn(schemaName, relationName, DbObjType.TABLE);
        addDepcy(depcy);
        return depcy;
    }

    protected GenericColumn addTypeDepcy(Data_typeContext type) {
        Schema_qualified_name_nontypeContext typeName = type.predefined_type().schema_qualified_name_nontype();
        if (typeName == null) {
            return new GenericColumn(ApgdiffConsts.PG_CATALOG, ParserAbstract.getTypeName(type),
                    DbObjType.TYPE);
        }
        return addTypeDepcy(typeName);
    }

    protected GenericColumn addTypeDepcy(Schema_qualified_name_nontypeContext typeName) {
        String schemaName = ApgdiffConsts.PG_CATALOG;
        IdentifierContext schemaCtx = typeName.identifier();
        String name = typeName.identifier_nontype().getText();

        if (schemaCtx != null) {
            schemaName = schemaCtx.getText();
        }

        GenericColumn gc = new GenericColumn(schemaName, name, DbObjType.TYPE);
        addDepcy(gc);
        return gc;
    }

    protected void addDepcy(GenericColumn depcy) {
        if (!ApgdiffUtils.isPgSystemSchema(depcy.schema) && !disabledDepcies.contains(depcy.type)) {
            depcies.add(depcy);
        }
    }

    /**
     * @return column with its type
     */
    protected ModPair<String, String> processColumn(List<? extends ParserRuleContext> ids) {
        if (ids.size() == 1) {
            return processTablelessColumn(ids.get(0));
        }

        String columnName = QNameParser.getFirstName(ids);
        String columnParent = QNameParser.getSecondName(ids);
        String schemaName = QNameParser.getThirdName(ids);
        return processColumn(schemaName, columnParent, columnName);
    }

    protected ModPair<String, String> processColumn(String schemaName, String columnParent, String columnName) {
        String columnType = TypesSetManually.COLUMN;
        Entry<String, GenericColumn> ref = findReference(schemaName, columnParent, columnName);
        List<Pair<String, String>> refComplex;
        if (ref != null) {
            GenericColumn referencedTable = ref.getValue();
            if (referencedTable != null) {
                columnType = addFilteredColumnDepcy(
                        referencedTable.schema, referencedTable.table, columnName);
            } else if ((refComplex = findReferenceComplex(columnParent)) != null) {
                columnType = refComplex.stream()
                        .filter(entry -> columnName.equals(entry.getFirst()))
                        .map(Pair::getSecond)
                        .findAny()
                        .orElseGet(() -> {
                            log(Log.LOG_WARNING, "Column " + columnName +
                                    " not found in complex " + columnParent);
                            return TypesSetManually.COLUMN;
                        });
            } else {
                log(Log.LOG_WARNING, "Complex not found: " + columnParent);
            }
        } else {
            log(Log.LOG_WARNING, "Unknown column reference: "
                    + schemaName + ' ' + columnParent + ' ' + columnName);
        }

        return new ModPair<>(columnName, columnType);
    }

    /**
     * Add a dependency only from the column of the user object. Always return its type.
     *
     * @param relation user or system object which contains column 'colName'
     * @param colName dependency from this column will be added
     * @return column type
     */
    protected String addFilteredColumnDepcy(String schemaName, String relationName, String colName) {
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
            log(Log.LOG_WARNING,
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
        IRelation relation = findRelation(schemaName, relationName);
        if (relation == null) {
            log(Log.LOG_WARNING, "Relation not found: " + schemaName + '.' + relationName);
            return Stream.empty();
        }

        Stream<Pair<String, String>> columns = relation.getRelationColumns();
        if (DbObjType.VIEW == relation.getStatementType() && columns == null) {
            analyzeViewColumns(relation);
            columns = relation.getRelationColumns();
        }

        Stream<Pair<String, String>> cols = columns
                .filter(col -> colNamePredicate.test(col.getFirst()));

        String relSchemaName = relation.getSchemaName();
        if (ApgdiffUtils.isPgSystemSchema(relSchemaName)) {
            return cols;
        }

        // hack
        return cols.peek(col -> addDepcy(new GenericColumn(relSchemaName,
                relation.getName(), col.getFirst(), DbObjType.COLUMN)));
    }

    protected void analyzeViewColumns(IRelation rel) {
        if (fullAnalyze != null) {
            fullAnalyze.analyzeView(rel.getName());
        }
    }

    protected ModPair<String, String> processTablelessColumn(ParserRuleContext id) {
        String name = id.getText();
        Pair<String, String> col = findColumnInComplex(name);
        if (col == null) {
            Pair<IRelation, Pair<String, String>> relCol = findColumn(name);
            if (relCol == null) {
                log(Log.LOG_WARNING, "Tableless column not resolved: " + name);
                return new ModPair<>(name, TypesSetManually.COLUMN);
            }
            IRelation rel = relCol.getFirst();
            col = relCol.getSecond();
            addDepcy(new GenericColumn(rel.getSchemaName(), rel.getName(),
                    col.getFirst(), DbObjType.COLUMN));
        }
        return col.copyMod();
    }

    protected void addColumnsDepcies(Schema_qualified_nameContext table,
            List<Indirection_identifierContext> columns) {
        List<IdentifierContext> ids = table.identifier();
        String schemaName = QNameParser.getSchemaName(ids);
        String tableName = QNameParser.getFirstName(ids);
        for (Indirection_identifierContext col : columns) {
            // only column name
            addFilteredColumnDepcy(schemaName, tableName, col.identifier().getText());
        }
    }

    protected void addFunctionDepcy(IFunction function) {
        addDepcy(new GenericColumn(function.getSchemaName(), function.getName(), function.getStatementType()));
    }

    /**
     * Use only in contexts where function can be pinpointed only by its name.
     * Such as ::regproc casts.
     */
    protected void addFunctionDepcyNotOverloaded(List<IdentifierContext> ids) {
        String schemaName = QNameParser.getSchemaName(ids);
        if (schemaName == null || ApgdiffUtils.isPgSystemSchema(schemaName)) {
            return;
        }

        String functionName = QNameParser.getFirstName(ids);
        availableFunctions(schemaName, ids.get(0)).stream()
        .filter(f -> functionName.equals(f.getBareName()))
        .findAny().ifPresent(this::addFunctionDepcy);
    }

    protected void addFunctionSigDepcy(String signature) {
        SQLParser p = AntlrParser.makeBasicParser(SQLParser.class, signature, "function signature");
        Function_args_parserContext sig = p.function_args_parser();
        List<IdentifierContext> ids = sig.schema_qualified_name().identifier();

        String schemaName = QNameParser.getSchemaName(ids);
        if (schemaName != null) {
            addDepcy(new GenericColumn(schemaName,
                    PgDiffUtils.getQuotedName(QNameParser.getFirstName(ids)) +
                    ParserAbstract.getFullCtxText(sig.function_args()), DbObjType.FUNCTION));
        }
    }

    protected void addSchemaDepcy(List<IdentifierContext> ids) {
        addDepcy(new GenericColumn(QNameParser.getFirstName(ids), DbObjType.SCHEMA));
    }

    protected Collection<? extends IFunction> availableFunctions(String schemaName, ParserRuleContext errorCtx) {
        return findSchema(schemaName, errorCtx).getFunctions();
    }

    protected IRelation findRelation(String schemaName, String relationName) {
        return findSchema(schemaName, null).getRelation(relationName);
    }

    private ISchema findSchema(String schemaName, ParserRuleContext errorCtx) {
        String name = schemaName == null ? ApgdiffConsts.PG_CATALOG : schemaName;
        ISchema foundSchema = db.getSchema(name);
        if (foundSchema == null) {
            throw new UnresolvedReferenceException("Schema '" + schemaName + "' not found!",
                    errorCtx != null ? errorCtx.getStart() : null);
        }
        return foundSchema;
    }

    protected void log(int level, String msg) {
        // debug method
        // Log.log(level, msg);
    }
}