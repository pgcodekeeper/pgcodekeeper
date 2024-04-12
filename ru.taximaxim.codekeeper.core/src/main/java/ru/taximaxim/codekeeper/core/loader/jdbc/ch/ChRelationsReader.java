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
import java.util.Locale;

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch.CreateChTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch.CreateChView;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChTable;
import ru.taximaxim.codekeeper.core.schema.ch.ChView;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class ChRelationsReader extends JdbcReader {

    public ChRelationsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException, XmlReaderException {
        PgStatement child;
        var engineName = result.getString("engine").toLowerCase(Locale.ROOT);
        if (engineName.contains("dictionary")) {
            return;
        }
        if (engineName.contains("view")) {
            child = getView(result, schema);
        } else {
            child = getTable(result, schema);
        }

        schema.addChild(child);
    }

    private PgStatement getView(ResultSet result, AbstractSchema schema) throws SQLException {
        var viewName = result.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), viewName, DbObjType.VIEW));
        ChView view = new ChView(viewName);
        String definition = result.getString("definition");
        loader.submitChAntlrTask(definition,
                p -> new Pair<>(
                        p.ch_file().query(0).stmt().ddl_stmt().create_stmt().create_view_stmt(),
                        (CommonTokenStream) p.getTokenStream()),
                pair -> new CreateChView(pair.getFirst(), (ChDatabase) schema.getDatabase(), pair.getSecond())
                .parseObject(view));
        return view;
    }

    private PgStatement getTable(ResultSet result, AbstractSchema schema) throws SQLException {
        var tableName = result.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), tableName, DbObjType.TABLE));
        ChTable table = new ChTable(tableName);
        String definition = result.getString("definition");
        loader.submitChAntlrTask(definition,
                p -> p.ch_file().query(0).stmt().ddl_stmt().create_stmt().create_table_stmt(),
                ctx -> new CreateChTable(ctx, (ChDatabase) schema.getDatabase()).parseObject(table));
        return table;
    }

    @Override
    protected String getSchemaColumn() {
        return "res.database";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        builder
        .column("res.name")
        .column("res.create_table_query AS definition")
        .column("res.engine")
        .from("system.tables res")
        .where("notLike(res.name, '.inner_id.%')");
    }
}
