package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Names_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.StatementActions;

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
        PgTrigger trigger = new PgTrigger(name, getFullCtxText(ctx.getParent()), db.getDefSearchPath());
        trigger.setTableName(ctx.tabl_name.getText());
        addObjReference(schemaName, ctx.tabl_name.getText(), DbObjType.TABLE,
                StatementActions.NONE, ctx.tabl_name.getStart().getStartIndex(), 0);
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
        String funcName = getName(ctx.function_parameters().name);
        String funcSchema = getSchemaName(ctx.function_parameters().name);
        int offset = 0;
        if (funcSchema == null) {
            funcSchema = getDefSchemaName();
        } else {
            offset = funcSchema.length() + 1;
            addObjReference(null, funcSchema, DbObjType.SCHEMA,
                    StatementActions.NONE, ctx.function_parameters().getStart().getStartIndex(), 0);
        }
        PgFunction func = new PgFunction(funcName, getFullCtxText(ctx.func_name), "");
        fillArguments(ctx.function_parameters().function_args(), func);
        addObjReference(funcSchema, func.getSignature(), DbObjType.FUNCTION,
                StatementActions.NONE, ctx.function_parameters().getStart().getStartIndex()+ offset, func.getBareName().length());
        
        for (Names_referencesContext column : ctx.names_references()) {
            for (Schema_qualified_nameContext nameCol : column.name){
            trigger.addUpdateColumn(getName(nameCol));
            }
        }
        if (ctx.when_expr != null) {
            trigger.setWhen(ctx.when_expr.getText());
        }
        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "TRIGGER", trigger.getTableName());
            return null;
        } else if(db.getSchema(schemaName).getTable(trigger.getTableName()) == null) {
            Log.log(Log.LOG_ERROR,
                    new StringBuilder().append("TABLE ")
                            .append(trigger.getTableName())
                            .append(" not found on schema ").append(schemaName)
                            .append(" That's why trigger ").append(name)
                            .append("will be skipped").toString());
            return null;
        }
        db.getSchema(schemaName).getTable(trigger.getTableName()).addTrigger(trigger);
        fillObjDefinition(schemaName, trigger, ctx.name.getStart().getStartIndex());
        return trigger;
    }

}
