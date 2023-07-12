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
import java.util.List;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.CreateAggregate;
import ru.taximaxim.codekeeper.core.schema.AbstractPgFunction;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgAggregate;
import ru.taximaxim.codekeeper.core.schema.PgAggregate.AggFuncs;
import ru.taximaxim.codekeeper.core.schema.PgAggregate.AggKinds;
import ru.taximaxim.codekeeper.core.schema.PgAggregate.ModifyType;

/**
 * Reads AGGREGATEs from JDBC.
 */
public class AggregatesReader extends AbstractFunctionsReader {

    public AggregatesReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected AbstractPgFunction readFunction(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String funcName = res.getString("proname");
        loader.setCurrentObject(new GenericColumn(schemaName, funcName, DbObjType.AGGREGATE));
        PgAggregate aggregate = new PgAggregate(funcName);

        switch (res.getString("aggkind")) {
        case "o":
            aggregate.setKind(AggKinds.ORDERED);
            break;
        case "h":
            aggregate.setKind(AggKinds.HYPOTHETICAL);
            break;
        default:
            break;
        }

        //// The order is important for adding dependencies. Two steps.

        // First step: filling all types and arguments.
        fillArguments(aggregate, res);

        // Second step: filling other parameters of AGGREGATE.
        fillAggregate(aggregate, res);

        return aggregate;
    }

