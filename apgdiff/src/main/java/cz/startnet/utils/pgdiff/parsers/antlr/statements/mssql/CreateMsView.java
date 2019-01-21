package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_viewContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSelect;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.MsSelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.SourceStatement;

public class CreateMsView extends BatchContextProcessor {

    private boolean isSchemaDef;
    private final Create_or_alter_viewContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    public CreateMsView(Batch_statementContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db, ctx, stream);
        this.ctx = ctx.batch_statement_body().create_or_alter_view();
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
    }

    public CreateMsView(Create_or_alter_viewContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db, null, stream);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
        isSchemaDef = true;
    }

    @Override
    protected ParserRuleContext getDelimiterCtx() {
        return ctx.qualified_name();
    }

    @Override
    public MsView getObject() {
        IdContext schemaCtx = ctx.qualified_name().schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        return getObject(schema);
    }

    public MsView getObject(AbstractSchema schema) {
        String name = ctx.qualified_name().name.getText();
        MsView view = new MsView(name);
        view.setAnsiNulls(ansiNulls);
        view.setQuotedIdentified(quotedIdentifier);
        setSourceParts(view);
        schema.addView(view);

        Select_statementContext vQuery = ctx.select_statement();
        if (vQuery != null) {
            MsSelect select = new MsSelect(schema.getName());
            select.analyze(new MsSelectStmt(vQuery));
            view.addAllDeps(select.getDepcies());
        }

        return view;
    }

    @Override
    protected void setSourceParts(SourceStatement st) {
        if (!isSchemaDef) {
            super.setSourceParts(st);
            return;
        }

        ParserRuleContext viewCtxWithCreate = ctx.getParent();
        boolean isKeepNewLines = db.getArguments().isKeepNewlines();
        String first = ParserAbstract.getHiddenLeftCtxText(viewCtxWithCreate, stream);
        st.setFirstPart(isKeepNewLines ? first : first.replace("\r", ""));

        List<Token> endTokens = stream.getHiddenTokensToRight(viewCtxWithCreate.getStop().getTokenIndex());
        Token stopToken = endTokens != null ? endTokens.get(endTokens.size() - 1) : viewCtxWithCreate.getStop();
        int stop = stopToken.getStopIndex();
        int start = getDelimiterCtx().getStop().getStopIndex() + 1;
        String second = stopToken.getInputStream().getText(Interval.of(start, stop));
        st.setSecondPart(isKeepNewLines ? second : second.replace("\r", ""));
    }
}
