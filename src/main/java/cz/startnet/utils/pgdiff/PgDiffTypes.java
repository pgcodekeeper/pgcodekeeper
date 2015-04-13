package cz.startnet.utils.pgdiff;

import java.util.Iterator;

import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgType;

/**
 * Diff Types
 */
public final class PgDiffTypes {
    
    /**
     * Outputs statements for creation of new types.
     *
     * @param writer
     *            writer the output should be written to
     * @param oldSchema original schema
     * @param newSchema new schema
     * @param searchPathHelper search path helper
     */
    public static void createTypes(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgType type : newSchema.getTypes()) {
            PgType oldType = oldSchema == null ? null : oldSchema.getType(type.getName());
            
            if (oldType == null) {
                depRes.addCreateStatements(type);
            }
        }
    }
        
    /**
     * Outputs statements for dropping of types that do not exist anymore.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropTypes(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        // Drop types that do not exist in new schema
        for (final PgType oldType : oldSchema.getTypes()) {
            if (!newSchema.containsType(oldType.getName())) {
                depRes.addDropStatements(oldType);
            }
        }
    }
    
    /**
     * This method assumes that its arguments are not equal. 
     */
    public static boolean canAlter(PgType oldType, PgType newType) {
        if (oldType.getForm() != newType.getForm()) {
            return false;
        }
        switch (oldType.getForm()) {
        case ENUM:
            Iterator<String> oi = oldType.getEnums().iterator();
            Iterator<String> ni = newType.getEnums().iterator();
            while (oi.hasNext()) {
                if (!ni.hasNext()) {
                    // some old members were removed in new, can't alter
                    return false;
                }
                String oldEnum = oi.next();
                if (!oldEnum.equals(ni.next())) {
                    // iterate over new enums until old enum is met or end is reached
                    boolean found = false;
                    while (ni.hasNext()) {
                        if (oldEnum.equals(ni.next())) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        return false; // oldEnum is not in the new list
                    }
                    // order changes will fail this test as they should
                    // consider old:(e1, e2), new:(e2, e1)
                    // we will go over new.e2 while iterating for old.e1
                    // thus we will fail to find new.e2 while iterating for old.e2
                }
            }
            // old list is exhausted at this point and we always return true
            // since we can create new enum members
            return true;
        case COMPOSITE:
            return true;
        default:
            return false;
        }
    }
    
    /**
     * Outputs statement for modified types.
     *
     * @param writer           writer the output should be written to
     * @param arguments        object containing arguments settings
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */    
    public static void alterTypes(final DepcyResolver depRes,
            final PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }
        for (PgType newType : newSchema.getTypes()) {
            PgType oldType = oldSchema.getType(newType.getName());
            depRes.addAlterStatements(oldType, newType);
        }
    }
    
    private PgDiffTypes() {
    }
}
