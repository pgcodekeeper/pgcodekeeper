package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.AbstractMap;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilAnalyzeExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PartitionForeignPgTable;
import cz.startnet.utils.pgdiff.schema.PartitionPgTable;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.RegularPgTable;
import cz.startnet.utils.pgdiff.schema.SimpleForeignPgTable;
import cz.startnet.utils.pgdiff.schema.SimplePgTable;
import cz.startnet.utils.pgdiff.schema.TypedPgTable;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TablesReader extends JdbcReader {

    public static class TablesReaderFactory extends JdbcReaderFactory {

        public TablesReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new TablesReader(this, loader);
        }
    }

    private TablesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSetWrapper result, PgSchema schema) throws WrapperAccessException {
        PgTable table = getTable(result, schema);
        loader.monitor.worked(1);
        if (table != null) {
            schema.addTable(table);
        }
    }

    private PgTable getTable(ResultSetWrapper res, PgSchema schema) throws WrapperAccessException {
        String schemaName = schema.getName();
        String tableName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, DbObjType.TABLE));
        String partitionBound = null;

        if (SupportedVersion.VERSION_10.checkVersion(loader.version)) {
            partitionBound = res.getString("partition_bound");
        }
        PgTable t;
        String serverName = res.getString("server_name");
        long ofTypeOid = res.getLong("of_type");
        if (serverName != null) {
            if (partitionBound == null) {
                t = new SimpleForeignPgTable(tableName, "", serverName);
            } else {
                t = new PartitionForeignPgTable(tableName, "", serverName, partitionBound);
            }
        } else if (ofTypeOid != 0) {
            JdbcType jdbcOfType = loader.cachedTypesByOid.get(ofTypeOid);
            String ofType = jdbcOfType.getFullName(schemaName);
            t = new TypedPgTable(tableName, "", ofType);
            jdbcOfType.addTypeDepcy(t);
        } else if (partitionBound != null) {
            t = new PartitionPgTable(tableName, "", partitionBound);
        } else {
            t = new SimplePgTable(tableName, "");
        }

        String[] foptions = res.getArray("ftoptions", String.class);
        if (foptions != null) {
            ParserAbstract.fillOptionParams(foptions, t::addOption, false, true);
        }

        // PRIVILEGES, OWNER
        loader.setOwner(t, res.getLong(CLASS_RELOWNER));
        loader.setPrivileges(t, PgDiffUtils.getQuotedName(t.getName()), res.getString("aclarray"), t.getOwner(), null);

        readColumns(res, t, ofTypeOid, schema);

        // INHERITS
        String[] inhrelnames = res.getArray("inhrelnames", String.class);
        if (inhrelnames != null) {
            String[] inhnspnames = res.getArray("inhnspnames", String.class);

            for (int i = 0; i < inhrelnames.length; ++i) {
                t.addInherits(schemaName.equals(inhnspnames[i]) ? null : inhnspnames[i], inhrelnames[i]);
                t.addDep(new GenericColumn(inhnspnames[i], inhrelnames[i], DbObjType.TABLE));
            }
        }

        // STORAGE PARAMETERS
        String [] opts = res.getArray("reloptions", String.class);
        if (opts != null) {
            ParserAbstract.fillOptionParams(opts, t::addOption, false, false);
        }

        String[] toast = res.getArray("toast_reloptions", String.class);
        if (toast != null) {
            ParserAbstract.fillOptionParams(toast, t::addOption, true, false);
        }

        // Table COMMENTS
        String comment = res.getString("table_comment");
        if (comment != null && !comment.isEmpty()) {
            t.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        if (res.getBoolean("has_oids")){
            t.setHasOids(true);
        }

        if (t instanceof RegularPgTable) {
            RegularPgTable regTable = (RegularPgTable) t;

            // TableSpace
            String tableSpace = res.getString("table_space");
            if (tableSpace != null && !tableSpace.isEmpty()) {
                regTable.setTablespace(tableSpace);
            }

            // since 9.5 PostgreSQL
            if (SupportedVersion.VERSION_9_5.checkVersion(loader.version)) {
                regTable.setRowSecurity(res.getBoolean("row_security"));
                regTable.setForceSecurity(res.getBoolean("force_security"));
            }

            // since 10 PostgreSQL
            if (SupportedVersion.VERSION_10.checkVersion(loader.version)) {
                regTable.setPartitionBy(res.getString("partition_by"));
            }

            // persistence: U - unlogged, P - permanent, T - temporary
            switch (res.getString("persistence")) {
            case "u":
                regTable.setLogged(false);
                break;
            default:
                break;
            }
        }
        return t;
    }

    private void readColumns(ResultSetWrapper res, PgTable t, long ofTypeOid,
            PgSchema schema) throws WrapperAccessException {
        String[] colNames = res.getArray("col_names", String.class);
        if (colNames == null) {
            return;
        }

        Long[] colTypeIds = res.getArray("col_type_ids", Long.class);
        String[] colTypeName = res.getArray("col_type_name", String.class);
        String[] colDefaults = res.getArray("col_defaults", String.class);
        String[] colComments = res.getArray("col_comments", String.class);
        Boolean[] colNotNull = res.getArray("col_notnull", Boolean.class);
        Integer[] colStatictics = res.getArray("col_statictics", Integer.class);
        Boolean[] colIsLocal = res.getArray("col_local", Boolean.class);
        Long[] colCollation = res.getArray("col_collation", Long.class);
        Long[] colTypCollation = res.getArray("col_typcollation", Long.class);
        String[] colCollationName = res.getArray("col_collationname", String.class);
        String[] colCollationSchema = res.getArray("col_collationnspname", String.class);
        String[] colAcl = res.getArray("col_acl", String.class);
        String[] colOptions = res.getArray("col_options", String.class);
        String[] colFOptions = res.getArray("col_foptions", String.class);
        String[] colStorages = res.getArray("col_storages", String.class);
        String[] colDefaultStorages = res.getArray("col_default_storages", String.class);

        for (int i = 0; i < colNames.length; i++) {
            PgColumn column = new PgColumn(colNames[i]);
            column.setInherit(!colIsLocal[i]);

            if (ofTypeOid == 0 && !column.isInherit()) {
                column.setType(colTypeName[i]);
            }

            loader.cachedTypesByOid.get(colTypeIds[i]).addTypeDepcy(column);

            if (colOptions[i] != null) {
                ParserAbstract.fillOptionParams(colOptions[i].split(","), column::addOption, false, false);
            }
            if (colFOptions[i] != null) {
                ParserAbstract.fillOptionParams(colFOptions[i].split(","), column::addForeignOption, false, true);
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

            String columnDefault = colDefaults[i];
            if (columnDefault != null && !columnDefault.isEmpty()) {
                column.setDefaultValue(columnDefault);
                loader.submitAntlrTask(columnDefault, (PgDatabase)schema.getParent(),
                        p -> p.vex_eof().vex().get(0),
                        (ctx, db) -> {
                            db.getContextsForAnalyze().add(new AbstractMap.SimpleEntry<>(t, ctx));

                            UtilAnalyzeExpr.analyze(ctx, new ValueExpr(schema.getName()), column);
                        });
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

            String comment = colComments[i];
            if (comment != null && !comment.isEmpty()) {
                column.setComment(loader.args, PgDiffUtils.quoteString(comment));
            }

            // COLUMNS PRIVILEGES
            String columnPrivileges = colAcl[i];
            if (columnPrivileges != null && !columnPrivileges.isEmpty()) {
                loader.setPrivileges(column, PgDiffUtils.getQuotedName(t.getName()),
                        columnPrivileges, t.getOwner(), PgDiffUtils.getQuotedName(colNames[i]));
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
}
