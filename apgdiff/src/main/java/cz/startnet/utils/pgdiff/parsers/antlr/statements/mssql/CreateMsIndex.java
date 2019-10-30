package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ClusteredContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_with_orderContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_includeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_sortContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_whereContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.MsIndex;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateMsIndex extends ParserAbstract {

    private final Create_indexContext ctx;

    public CreateMsIndex(Create_indexContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext schemaCtx = ctx.qualified_name().schema;
        IdContext tableCtx = ctx.qualified_name().name;
        IdContext nameCtx = ctx.name;
        List<IdContext> ids = Arrays.asList(schemaCtx, nameCtx);
        AbstractSchema schema = getSchemaSafe(ids);
        addObjReference(Arrays.asList(schemaCtx, tableCtx),
                DbObjType.TABLE, StatementActions.NONE);

        AbstractIndex ind = new MsIndex(nameCtx.getText());
        ind.setUnique(ctx.UNIQUE() != null);
        ClusteredContext cluster = ctx.clustered();
        ind.setClusterIndex(cluster != null && cluster.CLUSTERED() != null);

        parseIndex(ctx.index_rest(), ind);

        IStatementContainer table = getSafe(AbstractSchema::getStatementContainer, schema, tableCtx);
        addSafe((PgStatement) table, ind,
                Arrays.asList(schemaCtx, tableCtx, nameCtx));
    }

    static void parseIndex(Index_restContext rest, AbstractIndex ind) {
        Index_sortContext sort = rest.index_sort();
        for (Column_with_orderContext col : sort.column_name_list_with_order()
                .column_with_order()) {
            ind.addColumn(col.id().getText());
        }

        ind.setDefinition(getFullCtxText(sort));

        Index_includeContext include = rest.index_include();
        if (include != null) {
            for (IdContext col : include.column_name_list().id()) {
                ind.addInclude(col.getText());
            }
        }

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
            ind.setTablespace(tablespace.getText());
        }
    }
}
