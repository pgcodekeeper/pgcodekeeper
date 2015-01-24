package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.CreateFunctionParser;
import cz.startnet.utils.pgdiff.parsers.Parser;
import cz.startnet.utils.pgdiff.parsers.ParserUtils;
import cz.startnet.utils.pgdiff.parsers.SelectParser;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomErrorListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLLexer;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateView.SelectQueryVisitor;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
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

public class JdbcLoader implements PgCatalogStrings {
    /*
     * Trigger firing conditions
     */
// SONAR-OFF
    public static final int TRIGGER_TYPE_ROW = 1 << 0;
    public static final int TRIGGER_TYPE_BEFORE = 1 << 1;
    public static final int TRIGGER_TYPE_INSERT = 1 << 2;
    public static final int TRIGGER_TYPE_DELETE = 1 << 3;
    public static final int TRIGGER_TYPE_UPDATE = 1 << 4;
    public static final int TRIGGER_TYPE_TRUNCATE = 1 << 5;
    public static final int TRIGGER_TYPE_INSTEAD = 1 << 6;
// SONAR-ON
    private static final int DEFAULT_OBJECTS_COUNT = 100;
    private static final float DEFAULT_PROCOST = 100.0f;
    private static final float DEFAULT_PROROWS = 1000.0f;
    /*
     * Prepared statements to be executed
     */
    private PreparedStatement prepStatTables;
    private PreparedStatement prepStatViews;
    private PreparedStatement prepStatTriggers;
    private PreparedStatement prepStatFunctions;
    private PreparedStatement prepStatSequences;
    private PreparedStatement prepStatConstraints;
    private PreparedStatement prepStatIndecies;
    private PreparedStatement prepStatColumnsOfSchema;
    
    private Map<Long, String> cachedRolesNamesByOid = new HashMap<>();
    private Map<Long, PgType> cachedTypeNamesByOid = new HashMap<>();
    /*
     * Stores cached results of query "SELECT typmodout(colTypeMod)" for types.<br>
     * Key is the oid of pg_catalog.pg_type table. Inner map stores pairs of colTypeMod 
     * and result of "SELECT typmodout(colTypeMod)" query.
     */
    private Map<Long, Map<Integer,String>> cachedTypesTypmodouts = new HashMap<>();
    private Map<Long, Map<Integer, String>> cachedColumnNamesByTableOid = new HashMap<>();
    
    private Connection connection;
    private JdbcConnector connector;
    private IProgressMonitor monitor;
    private final boolean useAntrlForViews;
    
    public JdbcLoader(JdbcConnector connector, boolean useAntrlForViews){
        this.connector = connector;
        this.useAntrlForViews = useAntrlForViews;
    }

    public PgDatabase getDbFromJdbc(IProgressMonitor mon) throws IOException{
        monitor = mon == null ? new NullProgressMonitor() : SubMonitor.convert(mon, 1);
        PgDatabase d = new PgDatabase();
        try {
            Log.log(Log.LOG_INFO, "Reading db using JDBC.");
            connection = connector.getConnection();
            
            setTimeZone(connector.getTimezone());
            prepareStatements();
            prepareData();
            
            // query total objects count
            if (monitor instanceof SubMonitor){
                try(Statement stmnt = connection.createStatement();
                        ResultSet resCount = stmnt.executeQuery(JdbcQueries.QUERY_TOTAL_OBJECTS_COUNT)){
                    if (resCount.next()){
                        ((SubMonitor)monitor).setWorkRemaining(resCount.getInt(1) + 50);
                    }else{
                        ((SubMonitor)monitor).setWorkRemaining(DEFAULT_OBJECTS_COUNT);
                    }
                }
            }
            
            Log.log(Log.LOG_INFO, "Quering schemas");
            try(Statement stmnt = connection.createStatement(); 
                    ResultSet res = stmnt.executeQuery(JdbcQueries.QUERY_SCHEMAS)){
                
                while (res.next()) {
                    Log.log(Log.LOG_INFO, "Quering objects for schema " + res.getString(NAMESPACE_NSPNAME));
                    prepareDataForSchema(res.getLong(OID));
                    
                    PgSchema schema = getSchema(res);
                    if (res.getString(NAMESPACE_NSPNAME).equals(ApgdiffConsts.PUBLIC)){
                        d.replaceSchema(d.getSchema(ApgdiffConsts.PUBLIC), schema);
                    }else{
                        d.addSchema(schema);
                    }
                }   
            }
            
            Log.log(Log.LOG_INFO, "Quering extensions");
            try(Statement stmnt = connection.createStatement(); 
                    ResultSet res = stmnt.executeQuery(JdbcQueries.QUERY_EXTENSIONS)){
                while(res.next()){
                    PgExtension extension = getExtension(res);
                    monitor.worked(1);
                    if (extension != null){
                        d.addExtension(extension);
                    }
                }
            }
            Log.log(Log.LOG_INFO, "Database object has been successfully queried from JDBC");
        } catch (SQLException e) {
            throw new IOException(Messages.Connection_DatabaseJdbcAccessError, e);
        } finally{
            Log.log(Log.LOG_INFO, "Closing used JDBC resources");
            closeResources();
        }
        return d;
    }
    
