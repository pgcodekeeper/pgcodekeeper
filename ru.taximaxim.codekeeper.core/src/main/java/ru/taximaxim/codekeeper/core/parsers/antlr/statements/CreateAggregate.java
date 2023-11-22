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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.AggregateAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Aggregate_paramContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.All_op_refContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.All_simple_opContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_aggregate_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_argsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_argumentsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Identifier_nontypeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgAggregate;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgAggregate.AggFuncs;
import ru.taximaxim.codekeeper.core.schema.PgAggregate.AggKinds;
import ru.taximaxim.codekeeper.core.schema.PgAggregate.ModifyType;

public class CreateAggregate extends ParserAbstract {
    private final Create_aggregate_statementContext ctx;
    public CreateAggregate(Create_aggregate_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgAggregate aggregate = new PgAggregate(QNameParser.getFirstName(ids));

        //// The order is important for adding dependencies. Two steps.

        // First step: filling all types and arguments.

        Data_typeContext sTypeCtx = ctx.type;
        aggregate.setSType(getFullCtxText(sTypeCtx));
        addPgTypeDepcy(sTypeCtx, aggregate);

        fillAllArguments(aggregate);

        // Second step: filling other parameters of AGGREGATE.

        Schema_qualified_nameContext sFuncCtx = ctx.sfunc_name;
        aggregate.setSFunc(getFullCtxText(sFuncCtx));
        addFuncAsDepcy(AggFuncs.SFUNC, sFuncCtx, aggregate);

        fillAggregate(ctx.aggregate_param(), aggregate);

        Function_argsContext argsCtx = ctx.function_args();
        addSafe(getSchemaSafe(ids), aggregate, ids, argsCtx == null ? null : parseArguments(argsCtx));
    }

    private void fillAllArguments(PgAggregate aggregate) {
        Function_argsContext argumentsCtx = ctx.function_args();
        if (argumentsCtx != null) {
            List<Function_argumentsContext> directArgs = argumentsCtx.function_arguments();
            fillArguments(directArgs, aggregate);
            if (argumentsCtx.agg_order() != null) {
                fillArguments(argumentsCtx.agg_order().function_arguments(), aggregate);
            }
            aggregate.setDirectCount(directArgs.size());
        } else if (ctx.ANY() == null && ctx.BASETYPE() != null) {
            Data_typeContext baseTypeCtx = ctx.base_type;
            aggregate.addArgument(new Argument(null, getFullCtxText(baseTypeCtx)));
            addPgTypeDepcy(baseTypeCtx, aggregate);
            aggregate.setDirectCount(1);
        }
    }

    private void fillArguments(List<Function_argumentsContext> argumentsCtx, PgAggregate aggr) {
        for (Function_argumentsContext argument : argumentsCtx) {
            Identifier_nontypeContext name = argument.identifier_nontype();
            Argument arg = new Argument(parseArgMode(argument.argmode()),
                    (name != null ? name.getText() : null),
                    getTypeName(argument.data_type()));
            addPgTypeDepcy(argument.data_type(), aggr);
            aggr.addArgument(arg);
        }
    }

