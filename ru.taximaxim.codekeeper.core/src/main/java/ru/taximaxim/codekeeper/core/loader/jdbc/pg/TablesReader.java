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
import java.util.Arrays;

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcType;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterTable;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ICompressOptionContainer;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractRegularTable;
import ru.taximaxim.codekeeper.core.schema.pg.GpExternalTable;
import ru.taximaxim.codekeeper.core.schema.pg.PartitionForeignPgTable;
import ru.taximaxim.codekeeper.core.schema.pg.PartitionGpTable;
import ru.taximaxim.codekeeper.core.schema.pg.PartitionPgTable;
import ru.taximaxim.codekeeper.core.schema.pg.PgColumn;
import ru.taximaxim.codekeeper.core.schema.pg.SimpleForeignPgTable;
import ru.taximaxim.codekeeper.core.schema.pg.SimplePgTable;
import ru.taximaxim.codekeeper.core.schema.pg.TypedPgTable;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class TablesReader extends JdbcReader {

    private static final String CREATE_TABLE = "CREATE TABLE noname () ";

    public TablesReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String tableName = res.getString("relname");
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, DbObjType.TABLE));
        String partitionBound = null;
        String partitionGpBound = null;
        String partitionGpTemplate = null;

        if (SupportedVersion.VERSION_10.isLE(loader.getVersion()) &&
                res.getBoolean("relispartition")) {
            partitionBound = res.getString("partition_bound");
            checkObjectValidity(partitionBound, DbObjType.TABLE, tableName);
        }
        if (loader.isGreenplumDb()) {
            partitionGpBound = res.getString("partclause");
            partitionGpTemplate = res.getString("parttemplate");
        }

        AbstractPgTable t;
        String serverName = res.getString("server_name");
        long ofTypeOid = res.getLong("of_type");
        if (serverName != null) {
            if (partitionBound == null) {
                t = new SimpleForeignPgTable(tableName, serverName);
            } else {
                t = new PartitionForeignPgTable(tableName, serverName, partitionBound);
            }
            t.addDep(new GenericColumn(serverName, DbObjType.SERVER));
        } else if (ofTypeOid != 0) {
            JdbcType jdbcOfType = loader.getCachedTypeByOid(ofTypeOid);
            String ofType = jdbcOfType.getFullName();
            t = new TypedPgTable(tableName, ofType);
            jdbcOfType.addTypeDepcy(t);
        } else if (partitionBound != null) {
            t = new PartitionPgTable(tableName, partitionBound);
        } else if (partitionGpBound != null) {
            t = createGpParttionTable(tableName, partitionGpBound, partitionGpTemplate);
        } else if (loader.isGreenplumDb() && res.getString("exloc") != null) {
            t = new GpExternalTable(tableName);
            readExternalTable((GpExternalTable) t, res);
        } else {
            t = new SimplePgTable(tableName);
        }

        if (SupportedVersion.VERSION_12.isLE(loader.getVersion())) {
            String accessMethod = res.getString("access_method");
            if (accessMethod != null) {
                t.setMethod(accessMethod);
            }
        }

        String[] foptions = getColArray(res, "ftoptions");
        if (foptions != null) {
            ParserAbstract.fillOptionParams(foptions, t::addOption, false, true, false);
        }

        // PRIVILEGES, OWNER
        loader.setOwner(t, res.getLong("relowner"));
        loader.setPrivileges(t, res.getString("aclarray"), schemaName);
        loader.setAuthor(t, res);
        loader.setComment(t, res);

        readColumns(res, t, ofTypeOid, schema);

        // INHERITS
        String[] inhrelnames = getColArray(res, "inhrelnames");
        if (inhrelnames != null) {
            String[] inhnspnames = getColArray(res, "inhnspnames");

            for (int i = 0; i < inhrelnames.length; ++i) {
                t.addInherits(inhnspnames[i], inhrelnames[i]);
                addDep(t, inhnspnames[i], inhrelnames[i], DbObjType.TABLE);
            }
        }

        // STORAGE PARAMETERS
        String [] opts = getColArray(res, "reloptions");
        if (opts != null) {
            ParserAbstract.fillOptionParams(opts, t::addOption, false, false, false);
        }

        String[] toast = getColArray(res, "toast_reloptions");
        if (toast != null) {
            ParserAbstract.fillOptionParams(toast, t::addOption, true, false, false);
        }

        if (!SupportedVersion.VERSION_12.isLE(loader.getVersion()) && res.getBoolean("has_oids")) {
            t.setHasOids(true);
        }

        if (t instanceof AbstractRegularTable) {
            fillRegularTable(t, res);
        }

        schema.addTable(t);
    }

    private AbstractPgTable createGpParttionTable(String tableName, String partitionGpBound,
            String partitionGpTemplate) {
        PartitionGpTable table = new PartitionGpTable(tableName);
        var partGp = partitionGpBound;

        loader.submitAntlrTask(CREATE_TABLE + partitionGpBound + ';',
                p -> new Pair<>(
                        p.sql().statement(0).schema_statement().schema_create().create_table_statement().partition_gp(),
                        (CommonTokenStream) p.getTokenStream()),
                pair -> table.setPartitionGpBound(partGp,
                        AntlrUtils.normalizeWhitespaceUnquoted(pair.getFirst(), pair.getSecond())));

        if (partitionGpTemplate != null && !partitionGpTemplate.isEmpty()) {
            for (String template : partitionGpTemplate.split(";")) {
                loader.submitAntlrTask(template + ';',
                        p -> new Pair<>(
                                p.sql().statement(0).schema_statement().schema_alter().alter_table_statement()
                                .alter_partition_gp(),
                                (CommonTokenStream) p.getTokenStream()),
                        pair -> AlterTable.parseGpPartitionTemplate(table, pair.getFirst(), pair.getSecond()));
            }
        }

        return table;
    }

    private void fillRegularTable(AbstractPgTable t, ResultSet res) throws SQLException {
        AbstractRegularTable regTable = (AbstractRegularTable) t;

        // TableSpace
        String tableSpace = res.getString("table_space");
        if (tableSpace != null && !tableSpace.isEmpty()) {
            regTable.setTablespace(tableSpace);
        }

        if (loader.isGreenplumDb()) {
            String distribution = res.getString("distribution");
            if (distribution != null && !distribution.isBlank()) {
                regTable.setDistribution(distribution);
            }
        }

        // since 9.5 PostgreSQL
        if (SupportedVersion.VERSION_9_5.isLE(loader.getVersion())) {
            regTable.setRowSecurity(res.getBoolean("row_security"));
            regTable.setForceSecurity(res.getBoolean("force_security"));
        }

        // since 10 PostgreSQL
        if (SupportedVersion.VERSION_10.isLE(loader.getVersion()) &&
                "p".equals(res.getString("relkind"))) {
            String partitionBy = res.getString("partition_by");
            checkObjectValidity(partitionBy, DbObjType.TABLE, t.getBareName());
            regTable.setPartitionBy(partitionBy);
        }

        // persistence: U - unlogged, P - permanent, T - temporary
        if ("u".equals(res.getString("persistence"))) {
            regTable.setLogged(false);
        }
    }

    private void readColumns(ResultSet res, AbstractPgTable t, long ofTypeOid,
            AbstractSchema schema) throws SQLException {
        String[] colNames = getColArray(res, "col_names");
        if (colNames == null) {
            return;
        }

        Long[] colTypeIds = getColArray(res, "col_type_ids");
        String[] colTypeName = getColArray(res, "col_type_name");
        Boolean[] colHasDefault = getColArray(res, "col_has_default");
        String[] colDefaults = getColArray(res, "col_defaults");
        String[] colComments = getColArray(res, "col_comments");
        Boolean[] colNotNull = getColArray(res, "col_notnull");

        Integer[] colStatictics;
        if (SupportedVersion.VERSION_16.isLE(loader.getVersion())) {
            // in PG 16 type changed from int4 to int2
            Short[] tmpStatictics = getColArray(res, "col_statictics");
            colStatictics = Arrays.stream(tmpStatictics).map(e -> (int) e).toArray(Integer[]::new);
        } else {
            colStatictics = getColArray(res, "col_statictics");
        }

        Boolean[] colIsLocal = getColArray(res, "col_local");
        Long[] colCollation = getColArray(res, "col_collation");
        Long[] colTypCollation = getColArray(res, "col_typcollation");
        String[] colCollationName = getColArray(res, "col_collationname");
        String[] colCollationSchema = getColArray(res, "col_collationnspname");
        String[] colAcl = getColArray(res, "col_acl");
        String[] colOptions = getColArray(res, "col_options");
        String[] colFOptions = getColArray(res, "col_foptions");
        String[] colStorages = getColArray(res, "col_storages");
        String[] colDefaultStorages = getColArray(res, "col_default_storages");

        String[] colGenerated = null;
        if (SupportedVersion.VERSION_12.isLE(loader.getVersion())) {
            colGenerated = getColArray(res, "col_generated");
        }
        String[] colCompression = null;
        if (SupportedVersion.VERSION_14.isLE(loader.getVersion())) {
            colCompression = getColArray(res, "col_compression");
        }
        String[] colEncOptions = null;
        if (loader.isGreenplumDb()) {
            colEncOptions = getColArray(res, "col_enc_options");
        }

        for (int i = 0; i < colNames.length; i++) {
            PgColumn column = new PgColumn(colNames[i]);
            column.setInherit(!colIsLocal[i]);

            if (ofTypeOid == 0 && !column.isInherit()) {
                String type = colTypeName[i];
                checkTypeValidity(type);
                column.setType(type);
            }

            loader.getCachedTypeByOid(colTypeIds[i]).addTypeDepcy(column);

            if (colOptions[i] != null) {
                ParserAbstract.fillOptionParams(colOptions[i].split(","), column::addOption, false, false, false);
            }
            if (colFOptions[i] != null) {
                ParserAbstract.fillOptionParams(colFOptions[i].split(","), column::addForeignOption, false, true, false);
            }
            if (loader.isGreenplumDb() && colEncOptions[i] != null) {
                ICompressOptionContainer.fillCompressOptions(column, colEncOptions[i]);
            }

            if (!colStorages[i].equals(colDefaultStorages[i])) {
                switch(colStorages[i]) {
                case "x":
                    column.setStorage("EXTENDED");
                    break;
                case "m":
                    column.setStorage("MAIN");
                    break;
                case "e":
                    column.setStorage("EXTERNAL");
                    break;
                case "p":
                    column.setStorage("PLAIN");
                    break;
                default:
                    break;
                }
            }

            // unbox
            long collation = colCollation[i];
            if (collation != 0 && collation != colTypCollation[i] && column.getType() != null) {
                String collationSchema = colCollationSchema[i];
                String collationName = colCollationName[i];
                column.setCollation(PgDiffUtils.getQuotedName(collationSchema) + '.' +
                        PgDiffUtils.getQuotedName(collationName));
                addDep(column, collationSchema, collationName, DbObjType.COLLATION);
            }

            if (colHasDefault[i]) {
                String columnDefault = colDefaults[i];
                checkObjectValidity(columnDefault, DbObjType.COLUMN, colNames[i]);
                if (!columnDefault.isEmpty()) {
                    column.setDefaultValue(columnDefault);
                    loader.submitAntlrTask(columnDefault, p -> p.vex_eof().vex().get(0),
                            ctx -> schema.getDatabase().addAnalysisLauncher(
                                    new VexAnalysisLauncher(column, ctx, loader.getCurrentLocation())));
                }
            }

            if (colNotNull[i]) {
                column.setNullValue(false);
            }

            int statistics = colStatictics[i];
            // if the attstattarget entry for this column is
            // non-negative (i.e. it's not the default value)
            if (statistics > -1) {
                column.setStatistics(statistics);
            }

            if (colGenerated != null && "s".equals(colGenerated[i])) {
                column.setGenerated(true);
            }

            if (colCompression != null && !colCompression[i].isEmpty()) {
                switch (colCompression[i]) {
                case "p":
                    column.setCompression("pglz");
                    break;
                case "l":
                    column.setCompression("lz4");
                    break;
                }
            }

            String comment = colComments[i];
            if (comment != null && !comment.isEmpty()) {
                column.setComment(loader.getArgs(), PgDiffUtils.quoteString(comment));
            }

            // COLUMNS PRIVILEGES
            String columnPrivileges = colAcl[i];
            if (columnPrivileges != null && !columnPrivileges.isEmpty()) {
                loader.setPrivileges(column, t, columnPrivileges, schema.getName());
            }

            if (ofTypeOid != 0 && column.getNullValue()
                    && column.getDefaultValue() == null) {
                column.setInherit(true);
            }

            if (ofTypeOid != 0 || column.isInherit()) {
                boolean isNotDumpable = column.getDefaultValue() == null
                        && column.getNullValue()
                        && column.getStatistics() == null
                        && column.getCollation() == null
                        && column.getComment() == null
                        && column.getStorage() == null
                        && column.getForeignOptions().isEmpty()
                        && column.getOptions().isEmpty();
                if (!isNotDumpable) {
                    t.addColumn(column);
                }

            } else {
                t.addColumn(column);
            }
        }
    }

    private void readExternalTable(GpExternalTable extTable, ResultSet res) throws SQLException {
        String rowUrLoc = res.getString("urloc");
        if (rowUrLoc != null) {
            if (rowUrLoc.startsWith("{http")) {
                extTable.setWeb(true);
            }

            for (String urLocation : PgDiffUtils.unquoteQuotedString(rowUrLoc, 1).split(",")) {
                extTable.addUrLocation(PgDiffUtils.quoteString(urLocation));
            }
        }

        String exLoc = PgDiffUtils.unquoteQuotedName(res.getString("exloc"));
        if (exLoc.startsWith("HOST:")) {
            extTable.setExLocation("ON HOST " + PgDiffUtils.quoteString(exLoc.substring("ON HOST:".length())));
        } else if (exLoc.startsWith("PER_HOST")) {
            extTable.setExLocation("ON HOST");
        } else if (exLoc.startsWith("MASTER_ONLY")) {
            extTable.setExLocation("ON MASTER");
        } else if (exLoc.startsWith("COORDINATOR_ONLY")) {
            extTable.setExLocation("ON COORDINATOR");
        } else if (exLoc.startsWith("SEGMENT_ID:")) {
            extTable.setExLocation("ON SEGMENT " + exLoc.substring("SEGMENT_ID:".length()));
        } else if (exLoc.startsWith("TOTAL_SEGS:")) {
            extTable.setExLocation("ON " + exLoc.substring("TOTAL_SEGS:".length()));
        }

        String command = res.getString("command");
        if (command != null && !command.isBlank()) {
            extTable.setWeb(true);
            extTable.setCommand(PgDiffUtils.quoteString(command));
        }

        switch (res.getString("fmttype")) {
        case "t":
            extTable.setFormatType("'TEXT'");
            break;
        case "b":
            extTable.setFormatType("'CUSTOM'");
            break;
        default:
            extTable.setFormatType("'CSV'");
            break;
        }

        String options = PgDiffUtils.unquoteQuotedString(res.getString("options"), 1);
        if (!options.isBlank()) {
            ParserAbstract.fillOptionParams(options.split(","), extTable::addOption, false, true, false);
        }

        extTable.setFormatOptions(appendFormatOptions(res));

        extTable.setRejectLimit(res.getInt("rejlim"));
        extTable.setIsLogErrors(res.getBoolean("logerrors"));
        extTable.setRowReject(!"p".equals(res.getString("rejtyp")));
        extTable.setEncoding(PgDiffUtils.quoteString(res.getString("enc")));
        extTable.setWritable(res.getBoolean("writable"));

        String distribution = res.getString("distribution");
        if (distribution != null && !distribution.isBlank()) {
            extTable.setDistribution(distribution);
        }
    }

    private String appendFormatOptions(ResultSet res) throws SQLException {
        String formatOptions = res.getString("fmtopts");
        if (formatOptions.contains("formatter")) {
            return formatOptions.trim().replace(" ", "=");
        }
        return formatOptions;
    }

    @Override
    protected String getClassId() {
        return "pg_class";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.relnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addSysSchemasCte(builder);
        addExtensionDepsCte(builder);
        addDescriptionPart(builder, true);
        addColumnsPart(builder);
        addParentsPart(builder);

        builder
        .with("nspnames", "SELECT n.oid, n.nspname FROM pg_catalog.pg_namespace n")
        .with("collations",
                "SELECT c.oid, c.collname, n.nspname FROM pg_catalog.pg_collation c LEFT JOIN nspnames n ON n.oid = c.collnamespace")
        .column("res.relname")
        .column("res.relkind")
        .column("res.relowner::bigint")
        .column("res.relacl::text AS aclarray")
        .column("res.relpersistence AS persistence")
        .column("res.reloptions")
        .column("tc.reloptions AS toast_reloptions")
        .column("tabsp.spcname AS table_space")
        .column("am.amname AS access_method")
        .column("ftbl.ftoptions")
        .column("ser.srvname AS server_name")
        .column("res.reloftype::bigint AS of_type")
        .from("pg_catalog.pg_class res")
        .join("LEFT JOIN pg_catalog.pg_foreign_table ftbl ON ftbl.ftrelid = res.oid")
        .join("LEFT JOIN pg_catalog.pg_foreign_server ser ON ser.oid = ftbl.ftserver")
        .join("LEFT JOIN pg_catalog.pg_tablespace tabsp ON tabsp.oid = res.reltablespace")
        .join("LEFT JOIN pg_catalog.pg_class tc ON tc.oid = res.reltoastrelid")
        .join("LEFT JOIN pg_catalog.pg_am am ON am.oid = res.relam")
        .where("res.relkind IN ('f','r','p')");

        if (SupportedVersion.VERSION_9_5.isLE(loader.getVersion())) {
            builder
            .column("res.relrowsecurity AS row_security")
            .column("res.relforcerowsecurity AS force_security");
        }

        if (SupportedVersion.VERSION_10.isLE(loader.getVersion())) {
            builder
            .column("res.relispartition")
            .column("pg_catalog.pg_get_partkeydef(res.oid) AS partition_by")
            .column("pg_catalog.pg_get_expr(res.relpartbound, res.oid) AS partition_bound");
        }

        if (!SupportedVersion.VERSION_12.isLE(loader.getVersion())) {
            builder.column("res.relhasoids AS has_oids");
        }

        if (loader.isGreenplumDb()) {
            builder
            .column("pg_get_table_distributedby(res.oid) AS distribution")
            .column("x.urilocation AS urloc")
            .column("x.execlocation AS exloc")
            .column("x.fmttype")
            .column("x.fmtopts")
            .column("x.command")
            .column("x.rejectlimit AS rejlim")
            .column("x.rejectlimittype AS rejtyp")
            .column("x.logerrors")
            .column("x.options")
            .column("pg_catalog.pg_encoding_to_char(x.encoding) AS enc")
            .column("x.writable")
            .column("ps.tablename as parent_table")
            .column("CASE WHEN pl.parlevel = 0 THEN (SELECT pg_get_partition_def(res.oid, true, false)) END AS partclause")
            .column("CASE WHEN pl.parlevel = 0 THEN (SELECT pg_get_partition_template_def(res.oid, true, false)) END as parttemplate")
            .join("LEFT JOIN pg_exttable x ON res.oid = x.reloid")
            .join("LEFT JOIN pg_partitions ps on (res.relname = ps.partitiontablename)")
            .join("LEFT JOIN pg_partition_rule pr ON res.oid = pr.parchildrelid")
            .join("LEFT JOIN pg_partition p ON pr.paroid = p.oid")
            .join("LEFT JOIN pg_partition pl ON (res.oid = pl.parrelid AND pl.parlevel = 0)")
            .where("ps.tablename IS NULL");
        }
    }

    private void addColumnsPart(QueryBuilder builder) {
        QueryBuilder subQueryBuilder = new QueryBuilder();
        subQueryBuilder
        .column("a.attrelid")
        .column("pg_catalog.array_agg(a.attname ORDER BY a.attnum) AS col_names")
        .column("pg_catalog.array_agg(pg_catalog.array_to_string(a.attoptions, ',') ORDER BY a.attnum) AS col_options")
        .column("pg_catalog.array_agg(pg_catalog.array_to_string(a.attfdwoptions, ',') ORDER BY a.attnum) AS col_foptions")
        .column("pg_catalog.array_agg(a.attstorage ORDER BY a.attnum) AS col_storages")
        .column("pg_catalog.array_agg(t.typstorage ORDER BY a.attnum) AS col_default_storages")
        .column("pg_catalog.array_agg(a.atthasdef ORDER BY a.attnum) AS col_has_default")
        .column("pg_catalog.array_agg(pg_catalog.pg_get_expr(attrdef.adbin, attrdef.adrelid) ORDER BY a.attnum) AS col_defaults")
        .column("pg_catalog.array_agg(d.description ORDER BY a.attnum) AS col_comments")
        .column("pg_catalog.array_agg(a.atttypid::bigint ORDER BY a.attnum) AS col_type_ids")
        .column("pg_catalog.array_agg(pg_catalog.format_type(a.atttypid, a.atttypmod) ORDER BY a.attnum) AS col_type_name")
        // skips not null for column, if parents have not null
        .column("pg_catalog.array_agg(\n"
                + "      (CASE WHEN a.attnotnull THEN \n"
                + "        NOT EXISTS (\n"
                + "          SELECT 1 FROM pg_catalog.pg_inherits inh \n"
                + "          LEFT JOIN pg_catalog.pg_attribute attr ON attr.attrelid = inh.inhparent\n"
                + "          WHERE inh.inhrelid = a.attrelid \n"
                + "          AND attr.attnotnull\n"
                + "          AND attr.attname = a.attname)\n"
                + "        ELSE FALSE\n"
                + "        END\n"
                + "      ) ORDER BY a.attnum\n"
                + "    ) AS col_notnull")
        .column("pg_catalog.array_agg(a.attstattarget ORDER BY a.attnum) AS col_statictics")
        .column("pg_catalog.array_agg(a.attislocal ORDER BY a.attnum) AS col_local")
        .column("pg_catalog.array_agg(a.attacl::text ORDER BY a.attnum) AS col_acl")
        .column("pg_catalog.array_agg(a.attcollation::bigint ORDER BY a.attnum) AS col_collation")
        .column("pg_catalog.array_agg(t.typcollation::bigint ORDER BY a.attnum) AS col_typcollation")
        .column("pg_catalog.array_agg(cl.collname ORDER BY a.attnum) AS col_collationname")
        .column("pg_catalog.array_agg(cl.nspname ORDER BY a.attnum) AS col_collationnspname")
        .from("pg_catalog.pg_attribute a")
        .join("LEFT JOIN pg_catalog.pg_attrdef attrdef ON attrdef.adnum = a.attnum AND a.attrelid = attrdef.adrelid")
        .join("LEFT JOIN pg_catalog.pg_description d ON d.objoid = a.attrelid AND d.objsubid = a.attnum AND d.classoid = 'pg_catalog.pg_class'::pg_catalog.regclass")
        .join("LEFT JOIN pg_catalog.pg_type t ON t.oid = a.atttypid")
        .join("LEFT JOIN collations cl ON cl.oid =  a.attcollation")
        .where("a.attisdropped IS FALSE")
        .where("a.attnum > 0 GROUP BY a.attrelid")
        ;

        if (SupportedVersion.VERSION_12.isLE(loader.getVersion())) {
            builder.column("columns.col_generated");
            subQueryBuilder.column("pg_catalog.array_agg(a.attgenerated ORDER BY a.attnum) AS col_generated");
        }

        if (SupportedVersion.VERSION_14.isLE(loader.getVersion())) {
            builder.column("columns.col_compression");
            subQueryBuilder.column("pg_catalog.array_agg(a.attcompression ORDER BY a.attnum) AS col_compression");
        }

        if (loader.isGreenplumDb()) {
            builder.column("columns.col_enc_options");
            subQueryBuilder
            .column("pg_catalog.array_agg(pg_catalog.array_to_string(enc_a.attoptions, ',') ORDER BY a.attnum) AS col_enc_options")
            .join("LEFT JOIN pg_attribute_encoding enc_a ON enc_a.attnum = a.attnum AND a.attrelid = enc_a.attrelid");
        }

        String columns = "LEFT JOIN (\n" + subQueryBuilder.build() + "\n) columns ON columns.attrelid = res.oid";

        builder.column("columns.col_names");
        builder.column("columns.col_options");
        builder.column("columns.col_foptions");
        builder.column("columns.col_storages");
        builder.column("columns.col_default_storages");
        builder.column("columns.col_has_default");
        builder.column("columns.col_defaults");
        builder.column("columns.col_comments");
        builder.column("columns.col_type_ids");
        builder.column("columns.col_type_name");
        builder.column("columns.col_notnull");
        builder.column("columns.col_statictics");
        builder.column("columns.col_local");
        builder.column("columns.col_acl");
        builder.column("columns.col_collation");
        builder.column("columns.col_typcollation");
        builder.column("columns.col_collationname");
        builder.column("columns.col_collationnspname");
        builder.join(columns);
    }

    private void addParentsPart(QueryBuilder builder) {
        String parents = "LEFT JOIN (\n"
                + "  SELECT\n"
                + "    inh.inhrelid,\n"
                + "    pg_catalog.array_agg(inhrel.relname ORDER BY inh.inhrelid, inh.inhseqno) AS inhrelnames,\n"
                + "    pg_catalog.array_agg(inhns.nspname ORDER BY inh.inhrelid, inh.inhseqno) AS inhnspnames\n"
                + "  FROM pg_catalog.pg_inherits inh\n"
                + "  LEFT JOIN pg_catalog.pg_class inhrel ON inh.inhparent = inhrel.oid\n"
                + "  LEFT JOIN pg_catalog.pg_namespace inhns ON inhrel.relnamespace = inhns.oid\n"
                + "  GROUP BY inh.inhrelid\n"
                + ") parents ON parents.inhrelid = res.oid";

        builder.column("parents.inhrelnames");
        builder.column("parents.inhnspnames");
        builder.join(parents);
    }
}
