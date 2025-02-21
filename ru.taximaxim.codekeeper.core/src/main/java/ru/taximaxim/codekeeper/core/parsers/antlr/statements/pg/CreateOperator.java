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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.OperatorAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.All_op_refContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_operator_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_operator_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgOperator;

public class CreateOperator extends PgParserAbstract {

    private final Create_operator_statementContext ctx;

    public CreateOperator(Create_operator_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgOperator oper = new PgOperator(QNameParser.getFirstName(ids));
        Schema_qualified_nameContext funcCtx = null;
        Schema_qualified_nameContext restCtx = null;
        Schema_qualified_nameContext joinCtx = null;
        for (Create_operator_optionContext createOption : ctx.create_operator_option()) {
            if (createOption.func_name != null) {
                funcCtx = createOption.func_name;
            } else if (createOption.LEFTARG() != null) {
                Data_typeContext leftArgTypeCtx = createOption.type;
                oper.setLeftArg(getTypeName(leftArgTypeCtx));
                addTypeDepcy(leftArgTypeCtx, oper);
            } else if (createOption.RIGHTARG() != null) {
                Data_typeContext rightArgTypeCtx = createOption.type;
                oper.setRightArg(getTypeName(rightArgTypeCtx));
                addTypeDepcy(rightArgTypeCtx, oper);
            } else {
                var option = createOption.operator_option();
                if (option.COMMUTATOR() != null || option.NEGATOR() != null) {
                    All_op_refContext comutNameCtx = option.addition_oper_name;
                    IdentifierContext schemaNameCxt = comutNameCtx.identifier();
                    StringBuilder sb = new StringBuilder();
                    if (schemaNameCxt != null) {
                        sb.append("OPERATOR(")
                        .append(PgDiffUtils.getQuotedName(schemaNameCxt.getText()))
                        .append('.');
                    }
                    sb.append(comutNameCtx.all_simple_op().getText());
                    if (schemaNameCxt != null) {
                        sb.append(')');
                    }

                    if (option.COMMUTATOR() != null) {
                        oper.setCommutator(sb.toString());
                    } else {
                        oper.setNegator(sb.toString());
                    }
                } else if (option.MERGES() != null) {
                    oper.setMerges(true);
                } else if (option.HASHES() != null) {
                    oper.setHashes(true);
                } else if (option.RESTRICT() != null) {
                    restCtx = option.restr_name;
                } else if (option.JOIN() != null) {
                    joinCtx = option.join_name;
                }
            }
        }

        // waits for operator arguments to add the correct dependency
        String arguments = oper.getArguments();
        if (funcCtx != null) {
            oper.setProcedure(getFullCtxText(funcCtx));
            List<ParserRuleContext> funcIds = getIdentifiers(funcCtx);
            addDepSafe(oper, funcIds, DbObjType.FUNCTION, arguments);
            db.addAnalysisLauncher(new OperatorAnalysisLauncher(oper, getOperatorFunction(oper, funcIds), fileName));
        }

        if (restCtx != null) {
            oper.setRestrict(getFullCtxText(restCtx));
            List<ParserRuleContext> funcIds = getIdentifiers(restCtx);
            addDepSafe(oper, funcIds, DbObjType.FUNCTION, arguments);
        }

        if (joinCtx != null) {
            oper.setJoin(getFullCtxText(joinCtx));
            List<ParserRuleContext> funcIds = getIdentifiers(joinCtx);
            addDepSafe(oper, funcIds, DbObjType.FUNCTION, arguments);
        }

        addSafe(getSchemaSafe(ids), oper, ids);
    }

    private GenericColumn getOperatorFunction(PgOperator oper, List<ParserRuleContext> ids) {
        String name = QNameParser.getFirstName(ids) + oper.getArguments();
        return new GenericColumn(QNameParser.getSchemaName(ids), name, DbObjType.FUNCTION);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.OPERATOR, ctx.name);
    }
}
