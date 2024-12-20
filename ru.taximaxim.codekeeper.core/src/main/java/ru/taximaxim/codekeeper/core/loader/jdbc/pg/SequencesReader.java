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

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.pg.SupportedPgVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgSequence;

public class SequencesReader extends JdbcReader {

    private static final Logger LOG = LoggerFactory.getLogger(SequencesReader.class);

    private static final int DATA_SELECT_LENGTH;

    public SequencesReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String sequenceName = res.getString("relname");
        loader.setCurrentObject(new GenericColumn(schema.getName(), sequenceName, DbObjType.SEQUENCE));
        PgSequence s = new PgSequence(sequenceName);

        String refTable = res.getString("referenced_table_name");
        String refColumn = res.getString("ref_col_name");

        if ("u".equals(res.getString("relpersistence"))) {
            s.setLogged(false);
        }

        String identityType = null;
        if (SupportedPgVersion.VERSION_10.isLE(loader.getVersion())) {
            identityType = res.getString("attidentity");
            if (identityType != null && identityType.isEmpty()) {
                // treat lack of table dependency and no identityType as a single case
                identityType = null;
            }
        }

        if (refTable != null && identityType == null) {
            s.setOwnedBy(new GenericColumn(schema.getName(), refTable,
                    res.getString("ref_col_name"), DbObjType.COLUMN));
        }

        if (identityType == null) {
            loader.setOwner(s, res.getLong("relowner"));
            // PRIVILEGES
            loader.setPrivileges(s, res.getString("aclarray"), schema.getName());
        }

        loader.setComment(s, res);

        if (SupportedPgVersion.VERSION_10.isLE(loader.getVersion())) {
            s.setStartWith(Long.toString(res.getLong("seqstart")));
            String dataType = loader.getCachedTypeByOid(res.getLong("data_type")).getFullName();
            s.setMinMaxInc(res.getLong("seqincrement"), res.getLong("seqmax"),
                    res.getLong("seqmin"), dataType, 0L);
            s.setCache(Long.toString(res.getLong("seqcache")));
            s.setCycle(res.getBoolean("seqcycle"));
            s.setDataType(dataType);
        }

