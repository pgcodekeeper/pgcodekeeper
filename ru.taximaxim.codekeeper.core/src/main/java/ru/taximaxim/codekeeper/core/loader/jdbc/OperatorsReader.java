package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgOperator;

public class OperatorsReader extends JdbcReader {

    public OperatorsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_OPERATORS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String operSchemaName = schema.getName();
        String operName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(operSchemaName, operName, DbObjType.OPERATOR));
        PgOperator oper = new PgOperator(operName);

        // OWNER
        loader.setOwner(oper, res.getLong("owner"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            oper.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        long leftArgType = res.getLong("leftArg");
        if (leftArgType > 0) {
            JdbcType leftType = loader.cachedTypesByOid.get(leftArgType);
            oper.setLeftArg(leftType.getFullName());
            leftType.addTypeDepcy(oper);
        }

        long rightArgType = res.getLong("rightArg");
        if (rightArgType > 0) {
            JdbcType rightType = loader.cachedTypesByOid.get(rightArgType);
            oper.setRightArg(rightType.getFullName());
            rightType.addTypeDepcy(oper);
        }

        long resultType = res.getLong("result");
        JdbcType returnsType = loader.cachedTypesByOid.get(resultType);
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
            if (!Utils.isPgSystemSchema(schemaName)) {
                String name = funcName + oper.getArguments();
                oper.addDep(new GenericColumn(schemaName, name, DbObjType.FUNCTION));
            }
        }
        sb.append(PgDiffUtils.getQuotedName(funcName));
        return sb.toString();
    }

    @Override
    protected String getClassId() {
        return "pg_operator";
    }
}
