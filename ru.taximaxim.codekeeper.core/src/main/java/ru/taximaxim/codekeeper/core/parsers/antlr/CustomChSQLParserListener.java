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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.ChSqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Alter_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Ch_fileContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_database_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_table_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Drop_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.QueryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch.AlterChTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch.ChParserAbstract;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch.CreateChSchema;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch.CreateChTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch.DropChStatement;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;

public class CustomChSQLParserListener extends CustomParserListener<ChDatabase> implements ChSqlContextProcessor {

    public CustomChSQLParserListener(ChDatabase database, String filename, ParserListenerMode mode,
            List<Object> errors, IProgressMonitor monitor) {
        super(database, filename, mode, errors, monitor);
    }

    @Override
    public void process(Ch_fileContext rootCtx, CommonTokenStream stream) {
        for (QueryContext query : rootCtx.query()) {
            query(query, stream);
        }
    }

    private void query(QueryContext query, CommonTokenStream stream) {
        var ddlStmt = query.stmt().ddl_stmt();
        if (ddlStmt != null) {
            Create_stmtContext createCtx = ddlStmt.create_stmt();
            Alter_stmtContext alter;
            Drop_stmtContext dropCtx;
            if (createCtx != null) {
                create(createCtx, stream);
            } else if ((alter = ddlStmt.alter_stmt()) != null) {
                alter(alter, stream);
            } else if ((dropCtx = ddlStmt.drop_stmt()) != null) {
                drop(dropCtx);
            }
        } else {
            addToQueries(query, getAction(query));
        }
    }

    private String getAction(QueryContext query) {
        var dml = query.stmt().dml_stmt();
        if (dml.select_stmt() != null) {
            return "SELECT";
        }
        return null;
    }

    private void create(Create_stmtContext ctx, CommonTokenStream stream) {
        ChParserAbstract p;
        Create_database_stmtContext createDatabase;
        Create_table_stmtContext createTable;
        if ((createDatabase = ctx.create_database_stmt()) != null) {
            p = new CreateChSchema(createDatabase, db);
        } else if ((createTable = ctx.create_table_stmt()) != null) {
            p = new CreateChTable(createTable, db);
        } else {
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void drop(Drop_stmtContext ctx) {
        ChParserAbstract p;
        if (ctx.DATABASE() != null) {
            p = new DropChStatement(ctx, db);
        } else {
            addToQueries(ctx, "DROP");
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void alter(Alter_stmtContext ctx, CommonTokenStream stream) {
        ChParserAbstract p;
        if (ctx.alter_table_stmt() != null) {
            p = new AlterChTable(ctx.alter_table_stmt(), db);
        } else {
            return;
        }
        safeParseStatement(p, ctx);
    }
}
