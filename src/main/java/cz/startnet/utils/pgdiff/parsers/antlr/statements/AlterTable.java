package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_actionContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class AlterTable extends ParserAbstract {

    private Alter_table_statementContext ctx;
    public AlterTable(Alter_table_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        PgTable table = new PgTable(name, getFullCtxText(ctx.getParent()), "");
        for (Table_actionContext tablAction : ctx.table_action()) {
            if (tablAction.table_column_definition()!=null) {
                table.addColumn(getColumn(tablAction.table_column_definition()));
            }
            if (tablAction.tabl_constraint != null) {
                PgConstraint constr = getTableConstraint(tablAction.tabl_constraint);
                constr.setTableName(name);
                table.addConstraint(constr);
            }
            if (tablAction.index_name!=null) {
                table.setClusterIndexName(tablAction.index_name.getText());
            }
            if (tablAction.owner_to() !=null) {
                table.setOwner(tablAction.owner_to().name.getText());
            }
            
        }
        return table;
    }

}
