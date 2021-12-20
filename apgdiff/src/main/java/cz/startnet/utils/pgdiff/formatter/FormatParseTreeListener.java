package cz.startnet.utils.pgdiff.formatter;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLLexer;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.After_opsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comp_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.DeclarationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.DeclarationsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Exception_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.From_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_blockContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_statementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Groupby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.If_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Loop_startContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Loop_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.OpContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Op_charsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_opsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_ops_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Start_labelContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Vex_bContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectOps;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class FormatParseTreeListener implements ParseTreeListener {

    private final CommonTokenStream tokens;
    private final Map<Token, Pair<IndentDirection, Integer>> indents;
    private final Set<Token> unaryOps;

    /**
     * @param unaryOps found unary operators and other operator-like tokens
     */
    public FormatParseTreeListener(CommonTokenStream tokens,
            Map<Token, Pair<IndentDirection, Integer>> indents,
            Set<Token> unaryOps) {
        this.tokens = tokens;
        this.indents = indents;
        this.unaryOps = unaryOps;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        //no imp
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        //no imp
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        //no imp
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx instanceof VexContext) {
            formatOperators(new Vex((VexContext) ctx));
        } else if (ctx instanceof Vex_bContext) {
            formatOperators(new Vex((Vex_bContext) ctx));
        } else if (ctx instanceof Function_blockContext) {
            formatFunctionBlock((Function_blockContext) ctx);
        } else if (ctx instanceof Function_bodyContext) {
            formatFunctionBody((Function_bodyContext) ctx);
        } else if (ctx instanceof If_statementContext) {
            formatIfStatement((If_statementContext) ctx);
        } else if (ctx instanceof Loop_statementContext) {
            formatLoopStatement((Loop_statementContext) ctx);
        } else if (ctx instanceof Case_statementContext) {
            formatCaseStatement((Case_statementContext) ctx);
        } else if (ctx instanceof Function_statementsContext) {
            formatFunctionStatements((Function_statementsContext) ctx);
        } else if (ctx instanceof Select_primaryContext) {
            formatSelectPrimary((Select_primaryContext) ctx);
        } else if (ctx instanceof Delete_stmt_for_psqlContext) {
            formatDeleteStatement((Delete_stmt_for_psqlContext) ctx);
        } else if (ctx instanceof Update_stmt_for_psqlContext) {
            formatUpdateStatement((Update_stmt_for_psqlContext) ctx);
        } else if (ctx instanceof Insert_stmt_for_psqlContext) {
            formatInsertStatement((Insert_stmt_for_psqlContext) ctx);
        } else if (ctx instanceof Case_expressionContext) {
            formatCaseExpression((Case_expressionContext) ctx);
        } else if (ctx instanceof Exception_statementContext) {
            formatExceptionStatement((Exception_statementContext) ctx);
        } else if (ctx instanceof Select_stmt_no_parensContext) {
            formatSubselect(new SelectStmt((Select_stmt_no_parensContext) ctx));
        } else if (ctx instanceof Select_stmtContext
                && !(ctx.parent.parent.parent instanceof Function_statementContext)) {
            // non-top-level select, assume subselect
            formatSubselect(new SelectStmt((Select_stmtContext) ctx));
        } else if (ctx instanceof Select_opsContext) {
            formatSelectOps(new SelectOps((Select_opsContext) ctx));
        } else if (ctx instanceof Select_ops_no_parensContext) {
            formatSelectOps(new SelectOps((Select_ops_no_parensContext) ctx));
        } else if (ctx instanceof After_opsContext) {
            putIndent(ctx.getStart(), IndentDirection.BLOCK_LINE);
        } else if (ctx instanceof StatementContext) {
            formatSql((StatementContext) ctx);
        } else if (ctx instanceof Start_labelContext) {
            formatNonOpToken((Start_labelContext) ctx);
        } else if (ctx instanceof Comp_optionsContext) {
            formatNonOpToken((Comp_optionsContext) ctx);
        }
    }

    private void formatOperators(Vex vex) {
        TerminalNode node = vex.plus();
        if (node == null) {
            node = vex.minus();
        }
        if (node == null) {
            OpContext op = vex.op();
            if (op != null) {
                Op_charsContext opChars = op.op_chars();
                if (opChars != null) {
                    ParseTree opNode = opChars.children.get(0);
                    if (opNode instanceof TerminalNode) {
                        node = (TerminalNode) opNode;
                    }
                }
            }
        }
        if (node != null && vex.vex().size() == 1) {
            // found an operator with single operand
            unaryOps.add(node.getSymbol());
        }
    }

    private void formatNonOpToken(Start_labelContext ctx) {
        unaryOps.add(ctx.LESS_LESS().getSymbol());
        unaryOps.add(ctx.GREATER_GREATER().getSymbol());
    }

    private void formatNonOpToken(Comp_optionsContext ctx) {
        unaryOps.add(ctx.HASH_SIGN().getSymbol());
    }

    private void formatFunctionStatements(Function_statementsContext ctx) {
        List<Function_statementContext> statements = ctx.function_statement();
        List<TerminalNode> colons = ctx.SEMI_COLON();
        for (int i = 0; i < statements.size(); i++) {
            putIndent(statements.get(i).getStart(), IndentDirection.BLOCK_START);
            putIndent(colons.get(i).getSymbol(), IndentDirection.BLOCK_STOP);
        }
    }

    private void formatFunctionBlock(Function_blockContext block) {
        DeclarationsContext declare = block.declarations();
        if (declare != null) {
            putIndent(declare.DECLARE().getSymbol(), IndentDirection.BLOCK_LINE);
            for (DeclarationContext dec : declare.declaration()) {
                putIndent(dec.getStart(), IndentDirection.BLOCK_START);
                putIndent(dec.getStop(), IndentDirection.BLOCK_STOP);
            }
        }

        putIndent(block.BEGIN().getSymbol(), IndentDirection.BLOCK_LINE);
        putIndent(block.END().getSymbol(), IndentDirection.BLOCK_LINE);
    }

    private void formatFunctionBody(Function_bodyContext body) {
        putIndent(body.BEGIN().getSymbol(), IndentDirection.BLOCK_LINE);
        putIndent(body.END().getSymbol(), IndentDirection.BLOCK_LINE);
    }

    private void formatExceptionStatement(Exception_statementContext ctx) {
        putIndent(ctx.EXCEPTION().getSymbol(), IndentDirection.BLOCK_LINE);
        List<TerminalNode> whenTokens = ctx.WHEN();
        List<Function_statementsContext> statements = ctx.function_statements();
        for (int i = 0; i < whenTokens.size(); i++) {
            putIndent(whenTokens.get(i).getSymbol(), IndentDirection.BLOCK_START);
            putIndent(statements.get(i).getStop(), IndentDirection.BLOCK_STOP);
        }
    }

    private void formatSelectPrimary(Select_primaryContext ctx) {
        if (!isSelectPrimaryComplex(ctx)) {
            return;
        }

        TerminalNode node = ctx.SELECT();
        if (node != null && !isSelectPrimaryInParens(ctx)) {
            // only new-line SELECT if no LEFT_PAREN found next to it
            // LEFT_PAREN must open a block, making this newline extraneous
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.FROM();
        if (node != null) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.WHERE();
        if (node != null) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.HAVING();
        if (node != null) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.WINDOW();
        if (node != null) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        Groupby_clauseContext groupBy = ctx.groupby_clause();
        if (groupBy != null) {
            putIndent(groupBy.GROUP().getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatSelectOps(SelectOps selectOps) {
        TerminalNode op = selectOps.union();
        if (op == null) {
            op = selectOps.except();
        }
        if (op == null) {
            op = selectOps.intersect();
        }
        if (op != null) {
            putIndent(op.getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatSubselect(SelectStmt select) {
        // TODO improve sub/select formatting, make an option
        if (!isSelectComplex(select)) {
            return;
        }

        ParserRuleContext ctx = select.getCtx();
        if (ctx instanceof Select_stmtContext && ctx.getChildCount() == 1 && select.selectOps().selectStmt() != null) {
            //if select is entirely contained in parens don't need block start.
            //Block was created by code below for parens already
            return;
        }
        ParserRuleContext parent = ctx.getParent();
        TerminalNode leftParen = parent.getToken(SQLLexer.LEFT_PAREN, 0);
        if (leftParen != null) {
            TerminalNode rightParen = parent.getToken(SQLLexer.RIGHT_PAREN, 0);
            if (rightParen != null) {
                putIndent(leftParen.getSymbol(), IndentDirection.BLOCK_START);
                putIndent(rightParen.getSymbol(), IndentDirection.BLOCK_STOP);
                return;
            }
        }
        // if select is not wrapped with parens, make it the block
        putIndent(ctx.getStart(), IndentDirection.BLOCK_START);
        putIndent(ctx.getStop(), IndentDirection.BLOCK_STOP);
    }

    private void formatDeleteStatement(Delete_stmt_for_psqlContext ctx) {
        if (ctx.with_clause() == null && !isFromComplex(ctx.from_item())) {
            // simple statement
            return;
        }

        putIndent(ctx.DELETE().getSymbol(), IndentDirection.BLOCK_LINE);

        TerminalNode node = ctx.USING();
        if (node != null) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatUpdateStatement(Update_stmt_for_psqlContext ctx) {
        if (ctx.with_clause() == null && !isFromComplex(ctx.from_item())) {
            // simple statement
            return;
        }

        putIndent(ctx.UPDATE().getSymbol(), IndentDirection.BLOCK_LINE);

        TerminalNode node = ctx.FROM();
        if (node != null) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatInsertStatement(Insert_stmt_for_psqlContext ctx) {
        if (ctx.with_clause() != null) {
            putIndent(ctx.INSERT().getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatIfStatement(If_statementContext ctx) {
        for (TerminalNode node : ctx.ELSIF()) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }
        for (TerminalNode node : ctx.ELSEIF()) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }
        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            putIndent(elseCtx.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        putIndent(ctx.END().getSymbol(), IndentDirection.BLOCK_LINE);
    }

    private void formatLoopStatement(Loop_statementContext ctx) {
        TerminalNode loop = ctx.LOOP(0);
        if (loop != null) {
            Loop_startContext start = ctx.loop_start();
            if (start != null && start.IN() != null && start.DOUBLE_DOT() == null) {
                // open LOOP on new line only for complex loop exprs
                putIndent(loop.getSymbol(), IndentDirection.BLOCK_LINE);
            }
            putIndent(ctx.END().getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatCaseStatement(Case_statementContext ctx) {
        putIndent(ctx.CASE().get(0).getSymbol(), IndentDirection.BLOCK_LINE);

        for (TerminalNode node : ctx.WHEN()) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            putIndent(elseCtx.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        putIndent(ctx.END().getSymbol(), IndentDirection.BLOCK_LINE);

    }

    private void formatCaseExpression(Case_expressionContext ctx) {
        putIndent(ctx.CASE().getSymbol(), IndentDirection.BLOCK_START);

        for (TerminalNode node : ctx.WHEN()) {
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            putIndent(elseCtx.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        putIndent(ctx.END().getSymbol(), IndentDirection.BLOCK_STOP);
    }

    private void formatSql(StatementContext ctx) {
        putIndent(ctx.getStart(), IndentDirection.BLOCK_START);
        putIndent(ctx.getStop(), IndentDirection.BLOCK_STOP);
    }

    private void putIndent(Token token, IndentDirection indentDir) {
        Pair<IndentDirection, Integer> indent = indents.get(token);
        if (indent != null && indent.getFirst() == indentDir) {
            indent = new Pair<>(indentDir, indent.getSecond() + 1);
        } else {
            indent = new Pair<>(indentDir, 1);
        }

        indents.put(token, indent);
    }

    private boolean isSelectComplex(SelectStmt select) {
        ParserRuleContext ctx = select.getCtx();
        if (ctx.children.size() > 1) {
            // WITH or after_ops present
            return true;
        }
        Select_primaryContext primary = select.selectOps().selectPrimary();
        if (primary == null) {
            // top level select_ops has no primary: select is complex
            return true;
        }

        return isSelectPrimaryComplex(primary);
    }

    private boolean isSelectPrimaryComplex(Select_primaryContext ctx) {
        if (ctx.groupby_clause() != null || ctx.HAVING() != null || ctx.WINDOW() != null) {
            return true;
        }
        return isFromComplex(ctx.from_item());
    }

    private boolean isFromComplex(List<From_itemContext> fromList) {
        if (fromList.size() > 1) {
            return true;
        }
        if (!fromList.isEmpty() && fromList.get(0).from_primary() == null) {
            // top level from_item is not from_primary, it must be a join
            return true;
        }
        return false;
    }

    private boolean isSelectPrimaryInParens(Select_primaryContext ctx) {
        TerminalNode node = ctx.SELECT();
        if (node != null) {
            int oldPos = tokens.index();
            try {
                Token select = node.getSymbol();
                tokens.seek(select.getTokenIndex());
                Token prev = tokens.LT(-1);
                return prev == null ? false : prev.getType() == SQLLexer.LEFT_PAREN;
            } finally {
                tokens.seek(oldPos);
            }
        }
        return false;
    }
}
