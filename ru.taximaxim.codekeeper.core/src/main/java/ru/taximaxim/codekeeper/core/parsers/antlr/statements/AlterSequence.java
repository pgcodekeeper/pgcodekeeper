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

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_sequence_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Sequence_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Tokens_nonreserved_except_function_typeContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgSequence;

public class AlterSequence extends ParserAbstract {
    private final Alter_sequence_statementContext ctx;
    public AlterSequence(Alter_sequence_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgSequence sequence = (PgSequence) getSafe(AbstractSchema::getSequence,
                getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));

        PgObjLocation loc = addObjReference(ids, DbObjType.SEQUENCE, ACTION_ALTER);

        for (Sequence_bodyContext seqbody : ctx.sequence_body()) {
            if (seqbody.OWNED() != null && seqbody.col_name != null) {
                List<ParserRuleContext> col = getIdentifiers(seqbody.col_name);
                Tokens_nonreserved_except_function_typeContext word;
                if (col.size() != 1
                        || (word = seqbody.col_name.identifier().tokens_nonreserved_except_function_type()) == null
                        || word.NONE() == null) {
                    GenericColumn gc = new GenericColumn(QNameParser.getThirdName(col),
                            QNameParser.getSecondName(col), QNameParser.getFirstName(col), DbObjType.COLUMN);
                    doSafe(PgSequence::setOwnedBy, sequence, gc);
                    if (col.size() > 1) {
                        List<ParserRuleContext> tableIds = col.subList(0, col.size() - 1);
                        addObjReference(tableIds, DbObjType.TABLE, null);
                    }
                }
            }
        }

        if (!ctx.RESTART().isEmpty()) {
            loc.setWarning(DangerStatement.RESTART_WITH);
        }
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        if (!((Schema_alterContext) ctx).alter_sequence_statement().RESTART().isEmpty()) {
            loc.setWarning(DangerStatement.RESTART_WITH);
        }
        return loc;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.SEQUENCE, getIdentifiers(ctx.name));
    }
}
