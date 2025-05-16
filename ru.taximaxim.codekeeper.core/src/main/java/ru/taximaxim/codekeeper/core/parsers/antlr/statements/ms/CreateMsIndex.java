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
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ClusteredContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Index_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsIndex;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class CreateMsIndex extends MsParserAbstract {

    private final Create_indexContext ctx;

    public CreateMsIndex(Create_indexContext ctx, MsDatabase db, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Index_nameContext indexNameCtx = ctx.index_name();
        IdContext schemaCtx = indexNameCtx.table_name.schema;
        IdContext tableCtx = indexNameCtx.table_name.name;
        IdContext nameCtx = indexNameCtx.name;
        List<ParserRuleContext> ids = Arrays.asList(schemaCtx, nameCtx);
        AbstractSchema schema = getSchemaSafe(ids);
        addObjReference(Arrays.asList(schemaCtx, tableCtx), DbObjType.TABLE, null);

        MsIndex ind = new MsIndex(nameCtx.getText());
        ind.setUnique(ctx.UNIQUE() != null);
        ClusteredContext cluster = ctx.clustered();
        ind.setClustered(cluster != null && cluster.CLUSTERED() != null);
        ind.setColumnstore(ctx.COLUMNSTORE() != null);
        var restCtx = ctx.index_rest();
        if (restCtx != null) {
            parseIndex(restCtx, ind, schemaCtx == null ? null : schemaCtx.getText(), tableCtx.getText());
        } else {
            parseColumnstoreIndex(ctx, ind, schemaCtx == null ? null : schemaCtx.getText(), tableCtx.getText());
        }

        PgStatementContainer cont = getSafe(AbstractSchema::getStatementContainer, schema, tableCtx);
        addSafe(cont, ind, Arrays.asList(schemaCtx, tableCtx, nameCtx));
    }

    private void parseColumnstoreIndex(Create_indexContext ctx, AbstractIndex index, String schema, String table) {
        var nameList = ctx.name_list_in_brackets();
        if (nameList != null) {
            for (IdContext col : nameList.id()) {
                index.addInclude(col.getText());
                index.addDep(new GenericColumn(schema, table, col.getText(), DbObjType.COLUMN));
            }
        }
        var orderCols = ctx.order_cols;
        if (orderCols != null) {
            fillOrderCols((MsIndex) index, orderCols.column_name_list_with_order().column_with_order(), schema, table);
        }
        parseIndexOptions(index, ctx.index_where(), ctx.index_options(), ctx.id());
    }

    @Override
    protected String getStmtAction() {
        Qualified_nameContext qualNameCtx = ctx.index_name().qualified_name();
        return getStrForStmtAction(ACTION_CREATE, DbObjType.INDEX,
                Arrays.asList(qualNameCtx.schema, qualNameCtx.name, ctx.index_name().name));
    }
}
