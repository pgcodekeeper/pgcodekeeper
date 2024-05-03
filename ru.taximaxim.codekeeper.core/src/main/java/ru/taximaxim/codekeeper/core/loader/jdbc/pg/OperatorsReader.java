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

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcType;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgOperator;

public class OperatorsReader extends JdbcReader {

    public OperatorsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String operSchemaName = schema.getName();
        String operName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(operSchemaName, operName, DbObjType.OPERATOR));
        PgOperator oper = new PgOperator(operName);

        loader.setOwner(oper, res.getLong("owner"));
        loader.setComment(oper, res);

        long leftArgType = res.getLong("leftArg");
        if (leftArgType > 0) {
            JdbcType leftType = loader.getCachedTypeByOid(leftArgType);
            oper.setLeftArg(leftType.getFullName());
            leftType.addTypeDepcy(oper);
        }

        long rightArgType = res.getLong("rightArg");
        if (rightArgType > 0) {
            JdbcType rightType = loader.getCachedTypeByOid(rightArgType);
            oper.setRightArg(rightType.getFullName());
            rightType.addTypeDepcy(oper);
        }

        long resultType = res.getLong("result");
        JdbcType returnsType = loader.getCachedTypeByOid(resultType);
        oper.setReturns(returnsType.getFullName());

        oper.setProcedure(getProcessedName(oper, res.getString("procedure_nsp"),
                res.getString("procedure")));

        String commutator = res.getString("commutator");
        if (commutator != null) {
            StringBuilder sb = new StringBuilder().append("OPERATOR(")
                    .append(PgDiffUtils.getQuotedName(res.getString("commutator_nsp")))
                    .append('.').append(commutator).append(')');
            oper.setCommutator(sb.toString());
        }

        String negator = res.getString("negator");
        if (negator != null) {
            StringBuilder sb = new StringBuilder().append("OPERATOR(")
                    .append(PgDiffUtils.getQuotedName(res.getString("negator_nsp")))
                    .append('.').append(negator).append(')');
            oper.setNegator(sb.toString());
        }

        if (res.getBoolean("is_merges")) {
            oper.setMerges(true);
        }

        if (res.getBoolean("is_hashes")) {
            oper.setHashes(true);
        }

        String restrFuncName = res.getString("restrict");
        if (restrFuncName != null) {
            oper.setRestrict(getProcessedName(oper, res.getString("restrict_nsp"), restrFuncName));
        }

        String joinFuncName = res.getString("join");
        if (joinFuncName != null) {
            oper.setJoin(getProcessedName(oper, res.getString("join_nsp"), joinFuncName));
        }

        loader.setAuthor(oper, res);
        schema.addOperator(oper);
    }

    private String getProcessedName(PgOperator oper, String schemaName, String funcName) {
        StringBuilder sb = new StringBuilder();
        if (!Consts.PG_CATALOG.equalsIgnoreCase(schemaName)) {
            sb.append(PgDiffUtils.getQuotedName(schemaName)).append('.');
            addDep(oper, schemaName, funcName + oper.getArguments(), DbObjType.FUNCTION);
        }
        sb.append(PgDiffUtils.getQuotedName(funcName));
        return sb.toString();
    }

    @Override
    protected String getClassId() {
        return "pg_operator";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.oprnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionDepsCte(builder);
        addDescriptionPart(builder);

        builder
        .column("res.oprname AS name")
        .column("prc.proname AS procedure")
        .column("prc_n.nspname AS procedure_nsp")
        .column("res.oprleft::bigint AS leftArg")
        .column("res.oprright::bigint AS rightArg")
        .column("res.oprresult::bigint AS result")
        .column("com.oprname AS commutator")
        .column("com_n.nspname AS commutator_nsp")
        .column("neg.oprname AS negator")
        .column("neg_n.nspname AS negator_nsp")
        .column("res.oprcanmerge AS is_merges")
        .column("res.oprcanhash AS is_hashes")
        .column("prc_r.proname AS restrict")
        .column("prc_r_n.nspname AS restrict_nsp")
        .column("prc_j.proname AS join")
        .column("prc_j_n.nspname AS join_nsp")
        .column("res.oprowner AS owner")
        .from("pg_catalog.pg_operator res")
        .join("JOIN pg_catalog.pg_proc prc ON res.oprcode = prc.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace prc_n ON prc.pronamespace = prc_n.oid")
        .join("LEFT JOIN pg_catalog.pg_operator com ON res.oprcom = com.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace com_n ON com.oprnamespace = com_n.oid")
        .join("LEFT JOIN pg_catalog.pg_operator neg ON res.oprnegate = neg.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace neg_n ON neg.oprnamespace = neg_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc prc_r ON res.oprrest = prc_r.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace prc_r_n ON prc_r.pronamespace = prc_r_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc prc_j ON res.oprjoin = prc_j.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace prc_j_n ON prc_j.pronamespace = prc_j_n.oid");
    }
}
