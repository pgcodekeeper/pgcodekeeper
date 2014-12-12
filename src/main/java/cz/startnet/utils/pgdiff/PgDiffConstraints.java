/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;

/**
 * Diffs constraints.
 *
 * @author fordfrog
 */
public final class PgDiffConstraints {

    /**
     * Outputs statements for creation of new constraints.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param primaryKey       determines whether primary keys should be
     *                         processed or any other constraints should be
     *                         processed
     * @param searchPathHelper search path helper
     */
    public static void createConstraints(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final boolean primaryKey, final SearchPathHelper searchPathHelper) {
        for (final PgTable newTable : newSchema.getTables()) {
            final PgTable oldTable;

            if (oldSchema == null) {
                oldTable = null;
            } else {
                oldTable = oldSchema.getTable(newTable.getName());
            }

            // Add new constraints
            for (final PgConstraint constraint :
                    getNewConstraints(oldTable, newTable, primaryKey)) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, null, searchPathHelper, constraint);
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeCreationSql(script, null, constraint);
            }
        }
    }

    /**
     * Outputs statements for dropping non-existent or modified constraints.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param primaryKey       determines whether primary keys should be
     *                         processed or any other constraints should be
     *                         processed
     * @param searchPathHelper search path helper
     */
    public static void dropConstraints(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final boolean primaryKey, final SearchPathHelper searchPathHelper) {
        for (final PgTable newTable : newSchema.getTables()) {
            final PgTable oldTable;

            if (oldSchema == null) {
                oldTable = null;
            } else {
                oldTable = oldSchema.getTable(newTable.getName());
            }

            // Drop constraints that no more exist or are modified
            for (final PgConstraint constraint :
                    getDropConstraints(oldTable, newTable, primaryKey)) {
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, constraint);
            }
        }
        
        // КОСТЫЛЬ
        if (oldSchema == null){
            return;
        }
        
        for (final PgTable oldTable : oldSchema.getTables()) {
            if (newSchema.getTable(oldTable.getName()) == null && !PgDiff.isFullSelection(oldTable)) {
                PgTable newTable = new PgTable(oldTable.getName(), null, null);
                for (final PgConstraint constraint : getDropConstraints(oldTable, newTable, primaryKey)) {
                    searchPathHelper.outputSearchPath(script);
                    PgDiff.writeDropSql(script, null, constraint);
                }
            }
        }// КОСТЫЛЬ
    }

    /**
     * Returns list of constraints that should be dropped.
     *
     * @param oldTable   original table or null
     * @param newTable   new table or null
     * @param primaryKey determines whether primary keys should be processed or
     *                   any other constraints should be processed
     *
     * @return list of constraints that should be dropped
     *
     * @todo Constraints that are depending on a removed field should not be
     * added to drop because they are already removed.
     */
    private static List<PgConstraint> getDropConstraints(final PgTable oldTable,
            final PgTable newTable, final boolean primaryKey) {
        final List<PgConstraint> list = new ArrayList<>();

        if (newTable != null && oldTable != null) {
            for (final PgConstraint constraint : oldTable.getConstraints()) {
                if (constraint.isPrimaryKeyConstraint() == primaryKey
                        && (!newTable.containsConstraint(constraint.getName())
                        || !newTable.getConstraint(constraint.getName()).
                        compareWithoutComments(constraint))) {
                    list.add(constraint);
                }
            }
        }

        return list;
    }

    /**
     * Returns list of constraints that should be added.
     *
     * @param oldTable   original table
     * @param newTable   new table
     * @param primaryKey determines whether primary keys should be processed or
     *                   any other constraints should be processed
     *
     * @return list of constraints that should be added
     */
    private static List<PgConstraint> getNewConstraints(final PgTable oldTable,
            final PgTable newTable, final boolean primaryKey) {
        final List<PgConstraint> list = new ArrayList<>();

        if (newTable != null) {
            if (oldTable == null) {
                for (final PgConstraint constraint :
                        newTable.getConstraints()) {
                    if (constraint.isPrimaryKeyConstraint() == primaryKey) {
                        list.add(constraint);
                    }
                }
            } else {
                for (final PgConstraint constraint :
                        newTable.getConstraints()) {
                    if ((constraint.isPrimaryKeyConstraint() == primaryKey)
                            && (!oldTable.containsConstraint(
                            constraint.getName())
                            || !oldTable.getConstraint(constraint.getName()).
                            compareWithoutComments(constraint))) {
                        list.add(constraint);
                    }
                }
            }
        }

        return list;
    }

    /**
     * Outputs statements for constraint comments that have changed.
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

            for (final PgConstraint oldConstraint : oldTable.getConstraints()) {
                final PgConstraint newConstraint =
                        newTable.getConstraint(oldConstraint.getName());

                if (newConstraint == null) {
                    continue;
                }

                if (oldConstraint.getComment() == null
                        && newConstraint.getComment() != null
                        || oldConstraint.getComment() != null
                        && newConstraint.getComment() != null
                        && !oldConstraint.getComment().equals(
                        newConstraint.getComment())) {
                    searchPathHelper.outputSearchPath(script);
                    
                    StringBuilder sb = new StringBuilder();
                    sb.append("COMMENT ON ");
                    if (newConstraint.isPrimaryKeyConstraint()) {
                        sb.append("INDEX ");
                        sb.append(PgDiffUtils.getQuotedName(newConstraint.getName()));
                    } else {
                        sb.append("CONSTRAINT ");
                        sb.append(PgDiffUtils.getQuotedName(newConstraint.getName()));
                        sb.append(" ON ");
                        sb.append(PgDiffUtils.getQuotedName(newConstraint.getTableName()));
                    }
                    sb.append(" IS ");
                    sb.append(newConstraint.getComment());
                    sb.append(';');
                    script.addStatement(sb.toString());
                } else if (oldConstraint.getComment() != null
                        && newConstraint.getComment() == null) {
                    searchPathHelper.outputSearchPath(script);
                    
                    StringBuilder sb = new StringBuilder();
                    sb.append("COMMENT ON ");
                    if (newConstraint.isPrimaryKeyConstraint()) {
                        sb.append("INDEX ");
                        sb.append(PgDiffUtils.getQuotedName(newConstraint.getName()));
                    } else {
                        sb.append("CONSTRAINT ");
                        sb.append(PgDiffUtils.getQuotedName(newConstraint.getName()));
                        sb.append(" ON ");
                        sb.append(PgDiffUtils.getQuotedName(newConstraint.getTableName()));
                    }
                    sb.append(" IS NULL;");
                    script.addStatement(sb.toString());
                }
            }
        }
    }

    /**
     * Creates a new instance of PgDiffConstraints.
     */
    private PgDiffConstraints() {
    }
}
