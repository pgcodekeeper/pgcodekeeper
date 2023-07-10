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

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsSequence;

public class MsSequencesReader extends JdbcReader {

    public MsSequencesReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        String sequenceName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), sequenceName, DbObjType.SEQUENCE));
        MsSequence s = new MsSequence(sequenceName);

        String dataType = res.getString("data_type");
        int precision = res.getInt("precision");

        s.setDataType(JdbcLoaderBase.getMsType(s, res.getString("type_schema"),
                dataType, res.getBoolean("is_user_defined"), 0, precision, 0, false));

        s.setStartWith(Long.toString(res.getLong("start_value")));
        s.setMinMaxInc(res.getLong("increment"), res.getLong("maximum_value"),
                res.getLong("minimum_value"), dataType, precision);
        s.setCached(res.getBoolean("is_cached"));

        // getInt convert null to 0
        Object cashe = res.getObject("cache_size");
        if (cashe != null) {
            s.setCache(cashe.toString());
        }

        s.setCycle(res.getBoolean("is_cycling"));

        loader.setOwner(s, res.getString("owner"));

        schema.addSequence(s);
        loader.setPrivileges(s, XmlReader.readXML(res.getString("acl")));
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsPriviligesPart(builder);
        addMsOwnerPart(builder);

        builder
        .column("res.name")
        .column("SCHEMA_NAME(t.schema_id) AS type_schema")
        .column("t.name AS data_type")
        .column("t.is_user_defined")
        .column("res.precision")
        .column("CONVERT(bigint, res.start_value) AS start_value")
        .column("CONVERT(bigint, res.increment) AS increment")
        .column("CONVERT(bigint, res.minimum_value) AS minimum_value")
        .column("CONVERT(bigint, res.maximum_value) AS maximum_value")
        .column("res.is_cycling")
        .column("res.is_cached")
        .column("res.cache_size")
        .from("sys.sequences res WITH (NOLOCK)")
        .join("JOIN sys.types t WITH (NOLOCK) ON t.user_type_id = res.user_type_id");
    }

    @Override
    protected String getSchemaColumn() {
        return "res.schema_id";
    }
}