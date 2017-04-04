package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_oidContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_storage_parameterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateTable extends ParserAbstract {
    private final Create_table_statementContext ctx;
    private final String tablespace;
    private final String oids;
    public CreateTable(Create_table_statementContext ctx, PgDatabase db, String tablespace,
            String oids) {
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
        List<String> sequences = new ArrayList<>();
        for (Table_column_defContext colCtx : ctx.table_col_def) {
            for (PgConstraint constr : getConstraint(colCtx, schema.getName())) {
                table.addConstraint(constr);
            }
            if (colCtx.table_column_definition() != null) {
                table.addColumn(getColumn(colCtx.table_column_definition(), sequences,
                        getDefSchemaName()));
            }
        }
        for (String seq : sequences) {
            QNameParser seqName = new QNameParser(seq);
            table.addDep(new GenericColumn(seqName.getSchemaName(getDefSchemaName()),
                    seqName.getFirstName(), DbObjType.SEQUENCE));
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
        Storage_parameter_oidContext storage = ctx.storage_parameter_oid();
        if (storage != null) {
            With_storage_parameterContext parameters = storage.with_storage_parameter();
            if (parameters != null) {
                parseOptions(parameters.storage_parameter().storage_parameter_option(), table, schema.getName());
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
        schema.addTable(table);
        return table;
    }

    private void parseOptions(List<Storage_parameter_optionContext> options, PgTable table, String schemaName){
        for (Storage_parameter_optionContext option : options){
            Schema_qualified_nameContext key = option.schema_qualified_name();
            List <IdentifierContext> optionIds = key.identifier();
            VexContext valueContext = option.vex();
            String value = "";
            if (valueContext != null){
                ValueExpr vex = new ValueExpr(schemaName);
                vex.analyze(new Vex(valueContext));
                table.addAllDeps(vex.getDepcies());
                value = valueContext.getText();
            }
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
