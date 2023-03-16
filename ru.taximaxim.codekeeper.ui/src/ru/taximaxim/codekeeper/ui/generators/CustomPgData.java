/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
 * An implementation of a PostgreSql data generator for unimplemented types.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class CustomPgData extends PgData<String> {

    public CustomPgData() {
        super(PgDataType.OTHER, "'data'", null, null); //$NON-NLS-1$
    }

    @Override
    public String generateValue() {
        return generator == PgDataGenerator.ANY ? start : null;
    }

    @Override
    protected String generateRandom(Random ran) {
        return null;
    }

    @Override
    public int getMaxValues() {
        return 1;
    }

    @Override
    public String valueFromString(String s) {
        return s;
    }
}
