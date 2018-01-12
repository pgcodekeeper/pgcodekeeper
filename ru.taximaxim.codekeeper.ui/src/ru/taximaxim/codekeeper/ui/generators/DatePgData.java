package ru.taximaxim.codekeeper.ui.generators;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for DATE type.
 * <br><br>
 * Here step is stored as {@link LocalDate#ofEpochDay()} days of increment.
 *
 * @since 4.1.3
 * @author galiev_mr
 */
public class DatePgData extends PgData<LocalDate> {

    public DatePgData() {
        super(PgDataType.DATE,
                LocalDate.ofEpochDay(0),
                LocalDate.of(2070, 1, 1),
                LocalDate.ofEpochDay(1));
    }

    @Override
    public LocalDate generateValue() {
        switch (generator) {
        case CONSTANT: return start;
        case INCREMENT:
            LocalDate current = currentInc;
            currentInc = current.plusDays(step.toEpochDay());
            return current;
        case RANDOM: return generateRandom();
        default:
            return null;
        }
    }

    @Override
    public String generateAsString() {
        LocalDate value = generateValue();
        return value == null ? "null" : ("'" + value + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    @Override
    protected LocalDate generateRandom(Random ran) {
        return start.plusDays((long)((end.toEpochDay() - start.toEpochDay() + 1)
                * ran.nextDouble() + start.toEpochDay()));
    }

    @Override
    public int getMaxValues() {
        long beginTime = start.toEpochDay();
        long endTime = end.toEpochDay();
        long values = (endTime - beginTime + 1);
        return values > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) values;
    }

    @Override
    public LocalDate valueFromString(String s) {
        return LocalDate.parse(s);
    }

    @Override
    public String getStepAsString() {
        return Long.toString(Duration.between(LocalDate.ofEpochDay(0).atStartOfDay(),
                step.atStartOfDay()).toDays());
    }

    @Override
    public void setStepFromString(String step) {
        setStep(LocalDate.ofEpochDay(Long.parseLong(step)));
    }
}
