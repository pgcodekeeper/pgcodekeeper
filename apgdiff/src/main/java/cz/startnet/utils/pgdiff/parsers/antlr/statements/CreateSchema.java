package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class CreateSchema extends ParserAbstract {

    private final Create_schema_statementContext ctx;

    public CreateSchema(Create_schema_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
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

        addSafe(db, schema, Arrays.asList(nameCtx));
    }

    @Override
    protected Pair<StatementActions, GenericColumn> fillDescrObj() {
        return new Pair<>(StatementActions.CREATE,
                new GenericColumn(ctx.name.getText(), DbObjType.SCHEMA));
    }
}
