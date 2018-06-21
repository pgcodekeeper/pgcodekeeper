package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.PgFtsParser;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FtsParsersReader extends JdbcReader {

    public static class FtsParsersReaderFactory extends JdbcReaderFactory {

        public FtsParsersReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new FtsParsersReader(this, loader);
        }
    }

    protected FtsParsersReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSetWrapper res, PgSchema schema)
            throws SQLException, WrapperAccessException {
        PgFtsParser parser = new PgFtsParser(res.getString("prsname"), "");

        parser.setStartFunction(res.getString("prsstart"));
        parser.setGetTokenFunction(res.getString("prstoken"));
        parser.setEndFunction(res.getString("prsend"));
        parser.setLexTypesFunction(res.getString("prslextype"));

        String headline = res.getString("prsheadline");
        if (!"-".equals(headline)) {
            parser.setHeadLineFunction(headline);
        }

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            parser.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        schema.addFtsParser(parser);
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.FTS_PARSER;
    }
}
