package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgFtsTemplate;

public class FtsTemplatesReader extends JdbcReader {

    public FtsTemplatesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FTS_TEMPLATES, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        PgFtsTemplate template = new PgFtsTemplate(res.getString("tmplname"));

        String init = res.getString("tmplinit");
        if (!"-".equals(init)) {
            setFunctionWithDep(PgFtsTemplate::setInitFunction, template, init);
        }

        setFunctionWithDep(PgFtsTemplate::setLexizeFunction,
                template, res.getString("tmpllexize"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            template.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        loader.setAuthor(template, res);
        schema.addFtsTemplate(template);
    }

    @Override
    protected String getClassId() {
        return "pg_ts_template";
    }
}
