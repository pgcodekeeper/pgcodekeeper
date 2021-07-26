package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgForeignDataWrapper;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ForeignDataWrappersReader implements PgCatalogStrings {
    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public ForeignDataWrappersReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("foreign_data_wrapper query");
        String query = JdbcQueries.QUERY_FOREIGN_DATA_WRAPPERS
                .makeQuery(loader, "pg_foreign_data_wrapper");
        try (ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                PgForeignDataWrapper foreignDW = getForeignDW(res);
                db.addForeignDW(foreignDW);
                loader.setAuthor(foreignDW, res);
            }
        }
    }

    private PgForeignDataWrapper getForeignDW(ResultSet res) throws SQLException {
        String fdwName = res.getString("fdwname");
        loader.setCurrentObject(new GenericColumn(fdwName, DbObjType.FOREIGN_DATA_WRAPPER));
        PgForeignDataWrapper f = new PgForeignDataWrapper(fdwName);

        String fdwHandler = res.getString("fdwhandler");

        if (!"-".equals(fdwHandler)) {
            f.setHandler(res.getString("fdwhandler"));
        }
        String fdwValidator = res.getString("fdwvalidator");
        if (!"-".equals(fdwValidator)) {
            f.setValidator(fdwValidator);
        }
        if (res.getString("fdwoptions") != null) {
            Array arr = res.getArray("fdwoptions");
            String[] options = (String[]) arr.getArray();
            ParserAbstract.fillOptionParams(options, f::addOption, false, true, false);
        }
        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            f.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        return f;
    }
}
