package cz.startnet.utils.pgdiff.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.apgdiff.Log;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSelect;

public final class SelectParser {
    
    private static final String[] CLAUSES = {
        "FROM", "WHERE", "GROUP", "HAVING", "WINDOW",
        "UNION", "INTERSECT", "EXCEPT",
        "LIMIT", "OFFSET", "FETCH", "FOR"
    };
    
    private static final String[] JOIN_WORDS = {
        "NATURAL",
        "INNER",
        "LEFT", "RIGHT", "FULL",
        "CROSS", 
        "JOIN"
    };
    
    /**
     * Parses select column into groups: schema, table, column, alias.<br>
     * Expected format:
     * <code>[ [ <i><b>schema</i></b> . ] <i><b>table</i></b> . ] <i><b>column</i></b> [ [ AS ] <i><b>alias</i></b> ]</code>
     * <br><br>
     * 
     * Quoted identifiers are supported except for ones with escaped (doubled) double quotes.
     */
    public final static Pattern VALID_SELECT_COLUMN = Pattern.compile(
            "^(?:(?<schema>[\\w&&[^0-9]]\\w*|\"[^\"]+\")\\s*\\.\\s*)??"
            + "(?:(?<table>[\\w&&[^0-9]]\\w*|\"[^\"]+\")\\s*\\.\\s*)?"
            + "(?:(?<column>[\\w&&[^0-9]]\\w*|\"[^\"]+\"))"
            + "(?:\\s+(?:as\\s+)?" + "(?<alias>[\\w&&[^0-9]]\\w*|\"[^\"]+\"))?$",
            Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
    
    // capturing groups' IDs for the column regex
    public final static String GRP_SCHEMA = "schema";
    public final static String GRP_TABLE = "table";
    public final static String GRP_COLUMN = "column";
    public final static String GRP_ALIAS = "alias";
    
    public static PgSelect parse(PgDatabase db, String statement, String searchPath) {
        return new SelectParser(db, statement, searchPath).parseSelect(statement);
    }
    
    // below is the non-static part of the class
    
    /**
     * Object that will accumulate info about our statement.
     */
    private final PgSelect select;
    
    private final PgDatabase db;

    private SelectParser(PgDatabase db, String statement, String searchPath) {
        this.select = new PgSelect(statement, searchPath);
        this.db = db;
    }
    
    private PgSelect parseSelect(String statement) {
        try {
            parseSelectRecursive(statement);
        } catch (ParserException ex) {
            Log.log(ex);
        } catch (Exception ex) {
            Log.log(Log.LOG_DEBUG,
                    "Exception while trying to parse following SELECT statement\n"
                            + statement, ex);
        }
        
        // return at least what we were able to parse
        return select;
    }
    
    /**
     * Opened parentheses counter.
     * We need this to be a member variable due to recursive nature of the parser. 
     */
    private int parens;
    
    private void parseSelectRecursive(String statement) {
        final List<GenericColumn> columns = new ArrayList<>(10);
        final Map<String, String> tableAliases = new HashMap<>();
        
        Parser p = new Parser(statement);
        do {
            columns.clear();
            tableAliases.clear();
            
            while (p.expectOptional("(")) {
                ++parens;
            }
            
            p.expect("SELECT");
            do {
                String column = p.getExpression(CLAUSES);
                Matcher m = VALID_SELECT_COLUMN.matcher(column);
                
                if (m.matches()) {
                    columns.add(new GenericColumn(m.group(GRP_SCHEMA),
                            m.group(GRP_TABLE), m.group(GRP_COLUMN)));
                } else {
                    Log.log(Log.LOG_DEBUG, "SELECT column didn't match the pattern:\n"
                            + column);
                }
            } while (p.expectOptional(","));
            
            if (p.expectOptional("FROM")) {
                do {
                    String withoutParens = removeExcessParens(
                            new StringBuilder(p.getExpression(CLAUSES)), 0, 0, 0, new ArrayList<Integer>()).toString();
                    from(new Parser(withoutParens), tableAliases, columns);
                } while (p.expectOptional(","));
                resolveAliases(columns, tableAliases);
            }
            
            if (p.expectOptional("WHERE")) {
                p.getExpression(SelectParser.CLAUSES);
            }
            
            if (p.expectOptional("GROUP", "BY")) {
                do {
                    p.getExpression(SelectParser.CLAUSES);
                } while (p.expectOptional(","));
            }
            
            if (p.expectOptional("HAVING")) {
                do {
                    p.getExpression(SelectParser.CLAUSES);
                } while (p.expectOptional(","));
            }

            while (parens > 0 && p.expectOptional(")")) {
                --parens;
            }
            
            while (p.expectOptionalOneOf("UNION", "INTERSECT", "EXCEPT") != null) {
                p.expectOptionalOneOf("ALL", "DISTINCT");
                
                parseSelectRecursive(p.getRest());
            }
        } while (parens > 0);
    }
    
    /**
     * Resolve aliased columns and add them to accumulating object
     */
    private void resolveAliases(List<GenericColumn> columns, Map<String, String> tableAliases){
        for (GenericColumn column : columns) {
            if (column.schema == null && column.table != null) {
                String unaliased = tableAliases.get(column.table);
                if (unaliased != null) {
                    column = new GenericColumn(
                            ParserUtils.getSchemaName(unaliased, db),
                            ParserUtils.getObjectName(unaliased),
                            column.column);
                }
            }
            select.addColumn(column);
        }
    }
    
    /**
     * Replaces excessive (non-needed) parentheses in FROM query by spaces.
     * Leaves parens around SELECT query intact, as it is expected to be wrapped
     * Leaves single-quoted parens intact
     * 
     * @param sb    Initial query string
     * @param subselectStartsAt 
     * @return      Query string with excessive parens replaced by spaces
     */
    private StringBuilder removeExcessParens(StringBuilder sb, int startIndex, 
            int parensCount, int subselectCounter, List<Integer> subselectStartsAt) {
        for(int j = startIndex; j < sb.length(); j++){
            if (sb.charAt(j) == '('){
                parensCount++;
                String next = sb.substring(j + 1).trim();
                if (next.startsWith("SELECT ")){
                    subselectCounter++;
                    subselectStartsAt.add(parensCount);
                    removeExcessParens(sb, j + 1, parensCount, subselectCounter, subselectStartsAt);
                    break;
                }else{
                    sb.setCharAt(j, ' ');
                }
            }else if (sb.charAt(j) == ')'){
                if (subselectCounter > 0){
                    if (subselectStartsAt.contains(parensCount)){
                        subselectStartsAt.remove(subselectStartsAt.indexOf(parensCount));
                        parensCount--;
                        subselectCounter--;
                    }else if (subselectCounter < parensCount){
                        parensCount--;
                        sb.setCharAt(j, ' ');
                    }else{
                        subselectCounter--;
                        parensCount--;
                    }
                }else{
                    parensCount--;
                    sb.setCharAt(j, ' ');
                }
            }else if (sb.charAt(j) == '\''){
                int nextQuoteIndex = sb.toString().indexOf('\'', j + 1);
                removeExcessParens(sb, nextQuoteIndex + 1, parensCount, subselectCounter, subselectStartsAt);
                break;
            }
        }
        return sb;
    }
    
    private int getClosingParenthesisIndex(CharSequence part, int openingIndex){
        int parensCount = 0;
        for (int i = openingIndex + 1; i < part.length(); i++){
            if (part.charAt(i) == '('){
                parensCount++;
            }else if (part.charAt(i) == ')'){
                parensCount--;
            }
            if (parensCount == -1){
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
    
    private void from(Parser pf, Map<String, String> tableAliases, List<GenericColumn> outerSelectColumns) {
        pf.expectOptional("LATERAL");
        String joinOp = null;
        /*
         * If subselect is present in the first place
         * 
         * From PostgreSQL 9.3.4 Documentation:
         *     A sub-SELECT can appear in the FROM clause. This acts as though its 
         *     output were created as a temporary table for the duration of this 
         *     single SELECT command. Note that the sub-SELECT must be surrounded 
         *     by parentheses, and an alias must be provided for it. 
         *     A VALUES command can also be used here.
         */
        if (pf.expectOptional("(")) { // subselect
            int start = pf.getPosition();
            int end = getClosingParenthesisIndex(pf.getString(), start);
            
            // pf.expect("SELECT"); unnecessary, done in parseSelectRecursive()
            // parse subselect recursively as usually
            parseSelectRecursive(pf.getSubString(start, end));
            
            // skip subselect enclosement to its alias (which is REQUIRED) 
            pf.setPosition(end + 1);
            pf.skipWhitespace();
            pf.expectOptional("AS");
            String alias = pf.parseIdentifier();
            
            // If external SELECT selects columns from subselect,
            // remove them from external select columns list as they are already
            // dealiased and added to PgSelect when subselect is parsed
            Iterator<GenericColumn> it = outerSelectColumns.iterator();
            while (it.hasNext()) {
                GenericColumn c = it.next();
                if (c.schema == null && alias.equals(c.table)) {
                    it.remove();
                }
            }
            
            joinCondition(pf);
        } else {
            pf.expectOptional("ONLY");
            
            String table = pf.parseIdentifier();
            pf.expectOptional("*");
            
            if (!joinCondition(pf)) {
                boolean as = pf.expectOptional("AS");
                if (!as) {
                    joinOp = pf.expectOptionalOneOf(SelectParser.JOIN_WORDS);
                    if (joinOp != null || pf.isConsumed()) {
                        tableAliases.put(table, table);
                        // simple cross-schema selects are normalized by pg_dump to the following
                        // SELECT t1.c1 FROM s1.t1;
                        // thus an alias t1 = s1.t1 is required
                        tableAliases.put(ParserUtils.getObjectName(table), table);
                        
                        // FIXME данный код не детектит случай JOIN table ON | USING ...
                        // данная ветка - для обработки отсутствующего джойн кондишена
                        // isConsumed() тоже здесь толком не работает
                    }
                }
                if (as || (joinOp == null && !pf.isConsumed())) {
                    tableAliases.put(pf.parseIdentifier(), table);
                    
                    joinCondition(pf);
                }
            }
        }
        
        boolean join = joinOp != null;

        join |= pf.expectOptional("NATURAL");
        join |= pf.expectOptional("INNER");
        join |= pf.expectOptional("LEFT");
        join |= pf.expectOptional("RIGHT");
        join |= pf.expectOptional("FULL");
        join |= pf.expectOptional("OUTER");
        join |= pf.expectOptional("CROSS");
        join |= pf.expectOptional("JOIN");
        
        if (join) {
            from(pf, tableAliases, outerSelectColumns);
        }
        
        joinCondition(pf);
    }
    
    private boolean joinCondition(Parser pf) {
        if (pf.expectOptional("ON")) {
            pf.getExpression(SelectParser.JOIN_WORDS);
            return true;
        }
        if (pf.expectOptional("USING")) {
            pf.expect("(");
            do {
                pf.getExpression();
            } while (pf.expectOptional(","));
            pf.expect(")");
            
            return true;
        }
        
        return false;
    }
}
