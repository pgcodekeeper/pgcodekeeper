/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;

/**
 * Diffs tables.
 *
 * @author fordfrog
 */
public final class PgDiffTables {
    
    /**
     * Outputs statements for creation of new tables.
     * @param writer writer the output should be written to
     * @param oldSchema original schema
     * @param newSchema new schema
     * @param searchPathHelper search path helper
     */
    public static void createTables(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgTable table : newSchema.getTables()) {
            if (oldSchema == null || !oldSchema.containsTable(table.getName())) {
                depRes.addCreateStatements(table);
            }
        }
    }

    /**
     * Outputs statements for altering tables.
     *
     * @param writer           writer the output should be written to
     * @param arguments        object containing arguments settings
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void alterTables(final DepcyResolver depRes,
            final PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        for (final PgTable oldTable : oldSchema.getTables()) {
            depRes.addAlterStatements(oldTable, newSchema.getTable(oldTable.getName()));
        }
    }

    /**
     * Outputs statements for dropping tables.
     *
     * @param depRes 
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropTables(DepcyResolver depRes, final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        
        if (oldSchema == null) {
            return;
        }
        
        for (final PgTable table : oldSchema.getTables()) {
            if (!newSchema.containsTable(table.getName())) {
                depRes.addDropStatements(table);
            }
        }
    }

    /**
     * Creates a new instance of PgDiffTables.
     */
    private PgDiffTables() {
    }
}
