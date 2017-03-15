package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Null_orderingContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Order_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.ParamContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Param_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sort_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_spaceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateIndex extends ParserAbstract {
    private final Create_index_statementContext ctx;

    public CreateIndex(Create_index_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgIndex ind = new PgIndex(name != null ? name : "",
                getFullCtxText(ctx.getParent()));
        ind.setTableName(QNameParser.getFirstName(ctx.table_name.identifier()));
        Index_restContext indexRest = ctx.index_rest();
        StringBuilder sb = new StringBuilder();
        if (indexRest.method != null) {
            sb.append("USING ");
            sb.append(indexRest.method.getText());
            sb.append(" ");
        }
        sb.append("(");
        List<Sort_specifierContext> sorts = indexRest.sort_specifier_list()
                .sort_specifier();
        for (Sort_specifierContext sort : sorts) {
            // getText() delete some whitespace
            sb.append(getFullCtxText(sort.key));
            IdentifierContext op = sort.opclass;
            if (op != null) {
                sb.append(" ");
                sb.append(op.getText());
            }
            Order_specificationContext order = sort.order;
            if (order != null) {
                if (order.ASC() != null) {
                    sb.append(" ASC");
                } else if (order.DESC() != null) {
                    sb.append(" DESC");
                }
            }
            Null_orderingContext nullOrder = sort.null_order;
            if (nullOrder != null) {
                if (nullOrder.FIRST() != null) {
                    sb.append(" NULLS FIRST");
                } else {
                    sb.append(" NULLS LAST");
                }
            }
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(")");

        Param_clauseContext with = indexRest.param_clause();
        if (with != null) {
            sb.append(" WITH (");
            for (ParamContext param : with.param()) {
                sb.append(param.key.getText());
                sb.append("=");
                sb.append(param.value.getText());
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(")");
        }

        Table_spaceContext t = indexRest.table_space();
        if (t != null) {
            ind.setTableSpace(t.name.getText());
        }

        VexContext where = indexRest.vex();
        if (where != null) {
            sb.append(" WHERE ");
            sb.append(getFullCtxText(where));
        }

        ind.setDefinition(sb.toString());
        ind.setUnique(ctx.UNIQUE() != null);
        if (name != null) {
            if (db.getSchema(schemaName) == null) {
                logSkipedObject(schemaName, "INDEX", ind.getTableName());
                return null;
            } else if (db.getSchema(schemaName).getTable(ind.getTableName()) == null) {
                Log.log(Log.LOG_ERROR,
                        new StringBuilder().append("TABLE ").append(ind.getTableName())
                        .append(" not found on schema ").append(schemaName)
                        .append(" That's why index ").append(name)
                        .append("will be skipped").toString());
                return null;
            }
            db.getSchema(schemaName).getTable(ind.getTableName()).addIndex(ind);
        }

        ind.addDep(new GenericColumn(schemaName, ind.getTableName(), DbObjType.TABLE));
        // Костыль, т.к нужно улучшить парсер для vex в планевычитки колонок
        for (Sort_specifierContext sort_ctx : sorts) {
            Value_expression_primaryContext vexPrimary = sort_ctx.key
                    .value_expression_primary();
            if (vexPrimary != null) {
                Schema_qualified_nameContext colName = vexPrimary.schema_qualified_name();
                if (colName != null) {
                    ind.addDep(new GenericColumn(schemaName, ind.getTableName(),
                            colName.getText(), DbObjType.COLUMN));
                }
            }
        }
        return ind;
    }

}
