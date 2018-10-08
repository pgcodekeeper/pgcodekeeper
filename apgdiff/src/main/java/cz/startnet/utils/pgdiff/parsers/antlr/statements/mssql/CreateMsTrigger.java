package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsTrigger extends BatchContextProcessor {

    private final Create_or_alter_triggerContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    public CreateMsTrigger(Batch_statementContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db, ctx, stream);
        this.ctx = ctx.batch_statement_body().create_or_alter_trigger();
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
    }

    @Override
    protected ParserRuleContext getDelimiterCtx() {
        return ctx.table_name();
    }

    @Override
    public MsTrigger getObject() {
        List<IdContext> ids = ctx.simple_name().id();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        return getObject(schema);
    }

    public MsTrigger getObject(AbstractSchema schema) {
        ParserRuleContext batchCtx = ctx.getParent().getParent();
        MsTrigger trigger = new MsTrigger(QNameParser.getFirstName(ctx.simple_name().id()),
                getFullCtxText(batchCtx));
        trigger.setTableName(QNameParser.getFirstName(ctx.table_name().id()));
        trigger.setAnsiNulls(ansiNulls);
        trigger.setQuotedIdentified(quotedIdentifier);
        setSourceParts(trigger);

        getSafe(schema::getTriggerContainer, QNameParser.getFirstNameCtx(ctx.table_name().id()))
        .addTrigger(trigger);
        return trigger;
    }
}
