package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;
import java.util.function.BiConsumer;

import cz.startnet.utils.pgdiff.loader.JdbcQuery;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
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
        try (PreparedStatement statement = loader.connection.prepareStatement(query)) {
            setParams(statement);
            ResultSet result = loader.runner.runScript(statement);
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

    protected void setParams(PreparedStatement statement) throws SQLException {
        // subclasses will override if needed
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

    protected <T extends PgStatement> void setFunctionWithDep(
            BiConsumer<T, String> setter, T statement, String function) {
        if (function.contains(".")) {
            QNameParser<IdentifierContext> parser = QNameParser.parsePg(function);
            String schemaName = parser.getSchemaName();
            if (schemaName != null && !ApgdiffUtils.isPgSystemSchema(schemaName)) {
                statement.addDep(new GenericColumn(schemaName, parser.getFirstName(), DbObjType.FUNCTION));
            }
        }
        setter.accept(statement, function);
    }

    protected abstract void processResult(ResultSet result, AbstractSchema schema)
            throws SQLException, XmlReaderException;
}
