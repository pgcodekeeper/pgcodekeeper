package ru.taximaxim.codekeeper.ui.generators;

public enum PgDataGenerator {
    RANDOM ("RANDOM"),
    CONSTANT ("CONSTANT"),
    INCREMENT ("INCREMENT");

    private String type;

    private PgDataGenerator(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}