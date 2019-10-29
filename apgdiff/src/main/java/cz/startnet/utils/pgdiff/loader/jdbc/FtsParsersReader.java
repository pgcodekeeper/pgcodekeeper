package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgFtsParser;

public class FtsParsersReader extends JdbcReader {

    public FtsParsersReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FTS_PARSERS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        PgFtsParser parser = new PgFtsParser(res.getString("prsname"));

        setFunctionWithDep(PgFtsParser::setStartFunction, parser, res.getString("prsstart"));
        setFunctionWithDep(PgFtsParser::setGetTokenFunction, parser, res.getString("prstoken"));
        setFunctionWithDep(PgFtsParser::setEndFunction, parser, res.getString("prsend"));
        setFunctionWithDep(PgFtsParser::setLexTypesFunction, parser, res.getString("prslextype"));

        String headline = res.getString("prsheadline");
        if (!"-".equals(headline)) {
            setFunctionWithDep(PgFtsParser::setHeadLineFunction, parser, headline);
        }

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            parser.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        loader.setAuthor(parser, res);
        schema.addFtsParser(parser);
    }
}
