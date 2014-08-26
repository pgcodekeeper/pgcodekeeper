/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgView;

/**
 * Diffs views.
 *
 * @author fordfrog
 */
public class PgDiffViews {

    /**
     * Outputs statements for creation of views.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void createViews(final PgDiffScript script, PgDiffArguments arguments,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgView newView : newSchema.getViews()) {
            boolean isModified = oldSchema != null
                    && oldSchema.containsView(newView.getName()) 
                    && isViewModified(oldSchema.getView(newView.getName()), newView);
            if (oldSchema == null
                    || !oldSchema.containsView(newView.getName())
                    || isModified) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, arguments, searchPathHelper, newView);
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeCreationSql(script, null, newView);
                
                if (isModified){
                 // check all dependants, drop them if blocking
                    Set<PgStatement> dependantsSet = new LinkedHashSet<>(10);
                    PgDiff.getDependantsSet(oldSchema.getView(newView.getName()), dependantsSet);
                    
                    for (PgStatement depnt : dependantsSet){
                        if (depnt instanceof PgView){
                            PgDiff.tempSwitchSearchPath(depnt.getParent().getName(),
                                    searchPathHelper, script);
                            PgDiff.writeCreationSql(script,"-- DEPCY: Following view depends"
                                    + " on the altered view " + newView.getName(), depnt);
                        }
                    }
                }
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
    public static void dropViews(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        for (final PgView oldView : oldSchema.getViews()) {
            final PgView newView = newSchema.getView(oldView.getName());
            boolean isModified = newView != null && isViewModified(oldView, newView);
            if (newView == null || isModified) {
                
                // check all dependants, drop them if blocking
                Set<PgStatement> dependantsSet = new LinkedHashSet<>(10);
                PgDiff.getDependantsSet(oldView, dependantsSet);
                // wrap Set into array for reverse iteration
                Object[] dependants = dependantsSet.toArray();
                
                for (int i = dependants.length - 1; i >= 0; i--){
                    PgStatement depnt = (PgStatement) dependants[i];
                    
                    if (depnt instanceof PgView) {
                        PgDiff.tempSwitchSearchPath(depnt.getParent().getName(),
                                searchPathHelper, script);
                        PgDiff.writeDropSql(script, "-- DEPCY: This view depends on the "
                                + "view we are about to drop: " + oldView.getName(), depnt);
                    }
                }
                
                // output initial view drop
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, oldView);
    
                // recreate dependant views in straight order if view isn't modified
                if (isModified){
                    continue;
                }
                
                for (PgStatement depnt : dependantsSet){
                    if (depnt instanceof PgView){
                        PgDiff.tempSwitchSearchPath(depnt.getParent().getName(),
                                searchPathHelper, script);
                        PgDiff.writeCreationSql(script,"-- DEPCY: Following view depends"
                                + " on the dropped view " + oldView.getName(), depnt);
                    }
                }
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
    private static boolean isViewModified(final PgView oldView,
            final PgView newView) {
        List<String> oldColumnNames = oldView.getColumnNames();
        List<String> newColumnNames = newView.getColumnNames();

        // TODO faulty logic?
        // TODO review PgDiff compare methods against PgStatements' compare methods
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
    public static void alterViews(final PgDiffScript script,
            PgDiffArguments arguments, final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        for (final PgView oldView : oldSchema.getViews()) {
            final PgView newView = newSchema.getView(oldView.getName());

            if (newView == null) {
                continue;
            }
            
            diffDefaultValues(script, oldView, newView, searchPathHelper);

            if (!Objects.equals(oldView.getOwner(), newView.getOwner())) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(newView.getOwnerSQL());
            }
            
            if (!oldView.getPrivileges().equals(newView.getPrivileges())) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(newView.getPrivilegesSQL());
            }

            if (oldView.getComment() == null
                    && newView.getComment() != null
                    || oldView.getComment() != null
                    && newView.getComment() != null
                    && !oldView.getComment().equals(
                    newView.getComment())) {
                searchPathHelper.outputSearchPath(script);
                
                script.addStatement("COMMENT ON VIEW "
                        + PgDiffUtils.getQuotedName(newView.getName())
                        + " IS "
                        + newView.getComment()
                        + ';');
            } else if (oldView.getComment() != null
                    && newView.getComment() == null) {
                searchPathHelper.outputSearchPath(script);

                script.addStatement("COMMENT ON VIEW "
                        + PgDiffUtils.getQuotedName(newView.getName())
                        + " IS NULL;");
            }

            final List<String> columnNames =
                    new ArrayList<String>(newView.getColumnComments().size());

            for (final PgView.ColumnComment columnComment :
                    newView.getColumnComments()) {
                columnNames.add(columnComment.getColumnName());
            }

            for (final PgView.ColumnComment columnComment :
                    oldView.getColumnComments()) {
                if (!columnNames.contains(columnComment.getColumnName())) {
                    columnNames.add(columnComment.getColumnName());
                }
            }

            for (final String columnName : columnNames) {
                PgView.ColumnComment oldColumnComment = null;
                PgView.ColumnComment newColumnComment = null;

                for (final PgView.ColumnComment columnComment :
                        oldView.getColumnComments()) {
                    if (columnName.equals(columnComment.getColumnName())) {
                        oldColumnComment = columnComment;
                        break;
                    }
                }

                for (final PgView.ColumnComment columnComment :
                        newView.getColumnComments()) {
                    if (columnName.equals(columnComment.getColumnName())) {
                        newColumnComment = columnComment;
                        break;
                    }
                }

                if (oldColumnComment == null && newColumnComment != null
                        || oldColumnComment != null && newColumnComment != null
                        && !oldColumnComment.getComment().equals(
                        newColumnComment.getComment())) {
                    searchPathHelper.outputSearchPath(script);

                    script.addStatement("COMMENT ON COLUMN "
                            + PgDiffUtils.getQuotedName(newView.getName())
                            + '.'
                            + PgDiffUtils.getQuotedName(newColumnComment.getColumnName())
                            + " IS "
                            + newColumnComment.getComment()
                            + ';');
                } else if (oldColumnComment != null
                        && newColumnComment == null) {
                    searchPathHelper.outputSearchPath(script);

                    script.addStatement("COMMENT ON COLUMN "
                            + PgDiffUtils.getQuotedName(newView.getName())
                            + '.'
                            + PgDiffUtils.getQuotedName(oldColumnComment.getColumnName())
                            + " IS NULL;");
                }
            }
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
    private static void diffDefaultValues(final PgDiffScript script,
            final PgView oldView, final PgView newView,
            final SearchPathHelper searchPathHelper) {
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
                        searchPathHelper.outputSearchPath(script);

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
                searchPathHelper.outputSearchPath(script);

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

            searchPathHelper.outputSearchPath(script);

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
