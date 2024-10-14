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
package ru.taximaxim.codekeeper.core.verification;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.taximaxim.codekeeper.core.FILES_POSTFIX;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.loader.TokenLoader;
import ru.taximaxim.codekeeper.core.parsers.antlr.verification.VerificationProperties;

public class VerificationTest {
    private static final String RIGHT = "_right";

    @ParameterizedTest(name = "[{0}] - {1} : {2}")
    @CsvSource(delimiter = ';', value = {
            "function_max_length; max_function_length; 4",
            "cyclomatic_complexity; cyclomatic_complexity; 5",
            "function_params; max_function_params; 6",
            "grant_privil; deny_grant; Public, user0",
            "case_without_else; check_case_without_else; true",
            "check_temp_table; check_temp_table; true",
            "check_space_on_math; check_space_on_math; true",
            "quotes_in_table_column; check_quotes_in_table_column; true",
            // check SpaceAfterIf rule. Not space after 'if' keyword.
            "space_after_if; check_space_after_if; true",
            /**
             * checking indents. Check EolBeforeWhen rule.
             * Not EOL before when statement.
             */
            "eol_before_when; check_indents; true",
            /**
             * checking indents. Check exception indents rule
             *  "When" section starts indented, the "get stacked diagnostics"
             *  section starts indented, and all subsequent blocks are on the same level with it
             */
            "exception_position; check_indents; true",
            // checking space after comma rule.
            "space_after_comma; check_space_after_comma; true",
            "dollar_begin_function; allowed_function_start; $$, $_$, $BODY$",
            "semicolon_after_simple_sql; check_semicolon_after_simple_sql; true",
            "method_count; method_count; 40",
            //testing function body
            "function_body; method_count; 2",
    })
    void compareVerifyFiles(String fileName, String paramKey, String paramVal)
            throws IOException, InterruptedException, URISyntaxException {
        Properties rules = new Properties();
        rules.setProperty(paramKey, paramVal);

        String sourcePath = TestUtils.getPathToResource(fileName + FILES_POSTFIX.SQL, getClass()).toString();
        List<Object> errors = TokenLoader.verify(new PgDiffArguments(), new VerificationProperties(rules),
                List.of(sourcePath));
        String expectedErr = TestUtils.readResource(fileName + FILES_POSTFIX.ERRORS_TXT, getClass());

        Assertions.assertEquals(expectedErr, errors.stream().map(Object::toString).collect(Collectors.joining("\n")));
    }

    @Test
    void testVerifyGlobalRules() throws IOException, InterruptedException, URISyntaxException {
        String fileName = "check_all_rules";
        Path path = TestUtils.getPathToResource("rules.properties", getClass());
        String sourcePathRight = TestUtils.getPathToResource(fileName + RIGHT + FILES_POSTFIX.SQL, getClass()).toString();
        String sourcePath = TestUtils.getPathToResource(fileName + FILES_POSTFIX.SQL, getClass()).toString();
        List<Object> errors = TokenLoader.verify(new PgDiffArguments(), path, List.of(sourcePath, sourcePathRight));
        String expectedErr = TestUtils.readResource(fileName + FILES_POSTFIX.ERRORS_TXT, getClass());
        Assertions.assertEquals(expectedErr, errors.stream().map(Object::toString).collect(Collectors.joining("\n")));
    }
}