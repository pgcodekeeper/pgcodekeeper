package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_policy_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.User_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.IStatementContainer;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgEventType;
import cz.startnet.utils.pgdiff.schema.PgPolicy;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreatePolicy extends ParserAbstract {

    private final Create_policy_statementContext ctx;

    public CreatePolicy(Create_policy_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.schema_qualified_name().identifier();
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

        IdentifierContext parent = QNameParser.getFirstNameCtx(ids);
        IStatementContainer cont = getSafe(
                AbstractSchema::getStatementContainer, getSchemaSafe(ids), parent);
        addSafe((PgStatement) cont, policy, Arrays.asList(
                QNameParser.getSchemaNameCtx(ids), parent, ctx.identifier()));
    }

    @Override
    protected String getStmtAction() {
        List<IdentifierContext> ids = new ArrayList<>(ctx.schema_qualified_name().identifier());
        ids.add(ctx.identifier());
        return getStrForStmtAction(ACTION_CREATE, DbObjType.POLICY, ids);
    }
}