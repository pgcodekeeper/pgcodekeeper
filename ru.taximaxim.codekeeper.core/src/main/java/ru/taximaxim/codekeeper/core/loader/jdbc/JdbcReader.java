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

    private static final String SYS_SCHEMAS = "sys_schemas";

    protected JdbcReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet result) throws SQLException, XmlReaderException {
        String schemaColumn = getSchemaColumn();
        long schemaId = result.getLong(schemaColumn.substring(schemaColumn.indexOf('.') + 1));
        AbstractSchema schema = loader.schemaIds.get(schemaId);
        if (schema != null) {
            try {
                processResult(result, schema);
            } catch (ConcurrentModificationException ex) {
                if (!loader.args.isIgnoreConcurrentModification()) {
                    throw ex;
                }
                LOG.error(ex.getLocalizedMessage(), ex);
            }
        } else {
            LOG.warn("No schema found for id {}", schemaId);
        }
    }

    @Override
    protected QueryBuilder makeQuery() {
        if (loader.getSchemas().isEmpty()) {
            return null;
        }

        QueryBuilder builder = super.makeQuery();
        builder.column(getSchemaColumn());

        StringBuilder sb = new StringBuilder();
        sb.append(getSchemaColumn()).append(" IN (");
        for (Long id : loader.getSchemas().keySet()) {
            sb.append(id).append(',');
        }
        sb.setLength(sb.length() - 1);
        sb.append(')');

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

    protected abstract String getSchemaColumn();

    protected void addSysSchemasCte(QueryBuilder builder) {
        builder.with(SYS_SCHEMAS,
                "SELECT oid FROM pg_catalog.pg_namespace WHERE nspname LIKE 'pg\\_%' OR nspname = 'information_schema'");
        builder.where(getSchemaColumn() + " NOT IN (SELECT oid FROM sys_schemas)");
    }

    protected void addSysSchemasWithExtensionCte(QueryBuilder builder) {
        builder.with(SYS_SCHEMAS, SYS_SCHEMAS_WITH_EXTENSION_DEPS_CTE);
        builder.where(getSchemaColumn() + " NOT IN (SELECT oid FROM sys_schemas)");
    }

    @Override
    protected void addMsOwnerPart(String field, QueryBuilder builder) {
        builder.column("p.name AS owner");
        // left join
        builder.join("LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=" + field);
    }
}
