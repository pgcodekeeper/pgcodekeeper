package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.List_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_oidContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_storage_parameterContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
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
        PgTable table = new PgTable(QNameParser.getFirstName(ids), getFullCtxText(ctx.getParent()));
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        Define_columnsContext defineColumnContext = ctx.define_table().define_columns();
        Define_typeContext defineTypeContext = ctx.define_table().define_type();

        if(defineTypeContext != null){
            Data_typeContext dataTypeCtxOfType = defineTypeContext.type_name;
            String ofType = getFullCtxText(dataTypeCtxOfType);
            table.setOfType(ofType);
            List_of_type_column_defContext lstTypeColDefCtx = defineTypeContext.list_of_type_column_def();
            if(lstTypeColDefCtx != null){
                for (Table_of_type_column_defContext typeColCtx : lstTypeColDefCtx.table_col_def) {
                    if (typeColCtx.tabl_constraint != null) {
                        table.addConstraint(getTableConstraint(typeColCtx.tabl_constraint, schema.getName()));
                    }
                    if (typeColCtx.table_of_type_column_definition() != null) {
                        table.addColumnOfType(getColumnOfType(typeColCtx.table_of_type_column_definition(), getDefSchemaName()));
                    }
                }
            }

            addTypeAsDepcy(dataTypeCtxOfType, table, getDefSchemaName());
        } else {
            for (Table_column_defContext colCtx : defineColumnContext.table_col_def) {
                if (colCtx.tabl_constraint != null) {
                    table.addConstraint(getTableConstraint(colCtx.tabl_constraint, schema.getName()));
                }
                if (colCtx.table_column_definition() != null) {
                    table.addColumn(getColumn(colCtx.table_column_definition(), getDefSchemaName()));
                }
            }
        }
        if (defineColumnContext != null) {
            Column_referencesContext parentTable = defineColumnContext.parent_table;
            if(parentTable != null){
                for (Schema_qualified_nameContext nameInher : parentTable.names_references().name) {
                    List<IdentifierContext> idsInh = nameInher.identifier();
                    String inhSchemaName = QNameParser.getSchemaName(idsInh, null);
                    String inhTableName = QNameParser.getFirstName(idsInh);
                    table.addInherits(inhSchemaName, inhTableName);
                    GenericColumn gc = new GenericColumn(
                            inhSchemaName == null ? getDefSchemaName() : inhSchemaName,
                                    inhTableName, DbObjType.TABLE);
                    table.addDep(gc);
                }
            }
        }

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

        schema.addTable(table);
        return table;
    }

    private void parseOptions(List<Storage_parameter_optionContext> options, PgTable table){
        for (Storage_parameter_optionContext option : options){
            Schema_qualified_nameContext key = option.schema_qualified_name();
            List <IdentifierContext> optionIds = key.identifier();
            VexContext valueCtx = option.vex();
            String value = valueCtx == null ? "" : valueCtx.getText();
            String optionText = key.getText();
            if ("OIDS".equalsIgnoreCase(optionText)){
                if ("TRUE".equalsIgnoreCase(value) || "'TRUE'".equalsIgnoreCase(value)){
                    table.setHasOids(true);
                }
            } else if("toast".equals(QNameParser.getSecondName(optionIds))){
                fillStorageParams(value, QNameParser.getFirstName(optionIds), true, table);
            } else {
                fillStorageParams(value, optionText, false, table);
            }
        }
    }
}
