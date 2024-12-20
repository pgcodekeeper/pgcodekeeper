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

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_domain_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Domain_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintCheck;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgDomain;
import ru.taximaxim.codekeeper.core.schema.pg.PgSchema;

public class AlterDomain extends PgParserAbstract {

    private final Alter_domain_statementContext ctx;

    public AlterDomain(Alter_domain_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgDomain domain = getSafe(PgSchema::getDomain,
                getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));

        Domain_constraintContext constrCtx = ctx.dom_constraint;
        if (constrCtx != null && constrCtx.CHECK() != null) {
            IdentifierContext name = constrCtx.name;
            var constrCheck = new PgConstraintCheck(name != null ? name.getText() : "");
            CreateDomain.parseDomainConstraint(domain, constrCheck, constrCtx, db, fileName);
            if (ctx.not_valid != null) {
                constrCheck.setNotValid(true);
            }
            doSafe(PgDomain::addConstraint, domain, constrCheck);
        }

        addObjReference(ids, DbObjType.DOMAIN, ACTION_ALTER);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.DOMAIN, getIdentifiers(ctx.name));
    }
}
