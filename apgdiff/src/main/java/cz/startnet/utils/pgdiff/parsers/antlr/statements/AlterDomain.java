package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
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
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgDomain domain = db.getSchema(schemaName).getDomain(name);
        if (domain == null) {
            return null;
        }
        fillOwnerTo(ctx.owner_to(), domain);
        if (ctx.dom_constraint != null) {
            PgConstraint contraint = parseDomainConstraint(ctx.dom_constraint);
            if (contraint != null) {
                if (ctx.not_valid != null) {
                    contraint.setDefinition(contraint.getDefinition()+ " NOT VALID");
                    domain.addConstrNotValid(contraint);
                } else {
                    domain.addConstraint(contraint);
                }
            }
        }
        return domain;
    }
}
