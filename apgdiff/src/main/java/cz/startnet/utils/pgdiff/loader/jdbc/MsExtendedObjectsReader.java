package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsFunction;
import cz.startnet.utils.pgdiff.schema.MsFunction.MsArgument;
import cz.startnet.utils.pgdiff.schema.MsProcedure;
import cz.startnet.utils.pgdiff.schema.MsProcedure.ProcedureArgument;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsExtendedObjectsReader extends JdbcMsReader {

    public static class MsExtendedObjectsReaderFactory extends JdbcReaderFactory {

        public MsExtendedObjectsReaderFactory(Map<SupportedVersion, String> queries) {
            super(0, "", queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new MsExtendedObjectsReader(this, loader);
        }
    }

    public MsExtendedObjectsReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException, WrapperAccessException {
        loader.monitor.worked(1);
        String name = res.getString("name");
        DbObjType type = "PC".equals(res.getString("type")) ? DbObjType.PROCEDURE : DbObjType.FUNCTION;
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
                if ("nvarchar".equals(dataType)) {
                    argSize = size == -1 ? "(max)" : ("(" + size + ")");
                }
                // TODO precision, scale

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
            setOwner(proc, owner);
        } else {
            MsFunction func = new MsFunction(name, "");

            for (JsonReader arg : args) {
                String argSize = "";
                String dataType = arg.getString("type");
                int size = arg.getInt("size");
                if ("nvarchar".equals(dataType)) {
                    argSize = size == -1 ? "(max)" : ("(" + size + ")");
                }
                // TODO precision, scale

                MsArgument argDst = func.new MsArgument(arg.getBoolean("ou") ? "OUTPUT" : null,
                        arg.getString("name"), MsDiffUtils.quoteName(dataType) + argSize);

                if (arg.getBoolean("hd")) {
                    argDst.setDefaultExpression(arg.getString("dv"));
                }

                // TODO add to argument nullable ?
                func.addArgument(argDst);
            }

            StringBuilder sb = new StringBuilder();

            sb.append(" WITH EXECUTE AS ");
            sb.append((executeAs == null ? "CALLER" : executeAs));
            if (nullOnNullInput) {
                sb.append(", RETURNS NULL ON NULL INPUT");
            }
            sb.append("\nAS\n");
            sb.append(body);
            func.setBody(sb.toString());
            setOwner(func, owner);
        }
    }

    private void setOwner(PgStatement st, String owner) {
        if (!loader.args.isIgnorePrivileges()) {
            st.setOwner(owner == null ? ApgdiffConsts.SCHEMA_OWNER : owner);
        }
    }

    @Override
    protected DbObjType getType() {
        return null;
    }
}
