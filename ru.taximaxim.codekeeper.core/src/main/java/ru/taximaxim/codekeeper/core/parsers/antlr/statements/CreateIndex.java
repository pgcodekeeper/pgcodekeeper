package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_index_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Including_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Index_columnContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Index_columnsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Index_restContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Index_whereContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Indirection_varContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Nulls_distinctionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Value_expression_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.With_storage_parameterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.IndexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgIndex;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;

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

        Nulls_distinctionContext dist = rest.nulls_distinction();
        ind.setNullsDistinction(dist == null || dist.NOT() == null);

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
