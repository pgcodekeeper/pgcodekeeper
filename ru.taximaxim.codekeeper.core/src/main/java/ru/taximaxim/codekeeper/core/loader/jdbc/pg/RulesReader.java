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
package ru.taximaxim.codekeeper.core.loader.jdbc.pg;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateRule;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.EventType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.pg.PgRule;

public class RulesReader extends JdbcReader {

    public RulesReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException {
        String contName = result.getString("relname");
        PgStatementContainer c = schema.getStatementContainer(contName);
        if (c != null) {
            c.addRule(getRule(result, schema, contName));
        }
    }

    private PgRule getRule(ResultSet res, AbstractSchema schema, String tableName) throws SQLException {
        String schemaName = schema.getName();
        String ruleName = res.getString("rulename");
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, ruleName, DbObjType.RULE));

        String command = res.getString("rule_string");
        checkObjectValidity(command, DbObjType.RULE, ruleName);
        PgRule r = new PgRule(ruleName);

        switch (res.getString("ev_type")) {
        case "1":
            r.setEvent(EventType.SELECT);
            break;
        case "2":
            r.setEvent(EventType.UPDATE);
            break;
        case "3":
            r.setEvent(EventType.INSERT);
            break;
        case "4":
            r.setEvent(EventType.DELETE);
            break;
        }

        if (res.getBoolean("is_instead")) {
            r.setInstead(true);
        }

        switch (res.getString("ev_enabled")) {
        case "A":
            r.setEnabledState("ENABLE ALWAYS");
            break;
        case "R":
            r.setEnabledState("ENABLE REPLICA");
            break;
        case "D":
            r.setEnabledState("DISABLE");
            break;
        }

        loader.submitAntlrTask(command, p -> p.sql().statement(0)
                .schema_statement().schema_create().create_rewrite_statement(),
                ctx -> CreateRule.setConditionAndAddCommands(ctx, r,
                        schema.getDatabase(), loader.getCurrentLocation()));

        loader.setAuthor(r, res);
        loader.setComment(r, res);

        return r;
    }

    @Override
    protected String getClassId() {
        return "pg_rewrite";
    }

    @Override
    protected String getSchemaColumn() {
        return "ccc.relnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionSchemasCte(builder);
        addDescriptionPart(builder);

        builder
        .column("ccc.relname")
        .column("res.rulename")
        .column("res.ev_type")
        .column("res.is_instead")
        .column("res.ev_enabled")
        .column("pg_catalog.pg_get_ruledef(res.oid) AS rule_string")
        .from("pg_catalog.pg_rewrite res")
        .join("JOIN pg_catalog.pg_class ccc ON ccc.oid = res.ev_class")
        // block rules that implement views
        .where("NOT ((ccc.relkind = 'v' OR ccc.relkind = 'm') AND res.ev_type = '1' AND res.is_instead)");
    }
}
