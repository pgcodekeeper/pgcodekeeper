package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilExpr;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;

public class CreateView extends ParserAbstract {

    private static final String CHECK_OPTION = "check_option";
    private final Create_view_statementContext ctx;

    public CreateView(Create_view_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgView view = new PgView(name, getFullCtxText(ctx.getParent()));
        if (ctx.v_query != null) {
            view.setQuery(getFullCtxText(ctx.v_query));
            UtilExpr.analyze(ctx.v_query, new Select(schemaName), view);
        }
        if (ctx.column_name != null) {
            for (Schema_qualified_nameContext column : ctx.column_name.names_references().name) {
                view.addColumnName(ParserAbstract.getFullCtxText(column));
            }
        }

        if (ctx.create_view_option() != null){
            List <Create_view_optionContext> options = ctx.create_view_option();
            for (Create_view_optionContext option: options){
                List <IdentifierContext> value = option.view_option_value;
                String key = QNameParser.getFirstName(option.view_option_name);
                if (!value.isEmpty()) {
                    ParserAbstract.fillStorageParams(QNameParser.getFirstName(value), key , false, view);
                } else {
                    ParserAbstract.fillStorageParams("", key, false, view);
                }
            }
        }
        if (ctx.with_check_option() != null){
            if (ctx.with_check_option().LOCAL() != null){
                view.addOption(CHECK_OPTION, "local");
            } else {
                view.addOption(CHECK_OPTION, "cascaded");
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
