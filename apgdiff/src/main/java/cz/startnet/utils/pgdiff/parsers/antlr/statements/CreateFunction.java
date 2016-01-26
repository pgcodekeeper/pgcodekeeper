package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class CreateFunction extends ParserAbstract {
    private final Create_function_statementContext ctx;
    public CreateFunction(Create_function_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.function_parameters().name);
        String schemaName =getSchemaName(ctx.function_parameters().name);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }
        PgFunction function = new PgFunction(name, getFullCtxText(ctx.getParent()));
        fillArguments(ctx.function_parameters().function_args(), function, getDefSchemaName());
        function.setBody(db.getArguments() ,getFullCtxText(ctx.funct_body));

        if (ctx.function_ret_table()!= null) {
            function.setReturns(getFullCtxText(ctx.function_ret_table()));
        } else if(ctx.rettype != null) {
            function.setReturns(getFullCtxText(ctx.rettype));
            function.setReturnsName(parseReturns(ctx.rettype));
        } else if(ctx.rettype_data != null) {
            function.setReturns(getFullCtxText(ctx.rettype_data));
            function.setReturnsName(parseReturns(ctx.rettype_data));
        }
        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "FUNCTION", name);
            return null;
        }
        db.getSchema(schemaName).addFunction(function);

        return function;
    }

    private GenericColumn parseReturns(ParserRuleContext ctx) {
        SchemaNameListener snl = new SchemaNameListener();
        new ParseTreeWalker().walk(snl, ctx);
        Schema_qualified_nameContext name = snl.getName();
        if (name != null) {
            String typeName = getName(name);
            if (ApgdiffConsts.SYS_TYPES.contains(typeName)) {
                return null;
            }
            String schemaName = getSchemaName(name);
            if (schemaName == null) {
                schemaName = getDefSchemaName();
            }
            return new GenericColumn(schemaName, typeName, null);
        }
        return null;
    }
}

/**
 * Находит и возвращает первое попавшееся имя с указанием схемы или без нее
 */
class SchemaNameListener extends SQLParserBaseListener {
    private Schema_qualified_nameContext name;
    @Override
    public void exitSchema_qualified_name(Schema_qualified_nameContext ctx) {
        if (name == null) {
            name = ctx;
        }
    }
    Schema_qualified_nameContext getName() {
        return name;
    }
}

