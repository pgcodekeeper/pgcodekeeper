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
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgRule.PgRuleEventType;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgTrigger.TgTypes;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgType.PgTypeForm;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;

/**
 * An abstract 'factory' that creates 'artificial'
 * PgDatabase objects for specific test-cases.
 *
 * @author Alexander Levsha
 */
abstract class PgDatabaseObjectCreator {

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
public class PgAntlrLoaderTest {

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
                    {1},
                    {2},
                    {3},
                    {4},
                    {5},
                    {6},
                    {7},
                    {8},
                    {9},
                    {10},
                    {11},
                    {12},
                    {13},
                    {14},
                    {15},
                    {16},
                    {17}
                    // SONAR-ON
                });
    }
    /**
     * Index of the file that should be tested.
     */
    private final int fileIndex;

    /**
     * Array of implementations of {@link PgDatabaseObjectCreator}
     * each returning a specific {@link PgDatabase} for a test-case.
     */
    private static final PgDatabaseObjectCreator[] DB_OBJS = {
            new PgDB1(),
            new PgDB2(),
            new PgDB3(),
            new PgDB4(),
            new PgDB5(),
            new PgDB6(),
            new PgDB7(),
            new PgDB8(),
            new PgDB9(),
            new PgDB10(),
            new PgDB11(),
            new PgDB12(),
            new PgDB13(),
            new PgDB14(),
            new PgDB15(),
            new PgDB16(),
            new PgDB17()
    };

    /**
     * Creates a new instance of PgDumpLoaderTest.
     *
     * @param fileIndex {@link #fileIndex}
     */
    public PgAntlrLoaderTest(final int fileIndex) {
        this.fileIndex = fileIndex;
    }

    @Test
    public void loadSchema() throws InterruptedException, IOException, LicenseException {

        // first test the dump loader itself
        String filename = "schema_" + fileIndex + ".sql";
        PgDiffArguments args = ApgdiffTestUtils.getArgsLicensed();
        args.setInCharsetName(encoding);
        args.setForceUnixNewlines(false);
        PgDatabase d = ApgdiffTestUtils.loadTestDump(
                filename, PgAntlrLoaderTest.class, args);

        // then check result's validity against handmade DB object
        if(fileIndex > DB_OBJS.length) {
            Assert.fail("No predefined object for file: " + filename);
        }

        PgDatabase dbPredefined = DB_OBJS[fileIndex - 1].getDatabase();
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
    public void exportFullDb() throws IOException, InterruptedException, LicenseException {
        // prepare db object from sql file
        String filename = "schema_" + fileIndex + ".sql";
        PgDiffArguments args = ApgdiffTestUtils.getArgsLicensed();
        args.setInCharsetName(encoding);
        args.setForceUnixNewlines(false);
        PgDatabase dbFromFile = ApgdiffTestUtils.loadTestDump(
                filename, PgAntlrLoaderTest.class, args);

        PgDatabase dbPredefined = DB_OBJS[fileIndex - 1].getDatabase();
        Path exportDir = null;
        try{
            exportDir = Files.createTempDirectory("pgCodekeeper-test-files");
            new ModelExporter(exportDir.toFile(), dbPredefined, encoding).exportFull();

            args = ApgdiffTestUtils.getArgsLicensed();
            args.setInCharsetName(encoding);
            args.setForceUnixNewlines(false);
            args.setIgnoreSlonyTriggers(true);
            args.setOutputIgnoredStatements(true);
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

class PgDB1 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        PgTable table = new PgTable("fax_boxes", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("fax_box_id");
        col.setType("serial");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("name");
        col.setType("text");
        table.addColumn(col);

        PgConstraint constraint = new PgConstraint("fax_boxes_pkey", "");
        table.addConstraint(constraint);
        constraint.setDefinition("PRIMARY KEY (fax_box_id)");

        table.setOwner("postgres");

        table = new PgTable("faxes", "");
        schema.addTable(table);

        col = new PgColumn("fax_id");
        col.setType("serial");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("fax_box_id");
        col.setType("int4");
        table.addColumn(col);

        col = new PgColumn("from_name");
        col.setType("text");
        table.addColumn(col);

        col = new PgColumn("from_number");
        col.setType("text");
        table.addColumn(col);

        col = new PgColumn("status");
        col.setType("int4");
        table.addColumn(col);

        col = new PgColumn("pages");
        col.setType("int4");
        table.addColumn(col);

        col = new PgColumn("time_received");
        col.setType("timestamp");
        col.setDefaultValue("now()");
        table.addColumn(col);

        col = new PgColumn("time_finished_received");
        col.setType("timestamp");
        table.addColumn(col);

        col = new PgColumn("read");
        col.setType("int2");
        col.setDefaultValue("0");
        table.addColumn(col);

        col = new PgColumn("station_id");
        col.setType("text");
        table.addColumn(col);

        constraint = new PgConstraint("faxes_pkey", "");
        constraint.setDefinition("PRIMARY KEY (fax_id)");
        table.addConstraint(constraint);

        constraint = new PgConstraint("faxes_fax_box_id_fkey", "");
        constraint.setDefinition("FOREIGN KEY (fax_box_id)\n      REFERENCES fax_boxes (fax_box_id) MATCH SIMPLE\n      ON UPDATE RESTRICT ON DELETE CASCADE");
        table.addConstraint(constraint);

        table = new PgTable("extensions", "");
        schema.addTable(table);

        col = new PgColumn("id");
        col.setType("serial");
        col.setNullValue(false);
        table.addColumn(col);

        constraint = new PgConstraint("extensions_fax_box_id_fkey", "");
        constraint.setDefinition("FOREIGN KEY (fax_box_id) REFERENCES fax_boxes\n(fax_box_id)    ON UPDATE RESTRICT ON DELETE RESTRICT");
        table.addConstraint(constraint);

        return d;
    }
}

class PgDB2 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();

        PgSchema schema = new PgSchema("postgis", "");
        d.addSchema(schema);

        PgExtension ext = new PgExtension("postgis", "");
        ext.setSchema("postgis");
        d.addExtension(ext);
        ext.setComment("'PostGIS geometry, geography, and raster spatial types and functions'");

        schema = d.getSchema(ApgdiffConsts.PUBLIC);

        PgTable table = new PgTable("contacts", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("id");
        col.setType("int");
        table.addColumn(col);

        col = new PgColumn("number_pool_id");
        col.setType("int");
        table.addColumn(col);

        col = new PgColumn("name");
        col.setType("varchar(50)");
        table.addColumn(col);

        PgIndex idx = new PgIndex("contacts_number_pool_id_idx", "");
        table.addIndex(idx);
        idx.setTableName("contacts");
        idx.setDefinition("(number_pool_id)");

        return d;
    }
}

class PgDB3 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        PgSequence seq = new PgSequence("admins_aid_seq", "");
        seq.setStartWith("1");
        seq.setMinMaxInc(1L, 1000000000L, null);
        seq.setCache("1");
        schema.addSequence(seq);

        PgTable table = new PgTable("admins", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("aid");
        col.setType("integer");
        col.setDefaultValue("nextval('\"admins_aid_seq\"'::regclass)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("companyid");
        col.setType("integer");
        col.setDefaultValue("0");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("groupid");
        col.setType("integer");
        col.setDefaultValue("0");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("username");
        col.setType("character varying");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("password");
        col.setType("character varying(40)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("superuser");
        col.setType("boolean");
        col.setDefaultValue("'f'::bool");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("name");
        col.setType("character varying(40)");
        table.addColumn(col);

        col = new PgColumn("surname");
        col.setType("character varying(40)");
        table.addColumn(col);

        col = new PgColumn("email");
        col.setType("character varying(100)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("tel");
        col.setType("character varying(40)");
        table.addColumn(col);

        col = new PgColumn("mobile");
        col.setType("character varying(40)");
        table.addColumn(col);

        col = new PgColumn("enabled");
        col.setType("boolean");
        col.setDefaultValue("'t'::bool");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("lastlogints");
        col.setType("timestamp with time zone");
        col.setDefaultValue("now()");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("expirienced");
        col.setType("boolean");
        col.setDefaultValue("'f'::bool");
        table.addColumn(col);

        PgConstraint constraint = new PgConstraint("admins_pkey", "");
        constraint.setDefinition("Primary Key (\"aid\")");
        table.addConstraint(constraint);

        return d;
    }
}

class PgDB4 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        PgTable table = new PgTable("call_logs", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("id");
        col.setType("bigint");
        col.setNullValue(false);
        col.setDefaultValue("nextval('call_logs_id_seq'::regclass)");
        table.addColumn(col);

        return d;
    }
}

class PgDB5 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        PgFunction func = new PgFunction("gtsq_in", "");
        func.setBody("AS '$libdir/tsearch2', 'gtsq_in'\n    LANGUAGE c STRICT");
        func.setReturns("gtsq");
        schema.addFunction(func);

        PgFunction.Argument arg = new PgFunction.Argument();
        arg.setDataType("cstring");
        func.addArgument(arg);

        func = new PgFunction("multiply_numbers", "");
        func.setBody("AS $$\r\nbegin\r\n\treturn number1 * number2;\r\nend;\r\n$$\r\n    LANGUAGE plpgsql STRICT");
        func.setReturns("integer");
        schema.addFunction(func);

        arg = new PgFunction.Argument();
        arg.setName("number1");
        arg.setDataType("integer");
        func.addArgument(arg);

        arg = new PgFunction.Argument();
        arg.setName("number2");
        arg.setDataType("integer");
        func.addArgument(arg);

        func = new PgFunction("select_something", "");
        func.setBody("AS $_$SELECT number1 * number2$_$ LANGUAGE plpgsql");
        func.setReturns("integer");
        schema.addFunction(func);

        arg = new PgFunction.Argument();
        arg.setName("number1");
        arg.setDataType("integer");
        func.addArgument(arg);

        arg = new PgFunction.Argument();
        arg.setName("number2");
        arg.setDataType("integer");
        func.addArgument(arg);

        func = new PgFunction("select_something2", "");
        func.setBody("AS 'SELECT number1 * number2 || ''text''' LANGUAGE plpgsql");
        func.setReturns("integer");
        schema.addFunction(func);

        arg = new PgFunction.Argument();
        arg.setName("number1");
        arg.setDataType("integer");
        func.addArgument(arg);

        arg = new PgFunction.Argument();
        arg.setName("number2");
        arg.setDataType("integer");
        func.addArgument(arg);

        func = new PgFunction("select_something3", "");
        func.setBody("AS '\nSELECT number1 * number2 || ''text''\n' LANGUAGE plpgsql");
        func.setReturns("integer");
        schema.addFunction(func);

        arg = new PgFunction.Argument();
        arg.setName("number1");
        arg.setDataType("integer");
        func.addArgument(arg);

        arg = new PgFunction.Argument();
        arg.setName("number2");
        arg.setDataType("integer");
        func.addArgument(arg);

        return d;
    }
}

