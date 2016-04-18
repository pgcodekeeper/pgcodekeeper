package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Domain_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
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
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        PgDomain domain = new PgDomain(name, getFullCtxText(ctx.getParent()));
        domain.setDataType(getFullCtxText(ctx.dat_type));
        for (Collate_identifierContext coll : ctx.collate_identifier()) {
            domain.setCollation(getFullCtxText(coll.collation));
        }
        if (ctx.def_value != null) {
            domain.setDefaultValue(getFullCtxText(ctx.def_value));
        }
        for (Domain_constraintContext constr : ctx.dom_constraint) {
            PgConstraint consta = parseDomainConstraint(constr);
            if (consta != null) {
                domain.addConstraint(consta);
            }
            // вынесено ограничение, т.к. мы привязываем ограничение на нул к
            // объекту а не создаем отдельный констрайнт
            if (constr.common_constraint().null_value != null) {
                domain.setNotNull(constr.common_constraint().null_false != null);
            }
        }
        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "DOMAIN", name);
            return null;
        }
        db.getSchema(schemaName).addDomain(domain);
        return domain;
    }
}
