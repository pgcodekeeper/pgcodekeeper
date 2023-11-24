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
package ru.taximaxim.codekeeper.core.loader.jdbc.pg;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgEventTrigger;

public class EventTriggersReader extends AbstractStatementReader {

    private final PgDatabase db;

    public EventTriggersReader(JdbcLoaderBase loader, PgDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException, XmlReaderException {
        String evtName = res.getString("evtname");
        loader.setCurrentObject(new GenericColumn(evtName, DbObjType.EVENT_TRIGGER));

        PgEventTrigger evt = new PgEventTrigger(evtName);
        evt.setEvent(res.getString("evtevent"));

        switch (res.getString("evtenabled")) {
        case "D":
            evt.setMode("DISABLE");
            break;
        case "R":
            evt.setMode("ENABLE REPLICA");
            break;
        case "A":
            evt.setMode("ENABLE ALWAYS");
            break;
        }

        String[] tags = JdbcReader.getColArray(res, "evttags");
        if (tags != null) {
            for (String tag : tags) {
                evt.addTag(PgDiffUtils.quoteString(tag));
            }
        }

        String funcName = res.getString("proname");
        String funcSchema = res.getString("nspname");
        evt.setExecutable(funcSchema + '.' + funcName + "()");
        evt.addDep(new GenericColumn(funcSchema, funcName + "()", DbObjType.FUNCTION));

        loader.setOwner(evt, res.getString("rolname"));
        loader.setComment(evt, res);
        loader.setAuthor(evt, res);
        db.addEventTrigger(evt);
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addDescriptionPart(builder);
        addExtensionDepsCte(builder);

        builder.column("res.evtname")
        .column("res.evtevent")
        .column("res.evtenabled")
        .column("res.evttags")
        .column("nsp.nspname")
        .column("p.proname")
        .column("o.rolname")
        .from("pg_catalog.pg_event_trigger res")
        .join("JOIN pg_catalog.pg_roles o ON o.oid = res.evtowner")
        .join("JOIN pg_catalog.pg_proc p ON p.oid = res.evtfoid")
        .join("JOIN pg_catalog.pg_namespace nsp ON p.pronamespace = nsp.oid");
    }

    @Override
    protected String getClassId() {
        return "pg_event_trigger";
    }
}
