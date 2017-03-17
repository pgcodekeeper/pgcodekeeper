package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterDomain extends ParserAbstract {

    private final Alter_domain_statementContext ctx;

    public AlterDomain(Alter_domain_statementContext ctx, PgDatabase db,
            List<AntlrError> errors) {
        super(db, errors);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgDomain domain = db.getSchema(schemaName).getDomain(name);
        if (domain == null) {
            logError("DOMAIN", schemaName, ctx.getStart());
            return null;
        }
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
