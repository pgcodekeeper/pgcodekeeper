package ru.taximaxim.codekeeper.ui.generators;

/**
 * An implementation of a PostgreSql data generator for BIT type.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class BitPgData extends PgData {

    @Override
    public String generateValue() {
        switch (generator) {
        case CONSTANT: return start;
        case INCREMENT:
            return null;
        case RANDOM: return generateRandom();
        default:
            // throw new Exception("Unsupported format");
            return null;
        }
    }

    private String generateRandom() {
        int len = Integer.parseInt(length);
        if (!isUnique && !isNotNull && ran.nextDouble() < 0.1) {
            return null;
        }
        while (true) {
            String object = "B'"+ genSymbols(len , true, false) + "'::bit(" + length + ")";
            if (!isUnique || objects.add(object)){
                return object;
            }
        }
    }

    @Override
    public int getMaxValues() {
        int i = Integer.parseInt(length);
        if (i == 0) {
            return 0;
        }
        return (int) Math.pow(2, i);
    }
}
