package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgAggregate extends AbstractPgFunction {

    public enum AggKinds {
        NORMAL, ORDERED, HYPOTHETICAL
    }

    public enum ModifyType {
        READ_ONLY, SHAREABLE, READ_WRITE
    }

    public static final String SFUNC = "SFUNC";
    public static final String FINALFUNC = "FINALFUNC";
    public static final String COMBINEFUNC = "COMBINEFUNC";
    public static final String SERIALFUNC = "SERIALFUNC";
    public static final String DESERIALFUNC = "DESERIALFUNC";
    public static final String MSFUNC = "MSFUNC";
    public static final String MINVFUNC = "MINVFUNC";
    public static final String MFINALFUNC = "MFINALFUNC";

    private int directCount;

    private AggKinds kind = AggKinds.NORMAL;

    private String sFunc;
    private String sType;
    private int sSpace;
    private String finalFunc;
    private boolean isFinalFuncExtra;
    private String combineFunc;
    private String serialFunc;
    private String deserialFunc;
    private String initCond;
    private String mSFunc;
    private String mInvFunc;
    private String mSType;
    private int mSSpace;
    private String mFinalFunc;
    private boolean isMFinalFuncExtra;
    private String mInitCond;
    private String sortOp;

    private ModifyType finalFuncModify;
    private ModifyType mFinalFuncModify;

    public PgAggregate(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.AGGREGATE;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE AGGREGATE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getSchemaName())).append('.');

        appendAggSignature(sbSQL);

        sbSQL.append(" (\n\t").append(SFUNC).append(" = ");
        sbSQL.append(sFunc);
        sbSQL.append(",\n\tSTYPE = ");
        sbSQL.append(sType);

        if (sSpace != 0) {
            sbSQL.append(",\n\tSSPACE = ");
            sbSQL.append(sSpace);
        }

        if (finalFunc != null) {
            sbSQL.append(",\n\t").append(FINALFUNC).append(" = ");
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
            sbSQL.append(",\n\t").append(COMBINEFUNC).append(" = ");
            sbSQL.append(combineFunc);
        }

        if (serialFunc != null) {
            sbSQL.append(",\n\t").append(SERIALFUNC).append(" = ");
            sbSQL.append(serialFunc);
        }

        if (deserialFunc != null) {
            sbSQL.append(",\n\t").append(DESERIALFUNC).append(" = ");
            sbSQL.append(deserialFunc);
        }

        if (initCond != null) {
            sbSQL.append(",\n\tINITCOND = ");
            sbSQL.append(initCond);
        }

        if (mSFunc != null) {
            sbSQL.append(",\n\t").append(MSFUNC).append(" = ");
            sbSQL.append(mSFunc);
        }

        if (mInvFunc != null) {
            sbSQL.append(",\n\t").append(MINVFUNC).append(" = ");
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
            sbSQL.append(",\n\t").append(MFINALFUNC).append(" = ");
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

        if (getParallel() != null) {
            sbSQL.append(",\n\tPARALLEL = ");
            sbSQL.append(getParallel());
        }

        if (AggKinds.HYPOTHETICAL == kind) {
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
    protected boolean needDrop(AbstractPgFunction newFunction) {
        return true;
    }

    /**
     * Appends signature of aggregate to sb.<br />
     *
     * Used for CREATE, ALTER, DROP, COMMENT operations in Aggregates.<br /><br />
     *
     * (For PRIVILEGES in Aggregates used common method
     * {@link AbstractPgFunction#appendFunctionSignature(StringBuilder,
            includeDefaultValues, includeArgNames)}.)
     *
     */
    public StringBuilder appendAggSignature(StringBuilder sb) {
        sb.append(PgDiffUtils.getQuotedName(name)).append('(');
        if (arguments.isEmpty()) {
            sb.append('*');
        } else {
            boolean first = true;
            int i = directCount;
            for (final Argument arg : arguments) {
                if (i == 0) {
                    if (!first) {
                        sb.append(' ');
                    }
                    sb.append("ORDER BY ");
                } else if (!first) {
                    sb.append(", ");
                }

                sb.append(getDeclaration(arg, false, true));
                first = false;
                i--;
            }
        }
        sb.append(')');

        return sb;
    }

    @Override
    public boolean compareUnalterable(AbstractPgFunction func) {
        if (this == func) {
            return true;
        }

        if (func instanceof PgAggregate && super.compareUnalterable(func)) {
            PgAggregate aggr = (PgAggregate) func;
            return directCount == aggr.directCount
                    && Objects.equals(kind, aggr.getKind())
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
                    && Objects.equals(sortOp, aggr.getSortOp());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(directCount);
        hasher.put(kind);
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
    }

    public int getDirectCount() {
        return directCount;
    }

    public void setDirectCount(int directCount) {
        this.directCount = directCount;
        resetHash();
    }

    public AggKinds getKind() {
        return kind;
    }

    public void setKind(AggKinds kind) {
        this.kind = kind;
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

    public int getSSpace() {
        return sSpace;
    }

    public void setSSpace(int sSpace) {
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

    public ModifyType getFinalFuncModify() {
        return finalFuncModify;
    }

    public void setFinalFuncModify(ModifyType finalFuncModify) {
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

    public int getMSSpace() {
        return mSSpace;
    }

    public void setMSSpace(int mSSpace) {
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

    public ModifyType getMFinalFuncModify() {
        return mFinalFuncModify;
    }

    public void setMFinalFuncModify(ModifyType mFinalFuncModify) {
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

    @Override
    protected AbstractPgFunction getFunctionCopy() {
        PgAggregate copy = new PgAggregate(getBareName());
        copy.setDirectCount(getDirectCount());
        copy.setKind(getKind());
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
        return copy;
    }
}
