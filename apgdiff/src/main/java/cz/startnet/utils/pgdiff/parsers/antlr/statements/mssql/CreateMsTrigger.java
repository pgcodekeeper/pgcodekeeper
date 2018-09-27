package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Trigger_operationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Trigger_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTrigger.TgTypes;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsTrigger extends ParserAbstract {

    private final Create_or_alter_triggerContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    public CreateMsTrigger(Create_or_alter_triggerContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
    }

    @Override
    public MsTrigger getObject() {
        List<IdContext> ids = ctx.simple_name().id();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        return getObject(schema);
    }

    public MsTrigger getObject(AbstractSchema schema) {
        MsTrigger trigger = new MsTrigger(QNameParser.getFirstName(ctx.simple_name().id()),
                getFullCtxText(ctx.getParent()));
        trigger.setTableName(QNameParser.getFirstName(ctx.table_name().id()));
        trigger.setAnsiNulls(ansiNulls);
        trigger.setQuotedIdentified(quotedIdentifier);

        if (ctx.AFTER() != null) {
            trigger.setType(TgTypes.AFTER);
        } else if (ctx.FOR() != null) {
            trigger.setType(TgTypes.BEFORE);
        } else if (ctx.INSTEAD() != null) {
            trigger.setType(TgTypes.INSTEAD_OF);
        }

        for (Trigger_optionContext option : ctx.trigger_option()) {
            trigger.addOption(option.getText());
        }

        for (Trigger_operationContext oper : ctx.trigger_operation()) {
            if (oper.INSERT() != null) {
                trigger.setOnInsert(true);
            } else if (oper.UPDATE() != null) {
                trigger.setOnUpdate(true);
            } else if (oper.DELETE() != null) {
                trigger.setOnDelete(true);
            }
        }

        trigger.setNotForRep(ctx.not_for_replication() != null);
        trigger.setAppend(ctx.with_append() != null);
        String query = getFullCtxText(ctx.st_clause());
        trigger.setQuery(db.getArguments().isKeepNewlines() ? query : query.replace("\r", ""));

        getSafe(schema::getTriggerContainer, QNameParser.getFirstNameCtx(ctx.table_name().id()))
        .addTrigger(trigger);
        return trigger;
    }
}
