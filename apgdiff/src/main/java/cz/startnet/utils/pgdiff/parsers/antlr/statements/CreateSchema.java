package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class CreateSchema extends ParserAbstract {
    private final Create_schema_statementContext ctx;
    public CreateSchema(Create_schema_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = QNameParser.getFirstName(ctx.name.identifier());
        if (name == null) {
            return null;
        }
        PgSchema schema = new PgSchema(name, getFullCtxText(ctx.getParent()));
        if (ctx.user_name != null && !name.equals(ApgdiffConsts.PUBLIC)) {
            schema.setOwner(ctx.user_name.getText());
        }
        if (ctx.schema_def != null) {
            schema.setDefinition(getFullCtxText(ctx.schema_def));
        }
        PgSchema exists = db.getSchema(schema.getName());
        if (exists == null) {
            db.addSchema(schema);
        } else {
            db.tryReplacePublicDef(schema);
        }
        return schema;
    }

}
