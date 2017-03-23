package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
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
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
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
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgTable table = new PgTable(name, getFullCtxText(ctx.getParent()));
        List<String> sequences = new ArrayList<>();
        Map<String, GenericColumn> defaultFunctions = new HashMap<>();
        Define_columnsContext defineColumnContext = ctx.define_table().define_columns();
        Define_typeContext defineTypeContext = ctx.define_table().define_type();
        if(defineTypeContext != null){
            table.setOfType(QNameParser.getFirstName(defineTypeContext.type_name.identifier()));
            List_of_type_column_defContext lstTypeColDefCtx = defineTypeContext.list_of_type_column_def();
            if(lstTypeColDefCtx != null){
                for (Table_of_type_column_defContext typeColCtx : lstTypeColDefCtx.table_col_def) {
                    for (PgConstraint constr : getConstraint(typeColCtx, schemaName, name)) {
                        table.addConstraint(constr);
                    }
                    if (typeColCtx.table_of_type_column_definition() != null) {
                       table.addColumnOfType(getColumnOfType(typeColCtx.table_of_type_column_definition(), sequences,
                                defaultFunctions, getDefSchemaName()));
                    }
                }
            }
        } else {
            for (Table_column_defContext colCtx : defineColumnContext.table_col_def) {
                for (PgConstraint constr : getConstraint(colCtx, schemaName, name)) {
                    table.addConstraint(constr);
                }
                if (colCtx.table_column_definition() != null) {
                    table.addColumn(getColumn(colCtx.table_column_definition(), sequences,
                            defaultFunctions, getDefSchemaName()));
                }
            }
        }
        
        for (String seq : sequences) {
            QNameParser seqName = new QNameParser(seq);
            table.addDep(new GenericColumn(seqName.getSchemaName(getDefSchemaName()),
                    seqName.getFirstName(), DbObjType.SEQUENCE));
        }
        
        if(defineTypeContext != null){
            for (Entry<String, GenericColumn> function : defaultFunctions.entrySet()) {
                PgColumn col = table.getColumnOfType(function.getKey());
                if (col != null) {
                    col.addDep(function.getValue());
                }
            }
        } else {
            for (Entry<String, GenericColumn> function : defaultFunctions.entrySet()) {
                PgColumn col = table.getColumn(function.getKey());
                if (col != null) {
                    col.addDep(function.getValue());
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
                parseOptions(parameters.storage_parameter().storage_parameter_option(),table);
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

        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "TABLE", name);
            return null;
        }
        db.getSchema(schemaName).addTable(table);
        return table;
    }


    private void parseOptions(List<Storage_parameter_optionContext> options, PgTable table){
        for (Storage_parameter_optionContext option : options){
            Schema_qualified_nameContext key = option.schema_qualified_name();
            List <IdentifierContext> optionIds = key.identifier();
            VexContext valueContext = option.vex();
            String value = valueContext != null ? valueContext.getText() : "";
            String optionText = key.getText();
            if ("OIDS".equalsIgnoreCase(optionText)){
                if ("TRUE".equalsIgnoreCase(value) || "'TRUE'".equalsIgnoreCase(value)){
                    table.setHasOids(true);
                }
            } else if("toast".equals(QNameParser.getSecondName(optionIds))){
                ParserAbstract.fillStorageParams(value, QNameParser.getFirstName(optionIds), true, table);
            } else {
                ParserAbstract.fillStorageParams(value, optionText, false, table);
            }
        }
    }
}
