package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgAggregate;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AggregatesReader extends JdbcReader {

    public AggregatesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_AGGREGATES, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        if (!res.getBoolean("proisagg")) {
            return;
        }
        String schemaName = schema.getName();
        String funcName = res.getString("proname");

        loader.setCurrentObject(new GenericColumn(schemaName, funcName, DbObjType.AGGREGATE));
        PgAggregate aggr = new PgAggregate(funcName, "");
        fillArguments(aggr, res);
        fillAggregate(aggr, res);

        // OWNER
        loader.setOwner(aggr, res.getLong("proowner"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            aggr.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        // RETURN TYPE
        JdbcType returnType = loader.cachedTypesByOid.get(res.getLong("prorettype"));
        aggr.setReturns(returnType.getFullName());
        returnType.addTypeDepcy(aggr);

        // PRIVILEGES
        loader.setPrivileges(aggr, res.getString("aclarray"), schemaName);

        schema.addAggregate(aggr);
    }

    private void fillArguments(PgAggregate aggregate, ResultSet res) throws SQLException {
        String[] argModes = getColArray(res, "proargmodes");
        String[] argNames = getColArray(res, "proargnames");
        Long[] argTypeOids = getColArray(res, "proallargtypes");

        Long[] argTypes = argTypeOids != null ? argTypeOids : getColArray(res, "argtypes");
        for (int i = 0; argTypes.length > i; i++) {
            String aMode = argModes != null ? argModes[i] : "i";

            JdbcType returnType = loader.cachedTypesByOid.get(argTypes[i]);
            returnType.addTypeDepcy(aggregate);

            aMode = "i".equals(aMode) ? "IN" : "VARIADIC" ;

            // these require resetHash functionality for defaults
            Argument a = aggregate.new PgArgument(aMode, argNames != null ? argNames[i] : null,
                    loader.cachedTypesByOid.get(argTypes[i]).getFullName());

            aggregate.addArgument(a);
        }
    }

    private void fillAggregate(PgAggregate aggregate, ResultSet res) throws SQLException {
        // since 9.6 PostgreSQL
        // parallel mode: s - safe, r - restricted, u - unsafe
        if (SupportedVersion.VERSION_9_6.isLE(loader.version)) {
            String parMode = res.getString("proparallel");
            switch (parMode) {
            case "s":
                aggregate.setParallel("SAFE");
                break;
            case "r":
                aggregate.setParallel("RESTRICTED");
                break;
            default :
                break;
            }
        }

        aggregate.setSFunc(getProcessedName(res.getString("sfunc_nsp"), res.getString("sfunc")));
        aggregate.setSType(res.getString("stype"));
        aggregate.setFinalFuncModify(res.getString("finalfunc_modify"));
        aggregate.setMFinalFuncModify(res.getString("mfinalfunc_modify"));

        String kind = res.getString("aggkind");
        aggregate.setKind(kind);

        if ("h".equals(kind)) {
            aggregate.setHypothetical(true);
        }

        String sspace = res.getString("sspace");
        if (sspace != null) {
            aggregate.setSSpace(Long.parseLong(sspace));
        }

        String finalfunc = res.getString("finalfunc");
        if (finalfunc != null) {
            aggregate.setFinalFunc(getProcessedName(res.getString("finalfunc_nsp"), finalfunc));
        }

        if (res.getBoolean("is_finalfunc_extra")) {
            aggregate.setFinalFuncExtra(true);
        }

        String combinefunc = res.getString("combinefunc");
        if (combinefunc != null) {
            aggregate.setCombineFunc(getProcessedName(res.getString("combinefunc_nsp"), combinefunc));
        }

        String serialfanc = res.getString("serialfanc");
        if (serialfanc != null) {
            aggregate.setSerialFunc(getProcessedName(res.getString("serialfanc_nsp"), serialfanc));
        }

        String deserialfunc = res.getString("deserialfunc");
        if (deserialfunc != null) {
            aggregate.setDeserialFunc(getProcessedName(res.getString("deserialfunc_nsp"), deserialfunc));
        }

        String initCond = res.getString("initcond");
        if (initCond != null) {
            aggregate.setInitCond(initCond);
        }

        String msfunc = res.getString("msfunc");
        if (deserialfunc != null) {
            aggregate.setMSFunc(getProcessedName(res.getString("msfunc_nsp"), msfunc));
        }

        String minvfunc = res.getString("minvfunc");
        if (minvfunc != null) {
            aggregate.setMInvFunc(getProcessedName(res.getString("minvfunc_nsp"), minvfunc));
        }

        String mstype = res.getString("mstype");
        if (mstype != null) {
            aggregate.setMSType(res.getString("mstype"));
        }

        String msspace = res.getString("msspace");
        if (sspace != null) {
            aggregate.setMSSpace(Long.parseLong(msspace));
        }

        String mfinalfunc = res.getString("mfinalfunc");
        if (mfinalfunc != null) {
            aggregate.setMFinalFunc(getProcessedName(res.getString("mfinalfunc_nsp"), mfinalfunc));
        }

        if (res.getBoolean("is_mfinalfunc_extra")) {
            aggregate.setMFinalFuncExtra(true);
        }

        String mInitCond = res.getString("minitcond");
        if (mInitCond != null) {
            aggregate.setMInitCond(mInitCond);
        }

        String sortOp = res.getString("sortop");
        if (mfinalfunc != null) {
            aggregate.setSortOp(getProcessedName(res.getString("sortop_nsp"), sortOp));
        }
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.AGGREGATE;
    }
}
