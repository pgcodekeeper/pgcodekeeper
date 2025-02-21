/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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

public final class PgAggregate extends AbstractPgFunction {

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
    protected void appendFunctionFullSQL(StringBuilder sb, boolean isCreate) {
        sb.append("CREATE AGGREGATE ");
        appendFullName(sb);

        sb.append(" (\n\tSFUNC").append(" = ");
        sb.append(sFunc);
        sb.append(",\n\tSTYPE = ");
        sb.append(sType);

        if (sSpace != 0) {
            sb.append(",\n\tSSPACE = ");
            sb.append(sSpace);
        }

        if (finalFunc != null) {
            sb.append(",\n\tFINALFUNC").append(" = ");
            sb.append(finalFunc);
        }

        if (isFinalFuncExtra) {
            sb.append(",\n\tFINALFUNC_EXTRA");
        }

        if (finalFuncModify != null) {
            sb.append(",\n\tFINALFUNC_MODIFY = ");
            sb.append(finalFuncModify);
        }

        if (combineFunc != null) {
            sb.append(",\n\tCOMBINEFUNC").append(" = ");
            sb.append(combineFunc);
        }

        if (serialFunc != null) {
            sb.append(",\n\tSERIALFUNC").append(" = ");
            sb.append(serialFunc);
        }

        if (deserialFunc != null) {
            sb.append(",\n\tDESERIALFUNC").append(" = ");
            sb.append(deserialFunc);
        }

        if (initCond != null) {
            sb.append(",\n\tINITCOND = ");
            sb.append(initCond);
        }

        if (mSFunc != null) {
            sb.append(",\n\tMSFUNC").append(" = ");
            sb.append(mSFunc);
        }

        if (mInvFunc != null) {
            sb.append(",\n\tMINVFUNC").append(" = ");
            sb.append(mInvFunc);
        }

        if (mSType != null) {
            sb.append(",\n\tMSTYPE = ");
            sb.append(mSType);
        }

        if (mSSpace != 0) {
            sb.append(",\n\tMSSPACE = ");
            sb.append(mSSpace);
        }

        if (mFinalFunc != null) {
            sb.append(",\n\tMFINALFUNC").append(" = ");
            sb.append(mFinalFunc);
        }

        if (isMFinalFuncExtra) {
            sb.append(",\n\tMFINALFUNC_EXTRA");
        }

        if (mFinalFuncModify != null) {
            sb.append(",\n\tMFINALFUNC_MODIFY = ");
            sb.append(mFinalFuncModify);
        }

        if (mInitCond != null) {
            sb.append(",\n\tMINITCOND = ");
            sb.append(mInitCond);
        }

        if (sortOp != null) {
            sb.append(",\n\tSORTOP = ");
            sb.append(sortOp);
        }

        if (getParallel() != null) {
            sb.append(",\n\tPARALLEL = ");
            sb.append(getParallel());
        }

        if (AggKinds.HYPOTHETICAL == kind) {
            sb.append(",\n\tHYPOTHETICAL");
        }

        sb.append("\n)");
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
        if (func instanceof PgAggregate aggr && super.compareUnalterable(func)) {
            return directCount == aggr.directCount
                    && Objects.equals(kind, aggr.kind)
                    && Objects.equals(sFunc, aggr.sFunc)
                    && Objects.equals(sType, aggr.sType)
                    && sSpace == aggr.sSpace
                    && Objects.equals(finalFunc, aggr.finalFunc)
                    && isFinalFuncExtra == aggr.isFinalFuncExtra
                    && Objects.equals(finalFuncModify, aggr.finalFuncModify)
                    && Objects.equals(combineFunc, aggr.combineFunc)
                    && Objects.equals(serialFunc, aggr.serialFunc)
                    && Objects.equals(deserialFunc, aggr.deserialFunc)
                    && Objects.equals(initCond, aggr.initCond)
                    && Objects.equals(mSFunc, aggr.mSFunc)
                    && Objects.equals(mInvFunc, aggr.mInvFunc)
                    && Objects.equals(mSType, aggr.mSType)
                    && mSSpace == aggr.mSSpace
                    && Objects.equals(mFinalFunc, aggr.mFinalFunc)
                    && isMFinalFuncExtra == aggr.isMFinalFuncExtra
                    && Objects.equals(mFinalFuncModify, aggr.mFinalFuncModify)
                    && Objects.equals(mInitCond, aggr.mInitCond)
                    && Objects.equals(sortOp, aggr.sortOp);
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

    public void setFinalFuncExtra(boolean isFinalFuncExtra) {
        this.isFinalFuncExtra = isFinalFuncExtra;
        resetHash();
    }

    public void setFinalFuncModify(ModifyType finalFuncModify) {
        this.finalFuncModify = finalFuncModify;
        resetHash();
    }

    public void setCombineFunc(String combineFunc) {
        this.combineFunc = combineFunc;
        resetHash();
    }

    public void setSerialFunc(String serialFunc) {
        this.serialFunc = serialFunc;
        resetHash();
    }

    public void setDeserialFunc(String deserialFunc) {
        this.deserialFunc = deserialFunc;
        resetHash();
    }

    public void setInitCond(String initCond) {
        this.initCond = initCond;
        resetHash();
    }

    public void setMSFunc(String mSFunc) {
        this.mSFunc = mSFunc;
        resetHash();
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

    public void setMSSpace(int mSSpace) {
        this.mSSpace = mSSpace;
        resetHash();
    }

    public void setMFinalFunc(String mFinalFunc) {
        this.mFinalFunc = mFinalFunc;
        resetHash();
    }

    public void setMFinalFuncExtra(boolean isMFinalFuncExtra) {
        this.isMFinalFuncExtra = isMFinalFuncExtra;
        resetHash();
    }

    public void setMFinalFuncModify(ModifyType mFinalFuncModify) {
        this.mFinalFuncModify = mFinalFuncModify;
        resetHash();
    }

    public void setMInitCond(String mInitCond) {
        this.mInitCond = mInitCond;
        resetHash();
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
        PgAggregate copy = new PgAggregate(name);
        copy.setDirectCount(directCount);
        copy.setKind(kind);
        copy.setSFunc(sFunc);
        copy.setSType(sType);
        copy.setSSpace(sSpace);
        copy.setFinalFunc(finalFunc);
        copy.setFinalFuncExtra(isFinalFuncExtra);
        copy.setFinalFuncModify(finalFuncModify);
        copy.setCombineFunc(combineFunc);
        copy.setSerialFunc(serialFunc);
        copy.setDeserialFunc(deserialFunc);
        copy.setInitCond(initCond);
        copy.setMSFunc(mSFunc);
        copy.setMInvFunc(mInvFunc);
        copy.setMSType(mSType);
        copy.setMSSpace(mSSpace);
        copy.setMFinalFunc(mFinalFunc);
        copy.setMFinalFuncExtra(isMFinalFuncExtra);
        copy.setMFinalFuncModify(mFinalFuncModify);
        copy.setMInitCond(mInitCond);
        copy.setSortOp(sortOp);
        copy.setParallel(getParallel());
        copy.setReturns(getReturns());
        return copy;
    }
}
