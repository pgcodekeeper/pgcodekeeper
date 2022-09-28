package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Create_schemaContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.MsSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class CreateMsSchema extends ParserAbstract {

    private final Create_schemaContext ctx;

    public CreateMsSchema(Create_schemaContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.schema_name;
        AbstractSchema schema = new MsSchema(nameCtx.getText());
        if (ctx.owner_name != null && !db.getArguments().isIgnorePrivileges()) {
            schema.setOwner(ctx.owner_name.getText());
        }

        addSafe(db, schema, Arrays.asList(nameCtx));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.SCHEMA, ctx.schema_name);
    }
}
