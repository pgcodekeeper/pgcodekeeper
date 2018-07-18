package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.PgFtsTemplate;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FtsTemplatesReader extends JdbcReader {

    public static class FtsTemplatesReaderFactory extends JdbcReaderFactory {

        public FtsTemplatesReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new FtsTemplatesReader(this, loader);
        }
    }

    protected FtsTemplatesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException {
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
