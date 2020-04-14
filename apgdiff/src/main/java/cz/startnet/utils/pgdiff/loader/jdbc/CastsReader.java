package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.ICast.CastContext;
import cz.startnet.utils.pgdiff.schema.PgCast;
import cz.startnet.utils.pgdiff.schema.PgCast.CastMethod;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CastsReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public CastsReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("casts query");
        String query = loader.appendTimestamps(JdbcQueries.QUERY_CASTS.getQuery());

        try (ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                PgCast cast = getCast(res);
                db.addCast(cast);
                loader.setAuthor(cast, res);
            }
        }
    }

    private PgCast getCast(ResultSet res) throws SQLException {
        String source = res.getString("source");
        JdbcReader.checkTypeValidity(source);
        String target = res.getString("target");
        JdbcReader.checkTypeValidity(target);

        PgCast cast = new PgCast(source, target);
        loader.setCurrentObject(new GenericColumn(cast.getName(), DbObjType.CAST));

        addDep(cast, source);
        addDep(cast, target);

        String type = res.getString("castcontext");
        switch (type) {
        case "e":
            cast.setContext(CastContext.EXPLICIT);
            break;
        case "a":
            cast.setContext(CastContext.ASSIGNMENT);
            break;
        case "i":
            cast.setContext(CastContext.IMPLICIT);
            break;
        default:
            throw new IllegalStateException("Unknown cast context: " + type);
        }


        String method = res.getString("castmethod");
        switch (method) {
        case "f":
            cast.setMethod(CastMethod.FUNCTION);
            String function = res.getString("func");
            JdbcReader.checkObjectValidity(function, DbObjType.CAST, cast.getName());
            cast.setFunction(function);
            loader.submitAntlrTask(function, SQLParser::function_args_parser, ctx -> {
                List<IdentifierContext> ids = ctx.schema_qualified_name().identifier();
                String schemaName = QNameParser.getSchemaName(ids);
                if (schemaName != null && !ApgdiffUtils.isPgSystemSchema(schemaName)) {
                    String funcName = ParserAbstract.parseSignature(
                            QNameParser.getFirstName(ids), ctx.function_args());
                    cast.addDep(new GenericColumn(schemaName, funcName, DbObjType.FUNCTION));
                }
            });

            break;
        case "i":
            cast.setMethod(CastMethod.INOUT);
            break;
        case "b":
            cast.setMethod(CastMethod.BINARY);
            break;
        default:
            throw new IllegalStateException("Unknown cast method: " + type);
        }

        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            cast.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        return cast;
    }

    private void addDep(PgStatement statement, String objectName) {
        if (objectName.indexOf('.') != -1) {
            QNameParser<IdentifierContext> parser = QNameParser.parsePg(objectName);
            String schemaName = parser.getSchemaName();
            if (schemaName != null && !ApgdiffUtils.isPgSystemSchema(schemaName)) {
                statement.addDep(new GenericColumn(schemaName, parser.getFirstName(), DbObjType.TYPE));
            }
        }
    }
}