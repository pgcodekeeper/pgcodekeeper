package ru.taximaxim.codekeeper.ui.generators;

/**
 * An implementation of a PostgreSql data generator for BOOLEAN type.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class BooleanPgData extends PgData {

    @Override
    public String generateValue() {
        switch (generator){
        case CONSTANT: return start;
        case INCREMENT:
            String current = currentInc;
            currentInc = String.valueOf(!Boolean.parseBoolean(start));
            return current;
        case RANDOM: return generateRandom();
        default:
            // throw new Exception("Unsupported format");
            return null;
        }
    }

    private String generateRandom() {
        if (!isUnique && !isNotNull && ran.nextDouble() < 0.1) {
            return null;
        }
        while (true) {
            String object = String.valueOf(ran.nextDouble() < 0.5);
            if (!isUnique || objects.add(object)){
                return object;
            }
        }
    }

    @Override
    public int getMaxValues() {
        return 2;
    }
}
