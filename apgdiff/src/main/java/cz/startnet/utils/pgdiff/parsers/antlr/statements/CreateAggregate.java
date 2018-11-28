package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Aggregate_paramContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Aggregate_param_optionalContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_aggregate_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.PgAggregate;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

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

        String name = QNameParser.getFirstName(ids);
        String rawStatement = getFullCtxText(ctx.getParent());

        PgAggregate aggregate = new PgAggregate(name, rawStatement);
        fillArguments(aggregate);
        fillAggregate(ctx.aggregate_param(), ctx.aggregate_param_optional(), aggregate);

        schema.addFunction(aggregate);
        return aggregate;
    }

    private void fillArguments(PgAggregate aggregate) {
        for (Function_argumentsContext argument : ctx.function_parameters()
                .function_args().function_arguments()) {
            Argument arg = new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null,
                            getFullCtxText(argument.argtype_data));
            addTypeAsDepcy(argument.data_type(), aggregate, getDefSchemaName());
            aggregate.addArgument(arg);
        }
    }

    private void fillAggregate(List<Aggregate_paramContext> params,
            List<Aggregate_param_optionalContext> paramsOpt, PgAggregate aggregate) {
        for (Aggregate_paramContext param : params) {
            if (param.BASETYPE() != null) {
                aggregate.setBaseType(param.base_type.getText());
            } else if (param.SFUNC() != null) {
                aggregate.setSFunc(param.sfunc_name.getText());
            } else if (param.STYPE() != null) {
                aggregate.setSType(param.type.getText());
            }
        }

        if (paramsOpt != null ) {
            for (Aggregate_param_optionalContext paramOpt : paramsOpt) {
                if (paramOpt.SSPACE() != null) {
                    aggregate.setSSpace(Long.parseLong(paramOpt.s_space.getText()));
                } else if (paramOpt.FINALFUNC() != null) {
                    aggregate.setFinalFunc(paramOpt.final_func.getText());
                } else if (paramOpt.FINALFUNC_EXTRA() != null) {
                    aggregate.setFinalFuncExtra(true);
                } else if (paramOpt.FINALFUNC_MODIFY() != null) {
                    aggregate.setFinalFuncModify(getModifyParam(paramOpt));
                } else if (paramOpt.COMBINEFUNC() != null) {
                    aggregate.setCombineFunc(paramOpt.combine_func.getText());
                } else if (paramOpt.SERIALFUNC() != null) {
                    aggregate.setSerialFunc(paramOpt.serial_func.getText());
                } else if (paramOpt.DESERIALFUNC() != null) {
                    aggregate.setDeserialFunc(paramOpt.deserial_func.getText());
                } else if (paramOpt.INITCOND() != null) {
                    aggregate.setInitCond(paramOpt.init_cond.getText());
                } else if (paramOpt.MSFUNC() != null) {
                    aggregate.setMSFunc(paramOpt.ms_func.getText());
                } else if (paramOpt.MINVFUNC() != null) {
                    aggregate.setMInvFunc(paramOpt.minv_func.getText());
                } else if (paramOpt.MSTYPE() != null) {
                    aggregate.setMSType(paramOpt.ms_type.getText());
                } else if (paramOpt.MSSPACE() != null) {
                    aggregate.setMSSpace(Long.parseLong(paramOpt.ms_space.getText()));
                } else if (paramOpt.MFINALFUNC() != null) {
                    aggregate.setMFinalFunc(paramOpt.mfinal_func.getText());
                } else if (paramOpt.MFINALFUNC_EXTRA() != null) {
                    aggregate.setMFinalFuncExtra(true);
                } else if (paramOpt.MFINALFUNC_MODIFY() != null) {
                    aggregate.setMFinalFuncModify(getModifyParam(paramOpt));
                } else if (paramOpt.MINITCOND() != null) {
                    aggregate.setMInitCond(paramOpt.minit_cond.getText());
                } else if (paramOpt.SORTOP() != null) {
                    aggregate.setSortOp(paramOpt.oper_name.getText());
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

        // The default is READ_ONLY, except for ordered-set aggregates, for which the default is READ_WRITE.
        String defaultModifier = null;
        switch (kind.toLowerCase()) {
        case PgAggregate.NORMAL:
        case PgAggregate.HYPOTHETICAL:
            defaultModifier = "READ_ONLY";
            break;

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

    private String getModifyParam(Aggregate_param_optionalContext paramOpt) {
        String finalFuncModify = null;
        if (paramOpt.READ_ONLY() != null) {
            finalFuncModify = paramOpt.READ_ONLY().getText();
        } else if (paramOpt.SHAREABLE() != null) {
            finalFuncModify = paramOpt.SHAREABLE().getText();
        } else if (paramOpt.READ_WRITE() != null) {
            finalFuncModify = paramOpt.READ_WRITE().getText();
        }
        return finalFuncModify;
    }
}
