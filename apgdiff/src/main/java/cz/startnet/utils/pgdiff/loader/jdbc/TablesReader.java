package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TablesReader extends JdbcReader {

    public static class TablesReaderFactory extends JdbcReaderFactory {

        public TablesReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader, int version) {
            return new TablesReader(this, loader, version);
        }
    }

    private TablesReader(JdbcReaderFactory factory, JdbcLoaderBase loader, int currentVersion) {
        super(factory, loader, currentVersion);
    }

    @Override
    protected void processResult(ResultSetWrapper result, PgSchema schema) throws WrapperAccessException {
        PgTable table = getTable(result, schema.getName());
        loader.monitor.worked(1);
        if (table != null) {
            schema.addTable(table);
        }
    }

    private PgTable getTable(ResultSetWrapper res, String schemaName) throws WrapperAccessException {
        String tableName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, DbObjType.TABLE));
        PgTable t = new PgTable(tableName, "");

        t.setServerName(res.getString("server_name"));
        String[] options = res.getArray("ftoptions", String.class);
        if (options != null) {
            ParserAbstract.fillOptionParams(options, t::addOption, false, true);
        }

        // PRIVILEGES, OWNER
        loader.setOwner(t, res.getLong(CLASS_RELOWNER));
        loader.setPrivileges(t, PgDiffUtils.getQuotedName(t.getName()), res.getString("aclarray"), t.getOwner(), null);

        Integer[] colNumbers = res.getArray("col_numbers", Integer.class);
        String[] colNames = res.getArray("col_names", String.class);
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

        Long ofTypeOid = res.getLong("of_type");

        if(ofTypeOid != 0){
            JdbcType jdbcOfType = loader.cachedTypesByOid.get(ofTypeOid);
            String ofType = jdbcOfType.getFullName(schemaName);
            t.setOfType(ofType);
            jdbcOfType.addTypeDepcy(t);
        }

        for (int i = 0; i < colNumbers.length; i++) {
            if (colNumbers[i] < 1 || !colIsLocal[i]) {
                // пропускать не локальные (Inherited)  и системные (System) колонки
                continue;
            }

            PgColumn column = new PgColumn(colNames[i]);
            if(ofTypeOid == 0){
                column.setType(colTypeName[i]);
            }

            loader.cachedTypesByOid.get(colTypeIds[i]).addTypeDepcy(column);

            if (colOptions[i] != null) {
                ParserAbstract.fillOptionParams(colOptions[i].split(","), column::addOption, false, null);
            }
            if (colFOptions[i] != null) {
                ParserAbstract.fillOptionParams(colFOptions[i].split(","), column::addForeignOption, false, true);
            }

            if(!colStorages[i].equals(colDefaultStorages[i])){
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
            if (collation != 0 && collation != colTypCollation[i]) {
                column.setCollation(PgDiffUtils.getQuotedName(colCollationSchema[i])
                        + '.' + PgDiffUtils.getQuotedName(colCollationName[i]));
            }

            String columnDefault = colDefaults[i];
            if (columnDefault != null && !columnDefault.isEmpty()) {
                column.setDefaultValue(columnDefault);
                loader.submitAntlrTask(columnDefault, p -> {
                    ValueExpr vex = new ValueExpr(schemaName);
                    vex.analyze(new Vex(p.vex_eof().vex()));
                    return vex.getDepcies();
                }, column::addAllDeps);
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
                loader.setPrivileges(column, PgDiffUtils.getQuotedName(tableName),
                        columnPrivileges, t.getOwner(), PgDiffUtils.getQuotedName(colNames[i]));
            }

            if(ofTypeOid != 0){
                if((column.getDefaultValue()!= null && !column.getDefaultValue().isEmpty())
                        || !column.getNullValue()){
                    t.addColumnOfType(column);
                }
            } else {
                t.addColumn(column);
            }
        }

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
        String [] arrOpts = res.getArray("reloptions", String.class);
        if (arrOpts != null) {
            ParserAbstract.fillOptionParams(options, t::addOption, false, false);
        }

        String[] arrToast = res.getArray("toast_reloptions", String.class);
        if (arrToast != null) {
            ParserAbstract.fillOptionParams(options, t::addOption, true, false);
        }

        if (res.getBoolean("has_oids")){
            t.setHasOids(true);
        }

        // Table COMMENTS
        String comment = res.getString("table_comment");
        if (comment != null && !comment.isEmpty()) {
            t.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        // TableSpace
        String tableSpace = res.getString("table_space");
        if (tableSpace != null && !tableSpace.isEmpty()) {
            t.setTablespace(tableSpace);
        }

        // since 9.5 PostgreSQL
        if (SupportedVersion.VERSION_9_5.checkVersion(currentVersion)) {
            t.setRowSecurity(res.getBoolean("row_security"));
            t.setForceSecurity(res.getBoolean("force_security"));
        }

        // persistence: U - unlogged, P - permanent, T - temporary
        switch (res.getString("persistence")) {
        case "u":
            t.setLogged(false);
            break;
        default:
            break;
        }

        return t;
    }
}
