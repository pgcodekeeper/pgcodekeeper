package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import cz.startnet.utils.pgdiff.loader.JdbcQuery;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class JdbcReader implements PgCatalogStrings {

    private static final String EXTENSION_QUERY = "SELECT q.*, time.ses_user FROM ({0}) q\n"
            + "LEFT JOIN {1}.dbots_event_data time ON q.oid = time.objid";

    protected final JdbcQuery queries;
    protected final JdbcLoaderBase loader;

    protected JdbcReader(JdbcQuery queries, JdbcLoaderBase loader) {
        this.queries = queries;
        this.loader = loader;
    }

    public void read() throws SQLException, InterruptedException, XmlReaderException {
        String query = queries.makeQuery(loader.version);

        /*
        DbObjType type = getType();
        Collection<ObjectTimestamp> objects = loader.getTimestampOldObjects();
        if (objects != null && (!objects.isEmpty() || type == DbObjType.CONSTRAINT)) {
            if (getType() != DbObjType.CONSTRAINT) {
                for (AbstractSchema schema : loader.schemaIds.values()) {
                    fillOldObjects(objects, schema);
                }

                objects.removeIf(obj -> obj.getType() == getType());
            }

            query = excludeObjects(query, loader.getExtensionSchema(), loader.getTimestampLastDate());
        }

         */

        if (loader.getExtensionSchema() != null) {
            query = excludeObjects(query, loader.getExtensionSchema());
        }

        loader.setCurrentOperation(getClass().getSimpleName() + " query");
        try (ResultSet result = loader.runner.runScript(loader.statement, query)) {
            while (result.next()) {
                long schemaId = result.getLong("schema_oid");
                AbstractSchema schema = loader.schemaIds.get(schemaId);
                if (schema != null) {
                    processResult(result, schema);
                } else {
                    Log.log(Log.LOG_WARNING, "No schema found for id " + schemaId);
                }
            }
        }
    }

    /*
    private void fillOldObjects(Collection<ObjectTimestamp> objects, AbstractSchema sc) {
        PgDatabase projDb = loader.getTimestampSnapshot();

        DbObjType type = getType();
        for (ObjectTimestamp obj: objects) {
            if (obj.getSchema().equals(sc.getName()) && obj.getType() == type) {
                switch (type) {
                case VIEW:
                case TABLE:
                case FUNCTION:
                case PROCEDURE:
                case TYPE:
                case SEQUENCE:
                case FTS_PARSER:
                case FTS_TEMPLATE:
                case FTS_DICTIONARY:
                case FTS_CONFIGURATION:
                case OPERATOR:
                    PgStatement st = obj.copyStatement(projDb, loader);
                    if (st != null) {
                        sc.addChild(st);
                    }
                    break;
                case RULE:
                    obj.addRuleCopy(projDb, sc, loader);
                    break;
                case TRIGGER:
                    obj.addTriggerCopy(projDb, sc, loader);
                    break;
                case INDEX:
                    AbstractSchema schema = projDb.getSchema(sc.getName());
                    AbstractTable t;
                    if (schema != null && (t = schema.getTableByIndex(obj.getColumn())) != null) {
                        AbstractTable tab = sc.getTable(t.getName());
                        if (tab != null) {
                            tab.addIndex(t.getIndex(obj.getColumn()).shallowCopy());
                        }
                    }
                    break;
                default:
                    break;
                }
            }
        }
    }
     */

    /**
     * The functions that accept the oid / object name and return the set / processing of its metadata are considered unsafe.
     * These functions can return null if the object was deleted outside the transaction block.
     * This method checks the returned values.
     */
    public static void checkObjectValidity(Object object, DbObjType type, String name) {
        if (object == null) {
            throw new IllegalStateException("Statement concurrent modification: " + type + ' ' + name);
        }
    }

    /**
     * Checks type for a match with null and unknown types that can come from
     * functions that accept the oid / object name and return the set / processing of its metadata
     */
    public static void checkTypeValidity(String type) {
        checkObjectValidity(type, DbObjType.TYPE, "");
        if ("???".equals(type) || "???[]".equals(type)) {
            throw new IllegalStateException("Concurrent type modification");
        }
    }

    protected static <T> T[] getColArray(ResultSet rs, String columnName) throws SQLException {
        Array arr = rs.getArray(columnName);
        if (arr != null) {
            @SuppressWarnings("unchecked")
            T[] ret = (T[]) arr.getArray();
            return ret;
        }
        return null;
    }

    /**
     * Join extension to query
     *
     * @param base base query
     * @param schema extension schema
     * @param date snapshot date
     * @return new query
     */
    /*
    public static String excludeObjects(String base, String schema, Instant date) {
        return MessageFormat.format(EXTENSION_QUERY, base, schema, date);
    }
     */
    /**
     * Join timestamps to query
     *
     * @param base base query
     * @param schema extension schema
     * @return new query
     */
    public static String excludeObjects(String base, String schema) {
        return MessageFormat.format(EXTENSION_QUERY, base, schema);
    }

    protected abstract void processResult(ResultSet result, AbstractSchema schema)
            throws SQLException, XmlReaderException;

    protected DbObjType getType() {
        // PG subclasses must override
        return null;
    }
}
