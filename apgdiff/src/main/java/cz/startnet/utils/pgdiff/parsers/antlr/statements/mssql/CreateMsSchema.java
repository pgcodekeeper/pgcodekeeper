package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_schemaContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsSchema extends ParserAbstract {

    private final Create_schemaContext ctx;

    public CreateMsSchema(Create_schemaContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.schema_name;
        String name = nameCtx.getText();
        AbstractSchema schema = new MsSchema(name);
        if (ctx.owner_name != null && !db.getArguments().isIgnorePrivileges()) {
            schema.setOwner(ctx.owner_name.getText());
        }

        addSafe(db, schema, Arrays.asList(nameCtx));
    }

    @Override
    protected void fillQueryLocation(String fullScript, List<List<QueryLocation>> batches) {
        ParserRuleContext ctxWithActionName = ctx.getParent();
        String query = ParserAbstract.getFullCtxText(ctxWithActionName);
        batches.get(batches.size() - 1).add(new QueryLocation(getStmtAction(query),
                fullScript.indexOf(query), ctxWithActionName.getStart().getLine(), query));
    }
}
