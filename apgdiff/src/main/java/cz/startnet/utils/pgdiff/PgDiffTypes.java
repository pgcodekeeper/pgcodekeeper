package cz.startnet.utils.pgdiff;

import java.util.Iterator;

import cz.startnet.utils.pgdiff.schema.PgType;

/**
 * Diff Types
 */
public final class PgDiffTypes {
    
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
    
    private PgDiffTypes() {
    }
}
