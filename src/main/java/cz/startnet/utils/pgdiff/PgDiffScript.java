package cz.startnet.utils.pgdiff;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.taximaxim.codekeeper.apgdiff.Log;

/**
 * Contains list of SQL statements.<br>
 * A set is used to ensure that {@link #addStatementUnique(String)} does not 
 * add multiple entries.
 * 
 * @author Alexander Levsha
 */
public class PgDiffScript {

    private final List<String> statements = new ArrayList<>();
    
    // this is faster because HashSet.contains() is O(1)
    // List.contains() is O(n)
    // also String caches hashcodes, so that's a minor performance plus 
    private final Set<String> unique = new HashSet<>();
    
    /**
     * Add a statement to the script.
     */
    public void addStatement(String statement) {
        statements.add(statement);
        unique.add(statement);
    }
    
    /**
     * Adds statement only if it's not present in the statements list.
     */
    public void addStatementUnique(String statement) {
        if (!unique.contains(statement)) {
            addStatement(statement);
        } else {
            // FIXME need to replace w/ new??
            // should/can we move them to the back of the list?
            // linked list?
            
            // FUCK drop/creates are not grouped after all
            
            Log.log(Log.LOG_DEBUG, "PgDiffScript: ignoring unique statement:\n"
                    + statement);
        }
    }

    /**
     * Prints all statements into {@link PrintWriter}.
     */
    public void printStatements(PrintWriter printer) {
        for (String s : statements) {
            printer.println(s);
        }
    }
}
