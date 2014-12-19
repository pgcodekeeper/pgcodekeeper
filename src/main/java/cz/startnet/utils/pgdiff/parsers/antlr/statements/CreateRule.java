package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_parametersContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgRuleCommon;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateRule extends ParserAbstract {
    private Rule_commonContext ctx;

    public CreateRule(Rule_commonContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        DbObjType type = null;
        List<Schema_qualified_nameContext> obj_name = new ArrayList<>();
        if (ctx.body_rule.obj_name != null) {
            obj_name = ctx.body_rule.obj_name.name;
        } else if (ctx.body_rule.on_table() != null) {
            type = DbObjType.TABLE;
            obj_name = ctx.body_rule.on_table().obj_name.name;
        } else if (ctx.body_rule.on_column() != null) {
            type = DbObjType.COLUMN;
            obj_name = ctx.body_rule.on_column().obj_name.name;
        } else if (ctx.body_rule.on_sequence() != null) {
            type = DbObjType.SEQUENCE;
            obj_name = ctx.body_rule.on_sequence().obj_name.name;
        } else if (ctx.body_rule.on_database() != null) {
            type = DbObjType.DATABASE;
            obj_name = ctx.body_rule.on_database().obj_name.name;
        } else if (ctx.body_rule.on_datawrapper_server_lang() != null) {
            obj_name = ctx.body_rule.on_datawrapper_server_lang().obj_name.name;
        } else if (ctx.body_rule.on_function() != null) {
            type = DbObjType.FUNCTION;
            for (Function_parametersContext functparam : ctx.body_rule.on_function().obj_name) {
                PgFunction func = new PgFunction(getName(functparam.name), null, null);
                fillArguments(functparam.function_args(), func);
                db.getSchema(getDefSchemaName())
                        .getFunction(func.getSignature())
                        .addPrivilege(
                                new PgPrivilege(ctx.REVOKE() != null,
                                        getFullCtxText(ctx.body_rule),
                                        getFullCtxText(ctx)));
            }
        } else if (ctx.body_rule.on_large_object() != null) {
            obj_name = ctx.body_rule.on_large_object().obj_name.name;
        } else if (ctx.body_rule.on_schema() != null) {
            type = DbObjType.SCHEMA;
            obj_name = ctx.body_rule.on_schema().obj_name.name;
        } else if (ctx.body_rule.on_tablespace() != null) {
            obj_name = ctx.body_rule.on_tablespace().obj_name.name;
        }

        
        for (Schema_qualified_nameContext name : obj_name) {
            PgRuleCommon object = new PgRuleCommon(getFullCtxText(ctx));
            object.setBody(getFullCtxText(ctx.body_rule));
            object.setRevoke(ctx.REVOKE() != null);
            object.setObjName(name.getText());
            if (addToDB(name, type, new PgPrivilege(object.isRevoke(),
                    object.getBody(), object.getRawStatement()))) {
                fillObjLocation(object, ctx.getStart().getStartIndex(),
                    getDefSchemaName(), false);
            }
        }

        return null;
    }

    private boolean addToDB(Schema_qualified_nameContext name, DbObjType type, PgPrivilege pgPrivilege) {
        if (type == null) {
            return true;
        }
        String firstPart = getName(name);
        String secondPart = getTableName(name);
        String thirdPart = getSchemaName(name);
        String schemaName = secondPart == null ? getDefSchemaName() : secondPart; 
        PgStatement statement = null;
        switch (type) {
        case TABLE:
        case COLUMN:
            // нашли колонку, суем привилегии в таблицу так как так договорились
            if (thirdPart != null && !thirdPart.equals(secondPart)) {
                schemaName = thirdPart;
                firstPart = secondPart;
            }
            statement = db.getSchema(schemaName).getTable(firstPart);
            if (statement == null) {
                statement = db.getSchema(schemaName).getView(firstPart);
            }
            if (statement == null) {
                statement = db.getSchema(schemaName).getSequence(firstPart);
            }
            break;
        case SEQUENCE:
            statement = db.getSchema(schemaName).getSequence(firstPart);
            break;
        case DATABASE:
            statement = db;
            break;
        case SCHEMA:
            statement = db.getSchema(firstPart);
            break;
        default:
            break;
        }
        if (statement != null) {
            statement.addPrivilege(pgPrivilege);
            return false;
        }
        return true;
    }
}
