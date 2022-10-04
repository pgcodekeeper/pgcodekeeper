package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;

import org.antlr.v4.runtime.tree.ParseTree;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Insert_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class InsertMsStatement extends ParserAbstract {

    private final Insert_statementContext ctx;

    public InsertMsStatement(Insert_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Qualified_nameContext qname = ctx.qualified_name();
        if (qname != null) {
            addObjReference(Arrays.asList(qname.schema, qname.name),
                    DbObjType.TABLE, ACTION_INSERT);
        }
    }

    @Override
    protected String getStmtAction() {
        ParseTree id = ctx.qualified_name();
        if (id == null) {
            id = ctx.rowset_function_limited();
        }
        if (id == null) {
            id = ctx.LOCAL_ID();
        }
        return getStrForStmtAction(ACTION_INSERT + " INTO", DbObjType.TABLE, id);
    }
}
