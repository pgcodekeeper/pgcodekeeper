package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ClusteredContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_sortContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_whereContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsIndex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsIndex extends ParserAbstract {

    private final Create_indexContext ctx;

    public CreateMsIndex(Create_indexContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        IdContext schemaCtx = ctx.table_name().schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        String tableName = ctx.table_name().table.getText();
        String name = ctx.name.getText();
        AbstractIndex ind = new MsIndex(name, getFullCtxText(ctx.getParent()));
        ind.setTableName(tableName);
        ind.setUnique(ctx.UNIQUE() != null);
        ClusteredContext cluster = ctx.clustered();
        ind.setClusterIndex(cluster != null && cluster.CLUSTERED() != null);

        parseIndex(ctx.index_rest(), ind);

        getSafe(schema::getTable, ctx.table_name().table).addIndex(ind);
        return ind;
    }

    private void parseIndex(Index_restContext rest, AbstractIndex ind) {
        Index_sortContext sort = rest.index_sort();
        for (IdContext col : sort.column_name_list_with_order().id()) {
            ind.addColumn(col.getText());
        }

        ind.setDefinition(getFullCtxText(sort));

        Index_whereContext wherePart = rest.index_where();
        if (wherePart != null){
            ind.setWhere(getFullCtxText(wherePart.where));
        }

        Index_optionsContext options = rest.index_options();
        if (options != null) {
            for (Index_optionContext option : options.index_option()) {
                String key = option.key.getText();
                String value = option.index_option_value().getText();
                ind.addOption(key, value);
            }
        }

        IdContext tablespace = rest.id();
        if (tablespace != null) {
            ind.setTableSpace(tablespace.getText());
        }
    }
}