class PgDB6 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();
        //    schema.setComment("'Standard public schema'");

        schema.addPrivilege(new PgPrivilege(true, "ALL ON SCHEMA public FROM PUBLIC", ""));
        schema.addPrivilege(new PgPrivilege(true, "ALL ON SCHEMA public FROM postgres", ""));
        schema.addPrivilege(new PgPrivilege(false, "ALL ON SCHEMA public TO postgres", ""));
        schema.addPrivilege(new PgPrivilege(false, "ALL ON SCHEMA public TO PUBLIC", ""));

        PgTable table = new PgTable("test_table", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("id");
        col.setType("bigint");
        table.addColumn(col);

        col = new PgColumn("date_deleted");
        col.setType("timestamp without time zone");
        table.addColumn(col);

        table.setOwner("postgres");

        PgIndex idx = new PgIndex("test_table_deleted", "");
        idx.setTableName("test_table");
        idx.setDefinition("USING btree (date_deleted) WHERE (date_deleted IS NULL)");
        table.addIndex(idx);

        return d;
    }
}

class PgDB7 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();

        PgSchema schema = new PgSchema("common", "");
        d.addSchema(schema);
        d.setDefaultSchema("common");

        PgFunction func = new PgFunction("t_common_casttotext", "");
        func.setBody("AS $_$SELECT textin(timetz_out($1));$_$\n    LANGUAGE sql IMMUTABLE STRICT");
        func.setReturns("text");
        schema.addFunction(func);

        PgFunction.Argument arg = new PgFunction.Argument();
        arg.setDataType("time with time zone");
        func.addArgument(arg);

        func = new PgFunction("t_common_casttotext", "");
        func.setBody("AS $_$SELECT textin(time_out($1));$_$\n    LANGUAGE sql IMMUTABLE STRICT");
        func.setReturns("text");
        schema.addFunction(func);

        arg = new PgFunction.Argument();
        arg.setDataType("time without time zone");
        func.addArgument(arg);

        func = new PgFunction("t_common_casttotext", "");
        func.setBody("AS $_$SELECT textin(timestamptz_out($1));$_$\n    LANGUAGE sql IMMUTABLE STRICT");
        func.setReturns("text");
        schema.addFunction(func);

        arg = new PgFunction.Argument();
        arg.setDataType("timestamp with time zone");
        func.addArgument(arg);

        func = new PgFunction("t_common_casttotext", "");
        func.setBody("AS $_$SELECT textin(timestamp_out($1));$_$\n    LANGUAGE sql IMMUTABLE STRICT");
        func.setReturns("text");
        schema.addFunction(func);

        arg = new PgFunction.Argument();
        arg.setDataType("timestamp without time zone");
        func.addArgument(arg);

        return d;
    }
}

