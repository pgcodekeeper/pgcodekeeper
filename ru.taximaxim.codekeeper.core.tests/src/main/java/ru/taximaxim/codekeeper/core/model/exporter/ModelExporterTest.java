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
package ru.taximaxim.codekeeper.core.model.exporter;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.FILES_POSTFIX;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.CoreSettings;

public final class ModelExporterTest {

    @ParameterizedTest
    @CsvSource({
        "test_settings_in_pg, public.t1, TABLE",
        "test_settings_in_pg, public.t1.constr, CONSTRAINT"
        })
    void settingsTest(String template, String stmtName, DbObjType type) throws IOException, InterruptedException {
        var settings = new CoreSettings() {
            @Override
            public boolean isGenerateExists() {
                return true;
            }

            @Override
            public boolean isConstraintNotValid() {
                return true;
            }
        };

        AbstractDatabase db = TestUtils.loadTestDump(template + FILES_POSTFIX.SQL, getClass(), settings);

        var exporter = new ModelExporter(null, db, DatabaseType.PG, Consts.UTF_8, settings);
        var stmt = getStatement(db, stmtName, type);
        var actual = exporter.getDumpSql(stmt);

        // check that exporter generate script is equals generated script with default settings
        Assertions.assertEquals(getCreationSQL(stmt), actual, "this should be equals");

        var script = new SQLScript(settings);
        stmt.getCreationSQL(script);

        // check that exporter generate script is not equals generated script with user settings
        Assertions.assertNotEquals(script.getFullScript(), actual, "this should be not equals");
    }

    /**
     * 
     *  get {@link PgStatement} object from {@link AbstractDatabase} 
     * 
     * @param db - {@link AbstractDatabase} witch store PgStatement 
     * @param stmtName - name of {@link PgStatement} witch we need for test
     * @param type - {@link DbObjType} of {@link PgStatement} witch we need for test
     * @return - {@link PgStatement} witch we need for test
     */
    private PgStatement getStatement(AbstractDatabase db, String stmtName, DbObjType type) {
        String[] arr = Arrays.copyOf(stmtName.split("\\."), 3);
        return db.getStatement(new GenericColumn(arr[0], arr[1], arr[2], type));
    }

    /**
     * generate SQL script with default settings
     * 
     * @param statement - {@link PgStatement} witch we used for test
     * @return - generated script
     */
    private String getCreationSQL(PgStatement statement) {
        var script = new SQLScript(new CoreSettings());
        statement.getCreationSQL(script);
        return script.getFullScript();
    }
}
