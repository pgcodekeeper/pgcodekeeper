package ru.taximaxim.codekeeper.ui.generators;

public enum PgDataType {
    BIGINT ("bigint"),
    BIT ("bit"),
    BOOLEAN ("boolean"),
    CHARACTER ("character"),
    DATE ("date"),
    DOUBLE ("double precision"),
    INTEGER ("integer"),
    JSON ("json"),
    NUMERIC ("numeric"),
    REAL ("real"),
    SMALLINT ("smallint"),
    TEXT ("text"),
    OTHER ("other");

    private String type;

    private PgDataType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
