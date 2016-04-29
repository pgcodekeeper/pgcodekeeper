package cz.startnet.utils.pgdiff.parsers.antlr.rulectx;

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Orderby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
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

    public Orderby_clauseContext orderBy() {
        return isNp ? selectNp.orderby_clause() : select.orderby_clause();
    }

    public TerminalNode limit() {
        return isNp ? selectNp.LIMIT() : select.LIMIT();
    }

    public TerminalNode offset() {
        return isNp ? selectNp.OFFSET() : select.OFFSET();
    }

    public TerminalNode fetch() {
        return isNp ? selectNp.FETCH() : select.FETCH();
    }

    public TerminalNode of(int i) {
        return isNp ? selectNp.OF(i) : select.OF(i);
    }

    public List<VexContext> vex() {
        return isNp ? selectNp.vex() : select.vex();
    }

    public List<Schema_qualified_nameContext> schemaQualifiedName() {
        return isNp ? selectNp.schema_qualified_name() : select.schema_qualified_name();
    }
}
