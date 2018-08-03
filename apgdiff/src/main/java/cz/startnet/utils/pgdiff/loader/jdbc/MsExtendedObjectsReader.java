package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsFunction;
import cz.startnet.utils.pgdiff.schema.MsFunction.MsArgument;
import cz.startnet.utils.pgdiff.schema.MsProcedure;
import cz.startnet.utils.pgdiff.schema.MsProcedure.ProcedureArgument;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsExtendedObjectsReader extends JdbcReader {

    public MsExtendedObjectsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_EXTENDED_FUNCTIONS_AND_PROCEDURES, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException, JsonReaderException {
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

        List<JsonReader> args = JsonReader.fromArray(res.getString("args"));

        if (type == DbObjType.PROCEDURE) {
            MsProcedure proc = new MsProcedure(name, "");
            proc.setBody(body);
            proc.addOption("EXECUTE AS " + (executeAs == null ? "CALLER" : executeAs));


            for (JsonReader arg : args) {
                String argSize = "";
                String dataType = arg.getString("type");
                int size = arg.getInt("size");
                if ("varbinary".equals(dataType) || dataType.endsWith("varchar")) {
                    argSize = size == -1 ? " (max)" : (" (" + size + ")");
                } else if ("decimal".equals(dataType) || "numeric".equals(dataType)) {
                    argSize = " (" + arg.getInt("pr") + ", " + arg.getInt("sc") + ')';
                }
                // TODO other type with size

                ProcedureArgument argDst = proc.new ProcedureArgument(arg.getBoolean("ou") ? "OUTPUT" : null,
                        arg.getString("name"), MsDiffUtils.quoteName(dataType) + argSize);

                if (arg.getBoolean("hd")) {
                    argDst.setDefaultExpression(arg.getString("dv"));
                }

                argDst.setReadOnly(arg.getBoolean("ro"));
                // TODO VARYING to query; add to argument nullable ?
                proc.addArgument(argDst);
            }

            // TODO add to query proc.setForReplication(i);
            loader.setOwner(proc, owner);
            schema.addProcedure(proc);
            loader.setPrivileges(proc, JsonReader.fromArray(res.getString("acl")));
        } else {
            MsFunction func = new MsFunction(name, "");

            for (JsonReader arg : args) {
                String argSize = "";
                String dataType = arg.getString("type");
                int size = arg.getInt("size");
                if ("varbinary".equals(dataType) || dataType.endsWith("varchar")) {
                    argSize = size == -1 ? " (max)" : (" (" + size + ")");
                } else if ("decimal".equals(dataType) || "numeric".equals(dataType)) {
                    argSize = " (" + arg.getInt("pr") + ", " + arg.getInt("sc") + ')';
                }
                // TODO other type with size

                MsArgument argDst = func.new MsArgument(arg.getBoolean("ou") ? "OUTPUT" : null,
                        arg.getString("name"), MsDiffUtils.quoteName(dataType) + argSize);

                if (arg.getBoolean("hd")) {
                    argDst.setDefaultExpression(arg.getString("dv"));
                }

                // TODO add to argument nullable ?
                func.addArgument(argDst);
            }

            if ("FT".equals(funcType)) {

                List<String> columns = new ArrayList<>();

                for (JsonReader col : JsonReader.fromArray(res.getString("cols"))) {
                    MsColumn column = new MsColumn(col.getString("name"));
                    String argSize = "";
                    String dataType = col.getString("type");
                    int size = col.getInt("size");
                    if ("varbinary".equals(dataType) || dataType.endsWith("varchar")) {
                        argSize = size == -1 ? " (max)" : (" (" + size + ")");
                    } else if ("decimal".equals(dataType) || "numeric".equals(dataType)) {
                        argSize = " (" + col.getInt("pr") + ", " + col.getInt("sc") + ')';
                    }
                    // TODO other type with size

                    column.setType(MsDiffUtils.quoteName(dataType) + argSize);
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
                String argSize = "";
                String dataType = res.getString("return_type");
                int size = res.getInt("return_type_size");
                if ("varbinary".equals(dataType) || dataType.endsWith("varchar")) {
                    argSize = size == -1 ? " (max)" : (" (" + size + ")");
                } else if ("decimal".equals(dataType) || "numeric".equals(dataType)) {
                    argSize = " (" + res.getInt("pr") + ", " + res.getInt("sc") + ')';
                }

                // TODO other type with size
                func.setReturns(MsDiffUtils.quoteName(dataType) + argSize);
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
            loader.setOwner(func, owner);
            schema.addFunction(func);
            loader.setPrivileges(func, JsonReader.fromArray(res.getString("acl")));
        }
    }

    @Override
    protected DbObjType getType() {
        return null;
    }
}
