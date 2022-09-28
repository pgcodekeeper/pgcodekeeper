package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.ClusteredContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Column_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Create_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Identity_valueContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Index_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Table_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Table_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsExpressionAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.MsColumn;
import ru.taximaxim.codekeeper.core.schema.MsIndex;
import ru.taximaxim.codekeeper.core.schema.MsTable;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class CreateMsTable extends MsTableAbstract {

    private final Create_tableContext ctx;

    private final boolean ansiNulls;

    public CreateMsTable(Create_tableContext ctx, PgDatabase db, boolean ansiNulls) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.qualified_name().name;
        String tableName = nameCtx.getText();

        MsTable table = new MsTable(tableName);

        table.setAnsiNulls(ansiNulls);

        if (ctx.tablespace != null) {
            String tableSpace = MsDiffUtils.quoteName(ctx.tablespace.getText());
            if (ctx.partition_col_name != null) {
                tableSpace = tableSpace + '(' +
                        MsDiffUtils.quoteName(ctx.partition_col_name.getText()) + ')';
            }
            table.setTablespace(tableSpace);
        }

        if (ctx.textimage != null) {
            table.setTextImage(ctx.textimage.getText());
        }

        if (ctx.filestream != null) {
            table.setFileStream(ctx.filestream.getText());
        }

        for (Table_optionsContext options : ctx.table_options()) {
            parseOptions(options.index_option(), table);
        }

        for (Column_def_table_constraintContext colCtx : ctx.column_def_table_constraints().column_def_table_constraint()) {
            fillColumn(colCtx, table);
        }

        List<ParserRuleContext> ids = Arrays.asList(ctx.qualified_name().schema, nameCtx);
        addSafe(getSchemaSafe(ids), table, ids);
    }

    private void fillColumn(Column_def_table_constraintContext colCtx, MsTable table) {
        IdContext schemaCtx = ctx.qualified_name().schema;
        IdContext tableCtx = ctx.qualified_name().name;

        if (colCtx.table_constraint() != null) {
            table.addConstraint(getMsConstraint(colCtx.table_constraint(), schemaCtx.getText(), tableCtx.getText()));
        } else if (colCtx.table_index() != null) {
            Table_indexContext indCtx = colCtx.table_index();
            MsIndex index = new MsIndex(indCtx.index_name.getText());
            ClusteredContext cluster = indCtx.clustered();
            index.setClusterIndex(cluster != null && cluster.CLUSTERED() != null);

            parseIndex(indCtx.index_rest(), index, schemaCtx.getText(), tableCtx.getText());
            addSafe(table, index, Arrays.asList(schemaCtx, tableCtx, indCtx.index_name));
        } else {
            MsColumn col = new MsColumn(colCtx.id().getText());
            if (colCtx.data_type() != null) {
                Data_typeContext dt = colCtx.data_type();
                addMsTypeDepcy(dt, col);
                col.setType(getFullCtxText(dt));
            } else {
                col.setExpression(getFullCtxText(colCtx.expression()));
            }

            for (Column_optionContext option : colCtx.column_option()) {
                fillColumnOption(option, col);
            }

            table.addColumn(col);
        }
    }

    private void fillColumnOption(Column_optionContext option, MsColumn col) {
        if (option.SPARSE() != null) {
            col.setSparse(true);
        } else if (option.COLLATE() != null) {
            col.setCollation(getFullCtxText(option.collate));
        } else if (option.PERSISTED() != null) {
            col.setPersisted(true);
        } else if (option.ROWGUIDCOL() != null) {
            col.setRowGuidCol(true);
        } else if (option.IDENTITY() != null) {
            Identity_valueContext identity = option.identity_value();
            if (identity == null) {
                col.setIdentity("1", "1");
            } else {
                col.setIdentity(identity.seed.getText(), identity.increment.getText());
            }

            if (option.not_for_rep != null) {
                col.setNotForRep(true);
            }
        } else if (option.NULL() != null) {
            col.setNullValue(option.NOT() == null);
        } else if (option.DEFAULT() != null) {
            if (option.id() != null) {
                col.setDefaultName(option.id().getText());
            }
            ExpressionContext exp = option.expression();
            col.setDefaultValue(getFullCtxText(exp));
            db.addAnalysisLauncher(new MsExpressionAnalysisLauncher(col, exp, fileName));
        }
    }

    private void parseOptions(List<Index_optionContext> options, MsTable table) {
        for (Index_optionContext option : options) {
            String key = option.key.getText();
            String value = option.index_option_value().getText();
            table.addOption(key, value);
        }
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TABLE, ctx.qualified_name());
    }
}
