package ru.taximaxim.codekeeper.ui.generators;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * An implementation of a PostgreSql data generator for INTEGER types.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class IntegerPgData extends PgData {

    @Override
    public String generateValue() {
        switch (generator){
        case CONSTANT: return start;
        case INCREMENT:
            String current = currentInc;
            currentInc = new BigInteger(current).add(new BigInteger(step)).toString();
            return current;
        case RANDOM: return generateRandom();
        default:
            // throw new Exception("Unsupported format");
            return null;
        }
    }

    private String generateRandom() {
        BigInteger bigEnd = new BigInteger(end);
        BigInteger bigStart = new BigInteger(start);
        BigInteger range = bigEnd.subtract(bigStart).add(new BigInteger("1"));

        if (!isUnique && !isNotNull && ran.nextDouble() < 0.1) {
            return null;
        }
        while (true) {
            String object = new BigDecimal(range.doubleValue() * ran.nextDouble())
                    .toBigInteger().add(bigStart).toString();
            if (!isUnique || objects.add(object)){
                return object;
            }
        }
    }

    @Override
    public int getMaxValues() {
        BigInteger bigEnd = new BigInteger(end);
        BigInteger bigStart = new BigInteger(start);
        return bigEnd.subtract(bigStart).add(new BigInteger("1")).intValue();
    }
}
