package cz.startnet.utils.pgdiff;

import java.util.List;
import java.util.Objects;

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
	public static void createDomains(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
		for (final PgDomain domain : newSchema.getDomains()) {
            if (oldSchema == null
                    || !oldSchema.containsDomain(domain.getName())) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, null, searchPathHelper, domain);
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeCreationSql(script, null, domain, true);
            } else {
            	PgDomain oldDomain = oldSchema.getDomain(domain.getName());
            	if (oldDomain != null 
            			&& (!Objects.equals(oldDomain.getDataType(), domain.getDataType())
    					|| !Objects.equals(oldDomain.getCollation(), domain.getCollation()))) {
            		searchPathHelper.outputSearchPath(script);
            		PgDiff.writeCreationSql(script, null, domain, true);
            	}
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
        for (final PgDomain domain : oldSchema.getDomains()) {
            if (!newSchema.containsDomain(domain.getName())) {
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, domain);
            } else {
            	PgDomain newDomain = newSchema.getDomain(domain.getName());
            	if (newDomain != null 
            			&& (!Objects.equals(newDomain.getDataType(), domain.getDataType())
            			|| !Objects.equals(newDomain.getCollation(), domain.getCollation()))) {
            		searchPathHelper.outputSearchPath(script);
            		PgDiff.writeDropSql(script, null, domain);
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
			final PgDomain oldDomain =
                    oldSchema.getDomain(newDomain.getName());

            if (oldDomain == null) {
                continue;
            }
            if (!Objects.equals(newDomain.getDataType(), oldDomain.getDataType())
        			|| !Objects.equals(newDomain.getCollation(), oldDomain.getCollation())) {
            	continue;
            }
            sbSQL.setLength(0);
            
            StringBuilder sb = new StringBuilder();
			if (!Objects.equals(newDomain.getDefaultValue(),
					oldDomain.getDefaultValue())) {
            	if (newDomain.getDefaultValue() == null) {
            		sb.append("\n\tDROP DEFAULT");
            	} else {
            		sb.append("\n\tSET DEFAULT ").append(newDomain.getDefaultValue());
            	}
            }
			if (sb.length() > 0) {
				sbSQL.append("\nALTER DOMAIN ").append(newDomain.getName()).append(sb).append(";");
			}
			
			sb.setLength(0);
			if (newDomain.isNotNull() != oldDomain.isNotNull()) {
				if (newDomain.isNotNull()) {
					sb.append("\n\tSET NOT NULL");
				} else {
					sb.append("\n\tDROP NOT NULL");
				}
			}
			if (sb.length() > 0) {
				sbSQL.append("\nALTER DOMAIN ").append(newDomain.getName()).append(sb).append(";");
			}
			
			compareConstraints(newDomain.getName(), oldDomain.getConstraints(),
					newDomain.getConstraints(), sbSQL);
			compareConstraints(newDomain.getName(), oldDomain.getConstrsNotValid(),
					newDomain.getConstrsNotValid(), sbSQL);
			
			if (!oldDomain.equals(newDomain)
            		&& sbSQL.length() == 0) {
            	script.addDrop(oldDomain, null, oldDomain.getDropSQL());
            	script.addCreate(newDomain, null, newDomain.getCreationSQL(), true);
			} else {
				script.addStatement(sbSQL.toString());
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
	}
	
	private static void compareConstraints(String domainName, List<PgConstraint> oldDomain,
			List<PgConstraint> newDomain, StringBuilder sbSQL) {
		for (PgConstraint oldConstr : oldDomain) {
			if (!newDomain.contains(oldConstr)) {
				sbSQL.append("\nALTER DOMAIN ").append(domainName)
						.append("\n\tDROP CONSTRAINT ")
						.append(oldConstr.getName()).append(";");
			}
		}
		
		for (PgConstraint newConstr : newDomain) {
			if (!oldDomain.contains(newConstr)) {
				sbSQL.append("\nALTER DOMAIN ").append(domainName)
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
