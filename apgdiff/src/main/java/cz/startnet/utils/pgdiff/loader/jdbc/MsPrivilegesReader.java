package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;

// TODO move to queries
public class MsPrivilegesReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;

    public MsPrivilegesReader(JdbcLoaderBase loader) {
        this.loader = loader;
    }

    public void read() throws SQLException, InterruptedException  {
        loader.setCurrentOperation("privileges query");

        String query = JdbcQueries.QUERY_MS_PRIVILEGES.get(null);
        try (ResultSet r = loader.runner.runScript(loader.statement, query)) {
            while (r.next()) {
                readPrivilege(r, loader.schemaIds.get(r.getLong("schema_oid")));
            }
        }
    }

    private void readPrivilege(ResultSet res, PgSchema schema) throws SQLException {
        loader.monitor.worked(1);
        String name = res.getString("name");
        String state = res.getString("state_desc");
        String permission = res.getString("permission_name");
        String role = res.getString("role_name");

        boolean isWithGrantOption = false;
        if ("GRANT_WITH_GRANT_OPTION".equals(state)) {
            state = "GRANT";
            isWithGrantOption = true;
        }

        PgStatement st = schema.getChildren().filter(e -> e.getBareName().equals(name)).findFirst().orElse(null);
        if (st != null) {
            st.addPrivilege(new PgPrivilege(state, permission,
                    "OBJECT::" + MsDiffUtils.quoteName(schema.getName()) + '.'
                    + MsDiffUtils.quoteName(st.getName()),
                    MsDiffUtils.quoteName(role), isWithGrantOption));
        }
        // TODO column privileges
    }
}
