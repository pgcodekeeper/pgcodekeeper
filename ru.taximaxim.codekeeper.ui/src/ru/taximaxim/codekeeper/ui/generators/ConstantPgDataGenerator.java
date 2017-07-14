package ru.taximaxim.codekeeper.ui.generators;

public class ConstantPgDataGenerator extends PgDataGenerator {

    public ConstantPgDataGenerator() {
        super();
    }

    @Override
    protected Object generateValue(PgDataColumn column) {
        return column.getBegin();
    }

    @Override
    public String getName() {
        return "CONSTANT";
    }
}
