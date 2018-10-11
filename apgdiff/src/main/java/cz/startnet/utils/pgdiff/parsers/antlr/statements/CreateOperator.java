package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.Token;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_operator_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
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
        AbstractSchema schema = getSchemaSafe(operNameCtx, db.getDefaultSchema());
        PgOperator oper = new PgOperator(operNameCtx.operator.getText(), getFullCtxText(ctx.getParent()));
        for (Operator_optionContext option : ctx.operator_option()) {
            if (option.PROCEDURE() != null) {
                Schema_qualified_nameContext procFuncNameCtx = option.func_name;
                oper.setProcedure(procFuncNameCtx.getText());
                List<IdentifierContext> ids = procFuncNameCtx.identifier();
                oper.addDep(new GenericColumn(QNameParser.getSchemaName(ids, schema.getName()),
                        QNameParser.getFirstNameCtx(ids).getText(), DbObjType.FUNCTION));
            } else if (option.LEFTARG() != null) {
                Data_typeContext leftArgTypeCtx = option.type;
                oper.setLeftArg(new Argument(PgOperator.LEFTARG, leftArgTypeCtx.getText()));
                addTypeAsDepcy(leftArgTypeCtx, oper, schema.getName());
            } else if (option.RIGHTARG() != null) {
                Data_typeContext rightArgTypeCtx = option.type;
                oper.setRightArg(new Argument(PgOperator.RIGHTARG, rightArgTypeCtx.getText()));
                addTypeAsDepcy(rightArgTypeCtx, oper, schema.getName());
            } else if (option.COMMUTATOR() != null) {
                oper.setCommutator(option.addition_oper_name.getText());
            } else if (option.NEGATOR() != null) {
                oper.setNegator(option.addition_oper_name.getText());
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

    private AbstractSchema getSchemaSafe(Operator_nameContext operNameCtx, AbstractSchema defaultSchema) {
        IdentifierContext schemaCtx = operNameCtx.schema_name;
        AbstractSchema foundSchema = schemaCtx == null ? defaultSchema : getSafe(db::getSchema, schemaCtx);
        if (foundSchema != null) {
            return foundSchema;
        }

        Token opChars = operNameCtx.operator;
        throw new UnresolvedReferenceException("Schema not found for " +
                opChars.getText(), opChars);
    }
}
