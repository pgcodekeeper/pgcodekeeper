/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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

import java.util.Arrays;

public class FormatConfiguration {

    public enum IndentType {
        DISABLE, TAB, WHITESPACE
    }

    private boolean addWhitespaceBeforeOp;
    private boolean addWhitespaceAfterOp;
    private boolean removeTrailingWhitespace;

    private IndentType indentType = IndentType.DISABLE;
    private int indentSize;

    public void setAddWhitespaceBeforeOp(boolean addWhitespaceBeforeOp) {
        this.addWhitespaceBeforeOp = addWhitespaceBeforeOp;
    }

    public void setAddWhitespaceAfterOp(boolean addWhitespaceAfterOp) {
        this.addWhitespaceAfterOp = addWhitespaceAfterOp;
    }

    public void setRemoveTrailingWhitespace(boolean removeTrailingWhitespace) {
        this.removeTrailingWhitespace = removeTrailingWhitespace;
    }

    public void setIndentSize(int indentSize) {
        this.indentSize = indentSize;
    }

    public boolean isAddWhitespaceAfterOp() {
        return addWhitespaceAfterOp;
    }

    public boolean isAddWhitespaceBeforeOp() {
        return addWhitespaceBeforeOp;
    }

    public boolean isRemoveTrailingWhitespace() {
        return removeTrailingWhitespace;
    }

    public int getIndentSize() {
        return indentSize;
    }

    public IndentType getIndentType() {
        return indentType;
    }

    public void setIndentType(IndentType indentType) {
        this.indentType = indentType;
    }

    public String createIndent(int length) {
        return createIndent(length, getIndentType() == IndentType.TAB ? '\t' : ' ');
    }

    public static String createIndent(int length, char indentChar) {
        if (length <= 0) {
            return "";
        }

        char [] chars  = new char[length];
        Arrays.fill(chars, indentChar);

        return new String(chars);
    }

    public FormatConfiguration copy() {
        FormatConfiguration config = new FormatConfiguration();
        config.addWhitespaceBeforeOp = isAddWhitespaceBeforeOp();
        config.addWhitespaceAfterOp = isAddWhitespaceAfterOp();
        config.removeTrailingWhitespace = isRemoveTrailingWhitespace();
        config.indentType = getIndentType();
        config.indentSize = getIndentSize();
        return config;
    }
}
