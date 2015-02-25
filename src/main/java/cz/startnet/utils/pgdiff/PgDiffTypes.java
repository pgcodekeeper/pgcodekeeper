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
			if (oldSchema == null || !oldSchema.containsType(type.getName())) {
				PgDiff.addUniqueDependenciesOnCreateEdit(script, null,
						searchPathHelper, type);

				searchPathHelper.outputSearchPath(script);
				PgDiff.writeCreationSql(script, null, type, true);
			} else {
				PgType oldType = oldSchema.getType(type.getName());
				if (!oldType.getForm().equals(type.getForm())
						|| (!type.equals(oldType) && !canAlter(oldType, type))) {
					PgDiff.addUniqueDependenciesOnCreateEdit(script, null,
							searchPathHelper, type);
					searchPathHelper.outputSearchPath(script);
					PgDiff.writeCreationSql(script, null, type, true);
				}
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
			if (!newSchema.containsType(oldType.getName())
					|| !oldType.getForm().equals(newType.getForm())
					|| (!oldType.equals(newType) && !canAlter(oldType, newType))) {
				
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
		switch (oldType.getForm()) {
		case BASE:
		case RANGE:
		case SHELL:
			return false;
		case ENUM:
			for (String enume : newType.getEnums()) {
				if (!oldType.getEnums().contains(enume)) {
					return true;
				}
			}
			return false;
		default:
			return true;
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
		for (final PgType newType : newSchema.getTypes()) {
			final PgType oldType =
                    oldSchema.getType(newType.getName());

            if (oldType == null) {
                continue;
            }
            if (oldType.equals(newType)) {
            	continue;
            }
            sbSQL.setLength(0);
            if (newType.getForm().equals(oldType.getForm())
            		&& canAlter(oldType, newType)) {
	            StringBuilder atrrSb = new StringBuilder();
	            for (PgColumn attr : newType.getAttrs()) {
					PgColumn oldAttr = oldType.getAtt(attr.getName());
					if (oldAttr != null) {
						if (!oldAttr.getType().equals(attr.getType())) {
							atrrSb.append("\n\tALTER ATTRIBUTE ")
									.append(attr.getName())
									.append(" TYPE ")
									.append(attr.getFullDefinition(false, null))
									.append(", ");
						}
					} else {
						atrrSb.append("\n\tADD ATTRIBUTE ").append(attr.getName())
								.append(" ")
								.append(attr.getFullDefinition(false, null))
								.append(", ");
	            	}
	            }
	            for (PgColumn attr : oldType.getAttrs()) {
	            	if (newType.getAtt(attr.getName()) == null) {
	            		atrrSb.append("\n\tDROP ATTRIBUTE ").append(attr.getName())
								.append(", ");
	            	}
	            }
	            
	            if (atrrSb.length() > 0) {
	            	atrrSb.setLength(atrrSb.length() - 2);
					sbSQL.append("\nALTER TYPE ").append(newType.getName())
							.append(atrrSb).append(";");
	            }
	            
	            StringBuilder sb = new StringBuilder();
	            for (String enume : newType.getEnums()) {
	            	if (!oldType.getEnums().contains(enume)) {
	            		sb.append("\nALTER TYPE ").append(newType.getName())
								.append("\n\tADD VALUE ").append(enume).append(";");
	            	}
	            }
	            
	            sbSQL.append(sb);
	            if (sbSQL.length() > 0) {
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
	}
	/**
     * Creates a new instance of {@link PgDiffTypes}.
     */
	private PgDiffTypes() {
	}

}
