/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Stores database information.
 *
 * @author fordfrog
 */
public class PgDatabase extends PgStatement {

    /**
     * List of database schemas.
     */
    private final List<PgSchema> schemas = new ArrayList<PgSchema>(1);
    /**
     * List of database extensions.
     */
    private final List<PgExtension> extensions = new ArrayList<PgExtension>(1);
    /**
     * Array of ignored statements.
     */
    private final List<String> ignoredStatements = new ArrayList<String>();
    /**
     * Array of ignored data statements.
     */
    private final List<String> ignoredDataStatements = new ArrayList<String>();
    /**
     * Current default schema.
     */
    private PgSchema defaultSchema;
    /**
     * Comment.
     */
    private String comment;

    /**
     * Creates a new PgDatabase object.
     */
    public PgDatabase() {
        super(null);
        
        schemas.add(new PgSchema("public", null));
        defaultSchema = schemas.get(0);
    }

    /**
     * Getter for {@link #comment}.
     *
     * @return {@link #comment}
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for {@link #comment}.
     *
     * @param comment {@link #comment}
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * Sets default schema according to the {@code name} of the schema.
     *
     * @param name name of the schema
     */
    public void setDefaultSchema(final String name) {
        defaultSchema = getSchema(name);
    }

    /**
     * Getter for {@link #defaultSchema}.
     *
     * @return {@link #defaultSchema}
     */
    public PgSchema getDefaultSchema() {
        return defaultSchema;
    }

    /**
     * Getter for {@link #ignoredStatements}.
     *
     * @return {@link #ignoredStatements}
     */
    public List<String> getIgnoredStatements() {
        return Collections.unmodifiableList(ignoredStatements);
    }
    
    /**
     * Getter for {@link #ignoredDataStatements}.
     *
     * @return {@link #ignoredDataStatements}
     */
    public List<String> getIgnoredDataStatements() {
        return Collections.unmodifiableList(ignoredDataStatements);
    }

    /**
     * Adds ignored statement to the list of ignored statements.
     *
     * @param ignoredStatement ignored statement
     */
    public void addIgnoredStatement(final String ignoredStatement) {
        ignoredStatements.add(ignoredStatement);
    }
    
    /**
     * Adds ignored data statement to the list of ignored data statements.
     *
     * @param ignoredDataStatement ignored data statement
     */
    public void addIgnoredDataStatement(final String ignoredDataStatement) {
        ignoredDataStatements.add(ignoredDataStatement);
    }

    /**
     * Returns schema of given name or null if the schema has not been found. If
     * schema name is null then default schema is returned.
     *
     * @param name schema name or null which means default schema
     *
     * @return found schema or null
     */
    public PgSchema getSchema(final String name) {
        if (name == null) {
            return getDefaultSchema();
        }

        for (final PgSchema schema : schemas) {
            if (schema.getName().equals(name)) {
                return schema;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #schemas}. The list cannot be modified.
     *
     * @return {@link #schemas}
     */
    public List<PgSchema> getSchemas() {
        return Collections.unmodifiableList(schemas);
    }

    /**
     * Adds {@code schema} to the list of schemas.
     *
     * @param schema schema
     */
    public void addSchema(final PgSchema schema) {
        schemas.add(schema);
    }
    
    /**
     * Returns extension of given name or null if the extension has not been found.
     * 
     * @param name extension name
     * 
     * @return found extension or null
     */
    public PgExtension getExtension(final String name) {
    	for(final PgExtension ext : extensions) {
    		if(ext.getName().equals(name)) {
    			return ext;
    		}
    	}
    	
    	return null;
    }
    
    /**
     * Getter for {@link #extensions}. The list cannot be modified.
     * 
     * @return {@link #extensions}
     */
    public List<PgExtension> getExtensions() {
    	return Collections.unmodifiableList(extensions);
    }
    
    /**
     * Adds {@code #extension} to the list of extension.
     * 
     *  @param extension extension
     */
    public void addExtension(final PgExtension extension) {
    	extensions.add(extension);
    }
    
    @Override
    public String getCreationSQL() {
        return null;
    }
    
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        
        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgDatabase) {
            PgDatabase db = (PgDatabase) obj;
            
            eq = new HashSet<>(extensions).equals(new HashSet<>(db.extensions))
                    && new HashSet<>(schemas).equals(new HashSet<>(db.schemas));
        }
        
        return eq;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + new HashSet<>(extensions).hashCode();
        result = prime * result + new HashSet<>(schemas).hashCode();
        return result;
    }

    @Override
    public PgDatabase shallowCopy() {
        PgDatabase dbDst = new PgDatabase();
        dbDst.setComment(getComment());
        return dbDst;
    }
    
    @Override
    public PgDatabase deepCopy() {
        PgDatabase copy = shallowCopy();
        
        for(PgExtension ext : extensions) {
            copy.addExtension(ext.deepCopy());
        }
        for(PgSchema schema : schemas) {
            if(schema.getName().equals("public")) {
                copy.schemas.remove(copy.getSchema("public"));
            }
            copy.addSchema(schema.deepCopy());
        }
        
        return copy;
    }
}
