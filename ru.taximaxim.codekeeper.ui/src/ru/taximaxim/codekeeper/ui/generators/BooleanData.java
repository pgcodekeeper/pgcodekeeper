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

import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for BOOLEAN type.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public final class BooleanData extends DbData<Boolean> {

    public BooleanData() {
        super(DataType.BOOLEAN, true, null, null);
    }

    @Override
    public Boolean generateValue() {
        return switch (generator) {
        case CONSTANT -> start;
        case INCREMENT -> {
            Boolean current = currentInc;
            currentInc = !start;
            yield current;
        }
        case RANDOM -> generateRandom();
        default -> null;
        };
    }

    @Override
    protected Boolean generateRandom(Random ran) {
        return ran.nextBoolean();
    }

    @Override
    public int getMaxValues() {
        return 2;
    }

    @Override
    protected Boolean valueFromString(String s) {
        return Boolean.valueOf(s);
    }
}
