package cz.startnet.utils.pgdiff;

import java.util.Objects;

import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgType;

/**
 * Diff Types
 */
public final class PgDiffTypes {
	
	/**
     * Outputs statements for creation of new types.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
	public static void createTypes(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
		for (final PgType type : newSchema.getTypes()) {
            if (oldSchema == null
                    || !oldSchema.containsType(type.getName())) {
                PgDiff.addUniqueDependenciesOnCreateEdit(script, null, searchPathHelper, type);
                
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
        for (final PgType type : oldSchema.getTypes()) {
            if (!newSchema.containsType(type.getName())) {
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, type);
            }
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
            sbSQL.setLength(0);
            
            StringBuilder atrrSb = new StringBuilder();
            for (PgColumn attr : newType.getAttrs()) {
				if (oldType.getAtt(attr.getName()) != null
						&& !oldType.getAttrs().contains(attr)) {
					atrrSb.append("\nALTER ATTRIBUTE ").append(attr.getName())
							.append(" TYPE ")
							.append(attr.getFullDefinition(false, null))
							.append(", ");
            	} else {
					atrrSb.append("\nADD ATTRIBUTE ").append(attr.getName())
							.append(" ")
							.append(attr.getFullDefinition(false, null))
							.append(", ");
            	}
            }
            for (PgColumn attr : oldType.getAttrs()) {
            	if (!newType.getAttrs().contains(attr)) {
            		atrrSb.append("\nDROP ATTRIBUTE ").append(attr.getName())
							.append(", ");
            	}
            }
            
            if (atrrSb.length() > 0) {
				sbSQL.append("\nALTER TYPE ").append(newType.getName())
						.append(atrrSb).append(";");
            }
            
            for (String enume : newType.getEnums()) {
            	if (!oldType.getEnums().contains(enume)) {
					sbSQL.append("\nALTER TYPE ").append(newType.getName())
							.append(" ADD VALUE ").append(enume).append(";");
            	}
            }
            
            if (sbSQL.length() == 0) {
            	script.addDrop(oldType, null, oldType.getDropSQL());
            	script.addCreate(newType, null, newType.getCreationSQL(), true);
			} else {
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
