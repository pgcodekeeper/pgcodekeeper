package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Including_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_sortContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_whereContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sort_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateIndex extends ParserAbstract {
    private final Create_index_statementContext ctx;
    private final String tablespace;

    public CreateIndex(Create_index_statementContext ctx, PgDatabase db, String tablespace) {
        super(db);
        this.ctx = ctx;
        this.tablespace = tablespace;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.table_name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        String schemaName = schema.getName();
        String tableName = QNameParser.getFirstName(ids);
        String name = ctx.name.getText();
        AbstractIndex ind = new PgIndex(name != null ? name : "", getFullCtxText(ctx.getParent()));
        ind.setTableName(tableName);
        parseIndex(ctx.index_rest(), tablespace, schemaName, tableName, ind, db);
        ind.setUnique(ctx.UNIQUE() != null);
        if (name != null) {
            getSafe(schema::getTable, QNameParser.getFirstNameCtx(ids))
            .addIndex(ind);
        }

        ind.addDep(new GenericColumn(schemaName, tableName, DbObjType.TABLE));

        return ind;
    }

    public static void parseIndex(Index_restContext rest, String tablespace,
            String schemaName, String tableName, AbstractIndex ind, PgDatabase db) {
        db.addContextForAnalyze(ind, rest);

        Index_sortContext sort = rest.index_sort();
        parseColumns(sort, ind, db);

        Including_indexContext incl = sort.including_index();
        if (incl != null) {
            fillIncludingDepcy(incl, ind, schemaName, tableName);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(getFullCtxText(sort));
        if (rest.table_space() != null){
            sb.append(' ').append(getFullCtxText(rest.table_space()));
        } else if (tablespace != null) {
            sb.append(" TABLESPACE ").append(tablespace);
        }
        if (rest.index_where() != null){
            Index_whereContext whereCtx = rest.index_where();
            sb.append(' ').append(getFullCtxText(whereCtx));
        }
        ind.setDefinition(sb.toString());
    }

    private static void parseColumns(Index_sortContext sort, AbstractIndex ind, PgDatabase db) {
        for (Sort_specifierContext sort_ctx : sort.sort_specifier_list().sort_specifier()) {
            Value_expression_primaryContext vexPrimary = sort_ctx.key.value_expression_primary();
            if (vexPrimary != null) {
                Schema_qualified_nameContext colName = vexPrimary.schema_qualified_name();
                if (colName != null) {
                    ind.addColumn(colName.getText());
                }
            }
        }
    }

    public static void analyzeIndexRest(Index_restContext rest, PgStatement indexStmt,
            String schemaName, PgDatabase db) {
        String rawTableReference = indexStmt.getParent().getName();

        for (Sort_specifierContext sort_ctx : rest.index_sort().sort_specifier_list()
                .sort_specifier()) {
            UtilAnalyzeExpr.analyzeWithNmspc(sort_ctx.key, indexStmt, schemaName,
                    rawTableReference, db);
        }

        if (rest.index_where() != null){
            UtilAnalyzeExpr.analyzeWithNmspc(rest.index_where().vex(), indexStmt,
                    schemaName, rawTableReference, db);
        }
    }
}
