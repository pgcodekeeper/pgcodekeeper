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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.FuncTypes;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintCheck;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintFk;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintPk;
import ru.taximaxim.codekeeper.core.schema.ms.MsFunction;
import ru.taximaxim.codekeeper.core.schema.ms.MsIndex;
import ru.taximaxim.codekeeper.core.schema.ms.MsProcedure;
import ru.taximaxim.codekeeper.core.schema.ms.MsSchema;
import ru.taximaxim.codekeeper.core.schema.ms.MsSequence;
import ru.taximaxim.codekeeper.core.schema.ms.MsTable;
import ru.taximaxim.codekeeper.core.schema.ms.MsTrigger;
import ru.taximaxim.codekeeper.core.schema.ms.MsType;
import ru.taximaxim.codekeeper.core.schema.ms.MsView;
import ru.taximaxim.codekeeper.core.settings.TestCoreSettings;
import ru.taximaxim.codekeeper.core.utils.TempDir;

/**
 * Tests for PgDiffLoader class.
 *
 * @author fordfrog
 */
class MsAntlrLoaderTest {

    private static final String QUOTED_MS_USER = "[ms_user]";
    private static final String SCHEMA_DBO = "SCHEMA::[dbo]";
    private static final String REVOKE = "REVOKE";
    private static final String GRANT = "GRANT";

    private static final String BIGINT = "[bigint]";
    private static final String NVARCHAR_40 = "[nvarchar](40)";
    private static final String BIT = "[bit]";
    private static final String DATETIME = "[datetime]";
    private static final String TEXT = "[text]";
    private static final String INT = "[int]";
    private static final String MS_USER = "ms_user";
    private static final String PRIMARY = "PRIMARY";
    private static final String ENCODING = Consts.UTF_8;

    void testDatabase(String fileName, AbstractDatabase d) throws IOException, InterruptedException {
        loadSchema(fileName, d);
        exportFullDb(fileName, d);
    }

    void loadSchema(String fileName, AbstractDatabase dbPredefined) throws IOException, InterruptedException {
        // first test the dump loader itself
        var settings = new TestCoreSettings();
        settings.setInCharsetName(ENCODING);
        settings.setKeepNewlines(true);
        settings.setDbType(DatabaseType.MS);
        AbstractDatabase d = TestUtils.loadTestDump(fileName, MsAntlrLoaderTest.class, settings);

        Assertions.assertEquals(dbPredefined, d, "PgDumpLoader: predefined object is not equal to file " + fileName);

        // test deepCopy mechanism
        Assertions.assertEquals(d, d.deepCopy(), "PgStatement deep copy altered");
        Assertions.assertEquals(dbPredefined, d, "PgStatement deep copy altered original");
    }

    void exportFullDb(String fileName, AbstractDatabase dbPredefined) throws IOException, InterruptedException {
        // prepare db object from sql file
        var settings = new TestCoreSettings();
        settings.setInCharsetName(ENCODING);
        settings.setKeepNewlines(true);
        settings.setDbType(DatabaseType.MS);
        AbstractDatabase dbFromFile = TestUtils.loadTestDump(fileName, MsAntlrLoaderTest.class, settings);

        Path exportDir = null;
        try (TempDir dir = new TempDir("pgCodekeeper-test-files")) {
            exportDir = dir.get();
            new ModelExporter(exportDir, dbPredefined, DatabaseType.MS, ENCODING, settings).exportFull();

            AbstractDatabase dbAfterExport = new ProjectLoader(exportDir.toString(), settings).loadAndAnalyze();

            // check the same db similarity before and after export
            Assertions.assertEquals(dbPredefined, dbAfterExport, "Predefined object PgDB" + fileName +
                    " is not equal to exported'n'loaded.");

            Assertions.assertEquals(dbAfterExport, dbFromFile,
                    "Exported predefined object is not equal to file " + fileName);
        }
    }

