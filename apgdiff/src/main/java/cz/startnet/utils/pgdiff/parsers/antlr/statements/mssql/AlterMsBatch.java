package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statement_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterMsBatch extends BatchContextProcessor {

    private final Batch_statement_bodyContext ctx;

    public AlterMsBatch(Batch_statement_bodyContext ctx, PgDatabase db, CommonTokenStream stream) {
        super(db, ctx, stream);
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
        addObjReference(Arrays.asList(qname.schema, qname.name), type, ACTION_ALTER);
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
            addObjReference(Arrays.asList(secondCtx), DbObjType.SCHEMA, null);
        }
        addObjReference(Arrays.asList(schemaCtx, ctx.table_name.name),
                DbObjType.TABLE, null);
        addObjReference(Arrays.asList(schemaCtx, ctx.table_name.name, qname.name),
                DbObjType.TRIGGER, ACTION_ALTER);
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        return super.fillQueryLocation(ctx.getParent());
    }

    @Override
    protected String getStmtAction() {
        DbObjType type;
        List<? extends ParserRuleContext> ids;
        if (ctx.create_or_alter_procedure() != null) {
            Qualified_nameContext qname = ctx.create_or_alter_procedure().qualified_name();
            ids = Arrays.asList(qname.schema, qname.name);
            type = DbObjType.PROCEDURE;
        } else if (ctx.create_or_alter_function() != null) {
            Qualified_nameContext qname = ctx.create_or_alter_function().qualified_name();
            ids = Arrays.asList(qname.schema, qname.name);
            type = DbObjType.FUNCTION;
        } else if (ctx.create_or_alter_view() != null) {
            Qualified_nameContext qname = ctx.create_or_alter_view().qualified_name();
            ids = Arrays.asList(qname.schema, qname.name);
            type = DbObjType.VIEW;
        } else if (ctx.create_or_alter_trigger() != null) {
            Create_or_alter_triggerContext trigCtx = ctx.create_or_alter_trigger();
            Qualified_nameContext qname = trigCtx.trigger_name;
            IdContext schemaCtx = qname.schema;
            IdContext secondCtx = trigCtx.table_name.schema;
            if (schemaCtx == null) {
                schemaCtx = secondCtx;
            }
            ids = Arrays.asList(schemaCtx, trigCtx.table_name.name, qname.name);
            type = DbObjType.TRIGGER;
        } else {
            return null;
        }

        return getStrForStmtAction(ACTION_ALTER, type, ids);
    }

    @Override
    protected ParserRuleContext getDelimiterCtx() {
        throw new IllegalStateException("Unsupported operation for AlterMsBatch");
    }
}