    private void setTimeZone(String timezone) throws SQLException {
        Log.log(Log.LOG_INFO, "Setting JDBC session timezone to " + timezone);
        try(Statement stmnt = connection.createStatement()){
            stmnt.execute("SET timezone = '" + timezone + '\'');
        }
    }

    private void prepareData() throws SQLException {
        try(Statement stmnt = connection.createStatement()){
            // fill in rolenames
            try(ResultSet res = stmnt.executeQuery("SELECT oid::bigint, rolname FROM pg_catalog.pg_roles")){
                while (res.next()){
                    cachedRolesNamesByOid.put(res.getLong(OID), res.getString("rolname"));
                }
            }
            
            // fill in data types
            try(ResultSet res = stmnt.executeQuery("SELECT t.oid::bigint, t.typname, t.typlen, "
                    + "t.typelem::regtype AS castedType, t.typarray, n.nspname, proc.proname, nsp.nspname  "
                    + "FROM pg_catalog.pg_type t LEFT JOIN pg_catalog.pg_namespace n ON t.typnamespace = n.oid "
                    + "LEFT JOIN pg_catalog.pg_proc proc ON proc.oid = t.typmodout "
                    + "LEFT JOIN pg_catalog.pg_namespace nsp ON t.typnamespace = nsp.oid")){
                while (res.next()){
                    PgType type = new PgType(res.getString("typname"), res.getString("castedType"), 
                            res.getLong("typarray"), res.getInt("typlen"), res.getString("proname"),
                            res.getString(NAMESPACE_NSPNAME));
                    cachedTypeNamesByOid.put(res.getLong(OID), type);
                }
            }
        }
    }

    private void prepareStatements() throws SQLException{
        prepStatTables = connection.prepareStatement(JdbcQueries.QUERY_TABLES_PER_SCHEMA);
        prepStatViews = connection.prepareStatement(JdbcQueries.QUERY_VIEWS_PER_SCHEMA);
        prepStatTriggers = connection.prepareStatement(JdbcQueries.QUERY_TRIGGERS_PER_SCHEMA);
        prepStatFunctions = connection.prepareStatement(JdbcQueries.QUERY_FUNCTIONS_PER_SCHEMA);
        prepStatSequences = connection.prepareStatement(JdbcQueries.QUERY_SEQUENCES_PER_SCHEMA);
        prepStatConstraints = connection.prepareStatement(JdbcQueries.QUERY_CONSTRAINTS_PER_SCHEMA);
        prepStatIndecies = connection.prepareStatement(JdbcQueries.QUERY_INDECIES_PER_SCHEMA);
        prepStatColumnsOfSchema = connection.prepareStatement(JdbcQueries.QUERY_COLUMNS_PER_SCHEMA);
    }

    private void closeResources() {
        try {
            connection.close();
        } catch (Exception e) {
            Log.log(Log.LOG_WARNING, "Could not close JDBC connection", e);
        }
        try {
            prepStatTables.close();
        } catch (Exception e) {
            Log.log(Log.LOG_WARNING, "Could not close prepared statement for tables", e);
        }
        try {
            prepStatViews.close();
        } catch (Exception e) {
            Log.log(Log.LOG_WARNING, "Could not close prepared statement for views", e);
        }
        try {
            prepStatTriggers.close();
        } catch (Exception e) {
            Log.log(Log.LOG_WARNING, "Could not close prepared statement for triggers", e);
        }
        try {
            prepStatFunctions.close();
        } catch (Exception e) {
            Log.log(Log.LOG_WARNING, "Could not close prepared statement for functions", e);
        }
        try {
            prepStatSequences.close();
        } catch (Exception e) {
            Log.log(Log.LOG_WARNING, "Could not close prepared statement for sequences", e);
        }
        try {
            prepStatConstraints.close();
        } catch (Exception e) {
            Log.log(Log.LOG_WARNING, "Could not close prepared statement for constraints", e);
        }
        try {
            prepStatIndecies.close();
        } catch (Exception e) {
            Log.log(Log.LOG_WARNING, "Could not close prepared statement for indecies", e);
        }
        try {
            prepStatColumnsOfSchema.close();
        } catch (Exception e) {
            Log.log(Log.LOG_WARNING, "Could not close prepared statement for schema columns", e);
        }
    }
    
