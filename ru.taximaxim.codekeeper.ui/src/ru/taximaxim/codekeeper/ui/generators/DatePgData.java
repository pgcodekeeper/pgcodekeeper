/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
        if (generator == PgDataGenerator.ANY) {
            return any;
        }
        LocalDate value = generateValue();
        return value == null ? "null" : ("'" + value + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    @Override
    protected LocalDate generateRandom(Random ran) {
        return start.plusDays((long)((end.toEpochDay() - start.toEpochDay() + 1)
                * ran.nextDouble()));
    }

    @Override
    public int getMaxValues() {
        long beginTime = start.toEpochDay();
        long endTime = end.toEpochDay();
        long values = endTime - beginTime + 1;
        return values > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) values;
    }

    @Override
    public LocalDate valueFromString(String s) {
        try {
            return LocalDate.parse(s);
        } catch (DateTimeParseException ex) {
            throw new DateTimeException(
                    MessageFormat.format(EXP_FORMAT, ex.getParsedString(), "YYYY-MM-DD"), ex); //$NON-NLS-1$
        }
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
