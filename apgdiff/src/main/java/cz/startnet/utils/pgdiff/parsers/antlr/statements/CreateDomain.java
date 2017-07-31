package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Domain_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgSchema;
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
        PgSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        PgDomain domain = new PgDomain(QNameParser.getFirstName(ids), getFullCtxText(ctx.getParent()));
        domain.setDataType(getFullCtxText(ctx.dat_type));
        addTypeAsDepcy(ctx.dat_type, domain, getDefSchemaName());
        for (Collate_identifierContext coll : ctx.collate_identifier()) {
            domain.setCollation(getFullCtxText(coll.collation));
        }
        VexContext exp = ctx.def_value;
        if (exp != null) {
            ValueExpr vex = new ValueExpr(schema.getName());
            vex.analyze(new Vex(exp));
            domain.addAllDeps(vex.getDepcies());
            domain.setDefaultValue(getFullCtxText(exp));
        }
        for (Domain_constraintContext constr : ctx.dom_constraint) {
            PgConstraint consta = parseDomainConstraint(constr, schema.getName());
            if (consta != null) {
                domain.addConstraint(consta);
            }
            // вынесено ограничение, т.к. мы привязываем ограничение на нул к
            // объекту а не создаем отдельный констрайнт
            if (constr.common_constraint().null_value != null) {
                domain.setNotNull(constr.common_constraint().null_false != null);
            }
        }
        schema.addDomain(domain);
        return domain;
    }
}