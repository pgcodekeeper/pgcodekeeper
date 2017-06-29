package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRewrite;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgRuleContainer;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class RulesReader extends JdbcReader {

    public static class RulesReaderFactory extends JdbcReaderFactory {

        public RulesReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader, int version) {
            super.fillFallbackQuery(version);
            return new RulesReader(this, loader);
        }
    }

    private RulesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet result, PgSchema schema) throws SQLException {
        String contName = result.getString(CLASS_RELNAME);
        PgRuleContainer c = schema.getRuleContainer(contName);
        if (c != null) {
            PgRule rule = getRule(result, schema.getName(), contName);
            if (rule != null) {
                c.addRule(rule);
            }
        }
    }

    private PgRule getRule(ResultSet res, String schemaName, String tableName) throws SQLException {
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

        loader.submitAntlrTask(command, p -> p.sql().statement(0).schema_statement()
                .schema_create().create_rewrite_statement(), ctx -> {
                    r.setCondition(CreateRewrite.getCondition(ctx, r, schemaName));
                    CreateRewrite.setCommands(ctx, r, loader.args, schemaName);
                });

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            r.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        return r;
    }
}
