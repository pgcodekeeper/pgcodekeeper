package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statement_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterMsBatch extends ParserAbstract {

    private final Batch_statement_bodyContext ctx;

    public AlterMsBatch(Batch_statement_bodyContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.create_or_alter_procedure() != null) {
            alter(ctx.create_or_alter_procedure().qualified_name(), DbObjType.PROCEDURE);
        } else if (ctx.create_or_alter_function() != null) {
            alter(ctx.create_or_alter_function().qualified_name(), DbObjType.FUNCTION);
        } else if (ctx.create_or_alter_view() != null) {
            alter(ctx.create_or_alter_view().qualified_name(), DbObjType.VIEW);
        } else if (ctx.create_or_alter_trigger() != null) {
            alterTrigger(ctx.create_or_alter_trigger());
        }
    }

    private void alter(Qualified_nameContext qname, DbObjType type) {
        addObjReference(Arrays.asList(qname.schema, qname.name), type, StatementActions.ALTER);
    }

    private void alterTrigger(Create_or_alter_triggerContext ctx) {
        Qualified_nameContext qname = ctx.trigger_name;
        IdContext schemaCtx = qname.schema;
        IdContext secondCtx = ctx.table_name.schema;
        if (schemaCtx == null) {
            schemaCtx = secondCtx;
        }

        // second schema ref
        // CREATE TRIGGER schema.trigger ON schema.table ...
        if (secondCtx != null) {
            addObjReference(Arrays.asList(secondCtx), DbObjType.SCHEMA, StatementActions.NONE);
        }
        addObjReference(Arrays.asList(schemaCtx, ctx.table_name.name),
                DbObjType.TABLE, StatementActions.NONE);
        addObjReference(Arrays.asList(schemaCtx, ctx.table_name.name, qname.name),
                DbObjType.TRIGGER, StatementActions.ALTER);
    }

    @Override
    protected void fillQueryLocation(String fullScript) {
        ParserRuleContext ctxWithActionName = ctx.getParent();
        String query = ParserAbstract.getFullCtxText(ctxWithActionName);
        db.addToBatch(new QueryLocation(getStmtAction(query),
                fullScript.indexOf(query), ctxWithActionName.getStart().getLine(), query));
    }
}