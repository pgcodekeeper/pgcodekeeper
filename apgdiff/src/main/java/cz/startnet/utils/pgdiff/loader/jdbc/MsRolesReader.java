package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsRole;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsRolesReader {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public MsRolesReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException, XmlReaderException {
        loader.setCurrentOperation("roles query");
        String query = JdbcQueries.QUERY_MS_ROLES.get(null);
        try (ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                String name = res.getString("name");
                loader.setCurrentObject(new GenericColumn(name, DbObjType.ROLE));

                MsRole role = new MsRole(name, "");
                loader.setOwner(role, res.getString("owner"));

                for (XmlReader group : XmlReader.readXML(res.getString("groups"))) {
                    role.addMember(group.getString("m"));
                }

                loader.setPrivileges(role, XmlReader.readXML(res.getString("acl")));

                db.addRole(role);
            }
        }
    }
}
