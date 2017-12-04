package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.AbstractMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Delete;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Insert;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Update;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgRuleContainer;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class RulesReader extends JdbcReader {

    public static class RulesReaderFactory extends JdbcReaderFactory {

        public RulesReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new RulesReader(this, loader);
        }
    }

    private RulesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSetWrapper result, PgSchema schema) throws WrapperAccessException {
        String contName = result.getString(CLASS_RELNAME);
        PgRuleContainer c = schema.getRuleContainer(contName);
        if (c != null) {
            PgRule rule = getRule(result, schema, contName);
            if (rule != null) {
                c.addRule(rule);
            }
        }
    }

    private PgRule getRule(ResultSetWrapper res, PgSchema schema, String tableName) throws WrapperAccessException {
        String schemaName = schema.getName();
        String ruleName = res.getString("rulename");
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, ruleName, DbObjType.RULE));

        String command = res.getString("rule_string");
        PgRule r = new PgRule(ruleName, command);

        switch (res.getString("ev_type")) {
        case "1":
            r.setEvent(PgRuleEventType.SELECT);
            break;
        case "2":
            r.setEvent(PgRuleEventType.UPDATE);
            break;
        case "3":
            r.setEvent(PgRuleEventType.INSERT);
            break;
        case "4":
            r.setEvent(PgRuleEventType.DELETE);
            break;
        }

        if (res.getBoolean("is_instead")) {
            r.setInstead(true);
        }

        switch (res.getString("ev_enabled")) {
        case "A":
            r.setEnabledState("ENABLE ALWAYS");
            break;
        case "R":
            r.setEnabledState("ENABLE REPLICA");
            break;
        case "D":
            r.setEnabledState("DISABLE");
        }

        loader.submitAntlrTask(command, (PgDatabase)schema.getParent(),
                p -> {
                    Create_rewrite_statementContext createRewriteCtx = p.sql().statement(0).schema_statement()
                            .schema_create().create_rewrite_statement();

                    r.setCondition((createRewriteCtx.WHERE() != null) ? ParserAbstract.getFullCtxText(createRewriteCtx.vex()) : null);

                    for (Rewrite_commandContext cmd : createRewriteCtx.commands) {
                        r.addCommand(loader.args, ParserAbstract.getFullCtxText(cmd));
                    }

                    return createRewriteCtx;
                },
                (ctx, db) -> {
                    db.getContextsForAnalyze().add(new AbstractMap.SimpleEntry<>(r, ctx));

                    analyzeRewriteCreateStmtCtx(ctx, r, schemaName);

                    for (Rewrite_commandContext cmd : ctx.commands) {
                        analyzeRewriteCommandCtx(cmd, r, schemaName);
                    }
                });

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            r.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        return r;
    }

    public static void analyzeRewriteCreateStmtCtx(Create_rewrite_statementContext ctx, PgRule rule,
            String schemaName) {
        if (ctx.WHERE() != null) {
            VexContext exp = ctx.vex();
            ValueExprWithNmspc vex = new ValueExprWithNmspc(schemaName);
            vex.addReference("new", null);
            vex.addReference("old", null);
            vex.analyze(new Vex(exp));
            rule.addAllDeps(vex.getDepcies());
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void analyzeRewriteCommandCtx(Rewrite_commandContext cmd, PgRule rule,
            String schemaName) {
        ParserRuleContext parser = null;
        AbstractExprWithNmspc analyzer = null;
        if ((parser = cmd.select_stmt()) != null) {
            analyzer = new Select(schemaName);
        } else if ((parser = cmd.insert_stmt_for_psql()) != null) {
            analyzer = new Insert(schemaName);
        } else if ((parser = cmd.delete_stmt_for_psql()) != null) {
            analyzer = new Delete(schemaName);
        } else if ((parser = cmd.update_stmt_for_psql()) != null) {
            analyzer = new Update(schemaName);
        }
        if (parser != null && analyzer != null) {
            analyzer.addReference("new", null);
            analyzer.addReference("old", null);
            UtilExpr.analyze(parser, analyzer, rule);
        }
    }
}
