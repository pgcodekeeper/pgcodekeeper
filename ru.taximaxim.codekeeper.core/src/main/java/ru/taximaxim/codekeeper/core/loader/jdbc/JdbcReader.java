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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.BiConsumer;

import org.antlr.v4.runtime.ParserRuleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.ConcurrentModificationException;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public abstract class JdbcReader extends AbstractStatementReader {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcReader.class);

    private static final String EXTENSIONS_SCHEMAS = "extensions_schemas";

    private static final QueryBuilder EXTENSION_SCHEMA_CTE_SUBSELECT = new QueryBuilder()
            .column("1")
            .from("pg_catalog.pg_depend dp")
            .where("dp.objid = n.oid")
            .where("dp.deptype = 'e'")
            .where("dp.classid = 'pg_catalog.pg_namespace'::pg_catalog.regclass");

    private static final QueryBuilder EXTENSION_SCHEMA_CTE = new QueryBuilder()
            .column("n.oid")
            .from("pg_catalog.pg_namespace n")
            .where("EXISTS", EXTENSION_SCHEMA_CTE_SUBSELECT);

    protected JdbcReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet result) throws SQLException, XmlReaderException {
        String schemaColumn = getSchemaColumn();
        var schemaId = result.getObject(schemaColumn.substring(schemaColumn.indexOf('.') + 1));
        AbstractSchema schema = loader.getSchema(schemaId);
        if (schema == null) {
            LOG.warn("No schema found for id {}", schemaId);
            return;
        }

        try {
            processResult(result, schema);
        } catch (ConcurrentModificationException ex) {
            if (!loader.getArgs().isIgnoreConcurrentModification()) {
                throw ex;
            }
            LOG.error(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    protected QueryBuilder makeQuery() {
        String schemas = loader.getSchemas();
        if (schemas.isBlank()) {
            return null;
        }

        QueryBuilder builder = super.makeQuery();
        builder.column(getSchemaColumn());

        StringBuilder sb = new StringBuilder();
        sb.append(getSchemaColumn()).append(" IN (").append(schemas).append(')');

        builder.where(sb.toString());

        return builder;
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

    public static <T extends PgStatement> void setFunctionWithDep(
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

    protected void addDep(PgStatement statement, String schemaName, String name, DbObjType type) {
        if (schemaName != null && !Utils.isPgSystemSchema(schemaName)) {
            statement.addDep(new GenericColumn(schemaName, DbObjType.SCHEMA));
            statement.addDep(new GenericColumn(schemaName, name, type));
        }
    }

    protected abstract void processResult(ResultSet result, AbstractSchema schema)
            throws SQLException, XmlReaderException;

    protected abstract String getSchemaColumn();

    protected void addExtensionSchemasCte(QueryBuilder builder) {
        builder.with(EXTENSIONS_SCHEMAS, EXTENSION_SCHEMA_CTE);
        builder.where(getSchemaColumn() + " NOT IN (SELECT oid FROM extensions_schemas)");
    }

    @Override
    protected void addMsOwnerPart(String field, QueryBuilder builder) {
        builder.column("p.name AS owner");
        // left join
        builder.join("LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=" + field);
    }

    protected String readTriggerState(String stateChar) {
        String state;
        switch (stateChar) {
        case "f", "D":
            state = "DISABLE";
            break;
        case "t", "O":
            state = "ENABLE";
            break;
        case "R":
            state = "ENABLE REPLICA";
            break;
        case "A":
            state = "ENABLE ALWAYS";
            break;
        default:
            state = "ENABLE";
        }
        return state;
    }
}
