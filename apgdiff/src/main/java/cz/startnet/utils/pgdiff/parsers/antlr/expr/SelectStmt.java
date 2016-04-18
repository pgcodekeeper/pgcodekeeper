package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;

/**
 * Merging wrapper for select_stmt/select_stmt_no_parens
 *
 * @author levsha_aa
 */
public class SelectStmt {

    private final Select_stmtContext select;
    private final Select_stmt_no_parensContext selectNp;

    public SelectStmt(Select_stmtContext select) {
        this.select = select;
        this.selectNp = null;
    }

    public SelectStmt(Select_stmt_no_parensContext select) {
        this.selectNp = select;
        this.select = null;
    }

    private boolean isNp() {
        return selectNp != null;
    }

    public With_clauseContext withClause() {
        return isNp() ? selectNp.with_clause() : select.with_clause();
    }

    public SelectOps selectOps() {
        return isNp() ? new SelectOps(selectNp.select_ops_no_parens())
                : new SelectOps(select.select_ops());
    }

    public List<Value_expressionContext> valueExpression() {
        return isNp() ? selectNp.value_expression() : select.value_expression();
    }

    public List<Schema_qualified_nameContext> schemaQualifiedName() {
        return isNp() ? selectNp.schema_qualified_name() : select.schema_qualified_name();
    }

    // no need for TerminalNode wrappers (LIMIT, OFFSET)
    // add in the future if necessary
}
