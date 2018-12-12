package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
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
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        IdentifierContext nameCtx = QNameParser.getFirstNameCtx(ids);

        AbstractFunction func = getSafe(schema::getFunction,
                parseSignature(nameCtx.getText(), ctx.function_parameters().function_args()),
                nameCtx.getStart());
        fillOwnerTo(ctx.owner_to(), func);
        return null;
    }
}