package cz.startnet.utils.pgdiff.schema;

/**
 * The superclass for general pgsql statement
 * 
 * @author Alexander Levsha
 */
public class PgStatement {	
	/**
	 * The statement as it's been read from dump before parsing.
	 */
	private final String rawStatement;
	/**
	 * Last SET search_path preceding this statement
	 */
	private final String searchPath;
	
	/**
	 * Creates a new PgStatement object
	 * 
	 * @param statement {@link #rawStatement}
	 */
	public PgStatement(final String rawStatement) {
		this.rawStatement = rawStatement;
		this.searchPath = null;
	}
	
	/**
	 * Creates a new PgStatement object with searchPath
	 * 
	 * @param statement {@link #rawStatement}
	 * @param searchPath {@link #searchPath}
	 */
	public PgStatement(final String rawStatement, 
			final String searchPath) {
		this.rawStatement = rawStatement;
		this.searchPath = searchPath;
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
	 * Getter for {@link #searchPath}
	 * 
	 * @return {@link #searchPath}
	 */
	public String getSearchPath() {
		return searchPath;
	}
	
}
