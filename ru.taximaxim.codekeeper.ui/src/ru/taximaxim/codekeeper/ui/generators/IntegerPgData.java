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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 * An implementation of a PostgreSql data generator for INTEGER types.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class IntegerPgData extends PgData<BigInteger> {

    public IntegerPgData(PgDataType type) {
        super(type, BigInteger.ZERO, BigInteger.valueOf(1000), BigInteger.ONE);
    }

    @Override
    public BigInteger generateValue() {
        switch (generator){
        case CONSTANT: return start;
        case INCREMENT:
            BigInteger current = currentInc;
            currentInc = current.add(step);
            return current;
        case RANDOM: return generateRandom();
        default:
            return null;
        }
    }

    @Override
    protected BigInteger generateRandom(Random ran) {
        BigInteger range = end.subtract(start).add(BigInteger.ONE);
        return new BigDecimal(range).multiply(BigDecimal.valueOf(ran.nextDouble()))
                .toBigInteger().add(start);
    }

    @Override
    public int getMaxValues() {
        try {
            return end.subtract(start).add(BigInteger.ONE).intValueExact();
        } catch (ArithmeticException ex) {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public BigInteger valueFromString(String s) {
        return new BigInteger(s);
    }
}
