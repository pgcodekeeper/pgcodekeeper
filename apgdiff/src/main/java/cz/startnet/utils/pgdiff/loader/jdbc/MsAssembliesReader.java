package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsAssembly;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsAssembliesReader {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public MsAssembliesReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException, XmlReaderException {
        loader.setCurrentOperation("assemblies query");
        String query = JdbcQueries.QUERY_MS_ASSEMBLIES.get(null);
        try (ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                String name = res.getString("name");
                loader.setCurrentObject(new GenericColumn(name, DbObjType.ASSEMBLY));

                MsAssembly ass = new MsAssembly(name, "");
                for (XmlReader bin : XmlReader.readXML(res.getString("binaries"))) {
                    ass.addBinary(bin.getString("b"));
                }

                ass.setVisible(res.getBoolean("is_visible"));

                int i = res.getInt("permission_set");
                if (i == 2) {
                    ass.setPermission("EXTERNAL_ACCESS");
                } else if (i == 3) {
                    ass.setPermission("UNSAFE");
                }

                loader.setOwner(ass, res.getString("owner"));
                loader.setPrivileges(ass, XmlReader.readXML(res.getString("acl")));

                db.addAssembly(ass);
            }
        }
    }
}
