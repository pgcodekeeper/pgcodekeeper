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

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsExpressionAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsColumn;
import ru.taximaxim.codekeeper.core.schema.MsTable;
import ru.taximaxim.codekeeper.core.schema.MsType;

public class MsTablesReader extends JdbcReader {

    public MsTablesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_TABLES, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        loader.monitor.worked(1);
        String tableName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), tableName, DbObjType.TABLE));
        MsTable table = new MsTable(tableName);

        if (res.getBoolean("is_memory_optimized")) {
            table.addOption("MEMORY_OPTIMIZED", "ON");
        }

        if (res.getBoolean("durability")) {
            table.addOption("DURABILITY", res.getString("durability_desc"));
        }

        if (res.getBoolean("data_compression")) {
            table.addOption("DATA_COMPRESSION", res.getString("data_compression_desc"));
        }

        table.setFileStream(res.getString("file_stream"));
        table.setAnsiNulls(res.getBoolean("uses_ansi_nulls"));
        Object isTracked = res.getObject("is_tracked");
        if (isTracked != null) {
            table.setTracked((Boolean)isTracked);
        }

        boolean isTextImage = false;
        for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
            isTextImage = isTextImage || col.getBoolean("ti");
            table.addColumn(getColumn(col, schema, loader, null));
        }

        if (isTextImage) {
            table.setTextImage(res.getString("text_image"));
        }

        String tableSpace = res.getString("space_name");
        if (tableSpace != null) {
            StringBuilder sb = new StringBuilder(MsDiffUtils.quoteName(tableSpace));

            String partCol = res.getString("part_column");
            if (partCol != null) {
                sb.append('(').append(MsDiffUtils.quoteName(partCol)).append(')');
            }

            table.setTablespace(sb.toString());
        }

        loader.setOwner(table, res.getString("owner"));

        schema.addTable(table);
        loader.setPrivileges(table, XmlReader.readXML(res.getString("acl")));
    }

    // 'MsType type' used only for MsTypesReader processing to extract type depcy
    // from column object since it is temporary
    static AbstractColumn getColumn(XmlReader col, AbstractSchema schema,
            JdbcLoaderBase loader, MsType type) {
        MsColumn column = new MsColumn(col.getString("name"));
        String exp = col.getString("def");
        column.setExpression(exp);
        if (exp == null) {
            boolean isUserDefined = col.getBoolean("ud");
            if (!isUserDefined) {
                column.setCollation(col.getString("cn"));
            }

            column.setType(JdbcLoaderBase.getMsType(column, col.getString("st"), col.getString("type"),
                    isUserDefined, col.getInt("size"), col.getInt("pr"), col.getInt("sc")));
            column.setNullValue(col.getBoolean("nl"));
        }

        column.setSparse(col.getBoolean("sp"));
        column.setRowGuidCol(col.getBoolean("rgc"));
        column.setPersisted(col.getBoolean("ps"));

        String maskingFunction = col.getString("mf");
        if (maskingFunction != null) {
            column.setMaskingFunction("'" + maskingFunction + "'");
        }

        if (col.getBoolean("ii")) {
            column.setIdentity(Integer.toString(col.getInt("s")), Integer.toString(col.getInt("i")));
            column.setNotForRep(col.getBoolean("nfr"));
        }

        String def = col.getString("dv");
        if (def != null) {
            column.setDefaultValue(def);
            column.setDefaultName(col.getString("dn"));
            loader.submitMsAntlrTask(def, p -> p.expression_eof().expression().get(0),
                    ctx -> schema.getDatabase().addAnalysisLauncher(
                            new MsExpressionAnalysisLauncher(type == null ? column : type,
                                    ctx, loader.getCurrentLocation())));
        }
        return column;
    }
}
