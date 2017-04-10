package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Attribute_option_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_actionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterTable extends ParserAbstract {

    private final Alter_table_statementContext ctx;
    public AlterTable(Alter_table_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        IdentifierContext nameCtx = QNameParser.getFirstNameCtx(ids);
        PgTable tabl = null;

        List<String> sequences = new ArrayList<>();
        Map<String, GenericColumn> defaultFunctions = new HashMap<>();
        for (Table_actionContext tablAction : ctx.table_action()) {
            // for owners try to get any relation, fail if the last attempt fails
            if (tablAction.owner_to() != null) {
                PgStatement st = null;
                String name = nameCtx.getText();
                if ((st = schema.getTable(name)) != null) {
                    fillOwnerTo(tablAction.owner_to(), st);
                } else if ((st = schema.getSequence(name)) != null) {
                    fillOwnerTo(tablAction.owner_to(), st);
                } else if ((st = getSafe(schema::getView, nameCtx)) != null) {
                    fillOwnerTo(tablAction.owner_to(), st);
                }
                continue;
            }

            // everything else requires a real table, so fail immediately
            tabl = getSafe(schema::getTable, QNameParser.getFirstNameCtx(ids));
            if (tablAction.table_column_definition() != null) {
                tabl.addColumn(getColumn(tablAction.table_column_definition(),
                        sequences, getDefSchemaName()));
            }
            if (tablAction.set_def_column() != null) {
                String sequence = getSequence(tablAction.set_def_column().expression);
                if (sequence != null) {
                    sequences.add(sequence);
                }
                PgColumn col = tabl.getColumn(QNameParser.getFirstName(tablAction.column.identifier()));
                if (col != null) {
                    ValueExpr vex = new ValueExpr(schema.getName());
                    vex.analyze(new Vex(tablAction.set_def_column().expression));
                    col.addAllDeps(vex.getDepcies());
                }
            }

            if(tablAction.set_attribute_option() != null){
                PgColumn col = tabl.getColumn(QNameParser.getFirstName(tablAction.column.identifier()));
                if(col != null){
                    for(Attribute_option_valueContext option :tablAction.set_attribute_option().attribute_option_value()){
                        col.addOption(option.attribute_option.getText(), option.value.getText());
                    }
                }
            }

            if(tablAction.set_storage() != null){
                PgColumn col = tabl.getColumn(QNameParser.getFirstName(tablAction.column.identifier()));
                if(col != null){
                    col.setStorage(tablAction.set_storage().storage_option().getText());
                    col.setDefaultStorage(identifyDefaultStorage(col));
                }
            }

            if (tablAction.tabl_constraint != null) {
                PgConstraint constr = getTableConstraint(tablAction.tabl_constraint);
                if (tablAction.not_valid != null) {
                    constr.setNotValid(true);
                }
                tabl.addConstraint(constr);
            }
            if (tablAction.index_name != null) {
                IdentifierContext indexName = QNameParser.getFirstNameCtx(tablAction.index_name.identifier());
                PgIndex index = getSafe(tabl::getIndex, indexName);
                index.setClusterIndex(true);
            }

            if (tablAction.WITHOUT() != null && tablAction.OIDS() != null) {
                tabl.setHasOids(false);
            } else if (tablAction.WITH() != null && tablAction.OIDS() != null) {
                tabl.setHasOids(true);
            }
            if (tablAction.column != null) {
                if (tablAction.STATISTICS() != null) {
                    fillStatictics(tabl, tablAction);
                }
                if (tablAction.set_def_column() != null && tabl.getInherits().isEmpty()) {
                    // не добавляем в таблицу сиквенс если она наследует
                    // некоторые поля из др таблицы
                    // совместимость с текущей версией экспорта
                    fillDefColumn(tabl, tablAction);
                }
            }
            if (tablAction.RULE() != null) {
                createRule(tabl, tablAction);
            }
        }
        for (String seq : sequences) {
            // не добавляем в таблицу сиквенс если она наследует некоторые поля
            // из др таблицы
            // совместимость с текущей версией экспорта
            if (tabl.getInherits().isEmpty()) {
                QNameParser seqName = new QNameParser(seq);
                tabl.addDep(new GenericColumn(seqName.getSchemaName(getDefSchemaName()),
                        seqName.getFirstName(), DbObjType.SEQUENCE));
            }
        }
        for (Entry<String, GenericColumn> function : defaultFunctions.entrySet()) {
            PgColumn col = tabl.getColumn(function.getKey());
            if (col != null) {
                col.addDep(function.getValue());
            }
        }
        return null;
    }

    private void createRule(PgTable tabl, Table_actionContext tablAction) {
        PgRule rule = getSafe(tabl::getRule, tablAction.rewrite_rule_name.identifier(0));
        if (rule != null) {
            if (tablAction.DISABLE() != null) {
                rule.setEnabledState("DISABLE");
            } else if (tablAction.ENABLE() != null) {
                if (tablAction.REPLICA() != null) {
                    rule.setEnabledState("ENABLE REPLICA");
                } else if (tablAction.ALWAYS() != null) {
                    rule.setEnabledState("ENABLE ALWAYS");
                }
            }
        }
    }

    private void fillDefColumn(PgTable table, Table_actionContext tablAction) {
        String name = QNameParser.getFirstName(tablAction.column.identifier());
        if (table.getColumn(name) == null) {
            PgColumn col = new PgColumn(name);
            col.setDefaultValue(getFullCtxText(tablAction.set_def_column().expression));
            table.addColumn(col);
        } else {
            table.getColumn(name).setDefaultValue(
                    getFullCtxText(tablAction.set_def_column().expression));
        }
    }

    private void fillStatictics(PgTable table, Table_actionContext tablAction) {
        String name = QNameParser.getFirstName(tablAction.column.identifier());
        if (table.getColumn(name) == null) {
            PgColumn col = new PgColumn(name);
            String number = tablAction.integer.getText();
            col.setStatistics(Integer.valueOf(number));
            table.addColumn(col);
        } else {
            table.getColumn(name).setStatistics(
                    Integer.valueOf(tablAction.integer.getText()));
        }
    }

    private String identifyDefaultStorage(PgColumn column){
        String columnType = column.getType();

        String[] mainTypes = {"cidr", "inet", "numeric"};
        for(String type : mainTypes) {
            if(columnType.contains(type)){
                return "MAIN";
            }
        }

        String[] extendedTypes = {"bit", "varbit", "bytea", "bpchar", "char", "varchar", "json", "jsonb", "path", "polygon", "text", "tsvector", "txid_snapshot", "xml"};
        for(String type : extendedTypes) {
            if(columnType.contains(type)){
                return "EXTENDED";
            }
        }

        return "PLAIN";
    }
}
