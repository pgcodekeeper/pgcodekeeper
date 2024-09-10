/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.formatter.ch;

import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import ru.taximaxim.codekeeper.core.formatter.FormatParseTreeListener;
import ru.taximaxim.codekeeper.core.formatter.IndentDirection;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.ExprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.From_itemContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_opsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_ops_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.ChSelectOps;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class ChFormatParseTreeListener extends FormatParseTreeListener {

    public ChFormatParseTreeListener(CommonTokenStream tokens,
            Map<Token, Pair<IndentDirection, Integer>> indents,
            Set<Token> unaryOps) {
        super(tokens, indents, unaryOps);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx instanceof Select_primaryContext selectCtx) {
            formatSelectPrimary(selectCtx);
        } else if (ctx instanceof From_itemContext fromCtx) {
            formatFromItem(fromCtx);
        } else if (ctx instanceof Select_opsContext selectOpsCtx) {
            formatSelectOps(new ChSelectOps(selectOpsCtx));
        } else if (ctx instanceof Select_ops_no_parensContext selectOpsNoParensCtx) {
            formatSelectOps(new ChSelectOps(selectOpsNoParensCtx));
        } else if (ctx instanceof ExprContext expr) {
            formatExpr(expr);
        }
    }

    private void formatSelectPrimary(Select_primaryContext ctx) {
        TerminalNode node = ctx.SELECT();
        if (node != null && !isSelectPrimaryInParens(node, CHLexer.LPAREN)) {
            // only new-line SELECT if no LPAREN found next to it
            // LPAREN must open a block, making this newline extraneous
            putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var columnsCtx = ctx.select_list().expr();
        if (columnsCtx.size() > 1) {
            for (var expr : columnsCtx) {
                putIndent(expr.getStart(), IndentDirection.NEW_LINE);
            }
        }

        var fromCtx = ctx.from_clause();
        if (fromCtx != null) {
            putIndent(fromCtx.FROM().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var arrayCtx = ctx.array_join_clause();
        if (arrayCtx != null) {
            putIndent(arrayCtx.ARRAY().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var windowCtx = ctx.window_clause();
        if (windowCtx != null) {
            putIndent(windowCtx.WINDOW().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var prewhereCtx = ctx.prewhere_clause();
        if (prewhereCtx != null) {
            putIndent(prewhereCtx.PREWHERE().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var whereCtx = ctx.where_clause();
        if (whereCtx != null) {
            putIndent(whereCtx.WHERE().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var groupByCtx = ctx.group_by_clause();
        if (groupByCtx != null) {
            putIndent(groupByCtx.GROUP().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var havingCtx = ctx.having_clause();
        if (havingCtx != null) {
            putIndent(havingCtx.HAVING().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var orderByCtx = ctx.order_by_clause();
        if (orderByCtx != null) {
            putIndent(orderByCtx.ORDER().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var limitByCtx = ctx.limit_by_clause();
        if (limitByCtx != null) {
            putIndent(limitByCtx.LIMIT().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var limitCtx = ctx.limit_clause();
        if (limitCtx != null) {
            putIndent(limitCtx.LIMIT().getSymbol(), IndentDirection.BLOCK_LINE);
        }

        var settingsCtx = ctx.settings_clause();
        if (settingsCtx != null) {
            putIndent(settingsCtx.SETTINGS().getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatFromItem(From_itemContext ctx) {
        var primaryCtx = ctx.from_primary();
        if (primaryCtx != null) {
            var subSelectCtx = primaryCtx.select_stmt_no_parens();
            if (subSelectCtx != null) {
                putIndent(subSelectCtx.getStart(), IndentDirection.BLOCK_START);
                putIndent(subSelectCtx.getStop(), IndentDirection.BLOCK_STOP);
                putIndent(primaryCtx.RPAREN().getSymbol(), IndentDirection.BLOCK_LINE);
            }
            return;
        }

        if (ctx.LPAREN() != null) {
            putIndent(ctx.LPAREN().getSymbol(), IndentDirection.BLOCK_START);
            putIndent(ctx.RPAREN().getSymbol(), IndentDirection.BLOCK_STOP);
            return;
        }

        var joinTypeCtx = ctx.join_type();
        if (joinTypeCtx != null) {
            putIndent(joinTypeCtx.start, IndentDirection.BLOCK_LINE);
            return;
        }

        var joinOpCtx = ctx.join_op();
        if (joinOpCtx != null) {
            putIndent(joinOpCtx.start, IndentDirection.BLOCK_LINE);
            return;
        }

        var node = ctx.PASTE();

        if (node == null) {
            node = ctx.CROSS();
        }

        if (node == null) {
            node = ctx.JOIN();
        }

        putIndent(node.getSymbol(), IndentDirection.BLOCK_LINE);
    }

    private void formatSelectOps(ChSelectOps selectOps) {
        TerminalNode op = selectOps.union();
        if (op == null) {
            op = selectOps.except();
        }
        if (op == null) {
            op = selectOps.intersect();
        }
        if (op != null) {
            putIndent(op.getSymbol(), IndentDirection.BLOCK_LINE);
            return;
        }

        var subSelectCtx = selectOps.selectStmt();
        if (subSelectCtx != null) {
            putIndent(subSelectCtx.start, IndentDirection.BLOCK_START);
            putIndent(subSelectCtx.stop, IndentDirection.BLOCK_STOP);
            putIndent(selectOps.rightParen().getSymbol(), IndentDirection.BLOCK_LINE);
        }
    }

    private void formatExpr(ExprContext ctx) {
        TerminalNode node = ctx.PLUS();
        if (node == null) {
            node = ctx.MINUS();
        }
        if (node != null) {
            // found an operator with single operand
            unaryOps.add(node.getSymbol());
        }
    }
}
