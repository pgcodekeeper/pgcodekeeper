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
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.CreateRule;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgEventType;
import ru.taximaxim.codekeeper.core.schema.PgRule;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;

public class RulesReader extends JdbcReader {

    public RulesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_RULES, loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException {
        String contName = result.getString(CLASS_RELNAME);
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
            r.setEvent(PgEventType.SELECT);
            break;
        case "2":
            r.setEvent(PgEventType.UPDATE);
            break;
        case "3":
            r.setEvent(PgEventType.INSERT);
            break;
        case "4":
            r.setEvent(PgEventType.DELETE);
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
        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            r.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        return r;
    }

    @Override
    protected String getClassId() {
        return "pg_rewrite";
    }
}
