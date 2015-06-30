package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class CreateTable extends ParserAbstract {
    private final Create_table_statementContext ctx;
    private final String tablespace;
    private final String oids;

    public CreateTable(Create_table_statementContext ctx, PgDatabase db, Path filePath, String tablespace, String oids) {
        super(db, filePath);
        this.ctx = ctx;
        this.tablespace = tablespace;
        this.oids = oids;
    }

    @Override
    public PgStatement getObject() {

        String name = getName(ctx.name);
        String schemaName =getSchemaName(ctx.name);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }

        PgTable table = new PgTable(name, getFullCtxText(ctx.getParent()));
        List<String> sequences = new ArrayList<>();
        for (Table_column_defContext colCtx : ctx.table_col_def) {
            for (PgConstraint constr : getConstraint(colCtx, schemaName, name)) {
                constr.setTableName(name);
                table.addConstraint(constr);
            }
            if (colCtx.table_column_definition()!=null) {
                table.addColumn(getColumn(colCtx.table_column_definition(), sequences));
            }
        }
        for (String seq : sequences) {
            table.addSequence(seq);
        }
        if (ctx.paret_table != null) {
            for (Schema_qualified_nameContext nameInher : ctx.paret_table.names_references().name) {
                table.addInherits(getSchemaName(nameInher), getName(nameInher));
            }
        }

        if (tablespace != null) {
            table.setTablespace(tablespace);
        }
        if (ctx.table_space() != null) {
            table.setTablespace(getName(ctx.table_space().name));
        }

        StringBuilder sb = new StringBuilder();
        boolean explicitOids = false;
        if (ctx.storage_parameter_oid() != null) {
            if (ctx.storage_parameter_oid().with_storage_parameter() != null) {
                sb.append(getFullCtxText(ctx.storage_parameter_oid()
                        .with_storage_parameter().storage_parameter()));
            }
            if (ctx.storage_parameter_oid().WITHOUT() != null) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("OIDS=false");
                explicitOids = true;
            } else if (ctx.storage_parameter_oid().WITH() != null) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("OIDS=true");
                explicitOids = true;
            }
        }
        if (!explicitOids && oids != null) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("OIDS=true");
        }
        if (sb.length() > 0) {
            table.setWith(sb.toString());
        }
        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "TABLE", name);
            return null;
        }
        db.getSchema(schemaName).addTable(table);
        return table;
    }
}
