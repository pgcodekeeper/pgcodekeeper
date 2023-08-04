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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Another_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.BatchContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Batch_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_assemblyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_schemaContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Ddl_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Schema_createContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Security_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Sql_clausesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.St_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Tsql_fileContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql.AlterMsAuthorization;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql.GrantMsPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;

public class TSQLOverridesListener extends CustomParserListener
implements TSqlContextProcessor {

    private final Map<PgStatement, StatementOverride> overrides;

    public TSQLOverridesListener(PgDatabase db, String filename, ParserListenerMode mode,
            List<Object> errors, IProgressMonitor mon, Map<PgStatement, StatementOverride> overrides) {
        super(db, filename, mode, errors, mon);
        this.overrides = overrides;
    }

    @Override
    public void process(Tsql_fileContext rootCtx, CommonTokenStream stream) {
        for (BatchContext b : rootCtx.batch()) {
            Sql_clausesContext clauses = b.sql_clauses();
            Batch_statementContext batch;
            if (clauses != null) {
                for (St_clauseContext st : clauses.st_clause()) {
                    clause(st);
                }
            } else if ((batch = b.batch_statement()) != null) {
                safeParseStatement(() -> batch(batch), batch);
            }
        }
    }

    private void clause(St_clauseContext st) {
        Ddl_clauseContext ddl = st.ddl_clause();
        Another_statementContext ast;
        if (ddl != null && !db.getArguments().isIgnorePrivileges()) {
            Schema_createContext create = ddl.schema_create();
            Schema_alterContext alter;
            if (create != null) {
                safeParseStatement(() -> create(create), create);
            } else if ((alter = ddl.schema_alter()) != null) {
                alter(alter);
            }
        } else if ((ast = st.another_statement()) != null) {
            Security_statementContext ss;
            if ((ss = ast.security_statement()) != null && ss.rule_common() != null) {
                safeParseStatement(new GrantMsPrivilege(ss.rule_common(), db, overrides), ss);
            }
        }
    }

    private void create(Schema_createContext ctx) {
        Create_assemblyContext ass = ctx.create_assembly();
        if (ass!= null && ass.owner_name != null) {
            computeOverride(PgDatabase::getAssembly, ass.assembly_name, ass.owner_name);
        }
    }

    private void alter(Schema_alterContext ctx) {
        if (ctx.alter_authorization() != null) {
            safeParseStatement(new AlterMsAuthorization(
                    ctx.alter_authorization(), db, overrides), ctx);
        }
    }

    private void batch(Batch_statementContext batch) {
        Create_schemaContext schema = batch.create_schema();
        if (schema != null && schema.owner_name != null) {
            computeOverride(PgDatabase::getSchema, schema.schema_name, schema.owner_name);
        }
    }

    private <R extends PgStatement> void computeOverride(
            BiFunction<PgDatabase, String, R> getter, IdContext nameCtx, IdContext ownerCtx) {
        String name = nameCtx.getText();
        R statement = getter.apply(db, name);
        if (statement == null) {
            throw new UnresolvedReferenceException("Cannot find object in database: "
                    + name, nameCtx.getStart());
        }

        String owner = ownerCtx.getText();
        overrides.computeIfAbsent(statement, k -> new StatementOverride()).setOwner(owner);
    }
}