    private void fillAggregate(PgAggregate aggregate, ResultSet res) throws SQLException {
        // 'setDirectCount' must be first at this method, because of using 'directCount' later.
        if (AggKinds.NORMAL == aggregate.getKind()) {
            aggregate.setDirectCount(aggregate.getArguments().size());
        } else {
            int directCount = res.getInt("aggnumdirectargs");
            aggregate.setDirectCount(directCount);

            if (directCount == res.getInt("pronargs")) {
                // Explanation from documentation about this special case
                // (source: "https://www.postgresql.org/docs/11/sql-createaggregate.html").
                //
                // The syntax for ordered-set aggregates allows VARIADIC to be specified
                // for both the last direct parameter and the last aggregated (WITHIN GROUP)
                // parameter. However, the current implementation restricts use of VARIADIC
                // in two ways. First, ordered-set aggregates can only use VARIADIC "any",
                // not other variadic array types. Second, if the last direct parameter is
                // VARIADIC "any", then there can be only one aggregated parameter and it
                // must also be VARIADIC "any". (In the representation used in the system
                // catalogs, these two parameters are merged into a single VARIADIC "any"
                // item, since pg_proc cannot represent functions with more than one VARIADIC
                // parameter.) If the aggregate is a hypothetical-set aggregate, the direct
                // arguments that match the VARIADIC "any" parameter are the hypothetical
                // ones; any preceding parameters represent additional direct arguments
                // that are not constrained to match the aggregated arguments.

                // last argument must be VARIADIC "any"
                List<Argument> args = aggregate.getArguments();
                aggregate.addArgument(args.get(args.size() - 1));
            }
        }

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

        // since 9.6 PostgreSQL and default for greenplum
        if (SupportedVersion.VERSION_9_6.isLE(loader.version) || loader.isGreenplumDb) {
            aggregate.setCombineFunc(getProcessedName(aggregate, res.getString("combinefunc_nsp"),
                    res.getString("combinefunc"), AggFuncs.COMBINEFUNC));
            aggregate.setSerialFunc(getProcessedName(aggregate, res.getString("serialfunc_nsp"),
                    res.getString("serialfunc"), AggFuncs.SERIALFUNC));
            aggregate.setDeserialFunc(getProcessedName(aggregate, res.getString("deserialfunc_nsp"),
                    res.getString("deserialfunc"), AggFuncs.DESERIALFUNC));
        }
        // since 11 PostgreSQL
        if (SupportedVersion.VERSION_11.isLE(loader.version)) {
            aggregate.setFinalFuncModify(getModifyType(
                    res.getString("finalfunc_modify"), aggregate.getKind()));
            aggregate.setMFinalFuncModify(getModifyType(
                    res.getString("mfinalfunc_modify"), aggregate.getKind()));
        }

        JdbcType sType = loader.cachedTypesByOid.get(res.getLong("stype"));
        aggregate.setSType(sType.getFullName());
        sType.addTypeDepcy(aggregate);

        aggregate.setSSpace(res.getInt("sspace"));

        aggregate.setSFunc(getProcessedName(aggregate, res.getString("sfunc_nsp"),
                res.getString("sfunc"), AggFuncs.SFUNC));
        aggregate.setFinalFunc(getProcessedName(aggregate, res.getString("finalfunc_nsp"),
                res.getString("finalfunc"), AggFuncs.FINALFUNC));

        aggregate.setFinalFuncExtra(res.getBoolean("is_finalfunc_extra"));

        String initCond = res.getString("initcond");
        if (initCond != null) {
            aggregate.setInitCond(PgDiffUtils.quoteString(initCond));
        }

        // The parameter 'MSTYPE' must be processed before parameters 'MSFUNC',
        // 'MINVFUNC', 'MFINALFUNC', for correctly adding dependencies on the
        // functions 'MSFUNC', 'MINVFUNC', 'MFINALFUNC'.
        long mstype = res.getLong("mstype");
        if (mstype != 0) {
            JdbcType mSType = loader.cachedTypesByOid.get(mstype);
            aggregate.setMSType(mSType.getFullName());
            mSType.addTypeDepcy(aggregate);
        }


        aggregate.setMSFunc(getProcessedName(aggregate, res.getString("msfunc_nsp"),
                res.getString("msfunc"), AggFuncs.MSFUNC));
        aggregate.setMInvFunc(getProcessedName(aggregate, res.getString("minvfunc_nsp"),
                res.getString("minvfunc"), AggFuncs.MINVFUNC));

        aggregate.setMSSpace(res.getInt("msspace"));

        aggregate.setMFinalFunc(getProcessedName(aggregate, res.getString("mfinalfunc_nsp"),
                res.getString("mfinalfunc"), AggFuncs.MFINALFUNC));

        aggregate.setMFinalFuncExtra(res.getBoolean("is_mfinalfunc_extra"));

        String mInitCond = res.getString("minitcond");
        if (mInitCond != null) {
            aggregate.setMInitCond(PgDiffUtils.quoteString(mInitCond));
        }

        String sortOpName = res.getString("sortop");
        if (sortOpName != null) {
            String operSchemaName = res.getString("sortop_nsp");
            StringBuilder sb = new StringBuilder().append("OPERATOR(")
                    .append(PgDiffUtils.getQuotedName(operSchemaName))
                    .append('.').append(sortOpName).append(')');
            aggregate.setSortOp(sb.toString());

            aggregate.addDep(new GenericColumn(operSchemaName,
                    sortOpName + CreateAggregate.getSortOperSign(aggregate),
                    DbObjType.OPERATOR));
        }
    }

    private String getProcessedName(PgAggregate agg, String schemaName, String funcName, AggFuncs funcType) {
        if (funcName == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!Consts.PG_CATALOG.equalsIgnoreCase(schemaName)) {
            agg.addDep(new GenericColumn(schemaName,
                    funcName + CreateAggregate.getParamFuncSignature(agg, funcType), DbObjType.FUNCTION));
            sb.append(PgDiffUtils.getQuotedName(schemaName)).append('.');
        }
        sb.append(PgDiffUtils.getQuotedName(funcName));
        return sb.toString();
    }



