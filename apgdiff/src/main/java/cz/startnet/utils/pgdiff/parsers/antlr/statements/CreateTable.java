package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_partitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Partition_byContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_oidContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_storage_parameterContext;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractPgTable;
import cz.startnet.utils.pgdiff.schema.AbstractRegularTable;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractSequence;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PartitionPgTable;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.SimplePgTable;
import cz.startnet.utils.pgdiff.schema.TypedPgTable;

public class CreateTable extends TableAbstract {
    private final Create_table_statementContext ctx;
    private final String tablespace;
    private final String accessMethod;
    private final String oids;

    public CreateTable(Create_table_statementContext ctx, PgDatabase db,
            String tablespace, String accessMethod, String oids) {
        super(db);
        this.ctx = ctx;
        this.tablespace = tablespace;
        this.accessMethod = accessMethod;
        this.oids = oids;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String tableName = QNameParser.getFirstName(ids);
        String schemaName = getSchemaNameSafe(ids);
        AbstractSchema schema = getSchemaSafe(ids);
        AbstractTable table = defineTable(tableName, schemaName);
        addSafe(schema, table, ids);

        for (AbstractColumn col : table.getColumns()) {
            AbstractSequence seq = ((PgColumn) col).getSequence();
            if (seq != null) {
                seq.setParent(schema);
            }
        }
    }

    private AbstractTable defineTable(String tableName, String schemaName) {
        Define_tableContext tabCtx = ctx.define_table();
        Define_columnsContext colCtx = tabCtx.define_columns();
        Define_typeContext typeCtx = tabCtx.define_type();
        Define_partitionContext partCtx = tabCtx.define_partition();

        AbstractPgTable table;

        if (typeCtx != null) {
            table = defineType(typeCtx, tableName, schemaName);
        } else if (colCtx != null) {
            table = fillRegularTable(new SimplePgTable(tableName));
            fillColumns(colCtx, table, schemaName, tablespace);
        } else {
            String partBound = ParserAbstract.getFullCtxText(partCtx.for_values_bound());
            table = fillRegularTable(new PartitionPgTable(tableName, partBound));
            fillTypeColumns(partCtx.list_of_type_column_def(), table, schemaName, tablespace);
            addInherit(table, partCtx.parent_table.identifier());
        }

        return table;
    }

    private TypedPgTable defineType(Define_typeContext typeCtx, String tableName,
            String schemaName) {
        Data_typeContext typeName = typeCtx.type_name;
        String ofType = getTypeName(typeName);
        TypedPgTable table = new TypedPgTable(tableName, ofType);
        fillTypeColumns(typeCtx.list_of_type_column_def(), table, schemaName, tablespace);
        addPgTypeDepcy(typeName, table);
        fillRegularTable(table);
        return table;
    }

    private AbstractRegularTable fillRegularTable(AbstractRegularTable table) {
        if (ctx.table_space() != null) {
            table.setTablespace(ctx.table_space().identifier().getText());
        } else if (tablespace != null) {
            table.setTablespace(tablespace);
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

            // table access method for partitioned tables is not supported
        } else if (ctx.USING() != null) {
            table.setMethod(ctx.identifier().getText());
        } else if (accessMethod != null) {
            table.setMethod(accessMethod);
        }

        return table;
    }

    private void parseOptions(List<Storage_parameter_optionContext> options, AbstractRegularTable table){
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
