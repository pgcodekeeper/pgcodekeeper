package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class CreateSchema extends ParserAbstract {

    private final Create_schema_statementContext ctx;
    private final CustomSQLParserListener listener;

    public CreateSchema(Create_schema_statementContext ctx, PgDatabase db,
            CustomSQLParserListener listener) {
        super(db);
        this.ctx = ctx;
        this.listener = listener;
    }

    @Override
    public PgStatement getObject() {
        String name = ctx.name.getText();
        if (name == null) {
            return null;
        }
        AbstractSchema schema = new PgSchema(name);
        IdentifierContext userName = ctx.user_name;
        if (userName != null && !db.getArguments().isIgnorePrivileges()
                && (!name.equals(ApgdiffConsts.PUBLIC) || !"postgres".equals(userName.getText()))) {
            schema.setOwner(userName.getText());
        }
        db.addSchema(schema);

        if (ctx.schema_def != null) {
            String defaultSchemaName = db.getDefaultSchema().getName();
            try {
                db.setDefaultSchema(name);
                for (StatementContext s : ctx.schema_def.statement()) {
                    listener.statement(s);
                }
            } finally {
                db.setDefaultSchema(defaultSchemaName);
            }
        }

        return schema;
    }

}
