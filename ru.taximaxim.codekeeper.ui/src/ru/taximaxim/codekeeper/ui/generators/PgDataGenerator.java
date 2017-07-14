package ru.taximaxim.codekeeper.ui.generators;

public abstract class PgDataGenerator {

    protected PgDataColumn column;

    public abstract String getName();

    protected Object generateValue(PgDataColumn column) {
        this.column = column;
        switch (column.getType()) {
        case SMALLINT:
        case INTEGER:
        case BIGINT: return generateInteger();
        case BIT: return generateBit();
        case BOOLEAN: return generateBoolean();
        case CHARACTER: return generateCharacter();
        case DATE: return generateDate();
        case DOUBLE: return generateDouble();
        case JSON: return generateJson();
        case NUMERIC: return generateNumeric();
        case OTHER: return generateOther();
        case REAL: return generateReal();
        case TEXT: return generateText();
        default: return null;
        }
    }

    protected Object generateCharacter() {
        return null;
    }

    protected Object generateDate() {
        return null;
    }

    protected Object generateInteger() {
        return null;
    }

    protected Object generateDouble() {
        return null;
    }

    protected Object generateJson() {
        return null;
    }

    protected Object generateNumeric() {
        return null;
    }

    protected Object generateOther() {
        return null;
    }

    protected Object generateReal() {
        return null;
    }

    protected Object generateText() {
        return null;
    }

    protected Object generateBoolean() {
        return null;
    }

    protected Object generateBit() {
        return null;
    }

}