package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_viewContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSelect;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.MsSelectStmt;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsView extends BatchContextProcessor {

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

    @Override
    protected ParserRuleContext getDelimiterCtx() {
        return ctx.simple_name();
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
}
