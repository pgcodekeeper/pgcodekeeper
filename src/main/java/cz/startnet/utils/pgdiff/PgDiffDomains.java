package cz.startnet.utils.pgdiff;

import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgSchema;

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
    public static void createDomains(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgDomain domain : newSchema.getDomains()) {
            PgDomain oldDomain = oldSchema == null ? null : oldSchema.getDomain(domain.getName());
            if (oldDomain == null) {
                depRes.addCreateStatements(domain);
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
    public static void dropDomains(final DepcyResolver depRes,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }

        // Drop domains that do not exist in new schema
        for (final PgDomain oldDomain : oldSchema.getDomains()) {
            if (!newSchema.containsDomain(oldDomain.getName())) {
                depRes.addDropStatements(oldDomain);
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
    public static void alterDomains(final DepcyResolver depRes,
            final PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }
        for (final PgDomain oldDomain : oldSchema.getDomains()) {
            depRes.addAlterStatements(oldDomain,
                    newSchema.getDomain(oldDomain.getName()));
        }
    }
    
    public static void compareConstraints(String domainName, List<PgConstraint> oldDomain,
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
    
    private PgDiffDomains() {
    }
}
