package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.timestamps.ObjectTimestamp;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
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
            try (ResultSet result = st.executeQuery()) {
                while (result.next()) {
                    ResultSetWrapper wrapper = new JsonResultSetWrapper(result.getString(1));
                    PgDiffUtils.checkCancelled(loader.monitor);
                    processResult(wrapper, loader.schemas.map.get(result.getLong("schema_oid")));
                }
            }
        }
    }

    private void readSchemasSeparately() throws SQLException, InterruptedException, WrapperAccessException {
        String query = factory.makeFallbackQuery(loader.version);
        Set<Entry<Long, PgSchema>> schemas = loader.schemas.map.entrySet();

        List<ObjectTimestamp> objects = loader.getObjects();
        if (objects != null && !objects.isEmpty()) {
            DbObjType type = getType();
            DbObjType local = type == DbObjType.CONSTRAINT ? DbObjType.TABLE : type;
            PgDatabase projDb = loader.getProjDb();

            List<Long> oids = objects.stream().filter(obj -> (obj.getType() == local))
                    .map(ObjectTimestamp::getObjId).collect(Collectors.toList());

            for (Entry<Long, PgSchema> schema : schemas) {
                PgSchema sc = schema.getValue();
                fillOldObjects(objects, sc, type, projDb);
            }

            if (!oids.isEmpty()) {
                query = JdbcReaderFactory.excludeObjects(query, oids);
            }
        }


        try (PreparedStatement st = loader.connection.prepareStatement(query)) {
            for (Entry<Long, PgSchema> schema : schemas) {
                loader.setCurrentOperation("set search_path query");
                loader.statement.execute("SET search_path TO " +
                        PgDiffUtils.getQuotedName(schema.getValue().getName()) + ", pg_catalog;");

                loader.setCurrentOperation(factory.helperFunction + " query for schema " + schema.getValue().getName());
                st.setLong(1, schema.getKey());
                try (ResultSet result = st.executeQuery()) {
                    while (result.next()) {
                        ResultSetWrapper wrapper = new SQLResultSetWrapper(result);
                        PgDiffUtils.checkCancelled(loader.monitor);
                        processResult(wrapper, schema.getValue());
                    }
                }
            }
        }
    }

    private void fillOldObjects(List<ObjectTimestamp> objects, PgSchema sc, DbObjType type, PgDatabase projDb) {
        for (ObjectTimestamp obj: objects) {
            if (obj.getSchema().equals(sc.getName()) && (obj.getType() == type
                    || obj.getType() == DbObjType.TABLE && type == DbObjType.CONSTRAINT)) {
                switch (type) {
                case VIEW:
                    sc.addView((PgView) obj.getShallowCopy(projDb));
                    break;
                case TABLE:
                    sc.addTable((PgTable) obj.getShallowCopy(projDb));
                    break;
                case RULE:
                    PgRule rule = (PgRule) obj.getShallowCopy(projDb);
                    sc.getRuleContainer(rule.getParent().getName()).addRule(rule);
                    break;
                case TRIGGER:
                    PgTrigger trig = (PgTrigger) obj.getShallowCopy(projDb);
                    sc.getTriggerContainer(trig.getParent().getName()).addTrigger(trig);
                    break;
                case INDEX:
                    PgSchema baseSchema = projDb.getSchema(sc.getName());
                    if (baseSchema != null ) {
                        PgTable table = baseSchema.getTableByIndex(obj.getColumn());
                        if (table != null) {
                            String tableName = table.getName();
                            PgIndex index = (PgIndex) GenericColumn.
                                    getObject(projDb, sc.getName(), tableName, obj.getColumn(), DbObjType.INDEX);
                            sc.getTable(tableName).addIndex(index.shallowCopy());
                        }
                    }
                    break;
                case FUNCTION:
                    sc.addFunction((PgFunction) obj.getShallowCopy(projDb));
                    break;
                case CONSTRAINT:
                    PgTable table = (PgTable) obj.getDeepCopy(projDb);
                    PgTable newTable = sc.getTable(table.getName());
                    table.getConstraints().forEach(con -> newTable.addConstraint(con.shallowCopy()));
                    break;
                case TYPE:
                    sc.addType((PgType) obj.getShallowCopy(projDb));
                    break;
                case SEQUENCE:
                    sc.addSequence((PgSequence) obj.getShallowCopy(projDb));
                    break;
                default:
                    break;
                }
            }
        }
    }

    protected abstract void processResult(ResultSetWrapper json, PgSchema schema)
            throws SQLException, WrapperAccessException;

    protected abstract DbObjType getType();

}
