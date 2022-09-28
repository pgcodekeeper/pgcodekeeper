package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_policy_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.User_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgEventType;
import ru.taximaxim.codekeeper.core.schema.PgPolicy;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;

public class CreatePolicy extends ParserAbstract {

    private final Create_policy_statementContext ctx;

    public CreatePolicy(Create_policy_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.schema_qualified_name());
        addObjReference(ids, DbObjType.TABLE, null);

        PgPolicy policy = new PgPolicy(ctx.identifier().getText());

        policy.setPermissive(ctx.RESTRICTIVE() == null);

        if (ctx.FOR() != null && ctx.ALL() == null) {
            policy.setEvent(PgEventType.valueOf(ctx.event.getText().toUpperCase(Locale.ROOT)));
        }

        for (User_nameContext role : ctx.user_name()) {
            policy.addRole(getFullCtxText(role));
        }

        VexContext vex = ctx.using;
        if (vex != null) {
            policy.setUsing(getFullCtxText(vex));
            db.addAnalysisLauncher(new VexAnalysisLauncher(policy, vex, fileName));
        }

        vex = ctx.check;
        if (vex != null) {
            policy.setCheck(getFullCtxText(vex));
            db.addAnalysisLauncher(new VexAnalysisLauncher(policy, vex, fileName));
        }

        ParserRuleContext parent = QNameParser.getFirstNameCtx(ids);
        PgStatementContainer cont = getSafe(
                AbstractSchema::getStatementContainer, getSchemaSafe(ids), parent);
        addSafe(cont, policy, Arrays.asList(QNameParser.getSchemaNameCtx(ids), parent, ctx.identifier()));
    }

    @Override
    protected String getStmtAction() {
        List<ParserRuleContext> ids = new ArrayList<>(getIdentifiers(ctx.schema_qualified_name()));
        ids.add(ctx.identifier());
        return getStrForStmtAction(ACTION_CREATE, DbObjType.POLICY, ids);
    }
}