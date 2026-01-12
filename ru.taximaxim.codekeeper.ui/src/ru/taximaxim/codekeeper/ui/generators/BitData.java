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
 * An implementation of a PostgreSql data generator for BIT type.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public final class BitData extends DbData<String> {

    public BitData(DataType type, String constant) {
        super(type, constant, null, null);
    }

    @Override
    public String generateValue() {
        return switch (generator) {
        case CONSTANT -> start;
        case INCREMENT -> null;
        case RANDOM -> generateRandom();
        default -> null;
        };
    }

    @Override
    protected String generateRandom(Random ran) {
        return "B'"+ genSymbols(length, true, false) + "'"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public int getMaxValues() {
        return length == 0 ? 0 : (int) Math.pow(2, length);
    }

    @Override
    protected String valueFromString(String s) {
        return s;
    }
}
