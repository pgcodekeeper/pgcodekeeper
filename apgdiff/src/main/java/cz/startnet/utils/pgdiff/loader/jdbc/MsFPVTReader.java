package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.BiConsumer;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsProcedure;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsView;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsFPVTReader extends JdbcReader {

    public MsFPVTReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_FUNCTIONS_PROCEDURES_VIEWS_TRIGGERS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, JsonReaderException {
        loader.monitor.worked(1);
        String name = res.getString("name");

        String type = res.getString("type");
        DbObjType tt;

        // TR - SQL trigger
        // V - View
        // P - SQL Stored Procedure
        // IF - SQL inline table-valued function
        // FN - SQL scalar function
        // TF - SQL table-valued-function
        switch (type) {
        case "TR":
            tt = DbObjType.TRIGGER;
            break;
        case "V ":
            tt = DbObjType.VIEW;
            break;
        case "P ":
            tt = DbObjType.PROCEDURE;
            break;
        default:
            tt = DbObjType.FUNCTION;
            break;
        }

        loader.setCurrentObject(new GenericColumn(schema.getName(), name, tt));
        boolean an = res.getBoolean("ansi_nulls");
        boolean qi = res.getBoolean("quoted_identifier");
        boolean isDisable = res.getBoolean("is_disabled");

        String def = res.getString("definition");
        String owner = res.getString("owner");

        List<JsonReader> acls = JsonReader.fromArray(res.getString("acl"));

        PgDatabase db = schema.getDatabase();

        BiConsumer<PgStatementWithSearchPath, List<JsonReader>> cons = (st, acl) -> {
            try {
                loader.setPrivileges(st, acl);
            } catch (JsonReaderException e) {
                Log.log(e);
            }
        };

        if (tt == DbObjType.TRIGGER) {
            loader.submitMsAntlrTask(def, p -> p.tsql_file().batch(0).sql_clauses()
                    .st_clause(0).ddl_clause().schema_create().create_or_alter_trigger(),
                    ctx -> {
                        MsTrigger tr = (MsTrigger) new CreateMsTrigger(ctx, db, an, qi).getObject();
                        tr.setDisable(isDisable);
                    });
        } else if (tt == DbObjType.VIEW) {
            loader.submitMsAntlrTask(def, p -> p.tsql_file().batch(0).sql_clauses()
                    .st_clause(0).ddl_clause().schema_create().create_or_alter_view(),
                    ctx -> {
                        PgStatement st = new CreateMsView(ctx, db, an, qi).getObject();
                        loader.setOwner(st, owner);
                        cons.accept((PgStatementWithSearchPath)st, acls);
                    });
        } else if (tt == DbObjType.PROCEDURE) {
            loader.submitMsAntlrTask(def, p -> p.tsql_file().batch(0).sql_clauses()
                    .st_clause(0).ddl_clause().schema_create().create_or_alter_procedure(),
                    ctx -> {
                        PgStatement st = new CreateMsProcedure(ctx, db, an, qi).getObject();
                        loader.setOwner(st, owner);
                        cons.accept((PgStatementWithSearchPath)st, acls);
                    });
        } else {
            loader.submitMsAntlrTask(def, p -> p.tsql_file().batch(0).sql_clauses()
                    .st_clause(0).ddl_clause().schema_create().create_or_alter_function(),
                    ctx -> {
                        PgStatement st = new CreateMsFunction(ctx, db, an, qi).getObject();
                        loader.setOwner(st, owner);
                        cons.accept((PgStatementWithSearchPath)st, acls);
                    });
        }
    }
}
