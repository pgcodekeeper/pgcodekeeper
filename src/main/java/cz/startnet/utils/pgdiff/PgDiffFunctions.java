/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgFunction.Argument;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTrigger;

/**
 * Diffs functions.
 *
 * @author fordfrog
 */
public final class PgDiffFunctions {

    /**
     * Outputs statements for new or modified functions.
     *
     * @param writer           writer the output should be written to
     * @param arguments        object containing arguments settings
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void createFunctions(final PgDiffScript script,
            final PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        // Add new functions and replace modified functions
        for (final PgFunction newFunction : newSchema.getFunctions()) {
            final PgFunction oldFunction;

            if (oldSchema == null) {
                oldFunction = null;
            } else {
                oldFunction = oldSchema.getFunction(newFunction.getSignature());
            }

            if ((oldFunction == null) || !newFunction.equalsWhitespace(
                    oldFunction, arguments.isIgnoreFunctionWhitespace())) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, arguments, searchPathHelper, newFunction);
                
                searchPathHelper.outputSearchPath(script);
                if (oldFunction != null &&
                        (!Objects.equals(newFunction.getReturns(), oldFunction.getReturns())
                                || defaultsModifiedDeleted(newFunction, oldFunction))) {
                    PgDiff.writeDropSql(script, null, oldFunction);
                }
                PgDiff.writeCreationSql(script, null, newFunction);
            }
        }
    }
    
    private static boolean defaultsModifiedDeleted(PgFunction newFunction, 
            PgFunction oldFunction) {
        Iterator<Argument> iOld = oldFunction.getArguments().iterator();
        Iterator<Argument> iNew = newFunction.getArguments().iterator();
        while (iOld.hasNext() && iNew.hasNext()) {
            String oldDef = iOld.next().getDefaultExpression();
            String newDef = iNew.next().getDefaultExpression();

            // allow creation of defaults (old==null && new!=null)
            if (oldDef != null && !oldDef.equals(newDef)) {
                return true;
            }
        }
        // we could check for equal arg count but it's not our job here
        return false;
    }

    /**
     * Outputs statements for dropping of functions that exist no more.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropFunctions(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        // Drop functions that exist no more
        for (final PgFunction oldFunction : oldSchema.getFunctions()) {
            if (!newSchema.containsFunction(oldFunction.getSignature())) {
                Set<PgStatement> dependantsSet = new LinkedHashSet<PgStatement>(10);
                PgDiff.getDependantsSet(oldFunction, dependantsSet);
                PgStatement[] dependants = dependantsSet.toArray(
                        new PgStatement[dependantsSet.size()]);

                // drop dependants in reverse first
                for (int i = dependants.length - 1; i >= 0; --i) {
                    PgStatement depnt = dependants[i];
                    
                    if (depnt instanceof PgTrigger) {
                        PgDiff.tempSwitchSearchPath(
                                depnt.getParent().getParent().getName(),
                                searchPathHelper, script);
                        PgDiff.writeDropSql(script,
                                "-- DEPCY: This trigger depends on the function"
                                + " we are about to drop: " + oldFunction.getName(),
                                depnt);
                    }
                }
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, oldFunction);
            }
        }
    }

    /**
     * Outputs statements for function comments that have changed.
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

        for (final PgFunction oldfunction : oldSchema.getFunctions()) {
            final PgFunction newFunction =
                    newSchema.getFunction(oldfunction.getSignature());

            if (newFunction == null) {
                continue;
            }

            if (oldfunction.getComment() == null
                    && newFunction.getComment() != null
                    || oldfunction.getComment() != null
                    && newFunction.getComment() != null
                    && !oldfunction.getComment().equals(
                    newFunction.getComment())) {
                searchPathHelper.outputSearchPath(script);
                
                StringBuilder sb = new StringBuilder();
                sb.append("COMMENT ON FUNCTION ");
                newFunction.appendFunctionSignature(sb, false);
                sb.append(" IS ");
                sb.append(newFunction.getComment());
                sb.append(';');
                script.addStatement(sb.toString());
            } else if (oldfunction.getComment() != null
                    && newFunction.getComment() == null) {
                searchPathHelper.outputSearchPath(script);
                
                StringBuilder sb = new StringBuilder();
                sb.append("COMMENT ON FUNCTION ");
                newFunction.appendFunctionSignature(sb, false);
                sb.append(" IS NULL;");
                script.addStatement(sb.toString());
            }
        }
    }

    /**
     * Creates a new instance of PgDiffFunctions.
     */
    private PgDiffFunctions() {
    }
}
