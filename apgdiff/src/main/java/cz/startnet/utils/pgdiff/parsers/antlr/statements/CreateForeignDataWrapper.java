package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_foreign_data_wrapper_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Option_without_equalContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgForeignDataWrapper;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateForeignDataWrapper extends ParserAbstract{

    private final Create_foreign_data_wrapper_statementContext ctx;
    public CreateForeignDataWrapper(Create_foreign_data_wrapper_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {

        IdentifierContext nameCtx = ctx.name;
        PgForeignDataWrapper fDW = new PgForeignDataWrapper(nameCtx.getText());
        if (ctx.handler_func != null) {
            fDW.setHandler(getFullCtxText(ctx.handler_func));
        }
        if (ctx.validator_func != null) {
            fDW.setValidator(getFullCtxText(ctx.validator_func));
        }
        if (ctx.OPTIONS() != null) {
            for (Option_without_equalContext option :  ctx.option_without_equal()) {
                fDW.addOption(option.identifier().getText(), option.Character_String_Literal().getText());
            }
        }
        addSafe(db, fDW, Arrays.asList(nameCtx));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FOREIGN_DATA_WRAPPER, ctx.name);
    }

}
