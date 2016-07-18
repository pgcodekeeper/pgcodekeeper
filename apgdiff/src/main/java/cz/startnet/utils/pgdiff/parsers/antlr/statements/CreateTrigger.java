package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Names_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.When_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class CreateTrigger extends ParserAbstract {
    private final Create_trigger_statementContext ctx;

    public CreateTrigger(Create_trigger_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        PgTrigger trigger = new PgTrigger(name, getFullCtxText(ctx.getParent()));
        String tableName = ctx.tabl_name.getText();
        trigger.setTableName(tableName);
        trigger.setBefore(ctx.before_true != null);
        if (ctx.ROW() != null) {
            trigger.setForEachRow(true);
        }
        if (ctx.STATEMENT() != null) {
            trigger.setForEachRow(false);
        }
        trigger.setOnDelete(ctx.delete_true != null);
        trigger.setOnInsert(ctx.insert_true != null);
        trigger.setOnUpdate(ctx.update_true != null);
        trigger.setOnTruncate(ctx.truncate_true != null);
        trigger.setFunction(getFullCtxText(ctx.func_name),
                getFullCtxText(ctx.func_name.schema_qualified_name()) + "()");
        for (Names_referencesContext column : ctx.names_references()) {
            for (Schema_qualified_nameContext nameCol : column.name) {
                trigger.addUpdateColumn(QNameParser.getFirstName(nameCol.identifier()));
            }
        }
        WhenListener whenListener = new WhenListener();
        ParseTreeWalker.DEFAULT.walk(whenListener, ctx);
        trigger.setWhen(whenListener.getWhen());

        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "TRIGGER", trigger.getTableName());
            return null;
        } else if (db.getSchema(schemaName).getTable(trigger.getTableName()) == null) {
            Log.log(Log.LOG_ERROR,
                    new StringBuilder().append("TABLE ")
                            .append(trigger.getTableName())
                            .append(" not found on schema ").append(schemaName)
                            .append(" That's why trigger ").append(name)
                            .append("will be skipped").toString());
            return null;
        }
        db.getSchema(schemaName).getTable(trigger.getTableName()).addTrigger(trigger);
        return trigger;
    }

    public static class WhenListener extends SQLParserBaseListener {
        private String when;

        @Override
        public void exitWhen_trigger(When_triggerContext ctx) {
            when = getFullCtxText(ctx.when_expr);
        }

        public String getWhen() {
            return when;
        }
    }
}
