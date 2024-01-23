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
package ru.taximaxim.codekeeper.core.loader.jdbc.pg;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgCollation;

public class CollationsReader extends JdbcReader {

    public CollationsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String collName = res.getString("collname");
        loader.setCurrentObject(new GenericColumn(schemaName, collName, DbObjType.COLLATION));

        PgCollation coll = new PgCollation(collName);

        String lcCollate = res.getString("collcollate");
        if (lcCollate != null) {
            coll.setLcCollate(PgDiffUtils.quoteString(lcCollate));
        }
        String lcCtype = res.getString("collctype");
        if (lcCtype != null) {
            coll.setLcCtype(PgDiffUtils.quoteString(lcCtype));
        }

        loader.setComment(coll, res);

        if (SupportedVersion.VERSION_10.isLE(loader.getVersion())) {
            String provider = res.getString("collprovider");
            switch (provider) {
            case "c":
                coll.setProvider("libc");
                break;
            case "i":
                coll.setProvider("icu");
                if (SupportedVersion.VERSION_15.isLE(loader.getVersion())) {
                    String locale = res.getString("colliculocale");
                    if (locale != null) {
                        String quotedLocale = PgDiffUtils.quoteString(locale);
                        coll.setLcCollate(quotedLocale);
                        coll.setLcCtype(quotedLocale);
                    }
                }
                break;
            case "d":
                coll.setProvider("default");
                break;
            }
        }
        if (SupportedVersion.VERSION_12.isLE(loader.getVersion())) {
            coll.setDeterministic(res.getBoolean("collisdeterministic"));
        }

        if (SupportedVersion.VERSION_16.isLE(loader.getVersion())) {
            String rules = res.getString("collicurules");
            if (rules != null) {
                coll.setRules(PgDiffUtils.quoteString(rules));
            }
        }

        loader.setOwner(coll, res.getLong("collowner"));
        loader.setAuthor(coll, res);

        schema.addCollation(coll);
    }

    @Override
    protected String getClassId() {
        return "pg_collation";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.collnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addSysSchemasCte(builder);
        addExtensionDepsCte(builder);
        addDescriptionPart(builder);

        builder
        .column("res.collname")
        .column("res.collcollate")
        .column("res.collctype")
        .column("res.collowner::bigint")
        .from("pg_catalog.pg_collation res");

        if (SupportedVersion.VERSION_10.isLE(loader.getVersion())) {
            builder.column("res.collprovider");
        }

        if (SupportedVersion.VERSION_12.isLE(loader.getVersion())) {
            builder.column("res.collisdeterministic");
        }

        if (SupportedVersion.VERSION_15.isLE(loader.getVersion())) {
            builder.column("res.colliculocale");
        }

        if (SupportedVersion.VERSION_16.isLE(loader.getVersion())) {
            builder.column("res.collicurules");
        }
    }
}
