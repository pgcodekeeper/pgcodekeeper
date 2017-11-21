package ru.taximaxim.codekeeper.ui.generators;

import java.time.Instant;
import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for DATE type.
 * <br><br>
 * Here step is stored as {@link Instant#toEpochMilli()} ms of increment.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class DatePgData extends PgData<Instant> {

    public DatePgData() {
        super(PgDataType.DATE, Instant.ofEpochMilli(0), Instant.parse("2070-01-01T00:00:00Z"),
                Instant.ofEpochMilli(1000));
    }
    @Override
    public Instant generateValue() {
        switch (generator) {
        case CONSTANT: return start;
        case INCREMENT:
            Instant current = currentInc;
            currentInc = current.plusMillis(step.toEpochMilli());
            return current;
        case RANDOM: return generateRandom();
        default:
            return null;
        }
    }

    @Override
    protected Instant generateRandom(Random ran) {
        return start.plusMillis((long)((end.toEpochMilli() - start.toEpochMilli() + 1)
                * ran.nextDouble() + start.toEpochMilli()));
    }

    @Override
    public int getMaxValues() {
        long beginTime = start.getEpochSecond();
        long endTime = end.getEpochSecond();
        long values = (endTime - beginTime + 1);
        return values > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) values;
    }

    @Override
    public Instant valueFromString(String s) {
        return Instant.parse(s);
    }
}
