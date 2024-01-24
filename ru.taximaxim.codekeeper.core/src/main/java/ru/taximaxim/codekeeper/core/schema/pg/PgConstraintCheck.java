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

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class PgConstraintCheck extends PgConstraint {

    private boolean isInherit = true;
    private String expression;

    public PgConstraintCheck(String name) {
        super(name);
    }

    public void setInherit(boolean isInherit) {
        this.isInherit = isInherit;
        resetHash();
    }

    public boolean isInherit() {
        return isInherit;
    }

    public void setExpression(String expresion) {
        this.expression = expresion;
        resetHash();
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String getDefinition() {
        var sbSQL = new StringBuilder();
        sbSQL.append("CHECK (").append(getExpression()).append(')');
        if (!isInherit()) {
            sbSQL.append(" NO INHERIT");
        }
        return sbSQL.toString();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgConstraintCheck && super.compare(obj)) {
            return compareUnalterable((PgConstraintCheck) obj);
        }
        return false;
    }

    @Override
    protected boolean compareUnalterable(PgConstraint newConstr) {
        if (newConstr instanceof PgConstraintCheck) {
            var con = (PgConstraintCheck) newConstr;
            return super.compareUnalterable(con)
                    && isInherit() == con.isInherit()
                    && Objects.equals(getExpression(), con.getExpression());
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isInherit);
        hasher.put(expression);
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        var con = new PgConstraintCheck(name);
        con.setInherit(isInherit());
        con.setExpression(getExpression());
        return con;
    }
}