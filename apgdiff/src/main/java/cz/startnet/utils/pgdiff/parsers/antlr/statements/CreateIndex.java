package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
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
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_storage_parameterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.IndexAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementActions;
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
    public void parseObject() {
        List<IdentifierContext> ids = ctx.table_name.identifier();
        String schemaName = getSchemaNameSafe(ids);
        String tableName = QNameParser.getFirstName(ids);
        addObjReference(ids, DbObjType.TABLE, StatementActions.NONE);

        IdentifierContext nameCtx = ctx.name;
        String name = nameCtx != null ? nameCtx.getText() : "";
        PgIndex ind = new PgIndex(name);
        parseIndex(ctx.index_rest(), tablespace, schemaName, tableName, ind, db);
        ind.setUnique(ctx.UNIQUE() != null);

        if (nameCtx != null) {
            IdentifierContext parent = QNameParser.getFirstNameCtx(ids);
            IStatementContainer table = getSafe(AbstractSchema::getStatementContainer,
                    getSchemaSafe(ids), parent);
            addSafe((PgStatement) table, ind, Arrays.asList(
                    QNameParser.getSchemaNameCtx(ids), parent, nameCtx));
        }
    }

    public static void parseIndex(Index_restContext rest, String tablespace,
            String schemaName, String tableName, PgIndex ind, PgDatabase db) {
        db.addAnalysisLauncher(new IndexAnalysisLauncher(ind, rest));

        Index_sortContext sort = rest.index_sort();
        parseColumns(sort, ind);

        if (rest.method != null) {
            ind.setMethod(rest.method.getText());
        }

        Including_indexContext incl = rest.including_index();
        if (incl != null) {
            fillIncludingDepcy(incl, ind, schemaName, tableName);
            for (IdentifierContext col : incl.identifier()) {
                ind.addInclude(col.getText());
            }
        }

        ind.setDefinition(getFullCtxText(sort));

        With_storage_parameterContext options = rest.with_storage_parameter();

        if (options != null) {
            for (Storage_parameter_optionContext option : options.storage_parameter().storage_parameter_option()) {
                String key = option.storage_param.getText();
                VexContext v = option.value;
                String value = v == null ? "" : v.getText();
                ind.addOption(key, value);
            }
        }

        if (rest.table_space() != null) {
            ind.setTableSpace(getFullCtxText(rest.table_space().name));
        } else if (tablespace != null) {
            ind.setTableSpace(tablespace);
        }

        Index_whereContext wherePart = rest.index_where();
        if (wherePart != null){
            ind.setWhere(getFullCtxText(wherePart.vex()));
        }
    }

    private static void parseColumns(Index_sortContext sort, AbstractIndex ind) {
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
}
