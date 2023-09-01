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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Alter_assemblyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Assembly_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.MsAssembly;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class AlterMsAssembly extends ParserAbstract {

    private final Alter_assemblyContext ctx;

    public AlterMsAssembly(Alter_assemblyContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        MsAssembly assembly = getSafe(PgDatabase::getAssembly, db, ctx.name);
        addObjReference(Arrays.asList(ctx.name), DbObjType.ASSEMBLY, ACTION_ALTER);

        List<Assembly_optionContext> options = ctx.assembly_option();
        if (options != null) {
            for (Assembly_optionContext option : options) {
                if (option.VISIBILITY() != null) {
                    doSafe(MsAssembly::setVisible, assembly, option.on_off().ON() != null);
                }
            }
        }
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.ASSEMBLY, ctx.name);
    }
}
