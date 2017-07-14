package ru.taximaxim.codekeeper.ui.generators;

import java.math.BigInteger;

public class IncrementPgDataGenerator extends PgDataGenerator {

    public IncrementPgDataGenerator() {
        super();
    }

    @Override
    protected Object generateInteger() {
        return new BigInteger(column.getBegin()).subtract(new BigInteger(column.getStep()).negate());
    }

    @Override
    public String getName() {
        return "INCREMENT";
    }
}
