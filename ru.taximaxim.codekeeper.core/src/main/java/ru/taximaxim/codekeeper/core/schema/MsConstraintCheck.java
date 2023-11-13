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
package ru.taximaxim.codekeeper.core.schema;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;

public final class MsConstraintCheck extends MsConstraint {

    private boolean isNotForRepl;
    private String expression;

    public MsConstraintCheck(String name) {
        super(name);
    }

    public void setNotForRepl(boolean isNotForRepl) {
        this.isNotForRepl = isNotForRepl;
        resetHash();
    }

    public boolean isNotForRepl() {
        return isNotForRepl;
    }

    public void setExpression(String expression) {
        this.expression = expression;
        resetHash();
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String getDefinition() {
        var sbSQL = new StringBuilder();
        sbSQL.append("CHECK  ");
        if (isNotForRepl()) {
            sbSQL.append("NOT FOR REPLICATION ");
        }
        sbSQL.append('(').append(getExpression()).append(')');
        return sbSQL.toString();
    }

    @Override
    protected boolean compareUnalterable(MsConstraint newConstr) {
        if (newConstr instanceof MsConstraintCheck) {
            var con = (MsConstraintCheck) newConstr;
            return isNotForRepl() == con.isNotForRepl()
                    && Objects.equals(getExpression(), con.getExpression());
        }
        return false;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsConstraintCheck) {
            return super.compare(obj) && compareUnalterable((MsConstraintCheck) obj);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isNotForRepl);
        hasher.put(expression);
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        var con = new MsConstraintCheck(name);
        con.setNotForRepl(isNotForRepl());
        con.setExpression(getExpression());
        return con;
    }
}