package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;

/**
 * Container for shared JdbcLoader state.
 *
 * @author levsha_aa
 */
public abstract class JdbcLoaderBase implements PgCatalogStrings {

    private static final int DEFAULT_OBJECTS_COUNT = 100;

    protected final JdbcConnector connector;
    protected final SubMonitor monitor;
    protected final PgDiffArguments args;
    private GenericColumn currentObject;
    private String currentOperation;
    protected Connection connection;
    protected Statement statement;
    private Map<Long, String> cachedRolesNamesByOid;
    protected Map<Long, JdbcType> cachedTypesByOid;
    protected long availableHelpersBits;
    protected SchemasContainer schemas;

    public JdbcLoaderBase(JdbcConnector connector, SubMonitor monitor, PgDiffArguments args) {
        this.connector = connector;
        this.monitor = monitor;
        this.args = args;
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

    protected void queryRoles() throws SQLException {
        if (args.isIgnorePrivileges()) {
            return;
        }
        cachedRolesNamesByOid = new HashMap<>();
        setCurrentOperation("roles query");
        try (ResultSet res = statement.executeQuery("SELECT oid::bigint, rolname FROM pg_catalog.pg_roles")) {
            while (res.next()) {
                cachedRolesNamesByOid.put(res.getLong(OID), res.getString("rolname"));
            }
        }
    }

    protected String getRoleByOid(long oid) {
        return oid == 0 ? "PUBLIC" : cachedRolesNamesByOid.get(oid);
    }

    protected void setOwner(PgStatement statement, long ownerOid) {
        if (!args.isIgnorePrivileges()) {
            statement.setOwner(getRoleByOid(ownerOid));
        }
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
    protected void setPrivileges(PgStatement st, String stSignature,
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

    protected void queryTypesForCache() throws SQLException {
        cachedTypesByOid = new HashMap<>();
        setCurrentOperation("type cache query");
        try (ResultSet res = statement.executeQuery(JdbcQueries.QUERY_TYPES_FOR_CACHE_ALL)) {
            while (res.next()) {
                long oid = res.getLong(OID);
                JdbcType type = new JdbcType(oid, res.getString("typname"),
                        res.getLong("typelem"), res.getLong("typarray"),
                        res.getString(NAMESPACE_NSPNAME), res.getString("elemname"));
                cachedTypesByOid.put(oid, type);
            }
        }
    }

    protected void setupMonitorWork() throws SQLException {
        setCurrentOperation("object count query");
        try (ResultSet resCount = statement.executeQuery(JdbcQueries.QUERY_TOTAL_OBJECTS_COUNT)) {
            monitor.setWorkRemaining(resCount.next() ? resCount.getInt(1) : DEFAULT_OBJECTS_COUNT);
        }
    }

    /**
     * See: is_builtin(Oid objectId) in shippable.c
     */
    static boolean isBuiltin(long oid) {
        final int firstBootstrapObjectId = 10000;
        return oid < firstBootstrapObjectId;
    }
}