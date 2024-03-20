/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_constraint_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Table_index_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.ch.ChConstraint;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChIndex;

public abstract class ChParserAbstract extends ParserAbstract<ChDatabase> {

    protected ChParserAbstract(ChDatabase db) {
        super(db);
    }

    public static List<ParserRuleContext> getIdentifiers(Qualified_nameContext qNameCtx) {
        List<ParserRuleContext> ids = new ArrayList<>(3);
        ids.addAll(qNameCtx.identifier());
        return ids;
    }

    protected ChConstraint getConstraint(Table_constraint_defContext constraintCtx) {
        var constr = new ChConstraint(constraintCtx.identifier().getText(), constraintCtx.ASSUME() != null);
        constr.setExpr(getFullCtxText(constraintCtx.expr()));
        return constr;
    }

    protected ChIndex getIndex(Table_index_defContext indexCtx) {
        var index = new ChIndex(indexCtx.identifier().getText());
        index.setExpr(getFullCtxText(indexCtx.expr()));
        index.setType(getFullCtxText(indexCtx.index_type()));
        var granVal = indexCtx.gran;
        if (granVal != null) {
            index.setGranVal(Integer.parseInt(granVal.getText()));
        }
        return index;
    }
}
