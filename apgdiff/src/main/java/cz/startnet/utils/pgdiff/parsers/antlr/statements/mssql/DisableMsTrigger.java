package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Disable_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Trigger_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Trigger_namesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTriggerContainer;

public class DisableMsTrigger extends ParserAbstract {

    private final Disable_triggerContext ctx;

    public DisableMsTrigger(Disable_triggerContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        Trigger_namesContext triggers = ctx.trigger_names();
        Table_nameContext parent = ctx.table_name();
        if (triggers == null || parent == null) {
            return null;
        }

        IdContext schemaCtx = parent.schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        PgTriggerContainer cont = schema.getTable(parent.table.getText());
        if (cont == null) {
            cont = getSafe(schema::getView, parent.table);
        }

        for (Trigger_nameContext trigger : triggers.trigger_name()) {
            cont.getTrigger(trigger.name.getText()).setDisable(true);
        }

        return null;
    }
}
