/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr.rulectx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Collate_identifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Indirection_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.OpContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Truth_valueContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Type_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Value_expression_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Vex_bContext;

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
        List<ParseTree> children = (isB ? vexB : vex).children;
        if (children == null || children.isEmpty()) {
            return Collections.emptyList();
        }
        List<Vex> vex = new ArrayList<>();
        for (ParseTree node : children) {
            if (node instanceof VexContext vexCtx) {
                vex.add(new Vex(vexCtx));
            } else if (node instanceof Vex_bContext vexbCtx) {
                vex.add(new Vex(vexbCtx));
            }
        }
        return vex;
    }

    public ParserRuleContext getVexCtx() {
        return isB ? vexB : vex;
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

    public Indirection_listContext indirectionList() {
        return isB ? vexB.indirection_list() : vex.indirection_list();
    }

    public TerminalNode in() {
        return isB ? null : vex.IN();
    }

    public Select_stmt_no_parensContext selectStmt() {
        return isB ? null : vex.select_stmt_no_parens();
    }

    public Type_listContext typeList() {
        return isB ? vexB.type_list() : vex.type_list();
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