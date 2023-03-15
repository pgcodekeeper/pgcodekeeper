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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Delete_stmt_for_psqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.With_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;

public class Delete extends AbstractExprWithNmspc<Delete_stmt_for_psqlContext> {

    protected Delete(AbstractExpr parent) {
        super(parent);
    }

    public Delete(MetaContainer meta) {
        super(meta);
    }

    @Override
    public List<ModPair<String, String>> analyze(Delete_stmt_for_psqlContext delete) {
        // this select is used to collect namespaces for this DELETE operation
        Select select = new Select(this);
        With_clauseContext with = delete.with_clause();
        if (with != null) {
            select.analyzeCte(with);
        }

        select.addNameReference(delete.delete_table_name, delete.alias, null);
        if (delete.USING() != null) {
            select.from(delete.from_item());
        }

        if (delete.WHERE() != null) {
            VexContext vex = delete.vex();
            if (vex != null) {
                new ValueExpr(select).analyze(new Vex(vex));
            }
        }

        if (delete.RETURNING() != null) {
            return select.sublist(delete.select_list().select_sublist(), new ValueExpr(select));
        }

        return Collections.emptyList();
    }
}
