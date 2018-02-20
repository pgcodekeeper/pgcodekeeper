package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateIndex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class IndicesReader extends JdbcReader {

    public static class IndicesReaderFactory extends JdbcReaderFactory {

        public IndicesReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new IndicesReader(this, loader);
        }
    }

    private IndicesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSetWrapper result, PgSchema schema) throws WrapperAccessException {
        PgTable table = schema.getTable(result.getString("table_name"));
        if (table != null) {
            PgIndex index = getIndex(result, schema.getName(), table.getName());
            loader.monitor.worked(1);
            table.addIndex(index);
        }
    }

    private PgIndex getIndex(ResultSetWrapper res, String schemaName, String tableName) throws WrapperAccessException {
        String indexName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, indexName, DbObjType.INDEX));
        PgIndex i = new PgIndex(indexName, "");
        i.setTableName(tableName);

        String tablespace = res.getString("table_space");
        loader.submitAntlrTask(res.getString("definition") + ';',
                p -> CreateIndex.parseIndex(p.sql().statement(0).schema_statement()
                        .schema_create().create_index_statement().index_rest(), tablespace,
                        schemaName, i), i::setDefinition);

        i.setClusterIndex(res.getBoolean("isclustered"));
        i.setUnique(res.getBoolean("indisunique"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            i.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        i.addDep(new GenericColumn(schemaName, tableName, DbObjType.TABLE));

        return i;
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.INDEX;
    }
}