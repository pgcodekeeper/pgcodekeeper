package cz.startnet.utils.pgdiff;

import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class PgDiffColumns {

    /**
     * Outputs statements for creation of new tables.
     *
     * @param writer
     *            writer the output should be written to
     * @param oldSchema
     *            original schema
     * @param newSchema
     *            new schema
     * @param searchPathHelper
     *            search path helper
     */
    public static void createColumns(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgTable table : newSchema.getTables()) {
            if (oldSchema == null) {
                break;
            }
            PgTable oldTable = oldSchema.getTable(table.getName());
            if (oldTable != null) {
                for (PgColumn col : table.getColumns()) {
                    if (!oldTable.containsColumn(col.getName())) {
                        depRes.addCreateStatements(col);
                    }
                }
            }
        }
    }

    /**
     * Outputs statements for dropping tables.
     * 
     * @param depRes
     *
     * @param writer
     *            writer the output should be written to
     * @param oldSchema
     *            original schema
     * @param newSchema
     *            new schema
     * @param searchPathHelper
     *            search path helper
     */
    public static void dropColumns(DepcyResolver depRes,
            final PgDiffScript script, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {

        if (oldSchema == null) {
            return;
        }

        for (final PgTable table : oldSchema.getTables()) {
            PgTable newTable = newSchema.getTable(table.getName());
            if (newTable != null) {
                for (PgColumn col : table.getColumns()) {
                    if (!newTable.containsColumn(col.getName())) {
                        depRes.addDropStatements(col);
                    }
                }
            }
        }
    }

    /**
     * Outputs statements for altering tables.
     *
     * @param writer
     *            writer the output should be written to
     * @param arguments
     *            object containing arguments settings
     * @param oldSchema
     *            original schema
     * @param newSchema
     *            new schema
     * @param searchPathHelper
     *            search path helper
     */
    public static void alterColumns(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        for (final PgTable oldTable : oldSchema.getTables()) {
            PgTable newTable = newSchema.getTable(oldTable.getName());
            if (newTable != null) {
                for (PgColumn oldColumn : oldTable.getColumns()) {
                    depRes.appendALter(oldColumn,
                            newTable.getColumn(oldColumn.getName()));
                }
            }
        }
    }

    private PgDiffColumns() {
    }

}
