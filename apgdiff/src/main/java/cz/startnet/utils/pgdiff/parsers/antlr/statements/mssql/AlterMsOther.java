package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.loader.QueryLocation;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_sequenceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterMsOther extends ParserAbstract {

    private final Schema_alterContext ctx;

    public AlterMsOther(Schema_alterContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.alter_schema_sql() != null) {
            addObjReference(Arrays.asList(ctx.alter_schema_sql().schema_name),
                    DbObjType.SCHEMA, StatementActions.ALTER);
        } else if (ctx.alter_user() != null) {
            addObjReference(Arrays.asList(ctx.alter_user().username),
                    DbObjType.USER, StatementActions.ALTER);
        } else if (ctx.alter_sequence() != null) {
            alterSequence(ctx.alter_sequence());
        }
    }

    private void alterSequence(Alter_sequenceContext alter) {
        Qualified_nameContext qname = alter.qualified_name();
        PgObjLocation ref = addObjReference(Arrays.asList(qname.schema, qname.name),
                DbObjType.SEQUENCE, StatementActions.ALTER);
        if (!alter.RESTART().isEmpty()) {
            ref.setWarning(DangerStatement.RESTART_WITH);
        }
    }

    @Override
    protected void fillQueryLocation(String fullScript) {
        String query = ParserAbstract.getFullCtxText(ctx);
        QueryLocation loc = new QueryLocation(getStmtAction(query),
                fullScript.indexOf(query), ctx.getStart().getLine(), query);
        Alter_sequenceContext alterSeqCtx = ctx.alter_sequence();
        if (alterSeqCtx != null && !alterSeqCtx.RESTART().isEmpty()) {
            loc.setWarning(DangerStatement.RESTART_WITH);
        }
        db.addToBatch(loc);
    }
}