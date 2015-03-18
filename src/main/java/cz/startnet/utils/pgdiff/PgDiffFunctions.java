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
                    oldFunction, false)) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, arguments, searchPathHelper, newFunction);
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeCreationSql(script, null, newFunction, true);
            }
        }
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
            if (needsDrop(oldFunction, newSchema)) {
                Set<PgStatement> dependantsSet = new LinkedHashSet<>();
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
                
                // no re-creation because the only dependants we have so far are triggers
                // trigger funcs cannot change in a way that will require a drop+create
                // that is they never have arguments and always have the return type of TRIGGER
                // add dependants re-creation if necessary at a later point
            }
        }
    }

    private static boolean needsDrop(PgFunction oldFunction, PgSchema newSchema) {
        PgFunction newFunction = newSchema.getFunction(oldFunction.getSignature());
        
        if (newFunction == null || 
                !Objects.equals(oldFunction.getReturns(), newFunction.getReturns())) {
            return true;
        }
        
        Iterator<Argument> iOld = oldFunction.getArguments().iterator();
        Iterator<Argument> iNew = newFunction.getArguments().iterator();
        while (iOld.hasNext() && iNew.hasNext()) {
            Argument argOld = iOld.next();
            Argument argNew = iNew.next();
            
            String oldDef = argOld.getDefaultExpression();
            String newDef = argNew.getDefaultExpression();
            // allow creation of defaults (old==null && new!=null)
            if (oldDef != null && !oldDef.equals(newDef)) {
                return true;
            }
            
            // [IN]OUT args that change their names implicitly change the function's
            // return type due to it being "SETOF record" in case of
            // multiple [IN]OUT args present
            if (argOld.getMode() != null && argOld.getMode().endsWith("OUT") &&
                    !Objects.equals(argOld.getName(), argNew.getName())) {
                return true;
            }
        }
        
        return false;
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

        for (final PgFunction oldFunction : oldSchema.getFunctions()) {
            final PgFunction newFunction =
                    newSchema.getFunction(oldFunction.getSignature());

            if (newFunction == null) {
                continue;
            }

            PgDiff.diffComments(oldFunction, newFunction, script);
        }
    }

    /**
     * Creates a new instance of PgDiffFunctions.
     */
    private PgDiffFunctions() {
    }
}
