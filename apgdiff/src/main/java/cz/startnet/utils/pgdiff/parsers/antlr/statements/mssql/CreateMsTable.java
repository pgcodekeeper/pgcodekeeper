package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ClusteredContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Identity_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsIndex;
import cz.startnet.utils.pgdiff.schema.MsTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsTable extends TableAbstract {

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

        List<IdContext> ids = Arrays.asList(ctx.qualified_name().schema, nameCtx);
        addSafe(getSchemaSafe(ids), table, ids);
    }

    private void fillColumn(Column_def_table_constraintContext colCtx, MsTable table) {
        if (colCtx.table_constraint() != null) {
            table.addConstraint(getMsConstraint(colCtx.table_constraint()));
        } else if (colCtx.table_index() != null) {
            Table_indexContext indCtx = colCtx.table_index();
            MsIndex index = new MsIndex(indCtx.index_name.getText());
            ClusteredContext cluster = indCtx.clustered();
            index.setClusterIndex(cluster != null && cluster.CLUSTERED() != null);
            CreateMsIndex.parseIndex(indCtx.index_rest(), index);
            addSafe(table, index, Arrays.asList(ctx.qualified_name().schema,
                    ctx.qualified_name().name, indCtx.index_name));
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
            MsValueExpr vex = new MsValueExpr(getSchemaNameSafe(
                    Arrays.asList(ctx.qualified_name().schema, ctx.qualified_name().name)));
            vex.analyze(exp);
            col.addAllDeps(vex.getDepcies());
        }
    }

    private void parseOptions(List<Index_optionContext> options, MsTable table) {
        for (Index_optionContext option : options) {
            String key = option.key.getText();
            String value = option.index_option_value().getText();
            table.addOption(key, value);
        }
    }
}
