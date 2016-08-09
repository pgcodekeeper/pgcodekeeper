package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_queryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractExpr {

    private final String schema;
    private final AbstractExpr parent;
    private final Set<GenericColumn> depcies;

    /**
     * CTE names that current level of FROM has access to.
     */
    protected final Set<String> cte = new HashSet<>();

    public Set<GenericColumn> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    public AbstractExpr(String schema) {
        this.schema = schema;
        parent = null;
        depcies = new LinkedHashSet<>();
    }

    protected AbstractExpr(AbstractExpr parent) {
        this.schema = parent.schema;
        this.parent = parent;
        depcies = parent.depcies;
    }

    protected AbstractExpr findCte(String cteName) {
        return parent == null ? null : parent.findCte(cteName);
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
        String schema = QNameParser.getSchemaName(ids, this.schema);
        GenericColumn depcy = new GenericColumn(schema, QNameParser.getFirstName(ids), type);
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
     * @return column name or null if referenced qname is not found
     */
    protected String addColumnDepcy(Schema_qualified_nameContext qname) {
        List<IdentifierContext> ids = qname.identifier();
        String column = QNameParser.getFirstName(ids);

        // TODO table-less columns are pending full analysis
        if (ids.size() > 1) {
            String schema = QNameParser.getThirdName(ids);
            String table = QNameParser.getSecondName(ids);

            Entry<String, GenericColumn> ref = findReference(schema, table, column);
            if (ref == null) {
                Log.log(Log.LOG_WARNING, "Unknown column reference: "
                        + schema + ' ' + table + ' ' + column);
                return null;
            }

            GenericColumn referencedTable = ref.getValue();
            if (referencedTable != null) {
                depcies.add(new GenericColumn(referencedTable.schema, referencedTable.table, column, DbObjType.COLUMN));
            }
        }
        return column;
    }

    protected String getDefaultSchemaName() {
        return this.schema;
    }

    protected List<String> addColumnDepcy(String schemaName, String tableName, List<IdentifierContext> cols) {
        List<String> columns = new LinkedList<>();
        for (IdentifierContext col : cols) {
            depcies.add(new GenericColumn(schemaName, tableName, col.getText(), DbObjType.COLUMN));
            columns.add(col.getText());
        }
        return columns;
    }

    protected void withPerform(With_clauseContext with, Set<String> cte) {
        boolean recursive = with.RECURSIVE() != null;
        for (With_queryContext withQuery : with.with_query()) {
            String withName = withQuery.query_name.getText();

            Select_stmtContext withSelect = withQuery.select_stmt();
            if (withSelect == null) {
                Log.log(Log.LOG_WARNING, "Skipped analisys of modifying CTE " + withName);
                continue;
            }

            // add CTE name to the visible CTEs list after processing the query for normal CTEs
            // and before for recursive ones
            Select withProcessor = new Select(this);
            boolean duplicate;
            if (recursive) {
                duplicate = !cte.add(withName);
                withProcessor.analize(withSelect);
            } else {
                withProcessor.analize(withSelect);
                duplicate = !cte.add(withName);
            }
            if (duplicate) {
                Log.log(Log.LOG_WARNING, "Duplicate CTE " + withName);
            }
        }
    }

    protected abstract String analize(Vex vex);
}
