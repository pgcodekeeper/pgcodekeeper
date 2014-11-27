package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;

public class CreateView extends ParserAbstract {
    private Create_view_statementContext ctx;
    public CreateView(Create_view_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        PgView view = new PgView(name, getFullCtxText(ctx.getParent()), "");
        if (ctx.v_query!=null) {
            view.setQuery(ctx.v_query.getText());
        }
        for (Schema_qualified_nameContext column : ctx.column_name) {
            view.addColumnName(getName(column));
        }
        fillObjLocation(name, ctx.name.getStart().getStartIndex());
        return view;
    }

}
