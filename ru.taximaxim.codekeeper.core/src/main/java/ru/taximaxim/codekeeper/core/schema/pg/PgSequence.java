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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Locale;
import java.util.Objects;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLActionType;
import ru.taximaxim.codekeeper.core.script.SQLScript;

/**
 * Stores sequence information.
 */
public class PgSequence extends AbstractSequence {

    private static final String ALTER_SEQUENCE = "ALTER SEQUENCE ";
    private GenericColumn ownedBy;
    private boolean isLogged = true;

    public PgSequence(String name) {
        super(name);
        setCache("1");
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");
        if (!isLogged) {
            sbSQL.append("UNLOGGED ");
        }
        sbSQL.append("SEQUENCE ");
        appendIfNotExists(sbSQL);
        sbSQL.append(getQualifiedName());

        if (!BIGINT.equals(getDataType())) {
            sbSQL.append("\n\tAS ").append(getDataType());
        }

        fillSequenceBody(sbSQL);
        script.addStatement(sbSQL);

        getOwnedBySQL(script);
        appendOwnerSQL(script);
        appendPrivileges(script);
        appendComments(script);
    }

    @Override
    public void fillSequenceBody(StringBuilder sbSQL) {
        if (getStartWith() != null) {
            sbSQL.append("\n\tSTART WITH ");
            sbSQL.append(getStartWith());
        }

        if (getIncrement() != null) {
            sbSQL.append("\n\tINCREMENT BY ");
            sbSQL.append(getIncrement());
        }

        sbSQL.append("\n\t");

        if (getMaxValue() == null) {
            sbSQL.append("NO MAXVALUE");
        } else {
            sbSQL.append("MAXVALUE ");
            sbSQL.append(getMaxValue());
        }

        sbSQL.append("\n\t");

        if (getMinValue() == null) {
            sbSQL.append("NO MINVALUE");
        } else {
            sbSQL.append("MINVALUE ");
            sbSQL.append(getMinValue());
        }

        if (getCache() != null) {
            sbSQL.append("\n\tCACHE ");
            sbSQL.append(getCache());
        }

        if (isCycle()) {
            sbSQL.append("\n\tCYCLE");
        }
    }

    /**
     * Creates SQL statement for modification "OWNED BY" parameter.
     */
    public void getOwnedBySQL(SQLScript script) {
        if (getOwnedBy() == null) {
            return;
        }
        final StringBuilder sbSQL = new StringBuilder();

        sbSQL.append(ALTER_SEQUENCE).append(getQualifiedName());
        sbSQL.append("\n\tOWNED BY ").append(getOwnedBy().getQualifiedName());
        script.addStatement(sbSQL.toString(), SQLActionType.END);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgSequence newSequence = (PgSequence) newCondition;
        StringBuilder sbSQL = new StringBuilder();

        if (compareSequenceBody(newSequence, sbSQL)) {
            script.addStatement(ALTER_SEQUENCE + newSequence.getQualifiedName() + sbSQL);
        }

        appendAlterOwner(newSequence, script);

        if (isLogged != newSequence.isLogged) {
            StringBuilder sql = new StringBuilder();
            sql.append(ALTER_SEQUENCE).append(newSequence.getQualifiedName())
            .append(" SET")
            .append(newSequence.isLogged ? " LOGGED" : " UNLOGGED");
            script.addStatement(sql);
        }

        alterPrivileges(newSequence, script);
        appendAlterComments(newSequence, script);

        if (!Objects.equals(getOwnedBy(), newSequence.getOwnedBy())) {
            newSequence.getOwnedBySQL(script);
        }

        return getObjectState(script, startSize);
    }

    private boolean compareSequenceBody(PgSequence newSequence, StringBuilder sbSQL) {
        final String oldType = getDataType();
        final String newType = newSequence.getDataType();

        if (!oldType.equals(newType)) {
            sbSQL.append("\n\tAS ");
            sbSQL.append(newType);
        }

        final String newIncrement = newSequence.getIncrement();
        if (newIncrement != null && !newIncrement.equals(getIncrement())) {
            sbSQL.append("\n\tINCREMENT BY ");
            sbSQL.append(newIncrement);
        }

        final String newMinValue = newSequence.getMinValue();
        if (newMinValue == null && getMinValue() != null) {
            sbSQL.append("\n\tNO MINVALUE");
        } else if (newMinValue != null && !newMinValue.equals(getMinValue())) {
            sbSQL.append("\n\tMINVALUE ");
            sbSQL.append(newMinValue);
        }

        final String newMaxValue = newSequence.getMaxValue();
        if (newMaxValue == null && getMaxValue() != null) {
            sbSQL.append("\n\tNO MAXVALUE");
        } else if (newMaxValue != null && !newMaxValue.equals(getMaxValue())) {
            sbSQL.append("\n\tMAXVALUE ");
            sbSQL.append(newMaxValue);
        }

        final String newStart = newSequence.getStartWith();
        if (newStart != null && !newStart.equals(getStartWith())) {
            sbSQL.append("\n\tSTART WITH ");
            sbSQL.append(newStart);
        }

        final String newCache = newSequence.getCache();
        if (newCache != null && !newCache.equals(getCache())) {
            sbSQL.append("\n\tCACHE ");
            sbSQL.append(newCache);
        }

        final boolean newCycle = newSequence.isCycle();
        if (isCycle() && !newCycle) {
            sbSQL.append("\n\tNO CYCLE");
        } else if (!isCycle() && newCycle) {
            sbSQL.append("\n\tCYCLE");
        }

        final GenericColumn newOwnedBy = newSequence.getOwnedBy();
        if (newOwnedBy == null && getOwnedBy() != null) {
            sbSQL.append("\n\tOWNED BY NONE");
        }

        return sbSQL.length() > 0;
    }

    @Override
    public void setMinMaxInc(long inc, Long max, Long min, String dataType, long precision) {
        String type = dataType != null ? dataType : BIGINT;
        this.increment = Long.toString(inc);
        if (max == null || (inc > 0 && max == getBoundaryTypeVal(type, true, 0L))
                || (inc < 0 && max == -1)) {
            this.maxValue = null;
        } else {
            this.maxValue = "" + max;
        }
        if (min == null || (inc > 0 && min == 1)
                || (inc < 0 && min == getBoundaryTypeVal(type, false, 0L))) {
            this.minValue = null;
        } else {
            this.minValue = "" + min;
        }

        if (getStartWith() == null) {
            if (this.minValue != null) {
                setStartWith(this.minValue);
            } else {
                setStartWith(inc < 0 ? "-1" : "1");
            }
        }
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgSequence seq && super.compare(obj)) {
            return Objects.equals(ownedBy, seq.getOwnedBy())
                    && isLogged == seq.isLogged();
        }

        return false;
    }

    public GenericColumn getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(final GenericColumn ownedBy) {
        this.ownedBy = ownedBy;
        resetHash();
    }

    @Override
    public void setDataType(String dataType) {
        super.setDataType(dataType.toLowerCase(Locale.ROOT));
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
        resetHash();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(ownedBy == null ? 0 : ownedBy.hashCode());
        hasher.put(isLogged);
    }

    @Override
    protected AbstractSequence getSequenceCopy() {
        PgSequence sequence = new PgSequence(getName());
        sequence.setOwnedBy(getOwnedBy());
        return sequence;
    }

    @Override
    public AbstractSequence shallowCopy() {
        PgSequence copy = (PgSequence) super.shallowCopy();
        copy.setLogged(isLogged);
        return copy;
    }
}
