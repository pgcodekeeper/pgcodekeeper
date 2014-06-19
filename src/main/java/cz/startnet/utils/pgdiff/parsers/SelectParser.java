package cz.startnet.utils.pgdiff.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.apgdiff.Log;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSelect;

public class SelectParser {
    
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
            
            if (p.expectOptional("(")) {
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
                    Log.log(Log.LOG_DEBUG, "SELECT column didn't match the pattern"
                            + " while parsing statement:\n" + statement
                            + "\ncolumn:\n" + column);
                }
            } while (p.expectOptional(","));
            
            // TODO FROM SELECT вьюха public.v_i18n_resources
            // FROM JOIN тоже не парсится
            // FROM {regex}: [(]+
            if (p.expectOptional("FROM")) {
                do {
                    //Pass whole FROM statement
                    String fromQuery = p.getExpression(CLAUSES); 
                    from(new Parser(removeExcessParens(fromQuery)), tableAliases);
                } while (p.expectOptional(","));
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

            if (parens > 0 && p.expectOptional(")")) {
                --parens;
            }
            
            while (p.expectOptionalOneOf("UNION", "INTERSECT", "EXCEPT") != null) {
                p.expectOptionalOneOf("ALL", "DISTINCT");
                
                parseSelectRecursive(p.getRest());
            }
            
            // resolve aliased columns
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
                
                // and add them to the accumulating object
                select.addColumn(column);
            }
        } while (parens > 0);
    }
    
    /**
     * Replaces excessive (non-needed) parentheses in FROM query by spaces.
     * Leaves parens around SELECT query, as it is expected to be wrapped
     * 
     * @param initial Query string
     * @return Query string with excessive parens replaced by spaces
     */
    private String removeExcessParens(String initial){
        Parser p = new Parser(initial);
        StringBuilder sb = new StringBuilder(initial);
        int startIndex = 0;
        
        while(sb.substring(startIndex, sb.length()).contains("(")){
            int opening = sb.indexOf("(", startIndex);
            p = new Parser(sb.toString());
            p.setPosition(opening + 1);
            p.skipWhitespace();
            if (!p.expectOptional("SELECT")){
                int closing = getClosingParenthesisIndex(sb, opening);
                sb.setCharAt(opening, ' ');
                sb.setCharAt(closing, ' ');
            }else{
                startIndex = opening + 1;
            }
        }
        return sb.toString();
    }
    
    private int getClosingParenthesisIndex(StringBuilder part, int openingIndex){
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
    
    private void from(Parser pf, Map<String, String> tableAliases) {
        pf.expectOptional("ONLY");
        
        String table = pf.parseIdentifier();
        pf.expectOptional("*");

        String joinOp = null;
        
        if (!joinCondition(pf)) {
            boolean as = pf.expectOptional("AS");
            if (!as) {
                joinOp = pf.expectOptionalOneOf(SelectParser.JOIN_WORDS);
            }
            if (as || (joinOp == null && !pf.isConsumed())) {
                tableAliases.put(pf.parseIdentifier(), table);
                
                joinCondition(pf);
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
            from(pf, tableAliases);
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
