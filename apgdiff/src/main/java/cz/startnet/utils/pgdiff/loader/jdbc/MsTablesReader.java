package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsTable;
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
            table.addColumn(getColumn(col, schema.getName(), loader));
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

    static AbstractColumn getColumn(XmlReader col, String schemaName, JdbcLoaderBase loader) {
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

        if (col.getBoolean("ii")) {
            column.setIdentity(Integer.toString(col.getInt("s")), Integer.toString(col.getInt("i")));
            column.setNotForRep(col.getBoolean("nfr"));
        }

        String def = col.getString("dv");
        if (def != null) {
            column.setDefaultValue(def);
            column.setDefaultName(col.getString("dn"));
            loader.submitMsAntlrTask(def, p -> p.expression_eof().expression().get(0),
                    ctx -> {
                        MsValueExpr vex = new MsValueExpr(schemaName);
                        vex.analyze(ctx);
                        column.addAllDeps(vex.getDepcies());
                    });
        }
        return column;
    }
}
