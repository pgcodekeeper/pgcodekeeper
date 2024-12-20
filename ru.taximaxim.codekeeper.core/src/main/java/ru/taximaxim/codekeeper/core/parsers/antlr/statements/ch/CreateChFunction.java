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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.ChFuncAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_function_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Function_argumentsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Identifier_listContext;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChFunction;

public class CreateChFunction extends ChParserAbstract {

    private final Create_function_stmtContext ctx;

    public CreateChFunction(Create_function_stmtContext ctx,
            ChDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.qualified_name());

        String name = QNameParser.getFirstName(ids);
        ChFunction function = new ChFunction(name);
        parseObject(function);
        addSafe(db, function, ids);
    }

    public void parseObject(ChFunction function) {
        var bodyCtx = ctx.lambda_expr().expr();
        function.setBody(getFullCtxText(bodyCtx));

        parseArgs(function, ctx.lambda_expr().function_arguments());

        db.addAnalysisLauncher(new ChFuncAnalysisLauncher(function, bodyCtx, fileName));
    }

    private void parseArgs(ChFunction function, Function_argumentsContext funcArgs) {
        var id = funcArgs.identifier();
        if (id != null) {
            function.addArgument(new Argument(id.getText(), null));
            return;
        }

        Identifier_listContext argList = funcArgs.identifier_list();
        if (argList != null) {
            for (var argName : argList.identifier()) {
                function.addArgument(new Argument(argName.getText(), null));
            }
        }
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FUNCTION, ctx.qualified_name());
    }
}
