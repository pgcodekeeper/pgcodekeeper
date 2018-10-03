package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsTrigger extends ParserAbstract {

    private final Create_or_alter_triggerContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    private final CommonTokenStream stream;

    public CreateMsTrigger(Create_or_alter_triggerContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
        this.stream = stream;
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

        boolean isKeepNewLines = db.getArguments().isKeepNewlines();
        String first = ParserAbstract.getHiddenLeftCtxText(batchCtx, stream);
        String second = ParserAbstract.getRightCtxTextWithHidden(batchCtx, stream, true);
        trigger.setFirstPart(isKeepNewLines ? first : first.replace("\r", ""));
        trigger.setSecondPart(isKeepNewLines ? second : second.replace("\r", ""));

        getSafe(schema::getTriggerContainer, QNameParser.getFirstNameCtx(ctx.table_name().id()))
        .addTrigger(trigger);
        return trigger;
    }
}
