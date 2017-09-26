package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
import cz.startnet.utils.pgdiff.loader.timestamps.ObjectTimestamp;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Object_identity_parserContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TimestampsReader implements PgCatalogStrings {
    private final JdbcLoaderBase loader;
    private final String schemaName;

    private static final String QUERY = "select * from {0}.show_objects";

    public TimestampsReader(JdbcLoaderBase loader, String schemaName) {
        this.loader = loader;
        this.schemaName = schemaName;
    }

    public DBTimestamp read() throws SQLException, InterruptedException {
        DBTimestamp time = new DBTimestamp();
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
        GenericColumn gc = null;
        ObjectTimestamp ot;
        switch (type) {
        case "schema":
            gc = new GenericColumn(null, name, DbObjType.SCHEMA);
            break;
        case "extension":
            gc = new GenericColumn(null, name, DbObjType.EXTENSION);
            break;
        case "type":
            gc = new GenericColumn(schema, name, DbObjType.TYPE);
            break;
        case "sequence":
            gc = new GenericColumn(schema, name, DbObjType.SEQUENCE);
            break;
        case "function":
            gc = new GenericColumn(schema, name, DbObjType.FUNCTION);
            break;
        case "table":
        case "foreign table":
            gc = new GenericColumn(schema, name, DbObjType.TABLE);
            break;
        case "view":
        case "materialized view":
            gc = new GenericColumn(schema, name, DbObjType.VIEW);
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

        if (gc != null) {
            ot = new ObjectTimestamp(gc, objId, lastModified);
            time.addObject(ot);
        }
    }

    private void parseIdentity(Object_identity_parserContext ctx, DbObjType type,
            Instant lastModified, DBTimestamp time, Long objId) {
        if (ctx != null) {
            String name = ctx.name.getText();
            List<IdentifierContext> parent = ctx.parent.identifier();
            String schema = QNameParser.getSchemaNameCtx(parent).getText();
            String table = QNameParser.getSecondName(parent);
            GenericColumn gc = new GenericColumn(schema, table, name, type);
            time.addObject(new ObjectTimestamp(gc, objId, lastModified));
        }
    }
}