package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgType.PgTypeForm;

public class CreateType extends ParserAbstract {

    private final Create_type_statementContext ctx;

    public CreateType(Create_type_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgTypeForm form = PgTypeForm.SHELL;
        if (ctx.RANGE() != null) {
            form = PgTypeForm.RANGE;
        } else if (ctx.ENUM() != null) {
            form = PgTypeForm.ENUM;
        } else if (ctx.AS() != null) {
            form = PgTypeForm.COMPOSITE;
        } else if (ctx.INPUT() != null) {
            form = PgTypeForm.BASE;
        }
        PgType type = new PgType(name, form, getFullCtxText(ctx.getParent()));
        for (Table_column_definitionContext attr : ctx.attrs) {
            type.addAttr(getColumn(attr, new ArrayList<String>(), new HashMap<String, GenericColumn>(), getDefSchemaName()));
            addTypeAsDepcy(attr.datatype, type, getDefSchemaName());
        }
        for (Token enume : ctx.enums) {
            type.addEnum(enume.getText());
        }
        if (ctx.subtype_name != null) {
            type.setSubtype(getFullCtxText(ctx.subtype_name));
            addTypeAsDepcy(ctx.subtype_name, type, getDefSchemaName());
        }
        if (ctx.subtype_operator_class != null) {
            type.setSubtypeOpClass(getFullCtxText(ctx.subtype_operator_class));
        }
        if (ctx.collation != null) {
            type.setCollation(getFullCtxText(ctx.collation));
        }
        if (ctx.canonical_function != null) {
            type.setCanonical(getFullCtxText(ctx.canonical_function));
        }
        if (ctx.subtype_diff_function != null) {
            type.setSubtypeDiff(getFullCtxText(ctx.subtype_diff_function));
        }
        // TODO function depcies; caution: may introduce cyclic depcies
        if (ctx.input_function != null) {
            type.setInputFunction(getFullCtxText(ctx.input_function));
        }
        if (ctx.output_function != null) {
            type.setOutputFunction(getFullCtxText(ctx.output_function));
        }
        if (ctx.receive_function != null) {
            type.setReceiveFunction(getFullCtxText(ctx.receive_function));
        }
        if (ctx.send_function != null) {
            type.setSendFunction(getFullCtxText(ctx.send_function));
        }
        if (ctx.type_modifier_input_function != null) {
            type.setTypmodInputFunction(getFullCtxText(ctx.type_modifier_input_function));
        }
        if (ctx.type_modifier_output_function != null) {
            type.setTypmodOutputFunction(getFullCtxText(ctx.type_modifier_output_function));
        }
        if (ctx.analyze_function != null) {
            type.setAnalyzeFunction(getFullCtxText(ctx.analyze_function));
        }
        if (ctx.internallength != null) {
            type.setInternalLength(getFullCtxText(ctx.internallength));
        }
        List<TerminalNode> variable = ctx.VARIABLE();
        if (!variable.isEmpty()) {
            type.setInternalLength(variable.get(0).getText());
        }
        type.setPassedByValue(!ctx.PASSEDBYVALUE().isEmpty());
        if (ctx.alignment != null) {
            type.setAlignment(getFullCtxText(ctx.alignment));
        }
        if (ctx.storage != null) {
            type.setStorage(ctx.storage.getText());
        }
        if (ctx.like_type != null) {
            type.setLikeType(getFullCtxText(ctx.like_type));
        }
        if (ctx.category != null) {
            type.setCategory(ctx.category.getText());
        }
        if (ctx.preferred != null) {
            type.setPreferred(getFullCtxText(ctx.preferred));
        }
        if (ctx.default_value != null) {
            type.setDefaultValue(ctx.default_value.getText());
        }
        if (ctx.element != null) {
            type.setElement(getFullCtxText(ctx.element));
            addTypeAsDepcy(ctx.element, type, getDefSchemaName());
        }
        if (ctx.delimiter != null) {
            type.setDelimiter(ctx.delimiter.getText());
        }
        if (ctx.collatable != null) {
            type.setCollatable(getFullCtxText(ctx.collatable));
        }
        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "TYPE", name);
            return null;
        }
        db.getSchema(schemaName).addType(type);
        return type;
    }

}
