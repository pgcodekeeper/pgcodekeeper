package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgSchema;
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
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        PgDomain domain = getSafe(schema::getDomain, QNameParser.getFirstNameCtx(ids));

        fillOwnerTo(ctx.owner_to(), domain);
        if (ctx.dom_constraint != null) {
            PgConstraint constraint = parseDomainConstraint(ctx.dom_constraint);
            if (constraint != null) {
                if (ctx.not_valid != null) {
                    constraint.setNotValid(true);
                }
                domain.addConstraint(constraint);
            }
        }
        return domain;
    }
}
