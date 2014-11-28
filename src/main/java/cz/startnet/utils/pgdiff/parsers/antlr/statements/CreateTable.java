package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_constraintContext;
import cz.startnet.utils.pgdiff.schema.PgColumn;
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
        
        for (Schema_qualified_nameContext par_table : ctx.paret_table) {
            table.addInherits(getName(par_table));
        }
        
        if (ctx.table_space()!=null) {
            table.setTablespace(ctx.table_space().identifier().getText());
        }
        
        if (ctx.storage_parameter_oid() != null) {
            table.setWith(ctx.storage_parameter_oid().getText());
        }
        
        fillObjLocation(table, ctx.name.getStart().getStartIndex(), schemaName);
        return table;
    }
    
    static PgColumn getColumn(Table_column_definitionContext colCtx) {
        PgColumn col = null;
        if (colCtx.table_column_name() != null) {
            col = new PgColumn(colCtx.table_column_name().getText());
            for (Column_constraintContext column_constraint : colCtx
                    .column_constraint()) {
                if (column_constraint.default_expr != null) {
                    col.setDefaultValue(column_constraint.default_expr
                            .getText());
                } else if (column_constraint.default_expr_data != null) {
                    col.setDefaultValue(column_constraint.default_expr_data
                            .getText());
                }
                
                if (column_constraint.null_value != null) {
                    if (column_constraint.null_false != null) {
                        col.setNullValue(false);
                    } else {
                        col.setNullValue(true);
                    }
                }
            }
            if (colCtx.datatype != null) {
                col.setType(colCtx.datatype.getText());
            }
        }
        
        return col;
    }

    private List<PgConstraint> getConstraint(Table_column_defContext colCtx) {
        List<PgConstraint> result = new ArrayList<>();
        PgConstraint constr = null;
        if (colCtx.table_constraint() != null) {
            Table_constraintContext tablConstr = colCtx.table_constraint();
            constr = new PgConstraint(
                    tablConstr.constraint_name != null ? tablConstr.constraint_name.getText()
                            : "", getFullCtxText(tablConstr), "");
            constr.setDefinition(getFullCtxText(tablConstr));
            result.add(constr);
        } else {
            for (Column_constraintContext column_constraint : colCtx.table_column_definition().column_constraint()) {
                // skip null and def values, it parsed to column def
                if (column_constraint.null_value != null
                        || column_constraint.default_expr != null
                        || column_constraint.default_expr_data != null) {
                    continue;
                }
                constr = new PgConstraint(
                        column_constraint.constraint_name != null ? column_constraint.constraint_name.getText()
                                : "", getFullCtxText(column_constraint), "");
                constr.setDefinition(getFullCtxText(column_constraint));
                result.add(constr);
            }
        }
        return result;
    }
}
