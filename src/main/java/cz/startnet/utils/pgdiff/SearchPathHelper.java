/**
 * Copyright 2010 StartNet s.r.o.
 */
package cz.startnet.utils.pgdiff;


/**
 * Helps to output search path only if it was not output yet.
 *
 * @author fordfrog
 */
public class SearchPathHelper {

    private final String searchPath;
    private final String schemaName;
    private boolean wasOutput;

    /**
     * Creates new instance of SearchPathHelper.
     *
     * @param unquotedSchemaName {@link #searchPath}
     */
    public SearchPathHelper(final String unquotedSchemaName) {
        this.schemaName = unquotedSchemaName;
        this.searchPath = "SET search_path = "
                + PgDiffUtils.getQuotedName(unquotedSchemaName, true)
                + ", pg_catalog;";
    }

    /**
     * Outputs search path if it was not output yet.
     *
     * @param writer writer
     */
    public void outputSearchPath(final PgDiffScript script) {
        if (!wasOutput && !schemaName.isEmpty()) {
            script.addStatement(searchPath);
            wasOutput = true;
        }
    }
    
    public void setWasOutput(boolean wasOutput){
        this.wasOutput = wasOutput;
    }
    
    public boolean getWasOutput(){
       return wasOutput;
    }
    
    public String getSchemaName(){
        return this.schemaName;
    }
}
