package ru.taximaxim.codekeeper.ui.generators;

import java.text.MessageFormat;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * An implementation of a PostgreSql data generator for Time type.
 * <br><br>
 * Here step is stored as {@link LocalTime#toSecondOfDay()()} s of increment.
 *
 * @since 4.2.2
 * @author galiev_mr
 */
public class TimePgData extends PgData<LocalTime> {

    public TimePgData() {
        super(PgDataType.TIME,
                LocalTime.MIN,
                LocalTime.of(23, 59, 59),
                LocalTime.ofSecondOfDay(1));
    }

    @Override
    public LocalTime generateValue() {
        switch (generator) {
        case CONSTANT: return start;
        case INCREMENT:
            LocalTime current = currentInc;
            currentInc = current.plusNanos(step.toNanoOfDay());
            return current;
        case RANDOM: return generateRandom();
        default:
            return null;
        }
    }

    @Override
    public String generateAsString() {
        if (generator == PgDataGenerator.ANY) {
            return any;
        }
        LocalTime value = generateValue();
        return value == null ? "null" : ("'" + value + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    @Override
    protected LocalTime generateRandom(Random ran) {
        return start.plus((long)((((end.toSecondOfDay() - start.toSecondOfDay())
                * 1000) + 1) * ran.nextDouble()) , ChronoUnit.MILLIS);
    }

    @Override
    public int getMaxValues() {
        long beginTime = start.toSecondOfDay() * 1000L;
        long endTime = end.toSecondOfDay() * 1000L;
        long values = endTime - beginTime + 1;
        return values > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) values;
    }

    @Override
    public LocalTime valueFromString(String s) {
        try {
            return LocalTime.parse(s);
        } catch (DateTimeParseException ex) {
            throw new DateTimeException(
                    MessageFormat.format(EXP_FORMAT, ex.getParsedString(), "HH:MM:SS"), ex); //$NON-NLS-1$
        }
    }

    @Override
    public String getStepAsString() {
        return Duration.between(LocalTime.MIN, step).toString();
    }

    @Override
    public void setStepFromString(String step) {
        try {
            setStep(LocalTime.ofNanoOfDay((Duration.parse(step).toNanos())));
        } catch (DateTimeParseException ex) {
            throw new DateTimeException(
                    MessageFormat.format(EXP_FORMAT, ex.getParsedString(), Messages.Duration_expected_format), ex);
        }
    }
}