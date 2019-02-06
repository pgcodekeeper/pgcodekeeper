package cz.startnet.utils.pgdiff.parsers.antlr.rulectx;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_opsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_ops_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;

/**
 * Merging wrapper for select_ops/select_ops_no_parens
 *
 * @author levsha_aa
 */
public class SelectOps {

    private final Select_opsContext ops;
    private final Select_ops_no_parensContext opsNp;
    private final boolean isNp;

    public SelectOps(Select_opsContext ops) {
        this.ops = ops;
        this.opsNp = null;
        this.isNp = false;
    }

    public SelectOps(Select_ops_no_parensContext ops) {
        this.opsNp = ops;
        this.ops = null;
        this.isNp = true;
    }

    public Select_stmtContext selectStmt() {
        return isNp ? opsNp.select_stmt() : ops.select_stmt();
    }

    public Select_primaryContext selectPrimary() {
        return isNp ? opsNp.select_primary() : ops.select_primary();
    }

    public SelectOps firstOps() {
        Select_opsContext ctx = isNp ? opsNp.select_ops() : ops.select_ops(0);
        return ctx == null ? null : new SelectOps(ctx);
    }

    public SelectOps secondOps() {
        Select_opsContext ctx = isNp ? null : ops.select_ops(1);
        return ctx == null ? null : new SelectOps(ctx);
    }
}
