package cz.startnet.utils.pgdiff;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.startnet.utils.pgdiff.PgDiffStatement.DiffStatementType;
import cz.startnet.utils.pgdiff.parsers.antlr.DangerStatementParser;
import cz.startnet.utils.pgdiff.schema.PgStatement;

/**
 * Contains list of SQL statements.<br>
 * A set is used to ensure that {@link #addStatementUnique(String)} does not
 * add multiple entries.
 *
 * @author Alexander Levsha
 */
public class PgDiffScript {

    private final List<PgDiffStatement> statements = new ArrayList<>();

    // this is faster because HashSet.contains() is O(1)
    // List.contains() is O(n)
    // also String caches hashcodes, so that's a minor performance plus
    private final Set<PgDiffStatement> unique = new HashSet<>();

    public boolean isDangerDdl(boolean ignoreDropCol, boolean ignoreAlterCol,
            boolean ignoreDropTable, boolean ignoreRestartWith,
            boolean ignoreUpdate, boolean isMsSql) {
        return !findDangers(DangerStatement.getAllowedDanger(ignoreDropCol, ignoreAlterCol,
                ignoreDropTable, ignoreRestartWith, ignoreUpdate), isMsSql).isEmpty();
    }

    public Set<DangerStatement> findDangers(Collection<DangerStatement> allowedDangers,
            boolean isMsSql) {
        if (allowedDangers.containsAll(EnumSet.allOf(DangerStatement.class))) {
            return Collections.emptySet();
        }

        DangerStatementParser parser = new DangerStatementParser();
        for (PgDiffStatement st : statements) {
            parser.checkDanger(st.statement, isMsSql);
        }

        Set<DangerStatement> dangerTypes = parser.getDangerStatements();
        dangerTypes.removeAll(allowedDangers);

        return dangerTypes;
    }

    public void addStatement(String statement) {
        PgDiffStatement st = new PgDiffStatement(DiffStatementType.OTHER, null, statement.trim());
        PgDiffStatement last = statements.isEmpty() ? null : statements.get(statements.size() - 1);
        if (statements.isEmpty() || !st.equals(last)){
            statements.add(st);
        }
    }

    public void addDrop(PgStatement obj, String comment, String statement) {
        addStatementUnique(DiffStatementType.DROP, obj, comment, statement, false);
    }

    public void addCreate(PgStatement obj, String comment, String statement,
            boolean replaceExisting) {
        addStatementUnique(DiffStatementType.CREATE, obj, comment, statement,
                replaceExisting);
    }

    /**
     * Adds statement only if it's not present in the statements list.
     */
    private void addStatementUnique(DiffStatementType type, PgStatement obj,
            String comment, String statement, boolean replaceExisting) {
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
        } else if (replaceExisting) {
            statements.set(statements.indexOf(st), st);
        }
    }

    /**
     * Prints all statements into {@link PrintWriter}.
     */
    public void printStatements(PrintWriter printer) {
        for (PgDiffStatement st : statements) {
            printer.println(st.statement.trim());
            printer.println();
        }
    }
}
