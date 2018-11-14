package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgAggregate extends PgStatementWithSearchPath {

    private final List<Argument> arguments = new ArrayList<>();
    private final List<Argument> orderByArgs = new ArrayList<>();

    private String baseType;
    private String sFunc;
    private String sType;
    private long sSpace;
    private String finalFunc;
    private boolean isFinalFuncExtra;
    private String finalFuncModify;
    private String combineFunc;
    private String serialFunc;
    private String deserialFunc;
    private String initCond;
    private String mSFunc;
    private String mInvFunc;
    private String mSType;
    private long mSSpace;
    private String mFinalFunc;
    private boolean isMFinalFuncExtra;
    private String mFinalFuncModify;
    private String mInitCond;
    private String sortOp;
    private String parallel;
    private boolean isHypothetical;

    public PgAggregate(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.AGGREGATE;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE AGGREGATE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');

        if (baseType == null) {
            appendAggregateSignature(sbSQL, true);
        } else {
            sbSQL.append(getBareName());
        }

        sbSQL.append(" (\n\t");

        if (baseType != null) {
            sbSQL.append("BASETYPE = ");
            sbSQL.append(baseType);
            sbSQL.append(",\n\t");
        }

        sbSQL.append("SFUNC = ");
        sbSQL.append(sFunc);
        sbSQL.append(",\n\tSTYPE = ");
        sbSQL.append(sType);

        if (sSpace != 0) {
            sbSQL.append(",\n\tSSPACE = ");
            sbSQL.append(sSpace);
        }

        if (finalFunc != null) {
            sbSQL.append(",\n\tFINALFUNC = ");
            sbSQL.append(finalFunc);
        }

        if (isFinalFuncExtra) {
            sbSQL.append(",\n\tFINALFUNC_EXTRA");
        }

        if (finalFuncModify != null) {
            sbSQL.append(",\n\tFINALFUNC_MODIFY = ");
            sbSQL.append(finalFuncModify);
        }

        if (combineFunc != null) {
            sbSQL.append(",\n\tCOMBINEFUNC = ");
            sbSQL.append(combineFunc);
        }

        if (serialFunc != null) {
            sbSQL.append(",\n\tSERIALFUNC = ");
            sbSQL.append(serialFunc);
        }

        if (deserialFunc != null) {
            sbSQL.append(",\n\tDESERIALFUNC = ");
            sbSQL.append(deserialFunc);
        }

        if (initCond != null) {
            sbSQL.append(",\n\tINITCOND = ");
            sbSQL.append(initCond);
        }

        if (mSFunc != null) {
            sbSQL.append(",\n\tMSFUNC = ");
            sbSQL.append(mSFunc);
        }

        if (mInvFunc != null) {
            sbSQL.append(",\n\tMINVFUNC = ");
            sbSQL.append(mInvFunc);
        }

        if (mSType != null) {
            sbSQL.append(",\n\tMSTYPE = ");
            sbSQL.append(mSType);
        }

        if (mSSpace != 0) {
            sbSQL.append(",\n\tMSSPACE = ");
            sbSQL.append(mSSpace);
        }

        if (mFinalFunc != null) {
            sbSQL.append(",\n\tMFINALFUNC = ");
            sbSQL.append(mFinalFunc);
        }

        if (isMFinalFuncExtra) {
            sbSQL.append(",\n\tMFINALFUNC_EXTRA");
        }

        if (mFinalFuncModify != null) {
            sbSQL.append(",\n\tMFINALFUNC_MODIFY = ");
            sbSQL.append(mFinalFuncModify);
        }

        if (mInitCond != null) {
            sbSQL.append(",\n\tMINITCOND = ");
            sbSQL.append(mInitCond);
        }

        if (sortOp != null) {
            sbSQL.append(",\n\tSORTOP = ");
            sbSQL.append(sortOp);
        }

        if (parallel != null) {
            sbSQL.append(",\n\tPARALLEL = ");
            sbSQL.append(parallel);
        }

        if (isHypothetical) {
            sbSQL.append(",\n\tHYPOTHETICAL");
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
        sbString.append("DROP AGGREGATE ");
        sbString.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        appendAggregateSignature(sbString, true);
        sbString.append(';');

        return sbString.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgAggregate newAggregate;
        if (newCondition instanceof PgAggregate) {
            newAggregate = (PgAggregate)newCondition;
        } else {
            return false;
        }

        if (!checkForChanges(newAggregate)) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(getOwner(), newAggregate.getOwner())) {
            sb.append(newAggregate.getOwnerSQL());
        }
        alterPrivileges(newAggregate, sb);
        if (!Objects.equals(getComment(), newAggregate.getComment())) {
            sb.append("\n\n");
            newAggregate.appendCommentSql(sb);
        }
        return sb.length() > startLength;

    }

    /**
     * Alias for {@link #getSignature()} which provides a unique aggregate ID.
     *
     * Use {@link #getBareName()} to get just the aggregate name.
     */
    @Override
    public String getName() {
        return getSignature();
    }

    /**
     * Returns aggregate signature. It consists of unquoted name and argument
     * data types.
     *
     * @return aggregate signature
     */
    public String getSignature() {
        return appendAggregateSignature(new StringBuilder(), true).toString();
    }

    public StringBuilder appendAggregateSignature(StringBuilder sb, boolean includeArgNames) {
        sb.append(PgDiffUtils.getQuotedName(name)).append('(');
        appendArguments(sb, arguments, includeArgNames);
        if (!orderByArgs.isEmpty()) {
            if (!arguments.isEmpty()) {
                sb.append(' ');
            }
            sb.append("ORDER BY ");
            appendArguments(sb, orderByArgs, includeArgNames);
        }
        sb.append(')');
        return sb;
    }

    private void appendArguments(StringBuilder sb, List<Argument> args,
            boolean includeArgNames) {
        boolean addComma = false;
        for (final Argument arg : args) {
            if (addComma) {
                sb.append(", ");
            }
            sb.append(getDeclaration(arg, includeArgNames));
            addComma = true;
        }
    }

    private String getDeclaration(Argument arg, boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        String mode = arg.getMode();
        if (mode != null && !"IN".equalsIgnoreCase(mode)) {
            sbString.append(mode);
            sbString.append(' ');
        }

        String name = arg.getName();

        if (name != null && !name.isEmpty() && includeArgName) {
            sbString.append(PgDiffUtils.getQuotedName(name));
            sbString.append(' ');
        }

        sbString.append(arg.getDataType());

        return sbString.toString();
    }

    private boolean checkForChanges(PgAggregate aggr) {
        boolean equals = false;

        if (this == aggr) {
            equals = true;
        } else {
            equals = Objects.equals(name, aggr.getBareName())
                    && arguments.equals(aggr.getArguments())
                    && orderByArgs.equals(aggr.getOrderByArgs())
                    && Objects.equals(baseType, aggr.getBaseType())
                    && Objects.equals(sFunc, aggr.getsFunc())
                    && Objects.equals(sType, aggr.getSType())
                    && sSpace == aggr.getSSpace()
                    && Objects.equals(finalFunc, aggr.getFinalFunc())
                    && isFinalFuncExtra == aggr.isFinalFuncExtra()
                    && Objects.equals(finalFuncModify, aggr.getFinalFuncModify())
                    && Objects.equals(combineFunc, aggr.getCombineFunc())
                    && Objects.equals(serialFunc, aggr.getSerialFunc())
                    && Objects.equals(deserialFunc, aggr.getDeserialFunc())
                    && Objects.equals(initCond, aggr.getInitCond())
                    && Objects.equals(mSFunc, aggr.getMSFunc())
                    && Objects.equals(mInvFunc, aggr.getMInvFunc())
                    && Objects.equals(mSType, aggr.getMSType())
                    && mSSpace == aggr.getMSSpace()
                    && Objects.equals(mFinalFunc, aggr.getMFinalFunc())
                    && isMFinalFuncExtra == aggr.isMFinalFuncExtra()
                    && Objects.equals(mFinalFuncModify, aggr.getMFinalFuncModify())
                    && Objects.equals(mInitCond, aggr.getMInitCond())
                    && Objects.equals(sortOp, aggr.getSortOp())
                    && Objects.equals(parallel, aggr.getParallel())
                    && isHypothetical == aggr.isHypothetical();
        }
        return equals;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgAggregate) {
            PgAggregate aggr  = (PgAggregate) obj;
            if (!checkForChanges(aggr)) {
                return false;
            }
            return  Objects.equals(owner, aggr.getOwner())
                    && Objects.equals(grants, aggr.grants)
                    && Objects.equals(revokes, aggr.revokes)
                    && Objects.equals(comment, aggr.getComment());
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.putOrdered(arguments);
        hasher.putOrdered(orderByArgs);
        hasher.put(baseType);
        hasher.put(sFunc);
        hasher.put(sType);
        hasher.put(sSpace);
        hasher.put(finalFunc);
        hasher.put(isFinalFuncExtra);
        hasher.put(finalFuncModify);
        hasher.put(combineFunc);
        hasher.put(serialFunc);
        hasher.put(deserialFunc);
        hasher.put(initCond);
        hasher.put(mSFunc);
        hasher.put(mInvFunc);
        hasher.put(mSType);
        hasher.put(mSSpace);
        hasher.put(mFinalFunc);
        hasher.put(isMFinalFuncExtra);
        hasher.put(mFinalFuncModify);
        hasher.put(mInitCond);
        hasher.put(sortOp);
        hasher.put(parallel);
        hasher.put(isHypothetical);
        hasher.put(owner);
        hasher.putUnordered(grants);
        hasher.putUnordered(revokes);
        hasher.put(comment);
    }

    /**
     * Getter for {@link #arguments}. List cannot be modified.
     *
     * @return {@link #arguments}
     */
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    public void addArgument(final Argument argument) {
        arguments.add(argument);
        resetHash();
    }

    /**
     * Getter for {@link #orderByArgs}. List cannot be modified.
     *
     * @return {@link #orderByArgs}
     */
    public List<Argument> getOrderByArgs() {
        return Collections.unmodifiableList(orderByArgs);
    }

    public void addOrderByArg(final Argument orderByArg) {
        orderByArgs.add(orderByArg);
        resetHash();
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
        resetHash();
    }

    public String getsFunc() {
        return sFunc;
    }

    public void setsFunc(String sFunc) {
        this.sFunc = sFunc;
        resetHash();
    }

    public String getSType() {
        return sType;
    }

    public void setSType(String sType) {
        this.sType = sType;
        resetHash();
    }

    public long getSSpace() {
        return sSpace;
    }

    public void setSSpace(long sSpace) {
        this.sSpace = sSpace;
        resetHash();
    }

    public String getFinalFunc() {
        return finalFunc;
    }

    public void setFinalFunc(String finalFunc) {
        this.finalFunc = finalFunc;
        resetHash();
    }

    public boolean isFinalFuncExtra() {
        return isFinalFuncExtra;
    }

    public void setFinalFuncExtra(boolean isFinalFuncExtra) {
        this.isFinalFuncExtra = isFinalFuncExtra;
        resetHash();
    }

    public String getFinalFuncModify() {
        return finalFuncModify;
    }

    public void setFinalFuncModify(String finalFuncModify) {
        this.finalFuncModify = finalFuncModify;
        resetHash();
    }

    public String getCombineFunc() {
        return combineFunc;
    }

    public void setCombineFunc(String combineFunc) {
        this.combineFunc = combineFunc;
        resetHash();
    }

    public String getSerialFunc() {
        return serialFunc;
    }

    public void setSerialFunc(String serialFunc) {
        this.serialFunc = serialFunc;
        resetHash();
    }

    public String getDeserialFunc() {
        return deserialFunc;
    }

    public void setDeserialFunc(String deserialFunc) {
        this.deserialFunc = deserialFunc;
        resetHash();
    }

    public String getInitCond() {
        return initCond;
    }

    public void setInitCond(String initCond) {
        this.initCond = initCond;
        resetHash();
    }

    public String getMSFunc() {
        return mSFunc;
    }

    public void setMSFunc(String mSFunc) {
        this.mSFunc = mSFunc;
        resetHash();
    }

    public String getMInvFunc() {
        return mInvFunc;
    }

    public void setMInvFunc(String mInvFunc) {
        this.mInvFunc = mInvFunc;
        resetHash();
    }

    public String getMSType() {
        return mSType;
    }

    public void setMSType(String mSType) {
        this.mSType = mSType;
        resetHash();
    }

    public long getMSSpace() {
        return mSSpace;
    }

    public void setMSSpace(long mSSpace) {
        this.mSSpace = mSSpace;
        resetHash();
    }

    public String getMFinalFunc() {
        return mFinalFunc;
    }

    public void setMFinalFunc(String mFinalFunc) {
        this.mFinalFunc = mFinalFunc;
        resetHash();
    }

    public boolean isMFinalFuncExtra() {
        return isMFinalFuncExtra;
    }

    public void setMFinalFuncExtra(boolean isMFinalFuncExtra) {
        this.isMFinalFuncExtra = isMFinalFuncExtra;
        resetHash();
    }

    public String getMFinalFuncModify() {
        return mFinalFuncModify;
    }

    public void setMFinalFuncModify(String mFinalFuncModify) {
        this.mFinalFuncModify = mFinalFuncModify;
        resetHash();
    }

    public String getMInitCond() {
        return mInitCond;
    }

    public void setMInitCond(String mInitCond) {
        this.mInitCond = mInitCond;
        resetHash();
    }

    public String getSortOp() {
        return sortOp;
    }

    public void setSortOp(String sortOp) {
        this.sortOp = sortOp;
        resetHash();
    }

    public String getParallel() {
        return parallel;
    }

    public void setParallel(String parallel) {
        this.parallel = parallel;
        resetHash();
    }

    public boolean isHypothetical() {
        return isHypothetical;
    }

    public void setHypothetical(boolean isHypothetical) {
        this.isHypothetical = isHypothetical;
        resetHash();
    }

    @Override
    public PgStatement shallowCopy() {
        PgAggregate copy = new PgAggregate(getBareName(), getRawStatement());
        for (Argument argSrc : arguments) {
            Argument argDst = new Argument(argSrc.getMode(), argSrc.getName(), argSrc.getDataType());
            copy.addArgument(argDst);
        }
        for (Argument argSrc : orderByArgs) {
            Argument orderByArgDst = new Argument(argSrc.getMode(), argSrc.getName(), argSrc.getDataType());
            copy.addArgument(orderByArgDst);
        }
        copy.setBaseType(getBaseType());
        copy.setsFunc(getsFunc());
        copy.setSType(getSType());
        copy.setSSpace(getSSpace());
        copy.setFinalFunc(getFinalFunc());
        copy.setFinalFuncExtra(isFinalFuncExtra());
        copy.setFinalFuncModify(getFinalFuncModify());
        copy.setCombineFunc(getCombineFunc());
        copy.setSerialFunc(getSerialFunc());
        copy.setDeserialFunc(getDeserialFunc());
        copy.setInitCond(getInitCond());
        copy.setMSFunc(getMSFunc());
        copy.setMInvFunc(getMInvFunc());
        copy.setMSType(getMSType());
        copy.setMSSpace(getMSSpace());
        copy.setMFinalFunc(getMFinalFunc());
        copy.setMFinalFuncExtra(isMFinalFuncExtra());
        copy.setMFinalFuncModify(getMFinalFuncModify());
        copy.setMInitCond(getMInitCond());
        copy.setSortOp(getSortOp());
        copy.setParallel(getParallel());
        copy.setHypothetical(isHypothetical());
        copy.setComment(getComment());
        copy.setParallel(getParallel());
        copy.setOwner(getOwner());
        copy.setLocation(getLocation());
        copy.revokes.addAll(revokes);
        copy.grants.addAll(grants);
        copy.deps.addAll(deps);

        return copy;
    }

    @Override
    public PgStatement deepCopy() {
        return shallowCopy();
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }
}
