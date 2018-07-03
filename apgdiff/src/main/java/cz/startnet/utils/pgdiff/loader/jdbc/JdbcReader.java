package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import cz.startnet.utils.pgdiff.loader.timestamps.ObjectTimestamp;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsConfiguration;
import cz.startnet.utils.pgdiff.schema.PgFtsDictionary;
import cz.startnet.utils.pgdiff.schema.PgFtsParser;
import cz.startnet.utils.pgdiff.schema.PgFtsTemplate;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.wrappers.JsonResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.SQLResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class JdbcReader implements PgCatalogStrings {

    protected final JdbcReaderFactory factory;
    protected final JdbcLoaderBase loader;

    protected JdbcReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        this.factory = factory;
        this.loader = loader;
    }

    public void read() throws SQLException, InterruptedException, WrapperAccessException {
        boolean helperSuccess = false;
        if ((loader.availableHelpersBits & factory.hasHelperMask) != 0) {
            try {
                readAllUsingHelper();
                helperSuccess = true;
            } catch (SQLException | WrapperAccessException ex) {
                loader.addError(Messages.JdbcReader_helper_function_error);
                Log.log(Log.LOG_WARNING, "Error trying to use server JDBC helper, "
                        + "falling back to old queries: " + factory.helperFunction, ex);
                loader.connection.rollback();
            }
        }
        if (!helperSuccess) {
            readSchemasSeparately();
        }
    }

    private void readAllUsingHelper() throws SQLException, InterruptedException, WrapperAccessException {
        try (PreparedStatement st = loader.connection.prepareStatement(factory.helperQuery)) {
            loader.setCurrentOperation(factory.helperFunction + " query");

            st.setArray(1, loader.schemas.oids);
            st.setArray(2, loader.schemas.names);
            try (ResultSet result = loader.runner.runScript(st)) {
                while (result.next()) {
                    ResultSetWrapper wrapper = new JsonResultSetWrapper(result.getString(1));
                    processResult(wrapper, loader.schemas.map.get(result.getLong("schema_oid")));
                }
            }
        }
    }

    private void readSchemasSeparately() throws SQLException, InterruptedException, WrapperAccessException {
        String query = factory.makeFallbackQuery(loader.version);
        Set<Entry<Long, PgSchema>> schemas = loader.schemas.map.entrySet();

        List<ObjectTimestamp> objects = loader.getTimestampEqualObjects();
        if (objects != null && !objects.isEmpty()) {
            PgDatabase projDb = loader.getTimestampProjDb();

            StringBuilder sb = new StringBuilder();

            for (Entry<Long, PgSchema> schema : schemas) {
                PgSchema sc = schema.getValue();
                fillOldObjects(objects, sc, projDb, sb);
            }

            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                query = JdbcReaderFactory.excludeObjects(query, sb.toString());
            }
        }

        try (PreparedStatement st = loader.connection.prepareStatement(query)) {
            for (Entry<Long, PgSchema> schema : schemas) {
                loader.setCurrentOperation("set search_path query");
                loader.runner.run(loader.statement, "SET search_path TO pg_catalog;");

                loader.setCurrentOperation(factory.helperFunction + " query for schema " + schema.getValue().getName());
                st.setLong(1, schema.getKey());
                try (ResultSet result = loader.runner.runScript(st)) {
                    while (result.next()) {
                        ResultSetWrapper wrapper = new SQLResultSetWrapper(result);
                        processResult(wrapper, schema.getValue());
                    }
                }
            }
        }
    }

    private void fillOldObjects(List<ObjectTimestamp> objects, PgSchema sc, PgDatabase projDb, StringBuilder sbOids) {
        DbObjType type = getType();
        DbObjType local = type == DbObjType.CONSTRAINT ? DbObjType.TABLE : type;

        for (ObjectTimestamp obj: objects) {
            if (obj.getSchema().equals(sc.getName()) && obj.getType() == local) {
                switch (type) {
                case VIEW:
                    sc.addView((PgView) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case TABLE:
                    sc.addTable((PgTable) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case RULE:
                    obj.addRuleCopy(projDb, sc, loader);
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case TRIGGER:
                    obj.addTriggerCopy(projDb, sc, loader);
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case INDEX:
                    PgSchema schema = projDb.getSchema(sc.getName());
                    PgTable t;
                    if (schema != null && (t = schema.getTableByIndex(obj.getColumn())) != null) {
                        sc.getTable(t.getName()).addIndex(t.getIndex(obj.getColumn()).shallowCopy());
                    }
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case FUNCTION:
                    sc.addFunction((PgFunction) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case CONSTRAINT:
                    PgTable table = (PgTable) obj.getObject().getStatement(projDb);
                    PgTable newTable = sc.getTable(table.getName());
                    if (newTable.getConstraints().isEmpty()) {
                        table.getConstraints().forEach(con -> newTable.addConstraint(con.shallowCopy()));
                    }
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case TYPE:
                    sc.addType((PgType) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case SEQUENCE:
                    sc.addSequence((PgSequence) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case FTS_PARSER:
                    sc.addFtsParser((PgFtsParser) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case FTS_TEMPLATE:
                    sc.addFtsTemplate((PgFtsTemplate) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case FTS_DICTIONARY:
                    sc.addFtsDictionary((PgFtsDictionary) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case FTS_CONFIGURATION:
                    sc.addFtsConfiguration((PgFtsConfiguration) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                default:
                    break;
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

    protected abstract void processResult(ResultSetWrapper json, PgSchema schema)
            throws SQLException, WrapperAccessException;

    protected abstract DbObjType getType();

}
