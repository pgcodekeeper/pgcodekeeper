package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ClusteredContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Identity_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsIndex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.SimpleMsTable;

public class CreateMsTable extends TableAbstract {

    private final Create_tableContext ctx;

    private final boolean ansiNulls;

    public CreateMsTable(Create_tableContext ctx, PgDatabase db, boolean ansiNulls) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
    }

    @Override
    public PgStatement getObject() {
        IdContext schemaCtx = ctx.qualified_name().schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        String tableName = ctx.qualified_name().name.getText();

        SimpleMsTable table = new SimpleMsTable(tableName, getFullCtxText(ctx.getParent()));

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

        schema.addTable(table);
        return table;
    }

    private void fillColumn(Column_def_table_constraintContext colCtx, SimpleMsTable table) {
        if (colCtx.table_constraint() != null) {
            table.addConstraint(getMsConstraint(colCtx.table_constraint()));
        } else if (colCtx.table_index() != null) {
            Table_indexContext indCtx = colCtx.table_index();
            MsIndex index = new MsIndex(indCtx.index_name.getText(), "");
            index.setTableName(table.getName());
            ClusteredContext cluster = indCtx.clustered();
            index.setClusterIndex(cluster != null && cluster.CLUSTERED() != null);
            CreateMsIndex.parseIndex(indCtx.index_rest(), index);
            table.addIndex(index);
        } else {
            MsColumn col = new MsColumn(colCtx.id().getText());
            if (colCtx.data_type() != null) {
                col.setType(getFullCtxText(colCtx.data_type()));
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
            col.setDefaultValue(getFullCtxText(option.expression()));
        }
    }

    private void parseOptions(List<Index_optionContext> options, SimpleMsTable table) {
        for (Index_optionContext option : options) {
            String key = option.key.getText();
            String value = option.index_option_value().getText();
            table.addOption(key, value);
        }
    }
}
