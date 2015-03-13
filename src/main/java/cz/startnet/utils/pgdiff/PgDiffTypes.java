package cz.startnet.utils.pgdiff;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
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
    public static void createTypes(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgType type : newSchema.getTypes()) {
            PgType oldType = oldSchema == null ? null : oldSchema.getType(type.getName());
            
            if (oldType == null ||
                    (!type.equals(oldType) && !canAlter(oldType, type))) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, null,
                        searchPathHelper, type);

                searchPathHelper.outputSearchPath(script);
                PgDiff.writeCreationSql(script, null, type, true);
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
    public static void dropTypes(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        // Drop types that do not exist in new schema
        for (final PgType oldType : oldSchema.getTypes()) {
            PgType newType = newSchema.getType(oldType.getName());
            if (newType == null ||
                    (!oldType.equals(newType) && !canAlter(oldType, newType))) {
                
                Set<PgStatement> dependantsSet = new LinkedHashSet<>();
                PgDiff.getDependantsSet(oldType, dependantsSet);
                PgStatement[] dependants = dependantsSet.toArray(
                        new PgStatement[dependantsSet.size()]);

                // drop dependants in reverse first
                for (int i = dependants.length - 1; i >= 0; --i) {
                    PgStatement depnt = dependants[i];
                    
                    if (depnt instanceof PgFunction
                            || depnt instanceof PgTable) {
                        PgDiff.tempSwitchSearchPath(
                                depnt.getParent().getName(),
                                searchPathHelper, script);
                        PgDiff.writeDropSql(script,
                                "-- DEPCY: This object depends on the type"
                                + " we are about to drop: " + oldType.getName(),
                                depnt);
                    }
                }

                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, oldType);
                
                // create dependants
                for (PgStatement depnt : dependants) {
                    
                    if (depnt instanceof PgFunction
                            || depnt instanceof PgTable) {
                        PgDiff.tempSwitchSearchPath(
                                depnt.getParent().getName(),
                                searchPathHelper, script);
                        PgDiff.writeCreationSql(script,
                                "-- DEPCY: This object depends on the type"
                                + " we are about to create: " + oldType.getName(),
                                depnt, true);
                    }
                }
            }
        }
    }
    
    /**
     * This method assumes that its arguments are not equal. 
     */
    private static boolean canAlter(PgType oldType, PgType newType) {
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
            // since old list is exhausted at this point we always return true
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
    public static void alterTypes(final PgDiffScript script,
            final PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }
        final StringBuilder sbSQL = new StringBuilder();
        StringBuilder attrSb = new StringBuilder();
        for (final PgType newType : newSchema.getTypes()) {
            PgType oldType = oldSchema.getType(newType.getName());

            if (oldType == null) {
                continue;
            }
            if (oldType.equals(newType) || !canAlter(oldType, newType)) {
                continue;
            }
            sbSQL.setLength(0);
            attrSb.setLength(0);
            
            for (PgColumn attr : newType.getAttrs()) {
                PgColumn oldAttr = oldType.getAttr(attr.getName());
                if (oldAttr != null) {
                    if (!oldAttr.getType().equals(attr.getType())) {
                        attrSb.append("\n\tALTER ATTRIBUTE ")
                                .append(PgDiffUtils.getQuotedName(attr.getName()))
                                .append(" TYPE ")
                                .append(attr.getType())
                                .append(", ");
                    }
                } else {
                    attrSb.append("\n\tADD ATTRIBUTE ")
                            .append(attr.getFullDefinition(false, null))
                            .append(", ");
                }
            }
            for (PgColumn attr : oldType.getAttrs()) {
                if (newType.getAttr(attr.getName()) == null) {
                    attrSb.append("\n\tDROP ATTRIBUTE ")
                            .append(PgDiffUtils.getQuotedName(attr.getName()))
                            .append(", ");
                }
            }
            
            if (attrSb.length() > 0) {
                attrSb.setLength(attrSb.length() - ", ".length());
                if (sbSQL.length() != 0) {
                    sbSQL.append("\n\n");
                }
                sbSQL.append("ALTER TYPE ")
                        .append(PgDiffUtils.getQuotedName(newType.getName()))
                        .append(attrSb).append(';');
            }
            
            List<String> enums = newType.getEnums();
            List<String> oldEnums = oldType.getEnums();
            for (int i = 0; i < enums.size(); ++i) {
                String enum_ = enums.get(i);
                if (!oldEnums.contains(enum_)) {
                    if (sbSQL.length() != 0) {
                        sbSQL.append("\n\n");
                    }
                    sbSQL.append("ALTER TYPE ")
                            .append(PgDiffUtils.getQuotedName(newType.getName()))
                            .append("\n\tADD VALUE ").append(enum_);
                    if (i == 0) {
                        sbSQL.append(" BEFORE ").append(oldEnums.get(0));
                    } else {
                        sbSQL.append(" AFTER ").append(enums.get(i - 1));
                    }
                    sbSQL.append(';');
                }
            }
            
            if (sbSQL.length() > 0) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(sbSQL.toString());
            }
            if (!Objects.equals(oldType.getOwner(), newType.getOwner())) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(newType.getOwnerSQL());
            }
            if (!oldType.getPrivileges().equals(newType.getPrivileges())) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(newType.getPrivilegesSQL());
            }
            PgDiff.diffComments(oldType, newType, script);
        }
    }
    
    /**
     * Creates a new instance of {@link PgDiffTypes}.
     */
    private PgDiffTypes() {
    }
}
