package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.core.runtime.SubMonitor;
import org.junit.Assert;
import org.junit.Test;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.fileutils.TempDir;
import ru.taximaxim.codekeeper.core.ignoreparser.IgnoreParser;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class PgProjectLoaderTest {

    @Test
    public void testProjectLoaderWithIgnoredSchemas() throws IOException, InterruptedException {
        try(TempDir tempDir = new TempDir("ignore-schemas-test-project")){
            Path dir = tempDir.get();
            PgDiffArguments args = new PgDiffArguments();

            PgDatabase dbDump = TestUtils.loadTestDump(
                    TestUtils.RESOURCE_DUMP, TestUtils.class, args);

            new ModelExporter(dir, dbDump, Consts.UTF_8).exportFull();

            TestUtils.createIgnoredSchemaFile(dir);
            Path listFile = dir.resolve(".pgcodekeeperignoreschema");

            // load ignored schema list
            IgnoreSchemaList ignoreSchemaList = new IgnoreSchemaList();
            IgnoreParser ignoreParser = new IgnoreParser(ignoreSchemaList);
            ignoreParser.parse(listFile);

            PgDatabase loader = new ProjectLoader(dir.toString(),  args, SubMonitor.convert(null), null, ignoreSchemaList).load();

            for (AbstractSchema dbSchema : loader.getSchemas()) {
                if (TestUtils.IGNORED_SCHEMAS_LIST.contains(dbSchema.getName())) {
                    Assert.fail("Ignored Schema loaded " + dbSchema.getName());
                } else {
                    Assert.assertEquals("Schema from dump isn't equal schema from loader",
                            dbDump.getSchema(dbSchema.getName()), dbSchema);
                }
            }
        }
    }
}
