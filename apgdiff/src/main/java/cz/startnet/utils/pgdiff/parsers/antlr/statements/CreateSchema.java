package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
    public void parseObject() {
        IdentifierContext nameCtx = ctx.name;
        String name = nameCtx.getText();
        if (name == null) {
            return;
        }
        AbstractSchema schema = new PgSchema(name);
        IdentifierContext userName = ctx.user_name;
        if (userName != null && !db.getArguments().isIgnorePrivileges()
                && (!name.equals(ApgdiffConsts.PUBLIC) || !"postgres".equals(userName.getText()))) {
            schema.setOwner(userName.getText());
        }
        addSafe(PgDatabase::addSchema, db, schema);
        fillObjDefinition(new PgObjLocation(nameCtx.getText(), DbObjType.SCHEMA),
                nameCtx, schema);

        if (ctx.schema_def != null) {
            try {
                listener.setDefaultSchema(name);
                for (StatementContext s : ctx.schema_def.statement()) {
                    listener.statement(s);
                }
            } finally {
                listener.setDefaultSchema(null);
            }
        }
    }
}
