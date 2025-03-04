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

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.pg.SupportedPgVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateTrigger;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.pg.PgTrigger;
import ru.taximaxim.codekeeper.core.schema.pg.PgTrigger.TgTypes;
import ru.taximaxim.codekeeper.core.schema.pg.EnabledState;

public final class TriggersReader extends JdbcReader {

    // SONAR-OFF
    // pg_trigger.h
    private static final int TRIGGER_TYPE_ROW       = 1 << 0;
    private static final int TRIGGER_TYPE_BEFORE    = 1 << 1;
    private static final int TRIGGER_TYPE_INSERT    = 1 << 2;
    private static final int TRIGGER_TYPE_DELETE    = 1 << 3;
    private static final int TRIGGER_TYPE_UPDATE    = 1 << 4;
    private static final int TRIGGER_TYPE_TRUNCATE  = 1 << 5;
    private static final int TRIGGER_TYPE_INSTEAD   = 1 << 6;
    // SONAR-ON

    public TriggersReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String tableName = res.getString("relname");
        PgStatementContainer c = schema.getStatementContainer(tableName);
        if (c == null) {
            return;
        }

        String schemaName = schema.getName();
        String triggerName = res.getString("tgname");
        String tgEnabled = res.getString("tgenabled");

        if (!res.getString("tgparentid").equals("0") && c instanceof AbstractPgTable table) {
            table.putTriggerState(triggerName, readEnabledState(tgEnabled, true));
            return;
        }

        loader.setCurrentObject(new GenericColumn(schemaName, tableName, triggerName, DbObjType.TRIGGER));
        PgTrigger t = new PgTrigger(triggerName);

        int firingConditions = res.getInt("tgtype");
        if ((firingConditions & TRIGGER_TYPE_DELETE) != 0) {
            t.setOnDelete(true);
        }
        if ((firingConditions & TRIGGER_TYPE_INSERT) != 0) {
            t.setOnInsert(true);
        }
        if ((firingConditions & TRIGGER_TYPE_UPDATE) != 0) {
            t.setOnUpdate(true);
        }
        if ((firingConditions & TRIGGER_TYPE_TRUNCATE) != 0) {
            t.setOnTruncate(true);
        }
        if ((firingConditions & TRIGGER_TYPE_ROW) != 0) {
            t.setForEachRow(true);
        }
        if ((firingConditions & TRIGGER_TYPE_BEFORE) != 0) {
            t.setType(TgTypes.BEFORE);
        } else if ((firingConditions & TRIGGER_TYPE_INSTEAD) != 0) {
            t.setType(TgTypes.INSTEAD_OF);
        } else {
            t.setType(TgTypes.AFTER);
        }

        String funcName = res.getString("proname");
        String funcSchema = res.getString("nspname");

        StringBuilder functionCall = new StringBuilder(funcName.length() + 2);
        functionCall.append(PgDiffUtils.getQuotedName(funcSchema)).append('.')
        .append(PgDiffUtils.getQuotedName(funcName)).append('(');
        t.setTriggerState(readEnabledState(tgEnabled, false));

        byte[] args = res.getBytes("tgargs");
        if (args.length > 0) {
            functionCall.append('\'');
            int start = 0;
            for (int i = 0; i < args.length; ++i) {
                if (args[i] != 0) {
                    continue;
                }

                functionCall.append(new String(args, start, i - start, StandardCharsets.UTF_8));
                if (i != args.length - 1) {
                    functionCall.append("', '");
                }
                start = i + 1;
            }
            functionCall.append('\'');
        }
        functionCall.append(')');
        t.setFunction(functionCall.toString());

        addDep(t, funcSchema, funcName + "()", DbObjType.FUNCTION);

        if (res.getLong("tgconstraint") != 0) {
            t.setConstraint(true);

            String refRelName = res.getString("refrelname");
            if (refRelName != null) {
                String refSchemaName = res.getString("refnspname");
                StringBuilder sb = new StringBuilder();
                sb.append(PgDiffUtils.getQuotedName(refSchemaName)).append('.');
                sb.append(PgDiffUtils.getQuotedName(refRelName));

                t.setRefTableName(sb.toString());
                addDep(t, refSchemaName, refRelName, DbObjType.TABLE);
            }

            // before PostgreSQL 9.5
            if (res.getBoolean("tgdeferrable")) {
                t.setImmediate(!res.getBoolean("tginitdeferred"));
            }
        }

