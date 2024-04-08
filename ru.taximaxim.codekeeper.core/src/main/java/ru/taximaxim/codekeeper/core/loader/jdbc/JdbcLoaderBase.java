/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.Parser;
import org.eclipse.core.runtime.SubMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.DatabaseLoader;
import ru.taximaxim.codekeeper.core.loader.JdbcConnector;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.loader.JdbcRunner;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.MonitorCancelledRuntimeException;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgFunction;

/**
 * Container for shared JdbcLoader state.
 *
 * @author levsha_aa
 */
public abstract class JdbcLoaderBase extends DatabaseLoader {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcLoaderBase.class);

    private static final int DEFAULT_OBJECTS_COUNT = 100;

    /**
     * OID of the first user object
     *
     * @see <a href="https://github.com/postgres/postgres/blob/master/src/include/access/transam.h">transam.h</a>
     */
    private static final int FIRST_NORMAL_OBJECT_ID = 16384;

    private final SubMonitor monitor;
    private final PgDiffArguments args;
    private final IgnoreSchemaList ignorelistSchema;
    protected final Map<Object, AbstractSchema> schemaIds = new HashMap<>();
    protected final JdbcConnector connector;

    private boolean isGreenplumDb;
    private int version;
    private long lastSysOid;
    private String extensionSchema;
    private String currentOperation;
    private GenericColumn currentObject;
    private JdbcRunner runner;
    private Map<Long, JdbcType> cachedTypesByOid;
    private Map<Long, String> cachedRolesNamesByOid;

    protected Connection connection;
    protected Statement statement;

    protected JdbcLoaderBase(JdbcConnector connector, SubMonitor monitor, PgDiffArguments args,
            IgnoreSchemaList ignoreListSchema) {
        this.connector = connector;
        this.monitor = monitor;
        this.args = args;
        this.runner = new JdbcRunner(monitor);
        this.ignorelistSchema = ignoreListSchema;
    }

    public int getVersion() {
        return version;
    }

    public PgDiffArguments getArgs() {
        return args;
    }

    public long getLastSysOid() {
        return lastSysOid;
    }

    public Connection getConnection() {
        return connection;
    }

    public JdbcRunner getRunner() {
        return runner;
    }

    public Statement getStatement() {
        return statement;
    }

    public SubMonitor getMonitor() {
        return monitor;
    }

    public String getExtensionSchema() {
        return extensionSchema;
    }

    public void putSchema(Object schemaId, AbstractSchema schema) {
        schemaIds.put(schemaId, schema);
    }

    protected AbstractSchema getSchema(Object schemaId) {
        return schemaIds.get(schemaId);
    }

    public String getSchemas() {
        return schemaIds.keySet().stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public void setCurrentObject(GenericColumn currentObject) {
        this.currentObject = currentObject;
    }

    public void setCurrentOperation(String operation) {
        currentObject = null;
        currentOperation = operation;
    }

    public boolean checkIgnoreSchemaList(String schemaName) {
        return ignorelistSchema == null || ignorelistSchema.getNameStatus(schemaName);
    }

    public JdbcType getCachedTypeByOid(Long oid) {
        return cachedTypesByOid.get(oid);
    }

    public String getCurrentLocation() {
        StringBuilder sb = new StringBuilder("jdbc:");
        if (currentObject == null) {
            return sb.append(currentOperation).toString();
        }
        if (currentObject.schema != null) {
            sb.append('/').append(currentObject.schema);
        }
        if (currentObject.table != null) {
            sb.append('/').append(currentObject.table);
        }
        if (currentObject.column != null) {
            sb.append('/').append(currentObject.column);
        }
        return sb.toString();
    }

    public boolean isGreenplumDb() {
        return isGreenplumDb;
    }

    protected void queryRoles() throws SQLException, InterruptedException {
        if (args.isIgnorePrivileges()) {
            return;
        }
        cachedRolesNamesByOid = new HashMap<>();
        setCurrentOperation("roles query");
        try (ResultSet res = runner.runScript(statement, "SELECT oid::bigint, rolname FROM pg_catalog.pg_roles")) {
            while (res.next()) {
                cachedRolesNamesByOid.put(res.getLong("oid"), res.getString("rolname"));
            }
        }
    }

    public void addError(final String message) {
        errors.add(getCurrentLocation() + ' ' + message);
    }

    public String getRoleByOid(long oid) {
        if (args.isIgnorePrivileges()) {
            return null;
        }
        return oid == 0 ? "PUBLIC" : cachedRolesNamesByOid.get(oid);
    }

    public final void setComment(PgStatement f, ResultSet res) throws SQLException {
        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            f.setComment(args, PgDiffUtils.quoteString(comment));
        }
    }

    public void setOwner(PgStatement statement, long ownerOid) {
        if (!args.isIgnorePrivileges()) {
            statement.setOwner(getRoleByOid(ownerOid));
        }
    }

    public void setOwner(PgStatement st, String owner) {
        if (!args.isIgnorePrivileges()) {
            st.setOwner(owner);
        }
    }

    public void setAuthor(PgStatement st, ResultSet res) throws SQLException {
        if (getExtensionSchema() != null) {
            st.setAuthor(res.getString("ses_user"));
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
                && Consts.PUBLIC.equals(st.getName())) {
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
        case SERVER:
            stType = "FOREIGN SERVER";
            order = "U";
            break;
        case FOREIGN_DATA_WRAPPER:
            stType = "FOREIGN DATA WRAPPER";
            order = "U";
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

    public static String getMsType(PgStatement statement, String schema, String dataType,
            boolean isUserDefined, int size, int precision, int scale) {
        return getMsType(statement, schema, dataType, isUserDefined, size, precision, scale, true);
    }

    public static String getMsType(PgStatement statement, String schema, String dataType,
            boolean isUserDefined, int size, int precision, int scale, boolean quoteSysTypes) {
        StringBuilder sb = new StringBuilder();

        if (isUserDefined) {
            statement.addDep(new GenericColumn(schema, dataType, DbObjType.TYPE));
            sb.append(MsDiffUtils.quoteName(schema)).append('.');
        }

        boolean quoteName = isUserDefined || quoteSysTypes || !Utils.isMsSystemSchema(schema);
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
                long oid = res.getLong("oid");
                JdbcType type = new JdbcType(oid, res.getString("typname"),
                        res.getLong("typelem"), res.getLong("typarray"),
                        res.getString("nspname"), res.getString("elemname"), lastSysOid);
                cachedTypesByOid.put(oid, type);
            }
        }
    }

    protected void queryCheckVersion() throws SQLException, InterruptedException {
        setCurrentOperation("version checking query");
        try (ResultSet res = runner.runScript(statement, JdbcQueries.QUERY_CHECK_VERSION)) {
            version = res.next() ? res.getInt(1) : SupportedVersion.VERSION_9_4.getVersion();
        }
    }

    protected void queryCheckLastSysOid() throws SQLException, InterruptedException {
        setCurrentOperation("last system oid checking query");
        if (SupportedVersion.VERSION_15.isLE(getVersion())) {
            lastSysOid = FIRST_NORMAL_OBJECT_ID - 1L;
        } else {
            try (ResultSet res = runner.runScript(statement,
                    JdbcQueries.QUERY_CHECK_LAST_SYS_OID)) {
                lastSysOid = res.next() ? res.getLong(1) : 10_000;
            }
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
                String extVersion = res.getString("extversion");
                if (!extVersion.startsWith(Consts.EXTENSION_VERSION)) {
                    LOG.info("pg_dbo_timestamps: old version of extension is used: {}, current version: {}",
                            extVersion, Consts.EXTENSION_VERSION);
                } else if (res.getBoolean("disabled")) {
                    LOG.info("pg_dbo_timestamps: event trigger is disabled");
                } else {
                    extensionSchema = res.getString("nspname");
                }
            }
        }
    }

    public <T> void submitAntlrTask(String sql,
            Function<SQLParser, T> parserCtxReader, Consumer<T> finalizer) {
        submitAntlrTask(sql, parserCtxReader, finalizer, false, SQLParser.class);
    }

    public <T> void submitPlpgsqlTask(String sql,
            Function<SQLParser, T> parserCtxReader, Consumer<T> finalizer) {
        submitAntlrTask(sql, parserCtxReader, finalizer, true, SQLParser.class);
    }

    public <T> void submitMsAntlrTask(String sql,
            Function<TSQLParser, T> parserCtxReader, Consumer<T> finalizer) {
        submitAntlrTask(sql, parserCtxReader, finalizer, false, TSQLParser.class);
    }

    public <T> void submitChAntlrTask(String sql,
            Function<CHParser, T> parserCtxReader, Consumer<T> finalizer) {
        submitAntlrTask(sql, parserCtxReader, finalizer, false, CHParser.class);
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

    protected void queryCheckGreenplumDb() throws SQLException, InterruptedException {
        setCurrentOperation("greenplum checking query");
        try (ResultSet res = runner.runScript(statement, JdbcQueries.QUERY_CHECK_GREENPLUM)) {
            if (res.next()) {
                isGreenplumDb = res.getString(1).contains(Consts.GREENPLUM);
            }
        }
    }

    @Override
    protected void finishLoaders() throws InterruptedException, IOException {
        setCurrentOperation("finalizing antlr");
        AntlrParser.finishAntlr(antlrTasks);
    }
}
