package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;

import cz.startnet.utils.pgdiff.loader.JdbcQuery;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class JdbcReader implements PgCatalogStrings {

    protected final JdbcQuery queries;
    protected final JdbcLoaderBase loader;

    protected JdbcReader(JdbcQuery queries, JdbcLoaderBase loader) {
        this.queries = queries;
        this.loader = loader;
    }

    public void read() throws SQLException, InterruptedException, XmlReaderException {
        String query = loader.appendTimestamps(queries.makeQuery(loader.version));

        loader.setCurrentOperation(getClass().getSimpleName() + " query");
        try (ResultSet result = loader.runner.runScript(loader.statement, query)) {
            while (result.next()) {
                long schemaId = result.getLong("schema_oid");
                AbstractSchema schema = loader.schemaIds.get(schemaId);
                if (schema != null) {
                    try {
                        processResult(result, schema);
                    } catch (ConcurrentModificationException ex) {
                        if (loader.args.isIgnoreConcurrentModification()) {
                            Log.log(ex);
                        } else {
                            throw ex;
                        }
                    }
                } else {
                    Log.log(Log.LOG_WARNING, "No schema found for id " + schemaId);
                }
            }
        }
    }

    /**
     * The functions that accept the oid / object name and return the set / processing of its metadata are considered unsafe.
     * These functions can return null if the object was deleted outside the transaction block.
     * This method checks the returned values.
     */
    public static void checkObjectValidity(Object object, DbObjType type, String name) {
        if (object == null) {
            throw new ConcurrentModificationException(
                    "Statement concurrent modification: " + type + ' ' + name);
        }
    }

    /**
     * Checks type for a match with null and unknown types that can come from
     * functions that accept the oid / object name and return the set / processing of its metadata
     */
    public static void checkTypeValidity(String type) {
        checkObjectValidity(type, DbObjType.TYPE, "");
        if ("???".equals(type) || "???[]".equals(type)) {
            throw new ConcurrentModificationException("Concurrent type modification");
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

    protected abstract void processResult(ResultSet result, AbstractSchema schema)
            throws SQLException, XmlReaderException;
}
