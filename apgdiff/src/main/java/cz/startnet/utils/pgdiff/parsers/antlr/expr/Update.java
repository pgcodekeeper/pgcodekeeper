package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_subqueryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_setContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Using_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class Update extends AbstractExprWithNmspc {

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

    @Override
    protected List<String> analize(ParserRuleContext ruleCtx) {
        Update_stmt_for_psqlContext update = (Update_stmt_for_psqlContext) ruleCtx;
        With_clauseContext with = update.with_clause();
        if (with != null) {
            withPerform(with, cte);
        }

        if (update.update_table_name != null) {
            UtilExpr.addAliasRef(update.update_table_name, this, update.alias);

            if (update.SET() != null) {
                for (Update_setContext updateSet : update.update_set()) {
                    Table_subqueryContext subQuery;
                    if ((subQuery = updateSet.table_subquery()) != null) {
                        new Select(this).analize(subQuery.select_stmt());
                    } else if (updateSet.value != null && !updateSet.value.isEmpty()) {
                        List<IdentifierContext> tableIds = update.update_table_name.identifier();
                        addColumnDepcy(
                                QNameParser.getSchemaName(tableIds, getDefaultSchemaName()),
                                QNameParser.getFirstName(tableIds),
                                updateSet.column);

                        for (VexContext vex : updateSet.value) {
                            new ValueExpr(this).analize(new Vex(vex));
                        }
                    }
                }
            }

            if (update.FROM() != null) {
                for (Using_tableContext usingTable : update.using_table()) {
                    UtilExpr.addAliasRef(usingTable.schema_qualified_name(), this, usingTable.alias);
                    String aliasName = usingTable.alias.getText();
                    Column_referencesContext col_ctx;
                    if ((col_ctx = usingTable.column_references()) != null) {
                        for (Schema_qualified_nameContext ids : col_ctx
                                .names_references().name) {
                            addColumnReference(aliasName, QNameParser.getFirstName(ids
                                    .identifier()));
                        }
                    }
                }
            }

            VexContext vex;
            if (update.WHERE() != null && (vex = update.vex()) != null) {
                new ValueExpr(this).analize(new Vex(vex));
            }
        }
        return null;
    }

    @Override
    protected Entry<String, GenericColumn> findReference(String schema, String name, String column) {
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
        return super.findReference(schema, name, column);
    }

}
