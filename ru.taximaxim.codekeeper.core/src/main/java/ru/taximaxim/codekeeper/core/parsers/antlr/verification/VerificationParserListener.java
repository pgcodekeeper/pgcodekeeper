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
package ru.taximaxim.codekeeper.core.parsers.antlr.verification;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_createContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.SqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.StatementContext;

public class VerificationParserListener implements SqlContextProcessor {

    private final VerificationProperties rules;
    private final String fileName;
    private final List<Object> errors;

    public VerificationParserListener(VerificationProperties rules, String fileName, List<Object> errors) {
        this.rules = rules;
        this.fileName = fileName;
        this.errors = errors;
    }

    @Override
    public void process(SqlContext rootCtx, CommonTokenStream stream) {
        for (StatementContext s : rootCtx.statement()) {
            statement(s);
        }
    }

    private void statement(StatementContext statement) {
        Schema_statementContext schema = statement.schema_statement();
        if (schema == null) {
            return;
        }

        Schema_createContext create = schema.schema_create();
        if (create == null) {
            return;
        }

        IVerification verification = null;
        if (create.create_function_statement() != null) {
            verification = new VerificationFunction(create, rules, fileName, errors);
        } else if (create.rule_common() != null) {
            verification = new VerificationGrant(create.rule_common(), rules, fileName, errors);
        }

        if (verification != null) {
            verification.verify();
        }
    }
}