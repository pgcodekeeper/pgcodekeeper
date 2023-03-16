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
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;

public class MsConstraint extends AbstractConstraint {

    private boolean isDisabled;

    public MsConstraint(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER ").append(getParent().getStatementType().name());
        sbSQL.append(' ');
        sbSQL.append(getParent().getQualifiedName());
        if (isNotValid()) {
            sbSQL.append(" WITH NOCHECK");
        }
        sbSQL.append("\n\tADD ");
        if (!name.isEmpty()) {
            sbSQL.append("CONSTRAINT ").append(MsDiffUtils.quoteName(getName())).append(' ');
        }
        sbSQL.append(getDefinition());
        sbSQL.append(GO);

        // 1) if is not valid, after adding it is disabled by default
        // 2) can't be valid if disabled
        if (isNotValid()) {
            sbSQL.append("\n\nALTER ").append(getParent().getStatementType().name())
            .append(' ').append(getParent().getQualifiedName()).append(' ');
            if (isDisabled()) {
                sbSQL.append("NO");
            }
            sbSQL.append("CHECK CONSTRAINT ").append(MsDiffUtils.quoteName(getName()))
            .append(GO);
        }

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        MsConstraint newConstr = (MsConstraint) newCondition;

        if (!Objects.equals(getDefinition(), newConstr.getDefinition())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (isNotValid() != newConstr.isNotValid() || isDisabled() != newConstr.isDisabled()) {
            sb.append("\nALTER ").append(newConstr.getParent().getStatementType().name())
            .append(' ').append(newConstr.getParent().getQualifiedName())
            .append(" WITH ");
            if (newConstr.isNotValid()) {
                sb.append("NO");
            }
            sb.append("CHECK ");
            if (newConstr.isDisabled()) {
                sb.append("NO");
            }
            sb.append("CHECK CONSTRAINT ").append(MsDiffUtils.quoteName(newConstr.getName()))
            .append(GO);
            return true;
        }

        return false;
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(getParent().getQualifiedName());
        sbSQL.append("\n\tDROP CONSTRAINT ");
        if (optionExists) {
            sbSQL.append("IF EXISTS ");
        }
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean compare(PgStatement obj) {
        return obj instanceof MsConstraint && super.compare(obj)
                && isDisabled == ((MsConstraint) obj).isDisabled();
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
        resetHash();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isDisabled);
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        MsConstraint con = new MsConstraint(getName());
        con.setDisabled(isDisabled());
        return con;
    }
}
