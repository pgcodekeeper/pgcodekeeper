/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
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
    public static void createSequences(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgSequence sequence : newSchema.getSequences()) {
            if (oldSchema == null
                    || !oldSchema.containsSequence(sequence.getName())) {
            	depRes.addCreateStatements(sequence);
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
    public static void dropSequences(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        // Drop sequences that do not exist in new schema
        for (final PgSequence sequence : oldSchema.getSequences()) {
            if (!newSchema.containsSequence(sequence.getName())) {
            	depRes.addDropStatements(sequence);
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
    public static void alterSequences(final DepcyResolver depRes,
            final PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        for (final PgSequence oldSequence : oldSchema.getSequences()) {
            PgSequence newSequence = newSchema.getSequence(oldSequence.getName());
            depRes.appendAlter(oldSequence, newSequence);
            depRes.appendAlterOwnedBy(oldSequence, newSequence);
        }
    }

    /**
     * Creates a new instance of PgDiffSequences.
     */
    private PgDiffSequences() {
    }
}
