package cz.startnet.utils.pgdiff.schema;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores extension information.
 *
 * @author Alexander Levsha
 */
public class PgExtension extends PgStatement {
	
	/**
	 * Name of the extension.	
	 */
	private final String name;
	
	/**
	 * Schema of the extension.
	 */
	private String schema;
	
	/**
	 * Version.
	 */
	private String version;

	/**
	 * From old version.
	 */
	private String oldVersion;
	
	/**
	 * Comment
	 */
	private String comment;
	
	/**
	 * Creates a new PgExtension object.
	 * 	
	 * @param name {@link #name}
	 * @param rawStatement {@link #rawStatement}
	 */
	public PgExtension(final String name, final String rawStatement) {
		super(rawStatement);
		this.name = name;
	}
	
	/**
	 * Getter for {@link #name}.
	 * 
	 * @return {@link #name}
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for {@link #schema}.
	 * 
	 * @return {@link #schema}
	 */
	public String getSchema() {
		return schema;
	}
	
	/**
	 * Setter for {@link #schema}.
	 * 
	 * @param schema {@link #schema}
	 */
	public void setSchema(final String schema) {
		this.schema = schema;
	}
	
	/**
	 * Getter for {@link #version}.
	 * 
	 * @return {@link #version}
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * Setter for {@link #version}.
	 * 
	 * @param version {@link #version}
	 */
	public void setVersion(final String version) {
		this.version = version;
	}
	
	/**
	 * Getter for {@link #oldVersion}.
	 * 
	 * @return {@link #oldVersion}
	 */
	public String getOldVersion() {
		return oldVersion;
	}
	
	/**
	 * Setter for {@link #oldVersion}.
	 * 
	 * @param oldVersion {@link #oldVersion}
	 */
	public void setOldVersion(final String oldVersion) {
		this.oldVersion = oldVersion;
	}
	
	/**
	 * Getter for {@link #comment}.
	 * 
	 * @return {@link #comment}
	 */
	public String getComment() {
		return comment;
	}
	
	/**
	 * Setter for {@link #comment}.
	 * 
	 * @param comment {@link #comment}
	 */
	public void setComment(final String comment) {
		this.comment = comment;
	}
	
	/**
	 * Creates and returns SQL for creation of the extension.
	 * 
	 * @return created SQL
	 */
	public String getCreationSQL() {
		final StringBuilder sbSQL = new StringBuilder(50);
		sbSQL.append("CREATE EXTENSION ");
		sbSQL.append(PgDiffUtils.getQuotedName(getName()));
		
		if(getSchema() != null && !getSchema().isEmpty()) {
			sbSQL.append(" SCHEMA ");
			sbSQL.append(getSchema());
		}
		
		if(getVersion() != null && !getVersion().isEmpty()) {
			sbSQL.append(" VERSION ");
			sbSQL.append(getVersion());
		}
		
		if(getOldVersion() != null && !getOldVersion().isEmpty()) {
			sbSQL.append(" FROM ");
			sbSQL.append(getOldVersion());
		}
		
		sbSQL.append(';');
		
		if(getComment() != null && !getComment().isEmpty()) {
			sbSQL.append("\n\nCOMMENT ON EXTENSION ");
			sbSQL.append(PgDiffUtils.getQuotedName(getName()));
			sbSQL.append(" IS ");
			sbSQL.append(comment);
			sbSQL.append(';');
		}
		
		return sbSQL.toString();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param obj {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		boolean eq = false;
		
		if(this == obj) {
			eq = true;
		} else if(obj instanceof PgExtension) {
			final PgExtension ext = (PgExtension) obj;
			eq = name.equals(ext.getName()) 
					&& schema.equals(ext.getSchema())
					&& version.equals(ext.getVersion())
					&& oldVersion.equals(ext.getOldVersion());
		}
		
		return eq;
	}
}
