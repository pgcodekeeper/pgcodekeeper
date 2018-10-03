package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.BiConsumer;

import org.antlr.v4.runtime.CommonTokenStream;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_procedureContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_viewContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsProcedure;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsView;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsFunction;
import cz.startnet.utils.pgdiff.schema.MsProcedure;
import cz.startnet.utils.pgdiff.schema.MsTrigger;
import cz.startnet.utils.pgdiff.schema.MsView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsFPVTReader extends JdbcReader {

    public MsFPVTReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_FUNCTIONS_PROCEDURES_VIEWS_TRIGGERS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
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

        List<XmlReader> acls = XmlReader.readXML(res.getString("acl"));

        PgDatabase db = schema.getDatabase();

        BiConsumer<PgStatementWithSearchPath, List<XmlReader>> cons = (st, acl) -> {
            try {
                loader.setPrivileges(st, acl);
            } catch (XmlReaderException e) {
                Log.log(e);
            }
        };

        if (tt == DbObjType.TRIGGER) {
            loader.submitMsAntlrTask(def, p -> {
                Create_or_alter_triggerContext ctx = p.tsql_file().batch(0)
                        .batch_statement().batch_statement_body().create_or_alter_trigger();
                return new CreateMsTrigger(ctx, db, an, qi, (CommonTokenStream) p.getInputStream());
            }, creator -> {
                MsTrigger tr = creator.getObject(schema);
                tr.setDisable(isDisable);
            });
        } else if (tt == DbObjType.VIEW) {
            loader.submitMsAntlrTask(def, p -> {
                Create_or_alter_viewContext ctx = p.tsql_file().batch(0)
                        .batch_statement().batch_statement_body().create_or_alter_view();
                return new CreateMsView(ctx, db, an, qi, (CommonTokenStream) p.getInputStream());
            }, creator -> {
                MsView st = creator.getObject(schema);
                loader.setOwner(st, owner);
                cons.accept(st, acls);
            });
        } else if (tt == DbObjType.PROCEDURE) {
            loader.submitMsAntlrTask(def, p -> {
                Create_or_alter_procedureContext ctx = p.tsql_file().batch(0)
                        .batch_statement().batch_statement_body().create_or_alter_procedure();
                return new CreateMsProcedure(ctx, db, an, qi, (CommonTokenStream) p.getInputStream());
            }, creator -> {
                MsProcedure st = creator.getObject(schema);
                loader.setOwner(st, owner);
                cons.accept(st, acls);
            });
        } else {
            loader.submitMsAntlrTask(def, p -> {
                Create_or_alter_functionContext ctx = p.tsql_file().batch(0)
                        .batch_statement().batch_statement_body().create_or_alter_function();
                return new CreateMsFunction(ctx, db, an, qi, (CommonTokenStream) p.getInputStream());
            }, creator -> {
                MsFunction st = creator.getObject(schema);
                loader.setOwner(st, owner);
                cons.accept(st, acls);
            });
        }
    }
}
