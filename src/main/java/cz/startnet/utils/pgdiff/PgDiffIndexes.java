/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;

/**
 * Diffs indexes.
 *
 * @author fordfrog
 */
public final class PgDiffIndexes {

    /**
     * Outputs statements for creation of new indexes.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void createIndexes(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgTable newTable : newSchema.getTables()) {
            final String newTableName = newTable.getName();

            // Add new indexes
            if (oldSchema == null) {
                for (PgIndex index : newTable.getIndexes()) {
                	depRes.addCreateStatements(index);
                }
            } else {
                for (PgIndex index : getNewIndexes(oldSchema.getTable(newTableName), newTable)) {
                	depRes.addCreateStatements(index);
                }
            }
        }
    }

    /**
     * Outputs statements for dropping indexes that exist no more.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropIndexes(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgTable newTable : newSchema.getTables()) {
            final String newTableName = newTable.getName();
            final PgTable oldTable;

            if (oldSchema == null) {
                oldTable = null;
            } else {
                oldTable = oldSchema.getTable(newTableName);
            }

            // Drop indexes that do not exist in new schema or are modified
            for (final PgIndex index : getDropIndexes(oldTable, newTable)) {
            	depRes.addDropStatements(index);
            }
        }
        // КОСТЫЛЬ
        if (oldSchema == null){
            return;
        }
        
        for (final PgTable oldTable : oldSchema.getTables()) {
            if (newSchema.getTable(oldTable.getName()) == null && !PgDiff.isFullSelection(oldTable)) {
                PgTable newTable = new PgTable(oldTable.getName(), null);
                for (final PgIndex index : getDropIndexes(oldTable, newTable)) {
                	depRes.addDropStatements(index);
                }
            }
        }// КОСТЫЛЬ
    }

    /**
     * Returns list of indexes that should be dropped.
     *
     * @param oldTable original table
     * @param newTable new table
     *
     * @return list of indexes that should be dropped
     *
     * @todo Indexes that are depending on a removed field should not be added
     * to drop because they are already removed.
     */
    private static List<PgIndex> getDropIndexes(final PgTable oldTable,
            final PgTable newTable) {
        final List<PgIndex> list = new ArrayList<>();

        if (newTable != null && oldTable != null) {
            for (final PgIndex index : oldTable.getIndexes()) {
                if (!newTable.containsIndex(index.getName())
                        || !newTable.getIndex(index.getName()).compareWithoutComments(index)) {
                    list.add(index);
                }
            }
        }

        return list;
    }

    /**
     * Returns list of indexes that should be added.
     *
     * @param oldTable original table
     * @param newTable new table
     *
     * @return list of indexes that should be added
     */
    private static List<PgIndex> getNewIndexes(final PgTable oldTable,
            final PgTable newTable) {
        final List<PgIndex> list = new ArrayList<>();

        if (newTable != null) {
            if (oldTable == null) {
                for (final PgIndex index : newTable.getIndexes()) {
                    list.add(index);
                }
            } else {
                for (final PgIndex index : newTable.getIndexes()) {
                    if (!oldTable.containsIndex(index.getName())
                            || !oldTable.getIndex(index.getName()).
                            compareWithoutComments(index)) {
                        list.add(index);
                    }
                }
            }
        }

        return list;
    }

    /**
     * Outputs statements for index comments that have changed.
     *
     * @param writer           writer
     * @param oldSchema        old schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void alterComments(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        for(PgTable oldTable : oldSchema.getTables()) {
        	final PgTable newTable = newSchema.getTable(oldTable.getName());
			if (newTable == null) {
				continue;
			}
            for (final PgIndex oldIndex : oldTable.getIndexes()) {
            	if (newTable.containsIndex(oldIndex.getName())) {
            		depRes.addAlterStatements(oldIndex);
            	}
            }
        }
    }

    /**
     * Creates a new instance of PgDiffIndexes.
     */
    private PgDiffIndexes() {
    }
}
