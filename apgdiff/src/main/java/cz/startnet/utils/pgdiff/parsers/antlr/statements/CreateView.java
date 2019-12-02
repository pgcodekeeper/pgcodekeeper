package cz.startnet.utils.pgdiff.parsers.antlr.statements;


import java.text.MessageFormat;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_spaceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.ViewAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgView;

public class CreateView extends ParserAbstract {

    private static final String RECURSIVE_PATTERN = "CREATE VIEW {0} "
            + "\nAS WITH RECURSIVE {0}({1}) AS ("
            + "\n{2}\n)"
            + "\nSELECT {1}"
            + "\nFROM {0};";

    private final Create_view_statementContext context;
    private final String tablespace;

    public CreateView(Create_view_statementContext context, PgDatabase db, String tablespace) {
        super(db);
        this.context = context;
        this.tablespace = tablespace;
    }

    @Override
    public void parseObject() {
        Create_view_statementContext ctx = context;
        List<IdentifierContext> ids = ctx.name.identifier();
        IdentifierContext name = QNameParser.getFirstNameCtx(ids);
        PgView view = new PgView(name.getText());
        if (ctx.MATERIALIZED() != null) {
            view.setIsWithData(ctx.NO() == null);
            Table_spaceContext space = ctx.table_space();
            if (space != null) {
                view.setTablespace(space.identifier().getText());
            } else if (tablespace != null) {
                view.setTablespace(tablespace);
            }
        } else if (ctx.RECURSIVE() != null) {
            String sql = MessageFormat.format(RECURSIVE_PATTERN,
                    ParserAbstract.getFullCtxText(name),
                    ParserAbstract.getFullCtxText(ctx.column_names.identifier()),
                    ParserAbstract.getFullCtxText(ctx.v_query));

            ctx = AntlrParser.parseSqlString(SQLParser.class, SQLParser::sql, sql, "recursive view", null)
                    .statement(0).schema_statement().schema_create().create_view_statement();
        }
        Select_stmtContext vQuery = ctx.v_query;
        if (vQuery != null) {
            addStatementBody(vQuery);
            view.setQuery(getFullCtxText(vQuery));
            db.addAnalysisLauncher(new ViewAnalysisLauncher(view, vQuery));
        }
        if (ctx.column_names != null) {
            for (IdentifierContext column : ctx.column_names.identifier()) {
                view.addColumnName(column.getText());
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
            view.addOption(PgView.CHECK_OPTION,
                    ctx.with_check_option().LOCAL() != null ? "local" : "cascaded");
        }

        addSafe(getSchemaSafe(ids), view, ids);
    }
}
