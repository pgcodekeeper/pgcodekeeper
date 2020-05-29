package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.All_op_refContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.All_simple_opContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_operator_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_optionContext;
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
        Operator_nameContext operNameCtx = ctx.name;
        IdentifierContext schemaCtx = operNameCtx.schema_name;
        All_simple_opContext operName = operNameCtx.operator;
        List<ParserRuleContext> ids = Arrays.asList(schemaCtx, operName);
        PgOperator oper = new PgOperator(operName.getText());
        for (Operator_optionContext option : ctx.operator_option()) {
            if (option.PROCEDURE() != null || option.FUNCTION() != null) {
                oper.setProcedure(getFullCtxText(option.func_name));
                List<IdentifierContext> funcIds = option.func_name.identifier();
                addDepSafe(oper, funcIds, DbObjType.FUNCTION, true);

                db.addAnalysisLauncher(new OperatorAnalysisLaincher(
                        oper, getOperatorFunction(oper, funcIds), fileName));
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
                oper.setRestrict(getFullCtxText(option.restr_name));
                addDepSafe(oper, option.restr_name.identifier(), DbObjType.FUNCTION, true);
            } else if (option.JOIN() != null) {
                oper.setJoin(getFullCtxText(option.join_name));
                addDepSafe(oper, option.join_name.identifier(), DbObjType.FUNCTION, true);
            }
        }

        addSafe(getSchemaSafe(ids), oper, ids);
    }

    private GenericColumn getOperatorFunction(PgOperator oper, List<IdentifierContext> ids) {
        StringBuilder signature = new StringBuilder();
        String left = oper.getLeftArg();
        String right = oper.getRightArg();

        signature.append(QNameParser.getFirstName(ids)).append('(');
        if (left != null) {
            signature.append(left);
            if (right != null) {
                signature.append(", ").append(right);
            }
        } else {
            signature.append(right);
        }
        signature.append(')');

        return new GenericColumn(QNameParser.getSchemaName(ids),
                signature.toString(), DbObjType.FUNCTION);
    }

    @Override
    protected String getStmtAction() {
        Operator_nameContext operNameCtx = ctx.name;
        return getStrForStmtAction(ACTION_CREATE, DbObjType.OPERATOR,
                Arrays.asList(operNameCtx.schema_name, operNameCtx.operator));
    }
}
