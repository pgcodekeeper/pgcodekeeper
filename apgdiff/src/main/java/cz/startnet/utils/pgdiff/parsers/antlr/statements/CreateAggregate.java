package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Aggregate_paramContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.All_op_refContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_aggregate_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgAggregate;
import cz.startnet.utils.pgdiff.schema.PgAggregate.AggKinds;
import cz.startnet.utils.pgdiff.schema.PgAggregate.ModifyType;
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
        aggregate.setSType(getFullCtxText(sTypeCtx));
        addTypeAsDepcy(sTypeCtx, aggregate, schemaName);

        fillAllArguments(aggregate);

        // Second step: filling other parameters of AGGREGATE.

        Schema_qualified_nameContext sFuncCtx = ctx.sfunc_name;
        aggregate.setSFunc(sFuncCtx.getText());
        addFuncAsDepcy(PgAggregate.SFUNC, sFuncCtx, aggregate, schemaName);

        fillAggregate(ctx.aggregate_param(), aggregate, schema.getName(), schemaName);

        schema.addFunction(aggregate);
        return aggregate;
    }

    private void fillAllArguments(PgAggregate aggregate) {
        Function_argsContext argumentsCtx = ctx.function_parameters().function_args();
        List<Function_argumentsContext> directArgs = argumentsCtx.function_arguments();
        fillArguments(directArgs, aggregate);

        if (argumentsCtx.agg_order() != null) {
            fillArguments(argumentsCtx.agg_order().function_arguments(), aggregate);
        }

        aggregate.setDirectCount(directArgs.size());
    }

    private void fillArguments(List<Function_argumentsContext> argumentsCtx, PgAggregate aggr) {
        for (Function_argumentsContext argument : argumentsCtx) {
            Argument arg = new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null,
                            getFullCtxText(argument.argtype_data));
            addTypeAsDepcy(argument.data_type(), aggr, getDefSchemaName());
            aggr.addArgument(arg);
        }
    }

    private void fillAggregate(List<Aggregate_paramContext> params,
            PgAggregate aggregate, String aggrSchemaName, String defSchemaName) {
        ModifyType finalFuncModify = null;
        ModifyType mFinalFuncModify = null;
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
                    finalFuncModify = getModifyParam(paramOpt);
                } else if (paramOpt.COMBINEFUNC() != null) {
                    Schema_qualified_nameContext combineFuncCtx = paramOpt.combine_func;
                    aggregate.setCombineFunc(combineFuncCtx.getText());
                    addFuncAsDepcy(PgAggregate.COMBINEFUNC, combineFuncCtx, aggregate, defSchemaName);
                } else if (paramOpt.SERIALFUNC() != null) {
                    Schema_qualified_nameContext serialFuncCtx = paramOpt.serial_func;
                    aggregate.setSerialFunc(serialFuncCtx.getText());
                    addFuncAsDepcy(PgAggregate.SERIALFUNC, serialFuncCtx, aggregate, defSchemaName);
                } else if (paramOpt.DESERIALFUNC() != null) {
                    Schema_qualified_nameContext deserialFuncCtx = paramOpt.deserial_func;
                    aggregate.setDeserialFunc(deserialFuncCtx.getText());
                    addFuncAsDepcy(PgAggregate.DESERIALFUNC, deserialFuncCtx, aggregate, defSchemaName);
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
                    sb.append(operCtx.all_simple_op().getText());
                    if (schemaNameCxt != null) {
                        sb.append(')');
                    }

                    aggregate.setSortOp(sb.toString());

                    // TODO waits task #16080
                    // aggregate.addDep(new GenericColumn(schemaNameCxt == null ?
                    //         defSchemaName : schemaNameCxt.getText(),
                    //         getSortOperSign(aggregate, operCtx.all_simple_op().getText()),
                    //         DbObjType.OPERATOR));
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
        int directCount = aggregate.getDirectCount();
        List<Argument> orderByArgs = args.subList(directCount, args.size());

        switch(paramName) {
        case PgAggregate.SFUNC:
        case PgAggregate.MSFUNC:
        case PgAggregate.MINVFUNC:
            sb.append(paramName == PgAggregate.SFUNC ? sType : mSType).append(", ");
            fillStringByArgs(sb, orderByArgs.isEmpty() ? args : orderByArgs);
            break;
        case PgAggregate.FINALFUNC:
        case PgAggregate.MFINALFUNC:
            sb.append(paramName == PgAggregate.FINALFUNC ? sType : mSType).append(", ");
            if (directCount > 0 && !orderByArgs.isEmpty()) {
                // for signature: aggregateName(mode name type, ... ORDER BY modeN nameN typeN, ....)
                fillStringByArgs(sb, args.subList(0, directCount));
            }
            break;

        case PgAggregate.COMBINEFUNC:
            sb.append(sType).append(", ").append(sType).append(", ");
            break;

        case PgAggregate.DESERIALFUNC:
            sb.append("bytea").append(", ");
            // $FALL-THROUGH$
        case PgAggregate.SERIALFUNC:
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

    public static String getSortOperSign(PgAggregate aggr, String operName) {
        StringBuilder operSign = new StringBuilder();
        String argType = aggr.getArguments().get(0).getDataType();
        operSign.append(operName).append('(').append(argType).append(", ");
        operSign.append(argType);
        operSign.append(')');

        return operSign.toString();
    }

}
