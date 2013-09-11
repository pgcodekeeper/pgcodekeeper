package cz.startnet.utils.pgdiff.schema;

/**
 * The superclass for general pgsql statement.
 * 
 * @author Alexander Levsha
 */
public class PgStatement {	
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
}

