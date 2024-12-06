/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class PgOperator extends PgStatement implements IOperator, ISearchPath {

    private String procedure;
    private String leftArg;
    private String rightArg;
    private String commutator;
    private String negator;
    private boolean isMerges;
    private boolean isHashes;
    private String restrict;
    private String join;

    private String returns;

    public PgOperator(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.OPERATOR;
    }

    @Override
    public void setReturns(String returns) {
        this.returns = returns;
    }

    @Override
    public String getReturns() {
        return returns;
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE OPERATOR ");
        sbSQL.append(PgDiffUtils.getQuotedName(getSchemaName())).append('.');
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

        sbSQL.append("\n)");
        script.addStatement(sbSQL);

        appendOwnerSQL(script);
        appendPrivileges(script);
        appendComments(script);
    }

    public String getSignature() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBareName());
        sb.append('(');
        sb.append(leftArg == null ? "NONE" : leftArg);
        sb.append(", ");
        sb.append(rightArg == null ? "NONE" : rightArg);
        sb.append(')');
        return sb.toString();
    }

    public String getArguments() {
        StringBuilder signature = new StringBuilder();
        String left = getLeftArg();
        String right = getRightArg();

        signature.append('(');
        if (left != null) {
            signature.append(left);
            if (right != null) {
                signature.append(", ").append(right);
            }
        } else {
            signature.append(right);
        }
        signature.append(')');

        return signature.toString();
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, AtomicBoolean isNeedDepcies, SQLScript script) {
        int startSize = script.getSize();
        PgOperator newOperator = (PgOperator) newCondition;

        if (!compareUnalterable(newOperator)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        String newOperRestr = newOperator.getRestrict();
        String newOperJoin = newOperator.getJoin();
        boolean restrChanged = !Objects.equals(restrict, newOperRestr);
        boolean joinChanged = !Objects.equals(join, newOperJoin);
        if (restrChanged || joinChanged) {
            StringBuilder sql = new StringBuilder();
            sql.append("ALTER OPERATOR ")
            .append(getQualifiedName())
            .append("\n\tSET (");
            if (restrChanged) {
                sql.append("RESTRICT = ").append(newOperRestr != null ? newOperRestr : "NONE");
                if (joinChanged) {
                    sql.append(", ");
                }
            }
            if (joinChanged) {
                sql.append("JOIN = ").append(newOperJoin != null ? newOperJoin : "NONE");
            }
            sql.append(")");
            script.addStatement(sql);
        }

        appendAlterOwner(newOperator, script);
        appendAlterComments(newOperator, script);

        return getObjectState(script, startSize);
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

    @Override
    public String getQualifiedName() {
        return getParent().getQualifiedName() + '.' + getName();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgOperator oper && super.compare(obj)) {
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

    @Override
    public String getLeftArg() {
        return leftArg;
    }

    public void setLeftArg(String leftArg) {
        this.leftArg = leftArg;
        resetHash();
    }

    @Override
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
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }
}
