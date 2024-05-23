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
package ru.taximaxim.codekeeper.core.loader.jdbc.ch;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch.CreateChFunction;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChFunction;

public class ChFunctionsReader extends AbstractStatementReader {

    private final ChDatabase db;

    public ChFunctionsReader(JdbcLoaderBase loader, ChDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet result) throws SQLException, XmlReaderException {
        String name = result.getString("name");
        loader.setCurrentObject(new GenericColumn(name, DbObjType.FUNCTION));

        ChFunction function = new ChFunction(name);
        String definition = result.getString("create_query");

        loader.submitChAntlrTask(definition,
                p -> p.ch_file().query(0).stmt().ddl_stmt().create_stmt().create_function_stmt(),
                ctx -> new CreateChFunction(ctx, db).parseObject(function));

        db.addFunction(function);
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        builder
        .column("create_query")
        .column("name")
        .from("system.functions")
        .where("origin != 'System'");
    }
}