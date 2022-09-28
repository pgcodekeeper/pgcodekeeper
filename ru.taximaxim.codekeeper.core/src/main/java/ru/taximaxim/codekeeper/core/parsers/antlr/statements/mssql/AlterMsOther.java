package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Alter_sequenceContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

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
                    DbObjType.SCHEMA, ACTION_ALTER);
        } else if (ctx.alter_user() != null) {
            addObjReference(Arrays.asList(ctx.alter_user().username),
                    DbObjType.USER, ACTION_ALTER);
        } else if (ctx.alter_sequence() != null) {
            alterSequence(ctx.alter_sequence());
        }
    }

    private void alterSequence(Alter_sequenceContext alter) {
        Qualified_nameContext qname = alter.qualified_name();
        PgObjLocation ref = addObjReference(Arrays.asList(qname.schema, qname.name),
                DbObjType.SEQUENCE, ACTION_ALTER);
        if (!alter.RESTART().isEmpty()) {
            ref.setWarning(DangerStatement.RESTART_WITH);
        }
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        Alter_sequenceContext alterSeqCtx = ((Schema_alterContext) ctx).alter_sequence();
        if (alterSeqCtx != null && !alterSeqCtx.RESTART().isEmpty()) {
            loc.setWarning(DangerStatement.RESTART_WITH);
        }
        return loc;
    }

    @Override
    protected String getStmtAction() {
        if (ctx.alter_schema_sql() != null) {
            return getStrForStmtAction(ACTION_ALTER, DbObjType.SCHEMA, ctx.alter_schema_sql().schema_name);
        }
        if (ctx.alter_user() != null) {
            return getStrForStmtAction(ACTION_ALTER, DbObjType.USER, ctx.alter_user().username);
        }
        if (ctx.alter_sequence() != null) {
            return getStrForStmtAction(ACTION_ALTER, DbObjType.SEQUENCE, ctx.alter_sequence().qualified_name());
        }
        return null;
    }
}