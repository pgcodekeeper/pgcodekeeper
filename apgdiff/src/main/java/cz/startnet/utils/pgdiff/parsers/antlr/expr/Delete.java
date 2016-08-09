package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Using_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class Delete extends AbstractExprWithNmspc {

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

    @Override
    protected List<String> analize(ParserRuleContext ruleCtx) {
        Delete_stmt_for_psqlContext delete = (Delete_stmt_for_psqlContext) ruleCtx;
        With_clauseContext with = delete.with_clause();
        if (with != null) {
            withPerform(with, cte);
        }

        if (delete.delete_table_name != null) {
            UtilExpr.addAliasRef(delete.delete_table_name, this, delete.alias);
            if (delete.USING() != null) {
                for (Using_tableContext usingTable : delete.using_table()) {
                    UtilExpr.addAliasRef(usingTable.schema_qualified_name(), this, usingTable.alias);
                    String aliasName = usingTable.alias.getText();
                    Column_referencesContext col_ctx;
                    if ((col_ctx = usingTable.column_references()) != null) {
                        for (Schema_qualified_nameContext ids : col_ctx.names_references().name) {
                            addColumnReference(aliasName, QNameParser.getFirstName(ids.identifier()));
                        }
                    }
                }
            }

            VexContext vex;
            if (delete.WHERE() != null && (vex = delete.vex()) != null) {
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
