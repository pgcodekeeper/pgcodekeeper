package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Names_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_deferrableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_initialy_immedContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.When_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgTrigger.TgTypes;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateTrigger extends ParserAbstract {
    private final Create_trigger_statementContext ctx;
    public CreateTrigger(Create_trigger_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        PgTrigger trigger = new PgTrigger(QNameParser.getFirstName(ids), getFullCtxText(ctx.getParent()));
        trigger.setTableName(ctx.tabl_name.getText());
        if (ctx.AFTER() != null) {
            trigger.setType(TgTypes.AFTER);
        } else if (ctx.BEFORE() != null) {
            trigger.setType(TgTypes.BEFORE);
        } else if (ctx.INSTEAD() != null) {
            trigger.setType(TgTypes.INSTEAD_OF);
        }
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
        trigger.setFunction(getFullCtxText(ctx.func_name));

        if (ctx.CONSTRAINT() != null ) {
            trigger.setConstraint(true);
            Table_deferrableContext  def  = ctx.table_deferrable();
            if (def != null && def.NOT() == null){
                Table_initialy_immedContext  initImmed  = ctx.table_initialy_immed();
                if (initImmed != null){
                    trigger.setImmediate(initImmed.DEFERRED() == null);
                }
            }

            if (ctx.referenced_table_name != null){
                List<IdentifierContext> refName = ctx.referenced_table_name.identifier();
                String refSchemaName = QNameParser.getSecondName(refName);
                String refRelName = QNameParser.getFirstName(refName);

                StringBuilder sb = new StringBuilder();
                if (refSchemaName != null){
                    if (!refSchemaName.equals(schemaName)){
                        sb.append(PgDiffUtils.getQuotedName(refSchemaName)).append('.');
                    }
                } else {
                    refSchemaName = schemaName;
                }
                sb.append(PgDiffUtils.getQuotedName(refRelName));

                trigger.addDep(new GenericColumn(refSchemaName, refRelName, DbObjType.TABLE));
                trigger.setRefTableName(sb.toString());
            }
        }

        List<IdentifierContext> funcIds = ctx.func_name.schema_qualified_name().identifier();
        trigger.addDep(new GenericColumn(QNameParser.getSchemaName(funcIds, getDefSchemaName()),
                QNameParser.getFirstName(funcIds) + "()", DbObjType.FUNCTION));

        for (Names_referencesContext column : ctx.names_references()) {
            for (Schema_qualified_nameContext nameCol : column.name) {
                String col = QNameParser.getFirstName(nameCol.identifier());
                trigger.addUpdateColumn(col);
                trigger.addDep(new GenericColumn(schemaName, trigger.getTableName(), col, DbObjType.COLUMN));
            }
        }
        parseWhen(ctx.when_trigger(), trigger, schema.getName());

        getSafe(schema::getTriggerContainer, QNameParser.getFirstNameCtx(ctx.tabl_name.identifier()))
        .addTrigger(trigger);
        return trigger;
    }

    public static void parseWhen(When_triggerContext whenCtx, PgTrigger trigger, String schemaName) {
        if (whenCtx != null) {
            ValueExpr vex = new ValueExpr(schemaName);
            vex.analyze(new Vex(whenCtx.vex()));
            trigger.addAllDeps(vex.getDepcies());
            trigger.setWhen(getFullCtxText(whenCtx.when_expr));
        }
    }
}
