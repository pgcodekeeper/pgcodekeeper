package cz.startnet.utils.pgdiff.schema;

/**
 * The superclass for general pgsql statement.
 * 
 * @author Alexander Levsha
 */
abstract public class PgStatement {	
	/**
	 * The statement as it's been read from dump before parsing.
	 */
	private final String rawStatement;
	
	/**
	 * Creates a new PgStatement object
	 * 
	 * @param statement {@link #rawStatement}
	 */
	public PgStatement(final String rawStatement) {
		this.rawStatement = rawStatement;
	}
	
	/**
	 * Getter for {@link #rawStatement}
	 * 
	 * @return {@link #rawStatement}
	 */
	public String getRawStatement() {
		return rawStatement;
	}
	
	/**
	 * Abstraction to get name of the object statement defines.
	 * 
	 *  @return object's name
	 */
	abstract public String getName();
	
	/**
	 * Abstraction for creating SQL for creation of the object.
     *
     * @return created SQL
	 */
	abstract public String getCreationSQL();
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param obj {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	abstract public boolean equals(Object obj);
}