    private ModifyType getModifyType(String modifier, AggKinds kind) {
        switch (modifier) {
        case "r":
            return AggKinds.NORMAL == kind ? null : ModifyType.READ_ONLY;
        case "s":
            return ModifyType.SHAREABLE;
        case "w":
            return AggKinds.NORMAL != kind ? null : ModifyType.READ_WRITE;
        default :
            throw new IllegalStateException("FinalFuncModifier '"+ modifier + "' doesn't support by AGGREGATE!");
        }
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        super.fillQueryBuilder(builder);

        builder
        .column("sfunc.proname AS sfunc")
        .column("sfunc_n.nspname AS sfunc_nsp")
        .column("a.aggtranstype AS stype")
        .column("a.aggtransspace AS sspace")
        .column("finalfn.proname AS finalfunc")
        .column("finalfn_n.nspname AS finalfunc_nsp")
        .column("a.aggfinalextra AS is_finalfunc_extra")
        .column("a.agginitval AS initcond")
        .column("msfunc.proname AS msfunc")
        .column("msfunc_n.nspname AS msfunc_nsp")
        .column("minvfunc.proname AS minvfunc")
        .column("minvfunc_n.nspname AS minvfunc_nsp")
        .column("a.aggmtranstype AS mstype")
        .column("a.aggmtransspace AS msspace")
        .column("mfinalfn.proname AS mfinalfunc")
        .column("mfinalfn_n.nspname AS mfinalfunc_nsp")
        .column("a.aggmfinalextra AS is_mfinalfunc_extra")
        .column("a.aggminitval AS minitcond")
        .column("sortop.oprname AS sortop")
        .column("sortop_n.nspname AS sortop_nsp")
        .column("a.aggkind")
        .column("a.aggnumdirectargs")
        .join("LEFT JOIN pg_catalog.pg_aggregate a ON a.aggfnoid = res.oid")
        .join("LEFT JOIN pg_catalog.pg_proc sfunc ON a.aggtransfn = sfunc.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace sfunc_n ON sfunc.pronamespace = sfunc_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc finalfn ON a.aggfinalfn = finalfn.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace finalfn_n ON finalfn.pronamespace = finalfn_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc msfunc ON a.aggmtransfn = msfunc.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace msfunc_n ON msfunc.pronamespace = msfunc_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc minvfunc ON a.aggminvtransfn = minvfunc.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace minvfunc_n ON minvfunc.pronamespace = minvfunc_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc mfinalfn ON a.aggmfinalfn = mfinalfn.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace mfinalfn_n ON mfinalfn.pronamespace = mfinalfn_n.oid")
        .join("LEFT JOIN pg_catalog.pg_operator sortop ON a.aggsortop = sortop.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace sortop_n ON sortop.oprnamespace = sortop_n.oid");

        if (SupportedVersion.VERSION_9_6.isLE(loader.version) || loader.isGreenplumDb) {
            builder
            .column("combinefn.proname AS combinefunc")
            .column("combinefn_n.nspname AS combinefunc_nsp")
            .column("serialfn.proname AS serialfunc")
            .column("serialfn_n.nspname AS serialfunc_nsp")
            .column("deserialfn.proname AS deserialfunc")
            .column("deserialfn_n.nspname AS deserialfunc_nsp")
            .join("LEFT JOIN pg_catalog.pg_proc combinefn ON a.aggcombinefn = combinefn.oid")
            .join("LEFT JOIN pg_catalog.pg_namespace combinefn_n ON combinefn.pronamespace = combinefn_n.oid")
            .join("LEFT JOIN pg_catalog.pg_proc serialfn ON a.aggserialfn = serialfn.oid")
            .join("LEFT JOIN pg_catalog.pg_namespace serialfn_n ON serialfn.pronamespace = serialfn_n.oid")
            .join("LEFT JOIN pg_catalog.pg_proc deserialfn ON a.aggdeserialfn = deserialfn.oid")
            .join("LEFT JOIN pg_catalog.pg_namespace deserialfn_n ON deserialfn.pronamespace = deserialfn_n.oid");
        }

        if (SupportedVersion.VERSION_11.isLE(loader.version)) {
            builder
            .column("a.aggfinalmodify AS finalfunc_modify")
            .column("a.aggmfinalmodify AS mfinalfunc_modify")
            .where("res.prokind = 'a'");
        } else {
            builder.where("res.proisagg");
        }
    }
}
