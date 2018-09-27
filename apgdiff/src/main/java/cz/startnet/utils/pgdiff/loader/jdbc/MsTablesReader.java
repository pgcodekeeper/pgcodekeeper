package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.SimpleMsTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsTablesReader extends JdbcReader {

    public MsTablesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_TABLES, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        loader.monitor.worked(1);
        String tableName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), tableName, DbObjType.TABLE));
        SimpleMsTable table = new SimpleMsTable(tableName, "");

        if (res.getBoolean("is_memory_optimized")) {
            table.addOption("MEMORY_OPTIMIZED" , "ON");
        }

        if (res.getBoolean("durability")) {
            table.addOption("DURABILITY", res.getString("durability_desc"));
        }

        if (res.getBoolean("data_compression")) {
            table.addOption("DATA_COMPRESSION", res.getString("data_compression_desc"));
        }

        table.setTextImage(res.getString("text_image"));
        table.setFileStream(res.getString("file_stream"));
        table.setAnsiNulls(res.getBoolean("uses_ansi_nulls"));
        Object isTracked = res.getObject("is_tracked");
        if (isTracked != null) {
            table.setTracked((Boolean)isTracked);
        }

        for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
            AbstractColumn column = new MsColumn(col.getString("name"));
            // TODO other type with size
            String exp = col.getString("def");
            column.setExpression(exp);
            if (exp == null) {
                column.setCollation(col.getString("cn"));
                column.setNullValue(col.getBoolean("nl"));
                String dataType = col.getString("type");
                String argSize = "";
                int size = col.getInt("size");
                if ("varbinary".equals(dataType) || dataType.endsWith("varchar")) {
                    argSize = size == -1 ? " (max)" : (" (" + size + ")");
                } else if ("decimal".equals(dataType) || "numeric".equals(dataType)) {
                    argSize = " (" + col.getInt("pr") + ", " + col.getInt("sc") + ')';
                }
                column.setType(MsDiffUtils.quoteName(dataType) + argSize);
            }

            column.setSparse(col.getBoolean("sp"));
            column.setRowGuidCol(col.getBoolean("is_rowguidcol"));
            column.setPersisted(col.getBoolean("is_persisted"));

            if (col.getBoolean("ii")) {
                column.setIdentity(Integer.toString(col.getInt("s")), Integer.toString(col.getInt("i")));
                column.setNotForRep(col.getBoolean("nfr"));
            }

            String def = col.getString("dv");
            if (def != null) {
                column.setDefaultValue(def);
                column.setDefaultName(col.getString("dn"));
            }

            table.addColumn(column);
        }

        String tableSpace = MsDiffUtils.quoteName(res.getString("space_name"));
        String partCol = res.getString("part_column");
        if (partCol != null) {
            tableSpace = tableSpace + '(' + MsDiffUtils.quoteName(partCol) + ')';
        }
        table.setTablespace(tableSpace);

        loader.setOwner(table, res.getString("owner"));

        schema.addTable(table);
        loader.setPrivileges(table, XmlReader.readXML(res.getString("acl")));
    }
}
