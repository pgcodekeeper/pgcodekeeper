package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Domain_constraintContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateDomain extends ParserAbstract {

    private Create_domain_statementContext ctx;

    public CreateDomain(Create_domain_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.name);
        String schemaName = getSchemaName(ctx.name);
        if (schemaName == null) {
            schemaName = getDefSchemaName();
        }
        PgDomain domain = new PgDomain(name, getFullCtxText(ctx.getParent()), db.getDefSearchPath());
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
