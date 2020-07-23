package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.MsFuncProcTrigAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateMsTrigger extends BatchContextProcessor {

    private final Create_or_alter_triggerContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    public CreateMsTrigger(Batch_statementContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db, ctx, stream);
        this.ctx = ctx.batch_statement_body().create_or_alter_trigger();
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
    }

    @Override
    protected ParserRuleContext getDelimiterCtx() {
        return ctx.table_name;
    }

    @Override
    public void parseObject() {
        IdContext schemaCtx = ctx.trigger_name.schema;
        if (schemaCtx == null) {
            schemaCtx = ctx.table_name.schema;
        }
        List<ParserRuleContext> ids = Arrays.asList(schemaCtx, ctx.table_name.name);
        addObjReference(ids, DbObjType.TABLE, null);
        getObject(getSchemaSafe(ids), false);
    }

    public MsTrigger getObject(AbstractSchema schema, boolean isJdbc) {
        IdContext schemaCtx = ctx.trigger_name.schema;
        if (schemaCtx == null) {
            schemaCtx = ctx.table_name.schema;
        }
        IdContext tableNameCtx = ctx.table_name.name;
        IdContext nameCtx = ctx.trigger_name.name;

        MsTrigger trigger = new MsTrigger(nameCtx.getText());
        trigger.setAnsiNulls(ansiNulls);
        trigger.setQuotedIdentified(quotedIdentifier);
        setSourceParts(trigger);

        if (schema == null) {
            addObjReference(Arrays.asList(schemaCtx, tableNameCtx), DbObjType.TABLE, null);
        }

        db.addAnalysisLauncher(new MsFuncProcTrigAnalysisLauncher(trigger,
                ctx.sql_clauses(), fileName));

        PgStatementContainer cont = getSafe(AbstractSchema::getStatementContainer,
                schema, tableNameCtx);

        if (isJdbc && schema != null) {
            cont.addTrigger(trigger);
        } else {
            addSafe(cont, trigger,
                    Arrays.asList(schemaCtx, tableNameCtx, nameCtx));
        }
        return trigger;
    }

    @Override
    protected String getStmtAction() {
        IdContext schemaCtx = ctx.trigger_name.schema;
        if (schemaCtx == null) {
            schemaCtx = ctx.table_name.schema;
        }
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TRIGGER,
                Arrays.asList(schemaCtx, ctx.table_name.name, ctx.trigger_name.name));
    }
}
