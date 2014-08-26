package cz.startnet.utils.pgdiff;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import ru.taximaxim.codekeeper.apgdiff.Log;
import cz.startnet.utils.pgdiff.PgDiffStatement.DiffStatementType;
import cz.startnet.utils.pgdiff.schema.PgStatement;

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
        PgDiffStatement st = new PgDiffStatement(DiffStatementType.OTHER, null, statement);
        if (statements.isEmpty() || !st.equals(statements.getLast())){
            statements.add(st);
        }
    }
    
    public void addDrop(PgStatement obj, String comment, String statement) {
        addStatementUnique(DiffStatementType.DROP, obj, comment, statement);
    }
    
    public void addCreate(PgStatement obj, String comment, String statement) {
        addStatementUnique(DiffStatementType.CREATE, obj, comment, statement);
    }
    
    /**
     * Adds statement only if it's not present in the statements list.
     */
    private void addStatementUnique(DiffStatementType type, PgStatement obj, String comment, String statement) {
        if (type != DiffStatementType.DROP && type != DiffStatementType.CREATE) {
            throw new IllegalArgumentException(
                    "Only DROPs and CREATEs can be tracked as unique statements!");
        }
        
        PgDiffStatement st = new PgDiffStatement(type, obj, statement);
        if (!unique.contains(st)) {
            if (comment != null){
                addStatement(comment);
            }
            statements.add(st);
            unique.add(st);
        } else {
            Log.log(Log.LOG_DEBUG, "PgDiffScript: ignoring unique statement:\n"
                    + statement);
            
            // move duplicated CREATEs to the back of the list
            // this updates the statement to the most recent too
            if (type == DiffStatementType.CREATE) {
                statements.set(statements.indexOf(st), st);
            }
        }
    }

    /**
     * Prints all statements into {@link PrintWriter}.
     */
    public void printStatements(PrintWriter printer) {
        for (PgDiffStatement st : statements) {
            printer.println(st.statement);
            printer.println();
        }
    }
}
