package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
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
        for (Table_column_defContext colCtx : ctx.table_col_def) {
            for (PgConstraint constr : getConstraint(colCtx, schemaName, name)) {
                table.addConstraint(constr);
            }
            if (colCtx.table_column_definition()!=null) {
                table.addColumn(getColumn(colCtx.table_column_definition(), sequences,
                        defaultFunctions, getDefSchemaName()));
            }
        }
        for (String seq : sequences) {
            QNameParser seqName = new QNameParser(seq);
            table.addDep(new GenericColumn(seqName.getSchemaName(getDefSchemaName()),
                    seqName.getFirstName(), DbObjType.SEQUENCE));
        }
        for (Entry<String, GenericColumn> function : defaultFunctions.entrySet()) {
            PgColumn col = table.getColumn(function.getKey());
            if (col != null) {
                col.addDep(function.getValue());
            }
        }
        if (ctx.parent_table != null) {
            for (Schema_qualified_nameContext nameInher : ctx.parent_table.names_references().name) {
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

        if (tablespace != null) {
            table.setTablespace(tablespace);
        }
        if (ctx.table_space() != null) {
            table.setTablespace(QNameParser.getFirstName(ctx.table_space().name.identifier()));
        }

        boolean explicitOids = false;
        if (ctx.storage_parameter_oid() != null) {
            if (ctx.storage_parameter_oid().with_storage_parameter() != null) {
                search(ctx.storage_parameter_oid().with_storage_parameter().storage_parameter().storage_parameter_option(),
                        table);
            }
            if (ctx.storage_parameter_oid().WITHOUT() != null) {
                table.setHasOids(false);
                explicitOids = true;
            } else if (ctx.storage_parameter_oid().WITH() != null) {
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


    private void search(List<Storage_parameter_optionContext> options, PgTable table){
        for (Storage_parameter_optionContext option : options){
            Schema_qualified_nameContext key = option.schema_qualified_name();
            List <IdentifierContext> optionIds = key.identifier();
            String value = option.vex().getText();
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
