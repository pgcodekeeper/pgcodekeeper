package ru.taximaxim.codekeeper.ui.generators;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for INTEGER types.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class IntegerPgData extends PgData<BigInteger> {

    public IntegerPgData(PgDataType type) {
        super(type, BigInteger.ZERO, BigInteger.valueOf(1000), BigInteger.ONE);
    }

    @Override
    public BigInteger generateValue() {
        switch (generator){
        case CONSTANT: return start;
        case INCREMENT:
            BigInteger current = currentInc;
            currentInc = current.add(step);
            return current;
        case RANDOM: return generateRandom();
        default:
            return null;
        }
    }

    @Override
    protected BigInteger generateRandom(Random ran) {
        BigInteger range = end.subtract(start).add(BigInteger.ONE);
        return new BigDecimal(range).multiply(BigDecimal.valueOf(ran.nextDouble()))
                .toBigInteger().add(start);
    }

    @Override
    public int getMaxValues() {
        try {
            return end.subtract(start).add(BigInteger.ONE).intValueExact();
        } catch (ArithmeticException ex) {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public BigInteger valueFromString(String s) {
        return new BigInteger(s);
    }
}
