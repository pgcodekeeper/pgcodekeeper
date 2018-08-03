package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Check_boolean_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Domain_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterDomain extends ParserAbstract {

    private final Alter_domain_statementContext ctx;

    public AlterDomain(Alter_domain_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        PgDomain domain = getSafe(schema::getDomain, QNameParser.getFirstNameCtx(ids));

        fillOwnerTo(ctx.owner_to(), domain);

        Domain_constraintContext constrCtx = ctx.dom_constraint;
        Check_boolean_expressionContext boolExpCtx;
        if (constrCtx != null
                && (boolExpCtx = constrCtx.common_constraint()
                .check_boolean_expression()) != null) {
            AbstractConstraint constr = CreateDomain.processDomainConstraintCtx(constrCtx,
                    boolExpCtx, domain, db);
            if (ctx.not_valid != null) {
                constr.setNotValid(true);
            }
            domain.addConstraint(constr);
        }
        return domain;
    }
}
