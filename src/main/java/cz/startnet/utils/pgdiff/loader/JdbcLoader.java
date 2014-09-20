package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.apgdiff.Log;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.CreateFunctionParser;
import cz.startnet.utils.pgdiff.parsers.Parser;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgForeignKey;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSelect;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public class JdbcLoader {
    /*
     * Trigger firing conditions
     */
    private final int TRIGGER_TYPE_ROW = 1 << 0;
    private final int TRIGGER_TYPE_BEFORE = 1 << 1;
    private final int TRIGGER_TYPE_INSERT = 1 << 2;
    private final int TRIGGER_TYPE_DELETE = 1 << 3;
    private final int TRIGGER_TYPE_UPDATE = 1 << 4;
    private final int TRIGGER_TYPE_TRUNCATE = 1 << 5;
    private final int TRIGGER_TYPE_INSTEAD = 1 << 6;
    
    
    /**
     * Prepared statements to be executed
     */
    private PreparedStatement prepStatTriggers;
    private PreparedStatement prepStatFuncName;
    private PreparedStatement prepStatFunctions;
    private PreparedStatement prepStatLanguages;
    private PreparedStatement prepStatTypes;
    private PreparedStatement prepStatSequences;
    private PreparedStatement prepStatExtensions;
    private PreparedStatement prepStatConstraints;
    private PreparedStatement prepStatIndecies;
    private PreparedStatement prepStatColumnsOfSchema;
    private PreparedStatement prepStatIndexColumnDefault;
    
    // TODO HashMap caching of type, language
    
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
    
    private Map<String, Long> cachedSchemaByName = new HashMap<String, Long>();
    private Map<Long, String> cachedIndexAccesMethodsByOid = new HashMap<Long, String>();
    private Map<Long, String> cachedRolesNamesByOid = new HashMap<Long, String>();
    private Map<Long, Map<Integer, String>> cachedColumnNamesByTableOid = new HashMap<Long, Map<Integer,String>>();
    
    private String host;
    private int port;
    private String user;
    private String pass;
    private Object dbName;
    private String encoding;
    
    private Connection connection;
    private DatabaseMetaData metaData;
    
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    
    public JdbcLoader(String host, int port, String user, String pass, String dbName, String encoding) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.dbName = dbName;
        this.encoding = encoding;
    }

    public PgDatabase getDbFromJdbc() throws IOException{
        PgDatabase d = new PgDatabase();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(
                   "jdbc:postgresql://" + host + ":" + port + "/" + dbName, user, pass);
            prepareStatements();
            prepareData();
            metaData = connection.getMetaData();

            ResultSet res = metaData.getSchemas();
            while (res.next()) {
                String schemaName = res.getString("TABLE_SCHEM");
                if (schemaName.equals("pg_catalog") || schemaName.equals("information_schema")){
                    continue;
                }
                prepareDataForSchema(getSchemaOidByName(schemaName));
                PgSchema schema = getSchema(res.getString("TABLE_SCHEM"));
                
                if (schemaName.equals("public")){
                    d.replaceSchema(d.getSchema("public"), schema);                    
                }else{
                    d.addSchema(schema);
                }
            }
            Log.log(Log.LOG_INFO, "Creating extensions from JDBC");
            res = prepStatExtensions.executeQuery();
            while(res.next()){
                PgExtension extension = getExtension(res);
                if (extension != null){
                    d.addExtension(extension);
                }
            }
        } catch (SQLException e) {
            throw new IOException("Database JDBC access error occured", e);
        } catch (ClassNotFoundException e) {
            throw new IOException("JDBC driver class not found", e);
        }finally{
            closeResources();
        }
        return d;
    }
    
    private void prepareData() throws SQLException {
        ResultSet res = null;
        try(Statement stmnt = connection.createStatement()){
            // fill in namespace map
            res = stmnt.executeQuery("SELECT nspname, oid FROM pg_catalog.pg_namespace");
            while(res.next()){
                cachedSchemaByName.put(res.getString("nspname"), res.getLong("oid"));
            }
            res.close();
            
            // fill in index access method map
            res = stmnt.executeQuery("SELECT oid, amname FROM pg_catalog.pg_am");
            while(res.next()){
                cachedIndexAccesMethodsByOid.put(res.getLong("oid"), res.getString("amname"));
            }
            res.close();
            
            // fill in rolenames
            res = stmnt.executeQuery("SELECT oid, rolname FROM pg_catalog.pg_roles");
            while (res.next()){
                 cachedRolesNamesByOid.put(res.getLong("oid"), res.getString("rolname"));
            }
        }finally{
            try{
                res.close();
            }catch(Exception e){
                Log.log(Log.LOG_INFO, "Could not close result set after filling in maps", e);
            }
        }
    }

    private void prepareStatements() throws SQLException{
        prepStatTriggers = connection.prepareStatement("SELECT tgfoid, tgname, tgfoid, tgtype, tgrelid FROM pg_catalog.pg_trigger WHERE tgrelid = ?");
        prepStatFuncName = connection.prepareStatement("SELECT proname FROM pg_catalog.pg_proc WHERE oid = ?");
        
        String queryFunctions = 
                "SELECT "
                + "     proname, "
                + "     proowner, "
                + "     prolang, "
                + "     prosrc, "
                + "     pg_get_functiondef(p.oid) AS probody, "
                + "     prorettype, "
                + "     proallargtypes, "
                + "     proargmodes, "
                + "     proargnames, "
                + "     pg_get_function_arguments(p.oid) AS proarguments, "
                + "     pg_get_function_identity_arguments(p.oid) AS proarguments_without_default, "
                + "     proargdefaults, "
                + "     array_agg(acl.grantor) AS priv_grantors, "
                + "     array_agg(acl.grantee)::bigint[] AS priv_grantees, "
                + "     array_agg(acl.privilege_type) AS priv_types, "
                + "     array_agg(acl.is_grantable) AS priv_grantable, "
                + "     d.description AS comment "
                + "FROM "
                + "     pg_catalog.pg_proc p LEFT JOIN pg_catalog.pg_description d ON d.objoid = p.oid,"
                + "     aclexplode(proacl) acl "
                + "WHERE "
                + "     pronamespace = ? AND "
                + "     proisagg = FALSE "
                + "GROUP BY "
                + "     p.oid, "
                + "     proname, "
                + "     proowner, "
                + "     prolang, "
                + "     prosrc, "
                + "     probody, "
                + "     prorettype, "
                + "     proowner, "
                + "     proallargtypes, "
                + "     proargmodes, "
                + "     proargnames, "
                + "     proarguments, "
                + "     proargdefaults,"
                + "     comment;";
        
        prepStatFunctions = connection.prepareStatement(queryFunctions);
        prepStatLanguages = connection.prepareStatement("SELECT lanname FROM pg_catalog.pg_language WHERE oid = ?");
        prepStatTypes = connection.prepareStatement("SELECT typname FROM pg_catalog.pg_type WHERE oid = ?");
        
        String querySequenceInfo = 
                "SELECT "
                + "     c.oid AS sequence_oid,"
                + "     c.relowner,"
                + "     s.sequence_name,"
                + "     s.start_value,"
                + "     s.minimum_value,"
                + "     s.maximum_value,"
                + "     s.increment,"
                + "     s.cycle_option,"
                + "     d.refobjsubid AS referenced_column,"
                + "     d.refobjid AS referenced_table_oid,"
                + "     (SELECT relname FROM pg_catalog.pg_class WHERE oid = d.refobjid AND relkind = 'r') referenced_table_name,"
                + "     array_agg(acl.grantor) AS priv_grantors,"
                + "     array_agg(acl.grantee)::bigint[] AS priv_grantees,"
                + "     array_agg(acl.privilege_type) AS priv_types,"
                + "     array_agg(acl.is_grantable) AS priv_grantable "
                + "FROM "
                + "     information_schema.sequences s,"
                + "     pg_catalog.pg_class c,"
                + "     pg_catalog.pg_namespace n,"
                + "     pg_catalog.pg_depend d,"
                + "     aclexplode(relacl) acl "
                + "WHERE "
                + "     s.sequence_schema = ? AND "
                + "     c.relname = s.sequence_name AND "
                + "     n.oid = c.relnamespace AND "
                + "     d.objid = c.oid AND "
                + "     n.nspname = s.sequence_schema "
                + "GROUP BY "
                + "     sequence_oid,"
                + "     relowner,"
                + "     sequence_name,"
                + "     start_value,"
                + "     minimum_value,"
                + "     maximum_value,"
                + "     increment,"
                + "     cycle_option,"
                + "     referenced_column,"
                + "     referenced_table_oid,"
                + "     referenced_table_name "
                + "ORDER BY "
                + "     sequence_oid;";

        prepStatSequences = connection.prepareStatement(querySequenceInfo);
        prepStatExtensions = connection.prepareStatement("SELECT * FROM pg_catalog.pg_extension");
        prepStatConstraints = connection.prepareStatement("SELECT conname, contype, conrelid, consrc, CAST(conkey as integer[]), confrelid, CAST(confkey as integer[]), confupdtype, confdeltype, confmatchtype FROM pg_catalog.pg_constraint WHERE conrelid = ?");
        prepStatIndecies = connection.prepareStatement("SELECT i.indisunique, c.relname, c.relnamespace, c.relowner, definition FROM pg_catalog.pg_index i, pg_catalog.pg_class c, pg_get_indexdef(c.oid) definition WHERE i.indrelid = ? AND c.oid = i.indexrelid;");
        prepStatColumnsOfSchema = connection.prepareStatement("SELECT a.attname, a.attnum, a.attrelid FROM pg_catalog.pg_attribute a JOIN pg_catalog.pg_class c ON c.oid = a.attrelid WHERE c.relnamespace = ? AND c.relkind IN ('i', 'r') ORDER BY a.attrelid;");
        prepStatIndexColumnDefault = connection.prepareStatement("SELECT pg_get_indexdef(?, ?, true) AS indexColumnDefault;");
    }

    private void closeResources() {
        try {
            connection.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close JDBC connection", e);
        }
        try {
            prepStatTriggers.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close prepared statement for triggers", e);
        }
        try {
            prepStatFuncName.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close prepared statement for function names", e);
        }
        try {
            prepStatFunctions.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close prepared statement for functions", e);
        }
        try {
            prepStatLanguages.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close prepared statement for languages", e);
        }
        try {
            prepStatTypes.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close prepared statement for types", e);
        }
        try {
            prepStatSequences.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close prepared statement for sequences", e);
        }
        try {
            prepStatExtensions.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close prepared statement for extensions", e);
        }
        try {
            prepStatConstraints.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close prepared statement for constraints", e);
        }
        try {
            prepStatIndecies.close();
        } catch (Exception e) {
            Log.log(Log.LOG_INFO, "Could not close prepared statement for indecies", e);
        }
    }
    
    private PgSchema getSchema(String schema) throws SQLException{
        PgSchema s = new PgSchema(schema, "");
//        Log.log(Log.LOG_INFO, "Creating tables from JDBC");
        ResultSet res = metaData.getTables(null, schema, "%", new String[] {"TABLE"} );
        while (res.next()) {
            PgTable table = getTable(schema, res.getString("table_name"));
            s.addTable(table);
        }
//        Log.log(Log.LOG_INFO, "Creating views from JDBC");
        res = metaData.getTables(null, schema, "%", new String[] {"VIEW"} );
        while (res.next()) {
            PgView view = getView(schema, res.getString("table_name"));
            s.addView(view);
        }
//        Log.log(Log.LOG_INFO, "Creating functions from JDBC");
        prepStatFunctions.setLong(1, getSchemaOidByName(schema));
        res = prepStatFunctions.executeQuery();
        while (res.next()){
            PgFunction function = getFunction(res, schema);
            if (function != null){
                s.addFunction(function);
            }
        }
//        Log.log(Log.LOG_INFO, "Creating sequences from JDBC");
        prepStatSequences.setString(1, schema);
        res = prepStatSequences.executeQuery();
        PgSequence sequence = null;
        int previousSeqOid = 0;
        while(res.next()){
            if (previousSeqOid != res.getInt("sequence_oid")){
                sequence = getSequence(res, schema);
                if (sequence != null){
                    s.addSequence(sequence);
                }
            }else if (sequence != null && res.getInt("referenced_column") != 0){
                Integer[] ownedColumnNumbers = {res.getInt("referenced_column")};
                sequence.setOwnedBy(res.getString("referenced_table_name") + "." + getColumnNames(ownedColumnNumbers, res.getLong("referenced_table_oid")).get(0));
            }
            previousSeqOid = res.getInt("sequence_oid");
        }
        return s;
    }
    
    private PgExtension getExtension(ResultSet res) throws SQLException {
        PgExtension e = new PgExtension(res.getString("extname"), "");
        e.setVersion(res.getString("extversion"));
        e.setOwner(getRoleNameByOid(res.getLong("extowner")));
        e.setSchema(getScheNameByOid(res.getLong("extnamespace")));
        
        return e;
    }

    private PgConstraint getConstraint(ResultSet res, String schemaName, String tableName) throws SQLException {
        String constraintName = res.getString("conname");
        String definition = "";
        PgConstraint c = new PgConstraint(constraintName, "", getSearchPath(schemaName));
        
        List<String> columnNames = getColumnNames((Integer[])res.getArray("conkey").getArray(), res.getLong("conrelid"));
        switch (res.getString("contype")){
            case "f":
                c = new PgForeignKey(constraintName, "", getSearchPath(schemaName));
                List<String> referencedColumnNames = getColumnNames((Integer[])res.getArray("confkey").getArray(), res.getLong("confrelid"));
                definition = "FOREIGN KEY (";
                // TODO code reuse
                for(int i = 0; i < columnNames.size(); i++){
                    String columnName = columnNames.get(i);
                    definition = definition.concat(columnName);
                    if(i < columnNames.size() - 1){
                        definition = definition.concat(", ");
                    }
                }
                SimpleEntry<String, String> referencedTableName = getTableNameByOid(res.getLong("confrelid"));
                String schemaPrefix = "";
                if (!referencedTableName.getKey().equals(schemaName)){
                    schemaPrefix = referencedTableName.getKey() + ".";
                }
                definition = definition.concat(") REFERENCES " + schemaPrefix + referencedTableName.getValue() + "(");
                
                for(int i = 0; i < referencedColumnNames.size(); i++){
                    String columnName = referencedColumnNames.get(i);
                    definition = definition.concat(columnName);
                    if(i < referencedColumnNames.size() - 1){
                        definition = definition.concat(", ");
                    }
                }
                definition = definition.concat(")");
                break;
            case "p":
                definition = "PRIMARY KEY (";
                for(int i = 0; i < columnNames.size(); i++){
                    String columnName = columnNames.get(i);
                    definition = definition.concat(columnName);
                    if(i < columnNames.size() - 1){
                        definition = definition.concat(", ");
                    }
                }
                definition = definition.concat(")");
                break;
            case "c":
                definition = "CHECK (" + res.getString("consrc") + ")";
                break;
            case "u":
                definition = "UNIQUE (";
                for(int i = 0; i < columnNames.size(); i++){
                    String columnName = columnNames.get(i);
                    definition = definition.concat(columnName);
                    if(i < columnNames.size() - 1){
                        definition = definition.concat(", ");
                    }
                }
                definition = definition.concat(")");
                break;
        }
        
        switch (res.getString("confmatchtype")){
            case "f":
                definition = definition.concat(" MATCH FULL");
                break;
            case "p":
                definition = definition.concat(" MATCH PARTIAL");
                break;
        }
        
        switch(res.getString("confdeltype")){
            case "r":
                definition = definition.concat(" ON DELETE RESTRICT");
                break;
            case "c":
                definition = definition.concat(" ON DELETE CASCADE");
                break;
            case "n":
                definition = definition.concat(" ON DELETE SET NULL");
                break;
            case "d":
                definition = definition.concat(" ON DELETE SET DEFAULT");
                break;
        }
        
        switch(res.getString("confupdtype")){
            case "r":
                definition = definition.concat(" ON UPDATE RESTRICT");
                break;
            case "c":
                definition = definition.concat(" ON UPDATE CASCADE");
                break;
            case "n":
                definition = definition.concat(" ON UPDATE SET NULL");
                break;
            case "d":
                definition = definition.concat(" ON UPDATE SET DEFAULT");
                break;
        }

        c.setDefinition(definition);
        // set table name
        c.setTableName(tableName);
        // TODO c.setComment() ???
        return c;
    }
    
    private long timeNanosec = 0L;
    
    /**
     * Output to stderr time of some operation (required to be called twice)  
     */
    private void t(String mes){
        if (!mes.isEmpty())
            System.err.println(mes + " " + (System.nanoTime() - timeNanosec)/1000000 + " msec");
        timeNanosec = System.nanoTime();
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

    private PgTable getTable(String schema, String tableName) throws SQLException{
        // TODO get oids earlier (or cache), as they are not changed in time (minimize db queries)
        Long tableOid = getTableOidByName(tableName, getSchemaOidByName(schema));
        StringBuilder tableDef = new StringBuilder(); 

        tableDef.append("CREATE TABLE " + tableName + " (\n");
        
        ResultSet res = metaData.getColumns(null, schema, tableName, "%");
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
        
        PgTable t = new PgTable(tableName, tableDef.toString(), getSearchPath(schema));
        
        for(PgColumn column : columns){
            t.addColumn(column);
        }

        // Query PRIVILEGES
        String revokeMaindb = "ALL ON TABLE " + tableName + " TO maindb";
        String revokePublic = "ALL ON TABLE " + tableName + " TO PUBLIC";
        t.addPrivilege(new PgPrivilege(true, revokeMaindb, "REVOKE " + revokeMaindb));
        t.addPrivilege(new PgPrivilege(true, revokePublic, "REVOKE " + revokePublic));
        res = metaData.getTablePrivileges(null, schema, tableName);
        
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
                String privDef = priv + " ON TABLE " + tableName + " TO " + grantee;
                t.addPrivilege(new PgPrivilege(false, privDef, "GRANT " + privDef));            
            }
        }

        // Query OWNER
        String query = "SELECT tableowner FROM pg_catalog.pg_tables WHERE schemaname = '" + schema + "'" + " AND tablename = '" + tableName + "'";
        Statement stmt = connection.createStatement();
        res = stmt.executeQuery(query);
        if (res.next()){
            t.setOwner(res.getString("tableowner"));
        }
        
        // Query CONSTRAINTS
        prepStatConstraints.setLong(1, tableOid);
        res = prepStatConstraints.executeQuery();
        while (res.next()){
            PgConstraint constraint = getConstraint(res, schema, tableName);
            if (constraint != null){
                t.addConstraint(constraint);
            }
        }
        
        // Query INDECIES
        prepStatIndecies.setLong(1, tableOid);
        res = prepStatIndecies.executeQuery();
        while (res.next()){
            PgIndex index = getIndex(res, tableName, tableOid);
            if (index != null){
                t.addIndex(index);
            }
        }
        
        // Query TRIGGERS
        prepStatTriggers.setLong(1, tableOid);
        res = prepStatTriggers.executeQuery();
        while(res.next()){
            PgTrigger trigger = getTrigger(res);
            if (trigger != null){
                t.addTrigger(trigger);
            }
        }
        
        res.close();
        return t;
    }

    /**
     * Returns trigger object.
     * <br>
     * Available trigger firing conditions:
     *      boolean onDelete;
     *      boolean onInsert;
     *      boolean onUpdate;
     *      boolean onTruncate;
     *     
     *      boolean forEachRow;
     *      boolean before;
     */
    private PgTrigger getTrigger(ResultSet res) throws SQLException{
        
        String triggerName = res.getString("tgname");
        PgTrigger t = new PgTrigger(triggerName, "", "");
        
        int firingConditions = res.getInt("tgtype");
        if ((firingConditions & TRIGGER_TYPE_DELETE) != 0){
            t.setOnDelete(true);
        }
        if ((firingConditions & TRIGGER_TYPE_INSERT) != 0){
            t.setOnInsert(true);
        }
        if ((firingConditions & TRIGGER_TYPE_UPDATE) != 0){
            t.setOnUpdate(true);
        }
        if ((firingConditions & TRIGGER_TYPE_TRUNCATE) != 0){
            t.setOnTruncate(true);
        }
        if ((firingConditions & TRIGGER_TYPE_ROW) != 0){
            t.setForEachRow(true);
        }
        if ((firingConditions & TRIGGER_TYPE_BEFORE) != 0){
            t.setBefore(true);
        }
        
        String tableName = getTableNameByOid(res.getLong("tgrelid")).getValue();
        t.setTableName(tableName);
        
        String functionName = getFunctionNameByOid(res.getLong("tgfoid"));
        t.setFunction(functionName);
        return t;
    }
    
    private PgIndex getIndex(ResultSet res, String tableName, Long tableOid) throws SQLException {
        String schemaName = getScheNameByOid(res.getLong("relnamespace"));
        
        String indexName = res.getString("relname");
        PgIndex i = new PgIndex(indexName, "", getSearchPath(schemaName));
        i.setTableName(tableName);

        String definition = res.getString("definition"); 
        i.setDefinition(definition.substring(definition.indexOf("USING ")));
        
        i.setUnique(res.getBoolean("indisunique"));
        setOwner(i, res.getLong("relowner"));
        
        return i;
    }
    
    private void setOwner(PgStatement statement, Long ownerOid){
        setOwner(statement, getRoleNameByOid(ownerOid));
    }
    
    private void setOwner(PgStatement statement, String ownerName){
        statement.setOwner(ownerName);
    }
    
    private String getAccessMethodNameByOid(int accessMethodOid) {
        return cachedIndexAccesMethodsByOid.get(accessMethodOid);
    }

    /**
     * Returns function object accordingly to data stored in current res row
     * (except for aggregate functions). 
     * Defines function body from Postgres pg_get_functiondef() output.
     * <br><br>
     * 
     * Use this select query to define function manually (not completed):
     * "SELECT proname, prolang, prosrc, proisagg AS isaggregate, proiswindow AS iswindow, 
     *         prosecdef AS issecuritydefiner, proleakproof AS isleakproof, 
     *         proisstrict AS isnullonnull FROM pg_catalog.pg_proc WHERE pronamespace = ?"
     */
    private PgFunction getFunction(ResultSet res, String schemaName) throws SQLException{
        String definition = res.getString("probody");
        String languageName = getLangNameByOid(res.getLong("prolang"));
        int langFirstOccurenceIndex = definition.indexOf("LANGUAGE " + languageName); 
        String body = definition.substring(langFirstOccurenceIndex).replaceAll("\\$function\\$", "\\$\\$");
        String functionName = res.getString("proname");
        PgFunction f = new PgFunction(functionName, "", getSearchPath(schemaName));
        f.setBody(body);
        f.setReturns(getTypeNameByOid(res.getLong("prorettype")));

        String arguments = res.getString("proarguments");
        if (!arguments.isEmpty()){
            CreateFunctionParser.parseArguments(new Parser("(" + arguments + ")"), f);
        }
        
        // PRIVILEGES
        String signatureWithoutDefaults = functionName + "(" + res.getString("proarguments_without_default") + ")";
        Long [] granteeOids = (Long[])res.getArray("priv_grantees").getArray();
        String [] privTypes = (String[])res.getArray("priv_types").getArray();
        
        List<PrivilegePair> se = new ArrayList<PrivilegePair>(10);
        for (int i = 0; i < granteeOids.length; i++){
            se.add(new PrivilegePair(granteeOids[i], privTypes[i]));
        }
//        Collections.sort(se);
        
        setPrivileges(f, signatureWithoutDefaults, se);
        
        // OWNER
        setOwner(f, res.getLong("proowner"));
        
        // COMMENT
        String comment = res.getString("comment");
        f.setComment(comment != null && !comment.isEmpty() ? "'" + comment + "'" : null);
        return f;
    }
    
    private PgSequence getSequence(ResultSet res, String schemaName) throws SQLException {
        String sequenceName = res.getString("sequence_name");
        PgSequence s = new PgSequence(sequenceName, "", getSearchPath(schemaName));
        s.setCycle(res.getBoolean("cycle_option"));
        s.setIncrement(res.getString("increment"));
        
        // The data type of the sequence: In PostgreSQL, this is currently always bigint
        String maxValue = res.getString("maximum_value");
        s.setMaxValue(maxValue.equals(String.valueOf(Long.MAX_VALUE)) ? null : maxValue);
        String minValue = res.getString("minimum_value"); 
        s.setMinValue(minValue.equals("1") ? null : minValue);
        
        s.setStartWith(res.getString("start_value"));
        s.setCache(String.valueOf(1));
        // TODO SELECT cache_value FROM tableName;
        
        Integer[] ownedColumnNumbers = {res.getInt("referenced_column")};
        if (!ownedColumnNumbers[0].equals(Integer.valueOf(0))){
            s.setOwnedBy(res.getString("referenced_table_name") + "." + getColumnNames(ownedColumnNumbers, res.getLong("referenced_table_oid")));
        }
        
        setOwner(s, res.getLong("relowner"));
        
        // PRIVILEGES
        Long [] granteeOids = (Long[])res.getArray("priv_grantees").getArray();
        String [] privTypes = (String[])res.getArray("priv_types").getArray();
        
        List<PrivilegePair> se = new ArrayList<PrivilegePair>(10);
        for (int i = 0; i < granteeOids.length; i++){
            se.add(new PrivilegePair(granteeOids[i], privTypes[i]));
        }
        //Collections.sort(se);
        
        setPrivileges(s, sequenceName, se);
        
        return s;
    }
    
    private void setPrivileges(PgStatement st, String stSignature, List<PrivilegePair> privileges){
        String stType = "";
        int possiblePrivilegeCount = 13;
        if (st instanceof PgSequence){
            stType = "SEQUENCE";
            possiblePrivilegeCount = 3;
        }else if (st instanceof PgFunction){
            stType = "FUNCTION";
            possiblePrivilegeCount = 1;
        }else{
            throw new IllegalStateException("Not supported PgStatement class");
        }
        
        String revokeMaindb = "ALL ON " + stType + " " + stSignature + " FROM maindb";
        String revokePublic = "ALL ON " + stType + " " + stSignature + " FROM PUBLIC";
        st.addPrivilege(new PgPrivilege(true, revokePublic, "REVOKE " + revokePublic));
        st.addPrivilege(new PgPrivilege(true, revokeMaindb, "REVOKE " + revokeMaindb));
        // TODO REVOKE ALL ON FUNCTION startdblink(text, text) FROM postgres; (public schema)
        // TODO why postgres and maindb only?s 
        Long previousGranteeOid = 0L;
        Integer privilegeCounter = 0;
        String privilegesList = "";
        for(int i = 0; i < privileges.size(); i++){
            PrivilegePair p = privileges.get(i);
            if (p.granteeOid.equals(previousGranteeOid)){
                privilegeCounter++;
                if (!privilegesList.isEmpty()){
                    privilegesList = privilegesList.concat(",");
                }
                privilegesList = privilegesList.concat(p.privilegeType);
            }else{
                if (privilegeCounter != 0 && privilegeCounter < possiblePrivilegeCount){
                    String privDefinition = privilegesList + " ON " + stType + " " + stSignature + " TO " + getRoleNameByOid(previousGranteeOid);
                    st.addPrivilege(new PgPrivilege(false, privDefinition, "GRANT " + privDefinition));
                }
                privilegeCounter = 1;
                privilegesList = p.privilegeType;
            }
            
            if (privilegeCounter == possiblePrivilegeCount){
                privilegesList = "ALL";
                String privDefinition = "ALL ON " + stType + " " + stSignature + " TO " + getRoleNameByOid(p.granteeOid);
                st.addPrivilege(new PgPrivilege(false, privDefinition, "GRANT " + privDefinition));
            }
            previousGranteeOid = p.granteeOid;
            if (i == privileges.size() - 1 && privilegeCounter != possiblePrivilegeCount){
                String privDefinition = privilegesList + " ON " + stType + " " + stSignature + " TO " + getRoleNameByOid(previousGranteeOid);
                st.addPrivilege(new PgPrivilege(false, privDefinition, "GRANT " + privDefinition));
            }
        }
    }
    
    private String getSearchPath(String schema){
        return "SET search_path = " + schema + ", pg_catalog;";
    }

    private void prepareDataForSchema(Long schemaOid) throws SQLException{
        // fill in map with columns of tables and indecies of schema
        prepStatColumnsOfSchema.setLong(1, schemaOid);
        try(ResultSet res = prepStatColumnsOfSchema.executeQuery();){
            cachedColumnNamesByTableOid.clear();
            Long previousTableOid = 0L;
            Map<Integer, String> previousMap = null;
            while (res.next()){
                Integer columnNumber = res.getInt("attnum");
                if (columnNumber < 1){
                    continue;
                }
                Long tableOid = res.getLong("attrelid");
                String columnName = res.getString("attname");
                if (!previousTableOid.equals(tableOid)){
                    previousTableOid = tableOid;
                    previousMap = new HashMap<Integer, String>();
                    previousMap.put(columnNumber, columnName);
                    cachedColumnNamesByTableOid.put(tableOid, previousMap);
                }else{
                    previousMap.put(columnNumber, columnName);                
                }
            }
        }
    }
    
    /**
     * Returns an array of column names, resolved from conCols Array object 
     * by pg_attribute.attnum and tableOid
     * 
     * @param conCols   Array of ints containing column numbers (references pg_attribute.attnum)
     * @param tableOid  Oid of table - owner of these columns
     * @return
     */
    private List<String> getColumnNames(Integer[] cols, Long tableOid) throws SQLException{
        Map <Integer, String> tableColumns = cachedColumnNamesByTableOid.get(tableOid);
        // if requested table is in different schema
        if (tableColumns == null){
            try(    Statement st = connection.createStatement();
                    ResultSet res = st.executeQuery("SELECT attname, attnum FROM "
                            + "pg_catalog.pg_attribute WHERE attrelid = " + tableOid);){
                tableColumns = new HashMap<Integer, String>();
                while(res.next()){
                    tableColumns.put(res.getInt("attnum"), res.getString("attname"));
                }
                cachedColumnNamesByTableOid.put(tableOid, tableColumns);
            }
        }
        List<String> result = new ArrayList<String>(5);
        for(Integer n : cols){
            result.add(tableColumns.get(n));
        }
        return result;
    }

    private String getFunctionNameByOid(Long functionOid) throws SQLException{
        prepStatFuncName.setLong(1, functionOid);
        ResultSet res = prepStatFuncName.executeQuery();
        if (res.next()){
            return res.getString("proname");
        }
        return null;
    }

    /**
     * Returns schemaName.objectName pair for the table (and similar, such as 
     * Index or View) by seeking its oid in pg_catalog.pg_class  
     * @param tableOid
     * @return
     */
    private SimpleEntry<String, String> getTableNameByOid(Long tableOid) throws SQLException{
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

    // TODO cache it too?
    private Long getTableOidByName(String tableName, Long schemaOid) throws SQLException{
        String query = "SELECT oid FROM pg_catalog.pg_class WHERE relname = '" + tableName + "' AND relnamespace = " + schemaOid + " AND relkind IN ('r', 'i')";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        Long tableOid = 0L;
        if(res.next()){
            tableOid = res.getLong("oid");
        }
        if (res.next()){
            // WHAT?
            throw new IllegalArgumentException("There should be only one row for table " + tableName + 
                    " in schema oid " + schemaOid + ". Modify select query to limit result to single row."); 
        }
        return tableOid;
    }

    private Long getSchemaOidByName(String schema){
        return cachedSchemaByName.get(schema);
    }
    
    private String getLangNameByOid (Long langOid) throws SQLException{
        prepStatLanguages.setLong(1, langOid);
        try(ResultSet res = prepStatLanguages.executeQuery()){
            if (res.next()){
                return res.getString("lanname");
            }
        }
        return null;
    }
    
    private String getTypeNameByOid(Long typeOid) throws SQLException {
        prepStatTypes.setLong(1, typeOid);
        ResultSet res = prepStatTypes.executeQuery();
        if (res.next()){
            return res.getString("typname");
        }
        return "";
    }
    
    private String getRoleNameByOid(Long ownerOid){
        return ownerOid == 0 ? "PUBLIC" : cachedRolesNamesByOid.get(ownerOid);
    }
    
    private String getScheNameByOid(Long schemaOid){
        Iterator<Long> iterOid = cachedSchemaByName.values().iterator();
        Iterator<String> iterNames = cachedSchemaByName.keySet().iterator();

        while(iterOid.hasNext() && iterNames.hasNext()){
            Long next = iterOid.next();
            if (next.equals(schemaOid)){
                return iterNames.next();
            }
            iterNames.next();
        }
        return null;
    }
}

class PrivilegePair implements Comparable<PrivilegePair>{
    Long granteeOid;
    String privilegeType;
    
    public PrivilegePair(Long granteeOids, String privilegeType) {
        this.granteeOid = granteeOids;
        this.privilegeType = privilegeType;
    }

    @Override
    public int compareTo(PrivilegePair pair) {
        return granteeOid.compareTo(pair.granteeOid);
    }
}