package cz.startnet.utils.pgdiff.loader.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.Parser;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.DatabaseLoader;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Container for shared JdbcLoader state.
 *
 * @author levsha_aa
 */
public abstract class JdbcLoaderBase extends DatabaseLoader implements PgCatalogStrings {

    private static final String EXTENSION_QUERY = "SELECT q.*, time.ses_user FROM ({0}) q\n"
            + "LEFT JOIN {1}.dbots_event_data time ON q.oid = time.objid";

    private static final int DEFAULT_OBJECTS_COUNT = 100;

    // TODO after removing helpers split this into MS and PG base classes

    protected final JdbcConnector connector;
    protected final SubMonitor monitor;
    protected final PgDiffArguments args;
    private GenericColumn currentObject;
    private String currentOperation;
    protected Connection connection;
    protected Statement statement;
    private Map<Long, String> cachedRolesNamesByOid;
    protected Map<Long, JdbcType> cachedTypesByOid;
    protected final Map<Long, AbstractSchema> schemaIds = new HashMap<>();
    protected int version;
    private long lastSysOid;
    protected JdbcRunner runner;

    private String extensionSchema;

    public JdbcLoaderBase(JdbcConnector connector, SubMonitor monitor, PgDiffArguments args) {
        this.connector = connector;
        this.monitor = monitor;
        this.args = args;
        this.runner = new JdbcRunner(monitor);
    }

    protected void setCurrentObject(GenericColumn currentObject) {
        this.currentObject = currentObject;
    }

    protected void setCurrentOperation(String operation) {
        currentObject = null;
        currentOperation = operation;
    }

