package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.SimpleMsTable;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsTablesReader extends JdbcMsReader {


    public static class MsTablesReaderFactory extends JdbcReaderFactory {

        public MsTablesReaderFactory(Map<SupportedVersion, String> queries) {
            super(0, "", queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new MsTablesReader(this, loader);
        }
    }

    public MsTablesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException {
        loader.monitor.worked(1);
        String tableName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), tableName, DbObjType.TABLE));
        SimpleMsTable table = new SimpleMsTable(tableName, "");

        if (!loader.args.isIgnorePrivileges()) {
            String owner = res.getString("owner");
            table.setOwner(owner == null ? ApgdiffConsts.SCHEMA_OWNER : owner);
        }

        if (res.getBoolean("is_memory_optimazed")) {
            table.addOption("MEMORY_OPTIMIZED" , "ON");
        }

        if (res.getBoolean("durability")) {
            table.addOption("DURABILITY", res.getString("durability_desc"));
        }

        table.setTextImage(res.getString("text_image"));
        table.setFileStream(res.getString("file_stream"));
        table.setAnsiNulls(res.getBoolean("user_ansi_nulls"));

        // loader.setPrivileges(s, res.getString("aclarray"));

        // TODO add filegroup/tablespace
        // table.setTablespace(tablespace);

        schema.addTable(table);
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.TABLE;
    }
}
