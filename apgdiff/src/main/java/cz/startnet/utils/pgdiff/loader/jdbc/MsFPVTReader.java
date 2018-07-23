package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsProcedure;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsView;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsFPVTReader extends JdbcMsReader {

    public static class MsFPVTReaderFactory extends JdbcReaderFactory {

        public MsFPVTReaderFactory(Map<SupportedVersion, String> queries) {
            super(0, "", queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new MsFPVTReader(this, loader);
        }
    }

    public MsFPVTReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException {
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
        case "V":
            tt = DbObjType.VIEW;
            break;
        case "P":
            tt = DbObjType.PROCEDURE;
            break;
        default:
            tt = DbObjType.FUNCTION;
            break;
        }

        loader.setCurrentObject(new GenericColumn(schema.getName(), name, tt));
        boolean an = res.getBoolean("ansi_nulls");
        boolean qi = res.getBoolean("quotedIdentifier");

        String def = res.getString("definition");
        String owner = res.getString("owner");
        PgDatabase db = schema.getDatabase();

        if (tt == DbObjType.TRIGGER) {
            loader.submitMsAntlrTask(def, p -> p.tsql_file().batch(0).sql_clauses()
                    .st_clause(0).ddl_clause().schema_create().create_or_alter_trigger(),
                    ctx -> setOwner(new CreateMsTrigger(ctx, db, an, qi).getObject(), owner));
        } else if (tt == DbObjType.VIEW) {
            loader.submitMsAntlrTask(def, p -> p.tsql_file().batch(0).sql_clauses()
                    .st_clause(0).ddl_clause().schema_create().create_or_alter_view(),
                    ctx -> setOwner(new CreateMsView(ctx, db, an, qi).getObject(), owner));
        } else if (tt == DbObjType.PROCEDURE) {
            loader.submitMsAntlrTask(def, p -> p.tsql_file().batch(0).sql_clauses()
                    .st_clause(0).ddl_clause().schema_create().create_or_alter_procedure(),
                    ctx -> setOwner(new CreateMsProcedure(ctx, db, an, qi).getObject(), owner));
        } else {
            loader.submitMsAntlrTask(def, p -> p.tsql_file().batch(0).sql_clauses()
                    .st_clause(0).ddl_clause().schema_create().create_or_alter_function(),
                    ctx -> setOwner(new CreateMsFunction(ctx, db, an, qi).getObject(), owner));
        }

        // loader.setPrivileges(s, res.getString("aclarray"));
    }

    private void setOwner(PgStatement st, String owner) {
        if (!loader.args.isIgnorePrivileges()) {
            st.setOwner(owner == null ? ApgdiffConsts.SCHEMA_OWNER : owner);
        }
    }

    @Override
    protected DbObjType getType() {
        return null;
    }
}
