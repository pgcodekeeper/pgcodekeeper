package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsFunction;
import cz.startnet.utils.pgdiff.schema.MsFunction.FuncTypes;
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

        String assembly = res.getString("assembly");
        String assemblyClass = MsDiffUtils.quoteName(res.getString("assembly_class"));
        String assemblyMethod = MsDiffUtils.quoteName(res.getString("assembly_method"));
        String body = "EXTERNAL NAME " + MsDiffUtils.quoteName(assembly) + '.' + assemblyClass + '.' + assemblyMethod;
        boolean nullOnNullInput = res.getBoolean("null_on_null_input");
        String executeAs = res.getString("execute_as");
        String owner = res.getString("owner");

        List<XmlReader> args = XmlReader.readXML(res.getString("args"));
        AbstractFunction func;

        if (type == DbObjType.PROCEDURE) {
            func = new MsProcedure(name, "");
            func.setBody(body);
            func.addOption("EXECUTE AS " + (executeAs == null ? "CALLER" : executeAs));
        } else {
            func = new MsFunction(name, "");

            if ("FT".equals(funcType)) {
                List<String> columns = new ArrayList<>();

                for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
                    AbstractColumn column = new MsColumn(col.getString("name"));
                    boolean isUserDefined = col.getBoolean("ud");
                    if (!isUserDefined) {
                        column.setCollation(col.getString("cn"));
                    }

                    column.setType(JdbcLoaderBase.getMsType(func, col.getString("st"), col.getString("type"),
                            isUserDefined, col.getInt("size"), col.getInt("pr"), col.getInt("sc")));
                    column.setNullValue(col.getBoolean("nl"));
                    column.setSparse(col.getBoolean("sp"));
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

                func.setReturns("TABLE (\n" + String.join(",\n", columns) + ")");
                ((MsFunction)func).setFuncType(FuncTypes.TABLE);
            } else {
                func.setReturns(JdbcLoaderBase.getMsType(func, res.getString("return_type_sh"),
                        res.getString("return_type"), res.getBoolean("return_type_ud"),
                        res.getInt("return_type_size"), res.getInt("return_type_pr"),
                        res.getInt("return_type_sc")));
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
            boolean isUserDefined = arg.getBoolean("ud");
            Argument argDst = new Argument(arg.getBoolean("ou") ? "OUTPUT" : null,
                    arg.getString("name"), JdbcLoaderBase.getMsType(func, arg.getString("st"),
                            arg.getString("type"), isUserDefined, arg.getInt("size"),
                            arg.getInt("pr"), arg.getInt("sc")));

            if (arg.getBoolean("hd")) {
                String def = arg.getString("dv");
                String defValue;
                String baseType = arg.getString("bt");
                if (def == null) {
                    defValue = "NULL";
                } if ("varbinary".equals(baseType) || "nvarchar".equals(baseType)
                        || "varchar".equals(baseType) ) {
                    defValue = 'N' + PgDiffUtils.quoteString(def);
                } else if ("bit".equals(baseType)) {
                    defValue = "1".equals(def) ? "True" : "False";
                } else if ("real".equals(baseType) || "float".equals(baseType)) {
                    defValue = Double.toString(Double.parseDouble(def));
                    if ("0.0".equals(defValue)) {
                        defValue = "0";
                    }
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
        func.addDep(new GenericColumn(assembly, DbObjType.ASSEMBLY));

        schema.addFunction(func);
        loader.setPrivileges(func, XmlReader.readXML(res.getString("acl")));
    }
}
