package cz.startnet.utils.pgdiff.schema;

public class PgStatement {
	
	/**
	 * The superclass for general pgsql statement
	 * 
	 * @author Alexander Levsha
	 */
	
	/**
	 * The statement as it's been read from dump before parsing.
	 */
	private String rawStatement;
	
	/**
	 * Getter for {@link #rawStatement}
	 * 
	 * @return {@link #rawStatement}
	 */
	public String getRawStatement() {
		return rawStatement;
	}
	
	/**
	 * Setter for {@link #rawStatement}
	 * 
	 * @param rawStatement {@link #rawStatement}
	 */
	public void setRawStatement(String rawStatement) {
		this.rawStatement = rawStatement;
	}

}
