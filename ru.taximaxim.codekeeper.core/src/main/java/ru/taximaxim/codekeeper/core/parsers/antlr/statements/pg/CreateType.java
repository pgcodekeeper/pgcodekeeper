/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.text.MessageFormat;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import ru.taximaxim.codekeeper.core.Consts.FUNC_SIGN;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_type_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_directiveContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_column_definitionContext;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractType;
import ru.taximaxim.codekeeper.core.schema.pg.PgBaseType;
import ru.taximaxim.codekeeper.core.schema.pg.PgColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgCompositeType;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgEnumType;
import ru.taximaxim.codekeeper.core.schema.pg.PgRangeType;
import ru.taximaxim.codekeeper.core.schema.pg.PgShellType;

public final class CreateType extends PgParserAbstract {

    private final Create_type_statementContext ctx;

    public CreateType(Create_type_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        String name = QNameParser.getFirstName(ids);
        AbstractSchema schema = getSchemaSafe(ids);
        AbstractType type = null;
        if (ctx.RANGE() != null) {
            type = createRangeType(name, schema);
        } else if (ctx.ENUM() != null) {
            type = createEnumType(name);
        } else if (ctx.AS() != null) {
            type = createCompositeType(name);
        } else if (ctx.INPUT() != null) {
            type = createBaseType(name, schema);
        } else {
            type = new PgShellType(name);
        }

        addSafe(schema, type, ids);
    }

    private PgCompositeType createCompositeType(String name) {
        PgCompositeType type =  new PgCompositeType(name);
        for (Table_column_definitionContext attr : ctx.attrs) {
            addAttr(attr, type);
        }

        return type;
    }

    private PgEnumType createEnumType(String name) {
        PgEnumType type =  new PgEnumType(name);
        for (Character_stringContext enume : ctx.enums) {
            type.addEnum(enume.getText());
        }

        return type;
    }

    private PgRangeType createRangeType(String name, AbstractSchema schema) {
        PgRangeType type = new PgRangeType(name);
        if (ctx.subtype_name != null) {
            type.setSubtype(getTypeName(ctx.subtype_name));
            addTypeDepcy(ctx.subtype_name, type);
        }
        if (ctx.subtype_operator_class != null) {
            type.setSubtypeOpClass(getFullCtxText(ctx.subtype_operator_class));
        }
        if (ctx.collation != null) {
            type.setCollation(getFullCtxText(ctx.collation));
            addDepSafe(type, getIdentifiers(ctx.collation), DbObjType.COLLATION);
        }
        if (ctx.canonical_function != null) {
            type.setCanonical(getFullCtxText(ctx.canonical_function));
            addDepSafe(type, getIdentifiers(ctx.canonical_function), DbObjType.FUNCTION,
                    MessageFormat.format(FUNC_SIGN.TYPE_NAME.getName(), schema, name));
        }
        if (ctx.subtype_diff_function != null) {
            type.setSubtypeDiff(getFullCtxText(ctx.subtype_diff_function));
            addDepSafe(type, getIdentifiers(ctx.subtype_diff_function), DbObjType.FUNCTION,
                    MessageFormat.format(FUNC_SIGN.SUBTYPE_DIFF.getName(), type.getSubtype()));
        }
        if (ctx.multirange_name != null) {
            type.setMultirange(ctx.multirange_name.getText());
            addTypeDepcy(ctx.multirange_name, type);
        }

        return type;
    }

