/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.generators;

import java.text.MessageFormat;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Random;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * An implementation of a PostgreSql data generator for Timestamp type.
 * <br><br>
 * Here step is stored as {@link Instant#toEpochMilli()} ms of increment.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public final class TimestampData extends DbData<Instant> {

    public TimestampData() {
        super(DataType.TIMESTAMP, Instant.ofEpochMilli(0), Instant.parse("2070-01-01T00:00:00Z"), //$NON-NLS-1$
                Instant.ofEpochMilli(1000));
    }

    @Override
    public Instant generateValue() {
        return switch (generator) {
        case CONSTANT -> start;
        case INCREMENT -> {
            Instant current = currentInc;
            currentInc = current.plusMillis(step.toEpochMilli());
            yield current;
        }
        case RANDOM -> generateRandom();
        default -> null;
        };
    }

    @Override
    public String generateAsString() {
        if (generator == DataGenerator.ANY) {
            return any;
        }
        Instant value = generateValue();
        return value == null ? "null" : ("'" + value + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    @Override
    protected Instant generateRandom(Random ran) {
        return start.plusMillis((long)((end.toEpochMilli() - start.toEpochMilli() + 1) * ran.nextDouble()));
    }

    @Override
    public int getMaxValues() {
        long beginTime = start.getEpochSecond();
        long endTime = end.getEpochSecond();
        long values = (endTime - beginTime + 1);
        return values > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) values;
    }

    @Override
    protected Instant valueFromString(String s) {
        try {
            return Instant.parse(s);
        } catch (DateTimeParseException ex) {
            throw new DateTimeException(
                    EXP_FORMAT.formatted(ex.getParsedString(), "YYYY-MM-DDTHH:MM:SSZ"), ex); //$NON-NLS-1$
        }
    }

    @Override
    public String getStepAsString() {
        return Duration.ofMillis(step.toEpochMilli()).toString();
    }

    @Override
    public void setStepFromString(String step) {
        try {
            setStep(Instant.ofEpochMilli(Duration.parse(step).toMillis()));
        } catch (DateTimeParseException ex) {
            throw new DateTimeException(
                    EXP_FORMAT.formatted(ex.getParsedString(), Messages.Duration_expected_format), ex);
        }
    }
}
