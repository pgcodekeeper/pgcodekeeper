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
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_sequence_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Sequence_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Tokens_nonreserved_except_function_typeContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgSequence;

public class CreateSequence extends ParserAbstract {

    private final Create_sequence_statementContext ctx;

    public CreateSequence(Create_sequence_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgSequence sequence = new PgSequence(QNameParser.getFirstName(ids));
        if (ctx.UNLOGGED() != null) {
            sequence.setLogged(false);
        }

        fillSequence(sequence, ctx.sequence_body());
        addSafe(getSchemaSafe(ids), sequence, ids);
    }

    public static void fillSequence(PgSequence sequence, List<Sequence_bodyContext> list) {
        long inc = 1;
        Long maxValue = null;
        Long minValue = null;
        for (Sequence_bodyContext body : list) {
            if (body.type != null) {
                sequence.setDataType(body.type.getText());
            } else if (body.cache_val != null) {
                sequence.setCache(body.cache_val.getText());
            } else if (body.incr != null) {
                inc = Long.parseLong(body.incr.getText());
            } else if (body.maxval != null) {
                maxValue = Long.parseLong(body.maxval.getText());
            } else if (body.minval != null) {
                minValue = Long.parseLong(body.minval.getText());
            } else if (body.start_val != null) {
                sequence.setStartWith(body.start_val.getText());
            } else if (body.cycle_val != null) {
                sequence.setCycle(body.cycle_true == null);
            } else if (body.col_name != null) {
                // TODO incorrect qualified name work
                // also broken in altersequence
                List<ParserRuleContext> col = getIdentifiers(body.col_name);
                Tokens_nonreserved_except_function_typeContext word;
                if (col.size() != 1
                        || (word = body.col_name.identifier().tokens_nonreserved_except_function_type()) == null
                        || word.NONE() == null) {
                    sequence.setOwnedBy(new GenericColumn(QNameParser.getThirdName(col),
                            QNameParser.getSecondName(col), QNameParser.getFirstName(col), DbObjType.COLUMN));
                }
            }
        }
        sequence.setMinMaxInc(inc, maxValue, minValue, sequence.getDataType(), 0L);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.SEQUENCE, getIdentifiers(ctx.name));
    }
}
