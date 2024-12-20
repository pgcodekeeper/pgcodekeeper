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
package ru.taximaxim.codekeeper.ui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;
import org.junit.jupiter.api.Assertions;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;

public final class UiTestUtils {

    private static final String DIFF_SQL = "_diff.sql";

    public static final String RESOURCE_DUMP = "testing_dump.sql";
    public static final String RESOURCE_MS_DUMP = "testing_ms_dump.sql";
    public static final List<String> IGNORED_SCHEMAS_LIST = List.of("worker", "country", "ignore1", "ignore4vrw");

    public static AbstractDatabase loadTestDump(String resource, Class<?> c, PgDiffArguments args)
            throws IOException, InterruptedException {
        PgDumpLoader loader = new PgDumpLoader(() -> c.getResourceAsStream(resource),
                "test/" + c.getName() + '/' + resource, args);
        AbstractDatabase db = loader.loadAndAnalyze();
        Assertions.assertEquals("[]", loader.getErrors().toString(), "Test resource caused loader errors!");
        return db;
    }

    public static void compareResult(String script, String template,
            Class<?> clazz) throws IOException {
        Assertions.assertEquals(readResource(template + DIFF_SQL, clazz).trim(), script.trim());
    }

    public static String readResource(String resourceName, Class<?> clazz) throws IOException {
        try (InputStream is = clazz.getResourceAsStream(resourceName)) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public static void createIgnoredSchemaFile(Path dir) throws IOException {
        String rule = """
            SHOW ALL\s
            HIDE NONE country\s
            HIDE NONE worker\s\s
            HIDE REGEX 'ignore.*' """;
        Files.write(dir.resolve(".pgcodekeeperignoreschema"), rule.getBytes(StandardCharsets.UTF_8));
    }

    public static Path getPathToResource(String resourceName, Class<?> clazz) throws URISyntaxException, IOException {
        URL url = clazz.getResource(resourceName);
        return Paths.get(URIUtil.toURI("file".equals(url.getProtocol()) ? url : FileLocator.toFileURL(url)));
    }

    private UiTestUtils() {
    }
}
