package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;
import org.junit.Assert;
import org.junit.Test;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempDir;
import ru.taximaxim.codekeeper.apgdiff.ignoreparser.IgnoreParser;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.MsModelExporter;

public class MsProjectLoaderTest {

    @Test
    public void testProjectLoaderWithIgnoredSchemas() throws CoreException, IOException,
    InterruptedException, URISyntaxException {
        try(TempDir tempDir = new TempDir("ignore-schemas test project")){
            Path dir = tempDir.get();
            PgDiffArguments args = new PgDiffArguments();
            args.setMsSql(true);

            PgDatabase msDbDump = ApgdiffTestUtils.loadTestDump(
                    ApgdiffTestUtils.RESOURCE_MS_DUMP, ApgdiffTestUtils.class, args);

            new MsModelExporter(dir, msDbDump, ApgdiffConsts.UTF_8).exportFull();

            ApgdiffTestUtils.createIgnoredSchemaFile(dir);
            Path listFile = dir.resolve(".pgcodekeeperignoreschema");

            // load ignored schema list
            IgnoreSchemaList ignoreSchemaList = new IgnoreSchemaList();
            IgnoreParser ignoreParser = new IgnoreParser(ignoreSchemaList);
            ignoreParser.parse(listFile);

            PgDatabase loader = new ProjectLoader(dir.toString(),  args, SubMonitor.convert(null), null, ignoreSchemaList).load();

            for (AbstractSchema dbSchema : loader.getSchemas()) {
                if (ApgdiffTestUtils.IGNORED_SCHEMAS_LIST.contains(dbSchema.getName())) {
                    Assert.fail("Ignored Schema loaded " + dbSchema.getName());
                } else {
                    Assert.assertEquals("Schema from ms dump isn't equal schema from loader",
                            msDbDump.getSchema(dbSchema.getName()), dbSchema);
                }
            }
        }
    }
}
