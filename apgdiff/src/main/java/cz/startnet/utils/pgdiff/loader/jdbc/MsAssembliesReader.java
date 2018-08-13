package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsAssembly;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsAssembliesReader {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public MsAssembliesReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException, JsonReaderException {
        loader.setCurrentOperation("assemblies query");
        String query = JdbcQueries.QUERY_MS_ASSEMBLIES.get(null);
        try (ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                String name = res.getString("name");
                loader.setCurrentObject(new GenericColumn(name, DbObjType.ASSEMBLY));

                //TODO add 0x to beginning if binary
                String content = res.getString("content");
                MsAssembly ass = db.getAssembly(name);

                // problems with varbinaries in json
                if (ass != null) {
                    ass.addBinary(content);
                    continue;
                }

                ass = new MsAssembly(name, "");
                ass.addBinary(content);
                ass.setVisible(res.getBoolean("is_visible"));

                int i = res.getInt("permission_set");
                if (i == 2) {
                    ass.setPermission("EXTERNAL_ACCESS");
                } else if (i == 3) {
                    ass.setPermission("UNSAFE");
                }

                loader.setOwner(ass, res.getString("owner"));

                for (JsonReader acl : JsonReader.fromArray(res.getString("acl"))) {
                    String state = acl.getString("sd");
                    boolean isWithGrantOption = false;
                    if ("GRANT_WITH_GRANT_OPTION".equals(state)) {
                        state = "GRANT";
                        isWithGrantOption = true;
                    }

                    String permission = acl.getString("pn");
                    String role = acl.getString("r");

                    ass.addPrivilege(new PgPrivilege(state, permission,
                            "ASSEMBLY::" + MsDiffUtils.quoteName(ass.getName()),
                            MsDiffUtils.quoteName(role), isWithGrantOption));
                }

                db.addAssembly(ass);
            }
        }
    }
}
