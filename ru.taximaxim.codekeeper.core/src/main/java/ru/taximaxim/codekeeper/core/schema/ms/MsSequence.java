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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class MsSequence extends AbstractSequence {

    private boolean isCached;

    public MsSequence(String name) {
        super(name);
        setDataType(BIGINT);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SEQUENCE ");
        sbSQL.append(getQualifiedName());

        sbSQL.append("\n\tAS ").append(getDataType());

        fillSequenceBody(sbSQL);
        script.addStatement(sbSQL);
        appendOwnerSQL(script);
        appendPrivileges(script);
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

        sbSQL.append("\n\tMAXVALUE ");
        sbSQL.append(getMaxValue());

        sbSQL.append("\n\tMINVALUE ");
        sbSQL.append(getMinValue());

        if (isCached()) {
            sbSQL.append("\n\tCACHE ");
            if (getCache() != null) {
                sbSQL.append(getCache());
            }
        }

        if (isCycle()) {
            sbSQL.append("\n\tCYCLE");
        }
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, AtomicBoolean isNeedDepcies, SQLScript script) {
        int startSize = script.getSize();
        MsSequence newSequence = (MsSequence) newCondition;

        if (!newSequence.getDataType().equals(getDataType())) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        StringBuilder sbSQL = new StringBuilder();
        if (compareSequenceBody(newSequence, sbSQL)) {
            script.addStatement("ALTER SEQUENCE " + getQualifiedName() + sbSQL.toString());
        }

        appendAlterOwner(newSequence, script);
        alterPrivileges(newSequence, script);
        return getObjectState(script, startSize);
    }

    private boolean compareSequenceBody(MsSequence newSequence, StringBuilder sbSQL) {
        final String oldIncrement = getIncrement();
        final String newIncrement = newSequence.getIncrement();

        if (newIncrement != null
                && !newIncrement.equals(oldIncrement)) {
            sbSQL.append("\n\tINCREMENT BY ");
            sbSQL.append(newIncrement);
        }

        final String oldMinValue = getMinValue();
        final String newMinValue = newSequence.getMinValue();

        if (newMinValue == null && oldMinValue != null) {
            sbSQL.append("\n\tNO MINVALUE");
        } else if (newMinValue != null
                && !newMinValue.equals(oldMinValue)) {
            sbSQL.append("\n\tMINVALUE ");
            sbSQL.append(newMinValue);
        }

        final String oldMaxValue = getMaxValue();
        final String newMaxValue = newSequence.getMaxValue();

        if (newMaxValue == null && oldMaxValue != null) {
            sbSQL.append("\n\tNO MAXVALUE");
        } else if (newMaxValue != null
                && !newMaxValue.equals(oldMaxValue)) {
            sbSQL.append("\n\tMAXVALUE ");
            sbSQL.append(newMaxValue);
        }

        final String oldStart = getStartWith();
        final String newStart = newSequence.getStartWith();

        if (newStart != null && !newStart.equals(oldStart)) {
            sbSQL.append("\n\tRESTART WITH ");
            sbSQL.append(newStart);
        }

        final String oldCache = getCache();
        final String newCache = newSequence.getCache();

        if (newSequence.isCached() && !Objects.equals(newCache, oldCache)) {
            sbSQL.append("\n\tCACHE ");
            if (newCache != null) {
                sbSQL.append(newCache);
            }
        } else if (!newSequence.isCached()) {
            sbSQL.append("\n\tNO CACHE");
        }

        final boolean oldCycle = isCycle();
        final boolean newCycle = newSequence.isCycle();

        if (oldCycle && !newCycle) {
            sbSQL.append("\n\tNO CYCLE");
        } else if (!oldCycle && newCycle) {
            sbSQL.append("\n\tCYCLE");
        }

        return sbSQL.length() > 0;
    }

    @Override
    public void setDataType(String dataType) {
        String type = dataType.toLowerCase(Locale.ROOT);
        switch (type) {
        case "tinyint":
        case "smallint":
        case "int":
        case BIGINT:
        case "numeric":
        case "decimal":
            // set lowercased version for simple system types
            break;
        default:
            // set exactly as given
            type = dataType;
        }
        super.setDataType(type);
    }

    @Override
    public void setMinMaxInc(long inc, Long max, Long min, String dataType, long precision) {
        String type = dataType != null ? dataType : BIGINT;
        this.increment = Long.toString(inc);
        this.maxValue = Long.toString(max == null ? getBoundaryTypeVal(type, true, precision) : max);
        this.minValue = Long.toString(min == null ? getBoundaryTypeVal(type, false, precision) : min);
        resetHash();
    }

    public boolean isCached() {
        return isCached;
    }

    public void setCached(boolean isCached) {
        this.isCached = isCached;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsSequence seq && super.compare(obj)) {
            return isCached == seq.isCached();
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isCached);
    }

    @Override
    protected AbstractSequence getSequenceCopy() {
        MsSequence sequence = new MsSequence(getName());
        sequence.setCached(isCached());
        return sequence;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }

}
