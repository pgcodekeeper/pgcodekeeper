package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Aggregate_paramContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.All_op_refContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.All_simple_opContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_aggregate_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.PgAggregate;
import cz.startnet.utils.pgdiff.schema.PgAggregate.AggKinds;
import cz.startnet.utils.pgdiff.schema.PgAggregate.AggFuncs;
import cz.startnet.utils.pgdiff.schema.PgAggregate.ModifyType;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateAggregate extends ParserAbstract {
    private final Create_aggregate_statementContext ctx;
    public CreateAggregate(Create_aggregate_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
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

        addSafe(getSchemaSafe(ids), aggregate, ids);
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
        } else {
            Data_typeContext baseTypeCtx = ctx.base_type;
            String baseType = getFullCtxText(baseTypeCtx);
            if (!"ANY".equals(baseType)) {
                aggregate.addArgument(new Argument(null, baseType));
                addPgTypeDepcy(baseTypeCtx, aggregate);
                aggregate.setDirectCount(1);
            }
        }
    }

    private void fillArguments(List<Function_argumentsContext> argumentsCtx, PgAggregate aggr) {
        for (Function_argumentsContext argument : argumentsCtx) {
            Argument arg = new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null,
                            getFullCtxText(argument.argtype_data));
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
                                DbObjType.OPERATOR, true, getSortOperSign(aggregate));
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
        List<IdentifierContext> ids = paramFuncCtx.identifier();
        IdentifierContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        if (schemaCtx != null) {
            addDepSafe(aggr, Arrays.asList(schemaCtx, QNameParser.getFirstNameCtx(ids)),
                    DbObjType.FUNCTION, true, getParamFuncSignature(aggr, paramName));
        }
    }

    /**
     * Gets the signature for the given function name.
     *
     * @param aggregate aggregate object
     * @param paramName name of parameter
     * @return
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
            sb.append(AbstractPgFunction.getDeclaration(arg, false, true)).append(", ");
        }
    }

    public static String getSortOperSign(PgAggregate aggr) {
        String argType = aggr.getArguments().get(0).getDataType();
        return '(' + argType + ", " + argType + ')';
    }
}
