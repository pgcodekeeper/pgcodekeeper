package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class AlterSchema extends ParserAbstract {
    private final Alter_schema_statementContext ctx;
    public AlterSchema(Alter_schema_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = ctx.schema_with_name().name.getText();
        AbstractSchema schema = getSafe(db::getSchema, ctx.schema_with_name().name);

        Owner_toContext owner = ctx.owner_to();
        if (!ApgdiffConsts.PUBLIC.equals(name) || !"postgres".equals(owner.name.getText())) {
            fillOwnerTo(owner, schema);
        }
        return null;
    }
}
