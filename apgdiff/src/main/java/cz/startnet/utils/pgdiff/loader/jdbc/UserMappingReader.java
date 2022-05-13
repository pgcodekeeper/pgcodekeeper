package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgUserMapping;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class UserMappingReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public UserMappingReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("user_mapping_query");
        String query = JdbcQueries.QUERY_USER_MAPPING.makeQuery(loader, "pg_user_mapping");
        try (ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                PgUserMapping usm = getUserMapping(res);
                db.addUserMapping(usm);
                loader.setAuthor(usm, res);
            }
        }
    }

    private PgUserMapping getUserMapping(ResultSet res) throws SQLException {
        String user  = loader.getRoleByOid(res.getLong("username"));
        String server = res.getString("servername");
        PgUserMapping usm = new PgUserMapping(user, server);

        loader.setCurrentObject(new GenericColumn(usm.getName(), DbObjType.USER_MAPPING));
        usm.addDep(new GenericColumn(usm.getServer(), DbObjType.SERVER));

        String[] options = JdbcReader.getColArray(res, "umoptions");
        if (options != null) {
            ParserAbstract.fillOptionParams(options, usm::addOption, false, true, false);
        }
        return usm;
    }
}