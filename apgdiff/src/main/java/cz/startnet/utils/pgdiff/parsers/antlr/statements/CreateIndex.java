package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sort_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateIndex extends ParserAbstract {
    private final Create_index_statementContext ctx;
    public CreateIndex(Create_index_statementContext ctx, PgDatabase db,
            List<AntlrError> errors) {
        super(db, errors);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgIndex ind = new PgIndex(name != null ? name : "", getFullCtxText(ctx.getParent()));
        ind.setTableName(QNameParser.getFirstName(ctx.table_name.identifier()));
        ind.setDefinition(getFullCtxText(ctx.index_rest()));
        ind.setUnique(ctx.UNIQUE() != null);
        if (name != null) {
            if (db.getSchema(schemaName) == null) {
                logSkipedObject(schemaName, "INDEX", ind.getTableName(), ctx.getStart());
                return null;
            } else if(db.getSchema(schemaName).getTable(ind.getTableName()) == null) {
                Log.log(Log.LOG_ERROR,
                        new StringBuilder().append("TABLE ")
                        .append(ind.getTableName())
                        .append(" not found on schema ").append(schemaName)
                        .append(" That's why index ").append(name)
                        .append("will be skipped").toString());
                return null;
            }
            db.getSchema(schemaName).getTable(ind.getTableName()).addIndex(ind);
        }

        ind.addDep(new GenericColumn(schemaName, ind.getTableName(), DbObjType.TABLE));
        // Костыль, т.к нужно улучшить парсер для vex в планевычитки колонок
        for (Sort_specifierContext sort_ctx : ctx.index_rest().sort_specifier_list().sort_specifier()){
            Value_expression_primaryContext vexPrimary = sort_ctx.key.value_expression_primary();
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
