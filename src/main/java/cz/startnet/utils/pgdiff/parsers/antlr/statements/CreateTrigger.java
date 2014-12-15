package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Names_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTrigger;

public class CreateTrigger extends ParserAbstract {
    private Create_trigger_statementContext ctx;
    public CreateTrigger(Create_trigger_statementContext ctx, PgDatabase db, Path filePath) {
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
        PgTrigger trigger = new PgTrigger(name, getFullCtxText(ctx.getParent()), "");
        trigger.setTableName(ctx.tabl_name.getText());
        trigger.setBefore(ctx.before_true != null);
        if (ctx.ROW() != null) {
            trigger.setForEachRow(true);
        }
        if (ctx.STATEMENT() != null) {
            trigger.setForEachRow(false);
        }
        trigger.setOnDelete(ctx.delete_true != null);
        trigger.setOnInsert(ctx.insert_true!= null);
        trigger.setOnUpdate(ctx.update_true != null);
        trigger.setOnTruncate(ctx.truncate_true != null);
        trigger.setFunction(getFullCtxText(ctx.func_name));
        
        for (Names_referencesContext column : ctx.names_references()) {
            for (Schema_qualified_nameContext nameCol : column.name){
            trigger.addUpdateColumn(getName(nameCol));
            }
        }
        if (ctx.when_expr != null) {
            trigger.setWhen(ctx.when_expr.getText());
        }
        db.getSchema(schemaName).getTable(trigger.getTableName()).addTrigger(trigger);
        fillObjLocation(trigger, ctx.name.getStart().getStartIndex(), schemaName,
                db.getSchema(schemaName).getTable(trigger.getTableName()).getTrigger(name)!=null);
        return trigger;
    }

}
