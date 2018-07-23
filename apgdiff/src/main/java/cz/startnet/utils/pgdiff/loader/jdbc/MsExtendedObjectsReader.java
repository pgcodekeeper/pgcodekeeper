package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsFunction;
import cz.startnet.utils.pgdiff.schema.MsProcedure;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
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
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException {
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

        if (type == DbObjType.PROCEDURE) {
            MsProcedure proc = new MsProcedure(name, "");
            proc.setBody(body);
            proc.addOption("EXECUTE AS " + (executeAs == null ? "CALLER" : executeAs));
            // TODO add to query
            // proc.setForReplication(i);
            setOwner(proc, owner);
        } else {
            MsFunction func = new MsFunction(name, "");
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
