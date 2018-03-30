package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_args_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Object_identity_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TimestampsReader implements PgCatalogStrings {
    private final JdbcLoaderBase loader;

    private static final String QUERY = "select * from {0}.dbots_object_timestamps";

    public TimestampsReader(JdbcLoaderBase loader) {
        this.loader = loader;
    }

    public DBTimestamp read() throws SQLException, InterruptedException {
        DBTimestamp time = new DBTimestamp();
        String schemaName = loader.getExtensionSchema();
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
        long objId = res.getLong("objid");
        Instant lastModified = res.getTimestamp("last_modified").toInstant();
        String author = res.getString("author");
        GenericColumn column = null;
        switch (type) {
        case "schema":
            column = new GenericColumn(name, DbObjType.SCHEMA);
            break;
        case "extension":
            column = new GenericColumn(name, DbObjType.EXTENSION);
            break;
        case "type":
        case "composite type":
            column = new GenericColumn(schema, name, DbObjType.TYPE);
            break;
        case "sequence":
            column = new GenericColumn(schema, name, DbObjType.SEQUENCE);
            break;
        case "function":
            loader.submitAntlrTask(identity, SQLParser::function_args_parser,
                    ctx -> parseFunctionName(ctx, lastModified, time, objId, author));
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
                    ctx -> parseIdentity(ctx, DbObjType.RULE, lastModified, time, objId, author));
            break;
        case "trigger":
            loader.submitAntlrTask(identity, SQLParser::object_identity_parser,
                    ctx -> parseIdentity(ctx, DbObjType.TRIGGER, lastModified, time, objId, author));
            break;
        default: break;
        }

        if (column != null) {
            time.addObject(column, objId, lastModified, author);
        }
    }

    private void parseFunctionName(Function_args_parserContext ctx,
            Instant lastModified, DBTimestamp time, long objId, String author) {
        if (ctx != null) {
            List<IdentifierContext> object = ctx.schema_qualified_name().identifier();
            String schema = QNameParser.getSchemaNameCtx(object).getText();
            String name = QNameParser.getFirstName(object);
            GenericColumn gc = new GenericColumn(schema, ParserAbstract
                    .parseSignature(name, ctx.function_args()), DbObjType.FUNCTION);
            time.addObject(gc, objId, lastModified, author);
        }
    }

    private void parseIdentity(Object_identity_parserContext ctx, DbObjType type,
            Instant lastModified, DBTimestamp time, long objId, String author) {
        if (ctx != null) {
            String name = ctx.name.getText();
            List<IdentifierContext> parent = ctx.parent.identifier();
            String schema = QNameParser.getSchemaNameCtx(parent).getText();
            String table = QNameParser.getFirstName(parent);
            GenericColumn gc = new GenericColumn(schema, table, name, type);
            time.addObject(gc, objId, lastModified, author);
        }
    }
}