class PgDB8 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();
        //    schema.setComment("'Standard public schema'");

        PgType type = new PgType("testtt", PgTypeForm.COMPOSITE, "");
        PgColumn col = new PgColumn("a");
        col.setType("integer");
        type.addAttr(col);
        col = new PgColumn("b");
        col.setType("text");
        type.addAttr(col);
        type.setOwner("madej");
        schema.addType(type);

        schema = new PgSchema("``54'253-=9!@#$%^&*()__<>?:\"{}[];',./", "");
        d.addSchema(schema);

        PgFunction func = new PgFunction(".x\".\"\".", "");
        func.setBody("AS $_$\ndeclare\nbegin\nraise notice 'inside: %', $1;\nreturn true;\nend;\n$_$\n    LANGUAGE plpgsql");
        func.setReturns("boolean");
        schema.addFunction(func);

        PgFunction.Argument arg = new PgFunction.Argument();
        arg.setDataType("integer");
        func.addArgument(arg);

        func.setOwner("madej");

        return d;
    }
}

class PgDB9 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        PgTable table = new PgTable("user_data", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("id");
        col.setType("bigint");
        col.setNullValue(false);
        col.setDefaultValue("nextval('user_id_seq'::regclass)");
        table.addColumn(col);

        col = new PgColumn("email");
        col.setType("character varying(128)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("created");
        col.setType("timestamp with time zone");
        col.setDefaultValue("now()");
        table.addColumn(col);
        table.setOwner("postgres");

        PgRule rule = new PgRule("on_select", "");
        rule.setEvent(PgRuleEventType.SELECT);
        rule.setCondition("(1=1)");
        rule.setInstead(true);
        table.addRule(rule);

        PgSequence seq = new PgSequence("user_id_seq", "");
        seq.setMinMaxInc(1L, null, null);
        seq.setCache("1");
        seq.setOwnedBy("user_data.id");
        schema.addSequence(seq);
        seq.setOwner("postgres");

        table = new PgTable("t_ruleinsert", "");
        schema.addTable(table);

        col = new PgColumn("c1");
        col.setType("int");
        table.addColumn(col);

        PgView view = new PgView("user", "");
        view.setQuery("( SELECT user_data.id, user_data.email, user_data.created FROM user_data)");
        view.addColumnDefaultValue("created", "now()");
        schema.addView(view);

        view.setOwner("postgres");

        rule = new PgRule("on_delete", "");
        rule.setEvent(PgRuleEventType.DELETE);
        rule.addCommand("DELETE FROM user_data WHERE (user_data.id = old.id)");
        view.addRule(rule);

        rule = new PgRule("on_insert", "");
        rule.setEvent(PgRuleEventType.INSERT);
        rule.setInstead(true);
        rule.addCommand("INSERT INTO user_data (id, email, created) VALUES (new.id, new.email, new.created)");
        rule.addCommand("INSERT INTO t1(c1) DEFAULT VALUES");
        view.addRule(rule);

        rule = new PgRule("on_update", "");
        rule.setEvent(PgRuleEventType.UPDATE);
        rule.setInstead(true);
        rule.addCommand("UPDATE user_data SET id = new.id, email = new.email, created = new.created WHERE (user_data.id = old.id)");
        view.addRule(rule);

        view = new PgView("ws_test", "");
        view.setQuery("SELECT ud.id \"   i   d   \" FROM user_data ud");
        schema.addView(view);

        return d;
    }
}

