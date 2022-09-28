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
}
