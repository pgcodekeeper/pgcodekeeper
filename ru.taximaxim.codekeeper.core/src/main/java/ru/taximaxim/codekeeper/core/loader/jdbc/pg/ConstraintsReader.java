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

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterTable;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraint;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintCheck;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintExclude;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintFk;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintPk;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgIndexParamContainer;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class ConstraintsReader extends JdbcReader {

    private static final String ADD_CONSTRAINT = "ALTER TABLE noname ADD CONSTRAINT noname ";

    public ConstraintsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        if (SupportedVersion.VERSION_11.isLE(loader.getVersion()) && res.getInt("conparentid") != 0) {
            return;
        }

        String tableName = res.getString("relname");
        PgStatementContainer cont = schema.getStatementContainer(tableName);
        if (cont == null) {
            return;
        }

        String schemaName = schema.getName();
        String constraintName = res.getString("conname");
        String[] params = getColArray(res, "reloptions");
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, constraintName, DbObjType.CONSTRAINT));
        PgConstraint constr;

        String type = res.getString("contype");
        switch (type) {
        case "p":
        case "u":
            constr = new PgConstraintPk(constraintName, "p".equals(type));
            ((PgConstraintPk) constr).setClustered(res.getBoolean("isclustered"));
            break;
        case "f":
            constr = new PgConstraintFk(constraintName);
            break;
        case "c":
            constr = new PgConstraintCheck(constraintName);
            break;
        case "x":
            constr = new PgConstraintExclude(constraintName);
            break;
        default:
            throw new IllegalArgumentException("Unsupportes constraint's type " + type);
        }

        if (params != null) {
            ParserAbstract.fillOptionParams(params, ((PgIndexParamContainer) constr)::addParam, false, false, false);
        }

        String definition = res.getString("definition");
        checkObjectValidity(definition, DbObjType.CONSTRAINT, constraintName);
        String tablespace = res.getString("spcname");
        loader.submitAntlrTask(ADD_CONSTRAINT + definition + ';',
                p -> new Pair<>(p.sql().statement(0).schema_statement().schema_alter()
                        .alter_table_statement().table_action(0), (CommonTokenStream) p.getTokenStream()),
                pair -> new AlterTable(null, (PgDatabase) schema.getDatabase(), tablespace, pair.getSecond())
                .parseAlterTableConstraint(
                        pair.getFirst(), constr, schemaName, tableName, loader.getCurrentLocation()));
        loader.setAuthor(constr, res);
        loader.setComment(constr, res);

        cont.addConstraint(constr);
    }

    @Override
    protected String getClassId() {
        return "pg_constraint";
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
        .column("res.conname")
        .column("res.contype")
        .column("ts.spcname")
        .column("ci.reloptions")
        .column("pg_catalog.pg_get_constraintdef(res.oid) AS definition")
        .column("idx.indisclustered as isclustered")
        .from("pg_catalog.pg_constraint res")
        .join("LEFT JOIN pg_catalog.pg_class ccc ON ccc.oid = res.conrelid")
        .join("LEFT JOIN pg_catalog.pg_class cf ON cf.oid = res.confrelid")
        .join("LEFT JOIN pg_catalog.pg_class ci ON ci.oid = res.conindid AND res.contype != 'f'")
        .join("LEFT JOIN pg_catalog.pg_tablespace ts ON ts.oid = ci.reltablespace")
        .join("LEFT JOIN pg_catalog.pg_index idx ON idx.indexrelid = ci.oid")
        .where("ccc.relkind IN ('r', 'p', 'f')")
        .where("res.contype != 't'")
        .where("res.coninhcount = 0");

        if (SupportedVersion.VERSION_11.isLE(loader.getVersion())) {
            builder.column("res.conparentid::bigint");
        }
    }
}
