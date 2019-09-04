package cz.startnet.utils.pgdiff.loader;

import java.util.Objects;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;

/**
 * The class of the query to execute. It contains the query, information about
 * the position of the query in the parsed script and information about the
 * type of command.
 */
public class QueryLocation extends PgObjLocation {

    private static final long serialVersionUID = 7310018993032523902L;

    private final String sql;

    public QueryLocation(String action, ParserRuleContext ctx, String sql) {
        super(null, action, ctx.getStart().getStartIndex(), ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(), null);
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (obj instanceof QueryLocation) {
            return Objects.equals(sql, ((QueryLocation) obj).getSql());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return prime * super.hashCode() + (sql == null ? 0 : sql.hashCode());
    }
}
