package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_type_statementContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgType;

public class AlterType extends ParserAbstract {

	private Alter_type_statementContext ctx;

	public AlterType(Alter_type_statementContext ctx, PgDatabase db, Path filePath) {
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
		PgType type = db.getSchema(schemaName).getType(name);
		if (type == null) {
			return null;
		}
		if (ctx.owner_to() != null) {
			type.setOwner(getFullCtxText(ctx.owner_to().name));
		}
		return type;
	}

}
