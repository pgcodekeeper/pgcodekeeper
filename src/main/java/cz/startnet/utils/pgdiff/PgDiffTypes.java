package cz.startnet.utils.pgdiff;

import java.util.Objects;

import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgType.PgTypeForm;

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
            } else {
            	PgType oldType = oldSchema.getType(type.getName());
            	if (!oldType.getForm().equals(type.getForm())) {
            		searchPathHelper.outputSearchPath(script);
                    PgDiff.writeCreationSql(script, null, type, true);
            	} else if (!type.equals(oldType) 
						&&!canAlter(type)) {
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
		for (final PgType type : oldSchema.getTypes()) {
			if (!newSchema.containsType(type.getName())) {
				searchPathHelper.outputSearchPath(script);
				PgDiff.writeDropSql(script, null, type);
			} else {
				PgType newType = newSchema.getType(type.getName());
				if (!type.getForm().equals(newType.getForm())){
					searchPathHelper.outputSearchPath(script);
					PgDiff.writeDropSql(script, null, type);
				} else if (!type.equals(newType) 
						&&!canAlter(type)) {
					searchPathHelper.outputSearchPath(script);
					PgDiff.writeDropSql(script, null, type);
				}
			}
		}
	}
	
	private static boolean canAlter(PgType type) {
		switch (type.getForm()) {
		case BASE:
		case RANGE:
		case SHELL:
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
            		&& canAlter(oldType)) {
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
	            if (sb.length() == 0 &&
	            		oldType.getForm() == PgTypeForm.ENUM) {
	            	searchPathHelper.outputSearchPath(script);
					PgDiff.writeDropSql(script, null, oldType);
					PgDiff.writeCreationSql(script, null, newType, true);
					continue;
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
