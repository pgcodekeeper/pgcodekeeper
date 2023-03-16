/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Query_specificationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Select_opsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Select_ops_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Select_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Set_qualifierContext;

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
