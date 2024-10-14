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

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class VerificationProperties {

    // Rules for code verification

    private static final String MAX_FUNCTION_LENGTH = "max_function_length";
    private static final String METHOD_COUNT = "method_count";
    private static final String MAX_PARAMS_COUNT = "max_function_params";
    private static final String CYCLO_COMPLEX = "cyclomatic_complexity";
    private static final String INDENT_SIZE = "indent_size";

    private static final String CHECK_CASE_WITHOUT_ELSE = "check_case_without_else";
    private static final String CHECK_TEMP_TABLE = "check_temp_table";
    private static final String CHECK_SPACE_ON_MATH = "check_space_on_math";
    private static final String CHECK_SPACE_AFTER_IF = "check_space_after_if";
    private static final String CHECK_QUOTES_IN_TABLE_COLUMN = "check_quotes_in_table_column";
    private static final String CHECK_INDENTS = "check_indents";
    private static final String CHECK_SPACE_AFTER_COMMA = "check_space_after_comma";
    private static final String CHECK_SEMICOLON_AFTER_SIMPLE_SQL = "check_semicolon_after_simple_sql";

    private static final String ALLOWED_FUNCTION_START = "allowed_function_start";
    private static final String DENY_GRANT = "deny_grant";

    private final int maxFunctionLenght;
    private final int methodCount;
    private final int maxFunctionParams;
    private final int maxCyclomaticComplexity;
    private final int indentSize;
    private final boolean checkTempTable;
    private final boolean checkSpaceOnMath;
    private final boolean checkCaseWithElse;
    private final boolean checkSpaceAfterIf;
    private final boolean checkQuotesInTableColumn;
    private final boolean checkIndents;
    private final boolean checkSpaceAfterComma;
    private final boolean checkSemicolonAfterSimpleSql;
    private final List<String> allowedFunctionStart;
    private final List<String> deniedUsers;

    public VerificationProperties(Properties properties) {
        this.maxFunctionLenght = getIntProperty(properties, MAX_FUNCTION_LENGTH, -1);
        this.methodCount = getIntProperty(properties, METHOD_COUNT, -1);
        this.maxFunctionParams = getIntProperty(properties, MAX_PARAMS_COUNT, -1);
        this.maxCyclomaticComplexity = getIntProperty(properties, CYCLO_COMPLEX, -1);
        this.indentSize = getIntProperty(properties, INDENT_SIZE, 2);
        this.checkCaseWithElse = getBooleanProperty(properties, CHECK_CASE_WITHOUT_ELSE);
        this.checkTempTable = getBooleanProperty(properties, CHECK_TEMP_TABLE);
        this.checkSpaceOnMath = getBooleanProperty(properties, CHECK_SPACE_ON_MATH);
        this.checkSpaceAfterIf = getBooleanProperty(properties, CHECK_SPACE_AFTER_IF);
        this.checkQuotesInTableColumn = getBooleanProperty(properties, CHECK_QUOTES_IN_TABLE_COLUMN);
        this.checkIndents = getBooleanProperty(properties, CHECK_INDENTS);
        this.checkSpaceAfterComma = getBooleanProperty(properties, CHECK_SPACE_AFTER_COMMA);
        this.checkSemicolonAfterSimpleSql = getBooleanProperty(properties, CHECK_SEMICOLON_AFTER_SIMPLE_SQL);
        this.allowedFunctionStart = getListProperty(properties, ALLOWED_FUNCTION_START);
        this.deniedUsers = getListProperty(properties, DENY_GRANT);
    }

    private int getIntProperty(Properties properties, String paramName, int defaultValue) {
        String temp = properties.getProperty(paramName);
        if (temp != null) {
            return Integer.parseInt(temp);
        }

        return defaultValue;
    }

    private List<String> getListProperty(Properties properties, String paramName) {
        String temp = properties.getProperty(paramName);
        if (temp != null) {
            return Arrays.asList(temp.toLowerCase(Locale.ROOT).trim().split("\\s*,\\s*"));
        }

        return Collections.emptyList();
    }

    private boolean getBooleanProperty(Properties properties, String paramName) {
        String temp = properties.getProperty(paramName);
        return Boolean.parseBoolean(temp);
    }

    public int getMaxCyclomaticComplexity() {
        return maxCyclomaticComplexity;
    }

    public int getMaxFunctionLenght() {
        return maxFunctionLenght;
    }

    public int getMaxFunctionParams() {
        return maxFunctionParams;
    }

    public int getIndentSize() {
        return indentSize;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public boolean isCheckCaseWithElse() {
        return checkCaseWithElse;
    }

    public boolean isCheckTempTable() {
        return checkTempTable;
    }

    public boolean isCheckSpaceOnMath() {
        return checkSpaceOnMath;
    }

    public boolean isCheckSemicolonAfterSimpleSql() {
        return checkSemicolonAfterSimpleSql;
    }

    public boolean isCheckSpaceAfterIf() {
        return checkSpaceAfterIf;
    }

    public boolean isCheckQuotesInTableColumn() {
        return checkQuotesInTableColumn;
    }

    public boolean isCheckIndents() {
        // TODO replace after correcting indents
        // return checkIndents;
        return false;
    }

    public boolean isSpaceAfterComma() {
        return checkSpaceAfterComma;
    }

    public List<String> getAllowedFunctionStart() {
        return allowedFunctionStart;
    }

    public List<String> getDeniedUsers() {
        return deniedUsers;
    }

    public static VerificationProperties readProperties(Path path) throws IOException {
        Properties rules = new Properties();
        try (Reader reader = Files.newBufferedReader((path), StandardCharsets.UTF_8)) {
            rules.load(reader);
        }
        return new VerificationProperties(rules);
    }
}