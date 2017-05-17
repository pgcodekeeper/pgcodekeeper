package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_spaceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
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
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        PgView view = new PgView(QNameParser.getFirstName(ids), getFullCtxText(ctx.getParent()));
        if (ctx.MATERIALIZED() != null) {
            view.setIsWithData(ctx.NO() == null);
            Table_spaceContext tablespace = ctx.table_space();
            if (tablespace != null) {
                view.setTablespace(tablespace.name.getText());
            }
        }
        if (ctx.v_query != null) {
            view.setQuery(getFullCtxText(ctx.v_query));
            UtilExpr.analyze(new SelectStmt(ctx.v_query), new Select(schema.getName()), view);
        }
        if (ctx.column_name != null) {
            for (Schema_qualified_nameContext column : ctx.column_name.names_references().name) {
                view.addColumnName(ParserAbstract.getFullCtxText(column));
            }
        }
        Storage_parameterContext storage = ctx.storage_parameter();
        if (storage != null){
            List <Storage_parameter_optionContext> options = storage.storage_parameter_option();
            for (Storage_parameter_optionContext option: options){
                String key = option.schema_qualified_name().getText();
                VexContext value = option.vex();
                ParserAbstract.fillStorageParams(value != null ? value.getText() : "", key , false, view);
            }
        }
        if (ctx.with_check_option() != null){
            if (ctx.with_check_option().LOCAL() != null){
                view.addOption(CHECK_OPTION, "local");
            } else {
                view.addOption(CHECK_OPTION, "cascaded");
            }
        }
        schema.addView(view);
        return view;
    }
}
