/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;

public class ChPrivillegesReader extends AbstractStatementReader {

    private final ChDatabase db;

    public ChPrivillegesReader(JdbcLoaderBase loader, ChDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet result) throws SQLException, XmlReaderException{
        String user = result.getString("user_name");
        String role = result.getString("role_name");
        PgStatement st = user != null ? db.getUser(user) : db.getRole(role);

        String database = getNameOrAsterisk(result.getString("database"));
        String table = getNameOrAsterisk(result.getString("table"));
        String col = result.getString("column");
        String fullName = database + '.' + table;

        String permission = result.getString("access_type");
        String columnStr = col == null ? "" : '(' + col + ')';
        boolean isGrantOption = result.getBoolean("grant_option");

        st.addPrivilege(new PgPrivilege("GRANT", permission + columnStr, fullName,
                user != null ? user : role, isGrantOption, DatabaseType.CH));
    }

    private String getNameOrAsterisk(String name) {
        if (name == null) {
            return "*";
        }

        return ChDiffUtils.getQuotedName(name);
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        builder
        .column("role_name")
        .column("user_name")
        .column("table")
        .column("access_type")
        .column("database")
        .column("column")
        .column("grant_option")
        .from("system.grants")
        .where("user_name != 'default'");
    }
}