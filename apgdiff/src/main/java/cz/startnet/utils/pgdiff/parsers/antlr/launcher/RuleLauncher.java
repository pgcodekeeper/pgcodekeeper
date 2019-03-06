package cz.startnet.utils.pgdiff.parsers.antlr.launcher;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.AbstractExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Delete;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Insert;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Update;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * {@link AbstractAnalysisLauncher}
 */
public class RuleLauncher extends AbstractAnalysisLauncher {

    public RuleLauncher(PgStatementWithSearchPath stmt, PgDatabase db,
            List<AntlrError> errors) {
        super(stmt, db, errors);
    }

    @Override
    public void analyzeOneCtx(ParserRuleContext ctx, String schemaName) {
        analyzeRulesCreate((Create_rewrite_statementContext) ctx, (PgRule) stmt,
                schemaName, db);
    }

    private void analyzeRulesCreate(Create_rewrite_statementContext createRewriteCtx,
            PgRule rule, String schemaName, PgDatabase db) {
        analyzeRulesWhere(createRewriteCtx, rule, schemaName, db);
        for (Rewrite_commandContext cmd : createRewriteCtx.commands) {
            analyzeRulesCommand(cmd, rule, schemaName, db);
        }
    }

    private void analyzeRulesWhere(Create_rewrite_statementContext ctx, PgRule rule,
            String schemaName, PgDatabase db) {
        if (ctx.WHERE() != null) {
            ValueExprWithNmspc vex = new ValueExprWithNmspc(db);
            GenericColumn implicitTable = new GenericColumn(schemaName,
                    rule.getParent().getName(), DbObjType.TABLE);
            vex.addReference("new", implicitTable);
            vex.addReference("old", implicitTable);
            analyze(ctx.vex(), vex, rule);
        }
    }

    private void analyzeRulesCommand(Rewrite_commandContext cmd, PgRule rule,
            String schemaName, PgDatabase db) {
        Select_stmtContext select;
        Insert_stmt_for_psqlContext insert;
        Delete_stmt_for_psqlContext delete;
        Update_stmt_for_psqlContext update;
        if ((select = cmd.select_stmt()) != null) {
            analyzeRule(select, new Select(db), rule, schemaName);
        } else if ((insert = cmd.insert_stmt_for_psql()) != null) {
            analyzeRule(insert, new Insert(db), rule, schemaName);
        } else if ((delete = cmd.delete_stmt_for_psql()) != null) {
            analyzeRule(delete, new Delete(db), rule, schemaName);
        } else if ((update = cmd.update_stmt_for_psql()) != null) {
            analyzeRule(update, new Update(db), rule, schemaName);
        }
    }

    private <T extends ParserRuleContext> void analyzeRule(
            T ctx, AbstractExprWithNmspc<T> analyzer, PgRule rule, String schemaName) {
        GenericColumn implicitTable = new GenericColumn(schemaName,
                rule.getParent().getName(), DbObjType.TABLE);
        analyzer.addReference("new", implicitTable);
        analyzer.addReference("old", implicitTable);
        analyze(ctx, analyzer, rule);
    }
}