        if ("d".equals(identityType) || "a".equals(identityType)) {
            AbstractTable table = schema.getTable(refTable);
            if (table == null) {
                LOG.error("Not found table {} for sequence {}", table, s);
                return;
            }
            PgColumn column = (PgColumn) table.getColumn(refColumn);
            if (column == null) {
                column = new PgColumn(refColumn);
                column.setInherit(true);
                table.addColumn(column);
            }
            column.setSequence(s);
            s.setParent(schema);
            column.setIdentityType("d".equals(identityType) ? "BY DEFAULT" : "ALWAYS") ;
        } else {
            loader.setAuthor(s, res);
            schema.addSequence(s);
        }
    }

    static {
        DATA_SELECT_LENGTH =
                // static part
                JdbcQueries.QUERY_SEQUENCES_DATA.length() +
                // dynamic part
                (",'test_id78901234567890123456789.test_id78901234567890123456789' qname"
                        + " FROM test_id78901234567890123456789.test_id78901234567890123456789 UNION ALL ").length();
    }

    public static void querySequencesData(AbstractDatabase db, JdbcLoaderBase loader)
            throws SQLException, InterruptedException {
        loader.setCurrentOperation("sequences data query");

        List<String> schemasAccess = new ArrayList<>();
        try (PreparedStatement schemasAccessQuery = loader.getConnection()
                .prepareStatement(JdbcQueries.QUERY_SCHEMAS_ACCESS)) {
            Array arrSchemas = loader.getConnection().createArrayOf("text",
                    db.getSchemas().stream().filter(s -> !s.getSequences().isEmpty()).map(AbstractSchema::getName).toArray());
            schemasAccessQuery.setArray(1, arrSchemas);
            try (ResultSet schemaRes = loader.getRunner().runScript(schemasAccessQuery)) {
                while (schemaRes.next()) {
                    String schema = schemaRes.getString("nspname");
                    Object hasPriv = schemaRes.getObject("has_priv");
                    JdbcReader.checkObjectValidity(hasPriv, DbObjType.SCHEMA, schema);

                    if ((boolean)hasPriv) {
                        schemasAccess.add(schema);
                    } else {
                        loader.addError("No USAGE privileges for schema " + schema +
                                ". SEQUENCE data will be missing.");
                    }
                }
            } finally {
                arrSchemas.free();
            }
        }

        Map<String, AbstractSequence> seqs = new HashMap<>();
        for (String schema : schemasAccess) {
            for (AbstractSequence seq : db.getSchema(schema).getSequences()) {
                seqs.put(seq.getQualifiedName(), seq);
            }
        }

        StringBuilder sbUnionQuery = new StringBuilder(DATA_SELECT_LENGTH * seqs.size());

        try (PreparedStatement accessQuery = loader.getConnection()
                .prepareStatement(JdbcQueries.QUERY_SEQUENCES_ACCESS)) {
            Array arrSeqs = loader.getConnection().createArrayOf("text", seqs.keySet().toArray());
            accessQuery.setArray(1, arrSeqs);
            try (ResultSet res = loader.getRunner().runScript(accessQuery)) {
                while (res.next()) {
                    String qname = res.getString("qname");
                    Object hasPriv = res.getObject("has_priv");
                    JdbcReader.checkObjectValidity(hasPriv, DbObjType.SEQUENCE, qname);

                    if ((boolean)hasPriv) {
                        if (sbUnionQuery.length() > 0) {
                            sbUnionQuery.append("\nUNION ALL\n");
                        }
                        sbUnionQuery.append(JdbcQueries.QUERY_SEQUENCES_DATA)
                        .append(',')
                        .append(PgDiffUtils.quoteString(qname))
                        .append(" qname FROM ")
                        .append(qname);
                    } else {
                        loader.addError("No SELECT privileges for sequence " + qname +
                                ". Its data will be missing.");
                    }
                }
            } finally {
                arrSeqs.free();
            }
        }
        if (sbUnionQuery.length() < 1) {
            return;
        }

        try (ResultSet res = loader.getRunner().runScript(loader.getStatement(), sbUnionQuery.toString())) {
            while (res.next()) {
                PgDiffUtils.checkCancelled(loader.getMonitor());
                AbstractSequence seq = seqs.get(res.getString("qname"));
                seq.setStartWith(res.getString("start_value"));
                seq.setMinMaxInc(res.getLong("increment_by"), res.getLong("max_value"),
                        res.getLong("min_value"), null, 0L);
                seq.setCache(res.getString("cache_value"));
                seq.setCycle(res.getBoolean("is_cycled"));
            }
        }
    }

    @Override
    protected String getClassId() {
        return "pg_class";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.relnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionDepsCte(builder);
        addDescriptionPart(builder, true);

        builder
        .column("res.relowner::bigint")
        .column("res.relname")
        .column("res.relpersistence")
        .column("(SELECT t.relname FROM pg_catalog.pg_class t WHERE t.oid=dep.refobjid) referenced_table_name")
        .column("a.attname AS ref_col_name")
        .column("res.relacl::text AS aclarray")
        .from("pg_catalog.pg_class res")
        .join("LEFT JOIN pg_catalog.pg_depend dep ON dep.classid = res.tableoid AND dep.objid = res.oid AND dep.objsubid = 0"
                + " AND dep.refclassid = res.tableoid AND dep.refobjsubid != 0 AND dep.deptype IN ('i', 'a')")
        .join("LEFT JOIN pg_catalog.pg_attribute a ON a.attrelid = dep.refobjid AND a.attnum = dep.refobjsubid AND a.attisdropped IS FALSE")
        .where("res.relkind = 'S'");

        if (SupportedPgVersion.VERSION_10.isLE(loader.getVersion())) {
            builder
            .column("s.seqtypid::bigint AS data_type")
            .column("s.seqstart")
            .column("s.seqincrement")
            .column("s.seqmax")
            .column("s.seqmin")
            .column("s.seqcache")
            .column("s.seqcycle")
            .column("a.attidentity")
            .join("LEFT JOIN pg_catalog.pg_sequence s ON s.seqrelid = res.oid");
        }

    }
}