    private void fillAggregate(List<Aggregate_paramContext> params, PgAggregate aggregate) {
        ModifyType finalFuncModify = null;
        ModifyType mFinalFuncModify = null;

        if (params != null) {
            // The parameter 'MSTYPE' must be processed before parameters 'MSFUNC',
            // 'MINVFUNC', 'MFINALFUNC', for correctly adding dependencies on the
            // functions 'MSFUNC', 'MINVFUNC', 'MFINALFUNC'.
            Aggregate_paramContext mSTypeParamCtx = params.stream()
                    .filter(param -> param.MSTYPE() != null).findAny().orElse(null);
            if (mSTypeParamCtx != null) {
                Data_typeContext mSTypeCtx = mSTypeParamCtx.ms_type;
                aggregate.setMSType(getFullCtxText(mSTypeCtx));
                addPgTypeDepcy(mSTypeCtx, aggregate);
            }

            for (Aggregate_paramContext paramOpt : params) {
                if (paramOpt.SSPACE() != null) {
                    aggregate.setSSpace(Integer.parseInt(paramOpt.s_space.getText()));
                } else if (paramOpt.FINALFUNC() != null) {
                    Schema_qualified_nameContext finalFuncCtx = paramOpt.final_func;
                    aggregate.setFinalFunc(getFullCtxText(finalFuncCtx));
                    addFuncAsDepcy(AggFuncs.FINALFUNC, finalFuncCtx, aggregate);
                    db.addAnalysisLauncher(new AggregateAnalysisLauncher(aggregate,
                            getAggregateFunction(aggregate, getIdentifiers(finalFuncCtx)), fileName));
                } else if (paramOpt.FINALFUNC_EXTRA() != null) {
                    aggregate.setFinalFuncExtra(true);
                } else if (paramOpt.FINALFUNC_MODIFY() != null) {
                    finalFuncModify = getModifyParam(paramOpt);
                } else if (paramOpt.COMBINEFUNC() != null) {
                    Schema_qualified_nameContext combineFuncCtx = paramOpt.combine_func;
                    aggregate.setCombineFunc(getFullCtxText(combineFuncCtx));
                    addFuncAsDepcy(AggFuncs.COMBINEFUNC, combineFuncCtx, aggregate);
                } else if (paramOpt.SERIALFUNC() != null) {
                    Schema_qualified_nameContext serialFuncCtx = paramOpt.serial_func;
                    aggregate.setSerialFunc(getFullCtxText(serialFuncCtx));
                    addFuncAsDepcy(AggFuncs.SERIALFUNC, serialFuncCtx, aggregate);
                } else if (paramOpt.DESERIALFUNC() != null) {
                    Schema_qualified_nameContext deserialFuncCtx = paramOpt.deserial_func;
                    aggregate.setDeserialFunc(getFullCtxText(deserialFuncCtx));
                    addFuncAsDepcy(AggFuncs.DESERIALFUNC, deserialFuncCtx, aggregate);
                } else if (paramOpt.INITCOND() != null) {
                    aggregate.setInitCond(paramOpt.init_cond.getText());
                } else if (paramOpt.MSFUNC() != null) {
                    Schema_qualified_nameContext mSFuncCtx = paramOpt.ms_func;
                    aggregate.setMSFunc(getFullCtxText(mSFuncCtx));
                    addFuncAsDepcy(AggFuncs.MSFUNC, mSFuncCtx, aggregate);
                } else if (paramOpt.MINVFUNC() != null) {
                    Schema_qualified_nameContext mInvFuncCtx = paramOpt.minv_func;
                    aggregate.setMInvFunc(getFullCtxText(mInvFuncCtx));
                    addFuncAsDepcy(AggFuncs.MINVFUNC, mInvFuncCtx, aggregate);
                } else if (paramOpt.MSSPACE() != null) {
                    aggregate.setMSSpace(Integer.parseInt(paramOpt.ms_space.getText()));
                } else if (paramOpt.MFINALFUNC() != null) {
                    Schema_qualified_nameContext mFinalFuncCtx = paramOpt.mfinal_func;
                    aggregate.setMFinalFunc(getFullCtxText(mFinalFuncCtx));
                    addFuncAsDepcy(AggFuncs.MFINALFUNC, mFinalFuncCtx, aggregate);
                } else if (paramOpt.MFINALFUNC_EXTRA() != null) {
                    aggregate.setMFinalFuncExtra(true);
                } else if (paramOpt.MFINALFUNC_MODIFY() != null) {
                    mFinalFuncModify = getModifyParam(paramOpt);
                } else if (paramOpt.MINITCOND() != null) {
                    aggregate.setMInitCond(paramOpt.minit_cond.getText());
                } else if (paramOpt.SORTOP() != null) {
                    All_op_refContext operCtx = paramOpt.all_op_ref();
                    IdentifierContext schemaNameCxt = operCtx.identifier();
                    StringBuilder sb = new StringBuilder();
                    if (schemaNameCxt != null) {
                        sb.append("OPERATOR(")
                        .append(PgDiffUtils.getQuotedName(schemaNameCxt.getText()))
                        .append('.');
                    }
                    All_simple_opContext op = operCtx.all_simple_op();
                    sb.append(op.getText());
                    if (schemaNameCxt != null) {
                        sb.append(')');
                    }

                    aggregate.setSortOp(sb.toString());

                    if (schemaNameCxt != null) {
                        addDepSafe(aggregate, Arrays.asList(schemaNameCxt, op),
                                DbObjType.OPERATOR, DatabaseType.PG, getSortOperSign(aggregate));
                    }
                } else if (paramOpt.PARALLEL() != null) {
                    String parallel = null;
                    if (paramOpt.SAFE() != null) {
                        parallel = paramOpt.SAFE().getText();
                    } else if (paramOpt.RESTRICTED() != null) {
                        parallel = paramOpt.RESTRICTED().getText();
                    } else if (paramOpt.UNSAFE() != null) {
                        parallel = paramOpt.UNSAFE().getText();
                    }
                    aggregate.setParallel(parallel);
                } else if (paramOpt.HYPOTHETICAL() != null) {
                    aggregate.setKind(AggKinds.HYPOTHETICAL);
                }
            }
        }

        if (aggregate.getFinalFunc() == null) {
            aggregate.setReturns(ctx.type.getText());
        }

        if (AggKinds.HYPOTHETICAL != aggregate.getKind()
                && aggregate.getArguments().size() != aggregate.getDirectCount()) {
            aggregate.setKind(AggKinds.ORDERED);
        }

        ModifyType def = AggKinds.NORMAL == aggregate.getKind() ? ModifyType.READ_ONLY : ModifyType.READ_WRITE;
        aggregate.setFinalFuncModify(def == finalFuncModify ? null : finalFuncModify);
        aggregate.setMFinalFuncModify(def == mFinalFuncModify ? null : mFinalFuncModify);
    }

