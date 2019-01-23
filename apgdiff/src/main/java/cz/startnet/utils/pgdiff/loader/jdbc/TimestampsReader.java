package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.timestamps.ObjectTimestamp;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_args_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Object_identity_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_args_parserContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TimestampsReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;
    private final Map<GenericColumn, ObjectTimestamp> objects = new HashMap<>();

    public TimestampsReader(JdbcLoaderBase loader) {
        this.loader = loader;
    }

    public Collection<ObjectTimestamp> read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("pg_dbo_timestamp query");
        String schemaName = PgDiffUtils.getQuotedName(loader.getExtensionSchema());
        String query =  MessageFormat.format(JdbcQueries.QUERY_TIMESTAMPS, schemaName);
        try (ResultSet result = loader.runner.runScript(loader.statement, query)) {
            while (result.next()) {
                fill(result);
            }
        }

        return objects.values();
    }

    private void fill(ResultSet res) throws SQLException {
        String type = res.getString("type");
        String identity = res.getString("identity");
        String schema = res.getString("schema");
        String name = res.getString("name");
        if (name != null && name.startsWith("\"")) {
            name = PgDiffUtils.unquoteQuotedName(name);
        }
        long objId = res.getLong("objid");
        Instant lastModified = res.getTimestamp("last_modified").toInstant();
        String author = res.getString("ses_user");

        String acl = res.getString("acl");
        Map<String, String> colAcls;
        Array arr = res.getArray("colacls");
        if (arr != null) {
            String[] acls = (String[]) arr.getArray();
            String[] names = (String[]) res.getArray("colnames").getArray();
            colAcls = new HashMap<>();
            for (int i = 0; i < acls.length; ++i) {
                colAcls.put(names[i], acls[i]);
            }
        } else {
            colAcls = null;
        }

        GenericColumn column = null;
        switch (type) {
        case "schema":
            column = new GenericColumn(name, DbObjType.SCHEMA);
            break;
        case "extension":
            column = new GenericColumn(name, DbObjType.EXTENSION);
            break;
        case "type":
            //case "composite type":
            column = new GenericColumn(schema, name, DbObjType.TYPE);
            break;
        case "sequence":
            column = new GenericColumn(schema, name, DbObjType.SEQUENCE);
            break;
        case "function":
            loader.submitAntlrTask(identity, SQLParser::function_args_parser,
                    ctx -> parseFunctionName(ctx, lastModified, objId, author, acl, colAcls, true));
            break;
        case "procedure":
            loader.submitAntlrTask(identity, SQLParser::function_args_parser,
                    ctx -> parseFunctionName(ctx, lastModified, objId, author, acl, colAcls, false));
            break;
        case "operator":
            loader.submitAntlrTask(identity, SQLParser::operator_args_parser,
                    ctx -> parseOperName(schema, ctx, lastModified, objId, author, acl, colAcls));
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
        case "text search template":
            column = new GenericColumn(schema, name, DbObjType.FTS_TEMPLATE);
            break;
        case "text search parser":
            column = new GenericColumn(schema, name, DbObjType.FTS_PARSER);
            break;
        case "text search configuration":
            column = new GenericColumn(schema, name, DbObjType.FTS_CONFIGURATION);
            break;
        case "text search dictionary":
            column = new GenericColumn(schema, name, DbObjType.FTS_DICTIONARY);
            break;
        case "rule":
            loader.submitAntlrTask(identity, SQLParser::object_identity_parser,
                    ctx -> parseIdentity(ctx, DbObjType.RULE,
                            lastModified, objId, author, acl, colAcls));
            break;
        case "trigger":
            loader.submitAntlrTask(identity, SQLParser::object_identity_parser,
                    ctx -> parseIdentity(ctx, DbObjType.TRIGGER,
                            lastModified, objId, author, acl, colAcls));
            break;
        default: break;
        }

        if (column != null) {
            addObject(column, objId, lastModified, author, acl, colAcls);
        }
    }

    private void parseFunctionName(Function_args_parserContext ctx,
            Instant lastModified, long objId, String author, String acl,
            Map<String, String> colAcls, boolean isFunc) {
        if (ctx != null) {
            List<IdentifierContext> object = ctx.schema_qualified_name().identifier();
            String schema = QNameParser.getSchemaNameCtx(object).getText();
            String name = QNameParser.getFirstName(object);
            GenericColumn gc = new GenericColumn(schema, ParserAbstract
                    .parseSignature(name, ctx.function_args()),
                    isFunc ? DbObjType.FUNCTION : DbObjType.PROCEDURE);
            addObject(gc, objId, lastModified, author, acl, colAcls);
        }
    }

    private void parseOperName(String schemaName, Operator_args_parserContext ctx,
            Instant lastModified, long objId, String author, String acl,
            Map<String, String> colAcls) {
        if (ctx != null) {
            Target_operatorContext targerOperCtx = ctx.target_operator();
            Operator_nameContext operNameCtx = targerOperCtx.operator_name();
            IdentifierContext schemaCtx = operNameCtx.schema_name;
            GenericColumn gc = new GenericColumn(schemaCtx != null ? schemaCtx.getText() : schemaName,
                    ParserAbstract.parseSignature(operNameCtx.operator.getText(), targerOperCtx),
                    DbObjType.OPERATOR);
            addObject(gc, objId, lastModified, author, acl, colAcls);
        }
    }

    private void parseIdentity(Object_identity_parserContext ctx, DbObjType type,
            Instant lastModified, long objId, String author, String acl,
            Map<String, String> colAcls) {
        if (ctx != null) {
            String name = ctx.name.getText();
            List<IdentifierContext> parent = ctx.parent.identifier();
            String schema = QNameParser.getSchemaNameCtx(parent).getText();
            String table = QNameParser.getFirstName(parent);
            GenericColumn gc = new GenericColumn(schema, table, name, type);
            addObject(gc, objId, lastModified, author, acl, colAcls);
        }
    }

    /**
     * Added object from jdbc to objects map. <br>
     * WARNING: if objects already present in map, newest version of objects will be saved
     *
     * @param column - object definition
     * @param objId - object id
     * @param lastModified - last object modified time
     * @param author - modify author
     * @param acl - objects privileges
     * @param colAcls - object columns privileges
     */
    private void addObject(GenericColumn column, long objId, Instant lastModified,
            String author, String acl, Map<String, String> colAcls) {
        ObjectTimestamp obj = objects.get(column);
        if (obj == null || obj.getTime().compareTo(lastModified) < 1) {
            objects.put(column, new ObjectTimestamp(column, objId, lastModified, author,
                    acl, colAcls));
        }
    }
}