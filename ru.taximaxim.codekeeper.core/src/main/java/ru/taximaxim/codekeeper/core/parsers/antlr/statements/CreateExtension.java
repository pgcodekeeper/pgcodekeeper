package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_extension_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgExtension;

public class CreateExtension extends ParserAbstract {

    private final Create_extension_statementContext ctx;

    public CreateExtension(Create_extension_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdentifierContext nameCtx = ctx.name;
        PgExtension ext = new PgExtension(nameCtx.getText());
        IdentifierContext id = ctx.schema;
        if (id != null) {
            ext.setSchema(id.getText());
            addDepSafe(ext, Arrays.asList(id), DbObjType.SCHEMA, true);
        }

        addSafe(db, ext, Arrays.asList(nameCtx));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.EXTENSION, ctx.name);
    }
}