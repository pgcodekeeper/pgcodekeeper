package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_setContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Using_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class Update extends AbstractExpr {

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

    protected Update(AbstractExpr parent) {
        super(parent);
    }

    public Update(String schema) {
        super(schema);
    }

    @Override
    protected AbstractExpr findCte(String cteName) {
        return cte.contains(cteName) ? this : super.findCte(cteName);
    }

    private boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    public List<String> update(Update_stmt_for_psqlContext update) {
        With_clauseContext with = update.with_clause();
        if (with != null) {
            withPerform(with, cte);
        }

        Schema_qualified_nameContext table = update.update_table_name;
        if (table != null) {
            List<IdentifierContext> tableIds = table.identifier();
            String tableName = QNameParser.getFirstName(tableIds);
            //String schemaName = QNameParser.getSchemaName(tableIds, getDefaultSchemaName());

            boolean isCte = tableIds.size() == 1 && hasCte(tableName);
            GenericColumn depcy = null;

            if (isCte) {
                addReference(tableName, null);
            } else {
                depcy = addObjectDepcy(tableIds, DbObjType.TABLE);
                addRawTableReference(depcy);

            }

            if (update.alias != null) {
                addReference(update.alias.getText(), depcy);
            }

            if (update.FROM() != null) {
                for (Using_tableContext usingTable : update.using_table()) {
                    //QNameParser.
                    tableIds = usingTable.schema_qualified_name().identifier();
                    tableName = QNameParser.getFirstName(tableIds);
                    //schemaName = QNameParser.getSchemaName(tableIds, getDefaultSchemaName());
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

                    if (usingTable.column_references() != null) {
                        for (Schema_qualified_nameContext ids : usingTable.column_references()
                                .names_references().name) {
                            addColumnReference(usingTable.identifier().getText(), QNameParser.getFirstName(ids
                                    .identifier()));
                        }
                    }
                }
            }

            if (update.SET() != null) {
                for (Update_setContext updateSet : update.update_set()) {
                    if (updateSet.table_subquery() != null) {
                        new Select(this).select(new SelectStmt(updateSet.table_subquery().select_stmt()));
                    } else if (updateSet.value != null && !updateSet.value.isEmpty()) {
                        for (VexContext vex : updateSet.value) {
                            new ValueExpr(this).vex(new Vex(vex));
                        }
                    }
                }
            }

            if (update.WHERE() != null && update.vex() != null) {
                new ValueExpr(this).vex(new Vex(update.vex()));
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

    private boolean addColumnReference(String alias, String column) {
        Set<String> columns = columnAliases.get(alias);
        if (columns == null) {
            columns = new HashSet<>();
            columnAliases.put(alias, columns);
        }
        boolean exists = !columns.add(column);
        if (exists) {
            Log.log(Log.LOG_WARNING, "Duplicate column alias: " + alias + ' ' + column);
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
