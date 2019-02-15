package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
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
        PgDomain domain = new PgDomain(QNameParser.getFirstName(ids));
        domain.setDataType(getTypeName(ctx.dat_type));
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
            if (constrCtx.CHECK() != null) {
                IdentifierContext name = constrCtx.name;
                AbstractConstraint constr = new PgConstraint(name != null ? name.getText() : "");
                parseDomainConstraint(domain, constr, constrCtx, db);
                domain.addConstraint(constr);
            }
            // вынесено ограничение, т.к. мы привязываем ограничение на нул к
            // объекту а не создаем отдельный констрайнт
            if (constrCtx.NULL() != null) {
                domain.setNotNull(constrCtx.NOT() != null);
            }
        }
        schema.addDomain(domain);
        return domain;
    }

    public static void parseDomainConstraint(PgDomain domain, AbstractConstraint constr,
            Domain_constraintContext ctx, PgDatabase db) {
        VexContext vexCtx = ctx.vex();
        constr.setDefinition("CHECK (" + getFullCtxText(vexCtx) + ")");
        db.addContextForAnalyze(domain, vexCtx);
    }
}