    protected String getCurrentLocation() {
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

    protected void queryRoles() throws SQLException, InterruptedException {
        if (args.isIgnorePrivileges()) {
            return;
        }
        cachedRolesNamesByOid = new HashMap<>();
        setCurrentOperation("roles query");
        try (ResultSet res = runner.runScript(statement, "SELECT oid::bigint, rolname FROM pg_catalog.pg_roles")) {
            while (res.next()) {
                cachedRolesNamesByOid.put(res.getLong(OID), res.getString("rolname"));
            }
        }
    }

    protected void addError(final String message) {
        errors.add(getCurrentLocation() + ' ' + message);
    }

    /**
     * Join timestamps to query
     *
     * @param base base query
     * @return new query
     */
    public String appendTimestamps(String base) {
        if (extensionSchema == null) {
            return base;
        }
        return MessageFormat.format(EXTENSION_QUERY, base, PgDiffUtils.getQuotedName(extensionSchema));
    }

    public String getExtensionSchema() {
        return extensionSchema;
    }

    protected String getRoleByOid(long oid) {
        if (args.isIgnorePrivileges()) {
            return null;
        }
        return oid == 0 ? "PUBLIC" : cachedRolesNamesByOid.get(oid);
    }

    protected void setOwner(PgStatement statement, long ownerOid) {
        if (!args.isIgnorePrivileges()) {
            statement.setOwner(getRoleByOid(ownerOid));
        }
    }

    protected void setOwner(PgStatement st, String owner) {
        if (!args.isIgnorePrivileges()) {
            st.setOwner(owner);
        }
    }

    protected void setAuthor(PgStatement st, ResultSet res) throws SQLException {
        if (getExtensionSchema() != null) {
            st.setAuthor(res.getString(AUTHOR));
        }
    }

    public void setPrivileges(PgStatement st, String aclItemsArrayAsString, String schemaName) {
        setPrivileges(st, aclItemsArrayAsString, null, schemaName);
    }

    public void setPrivileges(PgStatement st, String aclItemsArrayAsString, String columnName, String schemaName) {
        String signature;
        switch (st.getStatementType()) {
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
            signature = ((AbstractPgFunction) st).appendFunctionSignature(
                    new StringBuilder(), false, true).toString();
            break;
        default:
            signature = PgDiffUtils.getQuotedName(st.getName());
            break;
        }

        String owner = st.getOwner();
        if (owner == null && st.getStatementType() == DbObjType.SCHEMA
                && ApgdiffConsts.PUBLIC.equals(st.getName())) {
            owner = "postgres";
        }

        setPrivileges(st, signature, aclItemsArrayAsString, owner,
                columnName == null ? null : PgDiffUtils.getQuotedName(columnName), schemaName);
    }

    public void setPrivileges(AbstractColumn column, AbstractTable t, String aclItemsArrayAsString, String schemaName) {
        setPrivileges(column, PgDiffUtils.getQuotedName(t.getName()), aclItemsArrayAsString,
                t.getOwner(), PgDiffUtils.getQuotedName(column.getName()), schemaName);
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
     * @param schemaName name of schema for 'PgStatement st'
     */
    /*
     * See parseAclItem() in dumputils.c
     * For privilege characters see JdbcAclParser.PrivilegeTypes
     * Order of all characters (for all types of objects combined) : raxdtDXCcTUw
     */
    private void setPrivileges(PgStatement st, String stSignature,
            String aclItemsArrayAsString, String owner, String columnId, String schemaName) {
        if (aclItemsArrayAsString == null || args.isIgnorePrivileges()) {
            return;
        }
        DbObjType type = st.getStatementType();
        String stType = null;
        boolean isFunctionOrTypeOrDomain = false;
        String order;
        switch (type) {
        case SEQUENCE:
            order = "rUw";
            break;

        case TABLE:
        case VIEW:
        case COLUMN:
            stType = "TABLE";
            if (columnId == null) {
                order = "raxdtDw";
            } else {
                order = "raxw";
            }
            break;

        case AGGREGATE:
            // For grant permissions to AGGREGATE in postgres used operator 'FUNCTION'.
            // For example grant permissions to AGGREGATE public.mode(boolean):
            // GRANT ALL ON FUNCTION public.mode(boolean) TO test_user;
            stType = "FUNCTION";

            // For grant permissions to AGGREGATE without arguments as signature
            // used only left and right paren.
            if (stSignature.contains("*")) {
                stSignature = stSignature.replace("*", "");
            }
            // $FALL-THROUGH$
        case FUNCTION:
        case PROCEDURE:
            order = "X";
            isFunctionOrTypeOrDomain = true;
            break;

        case SCHEMA:
            order = "CU";
            break;

        case TYPE:
        case DOMAIN:
            stType = "TYPE";
            order = "U";
            isFunctionOrTypeOrDomain = true;
            break;

        default:
            throw new IllegalStateException(type + " doesn't support privileges!");
        }
        int possiblePrivilegeCount = order.length();
        if (stType == null) {
            stType = st.getStatementType().name();
        }

        String qualStSignature = schemaName == null ? stSignature
                : PgDiffUtils.getQuotedName(schemaName) + '.' + stSignature;
        String column = columnId != null ? "(" + columnId + ")" : "";

        List<Privilege> grants = JdbcAclParser.parse(
                aclItemsArrayAsString, possiblePrivilegeCount, order, owner);

        boolean metPublicRoleGrants = false;
        boolean metDefaultOwnersGrants = false;
        for (Privilege p : grants) {
            if (p.isGrantAllToPublic()) {
                metPublicRoleGrants = true;
            }
            if (p.isDefault) {
                metDefaultOwnersGrants = true;
            }
        }

        // FUNCTION/TYPE/DOMAIN by default has "GRANT ALL to PUBLIC".
        // If "GRANT ALL to PUBLIC" for FUNCTION/TYPE/DOMAIN is absent, then
        // in this case for them explicitly added "REVOKE ALL from PUBLIC".
        if (!metPublicRoleGrants && isFunctionOrTypeOrDomain) {
            st.addPrivilege(new PgPrivilege("REVOKE", "ALL" + column,
                    stType + " " + qualStSignature, "PUBLIC", false));
        }

        // 'REVOKE ALL' for COLUMN never happened, because of the overlapping
        // privileges from the table.
        if (column.isEmpty() && !metDefaultOwnersGrants) {
            st.addPrivilege(new PgPrivilege("REVOKE", "ALL" + column,
                    stType + " " + qualStSignature, PgDiffUtils.getQuotedName(owner), false));
        }

        for (Privilege grant : grants) {
            // Always add if statement type is COLUMN, because of the specific
            // relationship with table privileges.
            // The privileges of columns for role are not set lower than for the
            // same role in the parent table, they may be the same or higher.
            //
            // Skip if default owner's privileges
            // or if it is 'GRANT ALL ON FUNCTION/TYPE/DOMAIN schema.name TO PUBLIC'
            if (column.isEmpty() && (grant.isDefault ||
                    (isFunctionOrTypeOrDomain && grant.isGrantAllToPublic()))) {
                continue;
            }
            String grantString = grant.grantValues.stream()
                    .collect(Collectors.joining(column + ',', "", column));
            st.addPrivilege(new PgPrivilege("GRANT", grantString,
                    stType + " " + qualStSignature, grant.grantee, grant.isGO));
        }
    }

    public void setPrivileges(PgStatement st, List<XmlReader> privs) {
        if (args.isIgnorePrivileges()) {
            return;
        }

        for (XmlReader acl : privs) {
            String state = acl.getString("sd");
            boolean isWithGrantOption = false;
            if ("GRANT_WITH_GRANT_OPTION".equals(state)) {
                state = "GRANT";
                isWithGrantOption = true;
            }

            String permission = acl.getString("pn");
            String role = acl.getString("r");
            String col = null;
            StringBuilder sb = new StringBuilder();

            if (st instanceof PgStatementWithSearchPath) {
                col = acl.getString("c");
                if (st.getStatementType() == DbObjType.TYPE) {
                    sb.append("TYPE::");
                }

                sb.append(st.getQualifiedName());

                if (col != null) {
                    sb.append('(').append(MsDiffUtils.quoteName(col)).append(')');
                }
            } else {
                sb.append(st.getStatementType() + "::" + MsDiffUtils.quoteName(st.getName()));
            }

            PgPrivilege priv = new PgPrivilege(state, permission, sb.toString(),
                    MsDiffUtils.quoteName(role), isWithGrantOption);

            if (col != null && st instanceof AbstractTable) {
                ((AbstractTable) st).getColumn(col).addPrivilege(priv);
            } else {
                st.addPrivilege(priv);
            }
        }
    }

    protected static String getMsType(PgStatement statement, String schema, String dataType,
            boolean isUserDefined, int size, int precision, int scale) {
        return getMsType(statement, schema, dataType, isUserDefined, size, precision, scale, true);
    }

    protected static String getMsType(PgStatement statement, String schema, String dataType,
            boolean isUserDefined, int size, int precision, int scale, boolean quoteSysTypes) {
        StringBuilder sb = new StringBuilder();

        if (isUserDefined) {
            statement.addDep(new GenericColumn(schema, dataType, DbObjType.TYPE));
            sb.append(MsDiffUtils.quoteName(schema)).append('.');
        }

        boolean quoteName = isUserDefined || quoteSysTypes || !ApgdiffUtils.isMsSystemSchema(schema);
        sb.append(quoteName ? MsDiffUtils.quoteName(dataType) : dataType);

        if ("varbinary".equals(dataType) || "nvarchar".equals(dataType)
                || "varchar".equals(dataType)) {
            if (size == -1) {
                sb.append(" (max)");
            } else {
                sb.append(" (").append(size).append(')');
            }
        } else if ("decimal".equals(dataType) || "numeric".equals(dataType)) {
            sb.append(" (").append(precision).append(", ").append(scale).append(')');
        }

        return sb.toString();
    }

    protected void queryTypesForCache() throws SQLException, InterruptedException {
        cachedTypesByOid = new HashMap<>();
        setCurrentOperation("type cache query");
        try (ResultSet res = runner.runScript(statement, JdbcQueries.QUERY_TYPES_FOR_CACHE_ALL)) {
            while (res.next()) {
                long oid = res.getLong(OID);
                JdbcType type = new JdbcType(oid, res.getString("typname"),
                        res.getLong("typelem"), res.getLong("typarray"),
                        res.getString(NAMESPACE_NSPNAME), res.getString("elemname"), lastSysOid);
                cachedTypesByOid.put(oid, type);
            }
        }
    }

    protected void queryCheckVersion() throws SQLException, InterruptedException {
        setCurrentOperation("version checking query");
        try (ResultSet res = runner.runScript(statement, JdbcQueries.QUERY_CHECK_VERSION)) {
            version = res.next() ? res.getInt(1) : SupportedVersion.VERSION_9_2.getVersion();
        }
    }

    protected void queryCheckLastSysOid() throws SQLException, InterruptedException {
        setCurrentOperation("last system oid checking query");
        try (ResultSet res = runner.runScript(statement, JdbcQueries.QUERY_CHECK_LAST_SYS_OID)) {
            lastSysOid = res.next() ? res.getLong(1) : 10_000;
        }
    }

    protected void setupMonitorWork() throws SQLException, InterruptedException {
        setCurrentOperation("object count query");
        try (ResultSet resCount = runner.runScript(statement, JdbcQueries.QUERY_TOTAL_OBJECTS_COUNT)) {
            monitor.setWorkRemaining(resCount.next() ? resCount.getInt(1) : DEFAULT_OBJECTS_COUNT);
        }
    }

    protected void queryCheckExtension() throws SQLException, InterruptedException {
        setCurrentOperation("check pg_dbo_timestamp extension");
        try (ResultSet res = runner.runScript(statement, JdbcQueries.QUERY_CHECK_TIMESTAMPS)) {
            while (res.next()) {
                String version = res.getString("extversion");
                if (!version.equals(ApgdiffConsts.EXTENSION_VERSION)) {
                    Log.log(Log.LOG_INFO, "pg_dbo_timestamps: old version of extension is used: " +
                            version + ", current version: " + ApgdiffConsts.EXTENSION_VERSION);
                } else if (res.getBoolean("disabled")) {
                    Log.log(Log.LOG_INFO, "pg_dbo_timestamps: event trigger is disabled");
                } else {
                    extensionSchema = res.getString("nspname");
                }
            }
        }
    }


    protected <T> void submitAntlrTask(String sql,
            Function<SQLParser, T> parserCtxReader, Consumer<T> finalizer) {
        submitAntlrTask(sql, parserCtxReader, finalizer, false, SQLParser.class);
    }

    protected <T> void submitPlpgsqlTask(String sql,
            Function<SQLParser, T> parserCtxReader, Consumer<T> finalizer) {
        submitAntlrTask(sql, parserCtxReader, finalizer, true, SQLParser.class);
    }

    protected <T> void submitMsAntlrTask(String sql,
            Function<TSQLParser, T> parserCtxReader, Consumer<T> finalizer) {
        submitAntlrTask(sql, parserCtxReader, finalizer, false, TSQLParser.class);
    }

    private <T, P extends Parser> void submitAntlrTask(String sql,
            Function<P, T> parserCtxReader, Consumer<T> finalizer,
            boolean removeInto, Class<P> parserClass) {
        String location = getCurrentLocation();
        GenericColumn object = this.currentObject;
        List<Object> list = new ArrayList<>();
        AntlrParser.submitAntlrTask(antlrTasks, () -> {
            PgDiffUtils.checkCancelled(monitor);
            P p = AntlrParser.makeBasicParser(parserClass, sql, location, list);
            if (removeInto) {
                AntlrUtils.removeIntoStatements(p);
            }
            return parserCtxReader.apply(p);
        }, t -> {
            errors.addAll(list);
            if (monitor.isCanceled()) {
                throw new MonitorCancelledRuntimeException();
            }
            setCurrentObject(object);
            finalizer.accept(t);
        });
    }

    @Override
    protected void finishLoaders() throws InterruptedException, IOException {
        setCurrentOperation("finalizing antlr");
        AntlrParser.finishAntlr(antlrTasks);
    }
}
