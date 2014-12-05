/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.util.Objects;

import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;

/**
 * Diffs sequences.
 *
 * @author fordfrog
 */
public final class PgDiffSequences {

    /**
     * Outputs statements for creation of new sequences.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void createSequences(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgSequence sequence : newSchema.getSequences()) {
            if (oldSchema == null
                    || !oldSchema.containsSequence(sequence.getName())) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, null, searchPathHelper, sequence);
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeCreationSql(script, null, sequence);
            }
        }
    }

    /**
     * Outputs statements for altering of new sequences.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void alterCreatedSequences(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        // Alter created sequences
        for (final PgSequence sequence : newSchema.getSequences()) {
            if ((oldSchema == null
                    || !oldSchema.containsSequence(sequence.getName()))
                    && sequence.getOwnedBy() != null
                    && !sequence.getOwnedBy().isEmpty()) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(sequence.getOwnedBySQL());
            }
        }
    }

    /**
     * Outputs statements for dropping of sequences that do not exist anymore.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropSequences(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        // Drop sequences that do not exist in new schema
        for (final PgSequence sequence : oldSchema.getSequences()) {
            if (!newSchema.containsSequence(sequence.getName())) {
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, sequence);
            }
        }
    }

    /**
     * Outputs statement for modified sequences.
     *
     * @param writer           writer the output should be written to
     * @param arguments        object containing arguments settings
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void alterSequences(final PgDiffScript script,
            final PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        final StringBuilder sbSQL = new StringBuilder();

        for (final PgSequence newSequence : newSchema.getSequences()) {
            final PgSequence oldSequence =
                    oldSchema.getSequence(newSequence.getName());

            if (oldSequence == null) {
                continue;
            }

            sbSQL.setLength(0);

            final String oldIncrement = oldSequence.getIncrement();
            final String newIncrement = newSequence.getIncrement();

            if (newIncrement != null
                    && !newIncrement.equals(oldIncrement)) {
                sbSQL.append("\n\tINCREMENT BY ");
                sbSQL.append(newIncrement);
            }

            final String oldMinValue = oldSequence.getMinValue();
            final String newMinValue = newSequence.getMinValue();

            if (newMinValue == null && oldMinValue != null) {
                sbSQL.append("\n\tNO MINVALUE");
            } else if (newMinValue != null
                    && !newMinValue.equals(oldMinValue)) {
                sbSQL.append("\n\tMINVALUE ");
                sbSQL.append(newMinValue);
            }

            final String oldMaxValue = oldSequence.getMaxValue();
            final String newMaxValue = newSequence.getMaxValue();

            if (newMaxValue == null && oldMaxValue != null) {
                sbSQL.append("\n\tNO MAXVALUE");
            } else if (newMaxValue != null
                    && !newMaxValue.equals(oldMaxValue)) {
                sbSQL.append("\n\tMAXVALUE ");
                sbSQL.append(newMaxValue);
            }

            if (!arguments.isIgnoreStartWith()) {
                final String oldStart = oldSequence.getStartWith();
                final String newStart = newSequence.getStartWith();

                if (newStart != null && !newStart.equals(oldStart)) {
                    sbSQL.append("\n\tRESTART WITH ");
                    sbSQL.append(newStart);
                }
            }

            final String oldCache = oldSequence.getCache();
            final String newCache = newSequence.getCache();

            if (newCache != null && !newCache.equals(oldCache)) {
                sbSQL.append("\n\tCACHE ");
                sbSQL.append(newCache);
            }

            final boolean oldCycle = oldSequence.isCycle();
            final boolean newCycle = newSequence.isCycle();

            if (oldCycle && !newCycle) {
                sbSQL.append("\n\tNO CYCLE");
            } else if (!oldCycle && newCycle) {
                sbSQL.append("\n\tCYCLE");
            }

            final String oldOwnedBy = oldSequence.getOwnedBy();
            final String newOwnedBy = newSequence.getOwnedBy();

            if (newOwnedBy != null && !newOwnedBy.equals(oldOwnedBy)) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, arguments, searchPathHelper, newSequence);
                
                sbSQL.append("\n\tOWNED BY ");
                sbSQL.append(newOwnedBy);
            }

            if (sbSQL.length() > 0) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement("ALTER SEQUENCE "
                        + PgDiffUtils.getQuotedName(newSequence.getName())
                        + sbSQL.toString() + ';');
            }
            
            if (!Objects.equals(oldSequence.getOwner(), newSequence.getOwner())) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(newSequence.getOwnerSQL());
            }
            
            if (!oldSequence.getPrivileges().equals(newSequence.getPrivileges())) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(newSequence.getPrivilegesSQL());
            }

            if (oldSequence.getComment() == null
                    && newSequence.getComment() != null
                    || oldSequence.getComment() != null
                    && newSequence.getComment() != null
                    && !oldSequence.getComment().equals(
                    newSequence.getComment())) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement("COMMENT ON SEQUENCE "
                        + PgDiffUtils.getQuotedName(newSequence.getName())
                        + " IS " + newSequence.getComment() + ';');
            } else if (oldSequence.getComment() != null
                    && newSequence.getComment() == null) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement("COMMENT ON SEQUENCE "
                        + newSequence.getName() + " IS NULL;");
            }
        }
    }

    /**
     * Creates a new instance of PgDiffSequences.
     */
    private PgDiffSequences() {
    }
}
