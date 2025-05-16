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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_constraint_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_elementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Type_definitionContext;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintCheck;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsIndex;
import ru.taximaxim.codekeeper.core.schema.ms.MsType;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class CreateMsType extends MsParserAbstract {

    private final Create_typeContext ctx;

    public CreateMsType(Create_typeContext ctx, MsDatabase db, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.qualified_name().name;
        MsType type = new MsType(nameCtx.getText());

        Type_definitionContext def = ctx.type_definition();

        if (def.FROM() != null) {
            type.setBaseType(getFullCtxText(def.data_type()));
            type.setNotNull(def.null_notnull() != null && def.null_notnull().NOT() != null);
        } else if (def.EXTERNAL() != null) {
            String assemblyName = def.assembly_name.getText();
            type.setAssemblyName(assemblyName);
            addDepSafe(type, Arrays.asList(def.assembly_name), DbObjType.ASSEMBLY);
            String assemblyClass;
            if (def.class_name != null) {
                assemblyClass = def.class_name.getText();
            } else {
                assemblyClass = type.getName();
            }

            type.setAssemblyClass(assemblyClass);
        } else {
            for (var con : def.table_elements().table_element()) {
                fillTableType(con, type);
            }
            type.setMemoryOptimized(def.WITH() != null && def.on_off().ON() != null);
        }

        List<ParserRuleContext> ids = Arrays.asList(ctx.qualified_name().schema, nameCtx);
        addSafe(getSchemaSafe(ids), type, ids);
    }

    private void fillTableType(Table_elementContext tableElementContext, MsType type) {
        if (tableElementContext.table_constraint() != null) {
            Table_constraint_bodyContext body = tableElementContext.table_constraint().table_constraint_body();
            if (body.column_name_list_with_order() != null) {
                type.addChild(getMsPKConstraint(null, null, null, body));
            } else {
                var constrCheck = new MsConstraintCheck(null);
                constrCheck.setExpression(getFullCtxTextWithCheckNewLines(body.search_condition()));
                type.addChild(constrCheck);
            }
        } else if (tableElementContext.table_index() != null) {
            type.addChild(getIndex(tableElementContext.table_index()));
        } else {
            var colCtx = tableElementContext.column_def();
            MsColumn col = new MsColumn(colCtx.id().getText());

            if (colCtx.data_type() != null) {
                col.setType(getFullCtxText(colCtx.data_type()));
                addTypeDepcy(colCtx.data_type(), type);
            } else {
                col.setExpression(getFullCtxTextWithCheckNewLines(colCtx.expression()));
            }

            for (Column_optionContext option : colCtx.column_option()) {
                fillColumnOption(option, col, type);
            }

            type.addChild(col);
        }
    }

    private MsIndex getIndex(Table_indexContext indexCtx) {
        var index = new MsIndex(indexCtx.ind_name.getText());
        index.setClustered(indexCtx.clustered() != null && indexCtx.clustered().CLUSTERED() != null);
        parseIndex(indexCtx.index_rest(), index, null, null);
        return index;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TYPE, ctx.qualified_name());
    }
}
