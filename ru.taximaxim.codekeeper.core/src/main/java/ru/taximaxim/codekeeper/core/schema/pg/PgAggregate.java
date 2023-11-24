/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.Argument;

public class PgAggregate extends AbstractPgFunction {

    public enum AggKinds {
        NORMAL, ORDERED, HYPOTHETICAL
    }

    public enum ModifyType {
        READ_ONLY, SHAREABLE, READ_WRITE
    }

    public enum AggFuncs {
        SFUNC, FINALFUNC, COMBINEFUNC, SERIALFUNC, DESERIALFUNC, MSFUNC, MINVFUNC, MFINALFUNC
    }

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
    private String returns;

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
    protected void appendFunctionFullSQL(StringBuilder sbSQL, boolean isCreate) {
        sbSQL.append("CREATE AGGREGATE ");
        appendFullName(sbSQL);

        sbSQL.append(" (\n\tSFUNC").append(" = ");
        sbSQL.append(sFunc);
        sbSQL.append(",\n\tSTYPE = ");
        sbSQL.append(sType);

        if (sSpace != 0) {
            sbSQL.append(",\n\tSSPACE = ");
            sbSQL.append(sSpace);
        }

        if (finalFunc != null) {
            sbSQL.append(",\n\tFINALFUNC").append(" = ");
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
            sbSQL.append(",\n\tCOMBINEFUNC").append(" = ");
            sbSQL.append(combineFunc);
        }

        if (serialFunc != null) {
            sbSQL.append(",\n\tSERIALFUNC").append(" = ");
            sbSQL.append(serialFunc);
        }

        if (deserialFunc != null) {
            sbSQL.append(",\n\tDESERIALFUNC").append(" = ");
            sbSQL.append(deserialFunc);
        }

        if (initCond != null) {
            sbSQL.append(",\n\tINITCOND = ");
            sbSQL.append(initCond);
        }

        if (mSFunc != null) {
            sbSQL.append(",\n\tMSFUNC").append(" = ");
            sbSQL.append(mSFunc);
        }

        if (mInvFunc != null) {
            sbSQL.append(",\n\tMINVFUNC").append(" = ");
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
            sbSQL.append(",\n\tMFINALFUNC").append(" = ");
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
    }

    @Override
    public boolean needDrop(AbstractFunction newFunction) {
        return true;
    }

    @Override
    public StringBuilder appendFullName(StringBuilder sb) {
        sb.append(PgDiffUtils.getQuotedName(getSchemaName())).append('.');
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

                arg.appendDeclaration(sb, false, true);
                first = false;
                i--;
            }
        }
        sb.append(')');

        return sb;
    }

    @Override
    protected boolean compareUnalterable(AbstractFunction func) {
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
    public String getReturns() {
        return returns;
    }

    @Override
    public void setReturns(String returns) {
        this.returns = returns;
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
        copy.setReturns(getReturns());
        return copy;
    }
}
