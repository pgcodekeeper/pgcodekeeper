package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Domain_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class AlterDomain extends ParserAbstract {

    private final Alter_domain_statementContext ctx;

    public AlterDomain(Alter_domain_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        PgDomain domain = getSafe(AbstractSchema::getDomain,
                getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));

        Domain_constraintContext constrCtx = ctx.dom_constraint;
        if (constrCtx != null && constrCtx.CHECK() != null) {
            IdentifierContext name = constrCtx.name;
            AbstractConstraint constr = new PgConstraint(name != null ? name.getText() : "");
            CreateDomain.parseDomainConstraint(domain, constr, constrCtx, db);
            if (ctx.not_valid != null) {
                constr.setNotValid(true);
            }
            doSafe(PgDomain::addConstraint, domain, constr);
        }

        addObjReference(ids, DbObjType.DOMAIN, StatementActions.ALTER);
    }

    @Override
    protected Pair<StatementActions, GenericColumn> fillDescrObj() {
        List<IdentifierContext> ids = ctx.name.identifier();
        return new Pair<>(StatementActions.ALTER, new GenericColumn(QNameParser.getSchemaName(ids),
                QNameParser.getFirstNameCtx(ids).getText(), DbObjType.DOMAIN));
    }
}
