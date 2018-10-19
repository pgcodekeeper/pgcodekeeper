package cz.startnet.utils.pgdiff.parsers.antlr.rulectx;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.For_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Option_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.With_expressionContext;

public class MsSelectStmt {

    private final Select_statementContext select;
    private final Select_stmt_no_parensContext selectNp;
    private final boolean isNp;

    public MsSelectStmt(Select_statementContext select) {
        this.select = select;
        this.selectNp = null;
        this.isNp = false;
    }

    public MsSelectStmt(Select_stmt_no_parensContext select) {
        this.selectNp = select;
        this.select = null;
        this.isNp = true;
    }

    public With_expressionContext withExpression() {
        return isNp ? selectNp.with_expression() : select.with_expression();
    }

    public MsSelectOps selectOps() {
        // no null check since select_ops is mandatory in select_stmt
        return isNp ? new MsSelectOps(selectNp.select_ops_no_parens())
                : new MsSelectOps(select.select_ops());
    }

    public Option_clauseContext option() {
        return isNp ? selectNp.option_clause() : select.option_clause();
    }

    public For_clauseContext forClause() {
        return isNp ? selectNp.for_clause() : select.for_clause();
    }
}
