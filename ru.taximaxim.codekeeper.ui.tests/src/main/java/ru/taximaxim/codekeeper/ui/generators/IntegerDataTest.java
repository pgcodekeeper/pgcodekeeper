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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntegerDataTest {

    private static Stream<Arguments> generateIntegerObjects() {
        return Stream.of(
                Arguments.of(new IntegerData(DataType.INTEGER, "BIGINT", 1, Long.MAX_VALUE)),
                Arguments.of(new IntegerData(DataType.INTEGER, "SMALLINT", Short.MAX_VALUE)),
                Arguments.of(new IntegerData(DataType.INTEGER, "TINYINT", 255)),
                Arguments.of(new IntegerData(DataType.INTEGER)),
                Arguments.of(new IntegerData(DataType.INTEGER, "BIT", 0, 1)),
                Arguments.of(new IntegerData(DataType.INTEGER, null, 5, 242)),
                Arguments.of(new IntegerData(DataType.INTEGER, null, 123152, 1236340)),
                Arguments.of(new IntegerData(DataType.INTEGER, null, -100, 100)),
                Arguments.of(new IntegerData(DataType.INTEGER, null, 400, 400)),
                Arguments.of(new IntegerData(DataType.INTEGER, null, -50, -1))
                );
    }

      @ParameterizedTest
      @MethodSource("generateIntegerObjects")
      void testGenerateValueConstant(IntegerData data) {
          data.setGenerator(DataGenerator.CONSTANT);
          BigInteger result = data.generateValue();
          var expected = data.start;
          assertEquals(expected, result);
      }

      @ParameterizedTest
      @MethodSource("generateIntegerObjects")
      void testGenerateValueAny(IntegerData data) {
          data.setGenerator(DataGenerator.ANY);
          BigInteger result = data.generateValue();
          assertNull(result);
      }

   @ParameterizedTest
   @MethodSource("generateIntegerObjects")
    void testGenerateValueIncrement(IntegerData data) {
        data.setStart(BigInteger.ZERO);
        data.setGenerator(DataGenerator.INCREMENT);

        assertEquals(BigInteger.ZERO, data.currentInc);

        BigInteger result = data.generateValue();

        assertEquals(BigInteger.ZERO, result);
        assertEquals(BigInteger.ONE, data.currentInc);
    }

    @ParameterizedTest
    @MethodSource("generateIntegerObjects")
    void testGenerateValueRandom(IntegerData data) {
        data.setGenerator(DataGenerator.RANDOM);
        data.setNotNull(true);

        BigInteger result = data.generateValue();

        assertTrue(result.compareTo(data.start) >= 0);
        assertTrue(result.compareTo(data.end) <= 0);
    }
}
