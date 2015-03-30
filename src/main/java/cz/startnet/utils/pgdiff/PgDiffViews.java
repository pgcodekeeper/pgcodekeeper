/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgView;

/**
 * Diffs views.
 *
 * @author fordfrog
 */
public final class PgDiffViews {

    /**
     * Outputs statements for creation of views.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void createViews(final DepcyResolver depRes, PgDiffArguments arguments,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgView newView : newSchema.getViews()) {
            if (oldSchema == null
                    || !oldSchema.containsView(newView.getName())) {
                depRes.addCreateStatements(newView);
            }
        }
    }

    /**
     * Outputs statements for dropping views.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropViews(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        for (final PgView oldView : oldSchema.getViews()) {
            if (!newSchema.containsView(oldView.getName())) {
                depRes.addDropStatements(oldView);
            }
        }
    }

    /**
     * Returns true if either column names or query of the view has been
     * modified.
     *
     * @param oldView old view
     * @param newView new view
     *
     * @return true if view has been modified, otherwise false
     */
    public static boolean isViewModified(final PgView oldView,
            final PgView newView) {
        List<String> oldColumnNames = oldView.getColumnNames();
        List<String> newColumnNames = newView.getColumnNames();

        if(oldColumnNames.isEmpty() && newColumnNames.isEmpty()) {
            String nOldQuery = oldView.getNormalizedQuery();
            String nNewQuery = newView.getNormalizedQuery();
            return !nOldQuery.equals(nNewQuery);
        } else {
            return !oldColumnNames.equals(newColumnNames);
        }
    }

    /**
     * Outputs statements for altering view default values.
     * @param arguments 
     *
     * @param writer           writer
     * @param oldSchema        old schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void alterViews(final DepcyResolver depRes,
            PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        for (final PgView oldView : oldSchema.getViews()) {
            depRes.appendAlter(oldView, newSchema.getView(oldView.getName()));
        }
    }

    /**
     * Diffs default values in views.
     *
     * @param writer           writer
     * @param oldView          old view
     * @param newView          new view
     * @param searchPathHelper search path helper
     */
    public static void diffDefaultValues(final PgDiffScript script,
            final PgView oldView, final PgView newView) {
        final List<PgView.DefaultValue> oldValues =
                oldView.getDefaultValues();
        final List<PgView.DefaultValue> newValues =
                newView.getDefaultValues();

        // modify defaults that are in old view
        for (final PgView.DefaultValue oldValue : oldValues) {
            boolean found = false;

            for (final PgView.DefaultValue newValue : newValues) {
                if (oldValue.getColumnName().equals(newValue.getColumnName())) {
                    found = true;

                    if (!oldValue.getDefaultValue().equals(newValue.getDefaultValue())) {
                        script.addStatement("ALTER TABLE "
                                + PgDiffUtils.getQuotedName(newView.getName())
                                + " ALTER COLUMN "
                                + PgDiffUtils.getQuotedName(newValue.getColumnName())
                                + " SET DEFAULT "
                                + newValue.getDefaultValue()
                                + ';');
                    }

                    break;
                }
            }

            if (!found) {
                script.addStatement("ALTER TABLE "
                        + PgDiffUtils.getQuotedName(newView.getName())
                        + " ALTER COLUMN "
                        + PgDiffUtils.getQuotedName(oldValue.getColumnName())
                        + " DROP DEFAULT;");
            }
        }

        // add new defaults
        for (final PgView.DefaultValue newValue : newValues) {
            boolean found = false;

            for (final PgView.DefaultValue oldValue : oldValues) {
                if (newValue.getColumnName().equals(oldValue.getColumnName())) {
                    found = true;
                    break;
                }
            }

            if (found) {
                continue;
            }

            script.addStatement("ALTER TABLE "
                    + PgDiffUtils.getQuotedName(newView.getName())
                    + " ALTER COLUMN "
                    + PgDiffUtils.getQuotedName(newValue.getColumnName())
                    + " SET DEFAULT "
                    + newValue.getDefaultValue()
                    + ';');
        }
    }

    /**
     * Creates a new instance of PgDiffViews.
     */
    private PgDiffViews() {
    }
}
