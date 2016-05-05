package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSelect;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;

public class CreateView extends ParserAbstract {

    private final Create_view_statementContext ctx;

    public CreateView(Create_view_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        PgView view = new PgView(name, getFullCtxText(ctx.getParent()));
        if (ctx.v_query != null) {
            view.setQuery(getFullCtxText(ctx.v_query));

            Select selectAnalyzer = new Select(schemaName);
            selectAnalyzer.select(new SelectStmt(ctx.v_query));

            PgSelect select = new PgSelect(getFullCtxText(ctx.v_query));
            for (GenericColumn col : selectAnalyzer.getDepcies()) {
                select.addColumn(col);
            }
            view.setSelect(select);
        }
        if (ctx.column_name != null) {
            for (Schema_qualified_nameContext column : ctx.column_name.names_references().name) {
                view.addColumnName(ParserAbstract.getFullCtxText(column));
            }
        }
        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "VIEW", name);
            return null;
        }
        db.getSchema(schemaName).addView(view);
        return view;
    }
}
