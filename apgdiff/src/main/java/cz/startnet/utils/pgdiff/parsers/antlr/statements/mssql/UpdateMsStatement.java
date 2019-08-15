package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Update_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class UpdateMsStatement extends ParserAbstract {

    private final Update_statementContext ctx;

    public UpdateMsStatement(Update_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Qualified_nameContext qname = ctx.qualified_name();
        if (qname != null) {
            PgObjLocation loc = addObjReference(Arrays.asList(qname.schema, qname.name),
                    DbObjType.TABLE, StatementActions.UPDATE);
            loc.setWarning(DangerStatement.UPDATE);
        }
    }

    @Override
    protected void fillQueryLocation(String fullScript) {
        String query = ParserAbstract.getFullCtxText(ctx);
        QueryLocation loc = new QueryLocation(getStmtAction(query),
                fullScript.indexOf(query), ctx.getStart().getLine(), query);
        loc.setWarning(DangerStatement.UPDATE);
        db.addToBatch(loc);
    }
}
