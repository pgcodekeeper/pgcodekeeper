package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Collate_identifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_domain_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Domain_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.DomainAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.PgConstraint;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgDomain;

public class CreateDomain extends ParserAbstract {

    private final Create_domain_statementContext ctx;
    private final CommonTokenStream stream;
    public CreateDomain(Create_domain_statementContext ctx, PgDatabase db, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.stream = stream;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgDomain domain = new PgDomain(QNameParser.getFirstName(ids));
        domain.setDataType(getTypeName(ctx.dat_type));
        addPgTypeDepcy(ctx.dat_type, domain);
        for (Collate_identifierContext coll : ctx.collate_identifier()) {
            domain.setCollation(getFullCtxText(coll.collation));
        }
        VexContext exp = ctx.def_value;
        if (exp != null) {
            db.addAnalysisLauncher(new VexAnalysisLauncher(domain, exp, fileName));
            domain.setDefaultValue(getExpressionText(exp, stream));
        }
        for (Domain_constraintContext constrCtx : ctx.dom_constraint) {
            if (constrCtx.CHECK() != null) {
                IdentifierContext name = constrCtx.name;
                AbstractConstraint constr = new PgConstraint(name != null ? name.getText() : "");
                parseDomainConstraint(domain, constr, constrCtx, db, fileName);
                domain.addConstraint(constr);
            }
            // вынесено ограничение, т.к. мы привязываем ограничение на нул к
            // объекту а не создаем отдельный констрайнт
            if (constrCtx.NULL() != null) {
                domain.setNotNull(constrCtx.NOT() != null);
            }
        }

        addSafe(getSchemaSafe(ids), domain, ids);
    }

    public static void parseDomainConstraint(PgDomain domain, AbstractConstraint constr,
            Domain_constraintContext ctx, PgDatabase db, String location) {
        VexContext vexCtx = ctx.vex();
        constr.setDefinition("CHECK (" + getFullCtxText(vexCtx) + ")");
        db.addAnalysisLauncher(new DomainAnalysisLauncher(domain, vexCtx, location));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.DOMAIN, getIdentifiers(ctx.name));
    }
}
