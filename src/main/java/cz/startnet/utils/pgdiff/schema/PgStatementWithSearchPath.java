package cz.startnet.utils.pgdiff.schema;

/**
 * The superclass for general pgsql statement with search_path.
 * That is any but SCHEMA and EXTENSION.
 * 
 * @author Alexander Levsha
 */
public abstract class PgStatementWithSearchPath extends PgStatement {
    /**
     * Last SET search_path preceding this statement
     */
    private final String searchPath;
    
    public PgStatementWithSearchPath(String name,
            String rawStatement, String searchPath) {
        super(name, rawStatement);
        this.searchPath = searchPath;
    }
    
    public String getSearchPath() {
        return searchPath;
    }
    
    abstract public PgStatement getContainerSchema();
}
