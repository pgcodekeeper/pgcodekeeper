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
package ru.taximaxim.codekeeper.core.loader.jdbc.ms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.loader.ms.SupportedMsVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsExpressionAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ms.GeneratedType;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsTable;
import ru.taximaxim.codekeeper.core.schema.ms.MsType;

public class MsTablesReader extends JdbcReader {

    public MsTablesReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        String tableName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), tableName, DbObjType.TABLE));
        MsTable table = new MsTable(tableName);

        if (SupportedMsVersion.VERSION_14.isLE(loader.getVersion())) {
            if (res.getBoolean("is_memory_optimized")) {
                table.addOption("MEMORY_OPTIMIZED", "ON");
            }

            if (res.getBoolean("durability")) {
                table.addOption("DURABILITY", res.getString("durability_desc"));
            }
        }

        if (res.getBoolean("data_compression")) {
            table.addOption("DATA_COMPRESSION", res.getString("data_compression_desc"));
        }

        if (SupportedMsVersion.VERSION_16.isLE(loader.getVersion()) && res.getBoolean("temporal_type")) {
            appendSystemVersioning(res, table);
        }

        if (SupportedMsVersion.VERSION_22.isLE(loader.getVersion()) && res.getBoolean("xml_compression")) {
            table.addOption("XML_COMPRESSION", "ON");
        }

        table.setFileStream(res.getString("file_stream"));
        table.setAnsiNulls(res.getBoolean("uses_ansi_nulls"));
        Object isTracked = res.getObject("is_tracked");
        if (isTracked != null) {
            table.setTracked((Boolean) isTracked);
        }

        String cols = res.getString("cols");
        List <XmlReader> xmlCols = XmlReader.readXML(cols);
        boolean isTextImage = false;
        for (XmlReader col : xmlCols) {
            isTextImage = isTextImage || col.getBoolean("ti");
            table.addColumn(getColumn(col, schema, loader, null));
        }

        if (SupportedMsVersion.VERSION_16.isLE(loader.getVersion())) {
            String perStartCol = getPeriodColName(res.getInt("start_col_id"), xmlCols);
            if (perStartCol != null) {
                String perEndCol = getPeriodColName(res.getInt("end_col_id"), xmlCols);
                table.setPeriodStartCol(table.getColumn(perStartCol));
                table.setPeriodEndCol(table.getColumn(perEndCol));
            }
        }

        if (isTextImage) {
            table.setTextImage(res.getString("text_image"));
        }

        String tablespace = res.getString("space_name");
        if (tablespace != null) {
            StringBuilder sb = new StringBuilder(MsDiffUtils.quoteName(tablespace));

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

    private String getPeriodColName(int colId, List<XmlReader> xmlCols) {
        if (colId != 0) {
            var periodCol = xmlCols.stream().filter(col -> col.getInt("id") == colId).findAny().orElse(null);
            if (periodCol != null) {
                return periodCol.getString("name");
            }
        }
        return null;
    }

    private void appendSystemVersioning(ResultSet res, MsTable table) throws SQLException {
        var histSchemaName = res.getString("hist_schema");
        if (histSchemaName == null) {
            return;
        }

        var histTableName = res.getString("hist_table");
        var sysVersioning = new StringBuilder("ON");
        sysVersioning.append(" (HISTORY_TABLE = ").append(MsDiffUtils.quoteName(histSchemaName)).append('.')
                .append(MsDiffUtils.quoteName(histTableName));

        if (SupportedMsVersion.VERSION_17.isLE(loader.getVersion())) {
            var histRetPeriod = res.getString("history_retention_period_unit_desc");
            if (null != histRetPeriod && !Objects.equals("INFINITE", histRetPeriod)) {
                sysVersioning.append(", HISTORY_RETENTION_PERIOD = ").append(res.getInt("history_retention_period"))
                .append(' ').append(histRetPeriod);
            }
        }
        sysVersioning.append(')');
        table.setSysVersioning(sysVersioning.toString());
        table.addDep(new GenericColumn(histSchemaName, histTableName, DbObjType.TABLE));
    }

    // 'MsType type' used only for MsTypesReader processing to extract type depcy
    // from column object since it is temporary
    static AbstractColumn getColumn(XmlReader col, AbstractSchema schema, JdbcLoaderBase loader, MsType type) {
        MsColumn column = new MsColumn(col.getString("name"));
        String exp = col.getString("def");
        if (exp == null) {
            boolean isUserDefined = col.getBoolean("ud");
            if (!isUserDefined) {
                column.setCollation(col.getString("cn"));
            }

            column.setType(JdbcLoaderBase.getMsType(column, col.getString("st"), col.getString("type"),
                    isUserDefined, col.getInt("size"), col.getInt("pr"), col.getInt("sc")));
            column.setNullValue(col.getBoolean("nl"));
        } else {
            column.setExpression(exp);
            loader.submitMsAntlrTask(exp, p -> p.expression_eof().expression().get(0),
                    ctx -> schema.getDatabase().addAnalysisLauncher(
                            new MsExpressionAnalysisLauncher(column, ctx, loader.getCurrentLocation())));
        }

        column.setSparse(col.getBoolean("sp"));
        column.setRowGuidCol(col.getBoolean("rgc"));
        column.setPersisted(col.getBoolean("ps"));

        if (SupportedMsVersion.VERSION_16.isLE(loader.getVersion())) {
            String maskingFunction = col.getString("mf");
            if (maskingFunction != null) {
                column.setMaskingFunction("'" + maskingFunction + "'");
            }
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

        if (SupportedMsVersion.VERSION_16.isLE(loader.getVersion())) {
            int colGenerated = col.getInt("gen");
            if (colGenerated != 0) {
                column.setGenerated(GeneratedType.parseDbType(colGenerated));
                column.setHidden(col.getBoolean("hd"));
            }
        }

        return column;
    }

    @Override
    protected String getSchemaColumn() {
        return "res.schema_id";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsPriviligesPart(builder);
        addMsColumnsPart(builder);
        addMsTablespacePart(builder);
        addMsOwnerPart(builder);

        builder
        .column("res.name")
        .column("c.name AS part_column")
        .column("ds.name AS file_stream")
        .column("dsx.name AS text_image")
        .column("res.uses_ansi_nulls")
        .column("sp.data_compression")
        .column("sp.data_compression_desc")
        .column("ctt.is_track_columns_updated_on AS is_tracked")
        .from("sys.tables res WITH (NOLOCK)")
        .join("JOIN sys.indexes ind WITH (NOLOCK) on ind.object_id = res.object_id")
        .join("JOIN sys.partitions sp WITH (NOLOCK) ON sp.object_id = res.object_id AND ind.index_id = sp.index_id AND sp.index_id IN (0,1) AND sp.partition_number = 1")
        .join("LEFT JOIN sys.data_spaces ds WITH (NOLOCK) ON res.filestream_data_space_id = ds.data_space_id")
        .join("LEFT JOIN sys.data_spaces dsx WITH (NOLOCK) ON dsx.data_space_id=res.lob_data_space_id")
        .join("LEFT JOIN sys.index_columns ic WITH (NOLOCK) ON ic.partition_ordinal > 0 AND ic.index_id = ind.index_id and ic.object_id = res.object_id")
        .join("LEFT JOIN sys.columns c WITH (NOLOCK) ON c.object_id = ic.object_id AND c.column_id = ic.column_id")
        .join("LEFT JOIN sys.change_tracking_tables ctt WITH (NOLOCK) ON ctt.object_id = res.object_id")
        .where("res.type = 'U'");

        if (SupportedMsVersion.VERSION_14.isLE(loader.getVersion())) {
            builder
            .column("res.is_memory_optimized")
            .column("res.durability")
            .column("res.durability_desc");
        }

        if (SupportedMsVersion.VERSION_16.isLE(loader.getVersion())) {
            builder
            .column("per.start_column_id AS start_col_id")
            .column("per.end_column_id AS end_col_id")
            .column("SCHEMA_NAME(hist.schema_id) as hist_schema")
            .column("hist.name as hist_table")
            .column("res.temporal_type")
            .join("LEFT JOIN sys.periods per WITH (NOLOCK) ON per.object_id = res.object_id")
            .join("LEFT JOIN sys.objects hist WITH (NOLOCK) ON hist.object_id = res.history_table_id");
        }

        if (SupportedMsVersion.VERSION_17.isLE(loader.getVersion())) {
            builder
            .column("res.history_retention_period_unit_desc")
            .column("res.history_retention_period");
        }

        if (SupportedMsVersion.VERSION_22.isLE(loader.getVersion())) {
            builder.column("sp.xml_compression");
        }
    }

    private void addMsColumnsPart(QueryBuilder builder) {
        QueryBuilder subSelect = new QueryBuilder()
                .column("c.name")
                .column("c.column_id AS id")
                .column("SCHEMA_NAME(t.schema_id) AS st")
                .column("t.name AS type")
                .column("CASE WHEN c.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN c.max_length/2 ELSE c.max_length END AS size")
                .column("c.precision AS pr")
                .column("c.scale AS sc")
                .column("c.is_sparse AS sp")
                .column("c.collation_name AS cn")
                .column("object_definition(c.default_object_id) AS dv")
                .column("dc.name AS dn")
                .column("c.is_nullable AS nl")
                .column("c.is_identity AS ii")
                .column("ic.seed_value AS s")
                .column("ic.increment_value AS i")
                .column("ic.is_not_for_replication AS nfr")
                .column("c.is_rowguidcol AS rgc")
                .column("cc.is_persisted AS ps")
                .column("t.is_user_defined AS ud")
                .column("""
                        CASE WHEN t.name IN ('GEOMETRY', 'GEOGRAPHY')
                          OR TYPE_NAME(t.system_type_id) IN ('TEXT', 'NTEXT','IMAGE' ,'XML')
                          OR (TYPE_NAME(t.system_type_id) IN ('VARCHAR', 'NVARCHAR', 'VARBINARY') AND c.max_length = -1)
                        THEN 1 ELSE 0 END AS ti""")
                .column("cc.definition AS def")
                .from("sys.columns c WITH (NOLOCK)")
                .join("JOIN sys.types t WITH (NOLOCK) ON c.user_type_id = t.user_type_id")
                .join("LEFT JOIN sys.computed_columns cc WITH (NOLOCK) ON cc.object_id = c.object_id AND c.column_id = cc.column_id")
                .join("LEFT JOIN sys.identity_columns ic WITH (NOLOCK) ON c.object_id = ic.object_id AND c.column_id = ic.column_id")
                .join("LEFT JOIN sys.default_constraints dc WITH (NOLOCK) ON dc.parent_object_id = c.object_id AND c.column_id = dc.parent_column_id")
                .join("LEFT JOIN sys.objects so WITH (NOLOCK) ON so.object_id = c.object_id")
                .where("c.object_id = res.object_id");

        if (SupportedMsVersion.VERSION_16.isLE(loader.getVersion())) {
            subSelect
            .column("c.is_hidden AS hd")
            .column("c.generated_always_type AS gen")
            .column("mc.masking_function AS mf")
            .join("LEFT JOIN sys.masked_columns mc WITH (NOLOCK) ON mc.object_id = c.object_id AND c.column_id = mc.column_id");
        }

        QueryBuilder cols = new QueryBuilder()
                .column("*")
                .from(subSelect, "cc ORDER BY cc.id")
                .postAction("FOR XML RAW, ROOT");

        builder
        .column("cc.cols")
        .join("CROSS APPLY", cols, "cc (cols)");
    }

    private void addMsTablespacePart(QueryBuilder builder) {
        QueryBuilder cols = new QueryBuilder()
                .column("TOP 1 dsp.name")
                .from("sys.indexes ind WITH (NOLOCK)")
                .join("LEFT JOIN sys.data_spaces dsp WITH (NOLOCK) on dsp.data_space_id = ind.data_space_id")
                .where("ind.object_id = res.object_id");

        builder.column("tt.name AS space_name");
        builder.join("CROSS APPLY", cols, "tt");
    }
}
