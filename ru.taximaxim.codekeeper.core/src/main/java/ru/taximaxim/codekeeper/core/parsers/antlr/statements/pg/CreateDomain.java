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

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.DomainAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Collate_identifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_domain_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Domain_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintCheck;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgDomain;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class CreateDomain extends PgParserAbstract {

    private final Create_domain_statementContext ctx;
    private final CommonTokenStream stream;

    public CreateDomain(Create_domain_statementContext ctx, PgDatabase db, CommonTokenStream stream, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
        this.stream = stream;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgDomain domain = new PgDomain(QNameParser.getFirstName(ids));
        domain.setDataType(getTypeName(ctx.dat_type));
        addTypeDepcy(ctx.dat_type, domain);
        for (Collate_identifierContext coll : ctx.collate_identifier()) {
            domain.setCollation(getFullCtxText(coll.collation));
            addDepSafe(domain, getIdentifiers(coll.collation), DbObjType.COLLATION);
        }
        VexContext exp = ctx.def_value;
        if (exp != null) {
            db.addAnalysisLauncher(new VexAnalysisLauncher(domain, exp, fileName));
            domain.setDefaultValue(getExpressionText(exp, stream));
        }
        for (Domain_constraintContext constrCtx : ctx.dom_constraint) {
            if (constrCtx.CHECK() != null) {
                IdentifierContext name = constrCtx.name;
                var constrCheck = new PgConstraintCheck(name != null ? name.getText() : "");
                parseDomainConstraint(domain, constrCheck, constrCtx, db, fileName, settings);
                domain.addConstraint(constrCheck);
            }
            // вынесено ограничение, т.к. мы привязываем ограничение на нул к
            // объекту а не создаем отдельный констрайнт
            if (constrCtx.NULL() != null) {
                domain.setNotNull(constrCtx.NOT() != null);
            }
        }

        addSafe(getSchemaSafe(ids), domain, ids);
    }

    public static void parseDomainConstraint(PgDomain domain, PgConstraintCheck constr,
            Domain_constraintContext ctx, AbstractDatabase db, String location, ISettings settings) {
        VexContext vexCtx = ctx.vex();
        constr.setExpression(Utils.checkNewLines(getFullCtxText(vexCtx), settings));
        db.addAnalysisLauncher(new DomainAnalysisLauncher(domain, vexCtx, location));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.DOMAIN, getIdentifiers(ctx.name));
    }
}
