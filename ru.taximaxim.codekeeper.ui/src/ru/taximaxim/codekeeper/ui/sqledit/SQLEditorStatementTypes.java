package ru.taximaxim.codekeeper.ui.sqledit;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public enum SQLEditorStatementTypes {
    FUNCTIONS("prefsFunction", Messages.SQLEditorStatementTypes_funcs), //$NON-NLS-1$
    RESERVED_WORDS("prefsReservedWords", Messages.SQLEditorStatementTypes_reserved), //$NON-NLS-1$
    UN_RESERVED_WORDS("prefsUnReservedWords", Messages.SQLEditorStatementTypes_unreserved), //$NON-NLS-1$
    TYPES("prefsTypes", Messages.SQLEditorStatementTypes_types), //$NON-NLS-1$
    SINGLE_LINE_COMMENTS("prefsSingleLineComments", Messages.SQLEditorStatementTypes_single_comments), //$NON-NLS-1$
    MULTI_LINE_COMMENTS("prefsMultiLineComments", Messages.SQLEditorStatementTypes_multi_comments), //$NON-NLS-1$
    CHARACTER_STRING_LITERAL("prefsCharacterStringLiteralComments", Messages.SQLEditorStatementTypes_string_literals), //$NON-NLS-1$
    QUOTED_IDENTIFIER("prefsQuotedIdentifier", Messages.SQLEditorStatementTypes_quoted_identifier); //$NON-NLS-1$

    private String name;
    private String translatedName;

    private SQLEditorStatementTypes(String name, String translatedName) {
        this.name = name;
        this.translatedName = translatedName;
    }

    @Override
    public String toString() {
        return translatedName;
    }

    public String getPrefName() {
        return name;
    }
}
