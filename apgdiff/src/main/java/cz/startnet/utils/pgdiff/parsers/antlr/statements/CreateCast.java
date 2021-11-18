package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Cast_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_cast_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.ICast.CastContext;
import cz.startnet.utils.pgdiff.schema.PgCast;
import cz.startnet.utils.pgdiff.schema.PgCast.CastMethod;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateCast extends ParserAbstract {

    private final Create_cast_statementContext ctx;

    public CreateCast(Create_cast_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Cast_nameContext nameCtx = ctx.cast_name();
        Data_typeContext source = nameCtx.source;
        Data_typeContext target = nameCtx.target;
        PgCast cast = new PgCast(getFullCtxText(source), getFullCtxText(target));

        addPgTypeDepcy(source, cast);
        addPgTypeDepcy(target, cast);

        Schema_qualified_nameContext funcNameCtx = ctx.func_name;
        if (funcNameCtx != null) {
            cast.setMethod(CastMethod.FUNCTION);
            List<IdentifierContext> ids = funcNameCtx.identifier();
            String args = getFullCtxText(ctx.function_args());
            addDepSafe(cast, ids, DbObjType.FUNCTION, true, args);
            cast.setFunction(getFullCtxText(funcNameCtx) + args);
        } else if (ctx.INOUT() != null) {
            cast.setMethod(CastMethod.INOUT);
        }

        if (ctx.ASSIGNMENT() != null) {
            cast.setContext(CastContext.ASSIGNMENT);
        } else if (ctx.IMPLICIT() != null) {
            cast.setContext(CastContext.IMPLICIT);
        }

        addSafe(db, cast, Arrays.asList(nameCtx));
    }

    @Override
    protected String getStmtAction() {
        StringBuilder sb = new StringBuilder();
        sb.append(ACTION_CREATE).append(' ').append(DbObjType.CAST).append(" (");
        sb.append(getCastName(ctx.cast_name()));
        sb.append(')');
        return sb.toString();
    }
}