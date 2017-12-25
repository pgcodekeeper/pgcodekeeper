package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_partitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_serverContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Foreign_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.List_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Partition_byContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_oidContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_of_type_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_storage_parameterContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PartitionForeignTable;
import cz.startnet.utils.pgdiff.schema.PartitionPgTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.RegularPgTable;
import cz.startnet.utils.pgdiff.schema.SimpleForeignPgTable;
import cz.startnet.utils.pgdiff.schema.SimplePgTable;
import cz.startnet.utils.pgdiff.schema.TypedPgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateTable extends ParserAbstract {
    private final Create_table_statementContext ctx;
    private final String tablespace;
    private final String oids;

    public CreateTable(Create_table_statementContext ctx, PgDatabase db, String tablespace, String oids) {
        super(db);
        this.ctx = ctx;
        this.tablespace = tablespace;
        this.oids = oids;
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
        Define_tableContext tabCtx = ctx.define_table();
        Define_columnsContext colCtx = tabCtx.define_columns();
        Define_typeContext typeCtx = tabCtx.define_type();
        Define_partitionContext partCtx = tabCtx.define_partition();

        String rawStatement = getFullCtxText(ctx.getParent());
        PgTable table;

        if (typeCtx != null) {
            table = defineType(typeCtx, tableName, rawStatement, schemaName);
        } else if (colCtx != null) {
            if (colCtx.define_server() != null) {
                table = defineServer(colCtx.define_server(), tableName, rawStatement, null, schemaName);
            } else {
                table = new SimplePgTable(tableName, rawStatement);
                fillRegularTable((RegularPgTable)table);
            }
            defineColumns(colCtx, table, schemaName);
        } else {
            if (partCtx.define_server() != null) {
                table = defineServer(partCtx.define_server(), tableName, rawStatement, partCtx, schemaName);
            } else {
                table = new PartitionPgTable(tableName, rawStatement,
                        ParserAbstract.getFullCtxText(partCtx.for_values_bound()));
                defineTypeColumns(partCtx.list_of_type_column_def(), table, schemaName);
                addInherit(table, partCtx.parent_table.identifier());
                fillRegularTable((RegularPgTable)table);
            }
        }

        return table;
    }

    private void defineColumns(Define_columnsContext columnsCtx, PgTable table, String schemaName) {
        for (Table_column_defContext colCtx : columnsCtx.table_col_def) {
            if (colCtx.tabl_constraint != null) {
                table.addConstraint(getTableConstraint(colCtx.tabl_constraint, schemaName));
            } else if (colCtx.table_column_definition() != null) {
                Table_column_definitionContext column = colCtx.table_column_definition();
                getColumn(column.column_name.getText(),
                        column.datatype, column.collate_name,
                        column.colmn_constraint, getDefSchemaName(), table);
            }
        }

        Column_referencesContext parentTable = columnsCtx.parent_table;
        if (parentTable != null) {
            for (Schema_qualified_nameContext nameInher : parentTable.names_references().name) {
                addInherit(table, nameInher.identifier());
            }
        }
    }

    private void defineTypeColumns(List_of_type_column_defContext columns,
            PgTable table, String schemaName) {
        if (columns != null) {
            for (Table_of_type_column_defContext colCtx : columns.table_col_def) {
                if (colCtx.tabl_constraint != null) {
                    table.addConstraint(getTableConstraint(colCtx.tabl_constraint, schemaName));
                }
                if (colCtx.table_of_type_column_definition() != null) {
                    Table_of_type_column_definitionContext column = colCtx.table_of_type_column_definition();
                    getColumn(column.column_name.getText(),
                            null, null, column.colmn_constraint,
                            getDefSchemaName(), table);
                }
            }
        }
    }

    private PgTable defineServer(Define_serverContext server, String tableName,
            String rawStatement, Define_partitionContext part, String schemaName) {
        PgTable table = null;
        String serverName = server.server_name.getText();
        if (part != null) {
            table = new PartitionForeignTable(tableName, rawStatement, serverName,
                    ParserAbstract.getFullCtxText(part.for_values_bound()));
            defineTypeColumns(part.list_of_type_column_def(), table, schemaName);
            addInherit(table, part.parent_table.identifier());
        } else {
            table = new SimpleForeignPgTable(tableName, rawStatement, serverName);
        }
        Define_foreign_optionsContext options = server.define_foreign_options();
        if (options != null){
            for (Foreign_optionContext option : options.foreign_option()){
                String value = option.value == null ? null : option.value.getText();
                fillOptionParams(value, option.name.getText(), false, table::addOption);
            }
        }
        return table;
    }

    private PgTable defineType(Define_typeContext typeCtx, String tableName,
            String rawStatement, String schemaName) {
        Data_typeContext typeName = typeCtx.type_name;
        String ofType = getFullCtxText(typeName);
        TypedPgTable table = new TypedPgTable(tableName, rawStatement, ofType);
        defineTypeColumns(typeCtx.list_of_type_column_def(), table, schemaName);
        addTypeAsDepcy(typeName, table, getDefSchemaName());
        fillRegularTable(table);
        return table;
    }

    private void fillRegularTable(RegularPgTable table) {
        if (tablespace != null) {
            table.setTablespace(tablespace);
        }
        if (ctx.table_space() != null) {
            table.setTablespace(QNameParser.getFirstName(ctx.table_space().name.identifier()));
        }

        boolean explicitOids = false;
        Storage_parameter_oidContext storage = ctx.storage_parameter_oid();
        if (storage != null) {
            With_storage_parameterContext parameters = storage.with_storage_parameter();
            if (parameters != null) {
                parseOptions(parameters.storage_parameter().storage_parameter_option(), table);
            }
            if (storage.WITHOUT() != null) {
                table.setHasOids(false);
                explicitOids = true;
            } else if (storage.WITH() != null) {
                table.setHasOids(true);
                explicitOids = true;
            }
        }

        if (!explicitOids && oids != null) {
            table.setHasOids(true);
        }

        if (ctx.UNLOGGED() != null) {
            table.setLogged(false);
        }

        Partition_byContext part = ctx.partition_by();
        if (part != null) {
            table.setPartitionBy(ParserAbstract.getFullCtxText(part.partition_method()));
        }

    }

    private void addInherit (PgTable table,  List<IdentifierContext> idsInh) {
        String inhSchemaName = QNameParser.getSchemaName(idsInh, null);
        String inhTableName = QNameParser.getFirstName(idsInh);
        table.addInherits(inhSchemaName, inhTableName);
        GenericColumn gc = new GenericColumn(
                inhSchemaName == null ? getDefSchemaName() : inhSchemaName,
                        inhTableName, DbObjType.TABLE);
        table.addDep(gc);
    }

    private void parseOptions(List<Storage_parameter_optionContext> options, RegularPgTable table){
        for (Storage_parameter_optionContext option : options){
            Schema_qualified_nameContext key = option.schema_qualified_name();
            List <IdentifierContext> optionIds = key.identifier();
            VexContext valueCtx = option.vex();
            String value = valueCtx == null ? "" : valueCtx.getText();
            String optionText = key.getText();
            if ("OIDS".equalsIgnoreCase(optionText)) {
                if ("TRUE".equalsIgnoreCase(value) || "'TRUE'".equalsIgnoreCase(value)) {
                    table.setHasOids(true);
                }
            } else if("toast".equals(QNameParser.getSecondName(optionIds))) {
                fillOptionParams(value, QNameParser.getFirstName(optionIds), true, table::addOption);
            } else {
                fillOptionParams(value, optionText, false, table::addOption);
            }
        }
    }
}
