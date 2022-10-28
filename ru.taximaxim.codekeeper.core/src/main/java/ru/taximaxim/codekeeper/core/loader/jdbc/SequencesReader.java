package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.log.Log;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgColumn;
import ru.taximaxim.codekeeper.core.schema.PgSequence;

public class SequencesReader extends JdbcReader {

    public SequencesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_SEQUENCES, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        loader.monitor.worked(1);
        String sequenceName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schema.getName(), sequenceName, DbObjType.SEQUENCE));
        PgSequence s = new PgSequence(sequenceName);

        String refTable = res.getString("referenced_table_name");
        String refColumn = res.getString("ref_col_name");

        if ("u".equals(res.getString("relpersistence"))) {
            s.setLogged(false);
        }

        String identityType = null;
        identityType = res.getString("attidentity");
        if (identityType != null && identityType.isEmpty()) {
            // treat lack of table dependency and no identityType as a single case
            identityType = null;
        }

        if (refTable != null && identityType == null) {
            s.setOwnedBy(new GenericColumn(schema.getName(), refTable,
                    res.getString("ref_col_name"), DbObjType.COLUMN));
        }

        if (identityType == null) {
            loader.setOwner(s, res.getLong(CLASS_RELOWNER));
            // PRIVILEGES
            loader.setPrivileges(s, res.getString("aclarray"), schema.getName());
        }

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            s.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        s.setStartWith(Long.toString(res.getLong("seqstart")));
        String dataType = loader.cachedTypesByOid.get(res.getLong("data_type")).getFullName();
        s.setMinMaxInc(res.getLong("seqincrement"), res.getLong("seqmax"),
                res.getLong("seqmin"), dataType, 0L);
        s.setCache(Long.toString(res.getLong("seqcache")));
        s.setCycle(res.getBoolean("seqcycle"));
        s.setDataType(dataType);

        if ("d".equals(identityType) || "a".equals(identityType)) {
            AbstractTable table = schema.getTable(refTable);
            if (table == null) {
                Log.log(Log.LOG_ERROR, "Not found table " + table + " for sequence " + s);
                return;
            }
            PgColumn column = (PgColumn) table.getColumn(refColumn);
            if (column == null) {
                column = new PgColumn(refColumn);
                column.setInherit(true);
                table.addColumn(column);
            }
            column.setSequence(s);
            s.setParent(schema);
            column.setIdentityType("d".equals(identityType) ? "BY DEFAULT" : "ALWAYS") ;
        } else {
            loader.setAuthor(s, res);
            schema.addSequence(s);
        }
    }

    @Override
    protected String getClassId() {
        return "pg_class";
    }
}