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
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractPolicy;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class PgPolicy extends AbstractPolicy implements ISearchPath {

    private String check;

    public PgPolicy(String name) {
        super(name);
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
        resetHash();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE POLICY ");
        appendFullName(sbSQL);

        if (!isPermissive()) {
            sbSQL.append("\n  AS RESTRICTIVE");
        }

        if (event != null) {
            sbSQL.append("\n  FOR ").append(event);
        }

        if (!roles.isEmpty()) {
            sbSQL.append("\n  TO ").append(String.join(", ", roles));
        }

        if (using != null && !using.isEmpty()) {
            sbSQL.append("\n  USING ").append(using);
        }

        if (check != null && !check.isEmpty()) {
            sbSQL.append("\n  WITH CHECK ").append(check);
        }
        sbSQL.append(';');

        return sbSQL.toString();
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgPolicy newPolice = (PgPolicy) newCondition;

        if (!compareUnalterable(newPolice)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        Set<String> newRoles = newPolice.roles;
        String newUsing = newPolice.getUsing();
        String newCheck = newPolice.getCheck();

        if (!Objects.equals(roles, newRoles) || !Objects.equals(using, newUsing)
                || !Objects.equals(check, newCheck)) {

            sb.append("\n\nALTER POLICY ");
            appendFullName(sb);

            if (!Objects.equals(roles, newRoles)) {
                sb.append("\n  TO ");
                if (newRoles.isEmpty()) {
                    sb.append("PUBLIC");
                } else {
                    sb.append(String.join(", ", newRoles));
                }
            }

            if (!Objects.equals(using, newUsing)) {
                sb.append("\n  USING ").append(newUsing);
            }

            if (!Objects.equals(check, newCheck)) {
                sb.append("\n  WITH CHECK ").append(newCheck);
            }
            sb.append(';');
        }
        compareComments(sb, newPolice);

        return getObjectState(sb, startLength);
    }

    @Override
    protected StringBuilder appendFullName(StringBuilder sb) {
        sb.append(PgDiffUtils.getQuotedName(getName()));
        sb.append(" ON ").append(getParent().getQualifiedName());
        return sb;
    }

    @Override
    protected AbstractPolicy getPolicyCopy() {
        PgPolicy copy = new PgPolicy(getName());
        copy.setCheck(getCheck());
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgPolicy police && super.compare(obj)) {
            return Objects.equals(getCheck(), police.getCheck());
        }

        return false;
    }

    private boolean compareUnalterable(PgPolicy police) {
        // we can alter but cannot remove
        if (using != null && police.getUsing() == null) {
            return false;
        }

        if (check != null && police.getCheck() == null) {
            return false;
        }

        return event == police.event && isPermissive == police.isPermissive();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(check);
    }

    @Override
    public boolean isSubElement() {
        return true;
    }

    @Override
    public final AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent().getParent();
    }
}
