/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.CreateFdw;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgForeignDataWrapper;

public class ForeignDataWrappersReader implements PgCatalogStrings {
    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public ForeignDataWrappersReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("foreign_data_wrapper query");
        String query = JdbcQueries.QUERY_FOREIGN_DATA_WRAPPERS
                .makeQuery(loader, "pg_foreign_data_wrapper");
        try (ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                PgForeignDataWrapper foreignDW = getForeignDW(res);
                db.addForeignDW(foreignDW);
                loader.setAuthor(foreignDW, res);
            }
        }
    }

    private PgForeignDataWrapper getForeignDW(ResultSet res) throws SQLException {
        String fdwName = res.getString("fdwname");
        loader.setCurrentObject(new GenericColumn(fdwName, DbObjType.FOREIGN_DATA_WRAPPER));
        PgForeignDataWrapper f = new PgForeignDataWrapper(fdwName);

        String fdwHandler = res.getString("fdwhandler");

        if (!"-".equals(fdwHandler)) {
            JdbcReader.setFunctionWithDep(PgForeignDataWrapper::setHandler, f, fdwHandler, CreateFdw.HANDLER_SIGNATURE);
        }
        String fdwValidator = res.getString("fdwvalidator");
        if (!"-".equals(fdwValidator)) {
            JdbcReader.setFunctionWithDep(PgForeignDataWrapper::setValidator, f, fdwValidator, CreateFdw.VALIDATOR_SIGNATURE);
        }

        String[] options = JdbcReader.getColArray(res, "fdwoptions");
        if (options != null) {
            ParserAbstract.fillOptionParams(options, f::addOption, false, true, false);
        }
        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            f.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        loader.setOwner(f, res.getLong("fdwowner"));
        loader.setPrivileges(f, res.getString("fdwacl"), null);

        return f;
    }
}
