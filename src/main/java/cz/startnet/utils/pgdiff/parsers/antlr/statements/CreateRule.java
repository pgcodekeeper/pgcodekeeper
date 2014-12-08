package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_parametersContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
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
        List<String> obj_name = new ArrayList<>();
        if (ctx.body_rule.obj_name != null) {
            obj_name.addAll(getNames(ctx.body_rule.obj_name.name));
        } else if (ctx.body_rule.on_table() != null) {
            obj_name.addAll(getNames(ctx.body_rule.on_table().obj_name.name));
        } else if (ctx.body_rule.on_column() != null) {
            obj_name.addAll(getNames(ctx.body_rule.on_column().obj_name.name));
        } else if (ctx.body_rule.on_sequence() != null) {
            obj_name.addAll(getNames(ctx.body_rule.on_sequence().obj_name.name));
        } else if (ctx.body_rule.on_database() != null) {
            obj_name.addAll(getNames(ctx.body_rule.on_database().obj_name.name));
        } else if (ctx.body_rule.on_datawrapper_server_lang() != null) {
            obj_name.addAll(getNames(ctx.body_rule.on_datawrapper_server_lang().obj_name.name));
        } else if (ctx.body_rule.on_function() != null) {
            for (Function_parametersContext functparam : ctx.body_rule.on_function().obj_name) {
                PgFunction func = new PgFunction(getName(functparam.name), null, null);
                fillArguments(functparam.function_args(), func);
                obj_name.add(func.getSignature());
            }
        } else if (ctx.body_rule.on_large_object() != null) {
            obj_name.addAll(getNames(ctx.body_rule.on_large_object().obj_name.name));
        } else if (ctx.body_rule.on_schema() != null) {
            obj_name.addAll(getNames(ctx.body_rule.on_schema().obj_name.name));
        } else if (ctx.body_rule.on_tablespace() != null) {
            obj_name.addAll(getNames(ctx.body_rule.on_tablespace().obj_name.name));
        }

        
        for (String name : obj_name) {
            PgRuleCommon object = new PgRuleCommon(getFullCtxText(ctx));
            object.setBody(getFullCtxText(ctx.body_rule));
            object.setRevoke(ctx.REVOKE() != null);
            object.setObjName(name);
            fillObjLocation(object, ctx.getStart().getStartIndex(),
                    getDefSchemaName());
        }

        return null;
    }

}
