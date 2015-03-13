package cz.startnet.utils.pgdiff;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

/**
 * Diff Domains
 */
public final class PgDiffDomains {

    /**
     * Outputs statements for creation of new domains.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void createDomains(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgDomain domain : newSchema.getDomains()) {
            PgDomain oldDomain = oldSchema == null ? null : oldSchema.getDomain(domain.getName());
            if (oldDomain == null ||
                    !Objects.equals(oldDomain.getDataType(), domain.getDataType()) ||
                    !Objects.equals(oldDomain.getCollation(), domain.getCollation())) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, null, searchPathHelper, domain);
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeCreationSql(script, null, domain, true);
            }
        }
    }
    
    /**
     * Outputs statements for dropping of domains that do not exist anymore.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropDomains(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        // Drop domains that do not exist in new schema
        for (final PgDomain oldDomain : oldSchema.getDomains()) {
            PgDomain newDomain = newSchema.getDomain(oldDomain.getName());
            if (newDomain == null ||
                    !Objects.equals(newDomain.getDataType(), oldDomain.getDataType()) ||
                    !Objects.equals(newDomain.getCollation(), oldDomain.getCollation())) {
                Set<PgStatement> dependantsSet = new LinkedHashSet<>();
                PgDiff.getDependantsSet(oldDomain, dependantsSet);
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
                                "-- DEPCY: This object depends on the domain"
                                + " we are about to drop: " + oldDomain.getName(),
                                depnt);
                    }
                }
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, oldDomain);
                
                // create dependants
                for (PgStatement depnt : dependants) {
                    
                    if (depnt instanceof PgFunction
                            || depnt instanceof PgTable) {
                        PgDiff.tempSwitchSearchPath(
                                depnt.getParent().getName(),
                                searchPathHelper, script);
                        PgDiff.writeCreationSql(script,
                                "-- DEPCY: This object depends on the domain"
                                + " we are about to create: " + oldDomain.getName(),
                                depnt, true);
                    }
                }
            }
        }
    }
    
    /**
     * Outputs statement for modified domains.
     *
     * @param writer           writer the output should be written to
     * @param arguments        object containing arguments settings
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */    
    public static void alterDomains(final PgDiffScript script,
            final PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }
        final StringBuilder sbSQL = new StringBuilder();
        for (final PgDomain newDomain : newSchema.getDomains()) {
            PgDomain oldDomain = oldSchema.getDomain(newDomain.getName());

            if (oldDomain == null) {
                continue;
            }
            if (!Objects.equals(newDomain.getDataType(), oldDomain.getDataType()) ||
                    !Objects.equals(newDomain.getCollation(), oldDomain.getCollation())) {
                continue;
            }
            sbSQL.setLength(0);
            
            if (!Objects.equals(newDomain.getDefaultValue(), oldDomain.getDefaultValue())) {
                if (sbSQL.length() != 0) {
                    sbSQL.append("\n\n");
                }
                sbSQL.append("ALTER DOMAIN ").append(PgDiffUtils.getQuotedName(newDomain.getName()));
                if (newDomain.getDefaultValue() == null) {
                    sbSQL.append("\n\tDROP DEFAULT");
                } else {
                    sbSQL.append("\n\tSET DEFAULT ").append(newDomain.getDefaultValue());
                }
                sbSQL.append(';');
            }
            
            if (newDomain.isNotNull() != oldDomain.isNotNull()) {
                if (sbSQL.length() != 0) {
                    sbSQL.append("\n\n");
                }
                sbSQL.append("ALTER DOMAIN ").append(PgDiffUtils.getQuotedName(newDomain.getName()));
                if (newDomain.isNotNull()) {
                    sbSQL.append("\n\tSET NOT NULL");
                } else {
                    sbSQL.append("\n\tDROP NOT NULL");
                }
                sbSQL.append(';');
            }
            
            compareConstraints(newDomain.getName(), oldDomain.getConstraints(),
                    newDomain.getConstraints(), sbSQL);
            compareConstraints(newDomain.getName(), oldDomain.getConstrsNotValid(),
                    newDomain.getConstrsNotValid(), sbSQL);
            
            if (sbSQL.length() > 0) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(sbSQL.toString());
            }
            if (!Objects.equals(oldDomain.getOwner(), newDomain.getOwner())) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(newDomain.getOwnerSQL());
            }
            if (!oldDomain.getPrivileges().equals(newDomain.getPrivileges())) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(newDomain.getPrivilegesSQL());
            }
            PgDiff.diffComments(oldDomain, newDomain, script);
        }
    }
    
    private static void compareConstraints(String domainName, List<PgConstraint> oldDomain,
            List<PgConstraint> newDomain, StringBuilder sbSQL) {
        for (PgConstraint oldConstr : oldDomain) {
            if (!newDomain.contains(oldConstr)) {
                if (sbSQL.length() != 0) {
                    sbSQL.append("\n\n");
                }
                sbSQL.append("ALTER DOMAIN ").append(domainName)
                        .append("\n\tDROP CONSTRAINT ")
                        .append(oldConstr.getName()).append(";");
            }
        }
        
        for (PgConstraint newConstr : newDomain) {
            if (!oldDomain.contains(newConstr)) {
                if (sbSQL.length() != 0) {
                    sbSQL.append("\n\n");
                }
                sbSQL.append("ALTER DOMAIN ").append(domainName)
                        .append("\n\tADD CONSTRAINT ")
                        .append(newConstr.getName()).append(" ")
                        .append(newConstr.getDefinition()).append(";");
            }
        }
    }
    
    /**
     * Creates a new instance of {@link PgDiffDomains}.
     */
    private PgDiffDomains() {
    }
}
