package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;
import java.util.function.BiConsumer;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Aggregate_paramContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_aggregate_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgAggregate;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateAggregate extends ParserAbstract {
    private final Create_aggregate_statementContext ctx;
    public CreateAggregate(Create_aggregate_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        String schemaName = schema.getName();

        String name = QNameParser.getFirstName(ids);
        String rawStatement = getFullCtxText(ctx.getParent());

        PgAggregate aggregate = new PgAggregate(name, rawStatement);

        //// The order is important for adding dependencies. Two steps.

        // First step: filling all types and arguments.

        if (ctx.BASETYPE() != null) {
            Data_typeContext baseTypeCtx = ctx.base_type;
            aggregate.setBaseType(getFullCtxText(baseTypeCtx));
            addTypeAsDepcy(baseTypeCtx, aggregate, schemaName);
        }

        Data_typeContext sTypeCtx = ctx.type;
        String sType = getFullCtxText(sTypeCtx);
        aggregate.setSType(sType);
        addTypeAsDepcy(sTypeCtx, aggregate, schemaName);

        fillAllArguments(aggregate);

        // Second step: filling other parameters of AGGREGATE.

        Schema_qualified_nameContext sFuncCtx = ctx.sfunc_name;
        aggregate.setSFunc(sFuncCtx.getText());
        addFuncAsDepcy(PgAggregate.SFUNC, sFuncCtx, aggregate, schemaName);

        fillAggregate(ctx.aggregate_param(), aggregate, schema.getName(), schemaName, sType);

        schema.addFunction(aggregate);
        return aggregate;
    }

    private void fillAllArguments(PgAggregate aggregate) {
        Function_argsContext argumentsCtx = ctx.function_parameters().function_args();

        fillArguments(argumentsCtx.function_arguments(), aggregate,
                (aggr, a) -> aggr.addArgument(a));

        if (argumentsCtx.agg_order() != null) {
            fillArguments(argumentsCtx.agg_order().function_arguments(), aggregate,
                    (aggr, a) -> aggr.addOrderByArg(a));
        }
    }

    private void fillArguments(List<Function_argumentsContext> argumentsCtx, PgAggregate aggr,
            BiConsumer<PgAggregate, Argument> addArgument) {
        for (Function_argumentsContext argumentCtx : argumentsCtx) {
            Data_typeContext argumentTypeCtx = argumentCtx.argtype_data;
            addTypeAsDepcy(argumentTypeCtx, aggr, getDefSchemaName());
            addArgument.accept(aggr, new Argument(
                    argumentCtx.arg_mode != null ? argumentCtx.arg_mode.getText() : null,
                            argumentCtx.argname != null ? argumentCtx.argname.getText() : null,
                                    getFullCtxText(argumentTypeCtx)));
        }
    }

    private void fillAggregate(List<Aggregate_paramContext> params,
            PgAggregate aggregate, String aggrSchemaName, String defSchemaName,
            String sType) {
        if (params != null) {
            for (Aggregate_paramContext paramOpt : params) {
                if (paramOpt.SSPACE() != null) {
                    aggregate.setSSpace(Long.parseLong(paramOpt.s_space.getText()));
                } else if (paramOpt.FINALFUNC() != null) {
                    Schema_qualified_nameContext finalFuncCtx = paramOpt.final_func;
                    aggregate.setFinalFunc(finalFuncCtx.getText());
                    addFuncAsDepcy(PgAggregate.FINALFUNC, finalFuncCtx, aggregate, defSchemaName);
                } else if (paramOpt.FINALFUNC_EXTRA() != null) {
                    aggregate.setFinalFuncExtra(true);
                } else if (paramOpt.FINALFUNC_MODIFY() != null) {
                    aggregate.setFinalFuncModify(getModifyParam(paramOpt));
                } else if (paramOpt.COMBINEFUNC() != null) {
                    Schema_qualified_nameContext combineFuncCtx = paramOpt.combine_func;
                    aggregate.setCombineFunc(combineFuncCtx.getText());
                    addFuncAsDepcy(PgAggregate.COMBINEFUNC, combineFuncCtx, aggregate, defSchemaName);
                } else if (paramOpt.SERIALFUNC() != null) {
                    // TODO add dependency
                    aggregate.setSerialFunc(paramOpt.serial_func.getText());
                } else if (paramOpt.DESERIALFUNC() != null) {
                    // TODO add dependency
                    aggregate.setDeserialFunc(paramOpt.deserial_func.getText());
                } else if (paramOpt.INITCOND() != null) {
                    aggregate.setInitCond(paramOpt.init_cond.getText());
                } else if (paramOpt.MSFUNC() != null) {
                    Schema_qualified_nameContext mSFuncCtx = paramOpt.ms_func;
                    aggregate.setMSFunc(mSFuncCtx.getText());
                    addFuncAsDepcy(PgAggregate.MSFUNC, mSFuncCtx, aggregate, defSchemaName);
                } else if (paramOpt.MINVFUNC() != null) {
                    Schema_qualified_nameContext mInvFuncCtx = paramOpt.minv_func;
                    aggregate.setMInvFunc(mInvFuncCtx.getText());
                    addFuncAsDepcy(PgAggregate.MINVFUNC, mInvFuncCtx, aggregate, defSchemaName);
                } else if (paramOpt.MSTYPE() != null) {
                    Data_typeContext mSTypeCtx = paramOpt.ms_type;
                    aggregate.setMSType(getFullCtxText(mSTypeCtx));
                    addTypeAsDepcy(mSTypeCtx, aggregate, aggrSchemaName);
                } else if (paramOpt.MSSPACE() != null) {
                    aggregate.setMSSpace(Long.parseLong(paramOpt.ms_space.getText()));
                } else if (paramOpt.MFINALFUNC() != null) {
                    Schema_qualified_nameContext mFinalFuncCtx = paramOpt.mfinal_func;
                    aggregate.setMFinalFunc(mFinalFuncCtx.getText());
                    addFuncAsDepcy(PgAggregate.MFINALFUNC, mFinalFuncCtx, aggregate, defSchemaName);
                } else if (paramOpt.MFINALFUNC_EXTRA() != null) {
                    aggregate.setMFinalFuncExtra(true);
                } else if (paramOpt.MFINALFUNC_MODIFY() != null) {
                    aggregate.setMFinalFuncModify(getModifyParam(paramOpt));
                } else if (paramOpt.MINITCOND() != null) {
                    aggregate.setMInitCond(paramOpt.minit_cond.getText());
                } else if (paramOpt.SORTOP() != null) {
                    Operator_nameContext operNameCtx = paramOpt.oper_name;
                    String operName = operNameCtx.getText();
                    aggregate.setSortOp(operName);
                    aggregate.addDep(new GenericColumn(
                            CreateOperator.getSchemaSafe(operNameCtx, db.getDefaultSchema(), db).getName(),
                            getSortOperSign(aggregate, operNameCtx.operator.getText(), sType),
                            DbObjType.OPERATOR));
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
                    aggregate.setHypothetical(true);
                }
            }
        }

        String kind = PgAggregate.NORMAL;
        if (aggregate.isHypothetical()) {
            kind = PgAggregate.HYPOTHETICAL;
        } else if (!aggregate.getOrderByArgs().isEmpty()){
            kind = PgAggregate.ORDERED;
        }
        aggregate.setKind(kind);

        checkFinalFuncModifiers(aggregate);
    }

    private void checkFinalFuncModifiers(PgAggregate aggr) {
        String finalFuncModify = aggr.getFinalFuncModify();
        String mFinalFuncModify = aggr.getMFinalFuncModify();
        if (finalFuncModify != null && mFinalFuncModify != null) {
            return;
        }

        String kind = aggr.getKind();

        // The default is READ_ONLY, except for ordered aggregates, for which the default is READ_WRITE.
        String defaultModifier = null;
        switch (kind.toLowerCase()) {
        case PgAggregate.NORMAL:
            defaultModifier = "READ_ONLY";
            break;

        case PgAggregate.HYPOTHETICAL:
        case PgAggregate.ORDERED:
            defaultModifier = "READ_WRITE";
            break;

        default:
            throw new IllegalStateException(kind + " doesn't support by AGGREGATE!");
        }


        if (finalFuncModify == null) {
            aggr.setFinalFuncModify(defaultModifier);
        }
        if (mFinalFuncModify == null) {
            aggr.setMFinalFuncModify(defaultModifier);
        }
    }

    private String getModifyParam(Aggregate_paramContext param) {
        String finalFuncModify = null;
        if (param.READ_ONLY() != null) {
            finalFuncModify = param.READ_ONLY().getText();
        } else if (param.SHAREABLE() != null) {
            finalFuncModify = param.SHAREABLE().getText();
        } else if (param.READ_WRITE() != null) {
            finalFuncModify = param.READ_WRITE().getText();
        }
        return finalFuncModify;
    }

    private void addFuncAsDepcy(String paramName, Schema_qualified_nameContext paramFuncCtx,
            PgAggregate aggr, String defSchemaName) {
        List<IdentifierContext> funcIds = paramFuncCtx.identifier();
        String funcSchemaName = QNameParser.getSchemaName(funcIds, defSchemaName);
        if (!PgSystemStorage.SCHEMA_PG_CATALOG.equalsIgnoreCase(funcSchemaName)) {
            aggr.addDep(new GenericColumn(funcSchemaName,
                    getParamFuncSignature(aggr, QNameParser.getFirstName(funcIds), paramName),
                    DbObjType.FUNCTION));
        }
    }

    /**
     * Gets the signature for the given function name.
     *
     * @param aggregate aggregate object
     * @param funcName function name
     * @param paramName name of parameter
     * @return
     */
    public static String getParamFuncSignature(PgAggregate aggregate, String funcName,
            String paramName) {
        StringBuilder sb = new StringBuilder();
        sb.append(funcName).append('(');

        String sType = aggregate.getSType();
        String mSType = aggregate.getMSType();
        List<Argument> args = aggregate.getArguments();
        List<Argument> orderByArgs = aggregate.getOrderByArgs();

        switch(paramName) {
        case PgAggregate.SFUNC:
            sb.append(sType).append(", ");
            if (args.isEmpty() && orderByArgs.isEmpty()) {
                // for signature: aggregateName(*)
                // no action
            } else if (!args.isEmpty() && orderByArgs.isEmpty()) {
                // for signature: aggregateName(mode name type, ...)
                fillStringByArgs(sb, args);
            } else if (args.isEmpty() && !orderByArgs.isEmpty()) {
                // for signature: aggregateName(ORDER BY mode name type, ...)
                fillStringByArgs(sb, orderByArgs);
            } else {
                // for signature: aggregateName(mode name type, ... ORDER BY modeN nameN typeN, ....)
                fillStringByArgs(sb, orderByArgs);
            }
            break;

        case PgAggregate.FINALFUNC:
            sb.append(sType).append(", ");
            if (!args.isEmpty() && !orderByArgs.isEmpty()) {
                // for signature: aggregateName(mode name type, ... ORDER BY modeN nameN typeN, ....)
                fillStringByArgs(sb, args);
            }
            break;

        case PgAggregate.COMBINEFUNC:
            sb.append(sType).append(", ");
            sb.append(sType).append(", ");
            break;

            // TODO
            // case PgAggregate.SERIALFUNC:
            // case PgAggregate.DESERIALFUNC:

        case PgAggregate.MSFUNC:
        case PgAggregate.MINVFUNC:
            sb.append(mSType).append(", ");
            if (args.isEmpty() && orderByArgs.isEmpty()) {
                // for signature: aggregateName(*)
                // no action
            } else if (!args.isEmpty() && orderByArgs.isEmpty()) {
                // for signature: aggregateName(mode name type, ...)
                fillStringByArgs(sb, args);
            } else if (args.isEmpty() && !orderByArgs.isEmpty()) {
                // for signature: aggregateName(ORDER BY mode name type, ...)
                fillStringByArgs(sb, orderByArgs);
            } else {
                // for signature: aggregateName(mode name type, ... ORDER BY modeN nameN typeN, ....)
                fillStringByArgs(sb, orderByArgs);
            }
            break;

        case PgAggregate.MFINALFUNC:
            sb.append(mSType).append(", ");
            if (!args.isEmpty() && !orderByArgs.isEmpty()) {
                // for signature: aggregateName(mode name type, ... ORDER BY modeN nameN typeN, ....)
                fillStringByArgs(sb, args);
            }
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
            String argMode = arg.getMode();
            if (!"IN".equals(argMode)) {
                sb.append(argMode).append(" ");
            }
            String argName = arg.getName();
            if (argName != null) {
                sb.append(argName).append(" ");
            }
            sb.append(arg.getDataType()).append(", ");
        }
    }

    public static String getSortOperSign(PgAggregate aggr, String operName, String sType) {
        StringBuilder operSign = new StringBuilder();
        operSign.append(operName).append('(').append(sType).append(", ");

        List<Argument> args = aggr.getArguments();
        if (!args.isEmpty()) {
            operSign.append(args.get(0).getDataType());
        } else {
            List<Argument> orderByArgs = aggr.getOrderByArgs();
            operSign.append(orderByArgs.get(0).getDataType());
        }

        operSign.append(')');

        return operSign.toString();
    }

}
