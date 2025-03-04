package ru.taximaxim.codekeeper.core.schema.pg;

public enum EnabledState {
    ENABLE("ENABLE"),
    ENABLE_ALWAYS("ENABLE ALWAYS"),
    ENABLE_REPLICA("ENABLE REPLICA"),
    DISABLE("DISABLE");

    public final String value;

    private EnabledState(String value) {
        this.value = value;
    }
}
