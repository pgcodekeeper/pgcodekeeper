package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class UpdateStatement extends ParserAbstract {

    private final Update_stmt_for_psqlContext ctx;

    public UpdateStatement(Update_stmt_for_psqlContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.update_table_name);
        PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, ACTION_UPDATE);
        loc.setWarning(DangerStatement.UPDATE);
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        loc.setWarning(DangerStatement.UPDATE);
        return loc;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_UPDATE, DbObjType.TABLE, getIdentifiers(ctx.update_table_name));
    }
}
