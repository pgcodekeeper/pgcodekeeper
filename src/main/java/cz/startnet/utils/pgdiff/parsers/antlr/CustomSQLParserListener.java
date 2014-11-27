package cz.startnet.utils.pgdiff.parsers.antlr;

import java.nio.file.Path;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_constraintContext;
import cz.startnet.utils.pgdiff.schema.PGObjLocation;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class CustomSQLParserListener extends SQLParserBaseListener {

    private PgDatabase db;
    private Path filePath;
    private List<PgStatement> objects;

    public CustomSQLParserListener(List<PgStatement> objects,
            PgDatabase database, Path filePath) {
        this.db = database;
        this.filePath = filePath;
        this.objects = objects;
    }

    @Override
    public void exitCreate_table_statement(Create_table_statementContext ctx) {
        int i = 0;
        if (ctx.name == null) {
            return;
        }
        while (ctx.name.identifier(i + 1) != null) {
            i++;
        }

        PgTable table = new PgTable(ctx.name.identifier(i).getText(), "CREATE "
                + getFullCtxText(ctx), "");

        for (Table_column_defContext colCtx : ctx.table_col_def) {
            PgColumn col = null;
            if (colCtx.table_column_name() != null) {
                col = new PgColumn(colCtx.table_column_name().getText());
            }
            // constraint
            if (col == null) {
                PgConstraint constr = null;
                if (colCtx.table_constraint() != null && colCtx.table_constraint().constraint_name != null) {
                    Table_constraintContext tablConstr = colCtx.table_constraint();
                    constr = new PgConstraint(tablConstr.constraint_name.getText(), getFullCtxText(tablConstr), "");
                    constr.setDefinition(getFullCtxText(tablConstr));
                } else {
                    for (Column_constraintContext column_constraint : colCtx
                            .column_constraint()) {
                        if (column_constraint.constraint_name != null) {
                            constr = new PgConstraint(column_constraint.constraint_name.getText(), getFullCtxText(column_constraint), "");
                            constr.setDefinition(getFullCtxText(column_constraint));
                        }
                    }
                }
                if (constr != null) {
                    table.addConstraint(constr);
                }
            } else {
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
                table.addColumn(col);
            }
        }
        
        for (Schema_qualified_nameContext par_table : ctx.paret_table) {
            i = 0;
            while (par_table.identifier(i + 1) != null) {
                i++;
            }
            table.addInherits(par_table.identifier(i).getText());
        }
        
        if (ctx.table_space()!=null) {
            table.setTablespace(ctx.table_space().identifier().getText());
        }
        
        if (ctx.storage_parameter_oid() != null) {
            table.setWith(ctx.storage_parameter_oid().getText());
        }

        objects.add(table);
        db.addObjLocation(new PGObjLocation(ctx.name.identifier(i).getText(),
                ctx.name.getStart().getStartIndex(), filePath));
    }

    private String getFullCtxText(ParserRuleContext ctx) {
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        ctx.start.getInputStream().getText(interval);
        return ctx.start.getInputStream().getText(interval);
    }
}
