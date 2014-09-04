package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
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
                PgSchema s = getSchema(res.getString("TABLE_SCHEM"));
                d.addSchema(s);
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
        }
        
        res = metaData.getTables(null, schema, "%", new String[] {"VIEW"} );
        while (res.next()) {
            PgView view = getView(schema, res.getString("table_name"));
        }
        return s;
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
        String query = "select tableowner from pg_catalog.pg_tables WHERE schemaname = '" + schema + "'" + " AND tablename = '" + table + "'";
        Statement stmt = connection.createStatement();
        res = stmt.executeQuery(query);
        if (res.next()){
            t.setOwner(res.getString("tableowner"));
        }
        
        return t;
    }
}