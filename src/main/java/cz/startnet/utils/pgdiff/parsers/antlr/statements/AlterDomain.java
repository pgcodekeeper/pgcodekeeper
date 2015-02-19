package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_def_columnContext;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class AlterDomain extends ParserAbstract {

	private Alter_domain_statementContext ctx;

	public AlterDomain(Alter_domain_statementContext ctx, PgDatabase db, Path filePath) {
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
		PgDomain domain = db.getSchema(schemaName).getDomain(name);
		if (domain == null) {
			return null;
		}
		if (ctx.owner_to() != null) {
			domain.setOwner(getFullCtxText(ctx.owner_to().name));
		}
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
