package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AbstractTable;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class AlterMsTable extends AbstractTable {

    private final Alter_tableContext ctx;

    public AlterMsTable(Alter_tableContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        IdContext schemaCtx = ctx.name.schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        PgTable table = getSafe(schema::getTable, ctx.name.table);

        Column_def_table_constraintContext colCtx = ctx.column_def_table_constraint();
        if (colCtx != null && colCtx.table_constraint() != null) {
            // TODO check / no check constraint
            addMsConstraint(colCtx.table_constraint(), table);
        }

        return table;
    }
}
