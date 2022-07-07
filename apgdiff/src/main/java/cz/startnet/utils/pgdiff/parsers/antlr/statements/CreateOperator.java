package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.All_op_refContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_operator_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.OperatorAnalysisLaincher;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgOperator;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateOperator extends ParserAbstract {

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
        for (Operator_optionContext option : ctx.operator_option()) {
            if (option.PROCEDURE() != null || option.FUNCTION() != null) {
                funcCtx = option.func_name;
            } else if (option.LEFTARG() != null) {
                Data_typeContext leftArgTypeCtx = option.type;
                oper.setLeftArg(getTypeName(leftArgTypeCtx));
                addPgTypeDepcy(leftArgTypeCtx, oper);
            } else if (option.RIGHTARG() != null) {
                Data_typeContext rightArgTypeCtx = option.type;
                oper.setRightArg(getTypeName(rightArgTypeCtx));
                addPgTypeDepcy(rightArgTypeCtx, oper);
            } else if (option.COMMUTATOR() != null || option.NEGATOR() != null) {
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

        // waits for operator arguments to add the correct dependency
        String arguments = oper.getArguments();
        if (funcCtx != null) {
            oper.setProcedure(getFullCtxText(funcCtx));
            List<ParserRuleContext> funcIds = getIdentifiers(funcCtx);
            addDepSafe(oper, funcIds, DbObjType.FUNCTION, true, arguments);
            db.addAnalysisLauncher(new OperatorAnalysisLaincher(
                    oper, getOperatorFunction(oper, funcIds), fileName));
        }

        if (restCtx != null) {
            oper.setRestrict(getFullCtxText(restCtx));
            List<ParserRuleContext> funcIds = getIdentifiers(restCtx);
            addDepSafe(oper, funcIds, DbObjType.FUNCTION, true, arguments);
        }

        if (joinCtx != null) {
            oper.setJoin(getFullCtxText(joinCtx));
            List<ParserRuleContext> funcIds = getIdentifiers(joinCtx);
            addDepSafe(oper, funcIds, DbObjType.FUNCTION, true, arguments);
        }


        addSafe(getSchemaSafe(ids), oper, ids);
    }

    private GenericColumn getOperatorFunction(PgOperator oper, List<ParserRuleContext> ids) {
        String name = QNameParser.getFirstName(ids) + oper.getArguments();
        return new GenericColumn(QNameParser.getSchemaName(ids),
                name, DbObjType.FUNCTION);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.OPERATOR, ctx.name);
    }
}
