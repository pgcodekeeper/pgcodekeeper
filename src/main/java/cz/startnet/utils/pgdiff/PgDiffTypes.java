package cz.startnet.utils.pgdiff;

import java.util.LinkedHashSet;
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
    
    private static boolean canAlter(PgType oldType, PgType newType) {
        if (oldType.getForm() != newType.getForm()) {
            return false;
        }
        switch (oldType.getForm()) {
        case ENUM:
            for (String enume : newType.getEnums()) {
                if (!oldType.getEnums().contains(enume)) {
                    return true;
                }
            }
            return false;
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
            
            for (String enume : newType.getEnums()) {
                if (!oldType.getEnums().contains(enume)) {
                    if (sbSQL.length() != 0) {
                        sbSQL.append("\n\n");
                    }
                    sbSQL.append("ALTER TYPE ")
                            .append(PgDiffUtils.getQuotedName(newType.getName()))
                            .append("\n\tADD VALUE ").append(enume).append(';');
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
