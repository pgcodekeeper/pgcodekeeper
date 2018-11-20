package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_aggregate_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgAggregate;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterAggregate extends ParserAbstract {

    private final Alter_aggregate_statementContext ctx;
    public AlterAggregate(Alter_aggregate_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        IdentifierContext nameCtx = QNameParser.getFirstNameCtx(ids);

        PgAggregate arrg = getSafe(schema::getAggregate,
                parseSignatureAggr(nameCtx.getText(), ctx.function_parameters().function_args()),
                nameCtx.getStart());
        fillOwnerTo(ctx.owner_to(), arrg);
        return null;
    }
}