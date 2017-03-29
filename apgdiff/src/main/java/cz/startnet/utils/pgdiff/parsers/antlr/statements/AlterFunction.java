package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterFunction extends ParserAbstract {

    private final Alter_function_statementContext ctx;
    public AlterFunction(Alter_function_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());

        IdentifierContext nameCtx = QNameParser.getFirstNameCtx(ids);
        PgFunction function = new PgFunction(nameCtx.getText(), getFullCtxText(ctx.getParent()));
        fillArguments(ctx.function_parameters().function_args(), function, getDefSchemaName());

        PgFunction func = getSafe(schema::getFunction, function.getSignature(), nameCtx.getStart());
        fillOwnerTo(ctx.owner_to(), func);
        return null;
    }
}