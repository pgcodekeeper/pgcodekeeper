package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsPrivilegesReader extends JdbcMsReader {

    public static class MsPrivilegesReaderFactory extends JdbcReaderFactory {

        public MsPrivilegesReaderFactory(Map<SupportedVersion, String> queries) {
            super(0, "", queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new MsPrivilegesReader(this, loader);
        }
    }

    public MsPrivilegesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException, WrapperAccessException {
        loader.monitor.worked(1);
        String name = res.getString("name");

        // TODO can be DENY, REVOKE, GRANT, GRANT_WITH_GRANT_OPTION
        boolean isGrant = "GRANT".equals(res.getString("state_desc"));
        String permission = res.getString("permission_name");
        String role = res.getString("role_name");

        String definition = permission + " ON  " + MsDiffUtils.quoteName(schema.getName())
        + '.' + MsDiffUtils.quoteName(name) + " TO " + MsDiffUtils.quoteName(role);

        PgStatement st = schema.getChildren().filter(e -> e.getName().equals(name)).findAny().orElse(null);
        if (st != null) {
            st.addPrivilege(new PgPrivilege(!isGrant, definition));
        }
    }

    @Override
    protected DbObjType getType() {
        return null;
    }
}
