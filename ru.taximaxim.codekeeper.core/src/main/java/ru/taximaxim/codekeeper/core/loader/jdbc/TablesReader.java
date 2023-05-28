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

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.AlterTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.AbstractRegularTable;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.GpExternalTable;
import ru.taximaxim.codekeeper.core.schema.ICompressOptionContainer;
import ru.taximaxim.codekeeper.core.schema.PartitionForeignPgTable;
import ru.taximaxim.codekeeper.core.schema.PartitionGpTable;
import ru.taximaxim.codekeeper.core.schema.PartitionPgTable;
import ru.taximaxim.codekeeper.core.schema.PgColumn;
import ru.taximaxim.codekeeper.core.schema.SimpleForeignPgTable;
import ru.taximaxim.codekeeper.core.schema.SimplePgTable;
import ru.taximaxim.codekeeper.core.schema.TypedPgTable;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class TablesReader extends JdbcReader {

    private static final String CREATE_TABLE = "CREATE TABLE noname () ";

    public TablesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_TABLES, loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException {
        AbstractPgTable table = getTable(result, schema);
        loader.monitor.worked(1);
        schema.addTable(table);
    }

    private AbstractPgTable getTable(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String tableName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, DbObjType.TABLE));
        String partitionBound = null;
        String partitionGpBound = null;
        String partitionGpTemplate = null;

        if (SupportedVersion.VERSION_10.isLE(loader.version) &&
                res.getBoolean("relispartition")) {
            partitionBound = res.getString("partition_bound");
            checkObjectValidity(partitionBound, DbObjType.TABLE, tableName);
        }
        if (loader.isGreenplumDb) {
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
            JdbcType jdbcOfType = loader.cachedTypesByOid.get(ofTypeOid);
            String ofType = jdbcOfType.getFullName();
            t = new TypedPgTable(tableName, ofType);
            jdbcOfType.addTypeDepcy(t);
        } else if (partitionBound != null) {
            t = new PartitionPgTable(tableName, partitionBound);
        } else if (partitionGpBound != null) {
            t = createGpParttionTable(tableName, partitionGpBound, partitionGpTemplate);
        } else if (loader.isGreenplumDb && res.getString("exloc") != null) {
            t = new GpExternalTable(tableName);
            readExternalTable((GpExternalTable) t, res);
        } else {
            t = new SimplePgTable(tableName);
        }

        if (SupportedVersion.VERSION_12.isLE(loader.version)) {
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
        loader.setOwner(t, res.getLong(CLASS_RELOWNER));
        loader.setPrivileges(t, res.getString("aclarray"), schemaName);
        loader.setAuthor(t, res);

        readColumns(res, t, ofTypeOid, schema);

        // INHERITS
        String[] inhrelnames = getColArray(res, "inhrelnames");
        if (inhrelnames != null) {
            String[] inhnspnames = getColArray(res, "inhnspnames");

            for (int i = 0; i < inhrelnames.length; ++i) {
                t.addInherits(inhnspnames[i], inhrelnames[i]);
                t.addDep(new GenericColumn(inhnspnames[i], inhrelnames[i], DbObjType.TABLE));
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

        // Table COMMENTS
        String comment = res.getString("table_comment");
        if (comment != null && !comment.isEmpty()) {
            t.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        if (!SupportedVersion.VERSION_12.isLE(loader.version) && res.getBoolean("has_oids")) {
            t.setHasOids(true);
        }

        if (t instanceof AbstractRegularTable) {
            fillRegularTable(t, res);
        }

        return t;
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

        if (loader.isGreenplumDb) {
            String distribution = res.getString("distribution");
            if (distribution != null && !distribution.isBlank()) {
                regTable.setDistribution(distribution);
            }
        }

        // since 9.5 PostgreSQL
        if (SupportedVersion.VERSION_9_5.isLE(loader.version)) {
            regTable.setRowSecurity(res.getBoolean("row_security"));
            regTable.setForceSecurity(res.getBoolean("force_security"));
        }

        // since 10 PostgreSQL
        if (SupportedVersion.VERSION_10.isLE(loader.version) &&
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
        Integer[] colStatictics = getColArray(res, "col_statictics");
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
        if (SupportedVersion.VERSION_12.isLE(loader.version)) {
            colGenerated = getColArray(res, "col_generated");
        }
        String[] colCompression = null;
        if (SupportedVersion.VERSION_14.isLE(loader.version)) {
            colCompression = getColArray(res, "col_compression");
        }
        String[] colEncOptions = null;
        if (loader.isGreenplumDb) {
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

            loader.cachedTypesByOid.get(colTypeIds[i]).addTypeDepcy(column);

            if (colOptions[i] != null) {
                ParserAbstract.fillOptionParams(colOptions[i].split(","), column::addOption, false, false, false);
            }
            if (colFOptions[i] != null) {
                ParserAbstract.fillOptionParams(colFOptions[i].split(","), column::addForeignOption, false, true, false);
            }
            if (loader.isGreenplumDb && colEncOptions[i] != null) {
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
                column.setCollation(PgDiffUtils.getQuotedName(colCollationSchema[i])
                        + '.' + PgDiffUtils.getQuotedName(colCollationName[i]));
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
                column.setComment(loader.args, PgDiffUtils.quoteString(comment));
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
}
