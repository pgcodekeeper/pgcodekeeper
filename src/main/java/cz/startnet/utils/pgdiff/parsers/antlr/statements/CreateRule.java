package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Col_rulesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_parametersContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class CreateRule extends ParserAbstract {
    private Rule_commonContext ctx;

    public CreateRule(Rule_commonContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        if (db.getArguments().isIgnorePrivileges()) {
            return null;
        }
        String col_rule = "";
        DbObjType type = null;
        List<Schema_qualified_nameContext> obj_name = new ArrayList<>();
        List<IdentifierContext> col_names = new ArrayList<>();
        if (ctx.body_rule.body_rules_rest().obj_name != null) {
            obj_name = ctx.body_rule.body_rules_rest().obj_name.name;
        } else if (ctx.body_rule.on_table() != null) {
            type = DbObjType.TABLE;
            obj_name = ctx.body_rule.on_table().obj_name.name;
        } else if (ctx.body_rule.on_column() != null) {
            type = DbObjType.COLUMN;
            obj_name = ctx.body_rule.on_column().on_col_table().obj_name.name;
            col_names = ctx.body_rule.on_column().column;
            for (Col_rulesContext rul : ctx.body_rule.on_column().col_rules()) {
                col_rule += rul.getText();
            }
            col_rule += "({0}) "
                    + getFullCtxText(ctx.body_rule.on_column().on_col_table())
                            + " " + getFullCtxText(ctx.body_rule.body_rules_rest());
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
                PgFunction func = new PgFunction(getName(functparam.name), null);
                fillArguments(functparam.function_args(), func, getDefSchemaName());
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
        } else if (ctx.body_rule.on_type() != null) {
            type = DbObjType.TYPE;
            obj_name = ctx.body_rule.on_type().obj_name.name;
        } else if (ctx.body_rule.on_domain() != null) {
            type = DbObjType.DOMAIN;
            obj_name = ctx.body_rule.on_domain().obj_name.name;
        }

        
        for (Schema_qualified_nameContext name : obj_name) {
            addToDB(name, type, new PgPrivilege(ctx.REVOKE() != null,
                    col_rule.isEmpty() ? getFullCtxText(ctx.body_rule) : col_rule, getFullCtxText(ctx)),
                    col_names);
        }

        return null;
    }

    private PgStatement addToDB(Schema_qualified_nameContext name,
            DbObjType type, PgPrivilege pgPrivilege, List<IdentifierContext> col_names) {
        if (type == null) {
            return null;
        }
        String firstPart = getName(name);
        String secondPart = getTableName(name);
        String thirdPart = getSchemaName(name);
        String schemaName = secondPart == null ? getDefSchemaName() : secondPart; 
        PgStatement statement = null;
        switch (type) {
        case TABLE:
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
        case COLUMN:
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
            if (statement.getStatementType() == DbObjType.TABLE) {
                PgTable tbl = (PgTable) statement;
                for (IdentifierContext col_name : col_names) {
                    PgColumn col = tbl.getColumn(col_name.getText());
                    if (col != null) {
                        String privTxt = MessageFormat.format(pgPrivilege.getDefinition(), col.getName());
                        col.addPrivilege(new PgPrivilege(
                                pgPrivilege.isRevoke(), privTxt, pgPrivilege
                                        .getRawStatement()));
                    }
                }
                return statement;
            }
        case SEQUENCE:
            statement = db.getSchema(schemaName).getSequence(firstPart);
            break;
        case DATABASE:
            statement = db;
            break;
        case SCHEMA:
            schemaName = null;
            statement = db.getSchema(firstPart);
            break;
        case TYPE:
            statement = db.getSchema(schemaName).getType(firstPart);
            break;
        case DOMAIN:
            statement = db.getSchema(schemaName).getDomain(firstPart);
            break;
        default:
            break;
        }
        if (statement != null) {
            statement.addPrivilege(pgPrivilege);
            return statement;
        }
        return null;
    }
}
