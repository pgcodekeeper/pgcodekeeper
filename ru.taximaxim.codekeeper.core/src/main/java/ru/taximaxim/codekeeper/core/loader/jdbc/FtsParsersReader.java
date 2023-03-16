/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgFtsParser;

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

    @Override
    protected String getClassId() {
        return "pg_ts_parser";
    }
}
