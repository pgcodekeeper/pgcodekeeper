package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_actionContext;
import cz.startnet.utils.pgdiff.schema.PgColumn;
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
        List<String> sequences = new ArrayList<>();
        for (Table_actionContext tablAction : ctx.table_action()) {
            if (tablAction.table_column_definition()!=null) {
                table.addColumn(getColumn(tablAction.table_column_definition(), sequences));
            }
            if (tablAction.tabl_constraint != null) {
                PgConstraint constr = getTableConstraint(tablAction.tabl_constraint);
                constr.setTableName(name);
                table.addConstraint(constr);
            }
            if (tablAction.index_name!=null) {
                table.setClusterIndexName(getFullCtxText(tablAction.index_name));
            }
            if (tablAction.owner_to() !=null) {
                table.setOwner(tablAction.owner_to().name.getText());
            }
            if (tablAction.WITHOUT() != null && tablAction.OIDS() != null) {
                table.setWith("OIDS=false");
            } else if (tablAction.WITH() != null && tablAction.OIDS() != null) {
                table.setWith("OIDS=true");
            }
            if (tablAction.column != null) {
                if (tablAction.STATISTICS() != null) {
                    if (table.getColumn(getName(tablAction.column)) == null) {
                        PgColumn col = new PgColumn(getName(tablAction.column));
                        String number = tablAction.integer.getText();
                        col.setStatistics(new Integer(number));
                        table.addColumn(col);
                    } else {
                        table.getColumn(getName(tablAction.column)).setStatistics(new Integer(tablAction.integer.toString()));   
                    }
                }
                if (tablAction.set_def_column() != null) {
                    if (table.getColumn(getName(tablAction.column)) == null) {
                        PgColumn col = new PgColumn(getName(tablAction.column));
                        col.setDefaultValue(getFullCtxText(tablAction.set_def_column().expression));
                        table.addColumn(col);
                    } else {
                        table.getColumn(getName(tablAction.column)).setDefaultValue(getFullCtxText(tablAction.set_def_column().expression));   
                    }
                }
            }
        }
        for (String seq : sequences) {
            table.addSequence(seq);
        }
        return table;
    }

}
