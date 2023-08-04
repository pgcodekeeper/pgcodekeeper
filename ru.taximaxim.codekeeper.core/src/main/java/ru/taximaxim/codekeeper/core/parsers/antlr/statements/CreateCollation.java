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

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Collation_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_collation_statementContext;
import ru.taximaxim.codekeeper.core.schema.PgCollation;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class CreateCollation extends ParserAbstract {
    private final Create_collation_statementContext ctx;

    public CreateCollation(Create_collation_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgCollation collation = new PgCollation(QNameParser.getFirstName(ids));

        for (Collation_optionContext body : ctx.collation_option()) {
            if (body.LOCALE() != null) {
                collation.setLcCollate(getValue(body));
                collation.setLcCtype(getValue(body));
            } else if (body.LC_COLLATE() != null) {
                collation.setLcCollate(getValue(body));
            } else if (body.LC_CTYPE() != null) {
                collation.setLcCtype(getValue(body));
            } else if (body.PROVIDER() != null) {
                collation.setProvider(getValue(body));
            } else if (body.DETERMINISTIC() != null) {
                collation.setDeterministic(parseBoolean(body.boolean_value()));
            }
        }
        addSafe(getSchemaSafe(ids), collation, ids);
    }

    private String getValue(Collation_optionContext body) {
        if (body.DEFAULT() != null) {
            return "default";
        }
        Character_stringContext val = body.character_string();
        if (val != null) {
            return val.getText();
        }
        return body.identifier().getText();
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.VIEW, ctx.name);
    }
}
