package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Names_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Predefined_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_deferrableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_initialy_immedContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Trigger_referencingContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.When_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
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
        List<IdentifierContext> ids = ctx.table_name.identifier();
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        String schemaName = schema.getName();
        PgTrigger trigger = new PgTrigger(ctx.name.getText(), getFullCtxText(ctx.getParent()));
        trigger.setTableName(QNameParser.getFirstName(ctx.table_name.identifier()));
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
        setQualifiedFunction(trigger, schemaName);

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
                sb.append(PgDiffUtils.getQuotedName(refSchemaName == null ? schemaName : refSchemaName))
                .append('.');
                sb.append(PgDiffUtils.getQuotedName(refRelName));

                trigger.addDep(new GenericColumn(refSchemaName, refRelName, DbObjType.TABLE));
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
                .data_type().predefined_type().schema_qualified_name_nontype();
        IdentifierContext sch = funcNameCtx.schema;
        String schName = sch != null ?  sch.getText() : getDefSchemaName();
        String objName = funcNameCtx.identifier_nontype().getText();
        trigger.addDep(new GenericColumn(schName, objName + "()", DbObjType.FUNCTION));

        for (Names_referencesContext column : ctx.names_references()) {
            for (Schema_qualified_nameContext nameCol : column.name) {
                String col = QNameParser.getFirstName(nameCol.identifier());
                trigger.addUpdateColumn(col);
                trigger.addDep(new GenericColumn(schemaName, trigger.getTableName(), col, DbObjType.COLUMN));
            }
        }
        parseWhen(ctx.when_trigger(), trigger, db);

        getSafe(schema::getTriggerContainer, QNameParser.getFirstNameCtx(ctx.table_name.identifier()))
        .addTrigger(trigger);
        return trigger;
    }

    private void setQualifiedFunction(PgTrigger trigger, String schemaName) {
        Function_nameContext functionNameCtx = ctx.func_name.function_name();
        if (functionNameCtx != null && functionNameCtx.data_type() != null) {
            Data_typeContext dataTypeCtx = functionNameCtx.data_type();
            Predefined_typeContext pridifinedType = dataTypeCtx.value != null ? dataTypeCtx.value : dataTypeCtx.predefined_type();

            Schema_qualified_name_nontypeContext schemaQualNameNonType = pridifinedType.schema_qualified_name_nontype();
            if (schemaQualNameNonType != null && schemaQualNameNonType.schema != null) {
                trigger.setFunction(getFullCtxText(ctx.func_name));
            } else {
                trigger.setFunction(schemaName + '.' + getFullCtxText(ctx.func_name));
            }
        } else {
            trigger.setFunction(getFullCtxText(ctx.func_name));
        }
    }

    public static void parseWhen(When_triggerContext whenCtx, PgTrigger trigger,
            PgDatabase db) {
        if (whenCtx != null) {
            VexContext vex = whenCtx.when_expr;
            trigger.setWhen(getFullCtxText(vex));
            db.addContextForAnalyze(trigger, vex);
        }
    }

    public static void analyzeTriggersWhen(VexContext ctx, PgTrigger trigger,
            String schemaName, PgDatabase db) {
        ValueExprWithNmspc vex = new ValueExprWithNmspc(schemaName, db);
        GenericColumn implicitTable = new GenericColumn(schemaName, trigger.getTableName(), DbObjType.TABLE);
        vex.addReference("new", implicitTable);
        vex.addReference("old", implicitTable);
        UtilAnalyzeExpr.analyze(new Vex(ctx), vex, trigger);
    }
}
