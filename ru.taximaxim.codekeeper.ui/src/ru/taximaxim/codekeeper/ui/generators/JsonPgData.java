package ru.taximaxim.codekeeper.ui.generators;

import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for JSON type.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class JsonPgData extends PgData<String> {

    public JsonPgData() {
        super(PgDataType.JSON, "'{\"a\": \"b\"}'", null, null);
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
        return "'{\"" + genSymbols(ran.nextInt(length) + 1, true, true) + "\": \"" +
                genSymbols(ran.nextInt(length) + 1, false, true) + "\"}'";
    }

    @Override
    public int getMaxValues() {
        return length == 0 ? 0 : (int) Math.pow(26, length);
    }

    @Override
    public String valueFromString(String s) {
        return s;
    }
}
