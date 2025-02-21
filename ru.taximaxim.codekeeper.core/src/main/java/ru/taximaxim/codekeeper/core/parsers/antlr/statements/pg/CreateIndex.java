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

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.IndexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_index_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Including_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Index_restContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Index_whereContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Nulls_distinctionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.With_storage_parameterContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgIndex;

public class CreateIndex extends PgParserAbstract {

    private final Create_index_statementContext ctx;
    private final String tablespace;
    private final CommonTokenStream stream;

    public CreateIndex(Create_index_statementContext ctx, PgDatabase db, String tablespace, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.tablespace = tablespace;
        this.stream = stream;
    }

    public static void parseIndex(Index_restContext rest, String tablespace, String schemaName, String tableName,
            PgIndex ind, PgDatabase db, String location, CommonTokenStream stream) {
        new CreateIndex(null, db, tablespace, stream).parseIndex(rest, schemaName, tableName, ind, location);
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.table_name);
        String schemaName = getSchemaNameSafe(ids);
        String tableName = QNameParser.getFirstName(ids);
        addObjReference(ids, DbObjType.TABLE, null);

        IdentifierContext nameCtx = ctx.name;
        String name = nameCtx != null ? nameCtx.getText() : "";
        PgIndex ind = new PgIndex(name);
        parseIndex(ctx.index_rest(), schemaName, tableName, ind, fileName);
        ind.setUnique(ctx.UNIQUE() != null);

        if (nameCtx != null) {
            ParserRuleContext parent = QNameParser.getFirstNameCtx(ids);
            PgStatementContainer table = getSafe(AbstractSchema::getStatementContainer,
                    getSchemaSafe(ids), parent);
            addSafe(table, ind, Arrays.asList(QNameParser.getSchemaNameCtx(ids), nameCtx));
        }
    }

    private void parseIndex(Index_restContext rest, String schemaName, String tableName, PgIndex ind, String location) {
        db.addAnalysisLauncher(new IndexAnalysisLauncher(ind, rest, location));

        fillSimpleColumns(ind, rest.index_columns().index_column(), null);

        if (rest.method != null) {
            ind.setMethod(rest.method.getText());
        }

        Including_indexContext incl = rest.including_index();
        if (incl != null) {
            fillIncludingDepcy(incl, ind, schemaName, tableName);
            for (IdentifierContext col : incl.identifier()) {
                ind.addInclude(col.getText());
            }
        }

        Nulls_distinctionContext dist = rest.nulls_distinction();
        ind.setNullsDistinction(dist == null || dist.NOT() == null);

        With_storage_parameterContext options = rest.with_storage_parameter();
        if (options != null) {
            for (Storage_parameter_optionContext option : options.storage_parameters().storage_parameter_option()) {
                String key = option.storage_parameter_name().getText();
                VexContext v = option.vex();
                String value = v == null ? "" : v.getText();
                fillOptionParams(value, key, false, ind::addOption);
            }
        }

        if (rest.table_space() != null) {
            ind.setTablespace(getFullCtxText(rest.table_space().identifier()));
        } else if (tablespace != null) {
            ind.setTablespace(tablespace);
        }

        Index_whereContext wherePart = rest.index_where();
        if (wherePart != null){
            ind.setWhere(getExpressionText(wherePart.vex(), stream));
        }
    }

    @Override
    protected String getStmtAction() {
        StringBuilder sb = new StringBuilder(ACTION_CREATE).append(' ').append(DbObjType.INDEX)
                .append(' ').append(QNameParser.getSchemaName(getIdentifiers(ctx.table_name)));
        if (ctx.name != null) {
            sb.append('.').append(ctx.name.getText());
        }
        return sb.toString();
    }
}