    private PgBaseType createBaseType(String name, AbstractSchema schema) {
        PgBaseType type = new PgBaseType(name);

        // the order in which dependencies are installed from type to functions is important for generating the migration script
        if (ctx.subscript_function != null) {
            type.setSubscriptFunction(getFullCtxText(ctx.subscript_function));
            addDepSafe(type, getIdentifiers(ctx.subscript_function), DbObjType.FUNCTION, FUNC_SIGN.INTERNAL.getName());
        }
        if (ctx.analyze_function != null) {
            type.setAnalyzeFunction(getFullCtxText(ctx.analyze_function));
            addDepSafe(type, getIdentifiers(ctx.analyze_function), DbObjType.FUNCTION, FUNC_SIGN.INTERNAL.getName());
        }
        if (ctx.type_modifier_output_function != null) {
            type.setTypmodOutputFunction(getFullCtxText(ctx.type_modifier_output_function));
            addDepSafe(type, getIdentifiers(ctx.type_modifier_output_function), DbObjType.FUNCTION,
                    FUNC_SIGN.TYPMOD_OUT.getName());
        }
        if (ctx.type_modifier_input_function != null) {
            type.setTypmodInputFunction(getFullCtxText(ctx.type_modifier_input_function));
            addDepSafe(type, getIdentifiers(ctx.type_modifier_input_function), DbObjType.FUNCTION,
                    FUNC_SIGN.TYPMOD_IN.getName());
        }
        if (ctx.send_function != null) {
            type.setSendFunction(getFullCtxText(ctx.send_function));
            addDepSafe(type, getIdentifiers(ctx.send_function), DbObjType.FUNCTION,
                    MessageFormat.format(FUNC_SIGN.TYPE_NAME.getName(), schema, name));
        }
        if (ctx.receive_function != null) {
            type.setReceiveFunction(getFullCtxText(ctx.receive_function));
            // added dependency two times because can be one of two types signature
            addDepSafe(type, getIdentifiers(ctx.receive_function), DbObjType.FUNCTION, FUNC_SIGN.INTERNAL.getName());
            addDepSafe(type, getIdentifiers(ctx.receive_function), DbObjType.FUNCTION,
                    FUNC_SIGN.REC_ADVANCED.getName());
        }

        type.setOutputFunction(getFullCtxText(ctx.output_function));
        addDepSafe(type, getIdentifiers(ctx.output_function), DbObjType.FUNCTION,
                MessageFormat.format(FUNC_SIGN.TYPE_NAME.getName(), schema, name));

        type.setInputFunction(getFullCtxText(ctx.input_function));
        // added dependency two times because can be one of two types signature
        addDepSafe(type, getIdentifiers(ctx.input_function), DbObjType.FUNCTION, FUNC_SIGN.IN.getName());
        addDepSafe(type, getIdentifiers(ctx.input_function), DbObjType.FUNCTION, FUNC_SIGN.IN_ADVANCED.getName());

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
            addTypeDepcy(ctx.element, type);
        }
        if (ctx.delimiter != null) {
            type.setDelimiter(ctx.delimiter.getText());
        }
        if (ctx.collatable != null) {
            type.setCollatable(getFullCtxText(ctx.collatable));
        }

        for (Storage_directiveContext storDirCtx : ctx.storage_directive()) {
            if (storDirCtx.compress_type != null) {
                type.setCompressType(storDirCtx.compress_type.getText());
            } else if (storDirCtx.compress_level != null) {
                type.setCompressLevel(Integer.parseInt(storDirCtx.compress_level.getText()));
            } else if (storDirCtx.block_size != null) {
                type.setBlockSize(Integer.parseInt(storDirCtx.block_size.getText()));
            }
        }

        return type;
    }

    private void addAttr(Table_column_definitionContext colCtx, PgCompositeType type) {
        AbstractColumn col = new PgColumn(colCtx.identifier().getText());
        col.setType(getTypeName(colCtx.data_type()));
        addTypeDepcy(colCtx.data_type(), type);
        if (colCtx.collate_identifier() != null) {
            var columnCollationCtx = colCtx.collate_identifier().collation;
            col.setCollation(getFullCtxText(columnCollationCtx));
            addDepSafe(type, getIdentifiers(columnCollationCtx), DbObjType.COLLATION);
        }
        type.addAttr(col);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TYPE, getIdentifiers(ctx.name));
    }
}
