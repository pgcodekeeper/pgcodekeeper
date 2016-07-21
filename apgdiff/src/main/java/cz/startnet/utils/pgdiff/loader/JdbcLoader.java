package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRewrite;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTrigger.WhenListener;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract.FunctionSearcher;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSelect;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgType.PgTypeForm;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
    private PreparedStatement prepStatIndices;
    private PreparedStatement prepStatColumnsOfSchema;
    private PreparedStatement prepStatTypes;
    private PreparedStatement prepStatRules;

    private final Map<Long, String> cachedRolesNamesByOid = new HashMap<>();
    private final Map<Long, JdbcType> cachedTypeNamesByOid = new HashMap<>();
    private final Map<Long, Map<Integer, String>> cachedColumnNamesByTableOid = new HashMap<>();

    private Connection connection;
    private final JdbcConnector connector;
    private final SubMonitor monitor;
    private final PgDiffArguments args;
    private GenericColumn currentObject;
    private String currentOperation;

    private Map<Long, String> schemaIds = new HashMap<>();

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments) {
        this(connector, pgDiffArguments, SubMonitor.convert(null));
    }

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments,
            SubMonitor monitor) {
        this.connector = connector;
        this.args = pgDiffArguments;
        this.monitor = monitor;
    }

    public PgDatabase getDbFromJdbc() throws IOException, InterruptedException, LicenseException {
        PgDatabase d = new PgDatabase();
        d.setArguments(args);
        try {
            Log.log(Log.LOG_INFO, "Reading db using JDBC.");
            setCurrentOperation("connection setup");
            connection = connector.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setReadOnly(true);
            setTimeZone(connector.getTimezone());

            int TOTAL_MASK = checkExistingPerformanceFunctions(connection);

            prepareStatements(TOTAL_MASK);
            prepareData();

            // query total objects count
            setCurrentOperation("object count query");
            try (Statement stmnt = connection.createStatement();
                    ResultSet resCount = stmnt.executeQuery(JdbcQueries.QUERY_TOTAL_OBJECTS_COUNT)) {
                if (resCount.next()) {
                    monitor.setWorkRemaining(resCount.getInt(1) + 50);
                } else {
                    monitor.setWorkRemaining(DEFAULT_OBJECTS_COUNT);
                }
            }

            Log.log(Log.LOG_INFO, "Querying schemas");
            setCurrentOperation("schemas query");
            try (Statement stmnt = connection.createStatement();
                    ResultSet res = stmnt.executeQuery(JdbcQueries.QUERY_SCHEMAS)) {

                while (res.next()) {
                    Log.log(Log.LOG_INFO, "Querying objects for schema " + res.getString(NAMESPACE_NSPNAME));
                    prepareDataForSchema(res.getLong(OID));
                    PgDumpLoader.checkCancelled(monitor);
                    PgSchema schema = getSchema(res);
                    if (ApgdiffConsts.PUBLIC.equals(schema.getName())) {
                        d.replaceSchema(d.getSchema(ApgdiffConsts.PUBLIC), schema);
                    } else {
                        d.addSchema(schema);
                    }
                }
            }

            //TODO
            addAllTables(isPerformance(DbObjType.TABLE, TOTAL_MASK), d);
            addAllViews(isPerformance(DbObjType.VIEW, TOTAL_MASK), d);
            addAllTriggers(isPerformance(DbObjType.TRIGGER, TOTAL_MASK), d);
            addAllRules(isPerformance(DbObjType.RULE, TOTAL_MASK), d);
            addAllFunctions(isPerformance(DbObjType.FUNCTION, TOTAL_MASK), d);
            addAllIndeces(isPerformance(DbObjType.INDEX, TOTAL_MASK), d);
            addAllSequences(isPerformance(DbObjType.SEQUENCE, TOTAL_MASK), d);
            addAllConstraints(isPerformance(DbObjType.CONSTRAINT, TOTAL_MASK), d);

            Log.log(Log.LOG_INFO, "Querying extensions");
            setCurrentOperation("extensions query");
            try (Statement stmnt = connection.createStatement();
                    ResultSet res = stmnt.executeQuery(JdbcQueries.QUERY_EXTENSIONS)) {
                while (res.next()) {
                    PgDumpLoader.checkCancelled(monitor);
                    PgExtension extension = getExtension(res);
                    monitor.worked(1);
                    if (extension != null) {
                        d.addExtension(extension);
                    }
                }
            }

            connection.commit();
            Log.log(Log.LOG_INFO, "Database object has been successfully queried from JDBC");
        } catch (Exception e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception ex) {
                e.addSuppressed(ex);
                Log.log(Log.LOG_ERROR, "Cannot rollBack changes", ex);
            }
            if (e instanceof InterruptedException) {
                throw (InterruptedException) e;
            }
            throw new IOException(MessageFormat.format(
                    Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), getCurrentLocation()), e);
        } finally {
            Log.log(Log.LOG_INFO, "Closing used JDBC resources");
            closeResources(connection, prepStatTables, prepStatViews, prepStatTriggers,
                    prepStatFunctions, prepStatSequences, prepStatConstraints,
                    prepStatIndices, prepStatColumnsOfSchema, prepStatTypes);
        }
        args.getLicense().verifyDb(d);
        return d;
    }

    private void setTimeZone(String timezone) throws SQLException {
        Log.log(Log.LOG_INFO, "Setting JDBC session timezone to " + timezone);
        try (Statement stmnt = connection.createStatement()) {
            stmnt.execute("SET timezone = '" + timezone + '\'');
        }
    }

    private void prepareData() throws SQLException {
        try (Statement stmnt = connection.createStatement()) {
            // fill in rolenames
            setCurrentOperation("roles query");
            try (ResultSet res = stmnt.executeQuery("SELECT oid::bigint, rolname FROM pg_catalog.pg_roles")) {
                while (res.next()) {
                    cachedRolesNamesByOid.put(res.getLong(OID), res.getString("rolname"));
                }
            }

            // fill in data types
            setCurrentOperation("type cache query");
            try (ResultSet res = stmnt.executeQuery(JdbcQueries.QUERY_TYPES_FOR_CACHE_ALL)) {
                while (res.next()) {
                    JdbcType type = new JdbcType(res.getString("typname"), res.getString("castedType"),
                            res.getLong("typarray"), res.getInt("typlen"), res.getString("proname"),
                            res.getString(NAMESPACE_NSPNAME));
                    cachedTypeNamesByOid.put(res.getLong(OID), type);
                }
            }
        }
    }

    private void prepareStatements(int TOTAL_MASK) throws SQLException {
        setCurrentOperation("prepared statements");
        prepStatTables = connection.prepareStatement(!isPerformance(DbObjType.TABLE, TOTAL_MASK)
                ? JdbcQueries.QUERY_TABLES_PER_SCHEMA : JdbcQueries.QUERY_GET_ALL_TABLE);
        prepStatViews = connection.prepareStatement(!isPerformance(DbObjType.VIEW, TOTAL_MASK)
                ? JdbcQueries.QUERY_VIEWS_PER_SCHEMA : JdbcQueries.QUERY_GET_ALL_VIEW);
        prepStatTriggers = connection.prepareStatement(!isPerformance(DbObjType.TRIGGER, TOTAL_MASK)
                ? JdbcQueries.QUERY_TRIGGERS_PER_SCHEMA : JdbcQueries.QUERY_GET_ALL_TRIGGER);
        prepStatFunctions = connection.prepareStatement(!isPerformance(DbObjType.FUNCTION, TOTAL_MASK)
                ? JdbcQueries.QUERY_FUNCTIONS_PER_SCHEMA : JdbcQueries.QUERY_GET_ALL_FUNCTION);
        prepStatSequences = connection.prepareStatement(!isPerformance(DbObjType.SEQUENCE, TOTAL_MASK)
                ? JdbcQueries.QUERY_SEQUENCES_PER_SCHEMA : JdbcQueries.QUERY_GET_ALL_SEQUENCE);
        prepStatConstraints = connection.prepareStatement(!isPerformance(DbObjType.CONSTRAINT, TOTAL_MASK)
                ? JdbcQueries.QUERY_CONSTRAINTS_PER_SCHEMA : JdbcQueries.QUERY_GET_ALL_CONSTRAINT);
        prepStatIndices = connection.prepareStatement(!isPerformance(DbObjType.INDEX, TOTAL_MASK)
                ? JdbcQueries.QUERY_INDICES_PER_SCHEMA : JdbcQueries.QUERY_GET_ALL_INDEX);
        prepStatColumnsOfSchema = connection.prepareStatement(JdbcQueries.QUERY_COLUMNS_PER_SCHEMA);
        prepStatTypes = connection.prepareStatement(JdbcQueries.QUERY_TYPES_PER_SCHEMA);
        prepStatRules = connection.prepareStatement(!isPerformance(DbObjType.VIEW, TOTAL_MASK)
                ? JdbcQueries.QUERY_RULES_PER_SCHEMA : JdbcQueries.QUERY_GET_ALL_RULE);
    }

    private void closeResources(AutoCloseable... resources) {
        for (int i = 0; i < resources.length; ++i) {
            try {
                if (resources[i] != null) {
                    resources[i].close();
                }
            } catch (Exception ex) {
                Log.log(Log.LOG_WARNING, "Could not close JDBC resource: "
                        + resources[i] + ", array index: " + i, ex);
            }
        }
    }

    private PgSchema getSchema(ResultSet res) throws SQLException, UnsupportedEncodingException, InterruptedException {
        String schemaName = res.getString(NAMESPACE_NSPNAME);
        currentObject = new GenericColumn(schemaName, null, null);
        Long schemaOid = res.getLong(OID);
        schemaIds.put(schemaOid, schemaName);
        PgSchema s = new PgSchema(schemaName, "");

        if (!schemaName.equals(ApgdiffConsts.PUBLIC)) {
            setOwner(s, res.getString("owner"));
        }
        setPrivileges(s, schemaName, res.getString("nspacl"), res.getString("owner"), null);

        String comment = res.getString("comment");
        if (!schemaName.equals(ApgdiffConsts.PUBLIC) && comment != null && !comment.isEmpty()) {
            s.setComment(args, PgDiffUtils.quoteString(comment));
        }
        // END SCHEMA

        // setting current schema as default
        setCurrentOperation("set search_path query");
        try (Statement stmnt = connection.createStatement()) {
            stmnt.execute("SET search_path = " + PgDiffUtils.getQuotedName(schemaName)
                    + ", pg_catalog;");
        }

        // TYPES
        setCurrentOperation("types query");
        prepStatTypes.setLong(1, schemaOid);
        try (ResultSet resTypes = prepStatTypes.executeQuery()) {
            while (resTypes.next()) {
                PgDumpLoader.checkCancelled(monitor);
                PgStatement typeOrDomain = getTypeDomain(resTypes, schemaName);
                monitor.worked(1);
                if (typeOrDomain != null) {
                    if (typeOrDomain.getStatementType() == DbObjType.DOMAIN) {
                        s.addDomain((PgDomain) typeOrDomain);
                    } else {
                        s.addType((PgType) typeOrDomain);
                    }
                }
            }
        }
        return s;
    }

    private PgStatement getTypeDomain(ResultSet res, String schemaName) throws SQLException {
        PgStatement st;
        String typtype = res.getString("typtype");
        if ("d".equals(typtype)) {
            st = getDomain(res, schemaName);
        } else {
            st = getType(res, schemaName, typtype);
        }
        if (st != null) {
            setOwner(st, res.getLong("typowner"));
            setPrivileges(st, st.getName(), res.getString("typacl"), st.getOwner(), null);
            String comment = res.getString("description");
            if (comment != null && !comment.isEmpty()) {
                st.setComment(args, PgDiffUtils.quoteString(comment));
            }
        }
        return st;
    }

    private PgDomain getDomain(ResultSet res, String schemaName) throws SQLException {
        PgDomain d = new PgDomain(res.getString("typname"), "");
        currentObject = new GenericColumn(schemaName, d.getName(), null);

        d.setDataType(res.getString("dom_basetype"));
        long collation = res.getLong("typcollation");
        if (collation != 0 && collation != res.getLong("dom_basecollation")) {
            d.setCollation(PgDiffUtils.getQuotedName(res.getString("dom_collationnspname"))
                    + '.' + PgDiffUtils.getQuotedName(res.getString("dom_collationname")));
        }

        String def = res.getString("dom_defaultbin");
        if (def == null) {
            def = res.getString("typdefault");
            if (def != null) {
                def = PgDiffUtils.quoteString(def);
            }
        }
        d.setDefaultValue(def);

        d.setNotNull(res.getBoolean("dom_notnull"));

        Array arrConnames = res.getArray("dom_connames");
        if (arrConnames != null) {
            String[] connames = (String[]) arrConnames.getArray();
            String[] condefs = (String[]) res.getArray("dom_condefs").getArray();
            Boolean[] convalids = (Boolean[]) res.getArray("dom_convalidates").getArray();
            String[] concomments = (String[]) res.getArray("dom_concomments").getArray();

            for (int i = 0; i < connames.length; ++i) {
                PgConstraint c = new PgConstraint(connames[i], "");
                c.setDefinition(condefs[i]);
                if (convalids[i]) {
                    d.addConstraint(c);
                } else {
                    d.addConstrNotValid(c);
                }
                if (concomments[i] != null && !concomments[i].isEmpty()) {
                    c.setComment(args, PgDiffUtils.quoteString(concomments[i]));
                }
            }
        }

        return d;
    }

    private PgType getType(ResultSet res, String schemaName, String typtype) throws SQLException {
        String name = res.getString("typname");
        currentObject = new GenericColumn(schemaName, name, null);
        PgType t;
        switch (typtype) {
        case "b":
            t = new PgType(name, PgTypeForm.BASE, "");

            t.setInputFunction(res.getString("typinput"));
            t.setOutputFunction(res.getString("typoutput"));
            if (res.getBoolean("typreceiveset")) {
                t.setReceiveFunction(res.getString("typreceive"));
            }
            if (res.getBoolean("typsendset")) {
                t.setSendFunction(res.getString("typsend"));
            }
            if (res.getBoolean("typmodinset")) {
                t.setTypmodInputFunction(res.getString("typmodin"));
            }
            if (res.getBoolean("typmodoutset")) {
                t.setTypmodOutputFunction(res.getString("typmodout"));
            }
            if (res.getBoolean("typanalyzeset")) {
                t.setAnalyzeFunction(res.getString("typanalyze"));
            }

            Short len = res.getShort("typlen");
            t.setInternalLength(len == -1 ? "variable" : len.toString());
            t.setPassedByValue(res.getBoolean("typbyval"));

            String align = res.getString("typalign");
            switch (align) {
            case "c":
                align = "char";
                break;
            case "s":
                align = "int2";
                break;
            case "i":
                align = "int4";
                break;
            case "d":
                align = "double";
                break;
            }
            t.setAlignment(align);

            String storage = res.getString("typstorage");
            switch (storage) {
            case "p":
                storage = "plain";
                break;
            case "e":
                storage = "external";
                break;
            case "x":
                storage = "extended";
                break;
            case "m":
                storage = "main";
                break;
            }
            t.setStorage(storage);

            String cat = res.getString("typcategory");
            if (cat != null && !"U".equals(cat)) {
                t.setCategory(PgDiffUtils.quoteString(cat));
            }

            if (res.getBoolean("typispreferred")) {
                t.setPreferred("true");
            }

            String def = res.getString("typdefaultbin");
            if (def == null) {
                def = res.getString("typdefault");
                if (def != null) {
                    def = PgDiffUtils.quoteString(def);
                }
            }
            t.setDefaultValue(def);

            if (res.getLong("typelem") != 0) {
                t.setElement(res.getString("typelemname"));
            }

            String delim = res.getString("typdelim");
            if (delim != null && !",".equals(delim)) {
                t.setDelimiter(PgDiffUtils.quoteString(delim));
            }

            if (res.getLong("typcollation") != 0) {
                t.setCollatable("true");
            }
            break;

        case "c":
            t = new PgType(name, PgTypeForm.COMPOSITE, "");

            Array arrAttnames = res.getArray("comp_attnames");
            if (arrAttnames == null) {
                break;
            }
            String[] attnames = (String[]) arrAttnames.getArray();
            String[] atttypes = (String[]) res.getArray("comp_atttypdefns").getArray();
            Long[] attcollations = (Long[]) res.getArray("comp_attcollations").getArray();
            Long[] atttypcollations = (Long[]) res.getArray("comp_atttypcollations").getArray();
            String[] attcollationnames = (String[]) res.getArray("comp_attcollationnames").getArray();
            String[] attcollationnspnames = (String[]) res.getArray("comp_attcollationnspnames").getArray();
            String[] attcomments = (String[]) res.getArray("comp_attcomments").getArray();

            for (int i = 0; i < attnames.length; ++i) {
                PgColumn a = new PgColumn(attnames[i]);
                a.setType(atttypes[i]);

                // unbox
                long attcollation = attcollations[i];
                if (attcollation != 0 && attcollation != atttypcollations[i]) {
                    a.setCollation(PgDiffUtils.getQuotedName(attcollationnspnames[i])
                            + '.' + PgDiffUtils.getQuotedName(attcollationnames[i]));
                }
                t.addAttr(a);
                if (attcomments[i] != null && !attcomments[i].isEmpty()) {
                    a.setComment(args, PgDiffUtils.quoteString(attcomments[i]));
                }
            }
            break;

        case "e":
            t = new PgType(name, PgTypeForm.ENUM, "");

            Array arrEnums = res.getArray("enums");
            if (arrEnums == null) {
                break;
            }
            String[] enums = (String[]) arrEnums.getArray();
            for (String enum_ : enums) {
                t.addEnum(PgDiffUtils.quoteString(enum_));
            }
            break;

        case "r":
            t = new PgType(name, PgTypeForm.RANGE, "");

            t.setSubtype(res.getString("rngsubtype"));
            if (!res.getBoolean("opcdefault")) {
                t.setSubtypeOpClass(PgDiffUtils.getQuotedName(res.getString("opcnspname")
                        + '.' + PgDiffUtils.getQuotedName(res.getString("opcname"))));
            }

            long collation = res.getLong("rngcollation");
            if (collation != 0 && collation != res.getLong("rngsubtypcollation")) {
                t.setCollation(PgDiffUtils.getQuotedName(res.getString("rngcollationnspname"))
                        + '.' + PgDiffUtils.getQuotedName(res.getString("rngcollationname")));
            }

            if (res.getBoolean("rngcanonicalset")) {
                t.setCanonical(res.getString("rngcanonical"));
            }
            if (res.getBoolean("rngsubdiffset")) {
                t.setCanonical(res.getString("rngsubdiff"));
            }
            break;
        default:
            t = null;
        }
        return t;
    }

    private void setSequencesCacheValue(PgSchema s) throws SQLException {
        setCurrentOperation("sequences cache_value query");
        final String prefix = "SELECT sequence_name, cache_value FROM ";
        final String postfix = " WHERE cache_value != 1";
        final String union = "\nUNION \n";

        StringBuilder unionSeqCache = new StringBuilder();
        List<PgSequence> seqs = s.getSequences();
        if (seqs.size() == 0) {
            return;
        }
        for (int i = 0; i < seqs.size(); i++) {
            PgSequence seq = seqs.get(i);
            unionSeqCache.append(prefix).append(s.getName()).append(".").append(seq.getName()).append(postfix);
            if (i < (seqs.size() - 1)) {
                unionSeqCache.append(union);
            }
        }

        try (Statement stmnt = connection.createStatement();
                ResultSet res = stmnt.executeQuery(unionSeqCache.toString())) {
            while (res.next()) {
                s.getSequence(res.getString("sequence_name")).setCache(res.getString("cache_value"));
            }
        }
    }

    private PgExtension getExtension(ResultSet res) throws SQLException {
        String extName = res.getString("extname");
        currentObject = new GenericColumn(extName, null, null);
        PgExtension e = new PgExtension(extName, "");
        e.setSchema(res.getString("namespace"));

        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            e.setComment(args, PgDiffUtils.quoteString(comment));
        }
        return e;
    }

    private PgConstraint getConstraint(ResultSet res, String schemaName, String tableName)
            throws SQLException {
        String constraintName = res.getString("conname");
        currentObject = new GenericColumn(schemaName, tableName, constraintName);
        String definition = res.getString("definition");
        PgConstraint c = new PgConstraint(constraintName, "");

        String contype = res.getString("contype");
        switch (contype) {
        case "f":
            List<String> referencedColumnNames = getColumnNames(
                    (Integer[]) res.getArray("confkey").getArray(), res.getLong("confrelid"));

            for (String colName : referencedColumnNames) {
                if (colName != null) {
                    GenericColumn referencedColumn = new GenericColumn(
                            res.getString("foreign_schema_name"),
                            res.getString("foreign_table_name"),
                            colName);
                    c.addForeignColumn(referencedColumn);
                }
            }

            break; // end foreign key
        case "p":
        case "u":
            if ("p".equals(contype)) {
                c.setPrimaryKey(true);
            } else {
                c.setUnique(true);
            }
            Integer[] concols = (Integer[]) res.getArray("conkey").getArray();
            for (String name : getColumnNames(concols, res.getLong("conrelid"))) {
                c.addColumn(new GenericColumn(schemaName, tableName, name));
            }
            break;
        }

        c.setDefinition(definition);

        // set table name
        c.setTableName(tableName);

        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            c.setComment(args, PgDiffUtils.quoteString(comment));
        }

        return c;
    }

    private String getStringListAsString(List<String> strings, String delimeter) {
        StringBuilder resultList = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            String listItem = strings.get(i);
            resultList.append(listItem);
            if (i < strings.size() - 1) {
                resultList.append(delimeter);
            }
        }
        return resultList.toString();
    }

    private PgView getView(ResultSet res, String schemaName) throws SQLException {
        String viewName = res.getString(CLASS_RELNAME);
        currentObject = new GenericColumn(schemaName, viewName, null);

        String viewDef = res.getString("definition").trim();
        if (viewDef.charAt(viewDef.length() - 1) == ';') {
            viewDef = viewDef.substring(0, viewDef.length() - 1);
        }

        PgView v = new PgView(viewName, "");
        v.setQuery(viewDef);
        v.setSelect(parseAntlrSelect(schemaName, viewDef));

        // OWNER
        setOwner(v, res.getLong(CLASS_RELOWNER));

        // Query columns default values and comments
        Array colNamesArr = res.getArray("column_names");
        if (colNamesArr != null) {
            String[] colNames = (String[]) colNamesArr.getArray();
            String[] colComments = (String[]) res.getArray("column_comments").getArray();
            String[] colDefaults = (String[]) res.getArray("column_defaults").getArray();
            String[] colACLs = (String[]) res.getArray("column_acl").getArray();

            for (int i = 0; i < colNames.length; i++) {
                String colName = colNames[i];
                String colDefault = colDefaults[i];
                if (colDefault != null) {
                    v.addColumnDefaultValue(colName, colDefault);
                }
                String colComment = colComments[i];
                if (colComment != null) {
                    v.addColumnComment(args, colName, PgDiffUtils.quoteString(colComment));
                }
                String colAcl = colACLs[i];
                // Привилегии на столбцы view записываются в саму view
                if (colAcl != null) {
                    setPrivileges(v, viewName, colAcl, v.getOwner(), colName);
                }
            }
        }

        // Query view privileges
        setPrivileges(v, viewName, res.getString("relacl"), v.getOwner(), null);

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            v.setComment(args, PgDiffUtils.quoteString(comment));
        }

        return v;
    }

    private PgSelect parseAntlrSelect(String schemaName, String statement) {
        SQLParser parser = AntlrParser.makeBasicParser(statement + ';', getCurrentLocation());
        return CreateView.createSelect(parser.sql().statement(0).data_statement().select_stmt(), schemaName);
    }

    private PgTable getTable(ResultSet res, String schemaName) throws SQLException {
        String tableName = res.getString(CLASS_RELNAME);
        currentObject = new GenericColumn(schemaName, tableName, null);
        String tableOwner = getRoleNameByOid(res.getLong(CLASS_RELOWNER));

        PgTable t = new PgTable(tableName, "");

        Integer[] colNumbers = (Integer[]) res.getArray("col_numbers").getArray();
        String[] colNames = (String[]) res.getArray("col_names").getArray();
        String[] colTypeName = (String[]) res.getArray("col_type_name").getArray();
        String[] colDefaults = (String[]) res.getArray("col_defaults").getArray();
        String[] colComments = (String[]) res.getArray("col_comments").getArray();
        Boolean[] colNotNull = (Boolean[]) res.getArray("col_notnull").getArray();
        Integer[] colStatictics = (Integer[]) res.getArray("col_statictics").getArray();
        Boolean[] colIsLocal = (Boolean[]) res.getArray("col_local").getArray();
        Long[] colCollation = (Long[]) res.getArray("col_collation").getArray();
        Long[] colTypCollation = (Long[]) res.getArray("col_typcollation").getArray();
        String[] colCollationName = (String[]) res.getArray("col_collationname").getArray();
        String[] colCollationSchema = (String[]) res.getArray("col_collationnspname").getArray();

        for (int i = 0; i < colNumbers.length; i++) {
            if (colNumbers[i] < 1) {
                // system columns
                continue;
            }
            // пропускать не локальные колонки (Inherited)
            if (!colIsLocal[i]) {
                continue;
            }
            String columnName = colNames[i];
            PgColumn column = new PgColumn(columnName);
            column.setType(colTypeName[i]);

            // unbox
            long collation = colCollation[i];
            if (collation != 0 && collation != colTypCollation[i]) {
                column.setCollation(PgDiffUtils.getQuotedName(colCollationSchema[i])
                        + '.' + PgDiffUtils.getQuotedName(colCollationName[i]));
            }

            String columnDefault = colDefaults[i];
            if (columnDefault != null && !columnDefault.isEmpty()) {
                column.setDefaultValue(columnDefault);
                GenericColumn func = parseFunctionCall(columnDefault);
                if (func != null) {
                    column.addDefaultFunction(func);
                }
            }

            if (colNotNull[i]) {
                column.setNullValue(false);
            }

            Integer statistics = colStatictics[i];
            // if the attstattarget entry for this column is
            // non-negative (i.e. it's not the default value)
            if (statistics > -1) {
                column.setStatistics(statistics);
            }

            String comment = colComments[i];
            if (comment != null && !comment.isEmpty()) {
                column.setComment(args, PgDiffUtils.quoteString(comment));
            }
            t.addColumn(column);
            // SEQUENCES
            if (colDefaults[i] != null) {
                Matcher matcher = PgColumn.PATTERN_SEQUENCE.matcher(colDefaults[i]);
                if (matcher.matches()) {
                    String seq = matcher.group("schema") == null ? matcher.group("seq")
                            : matcher.group("schema") + '.' + matcher.group("seq");
                    t.addSequence(seq);
                }
            }
        }

        // INHERITS
        Array arrInherits = res.getArray("inherited");
        String[] inherits = null;
        if (arrInherits != null && (inherits = (String[]) arrInherits.getArray()) != null &&
                inherits.length > 0) {
            for (String inherited : inherits) {
                // TODO get separate IDs from DB
                QNameParser qname = new QNameParser(inherited);
                t.addInherits(qname.getSecondName(), qname.getFirstName());
            }
        }

        // STORAGE PARAMETERS
        StringBuilder storageParameters = new StringBuilder();
        Array arr = res.getArray("reloptions");
        if (arr != null) {
            fillStorageParams(storageParameters, arr, false);
        }

        arr = res.getArray("toast_reloptions");
        if (arr != null) {
            fillStorageParams(storageParameters, arr, true);
        }

        if (storageParameters.length() > 0) {
            // убираем лишние запятую-пробел
            storageParameters.setLength(storageParameters.length() - 2);
            t.setWith('(' + storageParameters.toString() + ')');
        }

        // Table COMMENTS
        String comment = res.getString("table_comment");
        if (comment != null && !comment.isEmpty()) {
            t.setComment(args, PgDiffUtils.quoteString(comment));
        }

        // TableSpace
        String tableSpace = res.getString("table_space");
        if (tableSpace != null && !tableSpace.isEmpty()) {
            t.setTablespace(tableSpace);
        }

        if (res.getBoolean("has_oids")) {
            t.setWith(storageParameters.length() > 0 ? ("(" + storageParameters + ", OIDS=true)") : "OIDS=true");
        }

        // PRIVILEGES, OWNER
        setOwner(t, tableOwner);
        setPrivileges(t, t.getName(), res.getString("aclarray"), t.getOwner(), null);

        // COLUMNS PRIVILEGES
        String[] colAcl = (String[]) res.getArray("col_acl").getArray();
        for (int i = 0; i < colNumbers.length; i++) {
            String columnPrivileges = colAcl[i];
            if (columnPrivileges != null && !columnPrivileges.isEmpty()) {
                setPrivileges(t.getColumn(colNames[i]), tableName, columnPrivileges, tableOwner, colNames[i]);
            }
        }
        return t;
    }

    // TODO отрефакторить в вычитку всех зависимостей из экспрешшена
    private GenericColumn parseFunctionCall(String string) {
        SQLParser parser = AntlrParser.makeBasicParser(string, getCurrentLocation());
        FunctionSearcher fs = new FunctionSearcher();
        ParseTreeWalker.DEFAULT.walk(fs, parser.vex());
        if (fs.getName() == null) {
            return null;
        }
        List<IdentifierContext> ids = fs.getName().identifier();
        return new GenericColumn(QNameParser.getSchemaName(ids),
                QNameParser.getFirstName(ids), null);
    }

    private void fillStorageParams(StringBuilder storageParameters,
            Array arr, boolean isToast) throws SQLException {
        String[] options = (String[]) arr.getArray();
        for (String pair : options) {
            int sep = pair.indexOf('=');
            String option, value;
            if (sep == -1) {
                option = pair;
                value = "";
            } else {
                option = pair.substring(0, sep);
                value = pair.substring(sep + 1);
            }
            if (!value.equals(PgDiffUtils.getQuotedName(value))) {
                // only quote non-ids; pg_dump behavior
                value = PgDiffUtils.quoteString(value);
            }

            if (isToast) {
                storageParameters.append("toast.");
            }
            storageParameters.append(option).append('=').append(value).append(", ");
        }
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
        String tableName = res.getString(CLASS_RELNAME);
        currentObject = new GenericColumn(schemaName, tableName, triggerName);
        PgTrigger t = new PgTrigger(triggerName, "");

        int firingConditions = res.getInt("tgtype");
        if ((firingConditions & TRIGGER_TYPE_DELETE) != 0) {
            t.setOnDelete(true);
        }
        if ((firingConditions & TRIGGER_TYPE_INSERT) != 0) {
            t.setOnInsert(true);
        }
        if ((firingConditions & TRIGGER_TYPE_UPDATE) != 0) {
            t.setOnUpdate(true);
        }
        if ((firingConditions & TRIGGER_TYPE_TRUNCATE) != 0) {
            t.setOnTruncate(true);
        }
        if ((firingConditions & TRIGGER_TYPE_ROW) != 0) {
            t.setForEachRow(true);
        }
        if ((firingConditions & TRIGGER_TYPE_BEFORE) != 0) {
            t.setBefore(true);
        } else {
            t.setBefore(false);
        }

        t.setTableName(tableName);

        String funcName = res.getString("proname");
        if (!res.getString(NAMESPACE_NSPNAME).equals(schemaName)) {
            funcName = res.getString(NAMESPACE_NSPNAME).concat(".").concat(funcName);
        }
        String functionName = funcName.concat("(");
        byte[] args = res.getBytes("tgargs");
        if (args.length > 0) {
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
        for (String col_name : getColumnNames(
                (Number[]) res.getArray("col_numbers").getArray(),
                res.getLong("table_oid"))) {
            t.addUpdateColumn(col_name);
        }
        functionName = functionName.concat(")");

        t.setFunction(functionName, funcName + "()");

        t.setWhen(parseWhen(res.getString("definition")));
        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            t.setComment(this.args, PgDiffUtils.quoteString(comment));
        }
        return t;
    }

    private String parseWhen(String string) {
        SQLParser parser = AntlrParser.makeBasicParser(string, getCurrentLocation());
        WhenListener whenListener = new WhenListener();
        ParseTreeWalker.DEFAULT.walk(whenListener, parser.sql());
        return whenListener.getWhen();
    }

    private PgRule getRule(ResultSet res, String schemaName)
            throws SQLException, UnsupportedEncodingException {
        String ruleName = res.getString("rulename");
        String tableName = res.getString(CLASS_RELNAME);
        currentObject = new GenericColumn(schemaName, tableName, ruleName);

        String command = res.getString("rule_string");
        PgRule r = new PgRule(ruleName, command);
        r.setTargetName(tableName);

        switch (res.getString("ev_type")) {
        case "1":
            r.setEvent(PgRuleEventType.SELECT);
            break;
        case "2":
            r.setEvent(PgRuleEventType.UPDATE);
            break;
        case "3":
            r.setEvent(PgRuleEventType.INSERT);
            break;
        case "4":
            r.setEvent(PgRuleEventType.DELETE);
            break;
        }

        if (res.getBoolean("is_instead")) {
            r.setInstead(true);
        }

        SQLParser parser = AntlrParser.makeBasicParser(command, getCurrentLocation());
        Create_rewrite_statementContext ruleCtx = parser.sql().statement(0).schema_statement()
                .schema_create().create_rewrite_statement();
        r.setCondition(CreateRewrite.getCondition(ruleCtx));
        CreateRewrite.setCommands(ruleCtx, r, args);
        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            r.setComment(args, PgDiffUtils.quoteString(comment));
        }
        return r;
    }

    private PgIndex getIndex(ResultSet res, String schemaName, String tableName) throws SQLException {
        String indexName = res.getString(CLASS_RELNAME);
        currentObject = new GenericColumn(schemaName, tableName, indexName);
        PgIndex i = new PgIndex(indexName, "");
        i.setTableName(tableName);

        String definition = res.getString("definition");
        i.setDefinition(definition.substring(definition.indexOf("USING ")));
        i.setClusterIndex(res.getBoolean("isClustered"));

        i.setUnique(res.getBoolean("indisunique"));
        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            i.setComment(args, PgDiffUtils.quoteString(comment));
        }

        return i;
    }

    private void setOwner(PgStatement statement, Long ownerOid) {
        setOwner(statement, getRoleNameByOid(ownerOid));
    }

    private void setOwner(PgStatement statement, String ownerName) {
        if (!args.isIgnorePrivileges()) {
            statement.setOwner(ownerName);
        }
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
    private PgFunction getFunction(ResultSet res, String schemaName) throws SQLException {
        String functionName = res.getString("proname");
        currentObject = new GenericColumn(schemaName, functionName, null);
        PgFunction f = new PgFunction(functionName, "");

        f.setBody(args, getFunctionBody(res));

        // RETURN TYPE
        Array proargmodes = res.getArray("proargmodes");
        boolean returnsTable = false;
        StringBuilder returnedTableArguments = new StringBuilder();
        if (proargmodes != null && Arrays.asList((String[]) proargmodes.getArray()).contains("t")) {
            String[] argModes = (String[]) proargmodes.getArray();
            String[] argNames = (String[]) res.getArray("proargnames").getArray();
            Long[] argTypeOids = (Long[]) res.getArray("proallargtypes").getArray();
            for (int i = 0; i < argModes.length; i++) {
                String type = argModes[i];
                if (type.equals("t")) {
                    returnsTable = true;
                    if (returnedTableArguments.length() > 0) {
                        returnedTableArguments.append(", ");
                    }
                    returnedTableArguments.append(argNames[i]).append(" ");

                    JdbcType returnType = cachedTypeNamesByOid.get(argTypeOids[i]);
                    returnedTableArguments.append(returnType.getFullName(schemaName));
                }
            }
        }

        JdbcType returnType = cachedTypeNamesByOid.get(res.getLong("prorettype"));
        if (returnsTable) {
            f.setReturns("TABLE(" + returnedTableArguments + ")");
        } else {
            f.setReturns((res.getBoolean("proretset") ? "SETOF " : "") +
                    returnType.getFullName(schemaName));
            if (!ApgdiffConsts.SYS_TYPES.contains(returnType.getSchemaQualifiedName(schemaName))) {
                f.setReturnsName(new GenericColumn(returnType.getParentSchema(),
                        returnType.getTypeName(), null, DbObjType.TYPE));
            }
        }

        // ARGUMENTS
        String arguments = res.getString("proarguments");
        if (!arguments.isEmpty()) {
            parseArguments("(" + arguments + ")", f, schemaName);
        }

        // OWNER
        setOwner(f, res.getLong("proowner"));

        // PRIVILEGES
        String signatureWithoutDefaults = functionName + "(" +
                res.getString("proarguments_without_default") + ")";
        setPrivileges(f, signatureWithoutDefaults, res.getString("aclArray"), f.getOwner(), null);

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            f.setComment(args, PgDiffUtils.quoteString(comment));
        }
        return f;
    }

    private void parseArguments(String args, PgFunction f, String schemaName) {
        SQLParser parser = AntlrParser.makeBasicParser(args, getCurrentLocation());
        ParserAbstract.fillArguments(parser.function_args_parser().function_args(),
                f, schemaName);
    }

    private String getFunctionBody(ResultSet res) throws SQLException {
        StringBuilder body = new StringBuilder();

        String lanName = res.getString("lang_name");
        body.append("LANGUAGE ").append(PgDiffUtils.getQuotedName(lanName));

        if (res.getBoolean("proiswindow")) {
            body.append(" WINDOW");
        }

        // VOLATILE is default
        switch (res.getString("provolatile")) {
        case "i":
            body.append(" IMMUTABLE");
            break;
        case "s":
            body.append(" STABLE");
            break;
        }

        // CALLED ON NULL INPUT is default
        if (res.getBoolean("proisstrict")) {
            body.append(" STRICT");
        }

        // SECURITY INVOKER is default
        if (res.getBoolean("prosecdef")) {
            body.append(" SECURITY DEFINER");
        }

        if (res.getBoolean("proleakproof")) {
            body.append(" LEAKPROOF");
        }

        float cost = res.getFloat("procost");
        if (lanName.equals("internal") || lanName.equals("c")) {
            /* default cost is 1 */
            if (cost != 1) {
                body.append(" COST ").append((int) cost);
            }
        } else {
            /* default cost is 100 */
            if (cost != DEFAULT_PROCOST) {
                body.append(" COST ").append((int) cost);
            }
        }

        float rows = res.getFloat("prorows");
        if (rows != 0.0f && rows != DEFAULT_PROROWS) {
            body.append(" ROWS ").append((int) rows);
        }

        Array configParams = res.getArray("proconfig");
        if (configParams != null) {
            for (String param : (String[]) configParams.getArray()) {
                String[] params = param.split("=");
                String par = params[0];
                String val = params[1];
                if (!par.equals("DateStyle") && !par.equals("search_path")) {
                    par = PgDiffUtils.getQuotedName(par);
                    val = PgDiffUtils.quoteString(val);
                }
                body.append("\n    SET ").append(par).append(" TO ")
                        .append(val);
            }
        }

        String definition = res.getString("prosrc");
        String quote = getStringLiteralDollarQuote(definition);
        String probin = res.getString("probin");
        if (probin != null && !probin.isEmpty()) {
            body.append("\n    AS ").append(PgDiffUtils.quoteString(probin));
            if (!definition.equals("-")) {
                body.append(", ");
                if (!definition.contains("\'") && !definition.contains("\\")) {
                    body.append(PgDiffUtils.quoteString(definition));
                } else {
                    body.append(quote).append(definition).append(quote);
                }
            }
        } else {
            if (!definition.equals("-")) {
                body.append("\n    AS ").append(quote).append(definition).append(quote);
            }
        }
        return body.toString();
    }

    /**
     * Function equivalent to appendStringLiteralDQ in dumputils.c
     */
    public static String getStringLiteralDollarQuote(String definition) {
        final String suffixes = "_XXXXXXX";
        String quote = "$";
        int counter = 0;
        while (definition.contains(quote)) {
            quote = quote.concat(String.valueOf(suffixes.charAt(counter++)));
            counter %= suffixes.length();
        }

        return quote.concat("$");
    }

    private PgSequence getSequence(ResultSet res, String schemaName, boolean isPerformance) throws SQLException {
        String sequenceName = res.getString(CLASS_RELNAME);
        currentObject = new GenericColumn(schemaName, sequenceName, null);
        PgSequence s = new PgSequence(sequenceName, "");
        s.setCycle(res.getBoolean("cycle_option"));
        String increment = res.getString("increment");
        s.setIncrement(increment);

        // The data type of the sequence: In PostgreSQL, this is currently always bigint
        long inc = Long.parseLong(increment);

        s.setMaxValue(ParserAbstract.getMaxValue(inc, res.getString("maximum_value")));
        s.setMinValue(ParserAbstract.getMinValue(inc, res.getString("minimum_value")));
        s.setStartWith(res.getString("start_value"));
        s.setCache(isPerformance ? res.getString("cache_value") : String.valueOf(1));

        Integer referencedColumn = res.getInt("referenced_column");
        if (referencedColumn != 0) {
            s.setOwnedBy(res.getString("referenced_table_name") + "." + res.getString("ref_col_name"));
        }

        setOwner(s, res.getLong(CLASS_RELOWNER));

        // PRIVILEGES
        setPrivileges(s, sequenceName, res.getString("aclArray"), s.getOwner(), null);
        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            s.setComment(args, PgDiffUtils.quoteString(comment));
        }
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
            String aclItemsArrayAsString, String owner, String columnName) {
        if (aclItemsArrayAsString == null
                || args.isIgnorePrivileges()) {
            return;
        }
        String stType;
        String order = "arwdDxtXUCTc";
        if (st instanceof PgSequence) {
            stType = "SEQUENCE";
            order = "rUw";
        } else if (st instanceof PgFunction) {
            stType = "FUNCTION";
            order = "X";
        } else if (st instanceof PgTable || st instanceof PgView || st instanceof PgColumn) {
            stType = "TABLE";
            if (columnName != null) {
                order = "raxw";
            } else {
                order = "raxdtDw";
            }
        } else if (st instanceof PgSchema) {
            stType = "SCHEMA";
            order = "CU";
        } else {
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
        for (Privilege p : grants) {
            if (p.isDefault) {
                metDefaultOwnersGrants = true;
            }
        }

        if (!metDefaultOwnersGrants) {
            st.addPrivilege(new PgPrivilege(true, revokeOwner, "REVOKE " + revokeOwner));
        }

        for (Privilege grant : grants) {
            // skip if default owner's privileges
            if (grant.isDefault) {
                continue;
            }
            List<String> grantValues = grant.grantValues;
            if (column != null && !column.isEmpty()) {
                grantValues = new ArrayList<>(grant.grantValues.size());
                for (String plainGrant : grant.grantValues) {
                    grantValues.add(plainGrant + column);
                }
            }
            String privDefinition = getStringListAsString(grantValues, ",") + " ON " + stType + " " +
                    stSignature + " TO " + grant.grantee;
            if (grant.isGO) {
                privDefinition = privDefinition.concat(" WITH GRANT OPTION");
            }
            st.addPrivilege(new PgPrivilege(false, privDefinition, "GRANT " + privDefinition));
        }
    }

    @SuppressWarnings("unused")
    @Deprecated
    private String getSearchPath(String schema) {
        return MessageFormat.format(ApgdiffConsts.SEARCH_PATH_PATTERN, schema);
    }

    private void prepareDataForSchema(Long schemaOid) throws SQLException {
        // fill in map with columns of tables and indices of schema
        setCurrentOperation("schema columns cache query");
        prepStatColumnsOfSchema.setLong(1, schemaOid);
        try (ResultSet res = prepStatColumnsOfSchema.executeQuery();) {
            //            cachedColumnNamesByTableOid.clear();
            Long previousTableOid = 0L;
            Map<Integer, String> previousMap = null;
            while (res.next()) {
                Integer columnNumber = res.getInt("attnum");

                Long tableOid = res.getLong("attrelid");
                String columnName = res.getString("attname");
                if (!previousTableOid.equals(tableOid)) {
                    previousTableOid = tableOid;
                    previousMap = new HashMap<>();
                    previousMap.put(columnNumber, columnName);
                    cachedColumnNamesByTableOid.put(tableOid, previousMap);
                } else {
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
    private List<String> getColumnNames(Number[] cols, Long tableOid) throws SQLException {
        Map<Integer, String> tableColumns = cachedColumnNamesByTableOid.get(tableOid);
        // if requested table is in different schema
        if (tableColumns == null) {
            try (Statement st = connection.createStatement();
                    ResultSet res = st.executeQuery("SELECT attname, attnum FROM "
                            + "pg_catalog.pg_attribute WHERE attrelid = " + tableOid);) {
                tableColumns = new HashMap<>();
                while (res.next()) {
                    tableColumns.put(res.getInt("attnum"), res.getString("attname"));
                }
                cachedColumnNamesByTableOid.put(tableOid, tableColumns);
            }
        }

        List<String> result = new ArrayList<>();
        for (Number n : cols) {
            result.add(tableColumns.get(n));
        }
        return result;
    }

    /**
     * Returns the role name by its oid. If role oid is 0, returns "PUBLIC".
     * If no role with such oid exists, returns null.
     */
    private String getRoleNameByOid(Long roleOid) {
        return roleOid == 0 ? "PUBLIC" : cachedRolesNamesByOid.get(roleOid);
    }

    private String getCurrentLocation() {
        StringBuilder sb = new StringBuilder("jdbc:");
        if (currentObject == null) {
            return sb.append(currentOperation).toString();
        } else {
            if (currentObject.schema != null) {
                sb.append('/').append(currentObject.schema);
            }
            if (currentObject.table != null) {
                sb.append('/').append(currentObject.table);
            }
            if (currentObject.column != null) {
                sb.append('/').append(currentObject.column);
            }
        }
        return sb.toString();
    }

    private void setCurrentOperation(String operation) {
        currentObject = null;
        currentOperation = operation;
    }

    private int checkExistingPerformanceFunctions(Connection conn) throws SQLException {
        int TOTAL_MASK = 0;
        ResultSet rs = conn.createStatement().executeQuery(
                "SELECT oid FROM pg_namespace WHERE nspname = 'pgcodekeeperhelper'");
        if (!rs.next()) {
            return 0;
        }
        Long schemaOid = rs.getLong("oid");
        if (schemaOid == 0) {
            return 0;
        }
        try (ResultSet resFuncs = conn.createStatement().executeQuery("SELECT proname FROM pg_proc WHERE pronamespace="
                + schemaOid)) {
            while (resFuncs.next()) {
                String funcName = resFuncs.getString("proname");
                try {
                    TOTAL_MASK |= DbObjType.valueOf(funcName.substring(funcName.lastIndexOf('_') + 1).toUpperCase())
                            .getMask();
                } catch (NullPointerException | IllegalArgumentException ex) {
                    continue;
                }
            }
        }
        return TOTAL_MASK;
    }

    private boolean isPerformance(DbObjType objType, int totalMask) {
        return (totalMask & objType.getMask()) == objType.getMask() ? true : false;
    }

    private void addAllTables(boolean isPerformance, PgDatabase db) throws SQLException, InterruptedException {
        setCurrentOperation("tables query");
        if (isPerformance) {
            try (ResultSet tables = prepStatTables.executeQuery()) {
                while (tables.next()) {
                    PgDumpLoader.checkCancelled(monitor);
                    PgSchema schema = db.getSchema(tables.getString(NAMESPACE_NSPNAME));
                    PgTable table = getTable(tables, schema.getName());
                    if (table != null) {
                        schema.addTable(table);
                    }
                }
            }
        } else {
            for (Long oid : schemaIds.keySet()) {
                connection.setSchema(schemaIds.get(oid));
                prepStatTables.setLong(1, oid);
                try (ResultSet resTables = prepStatTables.executeQuery()) {
                    while (resTables.next()) {
                        PgDumpLoader.checkCancelled(monitor);
                        PgTable table = getTable(resTables, schemaIds.get(oid));
                        monitor.worked(1);
                        if (table != null) {
                            db.getSchema(schemaIds.get(oid)).addTable(table);
                        }
                    }
                }
            }
        }
    }

    private void addAllViews(boolean isPerformance, PgDatabase db) throws SQLException, InterruptedException {
        setCurrentOperation("views query");
        if (isPerformance) {
            try (ResultSet views = prepStatViews.executeQuery()) {
                while (views.next()) {
                    PgDumpLoader.checkCancelled(monitor);
                    PgSchema schema = db.getSchema(views.getString(NAMESPACE_NSPNAME));
                    PgView view = getView(views, schema.getName());
                    if (view != null) {
                        schema.addView(view);
                    }
                }
            }
        } else {
            for (Long oid : schemaIds.keySet()) {
                //                prepStatViews.setString(1, schemaIds.get(oid));
                connection.setSchema(schemaIds.get(oid));
                prepStatViews.setLong(1, oid);
                try (ResultSet resViews = prepStatViews.executeQuery()) {
                    while (resViews.next()) {
                        PgDumpLoader.checkCancelled(monitor);
                        PgView view = getView(resViews, schemaIds.get(oid));
                        monitor.worked(1);
                        if (view != null) {
                            db.getSchema(schemaIds.get(oid)).addView(view);
                        }
                    }
                }
            }
        }
    }

    private void addAllFunctions(boolean isPerformance, PgDatabase db) throws SQLException, InterruptedException {
        setCurrentOperation("finctions query");
        if (isPerformance) {
            try (ResultSet functions = prepStatFunctions.executeQuery()) {
                while (functions.next()) {
                    PgDumpLoader.checkCancelled(monitor);
                    PgSchema schema = db.getSchema(functions.getString(NAMESPACE_NSPNAME));
                    PgFunction function = getFunction(functions, schema.getName());
                    if (function != null) {
                        schema.addFunction(function);
                    }
                }
            }
        } else {
            for (Long oid : schemaIds.keySet()) {
                connection.setSchema(schemaIds.get(oid));
                prepStatFunctions.setLong(1, oid);
                try (ResultSet resFunctions = prepStatFunctions.executeQuery()) {
                    while (resFunctions.next()) {
                        PgDumpLoader.checkCancelled(monitor);
                        PgFunction function = getFunction(resFunctions, schemaIds.get(oid));
                        monitor.worked(1);
                        if (function != null) {
                            db.getSchema(schemaIds.get(oid)).addFunction(function);
                        }
                    }
                }
            }
        }
    }

    private void addAllIndeces(boolean isPerformance, PgDatabase db) throws SQLException, InterruptedException {
        setCurrentOperation("indexes query");
        if (isPerformance) {
            try (ResultSet indices = prepStatIndices.executeQuery()) {
                while (indices.next()) {
                    PgDumpLoader.checkCancelled(monitor);
                    PgSchema schema = db.getSchema(indices.getString(NAMESPACE_NSPNAME));
                    PgTable table = schema.getTable(indices.getString("table_name"));
                    PgIndex index = getIndex(indices, schema.getName(), table.getName());
                    if (index != null) {
                        table.addIndex(index);
                    }
                }
            }
        } else {
            for (Long oid : schemaIds.keySet()) {
                connection.setSchema(schemaIds.get(oid));
                prepStatIndices.setLong(1, oid);
                try (ResultSet indices = prepStatIndices.executeQuery()) {
                    while (indices.next()) {
                        PgDumpLoader.checkCancelled(monitor);
                        PgSchema schema = db.getSchema(schemaIds.get(oid));
                        PgTable table = schema.getTable(indices.getString("table_name"));
                        if (table != null) {
                            PgIndex index = getIndex(indices, schema.getName(), table.getName());
                            monitor.worked(1);
                            if (index != null) {
                                table.addIndex(index);
                            }
                        }
                    }
                }
            }
        }
    }

    private void addAllConstraints(boolean isPerformance, PgDatabase db) throws SQLException, InterruptedException {
        setCurrentOperation("constraints query");
        if (isPerformance) {
            try (ResultSet constraints = prepStatConstraints.executeQuery()) {
                while (constraints.next()) {
                    PgDumpLoader.checkCancelled(monitor);
                    PgSchema schema = db.getSchema(constraints.getString(NAMESPACE_NSPNAME));
                    PgTable table = schema.getTable(constraints.getString(CLASS_RELNAME));
                    if (table != null) {
                        PgConstraint constraint = getConstraint(constraints, schema.getName(), table.getName());
                        if (constraint != null) {
                            table.addConstraint(constraint);
                        }
                    }
                }
            }
        } else {
            for (Long oid : schemaIds.keySet()) {
                connection.setSchema(schemaIds.get(oid));
                prepStatConstraints.setLong(1, oid);
                try (ResultSet constraints = prepStatConstraints.executeQuery()) {
                    while (constraints.next()) {
                        PgDumpLoader.checkCancelled(monitor);
                        PgSchema schema = db.getSchema(schemaIds.get(oid));
                        PgTable table = schema.getTable(constraints.getString(CLASS_RELNAME));
                        if (table != null) {
                            PgConstraint constraint = getConstraint(constraints, schema.getName(), table.getName());
                            monitor.worked(1);
                            if (constraint != null) {
                                table.addConstraint(constraint);
                            }
                        }
                    }
                }
            }
        }
    }

    private void addAllSequences(boolean isPerformance, PgDatabase db) throws SQLException, InterruptedException {
        setCurrentOperation("sequences query");
        if (isPerformance) {
            try (ResultSet sequences = prepStatSequences.executeQuery()) {
                while (sequences.next()) {
                    PgDumpLoader.checkCancelled(monitor);
                    PgSchema schema = db.getSchema(sequences.getString(NAMESPACE_NSPNAME));
                    PgSequence sequence = getSequence(sequences, schema.getName(), isPerformance);
                    if (sequence != null) {
                        schema.addSequence(sequence);
                    }
                }
            }
        } else {
            for (Long oid : schemaIds.keySet()) {
                PgSchema schema = db.getSchema(schemaIds.get(oid));
                connection.setSchema(schemaIds.get(oid));
                prepStatSequences.setLong(1, oid);
                try (ResultSet sequences = prepStatSequences.executeQuery()) {
                    while (sequences.next()) {
                        PgDumpLoader.checkCancelled(monitor);
                        if (schema != null) {
                            PgSequence sequence = getSequence(sequences, schema.getName(), isPerformance);
                            monitor.worked(1);
                            if (sequence != null) {
                                schema.addSequence(sequence);
                            }
                        }
                    }
                }
                setSequencesCacheValue(schema);
            }
        }
    }

    private void addAllTriggers(boolean isPerformance, PgDatabase db) throws SQLException, InterruptedException,
            UnsupportedEncodingException {
        setCurrentOperation("triggers query");
        PgTable table;
        PgView view;
        if (isPerformance) {
            try (ResultSet triggers = prepStatTriggers.executeQuery()) {
                while (triggers.next()) {
                    PgDumpLoader.checkCancelled(monitor);
                    PgSchema schema = db.getSchema(triggers.getString(NAMESPACE_NSPNAME_TV));
                    PgTrigger trigger = getTrigger(triggers, schema.getName());
                    if (trigger != null && (table = schema.getTable(triggers.getString(
                            CLASS_RELNAME))) != null) {
                        table.addTrigger(trigger);
                    } else if (trigger != null && (view = schema.getView(triggers.getString(
                            CLASS_RELNAME))) != null) {
                        //TODO uncomment after merge with akifiev_an 
                        //view.addTrigger(trigger);
                    } else {
                        Log.log(Log.LOG_WARNING, "");
                    }
                }
            }
        } else {
            for (Long oid : schemaIds.keySet()) {
                connection.setSchema(schemaIds.get(oid));
                prepStatTriggers.setLong(1, oid);
                PgSchema schema = db.getSchema(schemaIds.get(oid));
                try (ResultSet triggers = prepStatTriggers.executeQuery()) {
                    while (triggers.next()) {
                        PgDumpLoader.checkCancelled(monitor);
                        PgTrigger trigger = getTrigger(triggers, schema.getName());
                        if (trigger != null && (table = schema.getTable(triggers.getString(CLASS_RELNAME))) != null) {
                            table.addTrigger(trigger);
                        } else if (trigger != null && (view = schema.getView(triggers.getString(
                                CLASS_RELNAME))) != null) {
                            //TODO uncomment after merge with akifiev_an 
                            //view.addTrigger(trigger);
                        } else {
                            Log.log(Log.LOG_WARNING, "");
                        }
                    }
                }
            }
        }
    }

    private void addAllRules(boolean isPerformance, PgDatabase db) throws SQLException, InterruptedException,
            UnsupportedEncodingException {
        setCurrentOperation("rules query");
        PgTable table;
        PgView view;
        if (isPerformance) {
            try (ResultSet triggers = prepStatRules.executeQuery()) {
                while (triggers.next()) {
                    PgDumpLoader.checkCancelled(monitor);
                    PgSchema schema = db.getSchema(triggers.getString(NAMESPACE_NSPNAME));
                    PgRule rule = getRule(triggers, schema.getName());
                    if (rule != null && (table = schema.getTable(triggers.getString(CLASS_RELNAME))) != null) {
                        table.addRule(rule);
                    } else if (rule != null && (view = schema.getView(triggers.getString(CLASS_RELNAME))) != null) {
                        view.addRule(rule);
                    } else {
                        Log.log(Log.LOG_WARNING, "");
                    }
                }
            }
        } else {
            for (Long oid : schemaIds.keySet()) {
                connection.setSchema(schemaIds.get(oid));
                prepStatRules.setLong(1, oid);
                PgSchema schema = db.getSchema(schemaIds.get(oid));
                try (ResultSet triggers = prepStatRules.executeQuery()) {
                    while (triggers.next()) {
                        PgDumpLoader.checkCancelled(monitor);
                        PgRule rule = getRule(triggers, schema.getName());
                        if (rule != null && (table = schema.getTable(triggers.getString(CLASS_RELNAME))) != null) {
                            table.addRule(rule);
                        } else if (rule != null && (view = schema.getView(triggers.getString(
                                CLASS_RELNAME))) != null) {
                            view.addRule(rule);
                        } else {
                            Log.log(Log.LOG_WARNING, "");
                        }
                    }
                }
            }
        }
    }
}
