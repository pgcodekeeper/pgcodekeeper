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

import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for REAL types.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public final class RealData extends DbData<Double> {

    public RealData(DataType type) {
        super(type, 0.0, 1000.0, 1.0);
    }

    @Override
    public Double generateValue() {
        return switch (generator) {
        case CONSTANT -> start;
        case INCREMENT -> {
            Double current = currentInc;
            currentInc += step;
            yield current;
        }
        case RANDOM -> generateRandom();
        default -> null;
        };
    }

    @Override
    protected Double generateRandom(Random ran) {
        return (end - start) * ran.nextDouble() + start;
    }

    @Override
    public int getMaxValues() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected Double valueFromString(String s) {
        return Double.valueOf(s);
    }
}
