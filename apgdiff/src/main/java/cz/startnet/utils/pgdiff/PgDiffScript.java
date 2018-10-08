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
            boolean ignoreDropTable, boolean ignoreRestartWith, boolean ignoreUpdate) {
        Set<DangerStatement> allowedDangers = EnumSet.noneOf(DangerStatement.class);
        if (ignoreDropCol) {
            allowedDangers.add(DangerStatement.DROP_COLUMN);
        }
        if (ignoreAlterCol) {
            allowedDangers.add(DangerStatement.ALTER_COLUMN);
        }
        if (ignoreDropTable) {
            allowedDangers.add(DangerStatement.DROP_TABLE);
        }
        if (ignoreRestartWith) {
            allowedDangers.add(DangerStatement.RESTART_WITH);
        }
        if (ignoreUpdate) {
            allowedDangers.add(DangerStatement.UPDATE);
        }

        return !findDangers(allowedDangers).isEmpty();
    }

    public Set<DangerStatement> findDangers(Collection<DangerStatement> allowedDangers) {
        Set<DangerStatement> allDangers = EnumSet.allOf(DangerStatement.class);
        if (allowedDangers.containsAll(allDangers)) {
            return Collections.emptySet();
        }

        Set<DangerStatement> dangerTypes = EnumSet.noneOf(DangerStatement.class);
        for (PgDiffStatement st : statements) {
            for (DangerStatement d : allDangers) {
                if (!allowedDangers.contains(d) && st.isDangerStatement(d)) {
                    dangerTypes.add(d);
                }
            }
        }
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
        } else {
            if (replaceExisting) {
                statements.set(statements.indexOf(st), st);
            }
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