    private PgSchema getSchema(ResultSet res) throws SQLException, UnsupportedEncodingException{
        String schemaName = res.getString(NAMESPACE_NSPNAME);
        Long schemaOid = res.getLong(OID);
        PgSchema s = new PgSchema(schemaName, "");

        if (!schemaName.equals(ApgdiffConsts.PUBLIC)){
            s.setOwner(res.getString("owner"));
        }
        setPrivileges(s, schemaName, res.getString("nspacl"), res.getString("owner"), null);
        
        String comment = res.getString("comment");
        if (!schemaName.equals(ApgdiffConsts.PUBLIC) && comment != null && !comment.isEmpty()){
            s.setComment(ParserUtils.quoteString(comment));
        }
        
        // setting current schema as default
        try(Statement stmnt = connection.createStatement()){
            stmnt.execute("SET search_path TO " + schemaName + ";");
        }
        
        // TABLES
        prepStatTables.setLong(1, schemaOid);
        try(ResultSet resTables = prepStatTables.executeQuery()){
            while (resTables.next()) {                
                PgTable table = getTable(resTables, schemaName);
                monitor.worked(1);
                if (table != null){
                    s.addTable(table);
                }
            }
        }
        
        // CONSTRAINTS
        PgTable table = null;
        prepStatConstraints.setLong(1, schemaOid);
        try(ResultSet resConstraints = prepStatConstraints.executeQuery()){
            while (resConstraints.next()){
                table = s.getTable(resConstraints.getString(CLASS_RELNAME));
                if (table != null){
                    PgConstraint constraint = getConstraint(resConstraints, schemaName, table.getName());
                    if (constraint != null){
                        table.addConstraint(constraint);
                    }
                }
            }
        }
        
        // INDECIES
        prepStatIndecies.setLong(1, schemaOid);
        try(ResultSet resIndecies = prepStatIndecies.executeQuery()){
            while (resIndecies.next()){
                table = s.getTable(resIndecies.getString("table_name"));
                if (table != null){
                    PgIndex index = getIndex(resIndecies, table.getName());
                    monitor.worked(1);
                    if (index != null){
                        table.addIndex(index);
                    }
                }
            }
        }
        
        // TRIGGERS
        
        prepStatTriggers.setLong(1, schemaOid);
        try(ResultSet resTriggers = prepStatTriggers.executeQuery()){
            while(resTriggers.next()){
                table = s.getTable(resTriggers.getString(CLASS_RELNAME));
                if (table != null){
                    PgTrigger trigger = getTrigger(resTriggers, schemaName);
                    if (trigger != null){
                        table.addTrigger(trigger);
                    }    
                }
            }
        }
        
        // VIEWS
        prepStatViews.setLong(1, schemaOid);
        try(ResultSet resViews = prepStatViews.executeQuery()){
            while (resViews.next()) {
                PgView view = getView(resViews, schemaName);
                monitor.worked(1);
                if (view != null){
                    s.addView(view);                    
                }
            }
        }
        
        // FUNCTIONS
        prepStatFunctions.setLong(1, schemaOid);
        try(ResultSet resFuncs = prepStatFunctions.executeQuery()){
            while (resFuncs.next()){
                PgFunction function = getFunction(resFuncs, schemaName);
                if (function != null){
                    s.addFunction(function);
                }
            }
        }

        // SEQUENCES
        prepStatSequences.setLong(1, schemaOid);
        try(ResultSet resSeq = prepStatSequences.executeQuery()){
            while(resSeq.next()){
                PgSequence sequence = getSequence(resSeq, schemaName);
                monitor.worked(1);
                if (sequence != null){
                    s.addSequence(sequence);
                }
            }
        }
        
        setSequencesCacheValue(s);
        return s;
    }
    
    private void setSequencesCacheValue(PgSchema s) throws SQLException {
        final String prefix = "SELECT sequence_name, cache_value FROM ";
        final String postfix = " WHERE cache_value != 1";
        final String union = "\nUNION \n";
        
        StringBuilder unionSeqCache = new StringBuilder();
        List<PgSequence> seqs = s.getSequences();
        if (seqs.size() == 0){
            return;
        }
        
        for (int i = 0; i < seqs.size(); i++){
            PgSequence seq = seqs.get(i);
            unionSeqCache.append(prefix).append(seq.getName()).append(postfix);
            if (i < (seqs.size() - 1)){
                unionSeqCache.append(union);
            }
        }
        
        try(Statement stmnt = connection.createStatement()){
            try(ResultSet res = stmnt.executeQuery(unionSeqCache.toString())){
                while (res.next()){
                    s.getSequence(res.getString("sequence_name")).setCache(res.getString("cache_value"));
                }
            }
        }
    }

    private PgExtension getExtension(ResultSet res) throws SQLException {
        PgExtension e = new PgExtension(res.getString("extname"), "");
//        e.setVersion(res.getString("extversion"));
        e.setOwner(getRoleNameByOid(res.getLong("extowner")));
        e.setSchema(res.getString("namespace"));
        
        String comment = res.getString("description");
        e.setComment(comment != null && !comment.isEmpty() ? 
                ParserUtils.quoteString(comment) : null);
        return e;
    }