    @Test
    void testDB0() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsTable table = new MsTable("fax_boxes");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("fax_box_id");
        col.setType(INT);
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("name");
        col.setType(TEXT);
        table.addColumn(col);

        MsConstraintPk constriaintPk = new MsConstraintPk("PK_fax_boxes", true);
        constriaintPk.setClustered(true);
        constriaintPk.setDataSpace(PRIMARY);
        constriaintPk.addColumn(new SimpleColumn("fax_box_id"));
        table.addConstraint(constriaintPk);

        table.setOwner(MS_USER);

        table = new MsTable("faxes");
        table.setAnsiNulls(true);
        schema.addTable(table);

        col = new MsColumn("fax_id");
        col.setType(INT);
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("fax_box_id");
        col.setType(INT);
        table.addColumn(col);

        col = new MsColumn("from_name");
        col.setType(TEXT);
        table.addColumn(col);

        col = new MsColumn("from_number");
        col.setType(TEXT);
        table.addColumn(col);

        col = new MsColumn("status");
        col.setType(INT);
        table.addColumn(col);

        col = new MsColumn("pages");
        col.setType(INT);
        table.addColumn(col);

        col = new MsColumn("time_received");
        col.setType(DATETIME);
        col.setDefaultName("DF_faxes_time_received");
        col.setDefaultValue("(getdate())");
        table.addColumn(col);

        col = new MsColumn("time_finished_received");
        col.setType(DATETIME);
        table.addColumn(col);

        col = new MsColumn("read");
        col.setType(INT);
        col.setDefaultName("DF_faxes_read");
        col.setDefaultValue("0");
        table.addColumn(col);

        col = new MsColumn("station_id");
        col.setType(TEXT);
        table.addColumn(col);

        constriaintPk = new MsConstraintPk("PK_faxes", true);
        constriaintPk.setClustered(true);
        constriaintPk.setDataSpace(PRIMARY);
        constriaintPk.addColumn(new SimpleColumn("fax_id"));
        table.addConstraint(constriaintPk);

        var constraintFk = new MsConstraintFk("FK_faxes_fax_box_id");
        constraintFk.setForeignSchema("dbo");
        constraintFk.setForeignTable("fax_boxes");
        constraintFk.addColumn("fax_box_id");
        constraintFk.addForeignColumn("fax_box_id");
        constraintFk.setDelAction("SET NULL");
        constraintFk.setUpdAction("CASCADE");
        table.addConstraint(constraintFk);

        table = new MsTable("extensions");
        table.setAnsiNulls(true);
        schema.addTable(table);

        col = new MsColumn("id");
        col.setType(INT);
        col.setNullValue(false);
        table.addColumn(col);

        constraintFk = new MsConstraintFk("FK_extensions_fax_box_id");
        constraintFk.setForeignSchema("dbo");
        constraintFk.setForeignTable("fax_boxes");
        constraintFk.addColumn("fax_box_id");
        constraintFk.setDelAction("SET DEFAULT");
        constraintFk.setUpdAction("SET NULL");
        constraintFk.setNotForRepl(true);
        table.addConstraint(constraintFk);

        table = new MsTable("table1");
        table.setAnsiNulls(true);
        schema.addTable(table);

        col = new MsColumn("id");
        col.setType(INT);
        col.setNullValue(false);
        table.addColumn(col);

        constraintFk = new MsConstraintFk("FK_table1_fax_box_id");
        constraintFk.setForeignSchema("dbo");
        constraintFk.setForeignTable("fax_boxes");
        constraintFk.addColumn("fax_box_id");
        constraintFk.setDelAction("CASCADE");
        constraintFk.setUpdAction("SET DEFAULT");
        table.addConstraint(constraintFk);

