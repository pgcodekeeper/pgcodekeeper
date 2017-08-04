package ru.taximaxim.codekeeper.ui.generators;

/**
 * An implementation of a PostgreSql data generator for REAL types.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class RealPgData extends PgData {

    @Override
    public String generateValue() {
        switch (generator) {
        case CONSTANT:
            return start;
        case INCREMENT:
            String current = currentInc;
            currentInc = String.valueOf(Double.parseDouble(currentInc) + Double.parseDouble(step));
            return current;
        case RANDOM: return generateRandom();
        default:
            // throw new Exception("Unsupported format");
            return null;
        }
    }

    private String generateRandom() {
        double st = Double.parseDouble(start);
        double en = Double.parseDouble(end);
        if (!isUnique && !isNotNull && ran.nextDouble() < 0.1) {
            return null;
        }
        while (true) {
            String object = String.valueOf((en - st + 1) * ran.nextDouble() + st);
            if (!isUnique || objects.add(object)){
                return object;
            }
        }
    }

    @Override
    public int getMaxValues() {
        return Integer.MAX_VALUE;
    }
}
