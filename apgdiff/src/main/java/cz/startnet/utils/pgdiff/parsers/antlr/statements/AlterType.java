package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgType;

public class AlterType extends ParserAbstract {

    private final Alter_type_statementContext ctx;

    public AlterType(Alter_type_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        PgType type = getSafe(schema::getType, QNameParser.getFirstNameCtx(ids));
        fillOwnerTo(ctx.owner_to(), type);
        return type;
    }
}