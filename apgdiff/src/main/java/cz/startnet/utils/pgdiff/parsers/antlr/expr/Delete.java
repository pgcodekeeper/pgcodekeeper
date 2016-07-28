package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Using_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class Delete extends AbstractExpr {

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

    protected Delete(AbstractExpr parent) {
        super(parent);
    }

    public Delete(String schema) {
        super(schema);
    }

    @Override
    protected AbstractExpr findCte(String cteName) {
        return cte.contains(cteName) ? this : super.findCte(cteName);
    }

    private boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    public List<String> delete(Delete_stmt_for_psqlContext delete) {
        With_clauseContext with = delete.with_clause();
        if (with != null) {
            withPerform(with, cte);
        }

        Schema_qualified_nameContext table = delete.delete_table_name;
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

            if (delete.alias != null) {
                addReference(delete.alias.getText(), depcy);
            }

            if (delete.USING() != null) {
                for (Using_tableContext usingTable : delete.using_table()) {
                    tableIds = usingTable.schema_qualified_name().identifier();
                    tableName = QNameParser.getFirstName(tableIds);
                    isCte = tableIds.size() == 1 && hasCte(tableName);
                    depcy = null;

                    if (isCte) {
                        addReference(tableName, null);
                    } else {
                        depcy = addObjectDepcy(tableIds, DbObjType.TABLE);
                        addRawTableReference(depcy);
                    }
                    if (usingTable.identifier() != null) {
                        addReference(usingTable.identifier().getText(), depcy);
                    }
                }
            }

            if (delete.WHERE() != null && delete.vex() != null) {
                new ValueExpr(this).vex(new Vex(delete.vex()));
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

    @Override
    protected Entry<String, GenericColumn> findReference(String schema, String name, String column) {
        //if (!inFrom || lateralAllowed) {
        boolean found;
        GenericColumn dereferenced = null;
        if (schema == null && namespace.containsKey(name)) {
            found = true;
            dereferenced = namespace.get(name);
        } else if (!unaliasedNamespace.isEmpty()) {
            // simple empty check to save some allocations
            // it will almost always be empty
            for (GenericColumn unaliased : unaliasedNamespace) {
                if (unaliased.table.equals(name) &&
                        (schema == null || unaliased.schema.equals(schema))) {
                    if (dereferenced == null) {
                        dereferenced = unaliased;
                        if (schema != null) {
                            // fully qualified, no ambiguity search needed
                            break;
                        }
                    } else {
                        Log.log(Log.LOG_WARNING, "Ambiguous reference: " + name);
                    }
                }
            }
            found = dereferenced != null;
        } else {
            found = false;
        }

        if (found) {
            // column aliases imply there must be a corresponding table alias
            // so we may defer their lookup until here

            // also, if we cannot dereference an existing name it's safe to assume
            // all its columns are aliases
            // this saves a lookup and extra space in columnAliases
            if (column != null && dereferenced != null) {
                Set<String> columns = columnAliases.get(name);
                if (columns != null && columns.contains(column)) {
                    dereferenced = null;
                }
            }
            return new SimpleEntry<>(name, dereferenced);
        }
        //}
        return super.findReference(schema, name, column);
    }

}