class PgDB10 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = new PgSchema("admin", "");
        d.addSchema(schema);
        d.setDefaultSchema("admin");

        schema.setOwner("postgres");

        PgTable table = new PgTable("acl_role", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("id");
        col.setType("bigint");
        col.setNullValue(false);
        table.addColumn(col);

        PgConstraint constraint = new PgConstraint("acl_role_pkey", "");
        constraint.setDefinition("PRIMARY KEY (id)");
        table.addConstraint(constraint);

        table.setOwner("postgres");

        table = new PgTable("user", "");
        schema.addTable(table);

        col = new PgColumn("id");
        col.setType("bigint");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("email");
        col.setType("character varying(255)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("name");
        col.setType("character varying(255)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("password");
        col.setType("character varying(40)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("is_active");
        col.setType("boolean");
        col.setDefaultValue("false");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("updated");
        col.setType("timestamp without time zone");
        col.setDefaultValue("now()");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("created");
        col.setType("timestamp without time zone");
        col.setDefaultValue("now()");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("role_id");
        col.setType("bigint");
        col.setNullValue(false);
        table.addColumn(col);

        col = new PgColumn("last_visit");
        col.setType("timestamp without time zone");
        col.setDefaultValue("now()");
        col.setNullValue(false);
        table.addColumn(col);

        PgIndex idx = new PgIndex("fki_user_role_id_fkey", "");
        idx.setTableName("user");
        idx.setDefinition("USING btree (role_id)");
        table.addIndex(idx);

        constraint = new PgConstraint("user_role_id_fkey", "");
        constraint.setDefinition("FOREIGN KEY (role_id) REFERENCES acl_role(id)");
        table.addConstraint(constraint);

        table.setOwner("postgres");

        return d;
    }
}

class PgDB11 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        PgFunction func = new PgFunction("curdate", "");
        func.setBody("LANGUAGE sql\n    AS $$SELECT CAST('now' AS date);\n$$");
        func.setReturns("date");
        schema.addFunction(func);

        return d;
    }
}

