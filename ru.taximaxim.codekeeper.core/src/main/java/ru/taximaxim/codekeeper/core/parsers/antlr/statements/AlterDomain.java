package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_domain_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Domain_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgConstraint;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgDomain;

public class AlterDomain extends ParserAbstract {

    private final Alter_domain_statementContext ctx;

    public AlterDomain(Alter_domain_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgDomain domain = getSafe(AbstractSchema::getDomain,
                getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));

        Domain_constraintContext constrCtx = ctx.dom_constraint;
        if (constrCtx != null && constrCtx.CHECK() != null) {
            IdentifierContext name = constrCtx.name;
            AbstractConstraint constr = new PgConstraint(name != null ? name.getText() : "");
            CreateDomain.parseDomainConstraint(domain, constr, constrCtx, db, fileName);
            if (ctx.not_valid != null) {
                constr.setNotValid(true);
            }
            doSafe(PgDomain::addConstraint, domain, constr);
        }

        addObjReference(ids, DbObjType.DOMAIN, ACTION_ALTER);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.DOMAIN, getIdentifiers(ctx.name));
    }
}
