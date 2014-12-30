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

    public AlterTable(Alter_table_statementContext ctx, PgDatabase db,
            Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName = getSchemaName(ctx.name);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        PgTable tabl = db.getSchema(schemaName).getTable(name);
        
        List<String> sequences = new ArrayList<>();
        for (Table_actionContext tablAction : ctx.table_action()) {

            if (tablAction.owner_to() != null) {
                if (tabl != null) {
                    tabl.setOwner(tablAction.owner_to().name.getText());
                } else if (db.getSchema(schemaName).getSequence(name) != null) {
                    db.getSchema(schemaName).getSequence(name)
                            .setOwner(tablAction.owner_to().name.getText());
                } else if (db.getSchema(schemaName).getView(name) != null) {
                    db.getSchema(schemaName).getView(name)
                            .setOwner(tablAction.owner_to().name.getText());
                }
            }
            if (tabl == null) {
                continue;
            }
            if (tablAction.table_column_definition() != null) {
                tabl.addColumn(getColumn(tablAction.table_column_definition(),
                        sequences));
            }
            if (tablAction.set_def_column() != null) {
                String sequence = getSequence(tablAction.set_def_column().expression);
                if (sequence != null) {
                    sequences.add(sequence);
                }
            }
            if (tablAction.tabl_constraint != null) {
                PgConstraint constr = getTableConstraint(tablAction.tabl_constraint);
                constr.setTableName(name);
                tabl.addConstraint(constr);
            }
            if (tablAction.index_name != null) {
                tabl.setClusterIndexName(getFullCtxText(tablAction.index_name));
            }

            if (tablAction.WITHOUT() != null && tablAction.OIDS() != null) {
                tabl.setWith("OIDS=false");
            } else if (tablAction.WITH() != null && tablAction.OIDS() != null) {
                tabl.setWith("OIDS=true");
            }
            if (tablAction.column != null) {
                if (tablAction.STATISTICS() != null) {
                    fillStatictics(tabl, tablAction);
                }
                if (tablAction.set_def_column() != null) {
                    // не добавляем в таблицу сиквенс если она наследует
                    // некоторые поля из др таблицы
                    // совместимость с текущей версией экспорта
                    if (tabl.getInherits().isEmpty()) {
                        fillDefColumn(tabl, tablAction);
                    }
                }
            }
        }
        for (String seq : sequences) {
            // не добавляем в таблицу сиквенс если она наследует некоторые поля
            // из др таблицы
            // совместимость с текущей версией экспорта
            if (tabl.getInherits().isEmpty()) {
                tabl.addSequence(seq);
            }
        }
        addObjReference(schemaName, tabl, ctx.name.getStart().getStartIndex());
        return null;
    }

    private void fillDefColumn(PgTable table, Table_actionContext tablAction) {
        if (table.getColumn(getName(tablAction.column)) == null) {
            PgColumn col = new PgColumn(getName(tablAction.column));
            col.setDefaultValue(getFullCtxText(tablAction.set_def_column().expression));
            table.addColumn(col);
        } else {
            table.getColumn(getName(tablAction.column)).setDefaultValue(
                    getFullCtxText(tablAction.set_def_column().expression));
        }
    }

    private void fillStatictics(PgTable table, Table_actionContext tablAction) {
        if (table.getColumn(getName(tablAction.column)) == null) {
            PgColumn col = new PgColumn(getName(tablAction.column));
            String number = tablAction.integer.getText();
            col.setStatistics(new Integer(number));
            table.addColumn(col);
        } else {
            table.getColumn(getName(tablAction.column)).setStatistics(
                    new Integer(tablAction.integer.getText()));
        }
    }

}
