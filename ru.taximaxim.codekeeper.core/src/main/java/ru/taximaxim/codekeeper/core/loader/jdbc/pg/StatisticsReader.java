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

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.pg.SupportedPgVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateStatistics;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgStatistics;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class StatisticsReader extends JdbcReader {

    public StatisticsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String statisticsName = res.getString("stxname");
        loader.setCurrentObject(new GenericColumn(schemaName, statisticsName, DbObjType.STATISTICS));

        PgStatistics stat = new PgStatistics(statisticsName);

        String definition = res.getString("def");
        checkObjectValidity(definition, DbObjType.STATISTICS, statisticsName);
        loader.submitAntlrTask(definition + ';',
                p -> new Pair<>(p.sql().statement(0).schema_statement().schema_create()
                        .create_statistics_statement(), (CommonTokenStream) p.getTokenStream()),
                pair -> new CreateStatistics(pair.getFirst(), (PgDatabase) schema.getDatabase(), pair.getSecond(),
                        loader.getSettings())
                .parseStatistics(stat));

        if (SupportedPgVersion.VERSION_13.isLE(loader.getVersion())) {
            stat.setStatistics(res.getInt("stxstattarget"));
        }

        loader.setOwner(stat, res.getLong("stxowner"));
        loader.setAuthor(stat, res);
        loader.setComment(stat, res);

        schema.addChild(stat);
    }

    @Override
    protected String getClassId() {
        return "pg_statistic_ext";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.stxnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionSchemasCte(builder);
        addDescriptionPart(builder);

        builder
        .column("res.stxname")
        .column("res.stxowner")
        .column("pg_catalog.pg_get_statisticsobjdef(res.oid::pg_catalog.oid) AS def")
        .from("pg_catalog.pg_statistic_ext res");

        if (SupportedPgVersion.VERSION_13.isLE(loader.getVersion())) {
            builder.column("res.stxstattarget");
        }
    }
}
