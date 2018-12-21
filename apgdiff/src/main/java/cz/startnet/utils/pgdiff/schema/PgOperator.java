package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgOperator extends PgStatementWithSearchPath {

    private String procedure;
    private String leftArg;
    private String rightArg;
    private String commutator;
    private String negator;
    private boolean isMerges;
    private boolean isHashes;
    private String restrict;
    private String join;

    public PgOperator(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.OPERATOR;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE OPERATOR ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        sbSQL.append(getBareName());
        sbSQL.append(" (\n\tPROCEDURE = ");
        sbSQL.append(procedure);

        if (leftArg != null) {
            sbSQL.append(",\n\tLEFTARG = ");
            sbSQL.append(leftArg);
        }

        if (rightArg != null) {
            sbSQL.append(",\n\tRIGHTARG = ");
            sbSQL.append(rightArg);
        }

        if (commutator != null) {
            sbSQL.append(",\n\tCOMMUTATOR = ");
            sbSQL.append(commutator);
        }

        if (negator != null) {
            sbSQL.append(",\n\tNEGATOR = ");
            sbSQL.append(negator);
        }

        if (isMerges) {
            sbSQL.append(",\n\tMERGES");
        }

        if (isHashes) {
            sbSQL.append(",\n\tHASHES");
        }

        if (restrict != null) {
            sbSQL.append(",\n\tRESTRICT = ");
            sbSQL.append(restrict);
        }

        if (join != null) {
            sbSQL.append(",\n\tJOIN = ");
            sbSQL.append(join);
        }

        sbSQL.append("\n);");

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        final StringBuilder sbString = new StringBuilder();
        sbString.append("DROP OPERATOR ");
        sbString.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        appendOperatorSignature(sbString);
        sbString.append(';');
        return sbString.toString();
    }

    public StringBuilder appendOperatorSignature(StringBuilder sb) {
        sb.append(getBareName());
        return appendOperatorArgs(sb);
    }

    public StringBuilder appendOperatorArgs(StringBuilder sb) {
        sb.append('(');
        sb.append(leftArg == null ? "NONE" : leftArg);
        sb.append(", ");
        sb.append(rightArg == null ? "NONE" : rightArg);
        sb.append(')');
        return sb;
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgOperator newOperator;
        if (newCondition instanceof PgOperator) {
            newOperator = (PgOperator)newCondition;
        } else {
            return false;
        }

        if (!compareUnalterable(newOperator)) {
            isNeedDepcies.set(true);
            return true;
        }

        String newOperRestr = newOperator.getRestrict();
        String newOperJoin = newOperator.getJoin();
        boolean restrChanged = !Objects.equals(restrict, newOperRestr);
        boolean joinChanged = !Objects.equals(join, newOperJoin);
        if (restrChanged || joinChanged) {
            sb.append("\n\nALTER OPERATOR ")
            .append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.')
            .append(getName())
            .append("\n\tSET (");
            if (restrChanged) {
                sb.append("RESTRICT = ").append(newOperRestr != null ? newOperRestr : "NONE");
                if (joinChanged) {
                    sb.append(", ");
                }
            }
            if (joinChanged) {
                sb.append("JOIN = ").append(newOperJoin != null ? newOperJoin : "NONE");
            }
            sb.append(");");
        }

        if (!Objects.equals(getOwner(), newOperator.getOwner())) {
            newOperator.alterOwnerSQL(sb);
        }

        if (!Objects.equals(getComment(), newOperator.getComment())) {
            sb.append("\n\n");
            newOperator.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    private boolean compareUnalterable(PgOperator oper) {
        return Objects.equals(procedure, oper.getProcedure())
                && Objects.equals(leftArg, oper.getLeftArg())
                && Objects.equals(rightArg, oper.getRightArg())
                && Objects.equals(commutator, oper.getCommutator())
                && Objects.equals(negator, oper.getNegator())
                && isMerges == oper.isMerges()
                && isHashes == oper.isHashes();
    }

    /**
     * Alias for {@link #getSignature()} which provides a unique operator ID.
     *
     * Use {@link #getBareName()} to get just the operator name.
     */
    @Override
    public String getName() {
        return getSignature();
    }

    public String getSignature() {
        return appendOperatorSignature(new StringBuilder()).toString();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgOperator && super.compare(obj)) {
            PgOperator oper  = (PgOperator) obj;
            return compareUnalterable(oper)
                    && Objects.equals(restrict, oper.getRestrict())
                    && Objects.equals(join, oper.getJoin());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(getProcedure());
        hasher.put(getLeftArg());
        hasher.put(getRightArg());
        hasher.put(getCommutator());
        hasher.put(getNegator());
        hasher.put(isMerges());
        hasher.put(isHashes());
        hasher.put(getRestrict());
        hasher.put(getJoin());
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
        resetHash();
    }

    public String getLeftArg() {
        return leftArg;
    }

    public void setLeftArg(String leftArg) {
        this.leftArg = leftArg;
        resetHash();
    }

    public String getRightArg() {
        return rightArg;
    }

    public void setRightArg(String rightArg) {
        this.rightArg = rightArg;
        resetHash();
    }

    public String getCommutator() {
        return commutator;
    }

    public void setCommutator(String commutator) {
        this.commutator = commutator;
        resetHash();
    }

    public String getNegator() {
        return negator;
    }

    public void setNegator(String negator) {
        this.negator = negator;
        resetHash();
    }

    public boolean isMerges() {
        return isMerges;
    }

    public void setMerges(boolean isMerges) {
        this.isMerges = isMerges;
        resetHash();
    }

    public boolean isHashes() {
        return isHashes;
    }

    public void setHashes(boolean isHashes) {
        this.isHashes = isHashes;
        resetHash();
    }

    public String getRestrict() {
        return restrict;
    }

    public void setRestrict(String restrict) {
        this.restrict = restrict;
        resetHash();
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
        resetHash();
    }

    @Override
    public PgOperator shallowCopy() {
        PgOperator operatorDst = new PgOperator(getBareName());
        copyBaseFields(operatorDst);
        operatorDst.setProcedure(getProcedure());
        operatorDst.setLeftArg(getLeftArg());
        operatorDst.setRightArg(getRightArg());
        operatorDst.setCommutator(getCommutator());
        operatorDst.setNegator(getNegator());
        operatorDst.setMerges(isMerges());
        operatorDst.setHashes(isHashes());
        operatorDst.setRestrict(getRestrict());
        operatorDst.setJoin(getJoin());
        return operatorDst;
    }

    @Override
    public PgOperator deepCopy() {
        return shallowCopy();
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }
}
