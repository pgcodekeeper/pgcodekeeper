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
