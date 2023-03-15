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
package ru.taximaxim.codekeeper.ui.formatter;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.text.edits.TextEdit;

import ru.taximaxim.codekeeper.core.formatter.FileFormatter;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration.IndentType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FORMATTER_PREF;

public class Formatter {

    public static FormatConfiguration getFormatterConfig() {
        IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
        FormatConfiguration config = new FormatConfiguration();

        String mode = mainPrefs.getString(FORMATTER_PREF.INDENT_TYPE);
        if (FORMATTER_PREF.WHITESPACE.equals(mode)) {
            config.setIndentType(IndentType.WHITESPACE);
        } else if (FORMATTER_PREF.TAB.equals(mode)) {
            config.setIndentType(IndentType.TAB);
        }

        config.setIndentSize(mainPrefs.getInt(FORMATTER_PREF.INDENT_SIZE));
        config.setRemoveTrailingWhitespace(
                mainPrefs.getBoolean(FORMATTER_PREF.REMOVE_TRAILING_WHITESPACE));
        config.setAddWhitespaceBeforeOp(
                mainPrefs.getBoolean(FORMATTER_PREF.ADD_WHITESPACE_BEFORE_OP));
        config.setAddWhitespaceAfterOp(
                mainPrefs.getBoolean(FORMATTER_PREF.ADD_WHITESPACE_AFTER_OP));
        return config;
    }

    public static TextEdit formatDoc(int offset, int length, String source, boolean isMsSql) {
        FileFormatter formatter = new FileFormatter(source, offset, length, getFormatterConfig(), isMsSql);
        return formatter.getFormatEdit();
    }

    private Formatter() {
    }
}
