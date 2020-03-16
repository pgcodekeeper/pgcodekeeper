package cz.startnet.utils.pgdiff.formatter;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.After_opsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.DeclarationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.DeclarationsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Exception_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_blockContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_statementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Groupby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.If_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Loop_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_setContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;

public class FormatParseTreeListener implements ParseTreeListener {

    private final Map<Token, IndentDirection> indents;

    public FormatParseTreeListener(Map<Token, IndentDirection> indents) {
        this.indents = indents;
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
        if (ctx instanceof Function_blockContext) {
            formatFunctionBlock((Function_blockContext) ctx);
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
        } else if (ctx instanceof Select_stmt_no_parensContext
                || (ctx instanceof Select_stmtContext
                        && !(ctx.parent.parent.parent instanceof Function_statementContext))) {
            // subselect
            indents.put(ctx.getStart(), IndentDirection.BLOCK_START);
            putBlockStop(ctx.getStop());
        } else if (ctx instanceof After_opsContext) {
            indents.put(ctx.getStart(), IndentDirection.BLOCK_LINE);
        } else if (ctx instanceof StatementContext) {
            formatSql((StatementContext) ctx);
        }
    }

    private void formatFunctionStatements(Function_statementsContext ctx) {
        List<Function_statementContext> statements = ctx.function_statement();
        List<TerminalNode> colons = ctx.SEMI_COLON();
        for (int i = 0; i < statements.size(); i++) {
            indents.put(statements.get(i).getStart(), IndentDirection.BLOCK_START);
            putBlockStop(colons.get(i).getSymbol());
        }
    }

    private void formatFunctionBlock(Function_blockContext block) {
        DeclarationsContext declare = block.declarations();
        if (declare != null) {
            indents.put(declare.DECLARE().getSymbol(), IndentDirection.BLOCK_LINE);
            for (DeclarationContext dec : declare.declaration()) {
                indents.put(dec.getStart(), IndentDirection.BLOCK_START);
                putBlockStop(dec.getStop());
            }
        }

        indents.put(block.BEGIN().getSymbol(), IndentDirection.BLOCK_LINE);
        indents.put(block.END().getSymbol(), IndentDirection.BLOCK_LINE);
    }

    private void formatExceptionStatement(Exception_statementContext ctx) {
        indents.put(ctx.EXCEPTION().getSymbol(), IndentDirection.BLOCK_LINE);
        indents.put(ctx.WHEN().get(0).getSymbol(), IndentDirection.BLOCK_START);
        putBlockStop(ctx.getStop());
    }

    private void formatSelectPrimary(Select_primaryContext ctx) {
        TerminalNode node = ctx.SELECT();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.FROM();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.WHERE();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.HAVING();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.WINDOW();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        Groupby_clauseContext groupBy = ctx.groupby_clause();
        if (groupBy != null) {
            indents.put(groupBy.GROUP().getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatDeleteStatement(Delete_stmt_for_psqlContext ctx) {
        indents.put(ctx.DELETE().getSymbol(), IndentDirection.BLOCK_LINE);

        TerminalNode node = ctx.USING();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.WHERE();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.RETURNING();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatUpdateStatement(Update_stmt_for_psqlContext ctx) {
        indents.put(ctx.UPDATE().getSymbol(), IndentDirection.BLOCK_LINE);

        for (Update_setContext update : ctx.update_set()) {
            indents.put(update.getStart(), IndentDirection.BLOCK_START);
            putBlockStop(update.getStop());
        }

        TerminalNode node = ctx.FROM();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.WHERE();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.RETURNING();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatInsertStatement(Insert_stmt_for_psqlContext ctx) {
        indents.put(ctx.INSERT().getSymbol(), IndentDirection.BLOCK_LINE);

        TerminalNode node = ctx.OVERRIDING();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.ON();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        node = ctx.RETURNING();
        if (node != null) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatIfStatement(If_statementContext ctx) {
        for (TerminalNode node : ctx.ELSIF()) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }
        for (TerminalNode node : ctx.ELSEIF()) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }
        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            indents.put(elseCtx.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        indents.put(ctx.END().getSymbol(), IndentDirection.BLOCK_LINE);
    }

    private void formatLoopStatement(Loop_statementContext ctx) {
        List<TerminalNode> loops = ctx.LOOP();
        if (!loops.isEmpty()) {
            indents.put(loops.get(0).getSymbol(), IndentDirection.BLOCK_LINE);
            indents.put(ctx.END().getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatCaseStatement(Case_statementContext ctx) {
        indents.put(ctx.CASE().get(0).getSymbol(), IndentDirection.BLOCK_LINE);

        for (TerminalNode node : ctx.WHEN()) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            indents.put(elseCtx.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        indents.put(ctx.END().getSymbol(), IndentDirection.BLOCK_LINE);
    }

    private void formatCaseExpression(Case_expressionContext ctx) {
        indents.put(ctx.CASE().getSymbol(), IndentDirection.BLOCK_START);

        for (TerminalNode node : ctx.WHEN()) {
            indents.put(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            indents.put(elseCtx.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        putBlockStop(ctx.END().getSymbol());
    }

    private void formatSql(StatementContext ctx) {
        indents.put(ctx.getStart(), IndentDirection.BLOCK_START);
        putBlockStop(ctx.getStop());
    }

    private void putBlockStop(Token token) {
        // if token already is block end, reduce twice
        indents.merge(token, IndentDirection.BLOCK_STOP,
                (o, n) -> o == IndentDirection.BLOCK_STOP ? IndentDirection.REDUCE_TWICE : n);
    }
}
