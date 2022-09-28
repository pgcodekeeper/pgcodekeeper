package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_foreign_data_wrapper_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Foreign_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgForeignDataWrapper;

public class CreateFdw extends ParserAbstract {

    public static final String VALIDATOR_SIGNATURE  = "(text[], oid)";
    public static final String HANDLER_SIGNATURE  = "()";

    private final Create_foreign_data_wrapper_statementContext ctx;

    public CreateFdw(Create_foreign_data_wrapper_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdentifierContext nameCtx = ctx.name;
        PgForeignDataWrapper fDW = new PgForeignDataWrapper(nameCtx.getText());
        if (ctx.handler_func != null) {
            fDW.setHandler(getFullCtxText(ctx.handler_func));
            addDepSafe(fDW, getIdentifiers(ctx.handler_func), DbObjType.FUNCTION, true, HANDLER_SIGNATURE);
        }
        if (ctx.validator_func != null) {
            fDW.setValidator(getFullCtxText(ctx.validator_func));
            addDepSafe(fDW, getIdentifiers(ctx.validator_func), DbObjType.FUNCTION, true, VALIDATOR_SIGNATURE);
        }
        Define_foreign_optionsContext options = ctx.define_foreign_options();
        if (options!= null) {
            for (Foreign_optionContext option : options.foreign_option()) {
                fillOptionParams(option.character_string().getText(), option.col_label().getText(), false,fDW::addOption);
            }
        }
        addSafe(db, fDW, Arrays.asList(nameCtx));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FOREIGN_DATA_WRAPPER, ctx.name);
    }
}