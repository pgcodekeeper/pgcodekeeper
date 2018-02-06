package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_foreign_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_foreign_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_foreign_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_partitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_serverContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Foreign_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Foreign_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.ForeignPgTable;
import cz.startnet.utils.pgdiff.schema.PartitionForeignPgTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.SimpleForeignPgTable;

public class CreateForeignTable extends AbstractTable {

    private final Create_foreign_table_statementContext ctx;

    public CreateForeignTable(Create_foreign_table_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String tableName = QNameParser.getFirstName(ids);
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        String schemaName = schema.getName();

        PgTable table = defineTable(tableName, schemaName);

        schema.addTable(table);
        return table;
    }

    private PgTable defineTable(String tableName, String schemaName) {
        Define_serverContext srvCtx = ctx.define_server();
        Define_foreign_tableContext colCtx = ctx.define_foreign_table();
        Define_partitionContext partCtx = ctx.define_partition();

        String rawStatement = getFullCtxText(ctx.getParent());
        PgTable table;

        if (colCtx != null) {
            table = fillForeignTable(srvCtx, new SimpleForeignPgTable(
                    tableName, rawStatement, srvCtx.server_name.getText()));
            fillColumns(colCtx, table, schemaName);
        } else {
            String partBound = ParserAbstract.getFullCtxText(partCtx.for_values_bound());
            table = fillForeignTable(srvCtx, new PartitionForeignPgTable(
                    tableName, rawStatement, srvCtx.server_name.getText(), partBound));

            fillTypeColumns(partCtx.list_of_type_column_def(), table, schemaName);
            addInherit(table, partCtx.parent_table.identifier());
        }

        return table;
    }

    private void fillColumns(Define_foreign_tableContext columnsCtx, PgTable table, String schemaName) {
        for (Foreign_column_defContext colCtx : columnsCtx.columns) {
            if (colCtx.tabl_constraint != null) {
                table.addConstraint(getTableConstraint(colCtx.tabl_constraint, schemaName));
            } else if (colCtx.define_foreign_columns() != null) {
                Define_foreign_columnsContext column = colCtx.define_foreign_columns();
                addColumn(column.column_name.getText(),
                        column.datatype, column.collate_name,
                        column.column_constraint, getDefSchemaName(),
                        column.define_foreign_options(), table);
            }
        }

        Column_referencesContext parentTable = columnsCtx.parent_table;
        if (parentTable != null) {
            for (Schema_qualified_nameContext nameInher : parentTable.names_references().name) {
                addInherit(table, nameInher.identifier());
            }
        }
    }

    private ForeignPgTable fillForeignTable(Define_serverContext server, ForeignPgTable table) {
        Define_foreign_optionsContext options = server.define_foreign_options();
        if (options != null){
            for (Foreign_optionContext option : options.foreign_option()){
                String value = option.value == null ? null : option.value.getText();
                fillOptionParams(value, option.name.getText(), false, table::addOption);
            }
        }
        return table;
    }
}
