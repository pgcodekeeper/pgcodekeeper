package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsTypesReader extends JdbcReader {

    public MsTypesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_TYPES, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema)
            throws SQLException, XmlReaderException {
        loader.monitor.worked(1);
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, DbObjType.TYPE));

        MsType type = new MsType(name, "");
        String baseType = res.getString("base_type");
        String assembly = res.getString("assembly_class");
        if (assembly != null) {
            type.setAssemblyName(assembly);
            type.setAssemblyClass(res.getString("assembly_class"));
            type.addDep(new GenericColumn(assembly, DbObjType.ASSEMBLY));
        } else if (baseType != null) {
            type.setBaseType(getMsType(type, null, baseType, false, res.getInt("size"),
                    res.getInt("precision"), res.getInt("scale")));
            type.setNotNull(!res.getBoolean("is_nullable"));
        } else {
            for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
                AbstractColumn column = new MsColumn(col.getString("name"));
                String exp = col.getString("def");
                column.setExpression(exp);
                if (exp == null) {
                    boolean isUserDefined = col.getBoolean("ud");
                    if (!isUserDefined) {
                        column.setCollation(col.getString("cn"));
                    }

                    column.setType(getMsType(type, col.getString("st"), col.getString("type"),
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
                }

                type.addColumn(column.getFullDefinition());
            }

            for (XmlReader index : XmlReader.readXML(res.getString("indices"))) {
                boolean isPrimaryKey = index.getBoolean("pk");
                boolean isUniqueConstraint = index.getBoolean("uc");
                boolean isClustered = index.getBoolean("cl");
                boolean isIgnoreDupKey = index.getBoolean("dk");
                int bucketCount = index.getInt("bc");
                String filter = index.getString("def");

                StringBuilder definition = new StringBuilder();

                if (isPrimaryKey) {
                    definition.append("PRIMARY KEY ");
                } else if (isUniqueConstraint) {
                    definition.append("UNIQUE ");
                } else {
                    definition.append("INDEX ").append(
                            MsDiffUtils.quoteName(index.getString("name"))).append(' ');
                }

                if (!isClustered) {
                    definition.append("NON");
                }

                definition.append("CLUSTERED ");

                if (bucketCount > 0) {
                    definition.append("HASH ");
                }

                definition.append('\n');

                List<String> columns = new ArrayList<>();

                for (XmlReader col : XmlReader.readXML(index.getString("cols"))) {
                    boolean isDesc = col.getBoolean("is_desc");
                    String colName = col.getString("name");
                    columns.add(MsDiffUtils.quoteName(colName) + (isDesc ? " DESC" : " ASC"));
                }

                definition.append("(\n\t");
                definition.append(String.join(",\n\t", columns));
                definition.append("\n)");

                if (filter != null) {
                    // index only, broken in dump
                    definition.append(" WHERE ").append(filter);
                }

                if (isIgnoreDupKey) {
                    // constraint only
                    definition.append(" WITH (IGNORE_DUP_KEY = ON)");
                } else if (bucketCount > 0) {
                    if (filter != null) {
                        definition.append('\n');
                    }
                    definition.append("WITH ( BUCKET_COUNT = ").append(bucketCount).append(')');
                }

                if (isPrimaryKey || isUniqueConstraint) {
                    type.addConstraint(definition.toString());
                } else {
                    type.addIndex(definition.toString());
                }
            }

            for (XmlReader check : XmlReader.readXML(res.getString("checks"))) {
                type.addConstraint(" CHECK (" + check.getString("def") + ")");
            }

            type.setMemoryOptimazed(res.getBoolean("is_memory_optimized"));
        }

        loader.setOwner(type, res.getString("owner"));

        schema.addType(type);

        loader.setPrivileges(type, XmlReader.readXML(res.getString("acl")));
    }
}