    private ModifyType getModifyParam(Aggregate_paramContext param) {
        if (param.READ_WRITE() != null) {
            return ModifyType.READ_WRITE;
        } else if (param.SHAREABLE() != null) {
            return ModifyType.SHAREABLE;
        } else {
            return ModifyType.READ_ONLY;
        }
    }

    private void addFuncAsDepcy(AggFuncs paramName,
            Schema_qualified_nameContext paramFuncCtx, PgAggregate aggr) {
        List<ParserRuleContext> ids = getIdentifiers(paramFuncCtx);
        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        if (schemaCtx != null) {
            addDepSafe(aggr, Arrays.asList(schemaCtx, QNameParser.getFirstNameCtx(ids)),
                    DbObjType.FUNCTION, DatabaseType.PG, getParamFuncSignature(aggr, paramName));
        }
    }

    private GenericColumn getAggregateFunction(PgAggregate aggregate, List<ParserRuleContext> ids) {
        String name = QNameParser.getFirstName(ids) + getParamFuncSignature(aggregate, AggFuncs.FINALFUNC);
        return new GenericColumn(QNameParser.getSchemaName(ids),
                name, DbObjType.FUNCTION);
    }

    /**
     * Gets the signature for the given function name.
     *
     * @param aggregate
     *            aggregate object
     * @param paramName
     *            name of parameter
     *
     * @return function signature
     */
    public static String getParamFuncSignature(PgAggregate aggregate, AggFuncs paramName) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');

        String sType = aggregate.getSType();
        String mSType = aggregate.getMSType();
        List<Argument> args = aggregate.getArguments();
        int directCount = aggregate.getDirectCount();
        List<Argument> orderByArgs = args.subList(directCount, args.size());

        switch(paramName) {
        case SFUNC:
        case MSFUNC:
        case MINVFUNC:
            sb.append(paramName == AggFuncs.SFUNC ? sType : mSType).append(", ");
            fillStringByArgs(sb, orderByArgs.isEmpty() ? args : orderByArgs);
            break;
        case FINALFUNC:
        case MFINALFUNC:
            sb.append(paramName == AggFuncs.FINALFUNC ? sType : mSType).append(", ");
            if (directCount > 0 && !orderByArgs.isEmpty()) {
                // for signature: aggregateName(mode name type, ... ORDER BY modeN nameN typeN, ....)
                fillStringByArgs(sb, args.subList(0, directCount));
            }
            break;

        case COMBINEFUNC:
            sb.append(sType).append(", ").append(sType).append(", ");
            break;

        case DESERIALFUNC:
            sb.append("bytea").append(", ");
            // $FALL-THROUGH$
        case SERIALFUNC:
            // Signature 'aggregateName(*)' with 'SERIALFUNC'-parameter could not be created.
            fillStringByArgs(sb, args);
            break;

        default:
            throw new IllegalStateException("The parameter '" + paramName
                    + "' of AGGREGATE '" + aggregate.getName()
                    + "' is not processed!"); //$NON-NLS-1$
        }

        sb.setLength(sb.length() - 2);
        sb.append(')');
        return sb.toString();
    }

    private static void fillStringByArgs(StringBuilder sb, List<Argument> args) {
        for (Argument arg : args) {
            arg.appendDeclaration(sb, false, true);
            sb.append(", ");
        }
    }

    public static String getSortOperSign(PgAggregate aggr) {
        String argType = aggr.getArguments().get(0).getDataType();
        return '(' + argType + ", " + argType + ')';
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.AGGREGATE, getIdentifiers(ctx.name));
    }
}
