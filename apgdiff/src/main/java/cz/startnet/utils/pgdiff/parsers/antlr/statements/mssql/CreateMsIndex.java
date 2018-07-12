package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_sortContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_whereContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsIndex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
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
        PgSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        String tableName = ctx.table_name().table.getText();
        String name = ctx.name.getText();
        MsIndex ind = new MsIndex(name, getFullCtxText(ctx.getParent()));
        ind.setTableName(tableName);
        ind.setUnique(ctx.UNIQUE() != null);

        parseIndex(ctx.index_rest(), ind);

        getSafe(schema::getTable, ctx.table_name().table).addIndex(ind);
        return ind;
    }

    private void parseIndex(Index_restContext rest, PgIndex ind) {
        Index_sortContext sort = rest.index_sort();
        for (IdContext col : sort.column_name_list_with_order().id()) {
            ind.addColumn(col.getText());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(getFullCtxText(sort));

        if (rest.index_where() != null){
            Index_whereContext whereCtx = rest.index_where();
            sb.append(' ').append(getFullCtxText(whereCtx));
        }

        ind.setDefinition(sb.toString());
    }
}
