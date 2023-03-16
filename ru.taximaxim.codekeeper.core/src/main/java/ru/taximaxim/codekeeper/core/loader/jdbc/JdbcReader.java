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

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.BiConsumer;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQuery;
import ru.taximaxim.codekeeper.core.log.Log;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.ConcurrentModificationException;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public abstract class JdbcReader implements PgCatalogStrings {

    protected final JdbcQuery queries;
    protected final JdbcLoaderBase loader;

    protected JdbcReader(JdbcQuery queries, JdbcLoaderBase loader) {
        this.queries = queries;
        this.loader = loader;
    }

    public void read() throws SQLException, InterruptedException, XmlReaderException {
        String query = queries.makeQuery(loader, true, getClassId());
        if (query == null) {
            return;
        }

        loader.setCurrentOperation(getClass().getSimpleName() + " query");
        try (PreparedStatement statement = loader.connection.prepareStatement(query)) {
            setParams(statement);
            ResultSet result = loader.runner.runScript(statement);
            while (result.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                long schemaId = result.getLong("schema_oid");
                AbstractSchema schema = loader.schemaIds.get(schemaId);
                if (schema != null) {
                    try {
                        processResult(result, schema);
                    } catch (ConcurrentModificationException ex) {
                        if (!loader.args.isIgnoreConcurrentModification()) {
                            throw ex;
                        }
                        Log.log(ex);
                    }
                } else {
                    Log.log(Log.LOG_WARNING, "No schema found for id " + schemaId);
                }
            }
        }
    }

    protected void setParams(PreparedStatement statement) throws SQLException {
        // subclasses will override if needed
    }

    /**
     * Override for postgres for correct dbo_ts extension work.
     *
     * @return object class's catalog name
     */
    protected String getClassId() {
        return null;
    }

    /**
     * The functions that accept the oid / object name and return the set / processing of its metadata are considered unsafe.
     * These functions can return null if the object was deleted outside the transaction block.
     * This method checks the returned values.
     */
    public static void checkObjectValidity(Object object, DbObjType type, String name) {
        if (object == null) {
            throw new ConcurrentModificationException(
                    "Statement concurrent modification: " + type + ' ' + name);
        }
    }

    /**
     * Checks type for a match with null and unknown types that can come from
     * functions that accept the oid / object name and return the set / processing of its metadata
     */
    public static void checkTypeValidity(String type) {
        checkObjectValidity(type, DbObjType.TYPE, "");
        if ("???".equals(type) || "???[]".equals(type)) {
            throw new ConcurrentModificationException("Concurrent type modification");
        }
    }

    public static <T> T[] getColArray(ResultSet rs, String columnName) throws SQLException {
        Array arr = rs.getArray(columnName);
        if (arr != null) {
            @SuppressWarnings("unchecked")
            T[] ret = (T[]) arr.getArray();
            return ret;
        }
        return null;
    }

    /**
     * @deprecated {@link #setFunctionWithDep(BiConsumer, PgStatement, String, String)}
     */
    @Deprecated
    protected <T extends PgStatement> void setFunctionWithDep(
            BiConsumer<T, String> setter, T statement, String function) {
        setFunctionWithDep(setter, statement, function, null);
    }

    protected static <T extends PgStatement> void setFunctionWithDep(
            BiConsumer<T, String> setter, T statement, String function, String signature) {
        if (function.indexOf('.') != -1) {
            QNameParser<ParserRuleContext> parser = QNameParser.parsePg(function);
            String schemaName = parser.getSchemaName();
            if (schemaName != null && !Utils.isPgSystemSchema(schemaName)) {
                statement.addDep(new GenericColumn(schemaName, DbObjType.SCHEMA));
                String name = parser.getFirstName();
                if (signature != null) {
                    name = PgDiffUtils.getQuotedName(name) + signature;
                }
                statement.addDep(new GenericColumn(schemaName, name, DbObjType.FUNCTION));
            }
        }
        setter.accept(statement, function);
    }

    protected abstract void processResult(ResultSet result, AbstractSchema schema)
            throws SQLException, XmlReaderException;
}
