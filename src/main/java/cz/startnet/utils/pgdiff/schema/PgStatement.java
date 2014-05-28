package cz.startnet.utils.pgdiff.schema;

/**
 * The superclass for general pgsql statement.
 * All changes to hashed fields of extending classes must be
 * followed by a {@link #resetHash()} call. 
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
    
    private volatile int hash;
    private volatile boolean hashComputed;
    
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
    
    /**
     * @return Always returns just the object's name.
     */
    public final String getBareName() {
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
    
    abstract public String getDropSQL();
    
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
     * Shallow version of {@link #equals(Object)}
     */
    abstract public boolean compare(PgStatement obj);
    
    /**
     * Computes new value of hash code for this object, called by {@link #hashCode()}
     * 
     * @return computed hash code of this object
     */
    abstract protected int computeHash();
    
    /**
     * Compares this object and all its children with another statement.<br>
     * This default version falls back to {@link #compare(PgStatement)}.
     * Override for any object with nested children!<br><br>
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj){
        return (obj instanceof PgStatement)? this.compare((PgStatement) obj) : false;
    }
    
    @Override
    public int hashCode(){
        if (!hashComputed){
            hash = computeHash();
            hashComputed = true;
        }
        return hash;
    }
    
    protected void resetHash(){
        PgStatement st = this;
        while (st != null){
            st.hashComputed = false;
            st = st.getParent();
        }
    }
}
