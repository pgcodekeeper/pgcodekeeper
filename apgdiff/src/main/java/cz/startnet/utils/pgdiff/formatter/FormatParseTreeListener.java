package cz.startnet.utils.pgdiff.formatter;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.DeclarationsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Exception_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_blockContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.If_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Loop_statementContext;

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
            exitFunctionBlock((Function_blockContext) ctx);
        } else if (ctx instanceof If_statementContext) {
            exitIfStatement((If_statementContext) ctx);
        } else if (ctx instanceof Loop_statementContext) {
            exitLoopStatement((Loop_statementContext) ctx);
        } else if (ctx instanceof Case_statementContext) {
            exitCaseStatement((Case_statementContext) ctx);
        }
    }

    private void exitFunctionBlock(Function_blockContext block) {
        DeclarationsContext declare = block.declarations();

        if (declare != null) {
            indents.put(declare.DECLARE().getSymbol(), IndentDirection.INCREACE);
        }

        indents.put(block.BEGIN().getSymbol(),
                declare == null ? IndentDirection.INCREACE : IndentDirection.REDUCE_AND_INCREACE);

        Exception_statementContext exception = block.exception_statement();
        if (exception != null) {
            indents.put(exception.EXCEPTION().getSymbol(), IndentDirection.REDUCE_AND_INCREACE);

            List<TerminalNode> whens = exception.WHEN();
            for (int i = 0; i < whens.size(); i++) {
                indents.put(whens.get(i).getSymbol(),
                        i == 0 ? IndentDirection.INCREACE : IndentDirection.REDUCE_AND_INCREACE);
            }
        }

        indents.put(block.END().getSymbol(),
                exception == null ? IndentDirection.REDUCE : IndentDirection.REDUCE_TWICE);
    }

    private void exitIfStatement(If_statementContext ctx) {
        indents.put(ctx.IF().get(0).getSymbol(), IndentDirection.INCREACE);

        for (TerminalNode node : ctx.ELSIF()) {
            indents.put(node.getSymbol(), IndentDirection.REDUCE_AND_INCREACE);
        }
        for (TerminalNode node : ctx.ELSEIF()) {
            indents.put(node.getSymbol(), IndentDirection.REDUCE_AND_INCREACE);
        }
        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            indents.put(elseCtx.getSymbol(), IndentDirection.REDUCE_AND_INCREACE);
        }

        indents.put(ctx.END().getSymbol(), IndentDirection.REDUCE);
    }

    private void exitLoopStatement(Loop_statementContext ctx) {
        List<TerminalNode> loops = ctx.LOOP();
        if (!loops.isEmpty()) {
            indents.put(loops.get(0).getSymbol(), IndentDirection.INCREACE);
            indents.put(ctx.END().getSymbol(), IndentDirection.REDUCE);
        }
    }

    private void exitCaseStatement(Case_statementContext ctx) {
        indents.put(ctx.CASE().get(0).getSymbol(), IndentDirection.INCREACE);

        List<TerminalNode> whens = ctx.WHEN();
        for (int i = 0; i < whens.size(); i++) {
            Token t = whens.get(i).getSymbol();
            indents.put(t, i == 0 ? IndentDirection.INCREACE :
                IndentDirection.REDUCE_AND_INCREACE);
        }

        TerminalNode elseCtx = ctx.ELSE();
        if (elseCtx != null) {
            indents.put(elseCtx.getSymbol(), IndentDirection.REDUCE_AND_INCREACE);
        }

        indents.put(ctx.END().getSymbol(), IndentDirection.REDUCE_TWICE);
    }
}
