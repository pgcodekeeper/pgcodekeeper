package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Insert_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
        Qualified_nameContext qname = ctx.qualified_name();
        return getStrForStmtAction(
                new StringBuilder(ACTION_INSERT).append(' ').append("INTO").toString(),
                DbObjType.TABLE, Arrays.asList(qname.schema, qname.name));
    }
}
