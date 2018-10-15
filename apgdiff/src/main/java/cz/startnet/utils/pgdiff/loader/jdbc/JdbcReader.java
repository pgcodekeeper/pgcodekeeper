package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.loader.timestamps.ObjectTimestamp;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractSequence;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.AbstractView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFtsConfiguration;
import cz.startnet.utils.pgdiff.schema.PgFtsDictionary;
import cz.startnet.utils.pgdiff.schema.PgFtsParser;
import cz.startnet.utils.pgdiff.schema.PgFtsTemplate;
import cz.startnet.utils.pgdiff.schema.PgOperator;
import cz.startnet.utils.pgdiff.schema.PgType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class JdbcReader implements PgCatalogStrings {

    protected final Map<SupportedVersion, String> queries;
    protected final JdbcLoaderBase loader;

    protected JdbcReader(Map<SupportedVersion, String> queries, JdbcLoaderBase loader) {
        this.queries = queries;
        this.loader = loader;
    }

    public void read() throws SQLException, InterruptedException, XmlReaderException {
        String query = makeQuery(loader.version);

        List<ObjectTimestamp> objects = loader.getTimestampEqualObjects();
        if (objects != null && !objects.isEmpty()) {
            PgDatabase projDb = loader.getTimestampProjDb();

            StringBuilder sb = new StringBuilder();

            for (AbstractSchema schema : loader.schemaIds.values()) {
                fillOldObjects(objects, schema, projDb, sb);
            }

            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                query = excludeObjects(query, sb.toString());
            }
        }

        loader.setCurrentOperation(getClass().getSimpleName() + " query");
        try (ResultSet result = loader.statement.executeQuery(query)) {
            while (result.next()) {
                processResult(result, loader.schemaIds.get(result.getLong("schema_oid")));
            }
        }
    }

    public String makeQuery(int version) {
        StringBuilder sb = new StringBuilder("SELECT * FROM (");
        sb.append(queries.get(null));
        sb.append(") t1 ");

        queries.entrySet().stream()
        .filter(e -> e.getKey() != null && e.getKey().checkVersion(version))
        .forEach(e -> sb.append("LEFT JOIN (").append(e.getValue())
                .append(") t").append(e.getKey().getVersion())
                .append(" USING (oid) "));

        return sb.toString();
    }

    private void fillOldObjects(List<ObjectTimestamp> objects, AbstractSchema sc, PgDatabase projDb, StringBuilder sbOids) {
        DbObjType type = getType();
        DbObjType local = type == DbObjType.CONSTRAINT ? DbObjType.TABLE : type;

        for (ObjectTimestamp obj: objects) {
            if (obj.getSchema().equals(sc.getName()) && obj.getType() == local) {
                switch (type) {
                case VIEW:
                    sc.addView((AbstractView) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case TABLE:
                    sc.addTable((AbstractTable) obj.copyStatement(projDb, loader));
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
                    AbstractSchema schema = projDb.getSchema(sc.getName());
                    AbstractTable t;
                    if (schema != null && (t = schema.getTableByIndex(obj.getColumn())) != null) {
                        sc.getTable(t.getName()).addIndex(t.getIndex(obj.getColumn()).shallowCopy());
                    }
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case FUNCTION:
                    sc.addFunction((AbstractFunction) obj.copyStatement(projDb, loader));
                    sbOids.append(obj.getObjId()).append(',');
                    break;
                case CONSTRAINT:
                    AbstractTable table = (AbstractTable) obj.getObject().getStatement(projDb);
                    AbstractTable newTable = sc.getTable(table.getName());
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
                    sc.addSequence((AbstractSequence) obj.copyStatement(projDb, loader));
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
                case OPERATOR:
                    sc.addOperator((PgOperator) obj.copyStatement(projDb, loader));
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
     * Exclude oids from query
     *
     * @param base - base query
     * @param oids - oids separated by commas
     * @return new query
     */
    public static String excludeObjects(String base, String oids) {
        StringBuilder sb = new StringBuilder("SELECT * FROM (");
        sb.append(base);
        sb.append(") q WHERE NOT (q.oid = ANY (ARRAY [");
        sb.append(oids);
        sb.append("]));");
        return sb.toString();
    }

    protected abstract void processResult(ResultSet result, AbstractSchema schema)
            throws SQLException, XmlReaderException;

    protected DbObjType getType() {
        // PG subclasses must override
        return null;
    }
}
