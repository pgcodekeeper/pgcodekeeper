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
package ru.taximaxim.codekeeper.core.parsers.antlr.msexpr;

import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Execute_moduleContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Execute_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Insert_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Name_list_in_bracketsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Select_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.With_expressionContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;

public class MsInsert extends MsAbstractExprWithNmspc<Insert_statementContext> {

    protected MsInsert(MsAbstractExpr parent) {
        super(parent);
    }

    @Override
    public List<String> analyze(Insert_statementContext insert) {
        With_expressionContext with = insert.with_expression();
        if (with != null) {
            analyzeCte(with);
        }

        ExpressionContext exp = insert.expression();
        if (exp != null) {
            new MsValueExpr(this).analyze(exp);
        }

        Select_statementContext ss = insert.select_statement();
        Execute_statementContext es;

        if (ss != null) {
            new MsSelect(this).analyze(ss);
        } else if ((es = insert.execute_statement()) != null) {
            Execute_moduleContext em = es.execute_module();
            Qualified_nameContext qname;
            if (em != null && (qname = em.qualified_name()) != null) {
                addObjectDepcy(qname, DbObjType.FUNCTION);
            }
        }

        Qualified_nameContext tableName = insert.qualified_name();
        if (tableName != null) {
            GenericColumn gc = addNameReference(tableName, null);
            Name_list_in_bracketsContext columns;

            if (gc != null && (columns = insert.name_list_in_brackets()) != null) {
                for (IdContext id : columns.id()) {
                    addDepcy(new GenericColumn(gc.schema, gc.table, id.getText(),
                            DbObjType.COLUMN), id);
                }
            }
        }

        return Collections.emptyList();
    }

}
