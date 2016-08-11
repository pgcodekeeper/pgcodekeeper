package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alias_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_queryContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractExprWithNmspc extends AbstractExpr {

    /**
     * The local namespace of this Select.<br>
     * String-Reference pairs keep track of external table aliases and
     * names.<br>
     * String-null pairs keep track of internal query names that have only the
     * Alias.
     */
    protected final Map<String, GenericColumn> namespace = new HashMap<>();
    /**
     * Unaliased namespace keeps track of tables that have no Alias.<br>
     * It has to be separate since same-named unaliased tables from different
     * schemas can be used, requiring qualification.
     */
    protected final Set<GenericColumn> unaliasedNamespace = new HashSet<>();
    /**
     * Column alias' are in a separate sets (per table) since they have two
     * values as the Key. This is not a Map because we don't connect column
     * aliases with their columns.<br>
     * Columns of non-dereferenceable objects are aliases by default and need
     * not to be added to this set.
     */
    protected final Map<String, Set<String>> columnAliases = new HashMap<>();
    /**
     * CTE names that current level of FROM has access to.
     */
    protected final Set<String> cte = new HashSet<>();

    public AbstractExprWithNmspc(String schema) {
        super(schema);
    }

    protected AbstractExprWithNmspc(AbstractExpr parent) {
        super(parent);
    }

    @Override
    protected AbstractExprWithNmspc findCte(String cteName) {
        return cte.contains(cteName) ? this : super.findCte(cteName);
    }

    @Override
    protected Entry<String, GenericColumn> findReference(String schema, String name, String column) {
        Entry<String, GenericColumn> ref = findReferenceInNmspc(schema, name, column);
        return ref == null ? super.findReference(schema, name, column) : ref;
    }

    protected Entry<String, GenericColumn> findReferenceInNmspc(String schema, String name, String column) {
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
        } else {
            return null;
        }
    }

    protected boolean addReference(String alias, GenericColumn object) {
        boolean exists = namespace.containsKey(alias);
        if (exists) {
            Log.log(Log.LOG_WARNING, "Duplicate namespace entry: " + alias);
        } else {
            namespace.put(alias, object);
        }
        return !exists;
    }

    protected boolean addRawTableReference(GenericColumn qualifiedTable) {
        boolean exists = !unaliasedNamespace.add(qualifiedTable);
        if (exists) {
            Log.log(Log.LOG_WARNING,
                    "Duplicate unaliased table: " + qualifiedTable.schema + ' ' + qualifiedTable.table);
        }
        return !exists;
    }

    protected boolean addColumnReference(String alias, String column) {
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

    protected void addNameReference(Schema_qualified_nameContext name, Alias_clauseContext alias) {
        if (alias == null) {
            addNameReference(name, null, null);
        } else {
            addNameReference(name, alias.alias, alias.column_alias);
        }
    }

    protected void addNameReference(Schema_qualified_nameContext name, IdentifierContext alias,
            List<IdentifierContext> columnAliases) {
        List<IdentifierContext> ids = name.identifier();
        String firstName = QNameParser.getFirstName(ids);

        boolean isCte = ids.size() == 1 && hasCte(firstName);
        GenericColumn depcy = null;
        if (!isCte) {
            depcy = addObjectDepcy(ids, DbObjType.TABLE);
        }

        if (alias != null) {
            String aliasName = alias.getText();
            boolean added = addReference(aliasName, depcy);
            if (!added && !isCte && columnAliases != null && !columnAliases.isEmpty()) {
                for (IdentifierContext columnAlias : columnAliases) {
                    addColumnReference(aliasName, columnAlias.getText());
                }
            }
        } else if (isCte) {
            addReference(firstName, null);
        } else {
            addRawTableReference(depcy);
        }
    }

    protected void analyzeCte(With_clauseContext with) {
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
                withProcessor.analyze(withSelect);
            } else {
                withProcessor.analyze(withSelect);
                duplicate = !cte.add(withName);
            }
            if (duplicate) {
                Log.log(Log.LOG_WARNING, "Duplicate CTE " + withName);
            }
        }
    }

    public abstract List<String> analyze(ParserRuleContext ruleCtx);
}