        // after Postgresql 10
        if (SupportedPgVersion.VERSION_10.isLE(loader.getVersion())) {
            t.setOldTable(res.getString("tgoldtable"));
            t.setNewTable(res.getString("tgnewtable"));
        }

        String[] arrCols = getColArray(res, "cols");
        if (arrCols != null) {
            for (String colName : arrCols) {
                t.addUpdateColumn(colName);
                t.addDep(new GenericColumn(schemaName, tableName, colName, DbObjType.COLUMN));
            }
        }

        String definition = res.getString("definition");
        checkObjectValidity(definition, DbObjType.TRIGGER, triggerName);
        loader.submitAntlrTask(definition, p -> p.sql().statement(0).schema_statement()
                .schema_create().create_trigger_statement().when_trigger(),
                ctx -> CreateTrigger.parseWhen(ctx, t, schema.getDatabase(), loader.getCurrentLocation()));

        loader.setAuthor(t, res);
        loader.setComment(t, res);
        c.addTrigger(t);
    }

    private EnabledState readEnabledState(String tgEnabled, boolean isChild) {
        EnabledState state = null;
        state = switch (tgEnabled) {
        case "f", "D" -> EnabledState.DISABLE;
        case "t", "O" -> isChild ? EnabledState.ENABLE : null;
        case "R" -> EnabledState.ENABLE_REPLICA;
        case "A" -> EnabledState.ENABLE_ALWAYS;
        default -> EnabledState.ENABLE;
        };
        return state;
    }

    @Override
    protected String getClassId() {
        return "pg_trigger";
    }

    @Override
    protected String getSchemaColumn() {
        return "cls.relnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionSchemasCte(builder);
        addDescriptionPart(builder, true);

        QueryBuilder subselect = new QueryBuilder()
                .column("pg_catalog.array_agg(attname ORDER BY attnum)")
                .from("pg_catalog.pg_attribute a")
                .where("a.attrelid = cls.oid")
                .where("a.attnum = ANY(res.tgattr)");

        builder
        .column("cls.relname")
        .column("p.proname")
        .column("nsp.nspname")
        .column("res.tgname")
        .column("res.tgtype")
        .column("res.tgenabled")
        .column("res.tgargs")
        .column("res.tgconstraint::bigint")
        .column("res.tgdeferrable")
        .column("res.tginitdeferred")
        .column("relcon.relname as refrelname")
        .column("refnsp.nspname as refnspname")
        .column("", subselect, "AS cols")
        .column("pg_catalog.pg_get_triggerdef(res.oid,false) AS definition")
        .from("pg_catalog.pg_trigger res")
        .join("LEFT JOIN pg_catalog.pg_class cls ON cls.oid = res.tgrelid")
        .join("LEFT JOIN pg_catalog.pg_class relcon ON relcon.oid = res.tgconstrrelid")
        .join("LEFT JOIN pg_catalog.pg_namespace refnsp ON refnsp.oid = relcon.relnamespace")
        .join("JOIN pg_catalog.pg_proc p ON p.oid = res.tgfoid")
        .join("JOIN pg_catalog.pg_namespace nsp ON p.pronamespace = nsp.oid")
        .where("cls.relkind IN ('r', 'f', 'p', 'm', 'v')")
        .where("res.tgisinternal = FALSE");

        if (SupportedPgVersion.VERSION_10.isLE(loader.getVersion())) {
            builder
            .column("res.tgoldtable")
            .column("res.tgnewtable");
        }

        if (SupportedPgVersion.VERSION_15.isLE(loader.getVersion())) {
            builder
            .column("res.tgparentid")
            .column("res.tgenabled")
            .join("LEFT JOIN pg_catalog.pg_trigger u ON u.oid = res.tgparentid")
            .where("res.tgparentid = 0 OR res.tgenabled != u.tgenabled");
        }
    }
}
