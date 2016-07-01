package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateFunction extends ParserAbstract {
    private final Create_function_statementContext ctx;
    public CreateFunction(Create_function_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }
        PgFunction function = new PgFunction(name, getFullCtxText(ctx.getParent()));
        fillArguments(ctx.function_parameters().function_args(), function, getDefSchemaName());
        function.setBody(db.getArguments() ,getFullCtxText(ctx.funct_body));

        if (ctx.function_ret_table()!= null) {
            function.setReturns(getFullCtxText(ctx.function_ret_table()));
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

    private GenericColumn parseReturns(Data_typeContext ctx) {
        Schema_qualified_name_nontypeContext type = ctx.predefined_type().schema_qualified_name_nontype();
        if (type != null) {
            String typeName = type.identifier_nontype().getText();

            if (ApgdiffConsts.SYS_TYPES.contains(typeName)) {
                return null;
            }
            IdentifierContext schemaNameCtx = type.identifier();
            String schemaName = schemaNameCtx == null ? getDefSchemaName() : schemaNameCtx.getText();
            return new GenericColumn(schemaName, typeName, null, DbObjType.TYPE);
        }
        return null;
    }
}
