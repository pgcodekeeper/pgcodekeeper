package cz.startnet.utils.pgdiff;

import java.util.List;

import cz.startnet.utils.pgdiff.schema.PgConstraint;

/**
 * Diff Domains
 */
public final class PgDiffDomains {
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