    private PgConstraint getConstraint(ResultSet res, String schemaName, String tableName) 
            throws SQLException {
        String constraintName = res.getString("conname");
        StringBuilder definition = new StringBuilder();
        PgConstraint c = new PgConstraint(constraintName, "", getSearchPath(schemaName));
        
        List<String> columnNames = res.getArray("conkey") == null ? new ArrayList<String>() : 
                getColumnNames((Integer[])res.getArray("conkey").getArray(), res.getLong("conrelid"));
        
        switch (res.getString("contype")){
            case "f":
                c = new PgForeignKey(constraintName, "", getSearchPath(schemaName));
                List<String> referencedColumnNames = getColumnNames(
                        (Integer[])res.getArray("confkey").getArray(), res.getLong("confrelid"));
                
                definition.append("FOREIGN KEY (").append(getStringListAsString(columnNames, ", "));
                definition.append(") REFERENCES " + res.getString("confrelid_name") + "(");
                definition.append(getStringListAsString(referencedColumnNames, ", ")).append(")");
                
                for (String colName : referencedColumnNames){
                    if (colName != null){
                        GenericColumn referencedColumn = new GenericColumn(
                                res.getString("foreign_schema_name"), 
                                res.getString("foreign_table_name"), 
                                colName);
                        ((PgForeignKey)c).addForeignColumn(referencedColumn);                        
                    }
                }
                
                switch (res.getString("confmatchtype")){
                    case "f":
                        definition.append(" MATCH FULL");
                        break;
                    case "p":
                        definition.append(" MATCH PARTIAL");
                        break;
                }
                
                switch(res.getString("confupdtype")){
                    case "r":
                        definition.append(" ON UPDATE RESTRICT");
                        break;
                    case "c":
                        definition.append(" ON UPDATE CASCADE");
                        break;
                    case "n":
                        definition.append(" ON UPDATE SET NULL");
                        break;
                    case "d":
                        definition.append(" ON UPDATE SET DEFAULT");
                        break;
                }
                
                switch(res.getString("confdeltype")){
                    case "r":
                        definition.append(" ON DELETE RESTRICT");
                        break;
                    case "c":
                        definition.append(" ON DELETE CASCADE");
                        break;
                    case "n":
                        definition.append(" ON DELETE SET NULL");
                        break;
                    case "d":
                        definition.append(" ON DELETE SET DEFAULT");
                        break;
                }
                break; // end foreign key
            case "p":
                definition.append("PRIMARY KEY (");
                definition.append(getStringListAsString(columnNames, ", ")).append(")");
                break;
            case "c":
                definition.append("CHECK (" + res.getString("consrc_usable") + ")");
                break;
            case "u":
                definition.append("UNIQUE (");
                definition.append(getStringListAsString(columnNames, ", ")).append(")");
                break;
        }
        
        c.setDefinition(definition.toString());
        
        // set table name
        c.setTableName(tableName);
        
        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()){
            c.setComment(ParserUtils.quoteString(comment));
        }
        