class PgDB12 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();

        d.setComment("'The status : ''E'' for enabled, ''D'' for disabled.'");

        return d;
    }
}

class PgDB13 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        PgFunction func = new PgFunction("drop_fk_except_for", "");
        func.setBody("LANGUAGE plpgsql\n    AS $$\nDECLARE\nBEGIN\n  -- aaa\nEND;\n$$");
        func.setReturns("SETOF character varying");
        schema.addFunction(func);

        PgFunction.Argument arg = new PgFunction.Argument();
        arg.setDataType("character varying[]");
        arg.setName("tables_in");
        func.addArgument(arg);

        return d;
    }
}

class PgDB14 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        schema.addPrivilege(new PgPrivilege(true, "ALL ON SCHEMA public FROM PUBLIC", ""));
        schema.addPrivilege(new PgPrivilege(true, "ALL ON SCHEMA public FROM postgres", ""));
        schema.addPrivilege(new PgPrivilege(false, "ALL ON SCHEMA public TO postgres", ""));
        schema.addPrivilege(new PgPrivilege(false, "ALL ON SCHEMA public TO PUBLIC", ""));

        d.setComment("'comments database'");
        //    schema.setComment("'public schema'");

        PgFunction func = new PgFunction("test_fnc", "");
        func.setBody("LANGUAGE plpgsql\n    AS $$BEGIN\nRETURN true;\nEND;$$");
        func.setReturns("boolean");
        schema.addFunction(func);

        PgFunction.Argument arg = new PgFunction.Argument();
        arg.setDataType("character varying");
        arg.setName("arg");
        func.addArgument(arg);

        func.setOwner("fordfrog");

        func.setComment("'test function'");

        func = new PgFunction("trigger_fnc", "");
        func.setBody("LANGUAGE plpgsql\n    AS $$begin\nend;$$");
        func.setReturns("trigger");
        schema.addFunction(func);

        func.setOwner("fordfrog");

        PgTable table = new PgTable("test", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("id");
        col.setType("integer");
        col.setNullValue(false);
        col.setComment("'id column'");
        col.setDefaultValue("nextval('test_id_seq'::regclass)");
        table.addColumn(col);

        col = new PgColumn("text");
        col.setType("character varying(20)");
        col.setNullValue(false);
        col.setComment("'text column'");
        table.addColumn(col);

        PgConstraint constraint = new PgConstraint("text_check", "");
        constraint.setDefinition("CHECK ((length((text)::text) > 0))");
        constraint.setComment("'text check'");
        table.addConstraint(constraint);

        table.setComment("'test table'");

        constraint = new PgConstraint("test_pkey", "");
        constraint.setDefinition("PRIMARY KEY (id)");
        table.addConstraint(constraint);

        constraint.setComment("'primary key'");

        table.setOwner("fordfrog");

        PgSequence seq = new PgSequence("test_id_seq", "");
        seq.setStartWith("1");
        seq.setMinMaxInc(1L, null, null);
        seq.setCache("1");
        schema.addSequence(seq);

        seq.setOwnedBy("test.id");

        seq.setOwner("fordfrog");

        seq.setComment("'test table sequence'");

        PgView view = new PgView("test_view", "");
        view.setQuery("SELECT test.id, test.text FROM test");
        schema.addView(view);

        view.setComment("'test view'");
        view.addColumnComment("id", "'view id col'");

        view.setOwner("fordfrog");

        PgTrigger trigger = new PgTrigger("test_trigger", "");
        trigger.setType(TgTypes.BEFORE);
        trigger.setOnUpdate(true);
        trigger.setTableName("test");
        trigger.setForEachRow(false);
        trigger.setFunction("trigger_fnc()");
        table.addTrigger(trigger);

        trigger.setComment("'test trigger'");

        return d;
    }
}

