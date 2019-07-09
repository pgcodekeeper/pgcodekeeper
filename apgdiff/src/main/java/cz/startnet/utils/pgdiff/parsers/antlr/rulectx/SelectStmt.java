package cz.startnet.utils.pgdiff.parsers.antlr.rulectx;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.After_opsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;

/**
 * Merging wrapper for select_stmt/select_stmt_no_parens
 *
 * @author levsha_aa
 */
public class SelectStmt {

    private final Select_stmtContext select;
    private final Select_stmt_no_parensContext selectNp;
    private final boolean isNp;

    public SelectStmt(Select_stmtContext select) {
        this.select = select;
        this.selectNp = null;
        this.isNp = false;
    }

    public SelectStmt(Select_stmt_no_parensContext select) {
        this.selectNp = select;
        this.select = null;
        this.isNp = true;
    }

    public With_clauseContext withClause() {
        return isNp ? selectNp.with_clause() : select.with_clause();
    }

    public SelectOps selectOps() {
        // no null check since select_ops is mandatory in select_stmt
        return isNp ? new SelectOps(selectNp.select_ops_no_parens())
                : new SelectOps(select.select_ops());
    }

    public List<After_opsContext> afterOps() {
        return isNp ? selectNp.after_ops() : select.after_ops();
    }
}
