package ru.taximaxim.codekeeper.ui.generators;

import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for BOOLEAN type.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class BooleanPgData extends PgData<Boolean> {

    public BooleanPgData() {
        super(PgDataType.BOOLEAN, true, null, null);
    }

    @Override
    public Boolean generateValue() {
        switch (generator){
        case CONSTANT: return start;
        case INCREMENT:
            Boolean current = currentInc;
            currentInc = !start;
            return current;
        case RANDOM: return generateRandom();
        default:
            return null;
        }
    }

    @Override
    protected Boolean generateRandom(Random ran) {
        return ran.nextBoolean();
    }

    @Override
    public int getMaxValues() {
        return 2;
    }

    @Override
    public Boolean valueFromString(String s) {
        return Boolean.valueOf(s);
    }
}
