package cz.startnet.utils.pgdiff.parsers.antlr.rulectx;

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Query_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_opsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_ops_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Set_qualifierContext;

public class MsSelectOps {

    private final Select_opsContext ops;
    private final Select_ops_no_parensContext opsNp;
    private final boolean isNp;

    public MsSelectOps(Select_opsContext ops) {
        this.ops = ops;
        this.opsNp = null;
        this.isNp = false;
    }

    public MsSelectOps(Select_ops_no_parensContext ops) {
        this.opsNp = ops;
        this.ops = null;
        this.isNp = true;
    }

    public TerminalNode leftParen() {
        return isNp ? null : ops.LR_BRACKET();
    }

    public TerminalNode rightParen() {
        return isNp ? null : ops.RR_BRACKET();
    }

    public Select_statementContext selectStmt() {
        return isNp ? null : ops.select_statement();
    }

    public List<Select_opsContext> selectOps() {
        return isNp ? opsNp.select_ops() : ops.select_ops();
    }

    public MsSelectOps selectOps(int i) {
        Select_opsContext ctx = isNp ? opsNp.select_ops(i) : ops.select_ops(i);
        return ctx == null ? null : new MsSelectOps(ctx);
    }

    public TerminalNode intersect() {
        return isNp ? opsNp.INTERSECT() : ops.INTERSECT();
    }

    public TerminalNode union() {
        return isNp ? opsNp.UNION() : ops.UNION();
    }

    public TerminalNode except() {
        return isNp ? opsNp.EXCEPT() : ops.EXCEPT();
    }

    public Set_qualifierContext setQualifier() {
        return isNp ? opsNp.set_qualifier() : ops.set_qualifier();
    }

    public Query_specificationContext querySpecification() {
        return isNp ? opsNp.query_specification() : ops.query_specification();
    }
}
