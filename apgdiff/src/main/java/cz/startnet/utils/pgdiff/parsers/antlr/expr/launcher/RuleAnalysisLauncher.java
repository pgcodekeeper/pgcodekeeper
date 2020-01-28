package cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

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
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;

public class RuleAnalysisLauncher extends AbstractAnalysisLauncher {

    public RuleAnalysisLauncher(PgRule stmt, Create_rewrite_statementContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<GenericColumn> analyze(ParserRuleContext ctx) {
        Set<GenericColumn> depcies = new LinkedHashSet<>();

        Create_rewrite_statementContext createRewriteCtx = (Create_rewrite_statementContext) ctx;

        if (createRewriteCtx.WHERE() != null) {
            ValueExprWithNmspc vex = new ValueExprWithNmspc(stmt.getDatabase());
            depcies.addAll(analyzeTableChild(createRewriteCtx.vex(), vex));
        }

        for (Rewrite_commandContext cmd : createRewriteCtx.rewrite_command()) {
            depcies.addAll(analyzeRulesCommand(cmd));
        }

        return depcies;
    }

    private Set<GenericColumn> analyzeRulesCommand(Rewrite_commandContext cmd) {
        PgDatabase db = stmt.getDatabase();
        Select_stmtContext select;
        if ((select = cmd.select_stmt()) != null) {
            return analyzeTableChild(select, new Select(db));
        }

        Insert_stmt_for_psqlContext insert;
        if ((insert = cmd.insert_stmt_for_psql()) != null) {
            return analyzeTableChild(insert, new Insert(db));
        }

        Delete_stmt_for_psqlContext delete;
        if ((delete = cmd.delete_stmt_for_psql()) != null) {
            return analyzeTableChild(delete, new Delete(db));
        }

        Update_stmt_for_psqlContext update;
        if ((update = cmd.update_stmt_for_psql()) != null) {
            return analyzeTableChild(update, new Update(db));
        }

        return Collections.emptySet();
    }
}
