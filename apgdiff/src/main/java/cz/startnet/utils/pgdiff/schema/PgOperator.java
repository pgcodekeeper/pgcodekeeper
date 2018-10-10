package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public class PgOperator extends AbstractFunction {

    public static final String LEFTARG = "LEFTARG";
    public static final String RIGHTARG = "RIGHTARG";
    public static final String TYPE_NONE = "NONE";

    private String procedure;
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
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE OPERATOR ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        sbSQL.append(getBareName());
        sbSQL.append('(');
        sbSQL.append("\n\tPROCEDURE = ");
        sbSQL.append(procedure);

        for (Argument arg : arguments) {
            if (!TYPE_NONE.equals(arg.getDataType())) {
                sbSQL.append(",\n\t");
                sbSQL.append(arg.getName());
                sbSQL.append(" = ");
                sbSQL.append(arg.getDataType());
            }
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
        sbString.append(getBareName());
        sbString.append(" (");
        arguments.stream().map(Argument::getDataType).collect(Collectors.joining(","));
        sbString.append(");");
        return sbString.toString();
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

    @Override
    public String getDeclaration(Argument arg, boolean includeDefaultValue, boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        String name = arg.getName();

        if (name != null && !name.isEmpty() && includeArgName) {
            sbString.append(PgDiffUtils.getQuotedName(name));
            sbString.append(' ');
        }

        sbString.append(arg.getDataType());

        return sbString.toString();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgOperator && super.compare(obj)) {
            PgOperator oper = (PgOperator) obj;
            return Objects.equals(getProcedure(), oper.getProcedure())
                    && Objects.equals(getCommutator(), oper.getCommutator())
                    && Objects.equals(getNegator(), oper.getNegator())
                    && isMerges == oper.isMerges()
                    && isHashes == oper.isHashes()
                    && Objects.equals(getRestrict(), oper.getRestrict())
                    && Objects.equals(getJoin(), oper.getJoin());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getProcedure());
        hasher.put(getCommutator());
        hasher.put(getNegator());
        hasher.put(isMerges());
        hasher.put(isHashes());
        hasher.put(getRestrict());
        hasher.put(getJoin());
    }

    @Override
    protected AbstractFunction getFunctionCopy() {
        PgOperator oper = new PgOperator(getBareName(), getRawStatement());
        oper.setProcedure(getProcedure());
        oper.setCommutator(getCommutator());
        oper.setNegator(getNegator());
        oper.setMerges(isMerges());
        oper.setHashes(isHashes());
        oper.setRestrict(getRestrict());
        oper.setJoin(getJoin());
        return oper;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
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
}
