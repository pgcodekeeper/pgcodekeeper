/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.SimpleMsTable;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;

/**
 * An abstract 'factory' that creates 'artificial'
 * PgDatabase MSSQL-objects for specific test-cases.
 *
 * @author Alexander Levsha
 */
abstract class MsDatabaseObjectCreator {

    /**
     * The method makes up a PgDatabase object specific to the test needs.
     */
    public abstract PgDatabase getDatabase();
}

/**
 * Tests for PgDiffLoader class.
 *
 * @author fordfrog
 */
@RunWith(value = Parameterized.class)
public class MsAntlrLoaderTest {

    private final String encoding = ApgdiffConsts.UTF_8;
    /**
     * Provides parameters for running the tests.
     *
     * @return parameters for the tests
     */
    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][]{
                    // SONAR-OFF
                    {0}
                    // ,
                    // {1}
                    // SONAR-ON
                });
    }
    /**
     * Index of the file that should be tested.
     */
    private final int fileIndex;

    /**
     * Array of implementations of {@link MsDatabaseObjectCreator}
     * each returning a specific {@link PgDatabase} for a test-case.
     */
    private static final MsDatabaseObjectCreator[] DB_OBJS = {
            new MsDB0()
            // ,
            // new MsDB1()
    };

    /**
     * Creates a new instance of PgDumpLoaderTest.
     *
     * @param fileIndex {@link #fileIndex}
     */
    public MsAntlrLoaderTest(final int fileIndex) {
        this.fileIndex = fileIndex;
    }

    @Test
    public void loadSchema() throws InterruptedException, IOException {

        // first test the dump loader itself
        String filename = "ms_schema_" + fileIndex + ".sql";
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(encoding);
        args.setKeepNewlines(true);
        args.setMsSql(true);
        PgDatabase d = ApgdiffTestUtils.loadTestDump(
                filename, MsAntlrLoaderTest.class, args);

        // then check result's validity against handmade DB object
        if(fileIndex > DB_OBJS.length) {
            Assert.fail("No predefined object for file: " + filename);
        }

        PgDatabase dbPredefined = DB_OBJS[fileIndex].getDatabase();

        Assert.assertEquals("PgDumpLoader: predefined object is not equal to file "
                + filename, dbPredefined, d);

        // test deepCopy mechanism
        Assert.assertEquals("PgStatement deep copy altered", d, d.deepCopy());
        Assert.assertEquals("PgStatement deep copy altered original", dbPredefined, d);
    }

    /**
     * Tests ModelExporter exportFull() method
     * @throws InterruptedException
     */
    @Test
    public void exportFullDb() throws IOException, InterruptedException {
        // prepare db object from sql file
        String filename = "ms_schema_" + fileIndex + ".sql";
        PgDiffArguments args = new PgDiffArguments();
        args.setInCharsetName(encoding);
        args.setKeepNewlines(true);
        args.setMsSql(true);
        PgDatabase dbFromFile = ApgdiffTestUtils.loadTestDump(
                filename, MsAntlrLoaderTest.class, args);

        PgDatabase dbPredefined = DB_OBJS[fileIndex].getDatabase();
        Path exportDir = null;
        try{
            exportDir = Files.createTempDirectory("pgCodekeeper-test-files");
            new ModelExporter(exportDir.toFile(), dbPredefined, encoding).exportFull();

            args = new PgDiffArguments();
            args.setInCharsetName(encoding);
            args.setKeepNewlines(true);
            args.setMsSql(true);
            PgDatabase dbAfterExport = PgDumpLoader.loadDatabaseSchemaFromDirTree(
                    exportDir.toString(), args, null, null);

            // check the same db similarity before and after export
            Assert.assertEquals("ModelExporter: predefined object PgDB" + fileIndex +
                    " is not equal to exported'n'loaded.", dbPredefined, dbAfterExport);

            Assert.assertEquals("ModelExporter: exported predefined object is not "
                    + "equal to file " + filename, dbAfterExport, dbFromFile);
        }finally{
            if (exportDir != null){
                deleteRecursive(exportDir.toFile());
            }
        }
    }

    /**
     * Deletes folder and its contents recursively. FOLLOWS SYMLINKS!
     */
    private static void deleteRecursive(File f) throws IOException {
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                deleteRecursive(sub);
            }
        }
        Files.delete(f.toPath());
    }
}

