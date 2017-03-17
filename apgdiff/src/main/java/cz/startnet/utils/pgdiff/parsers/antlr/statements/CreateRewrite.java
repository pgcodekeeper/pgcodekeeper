package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Delete;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Insert;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Update;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilExpr;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgRuleContainer;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class CreateRewrite extends ParserAbstract {
    private final Create_rewrite_statementContext ctx;

    public CreateRewrite(Create_rewrite_statementContext ctx, PgDatabase db,
            List<AntlrError> errors) {
        super(db, errors);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgRule rule = new PgRule(name, getFullCtxText(ctx.getParent()));
        rule.setEvent(PgRuleEventType.valueOf(ctx.event.getText()));
        rule.setCondition(getCondition(ctx));
        if (ctx.INSTEAD() != null){
            rule.setInstead(true);
        }
        setCommands(ctx, rule, db.getArguments(), schemaName);

        PgSchema schema = db.getSchema(schemaName);
        String targetName = ctx.table_name.getText();
        PgRuleContainer c = schema.getRuleContainer(targetName);
        if (c != null){
            c.addRule(rule);
        } else {
            Log.log(Log.LOG_ERROR, "Rule " + rule.getName() +
                    " is missing its container " + targetName +
                    " in schema " + schemaName);
        }
        return rule;
    }

    public static String getCondition(Create_rewrite_statementContext ctx) {
        return ctx.WHERE() == null ? null : getFullCtxText(ctx.vex());
    }

    public static void setCommands(Create_rewrite_statementContext ctx, PgRule rule,
            PgDiffArguments args, String schemaName) {
        for (Rewrite_commandContext cmd : ctx.commands) {
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
            rule.addCommand(args, getFullCtxText(cmd));
        }
    }
}