class PgDB15 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        PgTable table = new PgTable("test", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("id");
        col.setType("bigint");
        table.addColumn(col);

        table.setComment("'multiline\ncomment\n'");

        return d;
    }
}

/**
 * Tests subselect parser
 *
 * @author ryabinin_av
 *
 */
class PgDB16 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        // table1
        PgTable table = new PgTable("t_work", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("id");
        col.setType("integer");
        table.addColumn(col);

        // table2
        PgTable table2 = new PgTable("t_chart", "");
        schema.addTable(table2);
        col = new PgColumn("id");
        col.setType("integer");
        table2.addColumn(col);

        // view
        PgView view = new PgView("v_subselect", "");
        view.setQuery("SELECT c.id, t.id FROM ( SELECT t_work.id FROM t_work) t"
                + " JOIN t_chart c ON t.id = c.id");
        schema.addView(view);

        return d;
    }
}

/**
 * Tests subselect parser with double subselect
 *
 * @author ryabinin_av
 *
 */
class PgDB17 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
        PgDatabase d = new PgDatabase();
        PgSchema schema = d.getDefaultSchema();

        // table1
        PgTable table = new PgTable("t_work", "");
        schema.addTable(table);

        PgColumn col = new PgColumn("id");
        col.setType("integer");
        table.addColumn(col);

        // table2
        PgTable table2 = new PgTable("t_chart", "");
        schema.addTable(table2);
        col = new PgColumn("id");
        col.setType("integer");
        table2.addColumn(col);

        // table 3
        PgTable table3 = new PgTable("t_memo", "");
        schema.addTable(table3);
        col = new PgColumn("name");
        col.setType("text");
        table3.addColumn(col);

        // view
        PgView view = new PgView("v_subselect", "");
        view.setQuery("SELECT c.id, t.id, t.name FROM  ( SELECT w.id, m.name FROM "
                + "(SELECT t_work.id FROM t_work) w JOIN t_memo m ON w.id::text = m.name)  t JOIN t_chart c ON t.id = c.id");
        schema.addView(view);

        return d;
    }
}

// SONAR-ON
