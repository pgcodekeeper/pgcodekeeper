/**
 * Copyright 2010 StartNet s.r.o.
 */
package cz.startnet.utils.pgdiff;

import java.io.PrintWriter;

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
        // TODO is this search_path setting sufficient ?
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
            writer.println();
            writer.println(searchPath);
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
