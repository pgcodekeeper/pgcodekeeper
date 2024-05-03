/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.loader.jdbc.pg;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.pg.PgFtsParser;

public class FtsParsersReader extends JdbcReader {

    public FtsParsersReader(JdbcLoaderBase loader) {
        super(loader);
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

        loader.setComment(parser, res);
        loader.setAuthor(parser, res);
        schema.addFtsParser(parser);
    }

    @Override
    protected String getClassId() {
        return "pg_ts_parser";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.prsnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addDescriptionPart(builder);
        addExtensionDepsCte(builder);

        builder
        .column("res.prsname")
        .column("res.prsstart")
        .column("res.prstoken")
        .column("res.prsend")
        .column("res.prsheadline")
        .column("res.prslextype")
        .from("pg_catalog.pg_ts_parser res");
    }
}
