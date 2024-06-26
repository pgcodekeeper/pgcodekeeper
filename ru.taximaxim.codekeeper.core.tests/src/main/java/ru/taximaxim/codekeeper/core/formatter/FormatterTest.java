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
package ru.taximaxim.codekeeper.core.formatter;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.FILES_POSTFIX;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration.IndentType;

class FormatterTest {

    /**
     * Testing default parameters
     */
    @Test
    void testDefault() throws IOException, FormatterException {
        FormatConfiguration config = new FormatConfiguration();
        config.setAddWhitespaceAfterOp(true);
        config.setAddWhitespaceBeforeOp(true);
        config.setIndentSize(2);
        config.setIndentType(IndentType.WHITESPACE);
        config.setRemoveTrailingWhitespace(true);

        String newFile = "new_Default_config";
        String oldFile = "old_Default_config";
        testFormatter(oldFile, newFile, config, DatabaseType.PG);
    }

    @Test
    void testRemoveTrailingWhitespace() throws IOException, FormatterException {
        FormatConfiguration config = new FormatConfiguration();
        config.setRemoveTrailingWhitespace(true);

        String newFile = "new_RemoveTrailingWhitespace";
        String oldFile = "old_RemoveTrailingWhitespace";
        testFormatter(oldFile, newFile, config, DatabaseType.PG);
    }

    @Test
    void testAddWhitespaceAfterOp() throws IOException, FormatterException {
        FormatConfiguration config = new FormatConfiguration();
        config.setAddWhitespaceAfterOp(true);

        String newFile = "new_AddWhitespaceAfterOp";
        String oldFile = "old_AddWhitespaceOp";
        testFormatter(oldFile, newFile, config, DatabaseType.PG);
    }

    @Test
    void testAddWhitespaceBeforeOp() throws IOException, FormatterException {
        FormatConfiguration config = new FormatConfiguration();
        config.setAddWhitespaceBeforeOp(true);

        String newFile = "new_AddWhitespaceBeforeOp";
        String oldFile = "old_AddWhitespaceOp";
        testFormatter(oldFile, newFile, config, DatabaseType.PG);
    }

    @Test
    void testAddSpacesForTabs() throws IOException, FormatterException {
        FormatConfiguration config = new FormatConfiguration();
        config.setIndentType(IndentType.WHITESPACE);
        config.setIndentSize(8);

        String newFile = "new_SpacesForTabs";
        String oldFile = "old_SpacesForTabs";
        testFormatter(oldFile, newFile, config, DatabaseType.PG);
    }

    @Test
    void testIndentSize() throws IOException, FormatterException {
        FormatConfiguration config = new FormatConfiguration();
        config.setIndentType(IndentType.WHITESPACE);
        config.setIndentSize(8);

        String newFile = "new_IndentSize";
        String oldFile = "old";
        testFormatter(oldFile, newFile, config, DatabaseType.PG);
    }

    @Test
    void testIndentType() throws IOException, FormatterException {
        FormatConfiguration config = new FormatConfiguration();
        config.setIndentType(IndentType.TAB);
        config.setIndentSize(1);

        String newFile = "new_indent_type";
        String oldFile = "old";
        testFormatter(oldFile, newFile, config, DatabaseType.PG);
    }

    @Test
    void testIndentTypeTab() throws IOException, FormatterException {
        FormatConfiguration config = new FormatConfiguration();
        config.setIndentType(IndentType.TAB);
        config.setIndentSize(2);

        String newFile = "new_IndentTypeTab";
        String oldFile = "old";
        testFormatter(oldFile, newFile, config, DatabaseType.PG);
    }

    @Test
    void testCh() throws IOException, FormatterException {
        FormatConfiguration config = new FormatConfiguration();
        config.setIndentSize(2);
        config.setAddWhitespaceAfterOp(true);
        config.setAddWhitespaceBeforeOp(true);
        config.setIndentType(IndentType.WHITESPACE);
        config.setRemoveTrailingWhitespace(true);

        String newFile = "new_ch";
        String oldFile = "old_ch";
        testFormatter(oldFile, newFile, config, DatabaseType.CH);
    }

    private void testFormatter(String oldFileName, String newFileName, FormatConfiguration config, DatabaseType dbType)
            throws FormatterException, IOException {
        String newFile = getFileContent(newFileName + FILES_POSTFIX.SQL);
        String oldFile = getFileContent(oldFileName + FILES_POSTFIX.SQL);
        FileFormatter fileform = new FileFormatter(oldFile, 0, oldFile.length(), config, dbType);
        Assertions.assertEquals(newFile, fileform.formatText(), "Formatted files are different");
    }

    private String getFileContent(String fileName) throws IOException {
        return FileUtils.readResource(FormatterTest.class, fileName);
    }
}