        return c;
    }
    
    private String getStringListAsString(List<String> strings, String delimeter){
        StringBuilder resultList = new StringBuilder();
        for(int i = 0; i < strings.size(); i++){
            String listItem = strings.get(i);
            resultList.append(listItem);
            if(i < strings.size() - 1){
                resultList.append(delimeter);
            }
        }
        return resultList.toString();
    }
    
    private PgView getView(ResultSet res, String schemaName) throws SQLException {
        for(String depType : (String[]) res.getArray("deptype").getArray()){
            if (depType.equals("e")){
                return null;
            }
        }
        String viewName = res.getString(CLASS_RELNAME);
        
        String viewDef = res.getString("definition").trim();
        if (viewDef.charAt(viewDef.length() - 1) == ';'){
            viewDef = viewDef.substring(0, viewDef.length() - 1);
        }
        
        PgView v = new PgView(viewName, viewDef, getSearchPath(schemaName));
        v.setQuery(viewDef);
        
        // TODO костыль: необходимо передавать БД с дефолтной схемой = текущей схеме,
        // чтобы заполнять имя схемы в PgSelect'e, если селект происходит из 
        // не-schema-qualified таблицы. Передавать сюда рабочую БД (которую
        // мы компилируем из JDBC) не имеет смысла - текущая схема туда еще не 
        // добавлена, так как находится в работе.
        PgDatabase fakeDb = new PgDatabase();
        if (!schemaName.equals(ApgdiffConsts.PUBLIC)){
            fakeDb.addSchema(new PgSchema(schemaName, ""));
        }
        fakeDb.setDefaultSchema(schemaName);
        if (useAntrlForViews) {
            v.setSelect(parseAntLrSelect(fakeDb, viewDef, getSearchPath(schemaName)));
        } else {
            v.setSelect(SelectParser.parse(fakeDb, viewDef, getSearchPath(schemaName)));
        }
        
        // Query columns default values and comments
        Array colNamesArr = res.getArray("column_names");
        if (colNamesArr != null){
            String[] colNames = (String[]) colNamesArr.getArray();
            String[] colComments = (String[]) res.getArray("column_comments").getArray();
            String[] colDefaults = (String[]) res.getArray("column_defaults").getArray();
            
            for (int i = 0; i < colNames.length; i++){
                String colName = colNames[i];
                String colDefault = colDefaults[i];
                if (colDefault != null){
                    v.addColumnDefaultValue(colName, colDefault);
                }
                String colComment = colComments[i];
                if (colComment != null){
                    v.addColumnComment(colName, ParserUtils.quoteString(colComment));
                }    
            }
        }
        
        // OWNER
        v.setOwner(getRoleNameByOid(res.getLong(CLASS_RELOWNER)));
        
        // Query view privileges
        setPrivileges(v, viewName, res.getString("relacl"), v.getOwner(), null);
        
        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()){
            v.setComment(ParserUtils.quoteString(comment));
        }
        
        return v;
    }
    
    private PgSelect parseAntLrSelect(PgDatabase db, String statement, String searchPath) {
        PgSelect select = new PgSelect(statement, searchPath);
        SQLLexer lexer = new SQLLexer(new ANTLRInputStream(statement));
        lexer.removeErrorListeners();
        lexer.addErrorListener(CustomErrorListener.INSTATANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SQLParser parser = new SQLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(CustomErrorListener.INSTATANCE);
        CreateView cv = new CreateView(null, db, Paths.get("/"));
        SelectQueryVisitor visitor = cv.getVisitor(select);
        visitor.visit(parser.query_expression());
        return visitor.getSelect();
    }

    private PgTable getTable(ResultSet res, String schemaName) throws SQLException{
        for(String depType : (String[]) res.getArray("deptype").getArray()){
            if (depType.equals("e")){
                return null;
            }
        }
        String tableName = res.getString(CLASS_RELNAME);
        String tableOwner = getRoleNameByOid(res.getLong(CLASS_RELOWNER));
        StringBuilder tableDef = new StringBuilder(); 
        tableDef.append("CREATE TABLE ".concat(tableName).concat(" (\n"));
        
        List<PgColumn> columns = new ArrayList<>();
        
        Integer[] colNumbers = (Integer[])res.getArray("col_numbers").getArray();
        String[] colNames = (String[])res.getArray("col_names").getArray();
        Long[] colTypes = (Long[])res.getArray("col_types").getArray();
        String[] colDefaults = (String[])res.getArray("col_defaults").getArray();
        String[] colComments = (String[])res.getArray("col_comments").getArray();
        Integer[] colTypeMod = (Integer[])res.getArray("col_typemod").getArray();
        Boolean[] colNotNull = (Boolean[])res.getArray("col_notnull").getArray();
        for (int i = 0; i < colNumbers.length; i++) {
            if (colNumbers[i] < 1){
                continue;
            }
            
            String columnName = colNames[i];
            PgColumn column = new PgColumn(columnName);
            
            PgType columnType = cachedTypeNamesByOid.get(colTypes[i]);
            String columnTypeName = getTypeNameByOid(colTypes[i], schemaName);
             
            // pg_catalog.pg_attribute.atttypmod records type-specific data supplied 
            // at table creation time (for example, the maximum length of a varchar column). 
            // It is passed to type-specific input functions and length coercion functions. 
            // The value will generally be -1 for types that do not need atttypmod.
            //
            // if column type has it's "Type modifier output function" typmodout and
            // column type has it's atttypmod set up (colTypeMod[i] != -1)
            if (colTypeMod[i] != -1 && columnType.getTypmodout() != null && 
                    !columnType.getTypmodout().isEmpty()){
                String typMod = "";
                
                // Map of those colTypeMod values that 've been already queried in
                // form of "SELECT typmodout(colTypeMod)"
                Map<Integer, String> typeAvailableModes = cachedTypesTypmodouts.get(colTypes[i]);
                
                // if it was queried already, just use cached value
                if (typeAvailableModes != null && typeAvailableModes.containsKey(colTypeMod[i])){
                    typMod = typeAvailableModes.get(colTypeMod[i]);
                }
                // else query "SELECT typmodout(colTypeMod)" and cache result for further use
                else{
                    StringBuilder query = new StringBuilder();
                    query.append("SELECT ").append(columnType.getTypmodout());
                    query.append("(").append(String.valueOf(colTypeMod[i])).append(")");
                    try(Statement stmnt = connection.createStatement();
                            ResultSet resTypMod = stmnt.executeQuery(query.toString())){
                        if (resTypMod.next()){
                            typMod = resTypMod.getString(1);
                            // cache queried values 
                            if (typeAvailableModes == null){
                                typeAvailableModes = new HashMap<>();
                                typeAvailableModes.put(colTypeMod[i], typMod);
                                cachedTypesTypmodouts.put(colTypes[i], typeAvailableModes);
                            }else{
                                typeAvailableModes.put(colTypeMod[i], typMod);
                            }
                        }
                    }
                }
                
                // finally append type modifier
                columnTypeName = columnTypeName.concat(typMod);
            }
            column.setType(columnTypeName);
            
            tableDef.append("   " + columnName + " " + columnTypeName);
            
            String columnDefault = colDefaults[i];
            if (columnDefault != null && !columnDefault.isEmpty()){
                tableDef.append(" DEFAULT ").append(columnDefault);
                column.setDefaultValue(columnDefault);
            }
            
            if (colNotNull[i]){
                tableDef.append(" NOT NULL");
                column.setNullValue(false);
            }
            
            tableDef.append(",\n");
            String comment = colComments[i];
            if (comment != null && !comment.isEmpty()){
                column.setComment(ParserUtils.quoteString(comment));                
            }
            columns.add(column);
        }
        tableDef.append(");");
        
        PgTable t = new PgTable(tableName, tableDef.toString(), getSearchPath(schemaName));
        // INHERITS
        Array arrInherits = res.getArray("inherited");
        String [] inherits = null;
        if(arrInherits != null && (inherits = (String[]) arrInherits.getArray()) != null && 
                inherits.length > 0){
            for (String inherited : inherits){
                t.addInherits(
                        ParserUtils.getSecondObjectName(inherited), ParserUtils.getObjectName(inherited));
            }
        }else{
            for(PgColumn column : columns){
                t.addColumn(column);
            }
            
            // SEQUENCES
            for (String seqName : (String[])res.getArray("seqs").getArray()){
                if (seqName != null && !seqName.isEmpty()){
                    t.addSequence(seqName);
                }
            }
        }

        // STORAGE PARAMETERS
        Array arr = res.getArray("reloptions");
        if (arr != null){
            StringBuilder storageParameters = new StringBuilder();
            String[] options = (String[])arr.getArray();
            for(int i = 0; i < options.length; i++){
                storageParameters.append(options[i]);
                
                if (i < options.length - 1){
                    storageParameters.append(", ");
                }
            }
            if (storageParameters.length() > 0){
                storageParameters.insert(0, "(").append(")");
                t.setWith(storageParameters.toString());
            }
        }
        
        // Table COMMENTS
        String comment = res.getString("table_comment");
        if (comment != null && !comment.isEmpty()){
            t.setComment(ParserUtils.quoteString(comment));                
        }
        
        // PRIVILEGES, OWNER
        t.setOwner(tableOwner);
        setPrivileges(t, t.getName(), res.getString("aclarray"), t.getOwner(), null);
        
        // COLUMNS PRIVILEGES
        String[] colAcl = (String[])res.getArray("col_acl").getArray();
        for (int i = 0; i < colNumbers.length; i++) {
            String columnPrivileges = colAcl[i];
            if (columnPrivileges != null && !columnPrivileges.isEmpty()){
                setPrivileges(t, tableName, columnPrivileges, tableOwner, colNames[i]);
            }
        }

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
     * @param schemaName 
     */
    private PgTrigger getTrigger(ResultSet res, String schemaName)
            throws SQLException, UnsupportedEncodingException {
  
        String triggerName = res.getString("tgname");
        PgTrigger t = new PgTrigger(triggerName, "", getSearchPath(schemaName));
        
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
        }else{
            t.setBefore(false);
        }
        
        String tableName = res.getString("tgrelid");
        t.setTableName(tableName);
        
        String functionName = res.getString("proname").concat("(");
        byte[] args = res.getBytes("tgargs");
        if (args.length > 0){
            StringBuilder sbArgs = new StringBuilder();
            int start = 0;
            for (int i = 0; i < args.length; ++i) {
                if (args[i] != 0) {
                    continue;
                }
                
                sbArgs.append(new String(args, start, i - start, connector.getEncoding()));
                if (i != args.length - 1) {
                    sbArgs.append("', '");
                }
                start = i + 1;
            }
            functionName = functionName.concat('\'' + sbArgs.toString() + '\'');
        }
        functionName = functionName.concat(")");
        if (!res.getString(NAMESPACE_NSPNAME).equals(schemaName)){
            functionName = res.getString(NAMESPACE_NSPNAME).concat(".").concat(functionName);
        }
        
        t.setFunction(functionName);
        return t;
    }
    
    private PgIndex getIndex(ResultSet res, String tableName) throws SQLException {
        String schemaName = res.getString("namespace");
        
        String indexName = res.getString(CLASS_RELNAME);
        PgIndex i = new PgIndex(indexName, "", getSearchPath(schemaName));
        i.setTableName(tableName);

        String definition = res.getString("definition"); 
        i.setDefinition(definition.substring(definition.indexOf("USING ")));
        
        i.setUnique(res.getBoolean("indisunique"));
        setOwner(i, res.getLong(CLASS_RELOWNER));
        
        return i;
    }
    
    private void setOwner(PgStatement statement, Long ownerOid){
        setOwner(statement, getRoleNameByOid(ownerOid));
    }
    
    private void setOwner(PgStatement statement, String ownerName){
        statement.setOwner(ownerName);
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
        for(String depType : (String[]) res.getArray("deps").getArray()){
            if (depType.equals("e")){
                return null;
            }
        }
        
        String functionName = res.getString("proname");
        PgFunction f = new PgFunction(functionName, "", getSearchPath(schemaName));
        
        f.setBody(getFunctionBody(res));
        
        // RETURN TYPE
        Array proargmodes = res.getArray("proargmodes");
        boolean returnsTable = false;
        StringBuilder returnedTableArguments = new StringBuilder();
        if (proargmodes != null && Arrays.asList((String[])proargmodes.getArray()).contains("t")){
            String [] argModes = (String[])proargmodes.getArray();
            String [] argNames = (String[])res.getArray("proargnames").getArray();
            Long [] argTypeOids = (Long[])res.getArray("proallargtypes").getArray();
            for(int i = 0; i < argModes.length; i++){
                String type = argModes[i];
                if (type.equals("t")){
                    returnsTable = true;
                    if(returnedTableArguments.length() > 0){
                        returnedTableArguments.append(", ");
                    }
                    returnedTableArguments.append(argNames[i]).append(" ");
                    returnedTableArguments.append(getTypeNameByOid(argTypeOids[i], schemaName));
                }
            }            
        }
        
        if (returnsTable){
            f.setReturns("TABLE(" + returnedTableArguments + ")");
        }else if (res.getBoolean("proretset")){
            f.setReturns("SETOF " + getTypeNameByOid(res.getLong("prorettype"), schemaName));
        }else{
            f.setReturns(getTypeNameByOid(res.getLong("prorettype"), schemaName));
        }
        
        // ARGUMENTS
        String arguments = res.getString("proarguments");
        if (!arguments.isEmpty()){
            CreateFunctionParser.parseArguments(new Parser("(" + arguments + ")"), f);
        }
        
        // OWNER
        setOwner(f, res.getLong("proowner"));
        
        // PRIVILEGES
        String signatureWithoutDefaults = functionName + "(" + 
                res.getString("proarguments_without_default") + ")";
        setPrivileges(f, signatureWithoutDefaults, res.getString("aclArray"), f.getOwner(), null);
        
        // COMMENT
        String comment = res.getString("comment");
        f.setComment(comment != null && !comment.isEmpty() ?
                ParserUtils.quoteString(comment) : null);
        return f;
    }
    
    private String getFunctionBody(ResultSet res) throws SQLException {
        StringBuilder body = new StringBuilder();
        
        body.append("LANGUAGE ").append(res.getString("lang_name"));
        
        if (res.getBoolean("proiswindow")){
            body.append(" WINDOW");
        }
        
        // VOLATILE is default
        switch (res.getString("provolatile")){
            case "i":   body.append(" IMMUTABLE");
                        break;
            case "s":   body.append(" STABLE");
                        break;
        }
        if (res.getBoolean("proleakproof")){
            body.append(" LEAKPROOF");
        }
        
        // CALLED ON NULL INPUT is default
        if (res.getBoolean("proisstrict")){
            body.append(" STRICT");
        }
        
        // SECURITY INVOKER is default
        if (res.getBoolean("prosecdef")){
            body.append(" SECURITY DEFINER");
        }
        
        float cost = res.getFloat("procost");
        if (cost != DEFAULT_PROCOST){
            body.append(" COST ").append((int)cost);
        }
        
        float rows = res.getFloat("prorows");
        if (rows != 0.0f && rows != DEFAULT_PROROWS){
            body.append(" ROWS ").append((int)rows);
        }
        
        Array configParams = res.getArray("proconfig");
        if (configParams != null){
            for(String param : (String[]) configParams.getArray()){
                body.append("\n    SET ").append(param.replaceFirst("=", " TO "));
            }
        }
        
        String definition = res.getString("prosrc").replace("\r", "");
        String quote = getStringLiteralDollarQuote(definition);
        body.append("\n    AS ").append(quote).append(definition).append(quote);
        return body.toString();
    }

    /**
     * Function equivalent to appendStringLiteralDQ in dumputils.c
     * 
     * TODO implement other quoting based on probin column data, as in pg_dump.c::dumpFunc
     * @param definition
     * @return
     */
    private String getStringLiteralDollarQuote(String definition) {
        final String suffixes = "_XXXXXXX";
        String quote = "$";
        int counter = 0;
        while(definition.contains(quote) && counter < suffixes.length()){
            quote = quote.concat(String.valueOf(suffixes.charAt(counter)));
            counter++;
        }
        
        return quote.concat("$");
    }

    private PgSequence getSequence(ResultSet res, String schemaName) throws SQLException {
        String sequenceName = res.getString(CLASS_RELNAME);
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
        
        Integer referencedColumn = res.getInt("referenced_column");
        if (referencedColumn != 0){
            s.setOwnedBy(res.getString("referenced_table_name") + "." + res.getString("ref_col_name"));
        }
        
        setOwner(s, res.getLong(CLASS_RELOWNER));
        
        // PRIVILEGES
        setPrivileges(s, sequenceName, res.getString("aclArray"), s.getOwner(), null);
        
        return s;
    }
    
    /**
     * Parses <code>aclItemsArrayAsString</code> and adds parsed privileges to 
     * <code>PgStatement</code> object. Owner privileges go first.
     * <br>
     * Currently supports only adding privileges to PgFunction, PgSequence, 
     * PgTable, PgView, PgSchema
     * 
     * @param st    PgStatement object where privileges to be added
     * @param stSignature   PgStatement signature (differs in different PgStatement instances)
     * @param aclItemsArrayAsString     Input acl string in the 
     *                                  form of "{grantee=grant_chars/grantor[, ...]}"
     * @param owner the owner of PgStatement object (why separate?)
     * @param column    column name, if this aclItemsArrayAsString is column 
     *                      privilege string; otherwise null
     */
    private void setPrivileges(PgStatement st, String stSignature, 
            String aclItemsArrayAsString, String owner, String columnName){
        if (aclItemsArrayAsString == null){
            return;
        }
        String stType;
        String order = "arwdDxtXUCTc";
        if (st instanceof PgSequence){
            stType = "SEQUENCE";
            order = "rUw";
        }else if (st instanceof PgFunction){
            stType = "FUNCTION";
            order = "X";
        }else if (st instanceof PgTable || st instanceof PgView){
            stType = "TABLE";
            order = "raxdtDw";
        }else if (st instanceof PgSchema){
            stType = "SCHEMA";
            order = "CU";
        }else{
            throw new IllegalStateException("Not supported PgStatement class");
        }
        int possiblePrivilegeCount = order.length();
        
        String column = (columnName != null && !columnName.isEmpty()) ? "(" + columnName + ")" : "";
        String revokePublic = "ALL" + column + " ON " + stType + " " + stSignature + " FROM PUBLIC";
        String revokeOwner = "ALL" + column + " ON " + stType + " " + stSignature + " FROM " + 
                PgDiffUtils.getQuotedName(owner);
        st.addPrivilege(new PgPrivilege(true, revokePublic, "REVOKE " + revokePublic));
        
        List<Privilege> grants = new JdbcAclParser().parse(
                aclItemsArrayAsString, possiblePrivilegeCount, order, owner);
        
        boolean metDefaultOwnersGrants = false;
        for (Privilege p : grants){            
            if (p.isDefault){
                metDefaultOwnersGrants = true;
            }
        }
        
        if (!metDefaultOwnersGrants){
            st.addPrivilege(new PgPrivilege(true, revokeOwner, "REVOKE " + revokeOwner));
        }
        
        for(Privilege grant : grants){
            // skip if default owner's privileges
            if (grant.isDefault){
                continue;
            }
            List<String> grantValues = grant.grantValues;
            if (column != null && !column.isEmpty()){
                grantValues = new ArrayList<>(grant.grantValues.size());
                for (String plainGrant : grant.grantValues){
                    grantValues.add(plainGrant + column);
                }
            }
            String privDefinition = getStringListAsString(grantValues, ",") + " ON " + stType + " " + 
                    stSignature + " TO " + grant.grantee;
            if (grant.isGO){
                privDefinition = privDefinition.concat(" WITH GRANT OPTION");
            }
            st.addPrivilege(new PgPrivilege(false, privDefinition, "GRANT " + privDefinition));
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
                    previousMap = new HashMap<>();
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
                tableColumns = new HashMap<>();
                while(res.next()){
                    tableColumns.put(res.getInt("attnum"), res.getString("attname"));
                }
                cachedColumnNamesByTableOid.put(tableOid, tableColumns);
            }
        }
        List<String> result = new ArrayList<>();
        for(Integer n : cols){
            result.add(tableColumns.get(n));
        }
        return result;
    }
    
    /**
     * Returns the name of a type, whose <code>oid = typeOid</code>. If the type's schema name 
     * differs from targetSchemaName, the returned type name is schema-qualified.
     */
    private String getTypeNameByOid(Long typeOid, String targetSchemaName) throws SQLException {
        PgType type = cachedTypeNamesByOid.get(typeOid);
        return type.getParentSchema().equals("pg_catalog") || (type.getParentSchema().equals(targetSchemaName)) ? 
                type.getTypeName() : type.getParentSchema().concat(".").concat(type.getTypeName());
    }
    
    /**
     * Returns the role name by its oid. If role oid is 0, returns "PUBLIC". 
     * If no role with such oid exists, returns null.
     */
    private String getRoleNameByOid(Long roleOid){
        return roleOid == 0 ? "PUBLIC" : cachedRolesNamesByOid.get(roleOid);
    }
}
