package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgOperator;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class OperatorsReader extends JdbcReader {

    public OperatorsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_OPERATORS_PER_SCHEMA, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String operSchemaName = schema.getName();
        String operName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(operSchemaName, operName, DbObjType.OPERATOR));
        PgOperator oper = new PgOperator(operName, "");

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
            oper.setLeftArg(leftType.getFullName(operSchemaName));
            leftType.addTypeDepcy(oper);
        }

        long rightArgType = res.getLong("rightArg");
        if (rightArgType > 0) {
            JdbcType rightType = loader.cachedTypesByOid.get(rightArgType);
            oper.setRightArg(rightType.getFullName(operSchemaName));
            rightType.addTypeDepcy(oper);
        }

        String procFuncName = res.getString("procedure");
        String procFuncSchemaName = res.getString("procedure_nsp");
        oper.setProcedure(new StringBuilder(PgDiffUtils.getQuotedName(procFuncSchemaName))
                .append('.').append(PgDiffUtils.getQuotedName(procFuncName)).toString());
        oper.addDep(new GenericColumn(procFuncSchemaName,
                procFuncName + oper.appendOperatorArgs(new StringBuilder()).toString(),
                DbObjType.FUNCTION));

        String commutator = res.getString("commutator");
        if (comment != null) {
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

        String restrict = res.getString("restrict");
        if (restrict != null) {
            oper.setRestrict(restrict);
        }

        String join = res.getString("join");
        if (join != null) {
            oper.setJoin(join);
        }

        schema.addOperator(oper);
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.OPERATOR;
    }
}
