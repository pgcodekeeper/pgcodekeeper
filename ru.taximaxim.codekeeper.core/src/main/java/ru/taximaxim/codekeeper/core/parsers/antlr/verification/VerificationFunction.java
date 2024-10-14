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

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrError;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.ErrorTypes;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_function_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_actions_commonContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_createContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.PgParserAbstract;
import ru.taximaxim.codekeeper.core.schema.ArgMode;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * class for verify function statement
 */
public class VerificationFunction implements IVerification {
    private final Schema_createContext createCtx;
    private final Create_function_statementContext ctx;
    private final Character_stringContext definitionCtx;
    private final VerificationProperties rules;
    private final List<Object> errors;
    private final String fileName;
    private String language;
    private int methodCount;

    public VerificationFunction(Schema_createContext createCtx, VerificationProperties rules,
            String fileName, List<Object> errors) {
        this.createCtx = createCtx;
        this.ctx = createCtx.create_function_statement();
        this.rules = rules;
        this.fileName = fileName;
        this.errors = errors;
        this.definitionCtx = getFunctionDefinition();
    }

    @Override
    public void verify() {
        verifyFuncLength();
        verifyFuncParams();
        verifyFunctionBody();
        verifyMethodCount();
        verifyIndents();
        verifyDollarStyle();
    }

    /**
     * checking max length;
     */
    private void verifyFuncLength() {
        var ruleLength = rules.getMaxFunctionLenght();
        var funcLength = ctx.getStop().getLine();
        if (ruleLength > 0 && funcLength > ruleLength) {
            addError(MessageFormat.format(Messages.VerificationFunction_function_length, funcLength, ruleLength));
        }
    }

    /**
     * checking NCSS rule;
     */
    private void verifyMethodCount() {
        int ruleMethodCount = rules.getMethodCount();
        if (ruleMethodCount > 0 && methodCount > ruleMethodCount) {
            addError(MessageFormat.format(Messages.VerificationFunction_ncss, methodCount, ruleMethodCount));
        }
    }

    /**
     * checking the number of parameters in a function
     */
    private void verifyFuncParams() {
        int limitParams = rules.getMaxFunctionParams();
        if (limitParams < 0) {
            return;
        }

        var countParams = ctx.function_parameters().function_args().function_arguments().stream().
                filter(arg -> ParserAbstract.parseArgMode(arg.argmode()) != ArgMode.OUT).count();
        if (countParams > limitParams) {
            addError(MessageFormat.format(Messages.VerificationFunction_function_params, countParams, limitParams));
        }
    }

    /**
     * checking the case block rule & rule for creating a table. Walk on function body
     */
    private void verifyFunctionBody() {
        Function_bodyContext body = ctx.function_body();
        if (body != null) {
            runVerifyListener(body, null);
            return;
        }

        if (definitionCtx == null) {
            return;
        }

        Pair<String, Token> pair = PgParserAbstract.unquoteQuotedString(definitionCtx);
        SQLParser parser = AntlrParser.makeBasicParser(SQLParser.class, pair.getFirst(), fileName, errors);

        ParserRuleContext contex;
        if ("SQL".equalsIgnoreCase(language)) { //$NON-NLS-1$
            contex = parser.sql();
        } else {
            AntlrUtils.removeIntoStatements(parser);
            contex = parser.plpgsql_function();
        }
        runVerifyListener(contex, pair.getSecond());
    }

    /**
     * checking cyclomatic complexity
     * stylistic check of indents
     */
    private void verifyIndents() {
        Function_bodyContext body = ctx.function_body();
        if (body != null) {
            SQLParser parser = AntlrParser.makeBasicParser(SQLParser.class, ParserAbstract.getFullCtxText(createCtx),
                    fileName, errors);
            parser.sql();
            CommonTokenStream tokenStream = (CommonTokenStream) parser.getTokenStream();

            new VerificationIndents(ctx.getStart(), body, tokenStream, fileName, errors, rules).verify();
        } else if (definitionCtx != null) {
            Pair<String, Token> pair = PgParserAbstract.unquoteQuotedString(definitionCtx);
            String definition = pair.getFirst();
            Token codeStart = pair.getSecond();

            new VerificationIndents(codeStart, definition, language, fileName, errors, rules).verify();
        }
    }

    /**
     * Checking DollarStyle rule Dollar must begin with a new line and front of him no contains spaces.
     */
    private void verifyDollarStyle() {
        var allowedFunctionStart = rules.getAllowedFunctionStart();
        if (allowedFunctionStart.isEmpty() || definitionCtx == null) {
            return;
        }

        var beginToken = definitionCtx.getStart();
        if (!allowedFunctionStart.contains(beginToken.getText().toLowerCase(Locale.ROOT))) {
            addError(MessageFormat.format(Messages.VerificationFunction_body_start, allowedFunctionStart), beginToken);
        }
    }

    private void addError(String msg) {
        addError(msg, 1, 0);
    }

    private void addError(String msg, Token token) {
        addError(msg, token.getLine(), token.getCharPositionInLine());
    }

    private void addError(String msg, int line, int position) {
        AntlrError err = new AntlrError(fileName, line, position, msg, ErrorTypes.VERIFICATIONERROR);
        errors.add(err);
    }

    private Character_stringContext getFunctionDefinition() {
        Function_defContext funcDef = null;
        for (Function_actions_commonContext action : ctx.function_actions_common()) {
            if (action.LANGUAGE() != null) {
                language = action.lang_name.getText();
            } else if (action.AS() != null) {
                funcDef = action.function_def();
            }
        }

        if (funcDef == null || funcDef.symbol != null || !PgDiffUtils.isValidLanguage(language)) {
            return null;
        }

        return funcDef.definition;
    }

    private void runVerifyListener(ParserRuleContext definition, Token token) {
        var listener = new VerificationFunctionTreeListener(fileName, rules, errors, token);
        ParseTreeWalker.DEFAULT.walk(listener, definition);
        this.methodCount = listener.getMethodCount();
    }
}
