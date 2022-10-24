package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.CreateIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgIndex;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class IndicesReader extends JdbcReader {

    public IndicesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_INDICES, loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException {
        PgStatementContainer cont = schema.getStatementContainer(result.getString("table_name"));
        if (cont != null) {
            AbstractIndex index = getIndex(result, schema, cont.getName());
            loader.monitor.worked(1);
            cont.addIndex(index);
        }
    }

    private AbstractIndex getIndex(ResultSet res, AbstractSchema schema, String tableName) throws SQLException {
        String schemaName = schema.getName();
        String indexName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, indexName, DbObjType.INDEX));
        PgIndex i = new PgIndex(indexName);

        String tablespace = res.getString("table_space");
        String definition = res.getString("definition");
        checkObjectValidity(definition, DbObjType.INDEX, indexName);
        loader.submitAntlrTask(definition,
                p ->  new Pair<>(p.sql().statement(0).schema_statement().schema_create().create_index_statement().index_rest(),
                        (CommonTokenStream) p.getTokenStream()),
                pair -> CreateIndex.parseIndex(pair.getFirst(), tablespace, schemaName, tableName, i,
                        schema.getDatabase(), loader.getCurrentLocation(), pair.getSecond()));
        loader.setAuthor(i, res);

        i.setClusterIndex(res.getBoolean("isclustered"));
        i.setUnique(res.getBoolean("indisunique"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            i.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        String inhnspname = res.getString("inhnspname");

        if (inhnspname != null) {
            String inhrelname = res.getString("inhrelname");
            i.addInherit(inhnspname, inhrelname);
            i.addDep(new GenericColumn(inhnspname, inhrelname, DbObjType.INDEX));
        }

        return i;
    }

    @Override
    protected String getClassId() {
        return "pg_class";
    }
}