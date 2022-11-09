package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Insert_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Merge_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Rewrite_commandContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Delete;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Insert;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Merge;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Select;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Update;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.ValueExprWithNmspc;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgRule;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class RuleAnalysisLauncher extends AbstractAnalysisLauncher {

    public RuleAnalysisLauncher(PgRule stmt, Create_rewrite_statementContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        Set<PgObjLocation> depcies = new LinkedHashSet<>();

        Create_rewrite_statementContext createRewriteCtx = (Create_rewrite_statementContext) ctx;

        if (createRewriteCtx.WHERE() != null) {
            ValueExprWithNmspc vex = new ValueExprWithNmspc(meta);
            depcies.addAll(analyzeTableChild(createRewriteCtx.vex(), vex));
        }

        for (Rewrite_commandContext cmd : createRewriteCtx.rewrite_command()) {
            depcies.addAll(analyzeRulesCommand(cmd, meta));
        }

        return depcies;
    }

    private Set<PgObjLocation> analyzeRulesCommand(Rewrite_commandContext cmd, MetaContainer meta) {
        Select_stmtContext select;
        if ((select = cmd.select_stmt()) != null) {
            return analyzeTableChild(select, new Select(meta));
        }

        Insert_stmt_for_psqlContext insert;
        if ((insert = cmd.insert_stmt_for_psql()) != null) {
            return analyzeTableChild(insert, new Insert(meta));
        }

        Delete_stmt_for_psqlContext delete;
        if ((delete = cmd.delete_stmt_for_psql()) != null) {
            return analyzeTableChild(delete, new Delete(meta));
        }

        Update_stmt_for_psqlContext update;
        if ((update = cmd.update_stmt_for_psql()) != null) {
            return analyzeTableChild(update, new Update(meta));
        }

        Merge_stmt_for_psqlContext merge;
        if ((merge = cmd.merge_stmt_for_psql()) != null) {
            return analyzeTableChild(merge, new Merge(meta));
        }

        return Collections.emptySet();
    }
}
