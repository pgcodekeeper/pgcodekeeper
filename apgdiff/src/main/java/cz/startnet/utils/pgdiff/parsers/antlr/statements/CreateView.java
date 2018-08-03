package cz.startnet.utils.pgdiff.parsers.antlr.statements;


import java.text.MessageFormat;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_spaceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ViewSelect;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;

public class CreateView extends ParserAbstract {

    private static final String RECURSIVE_PATTERN = "CREATE VIEW {0} "
            + "\nAS WITH RECURSIVE {0}({1}) AS ("
            + "\n{2}\n)"
            + "\nSELECT {1}"
            + "\nFROM {0};";

    private final Create_view_statementContext context;

    public CreateView(Create_view_statementContext context, PgDatabase db) {
        super(db);
        this.context = context;
    }

    @Override
    public PgStatement getObject() {
        Create_view_statementContext ctx = context;
        List<IdentifierContext> ids = ctx.name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        IdentifierContext name = QNameParser.getFirstNameCtx(ids);
        AbstractView view = new PgView(name.getText(), getFullCtxText(ctx.getParent()));
        if (ctx.MATERIALIZED() != null) {
            view.setIsWithData(ctx.NO() == null);
            Table_spaceContext tablespace = ctx.table_space();
            if (tablespace != null) {
                view.setTablespace(tablespace.name.getText());
            }
        } else if (ctx.RECURSIVE() != null) {
            String sql = MessageFormat.format(RECURSIVE_PATTERN,
                    ParserAbstract.getFullCtxText(name),
                    ParserAbstract.getFullCtxText(ctx.column_name.names_references()),
                    ParserAbstract.getFullCtxText(ctx.v_query));

            ctx = AntlrParser.makeBasicParser(SQLParser.class, sql, "recursive view").sql()
                    .statement(0).schema_statement().schema_create().create_view_statement();
        }
        Select_stmtContext vQuery = ctx.v_query;
        if (vQuery != null) {
            view.setQuery(getFullCtxText(vQuery));
            db.addContextForAnalyze(view, vQuery);
            ViewSelect select = new ViewSelect(schema.getName());
            select.analyze(new SelectStmt(vQuery));
            view.addAllDeps(select.getDepcies());
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
                ParserAbstract.fillOptionParams(value != null ? value.getText() : "", key , false, view::addOption);
            }
        }
        if (ctx.with_check_option() != null){
            view.addOption(AbstractView.CHECK_OPTION,
                    ctx.with_check_option().LOCAL() != null ? "local" : "cascaded");
        }

        schema.addView(view);
        return view;
    }

    public static void analyzeViewCtx(ParserRuleContext ctx, AbstractView view,
            String schemaName, PgDatabase db) {
        if (ctx instanceof Select_stmtContext) {
            Select select = new Select(schemaName, db);
            view.addRelationColumns(select.analyze(ctx));
            view.addAllDeps(select.getDepcies());
        } else {
            UtilAnalyzeExpr.analyze((VexContext) ctx, new ValueExpr(schemaName, db), view);
        }
    }
}
