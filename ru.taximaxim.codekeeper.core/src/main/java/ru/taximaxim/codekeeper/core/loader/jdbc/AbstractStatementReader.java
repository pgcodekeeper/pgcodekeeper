/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;

public abstract class AbstractStatementReader {

    private static final String PG_CATALOG = "pg_catalog.";

    private static final String MS_PRIVILIGES_JOIN = """
            CROSS APPLY (
              SELECT * FROM (
                SELECT
                  perm.state_desc AS sd,
                  perm.permission_name AS pn,
                  roleprinc.name AS r,
                  col.name AS c
                FROM sys.database_principals roleprinc  WITH (NOLOCK)
                JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id
                LEFT JOIN sys.columns col WITH (NOLOCK) ON col.object_id = perm.major_id AND col.column_id = perm.minor_id
                WHERE major_id = res.object_id AND perm.class = 1
              ) cc
              FOR XML RAW, ROOT
            ) aa (acl)""";


    private static final String EXTENSION_DEPS_CTE =
            "SELECT objid FROM pg_catalog.pg_depend WHERE classid = {0}::pg_catalog.regclass AND deptype = ''e''";

    // join extension data with a left join
    private static final String EXTENSION_JOIN =
            "LEFT JOIN {0}.dbots_event_data time ON time.objid = res.oid AND time.classid = {1}::pg_catalog.regclass";

    // join description data with a left join
    private static final String DESCRIPTION_JOIN =
            "LEFT JOIN pg_catalog.pg_description d ON d.objoid = res.oid AND d.classoid = {0}::pg_catalog.regclass {1}";

    protected final JdbcLoaderBase loader;
    private final String classId;

    protected AbstractStatementReader(JdbcLoaderBase loader) {
        this.loader = loader;
        String tmpClassId = getClassId();
        this.classId = tmpClassId == null ? null : PgDiffUtils.quoteString(PG_CATALOG + tmpClassId);
    }

    public final void read() throws SQLException, InterruptedException, XmlReaderException {
        loader.setCurrentOperation(getClass().getSimpleName() + " query");
        QueryBuilder builder = makeQuery();
        if (builder == null) {
            return;
        }
        String query = builder.build();

        try (PreparedStatement statement = loader.getConnection().prepareStatement(query)) {
            setParams(statement);
            ResultSet result = loader.getRunner().runScript(statement);
            while (result.next()) {
                PgDiffUtils.checkCancelled(loader.getMonitor());
                loader.getMonitor().worked(1);
                processResult(result);
            }
        }
    }

    protected QueryBuilder makeQuery() {
        QueryBuilder builder = new QueryBuilder();
        fillQueryBuilder(builder);
        appendExtension(builder);
        return builder;
    }

    private void appendExtension(QueryBuilder builder) {
        String extensionSchema = loader.getExtensionSchema();
        if (extensionSchema != null) {
            builder.column("time.ses_user");
            builder.join(MessageFormat.format(EXTENSION_JOIN,
                    PgDiffUtils.getQuotedName(extensionSchema), classId));
        }
    }

    protected void addExtensionDepsCte(QueryBuilder builder) {
        builder.with("extension_deps", MessageFormat.format(EXTENSION_DEPS_CTE, classId));
        builder.where("res.oid NOT IN (SELECT objid FROM extension_deps)");
    }

    protected void addDescriptionPart(QueryBuilder builder) {
        addDescriptionPart(builder, false);
    }

    protected void addDescriptionPart(QueryBuilder builder, boolean checkColumn) {
        builder.column("d.description");
        builder.join(MessageFormat.format(DESCRIPTION_JOIN, classId,
                checkColumn ? "AND d.objsubid = 0" : ""));
    }

    protected void addMsPriviligesPart(QueryBuilder builder) {
        builder.column("aa.acl");
        builder.join(MS_PRIVILIGES_JOIN);
    }

    protected void addMsOwnerPart(QueryBuilder builder) {
        addMsOwnerPart("res.principal_id", builder);
    }

    protected void addMsOwnerPart(String field, QueryBuilder builder) {
        builder.column("p.name AS owner");
        builder.join("JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=" + field);
    }

    protected abstract void processResult(ResultSet result) throws SQLException, XmlReaderException;

    protected abstract void fillQueryBuilder(QueryBuilder builder);

    protected void setParams(PreparedStatement statement) throws SQLException {
        // subclasses will override if needed
    }

    /**
     * Override for postgres.
     *
     * @return object class's catalog name
     */
    protected String getClassId() {
        return null;
    }
}
