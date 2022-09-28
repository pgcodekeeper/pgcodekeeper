package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Update_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

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
                    DbObjType.TABLE, ACTION_UPDATE);
            loc.setWarning(DangerStatement.UPDATE);
        }
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        loc.setWarning(DangerStatement.UPDATE);
        return loc;
    }

    @Override
    protected String getStmtAction() {
        ParseTree id = ctx.qualified_name();
        if (id == null) {
            id = ctx.rowset_function_limited();
        }
        if (id == null) {
            id = ctx.LOCAL_ID(0);
        }
        return getStrForStmtAction(ACTION_UPDATE, DbObjType.TABLE, id);
    }
}
