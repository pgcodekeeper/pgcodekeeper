package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.Token;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_operator_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.OpContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgOperator;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateOperator extends ParserAbstract {
    private final Create_operator_statementContext ctx;
    public CreateOperator(Create_operator_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        Operator_nameContext operNameCtx = ctx.name;
        AbstractSchema operSchema = getSchemaSafe(operNameCtx, db.getDefaultSchema(), db);
        String operSchemaName = operSchema.getName();
        PgOperator oper = new PgOperator(operNameCtx.operator.getText(),
                getFullCtxText(ctx.getParent()));
        String procFuncSchemaName = null;
        String procFuncName = null;
        for (Operator_optionContext option : ctx.operator_option()) {
            if (option.PROCEDURE() != null || option.FUNCTION() != null) {
                Schema_qualified_nameContext procFuncNameCtx = option.func_name;
                List<IdentifierContext> ids = procFuncNameCtx.identifier();
                procFuncSchemaName = QNameParser.getSchemaName(ids, operSchemaName);
                procFuncName = QNameParser.getFirstName(ids);
                oper.setProcedure(PgDiffUtils.getQuotedName(procFuncSchemaName) + '.'
                        + PgDiffUtils.getQuotedName(procFuncName));
            } else if (option.LEFTARG() != null) {
                Data_typeContext leftArgTypeCtx = option.type;
                oper.setLeftArg(leftArgTypeCtx.getText());
                addTypeAsDepcy(leftArgTypeCtx, oper, operSchemaName);
            } else if (option.RIGHTARG() != null) {
                Data_typeContext rightArgTypeCtx = option.type;
                oper.setRightArg(rightArgTypeCtx.getText());
                addTypeAsDepcy(rightArgTypeCtx, oper, operSchemaName);
            } else if (option.COMMUTATOR() != null || option.NEGATOR() != null) {
                OpContext comutNameCtx = option.addition_oper_name;
                IdentifierContext schemaNameCxt = comutNameCtx.identifier();
                StringBuilder sb = new StringBuilder();
                if (schemaNameCxt != null) {
                    sb.append("OPERATOR(")
                    .append(PgDiffUtils.getQuotedName(schemaNameCxt.getText()))
                    .append('.');
                }
                sb.append(comutNameCtx.OP_CHARS().getText());
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
                oper.setRestrict(option.restr_name.getText());
            } else if (option.JOIN() != null) {
                oper.setJoin(option.join_name.getText());
            }
        }

        oper.addDep(new GenericColumn(procFuncSchemaName,
                procFuncName + oper.appendOperatorArgs(new StringBuilder()).toString(),
                DbObjType.FUNCTION));

        operSchema.addOperator(oper);
        return oper;
    }


    public static AbstractSchema getSchemaSafe(Operator_nameContext operNameCtx,
            AbstractSchema defaultSchema, PgDatabase db) {
        IdentifierContext schemaCtx = operNameCtx.schema_name;
        AbstractSchema foundSchema = schemaCtx == null ?
                defaultSchema : getSafe(db::getSchema, schemaCtx);
        if (foundSchema != null) {
            return foundSchema;
        }

        Token opChars = operNameCtx.operator;
        throw new UnresolvedReferenceException("Schema not found for " +
                opChars.getText(), opChars);
    }
}
