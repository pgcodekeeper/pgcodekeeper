package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.PgFtsParser;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FtsParsersReader extends JdbcReader {

    public FtsParsersReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FTS_PARSERS_PER_SCHEMA, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException {
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
