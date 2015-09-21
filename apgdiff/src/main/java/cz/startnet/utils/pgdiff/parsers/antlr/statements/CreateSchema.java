package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
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
        String name = getName(ctx.name);
        if (name == null) {
            return null;
        }
        PgSchema schema = new PgSchema(name, getFullCtxText(ctx.getParent()));
        if (ctx.user_name!=null
                && !name.equals(ApgdiffConsts.PUBLIC)) {
            schema.setOwner(ctx.user_name.getText());
        }
        StringBuilder elements = new StringBuilder(10);
        for (StatementContext element : ctx.schema_element) {
            elements.append(element.getText());
        }
        if (elements.length() > 0) {
            schema.setDefinition(elements.toString());
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
