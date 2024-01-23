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
package ru.taximaxim.codekeeper.cli;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParseTest {

    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(new ParseTestArgumentsProvider()));
    }

    @ParameterizedTest
    @MethodSource("generator")
    void mainTest(ArgumentsProvider args) throws IOException, URISyntaxException {
        try (args) {
            Main.main(args.args());
            String name = args.getClass().getSimpleName();
            Assertions.assertTrue(Files.isRegularFile(args.getParseResultDir().get().resolve(".pgcodekeeper")),
                    name + " - .pgcodekeeper doesn't exist");
            Assertions.assertTrue(Files.isDirectory(args.getParseResultDir().get().resolve("SCHEMA")),
                    name + " - SCHEMA doesn't exist");
        }
    }
}


/**
 * {@link ArgumentsProvider} implementation testing parsing option
 */
class ParseTestArgumentsProvider extends ArgumentsProvider {

    public ParseTestArgumentsProvider() {
        super("parse_test.sql");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        Path db = TestUtils.getPathToResource(ParseTest.class, resName);
        return new String[] { "--parse", "-o", getParseResultDir().get().toAbsolutePath().toString(),
                db.toAbsolutePath().toString() };
    }
}
