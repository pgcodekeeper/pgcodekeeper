package ru.taximaxim.codekeeper.ui.generators;

import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for REAL types.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class RealPgData extends PgData<Double> {

    public RealPgData(PgDataType type) {
        super(type, 0.0, 1000.0, 1.0);
    }

    @Override
    public Double generateValue() {
        switch (generator) {
        case CONSTANT:
            return start;
        case INCREMENT:
            Double current = currentInc;
            currentInc += step;
            return current;
        case RANDOM: return generateRandom();
        default:
            return null;
        }
    }

    @Override
    protected Double generateRandom(Random ran) {
        return (end - start + 1) * ran.nextDouble() + start;
    }

    @Override
    public int getMaxValues() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Double valueFromString(String s) {
        return Double.valueOf(s);
    }
}
