package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgAggregate extends AbstractPgFunction {

    public static final String NORMAL = "n";
    public static final String ORDERED = "o";
    public static final String HYPOTHETICAL = "h";

    private final List<Argument> orderByArgs = new ArrayList<>();

    private String kind;
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

        appendFunctionSignatureExtended(sbSQL, false, true);

        sbSQL.append(" (\n\tSFUNC = ");
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
            appendFuncModify(finalFuncModify, sbSQL, false);
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
            appendFuncModify(mFinalFuncModify, sbSQL, true);
        }

        if (mInitCond != null) {
            sbSQL.append(",\n\tMINITCOND = ");
            sbSQL.append(mInitCond);
        }

        if (sortOp != null) {
            sbSQL.append(",\n\tSORTOP = ");
            sbSQL.append(sortOp);
        }

        if (getParallel() != null) {
            sbSQL.append(",\n\tPARALLEL = ");
            sbSQL.append(getParallel());
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

    private void appendFuncModify(String funcModifier, StringBuilder sbSQL, boolean isMovingAgg) {
        // The default is READ_ONLY, except for ordered aggregates, for which the default is READ_WRITE.
        boolean appendModifier = false;
        switch (kind.toLowerCase()) {
        case NORMAL:
            if (!"READ_ONLY".equalsIgnoreCase(funcModifier)) {
                appendModifier = true;
            }
            break;

        case HYPOTHETICAL:
        case ORDERED:
            if (!"READ_WRITE".equalsIgnoreCase(funcModifier)) {
                appendModifier = true;
            }
            break;

        default:
            throw new IllegalStateException(kind + " doesn't support by AGGREGATE!");
        }

        if (appendModifier) {
            sbSQL.append(",\n\t");
            sbSQL.append(isMovingAgg ? "M" : "");
            sbSQL.append("FINALFUNC_MODIFY = ");
            sbSQL.append(funcModifier);
        }
    }

    @Override
    public StringBuilder appendFunctionSignature(StringBuilder sb,
            boolean includeDefaultValues, boolean includeArgNames) {
        return appendFunctionSignatureExtended(sb, true, includeArgNames);
    }

    public StringBuilder appendFunctionSignatureExtended(StringBuilder sb,
            boolean isPrivilegesSignature, boolean includeArgNames) {
        boolean cache = !includeArgNames;
        if (cache && signatureCache != null) {
            return sb.append(signatureCache);
        }
        final int sigStart = sb.length();

        sb.append(PgDiffUtils.getQuotedName(name)).append('(');
        if (!isPrivilegesSignature && arguments.isEmpty() && orderByArgs.isEmpty()) {
            sb.append('*');
        } else {
            appendArguments(sb, arguments, includeArgNames);
            if (!orderByArgs.isEmpty()) {
                if (!arguments.isEmpty()) {
                    if (!isPrivilegesSignature) {
                        sb.append(' ');
                    } else {
                        sb.append(", ");
                    }
                }

                if (!isPrivilegesSignature) {
                    sb.append("ORDER BY ");
                }

                appendArguments(sb, orderByArgs, includeArgNames);
            }
        }
        sb.append(')');

        if (cache) {
            signatureCache = sb.substring(sigStart, sb.length());
        }
        return sb;
    }

    private void appendArguments(StringBuilder sb, List<Argument> args,
            boolean includeArgNames) {
        boolean addComma = false;
        for (final Argument arg : args) {
            if (addComma) {
                sb.append(", ");
            }
            sb.append(getDeclaration(arg, false, includeArgNames));
            addComma = true;
        }
    }

    @Override
    public boolean checkForChanges(AbstractFunction func) {
        boolean equals = false;

        if (this == func) {
            equals = true;
        } else {
            PgAggregate aggr = (PgAggregate)func;
            equals = super.checkForChanges(aggr)
                    && orderByArgs.equals(aggr.getOrderByArgs())
                    && Objects.equals(kind, aggr.getKind())
                    && Objects.equals(baseType, aggr.getBaseType())
                    && Objects.equals(sFunc, aggr.getSFunc())
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
                    && isHypothetical == aggr.isHypothetical();
        }
        return equals;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.putOrdered(orderByArgs);
        hasher.put(kind);
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
        hasher.put(isHypothetical);
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
        resetHash();
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
        if (baseType != null && !"ANY".equals(baseType)) {
            arguments.add(new Argument(null, baseType));
        }
        resetHash();
    }

    public String getSFunc() {
        return sFunc;
    }

    public void setSFunc(String sFunc) {
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

    public boolean isHypothetical() {
        return isHypothetical;
    }

    public void setHypothetical(boolean isHypothetical) {
        this.isHypothetical = isHypothetical;
        resetHash();
    }

    @Override
    protected AbstractFunction getFunctionCopy() {
        PgAggregate copy = new PgAggregate(getBareName(), getRawStatement());
        for (Argument argSrc : orderByArgs) {
            Argument orderByArgDst = new Argument(argSrc.getMode(), argSrc.getName(),
                    argSrc.getDataType());
            copy.addOrderByArg(orderByArgDst);
        }
        copy.setKind(getKind());
        copy.setBaseType(getBaseType());
        copy.setSFunc(getSFunc());
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
        return copy;
    }
}
