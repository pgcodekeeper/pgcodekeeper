package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractMsClrFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.ArgMode;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.FuncTypes;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsClrFunction;
import cz.startnet.utils.pgdiff.schema.MsClrProcedure;
import cz.startnet.utils.pgdiff.schema.MsColumn;
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
        String assemblyClass = res.getString("assembly_class");
        String assemblyMethod = res.getString("assembly_method");
        String executeAs = res.getString("execute_as");
        String owner = res.getString("owner");

        List<XmlReader> args = XmlReader.readXML(res.getString("args"));
        AbstractMsClrFunction func;

        if (type == DbObjType.PROCEDURE) {
            func = new MsClrProcedure(name, assembly, assemblyClass, assemblyMethod);
        } else {
            MsClrFunction localFunc = new MsClrFunction(name, assembly, assemblyClass, assemblyMethod);

            if ("FT".equals(funcType)) {
                List<String> columns = new ArrayList<>();

                for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
                    MsColumn column = new MsColumn(col.getString("name"));
                    boolean isUserDefined = col.getBoolean("ud");
                    if (!isUserDefined) {
                        column.setCollation(col.getString("cn"));
                    }

                    column.setType(JdbcLoaderBase.getMsType(localFunc, col.getString("st"), col.getString("type"),
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

                localFunc.setReturns("TABLE (\n" + String.join(",\n", columns) + ")");
                localFunc.setFuncType(FuncTypes.TABLE);
            } else {
                localFunc.setReturns(JdbcLoaderBase.getMsType(localFunc, res.getString("return_type_sh"),
                        res.getString("return_type"), res.getBoolean("return_type_ud"),
                        res.getInt("return_type_size"), res.getInt("return_type_pr"),
                        res.getInt("return_type_sc")));
            }

            if (res.getBoolean("null_on_null_input")) {
                localFunc.addOption("RETURNS NULL ON NULL INPUT");
            }

            func = localFunc;
        }

        func.addOption("EXECUTE AS " + (executeAs == null ? "CALLER" : executeAs));

        for (XmlReader arg : args) {
            boolean isUserDefined = arg.getBoolean("ud");
            Argument argDst = new Argument(arg.getBoolean("ou") ? ArgMode.OUTPUT : ArgMode.IN,
                    arg.getString("name"), JdbcLoaderBase.getMsType(func, arg.getString("st"),
                            arg.getString("type"), isUserDefined, arg.getInt("size"),
                            arg.getInt("pr"), arg.getInt("sc")));

            if (arg.getBoolean("hd")) {
                String def = arg.getString("dv");
                String defValue;
                String baseType = arg.getString("bt");
                if (def == null) {
                    defValue = "NULL";
                } else if ("varbinary".equals(baseType) || "nvarchar".equals(baseType)
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
        func.addDep(new GenericColumn(assembly, DbObjType.ASSEMBLY));

        schema.addFunction(func);
        loader.setPrivileges(func, XmlReader.readXML(res.getString("acl")));
    }
}
