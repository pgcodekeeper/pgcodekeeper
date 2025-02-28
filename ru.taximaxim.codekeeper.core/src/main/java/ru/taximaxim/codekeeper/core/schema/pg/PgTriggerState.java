package ru.taximaxim.codekeeper.core.schema.pg;

public enum PgTriggerState {
    ENABLE("ENABLE"),
    ENABLE_ALWAYS("ENABLE ALWAYS"),
    ENABLE_REPLICA("ENABLE REPLICA"),
    DISABLE("DISABLE");

    public final String strValue;

    private PgTriggerState(String value) {
        this.strValue = value;
    }
}
