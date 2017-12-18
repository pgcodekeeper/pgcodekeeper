package ru.taximaxim.codekeeper.ui.generators;

import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for BIT type.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class BitPgData extends PgData<String> {

    public BitPgData() {
        super(PgDataType.BIT, "B'01'", null, null); //$NON-NLS-1$
    }

    @Override
    public String generateValue() {
        switch (generator) {
        case CONSTANT: return start;
        case INCREMENT:
            return null;
        case RANDOM: return generateRandom();
        default:
            return null;
        }
    }

    @Override
    protected String generateRandom(Random ran) {
        return "B'"+ genSymbols(length, true, false) + "'"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public int getMaxValues() {
        return length == 0 ? 0 : (int) Math.pow(2, length);
    }

    @Override
    public String valueFromString(String s) {
        return s;
    }
}
