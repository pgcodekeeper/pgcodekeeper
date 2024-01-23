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

import java.util.Random;

import ru.taximaxim.codekeeper.core.PgDiffUtils;

/**
 * An implementation of a PostgreSql data generator for JSON type.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class JsonPgData extends PgData<String> {

    public JsonPgData() {
        super(PgDataType.JSON, "{\"a\": \"b\"}", null, null); //$NON-NLS-1$
    }

    @Override
    public String generateValue() {
        switch (generator) {
        case CONSTANT: return PgDiffUtils.quoteString(start);
        case INCREMENT:
            return null;
        case RANDOM: return generateRandom();
        default:
            return null;
        }
    }

    @Override
    protected String generateRandom(Random ran) {
        return "'{\"" + genSymbols(ran.nextInt(length) + 1, true, true) + "\": \"" + //$NON-NLS-1$ //$NON-NLS-2$
                genSymbols(ran.nextInt(length) + 1, false, true) + "\"}'"; //$NON-NLS-1$
    }

    @Override
    public int getMaxValues() {
        return length == 0 ? 0 : (int) Math.pow(26, length);
    }

    @Override
    public String valueFromString(String s) {
        return s;
    }
}
