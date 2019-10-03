package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statement_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

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
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        return super.fillQueryLocation(ctx.getParent());
    }

    @Override
    protected Pair<StatementActions, GenericColumn> fillDescrObj() {
        GenericColumn descrObj = null;
        if (ctx.create_or_alter_procedure() != null) {
            Qualified_nameContext qname = ctx.create_or_alter_procedure().qualified_name();
            descrObj = new GenericColumn(qname.schema.getText(),
                    qname.name.getText(), DbObjType.PROCEDURE);
        } else if (ctx.create_or_alter_function() != null) {
            Qualified_nameContext qname = ctx.create_or_alter_function().qualified_name();
            descrObj = new GenericColumn(qname.schema.getText(),
                    qname.name.getText(), DbObjType.FUNCTION);
        } else if (ctx.create_or_alter_view() != null) {
            Qualified_nameContext qname = ctx.create_or_alter_view().qualified_name();
            descrObj = new GenericColumn(qname.schema.getText(),
                    qname.name.getText(), DbObjType.VIEW);
        } else if (ctx.create_or_alter_trigger() != null) {
            Create_or_alter_triggerContext trigCtx = ctx.create_or_alter_trigger();
            Qualified_nameContext qname = trigCtx.trigger_name;
            IdContext schemaCtx = qname.schema;
            IdContext secondCtx = trigCtx.table_name.schema;
            if (schemaCtx == null) {
                schemaCtx = secondCtx;
            }
            descrObj = new GenericColumn(schemaCtx.getText(),
                    trigCtx.table_name.name.getText(), qname.name.getText(), DbObjType.TRIGGER);
        }
        return descrObj != null ? new Pair<>(StatementActions.ALTER, descrObj) : null;
    }
}