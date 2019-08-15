package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Update_stmt_for_psqlContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class UpdateStatement extends ParserAbstract {

    private final Update_stmt_for_psqlContext ctx;

    public UpdateStatement(Update_stmt_for_psqlContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.update_table_name.identifier();
        PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, StatementActions.UPDATE);
        loc.setWarning(DangerStatement.UPDATE);
    }

    @Override
    protected void fillQueryLocation(String fullScript, List<List<QueryLocation>> batches) {
        String query = ParserAbstract.getFullCtxText(ctx);
        QueryLocation loc = new QueryLocation(getStmtAction(query),
                fullScript.indexOf(query), ctx.getStart().getLine(), query);
        loc.setWarning(DangerStatement.UPDATE);
        batches.get(batches.size() - 1).add(loc);
    }
}
