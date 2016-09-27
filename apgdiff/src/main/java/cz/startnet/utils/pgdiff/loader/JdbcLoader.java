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
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRewrite;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTrigger.WhenListener;
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
import cz.startnet.utils.pgdiff.schema.PgRuleContainer;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgTriggerContainer;
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

            prepareStatements();
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
                    long oid = res.getLong(OID);
                    JdbcType type = new JdbcType(oid, res.getString("typname"),
                            res.getLong("typelem"), res.getLong("typarray"),
                            res.getString(NAMESPACE_NSPNAME), res.getString("elemname"));
                    cachedTypeNamesByOid.put(oid, type);
                }
            }
        }
    }

    private void prepareStatements() throws SQLException {
        setCurrentOperation("prepared statements");
        prepStatTables = connection.prepareStatement(JdbcQueries.QUERY_TABLES_PER_SCHEMA);
        prepStatViews = connection.prepareStatement(JdbcQueries.QUERY_VIEWS_PER_SCHEMA);
        prepStatTriggers = connection.prepareStatement(JdbcQueries.QUERY_TRIGGERS_PER_SCHEMA);
        prepStatFunctions = connection.prepareStatement(JdbcQueries.QUERY_FUNCTIONS_PER_SCHEMA);
        prepStatSequences = connection.prepareStatement(JdbcQueries.QUERY_SEQUENCES_PER_SCHEMA);
        prepStatConstraints = connection.prepareStatement(JdbcQueries.QUERY_CONSTRAINTS_PER_SCHEMA);
        prepStatIndices = connection.prepareStatement(JdbcQueries.QUERY_INDICES_PER_SCHEMA);
        prepStatColumnsOfSchema = connection.prepareStatement(JdbcQueries.QUERY_COLUMNS_PER_SCHEMA);
        prepStatTypes = connection.prepareStatement(JdbcQueries.QUERY_TYPES_PER_SCHEMA);
        prepStatRules = connection.prepareStatement(JdbcQueries.QUERY_RULES_PER_SCHEMA);
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
        currentObject = new GenericColumn(schemaName, DbObjType.SCHEMA);
        long schemaOid = res.getLong(OID);
        PgSchema s = new PgSchema(schemaName, "");

        if (!schemaName.equals(ApgdiffConsts.PUBLIC)) {
            setOwner(s, res.getString("owner"));
        }
        setPrivileges(s, PgDiffUtils.getQuotedName(schemaName), res.getString("nspacl"), res.getString("owner"), null);

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
                if (typeOrDomain != null) {
                    if (typeOrDomain.getStatementType() == DbObjType.DOMAIN) {
                        s.addDomain((PgDomain) typeOrDomain);
                    } else {
                        s.addType((PgType) typeOrDomain);
                    }
                }
            }
        }

        // TABLES
        setCurrentOperation("tables query");
        prepStatTables.setLong(1, schemaOid);
        try (ResultSet resTables = prepStatTables.executeQuery()) {
            while (resTables.next()) {
                PgDumpLoader.checkCancelled(monitor);
                PgTable table = getTable(resTables, schemaName);
                monitor.worked(1);
                if (table != null) {
                    s.addTable(table);
                }
            }
        }

        // CONSTRAINTS
        setCurrentOperation("constraints query");
        prepStatConstraints.setLong(1, schemaOid);
        try (ResultSet resConstraints = prepStatConstraints.executeQuery()) {
            while (resConstraints.next()) {
                PgDumpLoader.checkCancelled(monitor);
                PgTable table = s.getTable(resConstraints.getString(CLASS_RELNAME));
                if (table != null) {
                    PgConstraint constraint = getConstraint(resConstraints, schemaName, table.getName());
                    if (constraint != null) {
                        table.addConstraint(constraint);
                    }
                }
            }
        }

        // VIEWS
        setCurrentOperation("views query");
        prepStatViews.setLong(1, schemaOid);
        try (ResultSet resViews = prepStatViews.executeQuery()) {
            while (resViews.next()) {
                PgDumpLoader.checkCancelled(monitor);
                PgView view = getView(resViews, schemaName);
                monitor.worked(1);
                if (view != null) {
                    s.addView(view);
                }
            }
        }

        // INDECIES
        prepStatIndices.setLong(1, schemaOid);
        try (ResultSet resIndecies = prepStatIndices.executeQuery()) {
            while (resIndecies.next()) {
                PgDumpLoader.checkCancelled(monitor);
                PgTable table = s.getTable(resIndecies.getString("table_name"));
                if (table != null) {
                    PgIndex index = getIndex(resIndecies, schemaName, table.getName());
                    monitor.worked(1);
                    if (index != null) {
                        table.addIndex(index);
                    }
                }
            }
        }

        // TRIGGERS
        setCurrentOperation("triggers query");
        prepStatTriggers.setLong(1, schemaOid);
        try (ResultSet resTriggers = prepStatTriggers.executeQuery()) {
            while (resTriggers.next()) {
                PgDumpLoader.checkCancelled(monitor);
                PgTriggerContainer c = s.getTriggerContainer(resTriggers.getString(CLASS_RELNAME));
                if (c != null) {
                    PgTrigger trigger = getTrigger(resTriggers, schemaName);
                    if (trigger != null) {
                        c.addTrigger(trigger);
                    }
                }
            }
        }

        // FUNCTIONS
        setCurrentOperation("functions query");
        prepStatFunctions.setLong(1, schemaOid);
        try (ResultSet resFuncs = prepStatFunctions.executeQuery()) {
            while (resFuncs.next()) {
                PgDumpLoader.checkCancelled(monitor);
                PgFunction function = getFunction(resFuncs, schemaName);
                if (function != null) {
                    s.addFunction(function);
                }
            }
        }

        // SEQUENCES
        setCurrentOperation("sequences query");
        prepStatSequences.setLong(1, schemaOid);
        try (ResultSet resSeq = prepStatSequences.executeQuery()) {
            while (resSeq.next()) {
                PgDumpLoader.checkCancelled(monitor);
                PgSequence sequence = getSequence(resSeq, schemaName);
                monitor.worked(1);
                if (sequence != null) {
                    s.addSequence(sequence);
                }
            }
        }

        // RULES
        setCurrentOperation("rules query");
        prepStatRules.setLong(1, schemaOid);
        try (ResultSet resRule = prepStatRules.executeQuery()) {
            while (resRule.next()) {
                PgDumpLoader.checkCancelled(monitor);
                PgRuleContainer c = s.getRuleContainer(resRule.getString(CLASS_RELNAME));
                if (c != null) {
                    PgRule rule = getRule(resRule, schemaName);
                    if (rule != null) {
                        c.addRule(rule);
                    }
                }
            }
        }

        setSequencesCacheValue(s);
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
            setPrivileges(st, PgDiffUtils.getQuotedName(st.getName()), res.getString("typacl"), st.getOwner(), null);
            String comment = res.getString("description");
            if (comment != null && !comment.isEmpty()) {
                st.setComment(args, PgDiffUtils.quoteString(comment));
            }
        }
        return st;
    }

    private PgDomain getDomain(ResultSet res, String schemaName) throws SQLException {
        PgDomain d = new PgDomain(res.getString("typname"), "");
        currentObject = new GenericColumn(schemaName, d.getName(), DbObjType.DOMAIN);

        d.setDataType(res.getString("dom_basetypefmt"));
        cachedTypeNamesByOid.get(res.getLong("dom_basetype")).addTypeDepcy(d);

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
        currentObject = new GenericColumn(schemaName, name, DbObjType.TYPE);
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

            short len = res.getShort("typlen");
            t.setInternalLength(len == -1 ? "variable" : "" + len);
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

            long elem = res.getLong("typelem");
            if (elem != 0) {
                JdbcType typeElem = cachedTypeNamesByOid.get(elem);
                t.setElement(typeElem.getFullName(schemaName));
                // autogenerated array types are hidden
                // so we should only get explicitly defined typelems as dependencies
                typeElem.addTypeDepcy(t);
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
            Long[] atttypeids = (Long[]) res.getArray("comp_atttypids").getArray();
            Long[] attcollations = (Long[]) res.getArray("comp_attcollations").getArray();
            Long[] atttypcollations = (Long[]) res.getArray("comp_atttypcollations").getArray();
            String[] attcollationnames = (String[]) res.getArray("comp_attcollationnames").getArray();
            String[] attcollationnspnames = (String[]) res.getArray("comp_attcollationnspnames").getArray();
            String[] attcomments = (String[]) res.getArray("comp_attcomments").getArray();

            for (int i = 0; i < attnames.length; ++i) {
                PgColumn a = new PgColumn(attnames[i]);
                a.setType(atttypes[i]);
                cachedTypeNamesByOid.get(atttypeids[i]).addTypeDepcy(t);

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

            JdbcType subtype = cachedTypeNamesByOid.get(res.getLong("rngsubtype"));
            t.setSubtype(subtype.getFullName(schemaName));
            subtype.addTypeDepcy(t);

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
            unionSeqCache.append(prefix).append(PgDiffUtils.getQuotedName(seq.getName())).append(postfix);
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
        currentObject = new GenericColumn(extName, DbObjType.EXTENSION);
        PgExtension e = new PgExtension(extName, "");
        e.setSchema(res.getString("namespace"));
        e.addDep(new GenericColumn(e.getSchema(), DbObjType.SCHEMA));

        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            e.setComment(args, PgDiffUtils.quoteString(comment));
        }
        return e;
    }

    private PgConstraint getConstraint(ResultSet res, String schemaName, String tableName)
            throws SQLException {
        String constraintName = res.getString("conname");
        currentObject = new GenericColumn(schemaName, tableName, constraintName, DbObjType.CONSTRAINT);
        String definition = res.getString("definition");
        PgConstraint c = new PgConstraint(constraintName, "");

        String contype = res.getString("contype");
        switch (contype) {
        case "f":
            String fschema = res.getString("foreign_schema_name");
            String ftable = res.getString("foreign_table_name");
            GenericColumn ftableRef = new GenericColumn(fschema, ftable, DbObjType.TABLE);
            c.setForeignTable(ftableRef);
            c.addDep(ftableRef);

            List<String> referencedColumnNames = getColumnNames(
                    (Integer[]) res.getArray("confkey").getArray(), res.getLong("confrelid"));
            for (String colName : referencedColumnNames) {
                if (colName != null) {
                    c.addForeignColumn(colName);
                    c.addDep(new GenericColumn(fschema, ftable, colName, DbObjType.COLUMN));
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
                c.addColumn(name);
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
        currentObject = new GenericColumn(schemaName, viewName, DbObjType.VIEW);

        String viewDef = res.getString("definition").trim();
        if (viewDef.charAt(viewDef.length() - 1) == ';') {
            viewDef = viewDef.substring(0, viewDef.length() - 1);
        }

        PgView v = new PgView(viewName, "");
        v.setQuery(viewDef);
        parseAntlrSelect(schemaName, viewDef, v);

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
                    setPrivileges(v, PgDiffUtils.getQuotedName(viewName), colAcl, v.getOwner(), PgDiffUtils.getQuotedName(colName));
                }
            }
        }

        // Query view privileges
        setPrivileges(v, PgDiffUtils.getQuotedName(viewName), res.getString("relacl"), v.getOwner(), null);

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            v.setComment(args, PgDiffUtils.quoteString(comment));
        }

        return v;
    }

    private void parseAntlrSelect(String schemaName, String statement, PgView v) {
        SQLParser parser = AntlrParser.makeBasicParser(statement + ';', getCurrentLocation());
        UtilExpr.analyze(parser.sql().statement(0).data_statement().select_stmt(), new Select(schemaName), v);
    }

    private PgTable getTable(ResultSet res, String schemaName) throws SQLException {
        String tableName = res.getString(CLASS_RELNAME);
        currentObject = new GenericColumn(schemaName, tableName, DbObjType.TABLE);
        String tableOwner = getRoleNameByOid(res.getLong(CLASS_RELOWNER));

        PgTable t = new PgTable(tableName, "");

        Integer[] colNumbers = (Integer[]) res.getArray("col_numbers").getArray();
        String[] colNames = (String[]) res.getArray("col_names").getArray();
        Long[] colTypeIds = (Long[]) res.getArray("col_type_ids").getArray();
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
            cachedTypeNamesByOid.get(colTypeIds[i]).addTypeDepcy(column);

            // unbox
            long collation = colCollation[i];
            if (collation != 0 && collation != colTypCollation[i]) {
                column.setCollation(PgDiffUtils.getQuotedName(colCollationSchema[i])
                        + '.' + PgDiffUtils.getQuotedName(colCollationName[i]));
            }

            String columnDefault = colDefaults[i];
            if (columnDefault != null && !columnDefault.isEmpty()) {
                column.setDefaultValue(columnDefault);
                GenericColumn func = parseFunctionCall(columnDefault, schemaName);
                if (func != null) {
                    column.addDep(func);
                }
            }

            if (colNotNull[i]) {
                column.setNullValue(false);
            }

            int statistics = colStatictics[i];
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
                    String seqSchema = matcher.group("schema");
                    if (seqSchema == null) {
                        seqSchema = schemaName;
                    }
                    t.addDep(new GenericColumn(seqSchema, matcher.group("seq"), DbObjType.SEQUENCE));
                }
            }
        }

        // INHERITS
        Array inhrelsarray = res.getArray("inhrelnames");
        if (inhrelsarray != null) {
            String[] inhrelnames = (String[]) inhrelsarray.getArray();
            String[] inhnspnames = (String[]) res.getArray("inhnspnames").getArray();

            for (int i = 0; i < inhrelnames.length; ++i) {
                t.addInherits(schemaName.equals(inhnspnames[i]) ? null : inhnspnames[i], inhrelnames[i]);
                t.addDep(new GenericColumn(inhnspnames[i], inhrelnames[i], DbObjType.TABLE));
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
        setPrivileges(t, PgDiffUtils.getQuotedName(t.getName()), res.getString("aclarray"), t.getOwner(), null);

        // COLUMNS PRIVILEGES
        String[] colAcl = (String[]) res.getArray("col_acl").getArray();
        for (int i = 0; i < colNumbers.length; i++) {
            String columnPrivileges = colAcl[i];
            if (columnPrivileges != null && !columnPrivileges.isEmpty()) {
                setPrivileges(t.getColumn(colNames[i]), PgDiffUtils.getQuotedName(tableName),
                        columnPrivileges, tableOwner, PgDiffUtils.getQuotedName(colNames[i]));
            }
        }
        return t;
    }

    // TODO отрефакторить в вычитку всех зависимостей из экспрешшена
    private GenericColumn parseFunctionCall(String def, String defSchema) {
        SQLParser parser = AntlrParser.makeBasicParser(def, getCurrentLocation());
        FunctionSearcher fs = new FunctionSearcher();
        ParseTreeWalker.DEFAULT.walk(fs, parser.vex());
        if (fs.getName() == null) {
            return null;
        }
        List<IdentifierContext> ids = fs.getName().identifier();
        return new GenericColumn(QNameParser.getSchemaName(ids, defSchema),
                QNameParser.getFirstName(ids), DbObjType.FUNCTION);
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
        String tableName = res.getString("tgrelid");
        currentObject = new GenericColumn(schemaName, tableName, triggerName, DbObjType.TRIGGER);
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
        String funcSchema = res.getString(NAMESPACE_NSPNAME);

        StringBuilder functionCall = new StringBuilder(funcName.length() + 2);
        if (!funcSchema.equals(schemaName)) {
            functionCall.append(PgDiffUtils.getQuotedName(funcSchema)).append('.');
        }
        functionCall.append(PgDiffUtils.getQuotedName(funcName)).append('(');

        byte[] args = res.getBytes("tgargs");
        if (args.length > 0) {
            functionCall.append('\'');
            int start = 0;
            for (int i = 0; i < args.length; ++i) {
                if (args[i] != 0) {
                    continue;
                }

                functionCall.append(new String(args, start, i - start, connector.getEncoding()));
                if (i != args.length - 1) {
                    functionCall.append("', '");
                }
                start = i + 1;
            }
            functionCall.append('\'');
        }
        functionCall.append(')');
        t.setFunction(functionCall.toString());

        t.addDep(new GenericColumn(funcSchema, funcName + "()", DbObjType.FUNCTION));

        for (String col_name : getColumnNames(
                (Number[]) res.getArray("col_numbers").getArray(),
                res.getLong("table_oid"))) {
            t.addUpdateColumn(col_name);
            t.addDep(new GenericColumn(schemaName, tableName, col_name, DbObjType.COLUMN));
        }
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
        currentObject = new GenericColumn(schemaName, tableName, ruleName, DbObjType.RULE);

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
        CreateRewrite.setCommands(ruleCtx, r, args, schemaName);
        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            r.setComment(args, PgDiffUtils.quoteString(comment));
        }
        return r;
    }

    private PgIndex getIndex(ResultSet res, String schemaName, String tableName) throws SQLException {
        String indexName = res.getString(CLASS_RELNAME);
        currentObject = new GenericColumn(schemaName, tableName, indexName, DbObjType.INDEX);
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

        i.addDep(new GenericColumn(schemaName, tableName, DbObjType.TABLE));
        Array colsArray = res.getArray("cols");
        if (colsArray != null) {
            String[] cols = (String[]) colsArray.getArray();
            for (String col : cols){
                i.addDep(new GenericColumn(schemaName, tableName, col, DbObjType.COLUMN));
            }
        }
        return i;
    }

    private void setOwner(PgStatement statement, long ownerOid) {
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
     */
    private PgFunction getFunction(ResultSet res, String schemaName) throws SQLException {
        String functionName = res.getString("proname");
        currentObject = new GenericColumn(schemaName, functionName, DbObjType.FUNCTION);
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
                    returnType.addTypeDepcy(f);
                }
            }
        }

        JdbcType returnType = cachedTypeNamesByOid.get(res.getLong("prorettype"));
        if (returnsTable) {
            f.setReturns("TABLE(" + returnedTableArguments + ")");
        } else {
            f.setReturns((res.getBoolean("proretset") ? "SETOF " : "") +
                    returnType.getFullName(schemaName));
            returnType.addTypeDepcy(f);
        }

        // ARGUMENTS
        // TODO manually assemble function sig instead of parsing?
        // NOTE though, performance is degraded when doing multiple parser calls (to parse defaults)
        // Benchmark               Mode  Cnt       Score      Error  Units
        // StupidTests.parseArgs  thrpt   20  115902.677 ± 1179.340  ops/s
        // StupidTests.parseVex   thrpt   20  165616.367 ± 2195.409  ops/s
        String arguments = res.getString("proarguments");
        if (!arguments.isEmpty()) {
            parseArguments("(" + arguments + ")", f, schemaName);
        }

        // OWNER
        setOwner(f, res.getLong("proowner"));

        // PRIVILEGES
        String signatureWithoutDefaults = PgDiffUtils.getQuotedName(functionName) + "(" +
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

    private PgSequence getSequence(ResultSet res, String schemaName) throws SQLException {
        String sequenceName = res.getString(CLASS_RELNAME);
        currentObject = new GenericColumn(schemaName, sequenceName, DbObjType.SEQUENCE);
        PgSequence s = new PgSequence(sequenceName, "");
        s.setCycle(res.getBoolean("cycle_option"));
        long increment = res.getLong("increment");
        s.setIncrement("" + increment);

        s.setMaxValue(ParserAbstract.getMaxValue(increment, res.getString("maximum_value")));
        s.setMinValue(ParserAbstract.getMinValue(increment, res.getString("minimum_value")));
        s.setStartWith(res.getString("start_value"));
        s.setCache(String.valueOf(1));

        int referencedColumn = res.getInt("referenced_column");
        if (referencedColumn != 0) {
            s.setOwnedBy(res.getString("referenced_table_name") + "." + res.getString("ref_col_name"));
        }

        setOwner(s, res.getLong(CLASS_RELOWNER));

        // PRIVILEGES
        setPrivileges(s, PgDiffUtils.getQuotedName(sequenceName), res.getString("aclArray"), s.getOwner(), null);
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
     * Currently supports privileges only on PgSequence, PgTable, PgView, PgColumn,
     * PgFunction, PgSchema, PgType, PgDomain
     *
     * @param st    PgStatement object where privileges to be added
     * @param stSignature   PgStatement signature (differs in different PgStatement instances)
     * @param aclItemsArrayAsString     Input acl string in the
     *                                  form of "{grantee=grant_chars/grantor[, ...]}"
     * @param owner the owner of PgStatement object (why separate?)
     * @param column    column name, if this aclItemsArrayAsString is column
     *                      privilege string; otherwise null
     */
    /*
     * See parseAclItem() in dumputils.c
     * For privilege characters see JdbcAclParser.PrivilegeTypes
     * Order of all characters (for all types of objects combined)
     * is given by order variable initialization
     */
    private void setPrivileges(PgStatement st, String stSignature,
            String aclItemsArrayAsString, String owner, String columnName) {
        if (aclItemsArrayAsString == null || args.isIgnorePrivileges()) {
            return;
        }
        String stType = null;
        String order = "raxdtDXCcTUw";
        switch (st.getStatementType()) {
        case SEQUENCE:
            order = "rUw";
            break;

        case TABLE:
        case VIEW:
        case COLUMN:
            stType = "TABLE";
            if (columnName == null) {
                order = "raxdtDw";
            } else {
                order = "raxw";
            }
            break;

        case FUNCTION:
            order = "X";
            break;

        case SCHEMA:
            order = "CU";
            break;

        case TYPE:
        case DOMAIN:
            stType = "TYPE";
            order = "U";
            break;

        default:
            throw new IllegalStateException(st.getStatementType() + " doesn't support privileges!");
        }
        int possiblePrivilegeCount = order.length();
        if (stType == null) {
            stType = st.getStatementType().name();
        }

        String column = (columnName != null && !columnName.isEmpty()) ? "(" + columnName + ")" : "";
        String revokePublic = "ALL" + column + " ON " + stType + " " + stSignature + " FROM PUBLIC";
        st.addPrivilege(new PgPrivilege(true, revokePublic, "REVOKE " + revokePublic));

        List<Privilege> grants = JdbcAclParser.parse(
                aclItemsArrayAsString, possiblePrivilegeCount, order, owner);

        boolean metDefaultOwnersGrants = false;
        for (Privilege p : grants) {
            if (p.isDefault) {
                metDefaultOwnersGrants = true;
            }
        }

        if (!metDefaultOwnersGrants) {
            String revokeOwner = "ALL" + column + " ON " + stType + " " + stSignature + " FROM " +
                    PgDiffUtils.getQuotedName(owner);
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

    private void prepareDataForSchema(long schemaOid) throws SQLException {
        // fill in map with columns of tables and indices of schema
        setCurrentOperation("schema columns cache query");
        prepStatColumnsOfSchema.setLong(1, schemaOid);
        try (ResultSet res = prepStatColumnsOfSchema.executeQuery();) {
            cachedColumnNamesByTableOid.clear();
            long previousTableOid = 0L;
            Map<Integer, String> previousMap = null;
            while (res.next()) {
                Integer columnNumber = res.getInt("attnum");

                long tableOid = res.getLong("attrelid");
                String columnName = res.getString("attname");
                if (previousTableOid != tableOid) {
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
    private List<String> getColumnNames(Number[] cols, long tableOid) throws SQLException {
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
    private String getRoleNameByOid(long roleOid) {
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

    /**
     * See: is_builtin(Oid objectId) in shippable.c
     */
    static boolean isBuiltin(long oid) {
        final int firstBootstrapObjectId = 10000;
        return oid < firstBootstrapObjectId;
    }
}
