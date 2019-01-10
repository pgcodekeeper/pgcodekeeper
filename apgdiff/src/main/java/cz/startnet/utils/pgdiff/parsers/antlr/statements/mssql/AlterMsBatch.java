package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statement_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
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
        addFullObjReference(qname.schema, qname.name, type, StatementActions.ALTER);
    }

    private void alterTrigger(Create_or_alter_triggerContext ctx) {
        Qualified_nameContext qname = ctx.trigger_name;
        IdContext schemaCtx = qname.schema;
        if (schemaCtx == null) {
            schemaCtx = ctx.table_name.schema;
        }

        if (schemaCtx != null) {
            IdContext parentCtx = ctx.table_name.name;
            IdContext nameCtx = qname.name;
            List<IdContext> ids = Arrays.asList(schemaCtx, parentCtx);
            // second schema ref
            // CREATE TRIGGER schema.trigger ON schema.table ...
            addReferenceOnSchema(ctx.table_name.schema);
            addFullObjReference(ids, DbObjType.TABLE, StatementActions.NONE);

            PgObjLocation loc = new PgObjLocation(getSchemaNameSafe(ids),
                    parentCtx.getText(), nameCtx.getText(), DbObjType.TRIGGER);
            addObjReference(loc, StatementActions.ALTER, nameCtx);
        }
    }
}