package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract.FunctionSearcher;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TablesReader extends JdbcReader {

    public static class TablesReaderFactory extends JdbcReaderFactory {

        public TablesReaderFactory(long hasHelperMask, String helperFunction, String fallbackQuery) {
            super(hasHelperMask, helperFunction, fallbackQuery);
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
    protected void processResult(ResultSet result, PgSchema schema) throws SQLException {
        PgTable table = getTable(result, schema.getName());
        loader.monitor.worked(1);
        if (table != null) {
            schema.addTable(table);
        }
    }

    private PgTable getTable(ResultSet res, String schemaName) throws SQLException {
        String tableName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, DbObjType.TABLE));
        PgTable t = new PgTable(tableName, "");

        // PRIVILEGES, OWNER
        loader.setOwner(t, res.getLong(CLASS_RELOWNER));
        loader.setPrivileges(t, PgDiffUtils.getQuotedName(t.getName()), res.getString("aclarray"), t.getOwner(), null);

        Integer[] colNumbers = (Integer[]) res.getArray("col_numbers").getArray();
        String[] colNames = (String[]) res.getArray("col_names").getArray();
        Long[] colTypeIds = (Long[]) res.getArray("col_type_ids").getArray();
        String[] colTypeName = (String[]) res.getArray("col_type_name").getArray();
        String[] colDefaults = (String[]) res.getArray("col_defaults").getArray();
        String[] colComments = (String[]) res.getArray("col_comments").getArray();
        Boolean[] colNotNull = (Boolean[]) res.getArray("col_notnull").getArray();
        Integer[] colStatictics = (Integer[]) res.getArray("col_statictics").getArray();
        Boolean[] colIsLocal = (Boolean[]) res.getArray("col_local").getArray();
        Long[] colCollation = (Long[]) res.getArray("col_collation").getArray();
        Long[] colTypCollation = (Long[]) res.getArray("col_typcollation").getArray();
        String[] colCollationName = (String[]) res.getArray("col_collationname").getArray();
        String[] colCollationSchema = (String[]) res.getArray("col_collationnspname").getArray();
        String[] colSeq = (String[]) res.getArray("col_attseq").getArray();
        String[] colAcl = (String[]) res.getArray("col_acl").getArray();

        for (int i = 0; i < colNumbers.length; i++) {
            if (colNumbers[i] < 1) {
                // system columns
                continue;
            }
            // пропускать не локальные колонки (Inherited)
            if (!colIsLocal[i]) {
                continue;
            }
            PgColumn column = new PgColumn(colNames[i]);
            column.setType(colTypeName[i]);
            loader.cachedTypesByOid.get(colTypeIds[i]).addTypeDepcy(column);

            // unbox
            long collation = colCollation[i];
            if (collation != 0 && collation != colTypCollation[i]) {
                column.setCollation(PgDiffUtils.getQuotedName(colCollationSchema[i])
                        + '.' + PgDiffUtils.getQuotedName(colCollationName[i]));
            }

            String columnDefault = colDefaults[i];
            if (columnDefault != null && !columnDefault.isEmpty()) {
                column.setDefaultValue(columnDefault);
                GenericColumn func = parseFunctionCall(columnDefault, schemaName);
                if (func != null) {
                    column.addDep(func);
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

            // SEQUENCES
            if (colSeq[i] != null && !colSeq[i].isEmpty()) {
                QNameParser seq = new QNameParser(colSeq[i]);
                t.addDep(new GenericColumn(seq.getSchemaName(schemaName), seq.getFirstName(), DbObjType.SEQUENCE));
            }

            // COLUMNS PRIVILEGES
            String columnPrivileges = colAcl[i];
            if (columnPrivileges != null && !columnPrivileges.isEmpty()) {
                loader.setPrivileges(column, PgDiffUtils.getQuotedName(tableName),
                        columnPrivileges, t.getOwner(), PgDiffUtils.getQuotedName(colNames[i]));
            }

            t.addColumn(column);
        }

        // INHERITS
        Array inhrelsarray = res.getArray("inhrelnames");
        if (inhrelsarray != null) {
            String[] inhrelnames = (String[]) inhrelsarray.getArray();
            String[] inhnspnames = (String[]) res.getArray("inhnspnames").getArray();

            for (int i = 0; i < inhrelnames.length; ++i) {
                t.addInherits(schemaName.equals(inhnspnames[i]) ? null : inhnspnames[i], inhrelnames[i]);
                t.addDep(new GenericColumn(inhnspnames[i], inhrelnames[i], DbObjType.TABLE));
            }
        }

        // STORAGE PARAMETERS
        StringBuilder storageParameters = new StringBuilder();
        Array arr = res.getArray("reloptions");
        if (arr != null) {
            fillStorageParams(storageParameters, arr, false);
        }

        arr = res.getArray("toast_reloptions");
        if (arr != null) {
            fillStorageParams(storageParameters, arr, true);
        }

        boolean hasOids = res.getBoolean("has_oids");
        if (storageParameters.length() > 0 && hasOids) {
            t.setWith(storageParameters.insert(0, '(').append("OIDS=true)").toString());
        } else if (storageParameters.length() > 0) {
            // убираем лишние запятую-пробел
            storageParameters.setLength(storageParameters.length() - 2);
            t.setWith(storageParameters.insert(0, '(').append(')').toString());
        } else if (hasOids) {
            t.setWith("OIDS=true");
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
        return t;
    }

    // TODO отрефакторить в вычитку всех зависимостей из экспрешшена
    private GenericColumn parseFunctionCall(String def, String defSchema) {
        SQLParser parser = AntlrParser.makeBasicParser(SQLParser.class, def, loader.getCurrentLocation());
        FunctionSearcher fs = new FunctionSearcher();
        ParseTreeWalker.DEFAULT.walk(fs, parser.vex());
        if (fs.getName() == null) {
            return null;
        }
        List<IdentifierContext> ids = fs.getName().identifier();
        return new GenericColumn(QNameParser.getSchemaName(ids, defSchema),
                QNameParser.getFirstName(ids), DbObjType.FUNCTION);
    }

    private void fillStorageParams(StringBuilder storageParameters,
            Array arr, boolean isToast) throws SQLException {
        String[] options = (String[]) arr.getArray();
        for (String pair : options) {
            int sep = pair.indexOf('=');
            String option, value;
            if (sep == -1) {
                option = pair;
                value = "";
            } else {
                option = pair.substring(0, sep);
                value = pair.substring(sep + 1);
            }
            if (!value.equals(PgDiffUtils.getQuotedName(value))) {
                // only quote non-ids; pg_dump behavior
                value = PgDiffUtils.quoteString(value);
            }

            if (isToast) {
                storageParameters.append("toast.");
            }
            storageParameters.append(option).append('=').append(value).append(", ");
        }
    }
}
