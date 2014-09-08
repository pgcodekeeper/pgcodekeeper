package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgForeignKey;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSelect;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;

public class DbSourceJdbc extends DbSource {

    final private static Map<String, String> DATA_TYPE_ALIASES = new HashMap<String, String>(){
        {
            put("int8","bigint");
            put("serial8","bigserial");
            put("varbit","bit varying");
            put("bool","boolean");
            put("char","character");
            put("varchar","character varying");
            put("float8","double precision");
            put("int","integer");
            put("int4","integer");
            put("float4","real");
            put("int2","smallint");
            put("serial2","smallserial");
            put("serial4","serial");
            put("timetz","time with time zone");
            put("timestamptz","timestamp with time zone");
        }
    };
    
    private String host;
    private int port;
    private String user;
    private String pass;
    private Object dbName;
    private String encoding;
    
    private Connection connection;
    private DatabaseMetaData metaData;
    
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    
    DbSourceJdbc(String host, int port, String user, String pass, String dbName, String encoding) {
        super(dbName);
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.dbName = dbName;
        this.encoding = encoding;
    }

    @Override
    protected PgDatabase loadInternal(SubMonitor monitor) throws IOException {
        PgDatabase d = new PgDatabase();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(
                   "jdbc:postgresql://" + host + ":" + port + "/" + dbName, user, pass);
            metaData = connection.getMetaData();

            ResultSet res = metaData.getSchemas();
            while (res.next()) {
                PgSchema schema = getSchema(res.getString("TABLE_SCHEM"));
                d.addSchema(schema);
            }
            
            connection.close();
        } catch (SQLException e) {
            throw new IOException("database JDBC access error occured", e);
        } catch (ClassNotFoundException e) {
            throw new IOException("JDBC driver class not found", e);
        }
        return d;
    }
    
    private PgSchema getSchema(String schema) throws SQLException{
        PgSchema s = new PgSchema(schema, "");
        
        ResultSet res = metaData.getTables(null, schema, "%", new String[] {"TABLE"} );
        
        while (res.next()) {
            PgTable table = getTable(schema, res.getString("table_name"));
            s.addTable(table);
        }
        
        res = metaData.getTables(null, schema, "%", new String[] {"VIEW"} );
        while (res.next()) {
            PgView view = getView(schema, res.getString("table_name"));
            s.addView(view);
        }
        return s;
    }
    
    private PgConstraint getConstraint(String schema, String constraint) throws SQLException {
        String query = "SELECT oid FROM pg_catalog.pg_namespace WHERE nspname = '" + schema + "'";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        int schemaOid;
        if(res.next()){
            schemaOid = res.getInt("oid");
        }else{
            // TODO throw exception, log, output to console?
            System.err.println("Cannot create constraint " + constraint + ": no oid found for schema " + schema + ".");
            return null;
        }
        
        query = "SELECT contype, conrelid, consrc, conkey, confrelid, confkey FROM pg_catalog.pg_constraint WHERE connamespace = " + schemaOid + "" + " AND conname = '" + constraint + "'";
        res = stmt.executeQuery(query);
        if (!res.next()){
            // TODO throw exception, log, output to console?
            System.err.println("Cannot create constraint " + constraint + ": no constraint found.");
            return null; 
        }
                
        /**
         * Constraint types:
         * 
         *   c = check constraint
         *   f = foreign key constraint
         *   p = primary key constraint
         *   
         *   u = unique constraint
         *   t = constraint trigger
         *   x = exclusion constraint
         */
        String definition = "";
        PgConstraint c = null;
        String conType = res.getString("contype");
        c = new PgConstraint(constraint, "", getSearchPath(schema));
        
        String[] columnNames = getColumnNames(res.getArray("conkey"), res.getString("conrelid"));
        switch (conType){
            case "f":
                c = new PgForeignKey(constraint, "", getSearchPath(schema));
                String[] referencedColumnNames = getColumnNames(res.getArray("confkey"), res.getString("confrelid"));
                definition = "FOREIGN KEY (";
                // TODO code reuse
                for(int i = 0; i < columnNames.length; i++){
                    String columnName = columnNames[i];
                    definition = definition.concat(columnName);
                    if(i < columnNames.length - 1){
                        definition = definition.concat(", ");
                    }
                }
                SimpleEntry<String, String> referencedTableName = getTableNameByOid(res.getString("confrelid"));
                String schemaPrefix = "";
                if (!referencedTableName.getKey().equals(schema)){
                    schemaPrefix = referencedTableName.getKey() + ".";
                }
                definition = definition.concat(") REFERENCES " + schemaPrefix + referencedTableName.getValue() + "(");
                
                for(int i = 0; i < referencedColumnNames.length; i++){
                    String columnName = referencedColumnNames[i];
                    definition = definition.concat(columnName);
                    if(i < referencedColumnNames.length - 1){
                        definition = definition.concat(", ");
                    }
                }
                definition = definition.concat(")");
                break;
            case "p":
                definition = "PRIMARY KEY (";
                for(int i = 0; i < columnNames.length; i++){
                    String columnName = columnNames[i];
                    definition = definition.concat(columnName);
                    if(i < columnNames.length - 1){
                        definition = definition.concat(", ");
                    }
                }
                definition = definition.concat(")");
                break;
            case "c":
                definition = res.getString("consrc");
                break;
        }
        c.setDefinition(definition);
        
        // set table name
        String tableOid = res.getString("conrelid");
        if (!tableOid.equals("0")){
            query = "SELECT relname FROM pg_catalog.pg_class WHERE oid = '" + tableOid + "'";
            res = stmt.executeQuery(query);
            if(res.next()){
                c.setTableName(res.getString("relname"));
            }
        }
        
        // TODO c.setComment() ???
        return c;
    }
    
    /**
     * Returns an array of column names, resolved from conCols Array object 
     * by pg_attribute.attnum and tableOid
     * 
     * @param conCols   Array containing column numbers (references pg_attribute.attnum)
     * @param tableOid  Oid of table - owner of these columns
     * @return
     */
    private String [] getColumnNames(Array conCols, String tableOid) throws SQLException{
        Integer[] cols = (Integer[]) conCols.getArray();
        
        String query = "SELECT attname FROM pg_catalog.pg_attribute WHERE attrelid = " + tableOid + " AND attnum IN (";
        for(int i = 0; i < cols.length; i++){
            Integer colNum = cols[i];
            query = query.concat(colNum.toString());
            if (i < cols.length - 1){
                query = query.concat(", ");
            }
        }
        query = query.concat(")");
        List<String> columnNames = new ArrayList<String>(3);
        ResultSet res = connection.createStatement().executeQuery(query);
        while(res.next()){
            columnNames.add(res.getString("attname"));
        }
        return columnNames.toArray(new String[columnNames.size()]);
    }
    
    private String getTableOidByName(String tableName, String schemaOid) throws SQLException{
        String query = "SELECT oid FROM pg_catalog.pg_class WHERE relname = '" + tableName + "' AND relnamespace = " + schemaOid + " AND relkind = 'r'";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        String tableOid = null;
        if(res.next()){
            tableOid = res.getString("oid");
        }
        if (res.next()){
            // WHAT?
            throw new IllegalArgumentException("There should be only one row for table " + tableName + 
                    " in schema oid " + schemaOid + ". Modify select query to limit result to single row."); 
        }
        return tableOid;
    }
    
    private SimpleEntry<String, String> getTableNameByOid(String tableOid) throws SQLException{
        String query = "SELECT relname, relnamespace FROM pg_catalog.pg_class WHERE oid = '" + tableOid + "'";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        String tableName = null;
        String schemaOid = null;
        if(res.next()){
            schemaOid = res.getString("relnamespace");
            tableName = res.getString("relname");
        }else{
            return null;
        }
        query = "SELECT nspname FROM pg_catalog.pg_namespace WHERE oid = '" + schemaOid + "'";
        res = stmt.executeQuery(query);
        String schemaName = null;
        if(res.next()){
            schemaName = res.getString("nspname");
        }else{
            return null;
        }
        stmt.close();
        return new SimpleEntry<String, String>(schemaName, tableName);
    }
    
    private PgView getView(String schema, String view) throws SQLException {
        Statement stmt = null;
        String query = "select view_definition from INFORMATION_SCHEMA.views WHERE table_schema = '" + schema + "'" + " AND table_name = '" + view + "'";
        String definitionColumnName = "view_definition";
        stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        
        // try pg_catalog.views, if view is blocked (invisible or definition is null)
        if (!res.next() || res.getString(definitionColumnName) == null){
            query = "select definition from pg_catalog.pg_views WHERE schemaname = '" + schema + "'" + " AND viewname = '" + view + "'";
            stmt = connection.createStatement();
            res = stmt.executeQuery(query);
            definitionColumnName = "definition";
            if (!res.next()){
                // TODO throw exception, log, output to console?
                System.err.println("No view info found in INFORMATION_SCHEMA and pg_catalog for " + schema + "." + view);
                return null;
            }
        }
        
        String viewDef = res.getString(definitionColumnName);
        if (viewDef == null){
            // TODO throw exception, log, output to console?
            System.err.println("View without definition (locked): " + view);
            viewDef = "";
        }else if (viewDef.charAt(viewDef.length() - 1) == ';'){
            viewDef = viewDef.substring(0, viewDef.length() - 1);
        }
        PgView v = new PgView(view, viewDef, getSearchPath(schema));
        v.setQuery(viewDef);
        // skip column names (aliases), as they are not used by us
        
        // we skip PgSelect, as it does not affect export (does it?)
        // TODO can query selected columns from pg_catalog
        // prevent NPE, because select in PgView is not initialized
        v.setSelect(new PgSelect("", ""));
        
        // Query columns default values and comments
        ResultSet res2 = metaData.getColumns(null, schema, view, null);
        while(res2.next()){
            String colName = res2.getString("COLUMN_NAME");
            String colDefault = res2.getString("COLUMN_DEF");
            if (colDefault != null){
                v.addColumnDefaultValue(colName, colDefault);
            }
            String colComment = res2.getString("REMARKS");
            if (colComment != null){
                v.addColumnComment(colName, colComment);
            }
        }
        
        // Query owners of view
        query = "select viewowner from pg_catalog.pg_views WHERE schemaname = '" + schema + "'" + " AND viewname = '" + view + "'";
        stmt = connection.createStatement();
        res = stmt.executeQuery(query);
        if (res.next()){
            v.setOwner(res.getString("viewowner"));
        }
        
        // TODO Comment on view
        
        return v;
    }

    private String getSearchPath(String schema){
        return "SET search_path = " + schema + ", pg_catalog";
    }
    
    private PgTable getTable(String schema, String table) throws SQLException{
        StringBuilder tableDef = new StringBuilder(); 

        tableDef.append("CREATE TABLE " + table + " (\n");
        
        ResultSet res = metaData.getColumns(null, schema, table, "%");
        List<PgColumn> columns = new ArrayList<PgColumn>(5);
        while (res.next()) {
            String columnName = res.getString("COLUMN_NAME");
            PgColumn column = new PgColumn(columnName);
            
            String columnType = res.getString("TYPE_NAME");
            // TODO надо ли проверку на наличие DEFULT, если serial?
            if (DATA_TYPE_ALIASES.get(columnType) != null){
                columnType = DATA_TYPE_ALIASES.get(columnType);
            }else if (columnType.equals("bigserial")){
                columnType = "bigint";
            }else if (columnType.equals("serial")){
                columnType = "integer";
            }
            column.setType(columnType);
            
            tableDef.append("   " + columnName + " " + columnType);
            if (columnType.equals("character") || columnType.equals("character varying")){
                String numOfChars = "(" + res.getInt("CHAR_OCTET_LENGTH") + ")";
                tableDef.append(numOfChars);
                column.setType(column.getType() + numOfChars);
            }
            
            String columnDefault = res.getString("COLUMN_DEF");
            if (columnDefault != null){
                tableDef.append(" DEFAULT " + columnDefault);
                column.setDefaultValue(columnDefault);
            }
            
            if (res.getInt("NULLABLE") == DatabaseMetaData.columnNoNulls){
                tableDef.append(" NOT NULL");
                column.setNullValue(false);
            }
            
            tableDef.append(",\n");
            columns.add(column);
        }
        tableDef.append(");");
        
        
        PgTable t = new PgTable(table, tableDef.toString(), getSearchPath(schema));
        
        for(PgColumn column : columns){
            t.addColumn(column);
        }
        
        // privileges
        String revokeMaindb = "ALL ON TABLE " + table + " TO maindb";
        String revokePublic = "ALL ON TABLE " + table + " TO PUBLIC";
        PgPrivilege p = new PgPrivilege(true, revokeMaindb, "REVOKE " + revokeMaindb);
        t.addPrivilege(p);
        p = new PgPrivilege(true, revokePublic, "REVOKE " + revokePublic);
        t.addPrivilege(p);
        
        res = metaData.getTablePrivileges(null, schema, table);
        Map<String, List<String>> privileges = new HashMap<String, List<String>>(10);
        while (res.next()) {
            String grantee = res.getString("GRANTEE");
            
            if (privileges.get(grantee) == null){
                privileges.put(grantee, new ArrayList<String>(Arrays.asList(res.getString("PRIVILEGE"))));
            }else if (privileges.get(grantee).size() < 6){
                privileges.get(grantee).add(res.getString("PRIVILEGE"));
            }else {
                privileges.put(grantee, new ArrayList<String>(Arrays.asList("ALL")));
            }
        }
        for(String grantee : privileges.keySet()){
            for(String priv : privileges.get(grantee)){
                String privDef = priv + " ON TABLE " + table + " TO " + grantee;
                p = new PgPrivilege(false, privDef, "GRANT " + privDef);
                t.addPrivilege(p);            
            }
        }
        // end privileges
        
        // Query owner
        String query = "SELECT tableowner FROM pg_catalog.pg_tables WHERE schemaname = '" + schema + "'" + " AND tablename = '" + table + "'";
        Statement stmt = connection.createStatement();
        res = stmt.executeQuery(query);
        if (res.next()){
            t.setOwner(res.getString("tableowner"));
        }
        
        // Query CONSTRAINTS
        query = "SELECT constraint_name, constraint_schema FROM information_schema.constraint_column_usage WHERE table_schema = '" + schema + "'" + " AND table_name = '" + table + "'";
        res = stmt.executeQuery(query);
        while (res.next()){
            String constraintName = res.getString("constraint_name");
            String constraintSchema = res.getString("constraint_schema");
            PgConstraint constraint = getConstraint(constraintSchema, constraintName);
            if (constraint != null){
                t.addConstraint(constraint);
            }
        }
        
        // Query INDECIES
        query = "SELECT indexrelid FROM pg_catalog.pg_index WHERE indrelid = '" + getTableOidByName(table, schema) + "'";
        res = stmt.executeQuery(query);
        while (res.next()){
            PgIndex index = getIndex(res.getString("indexrelid"));
            if (index != null){
                t.addIndex(index);
            }
        }
        return t;
    }

    private PgIndex getIndex(String string) {
        // TODO Auto-generated method stub
        return null;
    }
}