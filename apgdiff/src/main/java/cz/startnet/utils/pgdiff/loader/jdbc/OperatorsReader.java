package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgOperator;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class OperatorsReader extends JdbcReader {

    public OperatorsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_OPERATORS_PER_SCHEMA, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String operName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schemaName, operName, DbObjType.OPERATOR));
        PgOperator oper = new PgOperator(operName, "");

        // OWNER
        loader.setOwner(oper, res.getLong("owner"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            oper.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        String procName = res.getString("procedure");
        String procSchema = res.getString("procedure_nsp");
        oper.setProcedure(new StringBuilder(procSchema).append('.').append(procName).toString());
        oper.addDep(new GenericColumn(procSchema, procName, DbObjType.FUNCTION));

        long leftArgType = res.getLong("leftArg");
        if (leftArgType > 0) {
            JdbcType leftType = loader.cachedTypesByOid.get(leftArgType);
            oper.setLeftArg(new Argument(PgOperator.LEFTARG, leftType.getFullName(schemaName)));
            leftType.addTypeDepcy(oper);
        }

        long rightArgType = res.getLong("rightArg");
        if (rightArgType > 0) {
            JdbcType rightType = loader.cachedTypesByOid.get(rightArgType);
            oper.setRightArg(new Argument(PgOperator.RIGHTARG, rightType.getFullName(schemaName)));
            rightType.addTypeDepcy(oper);
        }

        String commutator = res.getString("commutator");
        if (comment != null) {
            oper.setCommutator(new StringBuilder("OPERATOR(").append(res.getString("commutator_nsp"))
                    .append('.').append(commutator).append(')').toString());
        }

        String negator = res.getString("negator");
        if (negator != null) {
            oper.setCommutator(new StringBuilder("OPERATOR(").append(res.getString("negator_nsp"))
                    .append('.').append(negator).append(')').toString());
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
