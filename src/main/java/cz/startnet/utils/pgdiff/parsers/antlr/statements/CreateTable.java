package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constraint_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class CreateTable extends ParserAbstract {
    private final Create_table_statementContext ctx;
    
    public CreateTable(Create_table_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }
    
    @Override
    public PgStatement getObject() {
        
        String name = getName(ctx.name);
        String schemaName =getSchemaName(ctx.name);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }
        if (name == null) {
            return null;
        }
        PgTable table = new PgTable(name, getFullCtxText(ctx.getParent()), "");

        for (Table_column_defContext colCtx : ctx.table_col_def) {
            for (PgConstraint constr : getConstraint(colCtx)) {
                table.addConstraint(constr);                
            }
            if (colCtx.table_column_definition()!=null) {
                table.addColumn(getColumn(colCtx.table_column_definition()));
            }
        }
        
        if (ctx.paret_table != null) {
            for (Schema_qualified_nameContext nameInher : ctx.paret_table.names_references().name) {
                table.addInherits(getSchemaName(nameInher), getName(nameInher));
            }
        }
        
        if (ctx.table_space()!=null) {
            table.setTablespace(getName(ctx.table_space().name));
        }
        
        if (ctx.storage_parameter_oid() != null) {
            if (ctx.storage_parameter_oid().with_storage_parameter() != null)
            table.setWith(getFullCtxText(ctx.storage_parameter_oid().with_storage_parameter().storage_parameter()));
        }
        
        fillObjLocation(table, ctx.name.getStart().getStartIndex(), schemaName);
        return table;
    }
}
