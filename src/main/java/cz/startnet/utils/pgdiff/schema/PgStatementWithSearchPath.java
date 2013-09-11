package cz.startnet.utils.pgdiff.schema;

/**
 * The superclass for general pgsql statement with search_path.
 * That is any but SCHEMA and EXTENSION.
 * 
 * @author Alexander Levsha
 */
public class PgStatementWithSearchPath extends PgStatement {
	/**
	 * Last SET search_path preceding this statement
	 */
	private final String searchPath;
	
	/**
	 * Creates a new PgStatement object with searchPath
	 * 
	 * @param statement {@link #rawStatement}
	 * @param searchPath {@link #searchPath}
	 */
	public PgStatementWithSearchPath(final String rawStatement, 
			final String searchPath) {
		super(rawStatement);
		this.searchPath = searchPath;
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
