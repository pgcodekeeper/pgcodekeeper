package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcTimestampLoader;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
import cz.startnet.utils.pgdiff.loader.timestamps.ObjectTimestamp;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_args_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Object_identity_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TimestampsReader implements PgCatalogStrings {
    private final JdbcLoaderBase loader;

    private static final String QUERY = "select * from {0}.show_objects";

    public TimestampsReader(JdbcLoaderBase loader) {
        this.loader = loader;
    }

    public DBTimestamp read() throws SQLException, InterruptedException {
        DBTimestamp time = new DBTimestamp();
        String schemaName = ((JdbcTimestampLoader)loader).getSchema();
        try (ResultSet result = loader.statement.executeQuery(MessageFormat.format(QUERY, schemaName))) {
            while (result.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                fill(result, time);
            }
        }

        return time;
    }

    private void fill(ResultSet res, DBTimestamp time) throws SQLException {
        String type = res.getString("type");
        String identity = res.getString("identity");
        String schema = res.getString("schema");
        String name = res.getString("name");
        Long objId = res.getLong("objid");
        Instant lastModified = res.getTimestamp("last_modified").toInstant();
        GenericColumn column = null;
        ObjectTimestamp object;
        switch (type) {
        case "schema":
            column = new GenericColumn(name, DbObjType.SCHEMA);
            break;
        case "extension":
            column = new GenericColumn(name, DbObjType.EXTENSION);
            break;
        case "type":
            column = new GenericColumn(schema, name, DbObjType.TYPE);
            break;
        case "sequence":
            column = new GenericColumn(schema, name, DbObjType.SEQUENCE);
            break;
        case "function":
            loader.submitAntlrTask(identity, SQLParser::function_args_parser,
                    ctx -> parseFunctionName(ctx, lastModified, time, objId));
            break;
        case "index":
            column = new GenericColumn(schema, null, name, DbObjType.INDEX);
            break;
        case "table":
        case "foreign table":
            column = new GenericColumn(schema, name, DbObjType.TABLE);
            break;
        case "view":
        case "materialized view":
            column = new GenericColumn(schema, name, DbObjType.VIEW);
            break;
        case "rule":
            loader.submitAntlrTask(identity, SQLParser::object_identity_parser,
                    ctx -> parseIdentity(ctx, DbObjType.RULE, lastModified, time, objId));
            break;
        case "trigger":
            loader.submitAntlrTask(identity, SQLParser::object_identity_parser,
                    ctx -> parseIdentity(ctx, DbObjType.TRIGGER, lastModified, time, objId));
            break;
        default: break;
        }

        if (column != null) {
            object = new ObjectTimestamp(column, objId, lastModified);
            time.addObject(object);
        }
    }

    private void parseFunctionName(Function_args_parserContext ctx, Instant lastModified, DBTimestamp time, Long objId) {
        if (ctx != null) {
            List<IdentifierContext> object = ctx.schema_qualified_name().identifier();
            String schema = QNameParser.getSchemaNameCtx(object).getText();
            String name = QNameParser.getFirstName(object);
            PgFunction func = new PgFunction(name, null);
            ParserAbstract.fillArguments(ctx.function_args(), func, schema);
            GenericColumn gc = new GenericColumn(schema, func.getName(), DbObjType.FUNCTION);
            time.addObject(new ObjectTimestamp(gc, objId, lastModified));
        }
    }

    private void parseIdentity(Object_identity_parserContext ctx, DbObjType type,
            Instant lastModified, DBTimestamp time, Long objId) {
        if (ctx != null) {
            String name = ctx.name.getText();
            List<IdentifierContext> parent = ctx.parent.identifier();
            String schema = QNameParser.getSchemaNameCtx(parent).getText();
            String table = QNameParser.getFirstName(parent);
            GenericColumn gc = new GenericColumn(schema, table, name, type);
            time.addObject(new ObjectTimestamp(gc, objId, lastModified));
        }
    }
}