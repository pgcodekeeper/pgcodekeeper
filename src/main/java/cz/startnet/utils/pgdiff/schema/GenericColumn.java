package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;
import java.util.Objects;

public final class GenericColumn implements Serializable{
/**
     * 
     */
    private static final long serialVersionUID = -5032985077177033449L;
// SONAR-OFF
    public final String schema;
    public final String table;
    public final String column;
// SONAR-ON
    private ViewReference type= ViewReference.COLUMN;
    
    public GenericColumn(String schema, String table, String column) {
        this.schema = schema;
        this.table = table;
        this.column = column;
    }
    
    public GenericColumn setType(ViewReference type) {
        this.type = type;
        return this;
    }
    
    public ViewReference getType() {
        return type;
    }
    
    public GenericColumn(String table, String column) {
        this(null, table, column);
    }
    
    public GenericColumn(String column) {
        this(null, column);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((column == null) ? 0 : column.hashCode());
        result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        result = prime * result + ((table == null) ? 0 : table.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        
        if (this == obj) {
            eq = true;
        } else if (obj instanceof GenericColumn) {
            GenericColumn col = (GenericColumn) obj;
            eq = Objects.equals(schema, col.schema)
                    && Objects.equals(table, col.table)
                    && Objects.equals(column, col.column);
        }
        
        return eq;
    }
    
    @Override
    public String toString() {
        return "schema: \"" + schema + "\"; table: \"" + table
                + "\"; column: \"" + column + "\";";
    }
    
    public enum ViewReference {
        COLUMN,
        FUNCTION,
        TABLE,
        SYSTEM
    }
}