package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class SequencesReader extends JdbcReader {

    public static class SequencesReaderFactory extends JdbcReaderFactory {

        public SequencesReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new SequencesReader(this, loader);
        }
    }

    private static final int DATA_SELECT_LENGTH;

    private SequencesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSetWrapper res, PgSchema schema) throws WrapperAccessException {
        loader.monitor.worked(1);
        String sequenceName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schema.getName(), sequenceName, DbObjType.SEQUENCE));
        PgSequence s = new PgSequence(sequenceName, "");

        String refTable = res.getString("referenced_table_name");
        String refColumn = res.getString("ref_col_name");

        String identityType = null;
        if (SupportedVersion.VERSION_10.checkVersion(loader.version)) {
            identityType = res.getString("attidentity");
        }

        if (refTable != null && (identityType == null
                || (!"d".equals(identityType) && !"a".equals(identityType)))) {
            s.setOwnedBy(PgDiffUtils.getQuotedName(refTable) + '.'
                    + PgDiffUtils.getQuotedName(res.getString("ref_col_name")));
        }

        if (identityType == null) {
            loader.setOwner(s, res.getLong(CLASS_RELOWNER));
            // PRIVILEGES
            loader.setPrivileges(s, PgDiffUtils.getQuotedName(sequenceName), res.getString("aclarray"),
                    s.getOwner(), null, schema.getName());
        }

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            s.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        if (SupportedVersion.VERSION_10.checkVersion(loader.version)) {
            s.setStartWith(res.getString("seqstart"));
            s.setMinMaxInc(res.getLong("seqincrement"), res.getLong("seqmax"), res.getLong("seqmin"));
            s.setCache(res.getString("seqcache"));
            s.setCycle(res.getBoolean("seqcycle"));
            if (identityType == null) {
                s.setDataType(loader.cachedTypesByOid.get(res.getLong("data_type")).getFullName(schema.getName()));
            }
        }

        if ("d".equals(identityType) || "a".equals(identityType)) {
            PgTable table = schema.getTable(refTable);
            PgColumn column = table.getColumn(refColumn);
            if (column == null) {
                column = new PgColumn(refColumn);
                column.setInherit(true);
                table.addColumn(column);
            }
            column.setSequence(s);
            column.setIdentityType("d".equals(identityType) ? "BY DEFAULT" : "ALWAYS") ;
        } else {
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

    public static void querySequencesData(PgDatabase db, JdbcLoaderBase loader) throws SQLException, InterruptedException {
        loader.setCurrentOperation("sequences data query");

        List<String> schemasAccess = new ArrayList<>();
        try (PreparedStatement schemasAccessQuery = loader.connection.prepareStatement(JdbcQueries.QUERY_SCHEMAS_ACCESS)) {
            Array arrSchemas = loader.connection.createArrayOf("text",
                    db.getSchemas().stream().filter(s -> !s.getSequences().isEmpty()).map(PgSchema::getName).toArray());
            schemasAccessQuery.setArray(1, arrSchemas);
            try (ResultSet schemaRes = loader.runner.runScript(schemasAccessQuery)) {
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

        Map<String, PgSequence> seqs = new HashMap<>();
        for (String schema : schemasAccess) {
            for (PgSequence seq : db.getSchema(schema).getSequences()) {
                seqs.put(seq.getQualifiedName(), seq);
            }
        }

        StringBuilder sbUnionQuery = new StringBuilder(DATA_SELECT_LENGTH * seqs.size());

        try (PreparedStatement accessQuery = loader.connection.prepareStatement(JdbcQueries.QUERY_SEQUENCES_ACCESS)) {
            Array arrSeqs = loader.connection.createArrayOf("text", seqs.keySet().toArray());
            accessQuery.setArray(1, arrSeqs);
            try (ResultSet res = loader.runner.runScript(accessQuery)) {
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

        try (ResultSet res = loader.runner.runScript(loader.statement, sbUnionQuery.toString())) {
            while (res.next()) {
                PgSequence seq = seqs.get(res.getString("qname"));
                seq.setStartWith(res.getString("start_value"));
                seq.setMinMaxInc(res.getLong("increment_by"), res.getLong("max_value"), res.getLong("min_value"));
                seq.setCache(res.getString("cache_value"));
                seq.setCycle(res.getBoolean("is_cycled"));
            }
        }
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.SEQUENCE;
    }
}