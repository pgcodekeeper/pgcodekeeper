package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class Insert extends AbstractExpr {

    /**
     * The local namespace of this Select.<br>
     * String-Reference pairs keep track of external table aliases and names.<br>
     * String-null pairs keep track of internal query names that have only the Alias.
     */
    private final Map<String, GenericColumn> namespace = new HashMap<>();
    /**
     * Unaliased namespace keeps track of tables that have no Alias.<br>
     * It has to be separate since same-named unaliased tables from different schemas
     * can be used, requiring qualification.
     */
    private final Set<GenericColumn> unaliasedNamespace = new HashSet<>();
    /**
     * Column alias' are in a separate sets (per table) since they have two values as the Key.
     * This is not a Map because we don't connect column aliases with their columns.<br>
     * Columns of non-dereferenceable objects are aliases by default and need not to be added to this set.
     */
    private final Map<String, Set<String>> columnAliases = new HashMap<>();
    /**
     * CTE names that current level of FROM has access to.
     */
    private final Set<String> cte = new HashSet<>();

    protected Insert(AbstractExpr parent) {
        super(parent);
    }

    public Insert(String schema) {
        super(schema);
    }

    @Override
    protected AbstractExpr findCte(String cteName) {
        return cte.contains(cteName) ? this : super.findCte(cteName);
    }

    private boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    public List<String> insert(Insert_stmt_for_psqlContext insert) {
        With_clauseContext with = insert.with_clause();
        if (with != null) {
            withPerform(with, cte);
        }

        Schema_qualified_nameContext table = insert.insert_table_name;
        if (table != null) {
            List<IdentifierContext> tableIds = table.identifier();
            String tableName = QNameParser.getFirstName(tableIds);
            String schemaName = QNameParser.getSchemaName(tableIds, getDefaultSchemaName());

            boolean isCte = tableIds.size() == 1 && hasCte(tableName);
            GenericColumn depcy = null;

            if (isCte) {
                addReference(tableName, null);
            } else {
                depcy = addObjectDepcy(tableIds, DbObjType.TABLE);
                addRawTableReference(depcy);

            }

            if (insert.LEFT_PAREN() != null && insert.RIGHT_PAREN() != null) {
                addColumnDepcy(schemaName, tableName, insert.column);
            }
            if (insert.select_stmt() != null) {
                new Select(this).select(new SelectStmt(insert.select_stmt()));
            }
        }
        return null;
    }

    private boolean addReference(String alias, GenericColumn object) {
        boolean exists = namespace.containsKey(alias);
        if (exists) {
            Log.log(Log.LOG_WARNING, "Duplicate namespace entry: " + alias);
        } else {
            namespace.put(alias, object);
        }
        return !exists;
    }

    private boolean addRawTableReference(GenericColumn qualifiedTable) {
        boolean exists = !unaliasedNamespace.add(qualifiedTable);
        if (exists) {
            Log.log(Log.LOG_WARNING, "Duplicate unaliased table: "
                    + qualifiedTable.schema + ' ' + qualifiedTable.table);
        }
        return !exists;
    }

}
