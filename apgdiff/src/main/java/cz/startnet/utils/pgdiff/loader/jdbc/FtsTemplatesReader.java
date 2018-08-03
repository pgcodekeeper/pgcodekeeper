package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgFtsTemplate;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FtsTemplatesReader extends JdbcReader {

    public FtsTemplatesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FTS_TEMPLATES_PER_SCHEMA, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        PgFtsTemplate template = new PgFtsTemplate(res.getString("tmplname"), "");

        String init = res.getString("tmplinit");
        if (!"-".equals(init)) {
            template.setInitFunction(init);
        }

        template.setLexizeFunction(res.getString("tmpllexize"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            template.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        schema.addFtsTemplate(template);
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.FTS_TEMPLATE;
    }
}
