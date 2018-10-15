package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgOperator extends PgStatementWithSearchPath {

    public static final String LEFTARG = "LEFTARG";
    public static final String RIGHTARG = "RIGHTARG";
    public static final String TYPE_NONE = "NONE";

    private String procedure;
    private Argument leftArg = new Argument(LEFTARG, TYPE_NONE);
    private Argument rightArg = new Argument(RIGHTARG, TYPE_NONE);
    private String commutator;
    private String negator;
    private boolean isMerges;
    private boolean isHashes;
    private String restrict;
    private String join;

    public PgOperator(String name, String rawStatement) {
        super(name, rawStatement);
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
        sbSQL.append(PgDiffUtils.getQuotedName(getBareName()));
        sbSQL.append('(');
        sbSQL.append("\n\tPROCEDURE = ");
        sbSQL.append(procedure);

        if (!TYPE_NONE.equals(leftArg.getDataType())) {
            sbSQL.append(",\n\t");
            sbSQL.append(leftArg.getName());
            sbSQL.append(" = ");
            sbSQL.append(leftArg.getDataType());
        }

        if (!TYPE_NONE.equals(rightArg.getDataType())) {
            sbSQL.append(",\n\t");
            sbSQL.append(rightArg.getName());
            sbSQL.append(" = ");
            sbSQL.append(rightArg.getDataType());
        }

        if (commutator != null) {
            sbSQL.append(",\n\tCOMMUTATOR = OPERATOR(");
            sbSQL.append(commutator);
            sbSQL.append(')');
        }

        if (negator != null) {
            sbSQL.append(",\n\tNEGATOR = OPERATOR(");
            sbSQL.append(negator);
            sbSQL.append(')');
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
        sb.append(PgDiffUtils.getQuotedName(getBareName()));
        sb.append(" (");
        sb.append(leftArg.getDataType());
        sb.append(", ");
        sb.append(rightArg.getDataType());
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

        if (!checkForChanges(newOperator)) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(getOwner(), newOperator.getOwner())) {
            sb.append(newOperator.getOwnerSQL());
        }
        alterPrivileges(newOperator, sb);
        if (!Objects.equals(getComment(), newOperator.getComment())) {
            sb.append("\n\n");
            newOperator.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    public boolean checkForChanges(PgOperator oper) {
        boolean equals = false;

        if (this == oper) {
            equals = true;
        } else {
            equals = Objects.equals(name, oper.getBareName())
                    && Objects.equals(procedure, oper.getProcedure())
                    && leftArg.equals(oper.getLeftArg())
                    && rightArg.equals(oper.getRightArg())
                    && Objects.equals(commutator, oper.getCommutator())
                    && Objects.equals(negator, oper.getNegator())
                    && isMerges == oper.isMerges()
                    && isHashes == oper.isHashes()
                    && Objects.equals(restrict, oper.getRestrict())
                    && Objects.equals(join, oper.getJoin());
        }
        return equals;
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

        if (obj instanceof PgOperator) {
            PgOperator oper  = (PgOperator) obj;
            if (!checkForChanges(oper)) {
                return false;
            }
            return Objects.equals(owner, oper.getOwner())
                    && Objects.equals(grants, oper.grants)
                    && Objects.equals(revokes, oper.revokes)
                    && Objects.equals(comment, oper.getComment());
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(getGrants());
        hasher.putOrdered(getRevokes());
        hasher.put(getBareName());
        hasher.put(getProcedure());
        hasher.put(getLeftArg());
        hasher.put(getRightArg());
        hasher.put(getCommutator());
        hasher.put(getNegator());
        hasher.put(isMerges());
        hasher.put(isHashes());
        hasher.put(getRestrict());
        hasher.put(getJoin());
        hasher.put(getOwner());
        hasher.put(getComment());
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
        resetHash();
    }

    public Argument getLeftArg() {
        return leftArg;
    }

    public void setLeftArg(Argument leftArg) {
        this.leftArg = leftArg;
        resetHash();
    }

    public Argument getRightArg() {
        return rightArg;
    }

    public void setRightArg(Argument rightArg) {
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
        PgOperator copy = new PgOperator(getBareName(), getRawStatement());
        copy.setProcedure(getProcedure());
        copy.setLeftArg(getLeftArg());
        copy.setRightArg(getRightArg());
        copy.setCommutator(getCommutator());
        copy.setNegator(getNegator());
        copy.setMerges(isMerges());
        copy.setHashes(isHashes());
        copy.setRestrict(getRestrict());
        copy.setJoin(getJoin());
        copy.setComment(getComment());
        for (PgPrivilege priv : revokes) {
            copy.addPrivilege(priv);
        }
        for (PgPrivilege priv : grants) {
            copy.addPrivilege(priv);
        }
        copy.setOwner(getOwner());
        copy.deps.addAll(deps);
        copy.setLocation(getLocation());

        return copy;
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
