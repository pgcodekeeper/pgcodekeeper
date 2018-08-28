package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.AbstractTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.SimpleMsTable;

public class AlterMsTable extends TableAbstract {

    private final Alter_tableContext ctx;

    public AlterMsTable(Alter_tableContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        IdContext schemaCtx = ctx.name.schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        AbstractTable table = getSafe(schema::getTable, ctx.name.table);

        Column_def_table_constraintContext colCtx = ctx.column_def_table_constraint();
        if (colCtx != null && colCtx.table_constraint() != null) {
            AbstractConstraint con = getMsConstraint(colCtx.table_constraint());
            con.setNotValid(ctx.NOCHECK() != null);
            table.addConstraint(con);
        } else if (ctx.con != null) {
            getSafe(table::getConstraint, ctx.con).setDisabled(ctx.NOCHECK() != null);;
        }

        IdContext triggerName = ctx.trigger;
        if (triggerName != null) {
            AbstractTrigger tr = getSafe(table::getTrigger, triggerName);
            tr.setDisable(ctx.ENABLE() == null);
        } else if (ctx.CHANGE_TRACKING() != null && ctx.ENABLE() != null) {
            ((SimpleMsTable)table).setTracked(ctx.ON() != null);
        }

        return table;
    }
}
