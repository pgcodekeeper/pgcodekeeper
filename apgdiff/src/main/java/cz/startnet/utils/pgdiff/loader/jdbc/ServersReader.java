package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgServer;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ServersReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public ServersReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("server_query");
        String query = JdbcQueries.QUERY_SERVERS.makeQuery(loader, "pg_foreign_server");
        try(ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                PgServer server = getServer(res);
                db.addServer(server);
                loader.setAuthor(server, res);
                loader.setOwner(server, res.getLong("srvowner"));
            }
        }
    }

    private PgServer getServer(ResultSet res) throws SQLException {
        String srvName = res.getString("srvname");
        loader.setCurrentObject(new GenericColumn(srvName, DbObjType.SERVER));
        PgServer srv = new PgServer(srvName);
        srv.setFdw(res.getString("fdwname"));
        String srvType = res.getString("srvtype");
        if (srvType != null) {
            srv.setType(PgDiffUtils.quoteString(srvType));
        }

        String srvVersion = res.getString("srvversion");
        if (srvVersion != null) {
            srv.setVersion(PgDiffUtils.quoteString(srvVersion));
        }

        if (res.getString("srvoptions") != null) {
            Array arr = res.getArray("srvoptions");
            String[] options = (String[]) arr.getArray();
            ParserAbstract.fillOptionParams(options, srv::addOption, false, true, false);
        }
        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            srv.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        return srv;
    }
}
