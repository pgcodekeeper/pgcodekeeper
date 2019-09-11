package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Delete;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Insert;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Update;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;

public class RuleAnalysisLauncher extends AbstractAnalysisLauncher {

    public RuleAnalysisLauncher(PgRule stmt, Create_rewrite_statementContext ctx) {
        super(stmt, ctx);
    }

    @Override
    public void analyze(ParserRuleContext ctx) {
        Create_rewrite_statementContext createRewriteCtx = (Create_rewrite_statementContext) ctx;

        if (createRewriteCtx.WHERE() != null) {
            ValueExprWithNmspc vex = new ValueExprWithNmspc(stmt.getDatabase());
            analyzeTableChild(createRewriteCtx.vex(), vex);
        }

        for (Rewrite_commandContext cmd : createRewriteCtx.commands) {
            analyzeRulesCommand(cmd);
        }
    }

    private void analyzeRulesCommand(Rewrite_commandContext cmd) {
        PgDatabase db = stmt.getDatabase();
        Select_stmtContext select;
        Insert_stmt_for_psqlContext insert;
        Delete_stmt_for_psqlContext delete;
        Update_stmt_for_psqlContext update;
        if ((select = cmd.select_stmt()) != null) {
            analyzeTableChild(select, new Select(db));
        } else if ((insert = cmd.insert_stmt_for_psql()) != null) {
            analyzeTableChild(insert, new Insert(db));
        } else if ((delete = cmd.delete_stmt_for_psql()) != null) {
            analyzeTableChild(delete, new Delete(db));
        } else if ((update = cmd.update_stmt_for_psql()) != null) {
            analyzeTableChild(update, new Update(db));
        }
    }
}