        testDatabase("ms_schema_0.sql", d);
    }

    @Test
    void testDB1() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);

        AbstractSchema schema = new MsSchema("msschema");
        d.addSchema(schema);

        schema = d.getSchema(Consts.DBO);

        MsTable table = new MsTable("contacts");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(INT);
        table.addColumn(col);

        col = new MsColumn("number_pool_id");
        col.setType(INT);
        table.addColumn(col);

        col = new MsColumn("name");
        col.setType("[varchar](50)");
        table.addColumn(col);

        MsIndex idx = new MsIndex("IX_contacts_number_pool_id");
        idx.addColumn(new SimpleColumn("number_pool_id"));
        table.addIndex(idx);

        testDatabase("ms_schema_1.sql", d);
    }

    @Test
    void testDB2() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsSequence seq = new MsSequence("admins_aid_seq");
        seq.setStartWith("1");
        seq.setMinMaxInc(1L, 1000000000L, 1L, null, 0L);
        seq.setCached(true);
        seq.setCache("1");
        schema.addSequence(seq);

        MsTable table = new MsTable("admins");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("aid");
        col.setType(INT);
        col.setNullValue(false);
        col.setDefaultName("DF_admins_aid");
        col.setDefaultValue("(NEXT VALUE FOR [dbo].[admins_aid_seq])");
        table.addColumn(col);

        MsConstraintPk constriaintPk = new MsConstraintPk("PK_admins", true);
        constriaintPk.setClustered(true);
        constriaintPk.setDataSpace(PRIMARY);
        constriaintPk.addColumn(new SimpleColumn("aid"));
        table.addConstraint(constriaintPk);

        col = new MsColumn("companyid");
        col.setType(INT);
        col.setDefaultName("DF_admins_companyid");
        col.setDefaultValue("0");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("groupid");
        col.setType(INT);
        col.setDefaultName("DF_admins_groupid");
        col.setDefaultValue("0");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("username");
        col.setType("[nvarchar](max)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("password");
        col.setType(NVARCHAR_40);
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("superuser");
        col.setType(BIT);
        col.setDefaultName("DF_admins_superuser");
        col.setDefaultValue("0");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("name");
        col.setType(NVARCHAR_40);
        table.addColumn(col);

        col = new MsColumn("surname");
        col.setType(NVARCHAR_40);
        table.addColumn(col);

        col = new MsColumn("email");
        col.setType("[nvarchar](100)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("tel");
        col.setType(NVARCHAR_40);
        table.addColumn(col);

        col = new MsColumn("mobile");
        col.setType(NVARCHAR_40);
        table.addColumn(col);

        col = new MsColumn("enabled");
        col.setType(BIT);
        col.setDefaultName("DF_admins_enabled");
        col.setDefaultValue("1");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("lastlogints");
        col.setType("[datetimeoffset]");
        col.setDefaultName("DF_admins_lastlogints");
        col.setDefaultValue("(getdate())");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("expirienced");
        col.setType(BIT);
        col.setDefaultName("DF_admins_expirienced");
        col.setDefaultValue("0");
        table.addColumn(col);

        testDatabase("ms_schema_2.sql", d);
    }

    @Test
    void testDB3() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsSequence seq = new MsSequence("call_logs_id_seq");
        seq.setStartWith("1");
        seq.setMinMaxInc(1L, 1000000000L, 1L, null, 0L);
        seq.setCached(true);
        seq.setCache("1");
        schema.addSequence(seq);

        MsTable table = new MsTable("call_logs");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(BIGINT);
        col.setNullValue(false);
        col.setDefaultName("DF_call_logs_id");
        col.setDefaultValue("(NEXT VALUE FOR [dbo].[call_logs_id_seq])");
        table.addColumn(col);

        testDatabase("ms_schema_3.sql", d);
    }

    @Test
    void testDB4() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsTable table = new MsTable("table1");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(INT);
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("entityId");
        col.setType(INT);
        col.setNullValue(false);
        table.addColumn(col);

        MsFunction func = new MsFunction("gtsq_in");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.addArgument(new Argument("@eid", "int"));
        func.setFirstPart("");
        func.setSecondPart("""
            (@eid int)
            RETURNS varchar(100)
            WITH RETURNS NULL ON NULL INPUT
            AS
            BEGIN
                Declare @logid varchar(50);
                SELECT @logid = tbl1.id from [dbo].[table1] AS tbl1
                WHERE tbl1.entityId = @eid
                RETURN  @logid
            END""");

        schema.addFunction(func);

        func = new MsFunction("multiply_numbers");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.addArgument(new Argument("@First", "int"));
        func.addArgument(new Argument("@Second", "int"));
        func.setFirstPart("");
        func.setSecondPart("""
            (@First int, @Second int)\s
            RETURNS integer
            AS
            BEGIN
                DECLARE @Res integer = 0

                SET @Res = @First * @Second

                IF @Res < 0
                    SET @Res = 0

                RETURN @Res
            END""");
        schema.addFunction(func);

        func = new MsFunction("select_something");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.addArgument(new Argument("@First", "int"));
        func.addArgument(new Argument("@Second", "int"));
        func.setFirstPart("");
        func.setSecondPart("""
            (@First int, @Second int)\s
            RETURNS integer
            AS
            BEGIN
                DECLARE @Res integer = 0
                SELECT  @Res = COUNT(*) FROM [dbo].[table1];
                RETURN @Res + @First * @Second
            END""");
        schema.addFunction(func);

        testDatabase("ms_schema_4.sql", d);
    }

    @Test
    void testDB5() throws IOException, InterruptedException {
        DatabaseType dbType = DatabaseType.MS;
        AbstractDatabase d = TestUtils.createDumpDB(dbType);
        AbstractSchema schema = d.getDefaultSchema();

        schema.addPrivilege(new PgPrivilege(REVOKE, "SELECT", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(REVOKE, "UPDATE", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(REVOKE, "DELETE", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(REVOKE, "INSERT", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));

        schema.addPrivilege(new PgPrivilege(GRANT, "SELECT", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(GRANT, "UPDATE", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(GRANT, "DELETE", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(GRANT, "INSERT", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));

        MsTable table = new MsTable("test_table");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(BIGINT);
        table.addColumn(col);

        col = new MsColumn("date_deleted");
        col.setType(DATETIME);
        table.addColumn(col);

        table.setOwner(MS_USER);

        MsIndex idx = new MsIndex("IX_test_table_date_deleted");
        idx.addColumn(new SimpleColumn("date_deleted"));
        idx.setWhere("(date_deleted IS NULL)");
        table.addIndex(idx);

        testDatabase("ms_schema_5.sql", d);
    }

    @Test
    void testDB6() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);

        AbstractSchema schema = new MsSchema("common");
        d.addSchema(schema);
        d.setDefaultSchema("common");

        MsFunction func = new MsFunction("t_common_casttotext");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.setFirstPart("");
        func.setSecondPart("""
            ()
            RETURNS varchar(100)
            AS
            BEGIN
                DECLARE @Res varchar(100) = ''
                SELECT  @Res = DATENAME(dw, '09/23/2013')
                RETURN  @Res
            END""");

        schema.addFunction(func);

        testDatabase("ms_schema_6.sql", d);
    }

    @Test
    void testDB7() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsType type = new MsType("testtt", false);
        MsColumn col = new MsColumn("a");
        col.setType(INT);
        type.addChild(col);
        col = new MsColumn("b");
        col.setType(TEXT);
        type.addChild(col);
        type.setOwner(MS_USER);
        schema.addType(type);

        schema = new MsSchema("``54'253-=9!@#$%^&*()__<>?:\"\"{]};',./");
        d.addSchema(schema);

        MsFunction func = new MsFunction(".x\"\".\"\"\"\".");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.addArgument(new Argument("@arg1", "int"));
        func.setFirstPart("/*Name test*/\n");
        func.setSecondPart("""
            (@arg1 int)
            RETURNS bit
            AS
            BEGIN
                DECLARE @Res bit = 0

                IF @arg1 > 1
                    SET @Res = 1

                RETURN @Res
            END""");

        func.setOwner(MS_USER);

        schema.addFunction(func);

        testDatabase("ms_schema_7.sql", d);
    }

    @Test
    void testDB8() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsSequence seq = new MsSequence("user_id_seq");
        seq.setMinMaxInc(1L, null, null, null, 0L);
        seq.setCached(true);
        seq.setCache("1");
        seq.setOwner(MS_USER);
        schema.addSequence(seq);

        MsTable table = new MsTable("user_data");
        table.setAnsiNulls(true);
        table.setOwner(MS_USER);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(BIGINT);
        col.setNullValue(false);
        col.setDefaultName("DF_user_data_id");
        col.setDefaultValue("(NEXT VALUE FOR [dbo].[user_id_seq])");
        table.addColumn(col);

        col = new MsColumn("email");
        col.setType("[nvarchar](128)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("created");
        col.setType("[datetimeoffset]");
        col.setDefaultName("DF_user_data_created");
        col.setDefaultValue("getdate()");
        table.addColumn(col);

        table = new MsTable("t1");
        table.setAnsiNulls(true);
        schema.addTable(table);

        col = new MsColumn("c1");
        col.setType(INT);
        table.addColumn(col);

        MsView view = new MsView("\"user\"");
        view.setAnsiNulls(true);
        view.setQuotedIdentified(true);
        view.setFirstPart("");
        view.setSecondPart("""
             AS
                SELECT\s
                [user_data].[id],
                [user_data].[email],
                [user_data].[created]
            FROM [dbo].[user_data]""");

        view.setOwner(MS_USER);
        schema.addView(view);

        MsTrigger trigger = new MsTrigger("instead_of_delete");
        trigger.setAnsiNulls(true);
        trigger.setQuotedIdentified(true);
        trigger.setFirstPart("");
        trigger.setSecondPart("""

                INSTEAD OF DELETE
                AS
                BEGIN
                    DELETE FROM [dbo].[user_data]
                    WHERE id = 10 \s
                END\
            """);
        view.addTrigger(trigger);

        trigger = new MsTrigger("instead_of_insert");
        trigger.setAnsiNulls(true);
        trigger.setQuotedIdentified(true);
        trigger.setFirstPart("");
        trigger.setSecondPart("""

                INSTEAD OF INSERT
                AS
                BEGIN
                    INSERT INTO [dbo].[user_data] (id, email, created)
                    VALUES(1, 'test@supermail.loc', getdate())
                END\
            """);
        view.addTrigger(trigger);

        trigger = new MsTrigger("instead_of_update");
        trigger.setAnsiNulls(true);
        trigger.setQuotedIdentified(true);
        trigger.setFirstPart("");
        trigger.setSecondPart("""

                INSTEAD OF UPDATE
                AS
                BEGIN
                    UPDATE [dbo].[user_data]\s
                    SET id = 55, email = 'super@supermail.loc'
                    WHERE id = 4
                END\
            """);
        view.addTrigger(trigger);

        view = new MsView("ws_test");
        view.setAnsiNulls(true);
        view.setQuotedIdentified(true);
        view.setFirstPart("");
        view.setSecondPart("""
             AS
                SELECT\s
                ud.[id] AS "   i   d   "
            FROM [dbo].[user_data] ud""");
        schema.addView(view);

        testDatabase("ms_schema_8.sql", d);
    }

    @Test
    void testDB9() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = new MsSchema("admin");
        d.addSchema(schema);
        d.setDefaultSchema("admin");

        schema.setOwner(MS_USER);

        MsTable table = new MsTable("acl_role");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(BIGINT);
        col.setNullValue(false);
        table.addColumn(col);

        MsConstraintPk constriaintPk = new MsConstraintPk("PK_acl_role", true);
        constriaintPk.setClustered(true);
        constriaintPk.setDataSpace(PRIMARY);
        constriaintPk.addColumn(new SimpleColumn("id"));
        table.addConstraint(constriaintPk);

        table.setOwner(MS_USER);

        table = new MsTable("\"user\"");
        table.setAnsiNulls(true);
        schema.addTable(table);

        col = new MsColumn("id");
        col.setType(BIGINT);
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("email");
        col.setType("[nvarchar](255)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("name");
        col.setType("[nvarchar](255)");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("password");
        col.setType(NVARCHAR_40);
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("is_active");
        col.setType(BIT);
        col.setDefaultName("DF_admin_is_active");
        col.setDefaultValue("0");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("updated");
        col.setType(DATETIME);
        col.setDefaultName("DF_admin_updated");
        col.setDefaultValue("(getdate())");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("created");
        col.setType(DATETIME);
        col.setDefaultName("DF_admin_created");
        col.setDefaultValue("(getdate())");
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("role_id");
        col.setType(BIGINT);
        col.setNullValue(false);
        table.addColumn(col);

        col = new MsColumn("last_visit");
        col.setType(DATETIME);
        col.setDefaultName("DF_admin_last_visit");
        col.setDefaultValue("(getdate())");
        col.setNullValue(false);
        table.addColumn(col);

        MsIndex idx = new MsIndex("IX_user_role_id");
        idx.addColumn(new SimpleColumn("role_id"));
        table.addIndex(idx);

        var constraintFk = new MsConstraintFk("FK_user_fax_box_id");
        constraintFk.addColumn("role_id");
        constraintFk.setForeignSchema("admin");
        constraintFk.setForeignTable("acl_role");
        constraintFk.addForeignColumn("id");
        table.addConstraint(constraintFk);

        table.setOwner(MS_USER);

        testDatabase("ms_schema_9.sql", d);
    }

    @Test
    void testDB10() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsFunction func = new MsFunction("curdate");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.setFirstPart("");
        func.setSecondPart("""
            ()
            RETURNS nvarchar(30)
            AS
            BEGIN
                Declare @textdate nvarchar(30);
                SELECT @textdate = CAST(GETDATE() AS nvarchar(30));
                RETURN  @textdate;
            END""");

        schema.addFunction(func);

        testDatabase("ms_schema_10.sql", d);
    }

    @Test
    void testDB11() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsTable table = new MsTable("TABLE_1");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("ID");
        col.setType(INT);
        col.setNullValue(false);
        col.setIdentity("1", "1");
        table.addColumn(col);

        col = new MsColumn("COLUMN_1");
        col.setType("[varchar](10)");
        table.addColumn(col);

        col = new MsColumn("COLUMN_2");
        col.setType("[varchar](10)");
        table.addColumn(col);

        MsConstraintPk constriaintPk = new MsConstraintPk("PK_TABLE_1", true);
        constriaintPk.setClustered(true);
        constriaintPk.setDataSpace(PRIMARY);
        constriaintPk.addColumn(new SimpleColumn("ID"));
        table.addConstraint(constriaintPk);

        testDatabase("ms_schema_11.sql", d);
    }

    @Test
    void testDB12() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsFunction func = new MsFunction("function_string_to_table");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.setFuncType(FuncTypes.MULTI);
        func.addArgument(new Argument("@string", "nvarchar(MAX)"));
        func.addArgument(new Argument("@delimiter", "char(1)"));
        func.setFirstPart("");
        func.setSecondPart("""

            (@string nvarchar(MAX), @delimiter char(1))
            RETURNS @output TABLE(tbldata nvarchar(256))
            BEGIN
                DECLARE @start INT, @end INT
                SELECT @start = 1, @end = CHARINDEX(@delimiter, @string)

                WHILE @start < LEN(@string) + 1 BEGIN
                    IF @end = 0\s
                        SET @end = LEN(@string) + 1

                    INSERT INTO @output (tbldata)\s
                    VALUES(SUBSTRING(@string, @start, @end - @start))
                    SET @start = @end + 1
                    SET @end = CHARINDEX(@delimiter, @string, @start)
                END

                RETURN
            END""");
        schema.addFunction(func);

        func = new MsFunction("function_empty");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.setFuncType(FuncTypes.MULTI);
        func.addArgument(new Argument("@string", "nvarchar(MAX)"));
        func.addArgument(new Argument("@delimiter", "char(1)"));
        func.setFirstPart("");
        func.setSecondPart("""

            (@string nvarchar(MAX), @delimiter char(1))
            RETURNS @output TABLE(tbldata nvarchar(256))
            BEGIN
                -- aaa
                RETURN
            END""");

        schema.addFunction(func);

        testDatabase("ms_schema_12.sql", d);
    }

    @Test
    void testDB13() throws IOException, InterruptedException {
        DatabaseType dbType = DatabaseType.MS;
        AbstractDatabase d = TestUtils.createDumpDB(dbType);
        AbstractSchema schema = d.getDefaultSchema();

        schema.addPrivilege(new PgPrivilege(REVOKE, "SELECT", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(REVOKE, "UPDATE", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(REVOKE, "DELETE", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(REVOKE, "INSERT", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));

        schema.addPrivilege(new PgPrivilege(GRANT, "SELECT", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(GRANT, "UPDATE", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(GRANT, "DELETE", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));
        schema.addPrivilege(new PgPrivilege(GRANT, "INSERT", SCHEMA_DBO, QUOTED_MS_USER, false, dbType));

        MsSequence seq = new MsSequence("test_id_seq");
        seq.setStartWith("1");
        seq.setMinMaxInc(1L, null, null, null, 0L);
        seq.setCached(true);
        seq.setCache("1");
        seq.setOwner(MS_USER);
        schema.addSequence(seq);

        MsFunction func = new MsFunction("test_fnc");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.addArgument(new Argument("@arg", "nvarchar"));
        func.setFirstPart("");
        func.setSecondPart("""
            (@arg nvarchar)\s
            RETURNS bit
            AS
            BEGIN
                RETURN 1
            END""");
        func.setOwner(MS_USER);

        schema.addFunction(func);

        func = new MsFunction("fnc");
        func.setAnsiNulls(true);
        func.setQuotedIdentified(true);
        func.setFirstPart("");
        func.setSecondPart("""
            ()\s
            RETURNS bit
            AS
            BEGIN
                RETURN 1
            END""");


        schema.addFunction(func);

        func.setOwner(MS_USER);

        MsProcedure proc = new MsProcedure("trigger_proc");
        proc.setAnsiNulls(true);
        proc.setQuotedIdentified(true);
        proc.setFirstPart("");
        proc.setSecondPart("""

            AS
            BEGIN
                -- empty procedure
                RETURN
            END""");
        schema.addFunction(proc);

        proc.setOwner(MS_USER);

        MsTable table = new MsTable("test");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(INT);
        col.setNullValue(false);
        col.setDefaultName("DF_test_id");
        col.setDefaultValue("(NEXT VALUE FOR [dbo].[test_id_seq])");
        table.addColumn(col);

        col = new MsColumn("text");
        col.setType("[nvarchar](20)");
        col.setNullValue(false);
        table.addColumn(col);

        var constraintCheck = new MsConstraintCheck("text_check");
        constraintCheck.setExpression("(LEN([text])>(0))");
        table.addConstraint(constraintCheck);


        MsConstraintPk constriaintPk = new MsConstraintPk("PK_test", true);
        constriaintPk.setClustered(true);
        constriaintPk.setDataSpace(PRIMARY);
        constriaintPk.addColumn(new SimpleColumn("id"));
        table.addConstraint(constriaintPk);
        table.setOwner(MS_USER);

        MsView view = new MsView("test_view");
        view.setAnsiNulls(true);
        view.setQuotedIdentified(true);
        view.setFirstPart("");
        view.setSecondPart("""
             AS
                SELECT\s
                [test].[id],
                [test].[text]
            FROM [dbo].[test]""");
        schema.addView(view);
        view.setOwner(MS_USER);

        MsIndex idx = new MsIndex("IX_test_id");
        table.addIndex(idx);
        idx.addColumn(new SimpleColumn("id"));

        MsTrigger trigger = new MsTrigger("test_trigger");
        trigger.setQuotedIdentified(true);
        trigger.setAnsiNulls(true);
        trigger.setFirstPart("");
        trigger.setSecondPart("""

            FOR UPDATE
            AS\s
                BEGIN
                    SET NOCOUNT ON;
                    EXEC [dbo].[trigger_proc];
                END""");
        table.addTrigger(trigger);

        testDatabase("ms_schema_13.sql", d);
    }

    @Test
    void testDB14() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        MsTable table = new MsTable("test");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(BIGINT);
        table.addColumn(col);

        testDatabase("ms_schema_14.sql", d);
    }

    @Test
    void testDB15() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        // table1
        MsTable table = new MsTable("\"t_work\"");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(INT);
        table.addColumn(col);

        // table2
        MsTable table2 = new MsTable("\"t_chart\"");
        table2.setAnsiNulls(true);
        schema.addTable(table2);
        col = new MsColumn("id");
        col.setType(INT);
        table2.addColumn(col);

        // view
        MsView view = new MsView("v_subselect");
        view.setAnsiNulls(true);
        view.setQuotedIdentified(true);
        view.setFirstPart("");
        view.setSecondPart("""
             AS
                SELECT\s
                    c.[id] AS id_t_chart,\s
                    t.[id] AS id_t_work\s
                FROM ( SELECT\s
                           ["t_work"].[id]\s
                       FROM [dbo].["t_work"]) t\s
            JOIN [dbo].["t_chart"] c ON t.[id] = c.[id]""");
        schema.addView(view);

        testDatabase("ms_schema_15.sql", d);
    }

    @Test
    void testDB16() throws IOException, InterruptedException {
        AbstractDatabase d = TestUtils.createDumpDB(DatabaseType.MS);
        AbstractSchema schema = d.getDefaultSchema();

        // table1
        MsTable table = new MsTable("\"t_work\"");
        table.setAnsiNulls(true);
        schema.addTable(table);

        MsColumn col = new MsColumn("id");
        col.setType(INT);
        table.addColumn(col);

        // table2
        MsTable table2 = new MsTable("\"t_chart\"");
        table2.setAnsiNulls(true);
        schema.addTable(table2);
        col = new MsColumn("id");
        col.setType(INT);
        table2.addColumn(col);

        // table 3
        MsTable table3 = new MsTable("\"t_memo\"");
        table3.setAnsiNulls(true);
        schema.addTable(table3);
        col = new MsColumn("name");
        col.setType(TEXT);
        table3.addColumn(col);

        // view
        MsView view = new MsView("v_subselect");
        view.setAnsiNulls(true);
        view.setQuotedIdentified(true);
        view.setFirstPart("");
        view.setSecondPart("""
             AS
                SELECT\s
                    c.[id] AS id_t_chart,\s
                    t.[id] AS id_t_work,\s
                    t.[name]
                FROM (SELECT\s
                          w.[id],\s
                          m.[name]\s
                      FROM (SELECT\s
                                ["t_work"].[id]
                            FROM [dbo].["t_work"]) w\s
                      JOIN [dbo].["t_memo"] m ON w.[id] = CONVERT(INT, CONVERT(VARCHAR(MAX), m.[name]))) t
                JOIN [dbo].["t_chart"] c ON t.[id] = c.[id]\
            """);
        schema.addView(view);

        testDatabase("ms_schema_16.sql", d);
    }
}
