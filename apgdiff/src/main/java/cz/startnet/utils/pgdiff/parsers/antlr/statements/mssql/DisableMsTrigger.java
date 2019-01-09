package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Enable_disable_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Names_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgTriggerContainer;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DisableMsTrigger extends ParserAbstract {

    private final Enable_disable_triggerContext ctx;

    public DisableMsTrigger(Enable_disable_triggerContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Names_referencesContext triggers = ctx.names_references();
        Qualified_nameContext parent = ctx.qualified_name();
        if (triggers == null || parent == null) {
            return;
        }

        IdContext schemaCtx = parent.schema;
        List<IdContext> ids = Arrays.asList(schemaCtx, parent.name);
        PgTriggerContainer cont = getSafe(AbstractSchema::getTriggerContainer,
                getSchemaSafe(ids), parent.name.getText(), parent.name.start);
        addFullObjReference(parent.schema, parent.name, DbObjType.TABLE, StatementActions.NONE);

        for (Qualified_nameContext qname : triggers.qualified_name()) {
            MsTrigger trig = (MsTrigger) getSafe(PgTriggerContainer::getTrigger,
                    cont, qname.name.getText(), qname.name.start);
            addReferenceOnSchema(schemaCtx);
            PgObjLocation loc = new PgObjLocation(getSchemaNameSafe(ids),
                    parent.name.getText(), qname.name.getText(), DbObjType.TRIGGER);
            addObjReference(loc, StatementActions.ALTER, qname);
            if (ctx.DISABLE() != null) {
                setSafe(MsTrigger::setDisable, trig, true);
            }
        }
    }
}
