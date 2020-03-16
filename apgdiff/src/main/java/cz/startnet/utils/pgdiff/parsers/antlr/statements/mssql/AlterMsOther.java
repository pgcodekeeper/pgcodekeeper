package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Alter_sequenceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
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
        DbObjType type = null;
        List<? extends ParserRuleContext> ids = null;
        if (ctx.alter_schema_sql() != null) {
            type = DbObjType.SCHEMA;
            ids = Arrays.asList(ctx.alter_schema_sql().schema_name);
        } else if (ctx.alter_user() != null) {
            type = DbObjType.USER;
            ids = Arrays.asList(ctx.alter_user().username);
        } else if (ctx.alter_sequence() != null) {
            type = DbObjType.SEQUENCE;
            Qualified_nameContext qname = ctx.alter_sequence().qualified_name();
            ids = Arrays.asList(qname.schema, qname.name);
        }
        return type != null ? getStrForStmtAction(ACTION_ALTER, type, ids) : null;
    }
}