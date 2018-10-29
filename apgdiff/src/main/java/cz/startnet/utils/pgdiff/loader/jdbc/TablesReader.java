package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PartitionForeignPgTable;
import cz.startnet.utils.pgdiff.schema.PartitionPgTable;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.AbstractRegularTable;
import cz.startnet.utils.pgdiff.schema.SimpleForeignPgTable;
import cz.startnet.utils.pgdiff.schema.SimplePgTable;
import cz.startnet.utils.pgdiff.schema.TypedPgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TablesReader extends JdbcReader {

    public TablesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_TABLES_PER_SCHEMA, loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException {
        AbstractTable table = getTable(result, schema);
        loader.monitor.worked(1);
        schema.addTable(table);
    }

    private AbstractTable getTable(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String tableName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, DbObjType.TABLE));
        String partitionBound = null;

        if (SupportedVersion.VERSION_10.isLE(loader.version) && res.getBoolean("relispartition")) {
            partitionBound = res.getString("partition_bound");
            checkObjectValidity(partitionBound, getType(), tableName);
        }
        AbstractTable t;
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
            String ofType = jdbcOfType.getFullName();
            t = new TypedPgTable(tableName, "", ofType);
            jdbcOfType.addTypeDepcy(t);
        } else if (partitionBound != null) {
            t = new PartitionPgTable(tableName, "", partitionBound);
        } else {
            t = new SimplePgTable(tableName, "");
        }

        String[] foptions = getColArray(res, "ftoptions");
        if (foptions != null) {
            ParserAbstract.fillOptionParams(foptions, t::addOption, false, true, false);
        }

        // PRIVILEGES, OWNER
        loader.setOwner(t, res.getLong(CLASS_RELOWNER));
        loader.setPrivileges(t, res.getString("aclarray"), schemaName);

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

        if (res.getBoolean("has_oids")){
            t.setHasOids(true);
        }

        if (t instanceof AbstractRegularTable) {
            AbstractRegularTable regTable = (AbstractRegularTable) t;

            // TableSpace
            String tableSpace = res.getString("table_space");
            if (tableSpace != null && !tableSpace.isEmpty()) {
                regTable.setTablespace(tableSpace);
            }

            // since 9.5 PostgreSQL
            if (SupportedVersion.VERSION_9_5.isLE(loader.version)) {
                regTable.setRowSecurity(res.getBoolean("row_security"));
                regTable.setForceSecurity(res.getBoolean("force_security"));
            }

            // since 10 PostgreSQL
            if (SupportedVersion.VERSION_10.isLE(loader.version) && "p".equals(res.getString("relkind"))) {
                String partitionBy = res.getString("partition_by");
                checkObjectValidity(partitionBy, getType(), tableName);
                regTable.setPartitionBy(partitionBy);
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

    private void readColumns(ResultSet res, AbstractTable t, long ofTypeOid,
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

        for (int i = 0; i < colNames.length; i++) {
            AbstractColumn column = new PgColumn(colNames[i]);
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
                            ctx -> schema.getDatabase().addContextForAnalyze(column, ctx));
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

    @Override
    protected DbObjType getType() {
        return DbObjType.TABLE;
    }
}
