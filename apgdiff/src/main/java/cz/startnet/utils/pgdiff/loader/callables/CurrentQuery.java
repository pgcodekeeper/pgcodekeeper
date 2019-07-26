package cz.startnet.utils.pgdiff.loader.callables;

/**
 * The class of the query to execute. It contains the query, information about
 * the position of the query in the parsed script and information about the
 * type of command.
 */
// TODO add a common parent for this class and the classes 'PgObjLocation'
// and 'AntlrError'
public class CurrentQuery {

    private final String stmtAction;
    private final int offsetInFullTxt;
    private final int line;
    private final String sql;

    public CurrentQuery(String stmtAction, int offsetInFullTxt, int line, String sql) {
        this.stmtAction = stmtAction;
        this.offsetInFullTxt = offsetInFullTxt;
        this.line = line;
        this.sql = sql;
    }

    public String getStmtAction() {
        return stmtAction;
    }

    public int getOffsetInFullTxt() {
        return offsetInFullTxt;
    }

    public int getLine() {
        return line;
    }

    public String getSql() {
        return sql;
    }
}
