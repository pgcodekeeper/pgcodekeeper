package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgUserMapping;

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
        String user  = res.getString("username");
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