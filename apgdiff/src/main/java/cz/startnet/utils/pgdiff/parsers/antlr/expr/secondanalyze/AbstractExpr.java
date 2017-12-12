package cz.startnet.utils.pgdiff.parsers.antlr.expr.secondanalyze;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cz.startnet.utils.pgdiff.PgDiffUtils;
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
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTable.Inherits;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractExpr {

    protected final String schema;
    private final AbstractExpr parent;
    private final Set<GenericColumn> depcies;

    protected final PgDatabase db;

    /*
     *  Map contains alias and list of pairs<columnName, columnType>. Pairs returned by aliased subquery.
     *  It will be used with "...FROM (function()) alias;" and with "...FROM (subquery) alias;".
     */
    protected final Map<String, List<Entry<String, String>>> complexNamespace = new HashMap<>();
    /*
     *  Map contains alias and list of pairs<columnName, columnType>. Pairs returned by aliased subquery.
     *  It will be used with "WITH alias1 AS (SELECT...), alias2 AS (SELECT...) SELECT ... FROM alias1".
     */
    protected final Map<String, List<Entry<String, String>>> cteConstruction = new HashMap<>();

    public Map<String, List<Entry<String, String>>> getComplexNamespace() {
        return complexNamespace;
    }

    public Map<String, List<Entry<String, String>>> getCteConstruction() {
        return cteConstruction;
    }

    public Set<GenericColumn> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    public AbstractExpr(String schema, PgDatabase db) {
        this.schema = schema;
        parent = null;
        depcies = new LinkedHashSet<>();
        this.db = db;
    }

    protected AbstractExpr(AbstractExpr parent) {
        this.schema = parent.schema;
        this.parent = parent;
        depcies = parent.depcies;
        this.db = parent.db;
    }

    protected AbstractExprWithNmspc<?> findCte(String cteName) {
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

    protected GenericColumn addObjectDepcy(List<IdentifierContext> ids, DbObjType type) {
        GenericColumn depcy = new GenericColumn(
                QNameParser.getSchemaName(ids, schema), QNameParser.getFirstName(ids), type);
        depcies.add(depcy);
        return depcy;
    }

    protected GenericColumn addFunctionDepcy(Schema_qualified_name_nontypeContext funcNameCtx, String signature){
        IdentifierContext sch = funcNameCtx.schema;
        String funcSchema = sch != null ? sch.getText() : schema;
        GenericColumn depcy = new GenericColumn(funcSchema, signature, DbObjType.FUNCTION);
        depcies.add(depcy);
        return depcy;
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
    protected Entry<String, String> addColumnDepcy(Schema_qualified_nameContext qname) {
        List<IdentifierContext> ids = qname.identifier();
        String column = QNameParser.getFirstName(ids);
        Entry<String, String> pair = new SimpleEntry<>(column, TypesSetManually.COLUMN);
        String columnParent = null;

        // TODO table-less columns are pending full analysis
        if (ids.size() > 1) {
            String schema = QNameParser.getThirdName(ids);
            columnParent = QNameParser.getSecondName(ids);

            Entry<String, GenericColumn> ref = findReference(schema, columnParent, column);
            if (ref == null) {
                Log.log(Log.LOG_WARNING, "Unknown column reference: "
                        + schema + ' ' + columnParent + ' ' + column);
            } else {
                GenericColumn referencedTable = ref.getValue();
                if (referencedTable != null) {
                    columnParent = referencedTable.table;
                    depcies.add(new GenericColumn(referencedTable.schema, columnParent, column, DbObjType.COLUMN));
                }
            }

            String type;
            type = getColumnType(columnParent, column);
            pair.setValue(type);
        }

        return pair;
    }

    private String getColumnType(String columnParent, String column) {
        PgSchema s = db.getSchema(schema);

        String type = TypesSetManually.COLUMN_WITH_RECURSIVE_OR_OTHER;

        if (schema != null && columnParent != null) {
            PgTable t;
            PgView v;
            if ((t = s.getTable(columnParent)) != null) {
                PgColumn col = t.getColumn(column);

                if (col != null) {
                    type = col.getType();
                } else {
                    List<Inherits> inheritsList = t.getInherits();
                    if (!inheritsList.isEmpty()) {
                        for (Inherits inht : inheritsList) {
                            PgTable tInherits = s.getTable(inht.getValue());
                            col = tInherits.getColumn(column);
                            if (col != null) {
                                type = col.getType();
                                break;
                            }
                        }
                    }
                }
            } else if ((v = s.getView(columnParent)) != null) {
                for (Entry<String, String> col : v.getColumnsOfQuery()) {
                    if (column.equals(col.getKey())) {
                        type = col.getValue();
                        break;
                    }
                }
            } else if (complexNamespace.containsKey(columnParent)) {
                type = complexNamespace.get(columnParent).stream()
                        .filter(entry -> column.equals(entry.getKey()))
                        .map(entry -> entry.getValue()).findFirst().get();
            } else {
                type = TypesSetManually.COLUMN_UNKNOWN;
            }
        }
        return type;
    }


    protected void addColumnsDepcies(Schema_qualified_nameContext table, List<IdentifierContext> cols) {
        List<IdentifierContext> ids = table.identifier();
        String schemaName = QNameParser.getSchemaName(ids, schema);
        String tableName = QNameParser.getFirstName(ids);
        for (IdentifierContext col : cols) {
            depcies.add(new GenericColumn(schemaName, tableName, col.getText(), DbObjType.COLUMN));
        }
    }

    protected void addFunctionSigDepcy(String signature) {
        SQLParser p = AntlrParser.makeBasicParser(SQLParser.class, signature, "function signature");
        Function_args_parserContext sig = p.function_args_parser();
        List<IdentifierContext> ids = sig.schema_qualified_name().identifier();
        depcies.add(new GenericColumn(QNameParser.getSchemaName(ids, schema),
                PgDiffUtils.getQuotedName(QNameParser.getFirstName(ids)) +
                ParserAbstract.getFullCtxText(sig.function_args()),
                DbObjType.FUNCTION));
    }

    protected void addSchemaDepcy(List<IdentifierContext> ids) {
        depcies.add(new GenericColumn(QNameParser.getFirstName(ids), DbObjType.SCHEMA));
    }

    protected static interface TypesSetManually {

        String UNKNOWN = "unknown";
        String UNKNOWN_ARRAY = "unknown[]";

        String COLUMN = "column";
        String COLUMN_UNKNOWN = "columnUnknown";
        String COLUMN_WITH_RECURSIVE_OR_OTHER = "columnWithRecursionOrOther";

        String FUNCTION_COLUMN = "functionCol";

        String NULL = "NULL";
        String QUALIFIED_ASTERISK = "qualifiedAsterisk";

        String BOOLEAN = "boolean";
        String INTEGER = "integer";
        String DOUBLE_PRECISION = "double precision";
        String TEXT = "text";
        String NUMERIC = "numeric";

    }
}