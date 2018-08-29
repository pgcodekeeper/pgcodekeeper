package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsFunction;
import cz.startnet.utils.pgdiff.schema.MsProcedure;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsExtendedObjectsReader extends JdbcReader {

    public MsExtendedObjectsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_EXTENDED_FUNCTIONS_AND_PROCEDURES, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        loader.monitor.worked(1);
        String name = res.getString("name");
        String funcType = res.getString("type");
        DbObjType type = "PC".equals(funcType) ? DbObjType.PROCEDURE : DbObjType.FUNCTION;
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, type));

        String assembly = MsDiffUtils.quoteName(res.getString("assembly"));
        String assemblyClass = MsDiffUtils.quoteName(res.getString("assembly_class"));
        String assemblyMethod = MsDiffUtils.quoteName(res.getString("assembly_method"));
        String body = "EXTERNAL NAME " + assembly + '.' + assemblyClass + '.' + assemblyMethod;
        boolean nullOnNullInput = res.getBoolean("null_on_null_input");
        String executeAs = res.getString("execute_as");
        String owner = res.getString("owner");

        List<XmlReader> args = XmlReader.readXML(res.getString("args"));
        AbstractFunction func;

        if (type == DbObjType.PROCEDURE) {
            func = new MsProcedure(name, "");
            func.setBody(body);
            func.addOption("EXECUTE AS " + (executeAs == null ? "CALLER" : executeAs));
            // TODO add to query proc.setForReplication(i);
        } else {
            func = new MsFunction(name, "");

            if ("FT".equals(funcType)) {

                List<String> columns = new ArrayList<>();

                for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
                    AbstractColumn column = new MsColumn(col.getString("name"));
                    String dataType = col.getString("type");
                    int size = col.getInt("size");
                    column.setType(MsDiffUtils.quoteName(dataType) + getArgSize(dataType, size, res));
                    column.setSparse(col.getBoolean("sp"));
                    column.setNullValue(col.getBoolean("nl"));
                    if (col.getBoolean("ii")) {
                        column.setIdentity(Integer.toString(col.getInt("s")), Integer.toString(col.getInt("i")));
                        column.setNotForRep(col.getBoolean("nfr"));
                    }

                    String def = col.getString("dv");
                    if (def != null) {
                        column.setDefaultValue(def);
                        column.setDefaultName(col.getString("dn"));
                    }

                    column.setCollation(col.getString("cn"));

                    column.setExpression(col.getString("def"));
                    columns.add(column.getFullDefinition());
                }

                // TODO table can have name, options and etc
                func.setReturns("TABLE (\n" + String.join(",\n", columns) + ")");
            } else {
                String dataType = res.getString("return_type");
                int size = res.getInt("return_type_size");
                func.setReturns(MsDiffUtils.quoteName(dataType) +  getArgSize(dataType, size, res));
            }

            StringBuilder sb = new StringBuilder();

            sb.append("WITH EXECUTE AS ");
            sb.append((executeAs == null ? "CALLER" : executeAs));
            if (nullOnNullInput) {
                sb.append(", RETURNS NULL ON NULL INPUT");
            }
            sb.append('\n');
            sb.append(body);
            func.setBody(sb.toString());
        }

        for (XmlReader arg : args) {
            String dataType = arg.getString("type");
            int size = arg.getInt("size");

            Argument argDst = new Argument(arg.getBoolean("ou") ? "OUTPUT" : null,
                    arg.getString("name"), MsDiffUtils.quoteName(dataType) + getArgSize(dataType, size, res));

            if (arg.getBoolean("hd")) {
                String def = arg.getString("dv");
                String defValue;
                if (def == null) {
                    defValue = "NULL";
                } else if ("varbinary".equals(dataType) || dataType.endsWith("varchar")) {
                    defValue = "N'" + def + "'";
                } else {
                    defValue = def;
                }

                argDst.setDefaultExpression(defValue);
            }

            argDst.setReadOnly(arg.getBoolean("ro"));
            func.addArgument(argDst);
        }

        loader.setOwner(func, owner);
        func.setCLR(true);
        schema.addFunction(func);
        loader.setPrivileges(func, XmlReader.readXML(res.getString("acl")));
    }

    private String getArgSize(String dataType, int size, ResultSet res) throws SQLException {
        // TODO other type with size
        if ("varbinary".equals(dataType) || dataType.endsWith("varchar")) {
            return size == -1 ? " (max)" : (" (" + size + ")");
        } else if ("decimal".equals(dataType) || "numeric".equals(dataType)) {
            return " (" + res.getInt("pr") + ", " + res.getInt("sc") + ')';
        }

        return "";
    }
}
