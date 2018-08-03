package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Check_boolean_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Domain_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateDomain extends ParserAbstract {

    private final Create_domain_statementContext ctx;
    public CreateDomain(Create_domain_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        PgDomain domain = new PgDomain(QNameParser.getFirstName(ids), getFullCtxText(ctx.getParent()));
        domain.setDataType(getFullCtxText(ctx.dat_type));
        addTypeAsDepcy(ctx.dat_type, domain, getDefSchemaName());
        for (Collate_identifierContext coll : ctx.collate_identifier()) {
            domain.setCollation(getFullCtxText(coll.collation));
        }
        VexContext exp = ctx.def_value;
        if (exp != null) {
            db.addContextForAnalyze(domain, exp);
            domain.setDefaultValue(getFullCtxText(exp));
        }
        for (Domain_constraintContext constrCtx : ctx.dom_constraint) {
            Check_boolean_expressionContext boolExpCtx = constrCtx.common_constraint()
                    .check_boolean_expression();
            if (boolExpCtx != null) {
                domain.addConstraint(processDomainConstraintCtx(constrCtx, boolExpCtx, domain, db));
            }
            // вынесено ограничение, т.к. мы привязываем ограничение на нул к
            // объекту а не создаем отдельный констрайнт
            if (constrCtx.common_constraint().null_value != null) {
                domain.setNotNull(constrCtx.common_constraint().null_false != null);
            }
        }
        schema.addDomain(domain);
        return domain;
    }

    public static AbstractConstraint processDomainConstraintCtx(Domain_constraintContext constrCtx,
            Check_boolean_expressionContext boolExpCtx, PgDomain domain, PgDatabase db) {
        AbstractConstraint constr = new PgConstraint(
                constrCtx.name != null ? QNameParser.getFirstName(constrCtx.name.identifier()) : "",
                        getFullCtxText(constrCtx));
        parseDomainConstraint(domain, constr, boolExpCtx, db);
        return constr;
    }

    public static void parseDomainConstraint(PgDomain domain, AbstractConstraint constr,
            Check_boolean_expressionContext boolExpCtx, PgDatabase db) {
        constr.setDefinition(getFullCtxText(boolExpCtx));
        db.addContextForAnalyze(domain, boolExpCtx.expression);
    }
}