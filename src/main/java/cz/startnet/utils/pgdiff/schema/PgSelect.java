package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PgSelect extends PgStatementWithSearchPath {
    
    private final List<SelectColumn> columns = new ArrayList<>(10);
    
    public PgSelect(String rawStatement, String searchPath) {
        super(null, rawStatement, searchPath);
    }
    
    /**
     * Adds a column to the column list if it doesn't contain the same column.
     */
    public void addColumn(SelectColumn column) {
        if (!columns.contains(column)) {
            columns.add(column);
        }
    }
    
    /**
     * @return unmodifiable copy of columns
     */
    public List<SelectColumn> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    @Override
    public String getCreationSQL() {
        return null;
    }

    @Override
    public PgSelect shallowCopy() {
        PgSelect selectDst = new PgSelect(getRawStatement(), getSearchPath());
        selectDst.columns.addAll(columns);
        return selectDst;
    }

    @Override
    public PgSelect deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;
        
        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgSelect) {
            PgSelect select = (PgSelect) obj;
            eq = Objects.equals(columns, select.columns);
        }
        
        return eq;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((columns == null) ? 0 : columns.hashCode());
        return result;
    }

    public final static class SelectColumn {
        public final String schema;
        public final String table;
        public final String column;
        
        public SelectColumn(String schema, String table, String column) {
            this.schema = schema;
            this.table = table;
            this.column = column;
        }
        
        public SelectColumn(String table, String column) {
            this(null, table, column);
        }
        
        public SelectColumn(String column) {
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
            } else if (obj instanceof SelectColumn) {
                SelectColumn column = (SelectColumn) obj;
                eq = Objects.equals(schema, column.schema)
                        && Objects.equals(table, column.table)
                        && Objects.equals(column, column.column);
            }
            
            return eq;
        }
    }
}
