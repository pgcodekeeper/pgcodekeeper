/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * An implementation of a PostgreSql data generator for TimestampTZ type.
 *
 * @since 4.2.2
 * @author galiev_mr
 */
public class TimestampTZPgData extends PgData<ZonedDateTime> {

    public TimestampTZPgData() {
        super(PgDataType.TIMESTAMPTZ,
                ZonedDateTime.parse("1970-01-01T00:00:00+01:00"), //$NON-NLS-1$
                ZonedDateTime.parse("2070-01-01T00:00:00+01:00"), //$NON-NLS-1$
                ZonedDateTime.parse("1970-01-01T00:00:01+00:00")); //$NON-NLS-1$
    }
    @Override
    public ZonedDateTime generateValue() {
        switch (generator) {
        case CONSTANT: return start;
        case INCREMENT:
            ZonedDateTime current = currentInc;
            long milles = Duration.between(ZonedDateTime.ofInstant(Instant.ofEpochMilli(0),
                    ZoneOffset.UTC), step).toMillis();
            currentInc = current.plus(milles, ChronoUnit.MILLIS);
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
        ZonedDateTime value = generateValue();
        return value == null ? "null" : ("'" + value + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    @Override
    protected ZonedDateTime generateRandom(Random ran) {
        long endTime = end.toInstant().toEpochMilli();
        long startTime = start.toInstant().toEpochMilli();
        return start.plus((long)((endTime - startTime + 1)  * ran.nextDouble()), ChronoUnit.MILLIS);
    }

    @Override
    public int getMaxValues() {
        long endTime = end.toInstant().toEpochMilli();
        long startTime = start.toInstant().toEpochMilli();
        long values = endTime - startTime + 1;
        return values > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) values;
    }

    @Override
    public ZonedDateTime valueFromString(String s) {
        try {
            return ZonedDateTime.parse(s);
        } catch (DateTimeParseException ex) {
            throw new DateTimeException(
                    MessageFormat.format(EXP_FORMAT, ex.getParsedString(), "YYYY-MM-DDTHH:MM:SS+01:00"), ex); //$NON-NLS-1$
        }
    }

    @Override
    public String getStepAsString() {
        return Duration.between(ZonedDateTime.ofInstant(Instant.ofEpochMilli(0),
                ZoneOffset.UTC), step).toString();
    }

    @Override
    public void setStepFromString(String step) {
        try {
            setStep(ZonedDateTime.ofInstant(Instant.ofEpochMilli(Duration.parse(step).toMillis()), ZoneOffset.UTC));
        } catch (DateTimeParseException ex) {
            throw new DateTimeException(
                    MessageFormat.format(EXP_FORMAT, ex.getParsedString(), Messages.Duration_expected_format), ex);
        }
    }
}