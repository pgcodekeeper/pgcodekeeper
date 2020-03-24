package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Character_stringContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgType.PgTypeForm;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateType extends ParserAbstract {

    private final Create_type_statementContext ctx;
    public CreateType(Create_type_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.name.identifier();
        String name = QNameParser.getFirstName(ids);
        AbstractSchema schema = getSchemaSafe(ids);
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
        PgType type = null;
        PgType newType = null;
        if (form == PgTypeForm.BASE && schema != null) {
            type = (PgType) schema.getType(name);
            if (type != null && type.getForm() != PgTypeForm.SHELL) {
                throw new IllegalStateException("Duplicate type but existing is not SHELL type!");
            }
        }
        if (type == null) {
            type = new PgType(name, form);
            newType = type;
        }

        for (Table_column_definitionContext attr : ctx.attrs) {
            type.addAttr(getColumn(attr));
        }
        for (Character_stringContext enume : ctx.enums) {
            type.addEnum(enume.getText());
        }
        if (ctx.subtype_name != null) {
            type.setSubtype(getTypeName(ctx.subtype_name));
            addPgTypeDepcy(ctx.subtype_name, type);
        }
        if (ctx.subtype_operator_class != null) {
            type.setSubtypeOpClass(getFullCtxText(ctx.subtype_operator_class));
        }
        if (ctx.collation != null) {
            type.setCollation(getFullCtxText(ctx.collation));
        }
        if (ctx.canonical_function != null) {
            type.setCanonical(getFullCtxText(ctx.canonical_function));
            addDepSafe(type, ctx.canonical_function.identifier(), DbObjType.FUNCTION, true);
        }
        if (ctx.subtype_diff_function != null) {
            type.setSubtypeDiff(getFullCtxText(ctx.subtype_diff_function));
            addDepSafe(type, ctx.subtype_diff_function.identifier(), DbObjType.FUNCTION, true);
        }
        if (ctx.input_function != null) {
            type.setInputFunction(getFullCtxText(ctx.input_function));
            addDepSafe(type, ctx.input_function.identifier(), DbObjType.FUNCTION, true);
        }
        if (ctx.output_function != null) {
            type.setOutputFunction(getFullCtxText(ctx.output_function));
            addDepSafe(type, ctx.output_function.identifier(), DbObjType.FUNCTION, true);
        }
        if (ctx.receive_function != null) {
            type.setReceiveFunction(getFullCtxText(ctx.receive_function));
            addDepSafe(type, ctx.receive_function.identifier(), DbObjType.FUNCTION, true);
        }
        if (ctx.send_function != null) {
            type.setSendFunction(getFullCtxText(ctx.send_function));
            addDepSafe(type, ctx.send_function.identifier(), DbObjType.FUNCTION, true);
        }
        if (ctx.type_modifier_input_function != null) {
            type.setTypmodInputFunction(getFullCtxText(ctx.type_modifier_input_function));
            addDepSafe(type, ctx.type_modifier_input_function.identifier(), DbObjType.FUNCTION, true);
        }
        if (ctx.type_modifier_output_function != null) {
            type.setTypmodOutputFunction(getFullCtxText(ctx.type_modifier_output_function));
            addDepSafe(type, ctx.type_modifier_output_function.identifier(), DbObjType.FUNCTION, true);
        }
        if (ctx.analyze_function != null) {
            type.setAnalyzeFunction(getFullCtxText(ctx.analyze_function));
            addDepSafe(type, ctx.analyze_function.identifier(), DbObjType.FUNCTION, true);
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
            type.setElement(getTypeName(ctx.element));
            addPgTypeDepcy(ctx.element, type);
        }
        if (ctx.delimiter != null) {
            type.setDelimiter(ctx.delimiter.getText());
        }
        if (ctx.collatable != null) {
            type.setCollatable(getFullCtxText(ctx.collatable));
        }
        if (newType != null) {
            // add only newly created type, not a filled SHELL that was added before
            addSafe(schema, type, ids);
        }
    }

    private AbstractColumn getColumn(Table_column_definitionContext colCtx) {
        AbstractColumn col = new PgColumn(colCtx.identifier().getText());
        col.setType(getTypeName(colCtx.data_type()));
        addPgTypeDepcy(colCtx.data_type(), col);
        if (colCtx.collate_identifier() != null) {
            col.setCollation(getFullCtxText(colCtx.collate_identifier().collation));
        }
        return col;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TYPE, ctx.name.identifier());
    }
}
