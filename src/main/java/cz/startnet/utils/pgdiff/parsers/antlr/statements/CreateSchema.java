package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateSchema extends ParserAbstract {
    private Create_schema_statementContext ctx;
    public CreateSchema(Create_schema_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        if (name == null) {
            return null;
        }
        PgSchema schema = new PgSchema(name, getFullCtxText(ctx.getParent()));
        if (ctx.user_name!=null) {
            schema.setAuthorization(ctx.user_name.getText());
        }
        StringBuilder elements = new StringBuilder(10);
        for (SqlContext element : ctx.schema_element) {
            elements.append(element.getText());
        }
        schema.setDefinition(elements.toString());
        fillObjLocation(schema, ctx.name.getStart().getStartIndex(), name);
        return schema;
    }

}
