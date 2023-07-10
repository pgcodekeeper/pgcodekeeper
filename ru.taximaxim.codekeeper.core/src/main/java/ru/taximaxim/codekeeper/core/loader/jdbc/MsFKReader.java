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
import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsConstraint;

public class MsFKReader extends JdbcReader {

    public MsFKReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema)
            throws SQLException, XmlReaderException {
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, DbObjType.CONSTRAINT));

        MsConstraint con = new MsConstraint(name);

        con.setNotValid(res.getBoolean("with_no_check"));
        con.setDisabled(res.getBoolean("is_disabled"));

        StringBuilder sb = new StringBuilder();

        String fschema = res.getString("referenced_schema_name");
        String ftable = res.getString("referenced_table_name");

        GenericColumn ftableRef = new GenericColumn(fschema, ftable, DbObjType.TABLE);
        con.setForeignTable(ftableRef);
        con.addDep(ftableRef);

        List<String> fields = new ArrayList<>();
        List<String> references = new ArrayList<>();

        for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
            String field = col.getString("f");
            String reference = col.getString("r");

            con.addForeignColumn(reference);
            con.addDep(new GenericColumn(fschema, ftable, reference, DbObjType.COLUMN));

            fields.add(MsDiffUtils.quoteName(field));
            references.add(MsDiffUtils.quoteName(reference));
        }

        sb.append("FOREIGN KEY (");
        sb.append(String.join(", ", fields));
        sb.append(") REFERENCES ");
        sb.append(MsDiffUtils.quoteName(fschema));
        sb.append('.');
        sb.append(MsDiffUtils.quoteName(ftable));
        sb.append(" (");
        sb.append(String.join(", ", references));
        sb.append(")");

        int del = res.getInt("delete_referential_action");
        if (del > 0) {
            sb.append(" ON DELETE ");
            if (del == 1) {
                sb.append("CASCADE");
            } else {
                sb.append("SET ").append(del == 2 ? "NULL" : "DEFAULT");
            }
        }

        int upd = res.getInt("update_referential_action");
        if (upd > 0) {
            sb.append(" ON UPDATE ");
            if (upd == 1) {
                sb.append("CASCADE");
            } else {
                sb.append("SET ").append(upd == 2 ? "NULL" : "DEFAULT");
            }
        }

        if (res.getBoolean("is_not_for_replication")) {
            sb.append(" NOT FOR REPLICATION");
        }

        con.setDefinition(sb.toString());

        schema.getTable(res.getString("table_name")).addConstraint(con);
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsColsPart(builder);

        builder
        .column("fs.name AS table_name")
        .column("res.name")
        .column("SCHEMA_NAME(rs.schema_id) AS referenced_schema_name")
        .column("rs.name AS referenced_table_name")
        .column("res.is_disabled")
        .column("res.is_not_for_replication")
        .column("res.update_referential_action")
        .column("res.is_not_trusted AS with_no_check")
        .column("res.delete_referential_action")
        .from("sys.foreign_keys res WITH (NOLOCK)")
        .join("JOIN sys.objects fs WITH (NOLOCK) ON res.parent_object_id=fs.object_id")
        .join("JOIN sys.objects rs WITH (NOLOCK) ON res.referenced_object_id=rs.object_id");
    }

    protected void addMsColsPart(QueryBuilder builder) {
        String cols = "CROSS APPLY (\n"
                + "  SELECT * FROM (\n"
                + "    SELECT \n"
                + "      sfkc.constraint_column_id AS id,\n"
                + "      fc.name AS f,\n"
                + "      rc.name AS r\n"
                + "    FROM sys.foreign_key_columns AS sfkc WITH (NOLOCK) \n"
                + "    JOIN sys.columns fc WITH (NOLOCK) ON sfkc.parent_column_id=fc.column_id AND fc.object_id=sfkc.parent_object_id\n"
                + "    JOIN sys.columns rc WITH (NOLOCK) ON sfkc.referenced_column_id=rc.column_id AND rc.object_id=sfkc.referenced_object_id\n"
                + "    WHERE res.object_id=sfkc.constraint_object_id\n"
                + "  ) cc ORDER BY cc.id\n"
                + "  FOR XML RAW, ROOT\n"
                + ") aa (cols)";

        builder.column("aa.cols");
        builder.join(cols);
    }

    @Override
    protected String getSchemaColumn() {
        return "fs.schema_id";
    }
}
