package cz.startnet.utils.pgdiff;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import cz.startnet.utils.pgdiff.PgDiffStatement.DiffStatementType;

import ru.taximaxim.codekeeper.apgdiff.Log;

/**
 * Contains list of SQL statements.<br>
 * A set is used to ensure that {@link #addStatementUnique(String)} does not 
 * add multiple entries.
 * 
 * @author Alexander Levsha
 */
public class PgDiffScript {

    private final LinkedList<PgDiffStatement> statements = new LinkedList<>();
    
    // this is faster because HashSet.contains() is O(1)
    // List.contains() is O(n)
    // also String caches hashcodes, so that's a minor performance plus 
    private final Set<PgDiffStatement> unique = new HashSet<>();
    
    /**
     * Add a statement to the script.
     */
    public void addStatement(String statement) {
        statements.add(new PgDiffStatement(DiffStatementType.OTHER, null, statement));
    }
    
    public void addDrop(String objname, String statement) {
        addStatementUnique(DiffStatementType.DROP, objname, statement);
    }
    
    public void addCreate(String objname, String statement) {
        addStatementUnique(DiffStatementType.CREATE, objname, statement);
    }
    
    /**
     * Adds statement only if it's not present in the statements list.
     */
    private void addStatementUnique(DiffStatementType type, String objname, String statement) {
        if (type != DiffStatementType.DROP && type != DiffStatementType.CREATE) {
            throw new IllegalArgumentException(
                    "Only DROPs and CREATEs can be tracked as unique statements!");
        }
        
        PgDiffStatement st = new PgDiffStatement(type, objname, statement);
        if (!unique.contains(st)) {
            statements.add(st);
            unique.add(st);
        } else {
            Log.log(Log.LOG_DEBUG, "PgDiffScript: ignoring unique statement:\n"
                    + statement);
            
            // move duplicated CREATEs to the back of the list
            // this updates the statement to the most recent too
            if (type == DiffStatementType.CREATE) {
               statements.remove(st);
               statements.add(st);
            }
        }
    }

    /**
     * Prints all statements into {@link PrintWriter}.
     */
    public void printStatements(PrintWriter printer) {
        for (PgDiffStatement st : statements) {
            printer.println(st.statement);
        }
    }
}
