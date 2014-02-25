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
	
	protected final String name;
	
	private PgStatement parent;
	
	public PgStatement(String name, String rawStatement) {
        this.name = name;
		this.rawStatement = rawStatement;
	}
	
	public String getRawStatement() {
		return rawStatement;
	}
	
	public String getName() {
	    return name;
	}
	
	public PgStatement getParent() {
	    return parent;
	}
	
	public void setParent(PgStatement parent) {
	    if(this.parent != null) {
	        throw new IllegalStateException("Statement already has a parent: "
	                + this.getClass() + " Name: " + this.getName());
	    }
	    
	    this.parent = parent;
	}
	
	abstract public String getCreationSQL();
	
	/**
	 * Copies all object properties into a new object and leaves all its children empty.
	 * 
	 * @return shallow copy of a DB object.
	 */
	abstract public PgStatement shallowCopy();
	
	/**
	 * Performs {@link #shallowCopy()} on this object and all its children.
	 * 
	 * @return a fully recursive copy of this statement.
	 */
	abstract public PgStatement deepCopy();
	
	/**
	 * This method does not account for nested child PgStatements.
	 * Shallow {@link #equals(Object)}
	 */
	abstract public boolean compare(PgStatement obj);
	
	/**
     * Compares this object and all its children with another statement.<br>
     * This default version falls back to {@link #compare(PgStatement)}.
     * Override for any object with children!<br><br>
     * 
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj){
	    return (obj instanceof PgStatement)? this.compare((PgStatement) obj) : false;
	}
	
	@Override
	abstract public int hashCode();
}
