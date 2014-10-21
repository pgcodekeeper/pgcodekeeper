/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;

/**
 * Diffs triggers.
 *
 * @author fordfrog
 */
public class PgDiffTriggers {

    /**
     * Outputs statements for creation of new triggers.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void createTriggers(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgTable newTable : newSchema.getTables()) {
            final PgTable oldTable;

            if (oldSchema == null) {
                oldTable = null;
            } else {
                oldTable = oldSchema.getTable(newTable.getName());
            }

            // Add new triggers
            for (final PgTrigger trigger : getNewTriggers(oldTable, newTable)) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, null, searchPathHelper, trigger);
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeCreationSql(script, null, trigger);
            }
        }
    }

    /**
     * Outputs statements for dropping triggers.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropTriggers(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgTable newTable : newSchema.getTables()) {
            final PgTable oldTable;

            if (oldSchema == null) {
                oldTable = null;
            } else {
                oldTable = oldSchema.getTable(newTable.getName());
            }

            // Drop triggers that no more exist or are modified
            for (final PgTrigger trigger :
                    getDropTriggers(oldTable, newTable)) {
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, trigger);
            }
        }
        
        // КОСТЫЛЬ
        if (oldSchema == null){
            return;
        }
        
        for (final PgTable oldTable : oldSchema.getTables()) {
            if (newSchema.getTable(oldTable.getName()) == null && !PgDiff.isFullSelection(oldTable)) {
                PgTable newTable = new PgTable(oldTable.getName(), null, null);
                for (final PgTrigger trigger : getDropTriggers(oldTable, newTable)) {
                    searchPathHelper.outputSearchPath(script);
                    PgDiff.writeDropSql(script, null, trigger);
                }
            }
        }// КОСТЫЛЬ
    }

    /**
     * Returns list of triggers that should be dropped.
     *
     * @param oldTable original table
     * @param newTable new table
     *
     * @return list of triggers that should be dropped
     */
    private static List<PgTrigger> getDropTriggers(final PgTable oldTable,
            final PgTable newTable) {
        final List<PgTrigger> list = new ArrayList<PgTrigger>();

        if (newTable != null && oldTable != null) {
            checkTrgExists(newTable, oldTable, list);
        }

        return list;
    }

    /**
     * Returns list of triggers that should be added.
     *
     * @param oldTable original table
     * @param newTable new table
     *
     * @return list of triggers that should be added
     */
    private static List<PgTrigger> getNewTriggers(final PgTable oldTable,
            final PgTable newTable) {
        final List<PgTrigger> list = new ArrayList<PgTrigger>();

        if (newTable != null) {
            if (oldTable == null) {
                list.addAll(newTable.getTriggers());
            } else {
                checkTrgExists(oldTable, newTable, list);
            }
        }

        return list;
    }

    private static void checkTrgExists(final PgTable containerToCheck,
            final PgTable containerSrc, final List<PgTrigger> list) {
        List<PgTrigger> oldTriggers = containerToCheck.getTriggers();
        for (final PgTrigger newTrigger : containerSrc.getTriggers()) {
            if (oldTriggers.isEmpty()) {
                list.add(newTrigger);
            } else {
                for (PgTrigger trig : oldTriggers) {
                    if (!trig.compareWithoutComments(newTrigger)) {
                        list.add(newTrigger);
                    }
                }
            }
        }
    }

    /**
     * Outputs statements for trigger comments that have changed.
     *
     * @param writer           writer
     * @param oldSchema        old schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void alterComments(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        for (PgTable oldTable : oldSchema.getTables()) {
            final PgTable newTable = newSchema.getTable(oldTable.getName());

            if (newTable == null) {
                continue;
            }

            for (final PgTrigger oldTrigger : oldTable.getTriggers()) {
                final PgTrigger newTrigger =
                        newTable.getTrigger(oldTrigger.getName());

                if (newTrigger == null) {
                    continue;
                }

                if (oldTrigger.getComment() == null
                        && newTrigger.getComment() != null
                        || oldTrigger.getComment() != null
                        && newTrigger.getComment() != null
                        && !oldTrigger.getComment().equals(
                        newTrigger.getComment())) {
                    searchPathHelper.outputSearchPath(script);

                    script.addStatement("COMMENT ON TRIGGER "
                            + PgDiffUtils.getQuotedName(newTrigger.getName())
                            + " ON "
                            + PgDiffUtils.getQuotedName(newTrigger.getTableName())
                            + " IS "
                            + newTrigger.getComment()
                            + ';');
                } else if (oldTrigger.getComment() != null
                        && newTrigger.getComment() == null) {
                    searchPathHelper.outputSearchPath(script);

                    script.addStatement("COMMENT ON TRIGGER "
                            + PgDiffUtils.getQuotedName(newTrigger.getName())
                            + " ON "
                            + PgDiffUtils.getQuotedName(newTrigger.getTableName())
                            + " IS NULL;");
                }
            }
        }
    }

    /**
     * Creates a new instance of PgDiffTriggers.
     */
    private PgDiffTriggers() {
    }
}
