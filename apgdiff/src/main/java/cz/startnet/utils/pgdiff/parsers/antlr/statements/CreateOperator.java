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
        AbstractSchema schema = getSchemaSafe(operNameCtx, db.getDefaultSchema(), db);
        PgOperator oper = new PgOperator(operNameCtx.operator.getText(),
                getFullCtxText(ctx.getParent()));
        for (Operator_optionContext option : ctx.operator_option()) {
            if (option.PROCEDURE() != null) {
                Schema_qualified_nameContext procFuncNameCtx = option.func_name;
                List<IdentifierContext> ids = procFuncNameCtx.identifier();
                String schemaName = QNameParser.getSchemaName(ids, schema.getName());
                String procName = QNameParser.getFirstName(ids);
                oper.setProcedure(PgDiffUtils.getQuotedName(schemaName) + '.'
                        + PgDiffUtils.getQuotedName(procName));
                oper.addDep(new GenericColumn(schemaName, procName, DbObjType.FUNCTION));
            } else if (option.LEFTARG() != null) {
                Data_typeContext leftArgTypeCtx = option.type;
                oper.setLeftArg(leftArgTypeCtx.getText());
                addTypeAsDepcy(leftArgTypeCtx, oper, schema.getName());
            } else if (option.RIGHTARG() != null) {
                Data_typeContext rightArgTypeCtx = option.type;
                oper.setRightArg(rightArgTypeCtx.getText());
                addTypeAsDepcy(rightArgTypeCtx, oper, schema.getName());
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
                oper.setRestrict(option.join_name.getText());
            }
        }

        schema.addOperator(oper);
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
