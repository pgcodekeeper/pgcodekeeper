package cz.startnet.utils.pgdiff.parsers.antlr.rulectx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Datetime_overlapsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.OpContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Truth_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Vex_bContext;

/**
 * Merging wrapper for vex/vex_b
 *
 * @author levsha_aa
 */
public class Vex {

    private final VexContext vex;
    private final Vex_bContext vexB;
    private final boolean isB;

    public Vex(VexContext vex) {
        this.vex = vex;
        this.vexB = null;
        this.isB = false;
    }

    public Vex(Vex_bContext vex) {
        this.vex = null;
        this.vexB = vex;
        this.isB = true;
    }

    public List<Vex> vex() {
        List<VexContext> vexs = isB ? vexB.vex() : vex.vex();
        List<Vex_bContext> vexBs = isB ? vexB.vex_b() : null;
        Vex_bContext vexBChild = isB ? null : vex.vex_b();

        int totalVex = vexs.size() +
                (vexBs != null ? vexBs.size() : vexBChild != null ? 1 : 0);
        if (totalVex == 0) {
            return Collections.emptyList();
        }
        List<Vex> vexAll = new ArrayList<>(totalVex);

        for (VexContext v : vexs) {
            vexAll.add(new Vex(v));
        }
        if (vexBs != null) {
            for (Vex_bContext vb : vexBs) {
                vexAll.add(new Vex(vb));
            }
        }
        if (vexBChild != null) {
            vexAll.add(new Vex(vexBChild));
        }
        return vexAll;
    }

    public ParserRuleContext getVexCtx() {
        return isB ? vexB : vex;
    }

    public boolean isChildOpIsPrefix() {
        return isB ? vexB.getChild(0) instanceof OpContext : vex.getChild(0) instanceof OpContext;
    }

    public TerminalNode castExpression() {
        return isB ? vexB.CAST_EXPRESSION() : vex.CAST_EXPRESSION();
    }

    public Data_typeContext dataType() {
        return isB ? vexB.data_type() : vex.data_type();
    }

    public Collate_identifierContext collateIdentifier() {
        return isB ? null : vex.collate_identifier();
    }

    public TerminalNode leftParen() {
        return isB ? vexB.LEFT_PAREN() : vex.LEFT_PAREN();
    }

    public TerminalNode rightParen() {
        return isB ? vexB.RIGHT_PAREN() : vex.RIGHT_PAREN();
    }

    public TerminalNode leftBracket() {
        return isB ? vexB.LEFT_BRACKET() : vex.LEFT_BRACKET();
    }

    public TerminalNode rightBracket() {
        return isB ? vexB.RIGHT_BRACKET() : vex.RIGHT_BRACKET();
    }

    public TerminalNode in() {
        return isB ? null : vex.IN();
    }

    public Select_stmt_no_parensContext selectStmt() {
        return isB ? null : vex.select_stmt_no_parens();
    }

    public Datetime_overlapsContext datetimeOverlaps() {
        return isB ? null : vex.datetime_overlaps();
    }

    public Value_expression_primaryContext primary() {
        return isB ? vexB.value_expression_primary() : vex.value_expression_primary();
    }

    public TerminalNode plus() {
        return isB ? vexB.PLUS() : vex.PLUS();
    }

    public TerminalNode minus() {
        return isB ? vexB.MINUS() : vex.MINUS();
    }

    public TerminalNode timeZone() {
        return isB ? null : vex.ZONE();
    }

    public TerminalNode colon() {
        return isB ? vexB.COLON() : vex.COLON();
    }

    public TerminalNode exp() {
        return isB ? vexB.EXP() : vex.EXP();
    }

    public TerminalNode multiply() {
        return isB ? vexB.MULTIPLY() : vex.MULTIPLY();
    }

    public TerminalNode divide() {
        return isB ? vexB.DIVIDE() : vex.DIVIDE();
    }

    public TerminalNode modular() {
        return isB ? vexB.MODULAR() : vex.MODULAR();
    }

    public OpContext op() {
        return isB ? vexB.op() : vex.op();
    }

    public TerminalNode between() {
        return isB ? null : vex.BETWEEN();
    }

    public TerminalNode like() {
        return isB ? null : vex.LIKE();
    }

    public TerminalNode ilike() {
        return isB ? null : vex.ILIKE();
    }

    public TerminalNode similar() {
        return isB ? null : vex.SIMILAR();
    }

    public TerminalNode lth() {
        return isB ? vexB.LTH() : vex.LTH();
    }

    public TerminalNode gth() {
        return isB ? vexB.GTH() : vex.GTH();
    }

    public TerminalNode leq() {
        return isB ? vexB.LEQ() : vex.LEQ();
    }

    public TerminalNode geq() {
        return isB ? vexB.GEQ() : vex.GEQ();
    }

    public TerminalNode equal() {
        return isB ? vexB.EQUAL() : vex.EQUAL();
    }

    public TerminalNode notEqual() {
        return isB ? vexB.NOT_EQUAL() : vex.NOT_EQUAL();
    }

    public TerminalNode is() {
        return isB ? vexB.IS() : vex.IS();
    }

    public Truth_valueContext truthValue() {
        return isB ? null : vex.truth_value();
    }

    public TerminalNode nullValue() {
        return isB ? null : vex.NULL();
    }

    public TerminalNode distinct() {
        return isB ? vexB.DISTINCT() : vex.DISTINCT();
    }

    public TerminalNode document() {
        return isB ? vexB.DOCUMENT() : vex.DOCUMENT();
    }

    public TerminalNode isNull() {
        return isB ? null : vex.ISNULL();
    }

    public TerminalNode notNull() {
        return isB ? null : vex.NOTNULL();
    }

    public TerminalNode not() {
        return isB ? null : vex.NOT();
    }

    public TerminalNode and() {
        return isB ? null : vex.AND();
    }

    public TerminalNode or() {
        return isB ? null : vex.OR();
    }
}