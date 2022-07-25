package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Including_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_columnContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_whereContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Indirection_varContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_storage_parameterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.IndexAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateIndex extends ParserAbstract {
    private final Create_index_statementContext ctx;
    private final String tablespace;
    private final CommonTokenStream stream;

    public CreateIndex(Create_index_statementContext ctx, PgDatabase db, String tablespace, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.tablespace = tablespace;
        this.stream = stream;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.table_name);
        String schemaName = getSchemaNameSafe(ids);
        String tableName = QNameParser.getFirstName(ids);
        addObjReference(ids, DbObjType.TABLE, null);

        IdentifierContext nameCtx = ctx.name;
        String name = nameCtx != null ? nameCtx.getText() : "";
        PgIndex ind = new PgIndex(name);
        parseIndex(ctx.index_rest(), tablespace, schemaName, tableName, ind, db, fileName, stream);
        ind.setUnique(ctx.UNIQUE() != null);

        if (nameCtx != null) {
            ParserRuleContext parent = QNameParser.getFirstNameCtx(ids);
            PgStatementContainer table = getSafe(AbstractSchema::getStatementContainer,
                    getSchemaSafe(ids), parent);
            addSafe(table, ind, Arrays.asList(QNameParser.getSchemaNameCtx(ids), nameCtx));
        }
    }

    public static void parseIndex(Index_restContext rest, String tablespace,
            String schemaName, String tableName, PgIndex ind, PgDatabase db, String location, CommonTokenStream stream) {
        db.addAnalysisLauncher(new IndexAnalysisLauncher(ind, rest, location));

        Index_columnsContext sort = rest.index_columns();
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
            for (Storage_parameter_optionContext option : options.storage_parameters().storage_parameter_option()) {
                String key = option.storage_parameter_name().getText();
                VexContext v = option.vex();
                String value = v == null ? "" : v.getText();
                fillOptionParams(value, key, false, ind::addOption);
            }
        }

        if (rest.table_space() != null) {
            ind.setTablespace(getFullCtxText(rest.table_space().identifier()));
        } else if (tablespace != null) {
            ind.setTablespace(tablespace);
        }

        Index_whereContext wherePart = rest.index_where();
        if (wherePart != null){
            ind.setWhere(getExpressionText(wherePart.vex(), stream));
        }
    }

    private static void parseColumns(Index_columnsContext sort, AbstractIndex ind) {
        for (Index_columnContext sort_ctx : sort.index_column()) {
            Value_expression_primaryContext vexPrimary = sort_ctx.column.value_expression_primary();
            if (vexPrimary != null) {
                Indirection_varContext colName = vexPrimary.indirection_var();
                if (colName != null) {
                    ind.addColumn(colName.getText());
                }
            }
        }
    }

    @Override
    protected String getStmtAction() {
        StringBuilder sb = new StringBuilder(ACTION_CREATE).append(' ').append(DbObjType.INDEX)
                .append(' ').append(QNameParser.getSchemaName(getIdentifiers(ctx.table_name)));
        if (ctx.name != null) {
            sb.append('.').append(ctx.name.getText());
        }
        return sb.toString();
    }
}
