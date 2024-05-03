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
package ru.taximaxim.codekeeper.core.loader.jdbc.ms;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintCheck;

public class MsCheckConstraintsReader extends JdbcReader {

    public MsCheckConstraintsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, DbObjType.CONSTRAINT));

        AbstractTable table = schema.getTable(res.getString("table_name"));
        if (table == null) {
            return;
        }

        var constrCheck = new MsConstraintCheck(name);

        constrCheck.setNotValid(res.getBoolean("with_no_check"));
        constrCheck.setDisabled(res.getBoolean("is_disabled"));
        constrCheck.setNotForRepl(res.getBoolean("is_not_for_replication"));
        constrCheck.setExpression(res.getString("definition"));

        table.addConstraint(constrCheck);
    }

    @Override
    protected String getSchemaColumn() {
        return "so.schema_id";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        builder
        .column("so.name AS table_name")
        .column("res.name")
        .column("res.is_not_for_replication")
        .column("res.is_not_trusted AS with_no_check")
        .column("res.is_disabled")
        .column("res.definition")
        .from("sys.check_constraints res WITH (NOLOCK)")
        .join("INNER JOIN sys.objects so WITH (NOLOCK) ON so.object_id=res.parent_object_id");
    }
}