// SONAR-OFF

class MsDB0 extends MsDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = ApgdiffTestUtils.createDumpMsDB();
        AbstractSchema schema = d.getDefaultSchema();

        SimpleMsTable table = new SimpleMsTable("fax_boxes", "");
        table.setAnsiNulls(true);
        schema.addTable(table);

        AbstractColumn col = new MsColumn("fax_box_id");
        col.setType("[int]");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("name");
        col.setType("[text]");
        table.addColumn(col);

        AbstractConstraint constraint = new MsConstraint("PK_fax_boxes", "");
        table.addConstraint(constraint);
        constraint.setDefinition("PRIMARY KEY CLUSTERED  ([fax_box_id]) ON [PRIMARY]");

        table.setOwner("ms_user");

        table = new SimpleMsTable("faxes", "");
        table.setAnsiNulls(true);
        schema.addTable(table);

        col = new MsColumn("fax_id");
        col.setType("[int]");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("fax_box_id");
        col.setType("[int]");
        table.addColumn(col);

        col = new MsColumn("from_name");
        col.setType("[text]");
        table.addColumn(col);

        col = new MsColumn("from_number");
        col.setType("[text]");
        table.addColumn(col);

        col = new MsColumn("status");
        col.setType("[int]");
        table.addColumn(col);

        col = new MsColumn("pages");
        col.setType("[int]");
        table.addColumn(col);

        col = new MsColumn("time_received");
        col.setType("[datetime]");
        // TODO uncomment this when default value setting will be fixed
        // TODO fix default value setting; at this moment trying to set default value gives us:
        //    ALTER TABLE [dbo].[faxes] ALTER COLUMN [time_received] DROP CONSTRAINT null
        //    ALTER TABLE [dbo].[fax_boxes] ADD CONSTRAINT [DF_fax_boxes] DEFAULT (getdate()) FOR [time_received]
        // col.setDefaultValue("getdate()");
        table.addColumn(col);
        // TODO uncomment this firstly
        // TODO replace constraint by 'setDefaultValue' when it will be fixed
        // constraint = new MsConstraint("DF_fax_boxes", "");
        // constraint.setDefinition("DEFAULT (getdate()) FOR [time_received]");
        // table.addConstraint(constraint);

        col = new MsColumn("time_finished_received");
        col.setType("[datetime]");
        table.addColumn(col);

        col = new MsColumn("read");
        col.setType("[int]");
        // TODO uncomment this when default value setting will be fixed
        // TODO for now replace 'default value setting' by constraint adding
        // col.setDefaultValue("0");
        table.addColumn(col);

        col = new MsColumn("station_id");
        col.setType("[text]");
        table.addColumn(col);

        constraint = new PgConstraint("PK_faxes", "");
        constraint.setDefinition("PRIMARY KEY CLUSTERED  ([fax_id]) ON [PRIMARY]");
        table.addConstraint(constraint);

        constraint = new PgConstraint("FK_faxes_fax_box_id", "");
        constraint.setDefinition("FOREIGN KEY (fax_box_id) \n" +
                "    REFERENCES [dbo].[fax_boxes](fax_box_id) ON DELETE SET NULL ON UPDATE CASCADE");
        table.addConstraint(constraint);

        table = new SimpleMsTable("extensions", "");
        table.setAnsiNulls(true);
        schema.addTable(table);

        col = new MsColumn("id");
        col.setType("[int]");
        col.setNullValue(false);
        table.addColumn(col);

        constraint = new PgConstraint("FK_extensions_fax_box_id", "");
        constraint.setDefinition("FOREIGN KEY (fax_box_id) \n" +
                "    REFERENCES [dbo].[fax_boxes](fax_box_id) ON DELETE SET NULL ON UPDATE CASCADE");
        table.addConstraint(constraint);

        return d;
    }
}

// SONAR-ON
