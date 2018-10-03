package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_viewContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsView extends ParserAbstract {

    private final Create_or_alter_viewContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    private final CommonTokenStream stream;

    public CreateMsView(Create_or_alter_viewContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
        this.stream = stream;
    }

    @Override
    public MsView getObject() {
        List<IdContext> ids = ctx.simple_name().id();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        return getObject(schema);
    }

    public MsView getObject(AbstractSchema schema) {
        IdContext name = QNameParser.getFirstNameCtx(ctx.simple_name().id());
        ParserRuleContext batchCtx = ctx.getParent().getParent();
        MsView view = new MsView(name.getText(), getFullCtxText(batchCtx));
        view.setAnsiNulls(ansiNulls);
        view.setQuotedIdentified(quotedIdentifier);
        boolean isKeepNewLines = db.getArguments().isKeepNewlines();
        String first = ParserAbstract.getHiddenLeftCtxText(batchCtx, stream);
        String second = ParserAbstract.getRightCtxTextWithHidden(batchCtx, stream, true);
        view.setFirstPart(isKeepNewLines ? first : first.replace("\r", ""));
        view.setSecondPart(isKeepNewLines ? second : second.replace("\r", ""));
        schema.addView(view);
        return view;
    }
}
