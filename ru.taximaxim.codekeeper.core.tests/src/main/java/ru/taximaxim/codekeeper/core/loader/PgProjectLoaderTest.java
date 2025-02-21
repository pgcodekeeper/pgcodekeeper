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
package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.core.runtime.SubMonitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.fileutils.TempDir;
import ru.taximaxim.codekeeper.core.ignoreparser.IgnoreParser;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;

class PgProjectLoaderTest {

    @Test
    void testProjectLoaderWithIgnoredSchemas() throws IOException, InterruptedException {
        try(TempDir tempDir = new TempDir("ignore-schemas-test-project")){
            Path dir = tempDir.get();
            PgDiffArguments args = new PgDiffArguments();

            AbstractDatabase dbDump = TestUtils.loadTestDump(
                    TestUtils.RESOURCE_DUMP, TestUtils.class, args);

            new ModelExporter(dir, dbDump, DatabaseType.PG, Consts.UTF_8).exportFull();

            TestUtils.createIgnoredSchemaFile(dir);
            Path listFile = dir.resolve(".pgcodekeeperignoreschema");

            // load ignored schema list
            IgnoreSchemaList ignoreSchemaList = new IgnoreSchemaList();
            IgnoreParser ignoreParser = new IgnoreParser(ignoreSchemaList);
            ignoreParser.parse(listFile);

            AbstractDatabase loader = new ProjectLoader(dir.toString(), args, SubMonitor.convert(null), null,
                    ignoreSchemaList).load();

            for (AbstractSchema dbSchema : loader.getSchemas()) {
                if (TestUtils.IGNORED_SCHEMAS_LIST.contains(dbSchema.getName())) {
                    Assertions.fail("Ignored Schema loaded " + dbSchema.getName());
                } else {
                    Assertions.assertEquals(
                            dbDump.getSchema(dbSchema.getName()), dbSchema, "Schema from dump isn't equal schema from loader");
                }
            }
        }
    }
}
