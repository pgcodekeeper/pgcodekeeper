package ru.taximaxim.codekeeper.ui.sqledit;

public enum SQLEditorStatementTypes {
    FUNCTIONS("prefsFunction", "Function"),
    PREDICATES("prefsPredicates", "Predicates"),
    RESERVED_WORDS("prefsReservedWords", "ReservedWords"),
    UN_RESERVED_WORDS("prefsUnReservedWords", "UnReservedWords"),
    TYPES("prefsTypes", "Types"),
    CONSTANTS("prefsConstants", "Constants"),
    SINGLE_LINE_COMMENTS("prefsSingleLineComments", "SingleLineComments"),
    GLOBAL_VARIABLES("prefsGlobalVariables", "GlobalVariables"),
    MULTI_LINE_COMMENTS("prefsMultiLineComments", "MultiLineComments"),
    CHARACTER_STRING_LITERAL("prefsCharacterStringLiteralComments", "CharacterStringLiteralComments");
    
    private String name;
    private String translatedName;
    private SQLEditorStatementTypes(String name, String tranclatedName) {
        this.name = name;
        this.translatedName = tranclatedName;
    }
    @Override
    public String toString() {
        return translatedName;
    }
    public String getPrefName() {
        return name;
    }
}
