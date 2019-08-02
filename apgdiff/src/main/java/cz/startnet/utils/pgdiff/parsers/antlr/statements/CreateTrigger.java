package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Columns_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_deferrableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_initialy_immedContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Trigger_referencingContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.When_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.TriggerAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgTrigger.TgTypes;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateTrigger extends ParserAbstract {
    private final Create_trigger_statementContext ctx;
    public CreateTrigger(Create_trigger_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.table_name.identifier();
        String schemaName = getSchemaNameSafe(ids);
        addObjReference(ids, DbObjType.TABLE, StatementActions.NONE);

        PgTrigger trigger = new PgTrigger(ctx.name.getText());
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

            if (ctx.referenced_table_name != null) {
                List<IdentifierContext> refName = ctx.referenced_table_name.identifier();
                String refSchemaName = QNameParser.getSecondName(refName);
                String refRelName = QNameParser.getFirstName(refName);

                StringBuilder sb = new StringBuilder();
                if (refSchemaName == null) {
                    refSchemaName = schemaName;
                }

                if (refSchemaName != null) {
                    sb.append(PgDiffUtils.getQuotedName(refSchemaName)).append('.');
                }
                sb.append(PgDiffUtils.getQuotedName(refRelName));

                addDepSafe(trigger, refName, DbObjType.TABLE, true);
                trigger.setRefTableName(sb.toString());
            }
        }

        for (Trigger_referencingContext ref : ctx.trigger_referencing()) {
            String name = ref.transition_relation_name.getText();
            if (ref.NEW() != null) {
                trigger.setNewTable(name);
            } else {
                trigger.setOldTable(name);
            }
        }

        Schema_qualified_name_nontypeContext funcNameCtx = ctx.func_name.function_name()
                .schema_qualified_name_nontype();
        IdentifierContext sch = funcNameCtx.schema;
        if (sch != null) {
            addDepSafe(trigger, Arrays.asList(sch, funcNameCtx.identifier_nontype()),
                    DbObjType.FUNCTION, true, "()");
        }

        for (Columns_listContext column : ctx.columns_list()) {
            for (IdentifierContext nameCol : column.name) {
                trigger.addUpdateColumn(nameCol.getText());
                addDepSafe(trigger, Arrays.asList(sch, QNameParser.getFirstNameCtx(ids), nameCol),
                        DbObjType.COLUMN, true);
            }
        }
        parseWhen(ctx.when_trigger(), trigger, db);

        IdentifierContext parent = QNameParser.getFirstNameCtx(ids);
        IStatementContainer cont = getSafe(AbstractSchema::getStatementContainer,
                getSchemaSafe(ids), parent);
        addSafe((PgStatement) cont, trigger, Arrays.asList(
                QNameParser.getSchemaNameCtx(ids), parent, ctx.name));
    }

    public static void parseWhen(When_triggerContext whenCtx, PgTrigger trigger,
            PgDatabase db) {
        if (whenCtx != null) {
            VexContext vex = whenCtx.when_expr;
            trigger.setWhen(getFullCtxText(vex));
            db.addAnalysisLauncher(new TriggerAnalysisLauncher(trigger, vex));
        }
    }
}
