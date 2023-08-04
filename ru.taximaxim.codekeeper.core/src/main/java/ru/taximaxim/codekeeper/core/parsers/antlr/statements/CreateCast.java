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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Cast_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_cast_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.ICast.CastContext;
import ru.taximaxim.codekeeper.core.schema.PgCast;
import ru.taximaxim.codekeeper.core.schema.PgCast.CastMethod;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class CreateCast extends ParserAbstract {

    private final Create_cast_statementContext ctx;

    public CreateCast(Create_cast_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        Cast_nameContext nameCtx = ctx.cast_name();
        Data_typeContext source = nameCtx.source;
        Data_typeContext target = nameCtx.target;
        PgCast cast = new PgCast(getFullCtxText(source), getFullCtxText(target));

        addPgTypeDepcy(source, cast);
        addPgTypeDepcy(target, cast);

        Schema_qualified_nameContext funcNameCtx = ctx.func_name;
        if (funcNameCtx != null) {
            cast.setMethod(CastMethod.FUNCTION);
            String args = getFullCtxText(ctx.function_args());
            addDepSafe(cast, getIdentifiers(funcNameCtx), DbObjType.FUNCTION, true, args);
            cast.setFunction(getFullCtxText(funcNameCtx) + args);
        } else if (ctx.INOUT() != null) {
            cast.setMethod(CastMethod.INOUT);
        }

        if (ctx.ASSIGNMENT() != null) {
            cast.setContext(CastContext.ASSIGNMENT);
        } else if (ctx.IMPLICIT() != null) {
            cast.setContext(CastContext.IMPLICIT);
        }

        addSafe(db, cast, Arrays.asList(nameCtx));
    }

    @Override
    protected String getStmtAction() {
        StringBuilder sb = new StringBuilder();
        sb.append(ACTION_CREATE).append(' ').append(DbObjType.CAST).append(" (");
        sb.append(getCastName(ctx.cast_name()));
        sb.append(')');
        return sb.toString();
    }
}
