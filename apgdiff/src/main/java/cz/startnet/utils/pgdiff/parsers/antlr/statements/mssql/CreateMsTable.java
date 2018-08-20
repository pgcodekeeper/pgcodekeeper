package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractRegularTable;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.SimpleMsTable;

public class CreateMsTable extends TableAbstract {

    private final Create_tableContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    public CreateMsTable(Create_tableContext ctx, PgDatabase db, boolean ansiNulls, boolean quotedIdentifier) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
    }

    @Override
    public PgStatement getObject() {
        IdContext schemaCtx = ctx.table_name().schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        String tableName = ctx.table_name().table.getText();

        SimpleMsTable table = new SimpleMsTable(tableName, getFullCtxText(ctx.getParent()));

        table.setAnsiNulls(ansiNulls);
        table.setQuotedIdentified(quotedIdentifier);

        if (ctx.tablespace != null) {
            table.setTablespace(ctx.tablespace.getText());
            table.setPartitionColName(ctx.partition_col_name.getText());
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

    private void parseOptions(List<Index_optionContext> options, AbstractRegularTable table){
        for (Index_optionContext option : options){
            String key = option.key.getText();
            String value = option.index_option_value().getText();
            table.addOption(key, value);
        }
    }
}
