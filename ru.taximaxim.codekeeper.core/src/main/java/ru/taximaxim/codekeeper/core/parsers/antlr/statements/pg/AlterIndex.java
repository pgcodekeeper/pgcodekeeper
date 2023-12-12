/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_index_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.pg.PgIndex;

public class AlterIndex extends PgParserAbstract {

    private final Alter_index_statementContext ctx;
    private final String alterIdxAllAction;

    public AlterIndex(Alter_index_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
        alterIdxAllAction = ctx.ALL() == null ? null : "ALTER INDEX ALL";
    }

    @Override
    public void parseObject() {
        if (alterIdxAllAction != null) {
            PgObjLocation loc = new PgObjLocation.Builder()
                    .setAction(alterIdxAllAction)
                    .setCtx(ctx.getParent())
                    .build();

            db.addReference(fileName, loc);
            return;
        }

        List<ParserRuleContext> ids = getIdentifiers(ctx.schema_qualified_name());

        Schema_qualified_nameContext inherit = ctx.index_def_action().index;

        if (inherit != null) {
            // in this case inherit is real index name
            List<ParserRuleContext> idsInh = getIdentifiers(inherit);

            PgIndex index = (PgIndex) getSafe(AbstractSchema::getIndexByName,
                    getSchemaSafe(idsInh), QNameParser.getFirstNameCtx(idsInh));

            String inhSchemaName = getSchemaNameSafe(ids);
            String inhTableName = QNameParser.getFirstName(ids);
            doSafe((i,o) -> i.addInherit(inhSchemaName, inhTableName), index, null);
            addDepSafe(index, ids, DbObjType.INDEX, DatabaseType.PG);

            addObjReference(idsInh, DbObjType.INDEX, ACTION_ALTER);
        } else {
            addObjReference(ids, DbObjType.INDEX, ACTION_ALTER);
        }
    }

    @Override
    protected String getStmtAction() {
        return alterIdxAllAction != null ? alterIdxAllAction
                : getStrForStmtAction(ACTION_ALTER, DbObjType.INDEX,
                        getIdentifiers(ctx.schema_qualified_name()));
    }
}
